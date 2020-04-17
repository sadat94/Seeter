/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.User;
import Model.UserInput;
import View.CLFormatter;
import View.Client;
import View.Reader;
import java.io.IOException;

/**
 *
 * @author ss15a
 */
public class AllCommandImplementer {
    
    private Client client;
    private CLFormatter formatter;
    private User user;
    private Reader reader;
    private AllCommandInvoker invoker;
 

    public AllCommandImplementer (Client newClient) {
        client = newClient;
        reader = new Reader();
        setCLFormatter();
        invoker = new AllCommandInvoker(formatter, user);
    }

    private void setUser() {
        client.inputUser();
        String name = null;
        try {
            name = reader.getReader().readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        user = new User(name, "localhost", 8888);
    }

    public void setCLFormatter() {
        setUser();
        formatter = null;

        if (user.getName().isEmpty() || user.getHost().isEmpty()) {
            System.err.println("User/host has not been set.");
            System.exit(1);
        }

        formatter = new CLFormatter(user.getHost(),user.getPort());
    }

    public CLFormatter getFormatter() {
        return formatter;
    }
    
    boolean finished = false;
    boolean state = true;

    public void loop() {

        while (!finished) {

            try {
                invoker.menuPrinter(state);
                UserInput userCommand = reader.getCommand();
                state = invoker.processCommand(userCommand);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
   
    public User getUser() {
        return user;
    }  

    public AllCommandInvoker getInvoker() {
        return invoker;
    }
}
