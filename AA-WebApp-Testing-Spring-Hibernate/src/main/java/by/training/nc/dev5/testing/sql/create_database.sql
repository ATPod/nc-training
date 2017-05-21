CREATE DATABASE IF NOT EXISTS `testing`;
USE `testing`;
CREATE TABLE IF NOT EXISTS `options` (
  `id`          INT(11)       NOT NULL AUTO_INCREMENT,
  `text`        VARCHAR(1000) NOT NULL,
  `number`      INT(11)       NOT NULL,
  `rightness`   BIT(1)        NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `questions` (
  `question_id` INT(11)       NOT NULL AUTO_INCREMENT,
  `text`        VARCHAR(1000) NOT NULL DEFAULT '0',
  `scores`      INT(11)       NOT NULL DEFAULT '0',
  PRIMARY KEY (`question_id`)
);

CREATE TABLE IF NOT EXISTS `questions_options` (
  `question_id` INT(11) DEFAULT NULL,
  `option_id`   INT(11) DEFAULT NULL,
  KEY `FK_questions_options_questions` (`question_id`),
  KEY `FK_questions_options_options` (`option_id`),
  CONSTRAINT `FK_questions_options_options` FOREIGN KEY (`option_id`) REFERENCES `options` (`id`),
  CONSTRAINT `FK_questions_options_questions` FOREIGN KEY (`question_id`) REFERENCES `questions` (`question_id`)
);
CREATE TABLE IF NOT EXISTS `users` (
  `id`       INT(11)     NOT NULL AUTO_INCREMENT,
  `type`     VARCHAR(50) NOT NULL DEFAULT '0',
  `name`     VARCHAR(50) NOT NULL DEFAULT '0',
  `surname`  VARCHAR(50) NOT NULL DEFAULT '0',
  `password` VARCHAR(50) NOT NULL DEFAULT '0',
  `login`    VARCHAR(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `students` (
  `id`     INT(11) DEFAULT NULL,
  `scores` INT(11) DEFAULT NULL,
  KEY `fk_student` (`id`),
  CONSTRAINT `fk_student` FOREIGN KEY (`id`) REFERENCES `users` (`id`)
);

CREATE TABLE IF NOT EXISTS `tutors` (
  `id`      INT(11)     DEFAULT NULL,
  `subject` VARCHAR(50) DEFAULT NULL,
  KEY `fk_tutor` (`id`),
  CONSTRAINT `fk_tutor` FOREIGN KEY (`id`) REFERENCES `users` (`id`)
);


CREATE TABLE IF NOT EXISTS `tests` (
  `test_id`  INT(11)     NOT NULL AUTO_INCREMENT,
  `tutor_id` INT(11)              DEFAULT '0',
  `subject`  VARCHAR(50) NOT NULL DEFAULT '0',
  `name`     VARCHAR(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`test_id`),
  KEY `fk_author` (`tutor_id`),
  CONSTRAINT `fk_author` FOREIGN KEY (`tutor_id`) REFERENCES `tutors` (`id`)
);

CREATE TABLE IF NOT EXISTS `tests_questions` (
  `test_id`     INT(11) DEFAULT NULL,
  `question_id` INT(11) DEFAULT NULL,
  KEY `FK_tests_questions_tests` (`test_id`),
  KEY `FK_tests_questions_questions` (`question_id`),
  CONSTRAINT `FK_tests_questions_questions` FOREIGN KEY (`question_id`) REFERENCES `questions` (`question_id`),
  CONSTRAINT `FK_tests_questions_tests` FOREIGN KEY (`test_id`) REFERENCES `tests` (`test_id`)
);

