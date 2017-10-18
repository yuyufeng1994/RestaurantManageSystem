/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50162
Source Host           : 127.0.0.1:3306
Source Database       : fbm

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2015-06-27 08:00:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dish
-- ----------------------------
DROP TABLE IF EXISTS `dish`;
CREATE TABLE `dish` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `type_id` int(5) DEFAULT NULL,
  `price` float(20,1) DEFAULT NULL,
  `picture` varchar(100) DEFAULT NULL,
  `sale` bigint(32) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dish_id` (`id`) USING BTREE,
  KEY `dish_name` (`name`) USING BTREE,
  KEY `dish_type` (`type_id`),
  CONSTRAINT `dish_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `dish_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dish
-- ----------------------------
INSERT INTO `dish` VALUES ('84', '82年拉菲', '7', '40000.0', '17ee09d6-c6c1-457d-a57c-b50480ca1fab.jpg', '0', '0', '82年拉菲');
INSERT INTO `dish` VALUES ('85', '鲜虾金针菇', '5', '56.0', 'cf08e511-5cd4-48b5-9554-16814fe2e987.jpg.jpg', '26', '184', '鲜虾金针菇——微波炉版');
INSERT INTO `dish` VALUES ('86', '蒜蓉西兰花', '6', '12.0', 'c192ae6c-721c-4266-af3b-a72bac09ff31.jpg.jpg', '3', '7', '蒜蓉西兰花 西兰花~~');
INSERT INTO `dish` VALUES ('90', '酸甜里脊', '6', '56.0', '12c3e824-9b87-451c-86d0-779a2d2a10a1.jpg.jpg', '10', '100', '酸甜里脊');
INSERT INTO `dish` VALUES ('91', '奥尔良烤翅', '1', '10.0', 'd4c90c9f-ea2f-4fdd-a34e-41adda3d7353.jpg.jpg', '1', '190', '奥尔良烤翅');
INSERT INTO `dish` VALUES ('92', '宫保豆腐', '6', '20.5', '305ae72b-7fa6-4155-980a-4041e0b1acad.gif.jpg', '5', '105', '宫保豆腐');
INSERT INTO `dish` VALUES ('93', '香煎小土豆', '8', '23.0', '1ddc2d87-f372-4766-b5c3-5f3f8dc54a99.jpg.jpg', '12', '98', '香煎小土豆');
INSERT INTO `dish` VALUES ('94', '古法酸梅汤', '7', '30.0', '51e33e99-8e48-450f-80a2-d4adf410a939.jpg.jpg', '10', '10', '古法酸梅汤');
INSERT INTO `dish` VALUES ('95', '开胃萝卜酸', '5', '10.0', '288fa516-58e8-4c0f-ab03-21a1a4be75ba.jpg.jpg', '10', '100', '开胃萝卜酸');
INSERT INTO `dish` VALUES ('96', '自制酸奶', '7', '10.0', 'bc0fa0b4-98e0-4820-8cfd-fb6f78a0f90f.jpg.jpg', '1', '109', '自制酸奶');
INSERT INTO `dish` VALUES ('97', '卡仕达樱桃蛋糕', '8', '50.0', 'b5f9ab53-dca2-4c4c-ad43-fb9b2f69270f.jpg.jpg', '2', '108', '海尔焙多芬智能烤箱---卡仕达樱桃蛋糕');
INSERT INTO `dish` VALUES ('98', '小棋格饼干', '8', '10.0', '6e849aee-ce6c-45fa-88bf-2d07ec3db603.jpg.jpg', '10', '108', '小棋格饼干');
INSERT INTO `dish` VALUES ('99', '清蒸肉末鲫鱼', '6', '60.0', 'dc064509-6cd5-49e5-b30d-6581c3c2bdf9.jpg.jpg', '1', '109', '清蒸肉末鲫鱼');
INSERT INTO `dish` VALUES ('100', '酸辣土豆丝', '6', '15.0', 'd7246ac8-e773-4b47-a031-27030502a6b6.jpg.jpg', '1', '109', '酸辣土豆丝，又酸又辣！');
INSERT INTO `dish` VALUES ('101', '芒果冻酸奶杯', '7', '10.0', 'f0a3d25b-bb52-4bc1-a578-6f453448a3b5.jpg.jpg', '10', '100', '芒果冻酸奶杯');
INSERT INTO `dish` VALUES ('102', '培根西兰花', '6', '10.0', 'c8b713fd-7d55-4997-97a0-c8da733a6ece.jpg.jpg', '2', '98', '培根西兰花');
INSERT INTO `dish` VALUES ('103', '黄金蛋炒饭', '1', '60.0', '5fbadaca-2f89-4cef-8923-cdf520187a5b.jpg.jpg', '10', '90', '黄金蛋炒饭，好吃的蛋炒饭！');
INSERT INTO `dish` VALUES ('104', '川味回锅肉', '6', '25.0', '94a4f8c1-1639-44e6-9e47-018fd0b2bba9.jpg.jpg', '2', '98', '川味回锅肉');
INSERT INTO `dish` VALUES ('105', '茄汁红烧牛肉面', '1', '20.0', 'f277fc96-946d-4f10-b0f6-fb1ffcc12dd1.jpg.jpg', '5', '95', '茄汁红烧牛肉面');
INSERT INTO `dish` VALUES ('106', '可乐鸡翅', '6', '30.0', 'e20e794e-8d44-4820-9a1b-cc065eb86cd0.jpg.jpg', '5', '95', '可乐鸡翅，可乐加鸡翅，好吃又美味');
INSERT INTO `dish` VALUES ('107', '香辣小龙虾', '5', '40.0', '345a4026-4b54-4cb6-b584-f5c596d254a3.jpg.jpg', '41', '59', '香辣小龙虾');
INSERT INTO `dish` VALUES ('108', '虾皮蛋汤饺子', '1', '20.0', 'b8440e94-ad79-4daf-aadd-78d0f32dba9c.jpg.jpg', '94', '69', '虾皮蛋汤饺子');
INSERT INTO `dish` VALUES ('109', '石榴鸡', '1', '25.0', 'cf193219-f213-4974-b7d1-b3109e012ff5.jpg.jpg', '17', '100', '石榴鸡');
INSERT INTO `dish` VALUES ('110', '新疆大盘鸡', '6', '50.0', 'eba4f218-fe07-4c79-a1cc-dd12678bcba0.jpg.jpg.jpg', '3', '97', '新疆大盘鸡');
INSERT INTO `dish` VALUES ('111', '回锅肉', '6', '67.5', '0646bb3e-8db9-4497-b51b-9098c3217f60.jpg.jpg', '4', '96', '源妈私房-回锅肉');
INSERT INTO `dish` VALUES ('112', '佛跳墙', '6', '100.5', 'fe0c86dc-939a-4763-a2ac-492d80906369.jpg.jpg', '8', '92', '佛跳墙又名满坛香，属闽菜系。佛跳墙是把几十种原料煨于一坛，有荤有素！');
INSERT INTO `dish` VALUES ('113', '七星鱼丸', '1', '25.0', 'b7295eb5-d8dc-4a0f-8fcb-1f1aee2ce126.jpg.jpg', '6', '94', '鱼丸是福建著名的汤菜之一。它是用鱼肉、瘦猪肉、虾干为主要原料制成的。');
INSERT INTO `dish` VALUES ('114', '花生汤', '8', '8.5', 'c99d9e22-e48a-476f-8042-446eef25c572.jpg.jpg', '4', '96', '香甜可口，美味至极！');
INSERT INTO `dish` VALUES ('115', '梅干菜扣肉', '6', '40.5', '6edb7199-a207-46df-a089-a3b46c9d27e5.jpg.jpg', '3', '970', '这道菜咸香爽口，肥而不腻。');
INSERT INTO `dish` VALUES ('116', '姜葱炒螃蟹', '6', '55.0', '23b9419f-a86c-463d-b88b-62486ab8dea3.jpg.jpg', '5', '905', '口感滑嫩，营养丰富。');
INSERT INTO `dish` VALUES ('117', '椒盐皮皮虾', '6', '58.0', '.jpg.jpg', '276', '596', '外酥里嫩，皮皮虾的鲜味充分保留。');
INSERT INTO `dish` VALUES ('119', '凉拌黄瓜', '2', '8.0', '.jpg.jpg.jpg', '9', '640', '清凉可口。');
INSERT INTO `dish` VALUES ('120', '香辣牛腱', '2', '28.0', '.jpg', '10', '540', '鲜嫩的牛肉！');
INSERT INTO `dish` VALUES ('122', '可乐', '7', '5.0', '636919b3-ad2b-48c2-896e-1c5a2d819a8b.jpg', '1', '95', '可口可乐');
INSERT INTO `dish` VALUES ('123', '雪碧', '7', '5.0', '04218984-707c-4ea0-9340-23ec689a9f7f.jpg', '2', '87', '透心凉心飞扬！');
INSERT INTO `dish` VALUES ('124', '加多宝', '7', '7.0', '9465075c-0570-4eee-ad41-e14238c5e6b1.jpg', '5', '9997', '清热降火。');
INSERT INTO `dish` VALUES ('125', '果粒橙', '7', '10.0', '2e03b00d-6851-4fba-858b-f6cecc4d1f0c.jpg', '9', '9993', '美汁源果粒橙。');
INSERT INTO `dish` VALUES ('126', '冰红茶', '7', '7.0', 'f4892bd0-dd19-4420-ba09-186709ce1325.jpg', '17', '9990', '冰力十足');
INSERT INTO `dish` VALUES ('127', '鲜榨青瓜汁', '7', '15.0', 'aeff9de4-1afa-4dbc-bba0-8d9218efbcfb.jpg', '7', '54', '鲜榨青瓜汁');
INSERT INTO `dish` VALUES ('128', '青岛啤酒', '7', '15.0', 'a1053185-1830-4669-ba67-e8ef16d7c1a4.jpg', '5', '996', '青岛啤酒');
INSERT INTO `dish` VALUES ('129', '张裕解百纳', '7', '180.0', '6bf9cd20-532e-49c6-abb7-7ddf7209e70f.jpg', '8', '96', '张裕解百纳');
INSERT INTO `dish` VALUES ('130', '马爹利蓝带', '7', '250.0', '682f0f74-77ca-4a3a-bc45-1f203d40b771.jpg', '16', '166', '马爹利蓝带');
INSERT INTO `dish` VALUES ('131', '双菇牛肉面', '1', '25.0', 'a0323f38-9db5-4d54-8c37-9f65dd0787fd.jpg', '28', '81', '双菇牛肉面');
INSERT INTO `dish` VALUES ('133', '冬瓜肉丸汤', '3', '10.5', '48399089-523e-4ec0-a0dc-b6bec5c76c5c.jpg', '103', '936', '冬瓜肉丸汤');
INSERT INTO `dish` VALUES ('134', '芒果冰激凌', '8', '35.0', 'a3c5c52c-de7d-4f09-b835-199d27a40946.jpg', '1', '99', '芒果冰激凌好好吃');
INSERT INTO `dish` VALUES ('135', '番茄鸡蛋碱面', '1', '23.0', 'f70c7546-1cb3-46a3-b9a3-d0a9806b4a3a.jpg', '2', '98', '番茄鸡蛋碱面 好吃的面');
INSERT INTO `dish` VALUES ('136', '香橙梨子汁', '7', '15.0', 'f813da36-a132-473a-b451-8958d8617674.jpg', '6', '94', '香橙梨子汁');
INSERT INTO `dish` VALUES ('137', '虾仁丝瓜盅', '6', '12.0', 'e0844d49-c249-43d7-891e-2007b902e359.jpg', '6', '94', '虾仁丝瓜盅');

-- ----------------------------
-- Table structure for dish_type
-- ----------------------------
DROP TABLE IF EXISTS `dish_type`;
CREATE TABLE `dish_type` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dish_type_id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dish_type
-- ----------------------------
INSERT INTO `dish_type` VALUES ('1', '主食');
INSERT INTO `dish_type` VALUES ('2', '凉菜');
INSERT INTO `dish_type` VALUES ('3', '汤羹');
INSERT INTO `dish_type` VALUES ('5', '开胃菜');
INSERT INTO `dish_type` VALUES ('6', '私房菜');
INSERT INTO `dish_type` VALUES ('7', '酒水');
INSERT INTO `dish_type` VALUES ('8', '甜点');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `toUser` bigint(32) DEFAULT NULL,
  `fromUser` bigint(32) DEFAULT NULL,
  `context` text,
  `date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `isRead` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `message_id` (`id`) USING BTREE,
  KEY `to` (`toUser`),
  KEY `from` (`fromUser`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '100', '100', '<img src=\"http://img.baidu.com/hi/jx2/j_0001.gif\" _src=\"http://img.baidu.com/hi/jx2/j_0001.gif\"/>', '2015-06-21 18:07:45', '');
