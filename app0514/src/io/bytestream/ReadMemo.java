/*
�������� �ڹ� ���α׷����� �޸��� ������ ������ �о���� = �Է�
�ڹ��� java.it ��Ű���� io ���� Ŭ������ ����

*/



package io.bytestream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class ReadMemo{
	FileInputStream fis; //�Է½�Ʈ�� �� ������ ������� �� �Է� ��Ʈ��
	FileOutputStream fos;

	//�Ʒ��� �ڵ�� ���������δ� ������ ������, ���� �����ڰ� ���ϸ��� �߸������� ���,
	//�����Ҷ� (�� runtime �� ) ������ �߻��Ͽ�, ���α׷��� ������ ���ᰡ �Ǿ������.
	public ReadMemo(){


		//���� ó���� ���� : ������ ������ ����
		try{
			fis = new FileInputStream("D:/korea202102_javaworkspace/app0514/res/memo.txt");
			System.out.println("���Ͽ� ���� ��Ʈ�� ���� ����");
			fos = new FileOutputStream("D:/korea202102_javaworkspace/app0514/res/memo_copy.txt");
			

			/*
			int data = fis.read();//1byte�о����
			System.out.println("�о���� ������ : "+(char)data);
			*/
			while(true){
				int data=fis.read();
				if(data==-1)break;
				fos.write(data);
				System.out.print((char)data);
			}

			

		}catch(FileNotFoundException e){
			//���� try�� ������ �����ߴ� ����� �߻��� ���, ���α׷��� ������ ����Ǵ°��� �ƴ϶�,
			//����ΰ� �� catch������ �����ϰ� �ȴ�.
			//������ ������ ã�Ƴ� �� �ִ� �α�, �����ڿ��� ����
			System.out.println("�ش� ������ ã�� �� �����ϴ�.");
		}catch(IOException e){//����ĳġ�� -> read������ ���ܰ� �߻��ϱ� ������ 
			System.out.println("���� ������ �б� ����.");
		}

	}
	


	public static void main(String[] args){
		new ReadMemo();
	}
}
