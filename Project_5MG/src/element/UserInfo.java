package element;

import java.io.*;
import java.util.*;

public class UserInfo {

	private String userName;
	private String userPwd;

	public UserInfo() {

	}

	public UserInfo(String userName, String userPwd) {
		this.userName = userName;
		this.userPwd = userPwd;
	}

	public Map<String, UserInfo> userlist() {

		Map<String, UserInfo> map = new HashMap<String, UserInfo>();

		try {
			String s;
			String[] array;
			int i = 0;
			BufferedReader bos = new BufferedReader(new FileReader("명단.txt"));
			while ((s = bos.readLine()) != null) {
				array = s.split("/");

				map.put(array[1], new UserInfo(array[0], array[2]));

			}
			bos.close();

		} catch (Exception e) {
			System.out.println("파일에 문제가 있습니다.");
		}
		return map;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

}
