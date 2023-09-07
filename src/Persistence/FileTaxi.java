package Persistence;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import Logic.Taxi;

public class FileTaxi extends FilePlain{
	
	public void pushJson(ArrayList<Taxi> taxis) throws IOException{
		//Guarda
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		String collection=gson.toJson(taxis);
		writeFile(collection);
	}
	
	public ArrayList<Taxi> pullJson() throws IOException{
		//Lee
		String json=readFile();
		Gson gson=new Gson();
		Type type=new TypeToken<ArrayList<Taxi>>(){}.getType();
		return gson.fromJson(json, type);
	}

}
