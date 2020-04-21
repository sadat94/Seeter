/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Internationalisation.Internationalisation;
import Model.SeetProgram;
import Model.User;
import Model.UserInput;
import View.CLFormatter;
import View.Client;
import View.Reader;
import Model.SeetDraftDatabase;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import sep.seeter.net.channel.ClientChannel;
import sep.seeter.net.message.Publish;
import sep.seeter.net.message.SeetsReply;
import sep.seeter.net.message.SeetsReq;

/**
 *
 * @author ss15adx Sadat Safuan
 */
public class AllCommandImplementer {
    
    private final Client client;
    private CLFormatter formatter;
    private User user;
    private final Reader reader;
    private final AllCommandInvoker invoker;
    private SeetProgram seet;
    private final SeetDraftDatabase seetDatabase;
    private static Internationalisation internationalise;
 

    public AllCommandImplementer (Client newClient) {
        
        client = newClient;
        seetDatabase = new SeetDraftDatabase();
        reader = new Reader();
        setCLFormatter();
        invoker = new AllCommandInvoker(this);
        this.internationalise = new Internationalisation();
        
    } 
    
    public void menuPrinter(Boolean state) { 
        if(state == true){
            System.out.print(CLFormatter.formatMainMenuPrompt());
        }else if(state == false){
            System.out.println(CLFormatter.formatDraftingMenuPrompt(seetDatabase.getDraftTopic(),seetDatabase.getDraftLines()));
        }
    }
  
    public boolean fetch() throws IOException, ClassNotFoundException {
        
        ClientChannel clientChannel = formatter.getChan();
        clientChannel.send(new SeetsReq(seet.getTitle()));
        SeetsReply rep = null;
        rep = (SeetsReply) clientChannel.receive();
        System.out.print(CLFormatter.formatFetched(seet.getTitle(), rep.users, rep.lines));

        return true;
    }

    public boolean compose() {
        seetDatabase.setDraftTopic(seet.getTitle());
        return false;
    }

    
    // true = Main, false = Drafting 
    public boolean body() {
        String line = Arrays.stream(seet.getMessage()).collect(Collectors.joining());
        seetDatabase.getDraftLines().add(line);

        return false;
    }

    public boolean send() throws IOException {

        String draftTopic = seetDatabase.getDraftTopic();
        String userId = user.getName();
        List<String> msgList = seetDatabase.getDraftLines();
        formatter.getChan().send(new Publish(userId, draftTopic, msgList));
        

        seetDatabase.setDraftTopic(null);
        return true;
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
            System.err.println(internationalise.user_notset);
            System.exit(1);
        }

        formatter = new CLFormatter(user.getHost(),user.getPort());
    }

    public CLFormatter getFormatter() {
        return formatter;
    }
    
    boolean finished = false;
    boolean state = true;


   
    public User getUser() {
        return user;
    }  

    public AllCommandInvoker getInvoker() {
        return invoker;
    }
    
    public boolean processCommand(UserInput command) throws IOException{
        
        String commandWord = command.getFirstWord();
        String secondWord = command.getSecondWord();
        String [] message = command.getMessageWord();
        
        
        if(commandWord.equals("exit")) {
            System.exit(0);
        }
        
        if(!invoker.getAllCommandsMap().containsKey(commandWord)) {
            System.out.println(internationalise.unrecognised);
            return true;
        }
        
        seet = new SeetProgram(secondWord, message);
        
        return invoker.runCommands(commandWord);
    }

    public Reader getReader() {
        return reader;
    }
    
    
}
