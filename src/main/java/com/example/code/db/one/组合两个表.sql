/*
175. 组合两个表

表1: Person
+-------------+---------+
| 列名         | 类型     |
+-------------+---------+
| PersonId    | int     |
| FirstName   | varchar |
| LastName    | varchar |
+-------------+---------+
PersonId 是上表主键

表2: Address
+-------------+---------+
| 列名         | 类型    |
+-------------+---------+
| AddressId   | int     |
| PersonId    | int     |
| City        | varchar |
| State       | varchar |
+-------------+---------+
AddressId 是上表主键

编写一个 SQL 查询，满足条件：无论 person 是否有地址信息，都需要基于上述两表提供 person 的以下信息：

FirstName, LastName, City, State
*/

-- 左连接
SELECT
    a.FirstName,
    a.LastName,
    b.City,
    b.State
FROM
    Person a
 LEFT JOIN Address b
    ON a.PersonId = b.PersonId;

-- 类似子查询的方式
select
    a.FirstName,
    a.LastName,
    (select b.city from Address b where a.PersonId = b.PersonId) city,
    (select b.State from Address b where a.PersonId = b.PersonId) State
from
    Person a