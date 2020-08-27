package me.graef.sebastian.bachelor.thesis;

import org.apache.log4j.Logger;
import org.jscience.physics.amount.Amount;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.AbstractDemandStrategy;

import javax.measure.quantity.Duration;

public class CalibrationTable {

    protected CalibrationEntry[] table;
    private static final Logger LOGGER = Logger.getLogger(AbstractDemandStrategy.class.getName());

    public CalibrationTable() {
        this.table = new CalibrationEntry[1];
    }

    public void addEntry(int entryNumber, Amount<Duration> targetTime, long parameter) {
        this.table[entryNumber] = new CalibrationEntry(targetTime, parameter);
    }

    public CalibrationEntry getEntry(int entryNumber) {
        return this.table[entryNumber];
    }


}
