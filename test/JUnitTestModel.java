/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controller.AllCommandImplementer;
import Controller.Command;
import Controller.ComposeSeet;
import Model.SeetDraftDatabase;
import Model.SeetProgram;
import Model.User;
import Model.UserInput;
import View.Client;
import static com.sun.xml.internal.messaging.saaj.packaging.mime.util.ASCIIUtility.getBytes;
import java.io.ByteArrayInputStream;

//import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ss15adx Sadat Safuan
 */
public class JUnitTestModel {
    
    public JUnitTestModel() {
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
//     @Test
//     public void hello() throws IOException {
//     String input = "exit\n";
//     
//     InputStream IN = System.in;
//     
//     ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes("UTF-8"));
//        System.setIn(in);
//     
//     Client client = new Client();
//     client.set("userid", "localhost", 8080);
//     
//     client.run();
//     
//     System.setIn(IN);
//     
//     }
     
     @Test
     
     public void UserTest() {
        System.out.println("Methods in User class : ");
        
        User instance = new User("Sadat","localhost",8080);
        
        String  expResult1 = ("Sadat");
        String  expResult2 = ("localhost");
        int     expResult3 =  8888;
        
         
        
        instance.setName("Sadat");
        String result1 = instance.getName();
        System.out.println(result1);
        
        
        instance.setHost("localhost");
        String result2 = instance.getHost();
        System.out.println(result2);
        
        
        instance.setPort(8888);
        int result3 = instance.getPort();
        System.out.println(result3);
        
 
        
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        
    }
     
     @Test
     
     public void UserInputTest() throws IOException {
        System.out.println("Methods in UserInputTest class : ");
        
        UserInput instance = new UserInput("newInput");
        
        List processCommand = instance.processCommand();        
        
        String processW = instance.processWord(0);

        String processW2 = instance.processWord(1);

        
        String expResult1 = processW;
        String expResult2 = processW2;
        
       
       
        String result1 = instance.getFirstWord();
        System.out.println(result1);
        
        
        
        String result2 = instance.getSecondWord();
        System.out.println(result2);
        
        
        
        String result3 = instance.processWord(1);
        System.out.println(result3);
        
        
        
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        
        
    }
     
     
     @Test
     
     public void SeetProgramTest() {
        System.out.println("Methods in User class : ");
        
        String   expResult1 = ("Mercedes");
        String[] expResult2 = {"Messageexample"};
        
        SeetProgram instance = new SeetProgram (expResult1, expResult2);
         
        
        instance.setTitle("Mercedes");
        String result1 = instance.getTitle();
        System.out.println(result1);
        
        
        instance.setMessage(expResult2);
        String [] result2 = instance.getMessage();
        System.out.println(result2);
        
        
      
 
        
        assertEquals(expResult1, result1);
        Assert.assertArrayEquals(expResult2, result2);
       
        
    }
     
     @Test
     
     public void SeetDraftDatabaseTest() {
        System.out.println("Methods in SeetDraftDatabase class : ");
        
        SeetDraftDatabase instance = new SeetDraftDatabase();
        
        String         expResult1 = ("Audi");
        List <String>  expResult2 = new LinkedList<>();
      
         
        
        instance.setDraftTopic(expResult1);
        String result1 = instance.getDraftTopic();
        System.out.println(result1);
        
        
        instance.setDraftLines(expResult2);
        List <String> result2 = instance.getDraftLines();
        System.out.println(result2);
        
        
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
     
        
    }
     
     
     
     

        
        
        
       
       
  
      
         
        
           
      
       
     
}
