public class Main{
	public static void main(String[] args) {
		RevisionPlanner planner =  new RevisionPlanner();
		for(int i = 1; i < 30; i++){
		   planner.add(i + "");
		}
		planner.display();
	}
}