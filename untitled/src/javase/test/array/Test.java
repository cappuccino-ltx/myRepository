package javase.test.array;

public class Test {
    public static void main(String[] args){
        //���н��Ϊ0
        System.out.println(args.length);
        //���������ʲôʱ�����ֵ�أ�
        //��ʵ��������������û��ģ��û����ڿ���̨���������������������Զ�ת��Ϊ��Sting[] args��
        //�����������г���java Test abc def xyz
        //��ô���ʱ��JVM���Զ���abc def xyzͨ���ո�ķ�ʽ�����зָ�ָ����֮���Զ�������
        //String[] args���鵱��
        //����main�������е�String[] args���������������û�����Ĳ����ġ�
        //����abc def xyzת��Ϊ�ַ����������{"abc","def","xyz"}

        System.out.println(args.length);

        for(int i = 0; i < args.length; i++){
            System.out.println(args[i]);
        }
    }
}
