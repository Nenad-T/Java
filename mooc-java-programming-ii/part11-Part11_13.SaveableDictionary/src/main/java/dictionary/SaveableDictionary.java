/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sakine
 */
public class SaveableDictionary {

    private final HashMap<String, String> dictionary;
    private String file;

    public SaveableDictionary(String file) {
        this.dictionary = new HashMap<>();
        this.file = file;
    }

    public SaveableDictionary() {
        this.dictionary = new HashMap<>();
    }

    public void add(String words, String translation) {
        if (!this.dictionary.containsKey(words)) {
            this.dictionary.put(words, translation);
        }
    }

    public String translate(String word) {
        String answer = null;
        for (String key : this.dictionary.keySet()) {
            if (word.contains(key)) {
                answer = this.dictionary.get(key);
            }
            if (this.dictionary.get(key).equals(word)) {
                answer = key;
            }
        }
        return answer;
    }

    public void delete(String word) {
        String toRemove = null;
        for (String key : this.dictionary.keySet()) {
            if (this.dictionary.get(key).contains(word)) {
                toRemove = key;
            }
            if (key.contains(word)) {
                toRemove = key;
            }
        }
        this.dictionary.remove(toRemove);
    }

    public boolean load() {
        Boolean loaded = false;
        try {
            File f = new File(file);
            Scanner fileReader = new Scanner(f);
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");
                this.add(parts[0], parts[1]);
                loaded = true;
            }
            fileReader.close();
        } catch (FileNotFoundException ex) {
            loaded = false;
        }
        return loaded;
//        try {
//            Files.lines(Paths.get(this.file))
//                    .map(l -> l.split(":"))
//                    .forEach(parts -> {
//                        this.dictionary.put(parts[0], parts[1]);
//                        this.dictionary.put(parts[1], parts[0]);
//                    });
//            return true;
//        } catch (IOException ex) {
//            return false;
//        }
    }

    public boolean save() {
        PrintWriter writer = null;
        try {
            File f = new File(file);
            writer = new PrintWriter(f);
            for (String key : this.dictionary.keySet()) {
                writer.println(key + ":" + this.dictionary.get(key));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveableDictionary.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            writer.close();
        }
        return writer != null;
    }
}
