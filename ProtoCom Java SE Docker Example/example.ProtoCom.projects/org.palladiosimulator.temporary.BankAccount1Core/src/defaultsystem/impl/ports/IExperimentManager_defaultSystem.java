package defaultsystem.impl.ports;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import defaultrepository.IExperimentManager;
import defaultrepository.impl.contexts.ExperimentHandlerContext;
import defaultsystem.impl.IdefaultSystem;

import java.io.Serializable;


public class IExperimentManager_defaultSystem implements IdefaultSystem, IExperimentManager, Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    protected IdefaultSystem myCompositeComponent;
    protected IExperimentManager myInnerPort;

    public IExperimentManager_defaultSystem(IExperimentManager myInnerPort, IdefaultSystem myComponent, String assemblyContext) {
        this.myInnerPort = myInnerPort;
        this.myCompositeComponent = myComponent;
    }

    public SimulatedStackframe<Object> simulateTransactions0(StackContext ctx) {
        return myInnerPort.simulateTransactions0(ctx);
    }


    @Override
    public IExperimentManager getPortProvided_IExperimentManager() {
        return this.myInnerPort;
    }

    public void setComponentFrame(SimulatedStackframe<Object> myComponentStackFrame) {
        this.myInnerPort.setComponentFrame(myComponentStackFrame);
    }

    @Override
    public void setContext(ExperimentHandlerContext context) {
        this.myCompositeComponent.setContext(context);
    }

    @Override
    public void setContext(Object context) {
        this.myCompositeComponent.setContext(context);
    }

    public IdefaultSystem getComponent() {
        return myCompositeComponent;
    }
}
