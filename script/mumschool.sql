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

 Date: 22/07/2018 23:53:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for exam_answer
-- ----------------------------
DROP TABLE IF EXISTS `exam_answer`;
CREATE TABLE `exam_answer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `exam_id` int(11) NULL DEFAULT NULL,
  `questin_bank_Id` int(11) NULL DEFAULT NULL,
  `question_id` int(11) NULL DEFAULT NULL,
  `choices` set('A','B','C','D') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `correct` bit(1) NULL DEFAULT NULL,
  `score` int(2) NULL DEFAULT NULL,
  `creater` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `modifier` int(11) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (1, 0, '宝宝不爱吃饭该怎么治疗？不爱吃饭影响身体发育，主要是宝宝一日三餐，没有一顿能好好吃一次，现在也不喝奶了。喜欢看书，都不知道他一天能量从哪里来。', 1, NULL, '2018-07-22 16:37:10', NULL, NULL);

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
INSERT INTO `question_bank` VALUES (1, '妈妈校园毕业考试', '这次考试非常重要，里面每道题都精挑细选，通过了有惊喜哦！！！', NULL, NULL, NULL, NULL, '', NULL, '2018-07-22 12:02:59', NULL, NULL);

-- ----------------------------
-- Table structure for question_choice
-- ----------------------------
DROP TABLE IF EXISTS `question_choice`;
CREATE TABLE `question_choice`  (
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
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question_choice
-- ----------------------------
INSERT INTO `question_choice` VALUES (1, 1, 'A', '补锌', b'1', NULL, '2018-07-22 16:37:46', NULL, NULL);
INSERT INTO `question_choice` VALUES (2, 1, 'B', '补钙', NULL, NULL, '2018-07-22 16:38:00', NULL, NULL);
INSERT INTO `question_choice` VALUES (3, 1, 'C', '补铁', NULL, NULL, '2018-07-22 16:38:11', NULL, NULL);
INSERT INTO `question_choice` VALUES (4, 1, 'D', '不许吃零食，不喝常温奶，可以喝奶粉，及冷藏酸奶，一定要注意营养均衡。', b'1', NULL, '2018-07-22 16:38:34', NULL, NULL);

-- ----------------------------
-- Table structure for relation_bank_question
-- ----------------------------
DROP TABLE IF EXISTS `relation_bank_question`;
CREATE TABLE `relation_bank_question`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_bank_id` int(11) NULL DEFAULT NULL,
  `question_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_exam
-- ----------------------------
DROP TABLE IF EXISTS `user_exam`;
CREATE TABLE `user_exam`  (
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
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of weixin_qr
-- ----------------------------
INSERT INTO `weixin_qr` VALUES (1, '扫码登录', 11, 0, 100406, '扫码登陆', 'http://mumschool-front.ngrok.xiaomiqiu.cn/login', 'gQH-7zwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyVkJkdDVxWFplLWgxdlB1aTFyMUEAAgQ-3lJbAwS0AAAA', '2018-07-21');
INSERT INTO `weixin_qr` VALUES (3, '扫码签到', 3, 0, 3, '欢迎参加妈妈校园大讲堂!', 'http://mumschool-front.ngrok.xiaomiqiu.cn/login', 'gQHh8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyenZBOTVQWFplLWgxMDAwMGcwMzkAAgQZ81JbAwQAAAAA', '2018-07-21');
INSERT INTO `weixin_qr` VALUES (4, '扫码考试', 5, 0, 51, '请狠戳我进入考试系统', 'http://mumschool-front.ngrok.xiaomiqiu.cn/login', 'gQGz8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAydHVHSzRaWFplLWgxMDAwMHcwM2UAAgTz8VJbAwQAAAAA', '2018-07-21');

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
