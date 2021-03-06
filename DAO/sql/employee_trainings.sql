drop table `employee_training` if exists;

CREATE TABLE `employee_training` (
  `employee_id` int(11) NOT NULL,
  `training_id` int(11) NOT NULL,
  UNIQUE KEY `employee_id` (`employee_id`,`training_id`),
  KEY `employee_training_fk1` (`training_id`),
  CONSTRAINT `employee_training_fk` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `employee_training_fk1` FOREIGN KEY (`training_id`) REFERENCES `training` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
