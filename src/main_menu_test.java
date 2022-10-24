import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class main_menu_test extends JFrame implements ActionListener {

    exit_dialog exit_game = new exit_dialog();

    public static void main(String args[]) {
        main_menu_test main_menu = new main_menu_test();
        
    }

    // create the buttons and labels
    public JButton btn1, btn2, btn3;
    public JLabel lbl1;

    // define the button's method
    public void buttonGroup() {
        btn1 = new JButton("Start Game");
        btn2 = new JButton("Load Game");
        btn3 = new JButton("Exit Game ");

        lbl1 = new JLabel("DIXIT");

        btn1.setPreferredSize(new Dimension(200, 100));
        btn2.setPreferredSize(new Dimension(200, 100));
        btn3.setPreferredSize(new Dimension(200, 100));


        lbl1.setFont(new Font("Arial", Font.PLAIN, 32));

        btn1.setFont(new Font("Arial", Font.PLAIN, 24));
        btn2.setFont(new Font("Arial", Font.PLAIN, 24));
        btn3.setFont(new Font("Arial", Font.PLAIN, 24));

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
    }

    // main frame panel
    public main_menu_test() {

        // call the button's method
        buttonGroup();

        // initialize the default layout as Grid Bag
        setLayout(new GridBagLayout());

        // The container for the gridbag elements
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 1;
        gbc.gridy = 0;
        // below specify the external padding of the component
        gbc.insets = new Insets(20, 0, 0, 0);
        add(lbl1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(btn1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(btn2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        add(btn3, gbc);

        setTitle("DIXIT | Main Menu");
        setSize(1280, 720);
        setVisible(true);
        setLocationRelativeTo(null); // set the frame to the middle of the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    // the method for the button action event
    public void actionPerformed(ActionEvent btnClick) {
        if (btnClick.getSource() == btn1) {
            System.out.println("Start Game ");
        } else if (btnClick.getSource() == btn2) {
            System.out.println("Load game");
        } else if (btnClick.getSource() == btn3) {
            System.out.println("Show Exit confirmation");
            exit_game.exit_dialog();
        }
    }
}