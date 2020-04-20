/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Internationalisation;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author ss15a
 */
public class Internationalisation {
    
    private String language ;
    private String country ;
    
    private static final String RESOURCE_PATH = "resources/MessageBundle";
    private ResourceBundle strings;
    public Locale locale;
//  public ResourceBundle strings;
    
    public String welcome;
    
    
    
    
    public String description;
    public String help;
    public String current;
    public String filters;
    public String farewell;
    public String unknown;
    public String fotoshop;
    public String explain;
    public String cannot;
    public String cwd;
    public String open;
    public String loaded;
    public String save;
    public String saved;
    public String exceeded;
    public String find;
    public String script;
    public String panic;
    public String quite;
    public String file;
    public String nme;
    public String noimg;
    public String load;
    public String hlp;
    public String save_prompt;
    public String save_prompt2;
    public String cache_amount;
    public String cache_added;
    public String filter;
    public String on_file;
    public String is_undone;
    public String cache_empty;
    public String cache_cleared;
    public String ug_line1;
    public String ug_line2;
    public String ug_line3;
    public String ug_line4;
    public String ug_line5;
    public String ug_line6;
    public String ug_line7;
    public String ug_line8;
    public String ug_line9;
    public String ug_line10;
    public String ug_line11;
    public String ug_line12;
    public String ug_line13;
    
    
    public static void main(String[] args) throws IOException {
        
      //  new Internationalisation().initialiseInternationalisation();   
    }
        
   
    public Internationalisation(){
        
        English();
        Italian();
    }
  
    /**
     * set the resource bundle 
     */
    public void ResourceBundleSetup() {
        
         strings = ResourceBundle.getBundle(RESOURCE_PATH, new Locale("en", "GB"));   
    }
    
    
    /**
     * set up Internationalisation
     */
    public void initialiseInternationalisation() {
        
        welcome = strings.getString("welcome");
        username = strings.getString("username");
        
        
        
        
        description = strings.getString("description");
        help = strings.getString("help");
        current = strings.getString("current");
        filters = strings.getString("filters");
        farewell = strings.getString("farewell");
        unknown = strings.getString("unknown");
        fotoshop = strings.getString("fotoshop");
        explain = strings.getString("explain");
        cannot = strings.getString("cannot");
        cwd = strings.getString("cwd");
        open = strings.getString("open");
        loaded = strings.getString("loaded");
        save = strings.getString("save");
        saved = strings.getString("saved");
        exceeded = strings.getString("exceeded");
        find = strings.getString("find");
        script = strings.getString("script");
        panic = strings.getString("panic");
        file = strings.getString("file");
        nme = strings.getString("nme");
        noimg = strings.getString("noimg");
        load = strings.getString("load");
        hlp = strings.getString("hlp");
        quite = strings.getString("quit");
        save_prompt = strings.getString("save_prompt");
        save_prompt2 = strings.getString("save_prompt2");
        cache_amount = strings.getString("cache_amount");
        cache_added = strings.getString("cache_added");
        filter = strings.getString("filter");   
        on_file = strings.getString("on_file");
        is_undone = strings.getString("is_undone");
        cache_empty = strings.getString("cache_empty");
        cache_cleared = strings.getString("cache_cleared");
        ug_line1 = strings.getString("ug_line1");
        ug_line2 = strings.getString("ug_line2");
        ug_line3 = strings.getString("ug_line3");
        ug_line4 = strings.getString("ug_line4");
        ug_line5 = strings.getString("ug_line5");
        ug_line6 = strings.getString("ug_line6");
        ug_line7 = strings.getString("ug_line7");
        ug_line8 = strings.getString("ug_line8");
        ug_line9 = strings.getString("ug_line9");
        ug_line10 = strings.getString("ug_line10");
        ug_line11 = strings.getString("ug_line11");
        ug_line12 = strings.getString("ug_line12");
        ug_line13 = strings.getString("ug_line13");
    }

    
    
    /**
     * English setup
     */
    public void English() {
    ResourceBundleSetup();
    Locale.setDefault(Locale.UK);
    initialiseInternationalisation();
    }
    
    /**
     *Italian setup
     */
    public void Italian() {
    ResourceBundleSetup();    
    Locale.setDefault(Locale.ITALY);
    initialiseInternationalisation();
    }
    
    
    
    /**
     *Language setup
     */
    public void chooseLanguage() {
        
        Scanner scannerObject = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please choose your preferred language : ");
        System.out.println("1 English: Press 1");
        System.out.println("2 Italian: Press 2");
        
            int option = 0 ;       
            boolean test = false ;
            while(test==false){
                if(scannerObject.hasNextInt()){
                    option = scannerObject.nextInt();
                        if(option == 1) {
                            English();
                            test = true;
                            return;
                        } else if(option == 2) {
                            Italian();
                            test = true;
                        } else {
                            System.out.println("Please choose a number for the preferred language : 1 ,2 ,3 ");
                            test = false;
                            return;
                        }
                        
                    test = true;
                    return;
                } else if(!scannerObject.hasNextInt()){
                    System.out.println("Invalid input."+"\nPlease enter a number");
                    scannerObject.next();
                }    
            }

    }

}

    
    
    
    
    
    

