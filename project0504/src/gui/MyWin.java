/*
	GUI ���α׷����� ������ �����찡 �־�� �Ѵ�.
	���� �ڹ� ���� GUI ���õ� ��Ű���� awt/swing���� �����Ѵ�.
	javaFX(�ȵ���̵�� ���� ���)

	�ڹٿ��� ������� ���������� Frame�̶�� Ŭ������ ���
*/
package gui;
import java.awt.Frame;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Checkbox;
import java.awt.TextArea;
import java.awt.Choice;
public class  MyWin{
	public static void main(String[] args){
		Frame frame;//������ ��ü , ��ü�� �ν��Ͻ��� ���� ���� frame���� �ʱ�ȭ�Ǿ����� �ʴ�.
		/*
		Frame�̶�� Ŭ������ ����� �������ذ��ε�, ������ ��� ����ؾ����� ������
		��? �츮�� ������ Ŭ������ �ƴϿ���
		[������ �������� ��ü ����ϴ� TIP]
			1)�ش� Ŭ������ ����ü ����? �뵵�� ����? �������� ����?

			2)�������ؼ��� �޸𸮿� �÷����Ѵ�.
			   �޸𸮿� �ø�����, �� ��ü�� �Ϲ�����, �߻�����, �������̽��������� �����Ѵ�.
			   -�Ϲ� Ŭ������ ��� : new �ϸ� �ȴ�.
			   -�߻� Ŭ������ ��� : �ڽ����� �ϼ� ��, �ڽ��� new�ϸ� ��
			   -�������̽��� ��� : �ڽ����� �ϼ� ��, �ڽ��� new�ϸ� ��

			 3)�޸𸮿� �ø��� ����� �����Ǿ��ٸ�
			   -�Ϲ� Ŭ������ ��쿣 new ������ �;��ϴ� �����ڸ� ����(CONSTR)
		*/

		frame = new Frame();//�������� �⺻������ ���� ������ �ʵ��� �Ӽ��� �����Ǿ��ִ�.

		//������ �ȿ� ������ ��ư ����
		Button bt = new Button("button");//Button is a Component

		FlowLayout flow = new FlowLayout();//������Ʈ�� �������� ��ġ�ϴ� �����ƿ� ��ü
		//��, �������� ��������, �������� ��������
		frame.setLayout(flow);

		//�Է� �ؽ�Ʈ �ڽ� �����Ͽ� �ٿ�����
		TextField t = new TextField(20);

		//üũ�ڽ� ������
		Checkbox ch1 = new Checkbox("��ȭ");
		Checkbox ch2 = new Checkbox("���α׷���");
		Checkbox ch3 = new Checkbox("����");
		Checkbox ch4 = new Checkbox("����");

		//TextArea
		TextArea area = new TextArea(5,15);

		//html�� select �ڽ��� java���� Choice��� �Ѵ�.
		Choice choice = new Choice();
		choice.add("@naver.com");
		choice.add("@nate.com");
		choice.add("@hanmail.net");

		


		//�����ӿ� ��ư ����
		frame.add(bt);
		frame.add(t);
		frame.add(ch1);
		frame.add(ch2);
		frame.add(ch3);
		frame.add(ch4);
		frame.add(area);
		frame.add(choice);



		//��ư ���� ��, ��� ��ư�� ����������
		//��� GUI���α׷��� ������ ȭ���� ��ġ ����� �����ڰ� �����ؾ��Ѵ�.

		


		//���� �����ڰ� ���ϴ� Ÿ�ӿ�, ���� ���� �� �ֵ��� �Ӽ��� �����ϴ� �޼��带 ȣ���غ���.
		frame.setVisible(true);

		//ũ�⵵ ������� ������, ���ϴ� ũ��� �����찡 ������ ����
		frame.setSize(300,400);
	}
}
