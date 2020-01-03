/*
 * We created the AI Class mainly because we wanted to the computer generate moves automatically for the game modes that use AI
*/
import java.util.Random;


public class AI extends Board{
	
private boolean color;

public AI(boolean color){
	super(1);
	this.color = color;
	}
public void setColor(boolean col){
	this.color=col;
	}

public String NextMove(){
	char piece=' ';
	int pieceValue=0;
	int xpos=0;
	int ypos=0;
	int threatx=0;
	int threaty=0;
	int counter=0;
	int count2=0;
	int rand=0;
	boolean threat=false;
	boolean defend = false;
	Random r = new Random();
	 int low=1;
     int high = 3;
     rand = r.nextInt(high-low)+low;
     System.out.println(rand);
	String move = "";//This will be a string representing the desired move
	//AI cannot use i,j,k,l 
	//first thing AI checks is what turn it is, if its within the first 
	//gets position of our king if hes in check

	if (super.isCheck(super.chessBoard)){//If the AI is in check, makes the first move it can find that removes the check
					 for (int it4=0;it4<super.chessBoard.size();it4++){
						for (int jt4=0 ;jt4 < super.chessBoard.get(it4).size();jt4++){
							if (super.chessBoard.get(it4).get(jt4)!=null&&super.chessBoard.get(it4).get(jt4).getW()==this.color){
								for (int it5=0;it5<super.chessBoard.size();it5++){
									for (int jt5=0;jt5<super.chessBoard.get(it5).size();jt5++){
										if (isCheck(isGoingToBeInCheck(it4,jt4,it5,jt5))==false){
											if (chessBoard.get(it4).get(jt4).canMove(it5,jt5)){
												move=this.toString(it4,jt4,it5,jt5);
												break;
											}}}}}}}}
	else{//takes the highest valued piece available if any are available
	//generating random number to decide wheather to be aggressive (takes pieces), to advance pieces, to 
	
	//loop bellow will check if any player of his color  is threatened by a piece of lesser value and we cant take it if it takes us
	
	for (int it0=0; it0<super.chessBoard.size();it0++){
	for (int jt0=0; jt0<super.chessBoard.get(it0).size();jt0++){
	if (super.chessBoard.get(it0).get(jt0)!=null&&super.chessBoard.get(it0).get(jt0).getW()==this.color&&super.chessBoard.get(it0).get(jt0).getValue()>1){
	defend = defence(it0,jt0,this.color)
	if (defend=true && isThreat(it0,jt0,!this.color)==false){
	
	}
	}
	}
	}

	for (int it1 =0; it1< super.chessBoard.size();it1++){
		for (int jt1=0;jt1<super.chessBoard.get(it1).size();jt1++){
			if (super.chessBoard.get(it1).get(jt1)!=null&&super.chessBoard.get(it1).get(jt1).getW()==this.color){
				for (int it2=0; it2<super.chessBoard.size();it2++){
					for (int jt2=0; jt2<super.chessBoard.get(it2).size();jt2++){
						if ((super.chessBoard.get(it2).get(jt2)!=null)&&(super.chessBoard.get(it1).get(jt1).canMove(it2,jt2))&&(super.chessBoard.get(it2).get(jt2).getW()!=this.color)&&(super.isCheck(isGoingToBeInCheck(it1,jt1,it2,jt2))==false||super.whichKing!=this.color)&&(super.chessBoard.get(it2).get(jt2).getValue()>pieceValue)&&(it1!=it2||jt1!=jt2)){
                            threat=isThreat(it2,jt2,this.color);
                            if (threat==false||super.chessBoard.get(it1).get(jt1).getValue()<=super.chessBoard.get(it2).get(jt2).getValue()){
							move=this.toString(it1,jt1,it2,jt2);
							pieceValue=super.chessBoard.get(it2).get(jt2).getValue();
							System.out.println("here"+" "+threat+" "+super.chessBoard.get(it1).get(jt1).getValue()+" "+super.chessBoard.get(it2).get(jt2).getValue());
							}
						}}}}}}

	if (pieceValue==0){	//advances pawns starting with central pawns if it cant take anything
	  if (Game.turn<=6){
	 // System.out.println("here");
	  //System.out.println(Game.turn);
      if (Game.turn==1||Game.turn==2){
      move=pawnMove();
      counter+=1;
      }
     else{
     //System.out.println("here");
     if (rand==1){
     //System.out.println("here");
     move=pawnMove();
     counter+=1;
     }
     else if (rand==2){
     move=knightMove();
     //System.out.println("here");
     counter+=1;
     }}
      }
      else{
		for (int it3 =0; it3< super.chessBoard.size();it3++){
		for (int jt3=0;jt3<super.chessBoard.get(it3).size();jt3++){
		if (super.chessBoard.get(it3).get(jt3)!=null&&super.chessBoard.get(it3).get(jt3).getW()==this.color&&super.chessBoard.get(it3).get(jt3).getP()=='P'){
			if (super.chessBoard.get(it3).get(jt3).getX()==3||super.chessBoard.get(it3).get(jt3).getX()==4){
				for (int kk=0;kk<8;kk++){
					for (int ll=0;ll<8;ll++){
						if (super.chessBoard.get(it3).get(jt3).canMove(kk,ll)&&(super.isCheck(isGoingToBeInCheck(it3,jt3,kk,ll))==false||super.whichKing!=this.color)&&(it3!=kk||jt3!=ll)){
							move=this.toString(it3,jt3,kk,ll);
							counter+=1;
							break;
						}}}
			if (counter==0&&(super.chessBoard.get(it3).get(jt3).getX()==2||super.chessBoard.get(it3).get(jt3).getX()==5)){
				for (int kkk=0;kkk<8;kkk++){
					for (int lll=0;lll<8;lll++){
						if (super.chessBoard.get(it3).get(jt3).canMove(kkk,lll)&&(super.isCheck(isGoingToBeInCheck(it3,jt3,kkk,lll))==false||super.whichKing!=this.color)&&(it3!=kkk||jt3!=lll)){
							move=this.toString(it3,jt3,kkk,lll);
							//System.out.println(Game.player+","+move);
							counter+=1;
							break;
				}}}}}}}}}}
	 if ((pieceValue==0)&&counter==0){//if it can't advance it's pawns it makes the first legal move
		for (int ii=0; ii< super.chessBoard.size();ii++){
			for (int jj=0;jj<super.chessBoard.get(ii).size();jj++){
				if (super.chessBoard.get(ii).get(jj)!=null&&super.chessBoard.get(ii).get(jj).getW()==this.color){
					for (int k4=0;k4<8;k4++){
					for (int l4=0;l4<8;l4++){
						if (super.chessBoard.get(ii).get(jj).canMove(k4,l4)&&(super.isCheck(isGoingToBeInCheck(ii,jj,k4,l4))==false||super.whichKing!=this.color)&&(ii!=k4||jj!=l4)){
							move=this.toString(ii,jj,k4,l4);
							break;
							}}}}}}}}
	System.out.println("Player: "+Game.player+" Move: "+move+" Turn: "+Game.turn);
	return move;
	}
public String pawnMove(){
String movePawn="";
int count=0;
for (int i=0;i<super.chessBoard.size();i++){
for (int j=0;j<super.chessBoard.get(i).size();j++){
if (super.chessBoard.get(i).get(j)!=null&&super.chessBoard.get(i).get(j).getW()==this.color&&super.chessBoard.get(i).get(j).getP()=='P'){
  for (int k=0;k<super.chessBoard.size();k++){
  for (int l=0;l<super.chessBoard.get(k).size();l++){
  if (super.chessBoard.get(i).get(j).canMove(k,l)&&(super.chessBoard.get(i).get(j).getX()==3||super.chessBoard.get(i).get(j).getX()==4)&&(l==super.chessBoard.get(i).get(j).getY()+2||l==super.chessBoard.get(i).get(j).getY()-2)){
    movePawn=this.toString(i,j,k,l);
    count+=1;
    // break;
  }
 // else if (super.chessBoard.get(i).get(j).canMove(k,l)&&count==0){
 // movePawn=this.toString(i,j,k,l);
 // }
  }
  
  }
  }
}
}
if (count==0){
for (int ii=0;ii<super.chessBoard.size();ii++){
for (int jj=0;jj<super.chessBoard.get(ii).size();jj++){
if (super.chessBoard.get(ii).get(jj)!=null&&super.chessBoard.get(ii).get(jj).getW()==this.color&&super.chessBoard.get(ii).get(jj).getP()=='P'){
for (int kk=0;kk<super.chessBoard.size();kk++){
  for (int ll=0;ll<super.chessBoard.get(kk).size();ll++){
    if (super.chessBoard.get(ii).get(jj).canMove(kk,ll)&&count==0){
        movePawn=this.toString(ii,jj,kk,ll);
    }
  
  }}

}}
}}
return movePawn;
}

public String knightMove(){
String moveKnight="";
for (int i=0;i<super.chessBoard.size();i++){
for (int j=0;j<super.chessBoard.get(i).size();j++){
if (super.chessBoard.get(i).get(j)!=null&&super.chessBoard.get(i).get(j).getW()==this.color&&super.chessBoard.get(i).get(j).getP()=='N'){
  for (int k=0;k<super.chessBoard.size();k++){
  for (int l=0;l<super.chessBoard.get(k).size();l++){
  if (super.chessBoard.get(i).get(j).canMove(k,l)){
    moveKnight=this.toString(i,j,k,l);
    break;
  }

  }
  
  }
  }
}
}
return moveKnight;
}
//this method will take in a position on the chessboard and will return true if any member of the opposite team can move to said location on the chessboard
//and false otherwise
public boolean isThreat(int newX, int newY, boolean color){
boolean threat=false;
for (int i=0;i<super.chessBoard.size();i++){
for (int j=0; j< super.chessBoard.get(i).size();j++){
if (super.chessBoard.get(i).get(j)!=null && super.chessBoard.get(i).get(j).getW()!=color&&super.chessBoard.get(i).get(j).canMove(newX,newY)){
threat=true;
}
else if (super.chessBoard.get(i).get(j)!=null&&super.chessBoard.get(i).get(j).getW()!=color&&super.chessBoard.get(i).get(j).getP()=='P'){

  if ((super.chessBoard.get(i).get(j).getX()==newX+1||super.chessBoard.get(i).get(j).getX()==newX-1)){
  if (this.color == true){
  if (super.chessBoard.get(i).get(j).getY()==newY-1){
  threat=true;
  }
  }
  else{
  if (super.chessBoard.get(i).get(j).getY()==newY+1){
  threat=true;
  }
} 
  }
}
}

}
return threat;
}

//method bellow will return true if there is a player on the other team that is of lesser value threatening one of our players that we cant
// take back check if any player of his color  is threatened by a piece of lesser value and we cant take it if it takes us

public boolean defence(int currX, int currY, boolean color){
boolean defend = false;
for (int i =0; i< super.chessBoard.size();i++){
for (int j =0; j< super.chessBoard.get(i).size();j++){
if (super.chessBoard.get(i).get(j)!=null && super.chessBoard.get(i).get(j).getW()!=color&&(super.chessBoard.get(i).get(j).getValue()<super.chessBoard.get(currX).get(currY).getValue())&&super.chessBoard.get(i).get(j).canMove(currX,currY)){
defend = true;
}
}
}
return defend;

}
//the following method will take in a location on the chessboard and return any move that the player at said location can move where isThreat is false.
public String moveAnywhereSafe (int currX, int currY, boolean color){
String moveAny = " ";
int count = 0;
for (int i=0;i<super.chessBoard.size();i++){
for (int j=0; j< super.chessBoard.get(i).size();j++){
//first if will check if there is any aggressive move that the piece can make, that is is there any player of higher value that it could take without putting itself in danger
if (super.chessBoard.get(currX).get(currY).canMove(i,j)&& (isThreat(i,j,color)==false||(super.chessBoard.get(i).get(j)!=null&&super.chessBoard.get(currX).get(currY).getValue()<=super.chessBoard.get(i).get(j).getValue()))){
moveAny=this.toString(currX,currY,i,j);
count+=1;
}}}
return moveAny;
}
 
public String aggressiveMove(int currX, int currY, boolean color){
String move = " ";
for (int i=0;i<super.chessBoard.size();i++){
for (int j=0; j< super.chessBoard.get(i).size();j++){
if 
}}


}

public String toString(int i, int j, int k , int l){//converts the x and y coordinates of the move to a string that the AI will pass to the game
	char x1='A';
	char x2='A';
		if (i==0){x1='A';}
			else if (i==1){x1='B';}
			else if (i==2){x1='C';}
			else if (i==3){x1='D';}
			else if (i==4){x1='E';}
			else if (i==5){x1='F';}
			else if (i==6){x1='G';}
			else if (i==7){x1='H';}
			if (k==0){x2='A';}
			else if (k==1){x2='B';}
			else if (k==2){x2='C';}
			else if (k==3){x2='D';}
			else if (k==4){x2='E';}
			else if (k==5){x2='F';}
			else if (k==6){x2='G';}
			else if (k==7){x2='H';}

	return x1+Integer.toString(7-j)+','+x2+Integer.toString(7-l);
	}

}
