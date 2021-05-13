package app0513.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
 * 자바의 컬력센 프레임웍 중 Map에 대해서 배우자
 * 
 * Map 이란 Key-Value의 쌍으로 이루어진 데이터 집합 대표적인 예 -> JSON
 * 
 * */



public class MapApp {
	public static void main(String[] args) {
		
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("fruit1","apple"); //데이터를 넣을때
		map.put("fruit2","pineapple"); //데이터를 넣을때
		map.put("fruit3","graph"); //데이터를 넣을때
		
		System.out.println(map.get("fruit3"));
		
		
		//주의 : 아래의 keySet 메서드는 map에 들어있는 value가 아니라 key이다.
		Set<String> set = map.keySet();//키만 끄집어내기
		Iterator<String> it = set.iterator(); //이름을 일렬로 늘어서게함
		
		while(it.hasNext()) {
			String key = it.next();//키를 얻었기 때문에 이 시점에 Map에 들어있는 데이터를 검색할 수 있다.
			String value = map.get(key);
			System.out.println(value);
		}
		
		
		
		
	}
}
