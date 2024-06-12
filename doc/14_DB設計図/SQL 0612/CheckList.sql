Create table CheckList (
    cl_id int AUTO_INCREMENT PRIMARY KEY,
    User_Id int,
    cl_name varchar(100) NOT NULL,
    cl_element varchar(100),
    Hiduke varchar(20) NOT NULL,
    FOREIGN KEY(User_Id) REFERENCES Users(User_Id)
);
