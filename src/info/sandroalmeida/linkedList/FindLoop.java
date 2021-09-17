package info.sandroalmeida.linkedList;

public class FindLoop {

    public static LinkedList findLoop(LinkedList head) {

        LinkedList first = head.next;
        LinkedList second = head.next.next;

        while(first != second){
            first = first.next;
            second = second.next.next;
        }
        first = head;
        while(first != second){
            first = first.next;
            second = second.next;
        }
        return first;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(1);
        head.next = new LinkedList(2);
        head.next.next = new LinkedList(3);
        head.next.next.next = new LinkedList(4);
        head.next.next.next.next = new LinkedList(5);
        head.next.next.next.next.next = new LinkedList(6);
        head.next.next.next.next.next.next = new LinkedList(7);
        head.next.next.next.next.next.next.next = new LinkedList(8);
        head.next.next.next.next.next.next.next.next = new LinkedList(9);
        head.next.next.next.next.next.next.next.next.next = head.next.next.next;
        LinkedList result = findLoop(head);
    }

}
