/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.State;

/**
 *
 * @author ss15a
 */
public interface Command {
    
    State execute();
    
}
