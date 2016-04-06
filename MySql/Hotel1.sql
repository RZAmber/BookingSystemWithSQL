/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50711
 Source Host           : localhost
 Source Database       : Hotel

 Target Server Type    : MySQL
 Target Server Version : 50711
 File Encoding         : utf-8

 Date: 04/05/2016 22:46:35 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `Check-in`
-- ----------------------------
DROP TABLE IF EXISTS `Check-in`;
CREATE TABLE `Check-in` (
  `orderID` int(11) NOT NULL,
  `cust_name` varchar(30) NOT NULL,
  `custID` int(11) NOT NULL,
  `chek-in time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `Cust_info`
-- ----------------------------
DROP TABLE IF EXISTS `Cust_info`;
CREATE TABLE `Cust_info` (
  `Cust_name` varchar(30) NOT NULL,
  `Cust_phone` int(10) NOT NULL,
  `Cust_email` varchar(40) DEFAULT NULL,
  `Cust_add1` varchar(30) DEFAULT NULL,
  `Cust_add2` varchar(30) DEFAULT NULL,
  `Cust_city` varchar(30) DEFAULT NULL,
  `Cust_state` varchar(30) DEFAULT NULL,
  `Cust_country` varchar(30) DEFAULT NULL,
  `orderID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `ReserveOr`
-- ----------------------------
DROP TABLE IF EXISTS `ReserveOr`;
CREATE TABLE `ReserveOr` (
  `orderID` int(11) NOT NULL,
  `room_number` int(11) NOT NULL,
  `check-in time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  `check-out time` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`orderID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `booking_info`
-- ----------------------------
DROP TABLE IF EXISTS `booking_info`;
CREATE TABLE `booking_info` (
  `orderID` int(11) NOT NULL AUTO_INCREMENT,
  `room_number` int(11) NOT NULL,
  `child` mediumint(11) DEFAULT NULL,
  `adult` int(11) NOT NULL,
  `check-in` date NOT NULL,
  `check-out` date NOT NULL,
  `stay night` int(11) NOT NULL,
  `total` float(40,0) NOT NULL,
  PRIMARY KEY (`orderID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `room_AON`
-- ----------------------------
DROP TABLE IF EXISTS `room_AON`;
CREATE TABLE `room_AON` (
  `room_number` int(11) NOT NULL,
  `room_style` varchar(30) NOT NULL,
  `Avaible` tinyint(1) NOT NULL,
  PRIMARY KEY (`room_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

SET FOREIGN_KEY_CHECKS = 1;
