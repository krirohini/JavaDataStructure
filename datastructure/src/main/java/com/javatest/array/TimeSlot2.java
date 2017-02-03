package com.javatest.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeSlot2 {
	
	int startTime; 
	int endTime; 
	int avgRequest;
	
	public TimeSlot2(int startTime, int endTime, int avgRequest) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.avgRequest = avgRequest;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public int getAvgRequest() {
		return avgRequest;
	}
	
	public void setAvgRequest(int avgRequest) {
		this.avgRequest = avgRequest;
	} 

	
	@SuppressWarnings("boxing")
	public static int findMaxRequestInHour(List<List<TimeSlot2> >  timeSlotList) {
		
		if( null == timeSlotList || timeSlotList.isEmpty()) {
			return 0; 
			//or throw exception 
		}
		Map<Integer, Integer> hourToRequestCountMap = new HashMap<>();

		for(List<TimeSlot2> timeSlotsForMc : timeSlotList ) {
			if(null != timeSlotsForMc && timeSlotsForMc.isEmpty() == false) { 
				for(TimeSlot2 timeSlot : timeSlotsForMc) { 
					for( int key = timeSlot.startTime ; key < timeSlot.endTime ; key++) { 
						if(hourToRequestCountMap.containsKey(key)) { 
							int count = hourToRequestCountMap.get(key);
							hourToRequestCountMap.put(key, count + timeSlot.getAvgRequest());
						} else { 
							hourToRequestCountMap.put(key, timeSlot.getAvgRequest());
						}
					}
				}
			}
		}
		
		int maxCount = 0; 
		for (Integer count : hourToRequestCountMap.values()) {
			if(count > maxCount) { 
				maxCount = count;
			}
		}
		
		return maxCount; 
	}
	
	public static void main(String[] args) {
		
//		mc1: {10,12,25}, {13,14,20}
//		mc2: {9,11,25}, {12,15,45}
		List<List<TimeSlot2> > timeSlotList = new ArrayList<List<TimeSlot2> >();
		
		List<TimeSlot2> timeSlotsForMc1 = new ArrayList<TimeSlot2>();
		timeSlotsForMc1.add( new TimeSlot2(10,12,25));
		timeSlotsForMc1.add( new TimeSlot2(13,14,20));
		timeSlotList.add(timeSlotsForMc1);
		
		List<TimeSlot2> timeSlotsForMc2 = new ArrayList<TimeSlot2>();
		timeSlotsForMc2.add( new TimeSlot2(9,11,25));
		timeSlotsForMc2.add( new TimeSlot2(12,15,45));
		
		timeSlotList.add(timeSlotsForMc2);
		
		System.out.println(findMaxRequestInHour(timeSlotList));
		
	}
	
	
}
