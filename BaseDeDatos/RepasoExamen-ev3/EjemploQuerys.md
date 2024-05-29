
1. **Obtener todos los alumnos que han obtenido una beca:**
```sql
SELECT * FROM alumno WHERE beca IS NOT NULL;
```

2. **Encontrar el nombre de los profesores que imparten asignaturas obligatorias:**
```sql
SELECT nombre
FROM profesor
WHERE idProfesor IN (
    SELECT idProfesor
    FROM impartir
    INNER JOIN asignatura ON impartir.idAsignatura = asignatura.idAsignatura
    WHERE caracter = 'obligatoria'
);
```

3. **Contar cuántos profesores hay en cada categoría:**
```sql
SELECT categoria, COUNT(*) AS cantidad_profesores
FROM profesor
GROUP BY categoria;
```

4. **Encontrar el número de teléfonos de contacto de cada profesor:**
```sql
SELECT idProfesor, COUNT(*) AS numero_telefonos
FROM tlfContactoProf
GROUP BY idProfesor;
```

5. **Calcular la media de créditos de asignaturas por curso:**
```sql
SELECT curso, AVG(creditos) AS media_creditos
FROM asignatura
GROUP BY curso;
```

6. **Encontrar el nombre de los profesores que coordinan asignaturas optativas:**
```sql
SELECT nombre
FROM profesor
WHERE idProfesor IN (
    SELECT coordinador
    FROM asignatura
    WHERE caracter = 'optativa'
);
```

7. **Listar los alumnos que están matriculados en asignaturas impartidas por un profesor específico:**
```sql
SELECT *
FROM alumno
WHERE idAlumno IN (
    SELECT idAlumno
    FROM matricula
    WHERE idAsignatura IN (
        SELECT idAsignatura
        FROM impartir
        WHERE idProfesor = 'profID'
    )
);
```

8. **Encontrar el número total de créditos de asignaturas en cada cuatrimestre:**
```sql
SELECT cuatrimestre, SUM(creditos) AS total_creditos
FROM asignatura
GROUP BY cuatrimestre;
```

9. **Calcular el promedio de notas de los alumnos en una asignatura específica:**
```sql
SELECT AVG(nota) AS promedio_notas
FROM matricula
WHERE idAsignatura = 'asignaturaID';
```

10. **Obtener el nombre de los alumnos que han obtenido la nota más alta en una asignatura:**
```sql
SELECT nombre, apellido1, apellido2
FROM alumno
WHERE idAlumno = (
    SELECT idAlumno
    FROM matricula
    WHERE idAsignatura = 'asignaturaID'
    ORDER BY nota DESC
    LIMIT 1
);
```

11. **Encontrar los profesores que coordinan asignaturas con más de 6 créditos:**
```sql
SELECT *
FROM profesor
WHERE idProfesor IN (
    SELECT coordinador
    FROM asignatura
    WHERE creditos > 6
);
```

12. **Listar los alumnos que están matriculados en asignaturas del segundo cuatrimestre:**
```sql
SELECT *
FROM alumno
WHERE idAlumno IN (
    SELECT idAlumno
    FROM matricula
    WHERE idAsignatura IN (
        SELECT idAsignatura
        FROM asignatura
        WHERE cuatrimestre = '2'
    )
);
```

13. **Contar el número de asignaturas obligatorias por curso:**
```sql
SELECT curso, COUNT(*) AS num_obligatorias
FROM asignatura
WHERE caracter = 'obligatoria'
GROUP BY curso;
```

14. **Calcular el número total de teléfonos de contacto registrados:**
```sql
SELECT COUNT(*) AS total_telefonos
FROM tlfContactoProf;
```

15. **Encontrar los cursos que tienen más de 5 asignaturas:**
```sql
SELECT idCurso, nombreDescriptivo
FROM curso
WHERE idCurso IN (
    SELECT curso
    FROM asignatura
    GROUP BY curso
    HAVING COUNT(*) > 5
);
```

