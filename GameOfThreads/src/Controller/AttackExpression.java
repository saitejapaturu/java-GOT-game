package Controller;

public class AttackExpression extends Expression{
	//terminal expression

	@Override
	public Command interperet(SquareContext context) {
		// TODO Auto-generated method stub
		return new AttackCommand();
	}


}
