package com.Ghreborn.client;

public class Constants {
	
   public static final int ITEM_PRESS_DURATION = 15;
   public static boolean shiftDrop = true;
   public static boolean hdTexturing = false;
   public static boolean smoothShading = true;
   public static boolean distanceFog = false;
   public static boolean IvertColors = false;
   public static final boolean MULTILEVEL_RENDER = true;
   /**
    * use this to pack or dump index's
    */
	/**
	 * Used to merge all the OS Buddy XP Drops so the counter doesn't get too
	 * big if you are training a lot of different skills
	 */
	public static boolean xp_merge = true;

	/**
	 * True = connect to local host False = connect to VPS
	 */
	public static boolean localHost = false;
	
	public static final String CACHE_DIRECTORY = "C:/.Ghreborn_file_store_32/";

	public static final String localAddress = "127.0.0.1";
	public static final String liveAddress = "185.219.133.188";
/**
 * use this to dump index's
 */
	public static final boolean DumpIndex1 = false;
	public static final boolean DumpIndex2 = false;
	public static final boolean DumpIndex3 = false;
	public static final boolean DumpIndex4 = false;
	public static final boolean DumpIndex5 = false;
	/**
	 * use this to pack index's
	 */
	public static final boolean repackIndex1 = false;
	public static final boolean repackIndex2 = false;
	public static final boolean repackIndex3 = false;
	public static final boolean repackIndex4 = false;
	public static final boolean repackIndex5 = false;
	public static final boolean repackIndex6 = false;
	/**
	 * index Amounts.
	 **/
	public static final int IndexAmount = 7;
	/**
	 * client reversion
	 */
	public static final int CLIENT_VERSION = 317;
	public static final boolean EXTENDED_ZOOM = true;
	public static final String CACHE_NAME = ".Ghreborn_file_store_32";
	public static final boolean DUMP_SPRITES = false;
	/**
 * Renders item names on ground items
 */
	public static boolean Render_item_names = true;
	/**
	 * turns on Jag Cached.
	 */
	public static boolean JAGCACHED_ENABLED = false;

/**
 * turns on interface grid
 */
	public static boolean enablegrid = false;
	/**
	 * old booleans that have been moved.
	 */
	public static boolean loadOrbs = true;
	public static boolean hp = true;
	public static boolean HPBarToggle = false;
	public static boolean roofsOff = false;
	public static boolean enableTileBlending = false;
	public static boolean enableSmoothShading = false;
	public static boolean enableAntiAliasing = false;
	public static boolean enableFogRendering = false;
    public static boolean enableRainbowFog = false;
	public static boolean bountyHunter = true;
	public static boolean playerNames = false;
	public static int chatColor = 0;
    public static int fogColor = 0xDCDBDF;
	public static long fogDelay = 500;
	public static boolean osbuddyGameframe = false;
}
