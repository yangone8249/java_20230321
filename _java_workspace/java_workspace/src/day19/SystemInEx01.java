package day19;

import java.io.IOException;

public class SystemInEx01 {

	public static void main(String[] args) {
		/* 알파벳 하나를 쓰고 Enter를 누르면 알파벳을 콘솔에 출력
		 * 
		 */
		System.out.print("알파벳을 여러개 쓰고 Enter : ");
		int i;
		try {
			//조건에서 한번씩 검사하여 줄바꿈이 나올때 조건문 탈출.
			//조건문에서 System.in.read 작동 가능
			while((i = System.in.read())!='\n') { 
				// System.in.read는 한글자만 가능함.	
				System.out.print((char)i);
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
