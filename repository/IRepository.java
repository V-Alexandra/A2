package repository;

import model.program_state.ProgramState;

import java.util.List;

public interface IRepository {
    List<ProgramState> getProgramStates();
    void addProgram(ProgramState programState);
    ProgramState getCurrentState();
    void setProgramStates(List<ProgramState> programStates);
}
