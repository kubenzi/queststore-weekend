DROP TABLE IF EXISTS account_type CASCADE;
DROP TABLE IF EXISTS user_data CASCADE;
DROP TABLE IF EXISTS student CASCADE;
DROP TABLE IF EXISTS mentor CASCADE;
DROP TABLE IF EXISTS admin CASCADE;
DROP TABLE IF EXISTS level_of_experience CASCADE;
DROP TABLE IF EXISTS class CASCADE;
DROP TABLE IF EXISTS groups CASCADE;
DROP TABLE IF EXISTS quest_type CASCADE;
DROP TABLE IF EXISTS quest CASCADE;
DROP TABLE IF EXISTS quest_achievements CASCADE;
DROP TABLE IF EXISTS achievement_details CASCADE;
DROP TABLE IF EXISTS item_type CASCADE;
DROP TABLE IF EXISTS item CASCADE;
DROP TABLE IF EXISTS item_request CASCADE;
DROP TABLE IF EXISTS request_students CASCADE;
DROP TABLE IF EXISTS item_status_type CASCADE;
DROP TABLE IF EXISTS transactions CASCADE;
DROP TABLE IF EXISTS transaction_students CASCADE;

CREATE TABLE account_type (
    account_type_id int NOT NULL,
    type_name character varying(255) NOT NULL,

    PRIMARY KEY (account_type_id)
);

CREATE TABLE user_data (
    user_id character varying(8) NOT NULL,
    account_type_id int NOT NULL,
    first_name character varying(255) NOT NULL,
    last_name character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,

    PRIMARY KEY (user_id),
    FOREIGN KEY (account_type_id) REFERENCES account_type(account_type_id)
);

CREATE TABLE student (
    student_id character varying(8) NOT NULL,
    user_id character varying(8) NOT NULL,
    wallet int NOT NULL,
    total_coins_earned int NOT NULL,
    group_id character varying(8) NOT NULL,

    PRIMARY KEY (student_id),
    FOREIGN KEY (user_id) REFERENCES user_data(user_id) ON DELETE CASCADE
--    FOREIGN KEY (group_id) REFERENCES groups(group_id) ON DELETE CASCADE
);

CREATE TABLE mentor (
    mentor_id character varying(8) NOT NULL,
    user_id character varying(8) NOT NULL,

    PRIMARY KEY (mentor_id),
    FOREIGN KEY (user_id) REFERENCES user_data(user_id) ON DELETE CASCADE
);

CREATE TABLE admin (
    admin_id character varying(8) NOT NULL,
    user_id character varying(8) NOT NULL,

    PRIMARY KEY (admin_id),
    FOREIGN KEY (user_id) REFERENCES user_data(user_id) ON DELETE CASCADE
);

CREATE TABLE level_of_experience (
    level_id int NOT NULL,
    level_name character varying(255) NOT NULL,
    coolcoins_required int NOT NULL,
    icon_name character varying(255) NOT NULL,

    PRIMARY KEY (level_id)
);

CREATE TABLE class (
    class_id character varying(8) NOT NULL,
    class_name character varying(255) NOT NULL,

    PRIMARY KEY (class_id)
);

CREATE TABLE groups (
    group_id character varying(8) NOT NULL,
    class_id character varying(8) NOT NULL,
    group_name character varying(255) NOT NULL,
    mentor_id character varying(8),

    PRIMARY KEY (group_id),
    FOREIGN KEY (class_id) REFERENCES class(class_id) ON DELETE CASCADE,
    FOREIGN KEY (mentor_id) REFERENCES mentor(mentor_id)
);

CREATE TABLE quest_type (
    quest_type_id int NOT NULL,
    type_name character varying(255) NOT NULL,

    PRIMARY KEY (quest_type_id)
);

CREATE TABLE quest (
    quest_id character varying(8) NOT NULL,
    quest_type_id int NOT NULL,
    quest_description character varying(255) NOT NULL,
    quest_value int NOT NULL,

    PRIMARY KEY (quest_id),
    FOREIGN KEY (quest_type_id) REFERENCES quest_type(quest_type_id)
);

CREATE TABLE quest_achievements (
    achievement_id character varying(8) NOT NULL,
    quest_description character varying(255) NOT NULL,
    quest_type_name character varying(255) NOT NULL,
    prize int NOT NULL,

    PRIMARY KEY (achievement_id)
);

