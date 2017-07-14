CREATE TABLE u_user (
  u_id BIGSERIAL NOT NULL,
  login VARCHAR(30) NOT NULL,
  hash_password VARCHAR(60) NOT NULL,
  token VARCHAR(60) NOT NULL,
  first_name VARCHAR(30),
  middle_name VARCHAR(30),
  last_name VARCHAR(30),
  role VARCHAR(20) NOT NULL,
  PRIMARY KEY (u_id)
);

CREATE TABLE student_info (
  st_id BIGSERIAL NOT NULL,
  s_group VARCHAR(10),
  course INT NOT NULL,
  lab_id BIGINT,
  elective_id BIGINT,
  practice_id BIGINT,
  leader_id BIGINT,
  user_id BIGINT NOT NULL,
  PRIMARY KEY (st_id)
);

CREATE TABLE teacher (
  t_id BIGSERIAL NOT NULL,
  t_first_name VARCHAR(30),
  t_middle_name VARCHAR(30),
  t_last_name VARCHAR(30),
  PRIMARY KEY (t_id)
);

CREATE TABLE lab (
  lab_id BIGSERIAL NOT NULL,
  lab_name VARCHAR(100) NOT NULL,
  leader_id BIGINT,
  PRIMARY KEY (lab_id)
);

CREATE TABLE elective (
  el_id BIGSERIAL NOT NULL,
  el_name VARCHAR(100) NOT NULL,
  leader_id BIGINT,
  course INT NOT NULL,
  PRIMARY KEY (el_id)
);

CREATE TABLE practice (
  pr_id BIGSERIAL NOT NULL,
  pr_name VARCHAR(100) NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  leader_id BIGINT,
  course INT NOT NULL,
  PRIMARY KEY (pr_id)
);

CREATE TABLE request (
  req_id BIGSERIAL NOT NULL,
  req_message VARCHAR(255),
  res_message VARCHAR(255),
  req_date DATE,
  student_id BIGINT NOT NULL,
  req_type VARCHAR(20) NOT NULL,
  attribute_id BIGINT NOT NULL,
  req_status VARCHAR(20) DEFAULT 'ACTIVE',
  PRIMARY KEY (req_id)
);

ALTER TABLE student_info ADD CONSTRAINT student_fk1 FOREIGN KEY (user_id) REFERENCES u_user(u_id);

ALTER TABLE student_info ADD CONSTRAINT student_fk2 FOREIGN KEY (lab_id) REFERENCES lab(lab_id);

ALTER TABLE student_info ADD CONSTRAINT student_fk3 FOREIGN KEY (elective_id) REFERENCES elective(el_id);

ALTER TABLE student_info ADD CONSTRAINT student_fk4 FOREIGN KEY (practice_id) REFERENCES practice(pr_id);

ALTER TABLE student_info ADD CONSTRAINT student_fk5 FOREIGN KEY (leader_id) REFERENCES teacher(t_id);

ALTER TABLE lab ADD CONSTRAINT lab_fk1 FOREIGN KEY (leader_id) REFERENCES teacher(t_id);

ALTER TABLE elective ADD CONSTRAINT elective_fk1 FOREIGN KEY (leader_id) REFERENCES teacher(t_id);

ALTER TABLE practice ADD CONSTRAINT practice_fk1 FOREIGN KEY (leader_id) REFERENCES teacher(t_id);

ALTER TABLE request ADD CONSTRAINT request_fk1 FOREIGN KEY (student_id) REFERENCES student_info(st_id);
