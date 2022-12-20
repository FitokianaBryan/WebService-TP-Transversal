create sequence sqadmin;
create sequence sqtokenadmin;


create table Admin(
idAdmin  varchar(10) primary key not null default 'admin'||nextval('sqadmin'),
users varchar(30),
mdp varchar(10)
);

insert into Admin(users,mdp) values ('hardi@gmail.com','hardi');
insert into Admin(users,mdp) values ('anjary@gmail.com','anjary');
insert into Admin(users,mdp) values ('bryan@gmail.com','bryan');


create table Avion(
idavion serial primary key not null,
nomavion varchar(30),
capacite int,
envergue int,
hauteur int,
masse_au_decollage int,
vitesse_de_croisiere int,
vitesse_max int,
rayon_max int,
capacite_kerosene int,
photo text default 'vide.png'
);


INSERT INTO Avion (nomavion, capacite, envergue, hauteur, masse_au_decollage, vitesse_de_croisiere, vitesse_max, rayon_max, capacite_kerosene)
VALUES
('Boeing 747', 400, 68.5, 19.3, 441000, 913, 945, 8700, 238000),
('Airbus A380', 853, 79.8, 24.1, 580000, 828, 928, 8500, 538000),
('Boeing 787 Dreamliner', 290, 60.1, 17.7, 356000, 913, 945, 7400, 186000),
('Bombardier CRJ700', 70, 30.9, 7.5, 32000, 614, 659, 2300, 7400),
('Embraer E190', 110, 35.1, 9.5, 40000, 614, 659, 2500, 8800);



create table EntretienAvion(
idavion int references Avion(idavion),
dateEntretien date,
description varchar(50),
cout double precision
);
INSERT INTO EntretienAvion (idavion, dateEntretien, description, cout) VALUES (1, '2022-01-01', 'Entretien annuel', 1000);
INSERT INTO EntretienAvion (idavion, dateEntretien, description, cout) VALUES (2, '2022-02-01', 'Remplacement des pneus', 500);
INSERT INTO EntretienAvion (idavion, dateEntretien, description, cout) VALUES (3, '2022-03-01', 'Contrôle de lavionique', 2000);


CREATE TABLE AssuranceAvion (
  idavion int REFERENCES Avion(idavion),
  dateDebut date NOT NULL,
  dateFin date NOT NULL,
  montant double precision NOT NULL,
  type varchar(50) NOT NULL
);
INSERT INTO AssuranceAvion (idavion, dateDebut, dateFin, montant, type) VALUES (1, '2022-01-01', '2022-12-31', 5000, 'annuelle');
INSERT INTO AssuranceAvion (idavion, dateDebut, dateFin, montant, type) VALUES (2, '2022-01-01', '2023-12-31', 10000, 'biennale');
INSERT INTO AssuranceAvion (idavion, dateDebut, dateFin, montant, type) VALUES (3, '2022-01-01', '2024-12-31', 15000, 'triennale');


create table Mouvement(
idavion int references Avion(idavion),
dateDepart timestamp,
dateArrivee timestamp,
lieu_depart varchar(20),
lieu_arrivee varchar(20),
kilometrage_effectuer int
);

INSERT INTO Mouvement (idavion, dateDepart, dateArrivee, lieu_depart, lieu_arrivee, kilometrage_effectuer)
VALUES (1, '2022-01-01 10:00:00', '2022-01-01 11:00:00', 'Paris', 'Marseille', 500);

INSERT INTO Mouvement (idavion, dateDepart, dateArrivee, lieu_depart, lieu_arrivee, kilometrage_effectuer)
VALUES (2, '2022-01-02 15:00:00', '2022-01-02 16:00:00', 'Londres', 'Edimbourg', 200);

INSERT INTO Mouvement (idavion, dateDepart, dateArrivee, lieu_depart, lieu_arrivee, kilometrage_effectuer)
VALUES (3, '2022-01-03 09:00:00', '2022-01-03 10:00:00', 'New York', 'Chicago', 800);

INSERT INTO Mouvement (idavion, dateDepart, dateArrivee, lieu_depart, lieu_arrivee, kilometrage_effectuer)
VALUES (4, '2022-01-04 14:00:00', '2022-01-04 15:00:00', 'Sydney', 'Melbourne', 300);

INSERT INTO Mouvement (idavion, dateDepart, dateArrivee, lieu_depart, lieu_arrivee, kilometrage_effectuer)
VALUES (5, '2022-01-05 11:00:00', '2022-01-05 12:00:00', 'Tokyo', 'Osaka', 400);


create table tokenAdmin(
idtokenadmin varchar(10) primary key not null default 'token'||nextval('sqtokenadmin'),
idadmin varchar(30) references Admin(idadmin),
token varchar(100),
datecreation date,
dateexpiration date,
role varchar(10)
);
