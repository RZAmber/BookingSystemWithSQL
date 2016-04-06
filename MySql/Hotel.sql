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

 Date: 04/05/2016 20:11:41 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `booking_info`
-- ----------------------------
DROP TABLE IF EXISTS `booking_info`;
CREATE TABLE `booking_info` (
  `orderID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) NOT NULL,
  `userName` varchar(255) NOT NULL,
  `room_number` int(11) NOT NULL,
  `people_number` int(11) NOT NULL,
  `check-in` date NOT NULL,
  `check-out` date NOT NULL,
  `stay night` int(11) NOT NULL,
  PRIMARY KEY (`orderID`,`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `room_baseinfo`
-- ----------------------------
DROP TABLE IF EXISTS `room_baseinfo`;
CREATE TABLE `room_baseinfo` (
  `room_number` int(11) NOT NULL,
  `room_style` varchar(255) NOT NULL,
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
