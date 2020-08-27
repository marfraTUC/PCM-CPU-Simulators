package defaultusagescenario.impl;

import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.impl.DefaultRandomGenerator;
import de.uka.ipd.sdq.probfunction.math.impl.ProbabilityFunctionFactoryImpl;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.cache.StoExCache;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import defaultrepository.IExperimentManager;
import me.graef.sebastian.bachelor.thesis.SimulatorBuild;

/**
 * @author Sebastian Graef
 */
public class defaultUsageScenario {
    protected StackContext ctx;
    private IExperimentManager m_portProvided_IExperimentManager;


    public defaultUsageScenario() {
        this.ctx = new StackContext();
        {
            String assemblyContext = "m_portProvided_IExperimentManager";
            m_portProvided_IExperimentManager = ((IExperimentManager) SimulatorBuild.getHandlerMap().get(assemblyContext));
        }

        this.ctx.getStack().createAndPushNewStackFrame();

        IProbabilityFunctionFactory probFunctionFactory = ProbabilityFunctionFactoryImpl.getInstance();

        probFunctionFactory.setRandomGenerator(new DefaultRandomGenerator());
        StoExCache.initialiseStoExCache(probFunctionFactory);
    }

    public void scenarioRunner() {
        /*
         * StartImpl (Start[TRANSIENT])
         */
        ctx.getStack().createAndPushNewStackFrame();

        /*
         * EntryLevelSystemCallImpl (EntryLevelSystemCall[TRANSIENT])
         */
        try {
            ctx.getStack().createAndPushNewStackFrame();

            SimulatedStackframe<Object> currentFrame = ctx.getStack().currentStackFrame();

            // Add required variables:
            int transactionPartition = (int) Math.ceil((double) SimulatorBuild.NUM_OF_TRANSACTIONS / (double) SimulatorBuild.NUM_OF_CORES);
            currentFrame.addValue("transactionPartition.VALUE", transactionPartition);

            // push back to StackFrame
            ctx.getStack().pushStackFrame(currentFrame);

            // EntryLevelSystemCall!
            m_portProvided_IExperimentManager.simulateTransactions0(ctx);

        } finally {
            ctx.getStack().removeStackFrame();
        }

        /*
         * StopImpl (Stop[TRANSIENT])
         */
        ctx.getStack().removeStackFrame();

    }
}
