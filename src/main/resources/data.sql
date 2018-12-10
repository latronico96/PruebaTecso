INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('AR','ARGENTINA', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('BR','BRASIL', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('UY','URUGUAY', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('CH','CHILE', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

insert into CUENTA values (1, 'Pesos' , 0 );
insert into CUENTA values (2, 'Pesos' , 0 );
insert into CUENTA values (3, 'Euros' , 0 );
insert into CUENTA values (4, 'Euros' , 0 );
insert into CUENTA values (5, 'Dolares' , 0 );
insert into CUENTA values (6, 'Dolares' , 0 );
insert into CUENTA values (7, 'Dolares' , 0 );
insert into CUENTA values (8, 'Dolares' , 0 );
insert into CUENTA values (9, 'Dolares' , 0 );
insert into CUENTA values (10, 'Euros' , 520.6 );

insert into MOVIMIENTO values ( 01, 'Movimiento 01', parsedatetime('2012-07-01 11:36:35', 'yyyy-MM-dd hh:mm:ss'), 520.6 , 'Haber' , 01 );
insert into MOVIMIENTO values ( 02, 'Movimiento 02', parsedatetime('2012-08-01 11:36:35', 'yyyy-MM-dd hh:mm:ss'), 520.6 , 'Debe' , 01 );
insert into MOVIMIENTO values ( 03, 'Movimiento 03', parsedatetime('2012-09-01 11:36:35', 'yyyy-MM-dd hh:mm:ss'), 520.6 , 'Haber' , 02 );
insert into MOVIMIENTO values ( 04, 'Movimiento 04', parsedatetime('2012-10-01 11:36:35', 'yyyy-MM-dd hh:mm:ss'), 520.6 , 'Debe' , 02 );
insert into MOVIMIENTO values ( 05, 'Movimiento 05', parsedatetime('2012-11-01 11:36:35', 'yyyy-MM-dd hh:mm:ss'), 520.6 , 'Haber' , 03 );
insert into MOVIMIENTO values ( 06, 'Movimiento 06', parsedatetime('2012-12-01 11:36:35', 'yyyy-MM-dd hh:mm:ss'), 520.6 , 'Debe' , 03 );
insert into MOVIMIENTO values ( 07, 'Movimiento 07', parsedatetime('2013-01-01 11:36:35', 'yyyy-MM-dd hh:mm:ss'), 520.6 , 'Haber' , 04 );
insert into MOVIMIENTO values ( 08, 'Movimiento 08', parsedatetime('2013-02-01 11:36:35', 'yyyy-MM-dd hh:mm:ss'), 520.6 , 'Debe' , 04 );
insert into MOVIMIENTO values ( 09, 'Movimiento 09', parsedatetime('2013-03-01 11:36:35', 'yyyy-MM-dd hh:mm:ss'), 520.6 , 'Haber' , 05 );
insert into MOVIMIENTO values ( 10, 'Movimiento 10', parsedatetime('2013-04-01 11:36:35', 'yyyy-MM-dd hh:mm:ss'), 520.6 , 'Debe' , 05 );
insert into MOVIMIENTO values ( 11, 'Movimiento 11', parsedatetime('2013-05-01 11:36:35', 'yyyy-MM-dd hh:mm:ss'), 520.6 , 'Haber' , 06 );
insert into MOVIMIENTO values ( 12, 'Movimiento 12', parsedatetime('2013-06-01 11:36:35', 'yyyy-MM-dd hh:mm:ss'), 520.6 , 'Debe' , 06 );
insert into MOVIMIENTO values ( 13, 'Movimiento 13', parsedatetime('2013-07-01 11:36:35', 'yyyy-MM-dd hh:mm:ss'), 520.6 , 'Haber' , 07 );
insert into MOVIMIENTO values ( 14, 'Movimiento 14', parsedatetime('2013-08-01 11:36:35', 'yyyy-MM-dd hh:mm:ss'), 520.6 , 'Debe' , 07 );
insert into MOVIMIENTO values ( 15, 'Movimiento 15', parsedatetime('2013-09-01 11:36:35', 'yyyy-MM-dd hh:mm:ss'), 520.6 , 'Haber' , 08 );
insert into MOVIMIENTO values ( 16, 'Movimiento 16', parsedatetime('2013-10-01 11:36:35', 'yyyy-MM-dd hh:mm:ss'), 520.6 , 'Debe' , 08 );
insert into MOVIMIENTO values ( 17, 'Movimiento 17', parsedatetime('2013-11-01 11:36:35', 'yyyy-MM-dd hh:mm:ss'), 520.6 , 'Haber' , 09 );
insert into MOVIMIENTO values ( 18, 'Movimiento 18', parsedatetime('2013-12-01 11:36:35', 'yyyy-MM-dd hh:mm:ss'), 520.6 , 'Debe' , 09 );
insert into MOVIMIENTO values ( 19, 'Movimiento 19', parsedatetime('2014-01-01 11:36:35', 'yyyy-MM-dd hh:mm:ss'), 520.6 , 'Haber' , 10 );
