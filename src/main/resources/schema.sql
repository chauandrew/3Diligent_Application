CREATE TABLE Students (
    sid         integer PRIMARY KEY,
    name        varchar(64)
);

CREATE TABLE Guardians (
    gid         integer PRIMARY KEY,
    name        varchar(64)
);

CREATE TABLE Relationships (
    sid         integer REFERENCES Students(sid),
    gid         integer REFERENCES Guardians(gid),
    CONSTRAINT pkey_sid_gid PRIMARY KEY (sid, gid)
);

CREATE TABLE Courses (
    cid         integer PRIMARY KEY,
    subject     varchar(64),
    title       varchar(64)
);

CREATE type grade_t as enum('A', 'B', 'C', 'D', 'F');

CREATE TABLE Transcript (
    sid         integer REFERENCES Students(sid),
    cid         integer REFERENCES Courses(cid),
    grade       grade_t,
    CONSTRAINT pkey_sid_cid PRIMARY KEY (sid, cid)
);

