package info.sandroalmeida.linkedList;

public class RemoveKthNodeFromEnd_V2 {

    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        int counter = 1;
        LinkedList first = head;
        LinkedList second = head;
        while (counter <= k){
            second = second.next;
            counter++;
        }
        if(second == null){
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }
        while(second.next != null){
            second = second.next;
            first = first.next;
        }
        first.next = first.next.next;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }


    public static void main(String[] args) {
        LinkedList head = new LinkedList(0);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(3);
        head.next.next.next.next = new LinkedList(4);
        head.next.next.next.next.next = new LinkedList(5);
        head.next.next.next.next.next.next = new LinkedList(6);
        head.next.next.next.next.next.next.next = new LinkedList(7);
        head.next.next.next.next.next.next.next.next = new LinkedList(8);
        head.next.next.next.next.next.next.next.next.next = new LinkedList(9);
        removeKthNodeFromEnd(head, 1);
    }
}
