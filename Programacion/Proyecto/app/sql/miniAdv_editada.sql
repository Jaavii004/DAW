-- MariaDB dump 10.19  Distrib 10.5.23-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: miniAdv
-- ------------------------------------------------------
-- Server version	10.5.23-MariaDB-0+deb11u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
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
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Clientes` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `poblacion` varchar(100) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `f_registro` date DEFAULT curdate(),
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
INSERT INTO `Clientes` VALUES (1,'Deposito de Maquinas','Beniparrell','Calle Pimpollo 18','inventa','info.oliplus.es','2024-03-28','Maquinas nuevas o retiradas'),(2,'Google','Mountain View, California','1600 Amphitheatre Parkway','+1 650-253-0000','info@google.com','2024-03-30','Motor de búsqueda y servicios en línea'),(3,'Amazon','Seattle, Washington','410 Terry Ave N','+1 (888) 280-4331','info@amazon.com','2024-03-30','Comercio electrónico, computación en la nube, streaming de video y más'),(4,'Apple','Cupertino, California','1 Apple Park Way','+1 (800) 692-7753','info@apple.com','2024-03-30','Productos electrónicos, software y servicios en línea'),(5,'Microsoft','Redmond, Washington','One Microsoft Way','+1 (800) 642-7676','msinfo@microsoft.com','2024-03-30','Desarrollo, licenciamiento y soporte de software'),(6,'Facebook','Menlo Park, California','1 Hacker Way','+1 (650) 543-4800','info@facebook.com','2024-03-30','Red social y servicios relacionados'),(7,'Tesla','Palo Alto, California','3500 Deer Creek Rd','+1 (888) 518-3752','info@tesla.com','2024-03-30','Fabricación de vehículos eléctricos y almacenamiento de energía'),(8,'Alphabet Inc.','Mountain View, California','1600 Amphitheatre Parkway','+1 650-253-0000','info@abc.xyz','2024-03-30','Empresa matriz de Google y otras subsidiarias'),(9,'Samsung','Seúl, Corea del Sur','129 Samsung-ro','+82-2-2255-0114','support@samsung.com','2024-03-30','Electrónica de consumo, dispositivos móviles y electrodomésticos'),(10,'Walmart','Bentonville, Arkansas','702 SW 8th St','+1 (800) 925-6278','help@walmart.com','2024-03-30','Venta al por menor, supermercados y tiendas de descuento'),(11,'Toyota','Toyota City, Japón','Toyota-cho, Toyota','+81-565-28-2121','toyota@email.toyota.com','2024-03-30','Fabricación y venta de automóviles, camiones y autobuses'),(12,'Olimpus','paiporta','gaga','1235648','javier@javier.com','2024-03-30','es');
/*!40000 ALTER TABLE `Clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Consumibles`
--

DROP TABLE IF EXISTS `Consumibles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Consumibles` (
  `id_consumible` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `f_añadido` date DEFAULT curdate(),
  PRIMARY KEY (`id_consumible`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Consumibles`
--

