package pcKiosk;

import java.util.HashMap;

public class PersonInfo {
	HashMap<String, String> map = new HashMap<>();
	
	public PersonInfo() {
		String time = "00:50";
		String id1= "leegeonju"; 
		String id2= "leegyuwon"; 
		String id3= "namtaewoo";
		String id4= "shindonghoon";
		map.put(id1, "00:30");
		map.put(id2, time);
		map.put(id3, time);	
		map.put(id4, time);		
	}
	
	public String getInfo(String id) {
		return map.get(id);
		
	}

	public void setInfo(String id, String time) {
		map.put(id, time);
		
	}

	public String cal(String id, String time) {
		String[] aryTime = time.split(":"); // :을 기준으로 aryTime[0]에 시간 저장 aryTime[1]에 분 저장
		
		//String >> int 변환
		int hour = Integer.parseInt(aryTime[0]);
		int min = Integer.parseInt(aryTime[1]);
		
		String curTime = getInfo(id);
		String[] aryCurTime = curTime.split(":");
		
		int curHour = Integer.parseInt(aryCurTime[0]);
		int curMin = Integer.parseInt(aryCurTime[1]);
		
		int totMin = (curHour*60) + (curMin) + (hour*60) + (min);
		
		int outHour = totMin / 60;
		int outMin = totMin % 60;
		
		String sHour ="";
		String sMin = "";
				
		if(outHour<1) {
			sHour = "00";
		}else if (outHour<10) {
			sHour = "0"+outHour;
		}else {			
			sHour = String.valueOf(outHour);
		}
		
		if(outMin<1) {
			sMin = "00";
		}else if (outMin<10) {
			sMin = "0"+outMin;
		}else {			
			sMin = String.valueOf(outMin);
		}
		
		String sTime = sHour + ":" + sMin;
		setInfo(id, sTime);
		
		return sTime;

	}
}	
