
package Controller;


import Model.MinimumConnectorsSql;
import java.util.*;
import javax.swing.JOptionPane;
public class MinimumConnectorsLogics {
   static int uid;
   static String uname;
   static int[]  validAnswers = new int[12] ;
   static int[] userAnswers = new int[12];
   public static int startPoint;
   String disBetCities;
   int userTotalDistance;
   static int totalDistanceT;
   int v = 5; // Number of vertices
   int[][] graph;
    public  MinimumConnectorsLogics(int[][] graph){        
        this.graph=graph;
        
        List<Edge> mst = findMinimumSpanningTree(graph);
        int totalWeight = calculateTotalWeight(mst);

        System.out.println("\nMinimum Spanning Tree:");
        int round = 0;
        for (Edge edge : mst) {
            System.out.println("Edge: " + edge.from + " - " + edge.to + ", Weight: " + edge.weight);
            inputAnswersToArray(edge.from,edge.to,edge.weight,round);
            round++;
        }
        
        int randomWeight = selectRandomWeight(graph);
        List<Edge> edgesWithRandomWeight = findEdgesWithWeight(graph, randomWeight);
        totalDistanceT = totalWeight;
        System.out.println("\nMinimum Total Edge Weight: " + totalWeight);
        System.out.println();
        System.out.println();
        System.out.println("Starting point is: "+validAnswers[0]);
        System.out.println("Array valid Answer contents: " + Arrays.toString(validAnswers));
        
    }
    public void setUserDetails(int uid, String uname){
        this.uid=uid;
        this.uname = uname;
    }
    public void setAnswers(int []userAnswers,int totalDis,String disBetCities){
      this.userAnswers =userAnswers;
      userTotalDistance = totalDis;
      this.disBetCities = disBetCities;
      boolean result = compareArrays(validAnswers, userAnswers);
      boolean result1;
        if (userTotalDistance==totalDistanceT) {
            result1=true;
        } else {
            result1=false;
        }
        if (result == true && result1==true ) {

              MinimumConnectorsSql mcSql= new MinimumConnectorsSql(uid, uname, 
                      disBetCities, startPoint, Arrays.toString(userAnswers), totalDistanceT);
              mcSql.saveAnswers();

        } else {
            JOptionPane.showMessageDialog(null, "Wrong Answer.","Try Again!",JOptionPane.ERROR_MESSAGE);
        }  
    }
    public int ReturnStartCity() {
        return startPoint;
    }
    public static void  inputAnswersToArray(int from, int to, int weight,int round){
        if (round==0) {
            startPoint = from;
            validAnswers[0] = from;
            validAnswers[1] = to;
            validAnswers[2] = weight;
        }if (round==1) {
            validAnswers[3] = from;
            validAnswers[4] = to;
            validAnswers[5] = weight;
        }if (round==2) {
            validAnswers[6] = from;
            validAnswers[7] = to;
            validAnswers[8] = weight;
        }if (round==3) {
            validAnswers[9] = from;
            validAnswers[10] = to;
            validAnswers[11] = weight;
        }
    }
    public static boolean compareArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }

        return true;
    }
    // Class to represent an edge in the graph
    static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    // Function to find the minimum spanning tree (MST) using Prim's algorithm
    public static List<Edge> findMinimumSpanningTree(int[][] graph) {
        int v = graph.length;
        boolean[] visited = new boolean[v];
        int[] parent = new int[v];
        int[] key = new int[v];

        for (int i = 0; i < v; i++) {
            key[i] = Integer.MAX_VALUE;
        }

        // Start with the first vertex
        key[0] = 0;
        parent[0] = -1;

        for (int i = 0; i < v - 1; i++) {
            int minKey = findMinKey(key, visited);
            visited[minKey] = true;

            for (int j = 0; j < v; j++) {
                if (graph[minKey][j] != 0 && !visited[j] && graph[minKey][j] < key[j]) {
                    parent[j] = minKey;
                    key[j] = graph[minKey][j];
                }
            }
        }

        List<Edge> mst = new ArrayList<>();
        for (int i = 1; i < v; i++) {
            mst.add(new Edge(parent[i], i, graph[parent[i]][i]));
        }

        return mst;
    }

    // Helper function to find the vertex with the minimum key value
    public static int findMinKey(int[] key, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < key.length; i++) {
            if (!visited[i] && key[i] < min) {
                min = key[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    // Helper function to calculate the total weight of the minimum spanning tree
    public static int calculateTotalWeight(List<Edge> mst) {
        int totalWeight = 0;

        for (Edge edge : mst) {
            totalWeight += edge.weight;
        }

        return totalWeight;
    }

    // Function to select a random weight from the graph
    public static int selectRandomWeight(int[][] graph) {
        Random random = new Random();
        int v = graph.length;

        int randomRow = random.nextInt(v);
        int randomCol = random.nextInt(v);

        return graph[randomRow][randomCol];
    }

    // Function to find the edges with a specific weight in the graph
    public static List<Edge> findEdgesWithWeight(int[][] graph, int weight) {
        List<Edge> edgesWithWeight = new ArrayList<>();
        int v = graph.length;

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (graph[i][j] == weight) {
                    edgesWithWeight.add(new Edge(i, j, weight));
                }
            }
        }

        return edgesWithWeight;
    }
}
