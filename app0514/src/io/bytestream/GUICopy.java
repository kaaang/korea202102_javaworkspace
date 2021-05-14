package io.bytestream;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * 파일 복사 기능을 GUI기반으로 처리해본다.
 * */

public class GUICopy extends JFrame implements WindowListener, ActionListener{
	JButton bt_open;
	JTextField t_open;
	JButton bt_target;
	JTextField t_target;
	JTextArea area;
	JScrollPane scroll;
	JButton bt_copy;
	JFileChooser chooser; //파일 탐색기 창 객체
	
	FileInputStream fis;//파일 입력용
	FileOutputStream fos;//파일 출력용
	
	public GUICopy() {
		bt_open = new JButton("원본선택");
		t_open = new JTextField();
		bt_target = new JButton("복사위치");
		t_target  = new JTextField();
		area = new JTextArea();
		scroll = new JScrollPane(area);
		bt_copy = new JButton("복사 실행");
		chooser = new JFileChooser("D:\\korea202102_javaworkspace\\app0513\\res\\images");
		
		//스타일
		setLayout(new FlowLayout());
		bt_open.setPreferredSize(new Dimension(100, 25));
		bt_target.setPreferredSize(new Dimension(100, 25));
		t_open.setPreferredSize(new Dimension(370, 25));
		t_target.setPreferredSize(new Dimension(370, 25));
		scroll.setPreferredSize(new Dimension(480, 180));
		
		
		//조립
		add(bt_open);
		add(t_open);
		add(bt_target);
		add(t_target);
		add(scroll);
		add(bt_copy);
		
		
		
		
		//이벤트
		this.addWindowListener(this);
		bt_open.addActionListener(this);
		bt_target.addActionListener(this);
		bt_copy.addActionListener(this);
		
		
		
		//보여주기
		setSize(new Dimension(500,350));
		setVisible(true);
		//아래의 메서드 호출하면 안되는 이유 : 윈도우 창 닫을때 스트림을 닫는 처리를 하기 위해
		//결론 : 윈도우 리스너를 구현하여서, 창 닫을떄 스트림도 닫아야 한다.
		//setDefaultCloseOperation();
		
	}
	
	public void openFile() {
		int res = chooser.showOpenDialog(this);
		if(res == JFileChooser.APPROVE_OPTION) {
			//선택한 파일의 디스크상의 풀 시스템 경로를 얻어와서 JTextField에 출력해보자
			File file = chooser.getSelectedFile();
			t_open.setText(file.getAbsolutePath());
		}
	}
	
	public void saveFile() {
		int res = chooser.showSaveDialog(this);
		if(res == JFileChooser.APPROVE_OPTION) {
			//System.out.println("선택완료");
			File file = chooser.getSelectedFile();
			t_target.setText(file.getAbsolutePath());
		}
		
	}
	
	public void copyFile() {
		//정해진 두 경로를 이용하여서, Stream을 만들어 입출력을 시도해보자
		try {
			fis = new FileInputStream(t_open.getText());
			fos = new FileOutputStream(t_target.getText());
			area.append("입력&출력 스트림 생성 완료\n");
			
			int data = -1;
			while(true) {
				data = fis.read();//한 바이트 읽기
				if(data == -1)break;
				fos.write(data);//한 바이트 쓰기
				area.append(data+"\n");
			}
			area.append("복사완료\n");
			JOptionPane.showMessageDialog(this, "완료");
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt_open) {
			openFile();
		}else if(e.getSource()==bt_target) {
			saveFile();
		}else if(e.getSource()==bt_copy) {
			copyFile();
		}
	}
	

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("close");
	}
	@Override
	public void windowOpened(WindowEvent e) {}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}
	
	
	
	public static void main(String[] args) {
		new GUICopy();
	}


	
	
}
