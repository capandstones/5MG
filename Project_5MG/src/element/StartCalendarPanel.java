package element;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class StartCalendarPanel extends JPanel {

	private int year;
	private int month;
	private JLabel monthLabel;
	private JPanel calendarPanel;
	private String selectedDate;
	private JTextField startDateField;

	public StartCalendarPanel(int year, int month, JTextField startDateField) {
		this.year = year;
		this.month = month;
		this.startDateField = startDateField;
		setLayout(new BorderLayout());

		monthLabel = new JLabel(year + "년 " + (month + 1) + "월");
		monthLabel.setFont(new Font("G마켓 산스 TTF Medium", Font.BOLD, 24));
		monthLabel.setHorizontalAlignment(JLabel.CENTER);
		add(monthLabel, BorderLayout.NORTH);

		calendarPanel = new JPanel(new GridLayout(0, 7));
		add(calendarPanel, BorderLayout.CENTER);

		createCalendar();
		createMonthChangeButtons();
	}

	private void createCalendar() {
		calendarPanel.removeAll();

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, 1);

		int startDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int maxDayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		String[] daysOfWeek = { "일", "월", "화", "수", "목", "금", "토" };
		for (String day : daysOfWeek) {
			JLabel label = new JLabel(day, JLabel.CENTER);
			label.setFont(new Font("G마켓 산스 TTF Medium", Font.BOLD, 15));
			calendarPanel.add(label);
		}

		for (int i = 1; i < startDayOfWeek; i++) {
			calendarPanel.add(new JLabel());
		}

		for (int day = 1; day <= maxDayOfMonth; day++) {
			JButton button = new JButton(String.valueOf(day));
			button.setFont(new Font("G마켓 산스 TTF Medium", Font.PLAIN, 15));
			button.setBackground(new Color(0, 0, 0));
			button.setForeground(new Color(255,255,255));
			calendarPanel.add(button);

			final int selectedDay = day;
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					selectedDate = year + "년 " + (month + 1) + "월 " + selectedDay + "일";
					if (startDateField != null) {
						startDateField.setText(selectedDate);
					}
					Window window = SwingUtilities.getWindowAncestor(StartCalendarPanel.this);
					if (window instanceof JFrame) {
						window.dispose();
					}
				}
			});
		}

		revalidate();
		repaint();
	}

	private void createMonthChangeButtons() {
		JButton prevMonthButton = new JButton("이전 달");
		prevMonthButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (month == 0) {
					year--;
					month = 11;
				} else {
					month--;
				}
				updateMonthLabel();
				createCalendar();
			}
		});

		JButton nextMonthButton = new JButton("다음 달");
		nextMonthButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (month == 11) {
					year++;
					month = 0;
				} else {
					month++;
				}
				updateMonthLabel();
				createCalendar();
			}
		});

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(prevMonthButton);
		buttonPanel.add(nextMonthButton);
		add(buttonPanel, BorderLayout.SOUTH);
	}

	private void updateMonthLabel() {
		monthLabel.setText(year + "년 " + (month + 1) + "월");
	}

	public String getSelectedDate() {
		return selectedDate;
	}
}
