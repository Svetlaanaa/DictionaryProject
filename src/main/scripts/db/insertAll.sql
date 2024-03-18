
-- Вставка данных в таблицу "words.word"
INSERT INTO "words"."word" ("basic_form", "speech_part") VALUES ('Дом', 'существительное');
INSERT INTO "words"."word" ("basic_form", "speech_part") VALUES ('Бегать', 'глагол');
INSERT INTO "words"."word" ("basic_form", "speech_part") VALUES ('Красивый', 'прилагательное');

INSERT INTO "words"."word" ("basic_form", "speech_part") VALUES ('Книга', 'существительное');
INSERT INTO "words"."word" ("basic_form", "speech_part") VALUES ('Плавать', 'глагол');
INSERT INTO "words"."word" ("basic_form", "speech_part") VALUES ('Интересный', 'прилагательное');

INSERT INTO "words"."word" ("basic_form", "speech_part") VALUES ('Стол', 'существительное');
INSERT INTO "words"."word" ("basic_form", "speech_part") VALUES ('Прыгать', 'глагол');
INSERT INTO "words"."word" ("basic_form", "speech_part") VALUES ('Удивительный', 'прилагательное');

INSERT INTO "words"."word" ("basic_form", "speech_part") VALUES ('Машина', 'существительное');
INSERT INTO "words"."word" ("basic_form", "speech_part") VALUES ('Петь', 'глагол');
INSERT INTO "words"."word" ("basic_form", "speech_part") VALUES ('Умный', 'прилагательное');

INSERT INTO "words"."word" ("basic_form", "speech_part") VALUES ('Солнце', 'существительное');

INSERT INTO "words"."word" ("basic_form", "speech_part") VALUES ('Кошка', 'существительное');
INSERT INTO "words"."word" ("basic_form", "speech_part") VALUES ('Прыгать', 'глагол');

INSERT INTO "words"."word" ("basic_form", "speech_part") VALUES ('Забавный', 'прилагательное');
INSERT INTO "words"."word" ("basic_form", "speech_part") VALUES ('Смешной', 'прилагательное');

-- Вставка данных в таблицу "definitions.definition"
INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example") VALUES (1, 'Строение, предназначенное для постоянного или временного проживания людей', 'В этом доме живет моя семья');
INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example") VALUES (2, 'Действие быстрого перемещения на ногах, обычно с целью спорта или рекреации', 'Я люблю бегать по утрам');
INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example") VALUES (3, 'Описывающий что-то, что приятно или привлекательно на вид или по внешнему облику', 'У неё очень красивая улыбка');

INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example") VALUES (4, 'Книга - это печатное издание, содержащее текст и/или иллюстрации, предназначенное для чтения или обучения. Книги могут быть различных жанров и форматов.', 'Эта книга очень увлекательная.');
INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example") VALUES (5, 'Плавать - это действие перемещения по водной поверхности путем движения конечностей или специальных средств. Плавание может быть спортивным видом активности или средством передвижения.', 'Летом мы часто плаваем в озере.');
INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example") VALUES (6, 'Интересный - это прилагательное, означающее привлекательный, вызывающий интерес.', 'Это очень интересная книга.');

INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example") VALUES (7, 'Стол - это предмет мебели, обычно с плоской поверхностью и ножками, используемый для размещения предметов. Столы могут быть разных размеров, форм и материалов.', 'На столе лежит книга.');
INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example") VALUES (8, 'Прыгать - это действие подпрыгивания или многократного отрыва от поверхности с последующим приземлением. Прыжки могут быть разного вида: высокие, длинные, короткие и т.д.', 'Он любит прыгать через препятствия.');
INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example") VALUES (9, 'Удивительный - это прилагательное, означающее что-то поразительное, необычное или вызывающее удивление. Удивительные события могут случаться в жизни каждого человека.', 'Это было удивительное путешествие.');

INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example") VALUES (10, 'Машина - это транспортное средство, обычно с двигателем, предназначенное для перемещения по дорогам. Машины могут быть различных типов и моделей.', 'Я купил новую машину.');
INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example") VALUES (11, 'Петь - это искусство производить звуки голосом или инструментом в музыкальных целях. Пение может быть хобби или профессией.', 'Она часто пела в детстве.');
INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example") VALUES (12, 'Умный - это характеристика человека или существа, обладающего высоким уровнем интеллекта и способностью к обучению. Умные люди часто принимают обдуманные решения.', 'Этот студент очень умен.');

INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example") VALUES (13, 'Солнце - это звезда, находящаяся в центре Солнечной системы и являющаяся источником света и тепла для Земли. Оно состоит преимущественно из водорода и гелия.', 'Сегодня светит солнце.');

INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example") VALUES (14, 'Млекопитающее семейства кошачьих. Обладает усами и острыми когтями.', 'Кошка спокойно спала на окне.');
INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example") VALUES (15, 'Делать резкий прыжок с ноги на ногу. Действие быстрое и энергичное.', 'Он прыгнул через барьер на тренировке.');

INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example") VALUES (16,
'Вызывающий улыбку, интересный. Часто используется для описания забавных ситуаций.',
'Этот мультфильм очень забавный и заставляет смеяться.');
INSERT INTO "definitions"."definition" ("word_id", "definition_text", "usage_example") VALUES (17, 'Комический, вызывающий смех. Характеризующийся остроумием и неожиданными поворотами сюжета', 'Этот фильм очень смешной и интересный');

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


INSERT INTO "definitions"."synonym" ("definition_id", "word_id", "synonym") VALUES (1, 16, 17);
INSERT INTO "definitions"."synonym" ("definition_id", "word_id", "synonym") VALUES (1, 17, 16);


