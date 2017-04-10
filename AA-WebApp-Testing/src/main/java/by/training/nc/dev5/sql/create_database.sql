CREATE DATABASE IF NOT EXISTS `aa-testing`
  DEFAULT CHARACTER SET utf8;
USE `aa-testing`;

CREATE TABLE `user_types` (
  `id`        INT(11)     NOT NULL AUTO_INCREMENT,
  `type_name` VARCHAR(50) NULL     DEFAULT '0',
  PRIMARY KEY (`id`)
)
  COMMENT = 'Types of users in system'
  COLLATE = 'utf8_general_ci'
  ENGINE = InnoDB;
CREATE TABLE `users` (
  `id`       INT(10)     NOT NULL AUTO_INCREMENT,
  `type`     INT(10)     NULL     DEFAULT NULL,
  `login`    VARCHAR(50) NULL     DEFAULT NULL,
  `password` VARCHAR(50) NULL     DEFAULT NULL,
  `name`     VARCHAR(50) NULL     DEFAULT NULL,
  `surname`  VARCHAR(50) NULL     DEFAULT NULL,
  `scores`   INT(10)     NULL     DEFAULT NULL,
  `subject`  VARCHAR(50) NULL     DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`type`) REFERENCES `user_types` (`id`)
)
  COMMENT = 'testing system users\r\n'
  COLLATE = 'utf8_general_ci'
  ENGINE = InnoDB;
CREATE TABLE `tests` (
  `id`       INT(50)     NOT NULL AUTO_INCREMENT
  COMMENT 'test identifier',
  `name`     VARCHAR(50) NULL     DEFAULT NULL
  COMMENT 'name of test',
  `subject`  VARCHAR(50) NULL     DEFAULT NULL
  COMMENT 'name of subject',
  `tutor_id` INT(11)     NULL     DEFAULT NULL
  COMMENT 'tutor id',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`tutor_id`) REFERENCES `users` (`id`)
)
  COMMENT = 'Table shows data about  tests'
  COLLATE = 'utf8_general_ci'
  ENGINE = InnoDB
  AUTO_INCREMENT = 2;
CREATE TABLE `questions` (
  `id`      INT(50)       NOT NULL AUTO_INCREMENT
  COMMENT 'identeficator of test',
  `text`    VARCHAR(1000) NOT NULL DEFAULT '0'
  COMMENT 'text of question',
  `scores`  VARCHAR(50)   NOT NULL DEFAULT '0'
  COMMENT 'scores for right answer',
  `fk_test` INT(50)       NOT NULL
  COMMENT 'identificator of test',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`fk_test`) REFERENCES `tests` (`id`)
)
  COMMENT = 'All questions from tests'
  COLLATE = 'utf8_general_ci'
  ENGINE = InnoDB
  AUTO_INCREMENT = 3;
CREATE TABLE `options` (
  `id`          INT(11)     NOT NULL AUTO_INCREMENT,
  `text`        VARCHAR(50) NULL     DEFAULT NULL,
  `number`      INT(50)     NULL     DEFAULT NULL
  COMMENT 'number of variant in question',
  `rightness`   BIT(1)      NULL     DEFAULT b'0',
  `question_id` INT(50)     NULL     DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`)
)
  COMMENT = 'Variants of question answer'
  COLLATE = 'utf8_general_ci'
  ENGINE = InnoDB
  AUTO_INCREMENT = 3;

