package me.graef.sebastian.bachelor.thesis;


import org.apache.log4j.Logger;
import org.jscience.physics.amount.Amount;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.DegreeOfAccuracyEnum;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.ICalibrationListener;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.ResourceTypeEnum;

import javax.measure.quantity.Duration;
import javax.measure.quantity.Quantity;
import javax.measure.unit.*;
import java.util.Properties;

public abstract class AbstractDemandStrategy implements IDemandStrategy {
    public static final Unit<Work> WORKUNITS = new BaseUnit("WU");
    private CalibrationTable calibrationTable;
    private static final Amount<Duration> ONE_MILLISECOND;

    protected long defaultIterationCount;
    private Properties properties;
    private Amount<ProcessingRate> processingRate;
    private ICalibrationListener listener;
    private boolean debug;
    protected DegreeOfAccuracyEnum degreeOfAccuracy;
    private static final Logger LOGGER;

    static {
        ONE_MILLISECOND = Amount.valueOf(1L, SI.MILLI(SI.SECOND));
        LOGGER = Logger.getLogger(AbstractDemandStrategy.class.getName());
    }

    public AbstractDemandStrategy(int iterationCount) {
        this.defaultIterationCount = (long) iterationCount;
    }

    public void initializeStrategy(DegreeOfAccuracyEnum degree, double initProcessingRate) {
        LOGGER.info("Initialising " + this.getName() + " " + this.getStrategysResource().name() + "  strategy with accuracy " + degree.name());
        this.degreeOfAccuracy = degree;
        this.processingRate = Amount.valueOf(initProcessingRate, ProcessingRate.UNIT);
        LOGGER.debug(this.getName() + " " + this.getStrategysResource().name() + " strategy initialised");
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void consume(double demand) {
        long fibCalculationIterations = calibrateDemanded(demand);
        LOGGER.debug("consume demand (" + fibCalculationIterations + ")");
        this.run(fibCalculationIterations);
    }

    public abstract ResourceTypeEnum getStrategysResource();

    public abstract String getName();

    public abstract void run(long var1);

    public void setCalibrationTable(CalibrationTable table) {
        this.calibrationTable = table;
    }

    public boolean hasCalibrationTable() {
        return this.calibrationTable != null;
    }


    /**
     * @param demand WorkDemand
     * @return number of calculation iterations of fibonacci
     */
    private long calibrateDemanded(double demand) {
        // Amount<Work> demandedWork = Amount.valueOf(demand, Work.UNIT);
        //
        // this.processingRate = Amount.valueOf(SimulatorBuild.processingRate, ProcessingRate.UNIT);
        // Amount<Duration> neededDemandDuration = demandedWork.divide(this.processingRate).to(SI.SECOND);



        // NEW Adapted calculation
        Amount<Duration> neededDemandDuration = Amount.valueOf(demand, SI.SECOND);
        neededDemandDuration = neededDemandDuration.to(SI.SECOND);

        CalibrationEntry calibrationEntry = this.calibrationTable.getEntry(0);

        long calibrationMeasurmentIterations = calibrationEntry.getParameter();
        Amount<Duration> calibrationMeasurmentDuration = calibrationEntry.getTargetTime();

        // convert to nanosec
        calibrationMeasurmentDuration = calibrationMeasurmentDuration.to(SI.MILLI(SI.SECOND));
        neededDemandDuration = neededDemandDuration.to(SI.MILLI(SI.SECOND));


        // using Dreisatz zur Berechnung
        long res = (long) Math.floor((neededDemandDuration.getEstimatedValue() * calibrationMeasurmentIterations) / calibrationMeasurmentDuration.getEstimatedValue());

//        System.out.println("calibrateDemanded --> " + res);
        return res;
    }

    public static String formatDuration(Amount<Duration> t) {
        if (t == null) {
            return "null";
        } else {
            Unit[] units = new Unit[]{SI.NANO(SI.SECOND), SI.MICRO(SI.SECOND), SI.MILLI(SI.SECOND), SI.SECOND, NonSI.MINUTE, NonSI.HOUR};
            Unit[] var5 = units;
            int var4 = units.length;

            for (int var3 = 0; var3 < var4; ++var3) {
                Unit<Duration> u = var5[var3];
                double value = t.to(u).getEstimatedValue();
                if (Math.abs(value) < 1000.0D) {
                    return value + " " + u;
                }
            }

            return t.toText().toString();
        }
    }

    public interface ProcessingRate extends Quantity {
        Unit<ProcessingRate> UNIT = new ProductUnit(Work.UNIT.divide(SI.SECOND));
    }

    public interface Work extends Quantity {
        Unit<Work> UNIT = AbstractDemandStrategy.WORKUNITS;
    }
}
