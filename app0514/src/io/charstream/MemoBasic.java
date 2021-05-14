package io.charstream;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//메모장의 읽기 기능만들 구현해보기
public class MemoBasic extends JFrame implements ActionListener{

	JButton bt;
	JTextArea area;
	JScrollPane scroll;
	JFileChooser chooser;
	
	
	public MemoBasic() {
		bt = new JButton("Load");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		chooser = new JFileChooser("D:\\korea202102_javaworkspace\\app0514\\res");
		
		add(bt,BorderLayout.NORTH);
		add(scroll);
		bt.addActionListener(this);
		
		setSize(500, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//바이트기반
	public void openFileByte() {
		if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			System.out.println(file.getAbsolutePath());
			
			FileInputStream fis=null;//지역변수이기 때문에 초기화를 해주어야한다.
			//스트림 생성
			try {
				fis = new FileInputStream(file.getAbsolutePath());
				//1바이트씩 읽어서 area에 출력하자
				int data = -1;
				while(true) {
					data = fis.read();
					if(data == -1)break;
					area.append(Character.toString((char)data));
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
	}
	
	//문자기반
	public void openFileChar() {
		int res = chooser.showOpenDialog(this);
		if(res==JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			FileReader reader=null;
			
			try {
				reader = new FileReader(file.getAbsolutePath());
				int data = -1;
				while(true) {
					data = reader.read();
					if(data == -1)break;
					area.append(Character.toString((char)data));
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		openFileByte();
		openFileChar();
	}
	
	
	public static void main(String[] args) {
		new MemoBasic();
	}


}
