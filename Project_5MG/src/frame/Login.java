package frame;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import element.UserInfo;
import main.Main;

public class Login extends JFrame {

	public Login() {

		JFrame f = new JFrame("로그인");

		f.setBounds(500, 100, 600, 800);
		f.getContentPane().setBackground(Color.white);
		f.setLayout(null);
		f.setLocationRelativeTo(null);

		Font font = new Font("G마켓 산스 TTF Medium", Font.BOLD, 18);

		ImageIcon img = new ImageIcon("tripcat2.png");

		JLabel label = new JLabel(img);
		label.setBounds(40, 50, 500, 500);
		f.add(label);

		JLabel b2 = new JLabel("아이디 : ");
		b2.setFont(font);
		f.add(b2);
		JLabel b3 = new JLabel("비밀번호 : ");
		b3.setFont(font);
		f.add(b3);
		TextField b4 = new TextField();
		f.add(b4);
		TextField b5 = new TextField();
		f.add(b5);
		b5.setEchoChar('*');// 암호화
		b4.setFocusTraversalKeysEnabled(false);
		b4.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_TAB) {
					b5.requestFocus();
				}
			}
		});

		ImageIcon loginImg = new ImageIcon("log-in (1).png");
		ImageIcon loginImg2 = new ImageIcon("log-in.png");

		JButton b6 = new JButton(loginImg);
		b6.setRolloverIcon(loginImg2);

		JRootPane rootp = rootPane.getRootPane();
		rootp.setDefaultButton(b6);
		b6.setBorderPainted(false);
		b6.setContentAreaFilled(false);
		b6.setFocusPainted(false);
		b6.setBorder(null);
		f.add(b6);

		ImageIcon joinImg = new ImageIcon("join.png");
		ImageIcon joinImg2 = new ImageIcon("join (1).png");

		JButton register = new JButton(joinImg);
		register.setRolloverIcon(joinImg2);

		register.setBorderPainted(false);
		register.setContentAreaFilled(false);
		register.setFocusPainted(false);
		register.setBorder(null);
		f.add(register);

		b2.setBounds(50, 600, 100, 40);
		b3.setBounds(50, 660, 100, 30);
		b4.setBounds(180, 600, 200, 40);
		b5.setBounds(180, 660, 200, 40);
		b6.setBounds(400, 600, 100, 58);
		register.setBounds(400, 660, 100, 40);

		List<Component> order = new ArrayList<>();
		order.add(b4);
		order.add(b5);
		order.add(b6);
		order.add(register);

		f.setSize(600, 800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("로그인 화면 ");
		f.setVisible(true);

		b6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {// 로그인 할때
				UserInfo user = new UserInfo();

				Map<String, UserInfo> map = user.userlist();

				if (!map.containsKey(b4.getText())) {
					JOptionPane.showMessageDialog(null, "입력하신 아이디가 존재하지 않습니다.");
				} else {
					if (map.get(b4.getText()).getUserPwd().equals(b5.getText())) {
						JOptionPane.showMessageDialog(null, "로그인 되었습니다.");

						Main.main(new String[0]);

						f.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.");
					}
				}
			}
		});

		register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				Join join = new Join();

			}
		});

	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_ENTER) {
			Toolkit.getDefaultToolkit().beep();
		}
	}

}
