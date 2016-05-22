create table books (bookname varchar(20),isbn varchar(20) primary key auto_increment,
author varchar(20),location varchar(20)
);
create table users (name varchar(20), username varchar(20) primary key,
password varchar(20), role varchar(20)
);
create table reviews(isnb int,reveiw varchar(50));


insert into books (bookname,author,location) values ("Sherlock","Sir Arthur Conan Doyle","Dek1");
insert into books (bookname,author,location) values ("Game of Thrones","George RR Martin","Dek2");
insert into books (bookname,author,location) values ("The Perks of being a wallflower","Stephen Chbosky","Dek3");
insert into books (bookname,author,location) values ("The Fault In Our Stars","John Green","Dek4");
insert into books (bookname,author,location) values ("The Cpp Programming Language","Arthur","Dek5");
insert into books (bookname,author,location) values ("Programming In C","Dennis Retchie","Dek6");
insert into books (bookname,author,location) values ("Intoduction to Algorithm","CLRS","Dek7");
insert into books (bookname,author,location) values ("The NewsBook","James Goshling","Dek8");



insert into users values("lokesh","lokesh","lokesh","user");
insert into users values("hemant","hemant","hemant","user");
insert into users values("hemant","hemant","hemant","user");
insert into users values("geetanjali","geetanjali","geetanjali","user");
insert into users values("subhashini","subhashini","subashini","user");
insert into users values("umesh","umesh","umesh","admin");


