create database cars;
use cars;


create table Law_Enforcement_Agencies(
    AgencyID int primary key,
    Agency_Name varchar(50),
    Jurisdiction varchar(100),
    Contact_Information varchar(100)
);


create table Officers(
    OfficerID int primary key,
    First_name varchar(50),
    Last_name varchar(50),
    Badgenumber int,
    Officer_Rank int,
    Contact_Information varchar(100),
    AgencyID int,
    foreign key (AgencyID) references Law_Enforcement_Agencies(AgencyID) on delete set null
);


create table Victims(
    VictimID int primary key,
    First_name varchar(50),
    Last_name varchar(50),
    Date_of_birth date not null,
    Gender varchar(20) not null,
    Contact_Information varchar(100)
);


create table Suspects(
    Suspect_ID int primary key,
    First_name varchar(50),
    Last_name varchar(50),
    Date_of_birth date,
    Gender varchar(20) not null,
    Contact_Information varchar(100)
);


create table Incidents(
    IncidentID int primary key,
    Incident_Type varchar(50) not null,
    Incident_Date date,
    Location varchar(100),
    Incident_Description varchar(500),
    Incident_status varchar(100),
    VictimID int,
    foreign key (VictimID) references Victims(VictimID) on delete set null,
    Suspect_ID int,
    foreign key (Suspect_ID) references Suspects(Suspect_ID) on delete set null,
    OfficerID int,
    foreign key (OfficerID) references Officers(OfficerID) on delete set null
);


create table Evidence(
    EvidenceID int primary key,
    Evidence_Description varchar(1000),
    Location_found varchar(100),
    IncidentID int,
    foreign key (IncidentID) references Incidents(IncidentID) on delete set null
);


create table Reports(
    Report_ID int primary key,
    IncidentID int,
    foreign key (IncidentID) references Incidents(IncidentID) on delete set null,
    OfficerID int,
    foreign key (OfficerID) references Officers(OfficerID) on delete set null,
    Report_date date,
    Report_details varchar(500),
    Report_Status varchar(20)
);


select * from Incidents;
select * from Victims;
select * from Suspects;
select * from Law_Enforcement_Agencies;
select * from Officers;
select * from Evidence;
select * from Reports;

insert into Law_Enforcement_Agencies (AgencyID, Agency_Name, Jurisdiction, contact_information) values
(1, 'City Police Department', 'Downtown', 'contact@citypolice.com'),
(2, 'State Bureau of Investigation', 'Statewide', 'contact@statebureau.com'),
(3, 'Federal Law Enforcement', 'Nationwide', 'contact@federalagency.com');

insert into Officers (OfficerID, First_name, Last_name, Badgenumber, officer_Rank, contact_information, AgencyID) values
(1, 'Andrew', 'Walker', 12345, 3, 'andrew.walker@police.com', 1),
(2, 'Sarah', 'Hall', 54321, 2, 'sarah.hall@police.com', 2),
(3, 'Mark', 'Allen', 67890, 1, 'mark.allen@police.com', 3),
(4, 'Nancy', 'Young', 98765, 4, 'nancy.young@police.com', 1),
(5, 'Steven', 'King', 13579, 3, 'steven.king@police.com', 2),
(6, 'Laura', 'Adams', 24680, 2, 'laura.adams@police.com', 3),
(7, 'Daniel', 'Nelson', 11223, 1, 'daniel.nelson@police.com', 1),
(8, 'Jessica', 'Carter', 33445, 3, 'jessica.carter@police.com', 2),
(9, 'George', 'Mitchell', 55667, 2, 'george.mitchell@police.com', 3),
(10, 'Karen', 'Roberts', 77889, 1, 'karen.roberts@police.com', 1);

insert into Victims (VictimID, First_name, Last_name, Date_of_birth, Gender, Contact_Information) values
(1, 'John', 'Doe', '1985-07-21', 'Male', 'john.doe@gmail.com'),
(2, 'Jane', 'Smith', '1990-05-12', 'Female', 'jane.smith@yahoo.com'),
(3, 'Michael', 'Brown', '1978-12-04', 'Male', 'michael.brown@gmail.com'),
(4, 'Emily', 'Johnson', '1995-03-10', 'Female', 'emily.johnson@gmail.com'),
(5, 'David', 'Williams', '1982-09-25', 'Male', 'david.williams@hotmail.com'),
(6, 'Emma', 'Davis', '2000-06-17', 'Female', 'emma.davis@gmail.com'),
(7, 'Daniel', 'Miller', '1987-08-30', 'Male', 'daniel.miller@gmail.com'),
(8, 'Sophia', 'Wilson', '1993-11-05', 'Female', 'sophia.wilson@yahoo.com'),
(9, 'James', 'Taylor', '1980-04-22', 'Male', 'james.taylor@gmail.com'),
(10, 'Olivia', 'Anderson', '1997-02-14', 'Female', 'olivia.anderson@gmail.com');

