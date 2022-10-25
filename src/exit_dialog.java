import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class exit_dialog extends JPanel implements ActionListener{
    // public static void main (String args[]){
    //     exit_dialog exitGame = new exit_dialog();
    // }

    public JButton close_btn, cancel_btn;
    public JDialog dialog;

    // void method with no returnable value to be called in other class
    public void exit_dialog(){
        JFrame exit_dialog = new JFrame();

        dialog = new JDialog(exit_dialog);

        dialog.setLayout(new GridBagLayout());

        dialog.setSize(800, 800);
        dialog.setLocationRelativeTo(null);

        JLabel text1 = new JLabel("Are you sure you want to quit? ");

        cancel_btn = new JButton("Cancel");
        cancel_btn.addActionListener(this);

        close_btn = new JButton("Close");
        close_btn.addActionListener(this);

        dialog.add(text1);
        dialog.add(close_btn);
        dialog.add(cancel_btn);
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
