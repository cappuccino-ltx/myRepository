package javase.practise;

public class test001 {
    public static void main(String[] args) {
        String maxString = "hellohellohello";
        String minString = "hello";
        //��¼����
        int count  = 0;

        int index = maxString.indexOf(minString);

        while (index != -1) {
            count++;
            //�Ѹղ���index ������+С���ĳ�����Ϊ��ʼλ�ý�ȡ��һ�εĴ�
            int startIndex = index + minString.length();
            maxString = maxString.substring(startIndex);
            //��������

            index = maxString.indexOf(minString);
        }
        System.out.println(count);
    }
}
