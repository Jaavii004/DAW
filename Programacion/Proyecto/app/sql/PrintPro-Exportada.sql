CREATE DATABASE  IF NOT EXISTS `PrintPro` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `PrintPro`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: javier    Database: PrintPro
-- ------------------------------------------------------
-- Server version	5.5.5-10.5.23-MariaDB-0+deb11u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Clientes`
--

DROP TABLE IF EXISTS `Clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Clientes` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `poblacion` varchar(100) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `f_registro` date DEFAULT current_timestamp(),
  `comentarios` text DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Clientes`
--

LOCK TABLES `Clientes` WRITE;
/*!40000 ALTER TABLE `Clientes` DISABLE KEYS */;
INSERT INTO `Clientes` VALUES (1,'Deposito de Maquinas','Beniparrell','Calle Pimpollo 18','inventa','info.oliplus.es','2024-03-28','Maquinas nuevas o retiradas'),(2,'Colegio El Ave María','Valencia','Carrer de Sagunt, 144','+34 963 85 27 40','info@colegioavemaria.es','2024-04-07','Centro educativo católico'),(3,'IES Isabel de Villena','Valencia','Calle Eslida, 13','+34 963 79 89 70','info@iesisabeldevillena.es','2024-04-07','Instituto de Educación Secundaria'),(4,'IES Lluís Vives','Valencia','Carrer del Doctor Lluch, 23','+34 963 79 40 64','info@iesluivives.org','2024-04-07','Instituto de Educación Secundaria'),(5,'IES Abastos','Valencia','Calle Font de Sant Lluís, 6','+34 963 15 50 56','info@iesabastos.org','2024-04-07','Instituto de Educación Secundaria'),(6,'IES Ramon Llull','Valencia','Carrer de Sant Pere, 4','+34 963 92 49 77','info@iesramonllull.org','2024-04-07','Instituto de Educación Secundaria'),(7,'IES Malilla','Valencia','Carrer dels Tres Creus, 20','+34 963 95 00 71','info@iesmalilla.com','2024-04-07','Instituto de Educación Secundaria'),(8,'IES Benicalap','Valencia','Avinguda del Pius XII, 2','+34 963 17 84 11','info@iesbenicalap.org','2024-04-07','Instituto de Educación Secundaria'),(9,'IES Arabista Ribera','Valencia','Avinguda de Tarongers, 4','+34 963 81 82 40','info@iesarabista.es','2024-04-07','Instituto de Educación Secundaria'),(10,'IES La Moreria','Valencia','Carrer de Santa Rosa, 2','+34 963 26 07 54','info@ieslamoreria.org','2024-04-07','Instituto de Educación Secundaria'),(11,'Colegio El Armelar','Valencia','Carrer de la Reina Doña Maria, 2','+34 963 82 59 72','info@colegioarmelar.com','2024-04-07','Centro educativo católico'),(12,'IES La Sénia','Paiporta','Carrer la Sénia, 3','+34 963 97 16 33','info@ieslasenia.com','2024-04-07','Instituto de Educación Secundaria'),(13,'CEIP L,Horta','Paiporta','Carrer de Jaume I, 9','+34 961 24 47 00','info@ieslhorta.com','2024-04-07','Instituto de Educación Secundaria'),(14,'IES Andreu Alfaro','Paiporta','Carrer del Mestre Serrano, 1','+34 961 21 82 88','info@iesandreualfaro.org','2024-04-07','Instituto de Educación Secundaria');
/*!40000 ALTER TABLE `Clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Consumibles`
--

DROP TABLE IF EXISTS `Consumibles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Consumibles` (
  `id_consumible` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `f_añadido` date DEFAULT current_timestamp(),
  PRIMARY KEY (`id_consumible`),
  UNIQUE KEY `Consumibles_pk` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Consumibles`
--

LOCK TABLES `Consumibles` WRITE;
/*!40000 ALTER TABLE `Consumibles` DISABLE KEYS */;
INSERT INTO `Consumibles` VALUES (1,'CF410A','Cartucho de toner negro original HP CF410A.','2024-04-04'),(2,'C13S051207','Unidad de tambor residual Epson C13S051207.','2024-04-04'),(3,'9630A003AA','Cartucho de toner negro Canon 9630A003AA.','2024-04-04'),(4,'DR820','Unidad de tambor Brother DR820.','2024-04-04'),(5,'CLT-R406','Unidad de tambor residual Samsung CLT-R406.','2024-04-04'),(6,'70C0Z50','Cartucho de toner cian Lexmark 70C0Z50.','2024-04-04'),(7,'593-BBKE','Cartucho de toner amarillo Dell 593-BBKE.','2024-04-04'),(8,'407324','Cartucho de toner negro Ricoh 407324.','2024-04-04'),(9,'106R02777','Cartucho de toner magenta Xerox 106R02777.','2024-04-04'),(10,'TK-5240Y','Cartucho de toner amarillo Kyocera TK-5240Y.','2024-04-04'),(11,'560NT','Cartucho de toner negro Sharp MX-560NT.','2024-04-04'),(12,'KX-FAT92X','Cartucho de toner Panasonic KX-FAT92X.','2024-04-04'),(13,'B0887','Cartucho de toner magenta Olivetti B0887.','2024-04-04'),(14,'T-FC30Y','Cartucho de toner amarillo Toshiba T-FC30Y.','2024-04-04'),(15,'OLB1051','Deposito residual konica.','2024-04-04'),(16,'A0X5152','Cartucho de toner cian Konica Minolta A0X5152.','2024-04-04');
/*!40000 ALTER TABLE `Consumibles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Contactos`
--

DROP TABLE IF EXISTS `Contactos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Contactos` (
  `id_contacto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `cargo` varchar(100) DEFAULT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_contacto`),
  KEY `id_cliente` (`id_cliente`),
  CONSTRAINT `Contactos_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `Clientes` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Contactos`
--

LOCK TABLES `Contactos` WRITE;
/*!40000 ALTER TABLE `Contactos` DISABLE KEYS */;
/*!40000 ALTER TABLE `Contactos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Impresoras`
--

DROP TABLE IF EXISTS `Impresoras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Impresoras` (
  `id_impresora` int(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(11) DEFAULT 1,
  `modelo` varchar(100) DEFAULT NULL,
  `numero_serie` varchar(50) DEFAULT NULL,
  `f_creacion` date DEFAULT current_timestamp(),
  `ubicacion` varchar(255) DEFAULT NULL,
  `ult_mant` date DEFAULT NULL,
  `p_color` int(11) DEFAULT 0,
  `p_bn` int(11) DEFAULT 0,
  `color` tinyint(1) DEFAULT NULL,
  `observaciones` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_impresora`),
  KEY `id_cliente` (`id_cliente`),
  CONSTRAINT `Impresoras_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `Clientes` (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Impresoras`
--

LOCK TABLES `Impresoras` WRITE;
/*!40000 ALTER TABLE `Impresoras` DISABLE KEYS */;
INSERT INTO `Impresoras` VALUES (1,1,'HP LaserJet Pro M402dn','LJ5M2948','2024-03-29','Pasillo',NULL,0,0,-1,'Exposicion'),(2,1,'Epson EcoTank L3150','EPL315021','2024-03-30','Conserjeria',NULL,0,0,-1,'Exposicion'),(3,1,'Canon imageCLASS MF644Cdw','CCMF644154','2024-03-30','Sala de Profesores',NULL,0,0,-1,'Exposicion'),(4,1,'Brother HL-L2370DW','BHLL237026','2024-03-30','Pasillo',NULL,0,0,-1,'Exposicion'),(5,1,'Samsung Xpress M2020W','SXMPR202003','2024-03-30','Conserjeria',NULL,0,0,-1,'Exposicion'),(6,1,'Lexmark B2236dw','LXBM223601','2024-03-30','Pasillo',NULL,0,0,-1,'Exposicion'),(7,1,'Dell Color Multifunction Printer C1765nfw','DCMPC176501','2024-03-30','Conserjeria',NULL,0,0,-1,'Exposicion'),(8,1,'Ricoh SP C261SFNw','RCSPC261004','2024-03-30','Pasillo',NULL,0,0,-1,'Exposicion'),(9,1,'Xerox Phaser 6510','XRPH651002','2024-03-30','Sala de Profesores',NULL,0,0,-1,'Exposicion'),(10,1,'Kyocera ECOSYS P5021cdw','KYECP502105','2024-03-30','Conserjeria',NULL,0,0,-1,'Exposicion'),(11,1,'Sharp MX-B450W','SHPMXB450008','2024-03-30','Pasillo',NULL,0,0,-1,'Exposicion'),(12,1,'Panasonic KX-MB2061ML','PNKXMB206105','2024-03-30','Sala de Profesores',NULL,0,0,1,'Exposicion'),(13,1,'Olivetti d-Color MF3301','OLDCMF330106','2024-03-30','Conserjeria',NULL,0,0,0,'Exposicion'),(14,1,'Toshiba e-STUDIO181','TBES181004','2024-03-30','Pasillo',NULL,0,0,-1,'Exposicion'),(15,1,'Konica Minolta bizhub C3100P','KMC310005','2024-03-30','Conserjeria',NULL,0,0,-1,'Exposicion');
/*!40000 ALTER TABLE `Impresoras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Incidencias`
--

DROP TABLE IF EXISTS `Incidencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Incidencias` (
  `id_incidencia` int(11) NOT NULL AUTO_INCREMENT,
  `id_impresora` int(11) DEFAULT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `f_creacion` timestamp NOT NULL DEFAULT current_timestamp(),
  `estado` tinyint(1) DEFAULT 0,
  `contacto` varchar(100) DEFAULT NULL,
  `impreso` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`id_incidencia`),
  KEY `id_impresora` (`id_impresora`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `Incidencias_ibfk_1` FOREIGN KEY (`id_impresora`) REFERENCES `Impresoras` (`id_impresora`),
  CONSTRAINT `Incidencias_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `Clientes` (`id_cliente`),
  CONSTRAINT `Incidencias_ibfk_3` FOREIGN KEY (`id_usuario`) REFERENCES `Usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Incidencias`
--

LOCK TABLES `Incidencias` WRITE;
/*!40000 ALTER TABLE `Incidencias` DISABLE KEYS */;
INSERT INTO `Incidencias` VALUES (6,1,1,1,'Atasco de papel en la bandeja de entrada.','2024-03-31 06:35:49',0,'Juan',0),(7,2,2,3,'Fallo en la impresion de informes importantes.','2024-03-31 06:35:49',0,'Maria',0),(8,1,3,3,'Error de conexion con la impresora.','2024-03-31 06:35:49',0,'Carlos',0),(9,3,2,1,'Aparicion de mensaje de error en la pantalla de la impresora.','2024-03-31 06:35:49',0,'Laura',0),(10,2,1,3,'Impresion de documentos con calidad borrosa.','2024-03-31 06:35:49',0,'Ana',0),(11,1,1,1,'Atasco de papel en la bandeja de salida.','2024-03-31 06:57:52',0,'Juan',1),(12,1,1,1,'Atasco de papel en la bandeja de entrada.','2024-03-31 06:58:09',0,'Manuel',0),(13,1,1,1,'Incidencia de prueba.','2024-03-31 08:12:47',0,'Antonio',0),(14,1,1,1,'Incidencia de prueba.','2024-03-31 08:13:58',0,'Antonio',0),(15,1,1,1,'Incidencia de prueba.','2024-03-31 08:15:17',0,'Antonio',0),(18,1,1,1,'Atasco de papel en la bandeja de entrada.','2024-04-02 13:30:57',0,'Manuel',0),(20,1,1,1,'Incidencia de prueba.','2024-04-02 13:42:00',0,'Antonio',0),(21,1,1,1,'Juan se a caiddo','2024-04-02 14:50:31',0,'Juan',0),(22,2,1,3,'Problemas con la interfaz de usuario.','2024-04-02 15:02:31',0,'Pepita',1),(23,13,1,3,'Error en la interfaz al realizar la impresion.','2024-04-02 15:15:40',0,'Paquita',1),(24,13,1,3,'Falla en la interfaz de usuario.','2024-04-02 15:19:02',0,'Ernesto',1),(25,13,1,3,'Problemas de comunicacion con la interfaz.','2024-04-02 15:30:54',0,'Pepito',1);
/*!40000 ALTER TABLE `Incidencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Roles`
--

DROP TABLE IF EXISTS `Roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Roles` (
  `id_rol` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id_rol`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Roles`
--

LOCK TABLES `Roles` WRITE;
/*!40000 ALTER TABLE `Roles` DISABLE KEYS */;
INSERT INTO `Roles` VALUES (2,'admin'),(1,'superadmin'),(3,'tecnico');
/*!40000 ALTER TABLE `Roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tecnicos`
--

DROP TABLE IF EXISTS `Tecnicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Tecnicos` (
  `id_tecnico` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `dni` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_tecnico`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tecnicos`
--

LOCK TABLES `Tecnicos` WRITE;
/*!40000 ALTER TABLE `Tecnicos` DISABLE KEYS */;
INSERT INTO `Tecnicos` VALUES (1,'Fran','Garcia','623987654','12345678A'),(2,'Raul','Martinez','634789012','23456789B'),(3,'Jorge','Lopez','645890123','34567890C'),(4,'Javier','Fernandez','656901234','45678901D'),(5,'Pedro','Gonzalez','667012345','56789012E');
/*!40000 ALTER TABLE `Tecnicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuarios`
--

DROP TABLE IF EXISTS `Usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_usuario` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `id_rol` int(11) NOT NULL DEFAULT 3,
  `ultimo_InicioSesion` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `nombre_usuario` (`nombre_usuario`),
  KEY `id_rol` (`id_rol`),
  CONSTRAINT `Usuarios_ibfk_1` FOREIGN KEY (`id_rol`) REFERENCES `Roles` (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuarios`
--

LOCK TABLES `Usuarios` WRITE;
/*!40000 ALTER TABLE `Usuarios` DISABLE KEYS */;
INSERT INTO `Usuarios` VALUES (1,'usuario_prueba','NombrePrueba','ApellidoPrueba','correo@example.com','123456789','63a9f0ea7bb98050796b649e85481845',3,'2024-03-28 00:00:00'),(3,'superuser','Super','Usuario','superuser@javier.com','123456789','63a9f0ea7bb98050796b649e85481845',1,'2024-04-02 19:30:15'),(6,'root','Admin','Root','root@javier.com','123456789','63a9f0ea7bb98050796b649e85481845',2,'2024-04-02 18:49:13'),(7,'usu','usu','usu','usu','1234567','63a9f0ea7bb98050796b649e85481845',2,'2024-03-29 00:00:00'),(8,'adminuser','adminuser','user','user@usuer-com','12345453','63a9f0ea7bb98050796b649e85481845',1,'2024-04-01 00:00:00');
/*!40000 ALTER TABLE `Usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-07 10:50:14