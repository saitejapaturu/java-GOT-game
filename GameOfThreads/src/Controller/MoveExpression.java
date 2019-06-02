package Controller;

public class MoveExpression extends Expression
{
	//terminal expression

	@Override
	public MoveCommand interperet(SquareContext context)
	{
		return new MoveCommand(context.getCurrentX(), context.getCurrentY(), context.getFirstX(), context.getFirstY());
	}
}
