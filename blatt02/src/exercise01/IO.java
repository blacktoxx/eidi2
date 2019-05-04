package exercise01;

import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.charset.StandardCharsets;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;


public class IO {

	public static void main(String[] args) {
		
		//TODO: Gedicht.txt einlesen, ausgeben und in Gelesen.txt abspeichern 1c)	
		
		
	}
	
	public static String readFile(String file) {
		
		//TODO: 1a)
		
		Path pathToFile = Paths.get(file);
		StringBuilder sb = new StringBuilder();
		
		try {
			BufferedReader reader = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8);
			
			while(reader.ready()) {
				sb.append(reader.readLine());
				sb.append(String.format("%n"));
			}
			
			reader.close();
		}catch (NoSuchFileException e) {
			System.err.println(String.format("Die Datei \"%s\" existiert nicht!", pathToFile));
		}catch (IOException e) {
			System.err.println("Sonstiger IO-Fehler!");
		}
		
		return new String(sb);
	}
	
	
	public static void writeFile(String file, String data) {
		//TODO: 1b)
	
		Path pathToFile = Paths.get(file);
		
		try {
			BufferedWriter writer = Files.newBufferedWriter(pathToFile, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
			
			writer.write(data);
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}	
}
