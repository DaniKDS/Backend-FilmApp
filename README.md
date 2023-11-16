# Backend-FilmApp

## Description

### server.port=8083 in application.properties

<img width="894" alt="image" src="https://github.com/DaniKDS/MovieMatch-Backend/assets/91533585/6a2c1955-2576-4fb7-86f6-b985323bc861">

<img width="934" alt="image" src="https://github.com/DaniKDS/MovieMatch-Backend/assets/91533585/edf4643b-77f8-4b57-aa8d-48cb2caadbc9">

<img width="892" alt="image" src="https://github.com/DaniKDS/MovieMatch-Backend/assets/91533585/6497c5e1-4543-405b-b352-69878f7ad63b">
#dupa ce v-ati conectat la baza de date si cumva pusca, va rog dati drop , o creati din nou si rulati proiectul ! 
#drop database ProiectColectiv1

#CREATE DATABASE ProiectColectiv1

#use ProiectColectiv1

-- Inserare în tabela Film cu coloanele în altă ordine (excludem coloana id_film)
INSERT INTO Film (descriere, durata, gen, imagine_film, titlu)
VALUES
('Thrilling sci-fi', '148 min', 'SF', 0x01010101, 'Inception'),
('Redemption in prison', '142 min', 'Drama', 0x02020202, 'The Shawshank Redemption'),
('Batman fights crime', '152 min', 'Action', 0x03030303, 'The Dark Knight'),
('Non-linear storytelling', '154 min', 'Crime', 0x04040404, 'Pulp Fiction'),
('Mafia family drama', '175 min', 'Crime', 0x05050505, 'The Godfather'),
('Epic fantasy adventure', '201 min', 'Fantasy', 0x06060606, 'The Lord of the Rings: The Fellowship of the Ring'),
('Coming-of-age drama', '126 min', 'Drama', 0x07070707, 'The Breakfast Club'),
('Mind-bending thriller', '113 min', 'Mystery', 0x08080808, 'Memento'),
('Heartwarming animation', '96 min', 'Animation', 0x09090909, 'Toy Story'),
('Classic romantic comedy', '95 min', 'Romance', 0x10101010, 'When Harry Met Sally');



-- Inserare în tabela Utilizator (eliminăm coloana id_utilizator)
INSERT INTO Utilizator (email, nume, prenume, username)
VALUES
('ion.popescu@email.com', 'Popescu', 'Ion', 'ion.popescu'),
('ana.ionescu@email.com', 'Ionescu', 'Ana', 'ana.ionescu'),
('mihai.radu@email.com', 'Radu', 'Mihai', 'mihai.radu'),
('elena.stoica@email.com', 'Stoica', 'Elena', 'elena.stoica'),
('alex.dumitru@email.com', 'Dumitru', 'Alex', 'alex.dumitru'),
('laura.maria@email.com', 'Maria', 'Laura', 'laura.maria'),
('cristian.ion@email.com', 'Ion', 'Cristian', 'cristian.ion'),
('andreea.popa@email.com', 'Popa', 'Andreea', 'andreea.popa'),
('george.moldovan@email.com', 'Moldovan', 'George', 'george.moldovan'),
('simona.neagu@email.com', 'Neagu', 'Simona', 'simona.neagu');



-- Inserare în tabela Prietenie (eliminăm coloana id_prietenie)
INSERT INTO Prietenie (id_utilizator1, id_utilizator2)
VALUES
(1, 2),
(2, 3),
(3, 4),
(4, 5),
(5, 1),
(1, 3),
(2, 4),
(3, 5),
(4, 1),
(5, 2);


-- Inserare în tabela Pereche (eliminăm coloana id_pereche)
INSERT INTO Pereche (id_film, id_utilizator)
VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 1),
(7, 2),
(8, 3),
(9, 4),
(10, 5);


-- Afișare conținut tabela Film
SELECT * FROM Film;

-- Afișare conținut tabela Utilizator
SELECT * FROM Utilizator;

-- Afișare conținut tabela Prietenie
SELECT * FROM Prietenie;

-- Afișare conținut tabela Pereche
SELECT * FROM Pereche;




