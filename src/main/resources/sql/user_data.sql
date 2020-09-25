DROP TABLE IF EXISTS account_type CASCADE;
DROP TABLE IF EXISTS user_data CASCADE;

CREATE TABLE account_type (
    account_type_id int NOT NULL,
    type_name character varying(255) NOT NULL,

    PRIMARY KEY (account_type_id)
);

CREATE TABLE user_data (
    user_id character varying(8),
    account_type_id int NOT NULL,
    first_name character varying(255) NOT NULL,
    last_name character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,

    PRIMARY KEY (user_id),
    FOREIGN KEY (account_type_id) REFERENCES account_type(account_type_id) ON DELETE CASCADE
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
  ('p4>xX8<X', 3, 'Andrzej', 'Kielbowicz', 'andrzej.kielbowicz@gmail.com', 'kielbowicz1')