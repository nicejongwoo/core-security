insert into account (id, age, email, password, username)
values (1, 22, 'user@email.com', '{bcrypt}$2a$10$rBb1HWeLjn0pNnVQsv8FjuRLWoLqgcIEVsioo0c0Q5wK21AUDIrl6', 'user');
insert into account (id, age, email, password, username)
values (2, 32, 'manager@email.com', '{bcrypt}$2a$10$rBb1HWeLjn0pNnVQsv8FjuRLWoLqgcIEVsioo0c0Q5wK21AUDIrl6', 'manager');
insert into account (id, age, email, password, username)
values (3, 33, 'admin@email.com', '{bcrypt}$2a$10$rBb1HWeLjn0pNnVQsv8FjuRLWoLqgcIEVsioo0c0Q5wK21AUDIrl6', 'admin');

insert into role (role_id, role_desc, role_name) values (1, '사용자권한', 'ROLE_USER');
insert into role (role_id, role_desc, role_name) values (2, '매니저권한', 'ROLE_MANAGER');
insert into role (role_id, role_desc, role_name) values (3, '관리자권한', 'ROLE_ADMIN');

insert into account_roles (account_id, role_id) values (1, 1);
insert into account_roles (account_id, role_id) values (2, 1);
insert into account_roles (account_id, role_id) values (2, 2);
insert into account_roles (account_id, role_id) values (3, 1);
insert into account_roles (account_id, role_id) values (3, 2);
insert into account_roles (account_id, role_id) values (3, 3);