package Persistence;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import Logic.Client;

public class FileClient extends FilePlain{
	
	public void pushJson(ArrayList<Client> clients) throws IOException{
		//Guarda
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		String collection=gson.toJson(clients);
		writeFile(collection);
	}
	
	public ArrayList<Client> pullJson() throws IOException{
		//Lee
		String json=readFile();
		Gson gson=new Gson();
		Type type=new TypeToken<ArrayList<Client>>(){}.getType();
		return gson.fromJson(json, type);
	}
}
