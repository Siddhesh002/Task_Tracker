CREATE TABLE `roles` (
                         `role_id` int NOT NULL,
                         `role` varchar(50) NOT NULL,

                         PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `members` (
                           `user_id` int AUTO_INCREMENT NOT NULL,
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

CREATE TABLE `tasks` (
                         `task_id` int AUTO_INCREMENT NOT NULL,
                         `title` varchar(50) NOT NULL,
                         `description` varchar(100) NOT NULL,
                         `status` varchar(100) DEFAULT 'IN_PROGRESS' NOT NULL,
                         `latest_note` varchar(100),
                         `assignee_id` int NOT NULL,

                         FOREIGN KEY (`assignee_id`) REFERENCES members (`user_id`),
                         PRIMARY KEY (`task_id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;