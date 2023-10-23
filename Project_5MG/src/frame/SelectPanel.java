package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import element.Cart;
import element.CartPanel;
import element.ReservationConfirm;
import gyeongjudetail.GyeongjuFoodDetailPage1;
import gyeongjudetail.GyeongjuFoodDetailPage2;
import gyeongjudetail.GyeongjuFoodDetailPage3;
import gyeongjudetail.GyeongjuFoodDetailPage4;
import gyeongjudetail.GyeongjuFoodDetailPage5;
import gyeongjudetail.GyeongjuHotelDetailPage5;
import gyeongjudetail.GyeongjuLookDetailPage1;
import gyeongjudetail.GyeongjuLookDetailPage2;
import gyeongjudetail.GyeongjuLookDetailPage3;
import gyeongjudetail.GyeongjuLookDetailPage4;
import jejudetail.JejuFoodDetailPage1;
import jejudetail.JejuFoodDetailPage2;
import jejudetail.JejuFoodDetailPage3;
import jejudetail.JejuFoodDetailPage4;
import jejudetail.JejuFoodDetailPage5;
import jejudetail.JejuLookDetailPage1;
import jejudetail.JejuLookDetailPage2;
import jejudetail.JejuLookDetailPage3;
import jejudetail.JejuLookDetailPage4;
import jejudetail.JejuLookDetailPage5;
import jeonjudetail.JeonjuFoodDetailPage1;
import jeonjudetail.JeonjuFoodDetailPage2;
import jeonjudetail.JeonjuFoodDetailPage3;
import jeonjudetail.JeonjuFoodDetailPage4;
import jeonjudetail.JeonjuFoodDetailPage5;
import jeonjudetail.JeonjuLookDetailPage1;
import jeonjudetail.JeonjuLookDetailPage2;
import jeonjudetail.JeonjuLookDetailPage3;
import jeonjudetail.JeonjuLookDetailPage4;
import jeonjudetail.JeonjuLookDetailPage5;
import sokchodetail.SokchoFoodDetailPage1;
import sokchodetail.SokchoFoodDetailPage2;
import sokchodetail.SokchoFoodDetailPage3;
import sokchodetail.SokchoFoodDetailPage4;
import sokchodetail.SokchoFoodDetailPage5;
import sokchodetail.SokchoLookDetailPage1;
import sokchodetail.SokchoLookDetailPage2;
import sokchodetail.SokchoLookDetailPage3;
import sokchodetail.SokchoLookDetailPage4;
import sokchodetail.SokchoLookDetailPage5;

public class SelectPanel extends JPanel {
	private Cart cart;
	private CartPanel cartPanel;
	private JPanel[] panels;
	private Random random;

	public SelectPanel() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setSize(600, 800);

		// 포스터 이미지
		ImageIcon cinema = new ImageIcon("tripcat.png");
		Image img = cinema.getImage();
		Image changeImg = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JLabel lblCinema = new JLabel(changeIcon);
		lblCinema.setSize(500, 380);
		lblCinema.setLocation(50, 50);
		add(lblCinema);

		// 하단의 버튼 설정
		JButton hbtn1 = new JButton("제주");
		JButton hbtn2 = new JButton("속초");
		JButton hbtn3 = new JButton("경주");
		JButton hbtn4 = new JButton("전주");

		hbtn1.setBackground(new Color(255, 255, 255));
		hbtn2.setBackground(new Color(255, 255, 255));
		hbtn3.setBackground(new Color(255, 255, 255));
		hbtn4.setBackground(new Color(255, 255, 255));

		hbtn1.setSize(600, 50);
		hbtn1.setLocation(0, 420);

		hbtn1.setFont(new Font("여기어때 잘난체", Font.BOLD, 40));
		hbtn1.setHorizontalAlignment(SwingConstants.LEFT);
		hbtn1.setHorizontalAlignment(JLabel.CENTER);
		hbtn1.setBorderPainted(false);
		hbtn1.setFocusPainted(false);

