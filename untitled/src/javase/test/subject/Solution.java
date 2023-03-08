package javase.test.subject;

class Solution {
    /**
     *整数反转
     * @param x 要反转得数
     * @return 反转之后的数
     */
    public static int reverse(int x) {
        int temp = 0;
        while (x != 0) {
            //每次循环的时候判断temp是否符合条件
            if (temp < Integer.MIN_VALUE / 10 || temp > Integer.MAX_VALUE / 10){
                return 0;
            }
            //符合条件的话继续进行翻转
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
