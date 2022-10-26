import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class dialogPU extends JPanel implements ActionListener{

    public JButton close_btn, cancel_btn;
    public JDialog ex_dialog, dialog1;


    // void method with no returnable value to be called in other class
    public void dialog_ext(){
        JFrame exit_dialog = new JFrame();
        
        ex_dialog = new JDialog(exit_dialog);

        ex_dialog.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        ex_dialog.setSize(300, 150);
        ex_dialog.setLocationRelativeTo(null);
        ex_dialog.setTitle("Exit Dixit");

        JLabel text1 = new JLabel("Are you sure you want to quit? ");

        cancel_btn = new JButton("Cancel");
        cancel_btn.addActionListener(this);

        close_btn = new JButton("Close");
        close_btn.addActionListener(this);
       
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 10);
        ex_dialog.add(close_btn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 10, 0, 0);
        ex_dialog.add(cancel_btn, gbc);

         // The text
         gbc.fill = GridBagConstraints.HORIZONTAL;
        //  gbc.ipady = 30;
         gbc.gridwidth = 2;
         gbc.gridx = 0;
         gbc.gridy = 0;
         gbc.insets = new Insets(10, 0, 20, 0);
         ex_dialog.add(text1, gbc);

         ex_dialog.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent btnClick){
       if(btnClick.getSource() == cancel_btn){
        ex_dialog.setVisible(false);
       }else if(btnClick.getSource() == close_btn){
        System.exit(0);
       }
    }

    // test dialog
	public void test_m(){
        JFrame test_dialog = new JFrame();
        
        dialog1 = new JDialog(test_dialog);

        dialog1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        dialog1.setSize(300, 150);
        dialog1.setLocationRelativeTo(null);

        JLabel text1 = new JLabel("Test pop up dialog");
       
        // The text
        gbc.fill = GridBagConstraints.HORIZONTAL;
        //  gbc.ipady = 30;
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 20, 0);
        dialog1.add(text1, gbc);

        dialog1.setVisible(true);
    }
}