INSERT INTO `message` VALUES ('2', '100', '10086', '<b>编号为 90  的 酸甜里脊 库存不足，请注意!</b>', '2015-06-24 16:21:50', '');
INSERT INTO `message` VALUES ('3', '10086', '10086', '<b>编号为 90  的 酸甜里脊 库存不足，请注意!</b>', '2015-06-24 16:21:50', '\0');
INSERT INTO `message` VALUES ('4', '20134206198', '10086', '<b>编号为 90  的 酸甜里脊 库存不足，请注意!</b>', '2015-06-24 16:21:50', '');
INSERT INTO `message` VALUES ('5', '20134206199', '10086', '<b>编号为 90  的 酸甜里脊 库存不足，请注意!</b>', '2015-06-24 16:21:50', '\0');
INSERT INTO `message` VALUES ('6', '20134206221', '10086', '<b>编号为 90  的 酸甜里脊 库存不足，请注意!</b>', '2015-06-24 16:21:50', '\0');
INSERT INTO `message` VALUES ('7', '20134206226', '10086', '<b>编号为 90  的 酸甜里脊 库存不足，请注意!</b>', '2015-06-24 16:21:50', '\0');
INSERT INTO `message` VALUES ('8', '20144206168', '10086', '<b>编号为 90  的 酸甜里脊 库存不足，请注意!</b>', '2015-06-24 16:21:50', '\0');
INSERT INTO `message` VALUES ('9', '20134206220', '100', '<p>你个sb</p>', '2015-06-24 16:22:12', '');
INSERT INTO `message` VALUES ('10', '100', '100', '11', '2015-06-24 16:24:43', '');
INSERT INTO `message` VALUES ('11', '100', '100', '<img src=\"http://img.baidu.com/hi/jx2/j_0001.gif\" _src=\"http://img.baidu.com/hi/jx2/j_0001.gif\"/>', '2015-06-24 16:25:16', '');
INSERT INTO `message` VALUES ('12', '100', '100', '1', '2015-06-24 16:25:22', '');
INSERT INTO `message` VALUES ('13', '10086', '100', '1', '2015-06-24 16:25:22', '\0');
INSERT INTO `message` VALUES ('14', '20134206198', '100', '1', '2015-06-24 16:25:22', '');
INSERT INTO `message` VALUES ('15', '20134206199', '100', '1', '2015-06-24 16:25:22', '\0');
INSERT INTO `message` VALUES ('16', '20134206201', '100', '1', '2015-06-24 16:25:22', '\0');
INSERT INTO `message` VALUES ('17', '20134206202', '100', '1', '2015-06-24 16:25:22', '\0');
INSERT INTO `message` VALUES ('18', '20134206220', '100', '1', '2015-06-24 16:25:22', '\0');
INSERT INTO `message` VALUES ('19', '20134206221', '100', '1', '2015-06-24 16:25:22', '\0');
INSERT INTO `message` VALUES ('20', '20134206226', '100', '1', '2015-06-24 16:25:22', '\0');
INSERT INTO `message` VALUES ('21', '20134206227', '100', '1', '2015-06-24 16:25:22', '\0');
INSERT INTO `message` VALUES ('22', '20144206168', '100', '1', '2015-06-24 16:25:22', '\0');
INSERT INTO `message` VALUES ('23', '20144206171', '20134206198', '<p>hello~冰芬妹</p>', '2015-06-25 15:10:00', '');
INSERT INTO `message` VALUES ('24', '20134206198', '20144206171', '<p>鱼鱼峰~</p>', '2015-06-25 15:10:04', '');
INSERT INTO `message` VALUES ('25', '20134206198', '20134206198', '大大的', '2015-06-26 07:59:43', '');
INSERT INTO `message` VALUES ('26', '10086', '20134206198', '<img src=\"http://img.baidu.com/hi/jx2/j_0015.gif\" _src=\"http://img.baidu.com/hi/jx2/j_0015.gif\"/>', '2015-06-26 08:04:12', '\0');

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('1', '锁定');
INSERT INTO `roles` VALUES ('2', '服务员');
INSERT INTO `roles` VALUES ('3', '厨师');
INSERT INTO `roles` VALUES ('4', '收银员');
INSERT INTO `roles` VALUES ('5', '经理');

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `userId` bigint(32) DEFAULT NULL,
  `salary` float(32,1) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  CONSTRAINT `salary_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of salary
-- ----------------------------
INSERT INTO `salary` VALUES ('1', '100', '222.2', '2015-06-15');
INSERT INTO `salary` VALUES ('2', '100', '252.2', '2015-06-15');

-- ----------------------------
-- Table structure for trade
-- ----------------------------
DROP TABLE IF EXISTS `trade`;
CREATE TABLE `trade` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `dish_num` int(11) DEFAULT NULL,
  `price` float(20,1) DEFAULT NULL,
  `userId` bigint(32) DEFAULT NULL,
  `customer_table` int(11) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `state` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Item_id` (`id`) USING BTREE,
  KEY `trade_ibfk_1` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=201500174 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trade
