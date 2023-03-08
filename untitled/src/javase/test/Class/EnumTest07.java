package javase.test.Class;

/**
 * enum��ö�����ͣ�
 * ö����һ�������������ͣ��ڱ������б������֮��Ҳ��һ��.class�ļ�
 * ö���е�ÿһ��ֵ�����Կ���һ��������
 * �ڱ���У�������boolean��������ȥ��ʾ�򵥵�ture��false������ʵ����һ��ö�ٷ�ʽ
 * ����˵��һ����ֹ����״̬�Ķ����磺̨���йرա����⣬ǿ�⣬������״̬��
 * ��ʱ��Ӧ����ö������ʾ
 * public enum State{
 *     //�رա����⡢ǿ��
 *     CLOSE,WEAK,STRONG
 * }
 *
 *  �ڱ�д�����ʱ�򣬿��ܵ��������һһö�ٳ����Ķ�������������ö������ȥ��д��
 *
 *  �����ڣ��ļ������ڣ���ɫ����λ״̬��
 */

//һ��̨�ƣ�������ʾ����ʱ��һ��״̬���رգ����⣬ǿ�⡣
public class EnumTest07 {
    public static void main(String[] args){
        Lamp taideng = new Lamp(State.CLOSE);
        taideng.setState(State.STRONG);
        System.out.println(taideng);
    }
}


 /**
  * ̨���ࣺ
  */
class Lamp{
    State state;

    public Lamp() {
    }

    public Lamp(State state) {
        this.state = state;
    }

    public void setState(State state){
        this.state = state;
    }
    public State getState(){
        return this.state;
    }

    @Override
    public String toString() {
        if (this.state == State.CLOSE) return "�ر�";
        else if (this.state == State.WEAK) return "����";
        else return "ǿ��";
    }
}

//״̬��ö������
enum State{
    //�رգ����⣬ǿ��
    CLOSE,WEAK,STRONG//��Щ����ö�ٳ���
}
