package me.graef.sebastian.bachelor.thesis;

import ProtoComBootstrap.AllocationStorage;
import ProtoComBootstrap.ResourceEnvironment;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.impl.DefaultRandomGenerator;
import de.uka.ipd.sdq.probfunction.math.impl.ProbabilityFunctionFactoryImpl;
import de.uka.ipd.sdq.simucomframework.variables.cache.StoExCache;
import defaultsystem.impl.defaultSystem;
import defaultusagescenario.impl.defaultUsageScenario;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.jscience.physics.amount.Amount;
import org.palladiosimulator.protocom.framework.java.se.AbstractAllocationStorage;
import org.palladiosimulator.protocom.framework.java.se.ComponentAllocation;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.DegreeOfAccuracyEnum;

import javax.measure.quantity.Duration;
import javax.measure.unit.SI;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;


/**
 * @author Sebastian Graef
 * <p>
 * this Class is an new version of
 */
public class SimulatorBuild {

    private static final Logger LOGGER = Logger.getRootLogger();


    /**
     * HashMap: Storing all Objects of components
     */
    private static HashMap<String, Object> handlerMap = new HashMap();
    private final Boolean isDebug = false;
    private final String CPU_STRATEGY = "fibonacci";

    public static final int NUM_OF_TRANSACTIONS = 500;
    public static final int NUM_OF_CORES = 16;
    public static double processingRate; // get set temporary


    //    /**
//     * TYPE values from SIMULATOR
//     * TEJAS Simulator calibration Result:
//     */
//    // trace with 1k iterations
//    public static final int NUM_CALIBRATION_FIB_ITERATIONS = 1000;
//    // time taken	=	3.4725 microseconds
//    public static final Amount<Duration> TIME_CALCULATION_TAKES = Amount.valueOf(3.4725, SI.MICRO(SI.SECOND));


    /**
     * TYPE values from SIMULATOR
     * MaxSim Simulator calibration Result:
     */
    // trace with 1 billion iterations
    public static final int NUM_CALIBRATION_FIB_ITERATIONS = 1000000000;
    // time taken	=	25707.115262 microseconds
    public static final Amount<Duration> TIME_CALCULATION_TAKES = Amount.valueOf(25707.115262, SI.MILLI(SI.SECOND));

    /**
     *
     */
    private SimulatorBuild() {
    }

    /**
     * @param args arguments can be empty
     */
    public static void main(String[] args) {
        // start TIMER
        long startTime = System.nanoTime();

        new SimulatorBuild().run();

        // stop TIMER
        Amount<Duration> durationAmount = Amount.valueOf((System.nanoTime() - startTime), SI.NANO(SI.SECOND));
        LOGGER.info("Simulation Time: " + durationAmount.to(SI.MILLI(SI.SECOND)).toText());
    }

    private void run() {
        // init Logging
        this.setupLogging();

        LOGGER.info("Command line read. Logging initialised. Protocom starts its workflow now...");
        LOGGER.info("Reading allocation configuration. Callibrating container if needed");

        // initialize allocations
        this.initAllocationStorage();
        AbstractAllocationStorage.initContainer();

        // setup random Generator
        DefaultRandomGenerator randomGen = new DefaultRandomGenerator();
        IProbabilityFunctionFactory probFunctionFactory = ProbabilityFunctionFactoryImpl.getInstance();
        probFunctionFactory.setRandomGenerator(randomGen);

        // throws exception!
        StoExCache.initialiseStoExCache(probFunctionFactory);

        // start menu
        this.createUserMenu();

        // start resource container
        this.handleContainer();

        // init defaultSystem
        defaultSystem.directCall(null);

        // start measurement
        this.startMeasurements();
    }


    private void startMeasurements() {
        LOGGER.info("Starting workload:");
        new defaultUsageScenario().scenarioRunner();
    }


    private void createUserMenu() {
        UserMenu.showUserMenu(this.getSystems());
    }

    private void setupLogging() {
        LOGGER.removeAllAppenders();
        PatternLayout layout = new PatternLayout("%d{HH:mm} %-5p [%t]: %m%n");
        LOGGER.addAppender(new ConsoleAppender(layout));
        if (this.isDebug) {
            LOGGER.setLevel(Level.DEBUG);
        } else {
            LOGGER.setLevel(Level.INFO);
        }
    }

    // initialise all allocation
    private void initAllocationStorage() {
        AllocationStorage.initSingleton(new AllocationStorage());
    }

    private void setupResources() {
        ResourceEnvironment.setUpResources(this.CPU_STRATEGY, getAccuracy());
    }

    private DegreeOfAccuracyEnum getAccuracy() {
        DegreeOfAccuracyEnum accuracy = DegreeOfAccuracyEnum.HIGH;
        return accuracy;
    }

    /**
     *
     */
    private void handleContainer() {
        Collection<String> containers = AbstractAllocationStorage.getContainerIds();

        String containerId = containers.iterator().next();
        LOGGER.debug("Start: Container " + AbstractAllocationStorage.getContainerName(containerId));
        AbstractAllocationStorage.setActiveContainer(containerId);

        this.setupResources();
        this.startComponentsFromContainer(containerId);
    }


    /**
     * start up all components inside of specific container:
     * <p>
     * <p>
     * WARNING! Only one container allowed
     *
     * @param containerId String
     */
    private void startComponentsFromContainer(String containerId) {
        Collection<ComponentAllocation> components = AbstractAllocationStorage.getComponents(containerId);

        for (ComponentAllocation component : components) {
            Method method = this.getDirectCall(component.getComponentClass().getName());

            String assemblyContext = component.getAssemblyContext();
            try {
                LOGGER.debug("Start: Component " + component.getComponentClass().getName() + ", assembly context: " + component.getAssemblyContext());

                // method call
                Object result = method.invoke(null, (Object) assemblyContext);
                SimulatorBuild.handlerMap.put(assemblyContext, result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * @param mainClassName ClassName
     * @return Method which allows direct access.
     */
    private Method getDirectCall(String mainClassName) {
        if (mainClassName == null) {
            return null;
        } else {
            try {
                Class<?> cls = Class.forName(mainClassName);
                return cls.getMethod("directCall", String.class);
            } catch (Throwable var3) {
                LOGGER.info("Failed to retrieve main class. Falling back to menu mode");
                return null;
            }
        }
    }

    private String[][] getSystems() {
        String[][] systems = {
                {
                        "defaultsystem.impl.defaultSystem", "defaultSystem"
                }
        };
        return systems;
    }


    /**
     * @return HashMap                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             ,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               Object> called "handlerMap" every component is included
     */
    public static HashMap<String, Object> getHandlerMap() {
        return handlerMap;
    }

}
