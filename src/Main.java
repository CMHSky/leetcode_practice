import java.util.Arrays;

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

        ModifiedMatrix app = new ModifiedMatrix();
        int[][] matrix = {{1,2,-1}, {4,-1,6}, {7,8,9}};
        System.out.println(Arrays.deepToString(app.modifiedMatrix(matrix)));
    }
}