package model;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class MainProgram {

	public static void main(String[] args) {
//		Locale locale = new Locale("de", "De");
		Locale locale = new Locale("no", "NO");
//		Locale locale = new Locale("en", "GB");
		//;)
		boolean forsett = true;
		Store butikk = new Store(locale);
		ResourceBundle apptexts = ResourceBundle.getBundle("apptexts", locale);
		
		while (forsett){
		System.out.print(apptexts.getString("choice"));
		Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        	if(i == 1){
    		System.out.print(apptexts.getString("fruits"));
            int j = input.nextInt();
            	if(j == 1){
            		butikk.addItem(new Item("Apple", 400.1));
            		System.out.println();
            	}else if(j == 2){
            		butikk.addItem(new Item("Banana", 360.1));
            		System.out.println();
            	}else if(j == 3){
            		butikk.addItem(new Item("Pineapple", 70.1));
            		System.out.println();
            	}else if(j == 4){
            		butikk.addItem(new Item("SuperPineapple", 30.1));
            		System.out.println();
            	}else{
            		
            	}
    		
    		
        	}else if(i == 2){
        	butikk.getItems();
        	
        	}else{
        		forsett = false;
        	}
		}
	}

}