LOCK TABLES `Consumibles` WRITE;
/*!40000 ALTER TABLE `Consumibles` DISABLE KEYS */;
/*!40000 ALTER TABLE `Consumibles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Contactos`
--

DROP TABLE IF EXISTS `Contactos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Impresoras`
--

LOCK TABLES `Impresoras` WRITE;
/*!40000 ALTER TABLE `Impresoras` DISABLE KEYS */;
INSERT INTO `Impresoras` VALUES (1,1,'1','1','2024-03-29','paiporta',NULL,0,0,-1,'er'),(2,1,'Modelo 2','Serie 2','2024-03-30','Ubicación 2',NULL,0,0,-1,'Observaciones 2'),(3,1,'Modelo 3','Serie 3','2024-03-30','Ubicación 3',NULL,0,0,-1,'Observaciones 3'),(4,1,'Modelo 4','Serie 4','2024-03-30','Ubicación 4',NULL,0,0,-1,'Observaciones 4'),(5,1,'Modelo 5','Serie 5','2024-03-30','Ubicación 5',NULL,0,0,-1,'Observaciones 5'),(6,1,'Modelo 6','Serie 6','2024-03-30','Ubicación 6',NULL,0,0,-1,'Observaciones 6'),(7,1,'Modelo 7','Serie 7','2024-03-30','Ubicación 7',NULL,0,0,-1,'Observaciones 7'),(8,1,'Modelo 8','Serie 8','2024-03-30','Ubicación 8',NULL,0,0,-1,'Observaciones 8'),(9,1,'Modelo 9','Serie 9','2024-03-30','Ubicación 9',NULL,0,0,-1,'Observaciones 9'),(10,1,'Modelo 10','Serie 10','2024-03-30','Ubicación 10',NULL,0,0,-1,'Observaciones 10'),(11,1,'Modelo 11','Serie 11','2024-03-30','Ubicación 11',NULL,0,0,-1,'Observaciones 11');
/*!40000 ALTER TABLE `Impresoras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Incidencias`
--

DROP TABLE IF EXISTS `Incidencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Incidencias` (
  `id_incidencia` int(11) NOT NULL AUTO_INCREMENT,
  `id_impresora` int(11) DEFAULT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `f_creacion` timestamp NOT NULL DEFAULT current_timestamp(),
  `estado` tinyint(1) DEFAULT NULL,
  `contacto` varchar(100) DEFAULT NULL,
  `impreso` tinyint(1) DEFAULT -1,
  PRIMARY KEY (`id_incidencia`),
  KEY `id_impresora` (`id_impresora`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `Incidencias_ibfk_1` FOREIGN KEY (`id_impresora`) REFERENCES `Impresoras` (`id_impresora`),
  CONSTRAINT `Incidencias_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `Clientes` (`id_cliente`),
  CONSTRAINT `Incidencias_ibfk_3` FOREIGN KEY (`id_usuario`) REFERENCES `Usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Incidencias`
--

LOCK TABLES `Incidencias` WRITE;
/*!40000 ALTER TABLE `Incidencias` DISABLE KEYS */;
/*!40000 ALTER TABLE `Incidencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Intervencion_Consumible`
--

DROP TABLE IF EXISTS `Intervencion_Consumible`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Intervencion_Consumible` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_intervencion` int(11) DEFAULT NULL,
  `id_consumible` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_intervencion` (`id_intervencion`),
  KEY `id_consumible` (`id_consumible`),
  CONSTRAINT `Intervencion_Consumible_ibfk_1` FOREIGN KEY (`id_intervencion`) REFERENCES `Intervenciones` (`id_intervencion`),
  CONSTRAINT `Intervencion_Consumible_ibfk_2` FOREIGN KEY (`id_consumible`) REFERENCES `Consumibles` (`id_consumible`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Intervencion_Consumible`
--

LOCK TABLES `Intervencion_Consumible` WRITE;
/*!40000 ALTER TABLE `Intervencion_Consumible` DISABLE KEYS */;
/*!40000 ALTER TABLE `Intervencion_Consumible` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Intervenciones`
--

DROP TABLE IF EXISTS `Intervenciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Intervenciones` (
  `id_intervencion` int(11) NOT NULL AUTO_INCREMENT,
  `id_incidencia` int(11) DEFAULT NULL,
  `id_tecnico` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `f_intervencion` timestamp NOT NULL DEFAULT current_timestamp(),
  `copias_color` int(11) DEFAULT NULL,
  `copias_bn` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_intervencion`),
  KEY `id_incidencia` (`id_incidencia`),
  KEY `id_tecnico` (`id_tecnico`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `Intervenciones_ibfk_1` FOREIGN KEY (`id_incidencia`) REFERENCES `Incidencias` (`id_incidencia`),
  CONSTRAINT `Intervenciones_ibfk_2` FOREIGN KEY (`id_tecnico`) REFERENCES `Tecnicos` (`id_tecnico`),
  CONSTRAINT `Intervenciones_ibfk_3` FOREIGN KEY (`id_usuario`) REFERENCES `Usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Intervenciones`
--

LOCK TABLES `Intervenciones` WRITE;
/*!40000 ALTER TABLE `Intervenciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `Intervenciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Roles`
--

DROP TABLE IF EXISTS `Roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Roles` (
  `id_rol` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Roles`
--

LOCK TABLES `Roles` WRITE;
/*!40000 ALTER TABLE `Roles` DISABLE KEYS */;
INSERT INTO `Roles` VALUES (1,'superadmin'),(2,'admin'),(3,'usuario');
/*!40000 ALTER TABLE `Roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tecnicos`
--

DROP TABLE IF EXISTS `Tecnicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tecnicos` (
  `id_tecnico` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `dni` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_tecnico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tecnicos`
--

LOCK TABLES `Tecnicos` WRITE;
/*!40000 ALTER TABLE `Tecnicos` DISABLE KEYS */;
/*!40000 ALTER TABLE `Tecnicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuarios`
--

DROP TABLE IF EXISTS `Usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_usuario` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `contraseña` varchar(100) NOT NULL,
  `id_rol` int(11) NOT NULL DEFAULT 3,
  `ultimo_InicioSesion` date DEFAULT curdate(),
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `nombre_usuario` (`nombre_usuario`),
  KEY `id_rol` (`id_rol`),
  CONSTRAINT `Usuarios_ibfk_1` FOREIGN KEY (`id_rol`) REFERENCES `Roles` (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuarios`
--

LOCK TABLES `Usuarios` WRITE;
/*!40000 ALTER TABLE `Usuarios` DISABLE KEYS */;
INSERT INTO `Usuarios` VALUES (1,'usuario_prueba','NombrePrueba','ApellidoPrueba','correo@example.com','123456789','4c882dcb24bcb1bc225391a602feca7c',3,'2024-03-28'),(3,'superuser','Super','Usuario','superuser@javier.com','123456789','63a9f0ea7bb98050796b649e85481845',1,'2024-03-28'),(6,'root','Admin','Root','root@javier.com','123456789','63a9f0ea7bb98050796b649e85481845',2,'2024-03-30'),(7,'usu','usu','usu','usu','1234567','81dc9bdb52d04dc20036dbd8313ed055',2,'2024-03-29');
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

-- Dump completed on 2024-03-30 13:32:02
