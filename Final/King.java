public class King extends Piece {// Contains the logic used for Kings

private char p = 'K';
private boolean white;
private int value=20;

public King (int i, int j,boolean w){
	super(i,j,w);
	}
public King (int i, int j,boolean w,boolean h){
	super(i,j,w,h);
}
public int getValue(){
	return this.value;
	}
	
public boolean canMove(int x, int y){
	//check logic is done in board class, and this canmove isnt accessed until we know board is not in check.
	int Cx=this.getX();
	int Cy=this.getY();
	int n = 0;
	if ((Board.idiot.get(x).get(y)!=null&&Board.idiot.get(x).get(y).getW()!=this.getW())||(Board.idiot.get(x).get(y)==null)){
	if (x==Cx){
		if (y==Cy+1||y==Cy-1){
			n+=1;
			}
		}
	else if (x==Cx+1){
		if (y==Cy|| y==Cy+1||y==Cy-1){
			n+=1;
			}
		}
	else if (x==Cx-1){
		if (y==Cy||y==Cy+1||y==Cy-1){
			n+=1;
			}
		}}
	if (n>=1){
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

