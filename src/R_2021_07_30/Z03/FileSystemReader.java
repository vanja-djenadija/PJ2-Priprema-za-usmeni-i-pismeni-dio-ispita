package R_2021_07_30.Z03;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;

public class FileSystemReader
{
	public void ocitaj(QuoteStorage qs, String s)
	{
		qs.quotes.clear();
		File file = new File(Main.PATH);
		File quotes[] = file.listFiles();
		for (File f : quotes)
		{
			try {
				if (f.getName().contains(s))
				{
					List<String> content = Files.readAllLines(f.toPath());
					for (String line : content)
						QuoteStorage.quotes.add(line);
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}