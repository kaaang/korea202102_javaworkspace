package app0513.collection;

import java.util.HashSet;
import java.util.Iterator;

/*
 * 자바의 컬렉션 프레임 윅 객체 중 순서 없는 데이터를 모아서 처리할 수 있는 Set를 알아보자.
 * */

public class SetApp {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("banana");
		set.add("mango");
		set.add("apple");
		
		//set은 데이터 중복을 허용하지 않음
		
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String item = it.next();
			System.out.println(item);
		}
		
		
	}

}
