package frame;

import java.awt.*;
import javax.swing.JFrame;

public class Frame_Base extends JFrame {

	private static Frame_Base instance;

	private Frame_Base(JFrame j) {

		Toolkit tk = Toolkit.getDefaultToolkit();

		setLayout(null);
		setBounds(((int) tk.getScreenSize().getWidth()) / 2 - 300, ((int) tk.getScreenSize().getHeight()) / 2 - 400,
				600, 800);

		getContentPane().setBackground(new Color(226, 224, 222));
		setSize(600, 800);

	}

	static public void getInstance(JFrame j) {
		instance = new Frame_Base(j);

		instance.getContentPane().removeAll();

		instance.revalidate();
		instance.repaint();
	}

	@Override
	public int getDefaultCloseOperation() {
		return super.getDefaultCloseOperation();
	}

}