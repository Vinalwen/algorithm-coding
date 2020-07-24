package topic_6_list;

import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author wenyao
 * @create 2020-07-19 13:07
 * ^-^ Fighting!
 */
public class PrintListReversingly_Iteratively {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> ret = new ArrayList<>();
            if(listNode.next == null){
                ret.add(listNode.val);
            }
            if(listNode.next != null){
                ret.addAll(printListFromTailToHead(listNode.next));
                ret.add(listNode.val);
            }
            return ret;
        }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(3,null);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        System.out.println(new PrintListReversingly_Iteratively().printListFromTailToHead(node1));

    }


}


   class ListNode {

        int val;
        ListNode next = null;

        ListNode(int val,ListNode next) {
            this.val = val;
            this.next = next;
        }
   }

