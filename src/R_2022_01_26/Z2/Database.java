import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.time.LocalDate;

public class Database extends Thread{

	String putanja;

	public Database(String putanja){
		this.putanja = putanja;
		start();
	}
	
	@Override
	public void run(){
		
		// deserijalizuje fajl iz foldera sa današnjim datumom
		String date = LocalDate.now().toString();
		String bin = "." + File.separator + date + File.separator + new File(putanja).getName().split("\\.")[0]  + ".bin";
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bin))){
			List<String> lines = (List<String>) ois.readObject();
			for(String line : lines){
				String[] parts = line.split("");
				for(String znak : parts){
					new Character(znak).join();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}