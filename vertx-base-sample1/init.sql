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