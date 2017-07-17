INSERT INTO teacher (t_first_name, t_middle_name, t_last_name) VALUES ('Marsel', 'Mihailovich', 'Sidikov');
INSERT INTO teacher (t_first_name, t_middle_name, t_last_name) VALUES ('Ivan', 'Mihailovich', 'Ivanov');
INSERT INTO teacher (t_first_name, t_middle_name, t_last_name) VALUES ('Mihail', 'Mihailovich', 'Mihailov');

INSERT INTO lab (lab_name, leader_id) VALUES ('Java', 1);
INSERT INTO lab (lab_name, leader_id) VALUES ('Android', 2);
INSERT INTO lab (lab_name, leader_id) VALUES ('Ruby', 3);

INSERT INTO elective (el_name, leader_id, course) VALUES ('Android', 1, 2);
INSERT INTO elective (el_name, leader_id, course) VALUES ('Ruby', 1, 1);
INSERT INTO elective (el_name, leader_id, course) VALUES ('Java', 3, 2);

INSERT INTO practice (pr_name, start_date, end_date, leader_id, course)
VALUES ('SMART', '2017-07-06 14:47:09', '2017-07-19 14:47:41', 1, 2);
INSERT INTO practice (pr_name, start_date, end_date, leader_id, course)
VALUES ('Java', '2017-07-06 14:47:09', '2017-07-19 14:47:41', 2, 1);
INSERT INTO practice (pr_name, start_date, end_date, leader_id, course)
VALUES ('Android', '2017-07-06 14:47:09', '2017-07-19 14:47:41', 3, 2);

