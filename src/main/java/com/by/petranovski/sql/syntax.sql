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






