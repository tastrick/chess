/*
 * The Bishop class has the properties of the Piece Bishop to implement it in the Board of Arrays
*/


import java.lang.Math;
public class Bishop extends Piece {//Used for pieces of type Bishop
private int value=3;
private char p = 'B';
private boolean move;
private boolean white;

public Bishop (int i, int j, boolean w){
	this.setX(i);
	this.setY(j);
	this.setW(w);
	}

public Bishop (int i, int j,boolean w,boolean h){
	super(i,j,w,h);
}
	
	/*
 * The Method getValue get the Value of the Bishop
*/


public int getValue(){
	return this.value;
	}
	
	/*
 * The canMove method checks to see if the Bishop can move to that specific space
*/


public boolean canMove(int x, int y){
	int extra=1;
	int n=0;
	if (x>this.getX()){
		
		if (y>this.getY()&&(y-this.getY()==x-this.getX())){
			for (int i=this.getX();i<x-1;i++){
				if (Board.idiot.get(this.getX()+extra).get(this.getY()+extra)==null){
					n+=1;
					}
					extra+=1;
				}
				
			}
		else if (y< this.getY() &&(this.getY()-y==x-this.getX())){
			for (int i=this.getX(); i<x-1;i++){
				if (Board.idiot.get(this.getX()+extra).get(this.getY()-extra)==null){
					n+=1;
					}
				extra+=1;
				}
				
			}
		}
	else if (x<this.getX()){
			if (y>this.getY()&&(y-this.getY()==this.getX()-x)){
			for (int i= x;i<this.getX()-1;i++){

				if (Board.idiot.get(this.getX()-extra).get(this.getY()+extra)==null){
					n+=1;
					}
				extra+=1;
				}
				
			}
		else if (y< this.getY() &&(this.getY()-y==this.getX()-x)){
			for (int i=x; i<this.getX()-1;i++){
				 if (Board.idiot.get(this.getX()-extra).get(this.getY()-extra)==null){
					n+=1;

					}
					
					extra+=1;
				}
			}
		
		}
		if (n>=0){
		if (Board.idiot.get(x).get(y)!=null){
				if (Board.idiot.get(x).get(y).getW()!=this.getW()){
						n+=1;
						}
					}
		else if (Board.idiot.get(x).get(y)==null){
			n+=1;
			}}
	if (Math.abs(this.getX()-x)==Math.abs(this.getY()-y)){
		if (n==Math.abs(this.getX()-x)){return true;}
		else return false;
		}
	else return false;
	}

	public char getP(){
	return p;
	}

	public void setEnPassant(boolean boo){
	}

	public boolean getEnPassant(){
		return false;
	}
}
