import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class exit_dialog extends JPanel implements ActionListener{

    public JButton close_btn, cancel_btn;
    public JDialog dialog;


    // void method with no returnable value to be called in other class
    public void exit_dialog(){
        JFrame exit_dialog = new JFrame();
        
        dialog = new JDialog(exit_dialog);

        dialog.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(null);

        JLabel text1 = new JLabel("Are you sure you want to quit? ");

        cancel_btn = new JButton("Cancel");
        cancel_btn.addActionListener(this);

        close_btn = new JButton("Close");
        close_btn.addActionListener(this);
       
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 10);
        dialog.add(close_btn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 10, 0, 0);
        dialog.add(cancel_btn, gbc);

         // The text
         gbc.fill = GridBagConstraints.HORIZONTAL;
        //  gbc.ipady = 30;
         gbc.gridwidth = 2;
         gbc.gridx = 0;
         gbc.gridy = 0;
         gbc.insets = new Insets(10, 0, 20, 0);
         dialog.add(text1, gbc);

        dialog.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent btnClick){
       if(btnClick.getSource() == cancel_btn){
        dialog.setVisible(false);
       }else if(btnClick.getSource() == close_btn){
        System.exit(0);
       }
    }

	// public void exit_dialog() {
	// }
}
