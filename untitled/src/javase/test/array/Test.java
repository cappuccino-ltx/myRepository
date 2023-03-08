package javase.test.array;

public class Test {
    public static void main(String[] args){
        //运行结果为0
        System.out.println(args.length);
        //那这个数组什么时候会有值呢？
        //其实这个数组是留给用户的，用户可在控制台上输入参数，这个参数会自动转化为“Sting[] args”
        //例如这样运行程序：java Test abc def xyz
        //那么这个时候，JVM会自动将abc def xyz通过空格的方式来进行分割，分割完成之后，自动方法到
        //String[] args数组当中
        //所以main方法当中的String[] args数组是用来接收用户输入的参数的。
        //将将abc def xyz转化为字符串数组就是{"abc","def","xyz"}

        System.out.println(args.length);

        for(int i = 0; i < args.length; i++){
            System.out.println(args[i]);
        }
    }
}
