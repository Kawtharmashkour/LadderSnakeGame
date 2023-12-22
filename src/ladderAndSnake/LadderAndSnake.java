package ladderAndSnake;

import java.util.Arrays;
import java.util.Random;

public class LadderAndSnake {
	private static int board[][];
	private static int numOfPlayers;
	private int[] playersOrder;
	private int[] playerPositions;
	
	//constructor
	public LadderAndSnake(int np) {
		numOfPlayers = np;
		boardInitialize();
		playerInitialize();
		
	}
	
	public void play() {
		int [] duplicates;
		
		System.out.println("Determining the order of playing turns...");
		int[] arr = new int[numOfPlayers];

        // Roll the dice for each player
		for (int i = 0; i < numOfPlayers; i++) {
            arr[i] = flipDice();
            System.out.println("Player " + (i+1) + " rolled a dice and got " + arr[i]);
        }
		
		//Roll the dice for each player has duplicate dice value
		do {
			
	        duplicates = Checker.findDuplicates(arr);
	        
	        if(duplicates.length>0) {
	        	//message
        		System.out.print("A tie was achieved between");
        		for(int j=0; j<duplicates.length; j++) {
        			System.out.printf(" player %d ",duplicates[j]);
        		}
        		System.out.println(". Attempting to break the tie");
        		
        		//input the new dice to the corresponding player
	        	for (int i = 0; i < duplicates.length; i++) {
		            arr[duplicates[i]-1] = flipDice();
		            System.out.println("Player " + duplicates[i] + " rolled a dice and got " + arr[duplicates[i]-1]);
		        }
	        }
        
		}while(duplicates.length>0);
		
		//arr is sorted because binarySearch method works on sorted arrays
        int[] arrSorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arrSorted);
        
        //assign the players depend on their dice value
        for(int i=0; i<arrSorted.length; i++) {
        	playersOrder[i] =(Arrays.binarySearch(arrSorted, arr[arr.length-i-1]) + 1);
        }
        
        
        System.out.print("Reached final decision on order of playing: ");
        for(int j=0; j<playersOrder.length; j++) {
			System.out.printf(" player %d ",playersOrder[j]);
		}
       
        
	} 
	
	
	public int flipDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
	
	private void playerInitialize() {
		playersOrder = new int[numOfPlayers];
		playerPositions = new int[numOfPlayers];
		
		Arrays.fill(playerPositions, 0);
	}
	
	private void boardInitialize() {
		board = new int[10][10];
		
		//initialize with 0, Zero means no ladder or snake available in the cell
		for(int i=0; i<10; i++) {
			Arrays.fill(board[i], 0);
		}
		
		//Initialize ladders , positive number to represent how many forward moves
		board[9][0] = 37;
		board[9][3] = 10;
		board[9][8] = 22;
		board[7][0] = 21;
		board[7][7] = 56;
		board[6][4] = 8;
		board[4][9] = 15;
		board[2][0] = 20;
		board[2][9] = 20;
		
		//Initialize snake , negative number to represent how many backword moves
		board[8][4] = -10;
		board[5][7] = -18;
		board[2][1] = -60;
		board[3][3] = -4;
		board[0][2] = -20;
		board[0][3] = -21;
		board[0][5] = -71;
		board[0][7] = -25;
		
 	}
}
