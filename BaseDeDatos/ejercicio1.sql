#1. -- Fotos del usuario con ID 36:
   SELECT * FROM Fotos WHERE idUsuario = 36;

    select *
    from instagram_low_cost.fotos,instagram_low_cost.usuarios 
    where instagram_low_cost.usuarios.idUsuario = instagram_low_cost.fotos.idUsuario 
        and instagram_low_cost.usuarios.idUsuario = 36;

#2. -- Fotos del usuario con ID 36 tomadas en enero del 2023:
   SELECT * FROM Fotos WHERE idUsuario = 36 AND YEAR(fechaCreacion) = 2023 AND MONTH(fechaCreacion) = 1;

#3. -- Comentarios del usuario 36 sobre la foto 12 del usuario 11:
   SELECT comentarios.comentario 
   FROM Comentarios 
   JOIN ComentariosFotos ON Comentarios.idComentario = ComentariosFotos.idComentario
   WHERE Comentarios.idUsuario = 36 AND ComentariosFotos.idFoto = 12;

#4. -- Fotos que han sorprendido al usuario 25:
   SELECT Fotos.* 
   FROM Fotos 
   JOIN ReaccionesFotos ON Fotos.idFoto = ReaccionesFotos.idFoto
   WHERE ReaccionesFotos.idUsuario = 25 AND ReaccionesFotos.idTipoReaccion = 4;

#5. -- Administradores que han dado más de 2 "Me gusta":
   SELECT Usuarios.*
   FROM Usuarios
   JOIN ReaccionesFotos ON Usuarios.idUsuario = ReaccionesFotos.idUsuario
   WHERE Usuarios.idRol = 3 AND ReaccionesFotos.idTipoReaccion = 1
   GROUP BY Usuarios.idUsuario
   HAVING COUNT(*) > 2;

#6. -- Número de "Me divierte" de la foto número 12 del usuario 45:
   SELECT COUNT(*)
   FROM ReaccionesFotos
   WHERE idFoto = 12 AND idUsuario = 45 AND idTipoReaccion = 3;

#7. -- Número de fotos tomadas en la playa (en base al título):
   SELECT COUNT(*)
   FROM Fotos
   WHERE descripcion LIKE '%playa%';





1. -- Fotos del usuario con ID 36:
   SELECT * FROM Fotos WHERE idUsuario = 36;

2. -- Fotos del usuario con ID 36 tomadas en enero del 2023:
   SELECT * FROM Fotos WHERE idUsuario = 36 AND YEAR(fechaCreacion) = 2023 AND MONTH(fechaCreacion) = 1;

3. -- Comentarios del usuario 36 sobre la foto 12 del usuario 11:
   SELECT comentarios.comentario 
   FROM Comentarios, ComentariosFotos 
   WHERE Comentarios.idComentario = ComentariosFotos.idComentario 
     AND Comentarios.idUsuario = 36 
     AND ComentariosFotos.idFoto = 12;

4. -- Fotos que han sorprendido al usuario 25:
   SELECT Fotos.* 
   FROM Fotos, ReaccionesFotos 
   WHERE Fotos.idFoto = ReaccionesFotos.idFoto 
     AND ReaccionesFotos.idUsuario = 25 
     AND ReaccionesFotos.idTipoReaccion = 4;

5. -- Administradores que han dado más de 2 "Me gusta":
   SELECT Usuarios.*
   FROM Usuarios, ReaccionesFotos
   WHERE Usuarios.idUsuario = ReaccionesFotos.idUsuario
     AND Usuarios.idRol = 3 
     AND ReaccionesFotos.idTipoReaccion = 1
     AND ReaccionesFotos.idTipoReaccion > 2;

6. -- Número de "Me divierte" de la foto número 12 del usuario 45:
   SELECT COUNT(*)
   FROM ReaccionesFotos
   WHERE idFoto = 12 AND idUsuario = 45 AND idTipoReaccion = 3;

7. -- Número de fotos tomadas en la playa (en base al título):
   SELECT COUNT(*)
   FROM Fotos
   WHERE descripcion LIKE '%playa%';
