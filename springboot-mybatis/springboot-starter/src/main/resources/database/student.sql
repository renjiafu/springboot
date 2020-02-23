CREATE TABLE `mybatis`.`student` (
  `sid` INT NOT NULL AUTO_INCREMENT,
  `sname` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `grade` INT NULL,
  `cls_id` INT NULL,
  PRIMARY KEY (`sid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '学生表';