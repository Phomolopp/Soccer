
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;


public class Player extends JFrame
{
    JPanel registerPanel,namePanel,PositionPanel,preferredFootPanel,feePanel,buttonPanel,firstPanel,mainPanel,textAreaPanel;
    JLabel registerLnameLabel,nameLabel,positionLabel,preferredFootLabel,feeLabel;
    JTextField nameField,positionfField,preferredFootField,feeField;
    JComboBox positionComboBox,preferredFootComboBox,feeComboBox;
    JButton registerButton,displayButton;
    JTextArea textArea;
    JScrollPane scrollPane;
    JSpinner feeSpinner;
    
    File file;
    FileWriter fWriter;
    BufferedWriter bWriter;
    FileReader fReader;
    BufferedReader bReader;
    
    public Player() 
    {
        setSize(350, 450);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        
        file = new File("data.txt");
        
        firstPanel = new JPanel(new GridLayout(6,1,1,1));
        registerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        PositionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        preferredFootPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        feePanel =  new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        textAreaPanel = new JPanel(new FlowLayout());
        mainPanel = new JPanel(new BorderLayout());
        
        //Register a new player
        registerLnameLabel = new JLabel("Register A New Player");
        registerPanel.add(registerLnameLabel);
        firstPanel.add(registerPanel);
        mainPanel.add(firstPanel,BorderLayout.NORTH);
        
        //Editing the name panel
        nameLabel = new JLabel("Name:            ");
        nameField = new JTextField(15);
        namePanel.add(nameLabel);
        namePanel.add(nameField);
        firstPanel.add(namePanel);
        
        //Editing the position panel
        positionLabel = new JLabel("Position:        ");
        positionComboBox = new JComboBox();
        positionComboBox.addItem("");
        positionComboBox.addItem("GK");
        positionComboBox.addItem("CB");
        positionComboBox.addItem("LB");
        positionComboBox.addItem("RB");
        positionComboBox.addItem("CM");
        positionComboBox.addItem("CAM");
        positionComboBox.addItem("LW");
        positionComboBox.addItem("RW");
        positionComboBox.addItem("ST");
        PositionPanel.add(positionLabel);
        PositionPanel.add(positionComboBox);
        firstPanel.add(PositionPanel);
        
        //Editing Preferred foot
         //Editing Preferred foot
        preferredFootLabel = new JLabel("Preferred Foot");
        preferredFootPanel.add(preferredFootLabel);
        preferredFootComboBox = new JComboBox();
        preferredFootComboBox.addItem("");
        preferredFootComboBox.addItem("Left");
        preferredFootComboBox.addItem("Right");
        preferredFootComboBox.addItem("Both");
        preferredFootPanel.add(preferredFootComboBox);
        firstPanel.add(preferredFootPanel);
        
        //EDITING Fee
        feeSpinner = new JSpinner(new SpinnerNumberModel(400, 100, 600, 50));
        feeSpinner.setSize(15,15);
        feeLabel = new JLabel("Fee");
        feePanel.add(feeLabel);
        feePanel.add(feeSpinner);
        firstPanel.add(feePanel);
        
        //editing Buttons
        registerButton = new JButton("REGISTER");
        registerButton.addActionListener(new Register());
        displayButton = new JButton("DISPLAY");
        displayButton.addActionListener(new Display());
        buttonPanel.add(registerButton);
        buttonPanel.add(displayButton);  
        firstPanel.add(buttonPanel);
        
        textArea = new JTextArea(10,5);
        
        scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        add(mainPanel, BorderLayout.NORTH);
        add(scrollPane,BorderLayout.SOUTH);
        setVisible(true);
    }

    private class Display implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            try {
                fReader = new FileReader(file);
                bReader = new BufferedReader(fReader);
                
                String text = "",store = ""; 
                
                while ((text = bReader.readLine()) != null) 
                {                    
                    store = store + text;
                }
                
                textArea.setText(store);
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    private  class Register implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            try {
                fWriter = new FileWriter(file,true);
                bWriter = new BufferedWriter(fWriter);
                
                String name = nameField.getText();
                String position = (String) positionComboBox.getSelectedItem();
                String feet = (String) preferredFootComboBox.getSelectedItem();
                int fee = (int) feeSpinner.getValue();
                
                Check check = new Check(name,position,feet,fee);
                
                bWriter.write(check.toString()+"\n");
                bWriter.close();
                fWriter.close();
                
            } catch (IOException ex) 
            {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    
    
}
