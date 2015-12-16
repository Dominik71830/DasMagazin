create database if not exists baza;

use baza;

drop table if exists produkty;
drop table if exists formularzedetal;
drop table if exists logi;
drop table if exists formularzewysylkowe;
drop table if exists samochody;
drop table if exists miejsca_docelowe;

create table produkty
(
id int NOT NULL AUTO_INCREMENT,
nazwa Varchar(30) NOT NULL,
ilosc int NOT NULL,
vat float NOT NULL,
cena float NOT NULL,
kategoria Varchar(15) NOT NULL,
objetosc float NOT NULL,
PRIMARY KEY (id)
)
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (1,'Czekolada Milka',100,0.08, 2.99, 'spożywcze',0.08);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (2,'Baton Twix',30,0.23,1.49, 'spożywcze',0.05);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (3,'Chleb Baltanowski', 20,0.05, 1.39, 'spożywcze',0.7);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (4, 'Woda niegazowana Cisowianka', 18,0.05, 0.99, 'spożywcze',1.5);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (5, 'Woda gazowana Cisowianka', 18,0.05, 1.39, 'spożywcze',1.5);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (6, 'Maslo Smakowita', 15,0.05, 3.49, 'spożywcze',0.3);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (7, 'Margaryna Kasia', 15,0.05, 2.49, 'spożywcze',0.25);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (8, 'Ser topiony Hochland', 30,0.08, 1.79, 'spożywcze',0.15);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (9, 'Mleko Łaciate', 30,0.05, 1.99, 'spożywcze',1.0);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (10, 'Bułki', 50,0.05, 0.39, 'spożywcze',0.03);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (11, 'Krzesło Verossi', 20, 0.23,149.99, 'meble',3.5);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (12, 'Stołek Marius', 30,0.23, 39.99, 'meble',2.0);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (13, 'Biurko Sonoma', 10,0.23, 359.99, 'meble',30.0);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (14, 'Komoda Olcha', 15,0.23, 449.99, 'meble',150.0);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (15, 'Półka na ściane Sonoma', 35,0.23, 69.99, 'meble',20.0);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (16, 'Stół Granas', 15,0.23, 349.99, 'meble',70.0);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (17, 'Łóżko Select hilding', 5,0.23, 959.99, 'meble',180.0);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (18, 'Kanapa Madryt3', 6,0.23, 1199.99, 'meble',90.0);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (19, 'Szuflada Gotland', 40,0.23, 29.99, 'meble',1.5);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (20, 'Lustro Venge', 25,0.23, 239.99, 'meble',10.0);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (21, 'Proszek do prania Ajax', 150,0.23, 49.99, 'przemysłowe',5.0);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (22, 'Płyn do mycia naczyń Perła', 150,0.08, 12.99, 'przemysłowe',1.5);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (23, 'Gąbka', 250,0.23, 0.99, 'przemysłowe',0.03);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (24, 'Płyn do płukania Pervoll', 150,0.08, 24.99, 'przemysłowe',1.5);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (25, 'Płyn do mycia szyb Mr muscle', 150,0.08, 16.99, 'przemysłowe',0.75);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (26, 'Płyn do podłóg Ajax', 200,0.08, 11.99, 'przemysłowe',1.5);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (27, 'Proszek do prania Vizir', 250,0.08, 24.99, 'przemysłowe',25.0);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (28, 'Proszek do prania Vanish', 250,0.08, 32.99, 'przemysłowe',10.0);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (29, 'Mydło Biały Jeleń', 350,0.08, 2.59, 'przemysłowe',0.1);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (30, 'Szampon do włosów Schauma', 200,0.08, 12.99, 'przemysłowe',1.0);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (31, 'Świetlówka Led 5W/E14 kula', 150,0.23, 12.99, 'elektroniczne',4.0);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (32, 'Świetlówka, Led 5W/E27 kula', 150,0.23, 13.99, 'elektroniczne',4.0);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (33, 'Bateria Vipow', 400,0.23, 1.85, 'elektroniczne',0.05);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (34, 'Bluetooth USB', 120,0.23, 6.99, 'elektroniczne',0.01);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (35, 'Złączka SVGA(D-Sub)', 200, 0.23,7.99, 'elektroniczne',0.02);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (36, 'Wentylator Revoltec', 50,0.23, 11.99, 'elektroniczne',0.02);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (37, 'Mysz optyczna Simple', 30,0.23, 10.99, 'elektroniczne',0.08);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (38, 'Mysz optyczna Marvell', 30, 0.23,12.99, 'elektroniczne',0.08);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (39, 'Odkurzacz USB', 50,0.23, 4.99, 'elektroniczne',0.04);
insert into produkty (id, nazwa, ilosc, vat, cena, kategoria,objetosc) values (40, 'Odtwarzacz mp3', 50, 0.23,29.99, 'elektroniczne',0.03);

