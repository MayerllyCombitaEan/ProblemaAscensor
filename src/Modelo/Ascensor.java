package Modelo;

import Vista.InOut;

import java.util.Vector;

import com.sun.org.apache.bcel.internal.generic.CASTORE;

public class Ascensor {
	
	private int levels;
	private int basements;
	private int totalLevels;
	private int ground;
	private int currentFloor;
	Vector <Integer> vectorAsc;
	
    InOut io=new InOut();
    
    public Ascensor(int levels, int basements){
    	
    	setLevels(levels);
    	setBasements(basements);
    	this.totalLevels = levels+basements;
    	vectorAsc = new Vector(totalLevels);
    	addBasements();
    	addLevels();
    	setCurrentFloor(1);
    }
    
//    public void newLift(){
//    	setLevels(io.SolicitarPisos());
//		setBasements(io.SolicitarSotanos());
//		currentFloor = 1;
//    }
    
    public void addBasements(){
    	
    	int b = getBasements();
    	while(b < 0){
    		vectorAsc.add(b);
    		b++;
    	};
    	
    }
    public void addLevels(){
    	int le = getLevels();
    	int n = 1;
    	for(int i = this.basements; i < (le+this.basements);i++){
    		vectorAsc.add(n);
    		n++;
    	}
    }
    public void setUpFloor(){
    	for(int i=0;i<vectorAsc.size();i++){
    		if(vectorAsc.elementAt(i)==1)
    			setGround(i);
    	}
    }

    public void moveLift(int up){
    	if(up >= getBasements() && up <= getLevels() && up != 0)
    		setCurrentFloor(up);
    	else
    		io.showStr("El numero no permitido pues sobre pasa el rango de pisos del edificio."
    				+ "\n (tampoco puede ser 0)");
    }

    public int nextFloor(){
    	int nxFloor = 0;
    	if(currentFloor == -1)
    		nxFloor = currentFloor + 2;
    	else
    		nxFloor = currentFloor + 1;
    	return nxFloor;
    }
    public int previousFloor(){
    	int prFloor = 0;
    	if(currentFloor == 1)
        	prFloor = currentFloor - 2;
    	else
    		prFloor = currentFloor - 1;
    	return prFloor;
    	
    }
    
    public int liftSupoort(){
    	return vectorAsc.size();
    }
    public boolean firstLevel(){
    	boolean fl = false;
    	if(getCurrentFloor() == vectorAsc.elementAt(0))
    	fl = true;
    	return fl;
    	
    }
    public boolean lastLevel(){
    	boolean ll = false;
    	if(getCurrentFloor() == vectorAsc.elementAt(totalLevels -1))
//    		/this.levels-1
    	ll = true;
    	return ll;
    	
    }

    public void BackMenu(){
        int op;
        do{
            
          op=io.showMenu();
          executeMenu(op);
        }while(op!=5);
    }
    
    public void executeMenu(int op){
        switch(op){
            case 1: 
            	if(lastLevel()==false)
            		io.showStr(Integer.toString(nextFloor()));
            	else 
            		io.showStr("Ya se encuentra en el piso mas alto");
            	break;
            case 2:
            	if(firstLevel()==false)
            		io.showStr(Integer.toString(previousFloor()));
            	else 
            		io.showStr("Ya se encuentra en el piso mas bajo");
            	
            	break;
            case 3: io.showStr(Integer.toString(liftSupoort()));break;
            case 4: moveLift(io.requestStr("¿A que piso quiere ir?"));break;
//            case 5: newLift();break;
            case 5: System.exit(0);
    }
    
    
 }   

		public int getLevels() {
			return levels;
		}

		public void setLevels(int levels) {
			this.levels = levels;
		}

		public int getBasements() {
			return basements;
		}

		public void setBasements(int basements) {
			this.basements = basements*(-1);
		}
        
        public int getGround(){
        	return ground;
        }
		
		public void setGround(int ground){
        	this.ground = ground;
        }
		
		public int getCurrentFloor(){
			return this.currentFloor;
		}
		public void setCurrentFloor(int currentFloor){
			this.currentFloor = currentFloor;
		}
        
    }
 
