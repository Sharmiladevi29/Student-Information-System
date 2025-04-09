create database insurance;
use insurance;

create table policy (
    policyid int primary key auto_increment,
    policyname varchar(100) not null,
    policydetails varchar(255)
);

create table user (
    userid int primary key auto_increment,
    username varchar(50) not null,
    password varchar(100) not null,
    role varchar(20) not null
);

create table client (
    clientid int primary key auto_increment,
    clientname varchar(100) not null,
    contactinfo varchar(255),
    policyid int,
    foreign key (policyid) references policy(policyid)
);

create table claim (
    claimid int primary key auto_increment,
    claimnumber varchar(50) not null,
    datefiled date not null,
    claimamount decimal(10,2) not null,
    status varchar(20) not null,
    policyid int,
    clientid int,
    foreign key (policyid) references policy(policyid),
    foreign key (clientid) references client(clientid)
);

create table payment (
    paymentid int primary key auto_increment,
    paymentdate date not null,
    paymentamount decimal(10,2) not null,
    clientid int,
    foreign key (clientid) references client(clientid)
);

insert into policy (policyname, policydetails) values 
('Home Insurance', 'Covers home-related damages'),
('Vehicle Insurance', 'Covers vehicles and accidents'),
('Health Insurance', 'Covers medical expenses');

insert into user (username, password, role) values 
('Arun', 'arun123', 'admin'),
('Seetha', 'seetha456', 'client'),
('Ramya', 'ramya789', 'staff');

insert into client (clientname, contactinfo, policyid) values 
('Mohan', 'mo@gmail.com', 1),
('Kavitha', 'kavi@yahoo.com', 3),
('Anand', 'ananth@outlook.com', 2);

insert into claim (claimnumber, datefiled, claimamount, status, policyid, clientid) values 
('CLM001', '2025-04-01', 50000.00, 'Submitted', 1, 1),
('CLM002', '2025-04-03', 200000.00, 'In Progress', 3, 2),
('CLM003', '2025-04-05', 75000.00, 'Completed', 2, 3);

insert into payment (paymentdate, paymentamount, clientid) values 
('2025-04-02', 10000.00, 1),
('2025-04-04', 15000.00, 2),
('2025-04-06', 12000.00, 3);

select * from policy;
select * from user;
select * from client;
select * from claim;
select * from payment;

