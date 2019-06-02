package Controller;

public class InvalidExpression extends Expression
{
//terminal expression
	@Override
	public MoveCommand interperet(SquareContext context)
	{
		// invoked when move is invalid
		return null;
	}
}
