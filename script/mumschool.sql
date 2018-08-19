/*
 Navicat Premium Data Transfer

 Source Server         : sjt-mysql
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : mumschool

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 19/08/2018 23:46:57
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
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam
-- ----------------------------
INSERT INTO `exam` VALUES (1, 7, 1, 0, 6, '2018-08-05 03:23:47', NULL, NULL, '2018-08-05 03:23:47', NULL, NULL);
INSERT INTO `exam` VALUES (2, 7, 1, 0, 0, '2018-08-05 10:37:06', NULL, NULL, '2018-08-05 10:37:06', NULL, NULL);
INSERT INTO `exam` VALUES (3, 8, 1, 0, 0, '2018-08-05 14:02:48', NULL, NULL, '2018-08-05 14:02:48', NULL, NULL);
INSERT INTO `exam` VALUES (4, 8, 1, 0, 8, '2018-08-05 17:22:29', NULL, NULL, '2018-08-05 17:22:29', NULL, NULL);
INSERT INTO `exam` VALUES (5, 7, 1, 0, 6, '2018-08-05 17:35:28', NULL, NULL, '2018-08-05 17:35:28', NULL, NULL);
INSERT INTO `exam` VALUES (6, 8, 1, 0, 6, '2018-08-05 17:38:58', NULL, NULL, '2018-08-05 17:38:58', NULL, NULL);
INSERT INTO `exam` VALUES (7, 8, 1, 0, 6, '2018-08-05 18:42:29', NULL, NULL, '2018-08-05 18:42:29', NULL, NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_answer
-- ----------------------------
INSERT INTO `exam_answer` VALUES (1, 1, 1, 1, 'A', b'1', 2, NULL, '2018-08-05 03:23:52', NULL, NULL);
INSERT INTO `exam_answer` VALUES (2, 1, 1, 2, 'A,B', b'1', 2, NULL, '2018-08-05 03:23:54', NULL, NULL);
INSERT INTO `exam_answer` VALUES (3, 1, 1, 3, 'C,D', b'1', 2, NULL, '2018-08-05 03:23:56', NULL, NULL);
INSERT INTO `exam_answer` VALUES (4, 4, 1, 1, 'A', b'1', 2, NULL, '2018-08-05 17:22:33', NULL, NULL);
INSERT INTO `exam_answer` VALUES (5, 4, 1, 2, 'A,B', b'1', 2, NULL, '2018-08-05 17:22:35', NULL, NULL);
INSERT INTO `exam_answer` VALUES (6, 4, 1, 3, 'C,D', b'1', 2, NULL, '2018-08-05 17:22:38', NULL, NULL);
INSERT INTO `exam_answer` VALUES (7, 4, 1, 3, 'C,D', b'1', 2, NULL, '2018-08-05 17:22:40', NULL, NULL);
INSERT INTO `exam_answer` VALUES (8, 5, 1, 1, 'A', b'1', 2, NULL, '2018-08-05 17:35:31', NULL, NULL);
INSERT INTO `exam_answer` VALUES (9, 5, 1, 2, 'A,B', b'1', 2, NULL, '2018-08-05 17:35:33', NULL, NULL);
INSERT INTO `exam_answer` VALUES (10, 5, 1, 3, 'C,D', b'1', 2, NULL, '2018-08-05 17:35:35', NULL, NULL);
INSERT INTO `exam_answer` VALUES (11, 6, 1, 1, 'A', b'1', 2, NULL, '2018-08-05 17:39:01', NULL, NULL);
INSERT INTO `exam_answer` VALUES (12, 6, 1, 2, 'A,B', b'1', 2, NULL, '2018-08-05 17:39:03', NULL, NULL);
INSERT INTO `exam_answer` VALUES (13, 6, 1, 3, 'C,D', b'1', 2, NULL, '2018-08-05 17:39:04', NULL, NULL);
INSERT INTO `exam_answer` VALUES (14, 7, 1, 1, 'A', b'1', 2, NULL, '2018-08-05 18:42:35', NULL, NULL);
INSERT INTO `exam_answer` VALUES (15, 7, 1, 2, 'A,B', b'1', 2, NULL, '2018-08-05 18:42:37', NULL, NULL);
INSERT INTO `exam_answer` VALUES (16, 7, 1, 3, 'C,D', b'1', 2, NULL, '2018-08-05 18:42:39', NULL, NULL);

-- ----------------------------
-- Table structure for lecture
-- ----------------------------
DROP TABLE IF EXISTS `lecture`;
CREATE TABLE `lecture`  (
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
-- Table structure for relation_lecture_mum
-- ----------------------------
DROP TABLE IF EXISTS `relation_lecture_mum`;
CREATE TABLE `relation_lecture_mum`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `train_id` int(11) NULL DEFAULT NULL,
  `doctor_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
INSERT INTO `short_message` VALUES (24, '18625206397', 1, '7274', '2018-07-30 23:34:55');

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
INSERT INTO `weixin_menu` VALUES (3, '医孕宝俱乐部', '333', 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx33c840e0ffad7c2e&redirect_uri=http%3A%2F%2Fmumschool-front.ngrok.xiaomiqiu.cn&response_type=code&scope=snsapi_base&state=1&connect_redirect=1', 'menu_club_login', 'view', NULL, NULL);
INSERT INTO `weixin_menu` VALUES (5, '在线考试', '444', '', 'menu_doctor_examine', 'scancode_push', 1, NULL);
INSERT INTO `weixin_menu` VALUES (6, '学术培训', '555', 'http://mumschool-front.ngrok.xiaomiqiu.cn/question', 'menu_doctor_train', 'view', 1, NULL);
INSERT INTO `weixin_menu` VALUES (7, '妈妈校园介绍', '666', 'http://mumschool-front.ngrok.xiaomiqiu.cn/scanToExam', 'menu_doctor_introduce', 'view', 1, NULL);
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
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of weixin_user
-- ----------------------------
INSERT INTO `weixin_user` VALUES (7, 'oez2-0fB-paUxeDTQOy1UnSfS-2I', '暖和', 1, 'zh_CN', '中国', '江苏', '苏州', 'http://thirdwx.qlogo.cn/mmopen/P3QglMOhpu6xeSBfQblQ7vq5TqU0ZYPQRgwZAE6wrILoOLP9TVY3XlBJCdrSoxqKkrJm0qrpPKoic0eS6go4GLWMvwzIvTGG5/132', '1970-01-19 01:36:05', 0, NULL, 'ADD_SCENE_QR_CODE', 0, NULL, '11', NULL, '18625206397', '111111', 1, 0, 2, 'tt', 'tt', 0, NULL, 6, '11', NULL, NULL, NULL, NULL, '2018-07-21 17:32:00', NULL, '2018-07-21 17:32:00', b'1');
INSERT INTO `weixin_user` VALUES (8, 'oez2-0W-6lLq73gsRwQ8ihxtnrCI', 'Shirly', 2, 'zh_CN', '中国', '江苏', '苏州', 'http://thirdwx.qlogo.cn/mmopen/KxMpGZibiadRshPj5mpfpjQ9VMY3Ifianem4dQrUz9cnJibHckwHy0jUr8EKpCD9c4eINYKdkHK1iapEBtLmPaApBl5uFR3bUfARD/132', '1970-01-19 01:57:17', 0, NULL, 'ADD_SCENE_QR_CODE', 0, NULL, 'Shirly', NULL, NULL, '123456', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-08-05 10:38:28', NULL, '2018-08-05 10:38:28', b'1');

SET FOREIGN_KEY_CHECKS = 1;