16. **Listar los profesores que imparten asignaturas optativas del primer cuatrimestre:**
```sql
SELECT *
FROM profesor
WHERE idProfesor IN (
    SELECT idProfesor
    FROM impartir
    INNER JOIN asignatura ON impartir.idAsignatura = asignatura.idAsignatura
    WHERE caracter = 'optativa' AND cuatrimestre = '1'
);
```

17. **Calcular la suma de los créditos de todas las asignaturas coordinadas por un profesor específico:**
```sql
SELECT SUM(creditos) AS total_creditos
FROM asignatura
WHERE coordinador = 'profID';
```

18. **Encontrar los alumnos que tienen una nota superior al promedio en una asignatura específica:**
```sql
SELECT *
FROM alumno
WHERE idAlumno IN (
    SELECT idAlumno
    FROM matricula
    WHERE idAsignatura = 'asignaturaID' AND nota > (
        SELECT AVG(nota)
        FROM matricula
        WHERE idAsignatura = 'asignaturaID'
    )
);
```

19. **Listar los profesores que imparten más de una asignatura:**
```sql
SELECT *
FROM profesor
WHERE idProfesor IN (
    SELECT idProfesor
    FROM impartir
    GROUP BY idProfesor
    HAVING COUNT(*) > 1
);
```

20. **Calcular el promedio de notas de los alumnos en todas las asignaturas del primer cuatrimestre:**
```sql
SELECT AVG(nota) AS promedio_notas
FROM matricula
WHERE idAsignatura IN (
    SELECT idAsignatura
    FROM asignatura
    WHERE cuatrimestre = '1'
);
```

20.1.  **Calcular el promedio de cada alumno en todas las asignaturas del primer cuatrimestre:**
```sql
SELECT a.idAlumno, a.nombre, AVG(m.nota) AS promedio_notas
FROM alumno a
JOIN matricula m ON a.idAlumno = m.idAlumno
JOIN asignatura s ON m.idAsignatura = s.idAsignatura
WHERE s.cuatrimestre = 1
GROUP BY a.idAlumno, a.nombre;
```


21. **Encontrar los cursos en los que todos los profesores sean catedráticos:**
```sql
SELECT idCurso, nombreDescriptivo
FROM curso
WHERE idCurso IN (
    SELECT curso
    FROM asignatura
    GROUP BY curso
    HAVING COUNT(DISTINCT coordinador) = (
        SELECT COUNT(*)
        FROM profesor
        WHERE categoria = 'Catedráticos de Universidad'
    )
);
```

22. **Listar los alumnos que han obtenido una beca y están matriculados en asignaturas del segundo cuatrimestre:**
```sql
SELECT *
FROM alumno
WHERE beca IS NOT NULL AND idAlumno IN (
    SELECT idAlumno
    FROM matricula
    WHERE idAsignatura IN (
        SELECT idAsignatura
        FROM asignatura
        WHERE cuatrimestre = '2'
    )
);
```

23. **Contar cuántos alumnos hay matriculados en asignaturas coordinadas por un profesor específico:**
```sql
SELECT COUNT(DISTINCT idAlumno) AS num_alumnos
FROM matricula
WHERE idAsignatura IN (
    SELECT idAsignatura
    FROM asignatura
    WHERE coordinador = 'profID'
);
```

24. **Calcular el número total de créditos de asignaturas optativas:**
```sql
SELECT SUM(creditos) AS total_creditos_optativas
FROM asignatura
WHERE caracter = 'optativa';
```

25. **Encontrar los profesores que no han coordinado ninguna asignatura:**
```sql
SELECT *
FROM profesor
WHERE idProfesor NOT IN (
    SELECT DISTINCT coordinador
    FROM asignatura
);
```

26. **Listar los alumnos que tienen una nota superior a 8 en todas las asignaturas en las que están matriculados:**
```sql
SELECT *
FROM alumno
WHERE idAlumno IN (
    SELECT idAlumno
    FROM matricula
    GROUP BY idAlumno
    HAVING MIN(nota) > 8
);
```

