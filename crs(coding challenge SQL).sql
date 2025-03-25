create database crs;
use crs;

create table Vehicle(
vehicle_id int primary key,
vehicle_make varchar(50) not null,
model varchar(50) not null,
vehicle_year int not null check (vehicle_year >=1900 and vehicle_year <=2025),
dailyrate decimal(10,2) not null check (dailyrate >=0),
available_status  enum('available','notavailable') not null,
passenger_capacity int,
engine_capacity int
);

select * from Vehicle;

create table Customer(
customer_id int primary key,
first_name varchar(30) not null,
last_name varchar(30) not null,
email varchar(100) unique not null,
phone_number varchar(20) unique not null
);

select * from Customer;

create table Lease(
lease_id int primary key,
vehicle_id int,
foreign key(vehicle_id) references Vehicle(vehicle_id) on delete cascade,
customer_id int,
foreign key(customer_id) references Customer(customer_id)on delete cascade,
start_date date not null,
end_date date not null,
lease_type varchar(30)
);

select * from Lease;

create table Payment(
payment_id int primary key,
lease_id int,
foreign key(lease_id) references Lease(lease_id) on delete cascade,
payment_date date not null,
amount decimal(10,2) not null check(amount>=0)
);

select * from Payment;

insert into Vehicle(vehicle_id,vehicle_make,model,vehicle_year,
dailyrate,available_status,passenger_capacity,engine_capacity)
values
(1,'Toyota','Camry',2022,50.00,'available',4,1450),
(2,'Honda','Civic',2023,45.00,'available',7,1500),
(3,'Ford','Focus',2022,48.00,'notavailable',4,1400),
(4,'Nissan','Altima',2023,52.00,'available',7,1200),
(5,'Chevrolet','Malibu',2022,47.00,'available',4,1800),
(6,'Hyundai','Sonata',2023,49.00,'notavailable',7,1400),
(7,'BMW','3 Series',2023,60.00,'available',7,2499),
(8,'Mercedes','C-Class',2022,58.00,'available',8,2599),
(9,'Audi','A4',2022,55.00,'notavailable',4,2500),
(10,'Lexus','ES',2023,54.00,'available',4,2500);

insert into Customer(customer_id,first_name,last_name,email,phone_number)
values
(1,'John','Doe','johndoe@example.com', '555-555-5555'),
(2,'Jane','Smith','janesmith@example.com','555-123-4567'),
(3,'Robert','Johnson','robert@example.com','555-789-1234'),
(4,'Sarah','Brown','sarah@example.com','555-456-7890'),
(5,'David','Lee','david@example.com','555-987-6543'),
(6,'Laura','Hall','laura@example.com','555-234-5678'),
(7,'Michael','Davis','michael@example.com','555-876-5432'),
(8,'Emma','Wilson','emma@example.com','555-432-1098'),
(9,'William','Taylor','william@example.com','555-321-6547'),
(10,'Olivia','Adams','olivia@example.com','555-765-4321');


insert into Lease(lease_id,vehicle_id,customer_id,start_date,end_date,lease_type)
values
(1,1,1,'2023-01-01','2023-01-05','Daily'),
(2,2,2,'2023-02-15','2023-02-28','Monthly'),
(3,3,3,'2023-03-10','2023-03-15','Daily'),
(4,4,4,'2023-04-20','2023-04-30','Monthly'),
(5,5,5,'2023-05-05','2023-05-10','Daily'),
(6,4,3,'2023-06-15','2023-06-30','Monthly'),
(7,7,7,'2023-07-01','2023-07-10','Daily'),
(8,8,8,'2023-08-12','2023-08-15','Monthly'),
(9,3,3,'2023-09-07','2023-09-10','Daily'),
(10,10,10,'2023-10-10','2023-10-31','Monthly');

insert into Payment(payment_id,lease_id,payment_date,amount) values
(1,1,'2023-01-03',200.00),
(2,2,'2023-02-20',1000.00),
(3,3,'2023-03-12',75.00),
(4,4,'2023-04-25',900.00),
(5,5,'2023-05-07',60.00),
(6,6,'2023-06-18',1200.00),
(7,7,'2023-07-03',40.00),
(8,8,'2023-08-14',1100.00),
(9,9,'2023-09-09',80.00),
(10,10,'2023-10-25',1500.00);




SET SQL_SAFE_UPDATES = 0;

update Vehicle
set dailyrate=68.00
where vehicle_make='Mercedes';

delete from Customer where customer_id=4;

alter table Payment rename column payment_date to transaction_date;

select * from Customer where email='johndoe@example.com';

select * from Lease
where customer_id=3
and end_date>=2022;

select p.* 
from payment p  
join lease l on p.lease_id = l.lease_id  
join customer c on l.customer_id = c.customer_id  
where c.phone_number = '555-987-6543';

select avg(dailyrate) as avg_dailyrate
from Vehicle
where available_status='available';

select * from Vehicle
order by dailyrate desc
limit 1;

select v.* from Vehicle v
join Lease l on v.vehicle_id=l.vehicle_id
where l.customer_id=3;

select * from Lease
order by end_date desc
limit 1;

select * from Payment 
where year(transaction_date)=2023;

select * 
from customer 
where customer_id not in (select distinct lease.customer_id from lease 
		                  join payment on lease.lease_id = payment.lease_id);

select v.vehicle_id,v.vehicle_make,v.model,v.vehicle_year,v.dailyrate,coalesce(sum(p.amount),0)as total_payments
from Vehicle v
left join Lease l on v.vehicle_id=l.vehicle_id
left join Payment p on p.lease_id=l.lease_id
group by v.vehicle_id,v.vehicle_make,v.model,v.vehicle_year,v.dailyrate
order by total_payments desc;

select c.customer_id, c.first_name, c.last_name, coalesce(sum(p.amount), 0) as total_payments
from customer c
left join lease l on c.customer_id = l.customer_id
left join payment p on l.lease_id = p.lease_id
group by c.customer_id, c.first_name, c.last_name
order by total_payments desc;

select l.lease_id, v.vehicle_id, v.vehicle_make, v.model, v.vehicle_year, v.dailyrate, l.start_date, l.end_date, l.lease_type
from lease l
join vehicle v on l.vehicle_id = v.vehicle_id;


select l.lease_id, c.customer_id, c.first_name, c.last_name, v.vehicle_id, v.vehicle_make, v.model, l.start_date, l.end_date, l.lease_type
from lease l
join customer c on l.customer_id = c.customer_id
join vehicle v on l.vehicle_id = v.vehicle_id
where l.end_date >= curdate()
order by l.start_date;

select c.customer_id, c.first_name, c.last_name, coalesce(sum(p.amount), 0) as total_spent
from customer c
left join lease l on c.customer_id = l.customer_id
left join payment p on l.lease_id = p.lease_id
group by c.customer_id, c.first_name, c.last_name
order by total_spent desc
limit 1;

select v.vehicle_id, v.vehicle_make, v.model, v.vehicle_year, v.dailyrate, l.lease_id, l.start_date, l.end_date, l.lease_type, c.customer_id, c.first_name, c.last_name
from vehicle v
left join lease l on v.vehicle_id = l.vehicle_id
left join customer c on l.customer_id = c.customer_id
where l.end_date >= curdate() 
order by l.start_date desc;
