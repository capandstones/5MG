package frame;

import java.awt.Toolkit;
import javax.swing.*;

public class FrameBase extends JFrame {

	private static FrameBase instance;

	private FrameBase(JPanel e) {
		Toolkit tk = Toolkit.getDefaultToolkit();

		setTitle("오마이 트립");
		setLayout(null);
		setBounds(((int) tk.getScreenSize().getWidth()) / 2 - 300, ((int) tk.getScreenSize().getHeight()) / 2 - 400,
				610, 830);
		add(e);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void getInstance(JPanel e) {
		instance = new FrameBase(e);

		instance.getContentPane().removeAll();
		instance.getContentPane().add(e);

		instance.revalidate();
		instance.repaint();
	}

	public void dipose() {
		super.dispose();
	}

	public static void getDispose() {
		instance.dispose();

	}

}
