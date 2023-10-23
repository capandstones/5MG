package element;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ReservationConfirm extends JPanel {

	private JTextArea reservationTextArea;

	public ReservationConfirm(String listName) {
		setLayout(new BorderLayout());

		reservationTextArea = new JTextArea();
		reservationTextArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(reservationTextArea);
		add(scrollPane, BorderLayout.CENTER);
		String reservationFileName = listName + "_reservation.txt";
		loadReservationFromFile(reservationFileName);
	}

	private void loadReservationFromFile(String fileName) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			StringBuilder reservationText = new StringBuilder();

			while ((line = reader.readLine()) != null) {
				reservationText.append(line).append("\n");
			}

			reservationTextArea.setText(reservationText.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