CREATE TABLE achievement_details (
    record_id character varying(8) NOT NULL,
    achievement_id character varying(8) NOT NULL,
    user_id character varying(8) NOT NULL,

    PRIMARY KEY (record_id),
    FOREIGN KEY (achievement_id) REFERENCES quest_achievements(achievement_id),
    FOREIGN KEY (user_id) REFERENCES user_data(user_id)
);

CREATE TABLE item_type (
    item_type_id int NOT NULL,
    item_type_name character varying(255) NOT NULL,

    PRIMARY KEY (item_type_id)
);

CREATE TABLE item (
    item_id character varying(8) NOT NULL,
    item_type_id int NOT NULL,
    item_name character varying(255) NOT NULL,
    item_description character varying(255) NOT NULL,
    item_cost int NOT NULL,

    PRIMARY KEY (item_id),
    FOREIGN KEY (item_type_id) REFERENCES item_type(item_type_id)
);

CREATE TABLE item_request (
    item_request_id character varying(8) NOT NULL,
    group_id character varying(8) NOT NULL,
    item_id character varying(8) NOT NULL,
    request_wallet int NOT NULL,

    PRIMARY KEY (item_request_id),
    FOREIGN KEY (group_id) REFERENCES groups(group_id),
    FOREIGN KEY (item_id) REFERENCES item(item_id)
);

CREATE TABLE request_students (
    record_id character varying(8) NOT NULL,
    item_request_id character varying(8) NOT NULL,
    user_id character varying(8) NOT NULL,
    coolcoins int NOT NULL,

    PRIMARY KEY (record_id),
    FOREIGN KEY (item_request_id) REFERENCES item_request(item_request_id),
    FOREIGN KEY (user_id) REFERENCES user_data(user_id)
);

CREATE TABLE item_status_type (
    item_status_id int NOT NULL,
    item_status_name character varying(255) NOT NULL,

    PRIMARY KEY (item_status_id)
);

CREATE TABLE transactions (
    transaction_id character varying(8) NOT NULL,
    item_name character varying(255) NOT NULL,
    item_description character varying(255) NOT NULL,
    item_type_name character varying(255) NOT NULL,
    item_status_id int NOT NULL,

    PRIMARY KEY (transaction_id),
    FOREIGN KEY (item_status_id) REFERENCES item_status_type(item_status_id)
);

CREATE TABLE transaction_students (
    record_id character varying(8) NOT NULL,
    transaction_id character varying(8) NOT NULL,
    user_id character varying(8) NOT NULL,
    coolcoins int NOT NULL,

    PRIMARY KEY (record_id),
    FOREIGN KEY (transaction_id) REFERENCES transactions(transaction_id),
    FOREIGN KEY (user_id) REFERENCES user_data(user_id)
);

INSERT INTO account_type VALUES
    (1, 'Admin'),
    (2, 'Mentor'),
    (3, 'Student');

INSERT INTO user_data VALUES
    ('x%[>j!X#', 1, 'Krzysztof', 'Jerzyna', 'k_jerzyna@admin.pl', 'jerzyna1'),
    ('JgsMz0d1', 2, 'Kesuke', 'Miyagi', 'miyagi@mentor.pl', 'miyagi1'),
    ('M+MIQP<f', 2, 'Ambrozy', 'Kleks', 'a_kleks@mentor.pl', 'kleks1'),
    ('x>[>j!X#', 3, 'Krzysiek', 'Chromiec', 'krzysztof.chromiec@gmail.com', 'chromiec1'),
    (')+e)CWq!', 3, 'Bartek', 'Jakimko', 'bartek.jakimko@gmail.com', 'jakimko1'),
    ('XtPra1XX', 3, 'Jakub', 'Chorazyk', 'jakub.chorazyk@gmail.com', 'chorazyk1'),
    ('p4>xX8<X', 3, 'Andrzej', 'Kielbowicz', 'andrzej.kielbowicz@gmail.com', 'kielbowicz1');

INSERT INTO student VALUES
    ('sZm5J_4+', 'x>[>j!X#', 400, 1450, 'hLs3X-8.'),
    ('lHv4S<6#', ')+e)CWq!', 100, 1200, 'hLs3X-8.'),
    ('gWa9Q+5+', 'XtPra1XX', 200, 1500, 'lTl7H{6('),
    ('wKr3Y%0%', 'p4>xX8<X', 50, 1550, 'lTl7H{6(');

