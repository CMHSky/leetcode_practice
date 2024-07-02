/*
有两个水壶，容量分别为 x 和 y 升。水的供应是无限的。确定是否有可能使用这两个壶准确得到 target 升。

你可以：

装满任意一个水壶
清空任意一个水壶
将水从一个水壶倒入另一个水壶，直到接水壶已满，或倒水壶已空。

示例 1:

输入: x = 3,y = 5,target = 4
输出: true
解释：
按照以下步骤操作，以达到总共 4 升水：
1. 装满 5 升的水壶(0, 5)。
2. 把 5 升的水壶倒进 3 升的水壶，留下 2 升(3, 2)。
3. 倒空 3 升的水壶(0, 2)。
4. 把 2 升水从 5 升的水壶转移到 3 升的水壶(2, 0)。
5. 再次加满 5 升的水壶(2, 5)。
6. 从 5 升的水壶向 3 升的水壶倒水直到 3 升的水壶倒满。5 升的水壶里留下了 4 升水(3, 4)。
7. 倒空 3 升的水壶。现在，5 升的水壶里正好有 4 升水(0, 4)。

示例 2:

输入: x = 2, y = 6, target = 5
输出: false

示例 3:

输入: x = 1, y = 2, target = 3
输出: true
解释：同时倒满两个水壶。现在两个水壶中水的总量等于 3。

提示:

1 <= x, y, target <= 103
* */

/*
* 知识点： 递归， DFS 深度优先搜索
* 思路：使用DFS遍历所有可能达成的状态，直到找到目标容量
* */

import java.util.HashSet;
import java.util.Set;

public class Shuihu {
    int capacityA, capacityB, target;
    private Set<Long> status = new HashSet<>();
    public boolean canMeasureWater(int x, int y, int target) {
        this.capacityA = x;
        this.capacityB = y;
        this.target = target;

        // 两容器的容量之和需要大于目标容量
        if (x + y < target) {
            return false;
        }

        // 递归调用
        return dfs(0, 0);
    }

    private boolean dfs(int curA, int curB) {
        // 使用一个HashSet记录所有已达成的状态
        // 避免进行重复操作
        long key = getLong(curA, curB);
        if (!this.status.add(key)) return false;

        int a2b = Math.min(curA, this.capacityB - curB);
        int b2a = Math.min(curB, this.capacityA - curA);
        return curA == this.target                          // 成功条件1： A容器容量 = 目标容量
                || curB == this.target                      // 成功条件2： B容器容量 = 目标容量
                || curA + curB == this.target               // 成功条件3： A容器容量 + B容器容量 = 目标容量
                || dfs(0, curB)                        // 操作1： 清空A容器
                || dfs(curA, 0)                        // 操作2： 清空B容器
                || dfs(this.capacityA, curB)                // 操作3： 倒满A容器
                || dfs(curA, this.capacityB)                // 操作4： 倒满B容器
                || dfs(curA - a2b, curB + a2b)   // 操作5： A容器倒往B容器
                || dfs(curA + b2a, curB - b2a);  // 操作6： B容器倒往A容器
    }

    private long getLong(int x, int y) {
        return x * 1000000L + y;
    }
}
