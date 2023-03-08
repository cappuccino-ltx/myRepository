package javase.test.reflect;

/**
 *
 * 获取一个文件的绝对路径
 *
 *      这种方法需要将要获取的文件放到类路径下（src），这样的话，不管以后文件怎么移植，都不需要改代码
 *
 */
public class AboutPath {
    public static void main(String[] args){
        //获取一个类的绝对路径 当前src路径下的db.properties这个文件的绝对路径

        String path = Thread.currentThread().getContextClassLoader()
                .getResource("javase/test/reflect/db.properties").getPath();
        System.out.println(path);
    }
}
