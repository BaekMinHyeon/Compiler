import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader {
	private Scanner scanner;
	public Reader(String fname) {
		try {
			this.scanner = new Scanner(new File("./src/" + fname)); // 읽을 파일 경로
		}catch (IOException e) {
			e.getStackTrace();
		}
	}
	
	public String[] Scan() {
		List<String> list = new ArrayList<>();
		while(this.scanner.hasNext()) {
			list.add(this.scanner.next());
		}
		String[] s = list.toArray(new String[0]);
		this.scanner.close();
		return s;
	}
}
