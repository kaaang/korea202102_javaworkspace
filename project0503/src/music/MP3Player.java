package music;

/*
	�߻�Ŭ������ ��ӹް� �Ǵ� �ڽ���, �θ� �ҿ����ϰ� ���ܳ��� �������� �ҿ��� �޼��带 �ϼ��ؾ��� �ǹ��� �ִ�.
	�� �θ𼼴뿡�� �ϼ����� ���� ���� �ڽ� ���뿡�� �ϼ��� ���� ���ѱ� �����̴�
	���)�߻�Ŭ������ ��ӹ��� �ڽ��� �θ� ���������� ���� �߻� �޼��带 �������̵� �ؾ��Ѵ�.
*/

import riding.Roller;
import aircraft.ZetWing;

//�ڹٿ����� ���� ����� �����ϰ� �ִ�. ��, �ڽ� Ŭ������ Ư�� Ŭ������ �θ�� �дٸ� ���̻� �ٸ� Ŭ������ �߰��ؼ� �θ�� ������ �� ����.

public class MP3Player extends MusicPlayer implements ZetWing, Roller{
	public void setVolume(){
		System.out.println("MP3�÷��̾��� ������ �����մϴ�.");
	}
	public void openMP3(){
		System.out.println("MP3������ �����մϴ�..");
	}

	public void roll(){
		System.out.println("�Ѹ���� ����");
	}
	public void fly(){
		System.out.println("������ ������ �ϴ��� ���ư���.");
	}


}