package info.sandroalmeida.linkedList;

public class SumOfLinkedLists_V2 {

    public static LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {

       LinkedList currentOne = linkedListOne;
       LinkedList currentTwo = linkedListTwo;
       LinkedList newList = null;
       int restToAdd = 0;

       while(currentOne != null || currentTwo != null || restToAdd != 0){

           int valueOne = currentOne != null ? currentOne.value : 0;
           int valueTwo = currentTwo != null ? currentTwo.value : 0;
           int sum = valueOne + valueTwo + restToAdd;
           restToAdd = 0;
           if(sum >= 10){
               restToAdd = sum / 10;
               newList = createAppendNewList(sum % 10, newList);
           } else{
               newList = createAppendNewList(sum, newList);
           }
           if(currentOne != null) currentOne = currentOne.next;
           if(currentTwo != null) currentTwo = currentTwo.next;
       }
       return newList;
    }

    public static LinkedList createAppendNewList(int value, LinkedList newList){
        if(newList == null){
            newList = new LinkedList(value);
        } else{
            LinkedList current = newList;
            while(current.next != null)
                current = current.next;
            current.next = new LinkedList(value);
        }
        return newList;
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList listOne = new LinkedList(2);
//        listOne.next = new LinkedList(7);
//        listOne.next.next = new LinkedList(1);

        LinkedList listTwo = new LinkedList(9);
//        listTwo.next = new LinkedList(1);

        LinkedList result = sumOfLinkedLists(listOne, listTwo);
    }

}
