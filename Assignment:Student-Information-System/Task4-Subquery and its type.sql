USE sisdb;

select avg(student_count) as avg_student_per_course
from(
select count(student_id) as student_count
from Enrollments
group by course_id)
as course_enrollments;

select s.student_id,s.first_name,s.last_name,p.amount
from Students s
join Payments p on s.student_id=p.student_id
where p.amount=(select max(amount) from Payments);


select c.course_id, c.course_name, COUNT(e.student_id) AS enrollment_count
from Courses c
join Enrollments e ON c.course_id = e.course_id
group by c.course_id, c.course_name
having COUNT(e.student_id) = (
    select COUNT(student_id) AS max_enrollments
    from Enrollments
    group by course_id
    order by max_enrollments DESC
    limit 1
);

select t.teacher_id, t.first_name, t.last_name, 
       coalesce(sum(p.amount), 0) as total_payments
from teacher t
join courses c on t.teacher_id = c.teacher_id
join enrollments e on c.course_id = e.course_id
join payments p on e.student_id = p.student_id
group by t.teacher_id, t.first_name, t.last_name;


select s.student_id, s.first_name, s.last_name
from students s
join enrollments e on s.student_id = e.student_id
group by s.student_id, s.first_name, s.last_name
having count(e.course_id) = (select count(*) from courses);

select first_name, last_name
from teacher
where teacher_id not in (select teacher_id from courses);

select avg(timestampdiff(year, date_of_birth, curdate())) as average_age
from Students;

select course_id, course_name
from courses
where course_id not in (select course_id from enrollments);


select e.student_id, s.first_name, s.last_name, e.course_id, c.course_name, 
       coalesce((select sum(p.amount) from payments p where p.student_id = e.student_id), 0) as total_payment
from enrollments e
join students s on e.student_id = s.student_id
join courses c on e.course_id = c.course_id;

select s.student_id, s.first_name, s.last_name, count(payment_id) as payment_count
from students s
join payments p on s.student_id = p.student_id
group by student_id, first_name, last_name
having count(payment_id) > 1;

select s.student_id, s.first_name, s.last_name, coalesce(sum(p.amount), 0) as total_payment
from students s
left join payments p on s.student_id = p.student_id
group by s.student_id, s.first_name, s.last_name;

select c.course_name, count(e.student_id) as student_count
from courses c
left join enrollments e on c.course_id = e.course_id
group by c.course_name;

select s.student_id, s.first_name, s.last_name, avg(p.amount) as average_payment
from students s
join payments p on s.student_id = p.student_id
group by s.student_id, s.first_name, s.last_name;
