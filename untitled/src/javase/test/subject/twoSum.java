package javase.test.subject;

/**
 *
 * ����֮�ͣ��ж�һ��������������������������ӵ����ġ�
 * �����������±�
 */
public class twoSum {
    public static int[] twoSum(int[] nums, int target) {
        //������Ҫ���ص�����
        int[] arr = {-1, -1};
        for (int i = 0; i < nums.length; i++){
            for (int j = i; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int target = 9;
        //���ú���
        int[] arr = twoSum(nums, target);
        if (arr[0] < 0) System.out.println("û�к��ʽ����");
            //������ص���������
        else System.out.println("[" + arr[0] + "," + arr[1] + "]");
    }
}
