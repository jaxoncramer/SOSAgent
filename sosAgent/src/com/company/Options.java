package com.company;

//TODO Create getArguments() to initialize Options from command line
public class Options {
    public char verboseLevel;                    /* amoutn of verbose info     */
    public int numParallelConnections = 10;          /* number of parallel connections */
    public char nonOF;                            /* nonOF mode                     */
    public char logging;                          /* enable logging to mysql        */
    public char protocol;                         /* network protocol for agents    */
    public String bindIP;


    //GETTERS
    public char getVerboseLevel() {
        return verboseLevel;
    }

    public int getNumParallelConnections() {
        return numParallelConnections;
    }

    public char getNonOF() {
        return nonOF;
    }

    public char getLogging() {
        return logging;
    }

    public char getProtocol() {
        return protocol;
    }

    public String getBindIP() {
        return bindIP;
    }


    //SETTERS
    public void setVerboseLevel(char verboseLevel) {
        this.verboseLevel = verboseLevel;
    }

    public void setNumParallelConnections(int numParallelConnections) {
        this.numParallelConnections = numParallelConnections;
    }

    public void setNonOF(char nonOF) {
        this.nonOF = nonOF;
    }

    public void setLogging(char logging) {
        this.logging = logging;
    }

    public void setProtocol(char protocol) {
        this.protocol = protocol;
    }

    public void setBindIP(String bindIP) {
        this.bindIP = bindIP;
    }
}
