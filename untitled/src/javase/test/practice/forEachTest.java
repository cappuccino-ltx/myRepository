package javase.test.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class forEachTest {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,4,4,44,33,290};
        for (int i : arr){
            System.out.println(i);
        }
        List<String> strList = new ArrayList<>();
        strList.add("abc");
        strList.add("aaa");
        strList.add("bbb");
        strList.add("ccc");
        strList.add("ddd");
        //用迭代器方式迭代集合
        Iterator<String> it = strList.iterator();
        while(it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }
        //用增强for来遍历集合
        for(String i : strList){
            System.out.println(i);
        }
    }
}
