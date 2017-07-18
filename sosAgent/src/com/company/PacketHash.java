package com.company;

import java.util.Hashtable;

/**
 * Created by jaxoncramer on 7/11/17.
 */
public class PacketHash {
    private int id;
    private int agentId;

    private int hostSentSize;
    private int size;

    private short needHeaderSize;
    private int packetIndex;
    private short serializedData[];
    private int seqNum;

    private char inUse;

    private Hashtable hh;

    //Getters
    public int getId() {
        return id;
    }

    public int getAgentId() {
        return agentId;
    }

    public int getHostSentSize() {
        return hostSentSize;
    }

    public int getSize() {
        return size;
    }

    public short getNeedHeaderSize() {
        return needHeaderSize;
    }

    public int getPacketIndex() {
        return packetIndex;
    }

    public short[] getSerializedData() {
        return serializedData;
    }

    public int getSeqNum() {
        return seqNum;
    }

    public char getInUse() {
        return inUse;
    }
}
