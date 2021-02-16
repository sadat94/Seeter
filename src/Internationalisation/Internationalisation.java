/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Internationalisation;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author ss15adx Sadat Safuan
 */
public class Internationalisation {
        
    private static final String RESOURCE_PATH = "Internationalisation/MessageBundle";
   
    private final ResourceBundle strings;
   
    public Locale locale;
    
    
    
    public String welcome;
    public String username;
    public String note;
    public String example;
    public String unrecognised;
    public String hello;
    public String user_notset;
    public String enter_command;
    public String fetch;
    public String compose;
    public String exit;
    public String drafting;
    public String drafting_enter_command;
    public String body;
    public String send;
    public String fetched;
    public String no_command_found;
    
             
        
   
    public Internationalisation(){
      
      strings = ResourceBundle.getBundle(RESOURCE_PATH, new Locale("en", "GB"));
      
      initialiseInternationalisation();
    }
  
    
    
    /**
     * set up internationalisation
     */
    public void initialiseInternationalisation() {
        
        welcome =                strings.getString("welcome");
        username =               strings.getString("username");
        note =                   strings.getString("note");
        example =                strings.getString("example");
        unrecognised =           strings.getString("unrecognised");
        hello =                  strings.getString("hello");
        user_notset =            strings.getString("user_notset");
        enter_command =          strings.getString("enter_command");
        fetch =                  strings.getString("fetch");
        compose =                strings.getString("compose");
        exit =                   strings.getString("exit");
        drafting =               strings.getString("drafting");
        drafting_enter_command = strings.getString("drafting_enter_command");
        body =                   strings.getString("body");
        send =                   strings.getString("send");
        fetched =                strings.getString("fetched");
        no_command_found =       strings.getString("no_command_found");        
    }
  
}