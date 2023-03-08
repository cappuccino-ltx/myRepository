package javase.test.array;
//
//import sun.font.FontRunIterator;

/**
 * √∞≈›≈≈–ÚÀ„∑®
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {8,4,6,2,7,1,5};

        bubbleSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    public static void bubbleSort(int arr[]) {
        for (int i = arr.length-1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int num = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = num;
                }
            }
        }
    }
}
