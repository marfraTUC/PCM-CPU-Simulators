package me.graef.sebastian.bachelor.thesis;

import org.palladiosimulator.protocom.resourcestrategies.activeresource.DegreeOfAccuracyEnum;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.ResourceTypeEnum;

import java.util.Properties;

public interface IDemandStrategy {
    void initializeStrategy(DegreeOfAccuracyEnum var1, double var2);

    void consume(double var1);

    void setProperties(Properties var1);

    ResourceTypeEnum getStrategysResource();

    String getName();

    void setCalibrationTable(CalibrationTable var1);
}
