package javase.test.practice;

public class Test01 {
    public static void main(String[] args) {
        String s = "abcd";
        char[] arr = s.toCharArray();
        for (char i : arr){
            System.out.println(i);
        }
        System.out.println(arr);
    }
}