27. **Calcular el promedio de notas de los alumnos en cada curso:**
```sql
SELECT curso, AVG(nota) AS promedio_notas
FROM matricula
INNER JOIN asignatura ON matricula.idAsignatura = asignatura.idAsignatura
GROUP BY curso;
```

28. **Encontrar las asignaturas que tienen al menos 3 profesores impartiendo:**
```sql
SELECT *
FROM asignatura
WHERE idAsignatura IN (
    SELECT idAsignatura
    FROM impartir
    GROUP BY idAsignatura
    HAVING COUNT(*) >= 3
);
```

29. **Listar los profesores que imparten asignaturas obligatorias y que no sean catedráticos:**
```sql
SELECT *
FROM profesor
WHERE idProfesor IN (
    SELECT idProfesor
    FROM impartir
    INNER JOIN asignatura ON impartir.idAsignatura = asignatura.idAsignatura
    WHERE caracter = 'obligatoria'
) AND categoria <> 'Catedráticos de Universidad';
```

30. **Calcular la diferencia entre el número máximo y mínimo de créditos de asignaturas por curso:**
```sql
SELECT curso, MAX(creditos) - MIN(creditos) AS diferencia_creditos
FROM asignatura
GROUP BY curso;
```


31. **Encontrar los alumnos que no han sido asignados a ninguna asignatura:**
```sql
SELECT *
FROM alumno
WHERE idAlumno NOT IN (
    SELECT DISTINCT idAlumno
    FROM matricula
);
```

32. **Listar las asignaturas que tienen más de 100 créditos:**
```sql
SELECT *
FROM asignatura
WHERE creditos > 100;
```

33. **Contar cuántas asignaturas son coordinadas por cada profesor:**
```sql
SELECT coordinador, COUNT(*) AS num_asignaturas_coordinadas
FROM asignatura
GROUP BY coordinador;
```

34. **Calcular el promedio de créditos de asignaturas por cuatrimestre:**
```sql
SELECT cuatrimestre, AVG(creditos) AS promedio_creditos
FROM asignatura
GROUP BY cuatrimestre;
```

35. **Encontrar los cursos en los que ningún alumno tiene beca:**
```sql
SELECT idCurso, nombreDescriptivo
FROM curso
WHERE idCurso NOT IN (
    SELECT curso
    FROM matricula
    INNER JOIN alumno ON matricula.idAlumno = alumno.idAlumno
    WHERE beca IS NOT NULL
);
```

36. **Listar los alumnos que están matriculados en todas las asignaturas obligatorias:**
```sql
SELECT *
FROM alumno
WHERE idAlumno IN (
    SELECT idAlumno
    FROM matricula
    GROUP BY idAlumno
    HAVING COUNT(DISTINCT idAsignatura) = (
        SELECT COUNT(*)
        FROM asignatura
        WHERE caracter = 'obligatoria'
    )
);
```

37. **Contar cuántos alumnos tienen el mismo código postal:**
```sql
SELECT codigoPostal, COUNT(*) AS num_alumnos
FROM alumno
GROUP BY codigoPostal;
```

38. **Calcular el promedio de notas de los alumnos en asignaturas impartidas por cada profesor:**
```sql
SELECT idProfesor, AVG(nota) AS promedio_notas
FROM matricula
INNER JOIN impartir ON matricula.idAsignatura = impartir.idAsignatura
GROUP BY idProfesor;
```

39. **Encontrar los profesores que imparten asignaturas tanto en el primer como en el segundo cuatrimestre:**
```sql
SELECT *
FROM profesor
WHERE idProfesor IN (
    SELECT idProfesor
    FROM impartir
    INNER JOIN asignatura ON impartir.idAsignatura = asignatura.idAsignatura
    GROUP BY idProfesor
    HAVING COUNT(DISTINCT cuatrimestre) = 2
);
```

40. **Listar los cursos que no tienen asignaturas optativas:**
```sql
SELECT idCurso, nombreDescriptivo
FROM curso
WHERE idCurso NOT IN (
    SELECT curso
    FROM asignatura
    WHERE caracter = 'optativa'
);
```

