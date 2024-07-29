/*
给你一个下标从 0 开始的字符串 num ，表示一个非负整数。
在一次操作中，您可以选择 num 的任意一位数字并将其删除。请注意，如果你删除 num 中的所有数字，则 num 变为 0。
返回最少需要多少次操作可以使 num 变成特殊数字。
如果整数 x 能被 25 整除，则该整数 x 被认为是特殊数字。

示例 1：

输入：num = "2245047"
输出：2
解释：删除数字 num[5] 和 num[6] ，得到数字 "22450" ，可以被 25 整除。
可以证明要使数字变成特殊数字，最少需要删除 2 位数字。

示例 2：

输入：num = "2908305"
输出：3
解释：删除 num[3]、num[4] 和 num[6] ，得到数字 "2900" ，可以被 25 整除。
可以证明要使数字变成特殊数字，最少需要删除 3 位数字。

示例 3：

输入：num = "10"
输出：1
解释：删除 num[0] ，得到数字 "0" ，可以被 25 整除。
可以证明要使数字变成特殊数字，最少需要删除 1 位数字。

题号：2844
* */

/*
* 知识点：贪心
* */

public class MinimumOperations {
    public int minimumOperations(String num) {
        int len = num.length();
        int result = Integer.MAX_VALUE;

        // 能被25整除的数的性质：
        // num为1位时，0能被25整除
        // num为2位时，25、50、75能被整除
        // num大于等于3位时，以00、25、50、75 结尾的数能被整除

        // 从后往前遍历
        int drop = 0;
        int d;
        for (int i = len - 1; i >= 0; i--) {
            char c = num.charAt(i);
            // 判断是否为 0 或者 5
            // 如果是的话，进入子循环，看要去除多少连续位，能够满足被25整除的数尾条件
            // 如果不是的话，直接去除
            if (c == '5' || c == '0') {
                d = 0;
                // 从 0 和 5 的为止往前遍历，找出最短的被去除的连续位的长度
                for (int j = i - 1; j >= 0; j--) {
                    char cc = num.charAt(j);
                    if (c == '5' && (cc == '2' || cc == '7')) {
                        break;
                    }

                    if (c == '0' && (cc == '0' || cc == '5')) {
                        break;
                    }

                    d++;
                }

                // 特殊处理，因为result的判断快于外循环的drop++
                if (c == '5' && d == i) {
                    d++;
                }

                result = Math.min(result, drop + d);
            }

            drop++;
        }

        return result == Integer.MAX_VALUE ? len : result;
    }
}
