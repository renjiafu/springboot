CREATE TABLE `student` (
  `stu_id` int NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `stu_age` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`stu_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='学生表';
