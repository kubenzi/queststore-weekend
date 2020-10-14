INSERT INTO account_type VALUES
    (1, 'admin'),
    (2, 'mentor'),
    (3, 'student');

INSERT INTO level_of_experience VALUES
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