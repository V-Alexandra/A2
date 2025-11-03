package controller;

import exceptions.StackIsEmptyException;
import model.adt.MyIStack;
import model.program_state.ProgramState;
import model.statement.IStatement;
import repository.IRepository;

import java.util.Stack;

public class Controller {
    IRepository repository;
    boolean displayFlag = false;
    public void setDisplayFlag(boolean displayFlag) {
        this.displayFlag = displayFlag;
    }

    public Controller(IRepository repository) {
        this.repository = repository;
    }

    public ProgramState oneStep(ProgramState state) {
        MyIStack<IStatement> stack = state.getExeStack();
        if(stack.isEmpty())
            throw new StackIsEmptyException();
        IStatement currentStatement = stack.pop();
        state.setExeStack(stack);
        return currentStatement.execute(state);
    }

    public void allSteps(){
        ProgramState program = this.repository.getCurrentState();
        display();
        while(!program.getExeStack().isEmpty()) {
            oneStep(program);
            display();
        }

    }

    private void display(){
        if(displayFlag){
            System.out.println(this.repository.getCurrentState().toString());
        }
    }
}
