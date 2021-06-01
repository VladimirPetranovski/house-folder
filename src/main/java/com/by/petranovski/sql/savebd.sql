# for our username and database - username in lowcase, database name in uppercase
// если надо сохранить базу данных под root
# mysqldump JIS4 > jis4_2020-12-08T23.00.00.sql // если root admin
// если надо сохранить бд для пользователя, где jis4 - пользователь, JIS4 - бд, jis4.sql -- файл куда сохранять
max@max:~$ mysqldump -h 127.0.0.1 -u jis4 JIS4 > jis4.sql -p
// можно через пробел указать базы данных данного пользователя JIS12 JIS4 И Т.Д
max@max:~$ mysqldump -h 127.0.0.1 -u jis4 JIS12 JIS4 > severalJisDatabases.sql -p
// а так все БД данного пользователя
max@max:~$ mysqldump -h 127.0.0.1 -u jis4 --all-databases > alldatabases.sql -p
// чтобы восстановить(накатить) тблицу, нужно снвчала ее удалить, потом создать пустую под этим названием а потом
max@max:~$ mysql -h 127.0.0.1 -u jis4 JIS4 < jis4.sql -p

max@max:~$ mysqldump -u username -ppassword database_name table_name > single_table_dump.sql
max@max:~$ mysqldump -u username -ppassword database_name table_name --where="date_created='2013-06-25'" > few_rows_dump.sql


Транзакции!!!
START TRANSACTION;
UPDATE user SET gender = 'F', likes = 405 WHERE id = 21; // или любое другое условие
// смотрим резаулт
SELECT * FROM user;
//если не устраивает результат ттогда
rollback;
// если устраивает, тогда
commit;
// обязательно надо установить
SET autocommit=0;

// Выборки
// выбрать по два(любое число) символа из каждой строчки какого то столбца
SELECT RIGHT (login, 2) FROM user;
// обрезать числа после точки, здесь цифра один означает номер вхождения символа '.'
SELECT login, SUBSTRING_INDEX(credit, '.', 1) FROM user;
// верхний, нижний регистр, и реверс
SELECT UPPER(name), LOWER(login), REVERSE(bio) FROM user;
// узнать длину строки
SELECT LENGTH(login) FROM user;
SELECT LENGTH(login), login FROM user WHERE LENGTH(login) >=5;
//убрать пробелы слева
SELECT LTRIM(' SASASA ');
//убрать пробелы ссправа
SELECT RTRIM(' FDHGJGHJ ');


// IF ELSE в SQL
ALTER TABLE user ADD login_policy VARCHAR(32);
UPDATE user SET login_policy =
                                CASE
                                    WHEN LENGTH(login) < 4
                                        THEN 'too short'
                                    WHEN LENGTH(login) <= 5
                                        THEN 'OK'
                                    ELSE 'too long'
                                END;
SELECT login, LENGTH(login), login_policy FROM user;

// Сортировка!!!!!!!!!!
//asc по возврастанию
SELECT login, bio, birth FROM user ORDER BY login ASC;
// desc по убыванию
SELECT login, bio, birth FROM user ORDER BY login DESC;
// можно выбирать несколько столбцов
SELECT login, bio, birth, name FROM user ORDER BY login ASC, name DESC;
// можно вставлять формулу
SELECT login, bio, name from user ORDER BY LENGTH(login) ASC, name DESC;
// получить юзера с максимальным значением чего то, здесь в условие добавляется другой запрос
SELECT likes, name FROM ubuser WHERE likes = (SELECT MAX(likes) FROM ubuser);
// тоже самое только с сортировкой и лимиT
SELECT likes, name FROM ubuser ORDER BY likes DESC LIMIT 1;

//СЧЕТТЧИК
SELECT bio, COUNT(bio) AS TOTAL FROM ubuser GROUP BY bio;
// можно сузить до какого то одного значения
SELECT bio, COUNT(bio) AS TOTAL FROM ubuser WHERE bio LIKE (%dev%) GROUP BY bio;
// можно упорядлочить
SELECT bio, COUNT(bio) AS TOTAL FROM ubuser GROUP BY bio ORDER BY total DESC;
//вывести тех кого максимум
SELECT bio, COUNT(bio) AS TOTAL FROM ubuser GROUP BY bio ORDER BY total DESC LIMIT 1;
// вывести второго после максимальног
SELECT bio, COUNT(bio) AS TOTAL FROM ubuser GROUP BY bio ORDER BY total DESC LIMIT 1,1;
// вывести всех кто встречается больше 3 раз
SELECT bio, COUNT(bio) AS TOTAL FROM ubuser GROUP BY bio HAVING total > 3;
//вывести сумму лайковб , переименовать столбец, среднее знавение для од\ного, счетчик биографии и саму биографии сгрупированной по биографии
SELECT SUM(likes) AS likes_total, AVG(likes), COUNT(bio), bio FROM ubuser GROUP BY bio;
// вывести мин кол лайков из професии
SELECT MIN(likes), bio FROM ubuser GROUP BY bio;
// вывести тех пользователей кто имеет мин кол лайков
SELECT likes, login, bio, name FROM ubuser WHERE likes = (SELECT MIN(likes) FROM ubuser);
// or
SELECT likes, login, bio, name FROM ubuser WHERE likes IN (SELECT MIN(likes) FROM ubuser);




// Группировка!!!!!!!
//distinct это уникальные значения
SELECT DISTINCT bio FROM user;
// с формулой
select DISTINCT length(login) FROM user

