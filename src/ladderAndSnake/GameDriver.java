// ----------------------------------------------------- 
// Assignment (3) 
// Question:  
// Written by: (Kawthar Mashkour 6284305) 
// ----------------------------------------------------- 


package ladderAndSnake;

public class GameDriver{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("How many players ? ");
		int nPlayers = Checker.trialInputCheck();
		
		if(nPlayers>1) {
			System.out.printf(" \n -- Ladder and Snake Board Game --\n\n");
			System.out.printf("Game is Played by %d players \n",nPlayers);
			
			LadderAndSnake game = new LadderAndSnake(nPlayers);
			game.play();
		}
		
		System.out.printf(" \n -- Game Program Terminated --\n\n");
		
	}

	

}
