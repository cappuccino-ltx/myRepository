package javase.test.array;

//import com.sun.deploy.security.SelectableSecurityManager;

import java.security.spec.RSAOtherPrimeInfo;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Objects;

/*Ϊĳ���Ƶ��д���򣺾Ƶ����ϵͳ��ģ�ⶩ�����˷�����ӡ����״̬�ȹ��ܣ�
            1���þƵ���û��ǾƵ�ǰ̨��
            2���Ƶ��ж��з���ʹ��һ����ά������ģ�⣬Room[][] room
            3���ŵ���ÿһ�����䶼Ӧ����һ��java����room
            4��ÿһ���Ƶ귿��room��Ӧ���У������ţ������������ԣ������Ƿ���С�
*/
//������
public class test02 {
    public static void main(String[] args) {
        //�����Ƶ����
        hotel tianyi = new hotel();

        System.out.println("��ӭʹ�����ݾƵ����ϵͳ��");
        System.out.println("�������Ķ�˵����");
        for (int i = 0;; i++) {
            System.out.println("���ܱ�Ŷ�Ӧ�Ĺ��ܣ�");
            System.out.print("\t[1]��ѯ������Ϣ");
            System.out.print("\t[2]����");
            System.out.print("\t[3]�˷�");
            System.out.println("\t[0]�˳�ϵͳ");

            System.out.print("�����빦�ܱ�ţ�");
            java.util.Scanner write = new java.util.Scanner(System.in);
            int num = write.nextInt();

            if(num == 1){
                tianyi.RoomPrint();
            }
            if(num == 2){
                System.out.print("������Ҫ���ķ����ţ�");
                int num2 = write.nextInt();
                tianyi.booking(num2);
            }
            if(num == 3){
                System.out.print("������Ҫ�˶��ķ����ţ�");
                int num3 = write.nextInt();
                tianyi.cancel(num3);
            }
            if(num == 0){
                System.out.println("��л����ʹ�ã�ף��������죡");
                break;
            }
            if(num != 0 & num != 1 & num !=2 & num != 3) System.out.println("�������󣡣�");
        }

    }
}
//�Ƶ���
class hotel{
    //����
    private Room[][] room;

    //���췽��
    hotel(){
        this.room = new Room[3][5];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if(i == 0) room[i][j] = new Room(100*(i+1)+(j+1),"���",false);
                if(i == 1) room[i][j] = new Room(100*(i+1)+(j+1),"�齫��",false);
                if(i == 2) room[i][j] = new Room(100*(i+1)+(j+1),"�󴲷�",false);
            }
        }
    }

    public hotel(int floor, int no) {
        this.room = new Room[floor][no];
        if(floor >= 4) {
            for (int i = 0; i < floor; i++) {
                for (int j = 0; j < no; j++) {
                    //if(i == 0) room[i][j] = new Room(100*(i+1)+(j+1),"���",false);
                    if (i == 1) room[i][j] = new Room(100 * (i + 1) + (j + 1), "�齫��", false);
                    if (i == no - 2) room[i][j] = new Room(100 * (i + 1) + (j + 1), "�󴲷�", false);
                    if (i == no - 1) room[i][j] = new Room(100 * (i + 1) + (j + 1), "��ͳ�׷�", false);
                    else room[i][j] = new Room(100 * (i + 1) + (j + 1), "���", false);
                }
            }
        }
        else {
            for (int i = 0; i < floor; i++) {
                for (int j = 0; j < no; j++) {
                    if(i == 0) room[i][j] = new Room(100*(i+1)+(j+1),"���",false);
                    if(i == 1) room[i][j] = new Room(100*(i+1)+(j+1),"�齫��",false);
                    if(i == 2) room[i][j] = new Room(100*(i+1)+(j+1),"�󴲷�",false);
                }
            }
        }
    }

    //����
    public void booking(int RoomId){
        if(RoomId/100 > 3||RoomId/100 < 1||RoomId%100 > 5||RoomId%100 < 1) {
            System.out.println("�˷��䲻���ڣ�");
            return;
        }
        if(room[RoomId/100-1][RoomId%100-1].RoomState == true) {
            System.out.println("�˷����ѱ�Ԥ����");
            return;
        }
        room[RoomId/100-1][RoomId%100-1].setRoomState(true);
        System.out.println("����Ԥ���ɹ���");
    }
    //�˷�
    public void cancel(int RoomId){
        if(RoomId/100 > room.length||RoomId/100 < 1||RoomId%100 > room[0].length||RoomId%100 <1) {
            System.out.println("�˷��䲻���ڣ�");
            return;
        }
        if(room[RoomId/100-1][RoomId%100-1].RoomState == false) {
            System.out.println("�˷���δ��Ԥ����");
            return;
        }
        room[RoomId/100-1][RoomId%100-1].setRoomState(false);
        System.out.println("�˷��ɹ�����");
    }
    //��ӡ������Ϣ
    public void RoomPrint(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(room[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "����һ��" + room.length + "��" + "�ľƵ�";
    }
}
//Room������
class Room{
    //������
    int RoomId;
    //��������
    String RoomClass;
    //����״̬
    boolean RoomState;

    Room(){
        this(101,"��׼��",false);
    }
    Room(int RoomId,String RoomClass,boolean RoomState){
        this.RoomId = RoomId;
        this.RoomClass = RoomClass;
        this.RoomState = RoomState;
    }
    /**public void RoomPrint(){
        String State = "����";
        if(this.RoomState == true)
            State = "�п�";
        System.out.println(RoomId+" "+RoomClass+" "+State);
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return this.getRoomId() == room.getRoomId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(RoomId, RoomClass, RoomState);
    }

    @Override
    public String toString() {
        //String State = "����";
        //if(RoomState == true) State = "�п�";
        return "[" + RoomId + ","+ RoomClass + "," + (RoomState ? "�п�" : "����") + ']';
    }

    public int getRoomId() {
        return RoomId;
    }

    public void setRoomId(int roomId) {
        RoomId = roomId;
    }

    public String getRoomClass() {
        return RoomClass;
    }

    public void setRoomClass(String roomClass) {
        RoomClass = roomClass;
    }

    public boolean getRoomState() {
        return RoomState;
    }

    public void setRoomState(boolean roomState) {
        RoomState = roomState;
    }
}
