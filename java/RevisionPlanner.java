import java.io.*;
import java.time.LocalDate;

public class RevisionPlanner implements Revision{
	private int[] revisionGaps = { 0, 1, 2, 3, 5, 7, 10, 15, 15, 30};

	@Override
	public void help(){

	}

	@Override
	public void add(String topic){
		BufferedWriter writer = null;
		try{
			FileWriter file = new FileWriter("/home/karthik/Desktop/Oct29/revision_assistant/files/revision.txt", true);
			writer = new BufferedWriter(file);
			writer.write(LocalDate.now().plusDays(Integer.parseInt(topic)) + "," + topic + "\n");
			writer.close();
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

	@Override
	public boolean remove(int index){
		return false;
	}

    @Override
	public void display(){
		BufferedReader reader = null;
		try{
			FileReader fReader = new FileReader("/home/karthik/Desktop/Oct29/revision_assistant/files/revision.txt");
			reader = new BufferedReader(fReader);
			String line = null;
			while((line = reader.readLine()) != null){
				System.out.println(line);
			}
			reader.close();
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}



}