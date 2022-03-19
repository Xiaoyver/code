/*
176. 第二高的薪水

Employee 表：
    +-------------+------+
    | Column Name | Type |
    +-------------+------+
    | id          | int  |
    | salary      | int  |
    +-------------+------+
    id 是这个表的主键。
    表的每一行包含员工的工资信息。

编写一个 SQL 查询，获取并返回 Employee 表中第二高的薪水 。如果不存在第二高的薪水，查询应该返回 null 。
查询结果如下例所示。
示例 1：
    输入：
    Employee 表：
    +----+--------+
    | id | salary |
    +----+--------+
    | 1  | 100    |
    | 2  | 200    |
    | 3  | 300    |
    +----+--------+
    输出：
    +---------------------+
    | SecondHighestSalary |
    +---------------------+
    | 200                 |
    +---------------------+
示例 2：
    输入：
    Employee 表：
    +----+--------+
    | id | salary |
    +----+--------+
    | 1  | 100    |
    +----+--------+
    输出：
    +---------------------+
    | SecondHighestSalary |
    +---------------------+
    | null                |
    +---------------------+

 */

-- 成功的SQL,稳定在220ms
SELECT
    IFNULL(
            (SELECT DISTINCT Salary
             FROM Employee
             ORDER BY Salary DESC
             LIMIT 1 , 1),
            NULL) AS SecondHighestSalary;
-- 我的解法,不稳定:230- 550ms
SELECT MAX(salary) AS SecondHighestSalary FROM Employee WHERE  salary < (
    SELECT MAX(salary) FROM Employee
)
-- 我的SQL,官方示例不通过
SELECT IFNULL(salary,NULL) SecondHighestSalary FROM Employee ORDER BY salary DESC LIMIT 1,1;
