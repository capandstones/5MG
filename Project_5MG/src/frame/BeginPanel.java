package frame;

import java.awt.Color;
import java.awt.Image;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class BeginPanel extends JPanel {

	public BeginPanel() {

		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setSize(600, 800);

		ImageIcon cinema = new ImageIcon("cat_logo.png");
		Image img = cinema.getImage();
		Image changeImg = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JLabel lblCinema = new JLabel(changeIcon);
		lblCinema.setSize(500, 500);
		lblCinema.setLocation(50, 100);
		add(lblCinema);

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						FrameBase.getDispose();
						FrameBase.getInstance(new SelectPanel());
					}
				});
			}
		});

		thread.start();
	}
}