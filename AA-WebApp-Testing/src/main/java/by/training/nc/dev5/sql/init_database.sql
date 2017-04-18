INSERT INTO `user_types` (`id`, `type_name`) VALUES
  (1, 'Student'),
  (2, 'Tutor');
INSERT INTO `users` (`type`, `login`, `password`, `name`, `surname`, `scores`, `subject`) VALUES
  (1, 'annivan', '12345', 'Анна', 'Иваненко', 0, NULL),
  (2, 'math', '1', 'Елена', 'Василенко', NULL, 'Математика'),
  (2, 'english', '2', 'Ирина', 'Александрова', NULL, 'Английский язык'),
  (1, 'petrvad', '11111', 'Вадим', 'Петров', 0, NULL),
  (1, 'svetant', '22222', 'Светлана', 'Антонова', 0, NULL),
  (1, 'elenvas', '22222', 'Анна', 'Александрова', 0, NULL);
INSERT INTO `tests` (`name`, `subject`, `tutor_id`) VALUES
  ('Элементарная математика', 'Математика', 2),
  ('Общая лексика', 'Английский язык', 3);
INSERT INTO `questions` (`text`, `scores`, `fk_test`) VALUES
  ('При делении натурального числа на 18 в частном получили 14 и в остатке 11. Чему равно делимое?', '2', 2),
  ('Сколько секунд содержат двое суток?', '5', 2),
  ('Какое из высказываний относительно натуральных чисел ложное?', '10', 2),
  ('He was so tired that he ... asleep in the chair.', '2', 3),
  ('Our company is a small organization with only a few ... .', '2', 3),
  ('Before we start the lesson, I`d like to ... what we did yesterday.', '2', 3);
INSERT INTO `options` (`text`, `number`, `rightness`, `question_id`) VALUES
  ('263', 1, b'1', 3),
  ('253', 2, b'0', 3),
  ('232400', 1, b'0', 4),
  ('172800', 2, b'1', 4),
  ('на 5 делятся все числа, которые оканчиваются на цифры 0 или 5', 1, b'0', 5),
  ('на 4 делятся все числа, которые оканчиваются цифрой 0 или 4', 2, b'1', 5),
  ('fell', 1, b'1', 6),
  ('felt', 2, b'0', 6),
  ('went', 3, b'0', 6),
  ('employments', 1, b'0', 7),
  ('employers', 2, b'0', 7),
  ('employees', 3, b'1', 7),
  ('run along', 1, b'0', 7),
  ('run through', 2, b'1', 7),
  ('run into', 3, b'0', 7);






