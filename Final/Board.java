/*
 * The Board Class is an 8x8 set of boxes to containing all active chess pieces 
*/



import java.util.ArrayList;
import java.util.*;
import java.lang.StringBuilder;
public class Board {
  private ArrayList<String> boardPrint= new ArrayList<String>();
  public static ArrayList <ArrayList <Piece>> chessBoard = new ArrayList<ArrayList<Piece>>();//Used to store the current arrangement of pieces
  public static ArrayList <ArrayList <Piece>> idiot; //This one will be used as a temporary array of pieces for check logic
  private boolean onBoard;
  public int turn=1;
  public GUI2 gui=null;
  public boolean whichKing;  //whichking will update in the is check method and be set to true if white king is in check and false if black king is in check 
  public boolean isMate;
 

 public Board(){//constructor that builds initial chess board
  gui=new GUI2();
  gui.end();
	 ArrayList<String> line= new ArrayList<String>();
   line.add("                                                    ");
   line.add("      A     B     C     D     E     F     G     H   ");
   line.add("   #################################################");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("7  #  R  #  N  #  B  #  Q  #  K  #  B  #  N  #  R  #");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("   #################################################");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("6  #  P  #  P  #  P  #  P  #  P  #  P  #  P  #  P  #");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("   #################################################");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("5  #     #     #     #     #     #     #     #     #");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("   #################################################");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("4  #     #     #     #     #     #     #     #     #");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("   #################################################");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("3  #     #     #     #     #     #     #     #     #");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("   #################################################");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("2  #     #     #     #     #     #     #     #     #");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("   #################################################");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("1  #  P  #  P  #  P  #  P  #  P  #  P  #  P  #  P  #");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("   #################################################");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("0  #  R  #  N  #  B  #  Q  #  K  #  B  #  N  #  R  #");
   line.add("   #     #     #     #     #     #     #     #     #");
   line.add("   #################################################");

   for (String s : line){
	   boardPrint.add(s);
	   }
	   
//initializes chessBoard to have all spots filled with null

for (int i=0;i<8;i++){
	chessBoard.add(new ArrayList<Piece>());
	for (int j=0;j<8;j++){
		chessBoard.get(i).add(j,null);
		}
	}

   //Rooks
   chessBoard.get(0).set(0,new Rook (0,0,false));
   chessBoard.get(0).set(7,new Rook (0,7,true));
   chessBoard.get(7).set(0,new Rook (7,0,false));
   chessBoard.get(7).set(7,new Rook (7,7,true));
   
   //knights
   chessBoard.get(1).set(0,new Knight (1,0,false));
   chessBoard.get(1).set(7,new Knight(1,7,true));
   chessBoard.get(6).set(0,new Knight (6,0,false));
   chessBoard.get(6).set(7,new Knight(6,7,true));

   
   //Bishops
   chessBoard.get(2).set(0,new Bishop (2,0,false));
   chessBoard.get(2).set(7,new Bishop(2,7,true));
   chessBoard.get(5).set(0,new Bishop (5,0,false));
   chessBoard.get(5).set(7,new Bishop(5,7,true));
   
   
   //Queens
   chessBoard.get(3).set(0,new Queen(3,0,false));
   chessBoard.get(3).set(7,new Queen(3,7,true));
   
   //Kings
   chessBoard.get(4).set(0,new King(4,0,false));
   chessBoard.get(4).set(7,new King(4,7,true));
   
   //Pawns
   for(int i=0; i<8;i++){
	   chessBoard.get(i).set(1,new Pawn(i,1,false));
	   chessBoard.get(i).set(6,new Pawn(i,6,true));
	   }
    
	idiot=chessBoard;
	
   }
   
 public Board (int n){}
   
   
	/*
 * This method loops through the arrayList and prints the Board 
*/
   public void printBoard (){
	   for (String s : boardPrint){
	   System.out.println(s);}
	   }
	   
	//parameter is string which is in the format "A2,B2"
	
