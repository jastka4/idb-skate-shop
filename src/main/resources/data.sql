--
-- Inserting data for table `users`
--
INSERT INTO `users`
    (`email`, `first_name`, `last_name`, `password`, `active`)
VALUES ('john@idb.org', 'John', 'Doe', '$2a$10$6n7ajFsm92grQPbERCMs5.9PUIlX0E6exBuf.m1HfK9vmz0RNYjTy', 1),
       ('mary@idb.org', 'Mary', 'Doe', '$2a$10$6n7ajFsm92grQPbERCMs5.9PUIlX0E6exBuf.m1HfK9vmz0RNYjTy', 1),
       ('mark@idb.org', 'Mark', 'Doe', '$2a$10$6n7ajFsm92grQPbERCMs5.9PUIlX0E6exBuf.m1HfK9vmz0RNYjTy', 1),
       ('susan@idb.org', 'Susan', 'Doe', '$2a$10$6n7ajFsm92grQPbERCMs5.9PUIlX0E6exBuf.m1HfK9vmz0RNYjTy', 1),
       ('ally@idb.org', 'Ally', 'Doe', '$2a$10$6n7ajFsm92grQPbERCMs5.9PUIlX0E6exBuf.m1HfK9vmz0RNYjTy', 1);

--
-- Inserting data for table `roles`
--
INSERT INTO `roles`
    (`role_id`, `role`)
VALUES (0, 'ADMIN'),
       (1, 'USER');

--
-- Inserting data for table `roles`
--
INSERT INTO `user_role`
    (`user_id`, `role_id`)
VALUES (1, 0),
       (2, 0),
       (3, 1),
       (4, 1),
       (5, 1);

INSERT INTO `images`
    (`name`, `type`, `alternative`, `product_id`)
VALUES ('Image 1', 'jpg', 'Image 1 description', 1),
       ('Image 2', 'jpg', 'Image 2 description', 2),
       ('Image 3', 'jpg', 'Image 3 description', 2),
       ('Image 4', 'jpg', 'Image 4 description', 2);

INSERT INTO `items`
    (`code`, `amount`, `name`, `description`, `price`)
VALUES ('ABCD10', 10, 'Jakiś przedmiot', 'Opis przedmiotu 1. Przedmiot 1 jest fajny.', 1.22),
       ('ABCD20', 12, 'Jakiś inny przedmiot', 'Opis przedmiotu 2. Przedmiot 2 też jest fajny.', 2.22);
