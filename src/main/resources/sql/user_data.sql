DROP TABLE IF EXISTS account_type CASCADE;
DROP TABLE IF EXISTS user_data CASCADE;
DROP TABLE IF EXISTS student CASCADE;
DROP TABLE IF EXISTS mentor CASCADE;
DROP TABLE IF EXISTS admin CASCADE;
DROP TABLE IF EXISTS level_of_experience CASCADE;
DROP TABLE IF EXISTS class CASCADE;
DROP TABLE IF EXISTS groups CASCADE;

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
    group_wallet int NOT NULL,
    mentor_id character varying(8),

    PRIMARY KEY (group_id),
    FOREIGN KEY (class_id) REFERENCES class(class_id) ON DELETE CASCADE,
    FOREIGN KEY (mentor_id) REFERENCES mentor(mentor_id)
);

INSERT INTO account_type VALUES
    (1, 'admin'),
    (2, 'mentor'),
    (3, 'student');

INSERT INTO user_data VALUES
    ('x%[>j!X#', 1, 'Krzysztof', 'Jerzyna', 'k_jerzyna@admin.pl', 'jerzyna1'),
    ('JgsMz0d1', 2, 'Kesuke', 'Miyagi', 'miyagi@mentor.pl', 'miyagi1'),
    ('M+MIQP<f', 2, 'Ambrozy', 'Kleks', 'a_kleks@mentor.pl', 'kleks1'),
    ('x>[>j!X#', 3, 'Krzysiek', 'Chromiec', 'krzysztof.chromiec@gmail.com', 'chromiec1'),
    (')+e)CWq!', 3, 'Bartek', 'Jakimko', 'bartek.jakimko@gmail.com', 'jakimko1'),
    ('XtPra1XX', 3, 'Jakub', 'Chorazyk', 'jakub.chorazyk@gmail.com', 'chorazyk1'),
    ('p4>xX8<X', 3, 'Andrzej', 'Kielbowicz', 'andrzej.kielbowicz@gmail.com', 'kielbowicz1');

INSERT INTO student VALUES
    ('sZm5J_4+', 'x>[>j!X#', 400, 2100, 'hLs3X-8.'),
    ('lHv4S<6#', ')+e)CWq!', 500, 2200, 'hLs3X-8.'),
    ('gWa9Q+5+', 'XtPra1XX', 800, 1800, 'lTl7H{6('),
    ('wKr3Y%0%', 'p4>xX8<X', 2000, 4000, 'lTl7H{6(');

INSERT INTO mentor VALUES
    ('bIx0U[5~', 'JgsMz0d1'),
    ('oDj2U:8-', 'M+MIQP<f');

INSERT INTO admin VALUES
    ('mQh5G+8#', 'x%[>j!X#');

INSERT INTO level_of_experience VALUES
    (1, 'paper plane', 500),
    (2, 'plane', 1000),
    (3, 'jet', 2000),
    (4, 'satellite', 5000),
    (5, 'space shuttle', 10000);

INSERT INTO class VALUES
    ('sUm2F/9<', 'krk weekend 02/2020');

INSERT INTO groups VALUES
    ('hLs3X-8.', 'sUm2F/9<', 'fusy', 1200, 'bIx0U[5~'),
    ('lTl7H{6(', 'sUm2F/9<', 'tez fusy', 1200, 'oDj2U:8-')