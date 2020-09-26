DROP TABLE IF EXISTS quest_type CASCADE;
DROP TABLE IF EXISTS quest CASCADE;
DROP TABLE IF EXISTS quest_achievements CASCADE;
DROP TABLE IF EXISTS achievement_details CASCADE;

CREATE TABLE quest_type (
    quest_type_id int NOT NULL,
    type_name character varying(255) NOT NULL,

    PRIMARY KEY (quest_type_id)
);

CREATE TABLE quest (
    quest_id character varying(8) NOT NULL,
    quest_type_id int NOT NULL,
    quest_name character varying(255) NOT NULL,
    quest_description character varying(255) NOT NULL,
    quest_value int NOT NULL,

    PRIMARY KEY (quest_id),
    FOREIGN KEY (quest_type_id) REFERENCES quest_type(quest_type_id)
);

CREATE TABLE quest_achievements (
    achievement_id character varying(8) NOT NULL,
    quest_id character varying(255) NOT NULL,
    total_value int NOT NULL,

    PRIMARY KEY (achievement_id),
    FOREIGN KEY (quest_id) REFERENCES quest(quest_id)
);

CREATE TABLE achievement_details (
    record_id character varying(8) NOT NULL,
    achievement_id character varying(8) NOT NULL,
    user_id character varying(8) NOT NULL,

    PRIMARY KEY (record_id),
    FOREIGN KEY (achievement_id) REFERENCES quest_achievements(achievement_id),
    FOREIGN KEY (user_id) REFERENCES user_data(user_id)
);



