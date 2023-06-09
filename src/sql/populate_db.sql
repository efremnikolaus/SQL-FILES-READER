INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES
    ('John Doe', '1990-01-01', 'Trainee', 800),
    ('Jane Smith', '1985-05-10', 'Junior', 1200),
    ('Michael Johnson', '1982-09-15', 'Middle', 3000),
    ('Emily Williams', '1978-03-20', 'Senior', 6000),
    ('David Brown', '1992-07-05', 'Trainee', 900),
    ('Sarah Davis', '1991-12-12', 'Junior', 1500),
    ('Daniel Wilson', '1988-06-25', 'Middle', 3500),
    ('Olivia Miller', '1980-10-18', 'Senior', 7000),
    ('James Anderson', '1993-04-30', 'Junior', 1300),
    ('Sophia Taylor', '1987-08-08', 'Senior', 5500);

INSERT INTO client (NAME)
VALUES
    ('Client A'),
    ('Client B'),
    ('Client C'),
    ('Client D'),
    ('Client E');

INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE)
VALUES
    (1, '2022-01-01', '2022-05-31'),
    (2, '2022-03-15', '2023-01-31'),
    (3, '2022-06-01', '2022-09-30'),
    (4, '2022-08-01', '2023-04-30'),
    (5, '2022-11-15', '2023-06-30'),
    (1, '2023-02-01', '2023-06-30'),
    (3, '2023-03-15', '2023-12-31'),
    (2, '2023-05-01', '2023-09-30'),
    (4, '2023-08-01', '2024-02-29'),
    (5, '2023-11-15', '2024-06-30');

INSERT INTO project_worker (PROJECT_ID, WORKER_ID)
VALUES
    (1, 1),
    (1, 2),
    (2, 3),
    (3, 4),
    (4, 5),
    (4, 6),
    (4, 7),
    (5, 8),
    (5, 9),
    (5, 10),
    (6, 2),
    (7, 3),
    (7, 5),
    (8, 1),
    (8, 4),
    (9, 6),
    (9, 7),
    (9, 9),
    (9, 10),
    (10, 2),
    (10, 4);

INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES
    ('Jennifer Lee', '1994-02-15', 'Trainee', 950),
    ('Christopher Clark', '1989-09-05', 'Junior', 1400),
    ('Ava Hernandez', '1990-06-20', 'Middle', 3200),
    ('Matthew Young', '1983-12-12', 'Senior', 6500),
    ('Emma Scott', '1995-05-25', 'Junior', 1100);

INSERT INTO project_worker (PROJECT_ID, WORKER_ID)
VALUES
    (6, 11),
    (6, 12),
    (7, 13),
    (8, 14),
    (10, 15);