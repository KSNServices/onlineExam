-- MySQL dump 10.13  Distrib 5.5.21, for Win64 (x86)
--
-- Host: localhost    Database: school_db
-- ------------------------------------------------------
-- Server version	5.5.21

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
-- Table structure for table `academic_year`
--

DROP TABLE IF EXISTS `academic_year`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `academic_year` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` varchar(32) DEFAULT NULL,
  `description` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `academic_year`
--

LOCK TABLES `academic_year` WRITE;
/*!40000 ALTER TABLE `academic_year` DISABLE KEYS */;
/*!40000 ALTER TABLE `academic_year` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `applicant_document`
--

DROP TABLE IF EXISTS `applicant_document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `applicant_document` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `application_form_id` int(11) DEFAULT NULL,
  `document_name` varchar(32) DEFAULT NULL,
  `path` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `application_form_id` (`application_form_id`),
  CONSTRAINT `applicant_document_ibfk_1` FOREIGN KEY (`application_form_id`) REFERENCES `applicantion_form` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applicant_document`
--

LOCK TABLES `applicant_document` WRITE;
/*!40000 ALTER TABLE `applicant_document` DISABLE KEYS */;
/*!40000 ALTER TABLE `applicant_document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `applicant_qualification_details`
--

DROP TABLE IF EXISTS `applicant_qualification_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `applicant_qualification_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `application_form_id` int(11) DEFAULT NULL,
  `qualification_name` varchar(64) DEFAULT NULL,
  `college_name` varchar(256) DEFAULT NULL,
  `board_name` varchar(128) DEFAULT NULL,
  `passing_year` varchar(32) DEFAULT NULL,
  `marks_obtained` double DEFAULT NULL,
  `medium` varchar(32) DEFAULT NULL,
  `subjects` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `application_form_id` (`application_form_id`),
  CONSTRAINT `applicant_qualification_details_ibfk_1` FOREIGN KEY (`application_form_id`) REFERENCES `applicantion_form` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applicant_qualification_details`
--

LOCK TABLES `applicant_qualification_details` WRITE;
/*!40000 ALTER TABLE `applicant_qualification_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `applicant_qualification_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `applicant_work_history`
--

DROP TABLE IF EXISTS `applicant_work_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `applicant_work_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `application_form_id` int(11) DEFAULT NULL,
  `organization_name` varchar(128) DEFAULT NULL,
  `location` varchar(64) DEFAULT NULL,
  `designation` varchar(128) DEFAULT NULL,
  `from_date` date DEFAULT NULL,
  `to_date` date DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `reason_of_leaving` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `application_form_id` (`application_form_id`),
  CONSTRAINT `applicant_work_history_ibfk_1` FOREIGN KEY (`application_form_id`) REFERENCES `applicantion_form` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applicant_work_history`
--

