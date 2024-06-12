CREATE TABLE TimeLine (
    tl_id int AUTO_INCREMENT PRIMARY KEY,
    rv_id int NOT NULL,
    User_Id int NOT NULL,
    comment varchar(255) NOT NULL,
    Hiduke varchar(20) NOT NULL,
    FOREIGN KEY(rv_id) REFERENCES Review(rv_id)
);
