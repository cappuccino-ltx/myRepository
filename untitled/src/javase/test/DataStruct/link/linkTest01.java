package javase.test.DataStruct.link;

/*
    ��������
 */
public class linkTest01 {
    Node header = null;
    int size = 0;

    public linkTest01(){}
    //�������в���Ԫ��
    public boolean add(Object obj){
        if(header == null){
            header = new Node(obj,null);
            size++;
            return true;
        }else {
            Node end = header;
            while(end.next != null){
                end = end.next;
            }
            end.next = new Node(obj, null);
            size++;
            return true;
        }
    }
    public boolean add(int index, Object obj){
        if (index > size + 1){
            System.out.println("�±겻�Ϸ���");
            return false;
        }
        else{
            Node node = header;
            if (index == 0){
                header = new Node(obj, node);
                size++;
            }else {
                for (int i = 0; i < index - 1; i++) {
                    node = node.next;
                }
                node.next = new Node(obj,node.next);
                size++;
            }
        }
        return true;
    }
    //��ȡ�����е�Ԫ��
    public Object get(int index){
        if (index > size || index < 0){
            return "�쳣��ȡ��";
        }
        Node node = header;
        for(int i = 0; i < index; i++){
            node = node.next;
        }
        return node.data;
    }
    //ɾ�������е�Ԫ��
    public boolean remove(Object obj){
        int temp = size;
        Node node = header;
        Node lastNode = header;
        if (header.data == obj){
            header = header.next;
            size--;
            return true;
        }

        for(int i = 0; i < size; i++){
            if(node.data == obj){
                lastNode.next = node.next;
                size--;
            }
            lastNode = node;
            node = node.next;
        }
        if (temp == size){
            System.out.println("δ�ҵ�Ԫ�أ�ɾ��ʧ�ܣ�");
            return false;
        }
        return true;
    }

    //�޸�������ĳ�����ݵķ���
    public boolean modify(Object oldData,Object newData){
        Node node = header;
        for(int i = 0; i < size; i++){
            if(node.data == oldData){
                node.data = newData;
                return true;
            }
            node = node.next;
        }
        System.out.println("δ�ҵ�ƥ��Ԫ�أ��޸�ʧ�ܣ�");
        return false;
    }
}

