use CinemaAppDB

select * from users
select * from UserRolesMappings
select * from UserRoles

select * from Movies
select * from Persons
order by FirstName asc
select * from MovieRoleMappings
select * from MovieRoles



exec deleteAllActorsAndDirectorsForMovie 1
select * from MovieRoleMappings


use master 
drop database CinemaAppDB

