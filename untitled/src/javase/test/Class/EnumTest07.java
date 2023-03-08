package javase.test.Class;

/**
 * enum是枚举类型，
 * 枚举是一种引用数据类型，在编译器中编译出来之后，也是一种.class文件
 * 枚举中的每一个值都可以看做一个常量。
 * 在编程中，可以用boolean这种类型去表示简单的ture和false，这其实就是一种枚举方式
 * 假如说有一个不止开关状态的对象，如：台灯有关闭、弱光，强光，这三种状态，
 * 此时就应该用枚举来表示
 * public enum State{
 *     //关闭、弱光、强光
 *     CLOSE,WEAK,STRONG
 * }
 *
 *  在编写程序的时候，可能的情况可以一一枚举出来的东西，都建议用枚举类型去编写，
 *
 *  类似于：四季，星期，颜色，档位状态。
 */

//一个台灯，可以显示他此时的一个状态，关闭，弱光，强光。
public class EnumTest07 {
    public static void main(String[] args){
        Lamp taideng = new Lamp(State.CLOSE);
        taideng.setState(State.STRONG);
        System.out.println(taideng);
    }
}


 /**
  * 台灯类：
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
        if (this.state == State.CLOSE) return "关闭";
        else if (this.state == State.WEAK) return "弱光";
        else return "强光";
    }
}

//状态的枚举类型
enum State{
    //关闭，弱光，强光
    CLOSE,WEAK,STRONG//这些都是枚举常量
}