		hbtn2.setSize(600, 50);
		hbtn2.setLocation(0, 480);

		hbtn2.setFont(new Font("여기어때 잘난체", Font.BOLD, 40));
		hbtn2.setHorizontalAlignment(SwingConstants.LEFT);
		hbtn2.setHorizontalAlignment(JLabel.CENTER);
		hbtn2.setBorderPainted(false);
		hbtn2.setFocusPainted(false);

		hbtn3.setSize(600, 50);
		hbtn3.setLocation(0, 540);

		hbtn3.setFont(new Font("여기어때 잘난체", Font.BOLD, 40));
		hbtn3.setHorizontalAlignment(SwingConstants.LEFT);
		hbtn3.setHorizontalAlignment(JLabel.CENTER);
		hbtn3.setBorderPainted(false);
		hbtn3.setFocusPainted(false);

		hbtn4.setSize(600, 50);
		hbtn4.setLocation(0, 600);

		hbtn4.setFont(new Font("여기어때 잘난체", Font.BOLD, 40));
		hbtn4.setHorizontalAlignment(SwingConstants.LEFT);
		hbtn4.setHorizontalAlignment(JLabel.CENTER);
		hbtn4.setBorderPainted(false);
		hbtn4.setFocusPainted(false);

		add(hbtn1);
		add(hbtn2);
		add(hbtn3);
		add(hbtn4);

