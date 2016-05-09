/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Version : 50711
 Source Host           : localhost
 Source Database       : Hotel

 Target Server Version : 50711
 File Encoding         : utf-8

 Date: 05/09/2016 16:58:31 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `ID` int(30) NOT NULL,
  `password` varchar(64) NOT NULL,
  `first_name` varchar(64) NOT NULL,
  `last_name` varchar(64) NOT NULL,
  `email` varchar(64) NOT NULL,
  `phone` int(255) NOT NULL,
  `is_admin` int(11) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `manager`
-- ----------------------------
BEGIN;
INSERT INTO `manager` VALUES ('300710', '123', 'Joe', 'Goran', 'jgoran@hello.com', '2032452123', '1'), ('300711', '123', 'Jana', 'Bord', 'jbord@hello.com', '2013145323', '1'), ('420890', '1234567', 'Kim', 'Lin', 'klin@hello.com', '2032918833', '0'), ('589402', '123456', 'Zeta', 'Becky', 'becky.zeta@hello.com', '2013987273', '0');
COMMIT;

-- ----------------------------
--  Table structure for `order_info`
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `orderID` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(64) NOT NULL,
  `first_name` varchar(64) NOT NULL,
  `last_name` varchar(64) NOT NULL,
  `room_type` varchar(64) NOT NULL,
  `amount` int(11) NOT NULL,
  `room_number` int(30) DEFAULT NULL,
  `check_in` varchar(64) NOT NULL,
  `check_out` varchar(64) NOT NULL,
  `total` float(40,0) DEFAULT NULL,
  `comment` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`orderID`,`email`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `order_info`
-- ----------------------------
BEGIN;
INSERT INTO `order_info` VALUES ('8', 'kunqi99@gmail.com', 'Kun', 'Wang', '   suite', '1', '303', '2016 9 5', '2016 9 6', '500', ''), ('13', 'rzhang21@stevens.edu', 'Rui', 'Zhang', 'Standard Room   ', '1', '104', '2016 6 4', '2016 6 8', '800', ''), ('19', 'jiaowang@stevens.edu', 'Jiao', 'Wang', '  deluxe single room ', '1', '202', '2017 1 1', '2017 2 1', '9300', ''), ('20', 'lgoodstein@gmail.com', 'Laurie', 'Goodstein', ' single room  ', '1', '101', '2016 6 3', '2016 6 5', '300', '');
COMMIT;

-- ----------------------------
--  Table structure for `room`
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `room_number` int(11) NOT NULL,
  `room_type` varchar(30) NOT NULL,
  `fee` float NOT NULL,
  `Available` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`room_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `room`
-- ----------------------------
BEGIN;
INSERT INTO `room` VALUES ('101', 'Single_Room', '150', 'No'), ('102', 'Single_Room', '150', '-'), ('103', 'Single_Room', '150', '-'), ('104', 'Standard_Room', '300', 'No'), ('105', 'Standard_Room', '300', 'No'), ('106', 'Single_Room', '150', '-'), ('107', 'Single_Room', '150', '-'), ('201', 'Standard_Room', '300', 'No'), ('202', 'Deluxe_Single_Room', '200', 'No'), ('203', 'Deluxe_Single_Room', '200', '-'), ('204', 'Standard_Room', '300', '-'), ('205', 'Standard_Room', '300', '-'), ('206', 'Deluxe_Single_Room', '200', '-'), ('207', 'Standard_Room', '300', '-'), ('301', 'Suite', '500', 'No'), ('302', 'Suite', '500', '-'), ('303', 'Suite', '500', 'No'), ('304', 'Deluxe_Single_Room', '200', '-');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `email` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `first_name` varchar(64) NOT NULL,
  `last_name` varchar(64) NOT NULL,
  `phone` int(255) NOT NULL,
  `country` varchar(64) NOT NULL,
  `address` varchar(64) NOT NULL,
  `address2` varchar(64) DEFAULT NULL,
  `city` varchar(64) NOT NULL,
  `state` varchar(64) NOT NULL,
  `zip` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`email`,`first_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('cuiying@gmail.com', 'win99999', 'Ying', 'Cui', '2013243742', 'USA', '437 OGDEN', '', 'Jersey City', 'Nk', '07307'), ('jiaowang@stevens.edu', 'win99999', 'Jiao', 'Wang', '201437483', 'USA', '437 Ogden', '', 'NJ', 'nj', '07307'), ('joeh@stevens.edu', '1234', 'John', 'LI', '2019392993', 'US', '8th', '', 'NYC', 'NY', '00930'), ('kunqi99@gmail.com', 'win930909', 'Kun', 'Wang', '2013992983', 'USA', '437 O', '', 'Jersey City', 'NJ', '07307'), ('lgoodstein@gmail.com', 'win9302093', 'Laurie', 'Goodstein', '202939201', 'usa', '45th', '', 'NYC', 'NY', '02938'), ('liushui@163.com', '1234839', 'Alicia', 'Parlapiano', '2019393847', 'USA', '65th', '', 'NYC', 'NY', '029303'), ('rzhang21@stevens.edu', 'win930909', 'Rui', 'Zhang', '201928921', 'USA', 'OGDE', '', 'JERSEY', 'NJ', '07307'), ('xusihui@stevens.edu', 'win99999', 'Xusihui', 'Chong', '2013882938', 'USA', 'Hoboken', '', 'Hoboken', 'NJ', '07030'), ('yoyo@gmail.com', 'win99999', 'Ya', 'Duan', '2019392829', 'China', 'Heze', '', 'heze', 'nj', '274700'), ('yuliang@gmail.com', 'win930909', 'Yu', 'Guo', '2013928845', 'China', 'Chongqing', '', 'Chongqing', 'Chongqing', '02930');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
