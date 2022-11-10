import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.sound.sampled.*;

public class MainMenu extends JPanel implements ActionListener {
	final JButton b1, b2, b3, b4; 
	final JLabel lb;
	//private BufferedImage image;
	public JButton yes_btn, no_btn;
	public JDialog exit;

	public dialogPU dialog = new dialogPU();
	
	public URL is = MainMenu.class.getResource("dixit_cards/menuMusic.wav");
	public AudioInputStream audioStream = AudioSystem.getAudioInputStream(is);
	public static Clip clip;
	

	public MainMenu()  throws UnsupportedAudioFileException, IOException, LineUnavailableException  {
		
		//Calls Main menu music method
		try {
			playMenuMusic();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ImageIcon icon = new ImageIcon(getClass().getResource("dixit_cards/dixit-logo.png")); // assign image to a new ImageIcon
		Image image = icon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(715, 260,  java.awt.Image.SCALE_SMOOTH); // scale it smoothly  

		ImageIcon dixitLogo = new ImageIcon(newimg);  // assign to a new ImageIcon instance

		b1 = new JButton("Start Game");
		b2 = new JButton("Game Rules");
		b3 = new JButton("Exit Game");
		b4 = new JButton("Settings");
		lb = new JLabel(dixitLogo);

		b1.setPreferredSize(new Dimension(200, 100));
		b2.setPreferredSize(new Dimension(200, 100));
		b3.setPreferredSize(new Dimension(200, 100));
		b4.setPreferredSize(new Dimension(200, 100));

		b1.setFont(new Font("Arial", Font.PLAIN, 24));
		b2.setFont(new Font("Arial", Font.PLAIN, 24));
		b3.setFont(new Font("Arial", Font.PLAIN, 24));
		b4.setFont(new Font("Arial", Font.PLAIN, 24));

		b1.setBackground(Color.decode("#55475B"));
		b1.setForeground(Color.decode("#F9DBA5"));
		b2.setBackground(Color.decode("#55475B"));
		b2.setForeground(Color.decode("#F9DBA5"));
		b3.setBackground(Color.decode("#55475B"));
		b3.setForeground(Color.decode("#F9DBA5"));
		b4.setBackground(Color.decode("#55475B"));
		b4.setForeground(Color.decode("#F9DBA5"));

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);

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
	
	public void playMenuMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		// BACKGROUND AUDIO
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.loop(clip.LOOP_CONTINUOUSLY);
		clip.start();
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-30.0f); // Reduce volume by 10 decibels.
	}
	public static void playMusic()   {
		 clip.setMicrosecondPosition(0);
		 clip.start();   	       
	}
	
	public static void stopMusic()   {
		 clip.stop();   	       
	}
	
	public void actionPerformed(ActionEvent btnclick) {

		//Main Menu button performs
		if(btnclick.getSource() == b1) {
			CardLayoutManager.showPage(3);
			//
		}
		else if(btnclick.getSource() == b2) {
			CardLayoutManager.showPage(2); //calls CLM class and the showPage method
		}

		else if(btnclick.getSource() == b4) {
			dialog.mainSettings();
		}

		else if(btnclick.getSource() == b3) {
			dialog.dialog_ext();
		}	
	}
}
