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

 Date: 27/07/2018 14:51:33
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
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_answer
-- ----------------------------
INSERT INTO `exam_answer` VALUES (8, 54, 1, 1, '', b'0', NULL, NULL, '2018-07-27 14:25:37', NULL, NULL);
INSERT INTO `exam_answer` VALUES (9, 55, 1, 1, '', b'0', NULL, NULL, '2018-07-27 14:30:15', NULL, NULL);

-- ----------------------------
-- Table structure for phone_identify
-- ----------------------------
DROP TABLE IF EXISTS `phone_identify`;
CREATE TABLE `phone_identify`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `identifying_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (1, 0, '宝宝不爱吃饭该怎么治疗？不爱吃饭影响身体发育，主要是宝宝一日三餐，没有一顿能好好吃一次，现在也不喝奶了。喜欢看书，都不知道他一天能量从哪里来。', 2, NULL, '2018-07-22 16:37:10', NULL, NULL);
INSERT INTO `question` VALUES (2, 0, '宝宝怕摔跤不走路怎么办？', 2, NULL, '2018-07-25 19:54:28', NULL, NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question_option
-- ----------------------------
INSERT INTO `question_option` VALUES (1, 1, 'A', '补锌', b'1', NULL, '2018-07-22 16:37:46', NULL, NULL);
INSERT INTO `question_option` VALUES (2, 1, 'B', '补钙', b'0', NULL, '2018-07-22 16:38:00', NULL, NULL);
INSERT INTO `question_option` VALUES (3, 1, 'C', '补铁', b'0', NULL, '2018-07-22 16:38:11', NULL, NULL);
INSERT INTO `question_option` VALUES (4, 1, 'D', '不许吃零食，不喝常温奶，可以喝奶粉，及冷藏酸奶，一定要注意营养均衡。', b'1', NULL, '2018-07-22 16:38:34', NULL, NULL);
INSERT INTO `question_option` VALUES (5, 2, 'A', '鼓励', b'1', NULL, '2018-07-25 19:57:38', NULL, NULL);
INSERT INTO `question_option` VALUES (6, 2, 'B', '不管', b'0', NULL, '2018-07-25 19:58:17', NULL, NULL);
INSERT INTO `question_option` VALUES (7, 2, 'C', '牵着手走', b'1', NULL, '2018-07-25 19:58:51', NULL, NULL);
INSERT INTO `question_option` VALUES (8, 2, 'D', '打一顿', b'0', NULL, '2018-07-25 19:59:29', NULL, NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of relation_bank_question
-- ----------------------------
INSERT INTO `relation_bank_question` VALUES (1, 1, 1, 1);
INSERT INTO `relation_bank_question` VALUES (2, 1, 2, 2);

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
INSERT INTO `weixin_menu` VALUES (3, '医孕宝俱乐部', '333', 'http://mumschool-front.ngrok.xiaomiqiu.cn/login', 'menu_club_login', 'view', NULL, NULL);
INSERT INTO `weixin_menu` VALUES (5, '在线考试', '444', 'http://mumschool-front.ngrok.xiaomiqiu.cn/scanToExam', 'menu_doctor_examine', 'view', 1, NULL);
INSERT INTO `weixin_menu` VALUES (6, '学术培训', '555', 'http://mumschool-front.ngrok.xiaomiqiu.cn/question', 'menu_doctor_train', 'view', 1, NULL);
INSERT INTO `weixin_menu` VALUES (7, '妈妈校园介绍', '666', 'http://mumschool.ngrok.xiaomiqiu.cn/mumschool/introduce', 'menu_doctor_introduce', 'view', 1, NULL);
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
  `status` int(11) NULL DEFAULT NULL,
  `bind` int(11) NULL DEFAULT NULL,
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
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of weixin_user
-- ----------------------------
INSERT INTO `weixin_user` VALUES (7, 'oez2-0fB-paUxeDTQOy1UnSfS-2I', '暖和', 1, 'zh_CN', '中国', '江苏', '苏州', 'http://thirdwx.qlogo.cn/mmopen/P3QglMOhpu6xeSBfQblQ7vq5TqU0ZYPQRgwZAE6wrILoOLP9TVY3XlBJCdrSoxqKkrJm0qrpPKoic0eS6go4GLWMvwzIvTGG5/132', '1970-01-19 01:36:05', 0, NULL, 'ADD_SCENE_QR_CODE', 0, NULL, '暖和', NULL, NULL, '123456', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-07-21 17:32:00', NULL, '2018-07-21 17:32:00', b'1');

SET FOREIGN_KEY_CHECKS = 1;
