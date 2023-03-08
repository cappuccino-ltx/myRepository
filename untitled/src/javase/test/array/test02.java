package javase.test.array;

//import com.sun.deploy.security.SelectableSecurityManager;

import java.security.spec.RSAOtherPrimeInfo;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Objects;

/*为某个酒店编写程序：酒店管理系统，模拟订房，退房，打印房间状态等功能，
            1、该酒店的用户是酒店前台；
            2、酒店中多有房间使用一个二维数组来模拟，Room[][] room
            3、九点钟每一个房间都应该是一个java对象，room
            4、每一个酒店房间room就应该有：房间编号，房间类型属性，房间是否空闲。
*/
//测试类
public class test02 {
    public static void main(String[] args) {
        //创建酒店对象
        hotel tianyi = new hotel();

        System.out.println("欢迎使用天逸酒店管理系统！");
        System.out.println("请认真阅读说明：");
        for (int i = 0;; i++) {
            System.out.println("功能编号对应的功能：");
            System.out.print("\t[1]查询房间信息");
            System.out.print("\t[2]订房");
            System.out.print("\t[3]退房");
            System.out.println("\t[0]退出系统");

            System.out.print("请输入功能编号：");
            java.util.Scanner write = new java.util.Scanner(System.in);
            int num = write.nextInt();

            if(num == 1){
                tianyi.RoomPrint();
            }
            if(num == 2){
                System.out.print("请输入要订的房间编号：");
                int num2 = write.nextInt();
                tianyi.booking(num2);
            }
            if(num == 3){
                System.out.print("请输入要退订的房间编号：");
                int num3 = write.nextInt();
                tianyi.cancel(num3);
            }
            if(num == 0){
                System.out.println("感谢您的使用，祝你生活愉快！");
                break;
            }
            if(num != 0 & num != 1 & num !=2 & num != 3) System.out.println("输入有误！！");
        }

    }
}
//酒店类
class hotel{
    //房间
    private Room[][] room;

    //构造方法
    hotel(){
        this.room = new Room[3][5];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if(i == 0) room[i][j] = new Room(100*(i+1)+(j+1),"标间",false);
                if(i == 1) room[i][j] = new Room(100*(i+1)+(j+1),"麻将房",false);
                if(i == 2) room[i][j] = new Room(100*(i+1)+(j+1),"大床房",false);
            }
        }
    }

    public hotel(int floor, int no) {
        this.room = new Room[floor][no];
        if(floor >= 4) {
            for (int i = 0; i < floor; i++) {
                for (int j = 0; j < no; j++) {
                    //if(i == 0) room[i][j] = new Room(100*(i+1)+(j+1),"标间",false);
                    if (i == 1) room[i][j] = new Room(100 * (i + 1) + (j + 1), "麻将房", false);
                    if (i == no - 2) room[i][j] = new Room(100 * (i + 1) + (j + 1), "大床房", false);
                    if (i == no - 1) room[i][j] = new Room(100 * (i + 1) + (j + 1), "总统套房", false);
                    else room[i][j] = new Room(100 * (i + 1) + (j + 1), "标间", false);
                }
            }
        }
        else {
            for (int i = 0; i < floor; i++) {
                for (int j = 0; j < no; j++) {
                    if(i == 0) room[i][j] = new Room(100*(i+1)+(j+1),"标间",false);
                    if(i == 1) room[i][j] = new Room(100*(i+1)+(j+1),"麻将房",false);
                    if(i == 2) room[i][j] = new Room(100*(i+1)+(j+1),"大床房",false);
                }
            }
        }
    }

    //订房
    public void booking(int RoomId){
        if(RoomId/100 > 3||RoomId/100 < 1||RoomId%100 > 5||RoomId%100 < 1) {
            System.out.println("此房间不存在！");
            return;
        }
        if(room[RoomId/100-1][RoomId%100-1].RoomState == true) {
            System.out.println("此房间已被预订！");
            return;
        }
        room[RoomId/100-1][RoomId%100-1].setRoomState(true);
        System.out.println("房间预定成功！");
    }
    //退房
    public void cancel(int RoomId){
        if(RoomId/100 > room.length||RoomId/100 < 1||RoomId%100 > room[0].length||RoomId%100 <1) {
            System.out.println("此房间不存在！");
            return;
        }
        if(room[RoomId/100-1][RoomId%100-1].RoomState == false) {
            System.out.println("此房间未被预订！");
            return;
        }
        room[RoomId/100-1][RoomId%100-1].setRoomState(false);
        System.out.println("退房成功！！");
    }
    //打印房间信息
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
        return "这是一个" + room.length + "层" + "的酒店";
    }
}
//Room房间类
class Room{
    //房间编号
    int RoomId;
    //房间类型
    String RoomClass;
    //房间状态
    boolean RoomState;

    Room(){
        this(101,"标准间",false);
    }
    Room(int RoomId,String RoomClass,boolean RoomState){
        this.RoomId = RoomId;
        this.RoomClass = RoomClass;
        this.RoomState = RoomState;
    }
    /**public void RoomPrint(){
        String State = "空闲";
        if(this.RoomState == true)
            State = "有客";
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
        //String State = "空闲";
        //if(RoomState == true) State = "有客";
        return "[" + RoomId + ","+ RoomClass + "," + (RoomState ? "有客" : "空闲") + ']';
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
