package com.requestbodylab.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CommandLine {
    public static String executeCommandPrompt(String command){
        ProcessBuilder processBuilder = new ProcessBuilder();
        StringBuilder output = new StringBuilder();

        switch (System.getProperty("os.name")) {
            case "Linux":
                processBuilder.command("bash", "-c", command);
                break;
            case "Mac OS X":
                processBuilder.command("bash", "-c", command);
                break;
            default:
                processBuilder.command("cmd.exe", "/c", command);
                break;
        }

        try {

            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Command executed successfully.");
            } else {
                System.err.println("Command failed with exit code: " + exitVal);
            }
            

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return output.toString();
    }
}