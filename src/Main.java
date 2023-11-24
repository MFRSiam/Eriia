// Created By MFR Siam

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static boolean hadError;
    public static void main(String[] args) throws IOException {
        if(args.length > 1){
            System.out.println("Usage: Erria [Script]");
            System.exit(64);
        }else if(args.length == 1){
            runFile(args[0]);
        }else{
            runPrompt();
        }
    }
    private static void runPrompt() throws IOException{
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        while(true){
            System.out.print("> ");
            String line = reader.readLine();
            if(line == null){
                break;
            }
            run(line);
        }
    }
    public static  void run(String source){
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();
        // For Now Just Print The Tokesn
        for(Token token: tokens){
            System.out.println(token);
        }
    }
    private static void error(int line,String message){
        report(line, "",message);
    }
    private static void report(int line,String where,String message){
        System.err.println("[Line : " + line + " ] Error: " + where + " : " + message );
        hadError = true;
    }

}