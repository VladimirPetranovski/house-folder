# for our username and database - username in lowcase, database name in uppercase
// если надо сохранить базу данных под root
# mysqldump JIS4 > jis4_2020-12-08T23.00.00.sql // если root admin
// если надо сохранить бд для пользователя, где jis4 - пользователь, JIS4 - бд, jis4.sql -- файл куда сохранять
max@max:~$ mysqldump -h 127.0.0.1 -u jis4 JIS4 > jis4.sql -p
// можно через пробел указать базы данных данного пользователя JIS12 JIS4 И Т.Д
max@max:~$ mysqldump -h 127.0.0.1 -u jis4 JIS12 JIS4 > severalJisDatabases.sql -p
// а так все БД данного пользователя
max@max:~$ mysqldump -h 127.0.0.1 -u jis4 --all-databases > alldatabases.sql -p
// чтобы восстановить тблицу, нужно снвчала ее удалить, потом создать пустую под этим названием а потом
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