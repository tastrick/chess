public class Queen extends Piece {

private char p = 'Q';
private int value=9;
private boolean white;
public Queen (int i, int j, boolean w){
	super(i,j,w);
	}
	
public Queen (int i, int j,boolean w, boolean h){
	super(i,j,w,h);
}
public int getValue(){
	return this.value;
	}
	
public boolean canMove(int x, int y){

	int n =0;

	if (x==this.getX()||y==this.getY()){
	int k =0;
	if (x==this.getX()){//for movement vertically
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
			
	else if (y==this.getY()){//for movement horizontally
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
					n+=1;
				}
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
	
	
	else {
	int extra=1;
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
