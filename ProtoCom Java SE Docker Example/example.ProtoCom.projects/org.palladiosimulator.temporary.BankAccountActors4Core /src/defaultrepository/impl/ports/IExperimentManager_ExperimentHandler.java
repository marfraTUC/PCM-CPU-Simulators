package defaultrepository.impl.ports;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import defaultrepository.IExperimentManager;
import defaultrepository.impl.IExperimentHandler;
import defaultrepository.impl.contexts.ExperimentHandlerContext;

public class IExperimentManager_ExperimentHandler implements IExperimentManager {

    public String componentName;
    public IExperimentHandler myComponent;

    /**
     * @param myComponent
     * @param assemblyContext
     */
    public IExperimentManager_ExperimentHandler(IExperimentHandler myComponent, String assemblyContext) {
        this.myComponent = myComponent;
        this.componentName = "IExperimentManager_ExperimentHandler_" + assemblyContext;
    }

    public SimulatedStackframe<Object> simulateTransactions0(StackContext ctx) {
        SimulatedStackframe<Object> result = myComponent.iExperimentManager_simulateTransactions0(ctx);
        return result;
    }

    @Override
    public void setComponentFrame(SimulatedStackframe<Object> componentStackFrame) {
        this.myComponent.setComponentFrame(componentStackFrame);
    }

    @Override
    public void setContext(ExperimentHandlerContext context) {
        this.myComponent.setContext(context);
    }
}