LOCK TABLES `applicant_work_history` WRITE;
/*!40000 ALTER TABLE `applicant_work_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `applicant_work_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `applicantion_form`
--

DROP TABLE IF EXISTS `applicantion_form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `applicantion_form` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `institution_choice_id` int(11) DEFAULT NULL,
  `exam_center_id` int(11) DEFAULT NULL,
  `recruitment_master_id` int(11) DEFAULT NULL,
  `first_name` varchar(32) DEFAULT NULL,
  `middle_name` varchar(32) DEFAULT NULL,
  `last_name` varchar(32) DEFAULT NULL,
  `father_name` varchar(32) DEFAULT NULL,
  `mother_name` varchar(32) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `mobile_number` varchar(32) DEFAULT NULL,
  `emailId` varchar(256) DEFAULT NULL,
  `gender` varchar(32) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `blood_group` varchar(32) DEFAULT NULL,
  `marital_status` varchar(32) DEFAULT NULL,
  `user_image` varchar(256) DEFAULT NULL,
  `enrolment_number` varchar(32) DEFAULT NULL,
  `application_status` varchar(32) DEFAULT NULL,
  `applicant_status` varchar(32) DEFAULT NULL,
  `description` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `institution_choice_id` (`institution_choice_id`),
  KEY `exam_center_id` (`exam_center_id`),
  KEY `category_id` (`category_id`),
  KEY `recruitment_master_id` (`recruitment_master_id`),
  CONSTRAINT `applicantion_form_ibfk_1` FOREIGN KEY (`institution_choice_id`) REFERENCES `institute` (`id`),
  CONSTRAINT `applicantion_form_ibfk_2` FOREIGN KEY (`exam_center_id`) REFERENCES `institute` (`id`),
  CONSTRAINT `applicantion_form_ibfk_3` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`),
  CONSTRAINT `applicantion_form_ibfk_4` FOREIGN KEY (`recruitment_master_id`) REFERENCES `recruitment_master` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applicantion_form`
--

LOCK TABLES `applicantion_form` WRITE;
/*!40000 ALTER TABLE `applicantion_form` DISABLE KEYS */;
/*!40000 ALTER TABLE `applicantion_form` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(128) DEFAULT NULL,
  `descrition` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(128) DEFAULT NULL,
  `state_id` int(11) DEFAULT NULL,
  `country_id` int(11) DEFAULT NULL,
  `description` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `state_id` (`state_id`),
  KEY `country_id` (`country_id`),
  CONSTRAINT `city_ibfk_1` FOREIGN KEY (`state_id`) REFERENCES `state` (`id`),
  CONSTRAINT `city_ibfk_2` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(128) DEFAULT NULL,
  `description` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `institute`
--

DROP TABLE IF EXISTS `institute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `institute` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `institude_name` varchar(32) DEFAULT NULL,
  `established_year` varchar(32) DEFAULT NULL,
  `vision` varchar(128) DEFAULT NULL,
  `mission` varchar(256) DEFAULT NULL,
  `mother_name` varchar(128) DEFAULT NULL,
  `principal_name` varchar(32) DEFAULT NULL,
  `institude_logo` varchar(256) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `description` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `institute`
--

LOCK TABLES `institute` WRITE;
/*!40000 ALTER TABLE `institute` DISABLE KEYS */;
/*!40000 ALTER TABLE `institute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modules`
--

DROP TABLE IF EXISTS `modules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modules` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `module_name` varchar(128) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `description` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modules`
--

LOCK TABLES `modules` WRITE;
/*!40000 ALTER TABLE `modules` DISABLE KEYS */;
/*!40000 ALTER TABLE `modules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `online_exam_levels`
--

DROP TABLE IF EXISTS `online_exam_levels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `online_exam_levels` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level_name` varchar(128) DEFAULT NULL,
  `description` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `online_exam_levels`
--

LOCK TABLES `online_exam_levels` WRITE;
/*!40000 ALTER TABLE `online_exam_levels` DISABLE KEYS */;
/*!40000 ALTER TABLE `online_exam_levels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `online_exam_subjects`
--

DROP TABLE IF EXISTS `online_exam_subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `online_exam_subjects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level_id` int(11) DEFAULT NULL,
  `subject_name` varchar(128) DEFAULT NULL,
  `description` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `level_id` (`level_id`),
  CONSTRAINT `online_exam_subjects_ibfk_1` FOREIGN KEY (`level_id`) REFERENCES `online_exam_levels` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `online_exam_subjects`
--

LOCK TABLES `online_exam_subjects` WRITE;
/*!40000 ALTER TABLE `online_exam_subjects` DISABLE KEYS */;
/*!40000 ALTER TABLE `online_exam_subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_plan_details`
--

DROP TABLE IF EXISTS `payment_plan_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment_plan_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `payment_plan_name` varchar(128) DEFAULT NULL,
  `payment_plan_mode` int(11) DEFAULT NULL,
  `validity` int(11) DEFAULT NULL,
  `plan_description` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_plan_details`
--

LOCK TABLES `payment_plan_details` WRITE;
/*!40000 ALTER TABLE `payment_plan_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment_plan_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recruitment_master`
--

DROP TABLE IF EXISTS `recruitment_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recruitment_master` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `academic_year_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `description` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recruitment_master`
--

LOCK TABLES `recruitment_master` WRITE;
/*!40000 ALTER TABLE `recruitment_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `recruitment_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recruitment_question_ans_options`
--

DROP TABLE IF EXISTS `recruitment_question_ans_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recruitment_question_ans_options` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `option_statement` varchar(512) DEFAULT NULL,
  `recruitment_questions_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `recruitment_questions_id` (`recruitment_questions_id`),
  CONSTRAINT `recruitment_question_ans_options_ibfk_1` FOREIGN KEY (`recruitment_questions_id`) REFERENCES `recruitment_questions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recruitment_question_ans_options`
--

LOCK TABLES `recruitment_question_ans_options` WRITE;
/*!40000 ALTER TABLE `recruitment_question_ans_options` DISABLE KEYS */;
/*!40000 ALTER TABLE `recruitment_question_ans_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recruitment_question_set_details`
--

DROP TABLE IF EXISTS `recruitment_question_set_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recruitment_question_set_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `online_exam_level_id` int(11) DEFAULT NULL,
  `total_questions` int(11) DEFAULT NULL,
  `total_sets` int(11) DEFAULT NULL,
  `academic_year_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `online_exam_level_id` (`online_exam_level_id`),
  CONSTRAINT `recruitment_question_set_details_ibfk_1` FOREIGN KEY (`online_exam_level_id`) REFERENCES `online_exam_levels` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recruitment_question_set_details`
--

LOCK TABLES `recruitment_question_set_details` WRITE;
/*!40000 ALTER TABLE `recruitment_question_set_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `recruitment_question_set_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recruitment_questions`
--

DROP TABLE IF EXISTS `recruitment_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recruitment_questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_statement` varchar(512) DEFAULT NULL,
  `online_exam_subjects_id` int(11) DEFAULT NULL,
  `status` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `online_exam_subjects_id` (`online_exam_subjects_id`),
  CONSTRAINT `recruitment_questions_ibfk_1` FOREIGN KEY (`online_exam_subjects_id`) REFERENCES `online_exam_subjects` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recruitment_questions`
--

LOCK TABLES `recruitment_questions` WRITE;
/*!40000 ALTER TABLE `recruitment_questions` DISABLE KEYS */;
/*!40000 ALTER TABLE `recruitment_questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recruitment_questions_set_subject_details`
--

DROP TABLE IF EXISTS `recruitment_questions_set_subject_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recruitment_questions_set_subject_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `recruitment_questions_set_id` int(11) DEFAULT NULL,
  `online_exam_subject_id` int(11) DEFAULT NULL,
  `total_questions` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `online_exam_subject_id` (`online_exam_subject_id`),
  KEY `recruitment_questions_set_id` (`recruitment_questions_set_id`),
  CONSTRAINT `recruitment_questions_set_subject_details_ibfk_1` FOREIGN KEY (`online_exam_subject_id`) REFERENCES `online_exam_subjects` (`id`),
  CONSTRAINT `recruitment_questions_set_subject_details_ibfk_2` FOREIGN KEY (`recruitment_questions_set_id`) REFERENCES `recruitment_questions_sets` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recruitment_questions_set_subject_details`
--

LOCK TABLES `recruitment_questions_set_subject_details` WRITE;
/*!40000 ALTER TABLE `recruitment_questions_set_subject_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `recruitment_questions_set_subject_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recruitment_questions_sets`
--

DROP TABLE IF EXISTS `recruitment_questions_sets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recruitment_questions_sets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `recruitment_question_set_details_id` int(11) DEFAULT NULL,
  `recruitment_questions_sets_name` varchar(128) DEFAULT NULL,
  `total_questions` int(11) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `recruitment_question_set_details_id` (`recruitment_question_set_details_id`),
  CONSTRAINT `recruitment_questions_sets_ibfk_1` FOREIGN KEY (`recruitment_question_set_details_id`) REFERENCES `recruitment_question_set_details` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recruitment_questions_sets`
--

LOCK TABLES `recruitment_questions_sets` WRITE;
/*!40000 ALTER TABLE `recruitment_questions_sets` DISABLE KEYS */;
/*!40000 ALTER TABLE `recruitment_questions_sets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recruitment_set_questions`
--

DROP TABLE IF EXISTS `recruitment_set_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recruitment_set_questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `recruitment_questions_sets_id` int(11) DEFAULT NULL,
  `recruitment_questions_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `recruitment_questions_id` (`recruitment_questions_id`),
  KEY `recruitment_questions_sets_id` (`recruitment_questions_sets_id`),
  CONSTRAINT `recruitment_set_questions_ibfk_1` FOREIGN KEY (`recruitment_questions_id`) REFERENCES `recruitment_questions` (`id`),
  CONSTRAINT `recruitment_set_questions_ibfk_2` FOREIGN KEY (`recruitment_questions_sets_id`) REFERENCES `recruitment_questions_sets` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recruitment_set_questions`
--

LOCK TABLES `recruitment_set_questions` WRITE;
/*!40000 ALTER TABLE `recruitment_set_questions` DISABLE KEYS */;
/*!40000 ALTER TABLE `recruitment_set_questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `state_name` varchar(128) DEFAULT NULL,
  `country_id` int(11) DEFAULT NULL,
  `description` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `country_id` (`country_id`),
  CONSTRAINT `state_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) DEFAULT NULL,
  `password` varchar(60) NOT NULL,
  `email_address` varchar(30) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `middle_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) NOT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `fax` varchar(15) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `authority` varchar(45) NOT NULL,
  `dob` datetime DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `user_image` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
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


CREATE TABLE `admission_form` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `registration_no` int(11) NOT NULL,
  `first_name` varchar(20) NOT NULL DEFAULT '',
  `middle_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `dob` date NOT NULL DEFAULT '0000-00-00',
  `father_name` varchar(20) DEFAULT NULL,
  `father_occupation` varchar(20) DEFAULT NULL,
  `mother_name` varchar(20) DEFAULT NULL,
  `mother_occupation` varchar(20) DEFAULT NULL,
  `mobile_number` int(11) DEFAULT NULL,
  `email_id` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `class` varchar(20) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `aadhar_number` bigint(12) DEFAULT NULL,
  `religion` varchar(20) DEFAULT NULL,
  `previousclass_percentage` varchar(20) DEFAULT NULL,
  `blood_group` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
			


