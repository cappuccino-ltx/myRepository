package javase.test.reflect;

public class Student {
    public int id;
    private String name;

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public boolean login(String name,String pwd){
        return name.equals("admin") && pwd.equals("123");
    }
    public void logout(){
        System.out.println("µÇ³ö£¡");
    }
}
