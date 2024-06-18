package sumitframework.basepackage;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;

import java.nio.file.StandardOpenOption;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public  List<HashMap<String, String>> readData() throws IOException
	{
		//converted JSON file to String
		//File f=new File("E:\\seleniumframework\addBook.json");
	String s =new String(Files.readAllBytes(Paths.get("E:\\seleniumframework\\data.json")));
		
	//convert String to Hash MAp
	ObjectMapper mapper=new ObjectMapper();
	TypeReference<List<HashMap<String,String>>> type=new TypeReference<List<HashMap<String,String>>>() {
	};
	List<HashMap<String,String>> listmap=	mapper.readValue(s, type);
	return listmap;
	
	
	}

}
