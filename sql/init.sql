create schema if not exists tmc;

-- create table if not exists tmc.role(
--     id serial primary key ,
--     name varchar(50) not null unique
-- );

create table if not exists tmc.employee(
                                           id serial primary key ,
                                           username varchar(255) not null unique ,
                                           password varchar(255) not null,
                                           role_name varchar(50) not null unique
);

-- create table tmc.employee_role(
--     id serial primary key,
--     employee_id int references tmc.employee(id),
--     role_id int references tmc.role(id)
-- );
--
-- create unique index if not exists "tmc_role_id_idx" on tmc.role using btree(id asc);
-- create unique index if not exists "tmc_employee_id_idx" on tmc.employee using btree(id asc);

-- insert into tmc.role(name) VALUES ('PURCHASING_DEPARTMENT');
-- insert into tmc.role(name) VALUES ('ACCOUNTANT');
-- insert into tmc.role(name) VALUES ('WAREHOUSE');

insert into tmc.employee(username, password, role_name)
VALUES ('AntonRomanovich','Romanovich', 'PURCHASING_DEPARTMENT');
INSERT INTO tmc.employee(username, password,role_name)
VALUES ('GoshaSergeevich', 'Sergeevich', 'ACCOUNTANT');
INSERT INTO tmc.employee(username, password,role_name)
VALUES ('SvetaAntonovna', 'Antonovna','WAREHOUSE');
INSERT INTO tmc.employee(username, password,role_name)
VALUES ('OlaPavlovna', 'Pavlovna','SALES_DEPARTMENT');

-- insert into tmc.employee_roles(employee_id, role_id) VALUES (1,1);
-- insert into tmc.employee_roles(employee_id, role_id) VALUES (1,2);
-- insert into tmc.employee_roles(employee_id, role_id) VALUES (2,2);
-- insert into tmc.employee_roles(employee_id, role_id) VALUES (3,3);