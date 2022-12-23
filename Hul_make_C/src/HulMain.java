import java.util.regex.Pattern;

public class HulMain {
	/*
	 * OS - Windows 10 64-bit
	 * Compiler = javac 11.0.14
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader r = new Reader("test.hul");
		String[] s = r.Scan();
		Writer w = new Writer("test.c");
		int count = 0; // "{","}"�� ��Ʈ ����
		int max_deep = 10; // �ݺ��� �ִ� ���� 10
		int t_num = 1; // \t�� �ʿ䰳��
		int number[] = new int[max_deep]; // �ݺ� Ƚ���� ���� ���� �迭
		int num = 0; // number�� ���° �迭 ����
		String npattern = "^[0-9]*$"; // ���ڷθ� �̷����
		String result = "#include <stdio.h>\nint main() {\n\tint _hul;\n\n";
		for(int i = 0; i < s.length; i++) {
			if(Pattern.matches(npattern, s[i]) == false)  // ���ڰ� �ƴ� ���
				for(int t = 0; t < t_num; t++)
					result += "\t";
			for(Token token : Token.values()) {
				if(s[i].equals(token.string)) {
					switch(token) {
					case READ:
						result += "printf(\"input: \");\n";
						for(int t = 0; t < t_num; t++)
							result += "\t";
						result += "scanf(\"%d\", &_hul);";
						break;
					case WRITE:
						result += "printf(\"%d\", _hul);";
						break;
					case INC:
						result += "_hul++;";
						break;
					case DEC:
						result += "_hul--;";
						break;
					case BLOCK_BEGIN:
						int pri = i; // i�� ���
						num = 0; // num �ʱ�ȭ
						if(t_num == 1) { // ���� �ٱ��� BLOCK_BEGIN�� ����
							count++;
							while(count != 0) {
								i++;
								if(s[i].equals("Hul{"))
									count++;
								else if(s[i].equals("}"))
									count--;
								else
									if(Pattern.matches(npattern, s[i]) == true)  // ���ڷθ� �̷���� 
										number[num++] = Integer.parseInt(s[i]); // �ݺ� Ƚ�� ����
							}
							number[num++] = Integer.parseInt(s[i+1]); // ������ } �ڿ� �ִ� ���� ����
							for(int j = num-1; j >= 0; j--) {
								result += String.format("int max%d = %d;\n\t", num-1-j, number[j]);
							}
							number = new int[max_deep]; // �ʱ�ȭ
						}
						result += String.format("for (int i%d = 0; i%d < max%d; i%d++){", t_num-1, t_num-1, t_num-1, t_num-1);
						t_num++;
						i = pri;
						break;
					case BLOCK_END:
						result = result.substring(0, result.length()-1); // ������ ���� ����(\t)
						result += "}";
						t_num--;
						break;
					}
					result += "\n";
					break;
				}
			}
		}
		result += "\treturn 0;\n}";
		w.write(result);
	}
	
	public enum Token {
		READ("Hul?"), WRITE("Hul!"), INC("Hul>"), DEC("Hul<"),
		BLOCK_BEGIN("Hul{"), BLOCK_END("}");
		String string;
		Token(String s) {this.string=s;}
	}

}
