package info.sandroalmeida.graph;

import java.util.HashMap;

public class YoungestCommonAncestor {

    public static AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {

        int levelOne = getLevel(topAncestor, descendantOne);
        int levelTwo = getLevel(topAncestor, descendantTwo);
        int diff = Math.abs(levelOne - levelTwo);
        while(diff > 0){
            if(levelOne > levelTwo)
                descendantOne = descendantOne.ancestor;
            else
                descendantTwo = descendantTwo.ancestor;
            diff--;
        }
        if(descendantOne == descendantTwo) return descendantOne;
        while(descendantOne != descendantTwo){
            descendantOne = descendantOne.ancestor;
            descendantTwo = descendantTwo.ancestor;
        }

        return descendantOne;
    }

    public static int getLevel(AncestralTree topAncestor, AncestralTree node){
        int count = 0;
        while(node != topAncestor){
            node = node.ancestor;
            count++;
        }
        return count;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }

    public static void main(String[] args) {
        var trees = new HashMap<Character, AncestralTree>();
        var alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (char a : alphabet.toCharArray()) {
            trees.put(a, new AncestralTree(a));
        }

        trees.get('A').addAsAncestor(new AncestralTree[] {trees.get('B'), trees.get('C'), trees.get('D'), trees.get('E'), trees.get('F')});
        trees.get('A').addAsAncestor(new AncestralTree[] {trees.get('B'), trees.get('C')});
        trees.get('B').addAsAncestor(new AncestralTree[] {trees.get('D'), trees.get('E')});
        trees.get('D').addAsAncestor(new AncestralTree[] {trees.get('H'), trees.get('I')});
        trees.get('C').addAsAncestor(new AncestralTree[] {trees.get('F'), trees.get('G')});

        AncestralTree result = getYoungestCommonAncestor(trees.get('A'), trees.get('E'), trees.get('I'));
        System.out.println(result.name);
    }
}
