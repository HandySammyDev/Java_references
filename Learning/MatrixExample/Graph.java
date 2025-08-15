package Learning.MatrixExample;

import java.util.ArrayList;

public class Graph {

    ArrayList<Node> nodes;
    int[][] matrix;

    //size = amount of nodes
    Graph(int size){
        nodes = new ArrayList<>();
        matrix = new int[size][size];
    }

    public void addNode(Node node){
        nodes.add(node);
    }

    public void addEdge(int src, int dst){
        matrix[src][dst] = 1; //This mean there's an edge between two nodes
    }

    public boolean checkEdge(int src, int dst){
        if(matrix[src][dst] == 1){
            return true;
        }
        else{
            return false;
        }
    }


    public void print(){

        System.out.print("  ");
        for(Node node : nodes){
            System.out.print(node.data + " ");
        }
        System.out.println();

        for(int i=0; i<matrix.length; i++){
            System.out.print(nodes.get(i).data + " ");

            for(int j=0; j<matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

//    Prints:

//    A B C D E
//  A 0 1 0 0 0
//  B 0 0 1 0 0
//  C 0 0 0 1 1
//  D 0 0 0 0 0
//  E 1 0 1 0 0

    // whenever there is a 1, it means there is an adjacency or an edge (node connecting to another node)

}
