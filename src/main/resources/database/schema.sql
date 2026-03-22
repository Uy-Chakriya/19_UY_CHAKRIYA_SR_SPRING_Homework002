drop table if exists student_courses;
drop table if exists courses;
drop table if exists students;
drop table if exists instructors;

create table if not exists instructors(
                                          instructor_id serial primary key,
                                          instructor_name varchar(100) not null,
                                          email varchar(50) unique not null
);
create table if not exists students(
                                       student_id serial primary key,
                                       student_name varchar(100) not null,
                                       email varchar(50) unique not null,
                                       phone_number varchar(10)
);
create table if not exists courses(
                                      course_id serial primary key,
                                      course_name varchar(100) not null,
                                      description text,
                                      instructor_id int,
                                      foreign key (instructor_id)
                                          references instructors(instructor_id)
                                          on delete set null
);
create table if not exists student_courses(
                                              student_id int,
                                              course_id int,
                                              primary key (student_id, course_id),
                                              foreign key (student_id) references students(student_id) on delete cascade,
                                              foreign key (course_id) references courses(course_id) on delete cascade -- Add this line
);