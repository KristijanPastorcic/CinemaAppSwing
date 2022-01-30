use CinemaAppDB
go

-- auth
create or alter proc "login"
    @loginName nvarchar(50),
    @password nvarchar(50)
as
	select IDUser from Users where LoginName = @loginName 
	AND [PasswordHash] = HASHBYTES('SHA2_512', @password + Salt)
go

create or alter proc register 
    @loginName nvarchar(50),
    @password nvarchar(50)
as
	DECLARE @Salt VARCHAR(25);

	-- Generate the salt
	DECLARE @Seed int;
	DECLARE @LCV tinyint;
	DECLARE @CTime DATETIME;

	SET @CTime = GETDATE();
	SET @Seed = (DATEPART(hh, @Ctime) * 10000000) + (DATEPART(n, @CTime) * 100000) + (DATEPART(s, @CTime) * 1000) + DATEPART(ms, @CTime);
	SET @LCV = 1;
	SET @Salt = CHAR(ROUND((RAND(@Seed) * 94.0) + 32, 3));

	WHILE (@LCV < 25)
	BEGIN
	   SET @Salt = @Salt + CHAR(ROUND((RAND() * 94.0) + 32, 3));
	   SET @LCV = @LCV + 1;
	END;

	insert into Users(LoginName, PasswordHash, Salt)
	values(@loginName, HASHBYTES('SHA2_512', @password + @Salt), @Salt)
	
	insert into UserRolesMappings(IDUserRole_FK, IDUser_FK)
	values(1, SCOPE_IDENTITY())
go

create or alter proc createAdmin	    
	@loginName nvarchar(50),
    @password nvarchar(50)
as
	exec register @loginName, @password;

	declare @id int;
	select @id = IDUser from Users where LoginName = @loginName;

	insert into UserRolesMappings(IDUser_FK, IDUserRole_FK)
	values (@id, 2)
go

create or alter proc isUserInRole
	@id int, @role nvarchar(25)
as
	if exists(	select ur.UserRole from UserRolesMappings um
	join UserRoles ur on um.IDUserRole_FK = ur.IDUserRole
	where IDUser_FK = @id and UserRole = @role)
	begin 
		select @id as id
	end 
go

--end auth

-- Person


create or alter proc getPerson
	@id int
as
	select p.IDPerson, p.FirstName, p.LastName, mr.MovieRole as MovieRole from Persons p
	join MovieRoleMappings mm on mm.IDPerson_FK = p.IDPerson
	join MovieRoles mr on mm.IDMovieRole_FK = mr.IDMovieRole
	where p.IDPerson = @id
go

create or alter proc getPersons
as
	select DISTINCT p.IDPerson, p.FirstName, p.LastName, mr.MovieRole as MovieRole from Persons p
	join MovieRoleMappings mm on mm.IDPerson_FK = p.IDPerson
	join MovieRoles mr on mm.IDMovieRole_FK = mr.IDMovieRole
go

create or alter proc deletePerson
	@id int
as
	delete MovieRoleMappings
	where IDPerson_FK = @id

	delete Persons
	where IDPerson = @id
go

create or alter proc createPerson
		@firstName nvarchar(50),
		@lastName nvarchar(50),
		@role nvarchar(50)
as
	insert into Persons(FirstName, LastName)
	values (@firstName, @lastName)

	declare @idRole int
	select @idRole = IDMovieRole from MovieRoles where MovieRole = @role

	insert into MovieRoleMappings(IDPerson_FK, IDMovieRole_FK)
	values (SCOPE_IDENTITY(), @idRole)
go

create or alter proc updatePerson
		@id int,
		@firstName nvarchar(50),
		@lastName nvarchar(50),
		@role nvarchar(50)
as

	declare @idRole int
	select @idRole = IDMovieRole from MovieRoles where MovieRole = @role
	update Persons
	set FirstName = @firstName, LastName = @lastName
	where IDPerson = @id
	
	update MovieRoleMappings
	set IDMovieRole_FK = @idRole
	where IDPerson_FK = @id
go

create or alter proc getMoviesForPerson
	@id int
