package javase.test.array;

public class twoarr {
    public static void main(String[] args) {
        //int[][] arr = new int[100][0];
        int[][] arr = new int[100][1];
        for (int i = 0; i < 10; i++){
            arr[i][0] = i;
        }
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i][0]);
        }
        String a = "ad";
        System.out.println((a.equals("d"))?a:"d");

    }
}
