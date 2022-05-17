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
    private static JTable table;
    private static JTable table2;
    private static JTable table_1;
    
    public static void main(String[] args) {
        Run();
        
       
    }

    public static void Run(){
        JFrame frame = new JFrame("mainMenu");
        frame.setSize(534,550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.getContentPane().add(panel);
        JLabel title = new JLabel("General - dice game",SwingConstants.CENTER);
        title.setBounds(10,10,498,40);
        title.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
        panel.add(title);

       
        
        rollDices = new JButton("Roll");
        rollDices.setBounds(277,174,158,44);
        rollDices.setHorizontalAlignment(JTextField.CENTER);
        rollDices.addActionListener(new ProjectSetup ());
        panel.add(rollDices);
        
        newGame = new JButton("New game");
        newGame.setBounds(277,282,158,67);
        newGame.setHorizontalAlignment(JTextField.CENTER);
        newGame.addActionListener(new ProjectSetup());
        panel.add(newGame);
        
        String number1="5";
        String[] columns={"Number","Points"};
        String[] [] data ={{"1", number1}, {"2", number1},{"3", number1},{"4", number1},{"5", number1},{"6", number1}};
        table = new JTable(data,columns);
        
        String[] columns2={"Type","Points"};
        String[] [] data2 ={{"pair", number1}, {"2 pairs", number1},{"triple", number1},{"square", number1},{"full", number1},{"small bucket", number1},{"big bucket", number1},{"chance", number1},{"general", number1},{"total", number1}};
        table2 = new JTable(data2,columns2);
        table2.setBounds(28, 189, 183, 160);
        panel.add(table2);
       
        table.setFillsViewportHeight(true);
        table.setBounds(28, 77, 183, 101);
        
        panel.add(table);
        
        JLabel lblNewLabel = new JLabel("You have 3 remaining rolls");
        lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(221, 134, 270, 44);
        panel.add(lblNewLabel);
        
        JFormattedTextField formattedTextField = new JFormattedTextField();
        formattedTextField.setFont(new Font("Tahoma", Font.PLAIN, 33));
        formattedTextField.setHorizontalAlignment(SwingConstants.CENTER);
        formattedTextField.setText("2");
        formattedTextField.setBounds(221, 77, 46, 46);
        panel.add(formattedTextField);
        
        JFormattedTextField formattedTextField_1 = new JFormattedTextField();
        formattedTextField_1.setText("2");
        formattedTextField_1.setHorizontalAlignment(SwingConstants.CENTER);
        formattedTextField_1.setFont(new Font("Tahoma", Font.PLAIN, 33));
        formattedTextField_1.setBounds(277, 77, 46, 46);
        panel.add(formattedTextField_1);
        
        JFormattedTextField formattedTextField_2 = new JFormattedTextField();
        formattedTextField_2.setText("2");
        formattedTextField_2.setHorizontalAlignment(SwingConstants.CENTER);
        formattedTextField_2.setFont(new Font("Tahoma", Font.PLAIN, 33));
        formattedTextField_2.setBounds(333, 77, 46, 46);
        panel.add(formattedTextField_2);
        
        JFormattedTextField formattedTextField_3 = new JFormattedTextField();
        formattedTextField_3.setText("2");
        formattedTextField_3.setHorizontalAlignment(SwingConstants.CENTER);
        formattedTextField_3.setFont(new Font("Tahoma", Font.PLAIN, 33));
        formattedTextField_3.setBounds(389, 77, 46, 46);
        panel.add(formattedTextField_3);
        
        JFormattedTextField formattedTextField_4 = new JFormattedTextField();
        formattedTextField_4.setText("3");
        formattedTextField_4.setHorizontalAlignment(SwingConstants.CENTER);
        formattedTextField_4.setFont(new Font("Tahoma", Font.PLAIN, 33));
        formattedTextField_4.setBounds(445, 77, 46, 46);
        panel.add(formattedTextField_4);
        
       
        
        
        
        
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
       
        
    }
    }
