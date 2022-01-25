use CinemaAppDB

select * from users
select * from UserRoles
select * from UserRolesMappings
 

delete Users
delete UserRolesMappings

use master 
drop database CinemaAppDB