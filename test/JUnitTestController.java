/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controller.AllCommandImplementer;
import Model.User;
import View.CLFormatter;
import View.Client;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ss15a
 */
public class JUnitTestController {
    
    public JUnitTestController() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void AllCommandImplementerTest() throws IOException, ClassNotFoundException {
          
        System.out.println("Methods in User class : ");
        
        User userTest = new User("Sadat", "localhost", 8080);
       
        Client client = new Client();
        
        Client test = client;
        
        CLFormatter clFormatterTest = new CLFormatter(userTest.getHost(), userTest.getPort());
        
        AllCommandImplementer instance = new AllCommandImplementer(test);
        
        
        
        Boolean     expResult1 = (true);
        Boolean     expResult2 = (false);
        Boolean     expResult3 = (false);
        Boolean     expResult4 = (true);
        
      //Boolean expResult 5 = runComands.commandWord()   
        
      //User expResultUser = new User("Safuan", "localhost", 8080);
      
        User        expResult5 = userTest;
        CLFormatter expResult6 = clFormatterTest;
        
      
        Boolean result1 = instance.fetch();
        System.out.println(result1);
        
        
     
        Boolean result2 = instance.compose();
        System.out.println(result2);
        
        
     
        Boolean result3 = instance.body();
        System.out.println(result3);
        
 
        Boolean result4 = instance.send();
        System.out.println(result4);
        
       
            
        instance.setUser();
        User result5 = instance.getUser();
        System.out.println(result5);
        
                
        instance.setCLFormatter();
        CLFormatter result6 = instance.getFormatter();
        System.out.println(result6);
        
        
        
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
        assertEquals(expResult5, result5);
        assertEquals(expResult6, result6);
     
     
     
     }
}
