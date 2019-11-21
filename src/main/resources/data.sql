--
-- Inserting data for table `users`
--
INSERT INTO `users`
    (`user_id`, `email`, `first_name`, `last_name`, `password`, `active`)
VALUES (1, 'john@idb.org', 'John', 'Doe', '$2a$10$6n7ajFsm92grQPbERCMs5.9PUIlX0E6exBuf.m1HfK9vmz0RNYjTy', 1),
       (2, 'mary@idb.org', 'Mary', 'Doe', '$2a$10$6n7ajFsm92grQPbERCMs5.9PUIlX0E6exBuf.m1HfK9vmz0RNYjTy', 1),
       (3, 'mark@idb.org', 'Mark', 'Doe', '$2a$10$6n7ajFsm92grQPbERCMs5.9PUIlX0E6exBuf.m1HfK9vmz0RNYjTy', 1),
       (4, 'susan@idb.org', 'Susan', 'Doe', '$2a$10$6n7ajFsm92grQPbERCMs5.9PUIlX0E6exBuf.m1HfK9vmz0RNYjTy', 1),
       (5, 'ally@idb.org', 'Ally', 'Doe', '$2a$10$6n7ajFsm92grQPbERCMs5.9PUIlX0E6exBuf.m1HfK9vmz0RNYjTy', 1);

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
