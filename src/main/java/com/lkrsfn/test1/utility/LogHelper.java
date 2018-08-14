package com.lkrsfn.test1.utility;

import com.lkrsfn.test1.reference.Reference;
import net.minecraftforge.fml.common.FMLLog;

import org.apache.logging.log4j.Level;

public class LogHelper {
    public static void log(Level logLevel, Object object) {
        FMLLog.log.log(logLevel, String.valueOf(object), Reference.MOD_ID);
    }

    public static void all(Object object) {log(Level.ALL, object);}
    public static void error(Object object) {log(Level.ERROR, object);}
    public static void debug(Object object) {log(Level.DEBUG, object);}
    public static void fatal(Object object) {log(Level.FATAL, object);}
}
