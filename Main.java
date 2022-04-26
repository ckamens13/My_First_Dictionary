/*
 * Group Project Spring 2022
 * Dictionary Using HashMap, Tree Map, LinkedHashMap
 * Mia Navarro, Cassandra Kamens
 */

/**
 *
 * Todd Wolfe
 */

 
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.io.*;
import java.util.Scanner;

//Create a class "Words" with three inputs name, part of speech, and definiton
class Words{
    public String word; 
    public String speech; 
    public String definition;

    Words(String word, String speech, String definition){
        this.word = word;
        this.speech = speech;
        this.definition = definition;
    }
}

//Create a class "HMDictionary"; a dictionary created using a HashMap
class HMDictionary {
    public HashMap<String, Words> map = new HashMap<String, Words>();

    public void dictionaryData() throws Exception {
        
        //Read File, Split Strings into needed parts
        BufferedReader br = new BufferedReader(new FileReader("dictionary.txt")); 
        for (String line = br.readLine(); line != null; line = br.readLine()) {
              String[] parsedLine = line.split(",");
              //value 1
              String word = parsedLine[0];
              //value 2
              String speech = parsedLine[1];
              //value 3
              String definition = parsedLine[2];
              Words words = new Words(word, speech, definition);
              //maps words to defintions
              map.put(word, words);
        }
        br.close();
    }

    ///Find the definition of the word from the input inside the dictionary
    public String findWord(String word) {
        for( String i : map.keySet()) {
            if (i.equals(word)) {
                Words newWord = map.get(i);
                
                return newWord.definition;
            }
        }
        return null;
    }

    //Find the part of speech of the word from the input inside the dictionary
    public String findSpeech(String speech) {
        for( String i : map.keySet()) {
            if (i.equals(speech)) {
                Words newWord = map.get(i);
                return newWord.speech;
            }
        }
        return null;
    }
}

//Create a class "TMDictionary"; a dictionary created using a TreeMap
class TMDictionary {
    public TreeMap<String, Words> map = new TreeMap<String, Words>();

    public void dictionaryData() throws Exception {
        //Read File, Split Strings into needed parts
        BufferedReader br = new BufferedReader(new FileReader("dictionary.txt")); 
        for (String line = br.readLine(); line != null; line = br.readLine()) {
        
              String[] parsedLine = line.split(",");
              //value 2
              String word = parsedLine[0];
              //value 3
              String speech = parsedLine[1];
              //value 4
              String definition = parsedLine[2];
              Words words = new Words(word, speech, definition);
              map.put(word, words);
        }
        br.close();
    }

    //Find the definition of the word from the input inside the dictionary
    public String findWord2(String word) {
        for( String i : map.keySet()) {
            if (i.equals(word)) {
                Words newWord = map.get(i);
                
                return newWord.definition;
            }
        }
        return null;
    }

    //Find the part of speech of the word from the input inside the dictionary
    public String findSpeech2(String speech) {
        for( String i : map.keySet()) {
            if (i.equals(speech)) {
                Words newWord = map.get(i);
                return newWord.speech;
            }
        }
        return null;
    }
}

//Create a class "LHMDictionary"; a dictionary created using a LinkedHashMap
class LHMDictionary {
    public LinkedHashMap<String, Words> map = new LinkedHashMap<String, Words>();

    public void dictionaryData() throws Exception {
        //Read File, Split Strings into needed parts
        BufferedReader br = new BufferedReader(new FileReader("dictionary.txt")); 
        for (String line = br.readLine(); line != null; line = br.readLine()) {
        
              String[] parsedLine = line.split(",");
              //value 1
              String word = parsedLine[0];
              //value 2
              String speech = parsedLine[1];
              //value 3
              String definition = parsedLine[2];
              Words words = new Words(word, speech, definition);
              map.put(word, words);
        }
        br.close();
    }

    //Find the definition of the word from the input inside the dictionary
    public String findWord3(String word) {
        for( String i : map.keySet()) {
            if (i.equals(word)) {
                Words newWord = map.get(i);
                
                return newWord.definition;
            }
        }
        return null;
    }

    //Find the part of speech of the word from the input inside the dictionary
    public String findSpeech3(String speech) {
        for( String i : map.keySet()) {
            if (i.equals(speech)) {
                Words newWord = map.get(i);
                return newWord.speech;
            }
        }
        return null;
    }
}

class Main {
    public static void main (String[] args) throws Exception{
        HMDictionary obj = new HMDictionary();
        obj.dictionaryData();

        TMDictionary obj2 = new TMDictionary();
        obj2.dictionaryData();

        LHMDictionary obj3 = new LHMDictionary();
        obj3.dictionaryData();


        Scanner dict = new Scanner(System.in);  

        //User Input
        System.out.println("Search word here: ");

        String word = dict.nextLine();  // read user input
        System.out.println("-------");
        System.out.println(" ");
        //HashMap 
        long startTime = System.nanoTime();
        System.out.println("HashMap");
        System.out.println("-------");
        System.out.println("Word: " + word);
        System.out.println("Part of Speech: " + obj.findSpeech(word));
        System.out.println("Defintion: " + obj.findWord(word));
        long endTime = System.nanoTime();
        long execution = endTime - startTime;
        System.out.println("Execution Time: " + execution + " nanoseconds");

        System.out.println(" ");

        //TreeMap
        long startTime2 = System.nanoTime();
        System.out.println("TreeMap");
        System.out.println("-------");
        System.out.println("Word: " + word);
        System.out.println("Part of Speech: " + obj2.findSpeech2(word));
        System.out.println("Defintion: " + obj2.findWord2(word));  
        long endTime2 = System.nanoTime();
        long execution2 = endTime2 - startTime2;
        System.out.println("Execution Time: " + execution2 + " nanoseconds");

        System.out.println(" ");

        //LinkedHashMap
        long startTime3 = System.nanoTime();
        System.out.println("LinkedHashMap");
        System.out.println("-------------");
        System.out.println("Word: " + word);
        System.out.println("Part of Speech: " + obj3.findSpeech3(word));
        System.out.println("Defintion: " + obj3.findWord3(word));  
        long endTime3 = System.nanoTime();
        long execution3 = endTime3 - startTime3;
        System.out.println("Execution Time: " + execution3 + " nanoseconds");

        System.out.println(" ");
        
    }
}


