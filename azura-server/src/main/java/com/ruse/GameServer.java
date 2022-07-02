package com.ruse;

import com.ruse.util.ShutdownHook;

import java.util.logging.Level;
import java.util.logging.Logger;

//import com.ruse.tools.discord.Discord;

/**
 * The starting point of Ruse.
 *
 * @author Gabriel
 * @author Samy
 */
public class GameServer {

    private static final GameLoader loader = new GameLoader(GameSettings.GAME_PORT);
    private static final Logger logger = Logger.getLogger("Ruse");
    private static String TOKEN = "NjA4MzQ0NTI1NzMxMTM1NTE3.XramXQ.zzsrxRJoG-mBTcX0axa5M7DHSXw";
    private static boolean updating;

    public static GameLoader getLoader() {
        return loader;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static boolean isUpdating() {
        return GameServer.updating;
    }

    public static void setUpdating(boolean updating) {
        GameServer.updating = updating;
    }

    public static void main(String[] params) {
        Runtime.getRuntime().addShutdownHook(new ShutdownHook());
        try {
            logger.info("Initializing the loader...");
            loader.init();
            loader.finish();
            logger.info("The loader has finished loading utility tasks.");
            logger.info(GameSettings.RSPS_NAME + " is now online on port " + GameSettings.GAME_PORT + "!");
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Could not start " + GameSettings.RSPS_NAME + "! Program terminated.", ex);
            System.exit(1);
        }

        // PkingBots.init();
    }
}