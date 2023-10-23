package element;

import javax.swing.*;

import frame.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Review extends JPanel {
	private JFrame frame;
	private JTextArea reviewTextArea;
	private int rating = 0;
	private JButton[] starButtons;
	private JButton saveButton;
	private String reviewFileName;

	public Review(String reviewFileName) {
		this.reviewFileName = reviewFileName;

		frame = new JFrame("리뷰 작성");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(400, 300);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		ImageIcon emptyStar = new ImageIcon("empty_star.png");
		ImageIcon filledStar = new ImageIcon("filled_star.png");

		starButtons = new JButton[5];
		for (int i = 0; i < 5; i++) {
			starButtons[i] = new JButton(emptyStar);
			starButtons[i].setBorderPainted(false);
			starButtons[i].setContentAreaFilled(false);
			int finalI = i;
			starButtons[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					rating = finalI + 1;
					updateStarButtons(starButtons);
				}
			});
			starButtons[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					updateStarButtons(starButtons, finalI + 1);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					updateStarButtons(starButtons, rating);
				}
			});
			panel.add(starButtons[i]);
		}

		mainPanel.add(panel, BorderLayout.NORTH);

		saveButton = new JButton("저장");
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveReviewAndRatingToFile();
				JOptionPane.showMessageDialog(null, "리뷰와 별점이 저장되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
				frame.dispose();
			}
		});

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(saveButton);

		frame.add(buttonPanel, BorderLayout.SOUTH);

		reviewTextArea = new JTextArea("리뷰 내용을 입력하세요.", 5, 30);

		mainPanel.add(new JScrollPane(reviewTextArea), BorderLayout.CENTER);

		frame.add(mainPanel);
		frame.setVisible(false);

		loadReviewAndRatingFromFile();
	}

	private void updateStarButtons(JButton[] starButtons) {
		updateStarButtons(starButtons, rating);
	}

	private void updateStarButtons(JButton[] starButtons, int rating) {
		for (int i = 0; i < 5; i++) {
			if (i < rating) {
				starButtons[i].setIcon(new ImageIcon("filled_star.png"));
			} else {
				starButtons[i].setIcon(new ImageIcon("empty_star.png"));
			}
		}
	}

	private void saveReviewAndRatingToFile() {
		try (PrintWriter writer = new PrintWriter(new FileWriter(reviewFileName))) {
			writer.println("Rating: " + rating);
			writer.println("Review: " + reviewTextArea.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadReviewAndRatingFromFile() {
		try (BufferedReader reader = new BufferedReader(new FileReader(reviewFileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.startsWith("Rating: ")) {
					rating = Integer.parseInt(line.substring("Rating: ".length()));
					updateStarButtons(starButtons, rating);
				} else if (line.startsWith("Review: ")) {
					reviewTextArea.setText(line.substring("Review: ".length()));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void toggleReviewPanel() {
		frame.setVisible(!frame.isVisible());
	}

	public void show() {
		frame.setVisible(true);
	}
}