41. **Encontrar los alumnos que están matriculados en asignaturas impartidas por un profesor que sea catedrático:**
```sql
SELECT *
FROM alumno
WHERE idAlumno IN (
    SELECT idAlumno
    FROM matricula
    INNER JOIN impartir ON matricula.idAsignatura = impartir.idAsignatura
    INNER JOIN profesor ON impartir.idProfesor = profesor.idProfesor
    WHERE categoria = 'Catedráticos de Universidad'
);
```

42. **Contar cuántas asignaturas hay por cada caracter (obligatoria u optativa):**
```sql
SELECT caracter, COUNT(*) AS num_asignaturas
FROM asignatura
GROUP BY caracter;
```

43. **Calcular el promedio de créditos de asignaturas por cada curso:**
```sql
SELECT curso, AVG(creditos) AS promedio_creditos
FROM asignatura
GROUP BY curso;
```

44. **Encontrar las asignaturas que no tienen ningún profesor asignado:**
```sql
SELECT *
FROM asignatura
WHERE idAsignatura NOT IN (
    SELECT DISTINCT idAsignatura
    FROM impartir
);
```

45. **Listar los profesores que imparten asignaturas con más de 6 créditos:**
```sql
SELECT *
FROM profesor
WHERE idProfesor IN (
    SELECT idProfesor
    FROM impartir
    INNER JOIN asignatura ON impartir.idAsignatura = asignatura.idAsignatura
    WHERE creditos > 6
);
```

46. **Encontrar los cursos que tienen asignaturas coordinadas por un profesor específico:**
```sql
SELECT idCurso, nombreDescriptivo
FROM curso
WHERE idCurso IN (
    SELECT curso
    FROM asignatura
    WHERE coordinador = 'profID'
);
```

47. **Listar los alumnos que han obtenido una beca y están matriculados en asignaturas de un cuatrimestre específico:**
```sql
SELECT *
FROM alumno
WHERE beca IS NOT NULL AND idAlumno IN (
    SELECT idAlumno
    FROM matricula
    INNER JOIN asignatura ON matricula.idAsignatura = asignatura.idAsignatura
    WHERE cuatrimestre = 'cuatrimestreID'
);
```

48. **Contar cuántas asignaturas tiene cada curso:**
```sql
SELECT curso, COUNT(*) AS num_asignaturas
FROM asignatura
GROUP BY curso;
```

49. **Calcular la suma de créditos de asignaturas impartidas por cada profesor:**
```sql
SELECT idProfesor, SUM(creditos) AS total_creditos
FROM impartir
INNER JOIN asignatura ON impartir.idAsignatura = asignatura.idAsignatura
GROUP BY idProfesor;
```

50. **Encontrar los profesores que imparten asignaturas de un cuatrimestre específico:**
```sql
SELECT *
FROM profesor
WHERE idProfesor IN (
    SELECT idProfesor
    FROM impartir
    INNER JOIN asignatura ON impartir.idAsignatura = asignatura.idAsignatura
    WHERE cuatrimestre = 'cuatrimestreID'
);
```

51. **Listar los alumnos que han obtenido una beca y tienen más de 3 teléfonos de contacto registrados:**
```sql
SELECT *
FROM alumno
WHERE beca IS NOT NULL AND idAlumno IN (
    SELECT idAlumno
    FROM tlfContactoProf
    GROUP BY idAlumno
    HAVING COUNT(*) > 3
);
```

52. **Contar cuántos alumnos hay matriculados en asignaturas de un curso específico:**
```sql
SELECT curso, COUNT(DISTINCT idAlumno) AS num_alumnos
FROM matricula
INNER JOIN asignatura ON matricula.idAsignatura = asignatura.idAsignatura
WHERE curso = 'cursoID'
GROUP BY curso;
```


53. **Calcular el promedio de notas de los alumnos en asignaturas obligatorias:**
```sql
SELECT AVG(nota) AS promedio_notas_obligatorias
FROM matricula
INNER JOIN asignatura ON matricula.idAsignatura = asignatura.idAsignatura
WHERE caracter = 'obligatoria';
```