INSERT INTO mentor VALUES
    ('bIx0U[5~', 'JgsMz0d1'),
    ('oDj2U:8-', 'M+MIQP<f');

INSERT INTO admin VALUES
    ('mQh5G+8#', 'x%[>j!X#');

INSERT INTO level_of_experience VALUES
    (1, 'paper plane', 0, 'icon-paper-plane-empty'),
    (2, 'plane', 500, 'icon-paper-plane'),
    (3, 'jet', 1000, 'icon-fighter-jet'),
    (4, 'space shuttle', 2000, 'icon-space-shuttle'),
    (5, 'rocket', 3000, 'icon-rocket');

INSERT INTO class VALUES
    ('sUm2F/9<', 'krk weekend 02/2020');

INSERT INTO groups VALUES
    ('hLs3X-8.', 'sUm2F/9<', 'fusy', 'bIx0U[5~'),
    ('lTl7H{6(', 'sUm2F/9<', 'tez fusy', 'oDj2U:8-');

INSERT INTO quest_type VALUES
    (1, 'individual quest'),
    (2, 'group quest');

INSERT INTO quest VALUES
    ('dSz6P|4~', 1, 'Finishing two-week self-assignment', 100),
    ('tTa5C^6,', 2, 'Finishing two-week group-assignment', 150),
    ('gEl8T<5#', 1, 'Spot a major mistake in the assignment', 100),
    ('qIr3C$3/', 2, 'Doing a demo for the class (side project, new technology, ...)', 200),
    ('zTx4L!1#', 1, 'Taking part in the student screening process', 100),
    ('eEe5D/3)', 1, 'Organizing a workshop for other students', 400),
    ('oIl4O&0[', 1, 'Attending 1 months without being late', 250),
    ('hQe0O[0-', 1, 'Set up a SMART goal accepted by a mentor, then achieve it', 400),
    ('oNt0K%4?', 2, 'Students choose the best project of the week. Selected team scores', 400),
    ('xNq2B{0^', 1, 'Do a presentation on a meet-up', 300);

INSERT INTO quest_achievements VALUES
    ('hAv7V<9!', 'Finishing two-week self-assignment', 'individual quest', 100),
    ('sSn6S/6_', 'Finishing two-week group-assignment', 'group quest', 150),
    ('fIt8E!1/', 'Spot a major mistake in the assignment', 'individual quest', 100),
    ('kNd8J_1-', 'Attending 1 months without being late', 'individual quest', 250),
    ('bIq1X#9[', 'Students choose the best project of the week. Selected team scores', 'group quest', 400),
    ('xXk0Q%6$', 'Do a presentation on a meet-up', 'individual quest', 300),
    ('rNf5I!6.', 'Attending 1 months without being late', 'individual quest', 250),
    ('sMi6E<1<', 'Students choose the best project of the week. Selected team scores', 'group quest', 400),
    ('zNy5I}9[', 'Students choose the best project of the week. Selected team scores', 'group quest', 400),
    ('wFg1F>8~', 'Students choose the best project of the week. Selected team scores', 'group quest', 400),
    ('mTu9E[5/', 'Attending 1 months without being late', 'individual quest', 250),
    ('jKv9E/6}', 'Doing a demo for the class (side project, new technology, ...)', 'group quest', 200),
    ('wFy0R~2]', 'Attending 1 months without being late', 'individual quest', 250);

--cena dodana do achievement_details na wypadek zmiany ceny w tabeli quest
INSERT INTO achievement_details VALUES
    ('sFg6A&4.', 'hAv7V<9!', 'x>[>j!X#'),
    ('iUa6W~8?', 'sSn6S/6_', 'x>[>j!X#'),
    ('kHl5I|3:', 'sSn6S/6_', ')+e)CWq!'),
    ('kSq3T,1,', 'fIt8E!1/', ')+e)CWq!'),
    ('cGy8P$2>', 'kNd8J_1-', 'XtPra1XX'),
    ('rEd0S<3_', 'bIq1X#9[', 'XtPra1XX'),
    ('cUx2R/9~', 'bIq1X#9[', 'p4>xX8<X'),
    ('bUp1C}3#', 'xXk0Q%6$', 'p4>xX8<X'),
    ('dUx5G}6|', 'rNf5I!6.', 'x>[>j!X#'),
    ('pJl1A&0_', 'sMi6E<1<', 'x>[>j!X#'),
    ('rDk8U#7^', 'sMi6E<1<', ')+e)CWq!'),
    ('jNd6U|5|', 'zNy5I}9[', 'x>[>j!X#'),
    ('oXk5M~2.', 'zNy5I}9[', ')+e)CWq!'),
    ('yCv4D-9{', 'wFg1F>8~', 'XtPra1XX'),
    ('bLf8K]9&', 'wFg1F>8~', 'p4>xX8<X'),
    ('cKx2W(6-', 'mTu9E[5/', 'XtPra1XX'),
    ('kHl1P^2|', 'jKv9E/6}', 'XtPra1XX'),
    ('fJk6R?5[', 'jKv9E/6}', 'p4>xX8<X'),
    ('tIz6U>4&', 'wFy0R~2]', 'p4>xX8<X');

