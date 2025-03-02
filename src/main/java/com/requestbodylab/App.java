package com.requestbodylab;

import io.javalin.Javalin;

/**
 * You could run this method to start the server, and then access it using the 'curl' command. For example, you can
 * type into a terminal the following command:
 *      curl localhost:9000/
 * Before this endpoint will return any information to you request, we will need to write that logic in
 * JavalinSingleton.java
 */
public class App 
{
    public static void main( String[] args )
    {
        Javalin app = JavalinSingleton.getInstance();
        app.start(9000);
    }
}