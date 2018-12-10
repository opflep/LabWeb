create database MyFashionBlog
use MyFashionBlog
drop table fashionBlog

create table message(
	id int identity(1,1),
	name varchar(200) not null,
	mail varchar(200) not null,
	message varchar(2000) not null,
)

create table AboutMe(
	name varchar(100),
	age int ,
	description ntext,
	picture varchar(200),
)
insert into aboutMe values('Susan Stratton', 25, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.', 'aboutme.jpg')

create table fashionBlog(
	fashionID int primary key identity(1,1),
	type int not null ,
	fashionName varchar(100) not null,
	fashionPushDate date not null,
	picture nvarchar(200) not null,
	content varchar(2000) not null,

)

insert into fashionBlog values (1,'In New York', '2014-08-24', 'NewYork1.jpg' ,'Claritas est etiam processus dynamicus, qui sequitur')
insert into fashionBlog values (2 ,'In New York', '2014-08-21', 'NewYork2.jpg' ,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius.')
insert into fashionBlog values (1 ,'Awesome Gucci', '2014-08-12', 'AwesomeGucci.jpg' ,'Claritas est etiam processus dynamicus, qui sequitur')
insert into fashionBlog values (1 ,'Special Offer', '2014-08-04', 'SpecialOffer.jpg' ,'Claritas est etiam processus dynamicus, qui sequitur')

insert into fashionBlog values (2 ,'Special Offer', '2014-04-17', 'NewYork1.jpg' ,'Claritas est etiam processus dynamicus, qui sequitur')
insert into fashionBlog values (1,'In New York', '2014-04-17', 'NewYork1.jpg' ,'Claritas est etiam processus dynamicus, qui sequitur')
insert into fashionBlog values (2 ,'In New York', '2014-04-18', 'NewYork2.jpg' ,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius.')
insert into fashionBlog values (1 ,'Awesome Gucci', '2014-04-19', 'AwesomeGucci.jpg' ,'Claritas est etiam processus dynamicus, qui sequitur')
insert into fashionBlog values (1 ,'Special Offer', '2014-04-20', 'SpecialOffer.jpg' ,'Claritas est etiam processus dynamicus, qui sequitur')




insert into aboutMe values ('Susan Stratton', 25, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.')

insert into message values ('name1', 'mail1', 'message 1')

select TOP 4 * from fashionBlog fas order by fas.fashionPushDate DESC

select count (*)as TotalRecord from  fashionBlog 

select * from fashionBlog fas order by fas.fashionPushDate 
	DESC OFFSET 0 ROWS FETCH NEXT 3 ROWS ONLY

select * from fashionBlog fas where fas.fashionID = 1
select * from message
select * from aboutMe

select * from (        
SELECT f.fashionID, f.type, f.fashionName, f.fashionPushDate, f.picture, f.content, 
                ROW_NUMBER() OVER(ORDER BY f.fashionPushDate) ID
        FROM fashionBlog as f ) as FF
Where ID between (1 - 1) * 5 + 1 and (2 - 1) * 5;              
        
        
        
        
        
        
        
select * from (SELECT f.fashionID, f.type, f.fashionName, f.fashionPushDate, f.picture, f.content, ROW_NUMBER() OVER(ORDER BY f.fashionPushDate) ID FROM fashionBlog as f ) as FF Where ID between (2 - 1) * 3 + 1 and 2 * 3;
        
        
        
        
        
        