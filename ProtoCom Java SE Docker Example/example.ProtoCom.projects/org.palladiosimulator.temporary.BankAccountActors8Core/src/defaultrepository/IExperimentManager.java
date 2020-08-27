package defaultrepository;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import defaultrepository.impl.contexts.ExperimentHandlerContext;

/**
 * @author Sebastian Graef
 */
public interface IExperimentManager {

    SimulatedStackframe<Object> simulateTransactions0(StackContext ctx);

    void setComponentFrame(SimulatedStackframe<Object> componentStackFrame);

    void setContext(ExperimentHandlerContext context);
}
