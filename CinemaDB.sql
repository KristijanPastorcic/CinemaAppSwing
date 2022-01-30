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
go

create table UserRoles(
	IDUserRole int primary key identity(1, 1),
	UserRole nvarchar(50) unique not null
)
go

create table UserRolesMappings(
	IDUserRoleMapping int primary key identity(1, 1),
	IDUserRole_FK int foreign key references UserRoles(IDUserRole),
	IDUser_FK int foreign key references Users(IDUser)
)
go

create table Movies(
	IDMovie int primary key identity(1,1),
	Title nvarchar(50) not null,
	PublishedDateTime nvarchar(50),
	"Description" nvarchar(500),
	Duration int,
	Genre nvarchar(50),
	Link nvarchar(100),
	InTheatars nvarchar(50),
	PosterPicturePath nvarchar(150)
)
go

create table MovieRoles(
	IDMovieRole int primary key identity(1,1),
	MovieRole nvarchar(50) unique not null
) 
go

create table MovieRoleMappings(
	IDMovieRoleMapping int primary key identity(1,1),
	IDPerson_FK int foreign key references Persons(IDPerson),
	IDMovieRole_FK int foreign key references MovieRoles(IDMovieRole),
	IDMovie_FK int foreign key  references Movies(IDMovie)
)
go

use master