package javase.test.DataStruct.link;

/**
 * ��������ڵ�
 */
public class Node{
    //������
    Object data;
    //ָ����
    Node next;

    public Node(){}

    public Node(Object obj, Node next){
        this.data = obj;
        this.next = next;
    }
}
