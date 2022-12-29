-- 2022-11-30
create table member2(
email varchar(100) not null,
pwd varchar(100) not null,
nick_name varchar(100) not null,
reg_at datetime default current_timestamp,
last_login datetime,
primary key(email));

alter table board add read_count int default 0;
alter table member add nick varchar(100) not null;

-- 2022-12-02
create table comment(
cno int not null auto_increment,
bno int default -1,
writer varchar(100) default "unknown",
content varchar(1000) not null,
reg_at datetime default current_timestamp,
primary key(cno));

-- 2022-12-06
-- 개발하기 전에 미리 fk 설정을 하면 개발할 때 수정/삭제에 제한이
-- 걸리기 때문에 다 개발한 후 테스트 후 수정 / 삭제가 이상이 없을 경우 
-- 이후 관계 설정 추가하여 다시 테스트 완료하는 것이 효율적
alter table board
add constraint fk_board_writer
foreign key (writer) references member2(email)
on update cascade
on delete no action;

alter table comment
add constraint fk_comment_writer
foreign key (writer) references member2(email)
on update cascade
on delete no action;

alter table comment
add constraint fk_comment_bno
foreign key (bno) references board(bno)
on update cascade
on delete no action;