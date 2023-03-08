package javase.test.subject;

class Solution {
    /**
     *������ת
     * @param x Ҫ��ת����
     * @return ��ת֮�����
     */
    public static int reverse(int x) {
        int temp = 0;
        while (x != 0) {
            //ÿ��ѭ����ʱ���ж�temp�Ƿ��������
            if (temp < Integer.MIN_VALUE / 10 || temp > Integer.MAX_VALUE / 10){
                return 0;
            }
            //���������Ļ��������з�ת
            int end = x % 10;
            x /= 10;
            temp = temp * 10 + end;
        }
        return temp;
    }


    public static void main(String[] args){
        int a = reverse(123);
        System.out.println(a);
    }
}
