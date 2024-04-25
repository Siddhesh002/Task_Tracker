create database task_directory;

use task_directory;

DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `members`;

--
-- Table structure for table `authorities`
--

CREATE TABLE `roles` (
  `role_id` int NOT NULL,
  `role` varchar(50) NOT NULL,
  
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `roles`
--

INSERT INTO `roles`
VALUES
(1,'ROLE_EMPLOYEE'),
(2,'ROLE_MANAGER'),
(3,'ROLE_ADMIN');

CREATE TABLE `members` (
  `user_id` int NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `pw` varchar(68) NOT NULL,
  `email` varchar(50) NOT NULL,
  `manager_id` int,
  `role_id` int NOT NULL,
  `active` tinyint NOT NULL,
	
  FOREIGN KEY (`role_id`) REFERENCES roles(`role_id`),
  FOREIGN KEY (`manager_id`) REFERENCES members(`user_id`),
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `members`
VALUES
(3,'dinesh','{noop}test123','dinesh@email.com',null,2,1),
(4,'siddhesh','{noop}test123','siddhesh@email.com',null,3,1),
(1,'amey','{noop}test123','amey@email.com',3,1,1),
(2,'soham','{noop}test123','soham@email.com',3,1,1);


--
-- Table structure for table task
--

CREATE TABLE `tasks` (
	`task_id` int NOT NULL,
    `title` varchar(50) NOT NULL,
    `description` varchar(100) NOT NULL,
    `status` varchar(100) DEFAULT 'IN_PROGRESS' NOT NULL,
    `latest_note` varchar(100),
    `assignee_id` int NOT NULL,
    
    FOREIGN KEY (`assignee_id`) REFERENCES members (`user_id`), 
    PRIMARY KEY (`task_id`)
    );
    
    INSERT INTO `tasks`
    VALUES
    (1,'Learn Java','Learning Java Development with frameworks such as Spring', 'IN_PROGRESS', 'Assigned as new project requirement', 1),
    (2,'Learn Python','Learning Python Development with frameworks such as Flask', 'IN_PROGRESS', 'Assigned as new project requirement', 2);
