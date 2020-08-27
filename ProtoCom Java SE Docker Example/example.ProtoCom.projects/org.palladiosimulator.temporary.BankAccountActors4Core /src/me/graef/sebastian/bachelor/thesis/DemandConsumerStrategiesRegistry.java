package me.graef.sebastian.bachelor.thesis;

import org.palladiosimulator.protocom.resourcestrategies.activeresource.ResourceTypeEnum;

import java.util.HashMap;

public final class DemandConsumerStrategiesRegistry {
    private final HashMap<ResourceTypeEnum, IDemandStrategy> strategiesHash = new HashMap();
    private static DemandConsumerStrategiesRegistry singletonInstance = new DemandConsumerStrategiesRegistry();

    private DemandConsumerStrategiesRegistry() {
    }

    public static DemandConsumerStrategiesRegistry singleton() {
        return singletonInstance;
    }

    public void registerStrategyFor(ResourceTypeEnum resourceType, IDemandStrategy strategy) {
        this.strategiesHash.put(resourceType, strategy);
    }

    public IDemandStrategy getStrategyFor(ResourceTypeEnum resource) {
        if (!this.strategiesHash.containsKey(resource)) {
            throw new RuntimeException("Requested Resourcestrategy >" + resource + "< is not registered!");
        } else {
            return this.strategiesHash.get(resource);
        }
    }
}
