use CinemaAppDB
go

create or alter proc "login"
    @loginName nvarchar(50),
    @password nvarchar(50)
as
	select IDUser from Users where LoginName = @loginName 
	AND [PasswordHash] = HASHBYTES('SHA2_512', @password + Salt)
go

create proc register 
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

use master