54. **Encontrar las asignaturas en las que ningún alumno ha obtenido una nota menor a 5:**
```sql
SELECT *
FROM asignatura
WHERE idAsignatura NOT IN (
    SELECT idAsignatura
    FROM matricula
    WHERE nota < 5
);
```

55. **Listar los profesores que no están coordinando ninguna asignatura:**
```sql
SELECT *
FROM profesor
WHERE idProfesor NOT IN (
    SELECT DISTINCT coordinador
    FROM asignatura
);
```

56. **Contar cuántos profesores coordinan asignaturas en cada cuatrimestre:**
```sql
SELECT cuatrimestre, COUNT(DISTINCT coordinador) AS num_profesores_coordinadores
FROM asignatura
GROUP BY cuatrimestre;
```

57. **Calcular el número de teléfonos de contacto de cada profesor y ordenarlos de forma descendente:**
```sql
SELECT idProfesor, COUNT(*) AS numero_telefonos
FROM tlfContactoProf
GROUP BY idProfesor
ORDER BY numero_telefonos DESC;
```

58. **Encontrar los cursos en los que ningún alumno tiene teléfono de contacto registrado:**
```sql
SELECT idCurso, nombreDescriptivo
FROM curso
WHERE idCurso NOT IN (
    SELECT curso
    FROM alumno
    INNER JOIN tlfContactoProf ON alumno.idAlumno = tlfContactoProf.idProfesor
);
```

59. **Listar los alumnos que están matriculados en asignaturas impartidas por un profesor cuya categoría sea "Titulares Universidad":**
```sql
SELECT *
FROM alumno
WHERE idAlumno IN (
    SELECT idAlumno
    FROM matricula
    INNER JOIN impartir ON matricula.idAsignatura = impartir.idAsignatura
    INNER JOIN profesor ON impartir.idProfesor = profesor.idProfesor
    WHERE categoria = 'Titulares Universidad'
);
```

60. **Contar cuántas asignaturas optativas hay por cada cuatrimestre:**
```sql
SELECT cuatrimestre, COUNT(*) AS num_asignaturas_optativas
FROM asignatura
WHERE caracter = 'optativa'
GROUP BY cuatrimestre;
```

61. **Calcular la suma de créditos de asignaturas optativas por cada curso:**
```sql
SELECT curso, SUM(creditos) AS total_creditos_optativas
FROM asignatura
WHERE caracter = 'optativa'
GROUP BY curso;
```

62. **Encontrar los profesores que imparten asignaturas de más de un cuatrimestre:**
```sql
SELECT idProfesor, COUNT(DISTINCT cuatrimestre) AS num_cuatrimestres
FROM impartir
INNER JOIN asignatura ON impartir.idAsignatura = asignatura.idAsignatura
GROUP BY idProfesor
HAVING num_cuatrimestres > 1;
```

63. **Listar los alumnos que han obtenido una beca y están matriculados en asignaturas coordinadas por un profesor específico:**
```sql
SELECT *
FROM alumno
WHERE beca IS NOT NULL AND idAlumno IN (
    SELECT idAlumno
    FROM matricula
    INNER JOIN asignatura ON matricula.idAsignatura = asignatura.idAsignatura
    WHERE coordinador = 'profID'
);
```

64. **Contar cuántos alumnos hay matriculados en asignaturas de un cuatrimestre específico:**
```sql
SELECT cuatrimestre, COUNT(DISTINCT idAlumno) AS num_alumnos
FROM matricula
INNER JOIN asignatura ON matricula.idAsignatura = asignatura.idAsignatura
GROUP BY cuatrimestre;
```

65. **Calcular el promedio de notas de los alumnos en asignaturas de más de 6 créditos:**
```sql
SELECT AVG(nota) AS promedio_notas_creditos_altos
FROM matricula
INNER JOIN asignatura ON matricula.idAsignatura = asignatura.idAsignatura
WHERE creditos > 6;
```

