package defaultrepository.impl;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import defaultrepository.IExperimentManager;

public interface IExperimentHandler {
    void setContext(Object myContext);

    void setComponentFrame(SimulatedStackframe<Object> myComponentStackFrame);

    SimulatedStackframe<Object> iExperimentManager_simulateTransactions0(StackContext ctx);

    IExperimentManager getPortProvided_IExperimentManager_ExperimentHandler();
}
