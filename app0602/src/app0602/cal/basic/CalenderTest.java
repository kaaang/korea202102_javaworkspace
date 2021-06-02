package app0602.cal.basic;

import java.util.Calendar;

/*
 * js에서는 날짜를 처리하는 객체가 Date이지만, 자바에서는 Calendear클래스가 담당한다
 * 참고)System 클래스에는 currentRimeMills()에서드가 지원되기는 하나, Calendat처럼 다양한 날짜를 처리하는 객체는 아니다.
 * 
 * */

public class CalenderTest {

	
	public static void main(String[] args) {
		
		/*
		Calendar cal=Calendar.getInstance();//추상 클래스이기 때문에 static클레스 메서드로 인스턴스 얻기
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		*/
		
		/*
		Calendar cal2 = Calendar.getInstance();
		cal2.set(Calendar.DATE, cal2.get(Calendar.DATE)+100);
		int mm = cal2.get(Calendar.MONDAY);
		int dd = cal2.get(Calendar.DATE);
		System.out.println((mm+1)+"월, "+dd+"일");
		*/
		
		
		Calendar cal3 = Calendar.getInstance();
		cal3.set(1945, 8-1, 15);
		int yy=cal3.get(Calendar.YEAR);
		int mm=cal3.get(Calendar.MONDAY);
		int dd=cal3.get(Calendar.DATE);
		int day=cal3.get(Calendar.DAY_OF_WEEK);
		
		String[] title= {"Sun","Mon","Tue","Wed","Thur","Fri","Sat"};
		
		System.out.println(yy+"년 "+(mm+1)+"월 "+dd+"일 "+title[day-1]+" 요일");
	}
}
