package javase.test.DataStruct.link;

/**
 * ˫������ڵ�
 */
public class node01 {
    //�ϸ��ڵ�ĵ�ַ
    node01 last;
    //����
    Object data;
    //�¸��ڵ�ĵ�ַ
    node01 next;

    public node01(){}
    public node01(node01 last, Object data, node01 next) {
        this.last = last;
        this.data = data;
        this.next = next;
    }
}
