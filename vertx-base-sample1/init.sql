CREATE TABLE `t_wxchannel`
(
  `wxappID`     VARCHAR(50) NOT NULL,
  `channelID`   int(11)     NOT NULL DEFAULT 1,
  `wxsecret`    varchar(50),
  `barCodeURL`  varchar(50),
  `information` text,
  `insertUser`  int(11)              DEFAULT NULL,
  `insertTime`  datetime             DEFAULT NULL,
  `updateUser`  int(11)              DEFAULT NULL,
  `updateTime`  datetime             DEFAULT NULL,
  PRIMARY KEY (`wxappID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `t_wxchannel` (`wxappID`, `channelID`, `wxsecret`, `barCodeURL`, `information`, `insertUser`, `insertTime`, `updateUser`, `updateTime`)
VALUES ('testAppId', '1', 'testSecret', NULL, NULL, -1, sysdate(), -1, sysdate());

CREATE TABLE IF NOT EXISTS `t_wxuser` (
                                        `wxappID` varchar(50) NOT NULL,
                                        `openID` varchar(50) NOT NULL,
                                        `clientID` int(11) DEFAULT NULL,
                                        `channelID` int(11) NOT NULL DEFAULT '1',
                                        `unionid` varchar(64) DEFAULT NULL,
                                        `phoneNum` varchar(11) DEFAULT NULL,
                                        `information` text,
                                        `sessionKey` varchar(128) DEFAULT NULL,
                                        `token` text,
                                        `tokenStartTime` datetime DEFAULT NULL,
                                        `insertUser` int(11) DEFAULT NULL,
                                        `insertTime` datetime DEFAULT NULL,
                                        `updateUser` int(11) DEFAULT NULL,
                                        `updateTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `t_wxuser`
--

INSERT INTO `t_wxuser` (`wxappID`, `openID`, `clientID`, `channelID`, `unionid`, `phoneNum`, `information`, `sessionKey`, `token`, `tokenStartTime`, `insertUser`, `insertTime`, `updateUser`, `updateTime`) VALUES
('testAppId', 'olfyl5KAogFXzRlNAY-ayIGUQbOQ', 0, 15, 'o7LNJ6FGuS2Yue2sVacfDalfAPSQ', '15656543573', NULL, 'TqOGcC/AcpzxqiFoxWIHRw==', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJvbGZ5bDVLQW9nRlh6UmxOQVktYXlJR1VRYk9RIiwiYXBwaWQiOiJ3eDlmMWFkYWU0NDU4MGMwY2MiLCJleHAiOjE1NTYwMjMxNDV9.B3yiF7wztayQsyoUXCR-_Ulg6GOr5cwuRbymVk1iJ62MkuIpF7v1LtwPYXsr7dC4wUIFpS6GNI4zkQw-qQWgiw', '2019-04-23 06:39:05', -1, '2019-03-22 23:26:48', -1, '2019-04-23 19:39:06'),
('testAppId', 'of0C15Al6In9Rb68u7Db9YT3kU_Q', 0, 1, NULL, NULL, NULL, 'z87NaLZOhGTSkRoIe9KVoQ==', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJvZjBDMTVBbDZJbjlSYjY4dTdEYjlZVDNrVV9RIiwiYXBwaWQiOiJ3eGE1MDNiMDBiNDUzMjQyZmEiLCJleHAiOjE1NTk1NDIyNzN9.8_QyRn5NBXS-x8Pfcp2Z_5McIAghEEB4-3F-OMiXGfxFMekVxt0WELB34UTt3XG1aCJEPMAaP3lNdG_YlUZqYg', '2019-06-03 00:11:13', -1, '2019-06-03 13:11:13', -1, '2019-06-03 13:11:13');
