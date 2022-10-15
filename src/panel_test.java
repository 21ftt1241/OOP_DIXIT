import java.awt.*;
import javax.swing.*;

public class panel_test {

	public static void main(String[] args) {
		JFrame frame = new JFrame("JFrame Example");
		// set the JFrame to fullscreen
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// JFrame bounds when rescaled
		frame.setBounds(100,100,1280,720);

		// create a new panel
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.gray);
		panel1.setBounds(100,50,300,300);

		container.add(panel1);

		frame.add(container);

		frame.setVisible(true);
	}

}
