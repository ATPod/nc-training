CREATE DATABASE IF NOT EXISTS `aa-testing`
  DEFAULT CHARACTER SET utf8;
USE `aa-testing`;
CREATE TABLE IF NOT EXISTS `questions` (
  `id`      INT(50)       NOT NULL AUTO_INCREMENT
  COMMENT 'identeficator of test',
  `text`    VARCHAR(1000) NOT NULL DEFAULT '0'
  COMMENT 'text of question',
  `scores`   VARCHAR(50)   NOT NULL DEFAULT '0'
  COMMENT 'scores for right answer',
  `fk_test` INT(50)       NOT NULL DEFAULT '0'
  COMMENT 'identificator of test',
  PRIMARY KEY (`id`),
  KEY `FK__tests` (`fk_test`),
  CONSTRAINT `FK__tests` FOREIGN KEY (`fk_test`) REFERENCES `tests` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8
  COMMENT = 'All questions from tests';

CREATE TABLE IF NOT EXISTS `students` (
  `id`      INT(11) NOT NULL          AUTO_INCREMENT
  COMMENT 'identeficator of student',
  `name`    VARCHAR(50)               DEFAULT NULL
  COMMENT 'name of student',
  `surname` VARCHAR(50)               DEFAULT NULL
  COMMENT 'surname of student',
  `scores`   INT(50) UNSIGNED ZEROFILL DEFAULT NULL
  COMMENT 'amount of scores',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8
  COMMENT = 'Table shows data about students';

CREATE TABLE IF NOT EXISTS `tests` (
  `id`       INT(50) NOT NULL AUTO_INCREMENT
  COMMENT 'test identificator',
  `name`     VARCHAR(50)      DEFAULT NULL
  COMMENT 'name of test',
  `subject`  VARCHAR(50)      DEFAULT NULL
  COMMENT 'name of subject',
  `tutor_id` INT(11)          DEFAULT NULL
  COMMENT 'tutor id',
  PRIMARY KEY (`id`),
  KEY `FK__tutors` (`tutor_id`),
  CONSTRAINT `FK__tutors` FOREIGN KEY (`tutor_id`) REFERENCES `tutors` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8
  COMMENT = 'Table shows data about availiable tests';

CREATE TABLE IF NOT EXISTS `tutors` (
  `id`      INT(50) NOT NULL AUTO_INCREMENT
  COMMENT 'identificator of tutor',
  `name`    VARCHAR(50)      DEFAULT NULL
  COMMENT 'name of tutor',
  `surname` VARCHAR(50)      DEFAULT NULL
  COMMENT 'surname of tutor',
  `subject` VARCHAR(50)      DEFAULT NULL
  COMMENT 'name of subject',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8
  COMMENT = 'Table show data about tutors';


CREATE TABLE IF NOT EXISTS `variants` (
  `id`          INT(11) NOT NULL AUTO_INCREMENT,
  `text`        VARCHAR(50)      DEFAULT NULL,
  `number`      INT(50)          DEFAULT NULL
  COMMENT 'number of variant in question',
  `rightness`   BIT(1)           DEFAULT b'0',
  `question_id` INT(50)          DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Variants_questions` (`question_id`),
  CONSTRAINT `FK_Variants_questions` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8
  COMMENT = 'Variants of question answer';
