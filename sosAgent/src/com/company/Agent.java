package com.company;

import java.util.ArrayList;

/**
 * Created by jaxoncramer on 7/10/17.
 */
public class Agent {

    public Agent(Common common) {
        this.common = common;
    }

    private Common common;
    private Controller controller = new Controller();
    private ArrayList<Integer> agentFDPool = new ArrayList<Integer>();
    private ArrayList<EventInfo> agentFDPoolEvent = new ArrayList<>();

    //GETTERS
    public Controller getController() {
        return controller;
    }

    public ArrayList<EventInfo> getAgentFDPoolEvent() {
        return agentFDPoolEvent;
    }

    public ArrayList<Integer> getAgentFDPool() {
        return agentFDPool;
    }
}