insert into Suspects (Suspect_ID, First_name, Last_name, Date_of_birth, Gender, Contact_information) values
(1, 'Robert', 'Jones', '1983-11-15', 'Male', 'robert.jones@gmail.com'),
(2, 'William', 'Garcia', '1975-06-20', 'Male', 'william.garcia@yahoo.com'),
(3, 'Linda', 'Martinez', '1992-01-05', 'Female', 'linda.martinez@gmail.com'),
(4, 'Joseph', 'Rodriguez', '1988-07-10', 'Male', 'joseph.rodriguez@gmail.com'),
(5, 'Barbara', 'Hernandez', '1981-03-25', 'Female', 'barbara.hernandez@hotmail.com'),
(6, 'Thomas', 'Lopez', '1979-09-17', 'Male', 'thomas.lopez@gmail.com'),
(7, 'Patricia', 'Gonzalez', '1994-05-30', 'Female', 'patricia.gonzalez@gmail.com'),
(8, 'Charles', 'Perez', '1986-08-05', 'Male', 'charles.perez@yahoo.com'),
(9, 'Jennifer', 'Lee', '1990-12-22', 'Female', 'jennifer.lee@gmail.com'),
(10, 'Matthew', 'Scott', '2001-04-14', 'Male', 'matthew.scott@gmail.com');

insert into Incidents (IncidentID, Incident_Type, Incident_Date, Location, Incident_Description, Incident_status, VictimID, Suspect_ID, OfficerID) values
(1, 'Robbery', '2025-03-01', 'Downtown', 'Armed robbery at a bank', 'Under Investigation', 1, 2, 1),
(2, 'Assault', '2025-02-28', 'City Park', 'Physical assault reported', 'Closed', 3, 5, 4),
(3, 'Burglary', '2025-02-25', 'Westside', 'House break-in', 'Pending', 4, 7, 2),
(4, 'Homicide', '2025-02-20', 'Eastside', 'Murder case under investigation', 'Ongoing', 5, 1, 3),
(5, 'Fraud', '2025-02-15', 'Financial District', 'Financial scam reported', 'Under Investigation', 6, 3, 5),
(6, 'Drug Possession', '2025-02-10', 'Suburbs', 'Illegal drug possession case', 'Closed', 7, 4, 6),
(7, 'Vandalism', '2025-02-05', 'School Zone', 'Property damage reported', 'Pending', 8, 9, 7),
(8, 'Kidnapping', '2025-02-01', 'Downtown', 'Child abduction case', 'Ongoing', 9, 10, 8),
(9, 'Theft', '2025-01-28', 'Shopping Mall', 'Pickpocketing incident', 'Closed', 10, 6, 9),
(10, 'Domestic Violence', '2025-01-25', 'Residential Area', 'Spousal abuse reported', 'Under Investigation', 2, 8, 10);

insert into Evidence (EvidenceID, Evidence_Description, Location_found, IncidentID) values
(1, 'Fingerprint samples', 'Bank Vault', 1),
(2, 'CCTV Footage', 'City Park', 2),
(3, 'Blood sample', 'House Entry', 3),
(4, 'Gun found', 'Crime Scene', 4),
(5, 'Financial records', 'Company Office', 5),
(6, 'Drugs confiscated', 'Suburb House', 6),
(7, 'Spray paint cans', 'School Wall', 7),
(8, 'Torn clothing', 'Kidnapper’s Hideout', 8),
(9, 'Wallet recovered', 'Shopping Mall', 9),
(10, 'Medical reports', 'Residential Area', 10);

insert into Reports (Report_ID, IncidentID, OfficerID, Report_date, Report_details, Report_Status) values
(1, 1, 1, '2025-03-02', 'Initial investigation started', 'Ongoing'),
(2, 2, 4, '2025-02-28', 'Suspect arrested and charged', 'Closed'),
(3, 3, 2, '2025-02-26', 'Awaiting forensic results', 'Pending'),
(4, 4, 3, '2025-02-21', 'Autopsy in progress', 'Ongoing'),
(5, 5, 5, '2025-02-16', 'Interviewing witnesses', 'Under Investigation'),
(6, 6, 6, '2025-02-11', 'Court hearing scheduled', 'Closed'),
(7, 7, 7, '2025-02-06', 'Surveillance video reviewed', 'Pending'),
(8, 8, 8, '2025-02-02', 'Amber Alert issued', 'Ongoing'),
(9, 9, 9, '2025-01-29', 'Recovered stolen goods', 'Closed'),
(10, 10, 10, '2025-01-26', 'Victim relocated to safety', 'Under Investigation');
