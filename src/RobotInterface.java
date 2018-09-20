import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class RobotInterface {
      ArrayList<Dish> dishlist = new ArrayList<Dish>();
      ArrayList<Dish> dishlist1 = new ArrayList<Dish>();
      ArrayList<String> jokelist = new ArrayList<String>();
      ArrayList<String> farelist = new ArrayList<String>();
      String filename;
     
      int option;
      BufferedReader breader;
      BufferedReader breader1;
      BufferedReader jreader;
      BufferedReader freader;
      
      /**
       * conductor with param
       * @param a
       */
      public RobotInterface(int a){
    	  this.option = a;
      }
      /**
       * conductor without param
       */
      public RobotInterface(){
    	 
      }
      /**
       * read data from the file
       */
      public void load(){
    	  if(option == 1){
    		  filename = "../File/fish.txt";
    	  }
    	  if(option == 2){
    		  filename = "../File/meat.txt";
    	  }
    	  if(option == 3){
    		  filename = "../File/rice.txt";
    	  }
    	  if(option == 4){
    		  filename = "../File/noddle.txt";
    	  }
    	  if(option == 5){
    		  filename = "../File/drink.txt";
    	  }
    	  try{
    	  File file = new File(filename);
    	  breader = new BufferedReader(new FileReader(file));
    	  
    	 
    	  String line = null;
    	  while((line = breader.readLine())!= null){
    		  Dish dish = new Dish();
    	 	  String item[] = line.split(",");
    		  dish.setDname(item[0]);
    		  dish.setSurpuls(Integer.parseInt(item[1]));
    		  dish.setPrice(Integer.parseInt(item[2]));	
    		  
    		  dishlist.add(dish);
    	  }
    	  }catch(Exception ex){
    		  ex.printStackTrace();
    	  }
    	  
      }
      /**
       * save data to the file
       * @param s
       * @param o
       */
      public void save(int s,int o){
    	  if(option == 1){
    		  filename = "../File/fish.txt";
    	  }
    	  if(option == 2){
    		  filename = "../File/meat.txt";
    	  }
    	  if(option == 3){
    		  filename = "../File/rice.txt";
    	  }
    	  if(option == 4){
    		  filename = "../File/noddle.txt";
    	  }
    	  if(option == 5){
    		  filename = "../File/drink.txt";
    	  }
    	  try{
        	  File file1 = new File(filename);
        	  breader1 = new BufferedReader(new FileReader(file1));
        	  
        	 
        	  String line = null;
        	  while((line = breader1.readLine())!= null){
        		  Dish dish1 = new Dish();
        	 	  String item[] = line.split(",");
        		  dish1.setDname(item[0]);
        		  dish1.setSurpuls(Integer.parseInt(item[1]));
        		  dish1.setPrice(Integer.parseInt(item[2]));	
        		  
        		  dishlist1.add(dish1);
        	  }
        	  }catch(Exception ex){
        		  ex.printStackTrace();
        	  }
    	     dishlist1.get(o).setSurpuls(s);
    	    try{
    	    	//FileWriter writer = new FileWriter(filename);
    	    	BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false)); 
    	    	for(int i = 0;i<dishlist1.size();i++){
    	    	writer.write(dishlist1.get(i).getDname()+","+dishlist1.get(i).getSurpuls()+","+dishlist1.get(i).getPrice());
    	    	writer.newLine();
    	       }
    	    	writer.close();
    	    }catch(Exception ex){
    	    	ex.printStackTrace();
    	    }
    	  
      }
      /**
       * read jokes from the file
       */
      public void loadjoke(){
    	  
    	  try{
    	  File joke = new File("../File/jokes.txt");
    	  jreader = new BufferedReader(new FileReader(joke));
    	  String line = null;
    	  while((line = jreader.readLine())!=null){
  			jokelist.add(line);
  		    }
    	  }catch(Exception ex){
    		  ex.printStackTrace();
    	  }
      }
      /**
       * read farewell from the file
       */
      public void loadfarewell(){
    	  try{
        	  File farewell = new File("../File/farewell.txt");
        	  freader = new BufferedReader(new FileReader(farewell));
        	  String line = null;
        	  while((line = freader.readLine())!=null){
      			farelist.add(line);
      		    }
        	  }catch(Exception ex){
        		  ex.printStackTrace();
        	  }
      }
}
