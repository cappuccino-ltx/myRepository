package javase.shiyan.conputerSystem;
import java.util.Scanner;
public class banker{
    static int n,m;
    int[][] Available = new int[100][1];//资源向量
    int[][] Max = new int[100][100];//最大需求矩阵
    int[][] Allocation = new int[100][100];//分配矩阵
    int[][] Need = new int[100][100];//需求矩阵
    int[] Work = new int[100];//当前可分配资源
    int[][] Finish = new int[100][1];//线程完成情况 0 false 1 true

    public static void main(String[] args){
        banker b = new banker();
        System.out.println("*****************************************");
        System.out.println("**********   欢迎来到银行家算法    ******");
        System.out.println("*****************************************");
        b.initialization(); //初始化数据
        while(true){
            b.menu();
            Scanner read = new Scanner(System.in);
            int select = read.nextInt();
            switch(select){
                case 1://显示当前资源情况；
                    b.show();
                    break;
                case 2://当前状态安全检查；
                    int[] order = b.check();
                    if(order[0] > 0) {
                        System.out.print("此刻状态安全！\n有安全线路：");
                        for (int j = 1; j <= order[0]; j++) {
                            System.out.print(" -> P" + order[j]);
                        }System.out.println();
                    }
                    if(order[0] == -1) System.out.println("此刻状态不安全，会产生死锁！");
                    if(order[0] == 0) System.out.println("线程以全部执行完成！");
                    break;
                case 3://请求资源分配
                    int[] request = new int[m];
                    System.out.print("请输入要操作的进程：P");
                    int process = read.nextInt() - 1;
                    System.out.println("请输入请求的各资源数量！");
                    for(int i = 0; i < m; i++){
                        System.out.print("资源"+ (i + 1)+":");
                        request[i] = read.nextInt();
                    }
                    if(b.allocation(process, request)) System.out.println("资源分配成功！");
                    else System.out.println("分配失败！");
                    break;
                case 4://退出程序
                    System.out.println("退出程序！");
                    return;
                default:
                    System.out.println("输入有误，请重新输入！");
                    break;
            }
        }
    }
    public boolean allocation(int process, int[] request){ //资源分配
        for (int i = 0; i < m; i++){
            if(Need[process][i] < request[i]){
                System.out.println("请求资源大于进程所需资源，分配不合法");
                return false;
            }
        }
        for (int i = 0; i < m; i++){
            if (Available[i][0] < request[i]){
                System.out.println("请求资源大于系统所剩资源，分配不合理");
                return false;
            }
        }
        for (int i = 0; i < m; i++){//尝试分配
            Allocation[process][i] += request[i];
            Available[i][0] -= request[i];
            Need[process][i] -= request[i];
        }
        int[] order = check();//判断当前是否安全
        if (order[0] > 0){
            for (int i = 0;i < m; i++){
                if(Need[process][i] != 0) break;
                if (i == m - 1) Finish[process][0] = 1;
            }
            System.out.println("存在安全序列：");
            for (int j = 1; j < order.length; j++) {
                System.out.print(" -> P" + order[j]);
            }System.out.println();
            return true;
        }else if (order[0] == -1) {
            System.out.println("本次分配不安全！");
            for (int i = 0; i < m; i++) {//撤销分配
                Allocation[process][i] -= request[i];
                Available[i][0] += request[i];
                Need[process][i] += request[i];
            }
        }
        return false;
    }
    public int[] check(){//状态安全检查
        int[] order = new int[n+1];//第一位表示是否以安全，其余表示安全序列
        int index = 1,f = 0;
        for (int i = 0; i < n; i++){
            if(Finish[i][0] == 0) f++;
            if (f == 0) {
                order[0] = 0;//表示线程已全部执行完毕,不需要在进行判断
                return order;
            }
        }
        for (int i = 0; i < m;i++) {Work[i] = Available[i][0];}//初始化Work
        int[] finish = new int[100];//初始化finish,用于标记线程是否执行完成。
        for (int i = 0; i < n; i++){finish[i] = Finish[i][0];}
        for (int i = 0; i < n; i++){
            boolean flag = false;//定义是否有线程执行完成的标签
            if (index == (f + 1)) {
                order[0] = f;//表示有安全序列
                return order;
            }
            if (finish[i] != 0) continue;
            for (int j = 0; j < m; j++){//判断资源是否满足线程需求，如果不符合，则直接跳出循环
                if (Work[j] < Need[i][j]) break;
                if (j == (m - 1)) flag = true;
            }
            if (flag == true){//若资源足够，则执行完该进程，并且释放资源
                for (int j = 0; j < m; j++){Work[j] += Allocation[i][j];}
                order[index++] = i + 1;
                finish[i] = 1;
                i = -1;
            }
        }
        order[0] = -1;//表示当前状态不安全
        return order;
    }
    public void show(){//查看资源情况
        print(n,m,"分配",Allocation);
        print(n,m,"需求",Need);
        print(n,m,"剩余",Available);
        print(n,m,"进程",Finish);
    }
    public static void print(int x, int y, String str1, int[][] arr){
        String str2 = "资源";
        System.out.println("**当前"+str2+str1+"情况！**");
        for (int i = 0; i < (str1.equals("进程")?x:y); i++){
            System.out.print("\t"+((str1.equals("进程")?str1:str2)+(i+1)));
        }System.out.println();
        if(str1.equals("剩余")){
            for (int i = 0; i < y; i++){
                System.out.print("\t"+arr[i][0]);
            }System.out.println();
        }else if (str1.equals("进程")){
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
    //初始化方法
    void initialization(){
        Scanner read2 = new Scanner(System.in);
        System.out.print("请输入线程总数：");
        n = read2.nextInt();
        System.out.print("请输入资源种类总数：");
        m = read2.nextInt();
        System.out.println("请依次输入各种资源数目：");
        for(int i = 0; i < m; i++){
            System.out.print("资源"+(i + 1)+":");
            Available[i][0] = read2.nextInt();
        }
        for (int i = 0; i < n; i++){
            System.out.println("请输入线程P"+(i+1)+"的初始信息");
            System.out.println("请输入该进程所需各资源的最大量");
            for(int j = 0; j < m; j++){
                System.out.print("资源"+(j + 1)+":");
                Max[i][j] = read2.nextInt();
            }
            System.out.println("请输入该进程已分配各资源的数量：");
            for(int j = 0; j < m; j++){
                System.out.print("资源"+(j + 1)+":");
                Allocation[i][j] = read2.nextInt();
            }
            //对需求矩阵进行初始化
            for(int j = 0; j < m; j++){
                Need[i][j] = Max[i][j] - Allocation[i][j];
                Available[j][0] -= Allocation[i][j];
            }
        }
    }
    void menu(){//菜单
        System.out.println("***************功能选择********************");
        System.out.println("**           1、显示当前资源情况         **");
        System.out.println("**           2、当前状态安全检查         **");
        System.out.println("**           3、请求资源分配	         **");
        System.out.println("**           4、退出程序                 **");
        System.out.println("*******************************************");
    }
}