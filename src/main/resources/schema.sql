CREATE TABLE u_user (
  u_id BIGSERIAL NOT NULL,
  login VARCHAR(30) NOT NULL UNIQUE,
  hash_password VARCHAR(60) NOT NULL,
  token VARCHAR(60) UNIQUE,
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
  lab_id BIGINT DEFAULT 1,
  elective_id BIGINT DEFAULT 1,
  practice_id BIGINT DEFAULT 1,
  leader_id BIGINT DEFAULT 1,
  user_id BIGINT NOT NULL,
  PRIMARY KEY (st_id)
);

CREATE TABLE teacher (
  t_id BIGSERIAL NOT NULL ,
  t_first_name VARCHAR(30),
  t_middle_name VARCHAR(30),
  t_last_name VARCHAR(30),
  PRIMARY KEY (t_id)
);

CREATE TABLE lab (
  lab_id BIGSERIAL NOT NULL,
  lab_name VARCHAR(100) NOT NULL,
  leader_id BIGINT DEFAULT 1,
  PRIMARY KEY (lab_id)
);

CREATE TABLE elective (
  el_id BIGSERIAL NOT NULL,
  el_name VARCHAR(100) NOT NULL,
  leader_id BIGINT DEFAULT 1,
  course INT NOT NULL,
  PRIMARY KEY (el_id)
);

CREATE TABLE practice (
  pr_id BIGSERIAL NOT NULL,
  pr_name VARCHAR(100) NOT NULL,
  start_date TIMESTAMP,
  end_date TIMESTAMP,
  leader_id BIGINT DEFAULT 1,
  course INT NOT NULL,
  PRIMARY KEY (pr_id)
);

CREATE TABLE request (
  req_id BIGSERIAL NOT NULL,
  req_message VARCHAR(255),
  res_message VARCHAR(255),
  req_date TIMESTAMP,
  student_id BIGINT NOT NULL,
  req_type VARCHAR(20) NOT NULL,
  attribute_id BIGINT NOT NULL,
  req_status VARCHAR(20) DEFAULT 'ACTIVE',
  PRIMARY KEY (req_id)
);

ALTER TABLE student_info ADD CONSTRAINT student_fk1 FOREIGN KEY (user_id) REFERENCES u_user(u_id);

ALTER TABLE student_info ADD CONSTRAINT student_fk2 FOREIGN KEY (lab_id) REFERENCES lab(lab_id) ON DELETE SET DEFAULT;

ALTER TABLE student_info ADD CONSTRAINT student_fk3 FOREIGN KEY (elective_id) REFERENCES elective(el_id) ON DELETE SET DEFAULT;

ALTER TABLE student_info ADD CONSTRAINT student_fk4 FOREIGN KEY (practice_id) REFERENCES practice(pr_id) ON DELETE SET DEFAULT;

ALTER TABLE student_info ADD CONSTRAINT student_fk5 FOREIGN KEY (leader_id) REFERENCES teacher(t_id) ON DELETE SET DEFAULT;

ALTER TABLE lab ADD CONSTRAINT lab_fk1 FOREIGN KEY (leader_id) REFERENCES teacher(t_id) ON DELETE SET DEFAULT;

ALTER TABLE elective ADD CONSTRAINT elective_fk1 FOREIGN KEY (leader_id) REFERENCES teacher(t_id) ON DELETE SET DEFAULT;

ALTER TABLE practice ADD CONSTRAINT practice_fk1 FOREIGN KEY (leader_id) REFERENCES teacher(t_id) ON DELETE SET DEFAULT;

ALTER TABLE request ADD CONSTRAINT request_fk1 FOREIGN KEY (student_id) REFERENCES student_info(st_id) ON DELETE CASCADE;

INSERT INTO u_user (login, hash_password, role) VALUES
  ('user1', '$2a$10$Xrdw8XE7GpQ0NnVHXBZ0VeUhtzvJklJlpDE5MdLTylxdLoJYGbZua', 'ADMIN');
INSERT INTO teacher (t_last_name) VALUES ('<None>');
INSERT INTO lab (lab_name) VALUES ('<None>');
INSERT INTO practice (pr_name, course) VALUES ('<None>', 1);
INSERT INTO elective (el_name, course) VALUES ('<None>', 1);
