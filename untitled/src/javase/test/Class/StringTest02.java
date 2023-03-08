package javase.test.Class;

public class StringTest02 {
    public static void main(String [] args){
        char c = "我是学生".charAt(0);
        System.out.println(c);//我

        int temp1 = "abc".compareTo("abc");
        System.out.println(temp1); //0,前后一致
        temp1 = "aac".compareTo("abf");
        System.out.println(temp1);//-1,前小后大
        temp1 = "abf".compareTo("abc");
        System.out.println(temp1);//3，前大后小，大多少

        System.out.println("java.lang.String".contains("java.lang"));
        System.out.println("http://www.baidu.com".contains("https://"));
        System.out.println("ABC".equalsIgnoreCase("abc"));
        System.out.println("cc++c#pythonjavaMysql".indexOf("java"));
        System.out.println("".isEmpty());
        String newString1 = "http://www.baidu.com".replace("http://", "https://");
        System.out.println(newString1);
        String newString2 = "name=zhangsan&password=123&age=23".replace("=", ":");
        System.out.println(newString2);
    }
}
