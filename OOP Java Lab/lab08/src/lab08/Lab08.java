/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab08;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Admin
 */
public class Lab08 {

    /**
     * @param args the command line arguments
     */
    private Map<Character, Integer> charCounter = 
new HashMap<Character, Integer>();
    
    private Map<String, Integer> wordCounter =
            new HashMap<String, Integer>();

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your content: ");
        String content = scanner.nextLine();
       
        Lab08 counter = new Lab08();
        counter.analyze(content);
    }
    
    
    
    public void analyze(String content) {
        
        for (char ch : content.toCharArray()) {
            if (Character.isSpaceChar(ch)) continue;
            if (charCounter.containsKey(ch)) {
                charCounter.put(ch, ((int) charCounter.get(ch)) + 1);
            } else {
                charCounter.put(ch, 1);
            }
        }
        StringTokenizer tokenizer = new StringTokenizer(content);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            System.out.println(token);
            if (wordCounter.containsKey(token)) {
                wordCounter.put(token, ((int) wordCounter.get(token)) + 1);
            } else {
                wordCounter.put(token, 1);
            }
        }
        System.out.println(wordCounter);
        System.out.println(charCounter);
    }
    
}
