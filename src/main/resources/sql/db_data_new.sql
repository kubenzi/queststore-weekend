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
    ('Student', 1, 'krzys@gmail.com', 'Krzysztof', 'Chromiec', 'Niemce15', 1450, 400, 1),
    ('Student', 2, 'bartek.jakimko@gmail.com', 'Bartosz', 'Jakimko', 'Barti123', 1200, 100, 1),
    ('Student', 3, 'kubus@gmail.com', 'Jakub', 'Chorazyk', 'Kubusqwerty', 1500, 200, 1),
    ('Student', 4, 'ondrej@gmail.com', 'Andrzej', 'Kielbowicz', 'ondrejondrej', 1550, 50, 1),
    ('USER_DATA', 5, 'przemekjestgosc@onet.pl', 'Przemyslaw', 'Raczkowski', 'master123', null, null, 2);

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
    (1, 'group'),
    (2, 'individual');

INSERT INTO item VALUES
    (1, 50, 'Private mentoring - 30 minutes', 'Mentoring', 2),
    (2, 300, 'You can spend a day in home office', 'Home office', 2),
    (3, 1000, '60 min workshop by a mentor of the chosen topic',  'Workshop',1),
    (4, 1000, 'Mentor joins a students team for one hour', 'Boost', 1)
