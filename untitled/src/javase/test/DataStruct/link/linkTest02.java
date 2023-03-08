package javase.test.DataStruct.link;

/**
 * ˫�������ʵ��
 */
public class linkTest02 {
    //ͷ���
    node01 header = null;
    int size = 0;

    public linkTest02() {}

    //����Ԫ�صķ���
    public void add(Object obj){
        if (header == null){
            header = new node01(null, obj, null);
            size++;
        }else{
            node01 node = header;
            for (int i = 0; i < size - 1;i++){
                node = node.next;
            }
            node.next = new node01(node,obj,null);
            size++;
        }
    }
    public void add(int index,Object obj){
        if (index > size + 1 || index < 0){
            System.out.println("�±��쳣������ʧ�ܣ�");
            return;
        }
        node01 node = header;
        if (index == 0){
            header = new node01(null,obj,header);
            header.next.last = header;
            size++;
            return;
        }
        for(int i = 0; i < index - 1; i++){
            node = node.next;
        }
        node01 temp = new node01(node,obj,node.next);
        node.next = temp;
        node.next.last = temp;
        size++;
    }
    //��ȡԪ�صķ���
    public Object get(int index){
        if (index > size - 1|| index < 0){
            return "��ȡʧ��";
        }
        node01 node = header;
        for(int i = 0; i < index; i++){
            node = node.next;
        }
        return node.data;
    }
    //ɾ��Ԫ�صķ���
    public boolean remove(Object obj){
        if (header.data == obj){
            header = header.next;
            header.last = null;
            size--;
            return true;
        }
        node01 node = header;
        node01 lastNode = header;
        for (int i = 0; i < size; i++){
            if (node.data == obj){
                lastNode.next = node.next;
                node.next.last = lastNode;
                size--;
                return true;
            }
            lastNode = node;
            node = node.next;
        }
        System.out.println("δ�ҵ�Ԫ�أ�ɾ��ʧ�ܣ�");
        return false;
    }
    //����Ԫ�صķ���
    public boolean modify(Object oldData,Object newData){
        node01 node = header;
        for (int i = 0; i < size; i++){
            if(node.data == oldData){
                node.data = newData;
                return true;
            }
            node = node.next;
        }
        System.out.println("δ�ҵ�Ԫ�أ�����ʧ�ܣ�");
        return false;
    }
}
