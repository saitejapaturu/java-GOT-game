package Controller;

public class AttackExpression extends Expression
{
	//Terminal expression For attack command
	@Override
	public AttackCommand interperet(SquareContext context)
	{
		return new AttackCommand(context.getCurrentX(), context.getCurrentY(), context.getFirstX(), context.getFirstY());
	}
}
