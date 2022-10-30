create database micro_db;
use micro_db;

CREATE TABLE user(
	id bigint(20) NOT NULL auto_increment,
    hp int NULL DEFAULT NULL,
    stamina int DEFAULT NULL,
    atk int DEFAULT NULL,
    def int DEFAULT NULL,
    agi int DEFAULT NULL,
    primary key(id)
);

DELIMITER $$
	CREATE PROCEDURE generate_data()
    BEGIN 
		DECLARE i INT DEFAULT 0;
        WHILE (i < 100) DO 
			INSERT INTO user (hp, stamina, atk, def, agi) VALUES
            (i, i, i, i, i);
            SET i = i + 1;
		END WHILE;
	END$$
DELIMITER ;

CALL generate_data();

SELECT * from micro_db.user;

CREATE TABLE IF NOT EXISTS `todo_db`.`todo` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NULL DEFAULT NULL,
  `detail` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

select current_user();