INSERT INTO `users` (`type`, `login`, `password`, `name`, `surname`) VALUES
  ('student', 'annivan', '12345', 'Анна', 'Иваненко'),
  ('tutor', 'english', '2', 'Ирина', 'Александрова'),
  ('student', 'petrvadim', '11111', 'Вадим', 'Петров'),
  ('tutor', 'elenvas', '1', 'Елена', 'Василенко'),
  ('student', 'alexivan', '3', 'Александр', 'Иванов'),
  ('tutor', 'victorvish', '4', 'Виктория', 'Вишневская'),
  ('student', 'marinvetr', '22222', 'Марина', 'Ветрова');
INSERT INTO `students` (`id`, `scores`) VALUES
  ('1', '0'),
  ('3', '0'),
  ('5', '0'),
  ('7', '0');
INSERT INTO `tutors` (`id`, `subject`) VALUES
  ('2', 'Английский язык'),
  ('4', 'Математика'),
  ('6', 'Русский язык');
INSERT INTO `tests` (`name`, `subject`) VALUES
  ('Элементарная математика', 'Математика'),
  ('Общая лексика', 'Английский язык');
INSERT INTO `questions` (`text`, `scores`) VALUES
  ('При делении натурального числа на 18 в частном получили 14 и в остатке 11. Чему равно делимое?', '5'),
  ('Сколько секунд содержат двое суток?', '5'),
  ('Какое из высказываний относительно натуральных чисел ложное?', '5'),
  ('He was so tired that he ... asleep in the chair.', '5'),
  ('Our company is a small organization with only a few ... .', '5'),
  ('Before we start the lesson, I`d like to ... what we did yesterday.', '5');
INSERT INTO `options` (`text`, `number`, `rightness`) VALUES
  ('263', 1, b'1'),
  ('253', 2, b'0'),
  ('232400', 1, b'0'),
  ('172800', 2, b'1'),
  ('на 5 делятся все числа, которые оканчиваются на цифры 0 или 5', 1, b'0'),
  ('на 4 делятся все числа, которые оканчиваются цифрой 0 или 4', 2, b'1'),
  ('fell', 1, b'1'),
  ('felt', 2, b'0'),
  ('went', 3, b'0'),
  ('employments', 1, b'0'),
  ('employers', 2, b'0'),
  ('employees', 3, b'1'),
  ('run along', 1, b'0'),
  ('run through', 2, b'1'),
  ('run into', 3, b'0');

INSERT INTO `questions_options` (`question_id`, `option_id`) VALUES
  (1, 1),
  (1, 2),
  (2, 3),
  (2, 4),
  (3, 5),
  (3, 6),
  (2, 7),
  (2, 8),
  (2, 9),
  (2, 10),
  (3, 11),
  (3, 12);

INSERT INTO `tests_questions` (`test_id`, `question_id`) VALUES
  (1, 1),
  (1, 2),
  (1, 3),
  (2, 4),
  (2, 5),
  (2, 6);
