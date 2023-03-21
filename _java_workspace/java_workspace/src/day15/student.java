package day15;

import java.util.Scanner;

public class student {
	/* class - student (별도 생성)
	 * 학생클래스 = 한 학생의 정보를 나타내는 클래스
	 * ㄴ학번, 이름, 주민번호, 학부, 학과, 수강과목(과목클래스를 배열로 생성)
	 * ㄴ수강과목에 대한 count 변수 (번지,index)
	 	ㄴ메서드 : 수강과목 추가(배열이 다 찼다면 늘려주기), 수강과목 삭제
	 	ㄴ생성자, get/set, 출력(toString)/2가지 형태로
	 */ 
	
	
	subject sub = new subject();
	private String stdName, stdNum, registerNum, faculty, major;
	private subject[] subjectlist = new subject[5]; 
	private int subCount;
	
	//생성자
	public student() {}
	//전체 요소를 받는 생성자
	public student(String stdName, String stdNum, String registerNum, String faculty, String major) {
		this.stdName = stdName;
		this.stdNum = stdNum;
		this.registerNum = registerNum;
		this.faculty = faculty;
		this.major = major;
	}
	
	//메서드
	/* print method : 학생 정보만 출력
	 */
	public void stdPrint() {
		System.out.println("학생명(학번):"+stdName+"("+stdNum+")");
		System.out.println("학부(학과):"+faculty+"("+major+")");
		System.out.println("주민번호:"+registerNum);
	}
	
	//수강과목을 출력하는 메서드
	public void subPrint() {
		//수강과목이 없을때
		if(subCount==0) {
			System.out.println("수강과목이 없습니다.");
		}else{
			//수강과목이 있을때 : 수강과목은 몇개 있는지 모름 (for문사용)
			for(int i=0; i<subCount; i++) {
				System.out.println(subjectlist[i]);
				//print메서드로 직접 sysout을 했을 경우엔 그냥 subjectlist만 사용한다.
			}
		}
		
		
	}
	// 수강과목 추가
	/* 매개변수 : subject subName
	 * 리턴타입 : void
	 */
	public void insertSubject(subject subName) {
		if(subCount == subjectlist.length) { //과목이 들어있는 배열이 다 차면 새로운 배열을 선언해주는 if문
			//new를 이용하여 배열 생성 +5
			subject[] tmp = new subject[subjectlist.length+5/*현재 인원에서 +5명 추가*/];//자료형을 subject의 생성자로 지정함.
			//arraycopy를 통해 배열복사
			System.arraycopy(subjectlist, 0, tmp, 0, subjectlist.length);//System.arraycopy(구배열, 시작번지, 신배열, 시작번지, 총개수)
			
//			for(int i=0; i<tmp.length; i++) {
//				subjectlist[i] = tmp[i];
//			}
			//새로만든 배열로 연결
			subjectlist = tmp;
		}
		//subName추가 (수강과목추가)
		subjectlist[subCount] = subName;
		subCount++; //값을 추가했기때문에 cnt증가
	}
	//수강과목 삭제
	public void deleteSubject(subject subName) {
		int index = -1; // 찾는 과목의 위치를 나타내는 변수
		// 만약 매개변수의 값이 null이라면 return한다.
		if(subName == null) {
			return;
		}
		//subName을 subjectlist에 있는지 검색
		for(int i=0; i<subCount; i++) {
			if(subjectlist[i].getSubName().equals(subName)) {
				//있다면 index에 저장
				index = i;
				break;
			}
		}
		if(index==-1) {
			System.out.println("수강한 과목이 없습니다.");
			return;
		}
		
		//찾았을 경우 삭제.
		//찾은 위치부터 뒷번지의 과목을 앞번지로 옮기는 작업
		for(int i=index; i<subCount-1; i++) {
			subjectlist[i] = subjectlist[i+1];
		}
		//마지막 번지는 null
		//ex) 과목이 3개 있다면 0 1 2(마지막번지는 2)
		subjectlist[subCount-1] = null;
		subCount--;
		
	}
	
	//subCount는 확인만하기때문에 getter만 만들고 setter는 안만든다(중요!)
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdNum() {
		return stdNum;
	}
	public void setStdNum(String stdNum) {
		this.stdNum = stdNum;
	}
	public String getRegisterNum() {
		return registerNum;
	}
	public void setRegisterNum(String registerNum) {
		this.registerNum = registerNum;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public subject[] getSubjectlist() {
		return subjectlist;
	}
	public void setSubjectlist(subject[] subjectlist) {
		this.subjectlist = subjectlist;
	}
	public int getSubCount() {
		return subCount;
	}
	
	
	
}
