package com.minssam.shoppingapp.main;

import javax.swing.JButton;

public class CustomButton extends JButton{
	private int id;
	
	public CustomButton(String title) {
		//매개변수가 있는 생성자는 부모밖에 없기 때문에
		//부모의 생성자는 물려받지 않으므로 
		//부모의 생성자를 자식이 호출해야함
		
		//무보의 생성자는 물려받지 않으므로
		super(title);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
