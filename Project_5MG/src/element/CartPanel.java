package element;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CartPanel extends JPanel {
	private Cart cart;
	private JTextArea cartTextArea;

	public CartPanel(Cart cart) {
		this.cart = cart;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(200, 200));

		cartTextArea = new JTextArea(10, 20);
		cartTextArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(cartTextArea);
		add(scrollPane, BorderLayout.CENTER);

		updateCart();
	}

	public void updateCart() {
		List<String> items = cart.getItems();
		StringBuilder cartText = new StringBuilder();
		for (String item : items) {
			cartText.append(item).append("\n");
		}
		cartTextArea.setText(cartText.toString());
	}
}
