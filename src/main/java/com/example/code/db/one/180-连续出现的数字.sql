/*
 180. 连续出现的数字

表：Logs
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| num         | varchar |
+-------------+---------+
id 是这个表的主键。

编写一个 SQL 查询，查找所有至少连续出现三次的数字。
返回的结果表中的数据可以按 任意顺序 排列。

查询结果格式如下面的例子所示：
示例 1:
输入：
Logs 表：
+----+-----+
| Id | Num |
+----+-----+
| 1  | 1   |
| 2  | 1   |
| 3  | 1   |
| 4  | 2   |
| 5  | 1   |
| 6  | 2   |
| 7  | 2   |
+----+-----+
输出：
Result 表：
+-----------------+
| ConsecutiveNums |
+-----------------+
| 1               |
+-----------------+
解释：1 是唯一连续出现至少三次的数字。
 */

-- 思路1.每个连续的数字会分配一个数值,如果大于三就返回
SELECT DISTINCT Num AS ConsecutiveNums
FROM (SELECT Num,
             if(@pre = Num, @count := @count + 1, @count := 1) AS nums,
             @pre := Num
      FROM Logs AS l,
           (SELECT @pre := NULL, @count := 1) AS pc
     ) AS n
WHERE nums >= 3;

-- 官方思路:连接,ID是连续的,如果ID不是连续的,官方的结题是不对的
SELECT DISTINCT l1.Num AS ConsecutiveNums
FROM Logs l1,
     Logs l2,
     Logs l3
WHERE l1.Id = l2.Id - 1
  AND l2.Id = l3.Id - 1
  AND l1.Num = l2.Num
  AND l2.Num = l3.Num;
