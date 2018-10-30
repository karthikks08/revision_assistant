import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		RevisionPlanner planner =  new RevisionPlanner();
		String command = null;
		if(args.length == 1){
			command = args[0].toUpperCase();
		    switch(command){
				case "ADD" : planner.add(userInput());
							 break;
				case "REMOVE" : try{
					            planner.remove(Integer.parseInt(userInput()));
							}catch(Exception e){
								System.out.println(e.getMessage());
							}break;
				default: planner.help();
						 break;
		    }
       	}else{
			planner.todaysTopics();
		}
	}
	public static String userInput(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Type topic name: ");
		String input = sc.nextLine();
		sc.close();
		return input;
	}
}