package info.sandroalmeida.greedyAlgorithms;


import java.util.*;

public class TaskAssignment {

    public static ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Map<Integer, List<Integer>> mapValueIndices = new HashMap<>();
        for(int i = 0; i < tasks.size(); i++){
            int value = tasks.get(i);
            if(mapValueIndices.containsKey(value)){
                mapValueIndices.get(value).add(i);
            } else{
                mapValueIndices.put(value, new ArrayList<>(List.of(i)));
            }
        }

        tasks.sort(Comparator.comparingInt(a -> a));

        int start = 0, end = tasks.size() - 1;
        while(start < end){
            List<Integer> possiblesStartIndex = mapValueIndices.get(tasks.get(start));
            int startIndex = 0;
            if(possiblesStartIndex.size() >= 1){
                startIndex = possiblesStartIndex.get(0);
                possiblesStartIndex.remove(0);
            }
            List<Integer> possiblesEndIndex = mapValueIndices.get(tasks.get(end));
            int endIndex = 0;
            if(possiblesEndIndex.size() >= 1){
                endIndex = possiblesEndIndex.get(0);
                possiblesEndIndex.remove(0);
            }

            result.add(new ArrayList<>(Arrays.asList(startIndex, endIndex)));
            start++;
            end--;
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> tasks = new ArrayList<>(Arrays.asList(1, 3, 5, 3, 1, 4));
        ArrayList<ArrayList<Integer>> result = taskAssignment(3, tasks);
        for(List<Integer> pair: result){
            System.out.print("(" + pair.get(0) + ", " + pair.get(1) + ")");
        }
    }
}