		hbtn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose();
				FrameBase.getInstance(new JejuFoodListPanel());
				setVisible(false);

			}
		});

		hbtn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose();
				FrameBase.getInstance(new SokchoFoodListPanel());
				setVisible(false);

			}
		});

		hbtn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose();
				FrameBase.getInstance(new GyeongjuFoodListPanel());
				setVisible(false);

			}
		});

		hbtn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose();
				FrameBase.getInstance(new JeonjuFoodListPanel());
				setVisible(false);

			}
		});

		JButton hbtn5 = new JButton("여기 어때?");
		hbtn5.setSize(600, 50);
		hbtn5.setLocation(0, 660);
		hbtn5.setBackground(new Color(255, 255, 255));
		hbtn5.setFont(new Font("여기어때 잘난체", Font.BOLD, 40));
		hbtn5.setHorizontalAlignment(SwingConstants.LEFT);
		hbtn5.setHorizontalAlignment(JLabel.CENTER);
		hbtn5.setBorderPainted(false);
		hbtn5.setFocusPainted(false); // 포커스 테두리 숨김
		add(hbtn5);

		hbtn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int randomAction = (int) (Math.random() * 40);

				if (randomAction == 0) {
					// 첫 번째 랜덤 액션
					Cart cart = new Cart();
					FrameBase.getDispose();
					FrameBase.getInstance(new GyeongjuFoodDetailPage1("남정부일기사식당"));
					setVisible(false);
				} else if (randomAction == 1) {
					// 두 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new GyeongjuFoodDetailPage2("양지식당"));
					setVisible(false);
				} else if (randomAction == 2) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new GyeongjuFoodDetailPage3("빼돌린뒷고기"));
					setVisible(false);
				} else if (randomAction == 3) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new GyeongjuFoodDetailPage4("황남경주식당"));
					setVisible(false);
				} else if (randomAction == 4) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new GyeongjuFoodDetailPage5("카페 바실라"));
					setVisible(false);
				} else if (randomAction == 5) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new GyeongjuLookDetailPage1("불국사"));
					setVisible(false);
				} else if (randomAction == 6) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new GyeongjuLookDetailPage2("월정교"));
					setVisible(false);
				} else if (randomAction == 7) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new GyeongjuLookDetailPage3("첨성대"));
					setVisible(false);
				} else if (randomAction == 8) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new GyeongjuLookDetailPage4("동궁과월지"));
					setVisible(false);
				} else if (randomAction == 9) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new GyeongjuHotelDetailPage5("양동마을"));
					setVisible(false);
				} else if (randomAction == 10) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new JejuFoodDetailPage1("갈치왕"));
					setVisible(false);
				} else if (randomAction == 11) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new JejuFoodDetailPage2("광해"));
					setVisible(false);
				} else if (randomAction == 12) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new JejuFoodDetailPage3("온오프"));
					setVisible(false);
				} else if (randomAction == 13) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new JejuFoodDetailPage4("흑돼지BBQ"));
					setVisible(false);
				} else if (randomAction == 14) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new JejuFoodDetailPage5("칠돈가"));
					setVisible(false);
				} else if (randomAction == 15) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new JejuLookDetailPage1("성산일출봉"));
					setVisible(false);
				} else if (randomAction == 16) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new JejuLookDetailPage2("아르떼"));
					setVisible(false);
				} else if (randomAction == 17) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new JejuLookDetailPage3("우도"));
					setVisible(false);
				} else if (randomAction == 18) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new JejuLookDetailPage4("천지연폭포"));
					setVisible(false);
				} else if (randomAction == 19) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new JejuLookDetailPage5("카멜리아힐"));
					setVisible(false);
				} else if (randomAction == 20) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new JeonjuFoodDetailPage1("메르밀진미집"));
					setVisible(false);
				} else if (randomAction == 21) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new JeonjuFoodDetailPage2("진미집"));
					setVisible(false);
				} else if (randomAction == 22) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new JeonjuFoodDetailPage3("카페 전망"));
					setVisible(false);
				} else if (randomAction == 23) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new JeonjuFoodDetailPage4("한방 오리촌"));
					setVisible(false);
				} else if (randomAction == 24) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new JeonjuFoodDetailPage5("황제보쌈"));
					setVisible(false);
				} else if (randomAction == 25) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new JeonjuLookDetailPage1("한옥마을"));
					setVisible(false);
				} else if (randomAction == 26) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new JeonjuLookDetailPage2("경기전"));
					setVisible(false);
				} else if (randomAction == 27) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new JeonjuLookDetailPage3("객리단길"));
					setVisible(false);
				} else if (randomAction == 28) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new JeonjuLookDetailPage4("수목원"));
					setVisible(false);
				} else if (randomAction == 29) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new JeonjuLookDetailPage5("덕진 공원"));
					setVisible(false);
				} else if (randomAction == 30) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new SokchoFoodDetailPage1("속초신토불이감자옹심이"));
					setVisible(false);
				} else if (randomAction == 31) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new SokchoFoodDetailPage2("성진활어"));
					setVisible(false);
				} else if (randomAction == 32) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new SokchoFoodDetailPage3("키친온유"));
					setVisible(false);
				} else if (randomAction == 33) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new SokchoFoodDetailPage4("장홍김밥"));
					setVisible(false);
				} else if (randomAction == 34) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new SokchoFoodDetailPage5("문어랑속초본점"));
					setVisible(false);
				} else if (randomAction == 35) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new SokchoLookDetailPage1("속초아이대관람차"));
					setVisible(false);
				} else if (randomAction == 36) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new SokchoLookDetailPage2("설악케이블카"));
					setVisible(false);
				} else if (randomAction == 37) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new SokchoLookDetailPage3("아바이마을"));
					setVisible(false);
				} else if (randomAction == 38) {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new SokchoLookDetailPage4("영금정"));
					setVisible(false);
				} else {
					// 세 번째 랜덤 액션
					FrameBase.getDispose();
					FrameBase.getInstance(new SokchoLookDetailPage5("테디베어팜"));
					setVisible(false);
				}

			}
		});

		// 뒤로가기 버튼
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
				Frame_Base.getInstance(new Login());
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

		cart = new Cart();
		cartPanel = new CartPanel(cart);

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
