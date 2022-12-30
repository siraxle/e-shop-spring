INSERT INTO users (id, archive, email, name, password, role)
VALUES (1, false, 'mail@mail.ru', 'admin', '$2a$10$lqy3.iGDf6pQf6nnI4VndOWet37400qoi4Sx79vQfno01Bw/Lt97S', 'ADMIN');

ALTER SEQUENCE user_seq RESTART WITH 2;