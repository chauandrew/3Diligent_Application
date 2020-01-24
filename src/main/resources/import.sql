

DELETE FROM Students;
DELETE FROM Guardians;
DELETE FROM Relationships;
DELETE FROM Courses;
DELETE FROM Transcript;

INSERT INTO Students(sid, name)
VALUES
    (1, 'Andrew'),
    (2, 'Howard'),
    (3, 'Eric'),
    (4, 'Jeff'),
    (5, 'Sara'),
    (6, 'Kayla'),
    (7, 'Farrah'),
    (8, 'Winston'),
    (9, 'Sean'),
    (10, 'Julian');

INSERT INTO Guardians(gid, name)
VALUES
    (1, 'Bob'),
    (2, 'Jocelyn');

INSERT INTO Relationships(sid, gid)
VALUES
    (1, 1), (2, 1), (3, 1), (4, 1),
    (5, 2), (6, 2), (7, 2), (8, 1),
    (9, 1), (10, 1);

INSERT INTO Courses(cid, subject, title)
VALUES
    (1, 'Computer_Science', 'Data_Structures'),
    (2, 'Computer_Science', 'Computer_Architecture'),
    (3, 'Math', 'Calculus'),
    (4, 'Math', 'Linear_Algebra'),
    (5, 'Statistics', 'Probability'),
    (6, 'Statistics', 'Markov_Models');

INSERT INTO Transcript(sid, cid, grade)
VALUES
    (1,1,'A'),
    (1,2,'A'),
    (1,3,'B'),
    (2,2,'B'),
    (2,5,'B'),
    (2,1,'A'),
    (3,1,'C'),
    (4,1,'D'),
    (5,1,'B'),
    (6,1,'A');


