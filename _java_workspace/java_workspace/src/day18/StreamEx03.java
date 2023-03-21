package day18;

import java.util.ArrayList;

import day15.student;

public class StreamEx03 {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<>();
		
		list.add(new Student("양휘원", 100));
		list.add(new Student("양휘투", 25));
		list.add(new Student("양휘쓰리", 30));
		list.add(new Student("양휘포", 49));
		list.add(new Student("양파입", 88));
		
		//{} : 처리구문이 많을경우 사용한다.
		list.stream().forEach(a/*list의 목록을 1개씩 가져온다.*/->{
			String name = a.getName();
			int score = a.getScore(); //list를 a에 대입한게 되므로 list의 함수 사용가능
		System.out.println(name+":"+score);
	});
		// 합계 : intStream
		// getScore() : Integer => int로 변환
		// 추출 => map, 추출 후 int변환 => mapToInt
		System.out.print("합계:"+list.stream().mapToInt(a-> a.getScore()).sum());//mapToInt 함수로 .getScore를 int형으로 변환 후 sum함수로 합계출력
		
		//개수 : count 사용
		// count 함수는 long자료형으로 추출되기때문에
		// 변수에 대입하려면 변수선언을 같은 long타입으로 해야한다.
		System.out.println("\t총인원:"+list.stream().count()+"명"); //list의 총 개수 .count함수 사용하여 출력
		
		//점수가 70점이상인 친구들의 합계
		int total = list.stream().mapToInt(a-> a.getScore()).filter(a-> a>=70).sum();
		System.out.println("70점이상인 성적 합계:"+total);
		
		System.out.println("종료");
	}


}
class Student{
	
	private String name;
	private int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	
	
}
