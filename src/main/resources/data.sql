-- password: 123
insert into account (id, age, email, password, username)
values (90001, 22, 'user@email.com', '{bcrypt}$2a$10$rBb1HWeLjn0pNnVQsv8FjuRLWoLqgcIEVsioo0c0Q5wK21AUDIrl6', 'user');
insert into account (id, age, email, password, username)
values (90002, 32, 'manager@email.com', '{bcrypt}$2a$10$rBb1HWeLjn0pNnVQsv8FjuRLWoLqgcIEVsioo0c0Q5wK21AUDIrl6', 'manager');
insert into account (id, age, email, password, username)
values (90003, 33, 'admin@email.com', '{bcrypt}$2a$10$rBb1HWeLjn0pNnVQsv8FjuRLWoLqgcIEVsioo0c0Q5wK21AUDIrl6', 'admin');

insert into role (role_id, role_desc, role_name) values (90001, '사용자권한', 'ROLE_USER');
insert into role (role_id, role_desc, role_name) values (90002, '매니저권한', 'ROLE_MANAGER');
insert into role (role_id, role_desc, role_name) values (90003, '관리자권한', 'ROLE_ADMIN');

insert into account_roles (account_id, role_id) values (90001, 90001);
insert into account_roles (account_id, role_id) values (90002, 90001);
insert into account_roles (account_id, role_id) values (90002, 90002);
insert into account_roles (account_id, role_id) values (90003, 90001);
insert into account_roles (account_id, role_id) values (90003, 90002);
insert into account_roles (account_id, role_id) values (90003, 90003);