package Persistence;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import Logic.Driver;

public class FileDriver extends FilePlain{
	public void pushJson(ArrayList<Driver> driver) throws IOException{
		//Guarda
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		String collection=gson.toJson(driver);
		writeFile(collection);
	}
	
	public ArrayList<Driver> pullJson() throws IOException{
		//Lee
		String json=readFile();
		Gson gson=new Gson();
		Type type=new TypeToken<ArrayList<Driver>>(){}.getType();
		return gson.fromJson(json, type);
	}

}
