package javase.test.DataStruct.link;

/**
 * 单向链表节点
 */
public class Node{
    //数据域
    Object data;
    //指针域
    Node next;

    public Node(){}

    public Node(Object obj, Node next){
        this.data = obj;
        this.next = next;
    }
}
