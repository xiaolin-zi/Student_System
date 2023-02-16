/*
Navicat MySQL Data Transfer

Source Server         : xiaolin
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : student_system

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2022-06-10 23:13:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_class`
-- ----------------------------
DROP TABLE IF EXISTS `tb_class`;
CREATE TABLE `tb_class` (
  `classId` int(11) NOT NULL AUTO_INCREMENT,
  `departName` varchar(100) DEFAULT NULL,
  `specName` varchar(100) DEFAULT NULL,
  `className` int(11) NOT NULL,
  PRIMARY KEY (`classId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_class
-- ----------------------------
INSERT INTO `tb_class` VALUES ('1', '计算机学院', '软件工程', '1');
INSERT INTO `tb_class` VALUES ('3', '计算机学院', '计算机科学与技术', '2');
INSERT INTO `tb_class` VALUES ('5', '艺术设计学院', '服装设计', '1');
INSERT INTO `tb_class` VALUES ('6', '自动化学院', '物联网工程', '2');
INSERT INTO `tb_class` VALUES ('7', '自动化学院', '物联网工程', '1');
INSERT INTO `tb_class` VALUES ('8', '计算机学院', '计算机科学与技术', '1');
INSERT INTO `tb_class` VALUES ('9', '政法学院', '法学', '1');
INSERT INTO `tb_class` VALUES ('10', '政法学院', '法学', '2');
INSERT INTO `tb_class` VALUES ('11', '计算机学院', '软件工程', '2');

-- ----------------------------
-- Table structure for `tb_cource`
-- ----------------------------
DROP TABLE IF EXISTS `tb_cource`;
CREATE TABLE `tb_cource` (
  `courceId` int(11) NOT NULL AUTO_INCREMENT,
  `courceName` varchar(100) NOT NULL,
  `courceHour` float DEFAULT NULL,
  `courceSpecName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`courceId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_cource
-- ----------------------------
INSERT INTO `tb_cource` VALUES ('1', '大学英语', '2.5', '法学');
INSERT INTO `tb_cource` VALUES ('2', '大学物理', '1.5', '物联网工程');
INSERT INTO `tb_cource` VALUES ('3', '高等数学', '5.5', '计算机科学与技术');
INSERT INTO `tb_cource` VALUES ('4', 'C语言程序设计', '3', '软件工程');
INSERT INTO `tb_cource` VALUES ('5', '数据结构', '3', '软件工程');
INSERT INTO `tb_cource` VALUES ('6', '线性代数', '1.5', '物理学');
INSERT INTO `tb_cource` VALUES ('7', '大学语文', '1.5', '服装设计');
INSERT INTO `tb_cource` VALUES ('8', '服装市场考察', '2.5', '服装设计');

-- ----------------------------
-- Table structure for `tb_depart`
-- ----------------------------
DROP TABLE IF EXISTS `tb_depart`;
CREATE TABLE `tb_depart` (
  `departId` int(11) NOT NULL AUTO_INCREMENT,
  `departName` varchar(100) NOT NULL,
  PRIMARY KEY (`departId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_depart
-- ----------------------------
INSERT INTO `tb_depart` VALUES ('1', '计算机学院');
INSERT INTO `tb_depart` VALUES ('3', '艺术设计学院');
INSERT INTO `tb_depart` VALUES ('4', '自动化学院');
INSERT INTO `tb_depart` VALUES ('5', '政法学院');
INSERT INTO `tb_depart` VALUES ('7', '物理学院');

-- ----------------------------
-- Table structure for `tb_score`
-- ----------------------------
DROP TABLE IF EXISTS `tb_score`;
CREATE TABLE `tb_score` (
  `scoreId` int(11) NOT NULL AUTO_INCREMENT,
  `stuNumber` int(11) NOT NULL,
  `courceName` varchar(100) NOT NULL,
  `score` float DEFAULT NULL,
  PRIMARY KEY (`scoreId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_score
-- ----------------------------
INSERT INTO `tb_score` VALUES ('1', '3001', 'C语言程序设计', '95');
INSERT INTO `tb_score` VALUES ('3', '3002', '高等数学', '59');
INSERT INTO `tb_score` VALUES ('5', '3004', '高等数学', '96');
INSERT INTO `tb_score` VALUES ('7', '3001', '数据结构', '97');
INSERT INTO `tb_score` VALUES ('8', '3006', '大学物理', '100');

-- ----------------------------
-- Table structure for `tb_spec`
-- ----------------------------
DROP TABLE IF EXISTS `tb_spec`;
CREATE TABLE `tb_spec` (
  `specId` int(11) NOT NULL AUTO_INCREMENT,
  `departName` varchar(100) DEFAULT NULL,
  `specName` varchar(100) NOT NULL,
  PRIMARY KEY (`specId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_spec
-- ----------------------------
INSERT INTO `tb_spec` VALUES ('1', '计算机学院', '计算机科学与技术');
INSERT INTO `tb_spec` VALUES ('3', '艺术设计学院', '服装设计');
INSERT INTO `tb_spec` VALUES ('5', '计算机学院', '软件工程');
INSERT INTO `tb_spec` VALUES ('6', '政法学院', '法学');
INSERT INTO `tb_spec` VALUES ('7', '自动化学院', '物联网工程');
INSERT INTO `tb_spec` VALUES ('14', '计算机学院', '网络工程');

-- ----------------------------
-- Table structure for `tb_student`
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student` (
  `stuId` int(11) NOT NULL AUTO_INCREMENT,
  `stuNumber` int(11) NOT NULL,
  `stuName` varchar(20) NOT NULL,
  `stuDepart` varchar(100) DEFAULT NULL,
  `stuSpec` varchar(100) DEFAULT NULL,
  `stuClass` int(11) DEFAULT NULL,
  PRIMARY KEY (`stuId`),
  UNIQUE KEY `stuNumber_UNIQUE` (`stuNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_student
-- ----------------------------
INSERT INTO `tb_student` VALUES ('1', '3001', '黄章', '计算机学院', '软件工程', '1');
INSERT INTO `tb_student` VALUES ('4', '3003', '马云', '计算机学院', '计算机科学与技术', '2');
INSERT INTO `tb_student` VALUES ('6', '3002', '马化腾', '计算机学院', '软件工程', '1');
INSERT INTO `tb_student` VALUES ('7', '3004', '周鸿祎', '自动化学院', '物联网工程', '2');
INSERT INTO `tb_student` VALUES ('8', '3005', '雷军', '自动化学院', '物联网工程', '2');
INSERT INTO `tb_student` VALUES ('9', '3006', '李彦宏', '物理学院', '物理学', '1');
INSERT INTO `tb_student` VALUES ('10', '3007', '刘强东', '政法学院', '法学', '1');
INSERT INTO `tb_student` VALUES ('11', '3008', '丁磊', '物理学院', '物理学', '1');
INSERT INTO `tb_student` VALUES ('13', '3009', '张朝阳', '艺术设计学院', '服装设计', '1');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `userPwd` varchar(45) DEFAULT NULL,
  `userType` int(11) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'admin', '123', '1');
INSERT INTO `tb_user` VALUES ('4', 'test', 'bbb', '2');
INSERT INTO `tb_user` VALUES ('5', 'abc', '123', '2');

-- ----------------------------
-- Table structure for `t_stu`
-- ----------------------------
DROP TABLE IF EXISTS `t_stu`;
CREATE TABLE `t_stu` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sno` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` char(2) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `grade` varchar(30) DEFAULT NULL,
  `dorm` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_stu
-- ----------------------------
INSERT INTO `t_stu` VALUES ('1', '20256666601', '张三', '男', '21', '20软件工程2班', '竹园21栋102');
INSERT INTO `t_stu` VALUES ('2', '20256666602', '李四', '男', '20', '20软件工程2班', '竹园21栋103');
INSERT INTO `t_stu` VALUES ('3', '20256666603', '王五', '男', '21', '20软件工程2班', '竹园21栋104');
INSERT INTO `t_stu` VALUES ('4', '20256666604', '赵六', '男', '22', '20软件工程2班', '竹园21栋105');
INSERT INTO `t_stu` VALUES ('5', '20256666605', '田七', '男', '21', '20软件工程2班', '竹园21栋106');
INSERT INTO `t_stu` VALUES ('6', '20256666606', '小明', '男', '21', '20软件工程二班', '竹园21栋107');
INSERT INTO `t_stu` VALUES ('7', '20256666607', '晓楠', '男', '21', '20软件工程一班', '竹园21栋108');
INSERT INTO `t_stu` VALUES ('8', '20256666608', '小陈', '男', '22', '20电子商务二班', '竹园21栋109');
INSERT INTO `t_stu` VALUES ('9', '20256666609', '小芳', '女', '20', '20软件工程一班', '竹园21栋110');
INSERT INTO `t_stu` VALUES ('10', '20256666610', '小天', '男', '19', '20软件工程一班', '紫园17栋201');
INSERT INTO `t_stu` VALUES ('11', '20256666611', '小李', '女', '21', '20电子商务二班', '紫园17栋202');
INSERT INTO `t_stu` VALUES ('12', '20256666612', '小林', '男', '22', '20软件工程二班', '紫园17栋203');
INSERT INTO `t_stu` VALUES ('13', '20256666613', '小乔', '女', '20', '20电子商务一班', '紫园17栋204');
INSERT INTO `t_stu` VALUES ('14', '20256666614', '小郭', '男', '23', '20电子商务一班', '紫园17栋205');
INSERT INTO `t_stu` VALUES ('15', '20256666615', '小高', '男', '19', '20软件工程二班', '紫园17栋206');
INSERT INTO `t_stu` VALUES ('16', '20256666616', '小娜', '女', '18', '20电子商务一班', '紫园17栋207');
INSERT INTO `t_stu` VALUES ('17', '20256666617', '小楷', '男', '19', '20软件工程二班', '紫园17栋208');
INSERT INTO `t_stu` VALUES ('18', '20256666618', '小中', '男', '19', '20电子商务一班', '紫园17栋209');
INSERT INTO `t_stu` VALUES ('19', '20256666619', '小杰', '男', '19', '20电子商务一班', '紫园17栋210');
INSERT INTO `t_stu` VALUES ('20', '20256666620', '小娥', '女', '21', '20软件工程二班', '竹园21栋521');
INSERT INTO `t_stu` VALUES ('21', '20256666621', '小王', '男', '20', '20电子商务一班', '竹园21栋301');
INSERT INTO `t_stu` VALUES ('22', '20256666622', '小柱', '男', '21', '20电子商务一班', '竹园21栋302');
INSERT INTO `t_stu` VALUES ('23', '20256666623', '小菜', '男', '20', '20软件工程二班', '竹园21栋303');
INSERT INTO `t_stu` VALUES ('24', '20256666624', '小白', '男', '22', '20电子商务二班', '竹园21栋304');
INSERT INTO `t_stu` VALUES ('25', '20256666625', '大乔', '女', '19', '20软件工程二班', '竹园21栋305');
INSERT INTO `t_stu` VALUES ('26', '20256666626', '喜羊羊', '男', '19', '20软件工程二班', '竹园21栋306');
INSERT INTO `t_stu` VALUES ('27', '20256666627', '懒羊羊', '男', '18', '20电子商务二班', '竹园21栋307');
INSERT INTO `t_stu` VALUES ('28', '20256666628', '沸羊羊', '男', '21', '20软件工程二班', '竹园21栋308');
INSERT INTO `t_stu` VALUES ('29', '20256666629', '美羊羊', '女', '19', '20电子商务一班', '竹园21栋309');
INSERT INTO `t_stu` VALUES ('30', '20256666630', '慢羊羊', '男', '18', '20软件工程一班', '竹园21栋310');
INSERT INTO `t_stu` VALUES ('31', '20256666631', '灰太狼', '男', '20', '20软件工程二班', '竹园21栋311');
INSERT INTO `t_stu` VALUES ('32', '20256666632', '暖羊羊', '女', '21', '20软件工程二班', '竹园21栋312');
INSERT INTO `t_stu` VALUES ('33', '20256666633', '红太狼', '女', '22', '20电子商务一班', '竹园21栋313');
INSERT INTO `t_stu` VALUES ('34', '20256666634', '小灰灰', '男', '21', '20软件工程二班', '竹园21栋314');
INSERT INTO `t_stu` VALUES ('35', '20256666635', '软绵绵', '男', '20', '20软件工程一班', '竹园21栋315');
INSERT INTO `t_stu` VALUES ('36', '20256666636', '孙策', '男', '19', '20软件工程一班', '竹园21栋316');
INSERT INTO `t_stu` VALUES ('37', '20256666637', '马超', '男', '18', '20电子商务一班', '竹园21栋317');
INSERT INTO `t_stu` VALUES ('38', '20256666638', '白起', '男', '22', '20电子商务一班', '竹园21栋318');
INSERT INTO `t_stu` VALUES ('39', '20256666639', '孙悟空', '男', '19', '20软件工程一班', '竹园21栋319');
INSERT INTO `t_stu` VALUES ('40', '20256666640', '多啦a梦', '男', '21', '20软件工程一班', '竹园21栋320');
INSERT INTO `t_stu` VALUES ('41', '20256666641', '小夫', '男', '21', '20软件工程二班', '竹园21栋321');
INSERT INTO `t_stu` VALUES ('42', '20256666642', '胖虎', '男', '21', '20软件工程一班', '竹园21栋322');
INSERT INTO `t_stu` VALUES ('43', '20256666643', '大雄', '男', '20', '20软件工程一班', '竹园21栋323');
INSERT INTO `t_stu` VALUES ('44', '20256666644', '熊大', '男', '22', '20电子商务二班', '竹园21栋324');
INSERT INTO `t_stu` VALUES ('45', '20256666645', '熊二', '男', '20', '20软件工程一班', '竹园21栋325');
INSERT INTO `t_stu` VALUES ('46', '20256666646', '光头强', '男', '19', '20软件工程二班', '竹园21栋326');
INSERT INTO `t_stu` VALUES ('47', '20256666647', '蜡笔小新', '男', '18', '20软件工程一班', '李园14栋101');
INSERT INTO `t_stu` VALUES ('48', '20256666648', '樱桃小丸子', '女', '19', '20软件工程一班', '李园14栋102');
INSERT INTO `t_stu` VALUES ('49', '20256666649', '工藤新一', '男', '21', '20软件工程一班', '李园14栋103');
INSERT INTO `t_stu` VALUES ('50', '20256666650', '黑子', '男', '20', '20电子商务一班', '李园14栋104');
INSERT INTO `t_stu` VALUES ('51', '20256666651', '李林', '男', '19', '20计算机二班', '李园14栋105');
INSERT INTO `t_stu` VALUES ('52', '20256666652', '卡卡西', '男', '20', '20软件工程一班', '李园14栋106');
INSERT INTO `t_stu` VALUES ('53', '20256666653', ' 佐助', '男', '20', '20软件工程一班', '李园14栋107');
INSERT INTO `t_stu` VALUES ('54', '20256666654', ' 不二周助', '男', '20', '20软件工程一班', '李园14栋108');
INSERT INTO `t_stu` VALUES ('55', '20256666655', ' 我爱罗', '男', '20', '20软件工程一班', '李园14栋109');
INSERT INTO `t_stu` VALUES ('56', '20256666656', ' 灰原哀 ', '男', '20', '20软件工程一班', '李园14栋110');
INSERT INTO `t_stu` VALUES ('57', '20256666657', '杀生丸', '男', '20', '20软件工程一班', '李园14栋111');
INSERT INTO `t_stu` VALUES ('58', '20256666658', '鸣人', '男', '20', '20软件工程一班', '李园14栋112');
INSERT INTO `t_stu` VALUES ('59', '20256666659', ' loli', '男', '20', '20软件工程一班', '李园14栋113');
INSERT INTO `t_stu` VALUES ('60', '20256666660', ' 越前龙马', '男', '20', '20软件工程一班', '李园14栋114');
INSERT INTO `t_stu` VALUES ('61', '20256666661', ' 鼬', '男', '20', '20软件工程一班', '李园14栋115');
INSERT INTO `t_stu` VALUES ('62', '20256666662', ' 手冢国光', '男', '20', '20软件工程一班', '李园14栋116');
INSERT INTO `t_stu` VALUES ('63', '20256666663', ' 工藤新一', '男', '20', '20软件工程一班', '李园14栋117');
INSERT INTO `t_stu` VALUES ('64', '20256666664', '晓 l', '男', '20', '20软件工程一班', '李园14栋118');
INSERT INTO `t_stu` VALUES ('65', '20256666665', ' 卡嘉莉', '女', '20', '20软件工程一班', '李园14栋119');
INSERT INTO `t_stu` VALUES ('66', '20256666666', ' 桔梗', '男', '20', '20软件工程一班', '李园14栋120');
INSERT INTO `t_stu` VALUES ('67', '20256666667', ' 流川枫 ', '男', '20', '20软件工程一班', '李园14栋121');
INSERT INTO `t_stu` VALUES ('68', '20256666668', '春野樱', '女', '20', '20软件工程一班', '李园14栋122');
INSERT INTO `t_stu` VALUES ('69', '20256666669', '阿斯兰', '女', '20', '20软件工程一班', '李园14栋123');
INSERT INTO `t_stu` VALUES ('70', '20256666670', ' 小樱', '女', '19', '20软件工程一班', '李园14栋124');
INSERT INTO `t_stu` VALUES ('71', '20256666671', ' 基拉 ', '女', '19', '20软件工程一班', '李园14栋125');
INSERT INTO `t_stu` VALUES ('72', '20256666672', '撒加', '女', '19', '20软件工程一班', '李园14栋126');
INSERT INTO `t_stu` VALUES ('73', '20256666673', ' 雏田', '女', '19', '20软件工程一班', '李园14栋127');
INSERT INTO `t_stu` VALUES ('74', '20256666674', '戈薇', '女', '19', '20软件工程一班', '李园14栋128');
INSERT INTO `t_stu` VALUES ('75', '20256666675', ' 怪盗基德', '男', '19', '20软件工程一班', '李园14栋129');
INSERT INTO `t_stu` VALUES ('76', '20256666676', ' 沙加 ', '男', '19', '20软件工程一班', '李园14栋130');
INSERT INTO `t_stu` VALUES ('77', '20256666677', '公主 ', '女', '19', '20软件工程一班', '李园14栋201');
INSERT INTO `t_stu` VALUES ('78', '20256666678', '女仆 ', '女', '19', '20软件工程二班', '李园14栋202');
INSERT INTO `t_stu` VALUES ('79', '20256666679', '夜神月', '女', '19', '20软件工程二班', '李园14栋203');
INSERT INTO `t_stu` VALUES ('80', '20256666680', '穆 ', '女', '19', '20软件工程二班', '李园14栋204');
INSERT INTO `t_stu` VALUES ('81', '20256666681', '樱木花道', '男', '19', '20软件工程二班', '李园14栋205');
INSERT INTO `t_stu` VALUES ('82', '20256666682', ' 破面 ', '男', '19', '20软件工程二班', '李园14栋206');
INSERT INTO `t_stu` VALUES ('83', '20256666683', '迪达拉', '男', '19', '20软件工程二班', '李园14栋207');
INSERT INTO `t_stu` VALUES ('84', '20256666684', ' saber ', '男', '19', '20软件工程二班', '李园14栋208');
INSERT INTO `t_stu` VALUES ('85', '20256666685', '八神', '男', '19', '20软件工程二班', '李园14栋209');
INSERT INTO `t_stu` VALUES ('86', '20256666686', '大蛇丸', '男', '19', '20软件工程二班', '李园14栋210');
INSERT INTO `t_stu` VALUES ('87', '20256666687', ' 谷冬狮郎 ', '男', '19', '20软件工程二班', '李园14栋211');
INSERT INTO `t_stu` VALUES ('88', '20256666688', '宁次 ', '男', '19', '20软件工程二班', '李园14栋212');
INSERT INTO `t_stu` VALUES ('89', '20256666689', '迹部 ', '男', '19', '20软件工程二班', '李园14栋213');
INSERT INTO `t_stu` VALUES ('90', '20256666690', '雪见 ', '男', '19', '20软件工程二班', '李园14栋214');
INSERT INTO `t_stu` VALUES ('91', '20256666691', '菊丸英二', '男', '19', '20软件工程二班', '李园14栋215');
INSERT INTO `t_stu` VALUES ('92', '20256666692', '鹿丸 ', '男', '21', '20软件工程二班', '李园14栋216');
INSERT INTO `t_stu` VALUES ('93', '20256666693', '拉克丝', '男', '21', '20软件工程二班', '李园14栋217');
INSERT INTO `t_stu` VALUES ('94', '20256666694', ' 朽木白哉', '男', '21', '20软件工程二班', '李园14栋218');
INSERT INTO `t_stu` VALUES ('95', '20256666695', ' 樱桃小丸子', '男', '21', '20软件工程二班', '李园14栋219');
INSERT INTO `t_stu` VALUES ('96', '20256666696', ' 朽木露琪亚', '男', '21', '20软件工程二班', '李园14栋220');
INSERT INTO `t_stu` VALUES ('97', '20256666697', ' 四代火影', '男', '21', '20软件工程二班', '李园14栋221');
INSERT INTO `t_stu` VALUES ('98', '20256666698', '路飞', '男', '21', '20软件工程二班', '李园14栋222');
INSERT INTO `t_stu` VALUES ('99', '20256666699', ' 灵儿 ', '男', '21', '20软件工程二班', '李园14栋223');
INSERT INTO `t_stu` VALUES ('100', '20251104260', '林徐耿', '男', '21', '20软件工程二班', '竹园21栋513');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'xiaolin', '123456');
INSERT INTO `t_user` VALUES ('2', 'lxg', '123456');
INSERT INTO `t_user` VALUES ('8', 'linxugeng', '666666');
INSERT INTO `t_user` VALUES ('9', 'xiaolin01', '123456');
INSERT INTO `t_user` VALUES ('10', 'xiaolin2', '666666');
INSERT INTO `t_user` VALUES ('11', '111111', '111111');
INSERT INTO `t_user` VALUES ('12', 'xiaolin03', 'dogurot');
INSERT INTO `t_user` VALUES ('13', '222222', '222222');
INSERT INTO `t_user` VALUES ('14', 'XiaoLin02', '111111');
INSERT INTO `t_user` VALUES ('15', 'xiaolin04', '666666');
