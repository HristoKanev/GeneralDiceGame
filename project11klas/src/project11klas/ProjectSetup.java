package project11klas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;



public class ProjectSetup implements ActionListener {


    
    
    private static JButton newGame;
    private static JButton rollDices;
   
    public static JButton exit;
    private static JTable table;
    private static JTable table2;
    private static JTextField textField;
    private static JTable table_1;
    
    public static void main(String[] args) {
        Run();
        
       
    }
    
    ///Proba

    public static void Run(){
        JFrame frame = new JFrame("mainMenu");
        frame.setSize(514,550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.getContentPane().add(panel);
        JLabel title = new JLabel("General - dice game",SwingConstants.CENTER);
        title.setBounds(0,10,500,40);
        title.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
        panel.add(title);

       
        
        rollDices = new JButton("Roll");
        rollDices.setBounds(328,348,135,56);
        rollDices.setHorizontalAlignment(JTextField.CENTER);
        rollDices.addActionListener(new ProjectSetup ());
        panel.add(rollDices);
        
        newGame = new JButton("New game");
        newGame.setBounds(328,132,135,67);
        newGame.setHorizontalAlignment(JTextField.CENTER);
        newGame.addActionListener(new ProjectSetup());
        panel.add(newGame);
        
        
        
        
       
        
        exit = new JButton("Exit");
        exit.setBounds(328,244,135,59);
        exit.setHorizontalAlignment(JTextField.CENTER);
        exit.addActionListener(new ProjectSetup());
        panel.add(exit);
        
        String number1="5";
        String[] columns={"Number","Points"};
        String[] [] data ={{"1", number1}, {"2", number1},{"3", number1},{"4", number1},{"5", number1},{"6", number1}};
        table = new JTable(data,columns);
        
        String[] columns2={"Type","Points"};
        String[] [] data2 ={{"pair", number1}, {"2 pairs", number1},{"triple", number1},{"square", number1},{"full", number1},{"small bucket", number1},{"big bucket", number1},{"chance", number1},{"general", number1},{"total", number1}};
        table2 = new JTable(data2,columns2);
        table2.setBounds(28, 244, 183, 160);
        panel.add(table2);
       
        table.setFillsViewportHeight(true);
        table.setBounds(28, 132, 183, 101);
        
        panel.add(table);
        
        JLabel lblNewLabel = new JLabel("You have        remaining rolls");
        lblNewLabel.setBounds(28, 415, 206, 59);
        panel.add(lblNewLabel);
        
        textField = new JTextField();
        textField.setBounds(84, 434, 13, 20);
        panel.add(textField);
        textField.setColumns(10);
        
       
        
        
        
        
        frame.setFocusable(true);
        frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getExtendedKeyCode()== KeyEvent.VK_ESCAPE)
					 System.exit(0);
					
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
        	
        });

        frame.setVisible(true);
    }
   
   
    
    
   
    
    
    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource()==newGame)
        {
        	 System.exit(0);
        }
        else if(e.getSource()==rollDices)
        {
        	 System.exit(0);
             }
       
        else if(e.getSource()==exit){
            System.exit(0);
        }
        
    }
    }
