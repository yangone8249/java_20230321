package day19;

import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderEx {

	public static void main(String[] args) {
		/* 한글 여러글자를 읽고 출력
		 * 
		 */
		System.out.println("한글로 입력해주세요. (Enter)");
		int i;
		
		//InputStreamReader
		InputStreamReader isr = new InputStreamReader(System.in/*실제 기반의 inputStream을 입력해줘야함.*/);
		try {
			while((i = isr.read())/*InputStreamReader에 속한 Read를 대입*/ != '\n'/*줄바꿈이 나오면 반복문 탈출*/) {
				System.out.print((char)i);
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
