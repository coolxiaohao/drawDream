/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : drawdream

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-04-07 21:58:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'admin_id',
  `adminName` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '管理员名称',
  `adminPwd` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '管理员密码',
  `adminActionPwd` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '管理员操作密码',
  `adminPhone` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '管理员联系电话',
  `adminToken` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '管理员登陆Token',
  `adminRuleId` int(11) DEFAULT NULL COMMENT '管理员权限',
  `addTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '添加日期',
  `editTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `headPortrait` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'e10adc3949ba59abbe56e057f20f883e', '13537430256', null, '1', '2020-04-07 21:18:19', '2020-04-07 21:18:19', null);

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `logType` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `logContent` text CHARACTER SET utf8,
  `addTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `path` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of log
-- ----------------------------

-- ----------------------------
-- Table structure for rule
-- ----------------------------
DROP TABLE IF EXISTS `rule`;
CREATE TABLE `rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员权限列表id',
  `ruleName` varchar(255) CHARACTER SET utf8 NOT NULL,
  `accessPath` varchar(255) CHARACTER SET utf8 NOT NULL,
  `needRule` int(4) DEFAULT '0' COMMENT '是否需要访问限制（0.需要,1.不需要）',
  `type` int(4) DEFAULT '1' COMMENT '是否启用（1.启用，2.禁用）',
  `addTime` datetime DEFAULT NULL COMMENT '添加时间',
  `port` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '权限属于哪一个端（‘admin’,‘home’,''api''）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of rule
-- ----------------------------
INSERT INTO `rule` VALUES ('1', '后台登录', '/admin/login', '1', '0', '2020-04-07 19:23:43', 'admin');

-- ----------------------------
-- Table structure for rulegroup
-- ----------------------------
DROP TABLE IF EXISTS `rulegroup`;
CREATE TABLE `rulegroup` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `groupName` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '权限组名称',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '权限属于后台还是前台（0.后台，1.PC，２.APP）',
  `ruleGroup` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '权限规则组',
  `isDefault` int(11) NOT NULL DEFAULT '0' COMMENT '是否默认（0.否，1.是）',
  `addTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '添加时间',
  `editTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of rulegroup
-- ----------------------------
INSERT INTO `rulegroup` VALUES ('1', '默认', '0', '1', '1', '2020-04-07 19:25:27', '2020-04-07 19:25:32');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '用户名',
  `userPwd` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '密码',
  `userKey` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '密钥',
  `userDealPwd` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '交易密码',
  `userDealKey` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '交易密钥',
  `status` int(4) NOT NULL DEFAULT '0' COMMENT '是否禁用（0.否，1.是）',
  `userPhone` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户电话号码',
  `addTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '添加时间',
  `editTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
