/*
 * The Piece class is the Parent class for all the types of Chess Pieces 
*/


import java.lang.Math;
public abstract class Piece {
	
  //INSTANCE VARIABLES
	
  private boolean white; //boolean for if white or black
  private int xpos; private int ypos; //positions of piece between 1 and 8
  private boolean danger;
  private char piece;
  private boolean hasMoved;
  
  //CONSTRUCTORS
  
  public Piece(char p){
   this.piece = p;
  }
  public Piece(Piece p){
   this.piece = p.piece;
  }
  public Piece(int x, int y, boolean w){
	  this.xpos=x;
	  this.ypos=y;
	  this.white=w;
	  this.hasMoved=false;
	  }
	  public Piece(int x, int y, boolean w, boolean h){
	  this.xpos=x;
	  this.ypos=y;
	  this.white=w;
	  this.hasMoved=h;
	  }
	  
	public Piece(){
		
		}

	  
//getter methods

public abstract int getValue();

public abstract boolean canMove(int i, int j);
public abstract void setEnPassant(boolean boo);//had to also make useless overide methods for all the pieces
public abstract boolean getEnPassant();//had to also make useless overide methods for all the pieces
	
/* 
The method getW returns whether the piece is a White piece/Black Piece
*/
public boolean getW(){
	return this.white;
	}
	public char getP(){
		return this.piece;
		}
	
	/* 
 * 
 The method getX return the x position of the Piece
*/
public int getX(){
	return this.xpos;
	}  
	
	/* 
 * 
 The method getY returns the y position of the Piece
*/
	
public int getY(){
	return this.ypos;
	}
	
	/* 
 * 
 The method getHasMoved checks to see if the Piece has moved
*/
public boolean getHasMoved(){
	return this.hasMoved;
}
//setter methods	
public void setW(boolean t){
	this.white=t;
	}
public void setP(char p){
	this.piece = p;
	
	}
public void setX(int x){
	this.xpos = x;
	}
public void setY(int y){
	this.ypos = y;
	}
public void setHasMoved(boolean hasMoved){
	this.hasMoved=hasMoved;
}
}
