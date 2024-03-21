
-- Вставка данных в таблицу "words.word"
INSERT INTO "words"."word" ("basic_form") VALUES ('Дом');
INSERT INTO "words"."word" ("basic_form") VALUES ('Бегать');
INSERT INTO "words"."word" ("basic_form") VALUES ('Красивый');

INSERT INTO "words"."word" ("basic_form") VALUES ('Книга');
INSERT INTO "words"."word" ("basic_form") VALUES ('Плавать');
INSERT INTO "words"."word" ("basic_form") VALUES ('Интересный');

INSERT INTO "words"."word" ("basic_form") VALUES ('Стол');
INSERT INTO "words"."word" ("basic_form") VALUES ('Прыгать');
INSERT INTO "words"."word" ("basic_form") VALUES ('Удивительный');

INSERT INTO "words"."word" ("basic_form") VALUES ('Машина');
INSERT INTO "words"."word" ("basic_form") VALUES ('Петь');
INSERT INTO "words"."word" ("basic_form") VALUES ('Умный');

INSERT INTO "words"."word" ("basic_form") VALUES ('Солнце');

INSERT INTO "words"."word" ("basic_form") VALUES ('Кошка');
INSERT INTO "words"."word" ("basic_form") VALUES ('Прыгать');

INSERT INTO "words"."word" ("basic_form") VALUES ('Забавный');
INSERT INTO "words"."word" ("basic_form") VALUES ('Смешной');

-- Вставка данных в таблицу "definitions.definition"
INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example", "speech_part") VALUES (1, 'Строение, предназначенное для постоянного или временного проживания людей', 'В этом доме живет моя семья', 'NOUN');
INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example", "speech_part") VALUES (2, 'Действие быстрого перемещения на ногах, обычно с целью спорта или рекреации', 'Я люблю бегать по утрам', 'VERB');
INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example", "speech_part") VALUES (3, 'Описывающий что-то, что приятно или привлекательно на вид или по внешнему облику', 'У неё очень красивая улыбка', 'ADJECTIVE');

INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example", "speech_part") VALUES (4, 'Книга - это печатное издание, содержащее текст и/или иллюстрации, предназначенное для чтения или обучения. Книги могут быть различных жанров и форматов.', 'Эта книга очень увлекательная.', 'NOUN');
INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example", "speech_part") VALUES (5, 'Плавать - это действие перемещения по водной поверхности путем движения конечностей или специальных средств. Плавание может быть спортивным видом активности или средством передвижения.', 'Летом мы часто плаваем в озере.', 'VERB');
INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example", "speech_part") VALUES (6, 'Интересный - это прилагательное, означающее привлекательный, вызывающий интерес.', 'Это очень интересная книга.', 'ADJECTIVE');

INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example", "speech_part") VALUES (7, 'Стол - это предмет мебели, обычно с плоской поверхностью и ножками, используемый для размещения предметов. Столы могут быть разных размеров, форм и материалов.', 'На столе лежит книга.', 'NOUN');
INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example", "speech_part") VALUES (8, 'Прыгать - это действие подпрыгивания или многократного отрыва от поверхности с последующим приземлением. Прыжки могут быть разного вида: высокие, длинные, короткие и т.д.', 'Он любит прыгать через препятствия.', 'VERB');
INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example", "speech_part") VALUES (9, 'Удивительный - это прилагательное, означающее что-то поразительное, необычное или вызывающее удивление. Удивительные события могут случаться в жизни каждого человека.', 'Это было удивительное путешествие.', 'ADJECTIVE');

INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example", "speech_part") VALUES (10, 'Машина - это транспортное средство, обычно с двигателем, предназначенное для перемещения по дорогам. Машины могут быть различных типов и моделей.', 'Я купил новую машину.', 'NOUN');
INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example", "speech_part") VALUES (11, 'Петь - это искусство производить звуки голосом или инструментом в музыкальных целях. Пение может быть хобби или профессией.', 'Она часто пела в детстве.', 'VERB');
INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example", "speech_part") VALUES (12, 'Умный - это характеристика человека или существа, обладающего высоким уровнем интеллекта и способностью к обучению. Умные люди часто принимают обдуманные решения.', 'Этот студент очень умен.', 'ADJECTIVE');


INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example", "speech_part") VALUES (13,
'Солнце - это звезда, находящаяся в центре Солнечной системы и являющаяся источником света и тепла для Земли. Оно состоит преимущественно из водорода и гелия.',
'Сегодня светит солнце.', 'NOUN');

INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example", "speech_part") VALUES (14, 'Млекопитающее семейства кошачьих. Обладает усами и острыми когтями.',
'Кошка спокойно спала на окне.', 'NOUN');
INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example", "speech_part") VALUES (15, 'Делать резкий прыжок с ноги на ногу. Действие быстрое и энергичное.',
'Он прыгнул через барьер на тренировке.', 'VERB');

INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example", "speech_part") VALUES (16,
'Вызывающий улыбку, интересный. Часто используется для описания забавных ситуаций.',
'Этот мультфильм очень забавный и заставляет смеяться.', 'ADJECTIVE');
INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example", "speech_part") VALUES (17,
'Комический, вызывающий смех. Характеризующийся остроумием и неожиданными поворотами сюжета',
'Этот фильм очень смешной и интересный', 'ADJECTIVE');

delete from "words"."other_form";
ALTER SEQUENCE "words"."other_form_id_seq" RESTART WITH 1;

-- Вставка данных в таблицу "words.other_form"
INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (1, 'Дому');
INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (1, 'Дома');
INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (2, 'Бегаю');
INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (2, 'Бегали');
INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (3, 'Красивая');
INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (3, 'Красивее');

INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (4, 'Книги');
INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (4, 'Книгу');
INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (5, 'Плаваю');
INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (5, 'Плавали');
INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (6, 'Интересная');
INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (6, 'Интереснее');

INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (7, 'Столы');
INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (7, 'Столу');
INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (8, 'Прыгаю');
INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (8, 'Прыгали');
INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (9, 'Удивительная');
INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (9, 'Удивительнее');

INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (10, 'Машины');
INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (10, 'Машину');
INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (11, 'Пою');
INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (11, 'Пели');
INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (12, 'Умный');
INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (12, 'Умнее');

INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (13, 'Солнца');
INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (13, 'Солнцу');

INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (14, 'Кошке');
INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (15, 'Прыгнул');

INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (16, 'Забавная');
INSERT INTO "words"."other_form" ("word_id", "other_form") VALUES (17, 'Смешная');


-- Вставка данных в таблицу "definitions.source"
INSERT INTO "definitions"."source" ("definition_id", "word_id", "source") VALUES (1, 1, 'Толковый словарь русского языка');
INSERT INTO "definitions"."source" ("definition_id", "word_id", "source") VALUES (1, 2, 'Энциклопедия "Слово"');
INSERT INTO "definitions"."source" ("definition_id", "word_id", "source") VALUES (1, 3, 'Учебник "Русский язык: синтаксис и стилистика"');

INSERT INTO "definitions"."source" ("definition_id", "word_id", "source") VALUES (1, 4, 'Онлайн-энциклопедия "Википедия"');
INSERT INTO "definitions"."source" ("definition_id", "word_id", "source") VALUES (1, 5, 'Словарь синонимов и антонимов');
INSERT INTO "definitions"."source" ("definition_id", "word_id", "source") VALUES (1, 6, 'Научно-популярная статья в журнале "Наука и жизнь"');

INSERT INTO "definitions"."source" ("definition_id", "word_id", "source") VALUES (1, 7, 'Лингвистический журнал "Язык и текст"');
INSERT INTO "definitions"."source" ("definition_id", "word_id", "source") VALUES (1, 8, 'Учебное пособие по русскому языку для школьников');
INSERT INTO "definitions"."source" ("definition_id", "word_id", "source") VALUES (1, 9, 'Интернет-ресурс "Грамота.ру"');

INSERT INTO "definitions"."source" ("definition_id", "word_id", "source") VALUES (1, 10, 'Словарь русского языка в 4 томах');
INSERT INTO "definitions"."source" ("definition_id", "word_id", "source") VALUES (1, 11, 'Учебник по лингвистике для студентов');
INSERT INTO "definitions"."source" ("definition_id", "word_id", "source") VALUES (1, 12, 'Статья в литературном журнале "Новый мир"');

INSERT INTO "definitions"."source" ("definition_id", "word_id", "source") VALUES (1, 13, 'Справочник по русскому языку для изучающих иностранные языки');
INSERT INTO "definitions"."source" ("definition_id", "word_id", "source") VALUES (1, 14, 'Электронный словарь современного русского языка');
INSERT INTO "definitions"."source" ("definition_id", "word_id", "source") VALUES (1, 15, 'Учебное пособие по стилистике для лингвистов');

INSERT INTO "definitions"."source" ("definition_id", "word_id", "source") VALUES (1, 16, 'Научная статья в журнале "Языкознание"');
INSERT INTO "definitions"."source" ("definition_id", "word_id", "source") VALUES (1, 17, 'Словарь русского языка с толкованиями');
--INSERT INTO "definitions"."source" ("definition_id", "word_id", "source") VALUES (1, 18, 'Интернет-ресурс "Русский язык онлайн"');
--
--INSERT INTO "definitions"."source" ("definition_id", "word_id", "source") VALUES (1, 19, 'Учебник по русскому языку для иностранных студентов');
--INSERT INTO "definitions"."source" ("definition_id", "word_id", "source") VALUES (1, 20, 'Учебник по русскому языку для иностранных студентов');


INSERT INTO "definitions"."synonym" ("definition_id", "synonym") VALUES (16, 17);
INSERT INTO "definitions"."synonym" ("definition_id", "synonym") VALUES (17, 16);


