import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
	private  FileWriter fw; // ���Ͽ� ���� ���� FileWriter ��ü

	public Writer(String fname) {
		try {
			File file = new File("./src/" + fname); // ������� ���
			if(!file.exists()) {
				file.createNewFile(); // ������ �������� �ʴ´ٸ� ������ ����
			}
			this.fw = new FileWriter(file, false); // FileWriter �ʱ�ȭ(�����)
		} catch(IOException e) {
	        e.getStackTrace();
		}
	}
	
	public void write(String string) {
		try {
			this.fw.write(string); // ���Ͽ� ���� ����
			this.fw.close(); // ���� �ݱ�
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
