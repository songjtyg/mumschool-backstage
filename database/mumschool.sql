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

 Date: 09/07/2018 22:32:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `openid` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img_url` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `sex` int(11) NULL DEFAULT NULL,
  `bind` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_UNIQUE`(`id`) USING BTREE
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
INSERT INTO `weixin_menu` VALUES (3, '!医孕宝俱乐部', '333', 'http://mumschool-front.ngrok.xiaomiqiu.cn/#/login', 'menu_club_login', 'view', NULL, NULL);
INSERT INTO `weixin_menu` VALUES (5, '在线考试', '444', 'http://mumschool.ngrok.xiaomiqiu.cn/mumschool/doctor/examine', 'menu_doctor_examine', 'view', 1, NULL);
INSERT INTO `weixin_menu` VALUES (6, '学术培训', '555', 'http://mumschool.ngrok.xiaomiqiu.cn/mumschool/doctor/train', 'menu_doctor_train', 'view', 1, NULL);
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
  `id` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `snum` int(11) NULL DEFAULT NULL,
  `msg` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qr_data` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ticket` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
