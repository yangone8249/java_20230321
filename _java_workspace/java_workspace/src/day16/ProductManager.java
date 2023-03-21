package day16;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager implements ProductInterface{
	
	private ArrayList<String> menu = new ArrayList<String>();
	private ArrayList<Integer> price = new ArrayList<Integer>();
	private ArrayList<String> order = new ArrayList<String>();
	private int total=0;
	private char select;
	@Override
	public void add(Scanner scan) {
			System.out.print("메뉴추가 기능입니다.\n추가할 메뉴를 입력하세요:");
			String m = scan.next();
			System.out.print(m+"의 가격을 입력하세요:");
			int p = scan.nextInt();
			menu.add(m);
			price.add(p);
			
	}

	@Override
	public void printProduct() {
			System.out.println("---메뉴 리스트 출력---");
			for(int i=0; i<menu.size();i++) {
				System.out.println(menu.get(i)+":"+price.get(i)+"원");
			}
	}
	
	@Override
	public void orderPick(Scanner scan) {
		
		System.out.println("----메뉴리스트----");
		for(int i=0; i<menu.size(); i++) {
			System.out.println(menu.get(i)+":"+price.get(i));
		}
		do {
			
		
		System.out.println("\n어떤메뉴로 주문하시겠습니까?");
		String choice = scan.next();
		order.add(choice);
		int cnt=0;
		System.out.println("몇개를 담으시나요?");
		int count = scan.nextInt();
		cnt = count;
		for(int i=0; i<menu.size(); i++) {
			if(choice.equals(menu.get(i))) {
				 count *= price.get(i);
				 total += count;
			}
		}
		
			System.out.println("total금액 : "+total);
		
		System.out.println("계속 주문하시겠습니까? (y/n)");
		select = scan.next().charAt(0);
		}while(select == 'y');
	}

	@Override
	public void delete(Scanner scan) {
		
		System.out.println("삭제할 메뉴를 입력하세요.");
		String d = scan.next();
		menu.remove(d);
	}

	@Override
	public void update(Scanner scan) {
		
		System.out.println("수정할 메뉴를 입력하세요.");
		String d = scan.next();
		for(int i=0; i<menu.size(); i++) {
			if(d.equals(menu.get(i))) {
				System.out.println(d+"를 어떤 메뉴로 변경하시나요?");
				String change = scan.next();
				menu.set(i, change);
				System.out.println(d+"의 가격은 얼마로 하시나요?");
				int rePrice = scan.nextInt();
				price.set(i, rePrice);
			}
		}
		
	}
	
	
}
