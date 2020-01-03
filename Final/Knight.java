public class Knight extends Piece {// Contains the logic used for Knights

private char p = 'N';
private boolean move;
private boolean white;
private int value=3;

public Knight (int i, int j,boolean w){
	this.setX(i);
	this.setY(j);
	this.setW(w);
	}
	
	public Knight (int i, int j,boolean w,boolean h){
	super(i,j,w,h);
}
public int getValue(){
	return this.value;
	}
	
public boolean canMove(int x, int y){
	int n=0;
	if ((x==this.getX()-1&&(y==this.getY()+2|| y==this.getY()-2 ))||(x==this.getX()+1&&(y==this.getY()+2||y==this.getY()-2))){
		n=1;
		
	}
	else if ((y==this.getY()+1&&(x==this.getX()+2||x==this.getX()-2))||(y==this.getY()-1&&(x==this.getX()+2||x==this.getX()-2))){
		n=1;
	}
	if ((Board.idiot.get(x).get(y)!=null)&&(Board.idiot.get(x).get(y).getW()==this.getW()))
		n=0;
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
