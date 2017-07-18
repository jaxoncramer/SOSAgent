package com.company;

import com.sun.org.glassfish.external.statistics.Stats;

import java.net.Inet6Address;
import java.nio.channels.spi.SelectorProvider;
import java.util.UUID;

/**
 * Created by jaxoncramer on 7/11/17.
 */
public class Client {
    private PacketHash bufferedPacketTable;
    private PacketHash bufferedPacket;
    private int sendSeq;
    private int recvSeq;

    private int headerSize; //should be unsigned int
    private int clientEventPool;
    private int eventPollOutAgent;
    private int eventPollOutHost;
    private EventInfo hostSideEventInfo;
    private EventInfo agentSideEventInfo[];
    private SelectorProvider event;
    private int hostSock;
    private int agentSock[];
    //private SerializedData packet[];

    private char agentFDPoll[];
    private char hostFDPoll;
    private int numParallelConnections;
    private int agentPacketQueueCount[];
    private int agentPacketIndexIN[];
    private int agentPacketIndexOUT;
    private int agentNeededHeaderSize[];

    private String sourceIP;
    private int sourcePort; //should be unsigned short

    private String agentIP;
    private int agentPort; //should be unsigned

    private int allowedConnections;
    private UUID uuid;
    private TransferRequest transferRequest;
    private Stats stats;


    //GETTERS
    public PacketHash getBufferedPacketTable() {
        return bufferedPacketTable;
    }

    public PacketHash getBufferedPacket() {
        return bufferedPacket;
    }

    public int getSendSeq() {
        return sendSeq;
    }

    public int getRecvSeq() {
        return recvSeq;
    }

    public int getHeaderSize() {
        return headerSize;
    }

    public int getClientEventPool() {
        return clientEventPool;
    }

    public int getEventPollOutAgent() {
        return eventPollOutAgent;
    }

    public int getEventPollOutHost() {
        return eventPollOutHost;
    }

    public EventInfo getHostSideEventInfo() {
        return hostSideEventInfo;
    }

    public EventInfo[] getAgentSideEventInfo() {
        return agentSideEventInfo;
    }

    public SelectorProvider getEvent() {
        return event;
    }

    public int getHostSock() {
        return hostSock;
    }

    public int[] getAgentSock() {
        return agentSock;
    }

    public char[] getAgentFDPoll() {
        return agentFDPoll;
    }

    public char getHostFDPoll() {
        return hostFDPoll;
    }

    public int getNumParallelConnections() {
        return numParallelConnections;
    }

    public int[] getAgentPacketQueueCount() {
        return agentPacketQueueCount;
    }

    public int[] getAgentPacketIndexIN() {
        return agentPacketIndexIN;
    }

    public int getAgentPacketIndexOUT() {
        return agentPacketIndexOUT;
    }

    public int[] getAgentNeededHeaderSize() {
        return agentNeededHeaderSize;
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

    public UUID getUuid() {
        return uuid;
    }

    public TransferRequest getTransferRequest() {
        return transferRequest;
    }

    public Stats getStats() {
        return stats;
    }


    //SETTERS
    public void setBufferedPacketTable(PacketHash bufferedPacketTable) {
        this.bufferedPacketTable = bufferedPacketTable;
    }

    public void setBufferedPacket(PacketHash bufferedPacket) {
        this.bufferedPacket = bufferedPacket;
    }

    public void setSendSeq(int sendSeq) {
        this.sendSeq = sendSeq;
    }

    public void setRecvSeq(int recvSeq) {
        this.recvSeq = recvSeq;
    }

    public void setHeaderSize(int headerSize) {
        this.headerSize = headerSize;
    }

    public void setClientEventPool(int clientEventPool) {
        this.clientEventPool = clientEventPool;
    }

    public void setEventPollOutAgent(int eventPollOutAgent) {
        this.eventPollOutAgent = eventPollOutAgent;
    }

    public void setEventPollOutHost(int eventPollOutHost) {
        this.eventPollOutHost = eventPollOutHost;
    }

    public void setHostSideEventInfo(EventInfo hostSideEventInfo) {
        this.hostSideEventInfo = hostSideEventInfo;
    }

    public void setAgentSideEventInfo(EventInfo[] agentSideEventInfo) {
        this.agentSideEventInfo = agentSideEventInfo;
    }

    public void setEvent(SelectorProvider event) {
        this.event = event;
    }

    public void setHostSock(int hostSock) {
        this.hostSock = hostSock;
    }

    public void setAgentSock(int[] agentSock) {
        this.agentSock = agentSock;
    }

    public void setAgentFDPoll(char[] agentFDPoll) {
        this.agentFDPoll = agentFDPoll;
    }

    public void setHostFDPoll(char hostFDPoll) {
        this.hostFDPoll = hostFDPoll;
    }

    public void setNumParallelConnections(int numParallelConnections) {
        this.numParallelConnections = numParallelConnections;
    }

    public void setAgentPacketQueueCount(int[] agentPacketQueueCount) {
        this.agentPacketQueueCount = agentPacketQueueCount;
    }

    public void setAgentPacketIndexIN(int[] agentPacketIndexIN) {
        this.agentPacketIndexIN = agentPacketIndexIN;
    }

    public void setAgentPacketIndexOUT(int agentPacketIndexOUT) {
        this.agentPacketIndexOUT = agentPacketIndexOUT;
    }

    public void setAgentNeededHeaderSize(int[] agentNeededHeaderSize) {
        this.agentNeededHeaderSize = agentNeededHeaderSize;
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

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setTransferRequest(TransferRequest transferRequest) {
        this.transferRequest = transferRequest;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }
}
