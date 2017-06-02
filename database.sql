-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: list_schema
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groups` (
  `group_number` varchar(6) NOT NULL,
  `student_id` int(11) NOT NULL,
  PRIMARY KEY (`group_number`,`student_id`),
  UNIQUE KEY `student_id_UNIQUE` (`student_id`),
  CONSTRAINT `fk_group_student_student_id` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES ('350504',1),('350504',2),('350503',3),('350504',4),('350504',5),('350504',6),('350504',7),('350504',8),('350504',9),('350504',10),('350504',11),('350504',12),('350504',13),('350504',14),('350504',15),('350504',16),('350504',17),('350504',18),('350504',19),('350504',20),('350504',21),('350504',22);
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lesson`
--

DROP TABLE IF EXISTS `lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lesson_name` varchar(45) NOT NULL,
  `lesson_type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lesson`
--

LOCK TABLES `lesson` WRITE;
/*!40000 ALTER TABLE `lesson` DISABLE KEYS */;
INSERT INTO `lesson` VALUES (1,'КПП','Laboratory'),(2,'КПиЯП','Laboratory'),(3,'СПОЛКС','Laboratory'),(4,'СПОВМ','Laboratory'),(5,'Схемотехника','Laboratory');
/*!40000 ALTER TABLE `lesson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marks`
--

DROP TABLE IF EXISTS `marks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marks` (
  `schedule_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `mark` int(11) NOT NULL,
  `absent` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`schedule_id`,`student_id`),
  KEY `fk_marks_student_student_id_idx` (`student_id`),
  CONSTRAINT `fk_marks_schedule_schedule_id` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`schedule_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_marks_student_student_id` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marks`
--

LOCK TABLES `marks` WRITE;
/*!40000 ALTER TABLE `marks` DISABLE KEYS */;
INSERT INTO `marks` VALUES (1,1,4,NULL),(1,2,5,1),(1,4,10,NULL),(1,8,7,NULL),(1,9,8,NULL),(1,12,6,NULL),(1,13,1,NULL),(1,15,9,NULL),(1,16,5,NULL),(1,21,8,NULL),(2,1,3,NULL),(2,2,7,NULL),(2,4,7,NULL),(2,7,9,NULL),(2,11,5,NULL),(2,12,7,NULL),(2,13,8,NULL),(2,14,3,NULL),(2,17,6,NULL),(2,18,7,NULL),(2,19,7,NULL),(2,20,7,NULL),(2,21,8,NULL),(2,22,6,NULL),(3,1,8,NULL),(3,2,7,NULL),(3,4,6,NULL),(3,5,7,NULL),(3,6,5,NULL),(3,8,6,NULL),(3,9,7,NULL),(3,10,4,NULL),(3,11,3,NULL),(3,14,5,NULL),(3,17,6,NULL),(4,1,5,NULL),(4,2,4,NULL),(4,5,5,NULL),(4,7,4,NULL),(4,8,5,NULL),(4,9,4,NULL),(4,13,5,NULL),(4,15,7,NULL),(4,17,9,NULL),(4,18,8,NULL),(4,19,7,NULL),(5,2,5,NULL),(5,4,7,NULL),(5,5,5,NULL),(5,6,6,NULL),(5,7,4,NULL),(5,8,3,NULL),(5,9,4,NULL),(5,16,5,NULL),(5,18,6,NULL),(5,19,7,NULL),(6,2,10,NULL),(6,4,8,NULL),(6,6,6,NULL),(6,7,5,NULL),(6,8,6,NULL),(6,9,7,NULL),(6,10,8,NULL),(6,11,7,NULL),(6,16,6,NULL),(6,17,5,NULL),(6,18,4,NULL),(7,1,5,NULL),(7,2,3,NULL),(7,9,4,NULL),(7,10,7,NULL),(7,13,5,NULL),(7,14,7,NULL),(7,16,6,NULL),(7,18,7,NULL),(7,19,6,NULL);
/*!40000 ALTER TABLE `marks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_number` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `room_number_UNIQUE` (`room_number`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (2,'501'),(3,'505а'),(1,'514');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule` (
  `schedule_id` int(11) NOT NULL,
  `date_time` datetime NOT NULL,
  `group_number` varchar(45) NOT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL,
  `lesson_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`group_number`,`schedule_id`),
  UNIQUE KEY `shedule_id_UNIQUE` (`schedule_id`),
  KEY `fk_schedule_teacher_teacher_id_idx` (`teacher_id`),
  KEY `fk_schedule_room_room_id_idx` (`room_id`),
  KEY `fk_schedule_lesson_lesson_id_idx` (`lesson_id`),
  CONSTRAINT `fk_schedule_group_group_number` FOREIGN KEY (`group_number`) REFERENCES `groups` (`group_number`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_schedule_lesson_lesson_id` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_schedule_room_room_id` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_schedule_teacher_teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,'2017-03-03 11:45:00','350504',3,1,1),(2,'2017-03-05 11:45:00','350504',3,2,1),(3,'2017-03-09 11:45:00','350504',3,2,1),(4,'2017-03-11 11:45:00','350504',3,2,1),(5,'2017-03-14 11:45:00','350504',3,1,1),(6,'2017-03-17 11:45:00','350504',3,2,1),(7,'2017-03-21 11:45:00','350504',3,1,1);
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_card_number` varchar(45) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `student_card_number_UNIQUE` (`student_card_number`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  CONSTRAINT `fk_student_user_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'0132203',NULL,'Алексей','Пискун'),(2,'0132506',NULL,'Александр','Молотовник'),(3,'0132507',NULL,'Станистав','Маковский'),(4,'0132508',NULL,'Евгений','Шилов'),(5,'0132509',NULL,'Артем','Борбровник'),(6,'0132499',NULL,'Александр','Янушкевич'),(7,'0132500',NULL,'Антон','Качан'),(8,'0132515',NULL,'Диана','Куприянова'),(9,'0132516',NULL,'Андрей','Савич'),(10,'0132517',NULL,'Павел','Евсаев'),(11,'0132518',NULL,'Андрей','Валынко'),(12,'0132519',NULL,'Никита','Давидович'),(13,'0132520',NULL,'Анастасия','Суворова'),(14,'0132521',NULL,'Александр','Сахаров'),(15,'0132522',NULL,'Роман','Черноокий'),(16,'0132523',NULL,'Сергей','Шелег'),(17,'0132524',NULL,'Дмитрий','Басов'),(18,'0132525',NULL,'Артем','Харченко'),(19,'0132526',NULL,'Никита','Павлович'),(20,'0132527',NULL,'Александр','Челочев'),(21,'0132528',NULL,'Андрей','Тарулис'),(22,'0132529',NULL,'Андрей','Савва');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `position` varchar(45) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  CONSTRAINT `fk_teacher_user_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'Аспирант',NULL,'Евгений','Кухарчук'),(2,'Аспирант',NULL,'Иван','Глецевич'),(3,'Доцент',3,'Пискунов','Алекс');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `rank` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `iduser_UNIQUE` (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','21232f297a57a5a743894a0e4a801fc3',5),(2,'alex','a029d0df84eb5549c641e04a9ef389e5',2),(3,'teacher','a029d0df84eb5549c641e04a9ef389e5',3),(4,'newTeach','a029d0df84eb5549c641e04a9ef389e5',3);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-02 17:34:09
