import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Shuihu app = new Shuihu();
//        boolean result = app.canMeasureWater(1, 2, 3);
//        System.out.println(result);

//        MaxPrimeDifference app = new MaxPrimeDifference();
//        int[] nums = {4,2,9,5,3};
//        System.out.println(app.maximumPrimeDifference(nums));

//        RemoveElement app = new RemoveElement();
//        int[] nums = {3,2,2,3};
//        System.out.println(app.removeElement(nums, 3));

//        RemoveDuplicates2 app = new RemoveDuplicates2();
//        int[] nums = {0,0,1,1,1,1,2,3,3};
//        System.out.println(app.removeDuplicates(nums));

//        ModifiedMatrix app = new ModifiedMatrix();
//        int[][] matrix = {{1,2,-1}, {4,-1,6}, {7,8,9}};
//        System.out.println(Arrays.deepToString(app.modifiedMatrix(matrix)));

//        CountAlternatingSubarrays app = new CountAlternatingSubarrays();
//        int[] nums = {1,0,1,0,1,1,0,1};
//        System.out.println(app.countAlternatingSubarrays(nums));

//        RotateArray app = new RotateArray();
//        int[] nums = {-1,-100,3,99};
//        app.rotate(nums, 2);
//        System.out.println(Arrays.toString(nums));

//        MaxProfit app = new MaxProfit();
//        int[] nums = {3,2,6,5,0,3};
//        System.out.println(app.maxProfit(nums));

//        CheckMove app = new CheckMove();
//        char[][] board = {
//                {'.','.','.','B','.','.','.','.'},
//                {'.','.','.','W','.','.','.','.'},
//                {'.','.','.','W','.','.','.','.'},
//                {'.','.','.','W','.','.','.','.'},
//                {'W','B','B','.','W','W','W','B'},
//                {'.','.','.','B','.','.','.','.'},
//                {'.','.','.','B','.','.','.','.'},
//                {'.','.','.','W','.','.','.','.'}
//        };
//
//        char[][] board = {
//                {'W','W','.','B','.','B','B','.'},
//                {'W','B','.','.','W','B','.','.'},
//                {'B','B','B','B','W','W','B','.'},
//                {'W','B','.','.','B','B','B','.'},
//                {'W','W','B','.','W','.','B','B'},
//                {'B','.','B','W','.','B','.','.'},
//                {'.','B','B','W','B','B','.','.'},
//                {'B','B','W','.','.','B','.','.'}
//        };

//        char[][] board = {
//                {'.','.','.','.','.','.','.','.'},
//                {'.','B','.','.','W','.','.','.'},
//                {'.','.','W','.','.','.','.','.'},
//                {'.','.','.','W','B','.','.','.'},
//                {'.','.','.','.','.','.','.','.'},
//                {'.','.','.','.','B','W','.','.'},
//                {'.','.','.','.','.','.','W','.'},
//                {'.','.','.','.','.','.','.','B'}
//        };
//
//        System.out.println(app.checkMove(board, 4, 4, 'W'));

//        PivotIndex app = new PivotIndex();
//        int[] nums = {2, 1, -1};
//        System.out.println(app.pivotIndex(nums));

//        MinimumDistance app = new MinimumDistance();
//        int[][] points = {{3,10},{5,15},{10,2},{4,4}};
//        System.out.println(app.minimumDistance(points));

//        MaxProfitV2 app = new MaxProfitV2();
//        int[] prices = {7,1,5,3,6,4};
//        System.out.println(app.maxProfit(prices));

//        CanJump app = new CanJump();
//        int[] nums = {1,3,2};
//        System.out.println(app.canJump(nums));

//        IncremovableSubarrayCount app = new IncremovableSubarrayCount();
//        int[] nums = {8,7,6,6};
//        System.out.println(app.incremovableSubarrayCount(nums));

//        CanSortArray app = new CanSortArray();
//        int[] nums = {8,4,2,30,15};
//        System.out.println(app.canSortArrayV2(nums));
//        System.out.println(Arrays.toString(nums));

//        Jump app = new Jump();
//        int[] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
//        System.out.println(app.jump(nums));

//        HIndex app = new HIndex();
//        int[] citations = {3, 0, 6, 1, 5};
//        System.out.println(app.hIndex(citations));

