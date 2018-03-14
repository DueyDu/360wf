import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import sun.misc.IOUtils;


public class WordFormatter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Starting work on the word formatter now...");
		
		
		//Replace this later with file opening GUI JPanel/JFrame
		try {
			String sampleText = new String(Files.readAllBytes(Paths.get("sample.txt")));
			//System.out.println(sampleText);
			
			averageWordsPerLine(sampleText);
			averageLineLength(sampleText);

			System.out.println(removeBlankLinesFromText(sampleText));
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/* Right Justification of lines with 80 characters */
	public static void rightJustify(String text)
	{
		String[] lines = text.split("\n");
		double lineCount = (double)lines.length;
		for(int i = 0; i < lineCount; i++)
		{
			System.out.printf("%80s",lines[i]);
			System.out.println();
		}    
	}
	/* Left Justification of lines with 80 characters */
	public static void leftJustify(String text)
	{
		String[] lines = text.split("\n");
		double lineCount = (double)lines.length;
		for(int i = 0; i < lineCount; i++)
		{
			System.out.printf("%-80s",lines[i]);
			System.out.println();
		}    
	}
	/* I am writing the methods here for now for ease of access
	 * But will refactor them to their own class later
	 */
	public static int wordsProcessed(String text) {
		int wordCount = 0;
		
		String[] lines = text.split("\n");
		
		for(int i=0;i<lines.length;i++) {
			wordCount = wordCount + lines[i].split(" ").length;
		}
		
		System.out.println("Words processed: " + wordCount);

		return wordCount;
	}
	
	public static int lines(String text) {
		int lineCount = text.split("\n").length;
		System.out.println("Words processed: " + lineCount);

		return lineCount;
	}
	
	public static String removeBlankLinesFromText(String text) {
		
		String[] lines = text.split("\n");
		String newString = "";
		
		for(int i=0;i<lines.length;i++) {
			if(lines[i].trim().length() != 0) {
				newString = newString + lines[i] + "\n";
			}
		}
		
		
		return newString;
		
	}
	
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
