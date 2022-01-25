use CinemaAppDB
go

insert into UserRoles(UserRole) values('User')
insert into UserRoles(UserRole) values('Admin')
go

exec createAdmin 'admin123', '123'

use master