create table if not exists instructors(
    instructor_id serial primary key,
    instructor_name varchar(100),
    email varchar(50)
);

create table if not exists students(
    student_id serial primary key not null ,
    student_name varchar(100) not null ,
    email varchar(50) not null ,
    phone_number int not null
);

create table if not exists courses(
    course_id serial primary key not null ,
    course_name varchar(100) not null ,
    description varchar(120) not null ,
    instructorId int not null
);










