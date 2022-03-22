/*
 177. 第N高的薪水
表: Employee
+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| salary      | int  |
+-------------+------+
Id是该表的主键列。
该表的每一行都包含有关员工工资的信息。

编写一个SQL查询来报告 Employee 表中第 n 高的工资。如果没有第 n 个最高工资，查询应该报告为 null 。
查询结果格式如下所示。
示例 1:
输入:
Employee table:
+----+--------+
| id | salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
n = 2
输出:
+------------------------+
| getNthHighestSalary(2) |
+------------------------+
| 200                    |
+------------------------+

示例 2:
输入:
Employee 表:
+----+--------+
| id | salary |
+----+--------+
| 1  | 100    |
+----+--------+
n = 2
输出:
+------------------------+
| getNthHighestSalary(2) |
+------------------------+
| null                   |
+------------------------+

 */

-- 思路一:排序,然后找第几个
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    SET N := N - 1;
    RETURN (
        # Write your MySQL query statement below.
        SELECT salary
        FROM employee
        GROUP BY salary
        ORDER BY salary DESC
        LIMIT N, 1
    );
END;
-- 思路二:先排序存到临时表,然后查询临时表,官方测试依然不通过
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    RETURN (
        # Write your MySQL query statement below.
        SELECT salary
        FROM (
                 select id,
                        salary,
                        @rank := if(salary is not null, @rank + 1, @rank) as rownum
                 from employee,
                      (select @rank := 0) as init
                 group by id, salary
                 order by salary desc
             ) a
        WHERE a.rownum = N
    );
END;
