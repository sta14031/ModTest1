package com.lkrsfn.test1.handler;

import com.lkrsfn.test1.reference.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class ConfigurationHandler {

    public static Configuration configuration;
    public static int numShards = 0;

    public static void init(File configFile) {
        // Create the configuration object from the given configuration file
        if (configuration == null) {
            configuration = new Configuration(configFile);
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equalsIgnoreCase(Reference.MOD_ID)) {
            // Resync configs
            loadConfiguration();
        }
    }

    public void loadConfiguration() {
        numShards = configuration.getInt("numShards",
                Configuration.CATEGORY_GENERAL,
                7, 0,127,
                "Number of shards that spawn");

        if (configuration.hasChanged())
            configuration.save();
    }
}