create table formularzedetal
(
id int NOT NULL AUTO_INCREMENT,
imie Varchar(20) NOT NULL,
nazwisko Varchar(40) NOT NULL,
produkty Varchar(500) NOT NULL,
cena float NOT NULL,
data_dodania timestamp, 
primary key (id)
)
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into formularzedetal (id, imie, nazwisko, produkty, cena, data_dodania) values (1, 'Łukasz', 'Cieślak', 
'Bateria Vipow			1	1.85
Baton Twix			2	2.98
 ' ,3.50, '2011-06-30 23:43:07');
insert into formularzedetal (id, imie, nazwisko, produkty, cena, data_dodania) values (2, 'Jan', 'Kowalski', 
'Woda niegazowana Cisowianka	2	1.98
Szampon do włosów Schauma		1	12.99
Mysz optyczna Simple		3	32.97
 ' ,47.94, '2015-03-14 23:43:07');
insert into formularzedetal (id, imie, nazwisko, produkty, cena, data_dodania) values (3, 'Andrzej', 'Nowak', 
'Bułki			2	0.78
Margaryna Kasia		3	7.47
Maslo Smakowita		1	3.49
Szampon do włosów Schauma		4	51.96
Woda gazowana Cisowianka		1	1.39
Świetlówka Led 5W/E14 kula		4	51.96
Stół Granas			3	1049.97
Łóżko Select hilding		1	959.99
Czekolada Milka		4	11.96
Krzesło Verossi			2	299.98
Gąbka			1	0.99
 ' ,1379.97, '2014-01-05 05:43:07');

create table logi
(
id int NOT NULL AUTO_INCREMENT,
data_powstania TIMESTAMP NOT NULL,
akcja Varchar(30) NOT NULL,
produkt_id int NOT NULL,
primary key (id)
)
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table formularzewysylkowe 
(
id int not NULL AUTO_INCREMENT,
miejsce_docelowe varchar(50) NOT NULL,
produkty varchar(500) NOT NULL,
samochod varchar(20) NOT NULL,
cena float NOT NULL,
data_dodania timestamp,
primary key(id)
)
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into formularzewysylkowe (id, miejsce_docelowe, produkty, samochod, cena, data_dodania) values (1, 'Kaufland, Żeromskiego 47', 'Bluetooth USB			100	699.0
Czekolada Milka		20	59.8
Mydło Biały Jeleń		111	287.49
Stołek Marius			3	119.97
Złączka SVGA(D-Sub)		100	799.0
Łóżko Select hilding		2	1919.98
 ', 'Fiat Ducato', 3885.24 , '2015-12-16 14:53:51');
insert into formularzewysylkowe (id, miejsce_docelowe, produkty, samochod, cena, data_dodania) values (2, 'InterMarche, Lotnicza 45','Bateria Vipow			20	37.0
Biurko Sonoma			1	359.99
 ', 'FSC Żuk', 396.99,'2015-12-16 14:48:31'); 



create table samochody
(
id int NOT NULL AUTO_INCREMENT,
model Varchar(40) NOT NULL,
nr_rejestracyjny Varchar(9) NOT NULL,
ladownosc float NOT NULL,
czy_jest_na_stanie boolean,
primary key(id)
)
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into samochody (id, model, nr_rejestracyjny, ladownosc, czy_jest_na_stanie) values (1, 'Ford Tranzit', 'EZG234D3', 1477, 1);
insert into samochody (id, model, nr_rejestracyjny, ladownosc, czy_jest_na_stanie) values (2, 'Fiat Ducato' , 'EL234543', 1800, 1);
insert into samochody (id, model, nr_rejestracyjny, ladownosc, czy_jest_na_stanie) values (3, 'Citroën Jumper', 'EZG23454', 2000, 0);
insert into samochody (id, model, nr_rejestracyjny, ladownosc, czy_jest_na_stanie) values (4, 'FSC Żuk' , 'EPA63472', 800, 1);
insert into samochody (id, model, nr_rejestracyjny, ladownosc, czy_jest_na_stanie) values (5, 'MAN F2000', 'EPD94562', 15700, 0);
insert into samochody (id, model, nr_rejestracyjny, ladownosc, czy_jest_na_stanie) values (6, 'Scania serii 4', 'EL45623',20000,1);
insert into samochody (id, model, nr_rejestracyjny, ladownosc, czy_jest_na_stanie) values (7, 'Daf XF','EZG76456',21000,0);
insert into samochody (id, model, nr_rejestracyjny, ladownosc, czy_jest_na_stanie) values (8, 'Ford Tranzit', 'EPA29548', 1477,0);
insert into samochody (id, model, nr_rejestracyjny, ladownosc, czy_jest_na_stanie) values (9, 'Citroën Jumper','EL76592', 2000, 1);
insert into samochody (id, model, nr_rejestracyjny, ladownosc, czy_jest_na_stanie) values (10, 'Fiat Ducato', 'EZG20473', 1800, 0);

create table miejsca_docelowe
(
id int NOT NULL AUTO_INCREMENT,
adres varchar(100) NOT NULL,
odleglosc int NOT NULL,
primary key(id)
)
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into miejsca_docelowe (id, adres, odleglosc) values (1, 'Tesco, Wyszyńskiego 15', 45);
insert into miejsca_docelowe (id, adres, odleglosc) values (2, 'Biedronka, Południowa 10', 30);
insert into miejsca_docelowe (id, adres, odleglosc) values (3, 'InterMarche, Lotnicza 45', 120);
insert into miejsca_docelowe (id, adres, odleglosc) values (4, 'Lidl, Łódzka 30', 46);
insert into miejsca_docelowe (id, adres, odleglosc) values (5, 'Tesco, Zgierska 89', 70);
insert into miejsca_docelowe (id, adres, odleglosc) values (6, 'Polo Market, Piłsudskiego 65', 95);
insert into miejsca_docelowe (id, adres, odleglosc) values (7, 'Tesco, Woronicza 17', 34);
insert into miejsca_docelowe (id, adres, odleglosc) values (8, 'Kurczaczek, Lumumby 3', 10);
insert into miejsca_docelowe (id, adres, odleglosc) values (9, 'Biedronka, Tamka 9', 67);
insert into miejsca_docelowe (id, adres, odleglosc) values (10, 'Kaufland, Żeromskiego 47', 87);