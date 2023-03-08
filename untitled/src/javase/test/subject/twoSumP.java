package javase.test.subject;

public class twoSumP {
    public static void main(String[] args){
        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));
        twoSumP t = new twoSumP();
        ListNode l3 = t.addTwoNumbers(l1,l2);
        ListNode temp = l3;
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r = null, t = null;
        int carry = 0;
        while(l1 == null & l2 == null){
            //if ()
        }
        return r;
    }
        /*int num = 1;
        int num1 = 0;
        int num2 = 0;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while (temp1 != null){
            num1 =  num1 + temp1.val * num;
            temp1 = temp1.next;
            num *= 10;
        }
        num = 1;
        while (temp2 != null){
            num2 =  num2 + temp2.val * num;
            temp2 = temp2.next;
            num *= 10;
        }
        int sum = num1 + num2;
        ListNode r = null;
        ListNode t = null;
        while (sum != 0) {
            if (r == null) {
                r = new ListNode(sum % 10);
                t = r;
            }else {
                t.next = new ListNode(sum % 10);
                t = t.next;
            }
            sum /= 10;
        }

        return r != null ? r : new ListNode(0);
    }*/
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}