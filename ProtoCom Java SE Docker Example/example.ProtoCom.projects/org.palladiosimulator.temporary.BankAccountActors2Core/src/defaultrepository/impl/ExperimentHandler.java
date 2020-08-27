package defaultrepository.impl;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import defaultrepository.IExperimentManager;
import defaultrepository.ITransaction;
import defaultrepository.impl.contexts.IExperimentHandlerContext;
import defaultrepository.impl.ports.IExperimentManager_ExperimentHandler;
import me.graef.sebastian.bachelor.thesis.SimulatorBuild;
import org.apache.log4j.Logger;
import org.palladiosimulator.protocom.framework.java.se.AbstractMain;

import java.util.ArrayList;

public class ExperimentHandler implements IExperimentHandler {
    private static final Logger LOGGER = Logger.getLogger(ExperimentHandler.class);
    protected IExperimentHandlerContext myContext;
    protected SimulatedStackframe<Object> myComponentStackFrame;
    protected SimulatedStackframe<Object> myDefaultComponentStackFrame;
    protected String assemblyContextID;
    protected IExperimentManager m_portProvided_IExperimentManager_ExperimentHandler;

    private ExperimentHandler(String assemblyContextID) {
        this.assemblyContextID = assemblyContextID;
        try {
            m_portProvided_IExperimentManager_ExperimentHandler = new IExperimentManager_ExperimentHandler(
                    this, assemblyContextID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setContext(Object myContext) {
        this.myContext = (IExperimentHandlerContext) myContext;
    }

    public void setComponentFrame(SimulatedStackframe<Object> myComponentStackFrame) {
        this.myComponentStackFrame = myComponentStackFrame;
        this.myDefaultComponentStackFrame = new SimulatedStackframe<Object>();
    }

    public SimulatedStackframe<Object> iExperimentManager_simulateTransactions0(StackContext ctx) {
        /*
         * StartActionImpl (StartAction[TRANSIENT])
         */

        /*
         * ForkActionImpl (ForkAction[TRANSIENT])
         */
        // TODO: check this FUNCTION! its self made!
        SimulatedStackframe<Object> out = simulateForkAction(ctx, SimulatorBuild.NUM_OF_CORES);

        /*
         * StopActionImpl (StopAction[TRANSIENT])
         */

        ctx.getStack().pushStackFrame(out);
        return ctx.getStack().currentStackFrame();
    }

    public IExperimentManager getPortProvided_IExperimentManager_ExperimentHandler() {
        return m_portProvided_IExperimentManager_ExperimentHandler;
    }

    public static void main(String[] args) {
        String assemblyContext = AbstractMain.getAssemblyContextFromArguments(args);
        new ExperimentHandler(assemblyContext);
    }

    public static ExperimentHandler directCall(String assemblyContext) {
        if (assemblyContext == null) {
            assemblyContext = "";
        }
        return new ExperimentHandler(assemblyContext);
    }


    /**
     * missing implementation of Fork Action at ProtoCom
     *
     * @param ctx default
     */
    private SimulatedStackframe<Object> simulateForkAction(StackContext ctx, int NUM_OF_THREADS) {
//        System.out.println("iExperimentManager_simulateTransactions0 is called");
        LOGGER.debug("FORK to: " + NUM_OF_THREADS);

        ArrayList<ITransaction> iTransactionExperimentHandlerList = new ArrayList();
        // Add all to list:
        iTransactionExperimentHandlerList.add(this.myContext.getRoleRequired_ITransaction1_ExperimentHandler());
        iTransactionExperimentHandlerList.add(this.myContext.getRoleRequired_ITransaction2_ExperimentHandler());


        assert (iTransactionExperimentHandlerList.size() == NUM_OF_THREADS);

        ArrayList<Thread> iTransactionExperimentHandlerThreadList = new ArrayList();

        int threadCount = 1;
        for (ITransaction iTansaction : iTransactionExperimentHandlerList) {
            Thread transactionThread = new TransactionThread(("ITransactionTHREAD_" + threadCount), ctx, iTansaction);

            // start thread
            transactionThread.start();
            iTransactionExperimentHandlerThreadList.add(transactionThread);

            threadCount++;
        }

        // wait for threads to end
        try {
            for (Thread t : iTransactionExperimentHandlerThreadList) {
                t.join();
            }
            LOGGER.info("wait for Ending!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ctx.getStack().currentStackFrame();
    }
}