	/*
 * The Method scanBoard checks if the inputed string which represents a move, is a valid move for that piece, considering En Passant and Castling Logic,
 also checks if it would put itself into check, and if everything works, 
 it makes the move and returns true indicating that it is a legal move and makes the move
*/
	
	public boolean scanBoard (String s){

		boolean wTurn;
		if (turn % 2 ==0)
			wTurn=false;
		else {wTurn=true;}
		boolean move=false;
		boolean check;
		int tester=0;
		int i = 0;
		int k = 0;
		int l = 0;
		int j = 0;
	
		char x1 = s.charAt(0);
		char y1 = s.charAt(1);
		char x2 = s.charAt(3);
		char y2 = s.charAt(4);
		char piece;
		//Converting string into integeres corresponding to indicies of pieces on the chessboard
		
		
		i=this.getXFromChar(x1);
		j=this.getXFromChar(x2);
		l=this.getYFromChar(y1);
		k=this.getYFromChar(y2);
		
		int Cx1=(i/6)-1;
		int Cx2=(j/6)-1;
		int Cy1=(l/4)-1;
		int Cy2=(k/4)-1;
		
		piece = this.getPiece(i,l);
		
		//line below doesnt work because x1, y1 are chars
		//System.out.println(piece);
		if ((Cx1<0||Cx1>7)||(Cx2<0||Cx2>7)||(Cy1<0||Cy1>7)||(Cy2<0||Cy2>7)){
			move=false;
			System.out.println("offboard");
			//tester+=1;
			}
			
		else if (wTurn==chessBoard.get(Cx1).get(Cy1).getW()){
			move=getPieceMove(Cx1,Cy1,Cx2,Cy2);
		}

	if (move==true){
			idiot =isGoingToBeInCheck(Cx1,Cy1,Cx2,Cy2) ;
			check=isCheck(idiot);
			isMate=isCMate();

			if (check==true&& this.whichKing==chessBoard.get(Cx1).get(Cy1).getW()){
				move=false;
				}

			if (Cx1==Cx2&&Cy1==Cy2){
				move=false;
				}

			else if (check==false||(check==true&&this.whichKing!=chessBoard.get(Cx1).get(Cy1).getW())){
			turn+=1;
			gui.movement(s);
			if (chessBoard.get(Cx2).get(Cy1)!=null){
			if (chessBoard.get(Cx2).get(Cy1).getEnPassant()&&chessBoard.get(Cx2).get(Cy1).getW()!=chessBoard.get(Cx1).get(Cy1).getW()&& chessBoard.get(Cx1).get(Cy1).getP()=='P'){
				chessBoard.get(Cx2).set(Cy1,null);
				}}
			chessBoard.get(Cx1).get(Cy1).setHasMoved(true);
			chessBoard.get(Cx1).get(Cy1).setX(Cx2);
			chessBoard.get(Cx1).get(Cy1).setY(Cy2);
			chessBoard.get(Cx2).set(Cy2,chessBoard.get(Cx1).get(Cy1));
			chessBoard.get(Cx1).set(Cy1,null);}
			}
		//If the move is valid, performs move
		
		//The below is for castling bypasses normal king movement rules
		else if((chessBoard.get(Cx1).get(Cy1).getP()=='K' && chessBoard.get(Cx1).get(Cy1).getHasMoved()==false && isCheck(chessBoard)==false)){//if the selected piece is a king that hasnt moved, and is not in check
			move=false;
				if(chessBoard.get(Cx1).get(Cy1).getW()==true){//if white king
					if(Cx2==2 && Cy2==7 && chessBoard.get(0).get(7)!=null){//if left side and a piece is where the castle should be
						if(chessBoard.get(0).get(7).getHasMoved()==false){
							for(int ah=1;ah<=3;ah++){
								if(chessBoard.get(ah).get(7)!=null || isCheck(isGoingToBeInCheck(Cx1,Cy1,ah,Cy2))){//if a space in between is empty or attacked, breaks the loop and sets move to false
									move=false;
									break;
								}
								else
									move=true;
								if(ah==3 && move){
									chessBoard.get(Cx1).get(Cy1).setHasMoved(true); chessBoard.get(0).get(7).setHasMoved(true);
									chessBoard.get(Cx1).get(Cy1).setX(Cx2); chessBoard.get(0).get(7).setX(3);
									chessBoard.get(Cx2).set(Cy2,chessBoard.get(Cx1).get(Cy1)); chessBoard.get(3).set(7,chessBoard.get(0).get(7));
									chessBoard.get(Cx1).set(Cy1,null); chessBoard.get(0).set(7,null);
								}
							}
						}
					}
					else if(Cx2==6 && Cy2==7 && chessBoard.get(0).get(7)!=null){//if right side and a piece is where the castle should be
						if(chessBoard.get(7).get(7).getHasMoved()==false){
							for(int ah=5;ah<=6;ah++){
								if(chessBoard.get(ah).get(7)!=null || isCheck(isGoingToBeInCheck(Cx1,Cy1,ah,Cy2))){//if a space in between is empty or attacked, breaks the loop and sets move to false
									move=false;
									System.out.println("One of the spaces is attacked"+ah);
									break;
								}
								else
									move=true;
								if(ah==6 && move){
									chessBoard.get(Cx1).get(Cy1).setHasMoved(true);chessBoard.get(7).get(7).setHasMoved(true);
									chessBoard.get(Cx1).get(Cy1).setX(Cx2); chessBoard.get(7).get(7).setX(5);
									chessBoard.get(Cx2).set(Cy2,chessBoard.get(Cx1).get(Cy1)); chessBoard.get(5).set(7,chessBoard.get(7).get(7));
									chessBoard.get(Cx1).set(Cy1,null); chessBoard.get(7).set(7,null);
								}
							}
						}
					}
				}
				
				else{										   //if black king
					if(Cx2==2 && Cy2==0 && chessBoard.get(0).get(0)!=null){//if left side and a piece is where the castle should be
						if(chessBoard.get(0).get(0).getHasMoved()==false){
							for(int ah=1;ah<=3;ah++){
								if(chessBoard.get(ah).get(0)!=null || isCheck(isGoingToBeInCheck(Cx1,Cy1,ah,Cy2))){//if a space in between is empty or attacked, breaks the loop and sets move to false
									move=false;
									break;
								}
								else
									move=true;
								if(ah==3 && move){
									chessBoard.get(Cx1).get(Cy1).setHasMoved(true); chessBoard.get(0).get(0).setHasMoved(true);
									chessBoard.get(Cx1).get(Cy1).setX(Cx2); chessBoard.get(0).get(0).setX(3);
									chessBoard.get(Cx2).set(Cy2,chessBoard.get(Cx1).get(Cy1)); chessBoard.get(3).set(0,chessBoard.get(0).get(0));
									chessBoard.get(Cx1).set(Cy1,null); chessBoard.get(0).set(0,null);
								}
							}
						}
					}
					else if(Cx2==6 && Cy2==0 && chessBoard.get(0).get(0)!=null){//if right side and a piece is where the castle should be
						if(chessBoard.get(7).get(0).getHasMoved()==false){
							for(int ah=5;ah<=6;ah++){
								if(chessBoard.get(ah).get(0)!=null || isCheck(isGoingToBeInCheck(Cx1,Cy1,ah,Cy2))){//if a space in between is empty or attacked, breaks the loop and sets move to false
									move=false;
									break;
								}
								else
									move=true;
								if(ah==6 && move){
									chessBoard.get(Cx1).get(Cy1).setHasMoved(true); chessBoard.get(7).get(0).setHasMoved(true);
									chessBoard.get(Cx1).get(Cy1).setX(Cx2); chessBoard.get(7).get(0).setX(5);
									chessBoard.get(Cx2).set(Cy2,chessBoard.get(Cx1).get(Cy1)); chessBoard.get(5).set(0,chessBoard.get(7).get(0));
									chessBoard.get(Cx1).set(Cy1,null); chessBoard.get(7).set(0,null);
								}
							}
						}
					}
					
				}
			}	
		//End castling logic
		this.updateBoardFromArray();
		idiot=chessBoard;
		return move;
	}
	
	
	/*
 * The getPieceMove method returns true if piece p in x1,y1 can move to x2,y2
*/	
	
public boolean getPieceMove(int x1, int y1, int x2, int y2){//this method is a shortcut for calling the canMove function for a piece
	boolean move;
	
		move = chessBoard.get(x1).get(y1).canMove(x2,y2);

		return move;
		}


public void updateBoardFromArray(){// this will update the text based board printed to the console from the piece array 	
	char piece;
	String line;
	String temp;
	boolean color;
	for (int i=0; i<chessBoard.size();i++){
		for (int j=0; j<chessBoard.get(i).size();j++){
			if (chessBoard.get(i).get(j)== null){
				line = boardPrint.get(4*(j+1));

				temp = line.substring(0,6*(i+1))+' '+line.substring(6*(i+1)+1);
				boardPrint.set(4*(j+1),temp);
				}
			else{
				piece=chessBoard.get(i).get(j).getP();
				color=chessBoard.get(i).get(j).getW();
				line = boardPrint.get(4*(j+1));
				temp = line.substring(0,6*(i+1))+piece+line.substring(6*(i+1)+1);
				boardPrint.set(4*(j+1),temp);
				}
			
			}
		}
	
	}


public int getXFromChar(char x){//this returns the integer index of x
int i=0;
for (char letter: boardPrint.get(1).toCharArray()){
					if (letter==x){
						i=boardPrint.get(1).indexOf(letter);}}
		return i;
		}

public int getYFromChar(char y){//this returns the integer index of y
	int i=0;
	int n=0;
	for (String line : boardPrint){
		if (line.startsWith(Character.toString(y))){
			n=i;
			}
		i+=1;
		}
	return n;
	}
	
