package Client;

import Model.MutableBoard;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import View.MainFrame;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;

import javax.swing.*;

import Controller.BoardHistory;
import Controller.TurnController;

public class GOTClient
{
	public static void main(String[] args)
	{
		//board.newBoard();
		
		TurnController turnController = new TurnController();

		FileInputStream filein;
		try {
			filein = new FileInputStream(new File("saved.txt"));
			ObjectInputStream objectin = new ObjectInputStream(filein);
			MutableBoard board = (MutableBoard) objectin.readObject();
			
			filein.close();
			objectin.close();
		} catch (FileNotFoundException e) {
			System.out.println("No saved history");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				MainFrame mainFrame = new MainFrame("Game Of Threads", board, turnController);

			}
		});
	}
}
