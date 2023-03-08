package javase.test.Class;

public class StringTest01 {
    public static void main(String[] args){
        String s1 = "hello";
        String s2 = new String("hello");

        System.out.println(s1 == s2);
        System.out.println(s2.equals("hello"));
    }


}

