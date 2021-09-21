package info.sandroalmeida.graph;

public class CycleInGraph {

    static boolean hasCycle = false;
    static int maxTraverse = 0;

    public static boolean cycleInGraph(int[][] edges) {
        maxTraverse = edges.length + 1;
        for(int i = 0; i < edges.length; i++){
            int[] children = edges[i];
                traverse(edges, i, children, 1);
        }
        return hasCycle;
    }

    public static void traverse(int[][] edges, int starting, int[] children, int traverseCount){
        for(int i: children){
            if(i == starting){
                hasCycle = true;
                return;
            }
        }

        if(children.length == 0)
            return;

        for (int child : children)
            if (traverseCount < maxTraverse) traverse(edges, starting, edges[child], traverseCount + 1);
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {
                                {1, 2},
                                {2},
                                {}
                        };
        System.out.println(cycleInGraph(input));
    }
}
