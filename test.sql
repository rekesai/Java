--设计一张图书表， 包括以下字段：书名、作者、价格、类型
create table book(
    name varchar(20),
    author varchar(20),
    price decimal(11,2),
    type varchar(20)
 );


/*设计一张老师表，包含以下字段：姓名、年龄、身高、体重、性别、学历、生日、身份证号*/
create table teacher(
    name varchar(20),
    age int,
    height double,
    weight decimal(11,2),
    sex varchar(5),
    education varchar(20),
    birth varchar(20),
    ID varchar(20)
);

/*设计一张商品表，包含以下字段：商品名称、商品价格、商品库存、商品描述*/
create table goods(
    goods_name varchar(20),
    goods_price decimal(20,2),
    goods_inventory int,
    goods_desc varchar(50)
);

--在以上创建的商品表中插入一条数据：名称为“学生书包”、价格18.91、库存101、描述为空
insert into (goods_name, goods_price, goods_inventory) values
    ('学生书包', 18.91, 101);


--创建学生表，包含以下字段：姓名、年龄
create table student(
    name varchar(20),
    age int
);


--student学生表中，字段有姓名name，年龄age，要求查询姓张，并且年龄在18到25岁之间的学生
select


--创建考试成绩表
create table exam_result(
    id int,
    name varchar(1000),
    chinese decimal(3, 1),
    math decimal(3, 1),
    english decimal(3, 1)
);

--插入测试数据
insert into exam_result values
    (1, '唐三藏', 67, 98, 56),
    (2, '孙悟空', 87.5, 78, 77),
    (3, '猪悟能', 88, 98, 90),
    (4, '曹孟德', 82, 84, 67),
    (5, '刘玄德', 55.5, 85, 45),
    (6, '孙仲谋', 70, 73, 78.5),
    (7, '宋公明', 75, 65, 30);

--查询所有
select * from exam_result;

--排序---order by + col_name + asc(升序)|desc(降序)  null值视为最小
select * from exam_result order by chinese asc;

--在图书表中新增一条记录：Java核心技术、作者“Cay S. Horstman”，价格56.43，分类为“计算机技术
insert into book valuse
    ('Java核心技术', 'Cay S. Horstman', 56.43, '计算机技术');


--展示编码方式
show variables like '%character%';

--修改某一条的编码方式
set ···=utf8;

--查看所有数据库
show databases;

--创建数据库
create database database_name;

--删除数据库（危险操作，实在不用放着就行了，删库要坐牢）
drop database database_name;

--使用某个数据库（进入到这个数据库）
use database_name;

--查看所有表
show tables;

--展示某个表的结构
desc table_name;

--创建表
create table table_name(
    (col_name1, 数据类型),
    (col_name2, 数据类型)
);

--在表中插入数据，可以插入多行
insert into table_name values (col_name1的数据, col_name2的数据···), (col_name1的数据, col_name2的数据···), ···;

--在表中插入指定列，可以插入多行
insert into table_name (col_name1, col_name2, ···) values (col_name1的数据, col_name2的数据···), ···;

--查看表中所有行
select * from table_name;

--查看指定列内容
select col_name1, col_name2 from table_name;

--给列起别名
select col_name1 as another_name from table_name;

--去重：根据查询结果中某一列或者几列的值进行去重，把重复的行去掉
select distinct col_name from table_name;
--去重，将两列的同行数据作比较，如果相同则去重
select distinct col_name1, col_name2 from table_name;

----排序---order by + col_name + asc(升序)|desc(降序)  null值视为最小
select *|col_name from table_name order by col_name asc|desc;
--查询同学各门成绩，依次按 数学降序，英语升序，语文升序的方式显示
SELECT name, math, english, chinese FROM exam_result ORDER BY math DESC, english, chinese;
