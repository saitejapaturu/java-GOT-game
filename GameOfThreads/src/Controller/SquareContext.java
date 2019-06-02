package Controller;

public class SquareContext {
	
	private String context = "";
	
	private int currentX;
	private int currentY;
	
	private int firstX;
	private int firstY;
	
	private int click = 0;
	
	String[] partsOfContext;
	
	public SquareContext(String info)
	{
		context = info;
		partsOfContext = getContext().split("-");
		currentX = Integer.valueOf(partsOfContext[0]);
		currentY = Integer.valueOf(partsOfContext[1]);
		
		firstX = Integer.valueOf(partsOfContext[2]);
		firstY = Integer.valueOf(partsOfContext[3]);

		click = Integer.valueOf(partsOfContext[4]);
	}
	
	public String getContext()
	{
		return context;
	}
	
	public int getCurrentX()
	{
		return currentX;
	}
	
	public int getCurrentY()
	{
		return currentY;
	}
	
	public int getFirstX()
	{
		return firstX;
	}
	
	public int getFirstY()
	{
		return firstY;
	}
	
	public int getClick()
	{
		return click;
	}
}
