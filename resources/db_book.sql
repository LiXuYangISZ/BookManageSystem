/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.58 : Database - db_book
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_book` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_book`;

/*Table structure for table `t_book` */

DROP TABLE IF EXISTS `t_book`;

CREATE TABLE `t_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookName` varchar(20) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `bookDesc` varchar(1000) DEFAULT NULL,
  `bookTypeId` int(11) DEFAULT NULL,
  `isflag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t_book` (`bookTypeId`),
  CONSTRAINT `FK_t_book` FOREIGN KEY (`bookTypeId`) REFERENCES `t_booktype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

/*Data for the table `t_book` */

insert  into `t_book`(`id`,`bookName`,`author`,`sex`,`price`,`bookDesc`,`bookTypeId`,`isflag`) values (21,'Java高级编程','黑马程序员','男',300,'大神成才之路',1,1),(24,'算法进阶','清华哈哈','男',200,'一起学算法啊',1,0),(26,'明朝那些事','石锐','男',130,'看明朝百年历史',2,0),(27,'射雕英雄传','金庸','男',200,'看郭靖杨过的惊人故事',2,0),(28,'僵尸先生','刘观伟','男',200,'胆子大的尽管来啊',3,0),(29,'鬼吹灯','无名','男',500,'昂,胆子小的别进来',3,0),(30,'造梦西游3','4399','男',1000,'一起通关啊',4,0),(31,'贪吃蛇','4399','女',500,'一起来做贪吃蛇啊',4,0),(32,'动物世界','CCTV','男',150,'来看大自然的动物',7,0),(36,'钢铁是怎样炼成的','奥斯特洛夫斯基','男',500,'一起来炼钢',6,0),(38,'百草纲目','李时珍','男',800,'一位秀才的一生心血',5,0),(39,'JavaScript设计','张学军','男',200,'跟着大佬学习啊',2,0),(41,'算法基础基础','LXYLXY','女',300,'算法入门哦,适合初学者学哦!!!哈哈',1,0),(42,'水浒传','施耐庵','男',100,'很好看啊',2,0);

/*Table structure for table `t_booktype` */

DROP TABLE IF EXISTS `t_booktype`;

CREATE TABLE `t_booktype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookTypeName` varchar(20) DEFAULT NULL,
  `bookTypeDesc` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `t_booktype` */

insert  into `t_booktype`(`id`,`bookTypeName`,`bookTypeDesc`) values (1,'计算机类','我爱编程,编程使我快乐哈哈哈哈哈'),(2,'历史','以史为鉴可以....额我忘了后面是啥了哈哈哈哈哈'),(3,'灵异类','僵尸大片让你惊悚睡不着!'),(4,'游戏类','王者荣耀,吃鸡,英雄联盟等着你的到来!'),(5,'动物百科','嘎嘎嘎,汪汪汪,喵喵喵.'),(6,'外文类','钢铁是怎样炼成的,就是那样练呗.'),(7,'动画片类','喜羊羊和灰太狼等着你哦'),(8,'爱情类','自古以来爱情就是一个永恒的话题可惜与我没啥关系'),(9,'科幻类','流浪地球,三体,带你探索宇宙的奥秘.'),(10,'人文','人文知识'),(13,'历史类','安抚安抚发');

/*Table structure for table `t_borrow` */

DROP TABLE IF EXISTS `t_borrow`;

CREATE TABLE `t_borrow` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `bookid` int(11) DEFAULT NULL,
  `btime` date DEFAULT NULL,
  `rtime` date DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;

/*Data for the table `t_borrow` */

insert  into `t_borrow`(`bid`,`userid`,`bookid`,`btime`,`rtime`) values (14,10,12,'2020-12-20','2020-12-23'),(20,10,20,'2020-12-23','2020-12-23'),(21,10,12,'2020-12-23','2020-12-23'),(22,10,21,'2020-12-23','2020-12-23'),(24,10,20,'2020-12-23','2020-12-23'),(25,10,20,'2020-12-23','2020-12-23'),(26,10,20,'2020-12-23','2020-12-23'),(27,10,21,'2020-12-23','2020-12-23'),(28,10,20,'2020-12-23','2020-12-23'),(29,10,20,'2020-12-23','2020-12-23'),(30,10,21,'2020-12-23','2020-12-23'),(31,10,12,'2020-12-23','2020-12-23'),(32,10,20,'2020-12-23','2020-12-23'),(33,10,21,'2020-12-23','2020-12-23'),(34,10,12,'2020-12-23','2020-12-23'),(35,10,20,'2020-12-23','2020-12-23'),(36,10,20,'2020-12-23','2020-12-23'),(37,10,12,'2020-12-23','2020-12-23'),(38,10,21,'2020-12-23','2020-12-23'),(39,10,12,'2020-12-23','2020-12-23'),(40,10,20,'2020-12-23','2020-12-23'),(41,10,12,'2020-12-23','2020-12-23'),(42,10,20,'2020-12-23','2020-12-23'),(43,10,12,'2020-12-23','2020-12-23'),(44,10,20,'2020-12-23','2020-12-23'),(45,10,20,'2020-12-23','2020-12-23'),(46,10,20,'2020-12-23','2020-12-23'),(47,10,21,'2020-12-23','2020-12-23'),(48,10,20,'2020-12-23','2020-12-23'),(49,10,21,'2020-12-23','2020-12-23'),(50,10,12,'2020-12-23','2020-12-23'),(51,10,20,'2020-12-23','2020-12-23'),(53,12,20,'2020-12-23','2020-12-23'),(54,8,21,'2020-12-23','2020-12-23'),(55,12,12,'2020-12-24','2020-12-24'),(57,12,29,'2020-12-24','2020-12-24'),(58,12,21,'2020-12-24','2020-12-27'),(59,14,22,'2020-12-24','2020-12-24'),(60,14,24,'2020-12-24','2020-12-24'),(62,15,25,'2020-12-24','2020-12-24'),(63,16,25,'2020-12-24','2020-12-24'),(64,16,26,'2020-12-24','2020-12-24'),(65,12,30,'2020-12-25','2020-12-25'),(66,12,36,'2020-12-25','2020-12-25'),(67,12,21,'2020-12-27','2020-12-27'),(68,12,25,'2020-12-27','2020-12-27'),(71,13,21,'2020-12-30','2020-12-30'),(72,13,25,'2020-12-30','2020-12-30'),(73,13,21,'2020-12-31',NULL),(74,13,26,'2020-12-31','2020-12-31'),(75,12,31,'2022-12-23','2022-12-23');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `userid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`userName`,`password`,`userid`) values (8,'admin','123456','1'),(11,'李四','123456','0'),(12,'GGY','123456','0'),(13,'LXY','123456789','0'),(19,'lxy','123456789','0'),(20,'lxy','123456789','0');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
