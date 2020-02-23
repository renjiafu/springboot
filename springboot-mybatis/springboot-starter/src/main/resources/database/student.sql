CREATE TABLE `mybatis`.`student` (
     `stu_id` INT NOT NULL AUTO_INCREMENT,
     `stu_name` VARCHAR(45) NULL,
     `password` VARCHAR(45) NULL,
     `birthday` DATETIME NULL,
     `cls_id` INT NULL,
     PRIMARY KEY (`stu_id`))
    COMMENT = '学生表';
