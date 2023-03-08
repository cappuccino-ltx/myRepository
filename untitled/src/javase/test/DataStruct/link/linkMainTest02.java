package javase.test.DataStruct.link;

/**
 * Ë«ÏòÁ´±í²âÊÔ³ÌĞò
 */
public class linkMainTest02 {
    public static void main(String[] args) {
        linkTest02 mylink = new linkTest02();
        mylink.add("abc");
        mylink.add("def");
        mylink.add(123);
        mylink.add(456);
        mylink.add(0,"lll");
        mylink.remove("lll");
        mylink.modify(123,"xiumei");
        for (int i = 0; i < mylink.size; i++){
            System.out.println(mylink.get(i));
        }
    }
}
