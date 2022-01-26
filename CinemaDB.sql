use master 
create database CinemaAppDB
go

use CinemaAppDB
go

create table Persons(
	IDPerson int primary key identity(1, 1),
	FirstName nvarchar(50) not null,
	LastName nvarchar(50) not null
)
go

create table Users(
	IDUser int primary key identity(1, 1),
	LoginName nvarchar(50) unique not null,
	[PasswordHash] [binary](64) not null,
	Salt nvarchar(36) not null
)

create table UserRoles(
	IDUserRole int primary key identity(1, 1),
	UserRole nvarchar(50) unique not null
)

create table UserRolesMappings(
	IDUserRoleMapping int primary key identity(1, 1),
	IDUserRole_FK int foreign key references UserRoles(IDUserRole),
	IDUser_FK int foreign key references Users(IDUser)
)

