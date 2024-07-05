/*
给你一个下标从 0 开始、大小为 m x n 的整数矩阵 matrix ，新建一个下标从 0 开始、名为 answer 的矩阵。使 answer 与 matrix 相等，接着将其中每个值为 -1 的元素替换为所在列的 最大 元素。

返回矩阵 answer 。

示例 1：

输入：matrix = [[1,2,-1],[4,-1,6],[7,8,9]]
输出：[[1,2,9],[4,8,6],[7,8,9]]
解释：上图显示了发生替换的元素（蓝色区域）。
- 将单元格 [1][1] 中的值替换为列 1 中的最大值 8 。
- 将单元格 [0][2] 中的值替换为列 2 中的最大值 9 。

示例 2：

输入：matrix = [[3,-1],[5,2]]
输出：[[3,2],[5,2]]
解释：上图显示了发生替换的元素（蓝色区域）。
* */

/*
* 知识点：多维数组
* */

public class ModifiedMatrix {
    public int[][] modifiedMatrix(int[][] matrix) {
        int[][] answer = new int[matrix.length][];

        for (int i = 0; i < matrix.length; i++) {
            answer[i] = new int[matrix[i].length];
            System.arraycopy(matrix[i], 0, answer[i], 0, matrix[i].length);
        }

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                if (answer[i][j] == -1) {
                    int max = -1;
                    for (int[] row : matrix) {
                        if (row[j] > max) {
                            max = row[j];
                        }
                    }

                    answer[i][j] = max;
                }
            }
        }

        return answer;
    }
}
