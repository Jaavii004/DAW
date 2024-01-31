# contar usuarios
select COUNT(*) from instagram_low_cost.usuarios;

#contar fotos de la base de datos
select COUNT(*) from instagram_low_cost.fotos;

select * from instagram_low_cost.roles;


# Contar las fotos del usuario id 36
select *
from instagram_low_cost.fotos,instagram_low_cost.usuarios 
where instagram_low_cost.usuarios.idUsuario = instagram_low_cost.fotos.idUsuario 
	and instagram_low_cost.usuarios.idUsuario = 36;

#contar fotos de los administradores 
select count(*) 
from instagram_low_cost.fotos,instagram_low_cost.usuarios
where instagram_low_cost.usuarios.idUsuario = instagram_low_cost.fotos.idUsuario 
	and instagram_low_cost.usuarios.idRol = 3;
    
Select instagram_low_cost.roles.descripcion , count(*) as "Numero de fotos"
From instagram_low_cost.fotos, instagram_low_cost.usuarios, instagram_low_cost.roles
where instagram_low_cost.usuarios.idRol = 3
	AND instagram_low_cost.usuarios.idUsuario = instagram_low_cost.fotos.idUsuario
    AND instagram_low_cost.usuarios.idRol = instagram_low_cost.roles.idRol
group by instagram_low_cost.roles.descripcion;
    

    
    
    
#numero comentarios de el usuario id11
select count(*) 
from instagram_low_cost.comentarios,instagram_low_cost.usuarios 
where instagram_low_cost.usuarios.idUsuario = instagram_low_cost.comentarios.idUsuario 
	and instagram_low_cost.usuarios.idUsuario = 11;


# saber usuarios conectados
SHOW PROCESSLIST;




#Obtener nombre, apellido y descripción de rol de todos los usuarios.

select nombre,apellido,descripcion
from usuarios,Roles
WHERE idRol = idRoles;

#Obtener el email de todos los administradores
select email from usuarios
WHERE idRol = 0;

select email,descripcion 
from usuarios,Roles
WHERE Roles.descripcion = "Usu" 
    AND usuarios.idRol = Roles.idRoles;

Ejercicio 1:

# Ejercicio 1 Fotos del usuario con ID 36
Select idFoto
From fotos,usuarios
where fotos.idUsuario = usuarios.idUsuario
    AND fotos.idUsuario = 36;

Otro ejemplo:

select * 
from instagram_low_cost.fotos f1
where f1.idUsuario=36;


Ejercicio 2:	 	 	 	
#Fotos del usuario con ID 36 tomadas en enero del 2023

select * from instagram_low_cost.fotos f1
where   YEAR(f1.fechaCreacion) = 2024  
    AND MONTH(f1.fechacreacion) = 01
    AND f1.idUsuario=33;



