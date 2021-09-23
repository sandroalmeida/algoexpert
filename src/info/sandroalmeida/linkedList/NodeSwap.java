package info.sandroalmeida.linkedList;

/**
 * head = 0 -> 1 -> 2 -> 3 -> 4 -> 5 // the head node with value 0
 * 1 -> 0 -> 3 -> 2 -> 5 -> 4 // the new head node with value 1
 * */

public class NodeSwap {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList nodeSwap(LinkedList head) {
        LinkedList current = head, previous = null, newHead;
        if(head.next != null) newHead = head.next;
        else return head;

        while(current != null && current.next != null){
            previous = swap(current, previous);
            current = previous.next;
        }
        return newHead;
    }

    public static LinkedList swap(LinkedList node, LinkedList previousNode){

        if(node.next != null){
            // swap
            LinkedList nextNode = node.next;
            node.next = node.next.next;
            nextNode.next = node;
            // reconnect previous
            if(previousNode != null)
                previousNode.next = nextNode;
        }

        return node;
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(0);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(3);
        head.next.next.next.next = new LinkedList(4);
        head.next.next.next.next.next = new LinkedList(5);

        LinkedList newHead = nodeSwap(head);
    }
}
