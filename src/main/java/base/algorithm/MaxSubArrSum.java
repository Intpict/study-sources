package main.java.base.algorithm;

/**
 * User: linsen
 * Date: 18/2/27
 * Time: 下午6:44
 * Description: 求数组最大和子区间
 */
public class MaxSubArrSum {

    private static class Ans {

        public int sum;

        public int start = -1;

        public int end = -1;

        @Override
        public String toString() {
            return String.format("sum:%d start:%d end:%d ", sum, start, end);
        }

    }

    public static Ans getMaxSubArraySum(int[] arr) {
        // 初始化结果集
        Ans ans = new Ans();
        // 入参检测
        if (arr == null || arr.length <= 0) {
            return ans;
        }
        // 保存数组第一个元素结果集
        ans.sum = arr[0];
        ans.start = ans.end = 0;

        // 初始化局部变量
        int tmpSum = ans.sum, tmpStart = ans.start, tmpEnd = ans.end;

        for (int i = 1; i < arr.length; i++) {
            if (tmpSum < 0) {
                tmpSum = 0;
                tmpStart = i;
            }
            tmpSum += arr[i];
            tmpEnd = i;
            if (tmpSum > ans.sum) {
                ans.sum = tmpSum;
                ans.start = tmpStart;
                ans.end = tmpEnd;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -4, 8};
        System.out.println(getMaxSubArraySum(arr));
    }

}
