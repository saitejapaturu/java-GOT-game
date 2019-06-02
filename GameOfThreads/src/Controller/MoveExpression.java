package Controller;

public class MoveExpression extends Expression{
	//terminal expression

	@Override
	public Command interperet(SquareContext context) {
		// TODO Auto-generated method stub
		return new MoveCommand();
	}

	

}
