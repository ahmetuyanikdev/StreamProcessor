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
        char c;

        String fullToken="";
        String token="";
        Boolean even;
        Boolean whiteSpaceEnded=false;
        Boolean onlyOneToken=false;
        try {
            while ((i = inputStream.read()) != -1) {
                c = (char) i;

                if (isWhiteSpace(c)) {
                    token = evaluateToken(token);
                    fullToken+=token;
                    whiteSpaceEnded=true;
                    onlyOneToken=false;
                    fullToken += c;
                    token="";

                } else {
                    token += c;
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

    public void processNormal(InputStream inputStream){
        int i;
        char c;
        String token="";
        try{
            while ((i = inputStream.read()) != -1) {
                c = (char) i;
                token+=c;
            }
            System.out.println(token);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
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

    public String reverseToken(String word){
        String reversed="";
        for (int i = word.length()-1; i >= 0 ; i--) {
            reversed+=word.charAt(i);
        }
        return reversed;
    }

    private Boolean isWhiteSpace(char cha){
        return Character.isWhitespace(cha);
    }

    protected InputStream getInputStreamOfFile(String path) throws IOException{
        return new FileInputStream(path);
    }

    public List<String> getTokens() {
        return tokens;
    }
}
