package javase.test.array;
/**
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args){
        int[] arr = {4,3,6,2,9,5,7};
        //调用选择排序方法
        selectSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "、");
        }
        for (int j : arr){
            System.out.print(j + "、");
        }
    }
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length - 1 ; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] <= arr[min]) min = j;
            }
            if (min != i) {
                //交换数据
                /*int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;*/
                //不创建第三个变量进行数据的交换。
                arr[i] = arr[i] ^ arr[min];
                arr[min] = arr[i] ^ arr[min];
                arr[i] = arr[i] ^arr[min];
            }
        }

    }
}
