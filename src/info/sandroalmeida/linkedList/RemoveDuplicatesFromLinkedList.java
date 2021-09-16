package info.sandroalmeida.linkedList;

public class RemoveDuplicatesFromLinkedList {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        if(linkedList == null) return null;
        LinkedList destList = null;
        LinkedList headDestList = null;
        return createLinkedListRecursive(linkedList, destList, headDestList);
    }

    public static LinkedList createLinkedListRecursive(LinkedList originList, LinkedList destList, LinkedList headDestList){
        LinkedList newNode = new LinkedList(originList.value);
        if(destList == null) {
            destList = newNode;
            headDestList = newNode;
        } else {
            if(destList.value != originList.value){
                destList.next = newNode;
                destList = destList.next;
            }
        }
        if(originList.next != null)
            createLinkedListRecursive(originList.next, destList, headDestList);
        return headDestList;
    }

    public static void main(String[] args) {
        LinkedList originList = new LinkedList(1);
        originList.next = new LinkedList(3);
        originList.next.next = new LinkedList(4);
        originList.next.next.next = new LinkedList(4);
        originList.next.next.next.next = new LinkedList(4);
        originList.next.next.next.next.next = new LinkedList(5);
        originList.next.next.next.next.next.next = new LinkedList(6);
        originList.next.next.next.next.next.next.next = new LinkedList(6);
        LinkedList destList = removeDuplicatesFromLinkedList(originList);
    }
}
