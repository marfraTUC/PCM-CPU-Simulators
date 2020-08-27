package defaultrepository;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import defaultrepository.impl.contexts.TransactionsContext;

public interface ITransaction {

    SimulatedStackframe<Object> executeTransaction0(StackContext ctx);

    void setComponentFrame(SimulatedStackframe<Object> componentStackFrame);

    void setContext(TransactionsContext context);

}
