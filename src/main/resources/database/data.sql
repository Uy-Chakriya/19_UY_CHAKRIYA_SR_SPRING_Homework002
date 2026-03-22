
INSERT INTO instructors (instructor_name, email)
VALUES
    ('chakriya', 'chakriya@gmail.com'),
    ('theara', 'theara@gmail.com'),
    ('malis', 'malis@gmail.com'),
    ('phalla', 'phalla@gmail.com'),
    ('sopheavy', 'sopheavy@gmail.com');

INSERT INTO students (student_name, email, phone_number)
VALUES
    ('kaka', 'kaka@gmail.com', '123456781'),
    ('bobo', 'bobo@gmail.com', '123456782'),
    ('lili', 'lili@gmail.com', '123456783'),
    ('arisa', 'arisa@gmail.com', '123456784'),
    ('krrish', 'krrish@gmail.com', '123456785');

INSERT INTO courses (course_name, description, instructor_id)
VALUES
    ('Spring', 'learn for free', 1),
    ('Java', 'learn for free', 2),
    ('IOS', 'learn for free', 3),
    ('Android', 'learn for free', 4);

INSERT INTO student_courses (student_id, course_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 1);
