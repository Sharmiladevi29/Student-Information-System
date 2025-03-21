use sisdb;
select * from Students;

select s.student_id, s.first_name, s.last_name, SUM(p.amount) AS total_payments
from Students s
join Payments p ON s.student_id = p.student_id
where s.student_id = 105 
group by s.student_id, s.first_name, s.last_name;

select c.course_id, c.course_name, COALESCE(COUNT(e.student_id), 0) AS student_count
from Courses c
left join Enrollments e ON c.course_id = e.course_id
group by c.course_id, c.course_name
order by student_count DESC;

select first_name,last_name 
from Students s
left join Enrollments e
on s.student_id=e.student_id
where e.student_id is null;

select s.first_name,s.last_name,c.course_name
from Students s
join Enrollments e on s.student_id=e.student_id
join courses c on c.course_id=e.course_id
order by s.first_name,s.last_name;

select t.first_name,t.last_name,c.course_name
from Teacher t
join Courses c on t.teacher_id=c.teacher_id;

select s.student_id,s.first_name,s.last_name,e.enrollment_date
from Students s
join Enrollments e on s.student_id=e.student_id
join Courses c on c.course_id=e.course_id
where course_name='Physics';


alter TABLE Payments MODIFY amount DECIMAL(10,2) NULL;

update Payments  
SET amount = NULL  
WHERE payment_id IN (507, 508);

select s.first_name,s.last_name
from Students s
left join Payments p on s.student_id=p.student_id
where p.amount is null;

select c.course_id,c.course_name
from Courses c
left join Enrollments e on c.course_id=e.course_id
where e.enrollment_id is null;

select e.student_id, s.first_name, s.last_name, COUNT(e.course_id) AS course_count
from Enrollments e
join Students s ON e.student_id = s.student_id
group by e.student_id, s.first_name, s.last_name
having COUNT(e.course_id) > 1;

select t.teacher_id,t.first_name,t.last_name
from Teacher t
left join Courses c on t.teacher_id=c.teacher_id
where c.course_id is null;