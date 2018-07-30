/*
 Navicat Premium Data Transfer

 Source Server         : songjtMySql
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : mumschool

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 30/07/2018 16:33:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `question_bank_id` int(11) NULL DEFAULT NULL,
  `correct_num` int(11) NULL DEFAULT NULL,
  `score` int(11) NULL DEFAULT NULL,
  `begin_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  `creater` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `modifier` int(11) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 99 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam
-- ----------------------------
INSERT INTO `exam` VALUES (7, 7, 1, 0, 0, '2018-07-26 00:07:12', NULL, NULL, '2018-07-26 00:07:12', NULL, NULL);
INSERT INTO `exam` VALUES (8, 7, 1, 0, 0, '2018-07-26 00:07:46', NULL, NULL, '2018-07-26 00:07:48', NULL, NULL);
INSERT INTO `exam` VALUES (9, 7, 1, 0, 0, '2018-07-26 00:08:42', NULL, NULL, '2018-07-26 00:08:41', NULL, NULL);
INSERT INTO `exam` VALUES (10, 7, 1, 0, 0, '2018-07-26 08:36:27', NULL, NULL, '2018-07-26 08:36:26', NULL, NULL);
INSERT INTO `exam` VALUES (11, 7, 1, 0, 0, '2018-07-26 08:37:57', NULL, NULL, '2018-07-26 08:39:03', NULL, NULL);
INSERT INTO `exam` VALUES (12, 7, 1, 0, 0, '2018-07-26 09:39:55', NULL, NULL, '2018-07-26 09:39:55', NULL, NULL);
INSERT INTO `exam` VALUES (13, 7, 1, 0, 0, '2018-07-26 09:40:20', NULL, NULL, '2018-07-26 09:40:46', NULL, NULL);
INSERT INTO `exam` VALUES (14, 7, 1, 0, 0, '2018-07-26 09:42:08', NULL, NULL, '2018-07-26 09:42:07', NULL, NULL);
INSERT INTO `exam` VALUES (15, 7, 1, 0, 0, '2018-07-26 09:43:02', NULL, NULL, '2018-07-26 09:43:01', NULL, NULL);
INSERT INTO `exam` VALUES (16, 7, 1, 0, 0, '2018-07-26 09:43:14', NULL, NULL, '2018-07-26 09:43:14', NULL, NULL);
INSERT INTO `exam` VALUES (17, 7, 1, 0, 0, '2018-07-26 09:44:09', NULL, NULL, '2018-07-26 09:44:08', NULL, NULL);
INSERT INTO `exam` VALUES (18, 7, 1, 0, 0, '2018-07-26 09:47:59', NULL, NULL, '2018-07-26 09:47:58', NULL, NULL);
INSERT INTO `exam` VALUES (19, 7, 1, 0, 0, '2018-07-26 09:47:59', NULL, NULL, '2018-07-26 09:47:58', NULL, NULL);
INSERT INTO `exam` VALUES (20, 7, 1, 0, 0, '2018-07-26 09:53:07', NULL, NULL, '2018-07-26 09:53:07', NULL, NULL);
INSERT INTO `exam` VALUES (21, 7, 1, 0, 0, '2018-07-26 19:40:19', NULL, NULL, '2018-07-26 19:40:19', NULL, NULL);
INSERT INTO `exam` VALUES (22, 7, 1, 0, 0, '2018-07-26 19:50:03', NULL, NULL, '2018-07-26 19:50:03', NULL, NULL);
INSERT INTO `exam` VALUES (23, 7, 1, 0, 0, '2018-07-26 19:59:19', NULL, NULL, '2018-07-26 19:59:18', NULL, NULL);
INSERT INTO `exam` VALUES (24, 7, 1, 0, 0, '2018-07-27 08:33:02', NULL, NULL, '2018-07-27 08:33:01', NULL, NULL);
INSERT INTO `exam` VALUES (25, 7, 1, 0, 0, '2018-07-27 08:34:45', NULL, NULL, '2018-07-27 08:34:44', NULL, NULL);
INSERT INTO `exam` VALUES (26, 7, 1, 0, 0, '2018-07-27 08:41:13', NULL, NULL, '2018-07-27 08:41:13', NULL, NULL);
INSERT INTO `exam` VALUES (27, 7, 1, 0, 0, '2018-07-27 08:42:49', NULL, NULL, '2018-07-27 08:42:49', NULL, NULL);
INSERT INTO `exam` VALUES (28, 7, 1, 0, 0, '2018-07-27 08:43:48', NULL, NULL, '2018-07-27 08:43:48', NULL, NULL);
INSERT INTO `exam` VALUES (29, 7, 1, 0, 0, '2018-07-27 08:46:06', NULL, NULL, '2018-07-27 08:46:05', NULL, NULL);
INSERT INTO `exam` VALUES (30, 7, 1, 0, 0, '2018-07-27 08:47:45', NULL, NULL, '2018-07-27 08:47:44', NULL, NULL);
INSERT INTO `exam` VALUES (31, 7, 1, 0, 0, '2018-07-27 08:48:48', NULL, NULL, '2018-07-27 08:48:47', NULL, NULL);
INSERT INTO `exam` VALUES (32, 7, 1, 0, 0, '2018-07-27 08:51:45', NULL, NULL, '2018-07-27 08:51:44', NULL, NULL);
INSERT INTO `exam` VALUES (33, 1, 1, 0, 0, '2018-07-27 09:16:18', NULL, NULL, '2018-07-27 09:16:17', NULL, NULL);
INSERT INTO `exam` VALUES (34, 1, 1, 0, 0, '2018-07-27 09:23:21', NULL, NULL, '2018-07-27 09:23:21', NULL, NULL);
INSERT INTO `exam` VALUES (35, 1, 1, 0, 0, '2018-07-27 09:28:45', NULL, NULL, '2018-07-27 09:28:44', NULL, NULL);
INSERT INTO `exam` VALUES (36, 1, 1, 0, 0, '2018-07-27 09:35:18', NULL, NULL, '2018-07-27 09:35:18', NULL, NULL);
INSERT INTO `exam` VALUES (37, 1, 1, 0, 0, '2018-07-27 11:48:34', NULL, NULL, '2018-07-27 11:48:34', NULL, NULL);
INSERT INTO `exam` VALUES (38, 1, 1, 0, 0, '2018-07-27 11:49:27', NULL, NULL, '2018-07-27 11:49:26', NULL, NULL);
INSERT INTO `exam` VALUES (39, 7, 1, 0, 0, '2018-07-27 11:50:18', NULL, NULL, '2018-07-27 11:50:18', NULL, NULL);
INSERT INTO `exam` VALUES (40, 1, 1, 0, 0, '2018-07-27 12:50:00', NULL, NULL, '2018-07-27 12:50:00', NULL, NULL);
INSERT INTO `exam` VALUES (41, 1, 1, 0, 0, '2018-07-27 12:57:27', NULL, NULL, '2018-07-27 12:57:27', NULL, NULL);
INSERT INTO `exam` VALUES (42, 1, 1, 0, 0, '2018-07-27 12:57:48', NULL, NULL, '2018-07-27 12:57:47', NULL, NULL);
INSERT INTO `exam` VALUES (43, 1, 1, 0, 0, '2018-07-27 12:59:34', NULL, NULL, '2018-07-27 12:59:33', NULL, NULL);
INSERT INTO `exam` VALUES (44, 1, 1, 0, 0, '2018-07-27 13:01:30', NULL, NULL, '2018-07-27 13:01:30', NULL, NULL);
INSERT INTO `exam` VALUES (45, 1, 1, 0, 0, '2018-07-27 13:03:42', NULL, NULL, '2018-07-27 13:03:41', NULL, NULL);
INSERT INTO `exam` VALUES (46, 1, 1, 0, 0, '2018-07-27 13:23:25', NULL, NULL, '2018-07-27 13:23:25', NULL, NULL);
INSERT INTO `exam` VALUES (47, 1, 1, 0, 0, '2018-07-27 13:38:18', NULL, NULL, '2018-07-27 13:38:18', NULL, NULL);
INSERT INTO `exam` VALUES (48, 1, 1, 0, 0, '2018-07-27 13:43:59', NULL, NULL, '2018-07-27 13:43:58', NULL, NULL);
INSERT INTO `exam` VALUES (49, 1, 1, 0, 0, '2018-07-27 13:59:53', NULL, NULL, '2018-07-27 13:59:53', NULL, NULL);
INSERT INTO `exam` VALUES (50, 1, 1, 0, 0, '2018-07-27 14:03:12', NULL, NULL, '2018-07-27 14:03:12', NULL, NULL);
INSERT INTO `exam` VALUES (51, 1, 1, 0, 0, '2018-07-27 14:07:40', NULL, NULL, '2018-07-27 14:07:39', NULL, NULL);
INSERT INTO `exam` VALUES (52, 1, 1, 0, 0, '2018-07-27 14:12:06', NULL, NULL, '2018-07-27 14:12:05', NULL, NULL);
INSERT INTO `exam` VALUES (53, 1, 1, 0, 0, '2018-07-27 14:14:23', NULL, NULL, '2018-07-27 14:14:23', NULL, NULL);
INSERT INTO `exam` VALUES (54, 1, 1, 0, 0, '2018-07-27 14:24:36', NULL, NULL, '2018-07-27 14:24:35', NULL, NULL);
INSERT INTO `exam` VALUES (55, 1, 1, 0, 0, '2018-07-27 14:29:52', NULL, NULL, '2018-07-27 14:29:51', NULL, NULL);
INSERT INTO `exam` VALUES (56, 1, 1, 0, 0, '2018-07-27 23:23:33', NULL, NULL, '2018-07-27 23:23:32', NULL, NULL);
INSERT INTO `exam` VALUES (57, 1, 1, 0, 0, '2018-07-27 23:39:17', NULL, NULL, '2018-07-27 23:39:17', NULL, NULL);
INSERT INTO `exam` VALUES (58, 1, 1, 0, 0, '2018-07-27 23:43:30', NULL, NULL, '2018-07-27 23:43:29', NULL, NULL);
INSERT INTO `exam` VALUES (59, 1, 1, 0, 0, '2018-07-27 23:45:10', NULL, NULL, '2018-07-27 23:45:10', NULL, NULL);
INSERT INTO `exam` VALUES (60, 1, 1, 0, 0, '2018-07-27 23:50:39', NULL, NULL, '2018-07-27 23:50:38', NULL, NULL);
INSERT INTO `exam` VALUES (61, 1, 1, 0, 0, '2018-07-28 10:25:18', NULL, NULL, '2018-07-28 10:25:17', NULL, NULL);
INSERT INTO `exam` VALUES (62, 1, 1, 0, 0, '2018-07-28 10:42:19', NULL, NULL, '2018-07-28 10:42:19', NULL, NULL);
INSERT INTO `exam` VALUES (63, 1, 1, 0, 0, '2018-07-28 10:53:09', NULL, NULL, '2018-07-28 10:53:09', NULL, NULL);
INSERT INTO `exam` VALUES (64, 1, 1, 0, 0, '2018-07-28 10:54:33', NULL, NULL, '2018-07-28 10:54:33', NULL, NULL);
INSERT INTO `exam` VALUES (65, 1, 1, 0, 0, '2018-07-28 10:56:04', NULL, NULL, '2018-07-28 10:56:04', NULL, NULL);
INSERT INTO `exam` VALUES (66, 1, 1, 0, 0, '2018-07-28 10:57:47', NULL, NULL, '2018-07-28 10:57:47', NULL, NULL);
INSERT INTO `exam` VALUES (67, 1, 1, 0, 0, '2018-07-28 11:05:35', NULL, NULL, '2018-07-28 11:05:34', NULL, NULL);
INSERT INTO `exam` VALUES (68, 1, 1, 0, 0, '2018-07-28 11:10:31', NULL, NULL, '2018-07-28 11:10:30', NULL, NULL);
INSERT INTO `exam` VALUES (69, 1, 1, 0, 0, '2018-07-28 11:11:58', NULL, NULL, '2018-07-28 11:11:57', NULL, NULL);
INSERT INTO `exam` VALUES (70, 1, 1, 0, 0, '2018-07-28 11:12:39', NULL, NULL, '2018-07-28 11:12:38', NULL, NULL);
INSERT INTO `exam` VALUES (71, 1, 1, 0, 0, '2018-07-28 13:06:09', NULL, NULL, '2018-07-28 13:06:08', NULL, NULL);
INSERT INTO `exam` VALUES (72, 1, 1, 0, 0, '2018-07-28 13:07:59', NULL, NULL, '2018-07-28 13:07:59', NULL, NULL);
INSERT INTO `exam` VALUES (73, 1, 1, 0, 0, '2018-07-28 13:11:46', NULL, NULL, '2018-07-28 13:11:45', NULL, NULL);
INSERT INTO `exam` VALUES (74, 1, 1, 0, 0, '2018-07-28 13:18:51', NULL, NULL, '2018-07-28 13:18:50', NULL, NULL);
INSERT INTO `exam` VALUES (75, 1, 1, 0, 0, '2018-07-28 13:21:51', NULL, NULL, '2018-07-28 13:21:50', NULL, NULL);
INSERT INTO `exam` VALUES (76, 1, 1, 0, 0, '2018-07-28 13:23:17', NULL, NULL, '2018-07-28 13:23:16', NULL, NULL);
INSERT INTO `exam` VALUES (77, 1, 1, 0, 0, '2018-07-28 13:24:23', NULL, NULL, '2018-07-28 13:24:23', NULL, NULL);
INSERT INTO `exam` VALUES (78, 1, 1, 0, 8, '2018-07-28 13:28:47', NULL, NULL, '2018-07-28 13:28:47', NULL, NULL);
INSERT INTO `exam` VALUES (79, 1, 1, 0, 6, '2018-07-28 13:31:36', NULL, NULL, '2018-07-28 13:31:36', NULL, NULL);
INSERT INTO `exam` VALUES (80, 1, 1, 0, 4, '2018-07-28 13:33:20', NULL, NULL, '2018-07-28 13:33:19', NULL, NULL);
INSERT INTO `exam` VALUES (81, 1, 1, 0, 6, '2018-07-28 13:47:02', NULL, NULL, '2018-07-28 13:47:01', NULL, NULL);
INSERT INTO `exam` VALUES (82, 7, 1, 0, 0, '2018-07-28 18:06:49', NULL, NULL, '2018-07-28 18:06:49', NULL, NULL);
INSERT INTO `exam` VALUES (83, 7, 1, 0, 6, '2018-07-28 18:07:06', NULL, NULL, '2018-07-28 18:07:06', NULL, NULL);
INSERT INTO `exam` VALUES (84, 7, 1, 0, 2, '2018-07-28 18:08:02', NULL, NULL, '2018-07-28 18:08:01', NULL, NULL);
INSERT INTO `exam` VALUES (85, 7, 1, 0, 0, '2018-07-28 18:14:52', NULL, NULL, '2018-07-28 18:14:52', NULL, NULL);
INSERT INTO `exam` VALUES (86, 7, 1, 0, 2, '2018-07-28 18:16:15', NULL, NULL, '2018-07-28 18:16:15', NULL, NULL);
INSERT INTO `exam` VALUES (87, 7, 1, 0, 4, '2018-07-28 18:32:34', NULL, NULL, '2018-07-28 18:32:34', NULL, NULL);
INSERT INTO `exam` VALUES (88, 7, 1, 0, 0, '2018-07-28 18:49:47', NULL, NULL, '2018-07-28 18:49:47', NULL, NULL);
INSERT INTO `exam` VALUES (89, 7, 1, 0, 2, '2018-07-28 18:55:06', NULL, NULL, '2018-07-28 18:55:05', NULL, NULL);
INSERT INTO `exam` VALUES (90, 7, 1, 0, 2, '2018-07-28 18:56:56', NULL, NULL, '2018-07-28 18:56:56', NULL, NULL);
INSERT INTO `exam` VALUES (91, 7, 1, 0, 0, '2018-07-28 22:38:09', NULL, NULL, '2018-07-28 22:38:08', NULL, NULL);
INSERT INTO `exam` VALUES (92, 7, 1, 0, 4, '2018-07-29 18:06:48', NULL, NULL, '2018-07-29 18:06:47', NULL, NULL);
INSERT INTO `exam` VALUES (93, 7, 1, 0, 2, '2018-07-29 18:09:22', NULL, NULL, '2018-07-29 18:09:22', NULL, NULL);
INSERT INTO `exam` VALUES (94, 7, 1, 0, 0, '2018-07-29 18:10:17', NULL, NULL, '2018-07-29 18:10:17', NULL, NULL);
INSERT INTO `exam` VALUES (95, 7, 1, 0, 6, '2018-07-29 18:10:41', NULL, NULL, '2018-07-29 18:10:41', NULL, NULL);
INSERT INTO `exam` VALUES (96, 7, 1, 0, 0, '2018-07-30 11:07:31', NULL, NULL, '2018-07-30 11:07:30', NULL, NULL);
INSERT INTO `exam` VALUES (97, 1, 1, 0, 6, '2018-07-30 14:22:14', NULL, NULL, '2018-07-30 14:22:14', NULL, NULL);
INSERT INTO `exam` VALUES (98, 7, 1, 0, 4, '2018-07-30 14:37:01', NULL, NULL, '2018-07-30 14:37:00', NULL, NULL);

-- ----------------------------
-- Table structure for exam_answer
-- ----------------------------
DROP TABLE IF EXISTS `exam_answer`;
CREATE TABLE `exam_answer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `exam_id` int(11) NULL DEFAULT NULL,
  `question_bank_Id` int(11) NULL DEFAULT NULL,
  `question_id` int(11) NULL DEFAULT NULL,
  `choices` set('A','B','C','D') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `correct` bit(1) NULL DEFAULT NULL,
  `score` int(2) NULL DEFAULT NULL,
  `creater` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `modifier` int(11) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 115 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_answer
-- ----------------------------
INSERT INTO `exam_answer` VALUES (8, 54, 1, 1, '', b'0', NULL, NULL, '2018-07-27 14:25:37', NULL, NULL);
INSERT INTO `exam_answer` VALUES (9, 55, 1, 1, '', b'0', NULL, NULL, '2018-07-27 14:30:15', NULL, NULL);
INSERT INTO `exam_answer` VALUES (10, NULL, NULL, NULL, 'A,B', NULL, NULL, NULL, '2018-07-27 23:28:50', NULL, NULL);
INSERT INTO `exam_answer` VALUES (11, 56, 1, 1, 'A,B', b'0', NULL, NULL, '2018-07-27 23:30:32', NULL, NULL);
INSERT INTO `exam_answer` VALUES (12, 57, 1, 1, 'A,B', b'0', NULL, NULL, '2018-07-27 23:39:34', NULL, NULL);
INSERT INTO `exam_answer` VALUES (13, 57, 1, 2, 'A,B', b'0', NULL, NULL, '2018-07-27 23:39:44', NULL, NULL);
INSERT INTO `exam_answer` VALUES (14, 57, 1, 2, 'A,B', b'0', NULL, NULL, '2018-07-27 23:42:01', NULL, NULL);
INSERT INTO `exam_answer` VALUES (15, 57, 1, 2, 'A,B', b'0', NULL, NULL, '2018-07-27 23:42:15', NULL, NULL);
INSERT INTO `exam_answer` VALUES (16, 57, 1, 2, 'A,B', b'0', NULL, NULL, '2018-07-27 23:43:03', NULL, NULL);
INSERT INTO `exam_answer` VALUES (17, 58, 1, 1, 'A,B', b'0', NULL, NULL, '2018-07-27 23:43:34', NULL, NULL);
INSERT INTO `exam_answer` VALUES (18, 58, 1, 2, 'A,B', b'0', NULL, NULL, '2018-07-27 23:43:40', NULL, NULL);
INSERT INTO `exam_answer` VALUES (19, 58, 1, 2, 'A,B', b'0', NULL, NULL, '2018-07-27 23:44:10', NULL, NULL);
INSERT INTO `exam_answer` VALUES (20, 58, 1, 2, 'A,B', b'0', NULL, NULL, '2018-07-27 23:44:40', NULL, NULL);
INSERT INTO `exam_answer` VALUES (21, 59, 1, 1, 'A,B', b'0', NULL, NULL, '2018-07-27 23:45:16', NULL, NULL);
INSERT INTO `exam_answer` VALUES (22, 59, 1, 2, 'A,B', b'0', NULL, NULL, '2018-07-27 23:45:58', NULL, NULL);
INSERT INTO `exam_answer` VALUES (23, 60, 1, 1, 'A,B', b'0', NULL, NULL, '2018-07-27 23:50:49', NULL, NULL);
INSERT INTO `exam_answer` VALUES (24, 60, 1, 2, 'A,B', b'0', NULL, NULL, '2018-07-27 23:50:55', NULL, NULL);
INSERT INTO `exam_answer` VALUES (25, 61, 1, 1, 'A,B', b'0', NULL, NULL, '2018-07-28 10:25:23', NULL, NULL);
INSERT INTO `exam_answer` VALUES (26, 61, 1, 2, 'A', b'0', NULL, NULL, '2018-07-28 10:25:32', NULL, NULL);
INSERT INTO `exam_answer` VALUES (27, 61, 1, 2, 'A', b'0', NULL, NULL, '2018-07-28 10:33:50', NULL, NULL);
INSERT INTO `exam_answer` VALUES (28, 62, 1, 1, 'A', b'0', NULL, NULL, '2018-07-28 10:42:40', NULL, NULL);
INSERT INTO `exam_answer` VALUES (29, 62, 1, 2, 'B', b'0', NULL, NULL, '2018-07-28 10:43:09', NULL, NULL);
INSERT INTO `exam_answer` VALUES (30, 63, 1, 1, 'A', b'0', NULL, NULL, '2018-07-28 10:53:22', NULL, NULL);
INSERT INTO `exam_answer` VALUES (31, 63, 1, 2, 'A', b'0', NULL, NULL, '2018-07-28 10:53:30', NULL, NULL);
INSERT INTO `exam_answer` VALUES (32, 64, 1, 1, 'A,B', b'0', NULL, NULL, '2018-07-28 10:54:42', NULL, NULL);
INSERT INTO `exam_answer` VALUES (33, 64, 1, 2, 'A', b'0', NULL, NULL, '2018-07-28 10:55:10', NULL, NULL);
INSERT INTO `exam_answer` VALUES (34, 65, 1, 1, 'A', b'0', NULL, NULL, '2018-07-28 10:56:08', NULL, NULL);
INSERT INTO `exam_answer` VALUES (35, 65, 1, 2, 'A', b'0', NULL, NULL, '2018-07-28 10:56:12', NULL, NULL);
INSERT INTO `exam_answer` VALUES (36, 66, 1, 1, 'A', b'0', NULL, NULL, '2018-07-28 10:57:52', NULL, NULL);
INSERT INTO `exam_answer` VALUES (37, 66, 1, 2, 'A', b'0', NULL, NULL, '2018-07-28 10:57:56', NULL, NULL);
INSERT INTO `exam_answer` VALUES (38, 67, 1, 1, 'A', b'0', NULL, NULL, '2018-07-28 11:05:40', NULL, NULL);
INSERT INTO `exam_answer` VALUES (39, 67, 1, 2, 'A', b'0', NULL, NULL, '2018-07-28 11:05:45', NULL, NULL);
INSERT INTO `exam_answer` VALUES (40, 68, 1, 1, 'A,B', b'0', NULL, NULL, '2018-07-28 11:10:35', NULL, NULL);
INSERT INTO `exam_answer` VALUES (41, 68, 1, 2, 'A', b'0', NULL, NULL, '2018-07-28 11:10:39', NULL, NULL);
INSERT INTO `exam_answer` VALUES (42, 69, 1, 1, 'A', b'0', NULL, NULL, '2018-07-28 11:12:01', NULL, NULL);
INSERT INTO `exam_answer` VALUES (43, 69, 1, 2, 'A', b'0', NULL, NULL, '2018-07-28 11:12:04', NULL, NULL);
INSERT INTO `exam_answer` VALUES (44, 70, 1, 1, 'A', b'0', NULL, NULL, '2018-07-28 11:12:42', NULL, NULL);
INSERT INTO `exam_answer` VALUES (45, 70, 1, 2, 'A', b'0', NULL, NULL, '2018-07-28 11:12:45', NULL, NULL);
INSERT INTO `exam_answer` VALUES (46, 71, 1, 1, 'A', b'1', NULL, NULL, '2018-07-28 13:06:14', NULL, NULL);
INSERT INTO `exam_answer` VALUES (47, 71, 1, 2, 'A,B', b'1', NULL, NULL, '2018-07-28 13:06:22', NULL, NULL);
INSERT INTO `exam_answer` VALUES (48, 71, 1, 2, 'A,B', b'1', NULL, NULL, '2018-07-28 13:06:43', NULL, NULL);
INSERT INTO `exam_answer` VALUES (49, 71, 1, 2, 'A,B', b'1', NULL, NULL, '2018-07-28 13:07:17', NULL, NULL);
INSERT INTO `exam_answer` VALUES (50, 72, 1, 1, 'A', b'1', NULL, NULL, '2018-07-28 13:08:02', NULL, NULL);
INSERT INTO `exam_answer` VALUES (51, 72, 1, 2, 'A,B', b'1', NULL, NULL, '2018-07-28 13:08:07', NULL, NULL);
INSERT INTO `exam_answer` VALUES (52, 72, 1, 2, 'A,B', b'1', NULL, NULL, '2018-07-28 13:09:21', NULL, NULL);
INSERT INTO `exam_answer` VALUES (53, 73, 1, 1, 'A', b'1', NULL, NULL, '2018-07-28 13:11:53', NULL, NULL);
INSERT INTO `exam_answer` VALUES (54, 73, 1, 2, 'A,B', b'1', NULL, NULL, '2018-07-28 13:12:01', NULL, NULL);
INSERT INTO `exam_answer` VALUES (55, 73, 1, 3, 'C,D', b'1', NULL, NULL, '2018-07-28 13:12:11', NULL, NULL);
INSERT INTO `exam_answer` VALUES (56, 75, 1, 1, 'A', b'1', NULL, NULL, '2018-07-28 13:22:01', NULL, NULL);
INSERT INTO `exam_answer` VALUES (57, 75, 1, 2, 'A,B', b'1', 2, NULL, '2018-07-28 13:22:07', NULL, NULL);
INSERT INTO `exam_answer` VALUES (58, 75, 1, 3, 'C,D', b'1', 2, NULL, '2018-07-28 13:22:14', NULL, NULL);
INSERT INTO `exam_answer` VALUES (59, 76, 1, 1, 'A', b'1', NULL, NULL, '2018-07-28 13:23:21', NULL, NULL);
INSERT INTO `exam_answer` VALUES (60, 76, 1, 2, 'A,B', b'1', 2, NULL, '2018-07-28 13:23:24', NULL, NULL);
INSERT INTO `exam_answer` VALUES (61, 76, 1, 3, 'C,D', b'1', 2, NULL, '2018-07-28 13:23:27', NULL, NULL);
INSERT INTO `exam_answer` VALUES (62, 77, 1, 1, 'A', b'1', NULL, NULL, '2018-07-28 13:24:25', NULL, NULL);
INSERT INTO `exam_answer` VALUES (63, 77, 1, 2, 'A,B', b'1', 2, NULL, '2018-07-28 13:24:28', NULL, NULL);
INSERT INTO `exam_answer` VALUES (64, 77, 1, 3, 'C,D', b'1', 2, NULL, '2018-07-28 13:24:37', NULL, NULL);
INSERT INTO `exam_answer` VALUES (65, 78, 1, 1, 'A', b'1', 2, NULL, '2018-07-28 13:29:12', NULL, NULL);
INSERT INTO `exam_answer` VALUES (66, 78, 1, 1, 'A', b'1', 2, NULL, '2018-07-28 13:29:13', NULL, NULL);
INSERT INTO `exam_answer` VALUES (67, 78, 1, 2, 'A,B', b'1', 2, NULL, '2018-07-28 13:29:28', NULL, NULL);
INSERT INTO `exam_answer` VALUES (68, 78, 1, 3, 'C,D', b'1', 2, NULL, '2018-07-28 13:29:35', NULL, NULL);
INSERT INTO `exam_answer` VALUES (69, 79, 1, 1, 'A', b'1', 2, NULL, '2018-07-28 13:31:39', NULL, NULL);
INSERT INTO `exam_answer` VALUES (70, 79, 1, 2, 'A,B', b'1', 2, NULL, '2018-07-28 13:31:41', NULL, NULL);
INSERT INTO `exam_answer` VALUES (71, 79, 1, 3, 'C,D', b'1', 2, NULL, '2018-07-28 13:32:07', NULL, NULL);
INSERT INTO `exam_answer` VALUES (72, 80, 1, 1, 'A', b'1', 2, NULL, '2018-07-28 13:33:23', NULL, NULL);
INSERT INTO `exam_answer` VALUES (73, 80, 1, 2, 'A,B', b'1', 2, NULL, '2018-07-28 13:33:26', NULL, NULL);
INSERT INTO `exam_answer` VALUES (74, 80, 1, 3, 'A,B', b'0', 2, NULL, '2018-07-28 13:33:46', NULL, NULL);
INSERT INTO `exam_answer` VALUES (75, 81, 1, 1, 'A', b'1', 2, NULL, '2018-07-28 13:47:05', NULL, NULL);
INSERT INTO `exam_answer` VALUES (76, 81, 1, 2, 'A,B', b'1', 2, NULL, '2018-07-28 13:47:08', NULL, NULL);
INSERT INTO `exam_answer` VALUES (77, 81, 1, 3, 'C,D', b'1', 2, NULL, '2018-07-28 13:47:12', NULL, NULL);
INSERT INTO `exam_answer` VALUES (78, 83, 1, 1, 'A', b'1', 2, NULL, '2018-07-28 18:07:13', NULL, NULL);
INSERT INTO `exam_answer` VALUES (79, 83, 1, 2, 'A,B', b'1', 2, NULL, '2018-07-28 18:07:16', NULL, NULL);
INSERT INTO `exam_answer` VALUES (80, 83, 1, 3, 'C,D', b'1', 2, NULL, '2018-07-28 18:07:21', NULL, NULL);
INSERT INTO `exam_answer` VALUES (81, 84, 1, 1, 'A', b'1', 2, NULL, '2018-07-28 18:08:56', NULL, NULL);
INSERT INTO `exam_answer` VALUES (82, 84, 1, 2, 'A,C', b'0', 2, NULL, '2018-07-28 18:08:59', NULL, NULL);
INSERT INTO `exam_answer` VALUES (83, 84, 1, 3, 'A', b'0', 2, NULL, '2018-07-28 18:09:01', NULL, NULL);
INSERT INTO `exam_answer` VALUES (84, NULL, NULL, NULL, '', b'1', NULL, NULL, '2018-07-28 18:09:16', NULL, NULL);
INSERT INTO `exam_answer` VALUES (85, 86, 1, 1, 'A', b'1', 2, NULL, '2018-07-28 18:16:18', NULL, NULL);
INSERT INTO `exam_answer` VALUES (86, 86, 1, 2, 'A', b'0', 2, NULL, '2018-07-28 18:16:20', NULL, NULL);
INSERT INTO `exam_answer` VALUES (87, 86, 1, 3, 'A', b'0', 2, NULL, '2018-07-28 18:16:22', NULL, NULL);
INSERT INTO `exam_answer` VALUES (88, 87, 1, 1, 'A', b'1', 2, NULL, '2018-07-28 18:32:42', NULL, NULL);
INSERT INTO `exam_answer` VALUES (89, 87, 1, 2, 'A,B', b'1', 2, NULL, '2018-07-28 18:32:44', NULL, NULL);
INSERT INTO `exam_answer` VALUES (90, 87, 1, 3, 'A', b'0', 2, NULL, '2018-07-28 18:32:46', NULL, NULL);
INSERT INTO `exam_answer` VALUES (91, 89, 1, 1, 'A', b'1', 2, NULL, '2018-07-28 18:55:12', NULL, NULL);
INSERT INTO `exam_answer` VALUES (92, 89, 1, 2, 'A', b'0', 2, NULL, '2018-07-28 18:55:14', NULL, NULL);
INSERT INTO `exam_answer` VALUES (93, 89, 1, 3, 'A', b'0', 2, NULL, '2018-07-28 18:55:15', NULL, NULL);
INSERT INTO `exam_answer` VALUES (94, 90, 1, 1, 'A', b'1', 2, NULL, '2018-07-28 19:32:27', NULL, NULL);
INSERT INTO `exam_answer` VALUES (95, 90, 1, 2, 'A', b'0', 2, NULL, '2018-07-28 19:32:29', NULL, NULL);
INSERT INTO `exam_answer` VALUES (96, 90, 1, 3, 'A', b'0', 2, NULL, '2018-07-28 19:32:32', NULL, NULL);
INSERT INTO `exam_answer` VALUES (97, 92, 1, 1, 'A', b'1', 2, NULL, '2018-07-29 18:07:11', NULL, NULL);
INSERT INTO `exam_answer` VALUES (98, 92, 1, 2, 'A', b'0', 2, NULL, '2018-07-29 18:07:13', NULL, NULL);
INSERT INTO `exam_answer` VALUES (99, 92, 1, 3, 'C,D', b'1', 2, NULL, '2018-07-29 18:07:16', NULL, NULL);
INSERT INTO `exam_answer` VALUES (100, 93, 1, 1, 'A', b'1', 2, NULL, '2018-07-29 18:09:26', NULL, NULL);
INSERT INTO `exam_answer` VALUES (101, 93, 1, 2, 'C', b'0', 2, NULL, '2018-07-29 18:09:29', NULL, NULL);
INSERT INTO `exam_answer` VALUES (102, 93, 1, 3, 'B', b'0', 2, NULL, '2018-07-29 18:09:36', NULL, NULL);
INSERT INTO `exam_answer` VALUES (103, 94, 1, 1, 'B', b'0', 2, NULL, '2018-07-29 18:10:22', NULL, NULL);
INSERT INTO `exam_answer` VALUES (104, 94, 1, 2, 'C', b'0', 2, NULL, '2018-07-29 18:10:24', NULL, NULL);
INSERT INTO `exam_answer` VALUES (105, 94, 1, 3, 'D', b'0', 2, NULL, '2018-07-29 18:10:27', NULL, NULL);
INSERT INTO `exam_answer` VALUES (106, 95, 1, 1, 'A', b'1', 2, NULL, '2018-07-29 18:10:44', NULL, NULL);
INSERT INTO `exam_answer` VALUES (107, 95, 1, 2, 'A,B', b'1', 2, NULL, '2018-07-29 18:10:48', NULL, NULL);
INSERT INTO `exam_answer` VALUES (108, 95, 1, 3, 'C,D', b'1', 2, NULL, '2018-07-29 18:10:52', NULL, NULL);
INSERT INTO `exam_answer` VALUES (109, 97, 1, 1, 'A', b'1', 2, NULL, '2018-07-30 14:23:00', NULL, NULL);
INSERT INTO `exam_answer` VALUES (110, 97, 1, 2, 'A,B', b'1', 2, NULL, '2018-07-30 14:23:03', NULL, NULL);
INSERT INTO `exam_answer` VALUES (111, 97, 1, 3, 'C,D', b'1', 2, NULL, '2018-07-30 14:23:08', NULL, NULL);
INSERT INTO `exam_answer` VALUES (112, 98, 1, 1, 'A', b'1', 2, NULL, '2018-07-30 14:37:05', NULL, NULL);
INSERT INTO `exam_answer` VALUES (113, 98, 1, 2, 'A,B', b'1', 2, NULL, '2018-07-30 14:37:08', NULL, NULL);
INSERT INTO `exam_answer` VALUES (114, 98, 1, 3, 'B,C', b'0', 2, NULL, '2018-07-30 14:37:10', NULL, NULL);

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` tinyint(1) NULL DEFAULT NULL COMMENT '1-单选；2-多选',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `score` int(2) NULL DEFAULT NULL,
  `creater` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `modifier` int(11) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (1, 0, '宝宝不爱吃饭该怎么治疗？不爱吃饭影响身体发育，主要是宝宝一日三餐，没有一顿能好好吃一次，现在也不喝奶了。喜欢看书，都不知道他一天能量从哪里来。', 2, NULL, '2018-07-22 16:37:10', NULL, NULL);
INSERT INTO `question` VALUES (2, 0, '宝宝怕摔跤不走路怎么办？', 2, NULL, '2018-07-25 19:54:28', NULL, NULL);
INSERT INTO `question` VALUES (3, 0, '宝宝溢奶怎么办', 2, NULL, '2018-07-28 13:01:42', NULL, NULL);

-- ----------------------------
-- Table structure for question_bank
-- ----------------------------
DROP TABLE IF EXISTS `question_bank`;
CREATE TABLE `question_bank`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `single_num` int(2) NULL DEFAULT NULL,
  `multiple_num` int(2) NULL DEFAULT NULL,
  `total_score` int(2) NULL DEFAULT NULL,
  `duration` int(255) NULL DEFAULT NULL COMMENT '考试时间（分钟）',
  `qr_verify_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qr_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creater` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `modifier` int(11) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question_bank
-- ----------------------------
INSERT INTO `question_bank` VALUES (1, '妈妈校园毕业考试', '这次考试非常重要，里面每道题都精挑细选，通过了有惊喜哦！！！', NULL, NULL, NULL, NULL, '1234567890', NULL, '', NULL, '2018-07-22 12:02:59', NULL, NULL);

-- ----------------------------
-- Table structure for question_option
-- ----------------------------
DROP TABLE IF EXISTS `question_option`;
CREATE TABLE `question_option`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) NULL DEFAULT NULL,
  `letter` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `correct` bit(1) NULL DEFAULT NULL,
  `creater` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `modifier` int(11) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question_option
-- ----------------------------
INSERT INTO `question_option` VALUES (1, 1, 'A', '补锌', b'1', NULL, '2018-07-22 16:37:46', NULL, NULL);
INSERT INTO `question_option` VALUES (2, 1, 'B', '补钙', b'0', NULL, '2018-07-22 16:38:00', NULL, NULL);
INSERT INTO `question_option` VALUES (3, 1, 'C', '补铁', b'0', NULL, '2018-07-22 16:38:11', NULL, NULL);
INSERT INTO `question_option` VALUES (4, 1, 'D', '不许吃零食，不喝常温奶，可以喝奶粉，及冷藏酸奶，一定要注意营养均衡。', b'0', NULL, '2018-07-22 16:38:34', NULL, NULL);
INSERT INTO `question_option` VALUES (5, 2, 'A', '鼓励', b'1', NULL, '2018-07-25 19:57:38', NULL, NULL);
INSERT INTO `question_option` VALUES (6, 2, 'B', '不管', b'1', NULL, '2018-07-25 19:58:17', NULL, NULL);
INSERT INTO `question_option` VALUES (7, 2, 'C', '牵着手走', b'0', NULL, '2018-07-25 19:58:51', NULL, NULL);
INSERT INTO `question_option` VALUES (8, 2, 'D', '打一顿', b'0', NULL, '2018-07-25 19:59:29', NULL, NULL);
INSERT INTO `question_option` VALUES (9, 3, 'A', '再喂一次', b'0', NULL, '2018-07-28 13:02:19', NULL, NULL);
INSERT INTO `question_option` VALUES (10, 3, 'B', '抱起拍拍', b'0', NULL, '2018-07-28 13:02:26', NULL, NULL);
INSERT INTO `question_option` VALUES (11, 3, 'C', '侧头睡', b'1', NULL, '2018-07-28 13:02:30', NULL, NULL);
INSERT INTO `question_option` VALUES (12, 3, 'D', '每次少喂点', b'1', NULL, '2018-07-28 13:02:34', NULL, NULL);

-- ----------------------------
-- Table structure for relation_bank_question
-- ----------------------------
DROP TABLE IF EXISTS `relation_bank_question`;
CREATE TABLE `relation_bank_question`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_bank_id` int(11) NULL DEFAULT NULL,
  `question_id` int(11) NULL DEFAULT NULL,
  `seq` int(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of relation_bank_question
-- ----------------------------
INSERT INTO `relation_bank_question` VALUES (1, 1, 1, 1);
INSERT INTO `relation_bank_question` VALUES (2, 1, 2, 2);
INSERT INTO `relation_bank_question` VALUES (3, 1, 3, 3);

-- ----------------------------
-- Table structure for relation_train_doctor
-- ----------------------------
DROP TABLE IF EXISTS `relation_train_doctor`;
CREATE TABLE `relation_train_doctor`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `train_id` int(11) NULL DEFAULT NULL,
  `doctor_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for short_message
-- ----------------------------
DROP TABLE IF EXISTS `short_message`;
CREATE TABLE `short_message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sms_type` tinyint(1) NULL DEFAULT NULL COMMENT '1-验证码；',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of short_message
-- ----------------------------
INSERT INTO `short_message` VALUES (1, '18625206397', 1, '3815', '2018-07-29 14:32:24');
INSERT INTO `short_message` VALUES (2, '18625206397', 1, '6502', '2018-07-29 15:22:59');
INSERT INTO `short_message` VALUES (3, '18625206397', 1, '9207', '2018-07-29 15:27:23');
INSERT INTO `short_message` VALUES (4, '18625206397', 1, '9405', '2018-07-29 15:36:46');
INSERT INTO `short_message` VALUES (5, '18625209397', 1, '2773', '2018-07-29 15:52:42');
INSERT INTO `short_message` VALUES (6, '18625206397', 1, '7662', '2018-07-29 16:06:42');
INSERT INTO `short_message` VALUES (7, '18625206397', 1, '3829', '2018-07-29 16:07:08');
INSERT INTO `short_message` VALUES (8, '18625206397', 1, '5601', '2018-07-29 16:07:59');
INSERT INTO `short_message` VALUES (9, '18625206397', 1, '9584', '2018-07-29 16:09:33');
INSERT INTO `short_message` VALUES (10, '18625206397', 1, '9326', '2018-07-29 16:10:09');
INSERT INTO `short_message` VALUES (11, '18625206397', 1, '7002', '2018-07-29 16:12:30');
INSERT INTO `short_message` VALUES (12, '18625206397', 1, '9969', '2018-07-29 16:14:29');
INSERT INTO `short_message` VALUES (13, '18625206397', 1, '5682', '2018-07-29 16:16:31');
INSERT INTO `short_message` VALUES (14, '18625206397', 1, '4741', '2018-07-29 16:24:19');
INSERT INTO `short_message` VALUES (15, '18625206397', 1, '5175', '2018-07-29 16:28:18');
INSERT INTO `short_message` VALUES (16, '18625206397', 1, '5804', '2018-07-29 16:55:41');
INSERT INTO `short_message` VALUES (17, '18625206397', 1, '5827', '2018-07-29 16:57:17');
INSERT INTO `short_message` VALUES (18, '18625206397', 1, '1897', '2018-07-29 16:58:47');
INSERT INTO `short_message` VALUES (19, '18625206397', 1, '8935', '2018-07-29 17:00:12');
INSERT INTO `short_message` VALUES (20, '18625206397', 1, '5826', '2018-07-29 17:41:48');
INSERT INTO `short_message` VALUES (21, '18625206397', 1, '5126', '2018-07-29 17:47:07');
INSERT INTO `short_message` VALUES (22, '18625206397', 1, '9622', '2018-07-29 22:07:31');
INSERT INTO `short_message` VALUES (23, '18625206397', 1, '8223', '2018-07-29 22:28:59');
INSERT INTO `short_message` VALUES (24, '18625206397', 1, '2077', '2018-07-30 09:25:47');
INSERT INTO `short_message` VALUES (25, '18625206397', 1, '2426', '2018-07-30 10:34:50');
INSERT INTO `short_message` VALUES (26, '18625206397', 1, '6762', '2018-07-30 10:36:27');
INSERT INTO `short_message` VALUES (27, '18625206397', 1, '3538', '2018-07-30 10:43:27');
INSERT INTO `short_message` VALUES (28, '18625206397', 1, '9013', '2018-07-30 10:52:33');
INSERT INTO `short_message` VALUES (29, '18625206397', 1, '6896', '2018-07-30 11:04:46');
INSERT INTO `short_message` VALUES (30, '18625206397', 1, '2885', '2018-07-30 11:05:49');
INSERT INTO `short_message` VALUES (31, '18625206397', 1, '7677', '2018-07-30 11:26:10');
INSERT INTO `short_message` VALUES (32, '18625206397', 1, '3019', '2018-07-30 12:16:26');
INSERT INTO `short_message` VALUES (33, '18625206397', 1, '5197', '2018-07-30 13:08:48');
INSERT INTO `short_message` VALUES (34, '18625206397', 1, '5457', '2018-07-30 13:09:34');
INSERT INTO `short_message` VALUES (35, '18625206397', 1, '5319', '2018-07-30 13:10:21');
INSERT INTO `short_message` VALUES (36, '18625206397', 1, '8383', '2018-07-30 13:40:07');

-- ----------------------------
-- Table structure for train
-- ----------------------------
DROP TABLE IF EXISTS `train`;
CREATE TABLE `train`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `province_code` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `city_code` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `begin_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  `bank_id` int(11) NULL DEFAULT NULL,
  `status` int(255) NULL DEFAULT NULL,
  `remark` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creater` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `modifier` int(11) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for weixin_menu
-- ----------------------------
DROP TABLE IF EXISTS `weixin_menu`;
CREATE TABLE `weixin_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menu_key` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pid` int(11) NULL DEFAULT NULL,
  `response_type` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_UNIQUE`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of weixin_menu
-- ----------------------------
INSERT INTO `weixin_menu` VALUES (1, '学术培训', '111', 'aa', 'menu_doctor', 'click', NULL, NULL);
INSERT INTO `weixin_menu` VALUES (2, '科普服务', '222', 'bb', 'menu_mum', 'click', NULL, NULL);
INSERT INTO `weixin_menu` VALUES (3, '医孕宝俱乐部', '333', 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx33c840e0ffad7c2e&redirect_uri=http%3A%2F%2Fmumschool-front.ngrok.xiaomiqiu.cn%2Ffirst&response_type=code&scope=snsapi_base&state=1&connect_redirect=1', 'menu_club_login', 'view', NULL, NULL);
INSERT INTO `weixin_menu` VALUES (5, '在线考试', '444', 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx33c840e0ffad7c2e&redirect_uri=http%3A%2F%2Fmumschool-front.ngrok.xiaomiqiu.cn%2Ffirst&response_type=code&scope=snsapi_base&state=1&connect_redirect=1', 'menu_doctor_examine', 'view', 1, NULL);
INSERT INTO `weixin_menu` VALUES (6, '学术培训', '555', 'http://mumschool-front.ngrok.xiaomiqiu.cn/question', 'menu_doctor_train', 'view', 1, NULL);
INSERT INTO `weixin_menu` VALUES (7, '妈妈校园介绍', '666', 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx33c840e0ffad7c2e&redirect_uri=http%3A%2F%2Fmumschool-front.ngrok.xiaomiqiu.cn%2Ffirst&response_type=code&scope=snsapi_base&state=1&connect_redirect=1', 'menu_doctor_introduce', 'view', 1, NULL);
INSERT INTO `weixin_menu` VALUES (8, '甄选推荐', '777', 'http://mumschool.ngrok.xiaomiqiu.cn/mumschool/introduce', 'menu_mum_recommend', 'view', 2, NULL);
INSERT INTO `weixin_menu` VALUES (9, '专家咨询', '888', 'http://mumschool.ngrok.xiaomiqiu.cn/mumschool/introduce', 'menu_mum_consult', 'view', 2, NULL);
INSERT INTO `weixin_menu` VALUES (10, '母婴科普', '999', 'http://mumschool.ngrok.xiaomiqiu.cn/mumschool/introduce', 'menu_mum_knowledge', 'view', 2, NULL);
INSERT INTO `weixin_menu` VALUES (11, '公益讲座', '000', 'http://mumschool.ngrok.xiaomiqiu.cn/mumschool/introduce', 'menu_mum_school', 'view', 2, NULL);

-- ----------------------------
-- Table structure for weixin_qr
-- ----------------------------
DROP TABLE IF EXISTS `weixin_qr`;
CREATE TABLE `weixin_qr`  (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `snum` int(11) NULL DEFAULT NULL,
  `msg` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qr_data` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ticket` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of weixin_qr
-- ----------------------------
INSERT INTO `weixin_qr` VALUES (1, '扫码登录', 11, 0, 100406, '扫码登陆', 'http://mumschool-front.ngrok.xiaomiqiu.cn/login', 'gQH-7zwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyVkJkdDVxWFplLWgxdlB1aTFyMUEAAgQ-3lJbAwS0AAAA', '2018-07-21');
INSERT INTO `weixin_qr` VALUES (3, '扫码签到', 3, 0, 3, '欢迎参加妈妈校园大讲堂!', 'http://mumschool-front.ngrok.xiaomiqiu.cn/login', 'gQHh8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyenZBOTVQWFplLWgxMDAwMGcwMzkAAgQZ81JbAwQAAAAA', '2018-07-21');
INSERT INTO `weixin_qr` VALUES (4, '扫码考试', 5, 0, 51, '请狠戳我进入考试系统', 'http://mumschool-front.ngrok.xiaomiqiu.cn/login', 'gQGz8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAydHVHSzRaWFplLWgxMDAwMHcwM2UAAgTz8VJbAwQAAAAA', '2018-07-21');
INSERT INTO `weixin_qr` VALUES (7, '扫码考试', 5, 0, 100565, '请狠戳我进入考试系统', 'http://mumschool-front.ngrok.xiaomiqiu.cn/question', 'gQFS8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyRDBJMjRvWFplLWgxakctbE5yMVUAAgQ2PlVbAwS0AAAA', '2018-07-23');
INSERT INTO `weixin_qr` VALUES (8, '扫码考试', 5, 0, 100496, '请狠戳我进入考试系统', 'http://mumschool-front.ngrok.xiaomiqiu.cn/question', 'gQGK8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyR1JrVDRxWFplLWgxbGIxbDFyMUsAAgSXQFVbAwS0AAAA', '2018-07-23');

-- ----------------------------
-- Table structure for weixin_user
-- ----------------------------
DROP TABLE IF EXISTS `weixin_user`;
CREATE TABLE `weixin_user`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickname` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` tinyint(11) NULL DEFAULT NULL,
  `language` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `country` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `province` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `city` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `headimgurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `subscribe_time` datetime(0) NULL DEFAULT NULL,
  `groupid` int(11) NULL DEFAULT NULL,
  `tagid_list` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `subscribe_scene` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qr_scene` int(2) NULL DEFAULT NULL,
  `qr_scene_str` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `login_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NOT NULL COMMENT '0-取消关注；1-在关注',
  `bind` int(11) NULL DEFAULT NULL COMMENT '0-未绑定；1-已绑定',
  `user_type` int(255) NULL DEFAULT NULL COMMENT '0-员工；1-医生；2：孕妇；3：妈妈',
  `hospital` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` int(255) NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `gestational_weeks` int(255) NULL DEFAULT NULL,
  `pre_hospital` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `register_time` datetime(0) NULL DEFAULT NULL,
  `last_login_time` datetime(0) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creater` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `modifier` int(11) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `active` bit(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_UNIQUE`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of weixin_user
-- ----------------------------
INSERT INTO `weixin_user` VALUES (7, 'oez2-0fB-paUxeDTQOy1UnSfS-2I', '暖和', 1, 'zh_CN', '中国', '江苏', '苏州', 'http://thirdwx.qlogo.cn/mmopen/P3QglMOhpu6xeSBfQblQ7vq5TqU0ZYPQRgwZAE6wrILoOLP9TVY3XlBJCdrSoxqKkrJm0qrpPKoic0eS6go4GLWMvwzIvTGG5/132', '1970-01-19 01:36:05', 0, NULL, 'ADD_SCENE_QR_CODE', 0, NULL, '0', NULL, '18625206397', '0', 1, 0, 1, '0', '0', 0, NULL, 6, '11', NULL, NULL, NULL, NULL, '2018-07-21 17:32:00', NULL, '2018-07-21 17:32:00', b'1');
INSERT INTO `weixin_user` VALUES (8, 'oez2-0WQa-Ib93oL1bviBNS_HR-w', '人参', 1, NULL, NULL, NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/P3QglMOhpu7HO9sYwA0VZgoKKicqk6DsL0y9MpfNcvwkTt1aDnjh10Fic7RLG5CAJDK8WF017cRCAWnuTr0icwJAAfPbibWqc8Ln/132', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-07-30 12:19:34', NULL, '2018-07-30 12:19:34', b'1');
INSERT INTO `weixin_user` VALUES (9, 'oez2-0W-6lLq73gsRwQ8ihxtnrCI', 'Shirly', 2, NULL, NULL, NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/KxMpGZibiadRshPj5mpfpjQ9VMY3Ifianem4dQrUz9cnJibHckwHy0jUr8EKpCD9c4eINYKdkHK1iapEBtLmPaApBl5uFR3bUfARD/132', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-07-30 15:17:52', NULL, '2018-07-30 15:17:52', b'1');

SET FOREIGN_KEY_CHECKS = 1;
