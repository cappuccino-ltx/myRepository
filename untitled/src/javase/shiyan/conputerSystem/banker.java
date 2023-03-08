package javase.shiyan.conputerSystem;
import java.util.Scanner;
public class banker{
    static int n,m;
    int[][] Available = new int[100][1];//��Դ����
    int[][] Max = new int[100][100];//����������
    int[][] Allocation = new int[100][100];//�������
    int[][] Need = new int[100][100];//�������
    int[] Work = new int[100];//��ǰ�ɷ�����Դ
    int[][] Finish = new int[100][1];//�߳������� 0 false 1 true

    public static void main(String[] args){
        banker b = new banker();
        System.out.println("*****************************************");
        System.out.println("**********   ��ӭ�������м��㷨    ******");
        System.out.println("*****************************************");
        b.initialization(); //��ʼ������
        while(true){
            b.menu();
            Scanner read = new Scanner(System.in);
            int select = read.nextInt();
            switch(select){
                case 1://��ʾ��ǰ��Դ�����
                    b.show();
                    break;
                case 2://��ǰ״̬��ȫ��飻
                    int[] order = b.check();
                    if(order[0] > 0) {
                        System.out.print("�˿�״̬��ȫ��\n�а�ȫ��·��");
                        for (int j = 1; j <= order[0]; j++) {
                            System.out.print(" -> P" + order[j]);
                        }System.out.println();
                    }
                    if(order[0] == -1) System.out.println("�˿�״̬����ȫ�������������");
                    if(order[0] == 0) System.out.println("�߳���ȫ��ִ����ɣ�");
                    break;
                case 3://������Դ����
                    int[] request = new int[m];
                    System.out.print("������Ҫ�����Ľ��̣�P");
                    int process = read.nextInt() - 1;
                    System.out.println("����������ĸ���Դ������");
                    for(int i = 0; i < m; i++){
                        System.out.print("��Դ"+ (i + 1)+":");
                        request[i] = read.nextInt();
                    }
                    if(b.allocation(process, request)) System.out.println("��Դ����ɹ���");
                    else System.out.println("����ʧ�ܣ�");
                    break;
                case 4://�˳�����
                    System.out.println("�˳�����");
                    return;
                default:
                    System.out.println("�����������������룡");
                    break;
            }
        }
    }
    public boolean allocation(int process, int[] request){ //��Դ����
        for (int i = 0; i < m; i++){
            if(Need[process][i] < request[i]){
                System.out.println("������Դ���ڽ���������Դ�����䲻�Ϸ�");
                return false;
            }
        }
        for (int i = 0; i < m; i++){
            if (Available[i][0] < request[i]){
                System.out.println("������Դ����ϵͳ��ʣ��Դ�����䲻����");
                return false;
            }
        }
        for (int i = 0; i < m; i++){//���Է���
            Allocation[process][i] += request[i];
            Available[i][0] -= request[i];
            Need[process][i] -= request[i];
        }
        int[] order = check();//�жϵ�ǰ�Ƿ�ȫ
        if (order[0] > 0){
            for (int i = 0;i < m; i++){
                if(Need[process][i] != 0) break;
                if (i == m - 1) Finish[process][0] = 1;
            }
            System.out.println("���ڰ�ȫ���У�");
            for (int j = 1; j < order.length; j++) {
                System.out.print(" -> P" + order[j]);
            }System.out.println();
            return true;
        }else if (order[0] == -1) {
            System.out.println("���η��䲻��ȫ��");
            for (int i = 0; i < m; i++) {//��������
                Allocation[process][i] -= request[i];
                Available[i][0] += request[i];
                Need[process][i] += request[i];
            }
        }
        return false;
    }
    public int[] check(){//״̬��ȫ���
        int[] order = new int[n+1];//��һλ��ʾ�Ƿ��԰�ȫ�������ʾ��ȫ����
        int index = 1,f = 0;
        for (int i = 0; i < n; i++){
            if(Finish[i][0] == 0) f++;
            if (f == 0) {
                order[0] = 0;//��ʾ�߳���ȫ��ִ�����,����Ҫ�ڽ����ж�
                return order;
            }
        }
        for (int i = 0; i < m;i++) {Work[i] = Available[i][0];}//��ʼ��Work
        int[] finish = new int[100];//��ʼ��finish,���ڱ���߳��Ƿ�ִ����ɡ�
        for (int i = 0; i < n; i++){finish[i] = Finish[i][0];}
        for (int i = 0; i < n; i++){
            boolean flag = false;//�����Ƿ����߳�ִ����ɵı�ǩ
            if (index == (f + 1)) {
                order[0] = f;//��ʾ�а�ȫ����
                return order;
            }
            if (finish[i] != 0) continue;
            for (int j = 0; j < m; j++){//�ж���Դ�Ƿ������߳�������������ϣ���ֱ������ѭ��
                if (Work[j] < Need[i][j]) break;
                if (j == (m - 1)) flag = true;
            }
            if (flag == true){//����Դ�㹻����ִ����ý��̣������ͷ���Դ
                for (int j = 0; j < m; j++){Work[j] += Allocation[i][j];}
                order[index++] = i + 1;
                finish[i] = 1;
                i = -1;
            }
        }
        order[0] = -1;//��ʾ��ǰ״̬����ȫ
        return order;
    }
    public void show(){//�鿴��Դ���
        print(n,m,"����",Allocation);
        print(n,m,"����",Need);
        print(n,m,"ʣ��",Available);
        print(n,m,"����",Finish);
    }
    public static void print(int x, int y, String str1, int[][] arr){
        String str2 = "��Դ";
        System.out.println("**��ǰ"+str2+str1+"�����**");
        for (int i = 0; i < (str1.equals("����")?x:y); i++){
            System.out.print("\t"+((str1.equals("����")?str1:str2)+(i+1)));
        }System.out.println();
        if(str1.equals("ʣ��")){
            for (int i = 0; i < y; i++){
                System.out.print("\t"+arr[i][0]);
            }System.out.println();
        }else if (str1.equals("����")){
            for (int i = 0; i < x; i++){
                System.out.print("\t"+(arr[i][0]==0?false:true));
            }System.out.println();
        }else{
            for (int i = 0; i < x; i++){
                System.out.print("P" + (i+1) + "\t");
                for (int j = 0; j < y; j++){
                    System.out.print((arr[i][j]) + "\t");
                }
                System.out.println();
            }
        }
    }
    //��ʼ������
    void initialization(){
        Scanner read2 = new Scanner(System.in);
        System.out.print("�������߳�������");
        n = read2.nextInt();
        System.out.print("��������Դ����������");
        m = read2.nextInt();
        System.out.println("���������������Դ��Ŀ��");
        for(int i = 0; i < m; i++){
            System.out.print("��Դ"+(i + 1)+":");
            Available[i][0] = read2.nextInt();
        }
        for (int i = 0; i < n; i++){
            System.out.println("�������߳�P"+(i+1)+"�ĳ�ʼ��Ϣ");
            System.out.println("������ý����������Դ�������");
            for(int j = 0; j < m; j++){
                System.out.print("��Դ"+(j + 1)+":");
                Max[i][j] = read2.nextInt();
            }
            System.out.println("������ý����ѷ������Դ��������");
            for(int j = 0; j < m; j++){
                System.out.print("��Դ"+(j + 1)+":");
                Allocation[i][j] = read2.nextInt();
            }
            //�����������г�ʼ��
            for(int j = 0; j < m; j++){
                Need[i][j] = Max[i][j] - Allocation[i][j];
                Available[j][0] -= Allocation[i][j];
            }
        }
    }
    void menu(){//�˵�
        System.out.println("***************����ѡ��********************");
        System.out.println("**           1����ʾ��ǰ��Դ���         **");
        System.out.println("**           2����ǰ״̬��ȫ���         **");
        System.out.println("**           3��������Դ����	         **");
        System.out.println("**           4���˳�����                 **");
        System.out.println("*******************************************");
    }
}