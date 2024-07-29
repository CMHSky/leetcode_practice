/*
给你一个下标从 0 开始的数组 points ，它表示二维平面上一些点的整数坐标，其中 points[i] = [xi, yi] 。
两点之间的距离定义为它们的曼哈顿距离。
请你恰好移除一个点，返回移除后任意两点之间的 最大 距离可能的 最小 值。

示例 1：

输入：points = [[3,10],[5,15],[10,2],[4,4]]
输出：12
解释：移除每个点后的最大距离如下所示：
- 移除第 0 个点后，最大距离在点 (5, 15) 和 (10, 2) 之间，为 |5 - 10| + |15 - 2| = 18 。
- 移除第 1 个点后，最大距离在点 (3, 10) 和 (10, 2) 之间，为 |3 - 10| + |10 - 2| = 15 。
- 移除第 2 个点后，最大距离在点 (5, 15) 和 (4, 4) 之间，为 |5 - 4| + |15 - 4| = 12 。
- 移除第 3 个点后，最大距离在点 (5, 15) 和 (10, 2) 之间的，为 |5 - 10| + |15 - 2| = 18 。
在恰好移除一个点后，任意两点之间的最大距离可能的最小值是 12 。

示例 2：

输入：points = [[1,1],[1,1],[1,1]]
输出：0
解释：移除任一点后，任意两点之间的最大距离都是 0 。

题号：3102
* */


import java.util.*;

public class MinimumDistance {
    List<int[]> distances = new ArrayList<>();
    public int minimumDistance(int[][] points) {
        int maxA = 0;
        int maxB = 0;
        int maximum = Integer.MIN_VALUE;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] distance = new int[3];
                distance[0] = i;
                distance[1] = j;
                distance[2] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                if (distance[2] > maximum) {
                    maximum = distance[2];
                    maxA = i;
                    maxB = j;
                }

                distances.add(distance);
            }
        }

        distances.sort(Comparator.comparingInt((int[] o) -> o[2]).reversed());

        int minimumA = 0;
        int minimumB = 0;

        // 去除A获得的最大距离的最小值
        for (int[] distance: distances) {
            if (distance[0] == maxA || distance[1] == maxA) {
                continue;
            }

            minimumA = distance[2];
            break;
        }

        // 去除B获得的最大距离的最小值
        for (int[] distance: distances) {
            if (distance[0] == maxB || distance[1] == maxB) {
                continue;
            }

            minimumB = distance[2];
            break;
        }

        return Math.min(minimumA, minimumB);
    }
}
