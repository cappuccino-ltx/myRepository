package javase.test.Class;

public class ClassTest04 {
    public static void main(String[] args){
        /**
         * String int Integer ֮���ת��
         */
        //intת����Stirng
        int a = 100;
        String a1 = a + "";
        System.out.println(a1);

        //Stringת����int
        int a2 = Integer.parseInt(a1);
        System.out.println(a2);

        //intת����Integer(�Զ�װ��)
        Integer b = 101;
        System.out.println(b);

        //Integerת����int(�Զ�����)
        int b1 = b;

        //Stringת����Integer
        Integer b2 = new Integer("123");
        Integer b3 = Integer.valueOf("123");
        System.out.println(b2);
        System.out.println(b3);

        //Integerת����String
        String c = String.valueOf(b3);
        System.out.println(c);
    }
}
