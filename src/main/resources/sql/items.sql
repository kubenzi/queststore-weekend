DROP TABLE IF EXISTS item_type CASCADE;
DROP TABLE IF EXISTS item CASCADE;
DROP TABLE IF EXISTS item_request_status CASCADE;
DROP TABLE IF EXISTS item_request CASCADE;
DROP TABLE IF EXISTS request_students CASCADE;
DROP TABLE IF EXISTS transactions CASCADE;
DROP TABLE IF EXISTS transaction_students CASCADE;


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

    PRIMARY KEY (item_ir),
    FOREIGN KEY (item_type_id) REFERENCES item_type(item_type_id)
);

CREATE TABLE request_status_type (
    request_status_id int NOT NULL,
    request_status_name character varying(255) NOT NULL,

    PRIMARY KEY (request_status_id)
);

CREATE TABLE item_request (
    item_request_id character varying(8) NOT NULL,
    group_id character varying(8) NOT NULL,
    item_id character varying(8) NOT NULL,
    request_wallet int NOT NULL,
    request_status_id int NOT NULL,

    PRIMARY KEY (item_request_id),
    FOREIGN KEY (group_id) REFERENCES groups(group_id),
    FOREIGN KEY (item_id) REFERENCES item(item_id),
    FOREIGN KEY (request_status_id) REFERENCES request_status_type(request_status_id)
);

CREATE TABLE request_students (
    record_id character varying(8) NOT NULL,
    item_request_id character varying(8) NOT NULL,
    user_id character varying(8) NOT NULL,

    PRIMARY KEY (record_id),
    FOREIGN KEY (item_request_id) REFERENCES item_request(item_request_id),
    FOREIGN KEY (user_id) REFERENCES user_data(user_id)
);

CREATE TABLE item_status_type (
    item_status_id int NOT NULL,
    item_status_name character varying(255) NOT NULL,
);

CREATE TABLE transactions (
    transaction_id character varying(8) NOT NULL,
    item_id character varying(8) NOT NULL,
    total_cost int NOT NULL,
    item_status_type_id int NOT NULL,

    PRIMARY KEY (transaction_id),
    FOREIGN KEY (item_id) REFERENCES item(item_id),
    FOREIGN KEY (item_status_id) REFERENCES item_status_type(item_status_id)
);

CREATE TABLE transaction_students (
    record_id character varying(8) NOT NULL,
    transaction_id character varying(8) NOT NULL,
    user_id character varying(8) NOT NULL,

    PRIMARY KEY (record_id),
    FOREIGN KEY (transaction_id) REFERENCES transactions(transaction_id),
    FOREIGN KEY (user_id) REFERENCES user_data(user_id)
);