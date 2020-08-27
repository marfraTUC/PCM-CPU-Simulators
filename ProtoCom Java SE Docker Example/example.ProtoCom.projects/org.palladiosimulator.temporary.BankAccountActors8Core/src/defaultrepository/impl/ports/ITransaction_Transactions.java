package defaultrepository.impl.ports;


import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import defaultrepository.ITransaction;
import defaultrepository.impl.ITransactions;
import defaultrepository.impl.contexts.TransactionsContext;


public class ITransaction_Transactions implements ITransaction {

    public String componentName;
    public ITransactions myComponent;

    /**
     * @param myComponent
     * @param assemblyContext
     */
    public ITransaction_Transactions(ITransactions myComponent, String assemblyContext) {
        this.myComponent = myComponent;
        this.componentName = "ITransaction_Transactions_" + assemblyContext;
    }

    public SimulatedStackframe<Object> executeTransaction0(StackContext ctx) {
        // PRE
        SimulatedStackframe<Object> result = myComponent.iTransaction_executeTransaction0(ctx);
        // POST
        return result;
    }

    @Override
    public void setComponentFrame(SimulatedStackframe<Object> componentStackFrame) {
        this.myComponent.setComponentFrame(componentStackFrame);
    }

    @Override
    public void setContext(TransactionsContext context) {
        this.myComponent.setContext(context);
    }


}
