package gyeongjudetail;

import javax.swing.*;
import element.*;
import frame.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class GyeongjuFoodDetailPage4 extends JPanel {

	private Review reviewPanel;
	private boolean isLiked = false;
	private ImageIcon likeIconEmpty = new ImageIcon("emptyH.png");
	private ImageIcon likeIconFull = new ImageIcon("fullH.png");
	private ImageIcon[] likeIcons = new ImageIcon[2];
	private int currentLikeIconIndex = 0;
	private Timer slideShowTimer;
	private Cart cart;
	private CartPanel cartPanel;
	private Reservation reservationPanel;

	private boolean loadLikedStateFromStorage() {
		String filePath = "liked4.txt";

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line = reader.readLine();
			if (line != null) {
				return Boolean.parseBoolean(line.trim());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	private void saveLikedStateToStorage(boolean isLiked) {
		String filePath = "liked4.txt";

		try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
			writer.println(isLiked);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public GyeongjuFoodDetailPage4(String listName) {
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

		String reviewFileName = listName + "_review.txt";

		JLabel nameLabel = new JLabel(listName);
		nameLabel.setFont(new Font("여기어때 잘난체", Font.BOLD, 30));
		nameLabel.setSize(600, 50);
		nameLabel.setLocation(0, 0);
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		add(nameLabel);

		likeIcons[0] = new ImageIcon("경주_맛집4(황남경주식당1).png");
		likeIcons[1] = new ImageIcon("경주_맛집4(황남경주식당2).png");

		JLabel imageLabel = new JLabel(likeIcons[currentLikeIconIndex]);
		imageLabel.setSize(450, 347);
		imageLabel.setLocation(75, 50);
		add(imageLabel);

		int slideShowDelay = 2500;
		slideShowTimer = new Timer(slideShowDelay, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currentLikeIconIndex = (currentLikeIconIndex + 1) % likeIcons.length;
				imageLabel.setIcon(likeIcons[currentLikeIconIndex]);
			}
		});
		slideShowTimer.start();

		reviewPanel = new Review(reviewFileName);
		reviewPanel.setVisible(false);
		add(reviewPanel);

		// 리뷰 버튼 표시
		JButton reviewButton = new JButton("리뷰");
		reviewButton.setFont(new Font("여기어때 잘난체", Font.BOLD, 20));
		reviewButton.setSize(200, 40);
		reviewButton.setLocation(75, 410);
		reviewButton.setBackground(new Color(255, 255, 255));
		add(reviewButton);
		reviewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reviewPanel.toggleReviewPanel();
			}
		});

		// 예약 버튼
		JButton reservationButton = new JButton("예약");
		reservationButton.setFont(new Font("여기어때 잘난체", Font.BOLD, 20));
		reservationButton.setSize(90, 40);
		reservationButton.setLocation(275, 410);
		reservationButton.setBackground(new Color(255, 255, 255));
		add(reservationButton);

		// 예약 버튼에 ActionListener 추가
		reservationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 예약 정보를 가져오고 Reservation 클래스 실행
				String selectedStartDate = reservationPanel.getSelectedStartDate();
				String selectedEndDate = reservationPanel.getSelectedEndDate();
				String numberOfPeople = reservationPanel.getNumberOfPeople();

				// 위에서 가져온 정보로 Reservation 클래스 실행
				Reservation reservation = new Reservation(listName);
				JFrame reservationFrame = new JFrame("예약 패널");
				reservationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				reservationFrame.setSize(500, 400);
				reservationFrame.add(reservation);
				reservationFrame.setVisible(true);
			}
		});

		// 찜하기 버튼
		JButton likeButton = new JButton(likeIconEmpty);
		likeButton.setSize(40, 40);
		likeButton.setLocation(485, 410);
		likeButton.setBackground(new Color(255, 255, 255));
		likeButton.setBorderPainted(false);
		likeButton.setFocusPainted(false);
		add(likeButton);

		JButton GoButton = new JButton("길찾기");
		GoButton.setFont(new Font("여기어때 잘난체", Font.BOLD, 20));
		GoButton.setSize(120, 40);
		GoButton.setLocation(365, 410);
		GoButton.setBackground(new Color(255, 255, 255));
		add(GoButton);
		GoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openURL("https://map.naver.com/p/directions/14136015.1992142,4518781.7300194,%EC%86%94%EB%8D%B0%EC%8A%A4%ED%81%AC,37747131,PLACE_POI/14383823.5176691,4278051.4930492,%ED%99%A9%EB%82%A8%EA%B2%BD%EC%A3%BC%EC%8B%9D%EB%8B%B9,1869007550,PLACE_POI/-/car?c=7.00,0,0,2,dh");
			}
		});

		isLiked = loadLikedStateFromStorage();
		if (isLiked) {
			likeButton.setIcon(likeIconFull);
		}

		likeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isLiked) {
					isLiked = false;
					likeButton.setIcon(likeIconEmpty);
					cart.removeItem(listName);
					cart.saveCartToFile();
					saveLikedStateToStorage(false);
					JOptionPane.showMessageDialog(null, "장바구니에서 항목이 제거되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
				} else {
					isLiked = true;
					likeButton.setIcon(likeIconFull);
					cart.addItem(listName);
					cart.saveCartToFile();
					saveLikedStateToStorage(true);
					JOptionPane.showMessageDialog(null, "장바구니에 항목이 추가되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		JLabel locationLabel = new JLabel("위치: 경북 경주시 배리1길 3");
		locationLabel.setFont(new Font("여기어때 잘난체", Font.PLAIN, 20));
		locationLabel.setSize(300, 30);
		locationLabel.setLocation(75, 450);
		add(locationLabel);

		// 기타 정보
		JLabel infoLabel1 = new JLabel("영업 시간: 09:00 - 20:00");
		infoLabel1.setFont(new Font("여기어때 잘난체", Font.PLAIN, 20));
		infoLabel1.setSize(400, 30);
		infoLabel1.setLocation(75, 480);
		add(infoLabel1);

		JLabel infoLabel2 = new JLabel("라스트오더 19:30");
		infoLabel2.setFont(new Font("여기어때 잘난체", Font.PLAIN, 20));
		infoLabel2.setSize(400, 30);
		infoLabel2.setLocation(75, 510);
		add(infoLabel2);

		JLabel infoLabel3 = new JLabel("1, 3번째 화요일 정기 휴무");
		infoLabel3.setFont(new Font("여기어때 잘난체", Font.PLAIN, 20));
		infoLabel3.setSize(400, 30);
		infoLabel3.setLocation(75, 540);
		add(infoLabel3);

		JLabel infoLabel4 = new JLabel("전화 번호: 010-1234-5678");
		infoLabel4.setFont(new Font("여기어때 잘난체", Font.PLAIN, 20));
		infoLabel4.setSize(400, 30);
		infoLabel4.setLocation(75, 570);
		add(infoLabel4);

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
				FrameBase.getInstance(new GyeongjuFoodListPanel());
				setVisible(false);

			}
		});

		cart = new Cart();
		cartPanel = new CartPanel(cart);

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
				cartPanel.updateCart();
				JOptionPane.showMessageDialog(null, cartPanel, "장바구니", JOptionPane.PLAIN_MESSAGE);
			}
		});

		// 일정
		ImageIcon time = new ImageIcon("일정.png");
		JButton timeBtn = new JButton(time);
		timeBtn.setSize(50, 50);
		timeBtn.setLocation(460, 730);
		timeBtn.setBorderPainted(false);
		timeBtn.setFocusPainted(false);
		add(timeBtn);

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

		reviewPanel = new Review(reviewFileName);
		reviewPanel.setVisible(false);
		add(reviewPanel);
	}

	private static void openURL(String url) {
		try {
			Desktop.getDesktop().browse(new URI(url));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
}