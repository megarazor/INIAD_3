BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "grade" (
	"student_id"	VARCHAR(10) NOT NULL,
	"course_id"	VARCHAR(10) NOT NULL,
	"score"	INTEGER,
	FOREIGN KEY("course_id") REFERENCES "course" ON DELETE CASCADE ON UPDATE NO ACTION,
	FOREIGN KEY("student_id") REFERENCES "student" ON DELETE CASCADE ON UPDATE NO ACTION,
	PRIMARY KEY("student_id","course_id")
);
CREATE TABLE IF NOT EXISTS "student" (
	"student_id"	VARCHAR(10) NOT NULL,
	"name"	VARCHAR(30),
	"city"	VARCHAR(30),
	"age"	INTEGER,
	PRIMARY KEY("student_id")
);
CREATE TABLE IF NOT EXISTS "course" (
	"course_id"	VARCHAR(10) NOT NULL,
	"course_name"	VARCHAR(50),
	"lecturer"	VARCHAR(30),
	"credit"	INTEGER,
	PRIMARY KEY("course_id")
);
INSERT INTO "grade" VALUES ('S1','J1',75);
INSERT INTO "grade" VALUES ('S1','J2',60);
INSERT INTO "grade" VALUES ('S2','J2',50);
INSERT INTO "grade" VALUES ('S3','J3',90);
INSERT INTO "grade" VALUES ('S3','J4',70);
INSERT INTO "grade" VALUES ('S3','J6',65);
INSERT INTO "grade" VALUES ('S4','J1',50);
INSERT INTO "grade" VALUES ('S4','J2',80);
INSERT INTO "grade" VALUES ('S4','J4',55);
INSERT INTO "grade" VALUES ('S4','J5',75);
INSERT INTO "grade" VALUES ('S4','J6',80);
INSERT INTO "student" VALUES ('S1','Yamada','Kyoto',19);
INSERT INTO "student" VALUES ('S2','Suzuki','Osaka',20);
INSERT INTO "student" VALUES ('S3','Kojima','Nara',22);
INSERT INTO "student" VALUES ('S4','Takeda','Kyoto',18);
INSERT INTO "student" VALUES ('S5','Takagi','Kobe',21);
INSERT INTO "course" VALUES ('J1','Database','Tanaka',4);
INSERT INTO "course" VALUES ('J2','Theory of Computation','Sato',2);
INSERT INTO "course" VALUES ('J3','Hardware','Kobayashi',6);
INSERT INTO "course" VALUES ('J4','Database','Ohno',4);
INSERT INTO "course" VALUES ('J5','OS','Saito',5);
INSERT INTO "course" VALUES ('J6','AI','Tanaka',3);
COMMIT;
