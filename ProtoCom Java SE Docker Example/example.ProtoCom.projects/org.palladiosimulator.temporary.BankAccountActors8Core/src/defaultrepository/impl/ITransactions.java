package defaultrepository.impl;


import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import defaultrepository.ITransaction;

public interface ITransactions {
    void setContext(Object myContext);

    void setComponentFrame(SimulatedStackframe<Object> myComponentStackFrame);

    SimulatedStackframe<Object> iTransaction_executeTransaction0(StackContext ctx);

    ITransaction getPortProvided_ITransaction_Transaction();
}