66. **Encontrar las asignaturas que tienen la misma cantidad de créditos que el promedio de créditos de todas las asignaturas:**
```sql
SELECT *
FROM asignatura
WHERE creditos = (
    SELECT AVG(creditos)
    FROM asignatura
);
```

67. **Listar los profesores que imparten asignaturas de un curso específico:**
```sql
SELECT *
FROM profesor
WHERE idProfesor IN (
    SELECT idProfesor
    FROM impartir
    INNER JOIN asignatura ON impartir.idAsignatura = asignatura.idAsignatura
    WHERE curso = 'cursoID'
);
```

68. **Encontrar los alumnos que están matriculados en todas las asignaturas optativas:**
```sql
SELECT *
FROM alumno
WHERE idAlumno IN (
    SELECT idAlumno
    FROM matricula
    GROUP BY idAlumno
    HAVING COUNT(DISTINCT idAsignatura) = (
        SELECT COUNT(*)
        FROM asignatura
        WHERE caracter = 'optativa'
    )
);
```

69. **Contar cuántas asignaturas tiene cada profesor coordinador:**
```sql
SELECT coordinador, COUNT(*) AS num_asignaturas
FROM asignatura
GROUP BY coordinador;
```

70. **Calcular el promedio de notas de los alumnos en asignaturas del primer cuatrimestre:**
```sql
SELECT AVG(nota) AS promedio_notas_primer_cuatrimestre
FROM matricula
INNER JOIN asignatura ON matricula.idAsignatura = asignatura.idAsignatura
WHERE cuatrimestre = '1';
```

71. **Encontrar los cursos que tienen asignaturas coordinadas por un profesor que no sea catedrático:**
```sql
SELECT idCurso, nombreDescriptivo
FROM curso
WHERE idCurso IN (
    SELECT curso
    FROM asignatura
    WHERE coordinador IN (
        SELECT idProfesor
        FROM profesor
        WHERE categoria <> 'Catedráticos de Universidad'
    )
);
```

72. **Listar los alumnos que han obtenido una beca y están matriculados en asignaturas del primer cuatrimestre:**
```sql
SELECT *
FROM alumno
WHERE beca IS NOT NULL AND idAlumno IN (
    SELECT idAlumno
    FROM matricula
    INNER JOIN asignatura ON matricula.idAsignatura = asignatura.idAsignatura
    WHERE cuatrimestre = '1'
);
```


73. Contar cuántos profesores imparten asignaturas en cada provincia:

```sql
COUNT(DISTINCT idProfesor) AS num_profesores
FROM impartir
INNER JOIN asignatura ON impartir.idAsignatura = asignatura.idAsignatura
INNER JOIN profesor ON impartir.idProfesor = profesor.idProfesor
GROUP BY provincia;
```

74. **Calcular la suma de créditos de todas las asignaturas optativas:**
```sql
SELECT SUM(creditos) AS suma_creditos_optativas
FROM asignatura
WHERE caracter = 'optativa';
```

75. **Encontrar las asignaturas que no han sido coordinadas por ningún profesor:**
```sql
SELECT *
FROM asignatura
WHERE coordinador IS NULL;
```

76. **Listar los profesores que imparten asignaturas de más de un curso:**
```sql
SELECT idProfesor, COUNT(DISTINCT curso) AS num_cursos
FROM impartir
INNER JOIN asignatura ON impartir.idAsignatura = asignatura.idAsignatura
GROUP BY idProfesor
HAVING num_cursos > 1;
```

77. **Encontrar los cursos en los que todos los alumnos tienen una beca:**
```sql
SELECT idCurso, nombreDescriptivo
FROM curso
WHERE idCurso IN (
    SELECT curso
    FROM alumno
    GROUP BY curso
    HAVING COUNT(*) = COUNT(beca)
);
```

78. **Listar los alumnos que han obtenido una beca y están matriculados en asignaturas impartidas por un profesor de una provincia específica:**
```sql
SELECT *
FROM alumno
WHERE beca IS NOT NULL AND idAlumno IN (
    SELECT idAlumno
    FROM matricula
    INNER JOIN impartir ON matricula.idAsignatura = impartir.idAsignatura
    INNER JOIN profesor ON impartir.idProfesor = profesor.idProfesor
    WHERE provincia = 'provinciaID'
);
```

