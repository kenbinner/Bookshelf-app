DROP TABLE Books;
DROP TABLE Customers;

CREATE TABLE Customers
	(
		customerId int(3) AUTO_INCREMENT PRIMARY KEY,
		name VARCHAR(20) NOT NULL,
		email VARCHAR(20) NOT NULL,
		password VARCHAR(20) NOT NULL
	);

CREATE TABLE Books
	(
		bookId int(5) AUTO_INCREMENT PRIMARY KEY,
		title VARCHAR(50) NOT NULL,
		author VARCHAR(50) NOT NULL,
		status VARCHAR(15) NOT NULL,
		comments VARCHAR(200),
		rating int(1),
		isbn VARCHAR(20) UNIQUE,
		customer int(3) REFERENCES Customers(customerId),
		image BLOB
	);

INSERT INTO Customers VALUES(1, 'Kengo', 'kengo@binner.org','Kengo@123');
INSERT INTO Customers VALUES(2, 'Naoki', 'naoki@binner.org','Naoki@123');

INSERT INTO Books VALUES(1, 'Bubishi', 'Patrick McCarthy', 'complete', 
'A really insightful and mysterious text on the origins of karate',4, '9784805313848',001,null );
INSERT INTO Books VALUES(2, 'Elon Musk', 'Ashlee Vance', 'complete', 
'Crazy amazing man, crazy amazing book',5 , null,001,null );
INSERT INTO Books VALUES(3, 'The Organised Mind', 'Daniel Levitin', 'on hold', 
'ok so far',3 , null,001 ,null);
INSERT INTO Books VALUES(4, 'Doraemon', 'Fujiko F Fujio', 'complete', 
null,4 , '4092270119',002,null );
INSERT INTO Books VALUES(5, 'One Punch Man', 'ONE', 'reading', 
null,5 ,null,002 ,null);
INSERT INTO Books VALUES(6, 'How to think Like a Mathematician', 'Kevin Houston', 'complete', 
'Great for undergrads!',4, '9780521719780',001 ,null);
INSERT INTO Books VALUES(7, 'Book of Assistance', 'Abdallah Ibn Alawi Al-Haddad', 'complete', 
'Great book',4, '1887752587',001 ,null);
INSERT INTO Books VALUES(8, 'Mindfulness', 'Mark Williams and Danny Penman', 'complete', 
'Excellent for mindfulness',4, 'B004ZFZJWA',001 ,null);
INSERT INTO Books VALUES(9, '5 Ingrediants', 'Jamie Oliver', 'reading', 
'Tasty recipes!',3, '0718187725',001 ,null);
INSERT INTO Books VALUES(10, 'Sam Stern''s Eat Vegetarian', 'Sam Stern', 'complete', 
'Tasty veggie!',5, '1406319759',001,null );
INSERT INTO Books VALUES(11, 'The Girl Who Played Go', 'Shan Sa', 'on hold', 
'Mystifying... can be hard to follow sometimes',3, '0099444984',001 ,null);
INSERT INTO Books VALUES(12, 'Life Story', 'Virginia Lee Burton', 'complete', 
'One of my favourite childhood books',5, '0547203594',001 ,null);

SELECT * FROM Customers;
SELECT * FROM Books;
