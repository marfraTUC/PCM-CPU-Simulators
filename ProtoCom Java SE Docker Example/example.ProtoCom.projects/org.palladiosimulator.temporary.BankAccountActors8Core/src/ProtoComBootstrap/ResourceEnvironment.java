package ProtoComBootstrap;

import me.graef.sebastian.bachelor.thesis.AbstractResourceEnvironment;
import org.palladiosimulator.protocom.framework.java.se.AbstractAllocationStorage;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.DegreeOfAccuracyEnum;

public class ResourceEnvironment extends AbstractResourceEnvironment {

    public static void setUpResources(String cpuStrategy, DegreeOfAccuracyEnum accuracy) {
        String idContainer = AbstractAllocationStorage.getActiveContainer();

        // Active resources of container myMac
        if (idContainer.equals("_K9EOQFP2Eea2AoC5pjcnpA")) {
            setUpCPU(cpuStrategy, accuracy, "1");
        }
    }
}
