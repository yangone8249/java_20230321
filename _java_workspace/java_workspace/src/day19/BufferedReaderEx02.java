package day19;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BufferedReaderEx02 {

	public static void main(String[] args) throws IOException {
		/* BufferedReader, PrintWriter
		 * 파일을 읽은 후 복사하여 객체 생성
		 * out.txt에서 파일을 Buffered로 읽은 후 
		 * => out2.txt로 신규 생성
		 */
		BufferedReader read = new BufferedReader(new FileReader("D:\\_java_workspace\\java_workspace\\out.txt")); //out.txt가져오기
		FileWriter fw = new FileWriter("out2.txt");//out2.txt 파일 생성
		
		while(true) {
			
			String r = read.readLine(); //Buffer의 스트림은 한번쓰고 재사용 불가하니, 변수에 대입하여 저장

			if(r == null ) { // 버퍼의 마지막 라인은 null이 출력되니 if로 break; 설정
				break;
			}
			System.out.print(r+"\n"); //콘솔에 어떻게 출력될지 보여줄 문자열
		
			fw.write(r+"\n"); // 콘솔과 같이 새로운 out2.txt에 저장될 문자열
			
			
		}
	
		read.close();
		fw.close(); //close는 꼭 닫아주기!
		
	}

}
