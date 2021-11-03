package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/*
 * Author: Parker Behrendt
 * Date: 10/27/2021
 * Class: CEN 3024C
 */
public class Main extends Application {
	/*Main application code*/
	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {
		try {
			/*Set title and establish group and textflow*/
			primaryStage.setTitle("Word Counter");
			Group root = new Group();
			TextFlow textFlow = new TextFlow();
			
			/*Create title text object*/
			Text title = new Text();
			title.setX(200);
			title.setY(0);;
			title.setText("Word Counter");
			title.setId("title");
			title.setFill(Color.rgb(0, 0, 205));
			textFlow.getChildren().add(title);
			
			/*Create output text object*/
			TextArea output = new TextArea();
			output.setLayoutX(10);
			output.setLayoutY(100);
			output.setMinWidth(380);
			output.setMaxWidth(380);
			output.setMinHeight(645);
			output.setId("Output");
			
			/*Create start button*/
			Button start = new Button();
			start.setLayoutX(100);
			start.setLayoutY(65);
			start.setText("Start Program");
			start.setMinWidth(200);
			start.setMinHeight(30);
			start.setId("button");
			/*Set start button action*/
			start.setOnAction(e -> {
				try {
					output.setText(textAnalyzer().toString());
					System.out.println(textAnalyzer().toString());
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			});
			
			/*Create stop button*/
			Button stop = new Button();
			stop.setLayoutX(100);
			stop.setLayoutY(750);
			stop.setText("Close Program");
			stop.setMinWidth(200);
			stop.setMinHeight(30);
			stop.setId("button");
			/*Set stop button action*/
			stop.setOnAction(e -> {
				primaryStage.close();
			});
			
			/*Set root children and establish scene*/
			root.getChildren().addAll(textFlow, start, stop, output);
			Scene scene = new Scene(root,400,800);
			scene.setFill(Color.rgb(0, 0, 0));
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static String removeSpecialChars(String str){ //Method to remove any special characters to isolate words
		str = str.toLowerCase();
		str = str.replaceAll("[^a-zA-Z0-9\\s]", "");
		str.split(" ");
	return str;  
	}
	public static TreeMap<String, Integer> sortMapKey(Map<String, Integer> words) { //Method to sort the map
		TreeMap<String, Integer> sortedMap = new TreeMap<>();
		sortedMap.putAll(words);
		return sortedMap;
    }
	static <K,V extends Comparable<? super V>>SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
	    SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(new Comparator<Map.Entry<K,V>>() {
	            @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
	                int res = e2.getValue().compareTo(e1.getValue());
	                return res != 0 ? res : 1;
	            }
	        }
	    );
	    sortedEntries.addAll(map.entrySet());
	    return sortedEntries;
	}
	
		static void textCounter(String fName, Map< String, Integer> words) throws FileNotFoundException{ //Method to count the words
			int wordCounter = 0;
			FileReader fr = new FileReader(fName);
			BufferedReader br = new BufferedReader(fr);
			Scanner poem=new Scanner (br);
			while(poem.hasNext()){
				String word = poem.next();
				word = removeSpecialChars(word);
				Integer counter = words.get(word);
				if(counter != null) {
					counter++;
				}
				else {
					counter = 1;
				}
				words.put(word,counter);
				
				wordCounter++;
			}
			sortMapKey(words);
			poem.close();
		}
		static StringBuilder textAnalyzer() throws FileNotFoundException {
			Map<String,Integer> words = new TreeMap<String, Integer>();
			textCounter("AssignmentPoem.txt",words);
			SortedSet<Entry<String, Integer>> sortedWords = entriesSortedByValues(words);
			Iterator<Entry<String, Integer>> value = sortedWords.iterator();
			int numCount = 0;
			StringBuilder str = new StringBuilder();
			while (value.hasNext()) {
				if(numCount <= 19) {
					Entry<String, Integer> entry = value.next();
					str.append(entry);
					str.append("\n");
					numCount++;
				}
				if(numCount == 20) {
					break;
				}
			}
			return str;
		}
	
	public static void main(String[] args) {
		launch(args);
	}
}
