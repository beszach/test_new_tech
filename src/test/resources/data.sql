# # Заносим юзеров в таблицу
INSERT INTO users(age, email, name, last_name, password) VALUES(5, 'admin@mail.ru', 'admin', 'admin', '$2a$08$zP/MxCfg75BXaume8EbdQOYXnkpNBudQbM11LaQHuw2z9yn2lJ2ry');
INSERT INTO users(age, email, name, last_name, password) VALUES(7, 'user@mail.ru', 'user', 'user', '$2a$08$hFgb3d1z8HZ21wWy8Oprr.jfOwKP46OJ.qt2vOzTiwb4aB.70rus6');
INSERT INTO users(age, email, name, last_name, password) VALUES(1, 'email1@mail.ru', 'name1', 'lastname1', '$2a$08$CJrrRJp5U4MyVRA5qTaSH.Crn/VeARFLG6efqZ/8m5B5U04tJTTYu');
INSERT INTO users(age, email, name, last_name, password) VALUES(2, 'email2@mail.ru', 'name2', 'lastname2', '$2a$08$44LcMt/Aj6iiViHaTOO3fOFchkVk9YmMn37Nta6yv6QZ/RN73qiPW');
INSERT INTO users(age, email, name, last_name, password) VALUES('3', 'email3@mail.ru', 'name3', 'lastname3', '$2a$08$JqJbB9If2JwvCy/t/3b6fu6UaviDofHkda0pKGU5Ok//MdVlN07u.');

# # Заносим роли в таблицу
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_DEVELOPER');
INSERT INTO roles(name) VALUES('ROLE_MANAGER');
INSERT INTO roles(name) VALUES('ROLE_HR');
#
INSERT INTO users_roles(users_id, roles_id) VALUES(1, 1);
INSERT INTO users_roles(users_id, roles_id) VALUES(2, 2);
INSERT INTO users_roles(users_id, roles_id) VALUES(3, 1);
INSERT INTO users_roles(users_id, roles_id) VALUES(4, 1);
INSERT INTO users_roles(users_id, roles_id) VALUES(5, 1);