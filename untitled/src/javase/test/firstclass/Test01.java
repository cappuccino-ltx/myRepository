package javase.test.firstclass;

public class Test01 {
    public static void main(String[] args){
        cat c = new cat();
        System.out.println(c.q);
        Test01.print(c);
        System.out.println(c.q);
    }

    public static void print(cat c){
        c.q = 20;
        System.out.println(c.q);
    }
}

class cat{
    int q = 10;
}
