INSERT INTO `questions` (`id`, `text`, `scores`, `fk_test`) VALUES
	(1, 'Question about animals', '5', 1),
	(2, 'Question about plants', '2', 1);
INSERT INTO `students` (`id`, `name`, `surname`, `scores`) VALUES
	(1, 'Alena', 'Vasilieva', 00000000000000000000000000000000000000000000000000),
	(2, 'Anna', 'Alexandrova', 00000000000000000000000000000000000000000000000000);
INSERT INTO `tests` (`id`, `name`, `subject`, `tutor_id`) VALUES
	(1, 'Biology test', 'Biology', 2);
INSERT INTO `tutors` (`id`, `name`, `surname`, `subject`) VALUES
	(1, 'Ivan', 'Ivanov', 'Math'),
	(2, 'Petr', 'Petrov', 'Biology');
INSERT INTO `variants` (`id`, `text`, `number`, `rightness`, `question_id`) VALUES
	(1, 'Variant about animals one', 1, b'1', 1),
	(2, 'Variant about animals two', 2, b'0', 1);
