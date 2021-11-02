package airplane;

import java.util.*;



public class AirPlaneSeatAllocation {
	
	
	public static final int seatCategorySize = 3;
	public static final int AsileSeat = 0;
	public static final int WindowSeat = 1;
	public static final int MiddleSeat = 2;
    public static final int zeroIndex = 0;
	public static final int firstIndex = 1;

	
	public static void main(String[] args) {
        // input to the program
		String inputArray[] = {"32","43","23","34"};
		int maxPassg = 30;
		
		int counter=1;
		//key and value pair
		TreeMap<String,String> seatingMap = new TreeMap<String,String>();
		int inputArrayLength = inputArray.length;
		int maxArrayIndex = 0;
		
        // setting up the computational model
		
		for(int j=zeroIndex;j<inputArrayLength;j++){
			int seatLocationIndex = Integer.parseInt(""+inputArray[j].charAt(zeroIndex));
			int locationIndex=Integer.parseInt(""+inputArray[j].charAt(firstIndex));
			maxArrayIndex = seatLocationIndex > maxArrayIndex ? seatLocationIndex : maxArrayIndex;
			maxArrayIndex = locationIndex > maxArrayIndex ? locationIndex : maxArrayIndex;
		}
		
		for(int seatCategory=zeroIndex;seatCategory<seatCategorySize;seatCategory++){	
			for(int i=zeroIndex;i<maxArrayIndex;i++){
				for(int j=zeroIndex;j<inputArrayLength;j++){
					
					int seatLocationIndex = Integer.parseInt(""+inputArray[j].charAt(zeroIndex));
					int locationIndex=Integer.parseInt(""+inputArray[j].charAt(firstIndex));
					
					for(int k=zeroIndex;k<seatLocationIndex;k++){
						
						String seatKeyIndex = j+""+i+""+k;
						
						if(maxPassg+firstIndex != counter && (seatingMap.get(seatKeyIndex)==null) && i<locationIndex) {
							// start to assign seats
                            // assign aisle seats
							if(seatCategory==AsileSeat){
								if(j==zeroIndex&&k==seatLocationIndex -firstIndex){
									seatingMap.put(seatKeyIndex,"A-"+counter++);
								}
								if(j>zeroIndex&&j<inputArrayLength-firstIndex&&(k==zeroIndex||k==seatLocationIndex-firstIndex)){
									seatingMap.put(seatKeyIndex,"A-"+counter++);
								}
								if(j==inputArrayLength-firstIndex&&k==zeroIndex){
									seatingMap.put(seatKeyIndex,"A-"+counter++);
								}	
							}
                            // then assign windows seats
							else if(seatCategory==WindowSeat){
								if(j==zeroIndex&&k==zeroIndex){
									seatingMap.put(seatKeyIndex,"W-"+counter++);
								}
								if(j==inputArrayLength-firstIndex&&k==seatLocationIndex-firstIndex){
									seatingMap.put(seatKeyIndex,"W-"+counter++);
								}
							}
                            // lastly, assign Middle seats
							else if(seatCategory==MiddleSeat){
								if(k!=zeroIndex&&k!=seatLocationIndex-firstIndex){
									seatingMap.put(seatKeyIndex,"M-"+counter++);
								}
							}
							
						}
						if(maxPassg+firstIndex == counter) {
							break;
						}
					}	
				}
			}	
		}
		
		// print out seating plan
		System.out.println(" W - Window Seat");
		System.out.println(" M - Middle Seat");
		System.out.println(" A - Asile Seat");
		System.out.println("|| - Pathway\n\n\n");
		
		
		for(int i=zeroIndex;i<maxArrayIndex;i++){
			for(int j=zeroIndex;j<inputArrayLength;j++){
				int seatLocationIndex = Integer.parseInt(""+inputArray[j].charAt(zeroIndex));
				for(int k=zeroIndex;k<seatLocationIndex;k++){
					
					String seatKeyIndex = j+""+i+""+k;
					
					if(seatingMap.get(seatKeyIndex) != null) {
						String seatKeyData = seatingMap.get(seatKeyIndex);
						System.out.print(seatKeyData); 
						for(int space=zeroIndex;space<7-seatKeyData.toCharArray().length;space++) {
							System.out.print(" ");
						}
					}
					else {
						System.out.print("       "); 
					}
					
				}
				if(j<inputArrayLength-1) {
					System.out.print("        ||        "); 					
				}
			}
			System.out.println();
		}
		
	}
	
}
