/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author ss15a
 */
public class SendSeet implements Command {
    
    private final AllCommandImplementer implementer;
    
    public SendSeet(AllCommandImplementer implementer) {
        this.implementer = implementer;
    }

    @Override //Command
    public boolean execute() {
        return implementer.send();
    }
    
}
