package javase.test.subject;

/**
 *
 * 两数之和，判断一个数是有数组内哪两个数的相加得来的。
 * 返回其数组下标
 */
public class twoSum {
    public static int[] twoSum(int[] nums, int target) {
        //定义需要返回的数组
        int[] arr = {-1, -1};
        for (int i = 0; i < nums.length; i++){
            for (int j = i; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int target = 9;
        //调用函数
        int[] arr = twoSum(nums, target);
        if (arr[0] < 0) System.out.println("没有合适结果！");
            //输出返回的数组内容
        else System.out.println("[" + arr[0] + "," + arr[1] + "]");
    }
}
