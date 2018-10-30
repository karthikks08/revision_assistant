public interface Revision{
	void help();
	void add(String topic);
	boolean remove(int index);
	void display();
}