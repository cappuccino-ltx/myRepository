package javase.practise;

public class test001 {
    public static void main(String[] args) {
        String maxString = "hellohellohello";
        String minString = "hello";
        //纪录次数
        int count  = 0;

        int index = maxString.indexOf(minString);

        while (index != -1) {
            count++;
            //把刚才是index 的索引+小串的长度作为开始位置截取上一次的大串
            int startIndex = index + minString.length();
            maxString = maxString.substring(startIndex);
            //继续查找

            index = maxString.indexOf(minString);
        }
        System.out.println(count);
    }
}
