CREATE TABLE users
(
    `user_id` BIGINT NOT NULL AUTO_INCREMENT,
    `login_id` VARCHAR(45) NULL DEFAULT NULL,
    `password` VARCHAR(255) NULL DEFAULT NULL,
    `nickname` DATE NULL DEFAULT NULL,
    `created_date` DATETIME NULL DEFAULT NULL,
    `last_modified_date` DATETIME NULL DEFAULT NULL,
    PRIMARY KEY (`user_id`)
);