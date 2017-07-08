DROP TABLE IF EXISTS student_info;
DROP TABLE IF EXISTS u_user;

CREATE TABLE u_user (
  u_id BIGSERIAL NOT NULL,
  login VARCHAR(30) NOT NULL,
  hash_password VARCHAR(60) NOT NULL,
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
  lab_name VARCHAR(40) NOT NULL,
  leader_id BIGINT,
  PRIMARY KEY (lab_id)
);

CREATE TABLE elective (
  el_id BIGSERIAL NOT NULL,
  el_name VARCHAR(40) NOT NULL,
  leader_id BIGINT,
  course INT,
  PRIMARY KEY (el_id)
);

CREATE TABLE practice (
  pr_id BIGSERIAL NOT NULL,
  pr_name VARCHAR(40) NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  leader_id BIGINT,
  course INT,
  PRIMARY KEY (pr_id)
);

CREATE TABLE request (
  req_id BIGSERIAL NOT NULL,
  req_message VARCHAR(255),
  res_message VARCHAR(255),
  req_date DATE,
  student_id BIGINT NOT NULL,
  req_status VARCHAR(20) DEFAULT 'ACTIVE',
  PRIMARY KEY (req_id)
);

CREATE TABLE leader_request (
  lead_req_id BIGSERIAL NOT NULL,
  req_id BIGINT NOT NULL,
  leader_id BIGINT NOT NULL,
  PRIMARY KEY (lead_req_id)
);


CREATE TABLE elective_request (
  el_req_id BIGSERIAL NOT NULL,
  req_id BIGINT NOT NULL,
  elective_id BIGINT NOT NULL,
  PRIMARY KEY (el_req_id)
);

CREATE TABLE lab_request (
  lab_req_id BIGSERIAL NOT NULL,
  req_id BIGINT NOT NULL,
  lab_id BIGINT NOT NULL,
  PRIMARY KEY (lab_req_id)
);

CREATE TABLE practice_request (
  pr_req_id BIGSERIAL NOT NULL,
  req_id BIGINT NOT NULL,
  practice_id BIGINT NOT NULL,
  PRIMARY KEY (pr_req_id)
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

ALTER TABLE leader_request ADD CONSTRAINT leader_request_fk1 FOREIGN KEY (req_id) REFERENCES request(req_id);

ALTER TABLE leader_request ADD CONSTRAINT leader_request_fk2 FOREIGN KEY (leader_id) REFERENCES teacher(t_id);

ALTER TABLE practice_request ADD CONSTRAINT practice_request_fk1 FOREIGN KEY (req_id) REFERENCES request(req_id);

ALTER TABLE practice_request ADD CONSTRAINT practice_request_fk2 FOREIGN KEY (practice_id) REFERENCES practice(pr_id);

ALTER TABLE lab_request ADD CONSTRAINT lab_request_fk1 FOREIGN KEY (req_id) REFERENCES request(req_id);

ALTER TABLE lab_request ADD CONSTRAINT lab_request_fk2 FOREIGN KEY (lab_id) REFERENCES lab(lab_id);

ALTER TABLE elective_request ADD CONSTRAINT elective_request_fk1 FOREIGN KEY (req_id) REFERENCES request(req_id);

ALTER TABLE elective_request ADD CONSTRAINT elective_request_fk2 FOREIGN KEY (req_id) REFERENCES elective(el_id);
