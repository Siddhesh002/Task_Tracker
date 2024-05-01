INSERT INTO `roles`
VALUES
    (1,'ROLE_EMPLOYEE'),
    (2,'ROLE_MANAGER'),
    (3,'ROLE_ADMIN');

INSERT INTO `members`
VALUES
    (3,'manager','{noop}test123','manager@email.com',null,2,1),
    (4,'admin','{noop}test123','admin@email.com',null,3,1),
    (1,'employee1','{noop}test123','employee1@email.com',3,1,1),
    (2,'employee2','{noop}test123','employee2@email.com',3,1,1);

INSERT INTO `tasks`
VALUES
    (1,'Learn Java','Learning Java Development with frameworks such as Spring', 'IN_PROGRESS', 'Assigned as new project requirement', 1),
    (2,'Learn Python','Learning Python Development with frameworks such as Flask', 'IN_PROGRESS', 'Assigned as new project requirement', 2);
