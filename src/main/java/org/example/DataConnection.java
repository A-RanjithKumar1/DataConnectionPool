package org.example;

import java.util.Scanner;
import java.util.logging.*;
public class DataConnection {
    private static final Logger LOGGER = Logger.getLogger("InfoLogging");
    private static DataConnection single = null;
    String s;

    private DataConnection(String s1) {
        s = "you are connected to the " + s1 + " successfully";
        LOGGER.info(s);
    }

    public static DataConnection getInstance(String s) {
        if (single == null)
            single = new DataConnection(s);

        return single;
    }

    public String newConnection(String ns) {
        s = "The new Connection is " + ns + " established";
        return s;
    }

    public void close() {
        s = "All the connections are Closed";
        LOGGER.info(s);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LOGGER.info("Enter the Connection Name");
        String con = sc.nextLine();
        // Instantiating Singleton class with variable x
        DataConnection x = DataConnection.getInstance(con);
        boolean choose = true;
        while (choose) {
            try {
                LOGGER.info("Select the option \n 1.New Connection\n 2.Close all connections");
                int op = sc.nextInt();
                sc.nextLine();
                if (op == 1) {
                    LOGGER.info("Enter the new Connection Name");
                    String ns = sc.nextLine();
                    String con1 = x.newConnection(ns);
                    LOGGER.info(con1);
                } else if (op == 2) {
                    x.close();
                    choose = false;
                }
                else{
                    LOGGER.info("Please Try Again!");
                }
            } catch (Exception e) {
                LOGGER.info("Something went wrong while giving input");
                choose=false;
            }
        }
    }
}

