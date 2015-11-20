create database if not exists baza;

use baza;

drop table if exists produkty;
drop table if exists klienci;
drop table if exists auta;

create table produkty
(
id int NOT NULL AUTO_INCREMENT,
nazwa Varchar(30) NOT NULL,
ilosc int NOT NULL,
vat float NOT NULL,
cena float NOT NULL,
kategoria Varchar(15) NOT NULL,
PRIMARY KEY (id)
)
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (1,'Czekolada Milka',10,0.08, 2.99, 'spożywcze');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (2,'Baton Twix',30,0.23,1.49, 'spożywcze');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (3,'Chleb Baltanowski', 20,0.05, 1.39, 'spożywcze');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (4, 'Woda niegazowana Cisowianka', 18,0.05, 0.99, 'spożywcze');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (5, 'Woda gazowana Cisowianka', 18,0.05, 1.39, 'spożywcze');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (6, 'Maslo Smakowita', 15,0.05, 3.49, 'spożywcze');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (7, 'Margaryna Kasia', 15,0.05, 2.49, 'spożywcze');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (8, 'Ser topiony Hochland', 30,0.08, 1.79, 'spożywcze');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (9, 'Mleko Łaciate', 30,0.05, 1.99, 'spożywcze');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (10, 'Bułki', 50,0.05, 0.39, 'spożywcze');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (11, 'Krzesło Verossi', 20, 0.23,149.99, 'meble');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (12, 'Stołek Marius', 30,0.23, 39.99, 'meble');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (13, 'Biurko Sonoma', 10,0.23, 359.99, 'meble');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (14, 'Komoda Olcha', 15,0.23, 449.99, 'meble');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (15, 'Półka na ściane Sonoma', 35,0.23, 69.99, 'meble');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (16, 'Stół Granas', 15,0.23, 349.99, 'meble');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (17, 'Łóżko Select hilding', 5,0.23, 959.99, 'meble');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (18, 'Kanapa Madryt3', 6,0.23, 1199.99, 'meble');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (19, 'Szuflada Gotland', 40,0.23, 29.99, 'meble');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (20, 'Lustro Venge', 25,0.23, 239.99, 'meble');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (21, 'Proszek do prania Ajax', 150,0.23, 49.99, 'przemysłowe');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (22, 'Płyn do mycia naczyń Perła', 150,0.08, 12.99, 'przemysłowe');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (23, 'Gąbka', 250,0.23, 0.99, 'przemysłowe');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (24, 'Płyn do płukania Pervoll', 150,0.08, 24.99, 'przemysłowe');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (25, 'Płyn do mycia szyb Mr muscle', 150,0.08, 16.99, 'przemysłowe');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (26, 'Płyn do podłóg Ajax', 200,0.08, 11.99, 'przemysłowe');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (27, 'Proszek do prania Vizir', 250,0.08, 24.99, 'przemysłowe');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (28, 'Proszek do prania Vanish', 250,0.08, 32.99, 'przemysłowe');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (29, 'Mydło Biały Jeleń', 350,0.08, 2.59, 'przemysłowe');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (30, 'Szampon do włosów Schauma', 200,0.08, 12.99, 'przemysłowe');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (31, 'Świetlówka Led 5W/E14 kula', 150,0.23, 12.99, 'elektroniczne');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (32, 'Świetlówka, Led 5W/E27 kula', 150,0.23, 13.99, 'elektroniczne');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (33, 'Bateria Vipow', 400,0.23, 1.85, 'elektroniczne');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (34, 'Bluetooth USB', 120,0.23, 6.99, 'elektroniczne');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (35, 'Złączka SVGA(D-Sub)', 200, 0.23,7.99, 'elektroniczne');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (36, 'Wentylator Revoltec', 50,0.23, 11.99, 'elektroniczne');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (37, 'Mysz optyczna Simple', 30,0.23, 10.99, 'elektroniczne');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (38, 'Mysz optyczna Marvell', 30, 0.23,12.99, 'elektroniczne');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (39, 'Odkurzacz USB', 50,0.23, 4.99, 'elektroniczne');
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria) values (40, 'Odtwarzacz mp3', 50, 0.23,29.99, 'elektroniczne');

/*create table klienci
(
id int NOT NULL AUTO_INCREMENT,
Imie Varchar(20) NOT NULL,
Nazwisko Varchar(40) NOT NULL,
Ulica Varchar(20) NOT NULL,
Nr_lokalu Int NOT NULL,
Miejscowosc Varchar(30) NOT NULL,
Kod_pocztowy Varchar(6) NOT NULL,
Telefon Int(9) NOT NULL,
Email Varchar(30),
Nazwa_sklepu Varchar(40)
)
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



create table auta
(
id int NOT NULL AUTO_INCREMENT,
Marka Varchar(15) NOT NULL,
Model Varchar(15) NOT NULL,
Nr_rejestracyjny Varchar(9) NOT NULL,
Czy_jest_na_stanie boolean
)
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
"/