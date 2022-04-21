package commonLibraries;

import java.util.Random;

public class JavaLibrary {
public int getRandomNumber() {
	Random r=new Random();
	int random = r.nextInt(1000);
	return random;
}
}
