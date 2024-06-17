Create table Users (
    User_Id int AUTO_INCREMENT PRIMARY KEY,
    User_Pw VARCHAR(12) NOT NULL,
    Mailaddress VARCHAR(100) NOT NULL,
    p_Nickname VARCHAR(12) NOT NULL,
    p_Img VARCHAR(255),
    p_Age VARCHAR(3),
    p_gender VARCHAR(12),
    Hiduke VARCHAR(20)
);

create table Chat_Bot(
    cBot_Id int AUTO_INCREMENT PRIMARY KEY,
    Bot_Chat varchar(255)
);

create table Chat_User(
    cUser_Id int AUTO_INCREMENT PRIMARY KEY,
    cBot_Id int NOT NULL,
    User_Chat varchar(200),
    FOREIGN KEY(cBot_Id) REFERENCES Chat_Bot(cBot_Id)
);

Create table CheckList (
    cl_id int AUTO_INCREMENT PRIMARY KEY,
    User_Id int,
    cl_name varchar(100) NOT NULL,
    cl_element varchar(100),
    Hiduke varchar(20) NOT NULL,
    FOREIGN KEY(User_Id) REFERENCES Users(User_Id)
);

Create table Review (
    rv_id int AUTO_INCREMENT PRIMARY KEY,
    User_Id int,
    rv_Onsenname varchar(200) NOT NULL,
    rv_point int(5) NOT NULL,
    rv_day varchar(50) NOT NULL,
    rv_img varchar(255) NOT NULL,
    rv_remark varchar(255) NOT NULL,
    rv_Hiduke varchar(20) NOT NULL,
    rv_iinecheck varchar(255) NOT NULL,
    rv_book int(1) NOT NULL,
    FOREIGN KEY(User_Id) REFERENCES Users(User_Id)
);

CREATE TABLE TimeLine (
    tl_id int AUTO_INCREMENT PRIMARY KEY,
    rv_id int NOT NULL,
    User_Id int NOT NULL,
    comment varchar(255) NOT NULL,
    Hiduke varchar(20) NOT NULL,
    FOREIGN KEY(rv_id) REFERENCES Review(rv_id)
);

CREATE TABLE Onsen (
    hs_id int AUTO_INCREMENT PRIMARY KEY,
    onsen_name varchar(100),
    hs_address varchar(100),
    hs_phone varchar(100),
    hs_effect varchar(100),
    hs_value varchar(100),
    hs_img varchar(255),
    hs_url varchar(100)
);
