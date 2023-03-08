package javase.test.array;

/**
 * ���ַ���������
 */
public class ArraySearch {
    //��ʹ�ö��ֲ��ҵķ���
    public static int lookup(int[] arr, int temp){
        for (int i = 0; i < arr.length; i++) {
            if (temp == arr[i]){
                return i;
            }
        }
        return -1;
    }
    //ʹ�ö��ֲ��ҵķ���
    public static int lookup1(int[] arr, int temp){
        int left = 0;
        int right = arr.length;
        for (int i = 0;i < arr.length;i++){
            int mid = (left + right)/2;
            if (temp == arr[mid]) return mid;
            if (temp < arr[mid]) right = mid - 1;
            if (temp > arr[mid]) left = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int temp = 6;

        System.out.println("��ʹ�ö��ֲ���___________________________________________");
        int n = lookup(arr, temp);
        if(n == -1) System.out.println("������û��" + temp);
        else System.out.println(temp + "���±���" + n);


        System.out.println("\nʹ�ö��ֲ���_____________________________________________");
        int m = lookup1(arr, temp);
        if (n == -1) System.out.println("������û��" + temp);
        else System.out.println(temp + "���±���" + m);
    }
}
