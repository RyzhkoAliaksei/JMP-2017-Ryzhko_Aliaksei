package com.epam.mentoring.MemoryManagement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CustomFileReader {

	public static final StringBuilder readFile(String fileName) {
		StringBuilder sb = new StringBuilder();
		Scanner s = null;
		FileReader fr = null;
		try {
			fr = new FileReader(fileName);
			s = new Scanner(fr);
			while (s.hasNextLine()) {
				sb.append(s.nextLine() + "\n");
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found " + fileName + " " + e);
		} finally {
			if (s != null) {
				s.close();
			}
		}
		return sb;
	}
}