//        MaxIncreaseKeepingSkyline app = new MaxIncreaseKeepingSkyline();
//        int[][] grid = {{3,0,8,4}, {2,4,5,7}, {9,2,6,3}, {0,3,1,0}};
//        System.out.println(app.maxIncreaseKeepingSkyline(grid));

//        AccountsMerge app = new AccountsMerge();
//        List<List<String>> accounts = new ArrayList<>();
//        String[][] acc = {{"John","johnsmith@mail.com","john_newyork@mail.com"},{"John","johnsmith@mail.com","john00@mail.com"},{"Mary","mary@mail.com"},{"John","johnnybravo@mail.com"}};
//        String[][] acc = {{"Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"},{"Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"},{"Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"},{"Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"},{"Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"}};
//        String[][] acc = {{"David","David0@m.co","David1@m.co"},{"David","David3@m.co","David4@m.co"},{"David","David4@m.co","David5@m.co"},{"David","David2@m.co","David3@m.co"},{"David","David1@m.co","David2@m.co"}};
//        for (String[] strings : acc) {
//            List<String> list = new ArrayList<>();
//            Collections.addAll(list, strings);
//            accounts.add(list);
//        }
//
//        System.out.println(app.accountsMerge(accounts));

//        FindIntersectionValues app = new FindIntersectionValues();
//        int[] num1 = {4,3,2,3,1};
//        int[] num2 = {2,2,5,2,3,6};
//        System.out.println(Arrays.toString(app.findIntersectionValuesV3(num1, num2)));

//        LongestConsecutive app = new LongestConsecutive();
//        int[] nums = {0,3,7,2,5,8,4,6,0,1};
//        System.out.println(app.longestConsecutive(nums));

//        MinimumTime app = new MinimumTime();
//        int n = 5;
//        int[][] edges = {{2,3,2},{4,4,9},{4,0,10},{4,3,4},{4,0,3}};
//        int[] disappear = {8,20,10,17,19};
//        System.out.println(Arrays.toString(app.minimumTime(n, edges, disappear)));

//        MaximumDetonation app = new MaximumDetonation();
//        int[][] bombs = {{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}};
//        System.out.println(app.maximumDetonation(bombs));

//        LengthOfLIS app = new LengthOfLIS();
//        int[] nums = {10,9,2,5,3,7,101,18};
//        System.out.println(app.lengthOfLIS(nums));

//        FindPeakElement app = new FindPeakElement();
//        int[] nums = {1,2,1,3,5,6,4};
//        System.out.println(app.findPeakElement(nums));

//        RelocateMarbles app = new RelocateMarbles();
//        int[] nums = {1,6,7,8};
//        int[] moveFrom = {1,7,2};
//        int[] moveTo = {2,9,5};
//        System.out.println(app.relocateMarbles(nums, moveFrom, moveTo));

//        MinimumOperations app = new MinimumOperations();
//        String num = "1111101";
//        System.out.println(app.minimumOperations(num));

//        FindValueOfPartition app = new FindValueOfPartition();
//        int[] nums = {100,1,10};
//        System.out.println(app.findValueOfPartition(nums));

//        CalPoints app = new CalPoints();
//        String[] ops = {"5","2","C","D","+"};
//        System.out.println(app.calPoints(ops));

//        Permute app = new Permute();
//        int[] nums = {0,1};
//        System.out.println(app.permute(nums));

//        CoinChange app = new CoinChange();
//        int[] coins = {1, 2, 5};
//        System.out.println(app.coinChange(coins, 11));

//        TopK app = new TopK();
//        int[] nums = {3,2,3,1,2,4,5,5,6};
//        System.out.println(app.findKthLargest(nums, 4));
//        System.out.println(Arrays.toString(nums));

//        Sort app = new Sort();
//        int[] nums = {3,2,3,1,2,4,5,5,6};

//        LengthOfLongestSubstring app = new LengthOfLongestSubstring();
//        String s = "abcabcbb";
//        System.out.println(app.lengthOfLongestSubstring(s));

//        MinSubArrayLen app = new MinSubArrayLen();
//        int[] nums = {5,1,3,5,10,7,4,9,2,8};
//        System.out.println(app.minSubArrayLen(15, nums));

//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        System.out.println(minStack.getMin());
//        minStack.pop();
//        System.out.println(minStack.top());
//        System.out.println(minStack.getMin());

        LetterCombinations app = new LetterCombinations();
        String digits = "234";
        System.out.println(app.letterCombinations(digits));
    }
}