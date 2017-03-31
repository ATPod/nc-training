INSERT INTO `user_types` (`id`, `type_name`) VALUES
	(1, 'Student'),
	(2, 'Tutor');
INSERT INTO `users` (`id`, `type`, `login`, `password`, `name`, `surname`, `scores`, `subject`) VALUES
	(1, 1, 'annivan', '12345', 'Anna', 'Ivanenko', 0, NULL),
	(2, 2, 'tutor', '11111', 'Tutor', 'Tutor', NULL, 'Biology');
	INSERT INTO `tests` (`id`, `name`, `subject`, `tutor_id`) VALUES
	(1, 'Biology test', 'Biology', 2);
	INSERT INTO `questions` (`id`, `text`, `scores`, `fk_test`) VALUES
	(1, 'Question about animals', '5', 1),
	(2, 'Question about plants', '2', 1);
INSERT INTO `options` (`id`, `text`, `number`, `rightness`, `question_id`) VALUES
	(1, 'Variant about animals one', 1, b'1', 1),
	(2, 'Variant about animals two', 2, b'0', 1);






