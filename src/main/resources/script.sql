create table movies(
Title varchar(255)
,Runtime int
,Genre varchar (255)
,IMDB_Score double
,Rating varchar (255)
);

INSERT INTO movies (Title, Runtime, Genre, IMDB_Score, Rating)
VALUES
('Howard the Duck', 110, 'Sci-Fi', 4.6, 'PG'),
('Lavalantula', 83, 'Horror', 4.7, 'TV-14'),
('Starship Troopers', 129, 'Sci-Fi', 7.2, 'PG-13'),
('Waltz With Bashir', 90, 'Documentary', 8.0, 'R'),
('Spaceballs', 96, 'Comedy', 7.1, 'PG'),
('Monsters Inc.', 92, 'Animation', 8.1, 'G');

INSERT INTO movies (Title, Runtime, Genre, IMDB_Score, Rating)
VALUES
('Snatch', 102, 'Comedy', 8.3, 'R')
,('Ad Astra', 123, 'Sci-Fi', 6.5, 'PG-13')
,('No Country for Old Men', 122, 'Crime', 8.2, 'R')
,('Oldboy', 120, 'Action', 8.4, 'R');

select * from movies where genre = 'Sci-Fi';

select * from movies where IMDB_Score >= 6.5;

SELECT * FROM movies WHERE rating = 'G' OR rating = 'PG' AND runtime < 100;

SELECT avg(Runtime), genre FROM movies WHERE IMDB_score < 7.5 GROUP BY Genre;

UPDATE movies SET Rating = 'R' WHERE Runtime = 129;

SELECT id, rating FROM movies WHERE genre = 'Documentary' OR genre = 'Horror';

SELECT AVG(imdb_score) AS avg, MAX(imdb_score) as min, MIN(imdb_score) as min FROM movies
GROUP BY Rating;

SELECT AVG(imdb_score) AS avg, MAX(imdb_score) as min, MIN(imdb_score) as min FROM movies
GROUP BY Rating HAVING COUNT(*) > 1;

DELETE FROM movies WHERE rating = 'R';

