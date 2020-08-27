package me.graef.sebastian.bachelor.thesis;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import org.apache.log4j.Logger;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.DegreeOfAccuracyEnum;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.ResourceTypeEnum;


/**
 * @author Sebastian
 * <p>
 * updated specific version
 */
public class AbstractResourceEnvironment {
    protected static final Logger LOGGER = Logger.getRootLogger();
    protected static final String[] CPU_STRATEGIES = new String[]{"fibonacci"};
    protected static final Class<?>[] CPU_STRATEGIES_CLASSES = new Class[]{FibonacciDemand.class};

    public AbstractResourceEnvironment() {
    }

    private static IDemandStrategy getStrategy(String usedStrategy, String[] strategies, Class<?>[] strategiesClasses) {
        IDemandStrategy strategy = null;

        for (int i = 0; i < strategies.length; ++i) {
            if (strategies[i].equals(usedStrategy)) {
                try {
                    strategy = (IDemandStrategy) strategiesClasses[i].newInstance();
                } catch (InstantiationException var6) {
                    LOGGER.error("CPU strategy " + usedStrategy + " can not be instantiated");
                } catch (IllegalAccessException var7) {
                }
            }
        }

        return strategy;
    }

    protected static void setUpCPU(String usedStrategy, DegreeOfAccuracyEnum accuracy, String processingRate) {
        IDemandStrategy strategy = getStrategy(usedStrategy, CPU_STRATEGIES, CPU_STRATEGIES_CLASSES);
        if (strategy == null) {
            LOGGER.warn("CPU strategy " + (usedStrategy == null ? "" : usedStrategy) + " not found. Using Fibonacci instead");
            strategy = new FibonacciDemand();
        }

        SimulatorBuild.processingRate = StackContext.evaluateStatic(processingRate, Double.class);

        registerStrategy(accuracy, processingRate, strategy, ResourceTypeEnum.CPU);
    }

    private static void registerStrategy(DegreeOfAccuracyEnum accuracy, String processingRate, IDemandStrategy strategy, ResourceTypeEnum resourceType) {
        double procRate = StackContext.evaluateStatic(processingRate, Double.class);
        CalibrationTable calibrationTable = new CalibrationTable();

        calibrationTable.addEntry(0, SimulatorBuild.TIME_CALCULATION_TAKES, SimulatorBuild.NUM_CALIBRATION_FIB_ITERATIONS);
        strategy.setCalibrationTable(calibrationTable);

        strategy.initializeStrategy(accuracy, procRate);
        DemandConsumerStrategiesRegistry.singleton().registerStrategyFor(resourceType, strategy);
    }
}
