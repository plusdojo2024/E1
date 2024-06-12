Create table Review (
    rv_id int AUTO_INCREMENT PRIMARY KEY,
    User_Id int,
    rv_hsname varchar(200) NOT NULL,
    rv_point int(5) NOT NULL,
    rv_day varchar(50) NOT NULL,
    rv_img varchar(255) NOT NULL,
    rv_remark varchar(255) NOT NULL,
    rv_Hiduke varchar(20) NOT NULL,
    rv_iinecheck varchar(255) NOT NULL,
    rv_book int(1) NOT NULL,
    FOREIGN KEY(User_Id) REFERENCES Users(User_Id)
);
