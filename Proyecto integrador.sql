DROP TABLE IF EXISTS auth_user_role;
DROP TABLE IF EXISTS auth_role;
DROP TABLE IF EXISTS auth_user;

CREATE TABLE auth_role (
  auth_role_id int(11) NOT NULL AUTO_INCREMENT,
  role_name varchar(255) DEFAULT NULL,
  role_desc varchar(255) DEFAULT NULL,
  PRIMARY KEY (auth_role_id)
);
INSERT INTO auth_role VALUES (1,'SUPER_USER','This user has ultimate rights for everything');
INSERT INTO auth_role VALUES (2,'ADMIN_USER','This user has admin rights for administrative work');
INSERT INTO auth_role VALUES (3,'SITE_USER','This user has access to site, after login - normal user');

CREATE TABLE auth_user (
  auth_user_id int(11) NOT NULL AUTO_INCREMENT,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  status varchar(255),
  PRIMARY KEY (auth_user_id)
);

CREATE TABLE auth_user_role (
  auth_user_id int(11) NOT NULL,
  auth_role_id int(11) NOT NULL,
  PRIMARY KEY (auth_user_id,auth_role_id),
  KEY FK_user_role (auth_role_id),
  CONSTRAINT FK_auth_user FOREIGN KEY (auth_user_id) REFERENCES auth_user (auth_user_id),
  CONSTRAINT FK_auth_user_role FOREIGN KEY (auth_role_id) REFERENCES auth_role (auth_role_id)
) ;

CREATE TABLE `order_table` (
  `order_id` INT NOT NULL,
  `drink_table_drink_id` INT NOT NULL,
  `food_table_food_id` INT NOT NULL,
  `auth_user_auth_user_id` INT NOT NULL,
  `number_of_table` INT NOT NULL,
  `count_food` INT NOT NULL,
  `count_drink` INT NOT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `fk_order_table_drink_table_idx` (`drink_table_drink_id` ASC),
  INDEX `fk_order_table_food_table1_idx` (`food_table_food_id` ASC),
  INDEX `fk_order_table_auth_user1_idx` (`auth_user_auth_user_id` ASC),
  CONSTRAINT `fk_order_table_drink_table`
    FOREIGN KEY (`drink_table_drink_id`)
    REFERENCES `drink_table` (`drink_id`)
	 ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_table_food_table1`
    FOREIGN KEY (`food_table_food_id`)
    REFERENCES `food_table` (`food_id`)
	 ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_table_auth_user1`
    FOREIGN KEY (`auth_user_auth_user_id`)
    REFERENCES `auth_user` (`auth_user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE food_table(
	food_id INT PRIMARY KEY AUTO_INCREMENT,
	food_name VARCHAR (50) NOT NULL,
	food_cost VARCHAR (50) NOT NULL,
	food_descripcion VARCHAR (250) NOT NULL,
	food_image MEDIUMBLOB NOT NULL);

CREATE TABLE drink_table(
	drink_id INT PRIMARY KEY AUTO_INCREMENT,
	drink_name VARCHAR (50) NOT NULL,
	drink_size VARCHAR (10) NOT NULL,
	drink_cost VARCHAR (10) NOT NULL,
	drink_image MEDIUMBLOB NOT NULL);

insert into auth_user (auth_user_id,first_name,last_name,email,password,status) values (1,'Diego','Anchillo','admin@gmail.com','$2a$10$DD/FQ0hTIprg3fGarZl1reK1f7tzgM4RuFKjAKyun0Si60w6g3v5i','VERIFIED');
insert into auth_user (auth_user_id,first_name,last_name,email,password,status) values (2,'Pedro','Martin','chef_1@gmail.com','$2a$10$t3YEpfib6Sm4oXhdTCH17.A81J7F.LJRZtTFXoEOuM6v.F/gqAnoq','VERIFIED');
insert into auth_user (auth_user_id,first_name,last_name,email,password,status) values (3,'Ana','Celeste','chef_2@gmail.com','$2a$10$t3YEpfib6Sm4oXhdTCH17.A81J7F.LJRZtTFXoEOuM6v.F/gqAnoq','VERIFIED');

insert into auth_user_role (auth_user_id, auth_role_id) values ('1','1');
insert into auth_user_role (auth_user_id, auth_role_id) values ('1','2');
insert into auth_user_role (auth_user_id, auth_role_id) values ('1','3');