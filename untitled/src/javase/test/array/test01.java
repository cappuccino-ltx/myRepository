package javase.test.array;
/*编写程序，使用一维数组，模拟栈数据结构
            要求：
                1、这个栈可以存放java中所有引用类型的数据；
                2、在栈中提供push方法压栈；
                3、在栈中提供pop方法弹栈；
                4、编写测试程序，new一个栈对象，调用push和pop方法实现压站和弹栈的动作：
*/
//测试类
public class test01 {
    public static void main(String[] args) {
        //new一个栈对象
        Stack stack = new Stack();
        //进行十次压栈
        for (int i = 0; i < 10; i++) {
            String a = "abc";
            stack.push(a);
        }
        //栈满后继续压栈
        stack.push(new String("abc"));
        //进行九次弹栈
        Object[] arr = new Object[20];
        for (int i = 0; i < 10; i++) {
            arr[i] = stack.pop();
        }
        //栈空后，继续弹栈
        arr[10] = stack.pop();
    }
}
//栈类
class Stack{
    //用来模拟栈的数组
    private Object[] array;
    //栈帧
    private int index;

    //构造函数
    public Stack(){
        this.array = new Object[10];
        this.index = -1;
    }
    public Stack(Object[] array) {
        this.array = array;
    }

    //set\get方法


    public Object[] getArray() {
        return array;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }

    //压栈方法
    public void push(Object obj){
        if(this.index == this.array.length - 1) {
            System.out.println("栈溢出，无法执行压栈操作！！！");
            return;
        }

        this.array[++this.index] = obj;
        if(this.index == this.array.length - 1)
            System.out.println("栈已满！！！");

    }
    //弹栈方法。
    public Object pop(){
        if(this.index == -1) {
            System.out.println("栈以空，无法执行弹栈操作！！！");
            return null;
        }
        Object obj = this.array[index--];
        if(this.index == 0)
            System.out.println("弹栈成功！栈以清空！！！");
        return obj;
    }
}
