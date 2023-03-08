package javase.test.DataStruct.link;
/**
 *  单向链表测试程序
 */
public class linkedMainTest01 {
    public static void main(String[] args) {
        linkTest01 mylink = new linkTest01();
        mylink.add(1);
        mylink.add(2);
        mylink.add(3);
        mylink.add(0,4);
        mylink.add(4, 5);
        mylink.remove(3);
        mylink.modify(5,"abc");
        for (int i = 0; i < mylink.size; i++){
            System.out.println(mylink.get(i));
        }
    }
}
