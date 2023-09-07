package Persistence;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import Logic.Serivicio;


public class FileServicio extends FilePlain{
	
	
	public void pushJson(ArrayList<Serivicio> servicios) throws IOException{
		//Guarda
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		String collection=gson.toJson(servicios);
		writeFile(collection);
	}
	
	public ArrayList<Serivicio> pullJson() throws IOException{
		//Lee
		String json=readFile();
		Gson gson=new Gson();
		Type type=new TypeToken<ArrayList<Serivicio>>(){}.getType();
		return gson.fromJson(json, type);
	}

}
