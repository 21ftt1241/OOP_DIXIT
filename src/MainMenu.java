import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import javax.swing.*;
import javax.sound.sampled.*;

public class MainMenu extends JPanel implements ActionListener {
	
	//Main Menu buttons
	final JButton b1, b2, b3, b4; 
	final JLabel lb;
	
	//Import DialogPU class
	public dialogPU dialog = new dialogPU();
	
	//Import music
	public URL is = MainMenu.class.getResource("dixit_cards/menuMusic.wav");
	public URL is2 = MainMenu.class.getResource("dixit_cards/clickSound.wav");
	public URL is3 = MainMenu.class.getResource("dixit_cards/victorySound.wav");
	public AudioInputStream audioStream = AudioSystem.getAudioInputStream(is);
	public AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(is2);
	public AudioInputStream audioStream3 = AudioSystem.getAudioInputStream(is3);
	public static Clip clip;
	public static Clip clip2;
	public static Clip clip3;
	
	
	public MainMenu() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		//Calls music and sounds method
		playMenuMusic();
		playClick();
		importVictory();
		
		//Import and resize DIXIT logo
		ImageIcon icon = new ImageIcon(getClass().getResource("dixit_cards/dixit-logo.png")); // assign image to a new ImageIcon
		Image image = icon.getImage(); // transform the image
		Image newimg = image.getScaledInstance(715, 260,  java.awt.Image.SCALE_SMOOTH); // scale it smoothly  
		ImageIcon dixitLogo = new ImageIcon(newimg);  // assign to a new ImageIcon instance

		b1 = new JButton("Start Game");
		b2 = new JButton("Game Rules");
		b3 = new JButton("Exit Game");
		b4 = new JButton("Settings");
		lb = new JLabel(dixitLogo);

		//Main Menu button sizes
		b1.setPreferredSize(new Dimension(200, 100));
		b2.setPreferredSize(new Dimension(200, 100));
		b3.setPreferredSize(new Dimension(200, 100));
		b4.setPreferredSize(new Dimension(200, 100));
		
		//Main Menu font sizes
		b1.setFont(new Font("Arial", Font.PLAIN, 24));
		b2.setFont(new Font("Arial", Font.PLAIN, 24));
		b3.setFont(new Font("Arial", Font.PLAIN, 24));
		b4.setFont(new Font("Arial", Font.PLAIN, 24));

		//Main Menu button colors
		b1.setBackground(Color.decode("#F3C94E"));
		b1.setForeground(Color.decode("#000000"));
		b2.setBackground(Color.decode("#F3C94E"));
		b2.setForeground(Color.decode("#000000"));
		b3.setBackground(Color.decode("#F3C94E"));
		b3.setForeground(Color.decode("#000000"));
		b4.setBackground(Color.decode("#F3C94E"));
		b4.setForeground(Color.decode("#000000"));
		
		//Add action listeners to buttons
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		//Main Menu layout & BG color
		setLayout(new GridBagLayout());
		setBackground(Color.decode("#EBD6B1"));

		//set things to grids using this
		GridBagConstraints gb = new GridBagConstraints();

		gb.gridx = 1;
		gb.gridy = 0;
		gb.insets = new Insets(20, 0, 0, 0);
		add(lb, gb);

		gb.gridx = 1;
		gb.gridy = 1;
		add(b1, gb);

		gb.gridx = 1;
		gb.gridy = 2;
		add(b2, gb);

		gb.gridx = 1;
		gb.gridy = 3;
		add(b4, gb);

		gb.gridx = 1;
		gb.gridy = 4;
		add(b3, gb);
	}
	
	//Play Menu Music method
	public void playMenuMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		// BACKGROUND AUDIO
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.loop(clip.LOOP_CONTINUOUSLY);
		clip.start();
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-30.0f); // Reduce volume by 30 decibels.
	}
	
	//Get Buttons sounds method
	public void playClick() throws LineUnavailableException, IOException, LineUnavailableException   {
		 //clip2.setMicrosecondPosition(0);
		clip2 = AudioSystem.getClip();
		clip2.open(audioStream2);
		FloatControl gainControl = (FloatControl) clip2.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
		   	       
	}
	
	//Get Victory Music method
	public void importVictory() throws LineUnavailableException, IOException, LineUnavailableException   {
		 //clip2.setMicrosecondPosition(0);
		clip3 = AudioSystem.getClip();
		clip3.open(audioStream3);
		FloatControl gainControl = (FloatControl) clip3.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(-25.0f); // Reduce volume by 25 decibels.
		   	       
	}
	
	//Play Victory Music method
	public static void playVictory()   {
		clip3.start();   	       
	}
	
	//Play Button sound method
	public static void playClick2()   {
		clip2.setMicrosecondPosition(0);
		clip2.start();   	       
	}
	//Play Menu Music method when clicked
	public static void playMusic()   {
		 clip.setMicrosecondPosition(0);
		 clip.start();   	       
	}
	
	//Stop Victory Music method
	public static void stopVictory()   {
		 clip3.stop();   	       
	}
	
	//Stop Main Menu Music method when clicked
	public static void stopMusic()   {
		 clip.stop();   	       
	}
	
	//Actions
	public void actionPerformed(ActionEvent btnclick) {
		//Plays button sound anytime there is btnclick
		playClick2();
		
		//Main Menu button performs
		//Start game
		if(btnclick.getSource() == b1) {
			CardLayoutManager.showPage(3);
		}
		//Game Rules
		else if(btnclick.getSource() == b2) {
			CardLayoutManager.showPage(2); //calls CLM class and the showPage method
		}
		//Settings
		else if(btnclick.getSource() == b4) {
			dialog.mainSettings();
		}
		//Exit game
		else if(btnclick.getSource() == b3) {
			dialog.dialog_ext();
		}
	}
}
