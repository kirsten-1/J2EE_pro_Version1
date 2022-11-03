/*
 Navicat Premium Data Transfer

 Source Server         : testconn
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : J2EE

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 02/11/2022 22:10:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for CourseTable
-- ----------------------------
DROP TABLE IF EXISTS `CourseTable`;
CREATE TABLE `CourseTable` (
  `cid` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `semester` int DEFAULT NULL,
  `stunum` int DEFAULT NULL,
  `credit` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of CourseTable
-- ----------------------------
BEGIN;
INSERT INTO `CourseTable` (`cid`, `name`, `semester`, `stunum`, `credit`) VALUES (1, 'javaEE', 2, 2, 3);
INSERT INTO `CourseTable` (`cid`, `name`, `semester`, `stunum`, `credit`) VALUES (2, 'javaSE', 1, 3, 4);
INSERT INTO `CourseTable` (`cid`, `name`, `semester`, `stunum`, `credit`) VALUES (3, 'spring', 3, 3, 5);
COMMIT;

-- ----------------------------
-- Table structure for majortable
-- ----------------------------
DROP TABLE IF EXISTS `majortable`;
CREATE TABLE `majortable` (
  `mid` int DEFAULT NULL,
  `majorname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of majortable
-- ----------------------------
BEGIN;
INSERT INTO `majortable` (`mid`, `majorname`) VALUES (1, 'javaEE');
INSERT INTO `majortable` (`mid`, `majorname`) VALUES (2, 'javaSE');
COMMIT;

-- ----------------------------
-- Table structure for studenttable
-- ----------------------------
DROP TABLE IF EXISTS `studenttable`;
CREATE TABLE `studenttable` (
  `name` varchar(255) DEFAULT NULL,
  `gender` int DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `credit` int DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of studenttable
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for usertable
-- ----------------------------
DROP TABLE IF EXISTS `usertable`;
CREATE TABLE `usertable` (
  `id` int DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of usertable
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
