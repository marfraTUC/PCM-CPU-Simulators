package defaultrepository.impl;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import defaultrepository.ITransaction;
import defaultrepository.impl.contexts.ITransactionsContext;
import defaultrepository.impl.ports.ITransaction_Transactions;
import me.graef.sebastian.bachelor.thesis.DemandConsumerStrategiesRegistry;
import org.apache.log4j.Logger;
import org.palladiosimulator.protocom.framework.java.se.AbstractMain;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.ResourceTypeEnum;

public class Transactions implements ITransactions {
    protected ITransactionsContext myContext;
    protected SimulatedStackframe<Object> myComponentStackFrame;
    protected SimulatedStackframe<Object> myDefaultComponentStackFrame;
    protected String assemblyContextID;
    public ITransaction m_portProvided_ITransaction_Transaction;

    private static final Logger LOGGER = Logger.getLogger(Transactions.class);

    public Transactions(String assemblyContextID) {
        this.assemblyContextID = assemblyContextID;
        try {
            m_portProvided_ITransaction_Transaction = new ITransaction_Transactions(this, assemblyContextID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setContext(Object myContext) {
        this.myContext = (ITransactionsContext) myContext;
    }

    @Override
    public void setComponentFrame(SimulatedStackframe<Object> myComponentStackFrame) {
        this.myComponentStackFrame = myComponentStackFrame;
        this.myDefaultComponentStackFrame = new SimulatedStackframe<Object>();
    }

    @Override
    public SimulatedStackframe<Object> iTransaction_executeTransaction0(StackContext ctx) {
        LOGGER.info("Thread: " + Thread.currentThread().getName() + " ==> iTransaction_executeTransaction");

        /*
         * StartActionImpl (StartAction[TRANSIENT])
         */

        /*
         * LoopActionImpl (LoopAction[TRANSIENT])
         */
        int maxIterationCount_l_qX0BLmEeefhYGEQ4GM3w = ctx.evaluate("transactionPartition.VALUE", Integer.class);

        for (int iterationCount_l_qX0BLmEeefhYGEQ4GM3w = 0; iterationCount_l_qX0BLmEeefhYGEQ4GM3w < maxIterationCount_l_qX0BLmEeefhYGEQ4GM3w; iterationCount_l_qX0BLmEeefhYGEQ4GM3w++) {
            /*
             * StartActionImpl (StartAction[TRANSIENT])
             */
//            LOGGER.debug("Thread: " + Thread.currentThread().getName() + ": RUN " + iterationCount_l_qX0BLmEeefhYGEQ4GM3w + " of " + maxIterationCount_l_qX0BLmEeefhYGEQ4GM3w);

            /*
             * BranchActionImpl (BranchAction[TRANSIENT])
             */
            double u_q05lQBLiEeefhYGEQ4GM3w = ctx.evaluate("DoublePDF[(1.0;1.0)]", Double.class);
            double sum_q05lQBLiEeefhYGEQ4GM3w = 0;

            if (sum_q05lQBLiEeefhYGEQ4GM3w <= u_q05lQBLiEeefhYGEQ4GM3w && u_q05lQBLiEeefhYGEQ4GM3w < sum_q05lQBLiEeefhYGEQ4GM3w + 0.929944316) {
                /*
                 * StartActionImpl (StartAction[TRANSIENT])
                 */

                /*
                 * InternalActionImpl (InternalAction[TRANSIENT])
                 */
                {
                    double demand = ctx.evaluate("0.01688", Double.class);

                    DemandConsumerStrategiesRegistry.singleton().getStrategyFor(ResourceTypeEnum.CPU).consume(demand);
                }

                /*
                 * StopActionImpl (StopAction[TRANSIENT])
                 */

            }
            if (sum_q05lQBLiEeefhYGEQ4GM3w <= u_q05lQBLiEeefhYGEQ4GM3w && u_q05lQBLiEeefhYGEQ4GM3w < sum_q05lQBLiEeefhYGEQ4GM3w + 0.070055684) {
                /*
                 * StartActionImpl (StartAction[TRANSIENT])
                 */

                /*
                 * InternalActionImpl (InternalAction[TRANSIENT])
                 */
                {
                    double demand = ctx.evaluate("0.01302", Double.class);

                    DemandConsumerStrategiesRegistry.singleton().getStrategyFor(ResourceTypeEnum.CPU).consume(demand);
                }

                /*
                 * StopActionImpl (StopAction[TRANSIENT])
                 */

            }

            /*
             * StopActionImpl (StopAction[TRANSIENT])
             */

        }

        /*
         * StopActionImpl (StopAction[TRANSIENT])
         */

        return ctx.getStack().currentStackFrame();
    }

    public ITransaction getPortProvided_ITransaction_Transaction() {
        return m_portProvided_ITransaction_Transaction;
    }

    public static void main(String[] args) {
        String assemblyContext = AbstractMain.getAssemblyContextFromArguments(args);
        new Transactions(assemblyContext);
    }

    public static Transactions directCall(String assemblyContext) {
        if (assemblyContext == null) {
            assemblyContext = "";
        }
        return new Transactions(assemblyContext);
    }

}
