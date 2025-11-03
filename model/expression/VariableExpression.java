package model.expression;

import model.adt.MyDictionary;
import model.value.IValue;

public class VariableExpression implements IExpression {
    String key;

    public VariableExpression(String key) {
        this.key = key;
    }

    @Override
    public IValue evaluate(MyDictionary<String, IValue> symbolTable) {
        return symbolTable.lookup(key);
    }

    @Override
    public String toString() {
        return this.key;
    }
}
