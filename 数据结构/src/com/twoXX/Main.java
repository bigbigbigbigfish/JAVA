package com.twoXX;

import javafx.util.Pair;

public class Main {
    static class Node {
        char value;
        Node left;
        Node right;

        public Node(char value) {
            this.value = value;
        }
    }
    private static Pair<Node, Integer> createTree(char[] preOrder) {
        if(preOrder.length == 0) {
            return new Pair<>(null,0);
        }

        if(preOrder[0] == '#') {
            return new Pair<>(null,1);
        }

        Node root = new Node(preOrder[0]);
    }

}
