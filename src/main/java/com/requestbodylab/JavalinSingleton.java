package com.requestbodylab;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;

/**
 * Background: A json string representing a song will be sent in this POST request with the following fields: 
 *      songName, artistName
 */
public class JavalinSingleton {

    public static Javalin getInstance(){
        Javalin app = Javalin.create();
        ObjectMapper om = new ObjectMapper();
        
        /**
         * Problem1: retrieve the song object from the request body...
         *      1. return the song object as JSON in the response body.
         * 
         * Note: Please refer to the "RequestBody.MD" file for more assistance.
         */
        app.post("/echo", ctx -> {

            try {
                Song song = om.readValue(ctx.body(), Song.class);
                ctx.json(song);
            } catch (Exception e) {
                ctx.status(400).result("Invalid request body: " + e.getMessage());
            }    
        });

        /**
         * Problem2: retrieve the song object from the request body...
         *      1. update the artist in the song object to "Beatles"
         *      2. return the updated song object as JSON in the response body
         * 
         * Note: Please refer to the "RequestBody.MD" file for more assistance.
         */
        app.post("/changeartisttobeatles", ctx -> {

            try {
                Song song = om.readValue(ctx.body(), Song.class);
                song.setArtistName("Beatles");
                ctx.json(song);
            } catch (Exception e) {
                ctx.status(400).result("Invalid request body: " + e.getMessage());
            }
        });
        
        return app;
    }
}