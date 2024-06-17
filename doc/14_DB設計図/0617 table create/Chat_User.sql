create table Chat_User(
    cUser_Id int AUTO_INCREMENT PRIMARY KEY,
    cBot_Id int NOT NULL,
    User_Chat varchar(200),
    FOREIGN KEY(cBot_Id) REFERENCES Chat_Bot(cBot_Id)
);