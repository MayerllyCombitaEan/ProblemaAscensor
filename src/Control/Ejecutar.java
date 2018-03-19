/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import Modelo.Ascensor;
import Vista.InOut;
/**
 *
 * @author user
 */
public class Ejecutar {
	
	public static void main(String args[]){
		InOut io = new InOut();
		int pisos = io.SolicitarPisos(); 	
		int sotanos = io.SolicitarSotanos();
		
		Ascensor a = new Ascensor(pisos, sotanos);
		
		int op;
		a.BackMenu();
		
		
	}
	
    
}
