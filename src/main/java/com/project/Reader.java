package com.project;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Reader {

    private List<String> tokens;

    public Reader(){
        tokens = new LinkedList<String>();
    }

    public Boolean determineEvenOrOdd(String word){
        if(word.length()>0){
           tokens.add(word);
        }
        return tokens.size()%2==0 ;
    }

    public String processInput(InputStream inputStream){

        int i;
        char character;

        String fullToken="";
        String token="";
        Boolean even;
        Boolean whiteSpaceEnded=false;
        Boolean onlyOneToken=false;
        try {
            while ((i = inputStream.read()) != -1) {

                character = (char) i;

                if (isWhiteSpace(character)) {
                    token = evaluateToken(token);
                    fullToken+=token;
                    whiteSpaceEnded=true;
                    onlyOneToken=false;
                    fullToken += character;
                    token="";

                } else {
                    token += character;
                    whiteSpaceEnded=false;
                    onlyOneToken=true;
                }
            }

            if(onlyOneToken || !whiteSpaceEnded){
                token = evaluateToken(token);
                fullToken+=token;
            }
        }

        catch (Exception e){
            System.out.println("--- Exception "+e.getMessage());
        }

        finally {
            return fullToken;
        }
    }

    private String evaluateToken(String token) {
        Boolean even;
        if(token.length()>0){
            even = determineEvenOrOdd(token);
            if(even)
                token = reverseToken(token);
        }
        return token;
    }

    public String reverseToken(String token){
        String reversed="";
        for (int i = token.length()-1; i >= 0 ; i--) {
            reversed+=token.charAt(i);
        }
        return reversed;
    }

    private Boolean isWhiteSpace(char cha){
        return Character.isWhitespace(cha);
    }

    public List<String> getTokens() {
        return tokens;
    }
}
