SELECT videoclub.PELICULA.Titol , videoclub.ACTOR.Nom
FROM videoclub.PELICULA
JOIN videoclub.ACTOR
ON PELICULA.CodiActor = ACTOR.CodiActor;