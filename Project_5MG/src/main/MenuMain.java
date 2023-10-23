package main;

import frame.Frame_Base;
import frame.Login;

public class MenuMain {

	public static void main(String[] args) {

		Frame_Base.getInstance(new Login());

	}

}