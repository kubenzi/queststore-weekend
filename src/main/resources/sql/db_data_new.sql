INSERT INTO account_type VALUES
    (1, 'student'),
    (2, 'mentor'),
    (3, 'admin');

INSERT INTO level VALUES
    (1, 0, 'icon-paper-plane-empty', 'paper plane'),
    (2, 500, 'icon-paper-plane', 'plane'),
    (3, 1000, 'icon-fighter-jet', 'jet'),
    (4, 2000, 'icon-space-shuttle', 'space shuttle'),
    (5, 3000, 'icon-rocket', 'rocket');

INSERT INTO quest_type VALUES
    (1, 'individual'),
    (2, 'group');

INSERT INTO quest VALUES
    (1, 'Finishing two-week self-assignment', 100, 1),
    (2, 'Finishing two-week group-assignment', 150, 2),
    (3, 'Spot a major mistake in the assignment', 100, 1),
    (4, 'Doing a demo for the class (side project, new technology, ...)', 200, 2),
    (5, 'Taking part in the student screening process', 100, 1),
    (6, 'Organizing a workshop for other students', 400, 1),
    (7, 'Attending 1 months without being late', 250, 1),
    (8, 'Set up a SMART goal accepted by a mentor, then achieve it', 400, 1),
    (9, 'Students choose the best project of the week. Selected team scores', 400, 2),
    (10, 'Do a presentation on a meet-up', 300, 1);

INSERT INTO group_class VALUES
    (1, '02.2020 Krk-weekend', 'Java-1'),
    (2, '02.2020 Krk-weekend', 'Java-2');

INSERT INTO user_data VALUES
    ('Student', 1, 'krzys@gmail.com', 'Krzysztof', 'Chromiec', 'Niemce15!', 1300, 200, 1),
    ('Student', 2, 'bartek.jakimko@gmail.com', 'Bartosz', 'Jakimko', 'Barti123!', 1050, 350, 1),
    ('Student', 3, 'kubus@gmail.com', 'Jakub', 'Chorazyk', 'Kubusqwerty123!', 1500, 200, 1),
    ('Student', 4, 'ondrej@gmail.com', 'Andrzej', 'Kielbowicz', 'ondrejondrej1!', 1550, 50, 1),
    ('USER_DATA', 5, 'przemekjestgosc@onet.pl', 'Przemyslaw', 'Raczkowski', 'master123!', null, null, 2);

INSERT INTO user_group VALUES
    (1, 1),
    (2, 1),
    (3, 2),
    (4, 2),
    (5, 1),
    (5, 2);

INSERT INTO group_class_users VALUES
    (1, 1),
    (1, 2),
    (2, 3),
    (2, 4),
    (1, 5),
    (2, 5);

INSERT INTO item_type VALUES
    (1, 'individual'),
    (2, 'group');

INSERT INTO item VALUES
    (1, 50, 'Private mentoring - 30 minutes', 'Mentoring', 1),
    (2, 300, 'You can spend a day in home office', 'Home office', 1),
    (3, 500, 'Extend SI week assignment deadline by one day', 'Get more time', 1),
    (4, 1000, '60 min workshop by a mentor of the chosen topic',  'Workshop',2),
    (5, 1000, 'Mentor joins a students team for one hour', 'Boost', 2),
    (6, 500, 'Extra material for the current topic', 'More materials', 2),
    (7, 3000, 'All mentors should dress up as pirates (or just funny) for the day', 'Carnival', 2),
    (8, 5000, 'The whole course goes to an off-school program instead for a day', 'Go outside', 2);

INSERT INTO request VALUES
    (1, 1000, '60 min workshop by a mentor of the chosen topic', 'Workshop', 1, 2),
    (2, 1000, 'Mentor joins a students team for one hour', 'Boost', 1, 2),
    (3, 1000, '60 min workshop by a mentor of the chosen topic', 'Workshop', 2, 2);

INSERT INTO request_detail VALUES
    (0, 300, 1, 1),
    (1, 400, 1, 2),
    (2, 100, 2, 1),
    (3, 400, 3, 3),
    (4, 400, 3, 4);

INSERT INTO request_request_details VALUES
    (1, 0),
    (1, 1),
    (2, 2),
    (3, 3),
    (3, 4);

INSERT INTO achievement VALUES
    (0, 'Finishing two-week self-assignment', 100, 1, 1),
    (1, 'Finishing two-week group-assignment', 150, 2, 1),
    (2, 'Finishing two-week group-assignment', 150, 2, 2),
    (3, 'Spot a major mistake in the assignment', 100, 1, 2),
    (4, 'Attending 1 months without being late', 250, 1, 3),
    (5, 'Students choose the best project of the week. Selected team scores', 400, 2, 3),
    (6, 'Students choose the best project of the week. Selected team scores', 400, 2, 4),
    (7, 'Do a presentation on a meet-up', 300, 1, 4),
    (8, 'Attending 1 months without being late', 250, 1, 1),
    (9, 'Students choose the best project of the week. Selected team scores', 400, 2, 1),
    (10, 'Students choose the best project of the week. Selected team scores', 400, 2, 2),
    (11, 'Students choose the best project of the week. Selected team scores', 400, 2, 1),
    (12, 'Students choose the best project of the week. Selected team scores', 400, 2, 2),
    (13, 'Students choose the best project of the week. Selected team scores', 400, 2, 3),
    (14, 'Students choose the best project of the week. Selected team scores', 400, 2, 4),
    (15, 'Attending 1 months without being late', 250, 1, 3),
    (16, 'Doing a demo for the class (side project, new technology, ...)', 200, 2, 3),
    (17, 'Doing a demo for the class (side project, new technology, ...)', 200, 2, 4),
    (18, 'Attending 1 months without being late', 250, 1, 4);

INSERT INTO student_achievement_list VALUES
    (1, 0),
    (1, 1),
    (2, 2),
    (2, 3),
    (3, 4),
    (3, 5),
    (4, 6),
    (4, 7),
    (1, 8),
    (1, 9),
    (2, 10),
    (1, 11),
    (2, 12),
    (3, 13),
    (4, 14),
    (3, 15),
    (3, 16),
    (4, 17),
    (4, 18);

INSERT INTO transaction_details VALUES
    (0, true, 600, '60 min workshop by a mentor(s) of the chosen topic', 'Workshop', 2, 1),
    (1, true, 400, '60 min workshop by a mentor(s) of the chosen topic', 'Workshop', 2, 2),
    (2, true, 400, 'Mentor joins your team for a one hour', 'Boost', 2, 3),
    (3, true, 600, 'Mentor joins your team for a one hour', 'Boost', 2, 4),
    (4, true, 500, 'Extra material for the current topic', 'More materials', 2, 4),
    (5, false, 50, 'Private mentoring', 'Mentoring', 1, 1),
    (6, true, 50, 'Private mentoring', 'Mentoring', 1, 1),
    (7, true, 300, 'You can spend a day in home office', 'Home office', 1, 2),
    (8, false, 500, 'Extend SI week assignment deadline by one day', 'Get more time', 1, 3);

INSERT INTO student_transaction_details VALUES
    (1, 0),
    (2, 1),
    (3, 2),
    (4, 3),
    (4, 4),
    (1, 5),
    (1, 6),
    (2, 7),
    (3, 8)