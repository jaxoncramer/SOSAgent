package com.company;

import sun.management.resources.agent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;

/**
 * Created by jaxoncramer on 7/10/17.
 */
public class Agent {

    public Agent(Common common) {
        this.common = common;
    }

    private Common common;
    private Options options = new Options();
    private Controller controller = new Controller();
    private ArrayList<Integer> agentFDPool = new ArrayList<Integer>();
    private ArrayList<EventInfo> agentFDPoolEvent = new ArrayList<>();
    private HashMap<UUID, Client> clientHash = new LinkedHashMap<>();

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

    public Options getOptions() {
        return options;
    }

    public HashMap<UUID, Client> getClientHash() {
        return clientHash;
    }

    public void initAgent() {
        for(int i = 0; i < common.getMAX_AGENT_CONNECTIONS(); i++) {
            getAgentFDPool().add(common.EMPTY);
        }
        getController().initControllerListener(this);

    }

    //from original: connect_host_side()
    public void connectToHost() {

    }

    //from original: connect_agent_side()
    public void connectToAgent() {

    }

    //from original: handle_host_side_connect()
    public void handleHostConnection() {
        Client newClient = initializeClient();
        if(newClient != null) {
            acceptHostConnection(this, newClient);
        }
    }

    //from original: accept_host_side()
    public void acceptHostConnection(Agent agent, Client client) {

    }

    //from original: accept_agent_side()
    public void acceptAgentConnection() {

    }

    //from original: handle_host_connected()
    public void hostConnected() {

    }

    //from original: agent_connected_event()
    public void agentConnected() {

    }

    //from original: get_uuid_and_confirm_client()
    public void confirmClient() {

    }

    private Client initializeClient() {

        Client newClient = new Client();

        newClient.setBufferedPacketTable(null);
        newClient.setAllowedConnections(0);

        newClient.setRecvSeq(0);
        newClient.setSendSeq(0);
        newClient.setNumParallelConnections(0);
        //TODO change Options to be initialized from command line
        newClient.setAgentFDPoll(new char[getOptions().getNumParallelConnections()]);

        newClient.setUuid(UUID.randomUUID());
        clientHash.put(newClient.getUuid(), newClient);

        return newClient;
    }
}
