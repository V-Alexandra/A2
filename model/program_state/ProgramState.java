package model.program_state;

import model.adt.MyIDictionary;
import model.adt.MyIList;
import model.adt.MyIStack;
import model.statement.IStatement;
import model.value.IValue;

public class ProgramState {
    private MyIStack<IStatement> exeStack;
    private MyIDictionary<String, IValue> symTable;
    private MyIList<IValue> out;
    private IStatement originalProgram;

    public ProgramState(MyIStack<IStatement> exeStack, MyIDictionary<String, IValue> symTable, MyIList<IValue> out, IStatement originalProgram) {
        this.exeStack = exeStack;
        this.symTable = symTable;
        this.out = out;
        this.originalProgram = originalProgram.deepCopy();
        this.exeStack.push(originalProgram);
    }

    public MyIStack<IStatement> getExeStack() {
        return exeStack;
    }

    public void setExeStack(MyIStack<IStatement> exeStack) {
        this.exeStack = exeStack;
    }

    public MyIDictionary<String, IValue> getSymTable() {
        return symTable;
    }

    public void setSymTable(MyIDictionary<String, IValue> symTable) {
        this.symTable = symTable;
    }

    public MyIList<IValue> getOut() {
        return out;
    }

    public void setOut(MyIList<IValue> out) {
        this.out = out;
    }

    public IStatement getOriginalProgram() {
        return originalProgram;
    }

    public void setOriginalProgram(IStatement originalProgram) {
        this.originalProgram = originalProgram;
    }

    public String exeStackToString() {
        return exeStack.toString();
    }

    public String symTableToString() {
        return symTable.toString();
    }

    public String outListToString() {
        return out.toString();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProgramState:\n");
        sb.append("  ExeStack:\n");
        if (exeStack.toString().equals("[]")) {
            sb.append("    (empty)\n");
        } else {
            sb.append("    ").append(exeStack.toString()).append("\n");
        }
        sb.append("  SymTable:\n");
        if (symTable.toString().equals("{}")) {
            sb.append("    (empty)\n");
        } else {
            sb.append("    ").append(symTable.toString()).append("\n");
        }
        sb.append("  Out:\n");
        if (out.toString().equals("[]")) {
            sb.append("    (empty)");
        } else {
            sb.append("    ").append(out.toString());
        }
        return sb.toString();
    }

}
