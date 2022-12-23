import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
	private  FileWriter fw; // 파일에 쓰기 위한 FileWriter 객체

	public Writer(String fname) {
		try {
			File file = new File("./src/" + fname); // 출력파일 경로
			if(!file.exists()) {
				file.createNewFile(); // 파일이 존재하지 않는다면 파일을 생성
			}
			this.fw = new FileWriter(file, false); // FileWriter 초기화(덮어쓰기)
		} catch(IOException e) {
	        e.getStackTrace();
		}
	}
	
	public void write(String string) {
		try {
			this.fw.write(string); // 파일에 문자 쓰기
			this.fw.close(); // 파일 닫기
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
