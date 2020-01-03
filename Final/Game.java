	/*
 * The Game class controls the flow of a game,
 It keeps track of all the game moves, which player has the current turn, and the final result of the game, 
 also it allows you to choose between the 3 different modes we have AI vs AI, Player vs Player and Player vs AI
*/



import java.util.Scanner;
public class Game {
	
//INSTANCE VARIABLES 
public static int turn;
public static boolean isW;
public static int type;
public static String player = "";
public static void main (String[] args){
	int game2Loop=0;
	boolean game=true;

	//Used to indicate the type of game being played
	boolean game1=false;
	boolean game2=false;
	boolean game3=false;
	
	boolean canMove;
	Board b = new Board();

	
	AI AI_game3W=new AI(true);
	AI AI_game3B=new AI(false);
	AI AI_game2= new AI(false);
	String playerColor="";
	String move="";
	
	turn =b.getTurn();
	b.printBoard();
	
	/*
 * Asking what type of game the player wants to play and sets the type of game based on the input
*/

	System.out.println("Which type of Game would you like to play");
	System.out.println("(1) Player v.s Player");
	System.out.println("(2) Player v.s AI");
	System.out.println("(3) AI v.s AI");
	Scanner keyboard1=new Scanner(System.in);
	String GameType = keyboard1.nextLine();
	type=Integer.parseInt(Character.toString(GameType.charAt(0)));
	if (type==1){game1=true;}
	else if (type==2){
		game2=true;
		while (game2Loop==0){
		System.out.println("Which color would you like to play? Black or White?");
		Scanner keyboard3=new Scanner(System.in);
		playerColor = keyboard3.nextLine();
		if (playerColor.equals("black")|| playerColor.equals("white") || playerColor.equals("Black") || playerColor.equals("White")){
			game2Loop+=1;
			if (playerColor.equals("black") || playerColor.equals("Black"))
			{AI_game2=new AI(true);}
			
}
		}
		}
	else if (type==3){game3=true;}

	//for player vs player game
	while (game==true){
		if (turn % 2 ==0)
		{
			isW=false;
			if (game2==true){
				if (playerColor.equals("White")||playerColor.equals("white")){
					player="AI";
					}
				else {player="Player";}
				}
			else if (game1==true){player = "P2";}
			else if (game3==true){player = "AI2";}
			}
		else 
		{
		isW=true;
		if (game2==true){
			if (playerColor.equals("Black")||playerColor.equals("black")){
				player="AI";
				}
			else {player="Player";}
			}
		else if (game1==true){player = "P1";}	
		else if (game3==true){player="AI1";}
		}

	canMove=false;
	while(canMove==false){

	if (game1==true||(game2==true && player!="AI")){
	System.out.println(player + " please enter your move: ");
	Scanner keyboard2=new Scanner(System.in);
	move=keyboard2.nextLine();}
	
	else if (game2==true&&player=="AI"){
		move=AI_game2.NextMove();
		}
	else if (game3==true&&isW==true){
		move=AI_game3W.NextMove();
		}
	else if (game3==true && isW==false){

		move=AI_game3B.NextMove();
		}
	canMove=b.scanBoard(move);
	
	if (canMove){
	turn+=1;
	b.printBoard();

	try {java.util.concurrent.TimeUnit.SECONDS.sleep(2);}
	catch(Exception e){}

	b.toggleEnPassant(turn);//invokes method in Board class used to switch all enpassant of player's pawns to false if it is now their turn
	}
	else {System.out.println("Invalid move, Try again!");}
	}
	if(b.isMate){//If the board is in a state of checkmate, the game ends
		System.out.println("Checkmate");
		game=false;
	}
	}
	
   }
   

}
