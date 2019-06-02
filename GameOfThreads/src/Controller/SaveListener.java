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

import Model.MutableBoard;

public class SaveListener implements ActionListener {
	
	private MutableBoard board;
	
	public SaveListener(MutableBoard board)
	{
		this.board = board;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(new File("saved.txt"));
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			// Write objects to file
			objectOutputStream.writeObject(board);


			objectOutputStream.close();
			objectOutputStream.flush();
			fileOutputStream.close();
			System.exit(0);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found");
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("Error initializing stream");
		}
	}
}