// посчитать сумму
SELECT SUM(credit) FROM ubuser WHERE gender = 'M';
// посчитать сумму в среднем сколько должен один мужик
SELECT AVG(credit) FROM ubuser WHERE gender = 'M';
// можно переименовать строку
SELECT MAX(likes) AS maxLIKES, name FROM ubuser GROUP BY name;


///ОТНОШЕНИЯ!!!!!!!!!!!!!
CREATE TABLE boys (
    -> boy_id INT(2) NOT NULL AUTO_INCREMENT,
    -> boy VARCHAR(50) DEFAULT NULL,
    -> PRIMARY KEY(boy_id));

CREATE TABLE toys (toy_id INT(2) NOT NULL AUTO_INCREMENT, toy VARCHAR(50) DEFAULT NULL, PRIMARY KEY(toy_id));

INSERT INTO boys (boy) VALUES ('David'), ('Max'), ('Vavan'), ('Anton');
INSERT INTO toys (toy) VALUES ('hula hoop'), ('solder'), ('boll'), ('bycicle'), ('stick');

// CORESTION JOIN | CROSS
SELECT b.boy t.toy FROM boys AS b CROSS JOIN toys AS t;
// МОЖНО обьединить таблицу саму на себя
SELECT b1.boy, b2.boy FROM boys AS b1 CROSS JOIN boys AS b2;

CREATE TABLE `boysWithToys` (
`boy_id` int NOT NULL AUTO_INCREMENT,
`boy` varchar(50) DEFAULT NULL,
`toy_id` int DEFAULT NULL,
PRIMARY KEY (`boy_id`));
// находим пользователей и их игрушки с помощью natural
SELECT boysWithToys.boy, toys.toy FROM boysWithToys NATURAL JOIN toys;
//заменяем столбцы
ALTER TABLE toys CHANGE toys_id id INT(2) NOT NULL AUTO_INCRIMENT; // получиться CORESTION JOIN (каждому каждый)
// чтобы этого не произошло надо сделать такую команду
SELECT boysWithToys.boy, toys.toy FROM boysWithToys INNER JOIN toys ON boysWithToys.toy_id = toys.id;
// или можно так
SELECT boysWithToys.boy, toys.toy FROM boysWithToys CROSS JOIN toys ON boysWithToys.toy_id = toys.id;
// или
SELECT boysWithToys.boy, toys.toy FROM boysWithToys JOIN toys ON boysWithToys.toy_id = toys.id;

// комманда LEFT OUTER JOIN добавляет все что слева и совпадения слева
SELECT boysWithToys.boy, toys.toy FROM boysWithToys LEFT OUTER JOIN toys ON boysWithToys.toy_id = toys.id;
// можно без OUTER
SELECT boysWithToys.boy, toys.toy FROM boysWithToys LEFT JOIN toys ON boysWithToys.toy_id = toys.id;
//оманда right join добавляет все что справа и совпадения слева
SELECT boysWithToys.boy, toys.toy FROM boysWithToys RIGHT JOIN toys ON boysWithToys.toy_id = toys.id;

//записи без подчиненных(вывести все игрушки без хозяев)
SELECT boysWithToys.boy, toys.toy FROM boysWithToys RIGHT JOIN toys ON boysWithToys.toy_id = toys.id WHERE boysWithToys.boy IS NULL;
// как узнать у кого нет каких игрушек
SELECT boysWithToys.boy, toys.toy
FROM toys
RIGHT JOIN
boysWithToys
ON boysWithToys.toy_id <> toys.id
ORDER BY boysWithToys.boy;

//FULL в sql не используется
для этого используем UNION
SELECT boysWithToys.boy, toys.toy FROM boysWithToys
    -> LEFT JOIN toys
    -> ON boysWithToys.toy_id = toys.id
    -> UNION
-> SELECT boysWithToys.boy, toys.toy FROM boysWithToys
    -> RIGHT JOIN toys
    -> ON boysWithToys.toy_id = toys.id;

// как сделать таблицу из обьединений
CREATE TABLE boysAndToysCache AS
SELECT boysWithToys.boy, toys.toy
FROM boysWithToys
JOIN toys
ON boysWithToys.toy_id = toys.id;

//создать VIEW ДЛЯ
CREATE VIEW boysAndToysView AS
SELECT boysWithToys.boy, toys.toy
FROM boysWithToys
JOIN toys
ON boysWithToys.toy_id = toys.id;

// КОМАНДЫ, чтобы смотреть как создавалась таблица
SHOW CREATE TABLE name;
SHOW CREATE VIEW name;

//добавить игрушки пользователям
CREATE TABLE boyToToy AS
SELECT boy_id, toy_id FROM boysWithToys WHERE toy_id IS NOT NULL;
INSERT INTO boyToToy VALUES (1, 3), (2, 3), (1, 3), (1, 1);
// вывести на экран мальчиков и их игрушки через обьединение
SELECT boys.boy, toys.toy
FROM boys
JOIN boyToToy
ON boys.boy_id = boyToToy.boy_id
JOIN toys
ON boyToToy.toy_id = toys.id;

//как установить жесткую связь между таблицами с помощью constraint
CREATE TABLE boysWithKeyToys (
    boy_id INT(2) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    boy VARCHAR(50) DEFAULT NULL,
    toy_id INT(2),
    CONSTRAINT constr FOREIGN KEY (toy_id) REFERENCES toys(id)
);
INSERT INTO boysWithKeyToys (boy, toy_id) VALUES ('David', 2), ('Maks', 2
), ('Vlad', 1), ('Anton', NULL);
если попробовать добавить туда ('David', 99) то не получиться



