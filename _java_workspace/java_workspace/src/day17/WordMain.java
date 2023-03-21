package day17;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class WordMain {
	/* 단어장 프로그램 만들기
	 * Word class
	 * 단어, 의미를 저장하는 클래스
	 * word, mean 생성자만들어서 하기
	 * 예) aplle : 사과
	 * 주의!! 오름차순으로 정렬해서 출력하기
	 * 1. 단어추가
	 * 2. 단어출력(정렬해서/key를 기준으로)
	 * 
	 */
	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);
		WordManager wm = new WordManager();
//		System.out.println("입력할 단어 개수");
//		int size = scan.nextInt();
		
		int menu;
		do {
			System.out.println("---메뉴선택---");
			System.out.println("1.단어추가");
			System.out.println("2.전체출력");
			System.out.println("3.단어검색");
			System.out.println("4.단어수정");
			System.out.println("5.단어삭제");
			System.out.println("6.파일로 출력");
			System.out.println("7.프로그램 종료");
			menu = scan.nextInt();
			
			switch(menu) {
			case 1: wm.add(scan); break;
			case 2: wm.print(); break;
			case 3: wm.read(scan); break;
			case 4: wm.update(scan); break;
			case 5: wm.delete(scan); break;
			case 6: 
			case 7: return;
			 default : System.out.println("메뉴 오류!");
			}
			
			
			
		}while(menu!=6);
		
		
		
		System.out.println("종료~!!");
		
		
		
		
	}
	
	



}
