package project;

import java.io.*;
import java.io.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DictionaryCommandline  {
    public String url;
    public FileInputStream fileInputStream;
    public Scanner scanner;
    public static int spaceWord = 15;
    public DictionaryCommandline(String url) throws FileNotFoundException {
        this.url = url;
        this.fileInputStream = new FileInputStream(url);
        this.scanner = new Scanner(fileInputStream);
    }

    public void showAllWords() throws IOException {
        String arr[] = new String[1000];
        int currentSize = 0;
        while (scanner.hasNextLine()) {
            arr[currentSize] = scanner.nextLine();
            currentSize++;
        }
        scanner.close();
        fileInputStream.close();
        for(int i = 0; i < currentSize; i++ ) {
            String english = "";
            String vietnameese = "";
            for(int j = 0; j < arr[i].length(); j++) {
                if(arr[i].charAt(j) == '_') {
                    english = arr[i].substring(0, j);
                    vietnameese = arr[i].substring(j+1, arr[i].length());
                    break;
                }
            }
            int space = DictionaryCommandline.spaceWord;
            if(space < english.length()) {
                space = english.length() + 3;
            }
            String temp = Integer.toString(i + 1) + '\t' + "| " + english;
            for(int j = 0; j < space- english.length() ; j++) {
                temp += ' ';
            }
            temp += "| "+ vietnameese;
            System.out.println(temp);

        }
    }


    public static void main(String[] args) throws IOException {
        DictionaryCommandline test = new DictionaryCommandline("C:\\Users\\rogergold\\OneDrive\\Desktop\\workSpace\\LearnJava\\src\\project\\dictionary.txt");
        test.showAllWords();
    }
}
