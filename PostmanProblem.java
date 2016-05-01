import java.util.Scanner;

public class PostmanProblem {
	

	/* Background:
	 * 
	 * There is a straight highway with villages alongside the highway. 
	 * The highway is represented as an integer axis, and the position 
	 * of each village is identified with a single integer coordinate. 
	 * There are no two villages in the same position. The distance 
	 * between two positions is the absolute value of the difference 
	 * of their integer coordinates. Post ofï¬�ces will be built in some, 
	 * but not necessarily all of the villages. Obviously, a village and 
	 * the post office in it have the same position. For building the 
	 * police offices, their positions should be chosen so that the 
	 * total sum of all distances between each village and its nearest 
	 * post office is minimal.
	 * 
	 * To Use:
	 * 
	 * Enter two integers: <number of villages> <number of post offices>
	 * Enter the position of each village
	 * 
	 * Output: the number of  the sum of all distances between 
	 * 		   each village and its nearest post office
	 * 
	 * Sample Input:
	 * 
	 * 10 5 
	 * 1 2 3 6 7 9 11 22 44 50
	 * 
	 * Sample Output:
	 * 
	 * 9
	 *
	 */
	
	public static Scanner sc = new Scanner(System.in);
	public static int numVillages, numPoliceStation;
	public static int[] villagePositions;
	
	public static Integer[][] memoizeTable;
	
	public static void main(String[] args){
		init();	
		int result = minDistance(numVillages, numPoliceStation);
		System.out.println(result);
	}

	private static void init() {
		getNumVillagesAndPoliceStation();
		fillVillagePositions(numVillages);
		memoizeTable = new Integer[numVillages][numPoliceStation];
		
	}
	
	private static int minDistance(int numberOfVillages, int numberOfPostOffices){
		int smallestDistance = Integer.MAX_VALUE;
		
		//If there's a memozied value, return it
		if (memoizeTable[numberOfVillages-1][numberOfPostOffices-1]!=null){
			return memoizeTable[numberOfVillages-1][numberOfPostOffices-1];
		}
		
		if (numberOfVillages<=numberOfPostOffices || numberOfVillages<=1 || numberOfPostOffices<0){
			memoizeTable[numberOfVillages-1][numberOfPostOffices-1]=0;
			return (int) 0;
			
		} else if (numberOfPostOffices==1){
			//Base Case
			for (int i=0; i<numberOfVillages; i++){
				int currDist=0;
				for (int j=0; j<numberOfVillages; j++){
					currDist += Math.abs(villagePositions[i]-villagePositions[j]);
				}
				if (currDist<smallestDistance){
					smallestDistance = currDist;
				}
			}
			memoizeTable[numberOfVillages-1][numberOfPostOffices-1]=smallestDistance;
			return smallestDistance;
			
		} else {		
			//Recursive Step
			for (int i=0; i<numberOfVillages-1; i++){
				int minimumCostofPreceeding = minDistance(numberOfVillages-1-i,numberOfPostOffices-1); 
				int costOfCurrent = cost(numberOfVillages-2-i,numberOfVillages-1); 
				int totalCost = minimumCostofPreceeding + costOfCurrent;
				if (totalCost<smallestDistance){
					smallestDistance=totalCost;
				}
			}
		memoizeTable[numberOfVillages-1][numberOfPostOffices-1]=smallestDistance;
		return smallestDistance;
		}
	}
	
	private static int cost(int startPostIndex, int endPostIndex){
		int distance = 0;
		for (int i=startPostIndex+1; i<endPostIndex; i++){
			//add up the cost 
			int minDist = Math.min(villagePositions[endPostIndex]-villagePositions[i],villagePositions[i]-villagePositions[startPostIndex]);
			distance+=minDist;
		}
		return distance;
	}

	private static void getNumVillagesAndPoliceStation() {
		String[] argsArray;
		argsArray = sc.nextLine().split(" ",2);
		numVillages = Integer.parseInt(argsArray[0].trim());
		numPoliceStation = Integer.parseInt(argsArray[1].trim());
	}

	private static void fillVillagePositions(int numVillages) {
		String[] argsArray;
		villagePositions = new int[numVillages];
		argsArray = sc.nextLine().split(" ",numVillages);
		for (int i=0; i<numVillages; i++){
			villagePositions[i]=Integer.parseInt(argsArray[i]);
		}
	}
}
