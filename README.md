# SOSAgent
Conversion of agent code from C to Java

Contents:

sosAgent - Java source code for SOS Agent that is being converted from C (work in progress)

OriginalAgentCodeC - Original SOS Agent code written in C that serves as a template for this project

RestletJARFiles - All .jar files needed for this project (more may be added)

agentWorkflowTable.xlsx - Excel document that details the workflow of original C code

agentLogicDiagram.pdf - High level logic diagram for old agent code that outlines control flow


SOS Agent uses a Restlet server to listen for commands from a Floodlight controller. For testing, curl was used to simulate the Floodlight controller sending JSON packets to the agent. The following curl command is used for testing (query details can be changed):

curl -X POST http://localhost:9998 -H \"Content-Type: application/json\" -d '{\"source\":\"CLIENT\", \"sourceIP\":\"10.0.0.1\", \"sourcePort\":10000, \"agentIP\":\"10.0.1.1\", \"allowedConnections\":1, \"bufferSize\":2048, \"queueSize\":2048}'
