package javase.test.DataStruct.link;

/*
    单向链表
 */
public class linkTest01 {
    Node header = null;
    int size = 0;

    public linkTest01(){}
    //往链表中插入元素
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
            System.out.println("下标不合法！");
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
    //获取链表中的元素
    public Object get(int index){
        if (index > size || index < 0){
            return "异常获取！";
        }
        Node node = header;
        for(int i = 0; i < index; i++){
            node = node.next;
        }
        return node.data;
    }
    //删除链表中的元素
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
            System.out.println("未找到元素！删除失败！");
            return false;
        }
        return true;
    }

    //修改链表中某个数据的方法
    public boolean modify(Object oldData,Object newData){
        Node node = header;
        for(int i = 0; i < size; i++){
            if(node.data == oldData){
                node.data = newData;
                return true;
            }
            node = node.next;
        }
        System.out.println("未找到匹配元素！修改失败！");
        return false;
    }
}

