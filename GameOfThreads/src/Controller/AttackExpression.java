package Controller;

public class AttackExpression extends Expression
{
	//terminal expression

	@Override
	public AttackCommand interperet(SquareContext context)
	{
		return new AttackCommand(context.getCurrentX(), context.getCurrentY(), context.getFirstX(), context.getFirstY());
	}
}