INSERT INTO item_type VALUES
    (1, 'individual item'),
    (2, 'group item');

INSERT INTO item VALUES
    ('fLl8F.3.', 1, 'Teach me!', 'Private mentoring', 50),
    ('wPx6Q{5:', 1, 'Coding in bed', 'You can spend a day in home office', 300),
    ('wVw7D|3$', 1, 'Extra day', 'Extend SI week assignment deadline by one day', 500),
    ('kLe8U+2_', 2, 'Teach us!', '60 min workshop by a mentor(s) of the chosen topic', 1000),
    ('gGy6S_9|', 2, '200 percent power!', 'Mentor joins your team for a one hour', 1000),
    ('aQz2P#7&', 2, 'Secret book', 'Extra material for the current topic', 500),
    ('oGi3D!0&', 2, 'Carnival', 'All mentors should dress up as pirates (or just funny) for the day', 3000),
    ('oGa4A-7%', 2, 'Close the school', 'The whole course goes to an off-school program instead for a day', 5000);

INSERT INTO item_request VALUES
    ('tXv0Q}6{', 'hLs3X-8.', 'kLe8U+2_', 700),
    ('cOl9S=1&', 'hLs3X-8.', 'gGy6S_9|', 100),
    ('xNs8D(1{', 'lTl7H{6(', 'kLe8U+2_', 800);

INSERT INTO request_students VALUES
    ('vCi0H-0(', 'tXv0Q}6{', 'x>[>j!X#', 300),
    ('sBz7K,8/', 'tXv0Q}6{', ')+e)CWq!', 400),
    ('sOd2Z[1#', 'cOl9S=1&', 'x>[>j!X#', 100),
    ('yJk1H{6<', 'xNs8D(1{', 'XtPra1XX', 400),
    ('bIv3O:7^', 'xNs8D(1{', 'p4>xX8<X', 400);

INSERT INTO item_status_type VALUES
    (1, 'not used'),
    (2, 'used');

INSERT INTO transactions VALUES
    ('oBj1D:4#', 'Teach us!', '60 min workshop by a mentor(s) of the chosen topic', 'group item', 1),
    ('oJu7B|7(', '200 percent power!', 'Mentor joins your team for a one hour', 'group item', 2),
    ('vEa7D?8}', 'Secret book', 'Extra material for the current topic', 'group item', 2),
    ('kUv7I(6}', 'Teach me!', 'Private mentoring', 'individual item', 2),
    ('xLq3Y!6)', 'Coding in bed', 'You can spend a day in home office', 'individual item', 1),
    ('aXf3G?6!', 'Extra day', 'Extend SI week assignment deadline by one day', 'individual item', 2);

INSERT INTO transaction_students VALUES
    ('sEk7E$7{', 'oBj1D:4#', 'x>[>j!X#', 600),
    ('zMj2C%5=', 'oBj1D:4#', ')+e)CWq!', 400),
    ('vHa0Z$8.', 'oJu7B|7(', 'XtPra1XX', 400),
    ('hQh2B-4|', 'oJu7B|7(', 'p4>xX8<X', 600),
    ('lGb2Q#6>', 'vEa7D?8}', 'p4>xX8<X', 500),
    ('bDe9S%7/', 'kUv7I(6}', 'x>[>j!X#', 50),
    ('wDu4O?4}', 'xLq3Y!6)', ')+e)CWq!', 300),
    ('yKv7E,3+', 'aXf3G?6!', 'XtPra1XX', 500)