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

INSERT INTO `categories`
    (`code`, `name`, `parent_id`)
VALUES ('A1', 'Skateboards', null),     -- 1
       ('A1B1', 'Cruising', 1),         -- 2
       ('A1C1', 'Freestyle', 1),        -- 3
       ('A1D1', 'Freeride', 1),         -- 4
       ('A1E1', 'Downhill', 1),         -- 5

       ('A1A1A1', 'Cruiser', 2),        -- 6
       ('A1A1B1', 'Bamboo', 2),         -- 7
       ('A1A1C1', 'Drop Down', 2),      -- 8
       ('A1A1D1', 'Drop Through', 2),   -- 9
       ('A1A1E1', 'Mini Cruiser', 2),   -- 10
       ('A1A1F1', 'Pintail', 2),        -- 11

       ('A1B1A1', 'Drop Down', 3),      -- 12
       ('A1B1B1', 'Drop Through', 3),   -- 13
       ('A1A1A1', 'Skateboard', 3),     -- 14

       ('A1C1A1', 'Drop Down', 4),      -- 15
       ('A1C1B1', 'Drop Through', 4),   -- 16
       ('A1C1C1', 'Fishboard', 4),      -- 17

       ('A1D1A1', 'Cruiser', 5),        -- 18
       ('A1D1B1', 'Topmount', 5),       -- 19
       ('A1D1B1', 'Speed Board', 5);    -- 20

INSERT INTO `items`
(`code`, `amount`, `name`, `description_pl`, `description_en`, `price`, `category_id`)
VALUES ('8506101', 6, 'Longboard FREE 520 Japan OXELO',
        'Deska o kształcie "Drop", który pozwala obniżyć środek ciężkości, aby zapewnić maksymalną stabilność, nawet przy dużych prędkościach. Bądź szybki jak wiatr! Lub prawie... ',
        'Drop-shaped board that allows you to lower the center of gravity to ensure maximum stability, even at high speeds. Be fast like the wind! Or almost...',
        116.38, 15),
       ('8214511', 21, 'Miniboard Penny Nickel Pastels',
        'Nickel to dłuższy model typowej "rybki" czyli tzw. cruzera. Plastikowe deski jak ta zyskały popularność w połowie lat 70, deskoroloki odlewane z plastiku były w tym czasie najbardziej stylowymi i odjazdowymi deskorolkami. Zwrotna i poręczna deska była świetnym sposobem przemieszczania się po mieście.',
        'Nickel is a longer model of a typical "fish", i.e. Cruzer. Plastic boards like this gained popularity in the mid-1970s, plastic-cast skateboards were the most stylish and cool skateboards at the time. A manoeuvrable and handy board was a great way of getting around the city.',
        129.06, 17),
       ('8494321', 2, 'Tony Hawk 180 Series',
        'Jeśli nigdy wcześniej nie postawiłeś nogi na deskorolce, ale chciałbyś spróbować jazdy na niej, to deskorolka kompletna z serii 180 z linii kompletnych deskorolek Tony Hawk jest stworzona dla Ciebie. Wykonano ją w taki sposób, aby zapewniała łatwą jazdę dzięki zastosowaniu miększych kółek i sprzętu, który wybaczy więcej błędów.',
        'If you''ve never set your foot on a skateboard before but would like to try riding on it, then the complete skateboard from the 180 series from the complete skateboard line Tony Hawk is made for you. It was made in such a way as to ensure easy driving thanks to the use of softer wheels and equipment that will forgive more mistakes.',
        51.47, 14),
       ('8494874', 10, 'PINTAIL 520 GRADIANT OXELO', 'Longboard o kształcie Pintail, 100 cm, stabilny i komfortowy. Ten rozmiar sprawia, że jest to idealna deska na spokojne przejażdżki.',
        'Pintail-shaped longboard, 100 cm, stable and comfortable. This size makes it an ideal board for quiet rides.',
        103.45, 11),
        ('8494874', 5, 'Cruiser YAMBA Square OXELO', 'Cruiser z drewnianym deckiem zapewnia lepszą stabilność. Wyposażona w koła 59 mm, deska zachowuje dobrą dynamikę i zapewnia dobre przyspieszenia. Ruszaj na poznanie miasta...',
        'Cruiser with a wooden deck provides better stability. Equipped with 59 mm wheels, the board maintains good dynamics and provides good acceleration. Get to know the city...',
        51.72, 6);

INSERT INTO `images`
    (`name`, `type`, `alternative`, `product_id`)
VALUES ('big_1420277', 'jpg', 'Image 1 description', 1),
       ('big_1420279', 'jpg', 'Image 2 description', 1),
       ('big_1420307', 'jpg', 'Image 3 description', 1),

       ('big_1310251', 'jpg', 'Image 1 description', 2),
       ('big_1310252', 'jpg', 'Image 2 description', 2),
       ('big_1310253', 'jpg', 'Image 3 description', 2),

       ('big_1134029', 'jpg', 'Image 1 description', 3),
       ('big_1134030', 'jpg', 'Image 2 description', 3),
       ('big_1134031', 'jpg', 'Image 3 description', 3),

       ('big_1572854', 'jpg', 'Image 1 description', 4),
       ('big_1572892', 'jpg', 'Image 2 description', 4),
       ('big_1572907', 'jpg', 'Image 3 description', 4),

       ('big_1290973', 'jpg', 'Image 1 description', 5),
       ('big_1290978', 'jpg', 'Image 2 description', 5),
       ('big_1291063', 'jpg', 'Image 3 description', 5);