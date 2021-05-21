package com.minssam.shoppingapp.main;

import java.awt.Dimension;

import javax.swing.JPanel;

//모든 페이지의 부모 패널 정의 -> 공통된 코드가 있을 경우 이 클래스에 적용
public class Page extends JPanel{
	private AppMain appMain;
	public AppMain getAppMain() {
		return appMain;
	}
	public void setAppMain(AppMain appMain) {
		this.appMain = appMain;
	}
	public Page(AppMain appMain) {
		this.appMain = appMain;
		setPreferredSize(new Dimension(1200,600));
		setVisible(false);
	}
}
