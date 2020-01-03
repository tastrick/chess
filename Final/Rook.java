import java.lang.Math;
public class Rook extends Piece {// Contains the logic used for Rooks

private char p = 'R';
private boolean move;
private boolean white;
private int value=5;

public Rook (int i, int j, boolean w){
	super(i,j,w);
	}
public Rook (int i, int j,boolean w,boolean h){
	super(i,j,w,h);
}
public int getValue(){
	return this.value;
	}
public boolean canMove(int x, int y){
	int n=0;
	//k will tell us if the spot the rook wants to go to is of opposite colour
	int k=7;
	int l=0;
	if (x==this.getX()){
		l+=1;
		k=Math.abs(this.getY()-y);
		if (y>this.getY()){
			for (int i=this.getY()+1; i<y;i++){
				if (Board.idiot.get(x).get(i)==null){
					n+=1;
				}
				
			}
			
		}
		
		else if (y<this.getY()){
				for (int i=this.getY()-1; i>y;i--){
					if (Board.idiot.get(x).get(i)==null){
						n+=1;
						}
					
					}
		}
	}
			
	else if (y==this.getY()){
		l+=1;
		k=Math.abs(this.getX()-x);
		if (x>this.getX()){
		for (int i=this.getX()+1;i<x;i++){
			if (Board.idiot.get(i).get(y)==null){
				n+=1;
				}
			}
		
		}
		else if (x<this.getX()){
			for (int i=this.getX()-1;i>x;i--){
			if (Board.idiot.get(i).get(y)==null){
				n+=1;
				}
			}
			
			}
	}
	if (Board.idiot.get(x).get(y)==null){
		if (l>0){
					n+=1;
				}}
	else if (Board.idiot.get(x).get(y)!=null){
		if (Board.idiot.get(x).get(y).getW()!=this.getW()){
						n+=1;
		}
	}
	if (n==k){
		return true;
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
	
