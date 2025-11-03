package model.statement;

import model.adt.MyIStack;
import model.program_state.ProgramState;

public class CompoundStatement  implements IStatement {
    IStatement firstStatement;
    IStatement secondStatement;
    public CompoundStatement(IStatement firstStatement, IStatement secondStatement) {
        this.firstStatement = firstStatement;
        this.secondStatement = secondStatement;
    }
    @Override
    public ProgramState execute(ProgramState programState) {
        MyIStack<IStatement> stack = programState.getExeStack();
        stack.push(secondStatement);
        stack.push(firstStatement);
        programState.setExeStack(stack);
        return programState;
    }
    @Override
    public String toString() {
        return String.format("(%s|%s)", firstStatement.toString(), secondStatement.toString());
    }
}