as
	select 
		IDMovie, Title, PublishedDateTime, "Description", Duration, Genre, Link, InTheatars, PosterPicturePath
	from MovieRoleMappings mm
	join Movies m on mm.IDMovie_FK = m.IDMovie
	where mm.IDPerson_FK = @id
go

-- movie inserts only unique persons, avoiding duplicates
create or alter proc createPersonWithMovieAndRole
		@firstName nvarchar(50),
		@lastName nvarchar(50),
		@idMovie int,
		@role nvarchar(50)
as
	declare @id int
	if exists (select * from Persons where FirstName = @firstName and LastName = @lastName)
		begin
			select @id = IDPerson from Persons where FirstName = @firstName and LastName = @lastName
		end
	else
		begin
			insert into Persons(FirstName, LastName) values(@firstName, @lastName)
			set @id = SCOPE_IDENTITY()
		end

	declare @idRole int
	select @idRole = IDMovieRole from MovieRoles where MovieRole = @role
		
	insert into MovieRoleMappings(IDPerson_FK, IDMovieRole_FK, IDMovie_FK)
	values(@id, @idRole, @idMovie) 
go




create or alter proc createMovie
	@title nvarchar(50),
	@pubDateTime nvarchar(50),
	@description nvarchar(500),
	@duration int,
	@genre nvarchar(50),
	@link nvarchar(50),
	@inTheatars nvarchar(50),
	@posterPicturePath nvarchar(150),
	@idOut int out
as
	insert into Movies(Title, PublishedDateTime, "Description", Duration, Genre, Link, InTheatars, PosterPicturePath)
	values(@title, @pubDateTime, @description, @duration, @genre, @link, @inTheatars, @posterPicturePath)

	set @idOut =  SCOPE_IDENTITY()
go



create or alter proc getMovies
as
	select 
		IDMovie, Title, PublishedDateTime, "Description", Duration, Genre, Link, InTheatars, PosterPicturePath
	from Movies
go

create or alter proc getMovieRolePerson
	@id int,
	@movieRole nvarchar(50)
as
	select p.IDPerson, p.FirstName, p.LastName from Persons p
	join MovieRoleMappings mm on mm.IDPerson_FK = p.IDPerson
	where mm.IDMovie_FK = @id and mm.IDMovieRole_FK = 
	(Select IDMovieRole from MovieRoles where MovieRole = @movieRole)
go

create or alter proc getMovie
	@id int
as
	select * from Movies where IDMovie = @id
go

create or alter proc getMovieRolePersonssss
	@movieRole nvarchar(50)
as
	select DISTINCT p.IDPerson, p.FirstName, p.LastName from Persons p
	join MovieRoleMappings mm on mm.IDPerson_FK = p.IDPerson
	where mm.IDMovieRole_FK = 
	(Select IDMovieRole from MovieRoles where MovieRole = @movieRole)
go

create or alter proc deleteMovie
	@id int
as
	delete from MovieRoleMappings
	where IDMovie_FK = @id

	delete from Movies
	where IDMovie = @id
go

create or alter proc updateMovie
	@id int,
	@title nvarchar(50),
	@pubDateTime nvarchar(50),
	@description nvarchar(500),
	@duration int,
	@genre nvarchar(50),
	@link nvarchar(50),
	@inTheatars nvarchar(50),
	@posterPicturePath nvarchar(150)
as
	update Movies
	set Title = @title,
	PublishedDateTime = @pubDateTime,
	"Description" = @description,
	Duration = @duration,
	Genre = @genre,
	InTheatars = @inTheatars,
	PosterPicturePath = @posterPicturePath
	where IDMovie = @id
go

create or alter proc deleteAllActorsAndDirectorsForMovie
	@id int
as
	delete  MovieRoleMappings
	where IDMovie_FK = @id;
go
-- end movie


-- admin
create or alter proc clean
as

	delete MovieRoleMappings
	delete Movies
	delete Persons
	delete MovieRoles

go

--end admin

--int 

insert into UserRoles(UserRole) values('User')
insert into UserRoles(UserRole) values('Admin')
go

insert into MovieRoles(MovieRole) values('Director')
insert into MovieRoles(MovieRole) values('Actor')
go

exec register 'user123', '123';
exec createAdmin 'admin123', '123'

use master