package com.company;


import com.sun.org.apache.regexp.internal.RE;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.restlet.*;
import org.restlet.data.MediaType;
import org.restlet.data.Protocol;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Created by jaxoncramer on 7/10/17.
 */
public class Controller extends ServerResource {

    private Common common = new Common();
    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

    private Server sock;
    private short port;
    private ArrayList<TransferRequest> requests = new ArrayList<>();

    //GETTERS
    public Server getSock() {
        return sock;
    }

    public short getPort() {
        return port;
    }

    //SETTERS
    public void setSock(Server sock) {
        this.sock = sock;
    }

    public void setPort(short port) {
        this.port = port;
    }

    //Initialize Controller Restlet Server once at beginning of program
    //server runs the getRestletResource function and handles exactly one request at a time
    public void initControllerListener() {
        Server server = new Server(Protocol.HTTP, this.common.getCONTROLLER_MSG_PORT(), getRestletResource());
        setSock(server);
        setPort((short) this.common.getCONTROLLER_MSG_PORT());
    }

    //starts the Controller Restlet Server
    public void getControllerMessage() {
        try {
            this.sock.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //handles exactly one Restlet server request and then stops the server
    //different functionality available for GET, POST, PUT, and DELETE
    public Restlet getRestletResource() {
        return new Restlet() {
            @Override
            public void handle(Request request, Response response) {

                //POST
                //Retrieves and parses JSON Object and stores relevant data in a transfer request
                if (request.getMethod().getName().equalsIgnoreCase("post")) {

                    handlePost(request, response);

                    //GET
                } else if(request.getMethod().getName().equalsIgnoreCase("get")) {

                    handleGet(request, response);

                    //PUT
                } else if(request.getMethod().getName().equalsIgnoreCase("put")) {

                    handlePut(request, response);

                    //DELETE
                } else if(request.getMethod().getName().equalsIgnoreCase("delete")) {

                    handleDelete(request, response);

                }

                //stops server after one request has been processed
                response.setOnSent(new Uniform() {
                    @Override
                    public void handle(Request req, Response res) {
                        try {
                            sock.stop();//stop the server
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        };
    }

    private void handlePost(Request request, Response response) {
        response.setEntity("POST request handled\n", MediaType.TEXT_PLAIN);
        JSONParser parser = new JSONParser();

        try {
            JsonRepresentation represent = new JsonRepresentation(request.getEntity());
            JSONObject jsonObject = represent.getJsonObject();

            TransferRequest transfer = new TransferRequest();

            if(jsonObject.has("source")) {
                transfer.setType((String) jsonObject.get("source"));

                if(transfer.getType().equals("CLIENT")) {
                    transfer.setSourceIP((String) jsonObject.get("sourceIP"));
                    transfer.setSourcePort((Integer) jsonObject.get("sourcePort"));
                    transfer.setAgentIP((String) jsonObject.get("agentIP"));
                    transfer.setAllowedConnections((Integer) jsonObject.get("allowedConnections"));
                    transfer.setBufferSize((Integer) jsonObject.get("bufferSize"));
                    transfer.setQueueSize((Integer) jsonObject.get("queueSize"));
                    printTransferMessage(transfer);
                } else if(transfer.getType().equals("AGENT")) {
                    transfer.setAgentIP((String) jsonObject.get("agentIP"));
                    transfer.setAgentPort((Integer) jsonObject.get("agentPort"));
                    transfer.setAllowedConnections((Integer) jsonObject.get("allowedConnections"));
                    transfer.setBufferSize((Integer) jsonObject.get("bufferSize"));
                    transfer.setQueueSize((Integer) jsonObject.get("queueSize"));
                    printTransferMessage(transfer);
                }

                requests.add(transfer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleGet(Request request, Response response) {
        response.setEntity("GET request handled\n", MediaType.TEXT_PLAIN);
        System.out.println("GET request");
    }

    private void handlePut(Request request, Response response) {

    }

    private void handleDelete(Request request, Response response) {

    }

    private void printTransferMessage(TransferRequest transfer) {
        System.out.println("Source Type: " + transfer.getType());
        System.out.println("Source IP: " + transfer.getSourceIP());
        System.out.println("Source Port: " + transfer.getSourcePort());
        System.out.println("Agent IP: " + transfer.getAgentIP());
        System.out.println("Agent Port: " + transfer.getAgentPort());
        System.out.println("Allowed Connections: " + transfer.getAllowedConnections());
        System.out.println("Buffer Size: " + transfer.getBufferSize());
        System.out.println("Queue Size: " + transfer.getQueueSize());
    }

}
