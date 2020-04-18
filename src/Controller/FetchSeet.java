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
public class FetchSeet implements Command{
    private AllCommandImplementer implementer;
    
     public FetchSeet(AllCommandImplementer implementer) {
        this.implementer = implementer;
    }
    
    @Override
    public boolean execute() {
        return implementer.fetch();
    }
    
}
