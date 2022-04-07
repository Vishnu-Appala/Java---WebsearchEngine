package SearchEngine;
//Importing the package
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
//importing all required libraries
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
//main class
public class ParseURL {
	//Save Doc Function for saving html files
	public static void saveDoc(Document doc, String stUrl) {
		try {
			PrintWriter htm = new PrintWriter(new FileWriter(Path.htmlDirectoryPath + doc.title().replace('/', '_') + ".html"));
			htm.write(doc.toString());
			htm.close();
			htt(Path.htmlDirectoryPath + doc.title().replace('/', '_') + ".html", stUrl,doc.title().replace('/', '_') + ".txt");

		} catch (Exception e) {

		}

	}
	//HTml to Text Function to save text files
	public static void htt(String htmlfile, String stUrl, String filename) throws Exception {
		File file = new File(htmlfile);
		Document doc = Jsoup.parse(file, "UTF-8");
		String data = doc.text().toLowerCase();
		data = stUrl + "::" + data;
		PrintWriter writer = new PrintWriter(Path.txtDirectoryPath + filename);
		writer.println(data);
		writer.close();
	}

}
