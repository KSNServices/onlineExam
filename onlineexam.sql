/*
SQLyog Community v8.61 
MySQL - 5.5.29 : Database - onlineexam
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`onlineexam` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `onlineexam`;

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) NOT NULL,
  `email_address` varchar(255) NOT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  `fax` int(11) DEFAULT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `admin_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6A68E082B7B116A` (`admin_id`),
  CONSTRAINT `FK6A68E082B7B116A` FOREIGN KEY (`admin_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`id`,`authority`,`email_address`,`enabled`,`fax`,`first_name`,`last_name`,`middle_name`,`password`,`phone`,`user_name`,`admin_id`) values (1,'ROLE_SUPER_ADMIN','rakesh@gmail.com',1,1234,'Rakesh','Jha','Kumar','$2a$10$VEPleyPeq7yuiDLwOS9KD.ecTDgISsRu8sYVHoRz.FXudRoSLJBBC','2323232323','sadmin',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
