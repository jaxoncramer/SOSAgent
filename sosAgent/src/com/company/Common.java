package com.company;

/**
 * Created by jaxoncramer on 7/10/17.
 */
public class Common {

    public int EMPTY = -1;

    public enum PollEventTypes {

        HOST_SIDE_CONNECT,
        AGENT_SIDE_CONNECT,
        HOST_CONNECTED,
        AGENT_CONNECTED,
        AGENT_CONNECTED_UUID,
        HOST_SIDE_DATA,
        AGENT_SIDE_DATA,
        CONTROLLER_MESSAGE
    }

    private int CONTROLLER_MSG_PORT = 9998;
    private int MAX_AGENT_CONNECTIONS = 1000;


    //GETTERS
    public int getCONTROLLER_MSG_PORT() {
        return CONTROLLER_MSG_PORT;
    }

    public int getMAX_AGENT_CONNECTIONS() {
        return MAX_AGENT_CONNECTIONS;
    }
}
