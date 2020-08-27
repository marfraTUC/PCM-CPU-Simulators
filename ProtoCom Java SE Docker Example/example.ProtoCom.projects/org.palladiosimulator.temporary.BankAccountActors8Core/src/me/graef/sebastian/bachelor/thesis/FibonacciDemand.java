package me.graef.sebastian.bachelor.thesis;

import org.apache.log4j.Logger;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.ResourceTypeEnum;


public class FibonacciDemand extends AbstractDemandStrategy {

    private static final Logger LOGGER = Logger.getLogger(FibonacciDemand.class);

    public FibonacciDemand() {
        super(10000);
    }

    private long fibonacci(long iterationCount) {
        long i1 = 1L;
        long i2 = 1L;
        long i3 = 0L;

        for (long i = 0L; i < iterationCount; ++i) {
            i3 = i1 + i2;
            i2 = i1;
            i1 = i3;
        }

        return i3;
    }

    @Override
    public void run(long initial) {
        LOGGER.debug("FibonacciDemand start " + initial + " iterations.");
        long res = this.fibonacci(initial);
        LOGGER.debug("Result: " + res);
    }

    public ResourceTypeEnum getStrategysResource() {
        return ResourceTypeEnum.CPU;
    }

    public String getName() {
        return "Fibonacci";
    }

    public void cleanup() {
    }
}