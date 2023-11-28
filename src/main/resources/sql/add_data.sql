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
VALUES ('New burger place on 6th', 1, '2022-01-03', 'The burger is delicious! Especially with the vegetarian chickpea patty, fresh tomato and honey-mustard sauce.', 'https://unsplash.com/de/fotos/eine-frau-die-auf-dem-gipfel-eines-berges-steht-und-in-den-himmel-schaut-mzR7Ksf2UEA'),
       ('I hate Git', 1, '2022-08-27', 'This is supposed to make our lives easier! Is there no alternative? Is there a way to make this enjoyable?', 'https://unsplash.com/de/fotos/eine-frau-die-auf-dem-gipfel-eines-berges-steht-und-in-den-himmel-schaut-mzR7Ksf2UEA'),
       ('New writer on the blog', 2, '2022-08-28', 'After the recent rant in this blog, Janny has decided to take a break and leave the posting up to me, Doro.', 'https://unsplash.com/de/fotos/eine-frau-die-auf-dem-gipfel-eines-berges-steht-und-in-den-himmel-schaut-mzR7Ksf2UEA'),
       ('I scream, you scream...', 2, '2022-08-31', '...we all scream for ice cream! I discovered a new ice cream shop. My favorite is chocolate mint. What is your favorite?', 'https://unsplash.com/de/fotos/eine-frau-die-auf-dem-gipfel-eines-berges-steht-und-in-den-himmel-schaut-mzR7Ksf2UEA');

INSERT INTO comment(text, date, users_id, post_id)
VALUES ('I like the BBQ sauce the best!', '2022-01-04', 3, 1),
       ('They are sooo expensive though!', '2022-01-05', 4, 1),
       ('F*ing Git', '2022-08-27', 4, 2),
       ('Sorry, it will be more positive from here on..', '2022-08-28', 2, 2),
       ('Welcome!', '2022-08-28', 3, 3),
       ('Thank you!', '2022-08-29', 2, 3),
       ('My favorite is mango!', '2022-08-31', 3, 4);