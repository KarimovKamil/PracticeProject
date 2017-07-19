INSERT INTO teacher (t_last_name, t_first_name, t_middle_name) VALUES ('Якушев', 'Бронислав', 'Леонидович');
INSERT INTO teacher (t_last_name, t_first_name, t_middle_name) VALUES ('Голубев', 'Василий', 'Сергеевич');
INSERT INTO teacher (t_last_name, t_first_name, t_middle_name) VALUES ('Марков', 'Юрий', 'Викторович');
INSERT INTO teacher (t_last_name, t_first_name, t_middle_name) VALUES ('Колесникова', 'Ксения', 'Лукьяновна');
INSERT INTO teacher (t_last_name, t_first_name, t_middle_name) VALUES ('Одинцова', 'Светлана', 'Георгьевна');

INSERT INTO lab (lab_name, leader_id) VALUES ('Java', 2);
INSERT INTO lab (lab_name, leader_id) VALUES ('Android', 3);
INSERT INTO lab (lab_name, leader_id) VALUES ('Ruby', 4);
INSERT INTO lab (lab_name, leader_id) VALUES ('DML', 5);

INSERT INTO elective (el_name, leader_id, course) VALUES ('Android', 2, 2);
INSERT INTO elective (el_name, leader_id, course) VALUES ('Ruby', 2, 1);
INSERT INTO elective (el_name, leader_id, course) VALUES ('Java', 4, 2);

INSERT INTO practice (pr_name, start_date, end_date, leader_id, course)
VALUES ('SMART', '2018-07-06', '2018-07-19', 2, 2);
INSERT INTO practice (pr_name, start_date, end_date, leader_id, course)
VALUES ('Java', '2018-07-06', '2017-08-19', 3, 1);
INSERT INTO practice (pr_name, start_date, end_date, leader_id, course)
VALUES ('Android', '2018-07-06', '2018-07-19', 4, 2);

INSERT INTO u_user (login, hash_password, role, last_name, first_name, middle_name) VALUES
  ('user2', '$2a$10$Xrdw8XE7GpQ0NnVHXBZ0VeUhtzvJklJlpDE5MdLTylxdLoJYGbZua', 'STUDENT',
  'Суханов', 'Германн', 'Куприянович');
INSERT INTO u_user (login, hash_password, role, last_name, first_name, middle_name) VALUES
  ('user3', '$2a$10$Xrdw8XE7GpQ0NnVHXBZ0VeUhtzvJklJlpDE5MdLTylxdLoJYGbZua', 'STUDENT',
  'Андреева', 'Юлия', 'Фроловна');
INSERT INTO u_user (login, hash_password, role, last_name, first_name, middle_name) VALUES
  ('user4', '$2a$10$Xrdw8XE7GpQ0NnVHXBZ0VeUhtzvJklJlpDE5MdLTylxdLoJYGbZua', 'STUDENT',
  'Осипов', 'Денис', 'Алексеевич');

INSERT INTO student_info (s_group, course, user_id) VALUES
  (505, 2, 2);
INSERT INTO student_info (s_group, course, user_id) VALUES
  (401, 3, 3);
INSERT INTO student_info (s_group, course, user_id) VALUES
  (601, 1, 4);

INSERT INTO request (req_date, student_id, req_type, attribute_id) VALUES
  ('2017-01-17', 1, 'LAB', 2);
INSERT INTO request (req_date, student_id, req_type, attribute_id) VALUES
  ('2017-01-17', 1, 'ELECTIVE', 3);
INSERT INTO request (req_date, student_id, req_type, attribute_id) VALUES
  ('2017-01-17', 2, 'LEADER', 1);
INSERT INTO request (req_date, student_id, req_type, attribute_id) VALUES
  ('2017-01-17', 3, 'PRACTICE', 2);