package me.graef.sebastian.bachelor.thesis;

import org.jscience.physics.amount.Amount;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.AbstractDemandStrategy;

import javax.measure.quantity.Duration;
import java.io.Serializable;

class CalibrationEntry implements Serializable {
    private static final long serialVersionUID = -1969713798721640687L;
    private final Amount<Duration> targetTime;
    private final long parameter;

    public CalibrationEntry(Amount<Duration> targetTime, long parameter) {
        this.targetTime = targetTime;
        this.parameter = parameter;
    }

    public Amount<Duration> getTargetTime() {
        return this.targetTime;
    }

    public long getParameter() {
        return this.parameter;
    }

    public String toString() {
        return AbstractDemandStrategy.formatDuration(this.targetTime) + "\t | \t" + this.parameter;
    }
}