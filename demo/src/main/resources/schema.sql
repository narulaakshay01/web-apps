drop table if exists user_activity ^;
drop table if exists user ^;
drop table if exists content_pages^;
drop table if exists content^;
drop table if exists author^;
drop table if exists reviewer^;


create table author(id int AUTO_INCREMENT primary key , name varchar(200) not null, email varchar(200) not null)^;
create table reviewer(id int AUTO_INCREMENT primary key, name varchar(200) not null, email varchar(200) not null)^;
create table user(id int AUTO_INCREMENT primary key, name varchar(200),  email VARCHAR(50) NOT NULL)^;
create table content(id int AUTO_INCREMENT primary key, name varchar(300), description varchar(250), author_id int, reviewer_id int, is_active bool,FOREIGN KEY(author_id) references author(id),FOREIGN KEY(reviewer_id) references reviewer(id))^;
create table content_pages(content_id int ,FOREIGN KEY(content_id) references content(id), id int, type varchar(20), path varchar(200), PRIMARY KEY (id,content_id))^;
create table user_activity(user_id int, FOREIGN KEY(user_id) references user(id), content_id int, FOREIGN KEY(content_id) references content_pages(content_id), page_id int, FOREIGN KEY(page_id) references content_pages(id), viewed_on date, primary key(user_id,content_id,page_id))^;


CREATE OR REPLACE VIEW progress
AS
	select user_id, t1.content_id, ((100*read_pages)/total_pages) progress from
		(select user_id,content_id,count(page_id) read_pages from user_activity group by user_id, content_id) t1
		join
		(select content_id,count(id) total_pages from content_pages group by content_id) t2
		on t1.content_id=t2.content_id 
	order by user_id^;






