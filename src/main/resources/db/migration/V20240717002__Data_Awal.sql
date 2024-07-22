insert into c_security_permission (id, created, created_by, permission_label,permission_value) VALUES ('P000','2024-07-17 00:00:00', 'SYSTEM','DEFAULT','default');

insert into c_security_role (id, created, created_by, description,name) VALUES ('R000','2024-07-17 00:00:00', 'SYSTEM','Default Management Role','Role Management');

insert into c_security_role_permission (id_role, id_permission) VALUES ('R000','P000');


insert into c_security_user (id, created, created_by, active,username,id_role) VALUES
    ('default_user','2024-07-17 00:00:00', 'SYSTEM',true,'admin.app@yopmail.com','R000');

insert into c_security_user_password (id_user, created, created_by, user_password) VALUES
    ('default_user','2024-07-17 00:00:00', 'SYSTEM','$2a$08$LS3sz9Ft014MNaIGCEyt4u6VflkslOW/xosyRbinIF9.uaVLpEhB6');