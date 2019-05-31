package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PushbackReader;

import tp6.lexer.Lexer;
import tp6.node.Start;
import tp6.parser.Parser;


public class Main {
    public static void main(String[] args) {
         // long start_time, stop_time;

         /*if (args.length < 1) {
              System.out.println("Usage:");
              System.out.println(" java main.Main <filename>");
         }*/

         try {
              // start_time = System.currentTimeMillis();
              Lexer lexer = new Lexer (new PushbackReader(new BufferedReader(new FileReader("test2.txt")), 1024));
              Parser parser = new Parser(lexer);
              Start ast = parser.parse();
              ast.apply(new Evaluator());
         }
         catch (Exception e) {
              e.printStackTrace();
         }
    }
}