// создать БД
CREATE DATABASE JIS6
DEFAULT CHARACTER SET utf8
DEFAULT COLLATE utf8_general_ci
// удалить БД
DROP DATABASE JIS6;
//создать юзера
CREATE USER jis6@localhost IDENTIFIED BY '12345';
GRANT ALL ON JIS6.* TO jis6@localhost;
//удалить юзера
DROP USER jis6@localhost;

SELECT user FROM mysql.user;
//перейти на пользователя
mysql -h 127.0.0.1 -P 3306 -u avp02 -p
mysql -u avp02 -p

//ВЫбрать базу дфнных
USE nameDb;
//чтобы узнать с помощью какой команды была создана бд или таблица
SHOW CREATE DATABASE nameDb;

//чт обы создать таблицу
CREATE TABLE nameT {
    id INT AUTO_INCREMENT,
    //и далее колонки

    };
//чт обы посмотреть табл
SHOW TABLES;
//описание таблицы
DESCRIBE nameT;
//посмотреть команду с помощью кот была созана таблица
SHOW CREATE TABLE nameT;

//добавить значение в столбец
INSERT INTO user ('login') VALUE ('Vavan02');
INSERT INTO `user` (login) VALUES ('Vavan');

INSERT INTO user (`login`) VALUES ("I'am Vavan");

INSERT INTO user (`login`) VALUES ('He sad "I am ok" he sad');
-- INSERT INTO user (`login`) VALUES ('He sad "I\'m ok" he sad'); тут должна экранироваться ковычка I\'m
// ПОСМОТРЕТЬ Значения в таблице кот добавили
SELECT * from user;

// ЧТОБЫ добавить столбец нужно
ALTER TABLE user ADD email VARCHAR (32);
//если надо изменить тип столбца
ALTER TABLE user MODIFY email TEXT;
//если надо преименовать столбец
ALTER TABLE user CHANGE email e_mail VARCHAR (32);
//или
ALTER TABLE user CHANGE COLUMN email e_mail VARCHAR (32);
// ЕСЛИ надо удалить колонку
ALTER TABLE user DROP e_mail;

//если надо переименовать таблицу
ALTER TABLE user RENAME abuser;

CREATE TABLE user (
    login VARCHAR(32) NOT NULL UNIQUE,
    name VARCHAR(255)
);
// заполняем данными
INSERT INTO user (`login`, `name`) VALUES ('maxbax', 'maxsim');
INSERT INTO user (`name`, `login`) VALUES ('vladimir', 'vov4eg');
INSERT INTO user VALUES ('CARABAS', 'igor'); // можно так, но последовательность должна быть такая же как при соданиии
//добаляем колонки
ALTER TABLE user ADD birth DATE;
ALTER TABLE user ADD registered DATETIME;
//заполняем
INSERT INTO user (`login`, `birth`) VALUES ('v1', '2020-10-11');
INSERT INTO user (login, registered) VALUES ('v2', '2021-09-01');
INSERT INTO user (login, registered) VALUES ('V3', '2021-05-29T10-15-59');
INSERT INTO user (login, registered) VALUES ('V4', '2021-05-29 10-15-59');
INSERT INTO user (login, registered) VALUES ('V4', '06.06.20'); // 2006-06-20
INSERT INTO user (login, registered) VALUES ('V6', '2020.06.20'); // 2020-06-20
INSERT INTO user (login, registered) VALUES ('V7', NOW()); // текущее время
INSERT INTO user (login, registered) VALUES ('V8', NOW() - INTERVAL 1 HOUR); // текущее время - 1 ЧАС

SELECT RAND()*(b - a) + a; // рандомное значение от а до b

