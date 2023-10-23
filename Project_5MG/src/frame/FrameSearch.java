package frame;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import element.SearchList;
import gyeongjudetail.*;
import jejudetail.*;
import jeonjudetail.*;
import sokchodetail.*;

public class FrameSearch extends JFrame {

	private JTextField searchField;
	private JButton searchButton;
	private JList<String> resultList;
	private DefaultListModel<String> listModel;
	private JButton backButton;
	private SearchList searchList;

	public FrameSearch() {
		setTitle("검색 애플리케이션");
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new GridBagLayout());

		backButton = new JButton("뒤로가기");
		backButton.addActionListener(e -> showOriginalList());

		GridBagConstraints backButtonConstraints = new GridBagConstraints();
		backButtonConstraints.gridx = 1;
		backButtonConstraints.gridy = 0;
		backButtonConstraints.anchor = GridBagConstraints.NORTHWEST;
		container.add(backButton, backButtonConstraints);

		JPanel searchPanel = new JPanel();
		searchField = new JTextField(20);
		searchButton = new JButton("검색");
		searchButton.addActionListener(e -> performSearch());

		searchField.addActionListener(e -> performSearch());

		searchPanel.add(searchField);
		searchPanel.add(searchButton);

		GridBagConstraints searchPanelConstraints = new GridBagConstraints();
		searchPanelConstraints.gridx = 1;
		searchPanelConstraints.gridy = 0;
		searchPanelConstraints.anchor = GridBagConstraints.NORTH;
		container.add(searchPanel, searchPanelConstraints);

		listModel = new DefaultListModel<>();
		resultList = new JList<>(listModel);

