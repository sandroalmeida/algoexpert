package info.sandroalmeida.linkedList;

public class MergeLinkedLists {

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {

        LinkedList previous = null;
        LinkedList currentOne = headOne;
        LinkedList currentTwo = headTwo;

        while(currentOne != null && currentTwo != null){
            if(currentOne.value < currentTwo.value){
                previous = currentOne;
                currentOne = currentOne.next;
            } else{
                if(previous != null) 
                    previous.next = currentTwo;
                previous = currentTwo;
                currentTwo = currentTwo.next;
                previous.next = currentOne;
            }
        }
        if(currentOne == null) previous.next = currentTwo;
        return headOne.value < headTwo.value ? headOne : headTwo;
    }

    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList listOne = new LinkedList(0);
        listOne.next = new LinkedList(2);
        listOne.next.next = new LinkedList(4);
        listOne.next.next.next = new LinkedList(6);
        listOne.next.next.next.next = new LinkedList(8);
        listOne.next.next.next.next.next = new LinkedList(10);

        LinkedList listTwo = new LinkedList(1);
        listTwo.next = new LinkedList(3);
        listTwo.next.next = new LinkedList(5);
        listTwo.next.next.next = new LinkedList(7);
        listTwo.next.next.next.next = new LinkedList(9);
        listTwo.next.next.next.next.next = new LinkedList(11);
        listTwo.next.next.next.next.next.next = new LinkedList(12);
        LinkedList result = mergeLinkedLists(listOne, listTwo);
    }
}