// можно заполнять таблицу построчно как выше , а можно как вот так
-- # BATCH UPDATE
INSERT INTO ubuser VALUES
(NULL, 'vadin', 'Vladimir Yakovlevitch', 'Директор завода', NULL, '2020-05-29', '2020-05-20 23:32:32', NULL, 'M', 150, 150.00, TRUE),
(NULL, 'mikas', 'Максим Шелкович', 'Директор ИТ Гуру', NULL, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NULL, 'M', RAND()*(1000-5)+5, RAND()*(1000-5)+5, RAND()),
(NULL, 'vikas', 'Евгений Абрамович', 'Промышленник со стажем', NULL, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NULL, 'F', RAND()*(1000-5)+5, RAND()*(1000-5)+5, RAND()),
(NULL, 'bikas', 'Владимир Ганц', 'Предприниматель', NULL, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NULL, 'M', RAND()*(1000-5)+5, RAND()*(1000-5)+5, RAND()),
(NULL, 'userr', 'Нетаньяху', 'Java Developer', NULL, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NULL, 'F', RAND()*(1000-5)+5, RAND()*(1000-5)+5, RAND()),
(NULL, 'myname', 'Соломон', 'Java Developer', NULL, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NULL, 'M', RAND()*(1000-5)+5, RAND()*(1000-5)+5, RAND()),
(NULL, 'login', 'Егор Барило', 'Предприниматель', NULL, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NULL, 'F', RAND()*(1000-5)+5, RAND()*(1000-5)+5, RAND()),
(NULL, 'passw', 'Авсеенков Владимир', 'Директор Курсов', NULL, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NULL, 'M', RAND()*(1000-5)+5, RAND()*(1000-5)+5, RAND()),
(NULL, 'noname', 'Никита Кожемяко', 'Промышленник без стажа', NULL, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NULL, 'F', RAND()*(1000-5)+5, RAND()*(1000-5)+5, RAND()),
(NULL, 'anon', 'Флипп Янцевич', 'Student', NULL, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NULL, 'M', RAND()*(1000-5)+5, RAND()*(1000-5)+5, RAND()),
(NULL, 'joker', 'Катерина Яцкевич', 'Mentor', NULL, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NULL, 'F', RAND()*(1000-5)+5, RAND()*(1000-5)+5, RAND()),
(NULL, 'focker', 'Доктор Кто', 'Mentor', NULL, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NULL, 'M', RAND()*(1000-5)+5, RAND()*(1000-5)+5, RAND()),
(NULL, 'mause', 'Терион Ланистер', 'Java Developer', NULL, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NULL, 'F', RAND()*(1000-5)+5, RAND()*(1000-5)+5, RAND()),
(NULL, 'mice', 'Бердд Питт', 'Java Developer', NULL, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NULL, 'M', RAND()*(1000-5)+5, RAND()*(1000-5)+5, RAND()),
(NULL, 'nice', 'Терминатор2', 'Student', NULL, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NULL, 'F', RAND()*(1000-5)+5, RAND()*(1000-5)+5, RAND()),
(NULL, 'goblin', 'Джон Смитт', 'Mentor', NULL, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NULL, 'M', RAND()*(1000-5)+5, RAND()*(1000-5)+5, RAND()),
(NULL, 'bobin', 'Егор Добкин', 'Student', NULL, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NULL, 'F', RAND()*(1000-5)+5, RAND()*(1000-5)+5, RAND()),
(NULL, 'bob', 'Дмитрий Федовор', 'Mentor', NULL, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NULL, 'M', RAND()*(1000-5)+5, RAND()*(1000-5)+5, RAND()),
(NULL, 'steave', 'Кац Шиллерман', 'Java Developer', NULL, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NULL, 'F', RAND()*(1000-5)+5, RAND()*(1000-5)+5, RAND()),
(NULL, 'jobs', 'Борис Нефедов', 'Student', NULL, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NULL, 'M', RAND()*(1000-5)+5, RAND()*(1000-5)+5, RAND()),
(NULL, 'rocket', 'Тамара Винникова', 'Mentor', NULL, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NULL, 'F', RAND()*(1000-5)+5, RAND()*(1000-5)+5, RAND()),
(NULL, 'virus', 'Василий Сулейманович', 'Mentor', NULL, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NOW()-INTERVAL RAND()*(1000-5)+5 DAY, NULL, 'M', RAND()*(1000-5)+5, RAND()*(1000-5)+5, RAND())
;

// удалить строку из таблицы
DELETE FROM user WHERE id =1; // здесь может быть любоке условие


// чтобф выбрать какие то столбцы
SELECT id, login, active FROM ubuser;
//если надо выбрать первые 3 записи
SELECT id, login, active FROM ubuser LIMIT 3;
// если надо аказать с какой записи начинать(2) и количество выбранных обьектов(3)
SELECT id, login, active FROM ubuser LIMIT 2, 3;
// если надо какую то конкретную запись
SELECT id, login, active FROM ubuser WHERE id = 5;
SELECT id, login, active FROM ubuser WHERE id < 20;
SELECT id, login, active, birth FROM ubuser WHERE birth BETWEEN '2019-01-01' AND '2020-05-01';
SELECT id, login, active, birth FROM ubuser WHERE birth > '2020-05-01';
SELECT id, login, active, birth FROM ubuser WHERE id IN (7, 15, 23); //из множества выбрать конкретные
SELECT id, login, active, birth FROM ubuser WHERE id NOT IN (7, 15, 23); //из множества выбрать RHJVT КРОМЕ ЭТИХ
//если надо выбрать по из какого то столбца пондобные как
SELECT id, login, birth, bio FROM ubuser WHERE bio LIKE '%dev%';
// если надо обьеденить запросы, при этом если обьект подпадает под два запроса он обьединяется
SELECT id, login, active, birth, bio FROM ubuser WHERE birth > '2020-05-01';
UNION
SELECT id, login, active, birth, bio FROM ubuser WHERE bio LIKE '%dev%';
// есл инужно чтобы выводился один обьект столько сколько запрросов
SELECT id, login, active, birth, bio FROM ubuser WHERE birth > '2020-05-01';
UNION ALL
SELECT id, login, active, birth, bio FROM ubuser WHERE bio LIKE '%dev%';

// ЕСЛИ СТОЯТ в столбце значекния раные NULL
SELECT id, login, active, birth, bio, image FROM ubuser WHERE image IS NULL;
SELECT id, login, active, birth, bio, image FROM ubuser WHERE image IS NOT NULL;

//если надо обновить како1 то параметр
UPDATE ubuser SET
    gender = 'M',
    likes = 1
    WHERE id = 21;






