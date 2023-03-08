package javase.test.subject;

/**
 *
 * 回文数：
 *      类似于101、12321……这样得数叫做回文数，-121不是回文数
 *
 */
public class huiwenshu {
    /**
     * 判断一个数是不是回文数！
     * @param x 要判断的数
     * @return 是回文数返回ture、否则返回false
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int num1 = x;
        int num2 = 0;
        for (int i = 0; num1 != 0; i++){
            int temp = num1 % 10;
            num1 = num1 / 10;
            num2 = num2 * 10 + temp;
        }
        return num2 == x;
    }

    public static void main(String[] args){
        System.out.println(isPalindrome(110011));
    }
}
