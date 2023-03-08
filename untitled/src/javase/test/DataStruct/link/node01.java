package javase.test.DataStruct.link;

/**
 * 双向链表节点
 */
public class node01 {
    //上个节点的地址
    node01 last;
    //数据
    Object data;
    //下个节点的地址
    node01 next;

    public node01(){}
    public node01(node01 last, Object data, node01 next) {
        this.last = last;
        this.data = data;
        this.next = next;
    }
}
