/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Version : 50711
 Source Host           : localhost
 Source Database       : Hotel

 Target Server Version : 50711
 File Encoding         : utf-8

 Date: 05/05/2016 10:30:51 AM
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
INSERT INTO `manager` VALUES ('300710', '123456', 'Joe', 'Goran', 'jgoran@hello.com', '2032452123', '1'), ('420890', '123456', 'Kim', 'Lin', 'klin@hello.com', '2032918833', '0'), ('589402', '123456', 'Zeta', 'Becky', 'becky.zeta@hello.com', '2013987273', '0');
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
  `check-in` date NOT NULL,
  `check-out` date NOT NULL,
  `total` float(40,0) DEFAULT NULL,
  `comment` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`orderID`,`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `order_info`
-- ----------------------------
BEGIN;
INSERT INTO `order_info` VALUES ('1', 'kunqi@gmail.com', 'Kun', 'Qi', 'Single', '1', null, '2016-05-03', '2016-05-04', null, null), ('2', 'kunqi@gmail.com', 'Jia', 'Qi', 'Single', '1', null, '2016-05-05', '2016-05-10', null, null), ('3', 'litingwang@stevens.edu', 'Liting', 'Wang', 'Double', '1', null, '2016-05-10', '2016-05-11', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `room_baseinfo`
-- ----------------------------
DROP TABLE IF EXISTS `room_baseinfo`;
CREATE TABLE `room_baseinfo` (
  `room_number` int(11) NOT NULL,
  `room_style` varchar(30) NOT NULL,
  `fee` float NOT NULL,
  `max` int(11) NOT NULL,
  PRIMARY KEY (`room_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `room_baseinfo`
-- ----------------------------
BEGIN;
INSERT INTO `room_baseinfo` VALUES ('101', 'Single', '150', '2'), ('102', 'Single', '150', '2'), ('103', 'Single', '150', '2'), ('104', 'Double', '200', '4'), ('105', 'Double', '200', '4'), ('106', 'Single', '150', '2'), ('107', 'Single', '150', '2'), ('201', 'Double', '200', '4'), ('202', 'Deluxe Single', '200', '2'), ('203', 'Deluxe Single', '200', '2'), ('204', 'Double', '200', '2'), ('205', 'Double', '200', '4'), ('206', 'Deluxe Single', '200', '2'), ('207', 'Double', '200', '4'), ('301', 'Family', '300', '5'), ('302', 'Family', '300', '5'), ('303', 'Family', '300', '5'), ('304', 'Deluxe Single', '200', '2');
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
INSERT INTO `user` VALUES ('cuiying@gmail.com', 'win99999', 'Cui', 'Ying', '2013243742', 'USA', '437 OGDEN', '', 'Jersey City', 'Nk', '07307'), ('rzhang21@steven.edu', 'win930909', 'RUI', 'ZHANG', '2013153265', 'USA', '437 ogden', '', 'jersey city', 'nj', '07307'), ('rzhang21@stevens.edu', 'win930909', 'Rui', 'Zhang', '2013153265', 'USA', '437 OGDEN', 'APT4', 'Jersey City', 'Nj', '07307');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
