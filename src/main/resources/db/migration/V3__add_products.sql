INSERT INTO products (id, price, title)
values (1, 450.00, 'Cheese'),
       (2, 45.0, 'Beer'),
        (3, 65.0, 'Milk'),
        (4, 115.0, 'Tomato'),
        (5, 58.0, 'Bread');

ALTER SEQUENCE product_seq RESTART WITH 6;