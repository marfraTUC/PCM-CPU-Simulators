package me.graef.sebastian.bachelor.thesis;

import org.apache.log4j.Logger;
import org.palladiosimulator.protocom.framework.java.se.AbstractAllocationStorage;

import java.util.Collection;
import java.util.Iterator;


/**
 * @author Sebastian Graef
 * <p>
 * <p>
 * Original: org.palladiosimulator.protocom.framework.java.se.utils.UserMenu
 * <p>
 * <p>
 * WARNING: reduced generity
 */
public class UserMenu {
    protected static Logger logger = Logger.getRootLogger();

    public UserMenu() {
    }

    protected static void showUserMenu(String[][] systems) {
        System.out.println("Show starting elements");
        showMenuItems(systems);
        System.out.println();
    }

    private static void showMenuItems(String[][] systems) {
        System.out.println("1: Usage Scenarios");
        int i = 2;
        String[][] var5 = systems;
        int var4 = systems.length;

        for (int var3 = 0; var3 < var4; ++var3) {
            String[] system = var5[var3];
            System.out.println(i + ": System " + system[1]);
            ++i;
        }

        Collection<String> containers = AbstractAllocationStorage.getContainerNames();

        for (Iterator<String> var8 = containers.iterator(); var8.hasNext(); ++i) {
            String container = var8.next();
            System.out.println(i + ": Container " + container);
        }
    }
}



