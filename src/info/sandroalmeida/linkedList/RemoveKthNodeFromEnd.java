package info.sandroalmeida.linkedList;

import java.util.ArrayList;
import java.util.List;

public class RemoveKthNodeFromEnd {

    public static void removeKthNodeFromEnd(LinkedList head, int k) {

        List<LinkedList> listNodes = new ArrayList<>();
        LinkedList currentNode = head;
        while(currentNode != null){
            if(listNodes.size() == k + 1) {
                listNodes.remove(0);
            }
            listNodes.add(currentNode);
            currentNode = currentNode.next;
        }

        if(listNodes.size() < k + 1){
            head.value = listNodes.get(1).value;
            head.next = listNodes.get(2);
        } else{
            listNodes.get(0).next = listNodes.size() > 2 ? listNodes.get(2): null;
        }
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
