import java.util.*;
import java.io.File;

/**
 * The Class FileLoader.
 */
public class FileLoader {

	
 /**
  * Load puzzle.
  *
  * @param pathway the pathway
  * @return the map
  * @throws Exception the exception
  */
 public static Map<String,ArrayList<String>> loadPuzzle(String pathway)
   throws Exception {
	 
	 File file = new File(pathway);
	 Scanner scan = new Scanner(file);
	 ArrayList<String> puzzle1 = new ArrayList<String>();
	 ArrayList<String> puzzle2 = new ArrayList<String>();
	 ArrayList<String> puzzle3 = new ArrayList<String>();
	 ArrayList<String> clues = new ArrayList<String>();
	 Map<String,ArrayList<String>> map =new HashMap<String, ArrayList<String>>();

	 
	 
	 if (scan.hasNextLine()) {
		 String[] puzzleCategories = scan.nextLine().split("-");
		 Collections.addAll(puzzle1, puzzleCategories);
	 }
	 
	 if (scan.hasNextLine()) {
		 String[] puzzleCategories = scan.nextLine().split("-");
		 Collections.addAll(puzzle2, puzzleCategories);
	 }
	 if (scan.hasNextLine()) {
		 String[] puzzleCategories = scan.nextLine().split("-");
		 Collections.addAll(puzzle3, puzzleCategories);
	 }
	 
	 while(scan.hasNextLine()){
		 clues.add(scan.nextLine());
	 }
	 
	  map.put("puzzleOne",puzzle1);
	  map.put("puzzleTwo",puzzle2);
	  map.put("puzzleThree",puzzle3); 
	  map.put("clues", clues);
	  
	  if(map.size() <4)
		  throw new Exception("Not enough loaded categories or clues");

  return map;
 }
}
