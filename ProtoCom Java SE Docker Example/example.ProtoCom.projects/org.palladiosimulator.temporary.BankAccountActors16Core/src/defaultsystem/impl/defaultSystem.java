package defaultsystem.impl;


import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import defaultrepository.IExperimentManager;
import defaultrepository.ITransaction;
import defaultrepository.impl.ExperimentHandler;
import defaultrepository.impl.Transactions;
import defaultrepository.impl.contexts.ExperimentHandlerContext;
import defaultrepository.impl.contexts.TransactionsContext;
import defaultsystem.impl.ports.IExperimentManager_defaultSystem;
import me.graef.sebastian.bachelor.thesis.SimulatorBuild;

import java.io.Serializable;

public class defaultSystem implements IdefaultSystem, Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private IExperimentManager m_portProvided_IExperimentManager;
    private IExperimentManager myAssembly_ExperimentHandler__ExperimentHandler_;
    private ITransaction myAssembly_Transactions2__Transactions_;
    private ITransaction myAssembly_Transactions1__Transactions_;
    private ITransaction myAssembly_Transactions3__Transactions_;
    private ITransaction myAssembly_Transactions4__Transactions_;
    private ITransaction myAssembly_Transactions5__Transactions_;
    private ITransaction myAssembly_Transactions6__Transactions_;
    private ITransaction myAssembly_Transactions7__Transactions_;
    private ITransaction myAssembly_Transactions8__Transactions_;
    private ITransaction myAssembly_Transactions9__Transactions_;
    private ITransaction myAssembly_Transactions10__Transactions_;
    private ITransaction myAssembly_Transactions11__Transactions_;
    private ITransaction myAssembly_Transactions12__Transactions_;
    private ITransaction myAssembly_Transactions13__Transactions_;
    private ITransaction myAssembly_Transactions14__Transactions_;
    private ITransaction myAssembly_Transactions15__Transactions_;
    private ITransaction myAssembly_Transactions16__Transactions_;

    private defaultSystem(String assemblyContextID) {
        initInnerComponents();

        try {
            m_portProvided_IExperimentManager = new IExperimentManager_defaultSystem(
                    myAssembly_ExperimentHandler__ExperimentHandler_,
                    this, assemblyContextID);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SimulatorBuild.getHandlerMap().put("m_portProvided_IExperimentManager", m_portProvided_IExperimentManager);

    }

    public void setContext(Object myContext) {
    }

    private void initAssembly_ExperimentHandler__ExperimentHandler_() {
        ExperimentHandlerContext context = new ExperimentHandlerContext(
                myAssembly_Transactions1__Transactions_,
                myAssembly_Transactions2__Transactions_,
                myAssembly_Transactions3__Transactions_,
                myAssembly_Transactions4__Transactions_,
                myAssembly_Transactions5__Transactions_,
                myAssembly_Transactions6__Transactions_,
                myAssembly_Transactions7__Transactions_,
                myAssembly_Transactions8__Transactions_,
                myAssembly_Transactions9__Transactions_,
                myAssembly_Transactions10__Transactions_,
                myAssembly_Transactions11__Transactions_,
                myAssembly_Transactions12__Transactions_,
                myAssembly_Transactions13__Transactions_,
                myAssembly_Transactions14__Transactions_,
                myAssembly_Transactions15__Transactions_,
                myAssembly_Transactions16__Transactions_
        );

        SimulatedStackframe<Object> componentStackFrame = new SimulatedStackframe<Object>();
        myAssembly_ExperimentHandler__ExperimentHandler_.setComponentFrame(componentStackFrame);
        myAssembly_ExperimentHandler__ExperimentHandler_.setContext(context);
    }

    private void initAssembly_Transactions2__Transactions_() {
        TransactionsContext context = new TransactionsContext();
        SimulatedStackframe<Object> componentStackFrame = new SimulatedStackframe<Object>();
        myAssembly_Transactions2__Transactions_.setComponentFrame(componentStackFrame);
        myAssembly_Transactions2__Transactions_.setContext(context);
    }

    private void initAssembly_Transactions1__Transactions_() {
        TransactionsContext context = new TransactionsContext();
        SimulatedStackframe<Object> componentStackFrame = new SimulatedStackframe<Object>();
        myAssembly_Transactions1__Transactions_.setComponentFrame(componentStackFrame);
        myAssembly_Transactions1__Transactions_.setContext(context);
    }

    private void initAssembly_Transactions3__Transactions_() {
        TransactionsContext context = new TransactionsContext();
        SimulatedStackframe<Object> componentStackFrame = new SimulatedStackframe<Object>();
        myAssembly_Transactions3__Transactions_.setComponentFrame(componentStackFrame);
        myAssembly_Transactions3__Transactions_.setContext(context);
    }

    private void initAssembly_Transactions4__Transactions_() {
        TransactionsContext context = new TransactionsContext();
        SimulatedStackframe<Object> componentStackFrame = new SimulatedStackframe<Object>();
        myAssembly_Transactions4__Transactions_.setComponentFrame(componentStackFrame);
        myAssembly_Transactions4__Transactions_.setContext(context);
    }

    private void initAssembly_Transactions5__Transactions_() {
        TransactionsContext context = new TransactionsContext();
        SimulatedStackframe<Object> componentStackFrame = new SimulatedStackframe<Object>();
        myAssembly_Transactions5__Transactions_.setComponentFrame(componentStackFrame);
        myAssembly_Transactions5__Transactions_.setContext(context);
    }

    private void initAssembly_Transactions6__Transactions_() {
        TransactionsContext context = new TransactionsContext();
        SimulatedStackframe<Object> componentStackFrame = new SimulatedStackframe<Object>();
        myAssembly_Transactions6__Transactions_.setComponentFrame(componentStackFrame);
        myAssembly_Transactions6__Transactions_.setContext(context);
    }

    private void initAssembly_Transactions7__Transactions_() {
        TransactionsContext context = new TransactionsContext();
        SimulatedStackframe<Object> componentStackFrame = new SimulatedStackframe<Object>();
        myAssembly_Transactions7__Transactions_.setComponentFrame(componentStackFrame);
        myAssembly_Transactions7__Transactions_.setContext(context);
    }

    private void initAssembly_Transactions8__Transactions_() {
        TransactionsContext context = new TransactionsContext();
        SimulatedStackframe<Object> componentStackFrame = new SimulatedStackframe<Object>();
        myAssembly_Transactions8__Transactions_.setComponentFrame(componentStackFrame);
        myAssembly_Transactions8__Transactions_.setContext(context);
    }

    private void initAssembly_Transactions9__Transactions_() {
        TransactionsContext context = new TransactionsContext();
        SimulatedStackframe<Object> componentStackFrame = new SimulatedStackframe<Object>();
        myAssembly_Transactions9__Transactions_.setComponentFrame(componentStackFrame);
        myAssembly_Transactions9__Transactions_.setContext(context);
    }

    private void initAssembly_Transactions10__Transactions_() {
        TransactionsContext context = new TransactionsContext();
        SimulatedStackframe<Object> componentStackFrame = new SimulatedStackframe<Object>();
        myAssembly_Transactions10__Transactions_.setComponentFrame(componentStackFrame);
        myAssembly_Transactions10__Transactions_.setContext(context);
    }

    private void initAssembly_Transactions11__Transactions_() {
        TransactionsContext context = new TransactionsContext();
        SimulatedStackframe<Object> componentStackFrame = new SimulatedStackframe<Object>();
        myAssembly_Transactions11__Transactions_.setComponentFrame(componentStackFrame);
        myAssembly_Transactions11__Transactions_.setContext(context);
    }

    private void initAssembly_Transactions12__Transactions_() {
        TransactionsContext context = new TransactionsContext();
        SimulatedStackframe<Object> componentStackFrame = new SimulatedStackframe<Object>();
        myAssembly_Transactions12__Transactions_.setComponentFrame(componentStackFrame);
        myAssembly_Transactions12__Transactions_.setContext(context);
    }

    private void initAssembly_Transactions13__Transactions_() {
        TransactionsContext context = new TransactionsContext();
        SimulatedStackframe<Object> componentStackFrame = new SimulatedStackframe<Object>();
        myAssembly_Transactions13__Transactions_.setComponentFrame(componentStackFrame);
        myAssembly_Transactions13__Transactions_.setContext(context);
    }

    private void initAssembly_Transactions14__Transactions_() {
        TransactionsContext context = new TransactionsContext();
        SimulatedStackframe<Object> componentStackFrame = new SimulatedStackframe<Object>();
        myAssembly_Transactions14__Transactions_.setComponentFrame(componentStackFrame);
        myAssembly_Transactions14__Transactions_.setContext(context);
    }

    private void initAssembly_Transactions15__Transactions_() {
        TransactionsContext context = new TransactionsContext();
        SimulatedStackframe<Object> componentStackFrame = new SimulatedStackframe<Object>();
        myAssembly_Transactions15__Transactions_.setComponentFrame(componentStackFrame);
        myAssembly_Transactions15__Transactions_.setContext(context);
    }

    private void initAssembly_Transactions16__Transactions_() {
        TransactionsContext context = new TransactionsContext();
        SimulatedStackframe<Object> componentStackFrame = new SimulatedStackframe<Object>();
        myAssembly_Transactions16__Transactions_.setComponentFrame(componentStackFrame);
        myAssembly_Transactions16__Transactions_.setContext(context);
    }

    public IExperimentManager getPortProvided_IExperimentManager() {
        return m_portProvided_IExperimentManager;
    }

    private void initInnerComponents() {
        try {
            System.out.println("initInnerComponents");

            String assemblyContext = null;

            assemblyContext = "_C_A_IMuCEeaW7fkNf8_rhQ";
            myAssembly_ExperimentHandler__ExperimentHandler_ = ((ExperimentHandler) SimulatorBuild.getHandlerMap().get(assemblyContext)).getPortProvided_IExperimentManager_ExperimentHandler();

            assemblyContext = "_AjC3QBLkEeefhYGEQ4GM3w";
            myAssembly_Transactions2__Transactions_ = ((Transactions) SimulatorBuild.getHandlerMap().get(assemblyContext)).getPortProvided_ITransaction_Transaction();
//                    (IPerformancePrototypePort<Transactions>) RmiRegistry.lookup("ITransaction_Transactions__AjC3QBLkEeefhYGEQ4GM3w");
            assemblyContext = "_ZO4e4BLkEeefhYGEQ4GM3w";
            myAssembly_Transactions1__Transactions_ = ((Transactions) SimulatorBuild.getHandlerMap().get(assemblyContext)).getPortProvided_ITransaction_Transaction();
//                    (IPerformancePrototypePort<Transactions>) RmiRegistry.lookup("ITransaction_Transactions__ZO4e4BLkEeefhYGEQ4GM3w");
            assemblyContext = "_xzVvUBLoEeefhYGEQ4GM3w";
            myAssembly_Transactions3__Transactions_ = ((Transactions) SimulatorBuild.getHandlerMap().get(assemblyContext)).getPortProvided_ITransaction_Transaction();
//                    (IPerformancePrototypePort<Transactions>) RmiRegistry.lookup("ITransaction_Transactions__xzVvUBLoEeefhYGEQ4GM3w");
            assemblyContext = "_3r0loBLoEeefhYGEQ4GM3w";
            myAssembly_Transactions4__Transactions_ = ((Transactions) SimulatorBuild.getHandlerMap().get(assemblyContext)).getPortProvided_ITransaction_Transaction();
//                    (IPerformancePrototypePort<Transactions>) RmiRegistry.lookup("ITransaction_Transactions__3r0loBLoEeefhYGEQ4GM3w");
            assemblyContext = "_6jiHsBLqEeefhYGEQ4GM3w";
            myAssembly_Transactions5__Transactions_ = ((Transactions) SimulatorBuild.getHandlerMap().get(assemblyContext)).getPortProvided_ITransaction_Transaction();
//                    (IPerformancePrototypePort<Transactions>) RmiRegistry.lookup("ITransaction_Transactions__6jiHsBLqEeefhYGEQ4GM3w");
            assemblyContext = "__BKwoBLqEeefhYGEQ4GM3w";
            myAssembly_Transactions6__Transactions_ = ((Transactions) SimulatorBuild.getHandlerMap().get(assemblyContext)).getPortProvided_ITransaction_Transaction();
//                    (IPerformancePrototypePort<Transactions>) RmiRegistry.lookup("ITransaction_Transactions___BKwoBLqEeefhYGEQ4GM3w");
            assemblyContext = "_ebu6EBLrEeefhYGEQ4GM3w";
            myAssembly_Transactions7__Transactions_ = ((Transactions) SimulatorBuild.getHandlerMap().get(assemblyContext)).getPortProvided_ITransaction_Transaction();
//                    (IPerformancePrototypePort<Transactions>) RmiRegistry.lookup("ITransaction_Transactions__ebu6EBLrEeefhYGEQ4GM3w");
            assemblyContext = "_yw8fsBLrEeefhYGEQ4GM3w";
            myAssembly_Transactions8__Transactions_ = ((Transactions) SimulatorBuild.getHandlerMap().get(assemblyContext)).getPortProvided_ITransaction_Transaction();
//                    (IPerformancePrototypePort<Transactions>) RmiRegistry.lookup("ITransaction_Transactions__yw8fsBLrEeefhYGEQ4GM3w");
            assemblyContext = "_B9SfUBLyEeezkqi8yNfN-g";
            myAssembly_Transactions9__Transactions_ = ((Transactions) SimulatorBuild.getHandlerMap().get(assemblyContext)).getPortProvided_ITransaction_Transaction();
//                    (IPerformancePrototypePort<Transactions>) RmiRegistry.lookup("ITransaction_Transactions__B9SfUBLyEeezkqi8yNfN-g");
            assemblyContext = "_GG-4kBLyEeezkqi8yNfN-g";
            myAssembly_Transactions10__Transactions_ = ((Transactions) SimulatorBuild.getHandlerMap().get(assemblyContext)).getPortProvided_ITransaction_Transaction();
//                    (IPerformancePrototypePort<Transactions>) RmiRegistry.lookup("ITransaction_Transactions__GG-4kBLyEeezkqi8yNfN-g");
            assemblyContext = "_L2TL0BLyEeezkqi8yNfN-g";
            myAssembly_Transactions11__Transactions_ = ((Transactions) SimulatorBuild.getHandlerMap().get(assemblyContext)).getPortProvided_ITransaction_Transaction();
//                    (IPerformancePrototypePort<Transactions>) RmiRegistry.lookup("ITransaction_Transactions__L2TL0BLyEeezkqi8yNfN-g");
            assemblyContext = "_RrongBLyEeezkqi8yNfN-g";
            myAssembly_Transactions12__Transactions_ = ((Transactions) SimulatorBuild.getHandlerMap().get(assemblyContext)).getPortProvided_ITransaction_Transaction();
//                    (IPerformancePrototypePort<Transactions>) RmiRegistry.lookup("ITransaction_Transactions__RrongBLyEeezkqi8yNfN-g");
            assemblyContext = "_ZTIkYBLyEeezkqi8yNfN-g";
            myAssembly_Transactions13__Transactions_ = ((Transactions) SimulatorBuild.getHandlerMap().get(assemblyContext)).getPortProvided_ITransaction_Transaction();
//                    (IPerformancePrototypePort<Transactions>) RmiRegistry.lookup("ITransaction_Transactions__ZTIkYBLyEeezkqi8yNfN-g");
            assemblyContext = "_f_EQ4BLyEeezkqi8yNfN-g";
            myAssembly_Transactions14__Transactions_ = ((Transactions) SimulatorBuild.getHandlerMap().get(assemblyContext)).getPortProvided_ITransaction_Transaction();
//                    (IPerformancePrototypePort<Transactions>) RmiRegistry.lookup("ITransaction_Transactions__f_EQ4BLyEeezkqi8yNfN-g");
            assemblyContext = "_l1dcgBLyEeezkqi8yNfN-g";
            myAssembly_Transactions15__Transactions_ = ((Transactions) SimulatorBuild.getHandlerMap().get(assemblyContext)).getPortProvided_ITransaction_Transaction();
//                    (IPerformancePrototypePort<Transactions>) RmiRegistry.lookup("ITransaction_Transactions__l1dcgBLyEeezkqi8yNfN-g");
            assemblyContext = "_pgSIcBLyEeezkqi8yNfN-g";
            myAssembly_Transactions16__Transactions_ = ((Transactions) SimulatorBuild.getHandlerMap().get(assemblyContext)).getPortProvided_ITransaction_Transaction();
//                    (IPerformancePrototypePort<Transactions>) RmiRegistry.lookup("ITransaction_Transactions__pgSIcBLyEeezkqi8yNfN-g");


            initAssembly_ExperimentHandler__ExperimentHandler_();
            initAssembly_Transactions2__Transactions_();
            initAssembly_Transactions1__Transactions_();
            initAssembly_Transactions3__Transactions_();
            initAssembly_Transactions4__Transactions_();
            initAssembly_Transactions5__Transactions_();
            initAssembly_Transactions6__Transactions_();
            initAssembly_Transactions7__Transactions_();
            initAssembly_Transactions8__Transactions_();
            initAssembly_Transactions9__Transactions_();
            initAssembly_Transactions10__Transactions_();
            initAssembly_Transactions11__Transactions_();
            initAssembly_Transactions12__Transactions_();
            initAssembly_Transactions13__Transactions_();
            initAssembly_Transactions14__Transactions_();
            initAssembly_Transactions15__Transactions_();
            initAssembly_Transactions16__Transactions_();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String... args) {
//        String assemblyContext = AbstractMain.getAssemblyContextFromArguments(args);
//        new defaultSystem(assemblyContext);
//    }

    /**
     * @return defaultSystem object
     */
    public static void directCall(String assemblyContext) {
        if (assemblyContext == null) {
            assemblyContext = "";
        }
//        return
        new defaultSystem(assemblyContext);
    }

}
