insert into CATEGORIES (ID, NAME) values (1, 'Application & Services');
insert into CATEGORIES (ID, NAME) values (2, 'Benefits & Paper Work');
insert into CATEGORIES (ID, NAME) values (3, 'Hardware & Software');
insert into CATEGORIES (ID, NAME) values (4, 'People Management');
insert into CATEGORIES (ID, NAME) values (5, 'Security & Access');
insert into CATEGORIES (ID, NAME) values (6, 'Workplaces & Facilities');

insert into USERS (ID, EMAIL,  FIRST_NAME, LAST_NAME, PASSWORD,  ROLE_ID) values (1, 'E1@gmail.com', 'Tom', 'Cruise', '{bcrypt}$2a$10$ObglJMFhSDX9dmCkNdXfauH7/2qyVyDUfJpkKQQ.szSSRXxUZCaO6', 0);
insert into USERS (ID, EMAIL,  FIRST_NAME, LAST_NAME, PASSWORD,  ROLE_ID) values (2, 'E2@gmail.com', 'Eddie', 'Murphy', '{bcrypt}$2a$10$uuOY1CZtGTwjez8DwDLWyeuZhkAhcWaigWQMgN6gTJQEFwtg0qq9G', 0);
insert into USERS (ID, EMAIL,  FIRST_NAME, LAST_NAME, PASSWORD,  ROLE_ID) values (3, 'M1@gmail.com', 'Manager1', 'Manager1', '{bcrypt}$2a$10$gyg4.uBbUW3YWKWyhk54gelNegh/xoFRJ/tor2Z8jmJr69MvjuKjO', 1);
insert into USERS (ID, EMAIL,  FIRST_NAME, LAST_NAME, PASSWORD,  ROLE_ID) values (4, 'M2@gmail.com', 'Manager2', 'Manager2', '{bcrypt}$2a$10$aQu2O6hoTYi8VOk/b6KWb.xBCaYa7R6JIzP5qzUOyU8eBKvSWs6Mm', 1);
insert into USERS (ID, EMAIL,  FIRST_NAME, LAST_NAME, PASSWORD,  ROLE_ID) values (5, 'A1@gmail.com', 'Admin1', 'Admin1', '{bcrypt}$2a$10$CtcmUCx.1lVcS7c88PJju.gI45CDzR8VcdH1WqnacTG22awsF8lK2', 2);
insert into USERS (ID, EMAIL,  FIRST_NAME, LAST_NAME, PASSWORD,  ROLE_ID) values (6, 'A2@gmail.com', 'Admin2', 'Admin2', '{bcrypt}$2a$10$QeuKfoyaTa7LghTSqNieluhTFyxW6pYoDm7cHOQANduy9OIYFZPCO', 2);