package javase.test.subject;

/**
 *
 * ��������
 *      ������101��12321������������������������-121���ǻ�����
 *
 */
public class huiwenshu {
    /**
     * �ж�һ�����ǲ��ǻ�������
     * @param x Ҫ�жϵ���
     * @return �ǻ���������ture�����򷵻�false
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
