/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : schoolblog

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-06-16 10:52:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for navigationbar
-- ----------------------------
DROP TABLE IF EXISTS `navigationbar`;
CREATE TABLE `navigationbar` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `createDate` datetime NOT NULL,
  PRIMARY KEY (`id`,`createDate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of navigationbar
-- ----------------------------
INSERT INTO `navigationbar` VALUES ('1', '推荐', '2019-05-27 20:32:23');
INSERT INTO `navigationbar` VALUES ('10', '区块链', '2019-05-14 20:34:33');
INSERT INTO `navigationbar` VALUES ('11', '游戏开发', '2019-05-13 20:34:43');
INSERT INTO `navigationbar` VALUES ('12', '研发管理', '2019-05-12 20:34:59');
INSERT INTO `navigationbar` VALUES ('13', '移动开发', '2019-05-11 20:35:13');
INSERT INTO `navigationbar` VALUES ('14', '物联网', '2019-05-09 20:35:26');
INSERT INTO `navigationbar` VALUES ('15', '运维', '2019-05-08 20:35:39');
INSERT INTO `navigationbar` VALUES ('16', '计算机基础', '2019-05-07 20:35:52');
INSERT INTO `navigationbar` VALUES ('17', '其他', '2019-05-06 20:36:02');
INSERT INTO `navigationbar` VALUES ('2', '最新文章', '2019-05-27 17:09:24');
INSERT INTO `navigationbar` VALUES ('4', '程序人生', '2019-05-26 20:33:23');
INSERT INTO `navigationbar` VALUES ('5', '数据库', '2019-05-26 20:33:12');
INSERT INTO `navigationbar` VALUES ('6', '前端', '2019-05-25 20:33:38');
INSERT INTO `navigationbar` VALUES ('7', '编程语言', '2019-05-24 20:33:51');
INSERT INTO `navigationbar` VALUES ('8', '人工智能', '2019-05-16 20:34:03');
INSERT INTO `navigationbar` VALUES ('9', '云计算/大数据', '2019-05-15 20:34:17');

-- ----------------------------
-- Table structure for t_draftbox
-- ----------------------------
DROP TABLE IF EXISTS `t_draftbox`;
CREATE TABLE `t_draftbox` (
  `draftboxId` varchar(200) NOT NULL,
  `title` varchar(200) NOT NULL,
  `introduce` varchar(200) DEFAULT NULL,
  `txt` varchar(225) DEFAULT NULL,
  `type` varchar(200) DEFAULT NULL,
  `discuss` char(1) DEFAULT NULL,
  `homePage` char(1) DEFAULT NULL,
  `draftDate` date DEFAULT NULL,
  PRIMARY KEY (`draftboxId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_draftbox
-- ----------------------------
INSERT INTO `t_draftbox` VALUES ('165be63a-de36-413b-b124-a08d5e6688b2', 'daddadadff', 'ada', '<p>dadaw</p>', '运维', 'N', 'Y', '2019-03-31');
INSERT INTO `t_draftbox` VALUES ('6fb5342a-9a55-4194-b610-3fd931b01805', 'da', 'gadwa', '<p>adaw</p>', '游戏开发', 'N', 'N', '2019-04-02');
INSERT INTO `t_draftbox` VALUES ('97eb7f3e-a67d-4bce-96e0-4a8c7620d4cc', 'dad', 'ada', '<p>daxx</p>', '前端', 'N', 'N', '2019-06-14');

-- ----------------------------
-- Table structure for t_imgurl
-- ----------------------------
DROP TABLE IF EXISTS `t_imgurl`;
CREATE TABLE `t_imgurl` (
  `imgId` varchar(200) NOT NULL,
  `imgName` varchar(200) NOT NULL,
  `url` varchar(200) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  PRIMARY KEY (`imgId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_imgurl
-- ----------------------------
INSERT INTO `t_imgurl` VALUES ('1f6f4a0a-71ac-4de2-acac-5970c83824b2', 'tm-450x300-08.jpg', 'upload\\aaa\\tm-450x300-08.jpg', '2019-03-31');
INSERT INTO `t_imgurl` VALUES ('259231a9-6a11-4e91-addf-1fa43a89a4b3', 'tm-450x300-01.jpg', 'upload\\admin\\tm-450x300-01.jpg', '2019-06-15');
INSERT INTO `t_imgurl` VALUES ('30e645bd-1c83-46ce-9581-e9b0d578e7a1', 'tm-450x300-09.jpg', 'upload\\admin\\tm-450x300-09.jpg', '2019-03-15');
INSERT INTO `t_imgurl` VALUES ('50cf8c37-aa5f-4a95-a22e-1d7f9512dd79', 'tm-450x300-08.jpg', 'upload\\admin\\tm-450x300-08.jpg', '2018-06-03');
INSERT INTO `t_imgurl` VALUES ('5ed24c26-af55-4081-9df8-d33fb40a4dd2', 'tm-450x300-09.jpg', 'upload\\aaa\\tm-450x300-09.jpg', '2019-03-31');
INSERT INTO `t_imgurl` VALUES ('70f8ab73-0d33-4ede-ac61-c3ba9b888a3f', 'tm-450x300-10.jpg', 'upload\\ccc\\tm-450x300-10.jpg', '2019-06-14');
INSERT INTO `t_imgurl` VALUES ('71159c80-97eb-428d-81ce-d201f442de75', 'hdfs读数据流程图.png', 'upload\\admin\\hdfs读数据流程图.png', '2019-05-30');
INSERT INTO `t_imgurl` VALUES ('7263b5d3-82bb-44fc-8c26-a1ff6fcfd682', 'home-bg.jpg', 'upload\\admin\\home-bg.jpg', '2018-11-03');
INSERT INTO `t_imgurl` VALUES ('84c28e11-008d-4728-87f4-5e9a8053795d', 'tm-450x300-10.jpg', 'upload\\aaa\\tm-450x300-10.jpg', '2019-03-31');
INSERT INTO `t_imgurl` VALUES ('aa970c46-0858-4694-ac86-367f9aede3e1', '系统流程图.png', 'upload\\null\\系统流程图.png', '2019-05-18');
INSERT INTO `t_imgurl` VALUES ('b7162b9e-168f-4b83-8f24-ca839bc8614d', 'tm-450x300-11.jpg', 'upload\\admin\\tm-450x300-11.jpg', '2019-06-15');
INSERT INTO `t_imgurl` VALUES ('c95042a0-56ea-4b89-a3b1-62ed3066bb8b', 'home-bg.jpg', 'upload\\admin\\home-bg.jpg', '2018-11-03');
INSERT INTO `t_imgurl` VALUES ('dc2366f7-d05d-4e61-bbe8-2984afe1b752', 'tm-450x300-09.jpg', 'upload\\admin\\tm-450x300-09.jpg', '2019-03-31');
INSERT INTO `t_imgurl` VALUES ('f03e19e7-3fee-46a9-aab2-f9f3e164ecf0', 'tm-450x300-09.jpg', 'upload\\admin\\tm-450x300-09.jpg', '2019-05-30');
INSERT INTO `t_imgurl` VALUES ('fa992c07-5c5d-4693-b015-a64aebc566e0', '2.jpg', 'upload\\admin\\2.jpg', '2018-06-03');

-- ----------------------------
-- Table structure for t_publish
-- ----------------------------
DROP TABLE IF EXISTS `t_publish`;
CREATE TABLE `t_publish` (
  `releaseId` varchar(200) NOT NULL,
  `title` varchar(200) NOT NULL,
  `introduce` text,
  `txt` text,
  `type` varchar(200) DEFAULT NULL,
  `discuss` char(1) DEFAULT NULL,
  `homePage` char(1) DEFAULT NULL,
  `ReleaseDate` date DEFAULT NULL,
  `readNum` int(11) DEFAULT '0',
  PRIMARY KEY (`releaseId`,`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_publish
-- ----------------------------
INSERT INTO `t_publish` VALUES ('15682d9c-a02f-4ab5-9764-2a928e58f2a6', '百度相关搜索是怎么出现的如何利用', '百度相关搜索形成原理  用户搜索词和其他搜索词出现相关的,或有很多人是直接搜索与这个词相关的其他短语,如果搜索的人多,可以解释的内容用户句话说从侧面也有很强的需求。因此,为了满足更多用户的需求,提高用户体验,百度搜索这个词的数据显示用户和搜索次数最多的词数据相关和最底部的相关搜索,方便用户找到自己。', '<p style=\"box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; color: rgb(79, 79, 79); line-height: 26px; overflow-wrap: break-word; font-variant-ligatures: common-ligatures; white-space: normal; background-color: rgb(255, 255, 255);\">例如:</p><p style=\"box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; color: rgb(79, 79, 79); line-height: 26px; overflow-wrap: break-word; font-variant-ligatures: common-ligatures; white-space: normal; background-color: rgb(255, 255, 255);\">1、就这儿工具举个例：假设百度收录这个词,一天有2000搜索,搜索这个词有1000人,但与此同时搜索句话说(如：百度收录查询),然后这些数据将被记录下来,在百度更新数据,这些词将被放置在底部的相关搜索结果。</p><p style=\"box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; color: rgb(79, 79, 79); line-height: 26px; overflow-wrap: break-word; font-variant-ligatures: common-ligatures; white-space: normal; background-color: rgb(255, 255, 255);\">2、很多人直接搜索“百度收录查询”这个词，由于百度数据量大，算法先进，它可以根据数据和哪些词是相关的来确定这个词，从而放在相关搜索的底部。</p><p style=\"box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; color: rgb(79, 79, 79); line-height: 26px; overflow-wrap: break-word; font-variant-ligatures: common-ligatures; white-space: normal; background-color: rgb(255, 255, 255);\">由于它是为用户和短语的需要，对我们网站搜索相关词语时进行选择，做词语，具有一定的参考价值。</p><p style=\"box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; color: rgb(79, 79, 79); line-height: 26px; overflow-wrap: break-word; font-variant-ligatures: common-ligatures; white-space: normal; background-color: rgb(255, 255, 255);\">如何使用相关的搜索推广</p><p style=\"box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; color: rgb(79, 79, 79); line-height: 26px; overflow-wrap: break-word; font-variant-ligatures: common-ligatures; white-space: normal; background-color: rgb(255, 255, 255);\">1、这其实就是，将自己的关键词+品牌词做相关搜索就可以了，可以提高自己网站的知名度和曝光率，长时间也可以带来很多流量。</p><p style=\"box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; color: rgb(79, 79, 79); line-height: 26px; overflow-wrap: break-word; font-variant-ligatures: common-ligatures; white-space: normal; background-color: rgb(255, 255, 255);\">2、实践是非常简单的流动,每天自己的搜索关键字时,搜索和添加自己的品牌的话,但几个IP显然是不够的,这需要一些IP点击软件的使用,或找到一个第三方支付刷。</p><p style=\"box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; color: rgb(79, 79, 79); line-height: 26px; overflow-wrap: break-word; font-variant-ligatures: common-ligatures; white-space: normal; background-color: rgb(255, 255, 255);\">提示:如果自己的服务和产品不好，即使这些相关的搜索做了一点，意义也不是很大，如果产品和服务失败了那就很难了。不建议用黑帽做这些东西，会让搜索引擎反感。</p><p><br/></p>', '计算机基础', 'N', 'Y', '2019-06-14', '6');
INSERT INTO `t_publish` VALUES ('47bd0032-7799-40fa-bdd9-c637aa37d6d9', '为何人工智能(AI)首选Python？读完这篇文章你就知道了', '以下链接是本人整理的关于计算机视觉（ComputerVision, CV）相关领域的网站链接，其中有CV牛人的主页，CV研究小组的主页，CV领域的paper,代码，CV领域的最新动态，国内的应用情况等等。打算从事 这个行业或者刚入门的朋友可以多关注这些网站，多了解一些CV的具体应用。搞研究的朋友也可以从中了解到很多牛人的研究动态、招生情况等。总之，我认为， 知识只有分享才能产生更大的价值，真诚希望下面的链接能对朋友们有所帮助。', '<p>如果你想要系统地学习人工智能，那么推荐你去看床长人工智能教程。非常棒的大神之作，教程不仅通俗易懂，而且很风趣幽默。点击这里可以查看教程。</p><p><br/></p><p>在这里我要明确表个态，对于希望加入到 AI 和大数据行业的开发人员来说，把鸡蛋放在 Python 这个篮子里不但是安全的，而且是必须的。或者换个方式说，如果你将来想在这个行业混，什么都不用想，先闭着眼睛把 Python 学会了。当然，Python不是没有它的问题和短处，你可以也应该有另外一种甚至几种语言与 Python 形成搭配，但是Python 将坐稳数据分析和 AI 第一语言的位置，这一点毫无疑问。</p><p><br/></p><p>我甚至认为，由于 Python 坐稳了这个位置，由于这个行业未来需要大批的从业者，更由于Python正在迅速成为全球大中小学编程入门课程的首选教学语言，这种开源动态脚本语言非常有机会在不久的将来成为第一种真正意义上的编程世界语。下面分享一个python实现人工智能的代码的脚本，进行AI人工智能python实现人机对话：</p><p><br/></p><p>AIML</p><p><br/></p><p>AIML由Richard Wallace发明。他设计了一个名为 A.L.I.C.E. （Artificial Linguistics Internet Computer Entity 人工语言网计算机实体） 的机器人，并获得了多项人工智能大奖。有趣的是，图灵测试的其中一项就在寻找这样的人工智能：人与机器人通过文本界面展开数分钟的交流，以此查看机器人是否会被当作人类。</p><p><br/></p><p>本文就使用了Python语言调用AIML库进行智能机器人的开发。</p><p><br/></p><p>本系统的运作方式是使用Python搭建服务端后台接口，供各平台可以直接调用。然后客户端进行对智能对话api接口的调用，服务端分析参数数据，进行语句的分析，最终返回应答结果。</p><p><br/></p><p>当前系统前端使用HTML进行简单地聊天室的设计与编写，使用异步请求的方式渲染数据。</p><p><br/></p><p><br/></p>', '人工智能', 'Y', 'Y', '2019-06-14', '2');
INSERT INTO `t_publish` VALUES ('575390f2-b814-422e-8393-a739acab67e7', 'Web】CSS（No.16）Css的三大特性（层叠性、继承性、优先级）', 'CSS层叠性', '<p>所谓层叠性是指多种CSS样式的叠加。</p><p><br/></p><p>是浏览器处理冲突的一个能力,如果一个属性通过两个相同选择器设置到同一个元素上，那么这个时候一个属性就会将另一个属性层叠掉。</p><p><br/></p><p>比如先给某个标签指定了内部文字颜色为红色，接着又指定了颜色为蓝色，此时出现一个标签指定了相同样式不同值的情况，这就是样式冲突。</p><p><br/></p><p>一般情况下，如果出现样式冲突，则会按照CSS书写的顺序，以最后的样式为准。</p><p><br/></p><h2 style=\"box-sizing: border-box; outline: 0px; margin: 8px 0px 16px; padding: 0px; font-size: 24px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; color: rgb(79, 79, 79); line-height: 32px; overflow-wrap: break-word; font-variant-ligatures: common-ligatures; white-space: normal; background-color: rgb(255, 255, 255);\">CSS继承性</h2><p style=\"box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; color: rgb(79, 79, 79); line-height: 26px; overflow-wrap: break-word; font-variant-ligatures: common-ligatures; white-space: normal; background-color: rgb(255, 255, 255);\">所谓继承性是指书写CSS样式表时，子标签会继承父标签的某些样式，如文本颜色和字号。想要设置一个可继承的属性，只需将它应用于父元素即可。</p><p style=\"box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; color: rgb(79, 79, 79); line-height: 26px; overflow-wrap: break-word; font-variant-ligatures: common-ligatures; white-space: normal; background-color: rgb(255, 255, 255);\">简单的理解就是： 子承父业。</p><p>CSS优先级</p><p>定义CSS样式时，经常出现两个或更多规则应用在同一元素上，这时就会出现优先级的问题。</p><p><br/></p><p>在考虑权重时，初学者还需要注意一些特殊的情况，具体如下：</p><p><br/></p><p>继承样式的权重为0。即在嵌套结构中，不管父元素样式的权重多大，被子元素继承时，他的权重都为0，也就是说子元素定义的样式会覆盖继承来的样式。</p><p><br/></p><p>行内样式优先。应用style属性的元素，其行内样式的权重非常高，可以理解为远大于100。总之，他拥有比上面提高的选择器都大的优先级。</p><p><br/></p><p>权重相同时，CSS遵循就近原则。也就是说靠近元素的样式具有最大的优先级，或者说排在最后的样式优先级最大。</p><p><br/></p><p>CSS定义了一个!important命令，该命令被赋予最</p><p><br/></p>', '前端', 'N', 'N', '2019-06-14', '2');
INSERT INTO `t_publish` VALUES ('64166480-b826-4eb4-818f-d4adb6b2c990', 'Redlock（redis分布式锁）原理分析', '个锁的算法实现了多redis实例的情况，相对于单redis节点来说，优点在于 防止了 单节点故障造成整个服务停止运行的情况；并且在多节点中锁的设计，及多节点同时崩溃等各种意外情况有自己独特的设计方法；', '<p style=\"box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; color: rgb(79, 79, 79); line-height: 26px; overflow-wrap: break-word; font-variant-ligatures: common-ligatures; white-space: normal; background-color: rgb(255, 255, 255);\">此博客或者官方文档的相关概念：</p><p style=\"box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; color: rgb(79, 79, 79); line-height: 26px; overflow-wrap: break-word; font-variant-ligatures: common-ligatures; white-space: normal; background-color: rgb(255, 255, 255);\">1.TTL：Time To Live;只 redis key 的过期时间或有效生存时间</p><p style=\"box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; color: rgb(79, 79, 79); line-height: 26px; overflow-wrap: break-word; font-variant-ligatures: common-ligatures; white-space: normal; background-color: rgb(255, 255, 255);\">2.clock drift:时钟漂移；指两个电脑间时间流速基本相同的情况下，两个电脑（或两个进程间）时间的差值；如果电脑距离过远会造成时钟漂移值 过大</p><p style=\"box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; color: rgb(79, 79, 79); line-height: 26px; overflow-wrap: break-word; font-variant-ligatures: common-ligatures; white-space: normal; background-color: rgb(255, 255, 255);\">最低保证分布式锁的有效性及安全性的要求如下：</p><p style=\"box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; color: rgb(79, 79, 79); line-height: 26px; overflow-wrap: break-word; font-variant-ligatures: common-ligatures; white-space: normal; background-color: rgb(255, 255, 255);\">1.互斥；任何时刻只能有一个client获取锁</p><p style=\"box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; color: rgb(79, 79, 79); line-height: 26px; overflow-wrap: break-word; font-variant-ligatures: common-ligatures; white-space: normal; background-color: rgb(255, 255, 255);\">2.释放死锁；即使锁定资源的服务崩溃或者分区，仍然能释放锁</p><p style=\"box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; color: rgb(79, 79, 79); line-height: 26px; overflow-wrap: break-word; font-variant-ligatures: common-ligatures; white-space: normal; background-color: rgb(255, 255, 255);\">3.容错性；只要多数redis节点（一半以上）在使用，client就可以获取和释放锁</p><p style=\"box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; color: rgb(79, 79, 79); line-height: 26px; overflow-wrap: break-word; font-variant-ligatures: common-ligatures; white-space: normal; background-color: rgb(255, 255, 255);\">网上讲的基于故障转移实现的redis主从无法真正实现Redlock:</p><p style=\"box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; color: rgb(79, 79, 79); line-height: 26px; overflow-wrap: break-word; font-variant-ligatures: common-ligatures; white-space: normal; background-color: rgb(255, 255, 255);\">因为redis在进行主从复制时是异步完成的，比如在clientA获取锁后，主redis复制数据到从redis过程中崩溃了，导致没有复制到从redis中，然后从redis选举出一个升级为主redis,造成新的主redis没有clientA 设置的锁，这是clientB尝试获取锁，并且能够成功获取锁，导致互斥失效；</p><p style=\"box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; color: rgb(79, 79, 79); line-height: 26px; overflow-wrap: break-word; font-variant-ligatures: common-ligatures; white-space: normal; background-color: rgb(255, 255, 255);\">思考题：这个失败的原因是因为从redis立刻升级为主redis，如果能够过TTL时间再升级为主redis（延迟升级）后，或者立刻升级为主redis但是过TTL的时间后再执行获取锁的任务，就能成功产生互斥效果；是不是这样就能实现基于redis主从的Redlock;</p><h4 style=\"box-sizing: border-box; outline: 0px; margin: 8px 0px 16px; padding: 0px; font-size: 20px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; color: rgb(79, 79, 79); line-height: 28px; overflow-wrap: break-word; font-variant-ligatures: common-ligatures; white-space: normal; background-color: rgb(255, 255, 255);\"><a target=\"_blank\" style=\"box-sizing: border-box; outline: 0px; margin: 0px; padding: 0px; color: rgb(78, 161, 219); cursor: pointer; background-color: transparent; overflow-wrap: break-word;\"></a>redis单实例中实现分布式锁的正确方式（原子性非常重要）:</h4><p style=\"box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; color: rgb(79, 79, 79); line-height: 26px; overflow-wrap: break-word; font-variant-ligatures: common-ligatures; white-space: normal; background-color: rgb(255, 255, 255);\">1.设置锁时，使用set命令，因为其包含了setnx,expire的功能，起到了原子操作的效果，给key设置随机值，并且只有在key不存在时才设置成功返回True,并且设置key的过期时间（最好用毫秒）</p><p><br/></p>', '数据库', 'N', 'Y', '2019-06-14', '1');
INSERT INTO `t_publish` VALUES ('658b58d7-07e2-45bb-97ac-8f9b4f0b9ca3', '强劲的Linux Trace工具：bpftrace (DTrace 2.0) for Linux 2018', '原作者是大名鼎鼎的性能分析专家：Brendan Gregg，现在工作在Netflix，之前工作在Sun，在Sun公司的时候，他就做了大量的性能分析和tracing相关的工作', '<p style=\"text-indent: 0em;\"><span style=\"color: rgb(255, 0, 0);\"><strong>bpftrace (DTrace 2.0) for Linux 2018</strong></span></p><p>告诉大家一个好消息，bpftrace开源啦，这对DTrace粉丝来说是一个绝对的好消息，其项目作者依然是Alastair Robertson, bpftrace是一个开源的高级的tracing（跟踪）工具（high-level tracing front-end），可以让你自定义的方式跟踪。它就像是DTrace version 2.0：实用，从eBPF virtual machine中编译出来。eBPF (extended Berkeley Packet Filter) 是近期kernel上比较热门的一个工程。也正在为兼容BSD而开发，BSD项目也是BPF项目的发源地。</p><p><br/></p><p><strong><span style=\"color: rgb(255, 0, 0); text-indent: 2em;\">bpftrace</span></strong></p><p>我第一次提及 bpftrace (aka BPFtrace)工作计划，是在曾经的一次演讲上：DTrace for Linux 2016， 当时，我也介绍了Linux Kernel的eBPF的孵化过程，同时也介绍了我当时在做的bcc (BPF Complier Collection)项目，一个让我在新的架构上重写Dtrace工具集的项目。bcc虽然很强大，但是要实现一个小工具就需要写一个小脚本，还是有点小麻烦（写一个小脚本要写的代码太多，不能用一行命令表达），因此，我准备额外分享另外一个高级工具bpftrace给大家。bpftrace特点在于，当希望编写小工具的时候，可以一行命令表达完整。</p><p><br/></p><p>Alastair最近在开发一些框架，并且适配了tracepoints（可以做到one-linner），昨天把kprobes也适配好了，举个例子：</p><p>我，Willian Gaspar, 和 Matheus Marchini，也提供了一些拓展和bugfix的patch，查看没有处理的问题issue list，查看指南， 查看之前的提交。</p><p><br/></p><p>bpftrace使用了已有的Linux kernel中的基础设施（eBPF, kprobes, uprobes, tracepoints, perf_events），同时也有bcc的库，至于bpftrace内部实现，使用了 lex/yacc parser 把程序转化为AST，再到 llvm IR actions, 最后变成BPF。</p><p><br/></p><p><strong><span style=\"color: rgb(255, 0, 0);\">bpftrace/eBPF vs DTrace equivalency</span></strong></p><p>这一个章节，我会写一些“例子”，来对比“bpftrace/eBPF” 和 “Dtrace”，但是，注意一点，并不是说kernel中的eBPF就是仅仅实现了一个 “Linux版的Dtrace” 哦，eBPF还有很多的用处。</p><p><br/></p><p>eBPF是其作者 Alexei Starovoitov 在PLUMgrid工作的时候（现在在Facebook）创建，是打算做成一个 Kernel中 通用的 “虚拟机”的，可以帮助实现软件定义网络的场景。很明显，它还有很多其他的场景，比如：eXpress Data Path, container security and networking, iptables, infrared decoding, intrusion detection, hyperupcalls, 和 FUSE performance. 实际上，eBPF直接使用是很费劲的，所以，才产生了bcc上层的python库。</p><p><br/></p><p><br/></p>', '运维', 'N', 'N', '2019-06-14', '1');
INSERT INTO `t_publish` VALUES ('a8cfbcff-1bc7-4421-ab97-5266b10cb93d', '论做游戏外挂，Python输过谁？', '首先要声明，这里的游戏外挂的概念，和那些大型网游里的外挂可不同，不能自动打怪，不能喝药不能躲避GM…… 那做这个外挂有啥用？问的好，没用，除了可以浪费你一点时间，提高一下编程技术，增加一点点点点点点的做外挂的基础以外，毫无用处，如果您是以制作一个惊天地泣鬼神不开则已一开', '<p>. 工具的准备</p><p>需要安装autopy和PIL以及pywin32包。</p><p><br/></p><p>autopy是一个自动化操作的python库，可以模拟一些鼠标、键盘事件，还能对屏幕进行访问，本来我想用win32api来模拟输入事件的，发现这个用起来比较简单，最厉害的是它是跨平台的，请搜索安装。</p><p><br/></p><p>PIL那是大名鼎鼎了，Python图像处理的No.1，下面会说明用它来做什么。</p><p><br/></p><p>pywin32其实不是必须的，但是为了方便（鼠标它在自己动着呢，如何结束它呢)，还是建议安装一下，哦对了，我是在win平台上做的，外挂大概只有windows用户需要吧？</p><p><br/></p><p>截屏和图像处理工具</p><p><br/></p><p>截屏是获取游戏图像以供分析游戏提示，其实没有专门的工具直接Print Screen粘贴到图像处理工具里也可以。我用的是PicPick，相当好用，而且个人用户是免费的。而图像处理则是为了获取各种信息的，我们要用它得到点菜图像后保存起来，供外挂分析判断。我用的是PhotoShop… 不要告诉Adobe，其实PicPick中自带的图像编辑器也足够了，只要能查看图像坐标和剪贴图片就好了，只不过我习惯PS了~</p><p><br/></p><p>看这个游戏，有8种菜，每种菜都有固定的做法，顾客一旦坐下来，头顶上就会有一个图片，看图片就知道他想要点什么菜，点击左边原料区域，然后点击一下……不知道叫什么，像个竹简一样的东西，菜就做完了，然后把做好的食物拖拽到客户面前就好了。</p><p><br/></p><p>顾客头上显示图片的位置是固定的，总共也只有四个位置，我们可以逐一分析，而原料的位置也是固定的，每种菜的做法更是清清楚楚，这样一来我们完全可以判断，程序可以很好的帮我们做出一份一份的佳肴并奉上，于是钱滚滚的来：）</p><p><br/></p><p>2.移动鼠标</p><p>这个命令会让鼠标迅速移动到指定屏幕坐标，你知道什么是屏幕坐标的吧，左上角是（0,0），然后向右向下递增，所以1024×768屏幕的右下角坐标是……你猜对了，是（1023,767）。</p><p><br/></p><p>不过有些不幸的，如果你实际用一下这个命令，然后用autopy.mouse.get_pos()获得一下当前坐标，发现它并不在(100,100)上，而是更小一些，比如我的机器上是（97,99），和分辨率有关。这个移动是用户了和windows中mouse_event函数，若不清楚api的，知道这回事就好了，就是这个坐标不是很精确的。像我一样很好奇的，可以去读一下autopy的源码，我发现他计算绝对坐标算法有问题：</p><p><br/></p><p>point.x *= 0xFFFF / GetSystemMetrics(SM_CXSCREEN);</p><p>这里先做除法再做乘法，学过一点计算方法的就应该知道对于整数运算，应该先乘再除的，否则就会产生比较大的误差，如果他写成:</p><p><br/></p><p>point.x = point.x * 0xffff / GetSystemMetrics(SM_CXSCREEN);</p><p>就会准多了，虽然理论上会慢一点点，不过我也懒得改代码重新编译了，差几个像素，这里对我们影响不大~咱要吸取教训呀</p><p><br/></p><p>&nbsp;</p><p><br/></p><p>&nbsp;</p><p><br/></p><p>3.点击鼠标</p><p><br/></p><p>这个比较简单，不过记得这里的操作都是非常非常快的，有可能游戏还没反应过来呢，你就完成了，于是失败了…… 所以必要的时候，请sleep一小会儿。</p><p><br/></p><p>4.键盘操作</p><p><br/></p><p>我们这次没用到键盘，所以我就不说了。</p><p><br/></p><p>怎么做？分析顾客头上的图像就可以，来，从获取图像开始吧~</p><p><br/></p><p>打开你钟爱的图像编辑器，开始丈量吧~ 我们得知道图像在屏幕的具体位置，可以用标尺量出来，本来直接量也是可以的，但是我这里使用了画面左上角的位置（也就是点1）来当做参考位置，这样一旦画面有变动，我们只需要修改一个点坐标就好了，否则每一个点都需要重新写一遍可不是一件快乐的事情。</p><p><br/></p><p>看最左边的顾客头像上面的图像，我们需要两个点才可确定这个范围，分别是图像的左上角和右下角，也就是点2和点3,。后面还有三个顾客的位置，只需要简单的加上一个增量就好了，for循环就是为此而生！</p><p><br/></p><p>同样的，我们原料的位置，“竹席”的位置等等，都可以用这种方法获得。注意获得的都是相对游戏画面左上角的相对位置。至于抓图的方法，PIL的ImageGrab就</p><p>---------------------&nbsp;</p><p>作者：A九离&nbsp;</p><p>来源：CSDN&nbsp;</p><p>原文：https://blog.csdn.net/weixin_44138053/article/details/88252177&nbsp;</p><p>版权声明：本文为博主原创文章，转载请附上博文链接！</p><p><br/></p>', '编程语言', 'N', 'N', '2019-04-03', '55');
INSERT INTO `t_publish` VALUES ('c4ced6a5-e601-4991-8bae-d2ce102d7c5a', '华为，将智能计算进行到底', '变永远是不变的主题，应对变化唯一的办法是创新。    以IT建设为例，时至今日，用户已经很少再谈某一项具体应用该如何部署，而是会说数字化转型、产业升级这样的大概念。反映在IT基础设施层面也是一样，以服务器为例，今天谈服务器的少了，说计算的多了。    从服务器到计算，再从计算到智能计算，名称的改变体现的不仅仅是产品本身的变化，更是趋势的演变。论前者，提到服务器，更多想到的是硬件盒子，而谈计算的第一反应则是资源，至于智能计算，比计算更高阶。观后者，计算，之前被称为成本中心，当下和未来，其正在以及必然会成为创新驱动中心。    用户需求是因，产品变化是果。因为用户对IT基础设施的关注点正在从如何有效利用资源转变为如何推动业务创新，如何从成本效用上升到价值创造，所以IT基础设施必须做出相应的变化来匹配用户需求的转变。', '<p style=\"text-align: center;\"><span class=\"bizsvr_52\" style=\"box-sizing: border-box; outline: 0px; font-weight: 700; word-break: break-all; color: rgb(79, 79, 79); font-family: FangSong, 仿宋; font-size: 20px; text-align: center; background-color: rgb(255, 255, 255);\"><span class=\"bizsvr_12\" style=\"box-sizing: border-box; outline: 0px; word-break: break-all; text-align: justify; color: rgb(0, 128, 255);\">华为眼中的智能计算</span></span></p><p><span style=\"color: rgb(79, 79, 79); font-family: &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, SimHei, Arial, SimSun; font-size: 15px; text-align: justify; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;在5月31日召开的“计算无边界 智心领未来”华为智能计算媒体沟通会上，华为再一次就智能计算进行了解读。而从这次沟通会的主题也能看出，相较2017年提出的“无边界计算”战略，2018年更突出了智能、智慧。</span></p><p><span style=\"color: rgb(79, 79, 79); font-family: &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, SimHei, Arial, SimSun; font-size: 15px; text-align: justify; background-color: rgb(255, 255, 255);\"><span style=\"color: rgb(79, 79, 79); font-family: &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, SimHei, Arial, SimSun; font-size: 15px; text-align: justify; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;具体而言，就思想层面而言，华为希望通过智能计算使能行业智能，为企业智能化转型加速，为智能化世界加速。这其中又分为两个维度，一是传统产业，在它们从当前规模化的工业生产逐步向个性化的柔性生产转变过程中，行业“+智能”会成为企业未来竞争力的关键体现，IT基础设施会逐步向智能化解决方案转变。</span></span></p><p style=\"text-align: center;\"><span style=\"color: rgb(79, 79, 79); font-family: &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, SimHei, Arial, SimSun; font-size: 15px; text-align: justify; background-color: rgb(255, 255, 255);\"><span style=\"color: rgb(79, 79, 79); font-family: &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, SimHei, Arial, SimSun; font-size: 15px; text-align: justify; background-color: rgb(255, 255, 255);\"><span class=\"bizsvr_52\" style=\"box-sizing: border-box; outline: 0px; font-weight: 700; word-break: break-all; color: rgb(79, 79, 79); font-family: FangSong, 仿宋; font-size: 20px; text-align: center; background-color: rgb(255, 255, 255);\"><span class=\"bizsvr_12\" style=\"box-sizing: border-box; outline: 0px; word-break: break-all; text-align: justify; color: rgb(0, 128, 255);\">产品是最好的呈现</span></span></span></span></p><p><span style=\"color: rgb(79, 79, 79); font-family: &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, SimHei, Arial, SimSun; font-size: 15px; text-align: justify; background-color: rgb(255, 255, 255);\"><span style=\"color: rgb(79, 79, 79); font-family: &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, SimHei, Arial, SimSun; font-size: 15px; text-align: justify; background-color: rgb(255, 255, 255);\"></span></span></p><p style=\"box-sizing: border-box; outline: 0px; padding: 0px; margin-top: 0px; margin-bottom: 16px; color: rgb(79, 79, 79); line-height: 1.75em; text-align: justify; word-break: break-all; font-family: &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, SimHei, Arial, SimSun; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"box-sizing: border-box; outline: 0px; word-break: break-all; font-size: 15px;\">这里举三个实际的产品例子：</span></p><p style=\"box-sizing: border-box; outline: 0px; padding: 0px; margin-top: 0px; margin-bottom: 16px; color: rgb(79, 79, 79); line-height: 1.75em; text-align: justify; word-break: break-all; font-family: &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, SimHei, Arial, SimSun; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"box-sizing: border-box; outline: 0px; word-break: break-all; font-size: 15px;\"><br/></span></p><p style=\"box-sizing: border-box; outline: 0px; padding: 0px; margin-top: 0px; margin-bottom: 16px; color: rgb(79, 79, 79); line-height: 1.75em; text-align: justify; word-break: break-all; font-family: &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, SimHei, Arial, SimSun; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"box-sizing: border-box; outline: 0px; word-break: break-all; font-size: 15px;\">一、智能引擎。华为最新服务器内置的智能引擎能够在软件管理、故障诊断、部署、移动管理、资产管理方面做到最大程度的简化。与此同时，华为资产管理下的服务器和数据中心能做到L1+L2智能联动，换句话说数据中心的基础设施和IT基础设施能做到自动关联、自动调整。</span></p><p style=\"box-sizing: border-box; outline: 0px; padding: 0px; margin-top: 0px; margin-bottom: 16px; color: rgb(79, 79, 79); line-height: 1.75em; text-align: justify; word-break: break-all; font-family: &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, SimHei, Arial, SimSun; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"box-sizing: border-box; outline: 0px; word-break: break-all; font-size: 15px;\"><br/></span></p><p style=\"box-sizing: border-box; outline: 0px; padding: 0px; margin-top: 0px; margin-bottom: 16px; color: rgb(79, 79, 79); line-height: 1.75em; text-align: justify; word-break: break-all; font-family: &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, SimHei, Arial, SimSun; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"box-sizing: border-box; outline: 0px; word-break: break-all; font-size: 15px;\">二、华为新一代智能云硬件平台Atlas，应该说其充分体现了华为对智能计算的理解，即如何利用好层出不穷的各种计算能力，为业务服务。</span></p><p><span style=\"box-sizing: border-box; outline: 0px; word-break: break-all; font-size: 15px;\"><br/></span></p><p><span style=\"color: rgb(79, 79, 79); font-family: &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, SimHei, Arial, SimSun; font-size: 15px; text-align: justify; background-color: rgb(255, 255, 255);\"><span style=\"color: rgb(79, 79, 79); font-family: &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, SimHei, Arial, SimSun; font-size: 15px; text-align: justify; background-color: rgb(255, 255, 255);\"><br/></span></span><br/></p>', '程序人生', 'Y', 'Y', '2018-06-03', '39');
INSERT INTO `t_publish` VALUES ('c751a183-c69c-4774-aa47-d378a7e9b352', '分布式存储首选，浪潮商用机器FP5466G2服务器测评分析', '如今随着信息时代的到来，以云计算、大数据、人工智能为代表的新晋技术与应用实现了爆发式的增长，随之而来促生了原本存在于各个行业的大量业务应用中PB级，甚至EB级的海量版数据信息，这些数据的存储、管理、分析和挖掘就成为企业级IT运维以及数据管理面临的一大挑战。', '<p><span style=\"margin: 0px; padding: 0px; max-width: 100%; font-family: -apple-system-font, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif; letter-spacing: 0.544px; text-align: justify; widows: 1; background-color: rgb(255, 255, 255); font-size: 15px; color: rgb(73, 73, 73); text-indent: 29.3333px; box-sizing: border-box !important; overflow-wrap: break-word !important;\">近日，</span><strong class=\"\" style=\"margin: 0px; padding: 0px; max-width: 100%; font-family: -apple-system-font, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif; letter-spacing: 0.544px; text-align: justify; white-space: normal; widows: 1; background-color: rgb(255, 255, 255); font-size: 15px; color: rgb(73, 73, 73); text-indent: 29.3333px; box-sizing: border-box !important; overflow-wrap: break-word !important;\">浪潮商用机器推出FP5466G2存储型服务器，</strong><span style=\"margin: 0px; padding: 0px; max-width: 100%; font-family: -apple-system-font, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif; letter-spacing: 0.544px; text-align: justify; widows: 1; background-color: rgb(255, 255, 255); font-size: 15px; color: rgb(73, 73, 73); text-indent: 29.3333px; box-sizing: border-box !important; overflow-wrap: break-word !important;\">号称是“大规模企业级分布式存储的首选平台”的服务器，能够很好的解决企业在数据存处理方面的上述问题，为此，CSDN评测小组对这款服务器产品从存储密度、产品性能、I/O能力、可扩展性、可靠性五大方面进行了详细的评测，以期为读者朋友呈现一个较完整的FP5466G2的全方位介绍，以供读者朋友比较、选择。</span></p><p><span style=\"margin: 0px; padding: 0px; max-width: 100%; font-family: -apple-system-font, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif; letter-spacing: 0.544px; text-align: justify; widows: 1; background-color: rgb(255, 255, 255); font-size: 15px; color: rgb(73, 73, 73); text-indent: 29.3333px; box-sizing: border-box !important; overflow-wrap: break-word !important;\"></span></p><h1 class=\"\" style=\"margin: 0px; padding: 0px; font-weight: 400; font-size: 16px; max-width: 100%; color: rgb(51, 51, 51); font-family: -apple-system-font, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif; letter-spacing: 0.544px; text-align: justify; white-space: normal; widows: 1; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; max-width: 100%; clear: both; min-height: 1em; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><span style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><strong style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important;\">有容乃大 海量存储不用愁</strong></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; max-width: 100%; clear: both; min-height: 1em; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><span style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; color: rgb(73, 73, 73); font-size: 15px; letter-spacing: 0.544px; text-indent: 29.3333px;\"><br/></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; max-width: 100%; clear: both; min-height: 1em; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><span style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; color: rgb(73, 73, 73); font-size: 15px; letter-spacing: 0.544px; text-indent: 29.3333px;\">据国际数据公司(IDC)和数据存储公司希捷开展的一项研究发现，2018年中国约产生7.6ZB(1ZB约相当于1万亿GB)的数据，到2025年该数字将增至48.6ZB。面对如此海量的数据，作为存储主力军的存储服务器首先当然应该在存储密度上做到“有容乃大”了。在这方面，FP5466G2分布式存储型服务器没有让我们失望，它能够在4U空间内支持40块3.5英寸硬盘。如果满配12TB的氦气硬盘，总容量在举手投足间就可高达480TB。这是什么概念？以人手一枚的苹果32G小手机打比方，一台机器就可满足7500人的手机存储需求。</span></p></h1><p><span style=\"margin: 0px; padding: 0px; max-width: 100%; font-family: -apple-system-font, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif; letter-spacing: 0.544px; text-align: justify; widows: 1; background-color: rgb(255, 255, 255); font-size: 15px; color: rgb(73, 73, 73); text-indent: 29.3333px; box-sizing: border-box !important; overflow-wrap: break-word !important;\"></span><br/></p><h1 class=\"\" style=\"margin: 0px; padding: 0px; font-weight: 400; font-size: 16px; max-width: 100%; color: rgb(51, 51, 51); font-family: -apple-system-font, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif; letter-spacing: 0.544px; text-align: justify; white-space: normal; widows: 1; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; max-width: 100%; clear: both; min-height: 1em; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><span style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><strong style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important;\">性能彪悍 “秒杀”x86服务器</strong></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; max-width: 100%; clear: both; min-height: 1em; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><span style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; font-size: 15px; color: rgb(73, 73, 73); text-indent: 29.3333px; letter-spacing: 0.544px;\"><br/></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; max-width: 100%; clear: both; min-height: 1em; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><span style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; font-size: 15px; color: rgb(73, 73, 73); text-indent: 29.3333px; letter-spacing: 0.544px;\">虽然作为存储服务器，存储密度和容量很重要，但如果没有出色的性能，也是白瞎。而FP5466G2则配置了号称“地表最强服务器芯片”的Power9，性能想不彪悍都难！并且，FP5466G2高效结合了Power9多线程超强并发能力，可以达到2倍的线程数量提升，简直可以说是一款存储服务器界的“性能怪兽”。而实际测试的数据也证明了这一点，在高并发的场景中，我们测试出FP5466G2与x86平台相比较，性能可以获得提升70%的提升，说是“秒杀”也丝毫也不为过。</span></p></h1><h1 class=\"\" style=\"margin: 0px; padding: 0px; font-weight: 400; font-size: 16px; max-width: 100%; color: rgb(51, 51, 51); font-family: -apple-system-font, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif; letter-spacing: 0.544px; text-align: justify; white-space: normal; widows: 1; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; max-width: 100%; clear: both; min-height: 1em; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><span style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; font-size: 15px; color: rgb(73, 73, 73); text-indent: 29.3333px; letter-spacing: 0.544px;\">就拿最考验计算性能的AI计算来说吧，通过FP5466G2的助力，在云端人脸识别数据放置等应用场景中，服务器内部的搭建训练模型可做到每50秒读取8000张图片，妥妥帮助企业进行更精准的人脸识别。</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; max-width: 100%; clear: both; min-height: 1em; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><span style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; font-size: 15px; color: rgb(73, 73, 73); text-indent: 29.3333px; letter-spacing: 0.544px;\"><br/></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; max-width: 100%; clear: both; min-height: 1em; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><span style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; font-size: 15px; color: rgb(73, 73, 73); text-indent: 29.3333px; letter-spacing: 0.544px;\">在著名的云存储性能COSBench的性能测试中，我们看到在并发数从1000达到6000时，FP5466G2的写性能不降反升，吞吐量达到了10240.77 op/s。在并发数从50升到1000时，读性能吞吐量达到25177.25 op/s。</span></p></h1><h1 class=\"\" style=\"margin: 0px; padding: 0px; font-weight: 400; font-size: 16px; max-width: 100%; color: rgb(51, 51, 51); font-family: -apple-system-font, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif; letter-spacing: 0.544px; text-align: justify; white-space: normal; widows: 1; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; max-width: 100%; clear: both; min-height: 1em; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><span style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><strong style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important;\">“闪电”I/O 数据处理So Easy</strong></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; max-width: 100%; clear: both; min-height: 1em; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><span style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; font-size: 15px; color: rgb(73, 73, 73); text-indent: 29.3333px; letter-spacing: 0.544px;\"><br/></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; max-width: 100%; clear: both; min-height: 1em; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><span style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; font-size: 15px; color: rgb(73, 73, 73); text-indent: 29.3333px; letter-spacing: 0.544px;\">然而，数据存储和处理，仅仅依靠存储服务器的海量存储和强大“芯”脏仍显不足，如果不能解决I/O的瓶颈问题，也是事倍功半。为了使FP5466G2具有“闪电”般的I/O速度，FP5466G2原生支持PCIe4.0，这意味着FP5466G2相对于配置PCIe 3.0的同款服务器速度要提高一倍，延迟同时降低30%。打个比方来说，一个100G的交换网络，每秒钟需要处理5000张图片，在PCIe3.0配置下的100G网络要想达到这个目标是比较困难的，但在PCIe4.0加持下可以轻松完成此项任务，并将延迟降低了30%。而有消息称，x86可能会在2020年下半年或者2021年初才会羞答答地支持PCIe4.0，这就使得FP5466G2至少领先x86服务器两年！</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; max-width: 100%; clear: both; min-height: 1em; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><span style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; font-size: 15px; color: rgb(73, 73, 73); text-indent: 29.3333px; letter-spacing: 0.544px;\"><br/></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; max-width: 100%; clear: both; min-height: 1em; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><span style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; font-size: 15px; color: rgb(73, 73, 73); text-indent: 29.3333px; letter-spacing: 0.544px;\">另外，FP5466G2还支持CAPI 2.0异构加速计算接口，将使得芯片间接口速度达到惊人的128GB/s ，较上一代提升高达4倍！同时，FP5466G2支持共享PCIe物理接口，直接支持Coherency(内存一致性) ，使加速器瞬间成为POWER CPU核的异构伙伴，不但使得传输速度更快，延迟也得到了显著的降低。</span></p></h1><h1 class=\"\" style=\"margin: 0px; padding: 0px; font-weight: 400; font-size: 16px; max-width: 100%; color: rgb(51, 51, 51); font-family: -apple-system-font, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif; letter-spacing: 0.544px; text-align: justify; white-space: normal; widows: 1; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; max-width: 100%; clear: both; min-height: 1em; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><span style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; font-size: 15px;\">灵活扩展 各类硬盘全通吃。</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; max-width: 100%; clear: both; min-height: 1em; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><span style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; font-size: 15px; color: rgb(73, 73, 73); text-indent: 29.3333px; letter-spacing: 0.544px;\"><br/></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; max-width: 100%; clear: both; min-height: 1em; box-sizing: border-box !important; overflow-wrap: break-word !important;\"><span style=\"margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; overflow-wrap: break-word !important; font-size: 15px; color: rgb(73, 73, 73); text-indent: 29.3333px; letter-spacing: 0.544px;\">为了应对更多海量数据存储的需求，FP5466G2还具有强大的灵活扩展能力，整个40块盘支持所有的硬盘混插模式，从低端的2T容量的硬盘，到14T容量的硬盘，全面通吃。而且它不但支持不同容量的硬盘进行混插，甚至还支持HDD、SSD、AVM不同类型的硬盘的混插。而为了应对温冷存储的问题，FP5466G2还为用户推荐了1块SSD搭配4到5块HDD硬盘的配置，从而能够在保证分层存储的情况下，达到一个最好的读写性能。</span></p></h1><p><br/></p>', '云计算/大数据', 'N', 'Y', '2019-06-14', '3');
INSERT INTO `t_publish` VALUES ('cb4d7f95-b4ba-4a56-89be-653d7063d2e1', 'daddadadff', '以下链接是本人整理的关于计算机视觉（ComputerVision, CV）相关领域的网站链接，其中有CV牛人的主页，CV研究小组的主页，CV领域的paper,代码，CV领域的最新动态，国内的应用情况等等。打算从事 这个行业或者刚入门的朋友可以多关注这些网站，多了解一些CV的具体应用。搞研究的朋友也可以从中了解到很多牛人的研究动态、招生情况等。总之，我认为， 知识只有分享才能产生更大的价值，真诚希望下面的链接能对朋友们有所帮助。', '<p>gadczxc</p>', '研发管理', 'N', 'Y', '2019-05-30', '22');
INSERT INTO `t_publish` VALUES ('d19c369f-9849-4e92-876c-edde553454a2', '大学本科自动化专业的体会—First step', 'fffffffffff', '<p>第一、先说自己为什么会选择自动化专业</p><p><br/></p><p><span style=\"white-space:pre\">	</span>高考结束后自己的超过一本线只有10分，在陕西能够上一个好的一本院校基本是不可能。自己就决定报个普通院校相对能好些的专业方向。通过在我们学校举办的西安各个大学报考咨询会，自己了解到对于工科来说，专业相对比较火的方向是《机械制造及其自动化专业》和《电气工程及其自动化专业》。面对专业的抉择，我没有咨询过相关朋友和父母，因为他们也不懂。最后自己通过数学中的交集公式来决定自己最后的选择。《机械制造及其自动化专业》和《电气工程及其自动化专业》求交集就是自动化专业。</p><p><br/></p><p>第二、大学四年自动化专业带给自己体会</p><p><br/></p><p><span style=\"white-space:pre\">	</span>如预期的目标一样，自己顺利进入自动化专业。和设想的一样大一和大二的课结合了机械和电气相关的知识，《工程制图》、《高等数学》、《三电》相关知识，学科科目很多很杂，涉及到的方面很广。大三就是一些专业课的学习，自己因为准备研究生考试，基本大三的上课就是打伏击过来的。大四面临找工作和上研究生的抉择，自己最后选择了上研究生。</p><p><br/></p><p><span style=\"white-space:pre\">	</span>本科毕业感觉自动化的技术方面毕业方向就是两个：单片机开发和软件开发。</p><p><br/></p><p>第三、对正要选择的自动化朋友的忠告</p><p><br/></p><p><span style=\"white-space:pre\">	</span>大一和大二的生活就是认真学习基础知识（例如：数学类）和做自己喜欢的事培养一个良好的习惯。大一和大二的基础课虽然很多，但是你会过的充实而不是迷茫。大三和大四的重点就要多放在实践方面，学校组织的各种实践性比赛多参加，你既可以获得荣誉也会获得你想不到的好处。不管你本科毕业是读研或者找工作都会有相应的优势。</p><p><br/></p><p>我是一个比较内向的人，所以自己感觉应该走技术这条路线来养活自己。</p><p><br/></p><p>通过博客来充实自己的生活和让自己养成一个好的习惯，自己会将自己做的项目和体会写到博客中作为留念</p><p>---------------------&nbsp;</p><p>作者：Zero Team&nbsp;</p><p>来源：CSDN&nbsp;</p><p>原文：https://blog.csdn.net/weixin_37344017/article/details/88253343&nbsp;</p><p>版权声明：本文为博主原创文章，转载请附上博文链接！</p><p><br/></p>', '程序人生', 'N', 'N', '2019-03-15', '33');
INSERT INTO `t_publish` VALUES ('d3b15fb9-9aa2-4675-96fd-c4d693b0436f', 'aaaaa那些只有程序员才能看懂的冷笑话，用餐时间请勿点开。。。', 'b', '<p>adadadad</p>', '人工智能', 'Y', 'Y', '2019-06-04', '20');
INSERT INTO `t_publish` VALUES ('f8b0f9f1-fbb0-4392-ba8f-1ec5bdca22a0', '【转发】计算机视觉领域一些牛人博客', '以下链接是本人整理的关于计算机视觉（ComputerVision, CV）相关领域的网站链接，其中有CV牛人的主页，CV研究小组的主页，CV领域的paper,代码，CV领域的最新动态，国内的应用情况等等。打算从事 这个行业或者刚入门的朋友可以多关注这些网站，多了解一些CV的具体应用。搞研究的朋友也可以从中了解到很多牛人的研究动态、招生情况等。总之，我认为， 知识只有分享才能产生更大的价值，真诚希望下面的链接能对朋友们有所帮助。', '<p>fadawd ac<br/></p>', '计算机基础', 'N', 'Y', '2019-05-30', '39');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userId` varchar(200) NOT NULL,
  `InfoId` varchar(200) DEFAULT NULL,
  `username` varchar(200) NOT NULL,
  `password` varchar(200) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `isSuper` varchar(200) DEFAULT '0',
  PRIMARY KEY (`userId`),
  KEY `FK_Reference_1` (`InfoId`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`InfoId`) REFERENCES `t_user_info` (`InfoId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('07f0b91e-67b0-4965-9ca0-3d3d661f80a2', 'a53be75b-fef0-43c3-9757-3a196826291d', 'jjjj', '123', '2019-06-14', '0');
INSERT INTO `t_user` VALUES ('1dadadg', '1', 'admin', '1234', '2018-12-21', '0');
INSERT INTO `t_user` VALUES ('2daawd', '2', 'aaa', '123', '2019-05-28', '0');
INSERT INTO `t_user` VALUES ('5945b36d-20cb-46f7-84f4-6465891bfa31', '009366f0-46ec-4c96-838d-28b8f9eb7696', 'ccc', '1234', '2019-06-03', '0');
INSERT INTO `t_user` VALUES ('7d341b0b-b5be-43eb-9a44-6a758f09230e', 'c24363b1-4b42-4fb3-897d-4ada78cec0f7', 'heroIno', '1234', '2019-07-03', '0');
INSERT INTO `t_user` VALUES ('dadf783f-2505-40f1-aa76-3444936f615e', '0a8d2469-04e9-4433-adb2-6d6e554b2d66', 'aaaa', '123', '2019-05-04', '0');
INSERT INTO `t_user` VALUES ('f395d515-f7fc-47cf-ac4f-91646777a57d', 'bc906dd8-100e-4bfe-b46c-e8b3f5330973', 'bbb', '12345', '2019-03-29', '0');

-- ----------------------------
-- Table structure for t_usermessage
-- ----------------------------
DROP TABLE IF EXISTS `t_usermessage`;
CREATE TABLE `t_usermessage` (
  `messageId` varchar(200) NOT NULL,
  `userId` varchar(200) DEFAULT NULL,
  `draftboxId` varchar(200) DEFAULT NULL,
  `releaseId` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`messageId`),
  KEY `FK_Reference_4` (`userId`),
  KEY `FK_Reference_5` (`draftboxId`),
  KEY `FK_Reference_6` (`releaseId`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`userId`) REFERENCES `t_user` (`userId`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`draftboxId`) REFERENCES `t_draftbox` (`draftboxId`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`releaseId`) REFERENCES `t_publish` (`releaseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_usermessage
-- ----------------------------
INSERT INTO `t_usermessage` VALUES ('0dcdee99-f60a-41ce-9614-7645afb15cbd', 'f395d515-f7fc-47cf-ac4f-91646777a57d', null, 'c4ced6a5-e601-4991-8bae-d2ce102d7c5a');
INSERT INTO `t_usermessage` VALUES ('2d907d9e-c09c-4417-9e7e-e4f8ebe86bb7', '5945b36d-20cb-46f7-84f4-6465891bfa31', null, '575390f2-b814-422e-8393-a739acab67e7');
INSERT INTO `t_usermessage` VALUES ('3cbad077-96e1-4833-a701-525789608226', '5945b36d-20cb-46f7-84f4-6465891bfa31', null, '64166480-b826-4eb4-818f-d4adb6b2c990');
INSERT INTO `t_usermessage` VALUES ('4df2e144-cfd4-43c6-9ae6-ceb0b1354fb4', '1dadadg', null, 'a8cfbcff-1bc7-4421-ab97-5266b10cb93d');
INSERT INTO `t_usermessage` VALUES ('586143fe-5532-49e1-9142-6267557776a1', '1dadadg', null, '15682d9c-a02f-4ab5-9764-2a928e58f2a6');
INSERT INTO `t_usermessage` VALUES ('620541f2-4a6b-47b7-9dde-c0047b23b19c', '1dadadg', '165be63a-de36-413b-b124-a08d5e6688b2', null);
INSERT INTO `t_usermessage` VALUES ('632ac93d-1642-4131-b51a-e8d0f75e7124', '1dadadg', '6fb5342a-9a55-4194-b610-3fd931b01805', null);
INSERT INTO `t_usermessage` VALUES ('6756ee3f-90a0-4928-aab0-dbcabc47a3cc', '2daawd', '97eb7f3e-a67d-4bce-96e0-4a8c7620d4cc', null);
INSERT INTO `t_usermessage` VALUES ('70b1314e-a2ca-4dfa-a1f4-e9dfe852c7b8', '1dadadg', null, 'd3b15fb9-9aa2-4675-96fd-c4d693b0436f');
INSERT INTO `t_usermessage` VALUES ('85dd1562-f2fa-44af-8cbc-5a9d1fba8830', '2daawd', null, 'f8b0f9f1-fbb0-4392-ba8f-1ec5bdca22a0');
INSERT INTO `t_usermessage` VALUES ('ad2df842-a17e-4897-84c4-6d06c4e495d6', '5945b36d-20cb-46f7-84f4-6465891bfa31', null, '658b58d7-07e2-45bb-97ac-8f9b4f0b9ca3');
INSERT INTO `t_usermessage` VALUES ('b2177853-261c-4fac-b0ef-e6b3a83073ee', '7d341b0b-b5be-43eb-9a44-6a758f09230e', null, 'd19c369f-9849-4e92-876c-edde553454a2');
INSERT INTO `t_usermessage` VALUES ('d38ef102-f4b5-4cd2-96d9-fa7074fb9f53', 'f395d515-f7fc-47cf-ac4f-91646777a57d', null, '47bd0032-7799-40fa-bdd9-c637aa37d6d9');
INSERT INTO `t_usermessage` VALUES ('db86457b-853c-42f6-bfbf-3f062f58e924', '5945b36d-20cb-46f7-84f4-6465891bfa31', null, 'c751a183-c69c-4774-aa47-d378a7e9b352');
INSERT INTO `t_usermessage` VALUES ('eb93e512-25a4-4b44-8236-822aec33d6f0', '2daawd', null, 'cb4d7f95-b4ba-4a56-89be-653d7063d2e1');

-- ----------------------------
-- Table structure for t_user_img
-- ----------------------------
DROP TABLE IF EXISTS `t_user_img`;
CREATE TABLE `t_user_img` (
  `userImgId` varchar(200) NOT NULL,
  `userId` varchar(200) DEFAULT NULL,
  `imgId` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`userImgId`),
  KEY `FK_Reference_2` (`userId`),
  KEY `FK_Reference_3` (`imgId`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`userId`) REFERENCES `t_user` (`userId`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`imgId`) REFERENCES `t_imgurl` (`imgId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_img
-- ----------------------------
INSERT INTO `t_user_img` VALUES ('0918fdc8-3eca-42b5-81ef-bd3206d50c9d', '1dadadg', '259231a9-6a11-4e91-addf-1fa43a89a4b3');
INSERT INTO `t_user_img` VALUES ('1bd957c3-eb71-40ae-8787-f852d74ae408', '2daawd', '5ed24c26-af55-4081-9df8-d33fb40a4dd2');
INSERT INTO `t_user_img` VALUES ('64f9f8ac-744f-4b99-aad7-848e8d8dbeb7', '2daawd', '1f6f4a0a-71ac-4de2-acac-5970c83824b2');
INSERT INTO `t_user_img` VALUES ('6b726d10-e590-4f4a-8e12-dedfad4bbb23', '1dadadg', 'fa992c07-5c5d-4693-b015-a64aebc566e0');
INSERT INTO `t_user_img` VALUES ('6d77dc7c-37e0-4f68-8014-40a8be92f285', '1dadadg', 'dc2366f7-d05d-4e61-bbe8-2984afe1b752');
INSERT INTO `t_user_img` VALUES ('7d2bedc8-60f6-4dda-aef7-69f2a113d0e3', '1dadadg', '7263b5d3-82bb-44fc-8c26-a1ff6fcfd682');
INSERT INTO `t_user_img` VALUES ('85982455-13cd-4281-ac6c-fd583f7ab420', '5945b36d-20cb-46f7-84f4-6465891bfa31', '70f8ab73-0d33-4ede-ac61-c3ba9b888a3f');
INSERT INTO `t_user_img` VALUES ('8790add1-b7c6-455c-9d3e-ff8877ca6d82', '1dadadg', 'b7162b9e-168f-4b83-8f24-ca839bc8614d');
INSERT INTO `t_user_img` VALUES ('945e6f20-7620-457d-8303-682565b24a91', '1dadadg', 'c95042a0-56ea-4b89-a3b1-62ed3066bb8b');
INSERT INTO `t_user_img` VALUES ('aab4ff56-0289-4f19-9f87-f5c3a709e60b', '1dadadg', 'f03e19e7-3fee-46a9-aab2-f9f3e164ecf0');
INSERT INTO `t_user_img` VALUES ('b4b191ba-15f0-4a9d-8157-5a6d650f08ea', '1dadadg', '71159c80-97eb-428d-81ce-d201f442de75');
INSERT INTO `t_user_img` VALUES ('be089bbd-f8ab-4d5e-a65c-6f539187f94b', '1dadadg', '50cf8c37-aa5f-4a95-a22e-1d7f9512dd79');
INSERT INTO `t_user_img` VALUES ('c7ec043c-1bbf-4bfd-8da5-ce04f4d47cc5', '1dadadg', '30e645bd-1c83-46ce-9581-e9b0d578e7a1');
INSERT INTO `t_user_img` VALUES ('cc02160b-f8ec-4f78-8120-247b01e2def9', '2daawd', '84c28e11-008d-4728-87f4-5e9a8053795d');

-- ----------------------------
-- Table structure for t_user_info
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info` (
  `InfoId` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `sex` char(1) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(200) NOT NULL,
  `telephone` varchar(200) NOT NULL,
  `introduce` varchar(200) DEFAULT NULL,
  `imgId` varchar(200) DEFAULT NULL,
  `bloodType` varchar(255) DEFAULT NULL COMMENT '血型',
  PRIMARY KEY (`InfoId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_info
-- ----------------------------
INSERT INTO `t_user_info` VALUES ('009366f0-46ec-4c96-838d-28b8f9eb7696', '周一啊', '男', '2019-04-17', '1434474927@qq.com', '13625484348', 'gdadadadasxcz', '70f8ab73-0d33-4ede-ac61-c3ba9b888a3f', 'A');
INSERT INTO `t_user_info` VALUES ('0a8d2469-04e9-4433-adb2-6d6e554b2d66', '无心', '女', '2019-06-11', '1434474927@qq.com', '13625484348', '我是一个大帅逼', null, 'C');
INSERT INTO `t_user_info` VALUES ('1', '李易峰DAD', '男', '2019-06-14', '1434474927@qq.com', '12345678', '本人性格热情开朗，待人友好，为人诚实谦虚。工作勤奋，认真负责，能吃苦耐劳，尽职尽责，有耐心。具有亲和力，平易近人，善于与人沟通。 \r\n学习刻苦认真，成绩优秀。积极参加课外文体活动，各种社会实践活动和兼职工作等，以增加自己的阅历，提高自己的能力。在工作中体会办事方式，锻炼口才和人际交往能力。', 'fa992c07-5c5d-4693-b015-a64aebc566e0', 'O');
INSERT INTO `t_user_info` VALUES ('2', '周杰伦', '男', '2019-03-14', '123ad', '212314', '本人性格热情开朗，待人友好，为人诚实谦虚。工作勤奋，认真负责，能吃苦耐劳，尽职尽责，有耐心。具有亲和力，平易近人，善于与人沟通。 \r\n学习刻苦认真，成绩优秀。积极参加课外文体活动，各种社会实践活动和兼职工作等，以增加自己的阅历，提高自己的能力。在工作中体会办事方式，锻炼口才和人际交往能力。', '84c28e11-008d-4728-87f4-5e9a8053795d', 'B');
INSERT INTO `t_user_info` VALUES ('a53be75b-fef0-43c3-9757-3a196826291d', '决', null, null, '1434474927@qq.com', '13625484348', null, null, null);
INSERT INTO `t_user_info` VALUES ('bc906dd8-100e-4bfe-b46c-e8b3f5330973', '刘德华', '男', '2019-01-21', '1434474927@qq.com', '13625484348', '我是一个大帅逼', '62d06624-b2e6-47e2-a3f0-1df25b27dd4e', 'AB');
INSERT INTO `t_user_info` VALUES ('c24363b1-4b42-4fb3-897d-4ada78cec0f7', '蔡永强', '男', '2019-05-30', '1434474927@qq.com', '13625484348', '我是一个大帅逼', null, 'O');

-- ----------------------------
-- Table structure for t_user_interesting
-- ----------------------------
DROP TABLE IF EXISTS `t_user_interesting`;
CREATE TABLE `t_user_interesting` (
  `interestingId` varchar(255) NOT NULL,
  `userId` varchar(255) NOT NULL,
  `interestingOne` varchar(255) DEFAULT NULL,
  `interestingTwo` varchar(255) DEFAULT NULL,
  `interestingThree` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`interestingId`,`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_interesting
-- ----------------------------
INSERT INTO `t_user_interesting` VALUES ('3eed494c-ff5d-42de-aa8c-6b89e925664f', '7d341b0b-b5be-43eb-9a44-6a758f09230e', '人工智能', '程序人生', '编程语言');
INSERT INTO `t_user_interesting` VALUES ('4c779eca-bbcd-46a4-b522-e1fdee428f6d', '2daawd', '人工智能', '程序人生', '运维');
INSERT INTO `t_user_interesting` VALUES ('5357e9eb-12fd-42c4-a911-23406f3bff36', 'dadf783f-2505-40f1-aa76-3444936f615e', '人工智能', '程序人生', '编程语言');
INSERT INTO `t_user_interesting` VALUES ('5dafc4f9-ea29-4896-bbef-9d9da3056ab0', '1dadadg', '人工智能', '程序人生', '研发管理');
INSERT INTO `t_user_interesting` VALUES ('7411b815-ff59-46c1-b8d1-bf6a0fed5486', '5945b36d-20cb-46f7-84f4-6465891bfa31', '人工智能', '程序人生', '编程语言');
INSERT INTO `t_user_interesting` VALUES ('895114d9-1d71-4fb9-93dd-dbab3ff4b895', 'f395d515-f7fc-47cf-ac4f-91646777a57d', '人工智能', '程序人生', '编程语言');

-- ----------------------------
-- Table structure for t_user_operation
-- ----------------------------
DROP TABLE IF EXISTS `t_user_operation`;
CREATE TABLE `t_user_operation` (
  `userId` varchar(255) NOT NULL,
  `upTime` datetime DEFAULT NULL,
  `operName` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_operation
-- ----------------------------
INSERT INTO `t_user_operation` VALUES ('13', '2012-01-21 00:00:00', 'dfada', '3adad');
INSERT INTO `t_user_operation` VALUES ('1dadadg', '2019-04-02 22:05:51', '文本操作', '发布文章');
INSERT INTO `t_user_operation` VALUES ('1dadadg', '2019-05-04 10:18:14', '文本操作', '发布文章');
INSERT INTO `t_user_operation` VALUES ('1dadadg', '2019-05-19 17:03:11', '文本操作', '删除文章:d45cd325-9aa0-4cb6-80d5-b0468f1421c6');
INSERT INTO `t_user_operation` VALUES ('1dadadg', '2019-05-19 17:09:18', '文本操作', '发布文章');
INSERT INTO `t_user_operation` VALUES ('1dadadg', '2019-05-19 17:09:49', '文本操作', '删除文章:df865c67-7104-4880-b223-0f00735de46f');
INSERT INTO `t_user_operation` VALUES ('1dadadg', '2019-05-19 17:13:02', '文本操作', '删除文章:a5f799c8-e421-481a-9d64-1fef89158cec');
INSERT INTO `t_user_operation` VALUES ('1dadadg', '2019-05-19 17:29:05', '文本操作', '发布文章');
INSERT INTO `t_user_operation` VALUES ('1dadadg', '2019-05-27 21:48:37', '文本操作', '删除文章:5a246753-3b04-4451-b639-d7f22982d02e');
INSERT INTO `t_user_operation` VALUES ('1dadadg', '2019-05-27 21:49:04', '文本操作', '修改已发布文章：aaaaa那些只有程序员才能看懂的冷笑话，用餐时间请勿点开。。。');
INSERT INTO `t_user_operation` VALUES ('1dadadg', '2019-05-27 21:49:07', '文本操作', '修改已发布文章：daddadadff');
INSERT INTO `t_user_operation` VALUES ('1dadadg', '2019-05-27 21:49:12', '文本操作', '修改已发布文章：论做游戏外挂，Python输过谁？');
INSERT INTO `t_user_operation` VALUES ('1dadadg', '2019-05-27 21:49:35', '文本操作', '修改已发布文章：daddadadff');
INSERT INTO `t_user_operation` VALUES ('1dadadg', '2019-05-29 10:00:50', '文本操作', '修改已发布文章：论做游戏外挂，Python输过谁？');
INSERT INTO `t_user_operation` VALUES ('2daawd', '2019-05-30 14:40:36', '文本操作', '修改已发布文章：【转发】计算机视觉领域一些牛人博客');
INSERT INTO `t_user_operation` VALUES ('2daawd', '2019-05-30 14:40:37', '文本操作', '发布文章');
INSERT INTO `t_user_operation` VALUES ('2daawd', '2019-05-30 14:44:48', '文本操作', '修改已发布文章：daddadadff');
INSERT INTO `t_user_operation` VALUES ('2daawd', '2019-05-30 14:44:50', '文本操作', '发布文章');
INSERT INTO `t_user_operation` VALUES ('2daawd', '2019-05-30 14:44:53', '文本操作', '修改已发布文章：daddadadff');
INSERT INTO `t_user_operation` VALUES ('2daawd', '2019-05-30 14:44:54', '文本操作', '发布文章');
INSERT INTO `t_user_operation` VALUES ('2daawd', '2019-05-30 14:44:57', '文本操作', '修改已发布文章：【转发】计算机视觉领域一些牛人博客');
INSERT INTO `t_user_operation` VALUES ('2daawd', '2019-05-30 14:44:59', '文本操作', '发布文章');
INSERT INTO `t_user_operation` VALUES ('1dadadg', '2019-06-04 17:45:55', '文本操作', '修改已发布文章：aaaaa那些只有程序员才能看懂的冷笑话，用餐时间请勿点开。。。');
INSERT INTO `t_user_operation` VALUES ('1dadadg', '2019-06-04 17:46:02', '文本操作', '发布文章');
INSERT INTO `t_user_operation` VALUES ('1dadadg', '2019-06-04 17:46:21', '文本操作', '修改已发布文章：aaaaa那些只有程序员才能看懂的冷笑话，用餐时间请勿点开。。。');
INSERT INTO `t_user_operation` VALUES ('2daawd', '2019-06-14 17:04:26', '文本操作', '发布文章');
INSERT INTO `t_user_operation` VALUES ('2daawd', '2019-06-14 17:04:32', '文本操作', '修改已发布文章：dad');
INSERT INTO `t_user_operation` VALUES ('2daawd', '2019-06-14 17:04:37', '文本操作', '存入草稿');
INSERT INTO `t_user_operation` VALUES ('f395d515-f7fc-47cf-ac4f-91646777a57d', '2019-06-14 20:07:45', '文本操作', '修改已发布文章：华为，将智能计算进行到底');
INSERT INTO `t_user_operation` VALUES ('f395d515-f7fc-47cf-ac4f-91646777a57d', '2019-06-14 20:16:02', '文本操作', '修改已发布文章：华为，将智能计算进行到底');
INSERT INTO `t_user_operation` VALUES ('f395d515-f7fc-47cf-ac4f-91646777a57d', '2019-06-14 20:16:04', '文本操作', '修改已发布文章：【转发】计算机视觉领域一些牛人博客');
INSERT INTO `t_user_operation` VALUES ('f395d515-f7fc-47cf-ac4f-91646777a57d', '2019-06-14 20:17:30', '文本操作', '发布文章');
INSERT INTO `t_user_operation` VALUES ('5945b36d-20cb-46f7-84f4-6465891bfa31', '2019-06-14 20:30:10', '文本操作', '修改已发布文章：在VMware Workstation Pro中实现kali的安装与基本配置');
INSERT INTO `t_user_operation` VALUES ('5945b36d-20cb-46f7-84f4-6465891bfa31', '2019-06-14 20:34:53', '文本操作', '发布文章');
INSERT INTO `t_user_operation` VALUES ('5945b36d-20cb-46f7-84f4-6465891bfa31', '2019-06-14 20:36:44', '用户操作', '修改个人资料');
INSERT INTO `t_user_operation` VALUES ('5945b36d-20cb-46f7-84f4-6465891bfa31', '2019-06-14 21:29:00', '文本操作', '发布文章');
INSERT INTO `t_user_operation` VALUES ('5945b36d-20cb-46f7-84f4-6465891bfa31', '2019-06-14 21:30:04', '文本操作', '发布文章');
INSERT INTO `t_user_operation` VALUES ('5945b36d-20cb-46f7-84f4-6465891bfa31', '2019-06-14 21:32:02', '文本操作', '发布文章');
INSERT INTO `t_user_operation` VALUES ('1dadadg', '2019-06-14 21:33:45', '文本操作', '发布文章');
INSERT INTO `t_user_operation` VALUES ('1dadadg', '2019-06-15 08:38:49', '文本操作', '发布文章');
INSERT INTO `t_user_operation` VALUES ('1dadadg', '2019-06-15 08:38:55', '文本操作', '修改已发布文章：aa');
INSERT INTO `t_user_operation` VALUES ('1dadadg', '2019-06-15 08:38:59', '文本操作', '发布文章');
INSERT INTO `t_user_operation` VALUES ('1dadadg', '2019-06-15 08:39:06', '文本操作', '删除文章:fbab10a1-6ba9-44f9-ab38-514b92cb71f7');
INSERT INTO `t_user_operation` VALUES ('1dadadg', '2019-06-15 08:58:18', '文本操作', '发布文章');
INSERT INTO `t_user_operation` VALUES ('1dadadg', '2019-06-15 08:58:25', '文本操作', '修改已发布文章：daddadadff');
INSERT INTO `t_user_operation` VALUES ('1dadadg', '2019-06-15 08:58:27', '文本操作', '发布文章');
INSERT INTO `t_user_operation` VALUES ('1dadadg', '2019-06-15 08:58:32', '文本操作', '删除文章:f26055d8-58ad-4a8c-b5ca-7be15862700c');
INSERT INTO `t_user_operation` VALUES ('1dadadg', '2019-06-15 08:58:45', '用户操作', '修改个人资料');

-- ----------------------------
-- View structure for v_draftinfo
-- ----------------------------
DROP VIEW IF EXISTS `v_draftinfo`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_draftinfo` AS select `a`.`username` AS `username`,`c`.`title` AS `title`,`c`.`type` AS `type`,`c`.`introduce` AS `introduce`,`c`.`draftDate` AS `draftDate`,`c`.`discuss` AS `discuss`,`c`.`homePage` AS `homePage` from ((`t_user` `a` join `t_usermessage` `b`) join `t_draftbox` `c`) where ((`b`.`userId` = `a`.`userId`) and (`b`.`draftboxId` = `c`.`draftboxId`)) ;

-- ----------------------------
-- View structure for v_lastnewmeg
-- ----------------------------
DROP VIEW IF EXISTS `v_lastnewmeg`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_lastnewmeg` AS select `a`.`username` AS `username`,`c`.`title` AS `title`,`c`.`type` AS `type`,`c`.`introduce` AS `introduce`,`c`.`ReleaseDate` AS `ReleaseDate`,`c`.`discuss` AS `discuss`,`c`.`homePage` AS `homePage`,`b`.`messageId` AS `messageId`,`c`.`txt` AS `txt`,`c`.`readNum` AS `readNum` from ((`t_user` `a` join `t_usermessage` `b`) join `t_publish` `c`) where ((`b`.`userId` = `a`.`userId`) and (`b`.`releaseId` = `c`.`releaseId`)) order by `c`.`ReleaseDate` desc ;

-- ----------------------------
-- View structure for v_releaseinfo
-- ----------------------------
DROP VIEW IF EXISTS `v_releaseinfo`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_releaseinfo` AS select `a`.`username` AS `username`,`c`.`title` AS `title`,`c`.`type` AS `type`,`c`.`introduce` AS `introduce`,`c`.`ReleaseDate` AS `ReleaseDate`,`c`.`discuss` AS `discuss`,`c`.`homePage` AS `homePage`,`b`.`messageId` AS `messageId`,`c`.`txt` AS `txt`,`c`.`readNum` AS `readNum` from ((`t_user` `a` join `t_usermessage` `b`) join `t_publish` `c`) where ((`b`.`userId` = `a`.`userId`) and (`b`.`releaseId` = `c`.`releaseId`)) ;

-- ----------------------------
-- View structure for v_tuijian
-- ----------------------------
DROP VIEW IF EXISTS `v_tuijian`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_tuijian` AS select `a`.`username` AS `username`,`c`.`title` AS `title`,`c`.`type` AS `type`,`c`.`introduce` AS `introduce`,`c`.`ReleaseDate` AS `ReleaseDate`,`c`.`discuss` AS `discuss`,`c`.`homePage` AS `homePage`,`b`.`messageId` AS `messageId`,`c`.`txt` AS `txt`,`c`.`readNum` AS `readNum` from ((`t_user` `a` join `t_usermessage` `b`) join `t_publish` `c`) where ((`b`.`userId` = `a`.`userId`) and (`b`.`releaseId` = `c`.`releaseId`)) order by `c`.`readNum` desc ;
DROP TRIGGER IF EXISTS `megUnioPublish`;
DELIMITER ;;
CREATE TRIGGER `megUnioPublish` AFTER DELETE ON `t_usermessage` FOR EACH ROW BEGIN 
	SET @ReleaseID = OLD.releaseId;
	SET @DraftboxID = OLD.draftboxId;
		DELETE FROM t_publish WHERE releaseId = @ReleaseID;
		DELETE FROM t_draftbox WHERE draftboxId = @DraftboxID;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `userimgUNIONimgurl`;
DELIMITER ;;
CREATE TRIGGER `userimgUNIONimgurl` AFTER DELETE ON `t_user_img` FOR EACH ROW BEGIN 
		DELETE from t_imgurl WHERE imgId = OLD.imgId;
END
;;
DELIMITER ;
