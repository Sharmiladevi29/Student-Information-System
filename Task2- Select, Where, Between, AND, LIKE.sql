use sisdb;

select* from Students;
select* from Courses;
select* from Enrollments;
select* from Teacher;
select* from Payments;

insert into Students (student_id, first_name, last_name, date_of_birth, email, phone_number)  
VALUES(113,'John','Doe','1995-08-15','john.doe@example.com','1234567890');

insert into Enrollments (enrollment_id, student_id, course_id, enrollment_date)
VALUES(413,105,303,'2025-03-18');

update Teacher
set email='wane@gmail.com'
where first_name='Sam';

delete from Enrollments
where student_id=104 and course_id=304;

update Courses
set teacher_id=212
where course_id=303;

select*from Courses WHERE course_id = 303;

delete from Students where student_id=104;

update Payments
set amount=350.00
where payment_id=504;