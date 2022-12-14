import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class dialogPU extends JPanel implements ActionListener {

    public JButton no_btn, yes_btn, btn1, btn2, 
    btnReturn, btnMainMenu, btnExit, windowedSize, fullscreenSize, muteMusic, playMusic,
    btnPA, btnQuit, advSettings;
    public JDialog ex_dialog, dialogDesc, dialogSettings, mainDialogSettings, endDialog;
    public JTextArea desc_area;

    public String text;

    // exit game dialog pop up
    public void dialog_ext(){
        // Create the frame for the exit dialog pop up
        JFrame exit_dialog = new JFrame();
        ex_dialog = new JDialog(exit_dialog, true);
        ex_dialog.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        ex_dialog.setSize(300, 150);
        ex_dialog.setLocationRelativeTo(null);
        ex_dialog.setTitle("Exit Dixit");

        JLabel text1 = new JLabel("Are you sure you want to quit? ");

        // Exit dialog "Yes" button
        yes_btn = new JButton("Yes");
        yes_btn.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 20, 0, 10);
        ex_dialog.add(yes_btn, gbc);

        // Exit dialog "No" button
        no_btn = new JButton("No");
        no_btn.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        ex_dialog.add(no_btn, gbc);

         // Text label
         gbc.fill = GridBagConstraints.HORIZONTAL;
         gbc.gridwidth = 2;
         gbc.gridx = 0;
         gbc.gridy = 0;
         gbc.insets = new Insets(10, 0, 20, 0);
         ex_dialog.add(text1, gbc);
         ex_dialog.setVisible(true);
    }


       // card descriptor pop up method
    public void card_descPU(){
        // dialog description frame
        dialogDesc = new JDialog(dialogDesc, true);
        dialogDesc.setSize(450, 300);
        dialogDesc.setLocationRelativeTo(null);
	dialogDesc.setAlwaysOnTop(true);
        dialogDesc.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // add confirm btn to frame
        btn1 = new JButton("Confirm");
        btn1.addActionListener(this);      
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets (0, 0, 0, 0);
        dialogDesc.add(btn1, gbc);

        // Text label
        JLabel text1 = new JLabel("Describe your card", SwingConstants.CENTER);
        text1.setFont(new Font("Arial", Font.PLAIN, 24));
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

 // in game settings dialog pop up
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
        
        // Windowed button
        windowedSize = new JButton("Windowed");
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
        // add settings dialog pop up
        JFrame settings_dialog = new JFrame();
        dialogSettings = new JDialog(settings_dialog);
        dialogSettings.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        dialogSettings.setSize(800, 350);
        dialogSettings.setLocationRelativeTo(null);
        dialogSettings.setTitle("Settings");

        // add return btn
        btnReturn = new JButton("Return");
        btnReturn.addActionListener(this);
        btnReturn.setPreferredSize(new Dimension(170, 50)); 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 0, 0);
        dialogSettings.add(btnReturn, gbc);

        btnMainMenu = new JButton("Exit to Main Menu");
        btnMainMenu.addActionListener(this);
        btnMainMenu.setPreferredSize(new Dimension(170, 50)); 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 0, 0);
        dialogSettings.add(btnMainMenu, gbc);
        
        // add exit game button
        btnExit = new JButton("Exit");
        btnExit.addActionListener(this);
        btnExit.setPreferredSize(new Dimension(170, 50));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(20, 0, 0, 0);
        dialogSettings.add(btnExit, gbc);

        // add advance settings button
        advSettings = new JButton("Advance Settings");
        advSettings.addActionListener(this);
        advSettings.setPreferredSize(new Dimension (170, 50));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets (20, 0, 10, 0);
        dialogSettings.add(advSettings, gbc);


        dialogSettings.setLocationRelativeTo(null);
        dialogSettings.setTitle("Settings");
        dialogSettings.setVisible(true);
    }
    
    public void dialogEnd(){

        
    	//Play Victory sound
    	MainMenu.stopMusic();
    	MainMenu.playVictory();

        // end dialog frame
        JFrame ed = new JFrame();
        endDialog = new JDialog(ed, true);
        endDialog.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        endDialog.setSize(450, 250);
        endDialog.setLocationRelativeTo(null);

        JLabel txt1 = new JLabel("Congratulations!");
        txt1.setFont(new Font("Arial", Font.PLAIN, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5,5,5,5);
        endDialog.add(txt1, gbc);
        
        // Winning player text, grabbed using GameFlow class wClr and WName.
        JLabel txt2 = new JLabel(GameFlow.wClr + " (" + GameFlow.wName + ")\n is the winner!" );
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(30, 0, 30, 0);
        endDialog.add(txt2, gbc);

        btnPA = new JButton("Play Again");
        btnPA.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets (0, 0, 0, 150);
        endDialog.add(btnPA, gbc);

        btnQuit = new JButton("Quit game");
        btnQuit.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 150, 0, 0);
        endDialog.add(btnQuit, gbc);
        
        
        endDialog.setVisible(true);
    }

    public String getText(){
        // Used to grab the text from the text area on dialog desc module
        String output = desc_area.getText() + "";
        return output;
    }

    // pop up action event
    public void actionPerformed(ActionEvent btnClick) {

        // setting dialog event
        if (btnClick.getSource() == btnReturn){
            dialogSettings.setVisible(false);
        }else if (btnClick.getSource() == btnExit){
            System.exit(0);
        }else if (btnClick.getSource() == advSettings){
            mainSettings();
        }
        else if (btnClick.getSource() == btnMainMenu) {
        	CardLayoutManager.showPage(1);
        	GameFlow.resetGame();
        	dialogSettings.setVisible(false);
        }

        // Exit Dialog event
        if (btnClick.getSource() == no_btn) {
            ex_dialog.setVisible(false);
        } else if (btnClick.getSource() == yes_btn) {
            System.exit(0);
        }

        // Desc dialog event
        // Open card descriptor dialog
        if (btnClick.getSource() == btn1){        
            dialogDesc.setVisible(false);
            STTurn.label1.setText("Card description: " + getText());
        }else if (btnClick.getSource() == btn2){
            // close card descriptor dialog
            dialogDesc.setVisible(false);
        }
        
        // Mute game music
        if (btnClick.getSource() == muteMusic) {
        	MainMenu.stopMusic();
        	mainDialogSettings.setVisible(false);
        }
        
        // play game music
        if (btnClick.getSource() == playMusic) {
        	MainMenu.playMusic();
        	mainDialogSettings.setVisible(false);
        }

        // Change game windows size to windowed
        if (btnClick.getSource() == windowedSize){
        	CardLayoutManager.mainWindow.dispose();
        	CardLayoutManager.mainWindow.setUndecorated(false);
        	CardLayoutManager.mainWindow.setVisible(true);
            CardLayoutManager.mainWindow.setSize(new Dimension(1920,1080));
            CardLayoutManager.mainWindow.setLocationRelativeTo(null);
            mainDialogSettings.setVisible(false);
        }
        
        // change game windows size to fullscreen
        if (btnClick.getSource() == fullscreenSize){
        	CardLayoutManager.mainWindow.dispose();
        	CardLayoutManager.mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        	CardLayoutManager.mainWindow.setUndecorated(true);
        	CardLayoutManager.mainWindow.setVisible(true);
        	mainDialogSettings.setVisible(false);
        }
        
        // end dialog event
        // Return the player to main menu
        if (btnClick.getSource() == btnPA){
        	MainMenu.stopVictory();
        	MainMenu.playMusic();
            CardLayoutManager.showPage(1);
            endDialog.setVisible(false);
        }else if (btnClick.getSource() == btnQuit){
            // exit the game
            endDialog.setVisible(false);
            System.exit(0);
        }
    }
}
