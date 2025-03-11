/**
 * JMJ
 * @author Martin Tejada
 * @version 1.0
 * @since Febuary, 2025
 * 
 */

 import java.awt.*;
 import javax.swing.*;
 import javax.swing.border.EmptyBorder;
 
 public class dot_prod_app {
     private int vector_len = 0;
     private double dot_p = 0;
     public static void main(String[] args) {
      
         new dot_prod_app().display();
         
     }
 
     public void display(){

         JFrame frame = new JFrame("Dot Product Calculator");
 
         // components to ask and get dimensions
         JLabel title = new JLabel(" Enter the length of both vectors: "); 
         Integer [] nums = {1,2,3,4,5,6,7,8,9}; // list to hold number options (amount of components in vector) ex: 3 = vector = {x,y,z}

         JComboBox<Integer> len = new JComboBox<>(nums); // add to drop down menu
         len.addActionListener(e -> vector_len = (Integer) len.getSelectedItem());
         len.setSelectedItem(1);

         title.setBorder(new EmptyBorder(0, 5, 0, 0));
         title.setFont(new Font("Arial", Font.BOLD,13));
         len.setBorder(new EmptyBorder(70, 10, 70, 15));
 
         // button to start input of vectors
         JButton start = new JButton("Start! ");
         JPanel start_pad = new JPanel();
         start_pad.add(start);

         // if button pressed go to input vectors
         start.addActionListener(e -> calculate_dotproduct());
 
         JPanel p1 = new JPanel(); // panel to hold buttons for desire format
         p1.setLayout(new GridLayout(1,2));
         p1.add(title);
         p1.add(len);
 
 
         frame.setLayout(new GridLayout(2,1));
         frame.add(p1);
         frame.add(start_pad);
 
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
         frame.setSize(500,400);
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);
     }
 
     public void calculate_dotproduct(){

         JFrame frame = new JFrame("Dot Product Calculator");
         JLabel ask = new JLabel("   Enter Vector 1 and 2 Components: ");
         ask.setFont(new Font("Arial", Font.BOLD,13));
         
         JPanel v1 = new JPanel();
         v1.setLayout(new GridLayout(1, vector_len));
 
         JTextField[] v1Fields = new JTextField[vector_len]; // Store references
 
         for(int i = 0; i < vector_len; i++){
             v1Fields[i] = new JTextField(i);
             v1.add(v1Fields[i]);
         }
 
         JPanel v2 = new JPanel();
         v2.setLayout(new GridLayout(1, vector_len));
 
         JTextField[] v2Fields = new JTextField[vector_len]; // Store references
 
         for(int i = 0; i < vector_len; i++){
             v2Fields[i] = new JTextField(i + 1);
             v2.add(v2Fields[i]);
         }
 
         JPanel options = new JPanel();
         JButton comp = new JButton("Find Dot Product");
         JButton retry = new JButton("New vector length");
         options.add(comp); options.add(retry);
 
         // calculate dot product
         comp.addActionListener(e -> {
             dot_p = 0;
             double [] v1Values = new double[vector_len]; // Array to store integer values from v1Fields
             double [] v2Values = new double[vector_len]; // Array to store integer values from v2Fields
 
             for (int i = 0; i < vector_len; i++) {
                 v1Values[i] = Double.parseDouble(v1Fields[i].getText().trim()); // Convert text to integer
                 v2Values[i] = Double.parseDouble(v2Fields[i].getText().trim()); // Convert text to integer

                 dot_p += (v1Values[i] * v2Values[i]); // Calculate dot product by multiplying vector components and adding them together
             }   
             ask.setText("    The dot product of these vectors is: " + dot_p);   // Change text to display dot product of vectors        
             ask.setFont(new Font("Arial", Font.BOLD,13));
            });
         
 
         // go back to previous for new dimensions
         retry.addActionListener(e -> {display(); dot_p = 0;});
 
         frame.setLayout(new GridLayout(4,1));
         frame.add(ask);
         frame.add(v1);
         frame.add(v2);
         frame.add(options);
 
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(500,400);
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);
 
     }
 
 }
 // JMJ