-- ----------------------------
INSERT INTO `trade` VALUES ('201500082', '3', '45.5', '100', '1104', '2015-05-01 14:14:44', '4');
INSERT INTO `trade` VALUES ('201500083', '5', '54.0', '100', '2105', '2015-06-12 16:37:42', '4');
INSERT INTO `trade` VALUES ('201500084', '2', '50.0', '100', '1101', '2015-06-10 20:33:04', '4');
INSERT INTO `trade` VALUES ('201500085', '7', '420.0', '100', '2106', '2015-06-14 21:41:50', '4');
INSERT INTO `trade` VALUES ('201500086', '3', '455.0', '100', '2105', '2015-06-13 12:28:12', '4');
INSERT INTO `trade` VALUES ('201500087', '11', '554.0', '293', '2107', '2015-06-15 13:14:22', '4');
INSERT INTO `trade` VALUES ('201500089', '6', '700.5', '100', '2105', '2015-06-02 21:11:05', '4');
INSERT INTO `trade` VALUES ('201500090', '2', '156.5', '100', '1101', '2015-06-11 21:28:53', '4');
INSERT INTO `trade` VALUES ('201500091', '1', '250.0', '101', '1101', '2015-06-14 13:19:28', '4');
INSERT INTO `trade` VALUES ('201500092', '4', '470.0', '285', '1102', '2015-06-11 13:19:57', '4');
INSERT INTO `trade` VALUES ('201500093', '7', '26.0', '285', '1104', '2015-06-17 16:56:44', '4');
INSERT INTO `trade` VALUES ('201500094', '2', '30.0', '285', '1103', '2015-06-10 13:21:18', '4');
INSERT INTO `trade` VALUES ('201500095', '13', '413.0', '289', '1101', '2015-06-13 13:22:02', '4');
INSERT INTO `trade` VALUES ('201500096', '9', '300.5', '285', '1104', '2015-06-11 13:22:34', '4');
INSERT INTO `trade` VALUES ('201500097', '4', '501.5', '288', '1101', '2015-06-16 16:57:59', '5');
INSERT INTO `trade` VALUES ('201500098', '6', '487.0', '288', '1101', '2015-06-12 13:24:11', '4');
INSERT INTO `trade` VALUES ('201500099', '10', '105.0', '100', '2106', '2015-06-10 21:02:58', '4');
INSERT INTO `trade` VALUES ('201500100', '9', '360.0', '100', '1101', '2015-06-10 21:03:52', '4');
INSERT INTO `trade` VALUES ('201500101', '15', '107.5', '100', '1101', '2015-06-17 16:57:06', '4');
INSERT INTO `trade` VALUES ('201500102', '1', '100.0', '100', '2107', '2015-06-17 16:57:31', '4');
INSERT INTO `trade` VALUES ('201500103', '103', '40.0', '100', '1101', '2015-06-17 16:56:49', '4');
INSERT INTO `trade` VALUES ('201500104', '3', '88.5', '100', '2108', '2015-06-17 16:56:02', '4');
INSERT INTO `trade` VALUES ('201500105', '4', '256.0', '100', '2106', '2015-06-17 16:58:26', '4');
INSERT INTO `trade` VALUES ('201500106', '7', '100.0', '100', '2106', '2015-06-17 19:18:23', '4');
INSERT INTO `trade` VALUES ('201500107', '37', '1592.0', '100', '1101', '2015-06-17 22:23:36', '4');
INSERT INTO `trade` VALUES ('201500108', '2', '430.0', '100', '2107', '2015-06-18 12:45:16', '4');
INSERT INTO `trade` VALUES ('201500109', '8', '295.0', '100', '2107', '2015-06-18 12:58:56', '4');
INSERT INTO `trade` VALUES ('201500110', '2', '21.0', '100', '2107', '2015-06-18 15:24:41', '4');
INSERT INTO `trade` VALUES ('201500111', '2', '21.0', '100', '2105', '2015-06-18 15:40:02', '4');
INSERT INTO `trade` VALUES ('201500112', '2', '260.5', '100', '1101', '2015-06-18 15:50:34', '4');
INSERT INTO `trade` VALUES ('201500113', '2', '260.5', '100', '1101', '2015-06-18 15:58:37', '4');
INSERT INTO `trade` VALUES ('201500114', '2', '430.0', '100', '1101', '2015-06-18 15:59:17', '4');
INSERT INTO `trade` VALUES ('201500115', '3', '31.5', '100', '1101', '2015-06-18 16:12:41', '4');
INSERT INTO `trade` VALUES ('201500116', '1', '10.5', '20134206198', '1101', '2015-06-18 16:16:43', '4');
INSERT INTO `trade` VALUES ('201500117', '1', '25.0', '20134206198', '1101', '2015-06-18 16:17:04', '4');
INSERT INTO `trade` VALUES ('201500118', '3', '440.5', '100', '1101', '2015-06-18 16:18:57', '4');
INSERT INTO `trade` VALUES ('201500119', '2', '35.5', '20134206198', '1101', '2015-06-18 16:20:57', '5');
INSERT INTO `trade` VALUES ('201500120', '10', '105.0', '100', '1101', '2015-06-18 16:24:10', '4');
INSERT INTO `trade` VALUES ('201500121', '1', '250.0', '100', '1101', '2015-06-18 16:29:16', '4');
INSERT INTO `trade` VALUES ('201500122', '2', '21.0', '100', '1101', '2015-06-18 16:39:48', '4');
INSERT INTO `trade` VALUES ('201500123', '2', '21.0', '100', '1101', '2015-06-18 19:26:19', '4');
INSERT INTO `trade` VALUES ('201500124', '1', '10.5', '100', '2107', '2015-06-18 20:16:28', '4');
INSERT INTO `trade` VALUES ('201500125', '1', '10.5', '100', '2107', '2015-06-18 20:19:22', '4');
INSERT INTO `trade` VALUES ('201500126', '6', '423.0', '100', '1101', '2015-06-18 20:39:14', '4');
INSERT INTO `trade` VALUES ('201500127', '2', '35.5', '20134206198', '2106', '2015-06-18 21:38:59', '4');
INSERT INTO `trade` VALUES ('201500128', '6', '56.0', '20134206198', '1101', '2015-06-18 22:11:27', '4');
INSERT INTO `trade` VALUES ('201500129', '8', '184.0', '100', '1101', '2015-06-18 23:09:08', '4');
INSERT INTO `trade` VALUES ('201500130', '9', '270.0', '100', '1101', '2015-06-18 23:10:03', '4');
INSERT INTO `trade` VALUES ('201500131', '9', '90.0', '100', '1101', '2015-06-18 23:11:09', '5');
INSERT INTO `trade` VALUES ('201500132', '3', '31.5', '100', '1101', '2015-06-18 23:12:56', '4');
INSERT INTO `trade` VALUES ('201500133', '5', '96.0', '100', '1101', '2015-06-18 23:13:39', '4');
INSERT INTO `trade` VALUES ('201500134', '2', '35.5', '100', '1101', '2015-06-18 23:14:04', '4');
INSERT INTO `trade` VALUES ('201500135', '7', '276.0', '100', '2106', '2015-06-19 11:28:19', '5');
INSERT INTO `trade` VALUES ('201500136', '2', '260.5', '100', '2106', '2015-06-19 11:56:46', '4');
INSERT INTO `trade` VALUES ('201500137', '7', '79.5', '100', '2105', '2015-06-19 16:53:25', '4');
INSERT INTO `trade` VALUES ('201500138', '3', '121.0', '100', '2105', '2015-06-19 16:53:33', '4');
INSERT INTO `trade` VALUES ('201500139', '4', '78.0', '100', '2105', '2015-06-19 16:55:57', '4');
INSERT INTO `trade` VALUES ('201500140', '8', '80.0', '100', '2105', '2015-06-19 16:58:46', '4');
INSERT INTO `trade` VALUES ('201500141', '5', '480.5', '20134206198', '1101', '2015-06-20 15:13:15', '4');
INSERT INTO `trade` VALUES ('201500142', '2', '35.5', '20134206198', '1101', '2015-06-22 09:42:21', '4');
INSERT INTO `trade` VALUES ('201500143', '2', '275.0', '20134206198', '1101', '2015-06-22 09:45:29', '4');
INSERT INTO `trade` VALUES ('201500144', '1', '10.5', '20134206198', '1101', '2015-06-22 09:54:58', '4');
INSERT INTO `trade` VALUES ('201500145', '1', '10.5', '20134206198', '1101', '2015-06-22 09:55:19', '4');
INSERT INTO `trade` VALUES ('201500146', '2', '17.0', '100', '1101', '2015-06-22 09:55:56', '4');
INSERT INTO `trade` VALUES ('201500147', '2', '60.0', '100', '1101', '2015-06-22 20:47:25', '4');
INSERT INTO `trade` VALUES ('201500148', '3', '88.5', '20134206198', '2105', '2015-06-23 11:23:07', '4');
INSERT INTO `trade` VALUES ('201500149', '1', '58.0', '20134206198', '2105', '2015-06-23 11:23:33', '4');
INSERT INTO `trade` VALUES ('201500150', '2', '116.0', '20134206198', '2105', '2015-06-23 11:26:43', '4');
INSERT INTO `trade` VALUES ('201500151', '1', '20.0', '20134206198', '2105', '2015-06-23 11:26:50', '4');
INSERT INTO `trade` VALUES ('201500152', '3', '88.5', '20134206198', '2105', '2015-06-23 11:28:32', '4');
INSERT INTO `trade` VALUES ('201500153', '12', '210.0', '20134206198', '2105', '2015-06-23 11:30:27', '4');
INSERT INTO `trade` VALUES ('201500154', '8', '84.0', '20134206198', '2105', '2015-06-23 11:34:25', '4');
INSERT INTO `trade` VALUES ('201500155', '23', '1298.0', '20134206198', '2105', '2015-06-23 11:36:32', '4');
INSERT INTO `trade` VALUES ('201500156', '1', '25.0', '100', '1101', '2015-06-23 17:04:37', '4');
INSERT INTO `trade` VALUES ('201500157', '2', '275.0', '100', '1101', '2015-06-23 17:05:13', '4');
INSERT INTO `trade` VALUES ('201500158', '2', '360.0', '100', '1101', '2015-05-01 17:05:22', '4');
INSERT INTO `trade` VALUES ('201500159', '4', '465.5', '100', '1101', '2015-04-01 17:08:15', '4');
INSERT INTO `trade` VALUES ('201500160', '2', '35.5', '100', '1101', '2015-04-01 17:08:28', '4');
INSERT INTO `trade` VALUES ('201500161', '5', '114.5', '20134206198', '1101', '2015-06-24 11:07:29', '4');
INSERT INTO `trade` VALUES ('201500162', '4', '42.0', '20134206198', '1104', '2015-06-24 11:15:34', '4');
INSERT INTO `trade` VALUES ('201500163', '2', '35.5', '100', '1101', '2015-06-24 15:18:30', '4');
INSERT INTO `trade` VALUES ('201500164', '5', '224.0', '100', '2107', '2015-06-24 16:21:50', '4');
INSERT INTO `trade` VALUES ('201500165', '5', '52.5', '100', '1101', '2015-06-24 16:24:33', '4');
INSERT INTO `trade` VALUES ('201500166', '4', '71.0', '20134206198', '1101', '2015-06-25 08:29:37', '4');
INSERT INTO `trade` VALUES ('201500167', '2', '35.5', '20134206198', '1101', '2015-06-25 15:04:53', '4');
INSERT INTO `trade` VALUES ('201500168', '8', '313.0', '20134206198', '1103', '2015-06-25 15:11:34', '4');
INSERT INTO `trade` VALUES ('201500169', '10', '863.5', '20134206198', '1103', '2015-06-26 07:58:42', '4');
INSERT INTO `trade` VALUES ('201500170', '1', '10.5', '20134206198', '1101', '2015-06-26 09:57:32', '1');
INSERT INTO `trade` VALUES ('201500171', '8', '119.0', '20134206198', '1101', '2015-06-26 18:48:09', '4');
INSERT INTO `trade` VALUES ('201500172', '11', '179.5', '20134206198', '2105', '2015-06-26 19:18:34', '4');
INSERT INTO `trade` VALUES ('201500173', '5', '126.0', '20134206198', '1104', '2015-06-26 20:11:34', '1');

