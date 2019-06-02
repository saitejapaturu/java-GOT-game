package Controller;

public class MoveExpression extends Expression{
	//terminal expression

	@Override
	public MoveCommand interperet(SquareContext context) {
		// TODO Auto-generated method stub
		return new MoveCommand(context.getCurrentX(), context.getCurrentY(), context.getFirstX(), context.getFirstY());
	}

	

}
