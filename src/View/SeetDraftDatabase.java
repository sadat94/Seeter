/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ss15a
 */
public class SeetDraftDatabase {
    
     private String draftTopic;
    private List<String> draftLines = new LinkedList<>();

    public SeetDraftDatabase() {};

    public String getDraftTopic() {
        return draftTopic;
    }

    public void setDraftTopic(String draftTopic) {
        this.draftTopic = draftTopic;
    }

    public List<String> getDraftLines() {
        return draftLines;
    }

    public void setDraftLines(List<String> draftLines) {
        this.draftLines = draftLines;
    }
    
}
