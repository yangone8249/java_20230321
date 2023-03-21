package day17;

import java.io.IOException;
import java.util.Scanner;

public interface WordInterface {
	
	void add(Scanner scan) throws IOException;
	void print();
	void read(Scanner scan);
	void update(Scanner scan);
	void delete(Scanner scan);	
}
