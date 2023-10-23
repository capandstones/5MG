package frame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import element.*;
import gyeongjudetail.*;

public class GyeongjuHotelListPanel extends JPanel {

	private Cart cart;
	private CartPanel cartPanel;

	public GyeongjuHotelListPanel() {

		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setSize(600, 800);

		ImageIcon home = new ImageIcon("free-icon-home-1946488.png");
		JButton homeBtn = new JButton(home);
		homeBtn.setSize(50, 50);
		homeBtn.setLocation(275, 730);
		homeBtn.setBorderPainted(false);
		homeBtn.setFocusPainted(false);

		add(homeBtn);

		homeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose();
				FrameBase.getInstance(new SelectPanel());
				setVisible(false);
			}
		});

		ImageIcon smap = new ImageIcon("경주.jpg");
		Image img = smap.getImage();
		Image changeImg = img.getScaledInstance(450, 347, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JLabel lblCinema = new JLabel(changeIcon);
		lblCinema.setSize(450, 347);
		lblCinema.setLocation(70, 50);
		add(lblCinema);

		JLabel titleLabel = new JLabel("경주");
		titleLabel.setFont(new Font("여기어때 잘난체", Font.BOLD, 30));
		titleLabel.setSize(600, 50);
		titleLabel.setLocation(0, 0);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		add(titleLabel);

		JButton foodbnt = new JButton("맛집");
		JButton lookbnt = new JButton("관광지");
		JButton hotelbnt = new JButton("숙박");

		foodbnt.setBackground(new Color(255, 255, 255));
		lookbnt.setBackground(new Color(255, 255, 255));
		hotelbnt.setBackground(new Color(255, 255, 255));

		foodbnt.setSize(150, 30);
		foodbnt.setLocation(75, 420);

		foodbnt.setFont(new Font("여기어때 잘난체", Font.BOLD, 25));
		foodbnt.setHorizontalAlignment(SwingConstants.CENTER);

		lookbnt.setSize(150, 30);
		lookbnt.setLocation(225, 420);

		lookbnt.setFont(new Font("여기어때 잘난체", Font.BOLD, 25));
		lookbnt.setHorizontalAlignment(SwingConstants.CENTER);

		hotelbnt.setSize(150, 30);
		hotelbnt.setLocation(375, 420);

		hotelbnt.setFont(new Font("여기어때 잘난체", Font.BOLD, 25));
		hotelbnt.setHorizontalAlignment(SwingConstants.CENTER);

		add(foodbnt);
		add(lookbnt);
		add(hotelbnt);

		lookbnt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose();
				FrameBase.getInstance(new GyeongjuLookListPanel());
				setVisible(false);

			}
		});

		foodbnt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose();
				FrameBase.getInstance(new GyeongjuFoodListPanel());
				setVisible(false);

			}
		});

		hotelbnt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose();
				FrameBase.getInstance(new GyeongjuHotelListPanel());
				setVisible(false);

			}
		});

		JLabel hotelLabel = new JLabel("숙박");
		hotelLabel.setFont(new Font("여기어때 잘난체", Font.BOLD, 25));
		hotelLabel.setSize(100, 50);
		hotelLabel.setLocation(75, 460);

		// 하단의 버튼 설정
		JButton hbtn1 = new JButton("포레스트173");
		JButton hbtn2 = new JButton("중명정원");
		JButton hbtn3 = new JButton("라한 셀렉트");
		JButton hbtn4 = new JButton("황리단스테이");
		JButton hbtn5 = new JButton("청공한옥스테이");

		hbtn1.setBackground(new Color(255, 255, 255));
		hbtn2.setBackground(new Color(255, 255, 255));
		hbtn3.setBackground(new Color(255, 255, 255));
		hbtn4.setBackground(new Color(255, 255, 255));
		hbtn5.setBackground(new Color(255, 255, 255));

		hbtn1.setSize(450, 30);
		hbtn1.setLocation(85, 510);

		hbtn1.setFont(new Font("G마켓 산스 TTF Medium", Font.BOLD, 20));
		hbtn1.setHorizontalAlignment(SwingConstants.LEFT);
		hbtn1.setBorderPainted(false);
		hbtn1.setFocusPainted(false);

		hbtn2.setSize(450, 30);
		hbtn2.setLocation(85, 545);

		hbtn2.setFont(new Font("G마켓 산스 TTF Medium", Font.BOLD, 20));
		hbtn2.setHorizontalAlignment(SwingConstants.LEFT);
		hbtn2.setBorderPainted(false);
		hbtn2.setFocusPainted(false);

		hbtn3.setSize(450, 30);
		hbtn3.setLocation(85, 580);

		hbtn3.setFont(new Font("G마켓 산스 TTF Medium", Font.BOLD, 20));
		hbtn3.setHorizontalAlignment(SwingConstants.LEFT);
		hbtn3.setBorderPainted(false);
		hbtn3.setFocusPainted(false);

		hbtn4.setSize(450, 30);
		hbtn4.setLocation(85, 615);

		hbtn4.setFont(new Font("G마켓 산스 TTF Medium", Font.BOLD, 20));
		hbtn4.setHorizontalAlignment(SwingConstants.LEFT);
		hbtn4.setBorderPainted(false);
		hbtn4.setFocusPainted(false);

		hbtn5.setSize(450, 30);
		hbtn5.setLocation(85, 650);

		hbtn5.setFont(new Font("G마켓 산스 TTF Medium", Font.BOLD, 20));
		hbtn5.setHorizontalAlignment(SwingConstants.LEFT);
		hbtn5.setBorderPainted(false);
		hbtn5.setFocusPainted(false);

		add(hotelLabel);
		add(hbtn1);
		add(hbtn2);
		add(hbtn3);
		add(hbtn4);
		add(hbtn5);

		ImageIcon icon = new ImageIcon("free-icon-images-8346099.png");
		JButton Imghbtn1 = new JButton(icon);
		JButton Imghbtn2 = new JButton(icon);
		JButton Imghbtn3 = new JButton(icon);
		JButton Imghbtn4 = new JButton(icon);
		JButton Imghbtn5 = new JButton(icon);

		Imghbtn1.setSize(30, 30);
		Imghbtn1.setLocation(50, 510);
		Imghbtn2.setSize(30, 30);
		Imghbtn2.setLocation(50, 545);
		Imghbtn3.setSize(30, 30);
		Imghbtn3.setLocation(50, 580);
		Imghbtn4.setSize(30, 30);
		Imghbtn4.setLocation(50, 615);
		Imghbtn5.setSize(30, 30);
		Imghbtn5.setLocation(50, 650);

		add(Imghbtn1);
		add(Imghbtn2);
		add(Imghbtn3);
		add(Imghbtn4);
		add(Imghbtn5);

		ImageIcon look1 = new ImageIcon("경주_숙소1(포레스트173-1).jpg");
		Image limg1 = look1.getImage();
		ImageIcon look2 = new ImageIcon("경주_숙소2(중명정원1).jpg");
		Image limg2 = look2.getImage();
		ImageIcon look3 = new ImageIcon("경주_숙소3(라한 셀렉트1).jpg");
		Image limg3 = look3.getImage();
		ImageIcon look4 = new ImageIcon("경주_숙소4(황리단스테이1).jpg");
		Image limg4 = look4.getImage();
		ImageIcon look5 = new ImageIcon("경주_숙소5(청공한옥스테이1).jpg");
		Image limg5 = look5.getImage();

		hbtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose();
				FrameBase.getInstance(new GyeongjuHotelDetailPage1("포레스트173"));
				setVisible(false);
			}
		});

		hbtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose();
				FrameBase.getInstance(new GyeongjuHotelDetailPage2("증명정원"));
				setVisible(false);
			}
		});

		hbtn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose();
				FrameBase.getInstance(new GyeongjuHotelDetailPage3("라한 셀렉트"));
				setVisible(false);
			}
		});

		hbtn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose();
				FrameBase.getInstance(new GyeongjuHotelDetailPage4("황리단스테이"));
				setVisible(false);
			}
		});

		hbtn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose();
				FrameBase.getInstance(new GyeongjuHotelDetailPage5("청공한옥스테이"));
				setVisible(false);
			}
		});

		Imghbtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblCinema.setIcon(new ImageIcon(limg1));
			}
		});

		Imghbtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblCinema.setIcon(new ImageIcon(limg2));
			}
		});

		Imghbtn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblCinema.setIcon(new ImageIcon(limg3));
			}
		});

		Imghbtn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblCinema.setIcon(new ImageIcon(limg4));
			}
		});

		Imghbtn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblCinema.setIcon(new ImageIcon(limg5));
			}
		});

		cart = new Cart();
		cartPanel = new CartPanel(cart);

		// 뒤로가기
		ImageIcon back = new ImageIcon("돌아가기.png");
		JButton backBtn = new JButton(back);
		backBtn.setSize(50, 50);
		backBtn.setLocation(20, 730);
		backBtn.setBorderPainted(false);
		backBtn.setFocusPainted(false);
		add(backBtn);

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose();
				FrameBase.getInstance(new SelectPanel());
				setVisible(false);

			}
		});

		// 장바구니
		ImageIcon like = new ImageIcon("찜.png");
		JButton likeBtn = new JButton(like);
		likeBtn.setSize(50, 50);
		likeBtn.setLocation(530, 730);
		likeBtn.setBorderPainted(false);
		likeBtn.setFocusPainted(false);

		add(likeBtn);

		likeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, cartPanel, "장바구니", JOptionPane.PLAIN_MESSAGE);
			}
		});

		// 일정 버튼
		ImageIcon time = new ImageIcon("일정.png");
		JButton timeBtn = new JButton(time);
		timeBtn.setSize(50, 50);
		timeBtn.setLocation(460, 730);
		timeBtn.setBorderPainted(false);
		timeBtn.setFocusPainted(false);
		add(timeBtn);

		timeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel reservationPanel = new JPanel();
				reservationPanel.setLayout(new BoxLayout(reservationPanel, BoxLayout.Y_AXIS));

				String[] tlist = { "달그리안", "디 아넥스" };

				for (String list : tlist) {
					ReservationConfirm confirmPanel = new ReservationConfirm(list);
					reservationPanel.add(confirmPanel);
				}

				JFrame confirmFrame = new JFrame("예약 확인");
				confirmFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				confirmFrame.setSize(500, 800);
				confirmFrame.add(reservationPanel);
				confirmFrame.setVisible(true);
			}
		});

		// 검색
		ImageIcon search = new ImageIcon("검색.png");
		JButton searchBtn = new JButton(search);
		searchBtn.setSize(50, 50);
		searchBtn.setLocation(390, 730);
		searchBtn.setBorderPainted(false);
		searchBtn.setFocusPainted(false);

		add(searchBtn);

		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameSearch frameSearch = new FrameSearch();
				frameSearch.setVisible(true);
			}
		});

	}

}
