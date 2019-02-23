import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sun.javafx.css.CalculatedValue;

public class Calculator {

	// to check target file whether exists and open it.
	private Scanner file;
	public void openFile() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please insert file path and name");
		
		String path = scan.nextLine();
		if (File.separator.equals("/")) {
			path = path.replace("/", File.separator);
		}
		else if (File.separator.equals("\\")) {
			path = path.replace("\\", File.separator);
		}
		
		Path target = Paths.get(path + ".txt");
		if (Files.exists(target)) {
			try {
				file = new Scanner(new File(path + ".txt"));
			} catch (Exception e) {
				e.getMessage();
			}
		}
		else {
			System.out.println("file does not exist");
		}
	}

	
	// to read all lines from file and add them List
	public void readFile() {
		List<String> list = new ArrayList<String>();
		while (file.hasNext()) {
			String line = file.nextLine();
			list.add(line);
			}
		
		float apply = findApply(list); 					// value of Apply
		System.out.println(calculate(list,apply)); 		// final result
	}
	
	// to determine Apply
	public float findApply(List<String> list) {
		String lastLine = list.get(list.size()-1); //Apply is supposed to be last line
		String partApply[] = lastLine.split(" ");
		String strApply = partApply[0]; // String part of Apply line
		String numApply = partApply[1]; // Number part of Apply line
		
		int apply = Integer.parseInt(numApply);
		if (strApply.equals("apply")) {
			return apply;
		}else {
			System.out.println("value of Apply is not found, please check input file");
		}
		return apply;
	}
	
	
	private float calculate(List<String> list, float result) {
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			String part[] = str.split(" ");
			String partStr = part[0];
			String partNum = part[1];
			
			int num = Integer.parseInt(partNum);
			
			if (partStr.equals("add")) {
				result = add(result, num);
			}
			
			else if (partStr.equals("multiply")) {
				result = multiply(result, num);
			}
			
			else if (partStr.equals("divide")) {
				result = divide(result, num);
			}
			
			else if (partStr.equals("substract")) {
				result = substract(result, num);
			}
		}
		return result;
	}
	
	public float add(float add, int num) {
		return add + num;
	}

	public float multiply(float multiply, int num) {
		return multiply * num;
	}

	public float substract(float substract, int num) {
		return substract - num;
	}

	public float divide(float divide, int num) {
		if (num == 0) {
			throw new ArithmeticException("Cannot be divided by zero!");
		}else {
			return divide /(float) num;
		}
	}

	
	
	public void closeFile() {
		file.close();
	}

}
