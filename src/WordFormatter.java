import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import sun.misc.IOUtils;


public class WordFormatter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Starting work on the word formatter now...");
		
		
		//Replace this later with file opening
		try {
			String sampleText = new String(Files.readAllBytes(Paths.get("sample.txt")));
			//System.out.println(sampleText);
			
			averageWordsPerLine(sampleText);
			averageLineLength(sampleText);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/* I am writing the methods here for now for ease of access
	 * But will refactor them to their own class later
	 */
	
	public static double averageWordsPerLine(String text) {
		
		String[] lines = text.split("\n");
		
		
		double lineCount = (double)lines.length;
		double wordCount = 0;
		
		for(int i=0;i<lineCount;i++) {
			String curLine = lines[i];
			String[] words = curLine.split(" ");
			wordCount = wordCount + words.length;
		}
		
		double averageWordsPerLine = wordCount/lineCount;
		
		System.out.println("Average words per line: " + averageWordsPerLine);
		
		return averageWordsPerLine;
		
	}
	
	public static double averageLineLength(String text) {
		
		String[] lines = text.split("\n");
		
		double lineCount = (double)lines.length;
		double totalLineLengths = 0;
		
		for(int i=0;i<lineCount;i++) {
			double curLineLength = (double)lines[i].length();
			totalLineLengths = totalLineLengths + curLineLength;
		}
		
		double averageLineLength = totalLineLengths/lineCount;
		
		//This is length in characters, not words
		System.out.println("Average line length: " + averageLineLength);
		return averageLineLength;
		
	}

}
