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
   SELECT * 
   FROM fotos 
   WHERE idUsuario = 36;

   SELECT *
   FROM instagram_low_cost.fotos,instagram_low_cost.usuarios 
   WHERE instagram_low_cost.usuarios.idUsuario = instagram_low_cost.fotos.idUsuario 
      AND instagram_low_cost.usuarios.idUsuario = 36;


2. -- Fotos del usuario con ID 36 tomadas en enero del 2023:
   SELECT *
   FROM instagram_low_cost.fotos
   WHERE instagram_low_cost.fotos.idUsuario = 36
      AND YEAR(instagram_low_cost.fotos.fechaCreacion) = 2023
      AND MONTH(instagram_low_cost.fotos.fechaCreacion) = 1;

3. -- Comentarios del usuario 36 sobre la foto 12 del usuario 11:
   SELECT instagram_low_cost.comentarios.comentario
   FROM instagram_low_cost.comentarios , instagram_low_cost.comentariosFotos
   WHERE instagram_low_cost.comentarios.idComentario = instagram_low_cost.comentariosFotos.idComentario
     AND instagram_low_cost.comentarios.idUsuario = 36
     AND instagram_low_cost.comentariosFotos.idFoto = 12;

4. -- Fotos que han sorprendido al usuario 25:
   SELECT instagram_low_cost.fotos.*
   FROM instagram_low_cost.fotos, instagram_low_cost.reaccionesFotos
   WHERE instagram_low_cost.fotos.idFoto = instagram_low_cost.reaccionesFotos.idFoto
     AND instagram_low_cost.reaccionesFotos.idUsuario = 25
     AND instagram_low_cost.reaccionesFotos.idTipoReaccion = 4;

5. -- Administradores que han dado más de 2 "Me gusta":
   SELECT instagram_low_cost.fotos.*
   FROM instagram_low_cost.usuarios, instagram_low_cost.reaccionesFotos
   WHERE instagram_low_cost.usuarios.idUsuario = instagram_low_cost.reaccionesFotos.idUsuario
     AND instagram_low_cost.usuarios.idRol = 3
     AND instagram_low_cost.reaccionesFotos.idTipoReaccion = 1
     AND instagram_low_cost.reaccionesFotos.idTipoReaccion > 2;

6. -- Número de "Me divierte" de la foto número 12 del usuario 45:
   SELECT count(*)
   FROM instagram_low_cost.reaccionesFotos
   WHERE idFoto = 12
     AND idUsuario = 45
     AND idTipoReaccion = 3;

   # Añado los para ver que me llegue una 
   insert into reaccionesFotos (idUsuario, idFoto , idTipoReaccion)
   values (45,12, 3);

7. -- Número de fotos tomadas en la playa (en base al título):
   SELECT *
   FROM instagram_low_cost.fotos
   WHERE instagram_low_cost.fotos.descripcion 
      LIKE '%playa%';
