package com.javatest.array;
import java.util.ArrayList;
import java.util.List;

public class Meeting {

	
	 
	static EmptySlot getOverlapForTimePeriod (EmptySlot firstSlot, EmptySlot secondSlot, int duration) { 
		if(firstSlot.start > secondSlot.end || 
				secondSlot.start > firstSlot.end) { 
			return null; 
		}
		
		int overlapStartTime = (firstSlot.start < secondSlot.start) ? 
				secondSlot.start : firstSlot.start; 
		int overlapEndTime = (firstSlot.end < secondSlot.end) ? 
				firstSlot.end : secondSlot.end;
	
		if(overlapEndTime < overlapStartTime) {
			return null;
		}
		
		if( (overlapEndTime - overlapStartTime) > duration) {
			EmptySlot overlappedSlot = new EmptySlot(overlapStartTime, overlapEndTime);
			return overlappedSlot;
		}
		
		return null; 
	}
	
	boolean isOccedFirst(EmptySlot first, EmptySlot second ) { 
		if(first.start < second.start) {
			return true;
		}
		return false; 
	}
	
	private static void addSlot(List<EmptySlot> userEmptySlots, int start, int end) {
		EmptySlot slot = new EmptySlot(start,end) ; 
		userEmptySlots.add(slot);
	}
	
	private static EmptySlot findFirstSlotForMeeting(List<EmptySlot> firstUserEmptySlots,
			List<EmptySlot> secondUserEmptySlots, int duraration) {
		
		EmptySlot overlappedSlot = null; 
		firstUserEmptySlots.listIterator();
		
		int firstCounter  = 0;
		int secondCounter  = 0;
		
		while ( firstCounter< firstUserEmptySlots.size() && 
				secondCounter < secondUserEmptySlots.size() ) {
			EmptySlot firstSlot = firstUserEmptySlots.get(firstCounter);
			EmptySlot secondSlot = secondUserEmptySlots.get(secondCounter);
			 
			if(firstSlot.getDuration() < duraration ) {
				firstCounter++;
				continue;
			}
			if(secondSlot.getDuration() < duraration ) {
				secondCounter++;
				continue;
			}
			overlappedSlot =getOverlapForTimePeriod(firstSlot, secondSlot,duraration  );
			
			if(null != overlappedSlot) {
				System.out.println("found slot");
			  return overlappedSlot;
			} else {
				firstCounter++;
				secondCounter++;
			}
		}
		
		System.out.println("cound not find slot");
		return overlappedSlot; 
		
	}
	
	public static void main(String[] args) {
		// User 1: [10, 30] [60,120] [150,170]
		//user 2 : [10, 20] [20,120] [250,170]
		List<EmptySlot> firstUserEmptySlots = new ArrayList<>();
		addSlot(firstUserEmptySlots, 10, 30);
		addSlot(firstUserEmptySlots, 60, 120);
		addSlot(firstUserEmptySlots, 150, 170);
		
		List<EmptySlot> secondUserEmptySlots = new ArrayList<>();
		addSlot(secondUserEmptySlots, 10, 20);
		addSlot(secondUserEmptySlots, 20, 120);
		addSlot(secondUserEmptySlots, 150, 170);
		
		int duraration = 30; 
		
		EmptySlot slot = findFirstSlotForMeeting(firstUserEmptySlots,secondUserEmptySlots,duraration );
		
		System.out.println(slot);

	}
}

class EmptySlot { 
	int start; 
	int end; 
	EmptySlot ( int a, int b  ) { 
		start = a;
		end = b;
	}
	
	int getDuration () {
		return end - start; 
	}

	@Override
	public String toString() {
		return "EmptySlot [start=" + start + ", end=" + end + "]";
	}
	
	
	
}