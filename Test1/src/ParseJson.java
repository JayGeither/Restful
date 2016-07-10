import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

//example parse
public class ParseJson {

	public static void main(String[] args) throws IOException {

		
		try {
			URL url = new URL("http://jsonplaceholder.typicode.com/users");
			InputStream is = url.openStream();
			JsonReader rdr = Json.createReader(is);
			//JsonObject obj  = rdr.readObject();
			
			JsonArray arr = rdr.readArray();
			
			JsonObject obj2 = arr.getJsonObject(0);
			System.out.println(obj2.getString("id"));
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
