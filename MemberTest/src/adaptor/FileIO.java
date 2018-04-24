package adaptor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import mediator.ModelManager;

public class FileIO implements Adaptor {
	@Override
	public ModelManager getModel() {
		try {
			FileInputStream fstream = new FileInputStream("ModelManager.ser");
			ObjectInputStream objStream = new ObjectInputStream(fstream);
			ModelManager model = (ModelManager) objStream.readObject();
			objStream.close();
			return model;
		} catch (FileNotFoundException e) {
			System.out.println("File not found. Creating new file");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public void setModel(ModelManager model) {
		try {
			FileOutputStream fstream = new FileOutputStream("ModelManager.ser");
			ObjectOutputStream outputFile = new ObjectOutputStream(fstream);
			outputFile.writeObject(model);
			outputFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
