package com.javatest.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeSlot {
	
	int startHour; 
	int endHour; 
	int avgRequest;
	
	
	
	public TimeSlot(int startHour, int endHour, int avgRequest) {
		this.startHour = startHour;
		this.endHour = endHour;
		this.avgRequest = avgRequest;
	}

	public int getStartHour() {
		return startHour;
	}
	
	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}
	
	public int getEndHour() {
		return endHour;
	}
	
	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}
	
	public int getAvgRequest() {
		return avgRequest;
	}
	
	public void setAvgRequest(int avgRequest) {
		this.avgRequest = avgRequest;
	} 

	
	@SuppressWarnings("boxing")
	public static int findMaxRequestInHour(List<List<TimeSlot> >  timeSlotList) {
		
		if( null == timeSlotList || timeSlotList.isEmpty()) {
			return 0; 
			//or throw exception 
		}
		Map<Integer, Integer> hourToRequestCountMap = new HashMap<>();

		for(List<TimeSlot> timeSlotsForMc : timeSlotList ) {
			if(null != timeSlotsForMc && timeSlotsForMc.isEmpty() == false) { 
				for(TimeSlot timeSlot : timeSlotsForMc) { 
					for( int key = timeSlot.startHour ; key < timeSlot.endHour ; key++) { 
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
		List<List<TimeSlot> > timeSlotList = new ArrayList<List<TimeSlot> >();
		
		List<TimeSlot> timeSlotsForMc1 = new ArrayList<TimeSlot>();
		timeSlotsForMc1.add( new TimeSlot(10,12,25));
		timeSlotsForMc1.add( new TimeSlot(13,14,20));
		timeSlotList.add(timeSlotsForMc1);
		
		List<TimeSlot> timeSlotsForMc2 = new ArrayList<TimeSlot>();
		timeSlotsForMc2.add( new TimeSlot(9,11,25));
		timeSlotsForMc2.add( new TimeSlot(12,15,45));
		
		timeSlotList.add(timeSlotsForMc2);
		
		System.out.println(findMaxRequestInHour(timeSlotList));
		
	}
	
	
}
