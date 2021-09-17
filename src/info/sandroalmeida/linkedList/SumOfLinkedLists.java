package info.sandroalmeida.linkedList;

import java.util.ArrayList;
import java.util.List;

public class SumOfLinkedLists {

    public static LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {

        int total = calcSum(linkedListOne) + calcSum(linkedListTwo);
        List<Integer> digits = new ArrayList<>();

        if(total != 0){
            int totalCopy = total;
            for(int i = 10; totalCopy >= 1;){
                int digit = totalCopy % i;
                digits.add(digit);
                totalCopy = totalCopy / i;
            }
        } else{
            digits.add(0);
        }

        LinkedList newList = new LinkedList(digits.get(0));
        LinkedList head = newList;
        for(int i = 1; i <  digits.size(); i++){
            newList.next = new LinkedList(digits.get(i));
            newList = newList.next;
        }

        return head;
    }

    public static int calcSum(LinkedList node){
        LinkedList current = node;
        int sum = 0;
        int multiplier = 1;
        while(current != null) {
            sum = sum + (current.value * multiplier);
            multiplier *= 10;
            current = current.next;
        }
        return sum;
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
        listOne.next = new LinkedList(7);
        listOne.next.next = new LinkedList(1);

        LinkedList listTwo = new LinkedList(9);
        listTwo.next = new LinkedList(1);

        LinkedList result = sumOfLinkedLists(listOne, listTwo);
    }

}
