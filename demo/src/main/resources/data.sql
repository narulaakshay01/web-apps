-- author
insert into author(name,email) values('Akshay','narulaakshay01@gmail.com'),('Aastha','aasthasaraf1995@gmail.com')^;
-- reviewer
insert into reviewer(name,email) values('Narula','narulaakshay01@gmail.com'),('Saraf','aasthasaraf1995@gmail.com')^;
-- user
insert into user (name, email) values('Ipsum','ipsum@ipsum.com'),('Lorem','lorem@lorem.com'),('alpha','alpha@alpha.com'),('beta','beta@beta.com'),('Upsilon','upsilon@upsilon.com')^;
-- content
insert into content(name, description, author_id, reviewer_id, is_active) values('Core Java','Basic concepts of java', 1,1,1),('Enterprise Java','Java concepts for web development', 1,2,1),
																				('MySQL','Basic concepts of MySQL', 2,2,1),('PL/SQL','Basic concepts of prgramming in sql', 2,1,1),
                                                                                ('Spring','Basic spring concepts', 1,1,0)^;
-- content pages
drop procedure if exists insert_content^; 
CREATE PROCEDURE insert_content()   
BEGIN
DECLARE i INT DEFAULT 1;
DECLARE j INT DEFAULT 1;
while (i <=5) do
	WHILE (j <= 10) DO
		insert into content_pages values(i,j,'html',CONCAT('C:\\Users\\narul\\OneDrive\\Desktop\\content\\',i,'-',j,'.html'));
		SET j = j+1;
	END WHILE;
    set i=i+1;
    set j=1;
end while;
END ^;

call insert_content()^;

-- user acivity

insert into user_activity values(1,1,1,now()),(2,1,1,now()),(2,1,2,now()),(2,1,3,now()),(2,1,4,now()),(2,1,5,now()),(2,1,6,now()),(2,1,7,now()),(2,1,8,now()),(2,1,9,now()),(2,1,10,now()),(3,1,1,now())
									,(3,1,2,now()),(3,1,3,now()),(3,1,4,now()),(3,1,5,now()),(3,1,6,now()),(3,1,7,now()),(3,1,8,now()),(3,1,9,now()),(3,1,10,now()),(3,2,1,now()),(3,2,2,now()),(3,2,3,now())
                                    ,(3,2,4,now()),(3,2,5,now()),(5,1,1,now()),(5,1,2,now()),(5,1,3,now()),(5,1,4,now()),(5,1,5,now()),(5,1,6,now()),(5,1,7,now()),(5,1,8,now()),(5,1,9,now()),
                                    (5,1,10,now()),(5,2,1,now()),(5,2,2,now()),(5,2,3,now()),(5,2,4,now()),(5,2,5,now()),(5,2,6,now()),(5,2,7,now()),(5,2,8,now()),(5,2,9,now()),(5,2,10,now()),
                                    (5,3,1,now()),(5,3,2,now()),(5,3,3,now()),(5,3,4,now()),(5,3,5,now()),(5,3,6,now()),(5,3,7,now()),(5,3,8,now()),(5,3,9,now()),(5,3,10,now()),(5,4,1,now()),
                                    (5,4,2,now()),(5,4,3,now()),(5,4,4,now()),(5,4,5,now()),(5,4,6,now()),(5,4,7,now()),(5,4,8,now()),(5,4,9,now()),(5,4,10,now())^;
insert into user_activity values(4,1,1,DATE_SUB(now(), INTERVAL 10 DAY)),
                                    (4,1,2,DATE_SUB(now(), INTERVAL 10 DAY)), (4,1,3,DATE_SUB(now(), INTERVAL 10 DAY)), (4,1,4,DATE_SUB(now(), INTERVAL 10 DAY)), (4,1,5,DATE_SUB(now(), INTERVAL 10 DAY)), (4,1,6,DATE_SUB(now(), INTERVAL 10 DAY)), (4,1,7,DATE_SUB(now(), INTERVAL 10 DAY)), 
                                    (4,1,8,DATE_SUB(now(), INTERVAL 10 DAY)), (4,1,9,DATE_SUB(now(), INTERVAL 10 DAY)), (4,1,10,DATE_SUB(now(), INTERVAL 10 DAY)), (4,2,1,DATE_SUB(now(), INTERVAL 10 DAY)), (4,2,2,DATE_SUB(now(), INTERVAL 10 DAY)), (4,2,3,DATE_SUB(now(), INTERVAL 10 DAY)), 
                                    (4,2,4,DATE_SUB(now(), INTERVAL 10 DAY)), (4,2,5,DATE_SUB(now(), INTERVAL 10 DAY)), (4,2,6,DATE_SUB(now(), INTERVAL 10 DAY)), (4,2,7,DATE_SUB(now(), INTERVAL 10 DAY)), (4,2,8,DATE_SUB(now(), INTERVAL 10 DAY)), (4,2,9,DATE_SUB(now(), INTERVAL 10 DAY)), 
                                    (4,2,10,DATE_SUB(now(), INTERVAL 10 DAY))^;
                                    

	
drop procedure if exists trivial^;
CREATE PROCEDURE trivial(in t int)   
BEGIN
	if t=0 then
		select c.name "Content Name", a.name "Author's Name", r.name "Reviewer's Name" from content c join author a on c.author_id=a.id join reviewer r on c.reviewer_id=r.id;    
	elseif t=1 then
		select c.name "Content Name", r.name "Reviewer's Name" from content c join reviewer r on c.reviewer_id=r.id and c.is_active=0;
	elseif t=2 then
		select c.name "Content Name", a.name "Author's Name", r.name "Reviewer's Name",r.email "Common Email" from content c join author a on c.author_id=a.id join reviewer r on c.reviewer_id=r.id where a.email=r.email;
    end if;
END^;

drop procedure if exists complex^;
CREATE PROCEDURE complex(in t int)   
BEGIN
	if t=0 then
		select a.name "Author's Name", count(*) "Total Authored" from content c join author a on c.author_id=a.id group by a.name,a.id order by "Total Authored" desc limit 1;
	elseif t=1 then
		select u.name "User's Name", c.name "Content Name" from progress p join user u on p.user_id=u.id and progress=100 join content c on p.content_id=c.id group by u.name,user_id having count(content_id)=1;
	elseif t=2 then
		select u.name "User's Name" from progress p join user u on p.user_id=u.id and progress=100 join content c on p.content_id=c.id group by u.name,user_id having count(content_id)=(Select count(*) from content where is_active=1);
    elseif t=3 then
		select u.name "User's Name", DATE_FORMAT(max(viewed_on),'%D %M %Y') "Most Recent View" from user_activity ua join user u on ua.user_id=u.id group by user_id,u.name having datediff(now(),max(viewed_on))>=7;
    elseif t=4 then
		select Rank() over(order by sum(progress) desc) "Rank", u.name "User's Name" from progress p join user u on p.user_id=u.id group by u.id,u.name;
    end if;
END^;

