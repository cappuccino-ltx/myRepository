package javase.test.array;

/**
 * 二分法查找数据
 */
public class ArraySearch {
    //不使用二分查找的方法
    public static int lookup(int[] arr, int temp){
        for (int i = 0; i < arr.length; i++) {
            if (temp == arr[i]){
                return i;
            }
        }
        return -1;
    }
    //使用二分查找的方法
    public static int lookup1(int[] arr, int temp){
        int left = 0;
        int right = arr.length;
        for (int i = 0;i < arr.length;i++){
            int mid = (left + right)/2;
            if (temp == arr[mid]) return mid;
            if (temp < arr[mid]) right = mid - 1;
            if (temp > arr[mid]) left = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int temp = 6;

        System.out.println("不使用二分查找___________________________________________");
        int n = lookup(arr, temp);
        if(n == -1) System.out.println("数组中没有" + temp);
        else System.out.println(temp + "的下标是" + n);


        System.out.println("\n使用二分查找_____________________________________________");
        int m = lookup1(arr, temp);
        if (n == -1) System.out.println("数组中没有" + temp);
        else System.out.println(temp + "的下标是" + m);
    }
}
