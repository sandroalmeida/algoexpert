package info.sandroalmeida.linkedList;

public class ShiftLinkedList {

    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        if(k > 0){
            for(int i = 1; i <= k; i++)
                head = helperForward(head);
        } else if(k < 0){
            for(int i = k; i < 0; i++)
                head = helperBack(head);
        }
        return head;
    }

    public static LinkedList helperForward(LinkedList head){
        LinkedList beforeTail = null;
        LinkedList currentNode = head;
        while(currentNode.next != null){
            if(currentNode.next.next == null)
                beforeTail = currentNode;
            currentNode = currentNode.next;
        }
        currentNode.next = head;
        beforeTail.next = null;
        return currentNode;
    }

    public static LinkedList helperBack(LinkedList head){
        LinkedList currentNode = head;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = head;
        LinkedList result = head.next;
        head.next = null;
        return result;
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(0);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(3);
        head.next.next.next.next = new LinkedList(4);
        head.next.next.next.next.next = new LinkedList(5);
        LinkedList result = shiftLinkedList(head, 2);
    }
}
