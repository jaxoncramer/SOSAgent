package com.company;

import sun.management.resources.agent;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private final static Common common = new Common();
    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        //Set LOGGER warning level (info, warning, or severe)
        LOGGER.setLevel(Level.INFO);

        //should only be one instance of common throughout program
        Agent agent = new Agent(common);

        //initialize agent
        agent.initAgent();

        while (true) {
            //#####################################//
            //TODO Remove manual switching between event types
            Common.PollEventTypes event = getEventType();
            //#####################################//

            if(event == null) {
                break;
            } else {

                switch (event) {
                    case CONTROLLER_MESSAGE:
                        LOGGER.info("CONTROLLER_MESSAGE " + new Throwable().getStackTrace()[0].getLineNumber());
                        agent.getController().getControllerMessage();
                        break;
                    case HOST_SIDE_CONNECT:
                        LOGGER.info("HOST_SIDE_CONNECT " + new Throwable().getStackTrace()[0].getLineNumber());
                        agent.handleHostConnection();
                        break;
                    case AGENT_CONNECTED:
                        LOGGER.info("AGENT_CONNECTED " + new Throwable().getStackTrace()[0].getLineNumber());
                        agent.agentConnected();
                        break;
                    case AGENT_SIDE_CONNECT:
                        LOGGER.info("AGENT_SIDE_CONNECT " + new Throwable().getStackTrace()[0].getLineNumber());
                        agent.acceptAgentConnection();
                        break;
                    case AGENT_CONNECTED_UUID:
                        LOGGER.info("AGENT_CONNECTED_UUID " + new Throwable().getStackTrace()[0].getLineNumber());
                        agent.confirmClient();
                        break;
                    case HOST_CONNECTED:
                        LOGGER.info("HOST_CONNECTED " + new Throwable().getStackTrace()[0].getLineNumber());
                        agent.hostConnected();
                        break;
                    default:
                        LOGGER.warning("Unknown event type " + new Throwable().getStackTrace()[0].getLineNumber());
                }
            }
        }

        System.out.println("Program Terminated Correctly");

    }

    private static Common.PollEventTypes getEventType() {
        Scanner scanner = new Scanner(System.in);
        int option;

        printMenu();
        try {
            option = scanner.nextInt();
            scanner.nextLine();
        } catch (java.util.InputMismatchException e) {
            scanner.nextLine();
            return null;
        }

        switch (option) {
            case 0:
                System.out.println("Quitting program...");
                return null;
            case 1:
                return Common.PollEventTypes.CONTROLLER_MESSAGE;
            case 2:
                return Common.PollEventTypes.HOST_SIDE_CONNECT;
            case 3:
                return Common.PollEventTypes.AGENT_CONNECTED;
            case 4:
                return Common.PollEventTypes.AGENT_SIDE_CONNECT;
            case 5:
                return Common.PollEventTypes.AGENT_CONNECTED_UUID;
            case 6:
                return Common.PollEventTypes.HOST_CONNECTED;
            default:
                System.out.println("Not valid option.");
                break;
        }
        return null;
    }

    private static void printMenu() {
        System.out.println("Enter one of the following to select an event type: ");
        System.out.println("0: Exit the program");
        System.out.println("1: CONTROLLER_MESSAGE");
        System.out.println("2: HOST_SIDE_CONNECT");
        System.out.println("3: AGENT_CONNECTED");
        System.out.println("4: ACCEPT_AGENT_SIDE");
        System.out.println("5: AGENT_CONNECTED_UUID");
        System.out.println("6: HOST_CONNECTED\n");
    }

}
