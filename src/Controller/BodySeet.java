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
public class BodySeet implements Command {
    
    
    private AllCommandInvoker invoker;
    
    public BodySeet(AllCommandInvoker invoker) {
        this.invoker = invoker;
    }

    @Override
    public boolean execute() {
        return invoker.body();
    }
    
}
