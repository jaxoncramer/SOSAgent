package com.company;

import java.util.Hashtable;
import java.util.UUID;

public class TransferRequest {
    private String type;
    private UUID id;
    private String sourceIP;
    private int sourcePort; //should be unsigned short
    private String agentIP;
    private int agentPort; //should be unsigned short
    private int allowedConnections; //should be unsigned short
    private int bufferSize;
    private int queueSize;
    private Hashtable hh;

    //GETTERS
    public String getType() {
        return type;
    }

    public UUID getId() {
        return id;
    }

    public String getSourceIP() {
        return sourceIP;
    }

    public int getSourcePort() {
        return sourcePort;
    }

    public String getAgentIP() {
        return agentIP;
    }

    public int getAgentPort() {
        return agentPort;
    }

    public int getAllowedConnections() {
        return allowedConnections;
    }

    public int getBufferSize() {
        return bufferSize;
    }

    public int getQueueSize() {
        return queueSize;
    }

    //SETTERS
    public void setType(String type) {
        this.type = type;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setSourceIP(String sourceIP) {
        this.sourceIP = sourceIP;
    }

    public void setSourcePort(int sourcePort) {
        this.sourcePort = sourcePort;
    }

    public void setAgentIP(String agentIP) {
        this.agentIP = agentIP;
    }

    public void setAgentPort(int agentPort) {
        this.agentPort = agentPort;
    }

    public void setAllowedConnections(int allowedConnections) {
        this.allowedConnections = allowedConnections;
    }

    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }
}
