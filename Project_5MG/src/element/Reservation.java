package element;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Reservation extends JPanel {

	private JButton startDateButton;
	private JTextField startDateField;
	private JButton endDateButton;
	private JTextField endDateField;
	private JLabel numberOfPeopleLabel;
	private JTextField numberOfPeopleField;
	private JButton reserveButton;
	private StartCalendarPanel startCalendarPanel;
	private EndCalendarPanel endCalendarPanel;
	private String selectedStartDate;
	private String selectedEndDate;
	private String numberOfPeople;
	private String reservationFileName;

	public Reservation(String listName) {
		setPreferredSize(new Dimension(300, 100));
		setLayout(new BorderLayout());

		reservationFileName = listName + "_reservation.txt";

		startDateButton = new JButton("시작날짜");
		startDateField = new JTextField(10);

		endDateButton = new JButton("종료날짜");
		endDateField = new JTextField(10);

		numberOfPeopleLabel = new JLabel("인원:");
		numberOfPeopleField = new JTextField(10);

		reserveButton = new JButton("예약하기");
		
		startDateButton.setBackground(new Color(0, 0, 0));
		startDateButton.setFont(new Font("G마켓 산스 TTF Medium", Font.BOLD, 20));
		startDateButton.setForeground(new Color(255,255,255));
		//startDateButton.setBorderPainted(false);
		//startDateButton.setFocusPainted(false);
		
		endDateButton.setBackground(new Color(0, 0, 0));
		endDateButton.setFont(new Font("G마켓 산스 TTF Medium", Font.BOLD, 20));
		endDateButton.setForeground(new Color(255,255,255));
		//endDateButton.setBorderPainted(false);
		//endDateButton.setFocusPainted(false);
		
		numberOfPeopleLabel.setOpaque(true);
		numberOfPeopleLabel.setBackground(new Color(0, 0, 0));
		numberOfPeopleLabel.setFont(new Font("G마켓 산스 TTF Medium", Font.BOLD, 20));
		numberOfPeopleLabel.setForeground(new Color(255,255,255));
		numberOfPeopleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		reserveButton.setBackground(new Color(0, 0, 0));
		reserveButton.setFont(new Font("G마켓 산스 TTF Medium", Font.BOLD, 20));
		reserveButton.setForeground(new Color(255,255,255));

		JPanel buttonPanel = new JPanel(new GridLayout(4, 2));
		buttonPanel.add(startDateButton);
		buttonPanel.add(startDateField);
		buttonPanel.add(endDateButton);
		buttonPanel.add(endDateField);
		buttonPanel.add(numberOfPeopleLabel);
		buttonPanel.add(numberOfPeopleField);
		buttonPanel.add(reserveButton);

		add(buttonPanel, BorderLayout.CENTER);

		startDateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int year = 2023;
				int month = 8;

				startCalendarPanel = new StartCalendarPanel(year, month, startDateField);
				JFrame frame = new JFrame("달력 패널");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setSize(400, 400);
				frame.add(startCalendarPanel);
				frame.setVisible(true);
			}
		});

		endDateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int year = 2023;
				int month = 8;

				endCalendarPanel = new EndCalendarPanel(year, month, endDateField);
				JFrame frame = new JFrame("달력 패널");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setSize(400, 400);
				frame.add(endCalendarPanel);
				frame.setVisible(true);
			}
		});

		reserveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedStartDate = getSelectedStartDate();
				selectedEndDate = getSelectedEndDate();
				numberOfPeople = getNumberOfPeople();

				saveReservationToFile(listName);

				JOptionPane.showMessageDialog(null, "예약이 완료되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);

				SwingUtilities.getWindowAncestor(Reservation.this).dispose();
			}
		});
	}

	private void saveReservationToFile(String listName) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(reservationFileName))) {
			writer.println(listName + " 예약현황");
			writer.println("인원: " + numberOfPeople + ", 예약 날짜 : " + selectedStartDate + "~" + selectedEndDate);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getSelectedStartDate() {
		if (startCalendarPanel != null) {
			return startCalendarPanel.getSelectedDate();
		} else {
			return null;
		}
	}

	public String getSelectedEndDate() {
		if (endCalendarPanel != null) {
			return endCalendarPanel.getSelectedDate();
		} else {
			return null;
		}
	}

	public String getNumberOfPeople() {
		if (startCalendarPanel != null) {
			return numberOfPeopleField.getText();
		} else {
			return null;
		}
	}
}