	/*
 * The getPiece Method returns the character of the piece on the console board
*/


public char getPiece(int x, int y){
	char piece = boardPrint.get(y).charAt(x);
	return piece;		
}
//getter
	
	/*
 * This Getter Method only returns if after the move happens one team is in check, this is only used in the Game Class, there is another method.
*/

public boolean getOnB(){
	return this.onBoard;
	}


public boolean isCheck(ArrayList <ArrayList <Piece>> chess){
	int n = 0;
	idiot=chess;
	for (int i=0; i<chess.size();i++){
		for (int j=0; j<chess.get(i).size();j++){
			if (chess.get(i).get(j)!=null){
				if (chess.get(i).get(j).getP()=='K'){
					
					//i, and j are the location of a king, so now rescan board to check if any of the players can move to i, j
					for (int k=0;k<chess.size();k++){
						for (int l=0; l<chess.get(k).size();l++){
							if (chess.get(k).get(l)!=null){
								if (chess.get(i).get(j).getW()!=chess.get(k).get(l).getW()){//If the king and the piece are different colors
									if (chess.get(k).get(l).canMove(i,j)){//If piece can move to king position
										n+=1;
										this.whichKing = chess.get(i).get(j).getW();
									}
									
								}
					}}
				}}
		}}}
		//The above series of loops that check if the king is in check or not
		if (n>=1){
			idiot=chessBoard;
			return true;
		}
		else{
			idiot=chessBoard;
			return false;
		}
	}
	