		resultList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int selectedIndex = resultList.getSelectedIndex();
					if (selectedIndex >= 0) {
						String selectedItem = listModel.getElementAt(selectedIndex);
						if (!selectedItem.trim().isEmpty()) {
							if ("경주".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new GyeongjuFoodListPanel());
								setVisible(false);
							} else if ("불국사".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new GyeongjuLookDetailPage1("불국사"));
								setVisible(false);
							} else if ("월정교".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new GyeongjuLookDetailPage2("월정교"));
								setVisible(false);
							} else if ("첨성대".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new GyeongjuLookDetailPage3("첨성대"));
								setVisible(false);
							} else if ("동궁과월지".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new GyeongjuLookDetailPage4("동궁과월지"));
								setVisible(false);
							} else if ("양동마을".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new GyeongjuLookDetailPage5("양동마을"));
								setVisible(false);
							} else if ("남정부일기사식당".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new GyeongjuFoodDetailPage1("남정부일기사식당"));
								setVisible(false);
							} else if ("양지식당".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new GyeongjuFoodDetailPage2("양지식당"));
								setVisible(false);
							} else if ("빼돌린뒷고기".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new GyeongjuFoodDetailPage3("빼돌린뒷고기"));
								setVisible(false);
							} else if ("황남경주식당".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new GyeongjuFoodDetailPage4("황남경주식당"));
								setVisible(false);
							} else if ("카페바실라".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new GyeongjuFoodDetailPage5("카페바실라"));
								setVisible(false);
							} else if ("포레스트".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new GyeongjuHotelDetailPage1("포레스트"));
								setVisible(false);
							} else if ("중명정원".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new GyeongjuHotelDetailPage2("중명정원"));
								setVisible(false);
							} else if ("라한셀렉트".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new GyeongjuHotelDetailPage3("라한셀렉트"));
								setVisible(false);
							} else if ("황리단스테이".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new GyeongjuHotelDetailPage4("라한셀렉트"));
								setVisible(false);
							} else if ("청공한옥스테이".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new GyeongjuHotelDetailPage5("청공한옥스테이"));
								setVisible(false);
							} else if ("속초".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new SokchoFoodListPanel());
								setVisible(false);
							} else if ("속초아이대관람차".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new SokchoLookDetailPage1("속초아이대관람차"));
								setVisible(false);
							} else if ("설약케이블카".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new SokchoLookDetailPage2("설약케이블카"));
								setVisible(false);
							} else if ("아바이마을".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new SokchoLookDetailPage3("아바이마을"));
								setVisible(false);
							} else if ("영금정".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new SokchoLookDetailPage4("영금정"));
								setVisible(false);
							} else if ("테디베어팜".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new SokchoLookDetailPage5("테디베어팜"));
								setVisible(false);
							} else if ("속초신토불이감자옹심이".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new SokchoFoodDetailPage1("속초신토불이감자옹심이"));
								setVisible(false);
							} else if ("성진활어".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new SokchoFoodDetailPage2("성진활어"));
								setVisible(false);
							} else if ("키친온유".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new SokchoFoodDetailPage3("키친온유"));
								setVisible(false);
							} else if ("장홍김밥".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new SokchoFoodDetailPage4("장홍김밥"));
								setVisible(false);
							} else if ("문어랑속초본점".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new SokchoFoodDetailPage5("문어랑속초본점"));
								setVisible(false);
							} else if ("더마크 속초 레지던스호텔".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new SokchoHotelDetailPage1("더마크 속초 레지던스호텔"));
								setVisible(false);
							} else if ("씨크루즈 호텔".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new SokchoHotelDetailPage2("씨크루즈 호텔"));
								setVisible(false);
							} else if ("마레몬스 호텔".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new SokchoHotelDetailPage3("마레몬스 호텔"));
								setVisible(false);
							} else if ("속초라마다 호텔".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new SokchoHotelDetailPage4("속초라마다 호텔"));
								setVisible(false);
							} else if ("롯데리조트 속초".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new SokchoHotelDetailPage5("롯데리조트 속초"));
								setVisible(false);
							} else if ("전주".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JeonjuFoodListPanel());
								setVisible(false);
							} else if ("메르밀진미집".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JeonjuLookDetailPage1("메르밀진미집"));
								setVisible(false);
							} else if ("한방오리촌".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JeonjuLookDetailPage2("한방오리촌"));
								setVisible(false);
							} else if ("황제보쌈".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JeonjuLookDetailPage3("황제보쌈"));
								setVisible(false);
							} else if ("진미집".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JeonjuLookDetailPage4("진미집"));
								setVisible(false);
							} else if ("카페 전망".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JeonjuLookDetailPage5("카페 전망"));
								setVisible(false);
							} else if ("다빈 호텔".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JeonjuHotelDetailPage1("다빈 호텔"));
								setVisible(false);
							} else if ("더 빈센트".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JeonjuHotelDetailPage2("더 빈센트"));
								setVisible(false);
							} else if ("블루보트 호텔".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JeonjuHotelDetailPage3("블루보트 호텔"));
								setVisible(false);
							} else if ("더 클래식 호텔".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JeonjuHotelDetailPage4("더 클래식 호텔"));
								setVisible(false);
							} else if ("라온 한옥 꿀잠".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JeonjuHotelDetailPage5("라온 한옥 꿀잠"));
								setVisible(false);
							} else if ("한옥마을".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JeonjuFoodDetailPage1("한옥마을"));
								setVisible(false);
							} else if ("경기전".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JeonjuFoodDetailPage2("경기전"));
								setVisible(false);
							} else if ("객리단길".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JeonjuFoodDetailPage3("객리단길"));
								setVisible(false);
							} else if ("수목원".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JeonjuFoodDetailPage4("수목원"));
								setVisible(false);
							} else if ("덕진공원".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JeonjuFoodDetailPage5("덕진공원"));
								setVisible(false);
							} else if ("제주도".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JejuFoodListPanel());
								setVisible(false);
							} else if ("성산일출봉".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JejuLookDetailPage1("성산일출봉"));
								setVisible(false);
							} else if ("아르떼".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JejuLookDetailPage2("아르떼"));
								setVisible(false);
							} else if ("우도".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JejuLookDetailPage3("우도"));
								setVisible(false);
							} else if ("천지연폭포".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JejuLookDetailPage4("천지연폭포"));
								setVisible(false);
							} else if ("카멜리아 힐".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JejuLookDetailPage5("카멜리아 힐"));
								setVisible(false);
							} else if ("갈치왕".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JejuFoodDetailPage1("갈치왕"));
								setVisible(false);
							} else if ("광해".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JejuFoodDetailPage2("광해"));
								setVisible(false);
							} else if ("온오프".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JejuFoodDetailPage3("온오프"));
								setVisible(false);
							} else if ("흑돼지BBQ".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JejuFoodDetailPage4("흑돼지BBQ"));
								setVisible(false);
							} else if ("칠돈가".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JejuFoodDetailPage5("칠돈가"));
								setVisible(false);
							} else if ("성산플로우".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JejuHotelDetailPage1("성산플로우"));
								setVisible(false);
							} else if ("마레보비치호텔".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JejuHotelDetailPage2("마레보비치호텔"));
								setVisible(false);
							} else if ("달그리안".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JejuHotelDetailPage3("달그리안"));
								setVisible(false);
							} else if ("브릿지".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JejuHotelDetailPage4("브릿지"));
								setVisible(false);
							} else if ("디 아넥스".equals(selectedItem)) {
								FrameBase.getDispose();
								FrameBase.getInstance(new JejuHotelDetailPage5("디 아넥스"));
								setVisible(false);
							}
						}
					}
				}
			}
		});

		GridBagConstraints resultListConstraints = new GridBagConstraints();
		resultListConstraints.gridx = 1;
		resultListConstraints.gridy = 1;
		resultListConstraints.fill = GridBagConstraints.BOTH;
		resultListConstraints.weightx = 1.0;
		resultListConstraints.weighty = 1.0;
		container.add(new JScrollPane(resultList), resultListConstraints);

		searchList = new SearchList();
	}

	private void performSearch() {
		String searchTerm = searchField.getText().toLowerCase().trim();
		listModel.clear();

		for (String keyword : searchList.getHiddenKeywords()) {
			if (keyword.toLowerCase().contains(searchTerm)) {
				listModel.addElement(keyword);
			}
		}
	}

	private void showOriginalList() {
		listModel.clear();
		List<String> items = searchList.getHiddenKeywords();
		for (String item : items) {
			listModel.addElement(item);
		}
	}

}