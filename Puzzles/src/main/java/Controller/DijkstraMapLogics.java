
package Controller;

import View.DijkstraMap;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;


public class DijkstraMapLogics {
    static int uid;
    static String uname;
    private Vertex[] vertices;        //Array of vertices to store cities
    private int numVertices;
    private int maxNum;
    PriorityQueue<Edge> pq;
    public int[] dist;               //Array of distances of vertices
    Boolean[] set;                   //Array to store visited nodes
    public int[] value = new int[9];
    public static int[] shortest;

    private class Vertex {

        private String id;
        private LinkedList<Edge> edges;
        private boolean encountered;
        @SuppressWarnings("unused")
        private boolean done;
        @SuppressWarnings("unused")
        private Vertex parent;
        private int cost;

        private Vertex(String id) {
            this.id = id;
            encountered = false;
            done = false;
            edges = new LinkedList<Edge>();
            @SuppressWarnings("unused")
            int cost = 0;
        }
    }

    private class Edge implements Comparator<Edge>, Comparable<Edge> {

        private int toIndex;          // index of destination vertex
        private double cost;          // cost of the road

        private Edge(int toIndex, double cost) {
            this.toIndex = toIndex;
            this.cost = cost;
        }

        @Override
        public int compare(Edge o1, Edge o2) {
            if (o1.cost < o2.cost) {
                return -1;
            }
            if (o2.cost < o1.cost) {
                return 1;
            }
            return 0;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.cost < o.cost) {
                return -1;
            }
            if (this.cost > o.cost) {
                return 1;
            }
            return 0;
        }
    }
    
    public DijkstraMapLogics(int uid,String uname){
        this.uid=uid;
        this.uname=uname;
        
        Random random = new Random();
        int[] val = new int[13];

        for (int i = 0; i < 13; i++) {
            val[i] = random.nextInt(45) + 5;
        }

        String cities = "ABCDEFGHI";
        int i = random.nextInt(9);
        String point = String.valueOf((cities.charAt(i)));

        System.out.println("Distance AB = " + val[0] + "km AI = " + val[1] + "km BI = " + val[2] + "km BC = " + val[3]
                + "km CD = " + val[4] + "km DI = " + val[5] + "km DE = " + val[6] + "km EH = " + val[7] + "km EF = " + val[8]
                + "km FH = " + val[9] + "km FG = " + val[10] + "km HG = " + val[11] + "km HI = " + val[12] + "km");
        System.out.println("Find the shortes path to each city from " + point);

        DijkstraMapLogics myGraph = new DijkstraMapLogics(2);


        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");
        myGraph.addVertex("D");
        myGraph.addVertex("E");
        myGraph.addVertex("F");
        myGraph.addVertex("G");
        myGraph.addVertex("H");
        myGraph.addVertex("I");

        myGraph.addEdge("A", "B", val[0]);
        myGraph.addEdge("A", "I", val[1]);
        myGraph.addEdge("B", "A", val[0]);
        myGraph.addEdge("B", "I", val[2]);
        myGraph.addEdge("B", "C", val[3]);
        myGraph.addEdge("C", "B", val[3]);
        myGraph.addEdge("C", "D", val[4]);
        myGraph.addEdge("D", "C", val[4]);
        myGraph.addEdge("D", "I", val[5]);
        myGraph.addEdge("D", "E", val[6]);
        myGraph.addEdge("E", "D", val[6]);
        myGraph.addEdge("E", "H", val[7]);
        myGraph.addEdge("E", "F", val[8]);
        myGraph.addEdge("F", "E", val[8]);
        myGraph.addEdge("F", "H", val[9]);
        myGraph.addEdge("F", "G", val[10]);
        myGraph.addEdge("G", "H", val[11]);
        myGraph.addEdge("G", "F", val[10]);
        myGraph.addEdge("H", "G", val[11]);
        myGraph.addEdge("H", "F", val[9]);
        myGraph.addEdge("H", "E", val[7]);
        myGraph.addEdge("H", "I", val[12]);
        myGraph.addEdge("I", "H", val[12]);
        myGraph.addEdge("I", "D", val[5]);
        myGraph.addEdge("I", "B", val[2]);
        myGraph.addEdge("I", "A", val[1]);

        myGraph.dijkstraHeap(point);
        myGraph.printSolution(myGraph.dist);

//        Game game = new Game(val,point);
//        game.setVisible(true);
        DijkstraMap game = new DijkstraMap(uid,uname,val, point, shortest);
        game.setVisible(true);
    }
    public DijkstraMapLogics(int maximum) {
        maxNum = maximum;
        vertices = new Vertex[maxNum];
        numVertices = 0;
        pq = new PriorityQueue<Edge>();
        dist = new int[9];
        set = new Boolean[1000];
    }

    public boolean addVertex(String id) {
        if (numVertices >= maxNum) {
            Vertex[] old = vertices;
            maxNum = 2 * maxNum;
            vertices = new Vertex[maxNum];
            for (int i = 0; i < old.length; i++) {
                vertices[i] = old[i];
            }
        }
        vertices[numVertices] = new Vertex(id);
        numVertices++;
        return true;
    }

    public boolean addEdge(String a, String b, double cost) {
        int i = -1;
        int j = -1;
        if (a.equals(b)) {
            return false;
        }
        try {
            for (int index = 0; index < maxNum; index++) {
                if (vertices[index] != null) {
                    if (vertices[index].id.toLowerCase().equals(a.toLowerCase())) {
                        i = index;
                    }
                    if (vertices[index].id.toLowerCase().equals(b.toLowerCase())) {
                        j = index;
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }

        if (i == -1 || j == -1) {
            return false;
        }
        addEdgeHelper(i, j, cost);
        return true;
    }

    public void addEdgeHelper(int i, int j, double cost) {
        vertices[i].edges.add(new Edge(j, cost));
        vertices[j].edges.add(new Edge(i, cost));
    }

    public void depthFirstTraversal(String id) {
        int index = -1;
        try {
            for (int i = 0; i < numVertices; i++) {
                if (vertices[i].id.toLowerCase().equals(id.toLowerCase())) {
                    index = i;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }

        if (index != -1) {
            myDepthFirstTraversal(index, null);
        }
    }

    public void myDepthFirstTraversal(int i, Vertex parent) {
        System.out.println(vertices[i].id);
        vertices[i].encountered = true;
        vertices[i].parent = parent;
        Iterator<Edge> edgeItr = vertices[i].edges.iterator();
        while (edgeItr.hasNext()) {
            int j = edgeItr.next().toIndex;
            if (!vertices[j].encountered) {
                myDepthFirstTraversal(j, vertices[i]);
            }
        }
    }

    private int minDistance(int dist[], Boolean sptSet[]) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        try {
            for (int v = 0; v < numVertices; v++) {
                if (sptSet[v] == false && dist[v] <= min) {
                    min = dist[v];
                    min_index = v;
                }
            }
        } catch (Exception e) {
        }

        return min_index;
    }

    private int dijkstrasHelper(int source) {
        int dist1[] = new int[numVertices];

        Boolean sptSet[] = new Boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            dist1[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[source] = 0;

        for (int count = 0; count < numVertices - 1; count++) {

            int u = minDistance(dist, sptSet);

            sptSet[u] = true;

            Vertex w = vertices[u];
            Iterator<Edge> itr;
            for (itr = w.edges.iterator(); itr.hasNext();) {
                Edge e = itr.next();
                int v = e.toIndex;

                if (!sptSet[v] && dist1[u] != Integer.MAX_VALUE && dist1[u] + e.cost < dist1[v]) {
                    dist1[v] = (int) (dist1[u] + e.cost);
                }
            }
        }
        // print the constructed distance array
        printSolution(dist1);
        return -1;
    }

    public void printSolution(int dist[]) {
        System.out.println("Vertex \t\t Distance from Source");
        try {
            for (int i = 0; i < numVertices; i++) {
                System.out.println(vertices[i].id + " \t\t " + dist[i]);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        shortest = dist;
    }

    public void dijkstraHeap(String source) {
        int src = -1;
        try {
            for (int i = 0; i < numVertices; i++) {
                if (vertices[i].id.toLowerCase().equals(source.toLowerCase())) {
                    src = i;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        if (src == -1) {
            return;
        }
        dijkstraHeapHelper(src);
    }

    private void dijkstraHeapHelper(int source) {
        int numSet = 0;
        try {
            for (int i = 0; i < numVertices; i++) {
                dist[i] = Integer.MAX_VALUE;
                set[i] = false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }

        pq.add(new Edge(source, 0));
        dist[source] = 0;
        numSet++;
        while (numSet < numVertices) {
            if (pq.isEmpty()) {
                return;
            }
            int index = pq.remove().toIndex;
            if (set[index]) {
                continue;
            }
            set[index] = true;
            processNeighbors(index);
        }
    }

    private void processNeighbors(int x) {
        int edgeDistance = -1;
        int newDistance = -1;
        Vertex v = vertices[x];
        Iterator<Edge> itr;
        for (itr = v.edges.iterator(); itr.hasNext();) {
            Edge e = itr.next();
            int index = e.toIndex;
            if (!set[index]) {
                edgeDistance = (int) e.cost;
                newDistance = dist[x] + edgeDistance;
                if (newDistance < dist[index]) {
                    dist[index] = newDistance;
                }
                pq.add(new Edge(index, dist[index]));
            }
        }
    }
}
