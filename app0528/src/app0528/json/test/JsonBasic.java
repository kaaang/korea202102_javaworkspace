package app0528.json.test;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * json은 자바 스크립트의 객체 표기법이므로, json 데이터를 자바 스크립트로 다루는것은 쉽다.
 * 그러나 자바는 json 형식을 이해하고 있을까?
 * 
 * */


public class JsonBasic {
	public static void main(String[] args) {
		
		//아래의 데이터는 문자열일 뿐,JSON 객체는 아니다
		//아래의 문자열을 JSON객체화 시키려면, 문자열을 대상으로 해석해야 한다. 
		
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"name\":\"scott\",");
		sb.append("\"age\":36");
		sb.append("}");
		
		
		JSONParser jsonParser = new JSONParser();
		try {
			JSONObject obj=(JSONObject)jsonParser.parse(sb.toString());
			//파싱이 완료된 이후부터는 단순 문자열이 아닌, JSON 객체가 된다.
			System.out.println(obj.get("name"));
			System.out.println(obj.get("age"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
}





