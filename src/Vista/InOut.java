/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;
import javax.swing.JOptionPane;


public class InOut {
    
    
    public int requestStr(String m){
    	return  Integer.parseInt( JOptionPane.showInputDialog(m));
    }
    
    
    public void showStr(String me){
        JOptionPane.showMessageDialog(null, me);
    }
    
    
    public int showMenu(){
        
String m="Menu de Opciones\n";
        
		m=m+"\n1.¿Cual sería el siguiente piso? \n";
        m=m+"2.¿Cual seía el piso anterior?\n";
        m=m+"3.¿Cuantos pisos puede atender el ascensor?\n";
        m=m+"4.Mover el Ascensor\n";
//        m=m+"5.Crear Nuevo Ascensor\n";
        m=m+"5.salir\n";
        
        return requestStr(m+"\nSelecione Opción");
    	
    }
    
    public int SolicitarPisos(){
        
    	String p="Nuevo Ascensor: Cuantos pisos?\n";
    	return requestStr(p);
    	    	
    	    }
    public int SolicitarSotanos(){
        
    	String s="Cuantos sotanos\n";
    	return requestStr(s);
    	    	
    	    }
    
}
