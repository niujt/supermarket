/*
Navicat MySQL Data Transfer

Source Server         : Mysqlsql
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : smbms

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2018-06-11 16:58:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for smbms_bill
-- ----------------------------
DROP TABLE IF EXISTS `smbms_bill`;
CREATE TABLE `smbms_bill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `billCode` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '账单编码',
  `productName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品名称',
  `productDesc` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品描述',
  `productUnit` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品单位',
  `productCount` decimal(20,2) DEFAULT NULL COMMENT '商品数量',
  `totalPrice` decimal(20,2) DEFAULT NULL COMMENT '商品总额',
  `isin` int(11) DEFAULT NULL,
  `isPayment` int(10) DEFAULT NULL COMMENT '是否支付（1：未支付 2：已支付）',
  `createdBy` bigint(20) DEFAULT NULL COMMENT '创建者（userId）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(20) DEFAULT NULL COMMENT '更新者（userId）',
  `modifyDate` datetime DEFAULT NULL COMMENT '更新时间',
  `providerId` bigint(20) DEFAULT NULL COMMENT '供应商ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of smbms_bill
-- ----------------------------
INSERT INTO `smbms_bill` VALUES ('19', 'DD20180301', '蒙牛优酸乳', null, '瓶', '100.00', '300.00', '1', '2', '17', '2018-04-07 23:20:47', null, null, '16');
INSERT INTO `smbms_bill` VALUES ('20', 'DD20180427', '伊利酸酸乳', null, '瓶', '400.00', '800.00', '2', '2', '17', '2018-04-27 13:45:50', null, null, '17');
INSERT INTO `smbms_bill` VALUES ('21', 'DD20180427', '鸡肉', null, '斤', '40.00', '200.00', '1', '1', '17', '2018-04-27 13:46:53', '17', '2018-04-27 13:50:00', '18');
INSERT INTO `smbms_bill` VALUES ('23', 'DD34124312', '鳄鱼肉', null, '斤', '30.00', '600.00', '2', '2', '17', '2018-04-30 01:51:14', '17', '2018-04-30 02:24:34', '20');
INSERT INTO `smbms_bill` VALUES ('33', 'DD34124312', 'dasad', null, '斤', '40.00', '800.00', '2', '2', '17', '2018-05-25 09:55:49', null, null, '16');
INSERT INTO `smbms_bill` VALUES ('34', 'DD34124312', 'sad', null, '斤', '40.00', '800.00', '1', '2', '17', '2018-05-25 09:55:50', null, null, '16');
INSERT INTO `smbms_bill` VALUES ('35', 'DD341222', 'qw', null, '斤', '40.00', '800.00', '1', '2', '17', '2018-05-25 09:55:52', null, null, '16');
INSERT INTO `smbms_bill` VALUES ('37', 'DD341111', '222', null, '斤', '40.00', '800.00', '2', '2', '17', '2018-05-25 09:55:55', null, null, '16');
INSERT INTO `smbms_bill` VALUES ('38', 'DD3412111', '333', null, '斤', '40.00', '800.00', '2', '2', '17', '2018-05-25 09:55:57', null, null, '16');

-- ----------------------------
-- Table structure for smbms_dept
-- ----------------------------
DROP TABLE IF EXISTS `smbms_dept`;
CREATE TABLE `smbms_dept` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `dcode` varchar(40) DEFAULT NULL,
  `dname` varchar(40) DEFAULT NULL,
  `dnumber` int(10) DEFAULT NULL,
  `createdby` bigint(10) DEFAULT NULL,
  `creationDate` datetime DEFAULT NULL,
  `modifyBy` bigint(10) DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of smbms_dept
-- ----------------------------
INSERT INTO `smbms_dept` VALUES ('0000000001', 'YG', '普通员工', '30', null, null, null, null);
INSERT INTO `smbms_dept` VALUES ('0000000002', 'JL', '经理', '10', null, null, null, null);

-- ----------------------------
-- Table structure for smbms_goods
-- ----------------------------
DROP TABLE IF EXISTS `smbms_goods`;
CREATE TABLE `smbms_goods` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `gcode` varchar(40) DEFAULT NULL,
  `gname` varchar(40) DEFAULT NULL,
  `gnumber` int(10) DEFAULT NULL,
  `gunit` varchar(40) DEFAULT NULL,
  `pprice` decimal(10,2) DEFAULT NULL,
  `sname` varchar(40) DEFAULT NULL,
  `createdBy` bigint(10) DEFAULT NULL,
  `creationDate` datetime DEFAULT NULL,
  `modifyBy` bigint(10) DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of smbms_goods
-- ----------------------------
INSERT INTO `smbms_goods` VALUES ('21', 'KC20180418', '伊利优酸乳', '399', '瓶', '2.50', '伊利优酸乳', '17', '2018-04-29 18:32:58', '17', '2018-04-30 01:41:19');
INSERT INTO `smbms_goods` VALUES ('22', 'KC20180430', '狗肉', '65', '斤', '35.00', '狗肉', '17', '2018-04-29 20:01:51', null, null);
INSERT INTO `smbms_goods` VALUES ('23', 'KC2018231', '牛肉', '80', '斤', '45.00', '牛肉', '17', '2018-04-30 00:33:44', null, null);
INSERT INTO `smbms_goods` VALUES ('24', 'KCA12312', '鸭肉', '100', '斤', '14.50', '鸭肉', '17', '2018-04-30 01:09:00', null, null);
INSERT INTO `smbms_goods` VALUES ('25', 'KC2143124', '鸡肉', '20', '斤', '6.60', '鸡肉', '17', '2018-04-30 01:20:01', null, null);
INSERT INTO `smbms_goods` VALUES ('26', 'KC20180430', '青蛙腿', '20', '只', '30.00', '青蛙腿', '17', '2018-04-30 02:09:25', null, null);
INSERT INTO `smbms_goods` VALUES ('31', 'KC20180430', '鹿鞭', '57', '根', '14.00', '鹿鞭', '17', '2018-04-30 02:36:46', null, null);
INSERT INTO `smbms_goods` VALUES ('32', 'KC312312', '鲤鱼', '30', '条', '4.50', '鲤鱼', '17', '2018-04-30 02:49:41', null, null);
INSERT INTO `smbms_goods` VALUES ('37', 'asdasd', '鸡蛋', '12', '个', '2.50', '鸡蛋', '17', '2018-05-08 12:34:22', null, null);
INSERT INTO `smbms_goods` VALUES ('38', 'KC20180510', '鸡爪', '250', '斤', '2.50', '鸡爪', '17', '2018-05-10 10:52:38', null, null);

-- ----------------------------
-- Table structure for smbms_people
-- ----------------------------
DROP TABLE IF EXISTS `smbms_people`;
CREATE TABLE `smbms_people` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `peopleName` varchar(40) DEFAULT NULL,
  `peopleAge` int(10) DEFAULT NULL,
  `deptid` bigint(10) DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  `gender` int(10) DEFAULT NULL,
  `createdBy` varchar(40) DEFAULT NULL,
  `creationDate` datetime DEFAULT NULL,
  `modifyBy` varchar(40) DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of smbms_people
-- ----------------------------
INSERT INTO `smbms_people` VALUES ('1', '小明', '15', '1', '1000.00', '1', '17', '2018-04-27 12:49:48', null, null);
INSERT INTO `smbms_people` VALUES ('3', '小刚', '12', '2', '33300.00', '1', '17', '2018-04-27 13:30:46', '17', '2018-04-30 03:51:01');
INSERT INTO `smbms_people` VALUES ('4', '小赵', '13', '2', '13300.00', '1', '17', '2018-04-27 13:30:48', '17', '2018-04-30 03:50:49');
INSERT INTO `smbms_people` VALUES ('5', '小孙', '14', '1', '2312.00', '2', '17', '2018-04-27 13:30:51', null, null);
INSERT INTO `smbms_people` VALUES ('6', '小李', '15', '1', '4230.00', '2', '17', '2018-04-27 13:30:54', '17', '2018-04-30 03:50:41');
INSERT INTO `smbms_people` VALUES ('14', '李刚', '34', '2', '7310.00', '1', '17', '2018-04-29 14:52:16', '17', '2018-04-29 14:52:44');
INSERT INTO `smbms_people` VALUES ('15', '王刚', '32', '1', '4001.00', '2', '17', '2018-05-04 22:47:07', '17', '2018-05-04 22:47:20');

-- ----------------------------
-- Table structure for smbms_provider
-- ----------------------------
DROP TABLE IF EXISTS `smbms_provider`;
CREATE TABLE `smbms_provider` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `proCode` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商编码',
  `proName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商名称',
  `proDesc` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商详细描述',
  `proContact` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商联系人',
  `proPhone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `proAddress` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '地址',
  `proFax` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '传真',
  `createdBy` bigint(20) DEFAULT NULL COMMENT '创建者（userId）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyDate` datetime DEFAULT NULL COMMENT '更新时间',
  `modifyBy` bigint(20) DEFAULT NULL COMMENT '更新者（userId）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of smbms_provider
-- ----------------------------
INSERT INTO `smbms_provider` VALUES ('16', 'GG20180301', '蒙牛', 'sjajsjasjj', '小米', '18115530702', '江苏苏州吴江', '63618279', '17', '2018-04-07 23:19:45', null, null);
INSERT INTO `smbms_provider` VALUES ('17', 'GG20180401', '伊利', '牛奶还是伊利的好', '小红', '18115530702', '江苏宿迁大石街道', '63618279', '17', '2018-04-16 12:54:26', '2018-04-27 01:44:11', '17');
INSERT INTO `smbms_provider` VALUES ('18', 'GG20180427', '鸡肉大亨', '丑的一比', '冯世林', '18115530702', '江苏无锡', '63618279', '17', '2018-04-27 13:49:41', null, null);
INSERT INTO `smbms_provider` VALUES ('19', 'GGS20180429', '猪厂', '又臭又香', '杨幂', '18115530702', '北京相城区', '63618279', '17', '2018-04-29 21:17:31', '2018-05-04 22:55:00', '17');
INSERT INTO `smbms_provider` VALUES ('20', 'GG2018231', '大型屠宰场', '现代鲁智深', '王阳明', '18115530702', '上海浦东新区', '63618279', '17', '2018-04-30 02:24:09', '2018-04-30 04:02:44', '17');

-- ----------------------------
-- Table structure for smbms_refuse
-- ----------------------------
DROP TABLE IF EXISTS `smbms_refuse`;
CREATE TABLE `smbms_refuse` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `refCode` varchar(40) DEFAULT NULL,
  `refName` varchar(40) DEFAULT NULL,
  `refunit` varchar(40) DEFAULT NULL,
  `refnumber` int(10) DEFAULT NULL,
  `refReasion` varchar(40) DEFAULT NULL,
  `createBy` bigint(10) DEFAULT NULL,
  `creationDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `modifyBy` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of smbms_refuse
-- ----------------------------
INSERT INTO `smbms_refuse` VALUES ('26', 'TH20180417', '鸡肉', '斤', '25', '21312', '17', '2018-04-30 01:39:38', '2018-04-30 01:39:48', '17');
INSERT INTO `smbms_refuse` VALUES ('27', 'TH20180417', '伊利优酸乳', '瓶', '1', 'qasqs', '17', '2018-04-30 01:40:42', '2018-04-30 01:41:07', '17');
INSERT INTO `smbms_refuse` VALUES ('29', 'TH20180525', '111', '只', '20', '取消111的订单', '17', '2018-05-25 10:09:25', null, null);
INSERT INTO `smbms_refuse` VALUES ('30', 'TH20180525', 'sad', '个', '112', '清空sad的库存', '17', '2018-05-25 10:17:25', null, null);

-- ----------------------------
-- Table structure for smbms_role
-- ----------------------------
DROP TABLE IF EXISTS `smbms_role`;
CREATE TABLE `smbms_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `roleCode` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色编码',
  `roleName` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色名称',
  `createdBy` bigint(20) DEFAULT NULL COMMENT '创建者',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(20) DEFAULT NULL COMMENT '修改者',
  `modifyDate` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of smbms_role
-- ----------------------------
INSERT INTO `smbms_role` VALUES ('1', 'admin', '系统管理员', '1', '2018-05-23 00:00:00', null, null);
INSERT INTO `smbms_role` VALUES ('2', 'manage', '经理', '1', '2018-05-23 00:00:00', null, null);
INSERT INTO `smbms_role` VALUES ('3', 'saleman', '销售人员', '1', '2018-05-23 12:55:46', null, null);

-- ----------------------------
-- Table structure for smbms_sale
-- ----------------------------
DROP TABLE IF EXISTS `smbms_sale`;
CREATE TABLE `smbms_sale` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `scode` varchar(40) DEFAULT NULL,
  `sname` varchar(40) DEFAULT NULL,
  `snumber` int(10) DEFAULT NULL,
  `sunit` varchar(40) DEFAULT NULL,
  `pprice` decimal(20,2) DEFAULT NULL COMMENT '进价',
  `sprice` decimal(20,2) DEFAULT NULL COMMENT '售价',
  `createdBy` bigint(10) DEFAULT NULL,
  `creationDate` datetime DEFAULT NULL,
  `modifyBy` bigint(10) DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of smbms_sale
-- ----------------------------
INSERT INTO `smbms_sale` VALUES ('22', 'SS20180429', '伊利优酸乳', '12', '瓶', '3.50', '4.50', '17', '2018-04-29 20:11:18', null, null);
INSERT INTO `smbms_sale` VALUES ('23', 'SS20180429', '伊利优酸乳', '5', '瓶', '2.50', '3.60', '17', '2018-04-29 20:11:33', null, null);
INSERT INTO `smbms_sale` VALUES ('28', 'SS20180429', '青蛙腿', '4', '斤', '32.00', '40.00', '17', '2018-04-29 20:34:21', '17', '2018-05-10 10:40:21');

-- ----------------------------
-- Table structure for smbms_user
-- ----------------------------
DROP TABLE IF EXISTS `smbms_user`;
CREATE TABLE `smbms_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `userCode` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户编码',
  `userName` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户名称',
  `userPassword` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户密码',
  `gender` int(10) DEFAULT NULL COMMENT '性别（1:女、 2:男）',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `phone` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机',
  `address` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '地址',
  `userRole` bigint(20) DEFAULT NULL COMMENT '用户角色（取自角色表-角色id）',
  `createdBy` bigint(20) DEFAULT NULL COMMENT '创建者（userId）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(20) DEFAULT NULL COMMENT '更新者（userId）',
  `modifyDate` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of smbms_user
-- ----------------------------
INSERT INTO `smbms_user` VALUES ('2', 'liming', '李明', '12345678', '2', '1983-12-10', '13688884457', '北京市', '2', '1', '2018-03-01 19:52:09', null, null);
INSERT INTO `smbms_user` VALUES ('16', 'xiaoming', '小明', '12345678', '1', '1996-04-10', '18115530702', '山东省青岛市青岛区小白社区', '1', '6', '2018-03-02 22:42:18', null, null);
INSERT INTO `smbms_user` VALUES ('17', 'admin', '系统管理员', 'niujiatao123', '1', '1996-08-23', '18115530702', '江苏苏州吴江', '1', '16', '2018-04-07 22:53:14', '17', '2018-05-12 15:32:38');
INSERT INTO `smbms_user` VALUES ('19', 'YY2131231', '张三', '12345678', '1', '1996-05-09', '18115530702', '江苏吴江', '3', '17', '2018-05-09 16:55:31', null, null);
