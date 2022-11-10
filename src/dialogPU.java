import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class dialogPU extends JPanel implements ActionListener {

    public JButton no_btn, yes_btn, btn1, btn2, 
    btnReturn, btnMainMenu, btnExit, windowedSize, fullscreenSize, muteMusic, playMusic;
    public JDialog ex_dialog, dialogDesc, dialogSettings, mainDialogSettings;
    public JTextArea desc_area;

    public String text;
    // MainMenu d = new MainMenu();
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

 // in game settings dialog
    public void mainSettings(){
        JFrame mainSettings_dialog = new JFrame();
        mainDialogSettings = new JDialog(mainSettings_dialog);
        mainDialogSettings.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        mainDialogSettings.setSize(300, 200);
        mainDialogSettings.setLocationRelativeTo(null);
        mainDialogSettings.setTitle("Settings");
        
        JLabel musicLabel = new JLabel("Music settings");
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainDialogSettings.add(musicLabel, gbc);
        
     // Mute music button
        muteMusic = new JButton("Mute");
        muteMusic.addActionListener(this);
        muteMusic.setPreferredSize(new Dimension(300, 150)); 
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainDialogSettings.add(muteMusic, gbc);
        
     // Play music button

        playMusic = new JButton("Play");
        playMusic.addActionListener(this);
        playMusic.setPreferredSize(new Dimension(300, 150));
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainDialogSettings.add(playMusic, gbc);
        
        JLabel windowLabel = new JLabel("Window settings");
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainDialogSettings.add(windowLabel, gbc);
        
        // 1920 x 1080 button
        windowedSize = new JButton("1920 x 1080");
        windowedSize.addActionListener(this);
        windowedSize.setPreferredSize(new Dimension(200, 200)); 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainDialogSettings.add(windowedSize, gbc);

        // Fullscreen button
        fullscreenSize = new JButton("Fullscreen");
        fullscreenSize.setPreferredSize(new Dimension(200, 200)); 
        fullscreenSize.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 3;
        
        mainDialogSettings.add(fullscreenSize, gbc); 
        mainDialogSettings.setLocationRelativeTo(null);
        mainDialogSettings.setTitle("Settings");
        mainDialogSettings.setVisible(true);
    }
    
    // in game settings dialog
    public void settings(){
        JFrame settings_dialog = new JFrame();
        dialogSettings = new JDialog(settings_dialog);
        dialogSettings.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        dialogSettings.setSize(300, 200);
        dialogSettings.setLocationRelativeTo(null);
        dialogSettings.setTitle("Settings");

        // add return btn
        btnReturn = new JButton("Return");
        btnReturn.addActionListener(this);
        btnReturn.setPreferredSize(new Dimension(100, 100)); 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 0, 0);
        dialogSettings.add(btnReturn, gbc);

        // add main menu button
        btnMainMenu = new JButton("Main Menu");
        btnMainMenu.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(15, 0, 0, 0);
        dialogSettings.add(btnMainMenu, gbc);

        // add exit game button
        btnExit = new JButton("Exit");
        btnExit.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(15, 0, 0, 0);
        dialogSettings.add(btnExit, gbc);

        dialogSettings.setLocationRelativeTo(null);
        dialogSettings.setTitle("Settings");
        dialogSettings.setVisible(true);
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

        // setting dialog event
        if (btnClick.getSource() == btnReturn){
            dialogSettings.setVisible(false);
        }else if (btnClick.getSource() == btnMainMenu){
            dialogSettings.setVisible(false);
            CardLayoutManager.showPage(1);
        }else if (btnClick.getSource() == btnExit){
            System.exit(0);
        }

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
        
        if (btnClick.getSource() == muteMusic) {
        	MainMenu.stopMusic();
        }
        
        if (btnClick.getSource() == playMusic) {
        	MainMenu.playMusic();
        }
        if (btnClick.getSource() == windowedSize){
        	CardLayoutManager.mainWindow.dispose();
        	CardLayoutManager.mainWindow.setUndecorated(false);
        	CardLayoutManager.mainWindow.setVisible(true);
            CardLayoutManager.mainWindow.setSize(new Dimension(1920,1080));
            CardLayoutManager.mainWindow.setLocationRelativeTo(null);
        }
        
        if (btnClick.getSource() == fullscreenSize){
        	CardLayoutManager.mainWindow.dispose();
        	CardLayoutManager.mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        	CardLayoutManager.mainWindow.setUndecorated(true);
        	CardLayoutManager.mainWindow.setVisible(true);
        }
        
    }
}
