/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.MinimumConnectorsLogics;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Hadaragama
 */
public class MinimumConnectors extends javax.swing.JFrame {

    /**
     * Creates new form MinimumConnectors
     */
    static int uid;
    static String uname;
    String disBetCities;
    int val1,val2,val3,val4,val5,val6,val7,val8,val9,val10,val11,val12;
    int totalDistance;
    int[] userAnswers = new int[12];
    int[][] adjacencyMatrix;
    int startPoint;
    int v = 5; // Number of vertices
    int[][] graph = generateGraph(v,10,100);
    MinimumConnectorsLogics mcl = new MinimumConnectorsLogics(graph);
    
    public MinimumConnectors(int uid, String uname) {
        initComponents();
        this.uname = uname;
        this.uid = uid;
        lbl_userName.setText(uname);
        mcl.setUserDetails(uid, uname);
        startPoint = mcl.ReturnStartCity();
        lbl_startCity.setText(""+startPoint);
        System.out.println("Generated Graph:");
        printGraph(graph);      
        adjacencyMatrix = graph;   
        String[] cities = {"0", "1", "2", "3", "4"};
        
        StringBuilder cityConnections = new StringBuilder();

        // Generate the city connections with units
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                int units = adjacencyMatrix[i][j];
                if (units > 0) {
                    cityConnections.append(cities[i]).append(" -> ")
                            .append(cities[j]).append("   :")
                            .append(units).append(" Km || ");
                }
            }
        }

        // Print the city connections
        System.out.println(cityConnections.toString());
        lbl_Connections.setText("<html>"+cityConnections.toString()+"</html>");
        disBetCities=cityConnections.toString();

      ;
    }
    public static int[][] generateGraph(int numVertices, int minValue, int maxValue) {
        int[][] graph = new int[numVertices][numVertices];
        Random random = new Random();
        
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i == j) {
                    graph[i][j] = 0; // No self-loops
                } else {
                    int randomValue = random.nextInt(maxValue - minValue + 1) + minValue;
                    graph[i][j] = randomValue;
                    graph[j][i] = randomValue; // Graph is undirected
                }
            }
        }
        
        return graph;
    }
    // Function to print the adjacency matrix representation of a graph
    public static void printGraph(int[][] graph) {
        int v = graph.length;

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void getUserInput(String total){
       userAnswers[0]  = Integer.parseInt(txt_val1.getText());
       userAnswers[1]  = 1;
       userAnswers[2]  = Integer.parseInt(txt_distance1.getText());
       userAnswers[3]  = Integer.parseInt(txt_val2.getText());
       userAnswers[4]  = 2;
       userAnswers[5]  = Integer.parseInt(txt_distance2.getText());
       userAnswers[6]  = Integer.parseInt(txt_val3.getText());
       userAnswers[7]  = 3;
       userAnswers[8]  = Integer.parseInt(txt_distance3.getText());
       userAnswers[9]  = Integer.parseInt(txt_val4.getText());
       userAnswers[10] = 4;
       userAnswers[11] = Integer.parseInt(txt_distance4.getText());
       totalDistance   = Integer.parseInt(total);
       System.out.println("User's Answer contents: " + Arrays.toString(userAnswers));
       System.out.println("User'sTotal Distance: " + totalDistance);
       
       mcl.setAnswers(userAnswers,totalDistance,disBetCities);
    }
     public void clear(){
       
       userAnswers[0]  = 0;
       userAnswers[1]  = 0;
       userAnswers[2]  = 0;
       userAnswers[3]  = 0;
       userAnswers[4]  = 0;
       userAnswers[5]  = 0;
       userAnswers[6]  = 0;
       userAnswers[7]  = 0;
       userAnswers[8]  = 0;
       userAnswers[9]  = 0;
       userAnswers[10] = 0;
       userAnswers[11] = 0;
       
       totalDistance = 0;
       
       txt_val1.setText("");
       txt_val2.setText("");        
       txt_val3.setText("");
       txt_val4.setText("");
       
       txt_distance1.setText("");
       txt_distance2.setText("");
       txt_distance3.setText("");
       txt_distance4.setText(""); 
       
       txt_totalDistance.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lbl_userID = new javax.swing.JLabel();
        lbl_close = new javax.swing.JLabel();
        lbl_userName = new javax.swing.JLabel();
        lbl_userName1 = new javax.swing.JLabel();
        lbl_close1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbl_instruction = new javax.swing.JLabel();
        lbl_instruction1 = new javax.swing.JLabel();
        lbl_instruction2 = new javax.swing.JLabel();
        btn_submit = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        lbl_instruction3 = new javax.swing.JLabel();
        lbl_startCity = new javax.swing.JLabel();
        lbl_instruction5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbl_City = new javax.swing.JLabel();
        txt_val1 = new javax.swing.JTextField();
        txt_val2 = new javax.swing.JTextField();
        txt_val3 = new javax.swing.JTextField();
        txt_val4 = new javax.swing.JTextField();
        lbl_City1 = new javax.swing.JLabel();
        lbl_City2 = new javax.swing.JLabel();
        lbl_to = new javax.swing.JLabel();
        lbl_to1 = new javax.swing.JLabel();
        lbl_to2 = new javax.swing.JLabel();
        lbl_to3 = new javax.swing.JLabel();
        lbl_to4 = new javax.swing.JLabel();
        lbl_to5 = new javax.swing.JLabel();
        lbl_to6 = new javax.swing.JLabel();
        lbl_to7 = new javax.swing.JLabel();
        lbl_km = new javax.swing.JLabel();
        lbl_km1 = new javax.swing.JLabel();
        lbl_km2 = new javax.swing.JLabel();
        lbl_km3 = new javax.swing.JLabel();
        lbl_City3 = new javax.swing.JLabel();
        lbl_km4 = new javax.swing.JLabel();
        txt_distance1 = new javax.swing.JTextField();
        txt_distance2 = new javax.swing.JTextField();
        txt_distance3 = new javax.swing.JTextField();
        txt_distance4 = new javax.swing.JTextField();
        txt_totalDistance = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lbl_Connections = new javax.swing.JLabel();
        lbl_Details = new javax.swing.JLabel();
        lbl_ConnectionsImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(12, 19, 79));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_userID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_userID.setForeground(new java.awt.Color(255, 255, 255));
        lbl_userID.setText("Hello");
        jPanel2.add(lbl_userID, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 6, -1, 30));

        lbl_close.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lbl_close.setForeground(new java.awt.Color(255, 255, 255));
        lbl_close.setText("X");
        lbl_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_closeMouseClicked(evt);
            }
        });
        jPanel2.add(lbl_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, -1, -1));

        lbl_userName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_userName.setForeground(new java.awt.Color(255, 255, 255));
        lbl_userName.setText("UserName");
        jPanel2.add(lbl_userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 11, -1, -1));

        lbl_userName1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_userName1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_userName1.setText("Find  Minimum Connectors");
        jPanel2.add(lbl_userName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 7, 253, -1));

        lbl_close1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lbl_close1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_close1.setText("<Back");
        lbl_close1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_close1MouseClicked(evt);
            }
        });
        jPanel2.add(lbl_close1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 50));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(560, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_instruction.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_instruction.setText("Puzzle - ");
        jPanel1.add(lbl_instruction, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 6, -1, -1));

        lbl_instruction1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_instruction1.setText("connectors & distances to connect all the cities & total distance starting");
        jPanel1.add(lbl_instruction1, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 26, -1, -1));

        lbl_instruction2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_instruction2.setText("There are five cities connectiong each other.Identify the minimum");
        jPanel1.add(lbl_instruction2, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 6, 422, -1));

        btn_submit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_submit.setForeground(new java.awt.Color(12, 19, 79));
        btn_submit.setText("Submit");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });
        jPanel1.add(btn_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 610, -1, -1));

        btn_clear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_clear.setForeground(new java.awt.Color(12, 19, 79));
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        jPanel1.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 610, -1, -1));

        lbl_instruction3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_instruction3.setText("from the city number :");
        jPanel1.add(lbl_instruction3, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 46, -1, -1));

        lbl_startCity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_startCity.setText("..");
        jPanel1.add(lbl_startCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 46, 9, -1));

        lbl_instruction5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(lbl_instruction5, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 46, -1, -1));

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        lbl_City.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_City.setForeground(new java.awt.Color(12, 19, 79));
        lbl_City.setText("City");

        txt_val1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txt_val1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_val1ActionPerformed(evt);
            }
        });
        txt_val1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_val1KeyPressed(evt);
            }
        });

        txt_val2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txt_val2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_val2ActionPerformed(evt);
            }
        });
        txt_val2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_val2KeyPressed(evt);
            }
        });

        txt_val3.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txt_val3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_val3ActionPerformed(evt);
            }
        });
        txt_val3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_val3KeyPressed(evt);
            }
        });

        txt_val4.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txt_val4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_val4ActionPerformed(evt);
            }
        });
        txt_val4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_val4KeyPressed(evt);
            }
        });

        lbl_City1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_City1.setForeground(new java.awt.Color(12, 19, 79));
        lbl_City1.setText("City");

        lbl_City2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_City2.setForeground(new java.awt.Color(12, 19, 79));
        lbl_City2.setText("Distance");

        lbl_to.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_to.setForeground(new java.awt.Color(12, 19, 79));
        lbl_to.setText("to");

        lbl_to1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_to1.setForeground(new java.awt.Color(12, 19, 79));
        lbl_to1.setText("to");

        lbl_to2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_to2.setForeground(new java.awt.Color(12, 19, 79));
        lbl_to2.setText("to");

        lbl_to3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_to3.setForeground(new java.awt.Color(12, 19, 79));
        lbl_to3.setText("to");

        lbl_to4.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lbl_to4.setForeground(new java.awt.Color(12, 19, 79));
        lbl_to4.setText("1");

        lbl_to5.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lbl_to5.setForeground(new java.awt.Color(12, 19, 79));
        lbl_to5.setText("2");

        lbl_to6.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lbl_to6.setForeground(new java.awt.Color(12, 19, 79));
        lbl_to6.setText("3");

        lbl_to7.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lbl_to7.setForeground(new java.awt.Color(12, 19, 79));
        lbl_to7.setText("4");

        lbl_km.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lbl_km.setForeground(new java.awt.Color(12, 19, 79));
        lbl_km.setText("Km");

        lbl_km1.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lbl_km1.setForeground(new java.awt.Color(12, 19, 79));
        lbl_km1.setText("Km");

        lbl_km2.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lbl_km2.setForeground(new java.awt.Color(12, 19, 79));
        lbl_km2.setText("Km");

        lbl_km3.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lbl_km3.setForeground(new java.awt.Color(12, 19, 79));
        lbl_km3.setText("Km");

        lbl_City3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_City3.setForeground(new java.awt.Color(12, 19, 79));
        lbl_City3.setText("Total Distance        :");

        lbl_km4.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lbl_km4.setForeground(new java.awt.Color(12, 19, 79));
        lbl_km4.setText("Km");

        txt_distance1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txt_distance1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_distance1ActionPerformed(evt);
            }
        });
        txt_distance1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_distance1KeyPressed(evt);
            }
        });

        txt_distance2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txt_distance2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_distance2ActionPerformed(evt);
            }
        });
        txt_distance2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_distance2KeyPressed(evt);
            }
        });

        txt_distance3.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txt_distance3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_distance3ActionPerformed(evt);
            }
        });
        txt_distance3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_distance3KeyPressed(evt);
            }
        });

        txt_distance4.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txt_distance4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_distance4ActionPerformed(evt);
            }
        });
        txt_distance4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_distance4KeyPressed(evt);
            }
        });

        txt_totalDistance.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txt_totalDistance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalDistanceActionPerformed(evt);
            }
        });
        txt_totalDistance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_totalDistanceKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_City)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txt_val1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(lbl_to))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txt_val2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(lbl_to1))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txt_val3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(lbl_to2))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txt_val4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(lbl_to3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_City1)
                            .addComponent(lbl_to5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_to4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_to6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_to7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbl_City3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_City2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txt_totalDistance, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_km4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txt_distance1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(txt_distance2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_km, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_km1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_distance3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_distance4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_km2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_km3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_City)
                    .addComponent(lbl_City1)
                    .addComponent(lbl_City2))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_val1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_to)
                    .addComponent(lbl_to4)
                    .addComponent(lbl_km)
                    .addComponent(txt_distance1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_val2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_to1)
                    .addComponent(lbl_to5)
                    .addComponent(lbl_km1)
                    .addComponent(txt_distance2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_val3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_to2)
                    .addComponent(lbl_to6)
                    .addComponent(lbl_km2)
                    .addComponent(txt_distance3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_val4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_to3)
                    .addComponent(lbl_to7)
                    .addComponent(lbl_km3)
                    .addComponent(txt_distance4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_City3)
                    .addComponent(lbl_km4)
                    .addComponent(txt_totalDistance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, -1, -1));

        lbl_Connections.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lbl_Connections.setForeground(new java.awt.Color(12, 19, 79));
        lbl_Connections.setToolTipText("");
        lbl_Connections.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lbl_Details.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Details.setForeground(new java.awt.Color(12, 19, 79));
        lbl_Details.setText("Distances between cities");

        lbl_ConnectionsImg.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lbl_ConnectionsImg.setForeground(new java.awt.Color(12, 19, 79));
        lbl_ConnectionsImg.setIcon(new javax.swing.ImageIcon("C:\\Users\\Chamod Dilushanka\\Downloads\\minimum.png")); // NOI18N
        lbl_ConnectionsImg.setToolTipText("");
        lbl_ConnectionsImg.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(lbl_Details, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbl_Connections, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_ConnectionsImg)
                .addGap(30, 30, 30))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(lbl_Details)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Connections, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_ConnectionsImg))
                .addGap(12, 12, 12))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 510, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 47, 560, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lbl_closeMouseClicked

    private void lbl_close1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_close1MouseClicked
        clear();
        this.setVisible(false);
        new Home(uid,uname).setVisible(true);
        
    }//GEN-LAST:event_lbl_close1MouseClicked

    private void txt_totalDistanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalDistanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalDistanceActionPerformed

    private void txt_distance4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_distance4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_distance4ActionPerformed

    private void txt_distance3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_distance3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_distance3ActionPerformed

    private void txt_distance2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_distance2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_distance2ActionPerformed

    private void txt_distance1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_distance1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_distance1ActionPerformed

    private void txt_val4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_val4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_val4ActionPerformed

    private void txt_val3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_val3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_val3ActionPerformed

    private void txt_val2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_val2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_val2ActionPerformed

    private void txt_val1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_val1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_val1ActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clear();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        String val1 = txt_val1.getText();
        String val2 = txt_val2.getText();
        String val3 = txt_val3.getText();
        String val4 = txt_val4.getText();

        String distance1 = txt_distance1.getText();
        String distance2 = txt_distance2.getText();
        String distance3 = txt_distance3.getText();
        String distance4 = txt_distance4.getText();
        String total = txt_totalDistance.getText();

        if (val1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter city numbers","Error",JOptionPane.ERROR_MESSAGE);
        } else if(distance1.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter distances between cities","Error",JOptionPane.ERROR_MESSAGE);
        } else if (val2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter city numbers","Error",JOptionPane.ERROR_MESSAGE);
        } else if(distance2.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter distances between cities","Error",JOptionPane.ERROR_MESSAGE);
        } else if (val3.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter city numbers","Error",JOptionPane.ERROR_MESSAGE);
        } else if(distance3.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter distances between cities","Error",JOptionPane.ERROR_MESSAGE);
        } else if (val4.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter city numbers","Error",JOptionPane.ERROR_MESSAGE);
        } else if(distance4.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter distances between cities","Error",JOptionPane.ERROR_MESSAGE);
        }else if(total.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter total distance of between cities","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            getUserInput(total);
        }
    }//GEN-LAST:event_btn_submitActionPerformed

    private void txt_val1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_val1KeyPressed
        char c = evt.getKeyChar();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            txt_val1.setEditable(true);
        } else {
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE) {
                txt_val1.setEditable(true);
            } else {
                JOptionPane.showMessageDialog(this, "Please enter Integer Value !","Information",JOptionPane.ERROR_MESSAGE);
                
                txt_val1.setText("");
            }
        }
    }//GEN-LAST:event_txt_val1KeyPressed

    //Validations for event handling
    private void txt_val2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_val2KeyPressed
        char c = evt.getKeyChar();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            txt_val2.setEditable(true);
        } else {
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE) {
                txt_val2.setEditable(true);
            } else {
                JOptionPane.showMessageDialog(this, "Please enter "
                        + "Integer Value !","Information",JOptionPane.ERROR_MESSAGE);
                
                txt_val2.setText("");
            }
        }
    }//GEN-LAST:event_txt_val2KeyPressed

    private void txt_val3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_val3KeyPressed
        char c = evt.getKeyChar();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            txt_val3.setEditable(true);
        } else {
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE) {
                txt_val3.setEditable(true);
            } else {
                JOptionPane.showMessageDialog(this, "Please enter Integer Value !","Information",JOptionPane.ERROR_MESSAGE);
                
                txt_val3.setText("");
            }
        }
    }//GEN-LAST:event_txt_val3KeyPressed

    private void txt_val4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_val4KeyPressed
        char c = evt.getKeyChar();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            txt_val4.setEditable(true);
        } else {
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE) {
                txt_val4.setEditable(true);
            } else {
                JOptionPane.showMessageDialog(this, "Please enter Integer Value !","Information",JOptionPane.ERROR_MESSAGE);
                
                txt_val4.setText("");
            }
        }
    }//GEN-LAST:event_txt_val4KeyPressed

    private void txt_distance1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_distance1KeyPressed
        char c = evt.getKeyChar();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            txt_distance1.setEditable(true);
        } else {
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE) {
                txt_distance1.setEditable(true);
            } else {
                JOptionPane.showMessageDialog(this, "Please enter Integer Value !","Information",JOptionPane.ERROR_MESSAGE);
                
                txt_distance1.setText("");
            }
        }
    }//GEN-LAST:event_txt_distance1KeyPressed

    private void txt_distance2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_distance2KeyPressed
         char c = evt.getKeyChar();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            txt_distance2.setEditable(true);
        } else {
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE) {
                txt_distance2.setEditable(true);
            } else {
                JOptionPane.showMessageDialog(this, "Please enter Integer Value !","Information",JOptionPane.ERROR_MESSAGE);
                
                txt_distance2.setText("");
            }
        }
    }//GEN-LAST:event_txt_distance2KeyPressed

    private void txt_distance3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_distance3KeyPressed
         char c = evt.getKeyChar();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            txt_distance3.setEditable(true);
        } else {
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE) {
                txt_distance3.setEditable(true);
            } else {
                JOptionPane.showMessageDialog(this, "Please enter Integer Value !","Information",JOptionPane.ERROR_MESSAGE);
                
                txt_distance3.setText("");
            }
        }
    }//GEN-LAST:event_txt_distance3KeyPressed

    private void txt_distance4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_distance4KeyPressed
        char c = evt.getKeyChar();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            txt_distance4.setEditable(true);
        } else {
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE) {
                txt_distance4.setEditable(true);
            } else {
                JOptionPane.showMessageDialog(this, "Please enter Integer Value !","Information",JOptionPane.ERROR_MESSAGE);
                
                txt_distance4.setText("");
            }
        }
    }//GEN-LAST:event_txt_distance4KeyPressed

    private void txt_totalDistanceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_totalDistanceKeyPressed
         char c = evt.getKeyChar();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            txt_totalDistance.setEditable(true);
        } else {
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE) {
                txt_totalDistance.setEditable(true);
            } else {
                JOptionPane.showMessageDialog(this, "Please enter Integer Value !","Information",JOptionPane.ERROR_MESSAGE);
                
                txt_totalDistance.setText("");
            }
        }
    }//GEN-LAST:event_txt_totalDistanceKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MinimumConnectors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MinimumConnectors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MinimumConnectors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MinimumConnectors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MinimumConnectors(uid,uname).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_submit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbl_City;
    private javax.swing.JLabel lbl_City1;
    private javax.swing.JLabel lbl_City2;
    private javax.swing.JLabel lbl_City3;
    private javax.swing.JLabel lbl_Connections;
    private javax.swing.JLabel lbl_ConnectionsImg;
    private javax.swing.JLabel lbl_Details;
    private javax.swing.JLabel lbl_close;
    private javax.swing.JLabel lbl_close1;
    private javax.swing.JLabel lbl_instruction;
    private javax.swing.JLabel lbl_instruction1;
    private javax.swing.JLabel lbl_instruction2;
    private javax.swing.JLabel lbl_instruction3;
    private javax.swing.JLabel lbl_instruction5;
    private javax.swing.JLabel lbl_km;
    private javax.swing.JLabel lbl_km1;
    private javax.swing.JLabel lbl_km2;
    private javax.swing.JLabel lbl_km3;
    private javax.swing.JLabel lbl_km4;
    private javax.swing.JLabel lbl_startCity;
    private javax.swing.JLabel lbl_to;
    private javax.swing.JLabel lbl_to1;
    private javax.swing.JLabel lbl_to2;
    private javax.swing.JLabel lbl_to3;
    private javax.swing.JLabel lbl_to4;
    private javax.swing.JLabel lbl_to5;
    private javax.swing.JLabel lbl_to6;
    private javax.swing.JLabel lbl_to7;
    private javax.swing.JLabel lbl_userID;
    private javax.swing.JLabel lbl_userName;
    private javax.swing.JLabel lbl_userName1;
    private javax.swing.JTextField txt_distance1;
    private javax.swing.JTextField txt_distance2;
    private javax.swing.JTextField txt_distance3;
    private javax.swing.JTextField txt_distance4;
    private javax.swing.JTextField txt_totalDistance;
    private javax.swing.JTextField txt_val1;
    private javax.swing.JTextField txt_val2;
    private javax.swing.JTextField txt_val3;
    private javax.swing.JTextField txt_val4;
    // End of variables declaration//GEN-END:variables

    private void lbl_Connections(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
