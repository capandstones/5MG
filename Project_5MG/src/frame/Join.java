package frame;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Map;
import javax.swing.*;
import element.UserInfo;

@SuppressWarnings("serial")
public class Join extends JFrame {

	public Join() {

		JFrame f = new JFrame();

		f.setBounds(500, 100, 600, 800);
		f.getContentPane().setBackground(Color.white);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		Font font = new Font("G마켓 산스 TTF Medium", Font.BOLD, 18);

		ImageIcon img = new ImageIcon("button.png");

		JLabel label = new JLabel(img);
		label.setBounds(200, 10, 170, 170);
		f.add(label);

		JLabel name = new JLabel("이름 :");
		JLabel id = new JLabel("아이디 :");
		JLabel pwd = new JLabel("패스워드 :");

		name.setFont(font);
		f.add(name);
		id.setFont(font);
		f.add(id);
		pwd.setFont(font);
		f.add(pwd);

		TextField t1 = new TextField();
		TextField t2 = new TextField();
		TextField t3 = new TextField();

		f.add(t1);
		f.add(t2);
		f.add(t3);

		t3.setEchoChar('*');

		ImageIcon joinImg = new ImageIcon("join.png");
		ImageIcon joingImg2 = new ImageIcon("join (1).png");

		JButton register = new JButton(joinImg);
		register.setRolloverIcon(joingImg2);

		register.setBorderPainted(false);
		register.setContentAreaFilled(false);
		register.setFocusPainted(false);
		register.setBorder(null);

		ImageIcon cancelImg = new ImageIcon("left.png");

		JButton cancel = new JButton(cancelImg);

		cancel.setBorderPainted(false);
		cancel.setContentAreaFilled(false);
		cancel.setFocusPainted(false);
		cancel.setBorder(null);

		f.add(register);
		f.add(cancel);
		name.setBounds(50, 200, 100, 40);
		id.setBounds(50, 250, 100, 40);
		pwd.setBounds(50, 300, 100, 40);

		t1.setBounds(170, 200, 300, 40);
		t2.setBounds(170, 250, 300, 40);
		t3.setBounds(170, 300, 300, 40);

		register.setBounds(160, 453, 108, 40);
		cancel.setBounds(315, 450, 130, 60);

		f.setSize(600, 600);
		f.setTitle("회원가입");
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setVisible(true);

		register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					UserInfo user = new UserInfo();
					Map<String, UserInfo> map = user.userlist();

					if (map.containsKey(t2.getText())) {
						JOptionPane.showMessageDialog(null, "아이디가 존재합니다. 다른 아이디를 입력해주세요.");
					} else {
						BufferedWriter bos = new BufferedWriter(new FileWriter("명단.txt", true));

						bos.write(t1.getText() + "/");
						bos.write(t2.getText() + "/");
						bos.write(t3.getText() + "/");
						bos.write("\r");

						bos.close();
						JOptionPane.showMessageDialog(null, "회원가입을 축하합니다!!");
						f.dispose();
						Frame_Base.getInstance(new Login());
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
				}

			}
		});

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				Frame_Base.getInstance(new Login());

			}
		});

	}
}
