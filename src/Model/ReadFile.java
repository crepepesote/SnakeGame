package Model;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class ReadFile {

	private JsonReader reader;

	private ArrayList<Levels> levels;

	public ReadFile() {
		levels = new ArrayList<>();
	}

	public void readFiles() throws IOException {
		reader = new Gson().newJsonReader(new FileReader("data/levels.json"));
		Levels[] ls = new Gson().fromJson(reader, Levels[].class);
		for (int i = 0; i < ls.length; i++) {
			levels.add(ls[i]);
		}
	}

	public String[] comprobate(String name, String level, int points) {
		return null;
	}

	public ArrayList<Levels> getLevels() {
		return levels;
	}

	public void setLevels(ArrayList<Levels> levels) {
		this.levels = levels;
	}
}
