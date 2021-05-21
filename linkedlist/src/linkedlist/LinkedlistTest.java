package linkedlist;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-03-09 18:45
 */
public class LinkedlistTest {
//    @Test
//    public boolean isPalindrome(ListNode head) {
//        //如果链表为空或者长度为1，返回true
//        if (head == null || head.next == null) {
//            return true;
//        } else if (head.next.next == null) {//长度为2时不会触发后续代码，需要单独判断，
//            if (head.next.val != head.val)
//                return false;
//        }
//        ListNode slow = head;
//        ListNode fast = head;
//        ListNode pre = null;
//        //第一次遍历，慢指针一边移动一边反转
//        while (fast.next != null && fast.next.next != null) {
//            //快指针移动
//            fast = fast.next.next;
//            //慢指针先反转当前结点和下一结点的方向再移动
//            ListNode cur = slow.next; //备份slow的下一个结点，防止改变方向后链表丢失
//            slow.next = pre;//将slow的指向指为pre；
//            pre = slow;//pre后移
//            slow = cur;//slow后移
//        }
//
//        //此时前半段已经翻转
//        // 如果链表长度为偶数，后半段比前半段多两个个结点，先判断后半段的前两个结点是否相等，在半段两段其余是否相等。
//        //如果链表长度为奇数，后半段比前半段多一个结点，比值时忽略后半段的第一个节点。
//        //如何判断奇数偶数？通过快慢指针中的快指针判断,当为奇数，fast.next=null；当为偶数，fast.next.next=null
//        if (fast.next == null) {
//            //奇数时，忽略前半段的第一个结点
//            slow = slow.next;
//        }else if (fast.next.next==null){
//            //偶数时，比较后半段的前两个结点是否相等
//            if (slow.next.val!=slow.val)
//                return false;
//            slow=slow.next.next;
//        }
//        while (pre != null && slow != null) {
//            if (pre.val != slow.val) {
//                return false;
//            }
//            pre = pre.next;
//            slow = slow.next;
//        }
//        return true;
//    }
}
