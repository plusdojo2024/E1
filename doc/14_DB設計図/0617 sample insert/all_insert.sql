/*  画像データは入れていない    */
insert into Users (User_Pw, Mailaddress, p_Nickname,p_Age, p_gender, Hiduke)
VALUES
('00000000','kusaka@example.com','くさか','22','男','2024-06-12');

INSERT INTO TimeLine(rv_id, User_Id, comment, Hiduke)
values
('1','1','参考になりました！','2024-06-12');

/*  画像データは入れていない    */
insert into CheckList (User_id, cl_name, cl_element, Hiduke)
VALUES
('1','会社前に確認するもの','財布','2024-06-12'),
('1','会社前に確認するもの','社員証','2024-06-12');

insert into Review (User_Id, rv_onsenname, rv_point, rv_day, rv_img, rv_remark, rv_Hiduke, rv_Iinecheck, rv_Book)
VALUES
('1','薬師乃湯','5','2024-06-10','noimage','よかった','2024-06-12','10','1');

INSERT into Onsen(HS_NAME, HS_ADDRESS, HS_PHONE, HS_EFFECT, HS_VALUE, HS_IMG, HS_URL)
VALUES
('薬師乃湯','阿賀野市村杉3946-6','0250-66-2626','関節リウマチ','250','Noimage','www.yakushinoyu.com');
