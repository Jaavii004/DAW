# Examen Ev2

Conéctese a la base de datos remota indicada por el profesor y realize las consultas enunciadas a continuación. Salvo especificaciones concretas, aplique el sentido común para lograr un resultado lo más legible posible para una persona. Justifique sus decisiones y documente el código utilizado.


# Ejercicio 1

### 1
```sql
UPDATE PREGUNTA
SET IdRespuesta = "1.a"
WHERE IdPregunta = 1;
```
### 2
```sql
UPDATE PREGUNTA
SET IdRespuesta = "2.a"
WHERE IdPregunta = 2;
```
### 3
```sql
UPDATE PREGUNTA
SET IdRespuesta = "3.c"
WHERE IdPregunta = 3;
```
### 4
```sql
UPDATE PREGUNTA
SET IdRespuesta = "4.b"
WHERE IdPregunta = 4;
```
### 5
```sql
UPDATE PREGUNTA
SET IdRespuesta = "5.c"
WHERE IdPregunta = 5;
```
### 6
```sql
UPDATE PREGUNTA
SET IdRespuesta = "6.c"
WHERE IdPregunta = 6;
```
### 7
```sql
UPDATE PREGUNTA
SET IdRespuesta = "7.b"
WHERE IdPregunta = 7;
```
### 8
```sql
UPDATE PREGUNTA
SET IdRespuesta = "8.b"
WHERE IdPregunta = 8;
```


## Empresa
Usando la base de datos `empresa`, realice las siguientes consultas.

![Estructura de la base de datos `empresa`.](img/empresa.png)


### Query 1
Nombre, oficio y salario de los empleados con ID 7900, 7934, 7782 y 7566.
Selecciono Nombre, oficio y salario de los empreados 7900, 7934, 7782 y 7566 de la tabla EMP
```sql
SELECT empresa.EMP.COGNOM , OFICI, SALARI
FROM empresa.EMP
WHERE EMP_NO = 7900
    OR EMP_NO = 7934
    OR EMP_NO = 7782
    OR EMP_NO = 7566;
```
### Query 2
Lista de los 5 pedidos más costosas, ordenados por fecha.
```sql
SELECT *
FROM empresa.COMANDA
ORDER BY TOTAL DESC
LIMIT 5;
```
### Query 3
Emleados que no perciben comisión con un salario inferior a 300000€.
Lo que utilizo es el where para saber si esta vacia la commision y le añado que tienen que cobrar menos de 300000
```sql
SELECT EMP.COGNOM , SALARI , COMISSIO
FROM empresa.EMP
where COMISSIO IS NULL
AND SALARI < 300000;
```


### Query 4
Clientes cuya ciudad tiene una R en la tercera posición.
selecciono el nombre y ciudad de la tabla clientes y con el substring me quedo con la 3 letra y veo si es una R 
```sql
SELECT empresa.CLIENT.NOM , CIUTAT
FROM empresa.CLIENT
WHERE SUBSTRING(empresa.CLIENT.CIUTAT, 3, 1) LIKE "R";
```

## Videoclub
Usando la base de datos `videoclub`, realice las siguientes consultas.

![Estructura de la base de datos `videoclub`.](img/videoclub.png)


### Query 5
Todos los clientes cuyo DNI termine con la letra B. La columna deberá nombrarse "Cliente".
Muestro todos los nombres de cliente poniendo de nombre CLIENTE de todos los clientes que su dni termine en B
```sql
SELECT videoclub.CLIENT.Nom AS Cliente
FROM videoclub.CLIENT
WHERE videoclub.CLIENT.DNI LIKE '%B';
```

### Query 6
Todas las facturas del mes actual, ordenadas por importe.

```sql
SELECT  *
FROM videoclub.FACTURA
WHERE MONTH(FACTURA.Data) = 03
ORDER BY Import DESC;
```


### Query 7
Facturas cuyo importe sea mayor de 5€ y menor de 10€.
Aqui vamos a mostrar las facturas cuyo nimporte sea mayor que 5 pero menor que 10
```sql
SELECT *
FROM videoclub.FACTURA
WHERE Import > 5
  AND Import < 10;
```

### Query 8
Películas junto a sus géneros. Deberán listarse todos los géneros, incluso si no tienen una película asociada.


### Query 9
El nombre de aquellos clientes que hayan realizado algún préstamo.
Vamos a unir las dos tablas para ver los que tienen prestamos y los que tengan prestamos los listamos 
```sql
SELECT Nom
FROM videoclub.PRESTEC
JOIN videoclub.CLIENT C on C.DNI = PRESTEC.DNI
```

### Query 10
Películas junto a todos sus actores.
```sql
SELECT videoclub.PELICULA.Titol , videoclub.ACTOR.Nom
FROM videoclub.PELICULA
JOIN videoclub.ACTOR
ON PELICULA.CodiActor = ACTOR.CodiActor;
```