-- ----------------------------
-- Table structure for trade_item
-- ----------------------------
DROP TABLE IF EXISTS `trade_item`;
CREATE TABLE `trade_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tradeId` bigint(20) DEFAULT NULL,
  `quantity` int(5) DEFAULT NULL,
  `dishId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tradeItemid` (`id`) USING BTREE,
  KEY `dishId` (`dishId`),
  KEY `trade_item_ibfk_1` (`tradeId`),
  CONSTRAINT `trade_item_ibfk_1` FOREIGN KEY (`tradeId`) REFERENCES `trade` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=628 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trade_item
-- ----------------------------
INSERT INTO `trade_item` VALUES ('389', '201500082', '1', '134');
INSERT INTO `trade_item` VALUES ('390', '201500082', '1', '132');
INSERT INTO `trade_item` VALUES ('391', '201500082', '1', '131');
INSERT INTO `trade_item` VALUES ('392', '201500083', '1', '128');
INSERT INTO `trade_item` VALUES ('393', '201500083', '1', '127');
INSERT INTO `trade_item` VALUES ('394', '201500083', '1', '126');
INSERT INTO `trade_item` VALUES ('395', '201500083', '1', '125');
INSERT INTO `trade_item` VALUES ('396', '201500083', '1', '124');
INSERT INTO `trade_item` VALUES ('397', '201500084', '2', '103');
INSERT INTO `trade_item` VALUES ('398', '201500085', '1', '131');
INSERT INTO `trade_item` VALUES ('399', '201500085', '1', '130');
INSERT INTO `trade_item` VALUES ('400', '201500085', '3', '105');
INSERT INTO `trade_item` VALUES ('401', '201500085', '1', '104');
INSERT INTO `trade_item` VALUES ('402', '201500085', '1', '103');
INSERT INTO `trade_item` VALUES ('403', '201500086', '1', '130');
INSERT INTO `trade_item` VALUES ('404', '201500086', '1', '129');
INSERT INTO `trade_item` VALUES ('405', '201500086', '1', '131');
INSERT INTO `trade_item` VALUES ('406', '201500087', '1', '130');
INSERT INTO `trade_item` VALUES ('407', '201500087', '1', '129');
INSERT INTO `trade_item` VALUES ('408', '201500087', '1', '101');
INSERT INTO `trade_item` VALUES ('409', '201500087', '1', '113');
INSERT INTO `trade_item` VALUES ('410', '201500087', '1', '114');
INSERT INTO `trade_item` VALUES ('411', '201500087', '1', '115');
INSERT INTO `trade_item` VALUES ('412', '201500087', '1', '105');
INSERT INTO `trade_item` VALUES ('413', '201500087', '4', '123');
INSERT INTO `trade_item` VALUES ('417', '201500089', '1', '130');
INSERT INTO `trade_item` VALUES ('418', '201500089', '1', '129');
INSERT INTO `trade_item` VALUES ('419', '201500089', '1', '117');
INSERT INTO `trade_item` VALUES ('420', '201500089', '2', '85');
INSERT INTO `trade_item` VALUES ('421', '201500089', '1', '112');
INSERT INTO `trade_item` VALUES ('422', '201500090', '1', '112');
INSERT INTO `trade_item` VALUES ('423', '201500090', '1', '90');
INSERT INTO `trade_item` VALUES ('424', '201500091', '1', '130');
INSERT INTO `trade_item` VALUES ('425', '201500092', '1', '131');
INSERT INTO `trade_item` VALUES ('426', '201500092', '1', '130');
INSERT INTO `trade_item` VALUES ('427', '201500092', '1', '129');
INSERT INTO `trade_item` VALUES ('428', '201500092', '1', '128');
INSERT INTO `trade_item` VALUES ('429', '201500093', '1', '131');
INSERT INTO `trade_item` VALUES ('430', '201500093', '1', '130');
INSERT INTO `trade_item` VALUES ('431', '201500093', '1', '125');
INSERT INTO `trade_item` VALUES ('432', '201500093', '1', '119');
INSERT INTO `trade_item` VALUES ('433', '201500093', '1', '117');
INSERT INTO `trade_item` VALUES ('434', '201500093', '1', '113');
INSERT INTO `trade_item` VALUES ('435', '201500093', '1', '110');
INSERT INTO `trade_item` VALUES ('436', '201500094', '1', '131');
INSERT INTO `trade_item` VALUES ('437', '201500094', '1', '122');
INSERT INTO `trade_item` VALUES ('438', '201500095', '1', '131');
INSERT INTO `trade_item` VALUES ('439', '201500095', '1', '126');
INSERT INTO `trade_item` VALUES ('440', '201500095', '1', '117');
INSERT INTO `trade_item` VALUES ('441', '201500095', '1', '116');
INSERT INTO `trade_item` VALUES ('442', '201500095', '1', '115');
INSERT INTO `trade_item` VALUES ('443', '201500095', '1', '112');
INSERT INTO `trade_item` VALUES ('444', '201500095', '1', '110');
INSERT INTO `trade_item` VALUES ('445', '201500095', '1', '102');
INSERT INTO `trade_item` VALUES ('446', '201500095', '4', '128');
INSERT INTO `trade_item` VALUES ('447', '201500095', '1', '124');
INSERT INTO `trade_item` VALUES ('448', '201500096', '1', '119');
INSERT INTO `trade_item` VALUES ('449', '201500096', '1', '116');
INSERT INTO `trade_item` VALUES ('450', '201500096', '1', '125');
INSERT INTO `trade_item` VALUES ('451', '201500096', '2', '124');
INSERT INTO `trade_item` VALUES ('452', '201500096', '1', '111');
INSERT INTO `trade_item` VALUES ('453', '201500096', '1', '106');
INSERT INTO `trade_item` VALUES ('454', '201500096', '1', '103');
INSERT INTO `trade_item` VALUES ('455', '201500096', '1', '90');
INSERT INTO `trade_item` VALUES ('456', '201500097', '1', '114');
INSERT INTO `trade_item` VALUES ('457', '201500097', '1', '113');
INSERT INTO `trade_item` VALUES ('458', '201500097', '1', '112');
INSERT INTO `trade_item` VALUES ('459', '201500097', '1', '111');
INSERT INTO `trade_item` VALUES ('460', '201500098', '1', '130');
INSERT INTO `trade_item` VALUES ('461', '201500098', '1', '123');
INSERT INTO `trade_item` VALUES ('462', '201500098', '4', '117');
INSERT INTO `trade_item` VALUES ('463', '201500099', '10', '133');
INSERT INTO `trade_item` VALUES ('464', '201500100', '9', '107');
INSERT INTO `trade_item` VALUES ('465', '201500101', '15', '133');
INSERT INTO `trade_item` VALUES ('466', '201500102', '1', '125');
INSERT INTO `trade_item` VALUES ('467', '201500103', '16', '109');
INSERT INTO `trade_item` VALUES ('468', '201500103', '87', '108');
INSERT INTO `trade_item` VALUES ('469', '201500104', '1', '108');
INSERT INTO `trade_item` VALUES ('470', '201500104', '1', '133');
INSERT INTO `trade_item` VALUES ('471', '201500104', '1', '117');
INSERT INTO `trade_item` VALUES ('472', '201500105', '1', '120');
INSERT INTO `trade_item` VALUES ('473', '201500105', '1', '103');
INSERT INTO `trade_item` VALUES ('474', '201500105', '1', '112');
INSERT INTO `trade_item` VALUES ('475', '201500105', '1', '111');
INSERT INTO `trade_item` VALUES ('476', '201500106', '1', '127');
INSERT INTO `trade_item` VALUES ('477', '201500106', '1', '126');
INSERT INTO `trade_item` VALUES ('478', '201500106', '1', '131');
INSERT INTO `trade_item` VALUES ('479', '201500106', '2', '133');
INSERT INTO `trade_item` VALUES ('480', '201500106', '1', '124');
INSERT INTO `trade_item` VALUES ('481', '201500106', '1', '113');
INSERT INTO `trade_item` VALUES ('482', '201500107', '7', '85');
INSERT INTO `trade_item` VALUES ('483', '201500107', '30', '107');
INSERT INTO `trade_item` VALUES ('484', '201500108', '1', '130');
INSERT INTO `trade_item` VALUES ('485', '201500108', '1', '129');
INSERT INTO `trade_item` VALUES ('486', '201500109', '1', '120');
INSERT INTO `trade_item` VALUES ('487', '201500109', '1', '103');
INSERT INTO `trade_item` VALUES ('488', '201500109', '1', '98');
INSERT INTO `trade_item` VALUES ('489', '201500109', '1', '112');
INSERT INTO `trade_item` VALUES ('490', '201500109', '2', '93');
INSERT INTO `trade_item` VALUES ('491', '201500109', '1', '94');
INSERT INTO `trade_item` VALUES ('492', '201500109', '1', '92');
INSERT INTO `trade_item` VALUES ('493', '201500110', '2', '133');
INSERT INTO `trade_item` VALUES ('494', '201500111', '2', '133');
INSERT INTO `trade_item` VALUES ('495', '201500112', '1', '133');
INSERT INTO `trade_item` VALUES ('496', '201500112', '1', '130');
INSERT INTO `trade_item` VALUES ('497', '201500113', '1', '133');
INSERT INTO `trade_item` VALUES ('498', '201500113', '1', '130');
INSERT INTO `trade_item` VALUES ('499', '201500114', '1', '130');
INSERT INTO `trade_item` VALUES ('500', '201500114', '1', '129');
INSERT INTO `trade_item` VALUES ('501', '201500115', '3', '133');
INSERT INTO `trade_item` VALUES ('502', '201500116', '1', '133');
INSERT INTO `trade_item` VALUES ('503', '201500117', '1', '131');
INSERT INTO `trade_item` VALUES ('504', '201500118', '1', '133');
INSERT INTO `trade_item` VALUES ('505', '201500118', '1', '130');
INSERT INTO `trade_item` VALUES ('506', '201500118', '1', '129');
INSERT INTO `trade_item` VALUES ('507', '201500119', '1', '133');
INSERT INTO `trade_item` VALUES ('508', '201500119', '1', '131');
INSERT INTO `trade_item` VALUES ('509', '201500120', '10', '133');
INSERT INTO `trade_item` VALUES ('510', '201500121', '1', '130');
INSERT INTO `trade_item` VALUES ('511', '201500122', '2', '133');
INSERT INTO `trade_item` VALUES ('512', '201500123', '2', '133');
INSERT INTO `trade_item` VALUES ('513', '201500124', '1', '133');
INSERT INTO `trade_item` VALUES ('514', '201500125', '1', '133');
INSERT INTO `trade_item` VALUES ('515', '201500126', '2', '117');
INSERT INTO `trade_item` VALUES ('516', '201500126', '1', '108');
INSERT INTO `trade_item` VALUES ('517', '201500126', '1', '106');
INSERT INTO `trade_item` VALUES ('518', '201500126', '1', '124');
INSERT INTO `trade_item` VALUES ('519', '201500126', '1', '130');
INSERT INTO `trade_item` VALUES ('520', '201500127', '1', '131');
INSERT INTO `trade_item` VALUES ('521', '201500127', '1', '133');
INSERT INTO `trade_item` VALUES ('522', '201500128', '2', '126');
INSERT INTO `trade_item` VALUES ('523', '201500128', '2', '125');
INSERT INTO `trade_item` VALUES ('524', '201500128', '1', '124');
INSERT INTO `trade_item` VALUES ('525', '201500128', '1', '127');
INSERT INTO `trade_item` VALUES ('526', '201500129', '8', '93');
INSERT INTO `trade_item` VALUES ('527', '201500130', '9', '94');
INSERT INTO `trade_item` VALUES ('528', '201500131', '9', '95');
INSERT INTO `trade_item` VALUES ('529', '201500132', '3', '133');
INSERT INTO `trade_item` VALUES ('530', '201500133', '2', '133');
INSERT INTO `trade_item` VALUES ('531', '201500133', '3', '131');
INSERT INTO `trade_item` VALUES ('532', '201500134', '1', '133');
INSERT INTO `trade_item` VALUES ('533', '201500134', '1', '131');
INSERT INTO `trade_item` VALUES ('534', '201500135', '4', '117');
INSERT INTO `trade_item` VALUES ('535', '201500135', '2', '119');
INSERT INTO `trade_item` VALUES ('536', '201500135', '1', '120');
INSERT INTO `trade_item` VALUES ('537', '201500136', '1', '133');
INSERT INTO `trade_item` VALUES ('538', '201500136', '1', '130');
INSERT INTO `trade_item` VALUES ('539', '201500137', '1', '133');
INSERT INTO `trade_item` VALUES ('540', '201500137', '1', '131');
INSERT INTO `trade_item` VALUES ('541', '201500137', '3', '125');
INSERT INTO `trade_item` VALUES ('542', '201500137', '2', '126');
INSERT INTO `trade_item` VALUES ('543', '201500138', '1', '116');
INSERT INTO `trade_item` VALUES ('544', '201500138', '1', '117');
INSERT INTO `trade_item` VALUES ('545', '201500138', '1', '119');
INSERT INTO `trade_item` VALUES ('546', '201500139', '1', '125');
INSERT INTO `trade_item` VALUES ('547', '201500139', '1', '124');
INSERT INTO `trade_item` VALUES ('548', '201500139', '1', '123');
INSERT INTO `trade_item` VALUES ('549', '201500139', '1', '90');
INSERT INTO `trade_item` VALUES ('550', '201500140', '8', '101');
INSERT INTO `trade_item` VALUES ('551', '201500141', '1', '133');
INSERT INTO `trade_item` VALUES ('552', '201500141', '1', '131');
INSERT INTO `trade_item` VALUES ('553', '201500141', '1', '130');
INSERT INTO `trade_item` VALUES ('554', '201500141', '1', '129');
INSERT INTO `trade_item` VALUES ('555', '201500141', '1', '128');
INSERT INTO `trade_item` VALUES ('556', '201500142', '1', '133');
INSERT INTO `trade_item` VALUES ('557', '201500142', '1', '131');
INSERT INTO `trade_item` VALUES ('558', '201500143', '1', '131');
INSERT INTO `trade_item` VALUES ('559', '201500143', '1', '130');
INSERT INTO `trade_item` VALUES ('560', '201500144', '1', '133');
INSERT INTO `trade_item` VALUES ('561', '201500145', '1', '133');
INSERT INTO `trade_item` VALUES ('562', '201500146', '1', '125');
INSERT INTO `trade_item` VALUES ('563', '201500146', '1', '126');
INSERT INTO `trade_item` VALUES ('564', '201500147', '1', '140');
INSERT INTO `trade_item` VALUES ('565', '201500147', '1', '139');
INSERT INTO `trade_item` VALUES ('566', '201500148', '1', '117');
INSERT INTO `trade_item` VALUES ('567', '201500148', '1', '108');
INSERT INTO `trade_item` VALUES ('568', '201500148', '1', '133');
INSERT INTO `trade_item` VALUES ('569', '201500149', '1', '117');
INSERT INTO `trade_item` VALUES ('570', '201500150', '2', '117');
INSERT INTO `trade_item` VALUES ('571', '201500151', '1', '108');
INSERT INTO `trade_item` VALUES ('572', '201500152', '1', '117');
INSERT INTO `trade_item` VALUES ('573', '201500152', '1', '108');
INSERT INTO `trade_item` VALUES ('574', '201500152', '1', '133');
INSERT INTO `trade_item` VALUES ('575', '201500153', '5', '126');
INSERT INTO `trade_item` VALUES ('576', '201500153', '7', '131');
INSERT INTO `trade_item` VALUES ('577', '201500154', '8', '133');
INSERT INTO `trade_item` VALUES ('578', '201500155', '1', '103');
INSERT INTO `trade_item` VALUES ('579', '201500155', '3', '117');
INSERT INTO `trade_item` VALUES ('580', '201500155', '15', '85');
INSERT INTO `trade_item` VALUES ('581', '201500155', '4', '90');
INSERT INTO `trade_item` VALUES ('582', '201500156', '1', '131');
INSERT INTO `trade_item` VALUES ('583', '201500157', '1', '130');
INSERT INTO `trade_item` VALUES ('584', '201500157', '1', '131');
INSERT INTO `trade_item` VALUES ('585', '201500158', '2', '129');
INSERT INTO `trade_item` VALUES ('586', '201500159', '1', '133');
INSERT INTO `trade_item` VALUES ('587', '201500159', '1', '131');
INSERT INTO `trade_item` VALUES ('588', '201500159', '1', '130');
INSERT INTO `trade_item` VALUES ('589', '201500159', '1', '129');
INSERT INTO `trade_item` VALUES ('590', '201500160', '1', '133');
INSERT INTO `trade_item` VALUES ('591', '201500160', '1', '131');
INSERT INTO `trade_item` VALUES ('592', '201500161', '1', '114');
INSERT INTO `trade_item` VALUES ('593', '201500161', '1', '113');
INSERT INTO `trade_item` VALUES ('594', '201500161', '1', '103');
INSERT INTO `trade_item` VALUES ('595', '201500161', '2', '133');
INSERT INTO `trade_item` VALUES ('596', '201500162', '4', '133');
INSERT INTO `trade_item` VALUES ('597', '201500163', '1', '133');
INSERT INTO `trade_item` VALUES ('598', '201500163', '1', '131');
INSERT INTO `trade_item` VALUES ('599', '201500164', '1', '117');
INSERT INTO `trade_item` VALUES ('600', '201500164', '2', '106');
INSERT INTO `trade_item` VALUES ('601', '201500164', '1', '97');
INSERT INTO `trade_item` VALUES ('602', '201500164', '1', '90');
INSERT INTO `trade_item` VALUES ('603', '201500165', '5', '133');
INSERT INTO `trade_item` VALUES ('604', '201500166', '2', '133');
INSERT INTO `trade_item` VALUES ('605', '201500166', '2', '131');
INSERT INTO `trade_item` VALUES ('606', '201500167', '1', '133');
INSERT INTO `trade_item` VALUES ('607', '201500167', '1', '131');
INSERT INTO `trade_item` VALUES ('608', '201500168', '4', '117');
INSERT INTO `trade_item` VALUES ('609', '201500168', '2', '133');
INSERT INTO `trade_item` VALUES ('610', '201500168', '1', '108');
INSERT INTO `trade_item` VALUES ('611', '201500168', '1', '107');
INSERT INTO `trade_item` VALUES ('612', '201500169', '4', '92');
INSERT INTO `trade_item` VALUES ('613', '201500169', '3', '130');
INSERT INTO `trade_item` VALUES ('614', '201500169', '3', '133');
INSERT INTO `trade_item` VALUES ('615', '201500170', '1', '133');
INSERT INTO `trade_item` VALUES ('616', '201500171', '3', '137');
INSERT INTO `trade_item` VALUES ('617', '201500171', '4', '136');
INSERT INTO `trade_item` VALUES ('618', '201500171', '1', '135');
INSERT INTO `trade_item` VALUES ('619', '201500172', '3', '137');
INSERT INTO `trade_item` VALUES ('620', '201500172', '2', '136');
INSERT INTO `trade_item` VALUES ('621', '201500172', '1', '135');
INSERT INTO `trade_item` VALUES ('622', '201500172', '1', '134');
INSERT INTO `trade_item` VALUES ('623', '201500172', '1', '133');
INSERT INTO `trade_item` VALUES ('624', '201500172', '3', '128');
INSERT INTO `trade_item` VALUES ('625', '201500173', '1', '85');
INSERT INTO `trade_item` VALUES ('626', '201500173', '2', '86');
INSERT INTO `trade_item` VALUES ('627', '201500173', '2', '93');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `type` int(5) DEFAULT NULL,
  `tell` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`id`) USING BTREE,
  KEY `user_name` (`name`) USING BTREE,
  KEY `type` (`type`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`type`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20144206172 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('100', 'Mr.Yu', '202cb962ac59075b964b07152d234b70', '5', '13574472507');
INSERT INTO `user` VALUES ('10086', '系统', '827ccb0eea8a706c4c34a16891f84e7b', '5', '10086');
INSERT INTO `user` VALUES ('20134206198', '俞育峰', '827ccb0eea8a706c4c34a16891f84e7b', '5', '13574472507');
INSERT INTO `user` VALUES ('20134206199', '陈惠敏', '827ccb0eea8a706c4c34a16891f84e7b', '5', '13574472508');
INSERT INTO `user` VALUES ('20134206201', '沈正环', '827ccb0eea8a706c4c34a16891f84e7b', '2', '13574472509');
INSERT INTO `user` VALUES ('20134206202', '傻屌', '827ccb0eea8a706c4c34a16891f84e7b', '2', '12345454543');
INSERT INTO `user` VALUES ('20134206220', '张诚', '02e3e7ef043fa63aeed97729106ba226', '2', '13574472507');
INSERT INTO `user` VALUES ('20134206221', '叶思航', '827ccb0eea8a706c4c34a16891f84e7b', '5', '12345678917');
INSERT INTO `user` VALUES ('20134206226', '张汉清', '827ccb0eea8a706c4c34a16891f84e7b', '5', '12345678910');
INSERT INTO `user` VALUES ('20144206168', '陈长文', '827ccb0eea8a706c4c34a16891f84e7b', '5', '13574472500');
INSERT INTO `user` VALUES ('20144206169', '张三', '827ccb0eea8a706c4c34a16891f84e7b', '2', '13185398645');
INSERT INTO `user` VALUES ('20144206170', '李四', '827ccb0eea8a706c4c34a16891f84e7b', '3', '13956484569');
INSERT INTO `user` VALUES ('20144206171', '吴冰芬', '827ccb0eea8a706c4c34a16891f84e7b', '5', '13574472508');
