package element;

import java.util.*;

public class SearchList {
	private List<String> hiddenKeywords;

	public SearchList() {
		hiddenKeywords = new ArrayList<>();

		hiddenKeywords.add("경주");
		hiddenKeywords.add("제주도");
		hiddenKeywords.add("전주");
		hiddenKeywords.add("속초");

		// 경주
		hiddenKeywords.add("불국사");
		hiddenKeywords.add("월정교");
		hiddenKeywords.add("첨성대");
		hiddenKeywords.add("동궁과월지");
		hiddenKeywords.add("양동마을");
		hiddenKeywords.add("남정부일기사식당");
		hiddenKeywords.add("양지식당");
		hiddenKeywords.add("빼돌린뒷고기");
		hiddenKeywords.add("황남경주식당");
		hiddenKeywords.add("카페바실라");
		hiddenKeywords.add("포레스트173");
		hiddenKeywords.add("중명정원");
		hiddenKeywords.add("라한셀렉트");
		hiddenKeywords.add("황리단스테이");
		hiddenKeywords.add("청공한옥스테이");

		// 속초
		hiddenKeywords.add("속초아이대관람차");
		hiddenKeywords.add("설약케이블카");
		hiddenKeywords.add("아바이마을");
		hiddenKeywords.add("영금정");
		hiddenKeywords.add("테디베어팜");
		hiddenKeywords.add("속초신토불이감자옹심이");
		hiddenKeywords.add("성진활어");
		hiddenKeywords.add("키친온유");
		hiddenKeywords.add("장홍김밥");
		hiddenKeywords.add("문어랑속초본점");
		hiddenKeywords.add("더마크 속초 레지던스호텔");
		hiddenKeywords.add("씨크루즈 호텔");
		hiddenKeywords.add("마레몬스 호텔");
		hiddenKeywords.add("속초라마다 호텔");
		hiddenKeywords.add("롯데리조트 속초");

		// 전주
		hiddenKeywords.add("메르밀진미집");
		hiddenKeywords.add("한방오리촌");
		hiddenKeywords.add("황제보쌈");
		hiddenKeywords.add("진미집");
		hiddenKeywords.add("카페 전망");
		hiddenKeywords.add("다빈 호텔");
		hiddenKeywords.add("더 빈센트");
		hiddenKeywords.add("블루보트 호텔");
		hiddenKeywords.add("더 클래식 호텔");
		hiddenKeywords.add("라온 한옥 꿀잠");
		hiddenKeywords.add("한옥마을");
		hiddenKeywords.add("경기전");
		hiddenKeywords.add("객리단길");
		hiddenKeywords.add("수목원");
		hiddenKeywords.add("덕진공원");

		// 제주
		hiddenKeywords.add("성산일출봉");
		hiddenKeywords.add("아르떼");
		hiddenKeywords.add("우도");
		hiddenKeywords.add("천지연폭포");
		hiddenKeywords.add("카멜리아 힐");
		hiddenKeywords.add("갈치왕");
		hiddenKeywords.add("광해");
		hiddenKeywords.add("온오프");
		hiddenKeywords.add("흑돼지BBQ");
		hiddenKeywords.add("칠돈가");
		hiddenKeywords.add("성산플로우");
		hiddenKeywords.add("마레보비치호텔");
		hiddenKeywords.add("달그리안");
		hiddenKeywords.add("브릿지");
		hiddenKeywords.add("디 아넥스");

	}

	public List<String> getHiddenKeywords() {
		return hiddenKeywords;
	}
}