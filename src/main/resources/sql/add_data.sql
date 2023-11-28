-- DELETE FROM "user";
-- DELETE FROM post;
-- DELETE FROM comment;

ALTER SEQUENCE users_id_seq RESTART WITH 1;
ALTER SEQUENCE post_id_seq RESTART WITH 1;
ALTER SEQUENCE comment_id_seq RESTART WITH 1;

INSERT INTO users(username, password, is_admin)
VALUES ('Janny95', '1234', true),
       ('Doro', 'passwort', true),
       ('Luzie', '1234', false),
       ('Theo', 'passwort', false);

INSERT INTO post(title, users_id, date, text, image)
VALUES ('New burger place on 6th', 1, '2022-01-03', 'The burger is delicious! Especially with the vegetarian chickpea patty, fresh tomato and honey-mustard sauce.', 'https://plus.unsplash.com/premium_photo-1674670904769-544b31893a15?q=80&w=1770&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D'),
       ('I hate Git', 1, '2022-08-27', 'This is supposed to make our lives easier! Is there no alternative? Is there a way to make this enjoyable?', 'https://images.unsplash.com/photo-1605879071148-d9ddbff24471?q=80&w=1932&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D'),
       ('New writer on the blog', 2, '2022-08-28', 'After the recent rant in this blog, Janny has decided to take a break and leave the posting up to me, Doro.', 'https://plus.unsplash.com/premium_photo-1673529873151-31306ec72ffb?q=80&w=1770&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D'),
       ('I scream, you scream...', 2, '2022-08-31', '...we all scream for ice cream! I discovered a new ice cream shop. My favorite is chocolate mint. What is your favorite?', 'https://images.unsplash.com/photo-1501443762994-82bd5dace89a?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');

INSERT INTO comment(text, date, users_id, post_id)
VALUES ('I like the BBQ sauce the best!', '2022-01-04', 3, 1),
       ('They are sooo expensive though!', '2022-01-05', 4, 1),
       ('F*ing Git', '2022-08-27', 4, 2),
       ('Sorry, it will be more positive from here on..', '2022-08-28', 2, 2),
       ('Welcome!', '2022-08-28', 3, 3),
       ('Thank you!', '2022-08-29', 2, 3),
       ('My favorite is mango!', '2022-08-31', 3, 4);

-- INSERT INTO post(title, users_id, date, text, image)
-- VALUES ('New burger place on 6th', 1, '03.01.2022 18:31', 'The burger is delicious! Especially with the vegetarian chickpea patty, fresh tomato and honey-mustard sauce.', 'https://plus.unsplash.com/premium_photo-1674670904769-544b31893a15?q=80&w=1770&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D'),
--        ('I hate Git', 1, '27.08.2022 3:02', 'This is supposed to make our lives easier! Is there no alternative? Is there a way to make this enjoyable?', 'https://images.unsplash.com/photo-1605879071148-d9ddbff24471?q=80&w=1932&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D'),
--        ('New writer on the blog', 2, '28.08.2022 13:00', 'After the recent rant in this blog, Janny has decided to take a break and leave the posting up to me, Doro.', 'https://plus.unsplash.com/premium_photo-1673529873151-31306ec72ffb?q=80&w=1770&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D'),
--        ('I scream, you scream...', 2, '31.08.2022 16:00', '...we all scream for ice cream! I discovered a new ice cream shop. My favorite is chocolate mint. What is your favorite?', 'https://images.unsplash.com/photo-1501443762994-82bd5dace89a?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');
--
-- INSERT INTO comment(text, date, users_id, post_id)
-- VALUES ('I like the BBQ sauce the best!', '04.01.2022 19:10', 3, 1),
--        ('They are sooo expensive though!', '05.01.2022 11:40', 4, 1),
--        ('F*ing Git', '27.08.2022 8:45', 4, 2),
--        ('Sorry, it will be more positive from here on..', '28.08.2022 9:00', 2, 2),
--        ('Welcome!', '28.08.2022 15:30', 3, 3),
--        ('Thank you!', '29.08.2022 16:00', 2, 3),
--        ('My favorite is mango!', '31.08.2022 19:00', 3, 4);