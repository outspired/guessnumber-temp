import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    static List<GameResult> results = new ArrayList<>();
    static Random rand = new Random();

    public static void main(String[] args) {
      addResults();
      showResults();
    }
    
    
    private static void addResults() {
    	for (int i = 0; i < 10; i++) {
    		GameResult r = new GameResult();
    		int randName = rand.nextInt(100000000) + 1;
    		r.name = "name" + String.valueOf(randName);
        	r.triesCount = 50*i;
        	r.timeSpent = i;
        	results.add(r);
    	}
    }
    
    
    private static void showResults() {
    	
    	String headerName = "User name";
    	String headerTriesCount = "Number of tries";
    	String headerTimeSpent = "Time";
    	
    	int maxName = headerName.length();
    	int maxTriesCount = headerTriesCount.length();
    	int maxTimeSpent = headerTimeSpent.length();
    	
    	for (GameResult r : results) {
    	  if (maxName < r.name.length()) {
    	    maxName = r.name.length();
    	  }
    	  if (maxTriesCount < String.valueOf(r.triesCount).length()) {
    	    maxTriesCount = String.valueOf(r.triesCount).length();
    	  }
    	  if (maxTimeSpent < String.valueOf(r.timeSpent).length()) {
    	    maxTimeSpent = String.valueOf(r.timeSpent).length();
    	  }
    	}
    	
    	int headerNameLength = headerName.length();
    	for (int i = 0; i < maxName - headerNameLength; i++) {
    	  headerName = headerName + " ";
    	}
    	int headerTriesCountLength = headerTriesCount.length();
    	for (int i = 0; i < maxTriesCount - headerTriesCountLength; i++) {
    	  headerTriesCount = headerTriesCount + " ";
    	}
    	int headerTimeSpentLength = headerTimeSpent.length();
    	for (int i = 0; i < maxTimeSpent - headerTimeSpentLength; i++) {
    	  headerTimeSpent = headerTimeSpent + " ";
    	}
    	
        int nameAddSpaceNum;
        int triesCountAddSpaceNum;
        int timeSpentAddSpaceNum;
        
        String nameAddedSpaces;
        String triesCountAddedSpaces;
        String timeSpentAddedSpaces;
        
        //String tableLineHorizontal = "|";
        //for (int i=0; i < 8 + maxName + maxTriesCount + maxTimeSpent; i++) {
        //  tableLineHorizontal = tableLineHorizontal + "-";
        //}
        //tableLineHorizontal = tableLineHorizontal + "|";
        
        String tableLineHorizontal = "|";
        for (int i=0; i < 2 + maxName; i++) {tableLineHorizontal = tableLineHorizontal + "-";}
        tableLineHorizontal = tableLineHorizontal + "+";
        for (int i=0; i < 2 + maxTriesCount; i++) {tableLineHorizontal = tableLineHorizontal + "-";}
        tableLineHorizontal = tableLineHorizontal + "+";
        for (int i=0; i < 2 + maxTimeSpent; i++) {tableLineHorizontal = tableLineHorizontal + "-";}
        tableLineHorizontal = tableLineHorizontal + "|";
        
        System.out.println(tableLineHorizontal);
        System.out.println("| " + headerName + " | " + headerTriesCount + " | " + headerTimeSpent + " |");
        System.out.println(tableLineHorizontal);
        
        
        for (GameResult r : results) {
          nameAddSpaceNum = maxName - r.name.length();
          triesCountAddSpaceNum = maxTriesCount - String.valueOf(r.triesCount).length();
          timeSpentAddSpaceNum = maxTimeSpent - String.valueOf(r.timeSpent).length();
          
          nameAddedSpaces = r.name;
          for (int i=0; i < nameAddSpaceNum; i++) {
            nameAddedSpaces = nameAddedSpaces + " ";
          }
          
          triesCountAddedSpaces = String.valueOf(r.triesCount);
          for (int i=0; i < triesCountAddSpaceNum; i++) {
            triesCountAddedSpaces = " " + triesCountAddedSpaces;
          }
          
          timeSpentAddedSpaces = String.valueOf(r.timeSpent);
          for (int i=0; i < timeSpentAddSpaceNum; i++) {
            timeSpentAddedSpaces = " " + timeSpentAddedSpaces;
          }
          
          
          System.out.println("| " + nameAddedSpaces + " | " + triesCountAddedSpaces + " | " + timeSpentAddedSpaces + " |");
          System.out.println(tableLineHorizontal);
          //System.out.printf("Name: %s Tries: %d Time: %dsec\n", nameAddedSpaces, triesCountAddedSpaces, timeSpentAddedSpaces);
        }
        
        
    	
    	//results.stream()
             //.sorted(Comparator.<GameResult>comparingInt(r -> r.triesCount)
             //.thenComparingLong(r -> r.timeSpent))
             //.limit(5)
             //.forEach(r -> {
              //nameAddSpaceNum = maxName - r.name.length();
              
              
              //triesCountAddSpaceNum = maxTriesCount - String.valueOf(r.triesCount).length();
              //timeSpentAddSpaceNum = maxTimeSpent - String.valueOf(r.timeSpent).length();
              
              
    	      
    	      //System.out.printf("Name: %s Tries: %d Time: %dsec\n", r.name, r.triesCount, r.timeSpent);
             //});
    }
    
    
    
    public static class GameResult {
    	int triesCount;
    	String name;
    	int timeSpent;
    }
}