79. **Contar cuántas asignaturas imparten los profesores de cada categoría:**
```sql
SELECT categoria, COUNT(DISTINCT idAsignatura) AS num_asignaturas_impartidas
FROM impartir
INNER JOIN profesor ON impartir.idProfesor = profesor.idProfesor
GROUP BY categoria;
```

80. **Calcular el promedio de créditos de asignaturas obligatorias y optativas por cada curso:**
```sql
SELECT curso, AVG(creditos) AS promedio_creditos_obligatorias, AVG(creditos) AS promedio_creditos_optativas
FROM asignatura
GROUP BY curso;
```

81. **Encontrar las asignaturas que tienen más de 5 profesores impartiendo:**
```sql
SELECT *
FROM asignatura
WHERE idAsignatura IN (
    SELECT idAsignatura
    FROM impartir
    GROUP BY idAsignatura
    HAVING COUNT(*) > 5
);
```

82. **Listar los alumnos que han obtenido una beca y están matriculados en asignaturas coordinadas por un profesor de una categoría específica:**
```sql
SELECT *
FROM alumno
WHERE beca IS NOT NULL AND idAlumno IN (
    SELECT idAlumno
    FROM matricula
    INNER JOIN asignatura ON matricula.idAsignatura = asignatura.idAsignatura
    INNER JOIN profesor ON asignatura.coordinador = profesor.idProfesor
    WHERE categoria = 'categoriaID'
);
```

83. **Contar cuántas asignaturas imparte cada profesor:**
```sql
SELECT idProfesor, COUNT(*) AS num_asignaturas_impartidas
FROM impartir
GROUP BY idProfesor;
```

84. **Calcular el promedio de notas de los alumnos en asignaturas coordinadas por cada profesor:**
```sql
SELECT coordinador, AVG(nota) AS promedio_notas
FROM matricula
INNER JOIN asignatura ON matricula.idAsignatura = asignatura.idAsignatura
GROUP BY coordinador;
```

85. **Encontrar las asignaturas que tienen una nota promedio superior a 7:**
```sql
SELECT *
FROM asignatura
WHERE idAsignatura IN (
    SELECT idAsignatura
    FROM matricula
    GROUP BY idAsignatura
    HAVING AVG(nota) > 7
);
```

86. **Listar los profesores que imparten asignaturas en más de un cuatrimestre:**
```sql
SELECT idProfesor, COUNT(DISTINCT cuatrimestre) AS num_cuatrimestres
FROM impartir
INNER JOIN asignatura ON impartir.idAsignatura = asignatura.idAsignatura
GROUP BY idProfesor
HAVING num_cuatrimestres > 1;
```

87. **Encontrar los cursos en los que todos los alumnos tienen teléfono de contacto registrado:**
```sql
SELECT idCurso, nombreDescriptivo
FROM curso
WHERE idCurso IN (
    SELECT curso
    FROM alumno
    GROUP BY curso
    HAVING COUNT(*) = COUNT(
        SELECT DISTINCT idAlumno
        FROM tlfContactoProf
        WHERE tlfContactoProf.idAlumno = alumno.idAlumno
    )
);
```

88. **Listar los alumnos que tienen una beca y están matriculados en asignaturas con más de 6 créditos:**
```sql
SELECT *
FROM alumno
WHERE beca IS NOT NULL AND idAlumno IN (
    SELECT idAlumno
    FROM matricula
    INNER JOIN asignatura ON matricula.idAsignatura = asignatura.idAsignatura
    WHERE creditos > 6
);
```

89. **Contar cuántas asignaturas hay en cada cuatrimestre:**
```sql
SELECT cuatrimestre, COUNT(*) AS num_asignaturas
FROM asignatura
GROUP BY cuatrimestre;
```

90. **Calcular el promedio de créditos de asignaturas por cada profesor coordinador:**
```sql
SELECT coordinador, AVG(creditos) AS promedio_creditos
FROM asignatura
GROUP BY coordinador;
```