		/*
 * The method  isGoingToBeInCheck returns a copy of the ChessBoard after a move is made, its used to determine if the move would put the player's own king into check
*/

public ArrayList <ArrayList <Piece>> isGoingToBeInCheck(int x1, int y1, int x2, int y2){
	
	
	ArrayList <ArrayList <Piece>> dummy = new ArrayList<ArrayList<Piece>>();
	//initializes a dummy chessboard to be the same as the current board
	for (int i=0;i<8;i++){
	dummy.add(new ArrayList<Piece>());
	for (int j=0;j<8;j++){
		dummy.get(i).add(j,null);
		}
	}
	
	for (int i=0; i<chessBoard.size();i++){
		for (int j=0; j<chessBoard.get(i).size();j++){
			if (chessBoard.get(i).get(j)!=null){
			if (chessBoard.get(i).get(j).getP()=='P'){
				dummy.get(i).set(j,new Pawn(chessBoard.get(i).get(j).getX(),chessBoard.get(i).get(j).getY(),chessBoard.get(i).get(j).getW(),chessBoard.get(i).get(j).getHasMoved()));
				}
			else if (chessBoard.get(i).get(j).getP()=='R'){
				dummy.get(i).set(j,new Rook(chessBoard.get(i).get(j).getX(),chessBoard.get(i).get(j).getY(),chessBoard.get(i).get(j).getW(),chessBoard.get(i).get(j).getHasMoved()));
				}
			else if (chessBoard.get(i).get(j).getP()=='N'){
				dummy.get(i).set(j,new Knight(chessBoard.get(i).get(j).getX(),chessBoard.get(i).get(j).getY(),chessBoard.get(i).get(j).getW(),chessBoard.get(i).get(j).getHasMoved()));
				}
			else if (chessBoard.get(i).get(j).getP()=='B'){
				dummy.get(i).set(j,new Bishop(chessBoard.get(i).get(j).getX(),chessBoard.get(i).get(j).getY(),chessBoard.get(i).get(j).getW(),chessBoard.get(i).get(j).getHasMoved()));
				}
			else if (chessBoard.get(i).get(j).getP()=='Q'){ 
				dummy.get(i).set(j,new Queen(chessBoard.get(i).get(j).getX(),chessBoard.get(i).get(j).getY(),chessBoard.get(i).get(j).getW(),chessBoard.get(i).get(j).getHasMoved()));
				}
			else if (chessBoard.get(i).get(j).getP()=='K'){
				dummy.get(i).set(j,new King(chessBoard.get(i).get(j).getX(),chessBoard.get(i).get(j).getY(),chessBoard.get(i).get(j).getW(),chessBoard.get(i).get(j).getHasMoved()));
				}}
		
	}}//Copying the array
	//now moves the possible move x1 and x2

	dummy.get(x1).get(y1).setX(x2);
	dummy.get(x1).get(y1).setY(y2);
	dummy.get(x2).set(y2,dummy.get(x1).get(y1));
	dummy.get(x1).set(y1,null);

	//Bypasses checking if it is a valid move
	return dummy;
}

public void toggleEnPassant(int turny){//Sets En Passant for all pawns owned by the player who's turn it is to false
	boolean wite=true;
	if(turny%2==0)
		wite=false;
	
	for (int i=0; i<chessBoard.size();i++){
		for (int j=0; j<chessBoard.get(i).size();j++){
			if (chessBoard.get(i).get(j)!=null){
				if ((chessBoard.get(i).get(j).getP()=='P')&&(chessBoard.get(i).get(j).getW()==wite))
						chessBoard.get(i).get(j).setEnPassant(false);

}}}}

public boolean isCMate(){//Checks if the current state of the board is in checkmate
	int n=0;
		for(int i=0; i<chessBoard.size();i++){
			for (int j=0; j<chessBoard.get(i).size();j++){
				if (chessBoard.get(i).get(j)!=null){
				if (chessBoard.get(i).get(j).getW()== this.whichKing){
					for (int k=0; k<chessBoard.size();k++){
						for (int l=0; l<chessBoard.get(k).size();l++){
							if (chessBoard.get(i).get(j).canMove(k,l)){
							if (isCheck(isGoingToBeInCheck(i,j,k,l))==false){
								n+=1;
							}
							}
							}
						}
				
			}
		
		}
	
	}
	
}
if (n>0){
	return false;
	}
else {
	isMate=true;
	return true;}

}
	
		/*
 * The method printArray prints the text based version of the board to the console
*/

public void printArray(ArrayList <ArrayList <Piece>> chess){
	for (int i=0; i<8;i++){
		for (int j=0;j<8;j++){
			if (chess.get(i).get(j)!=null){
			System.out.println(chess.get(i).get(j).getP()+","+chess.get(i).get(j).getX()+","+chess.get(i).get(j).getY()+","+chess.get(i).get(j).getW());
			}
		}
		}
	
	}
	
public int getTurn(){
	return this.turn;
	}
}
