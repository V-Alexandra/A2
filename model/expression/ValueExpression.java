package model.expression;

import model.adt.MyDictionary;
import model.value.IValue;

public class ValueExpression implements IExpression {
    private IValue value;

    public ValueExpression(IValue value) {
        this.value = value;
    }

    @Override
    public IValue evaluate(MyDictionary<String, IValue> symbolTable) {
        return value;
    }
}
