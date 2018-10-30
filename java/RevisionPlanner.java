import java.io.*;
import java.time.LocalDate;

public class RevisionPlanner{
	// 1-today, 2-previous day, 4-topics before 3 days
	private int[] revisionGaps = { 1, 2, 4, 7, 12, 20, 30, 45, 60};
	public void help(){

	}

	public void add(String topic){
		BufferedWriter writer = null;
		BufferedReader reader = null;
		// read all lines
		String oldText = "";
		try{
			FileReader fReader = new FileReader("/home/karthik/Desktop/Oct29/revision_assistant/files/revision.txt");
			reader = new BufferedReader(fReader);
			String line = null;
			line = reader.readLine();
			// Test first line
			if(line != null && isToday(line.split(":")[0])){
				// adding more topics on same day
				oldText = line + "," +  topic;
			}else{
				// add first topic of the day
				oldText = LocalDate.now() + ":" + topic;
				oldText = oldText + "\n" + ((line != null) ? line : "");				
			}
			while((line = reader.readLine()) != null){
				oldText = oldText + "\n" + line;				
			}
			reader.close();
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		try{
			FileWriter file = new FileWriter("/home/karthik/Desktop/Oct29/revision_assistant/files/revision.txt");
			writer = new BufferedWriter(file);
			writer.write(oldText);
			writer.close();
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

	public boolean remove(int index){
		return false;
	}

	private boolean isToday(String date){
		return LocalDate.now().toString().equals(date);
	}

	public void todaysTopics(){
		BufferedReader reader = null;
		try{
			FileReader fReader = new FileReader("/home/karthik/Desktop/Oct29/revision_assistant/files/revision.txt");
			reader = new BufferedReader(fReader);
			String line = null;
			int lineCount = 0;
			int nextRevisionGap = 0;
			while((line = reader.readLine()) != null){
				lineCount++;
				if(lineCount == revisionGaps[nextRevisionGap]){
					System.out.println(line);
					nextRevisionGap++;
				}
			}
			reader.close();
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}



}
