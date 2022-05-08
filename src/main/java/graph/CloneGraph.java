package graph;

import java.util.*;

public class CloneGraph {


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        CloneGraph cloneGraph = new CloneGraph();
        Node newGraph = cloneGraph.cloneGraph(node1);
        System.out.println("done");
    }
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Set<Integer> nodesCreated = new HashSet<>();
        Map<Integer, Node> nodeMap = new HashMap<>();
        Queue<Node> nodesToCreate = new LinkedList<>();

        Set<Integer> nodesGenerated = new HashSet<>();
        Queue<Node> nodesToGenerate = new LinkedList<>();

        nodesToCreate.add(node);
        createNode(nodesToCreate, nodesCreated, nodeMap);

        nodesToGenerate.add(node);
        generateRelations(nodesToGenerate, nodesGenerated, nodeMap);
        return nodeMap.get(node.val);
    }

    private void createNode(Queue<Node> nodesToCreate, Set<Integer> nodesCreated,Map<Integer, Node> nodeMap) {
        while (!nodesToCreate.isEmpty()) {
            Node nodeToCreate = nodesToCreate.remove();
            if (!nodesCreated.contains(nodeToCreate.val)) {
                Node newNode = new Node(nodeToCreate.val);
                nodeMap.put(newNode.val, newNode);
                nodesCreated.add(newNode.val);
                nodesToCreate.addAll(nodeToCreate.neighbors);
            }
        }
        if (!nodesToCreate.isEmpty()) {
            createNode(nodesToCreate, nodesCreated, nodeMap);
        }
    }

    private void generateRelations(Queue<Node> nodesToGenerate, Set<Integer> nodesGenerated, Map<Integer, Node> nodeMap) {
        while (!nodesToGenerate.isEmpty()) {
            Node node = nodesToGenerate.remove();
            Node newNode = nodeMap.get(node.val);
            if (!nodesGenerated.contains(node.val)) {
                for(Node neighbour: node.neighbors) {
                    Node newNeighbour = nodeMap.get(neighbour.val);
                    newNode.neighbors.add(newNeighbour);
                }
                nodesGenerated.add(node.val);
                nodesToGenerate.addAll(node.neighbors);
            }
        }

        if (!nodesToGenerate.isEmpty()) {
            generateRelations(nodesToGenerate, nodesGenerated, nodeMap);
        }
    }
}


class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}