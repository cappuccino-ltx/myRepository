package javase.test.array;
/*��д����ʹ��һά���飬ģ��ջ���ݽṹ
            Ҫ��
                1�����ջ���Դ��java�������������͵����ݣ�
                2����ջ���ṩpush����ѹջ��
                3����ջ���ṩpop������ջ��
                4����д���Գ���newһ��ջ���󣬵���push��pop����ʵ��ѹվ�͵�ջ�Ķ�����
*/
//������
public class test01 {
    public static void main(String[] args) {
        //newһ��ջ����
        Stack stack = new Stack();
        //����ʮ��ѹջ
        for (int i = 0; i < 10; i++) {
            String a = "abc";
            stack.push(a);
        }
        //ջ�������ѹջ
        stack.push(new String("abc"));
        //���оŴε�ջ
        Object[] arr = new Object[20];
        for (int i = 0; i < 10; i++) {
            arr[i] = stack.pop();
        }
        //ջ�պ󣬼�����ջ
        arr[10] = stack.pop();
    }
}
//ջ��
class Stack{
    //����ģ��ջ������
    private Object[] array;
    //ջ֡
    private int index;

    //���캯��
    public Stack(){
        this.array = new Object[10];
        this.index = -1;
    }
    public Stack(Object[] array) {
        this.array = array;
    }

    //set\get����


    public Object[] getArray() {
        return array;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }

    //ѹջ����
    public void push(Object obj){
        if(this.index == this.array.length - 1) {
            System.out.println("ջ������޷�ִ��ѹջ����������");
            return;
        }

        this.array[++this.index] = obj;
        if(this.index == this.array.length - 1)
            System.out.println("ջ����������");

    }
    //��ջ������
    public Object pop(){
        if(this.index == -1) {
            System.out.println("ջ�Կգ��޷�ִ�е�ջ����������");
            return null;
        }
        Object obj = this.array[index--];
        if(this.index == 0)
            System.out.println("��ջ�ɹ���ջ����գ�����");
        return obj;
    }
}
