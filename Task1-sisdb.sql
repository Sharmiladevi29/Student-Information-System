create database sisdb;
use sisdb;

create database sisdb;
use sisdb;

create table Students(
 student_id int primary key ,
 first_name varchar(50) not null,
 last_name varchar(50) not null,
 date_of_birth date not null,
 email varchar(100) unique not null,
 phone_number varchar(15) unique not null
 );
 
 create table Teacher (
   teacher_id int primary key ,
   first_name varchar(50) not null,
   last_name varchar(50) not null,
   email varchar(100) unique not null 
   );
   
create table Courses(
	course_id int primary key ,
	course_name varchar(50) not null,
    credits int check(credits>0),
	teacher_id int,
	foreign key(teacher_id) references Teacher(teacher_id) on delete set null
	);
      
	create table Enrollments (
	   enrollment_id int primary key ,
	   student_id int,
	   course_id int,
	   enrollment_date date not null,
	   foreign key(student_id) references Students(student_id) on delete cascade,
	   foreign key(course_id) references Courses(course_id) on delete cascade
	);
         
	create table Payments(
		payment_id int primary key ,
		student_id int,
		amount decimal(10,2) not null check(amount>0),
		payment_date date not null,
		foreign key(student_id) references Students(student_id) on delete cascade
		);
        
	insert into Students (student_id, first_name, last_name, date_of_birth, email, phone_number) VALUES
    (101, 'Alice', 'Brown', '1999-11-30', 'alice@gmail.com', '9874659867'),
    (102, 'Charlie', 'Williams', '2000-12-03', 'charlie@gmail.com', '8938476356'),
    (103, 'Bob', 'Jay', '2002-03-29', 'bob@gmail.com', '8245658809'),
    (104, 'John', 'Doe', '1997-05-15', 'john@gmail.com', '9342765541'),
    (105, 'Jane', 'Smith', '1998-07-19', 'jane@gmail.com', '8975631097'),
    (106, 'Emma', 'Johnson', '2001-06-21', 'emma@gmail.com', '9123456789'),
    (107, 'Liam', 'Anderson', '2003-09-14', 'liam@gmail.com', '9234567890'),
    (108, 'Olivia', 'Martinez', '2000-02-10', 'olivia@gmail.com', '9345678901'),
    (109, 'Noah', 'Wilson', '1999-08-25', 'noah@gmail.com', '9456789012'),
    (110, 'Sophia', 'Taylor', '2002-04-05', 'sophia@gmail.com', '9567890123'),
    (111, 'Mason', 'Thomas', '1998-11-12', 'mason@gmail.com', '9678901234'),
    (112, 'Isabella', 'Harris', '1997-01-30', 'isabella@gmail.com', '9789012345');
    
    insert into Teacher (teacher_id, first_name, last_name, email) VALUES
    (201, 'David', 'Miller', 'david@gmail.com'),
    (202, 'Sam', 'Wane', 'sam@gmail.com'),
    (203, 'Emily', 'Clark', 'emily@gmail.com'),
    (204, 'Michael', 'Johnson', 'michael@gmail.com'),
    (205, 'Sophia', 'Martinez', 'sophia@gmail.com'),
    (206, 'James', 'Brown', 'james@gmail.com'),
    (207, 'Olivia', 'Wilson', 'olivia@gmail.com'),
    (208, 'William', 'Davis', 'william@gmail.com'),
    (209, 'Emma', 'Taylor', 'emma@gmail.com'),
    (210, 'Daniel', 'White', 'daniel@gmail.com'),
    (211, 'Ava', 'Harris', 'ava@gmail.com'),
    (212, 'Ethan', 'Thompson', 'ethan@gmail.com');

   
   insert into Courses (course_id, course_name, credits, teacher_id) VALUES
    (301, 'Mathematics', 3, 201),
    (302, 'Science', 4, 202),
    (303, 'Physics', 5, 203),
    (304, 'Chemistry', 4, 204),
    (305, 'Biology', 3, 205),
    (306, 'Computer Science', 5, 206),
    (307, 'History', 3, 207),
    (308, 'Geography', 3, 208),
    (309, 'English Literature', 4, 209),
    (310, 'Economics', 3, 210),
    (311, 'Political Science', 4, 211),
    (312, 'Psychology', 3, 212);


   insert into Enrollments (enrollment_id, student_id, course_id, enrollment_date) VALUES
    (401, 101, 301, '2025-01-15'),
    (402, 102, 302, '2025-01-18'),
    (403, 103, 303, '2025-01-21'),
    (404, 104, 304, '2025-01-25'),
    (405, 105, 305, '2025-01-29'),
    (406, 106, 306, '2025-02-02'),
    (407, 107, 307, '2025-02-07'),
    (408, 108, 308, '2025-02-10'),
    (409, 109, 309, '2025-02-14'),
    (410, 110, 310, '2025-02-20'),
    (411, 111, 311, '2025-02-25'),
    (412, 112, 312, '2025-03-01');
    
    insert into Payments (payment_id, student_id, amount, payment_date) VALUES
    (501, 101, 500.00, '2025-01-10'),
    (502, 102, 750.50, '2025-01-12'),
    (503, 103, 620.75, '2025-01-15'),
    (504, 104, 800.00, '2025-01-20'),
    (505, 105, 450.25, '2025-01-25'),
    (506, 106, 900.00, '2025-02-01'),
    (507, 107, 700.30, '2025-02-05'),
    (508, 108, 550.00, '2025-02-10'),
    (509, 109, 850.75, '2025-02-15'),
    (510, 110, 680.50, '2025-02-22'),
    (511, 111, 920.00, '2025-02-28'),
    (512, 112, 770.40, '2025-03-05');

