


sudo mysql

SET GLOBAL local_infile=1;

mysql --local-infile=1 -u gasolinera -p

USE GASOLINERA

OAD DATA LOCAL INFILE '/home/javier/gas.sql' INTO TABLE VENTAS FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n' IGNORE 1 ROWS;
