package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveListener implements ActionListener {
	
	BoardHistory history;
	
	public SaveListener(BoardHistory History)
	{
		this.history = history;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			FileOutputStream f = new FileOutputStream(new File("saved.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Write objects to file
			o.writeObject(history);
			

			o.close();
			f.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
		
	}

}
