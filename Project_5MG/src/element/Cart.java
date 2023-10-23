package element;

import java.io.*;
import java.util.*;

public class Cart {
	private List<String> items;
	private String cartFilePath = "cart.txt";

	public Cart() {
		items = new ArrayList<>();
		loadCartFromFile();
	}

	public void addItem(String item) {
		items.add(item);
		saveCartToFile();
	}

	public void removeItem(String item) {
		items.remove(item);
		saveCartToFile();
	}

	public List<String> getItems() {
		return items;
	}

	public void saveCartToFile() {
		try (PrintWriter writer = new PrintWriter(new FileWriter(cartFilePath))) {
			for (String item : items) {
				writer.println(item);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadCartFromFile() {
		try (BufferedReader reader = new BufferedReader(new FileReader(cartFilePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				items.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