91. **Encontrar las asignaturas que tienen una nota mínima de 6:**
```sql
SELECT *
FROM asignatura
WHERE idAsignatura IN (
    SELECT idAsignatura
    FROM matricula
    WHERE nota >= 6
);
```

92. **Listar los profesores que imparten asignaturas en todos los cursos:**
```sql
SELECT idProfesor, nombre
FROM profesor
WHERE idProfesor IN (
    SELECT idProfesor
    FROM impartir
    GROUP BY idProfesor
    HAVING COUNT(DISTINCT curso) = (
        SELECT COUNT(DISTINCT idCurso)
        FROM curso
    )
);
```

93. **Encontrar los cursos que tienen asignaturas con notas promedio superiores a 8:**
```sql
SELECT idCurso, nombreDescriptivo
FROM curso
WHERE idCurso IN (
    SELECT curso
    FROM asignatura
    WHERE idAsignatura IN (
        SELECT idAsignatura
        FROM matricula
        GROUP BY idAsignatura
    HAVING AVG(nota) > 8
);
```

94. **Listar los alumnos que han obtenido una beca y están matriculados en asignaturas impartidas por un profesor con más de 10 años de experiencia:**
```sql
SELECT *
FROM alumno
WHERE beca IS NOT NULL AND idAlumno IN (
    SELECT idAlumno
    FROM matricula
    INNER JOIN impartir ON matricula.idAsignatura = impartir.idAsignatura
    INNER JOIN profesor ON impartir.idProfesor = profesor.idProfesor
    WHERE fecha_contratacion <= CURRENT_DATE - INTERVAL '10 years'
);
```

95. **Contar cuántos alumnos hay matriculados en asignaturas de un determinado tipo (obligatoria u optativa):**
```sql
SELECT caracter, COUNT(DISTINCT idAlumno) AS num_alumnos
FROM matricula
INNER JOIN asignatura ON matricula.idAsignatura = asignatura.idAsignatura
GROUP BY caracter;
```

96. **Calcular la suma de créditos de todas las asignaturas impartidas por cada profesor:**
```sql
SELECT idProfesor, SUM(creditos) AS total_creditos
FROM impartir
INNER JOIN asignatura ON impartir.idAsignatura = asignatura.idAsignatura
GROUP BY idProfesor;
```

97. **Encontrar las asignaturas que tienen una nota máxima de 10:**
```sql
SELECT *
FROM asignatura
WHERE idAsignatura IN (
    SELECT idAsignatura
    FROM matricula
    WHERE nota = 10
);
```

98. **Listar los profesores que imparten asignaturas en todos los cuatrimestres:**
```sql
SELECT idProfesor, nombre
FROM profesor
WHERE idProfesor IN (
    SELECT idProfesor
    FROM impartir
    GROUP BY idProfesor
    HAVING COUNT(DISTINCT cuatrimestre) = (
        SELECT COUNT(DISTINCT cuatrimestre)
        FROM asignatura
    )
);
```

99. **Encontrar los cursos que no tienen asignaturas coordinadas por un profesor de una determinada categoría:**
```sql
SELECT idCurso, nombreDescriptivo
FROM curso
WHERE idCurso NOT IN (
    SELECT curso
    FROM asignatura
    WHERE coordinador IN (
        SELECT idProfesor
        FROM profesor
        WHERE categoria = 'categoriaID'
    )
);
```

100. **Listar los alumnos que han obtenido una beca y están matriculados en asignaturas con más de 4 créditos y coordinadas por un profesor con un determinado NIF:**
```sql
SELECT *
FROM alumno
WHERE beca IS NOT NULL AND idAlumno IN (
    SELECT idAlumno
    FROM matricula
    INNER JOIN asignatura ON matricula.idAsignatura = asignatura.idAsignatura
    WHERE creditos > 4 AND coordinador IN (
        SELECT idProfesor
        FROM profesor
        WHERE NIF = 'NIF_del_profesor'
    )
);
```
