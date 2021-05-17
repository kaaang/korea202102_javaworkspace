package app0517.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//메모장 기능 중 스트림으로 처리할 수 있는 부분을 코드로 구현해 본다.

public class MemoEditor extends JFrame{
	
	JMenuBar bar;
	JMenu m_file;
	JMenuItem item_new;
	JMenuItem item_open;
	JMenuItem item_save;
	JMenuItem item_saveas;
	JMenuItem item_exit;
	JTextArea area;
	JScrollPane scroll;
	
	JFileChooser chooser;//파일 탐색기
	
	
	public MemoEditor() {
		bar = new JMenuBar();
		m_file = new JMenu("File");
		item_new = new JMenuItem("새 파일");
		item_open = new JMenuItem("열기");
		item_save = new JMenuItem("저장");
		item_saveas = new JMenuItem("새 이름으로 저장");
		item_exit = new JMenuItem("끝내기");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		
		chooser = new JFileChooser("D:\\korea202102_javaworkspace\\app0514\\src");
		
		
		m_file.add(item_new);
		m_file.add(item_open);
		m_file.add(item_save);
		m_file.add(item_saveas);
		m_file.add(item_exit);
		bar.add(m_file);//메뉴바에 파일메뉴 부착
		setJMenuBar(bar);//프레임에 메뉴 부착
		add(scroll);
		
		/*
		 * 아래와 같은 이름없는 클래스를 가리켜 내부 익명 클래스라 한다.
		 * 사용목적 : 원래 클래스란 코드의 재사용성을 위한 커푸집이 목적이였으나 클래스 중에는 재사용성이 별로 없는 1회성의 클래스도 있다
		 * 이런 경우 굳이 개발자가 .java파일을 물리적으로 정의해가면서까지 개발할 필요가 없기 때문에 sun에서는 클래스 안에 이름없는 클래스를
		 * 넣을 수 있도록 내부 익명 클래스를 지원한다. 주로 이벤트 구현시 압도적으로 많이 사용한다.
		 * 또한 내부 익명 클래스를 사용하면, 객체간 주소를 전달해야하는 불편함도 해소할 수 있다.
		 * 즉 내부익명 클래스는 외부 클래의 멤버들을 자기꺼처럼 사용할 수 있다.
		 * */
		item_open.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		});
		item_new.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//새 파일은 area를 비우는것
				area.setText("");
			}
		});
		//새 이름으로 저장
		item_saveas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveFileAs();
			}
		});
		
		
		
		setBounds(2000, 100, 700, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);//무언가 창을 닫을때 자원 반납을 위해선 이메서드 대신 리스너를 구현해야한다.
	}
	
	
	//파일 열어서, 편집기 창에 출력하기
	public void openFile() {
		int res = chooser.showOpenDialog(this);
		if(res == JFileChooser.APPROVE_OPTION) {
			//선택한 파일에 대한 입력 스트림을 생성하며, 내용을 읽어와서 area에 출력
			File file = chooser.getSelectedFile();
			FileReader reader=null;
			BufferedReader buffr = null; //문자 스트림을 대상으로 버퍼를 지원하는 스트림
			try {
				reader = new FileReader(file);
				buffr = new BufferedReader(reader);
				String data = null;
				while(true) {
					data = buffr.readLine();
					if(data == null)break;
					area.append(data+"\n");
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(buffr != null) {
					try {
						buffr.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
	public void saveFileAs() {
		
	}
	
	public static void main(String[] args) {
		new MemoEditor();
	}
}
