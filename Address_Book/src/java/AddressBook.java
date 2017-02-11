import java.io.*;
import java.util.*;
import java.io.IOException;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nathasha
 */

//Logic for your address book
public class AddressBook {
    
private static Map<String, List<String>> map;    
    //read from file and create Address Book
    public static void initAddressBook(String fileName) throws IOException{
         map = new HashMap<>();
        try{
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        
        
        List<String> arraylist = new ArrayList<>();
        String[] temp = new String[2];
		String[] array;

		String line;

		while((line = br.readLine()) != null){

			temp = line.split(",",2);   //split into two Strings
			array = temp[1].split(",");  //Split second string,
			arraylist = Arrays.asList(array);  //put array into arraylist
			map.put(temp[0],arraylist);
		}

		br.close();
                
                
        }catch (java.io.FileNotFoundException e) {
            System.out.println("The file not found");

	} 
    }
    
    //search details of the requested contact in the address book
    public static List<String> search(String name ){
	List<String> list = new ArrayList<>();
        try{
            list = map.get(name);
        }catch(NullPointerException e){
                //.println("There is no person called '"+name+"' in Phone Book!");
        }
        
        return list;
    }
    
}


