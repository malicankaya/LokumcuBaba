create database lokumcubaba;
use lokumcubaba;
create table bayibasvurular (
	id int not null auto_increment primary key,
    ad_soyad varchar(50) not null,
    tckimlik varchar(11) not null,
    adres varchar(350) not null,
    telefon varchar(11) not null,
    eposta varchar(100) not null,
    dogum_tarihi varchar(50) not null,
    s1 bool not null,
    s2 varchar(300),
    s3 varchar(300) not null,
    s4 varchar(10) not null,
    s5 varchar(300)
)