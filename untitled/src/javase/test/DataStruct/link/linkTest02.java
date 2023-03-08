package javase.test.DataStruct.link;

/**
 * 双向链表的实现
 */
public class linkTest02 {
    //头结点
    node01 header = null;
    int size = 0;

    public linkTest02() {}

    //插入元素的方法
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
            System.out.println("下标异常！插入失败！");
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
    //获取元素的方法
    public Object get(int index){
        if (index > size - 1|| index < 0){
            return "获取失败";
        }
        node01 node = header;
        for(int i = 0; i < index; i++){
            node = node.next;
        }
        return node.data;
    }
    //删除元素的方法
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
        System.out.println("未找到元素，删除失败！");
        return false;
    }
    //更新元素的方法
    public boolean modify(Object oldData,Object newData){
        node01 node = header;
        for (int i = 0; i < size; i++){
            if(node.data == oldData){
                node.data = newData;
                return true;
            }
            node = node.next;
        }
        System.out.println("未找到元素！更新失败！");
        return false;
    }
}
