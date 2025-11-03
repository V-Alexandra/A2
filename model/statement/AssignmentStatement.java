package model.statement;

import exceptions.InvalidTypeException;
import exceptions.VariableNotDefinedException;
import model.adt.MyDictionary;
import model.adt.MyIDictionary;
import model.expression.IExpression;
import model.program_state.ProgramState;
import model.value.IValue;

public class AssignmentStatement implements IStatement {
    private String key;
    private IExpression expression;

    public AssignmentStatement(String key, IExpression expression) {
        this.key = key;
        this.expression = expression;
    }

    @Override
    public ProgramState execute(ProgramState programState) {
        MyIDictionary<String, IValue> symbolTable = programState.getSymTable();
        if (!symbolTable.containsKey(key)) {
            throw new VariableNotDefinedException();
        }
        IValue value = expression.evaluate((MyDictionary<String, IValue>) symbolTable); //error
        if (value.getType().equals((symbolTable.lookup(key)).getType())) {
            symbolTable.update(key, value);
        } else
            throw new InvalidTypeException();
        programState.setSymTable(symbolTable);
        return programState;
    }

}
