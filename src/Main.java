public class Main {
	public static void main(String[] args) {
		Calculator file = new Calculator();
		file.openFile();
		file.readFile();
		file.closeFile();
	}

}
