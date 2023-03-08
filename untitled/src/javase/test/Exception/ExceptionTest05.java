package javase.test.Exception;

public class ExceptionTest05 {
    public static void main(String[] args){
        int i = exce();
        System.out.println(i);//100
    }

    private static int exce() {
        int i = 10;
        try {
            return i;
        }finally{
            return 10*i;
        }

    }
}
