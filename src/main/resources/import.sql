-- password: 123
insert into account (id, age, email, password, username) values (90001, 22, 'user@email.com', '{bcrypt}$2a$10$rBb1HWeLjn0pNnVQsv8FjuRLWoLqgcIEVsioo0c0Q5wK21AUDIrl6', 'user');
insert into account (id, age, email, password, username) values (90002, 32, 'manager@email.com', '{bcrypt}$2a$10$rBb1HWeLjn0pNnVQsv8FjuRLWoLqgcIEVsioo0c0Q5wK21AUDIrl6', 'manager');
insert into account (id, age, email, password, username) values (90003, 33, 'admin@email.com', '{bcrypt}$2a$10$rBb1HWeLjn0pNnVQsv8FjuRLWoLqgcIEVsioo0c0Q5wK21AUDIrl6', 'admin');

insert into role (role_id, role_desc, role_name) values (90001, '사용자권한', 'ROLE_USER');
insert into role (role_id, role_desc, role_name) values (90002, '매니저권한', 'ROLE_MANAGER');
insert into role (role_id, role_desc, role_name) values (90003, '관리자권한', 'ROLE_ADMIN');

insert into account_roles (account_id, role_id) values (90001, 90001);
--insert into account_roles (account_id, role_id) values (90002, 90001);
insert into account_roles (account_id, role_id) values (90002, 90002);
--insert into account_roles (account_id, role_id) values (90003, 90001);
--insert into account_roles (account_id, role_id) values (90003, 90002);
insert into account_roles (account_id, role_id) values (90003, 90003);

insert into resource (resource_id, resource_name, resource_type, order_num) values (90001, '/admin/**', 'url', 1);
insert into resource (resource_id, resource_name, resource_type, order_num) values (90002, '/mypage', 'url', 2);
insert into resource (resource_id, resource_name, resource_type, order_num) values (90003, '/messages', 'url', 3);
insert into resource (resource_id, resource_name, resource_type, order_num) values (90004, '/config', 'url', 4);

insert into role_resource (resource_id, role_id) values (90001, 90003);
insert into role_resource (resource_id, role_id) values (90002, 90001);
insert into role_resource (resource_id, role_id) values (90003, 90002);
insert into role_resource (resource_id, role_id) values (90004, 90003);

-- method 인가 처리 테스트 데이터
insert into resource (resource_id, resource_name, resource_type, order_num) values (90005, 'com.core.sec.aopsecurity.AopMethodService.methodSecured', 'method', 5);
insert into role_resource (resource_id, role_id) values (90005, 90001);

-- pointcut 인가 처리 테스트 데이터
insert into resource (resource_id, resource_name, resource_type, order_num) values (90006, 'execution(* com.core.sec.aopsecurity.AopPointcutService.pointcut*(..))', 'pointcut', 6);
insert into role_resource (resource_id, role_id) values (90006, 90001);
