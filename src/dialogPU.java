import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class dialogPU extends JPanel implements ActionListener{

    public JButton no_btn, yes_btn, btn1, btn2;
    public JDialog ex_dialog, dialogDesc;
    public JTextArea desc_area;

    public String text;

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

        yes_btn = new JButton("Yes");
        yes_btn.addActionListener(this);
       
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 20, 0, 10);
        ex_dialog.add(yes_btn, gbc);

        no_btn = new JButton("No");
        no_btn.addActionListener(this);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        ex_dialog.add(no_btn, gbc);

         // The text
         gbc.fill = GridBagConstraints.HORIZONTAL;
         gbc.gridwidth = 2;
         gbc.gridx = 0;
         gbc.gridy = 0;
         gbc.insets = new Insets(10, 0, 20, 0);
         ex_dialog.add(text1, gbc);
         ex_dialog.setVisible(true);
    }


       // card descriptor pop up
    public void card_descPU(){
        dialogDesc = new JDialog(dialogDesc);
        dialogDesc.setSize(450, 300);
        dialogDesc.setLocationRelativeTo(null);
        dialogDesc.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        btn1 = new JButton("Confirm");
        btn2 = new JButton("Cancel");

        btn1.addActionListener(this);
        btn2.addActionListener(this);

        // add confirm btn to frame
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets (0, 0, 0, 150);
        dialogDesc.add(btn1, gbc);

        // add cancel btn to frame
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets (0, 150, 0, 0);
        dialogDesc.add(btn2, gbc);

        JLabel text1 = new JLabel("Describe your card", SwingConstants.CENTER);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 10, 0);
        dialogDesc.add(text1, gbc);        

        // set text area
        desc_area = new JTextArea();
        desc_area.setPreferredSize(new Dimension(250, 100));
        desc_area.setLineWrap(true);
        desc_area.setWrapStyleWord(true);

        // call the Text field limit class
        desc_area.setDocument(new JTextFieldLimit(200));

        // add text area to the dialog frame
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        dialogDesc.add(desc_area, gbc);

        dialogDesc.setVisible(true);
    }

    public String getText(){
        String output = desc_area.getText();
        return output;

        // use this code to grab the card description fro other class
        //dialogPU dialog = new dialogPU();
        // String x = dialog.getText();
        // System.out.println(x);
    }

    // pop up action event
    public void actionPerformed(ActionEvent btnClick) {

        // Exit Dialog event
        if (btnClick.getSource() == no_btn) {
            ex_dialog.setVisible(false);
        } else if (btnClick.getSource() == yes_btn) {
            System.exit(0);
        }

        // Desc dialog event
        if (btnClick.getSource() == btn1){
            System.out.println(getText());
            dialogDesc.setVisible(false);
        }else if (btnClick.getSource() == btn2){
            dialogDesc.setVisible(false);
        }
    }
}
