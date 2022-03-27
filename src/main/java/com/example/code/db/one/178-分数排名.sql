/*
 178. 分数排名
SQL架构
表: Scores

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| score       | decimal |
+-------------+---------+
Id是该表的主键。
该表的每一行都包含了一场比赛的分数。Score是一个有两位小数点的浮点值。

编写 SQL 查询对分数进行排序。排名按以下规则计算:

分数应按从高到低排列。
如果两个分数相等，那么两个分数的排名应该相同。
在排名相同的分数后，排名数应该是下一个连续的整数。换句话说，排名之间不应该有空缺的数字。
按 score 降序返回结果表。

查询结果格式如下所示。

示例 1:

输入:
Scores 表:
+----+-------+
| id | score |
+----+-------+
| 1  | 3.50  |
| 2  | 3.65  |
| 3  | 4.00  |
| 4  | 3.85  |
| 5  | 4.00  |
| 6  | 3.65  |
+----+-------+
输出:
+-------+------+
| score | rank |
+-------+------+
| 4.00  | 1    |
| 4.00  | 1    |
| 3.85  | 2    |
| 3.65  | 3    |
| 3.65  | 3    |
| 3.50  | 4    |
+-------+------+
 */

-- 思路1.把成绩排好名次作为一个临时表,用成绩去关联查询
SELECT a.score,
       CAST(b.rownum as SIGNED) as `rank`
FROM Scores a
         LEFT JOIN (
    SELECT score,
           @rank := if(score is not null,
                       @rank + 1,
                       @rank) as rownum
    from (
             SELECT score
             FROM Scores
             group by score
             ORDER BY score DESC) t,
         (
             select @rank := 0) as init
) b ON
    a.score = b.score
ORDER BY b.rownum

-- 思路2.使用函数
    -- 1.rank() over：排名相同的两名是并列，但是占两个名次，1 1 3 4 4 6这种
    -- 2.dense_rank() over：排名相同的两名是并列，共占一个名词，1 1 2 3 3 4这种
    -- 3.row_number() over这个函数不需要考虑是否并列，哪怕根据条件查询出来的数值相同也会进行连续排名 1 2 3 4 5
SELECT
    Score ,
    dense_rank() over (order by Score desc)  as 'Rank'
-- 不指定 partition by 相当于所有行数据一个 partition, 数据进行区内排序
-- dense_rank() 相当于每一行数据一个窗口, 对数据进行比较
FROM Scores;