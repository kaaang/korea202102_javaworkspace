package app0513.collection;

import java.util.ArrayList;

import javax.swing.JButton;

/*
 * 자바의 컬렉션 프레임 웍 중 List에 대해 학습한다.
 * */


public class ListApp {
	
	
	
	public static void main(String[] args) {
		//리스트는 배열과 모습이 같다, 단지 다루려는 대상이 객체에 한정되어 있다.
		ArrayList<String> list=new ArrayList<String>();
		//<>는 제너릭(Generic)타입으로 명시된 컬렉션 프레임웍 객체는, 해당 객체만을 받아들인다
		//컴파일 타임에 잡아냄
		
		
		list.add("apple"); //자바에서 지원한느 모든 자료형을 넣을 수 있다.
		list.add("apple"); //자바에서 지원한느 모든 자료형을 넣을 수 있다.
		list.add("apple"); //자바에서 지원한느 모든 자료형을 넣을 수 있다.
		
		System.out.println(list);
		System.out.println(list.size());
		list.set(1, "사과");
		System.out.println(list);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
		
		for(String item : list) {
			System.out.println(item);
		}
		
		
		
	}
	
	
}
