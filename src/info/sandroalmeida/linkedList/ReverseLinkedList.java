package info.sandroalmeida.linkedList;

public class ReverseLinkedList {

    public static LinkedList reverseLinkedList(LinkedList head) {

        LinkedList previous = null;
        LinkedList current = head;
        while(current != null){
            LinkedList next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList(0);
        list.next = new LinkedList(1);
        list.next.next = new LinkedList(2);
        list.next.next.next = new LinkedList(3);
        list.next.next.next.next = new LinkedList(4);
        list.next.next.next.next.next = new LinkedList(5);
        list = reverseLinkedList(list);
    }
}
