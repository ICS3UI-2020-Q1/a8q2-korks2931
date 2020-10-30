import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables 
  JLabel firstLabel;
  JLabel secondLabel; 
  JLabel resultLabel; 

  JTextField firstInputNumber ;
  JTextField secondInputNumber;
  JTextArea resultOutputArea; 

  JButton addButton;
  JButton subButton;
  JButton mulButton;
  JButton divButton;



  JPanel mainPanel; 


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    // initialize the main panel 
    mainPanel = new JPanel();

    // turn on the manual layouts 
    mainPanel.setLayout(null);

  
    // create the labels that let the user know what to enter 
    firstLabel = new JLabel("First number");
    firstLabel.setBounds (150,200, 120,100);
    secondLabel = new JLabel ("Second number");
    secondLabel.setBounds(150,240,120,100);

    resultLabel = new JLabel ("Result");
    resultLabel.setBounds(150,280,120,100);

    // create the text boxes
    firstInputNumber= new JTextField();
    firstInputNumber.setBounds(370,240,120,20);
    secondInputNumber = new JTextField();
    secondInputNumber.setBounds(370,280,120,20);

    // initialize the buttons 
    addButton = new JButton("Add");
    addButton.setBounds(150,410,90,20);
    subButton = new JButton("Sub");
    subButton.setBounds(250,410,90,20);
    mulButton = new JButton("Mul");
    mulButton.setBounds(350,410,90,20);
    divButton = new JButton("Div");
    divButton.setBounds(450,410,90,20);

    
    // set the action command so we know which button was pressed
    addButton.setActionCommand("Add");
    subButton.setActionCommand("Sub");
    mulButton.setActionCommand("Mul");
    divButton.setActionCommand("Div");


    // add the action listener 
    addButton.addActionListener(this);
    subButton.addActionListener(this);
    mulButton.addActionListener(this);
    divButton.addActionListener(this);

    // create a text area for the result 
    resultOutputArea = new JTextArea();
    resultOutputArea.setBounds(370,320,120,20);
    resultOutputArea.setEnabled(false);

   

 
    //add the labels to the main panel 
    mainPanel.add(firstLabel);
    mainPanel.add(secondLabel);
    mainPanel.add(resultLabel);

    // add the text boxes and areas 
    mainPanel.add(firstInputNumber);
    mainPanel.add(secondInputNumber);
    

    // add the buttons to the panel
    mainPanel.add(addButton);
    mainPanel.add(subButton);
    mainPanel.add(mulButton);
    mainPanel.add(divButton);
    // add the result text area
    mainPanel.add(resultOutputArea);
    
    // add the panel to the JFrame to see it 
    frame.add(mainPanel);
    

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

     // get the numbers that the user entered to use 
     String firstText = firstInputNumber.getText();
     String secondText = secondInputNumber.getText();
     // convert the strings into integers
     int firstNum = Integer.parseInt(firstText);
     int secondNum = Integer.parseInt(secondText);
      int result = 0;
     

     if ( command.equals("Add")){
     // add button was pressed 
    
   // deal with the buttons getting pressed
     result = firstNum + secondNum;
     
   }else if( command.equals("Sub")){
     // sub button was pressed
      result = firstNum - secondNum;
     
   }else if ( command.equals("Mul")){
     // mul button was pressed 
     result = firstNum * secondNum;
   }else if ( command.equals("Div")){
     // div button was pressed 
     result = firstNum / secondNum;
   }
   resultOutputArea.setText("" + result);
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
