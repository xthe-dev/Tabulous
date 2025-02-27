package com.nxtdelivery.tabulous.config;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.*;
import cc.polyfrost.oneconfig.config.core.OneColor;
import cc.polyfrost.oneconfig.config.data.InfoType;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import cc.polyfrost.oneconfig.config.data.OptionSize;
import cc.polyfrost.oneconfig.config.migration.VigilanceMigrator;

public class TabulousConfig extends Config {
    @Switch(
            category = "Tab", name = "Disable Tab"
    )
    public static boolean disabled = false;

    @Switch(
            name = "Enable Animations",
            category = "Tab", subcategory = "Animations"
    )
    public static boolean animations = true;

    @Slider(
            name = "Animation Speed",
            category = "Tab", subcategory = "Animations",
            min = 2f, max = 30f
    )
    public static float animSpeed = 10f;

    @Dropdown(
            name = "Tab Position",
            category = "Tab", subcategory = "General", options = {"Top (Default)", "Top Left", "Top Right", "Left", "Bottom"}
    )
    public static int position = 0;

    @Checkbox(
            name = "Show Self At Top",
            category = "Tab", subcategory = "General"
    )
    public static boolean alwaysAtTop = false;

    @Switch(
            name = "Don't Render Bossbar",
            category = "Tab", subcategory = "General"
    )
    public static boolean cancelBossbar = false;

    @Switch(
            name = "Close in GUIs",
            category = "Tab", subcategory = "General"
    )
    public static boolean closeInGUIs = true;

    @Slider(
            name = "Top Position",
            category = "Tab", subcategory = "General", min = 0, max = 20, step = 1
    )
    public static int topPosition = 10;

    @Switch(
            name = "Text Shadow",
            category = "Tab", subcategory = "General"
    )
    public static boolean textShadow = true;

    @Switch(
            name = "Show Scoreboard Values",
            category = "Tab", subcategory = "General"
    )
    public static boolean renderScoreboardValues = true;

    @Checkbox(
            name = "Hide Invalid Names (disable custom scoreboards)",
            category = "Tab", subcategory = "General"
    )
    public static boolean hideInvalidNames = false;

    @Switch(
            name = "Show Header",
            category = "Tab", subcategory = "Headers/Footers"
    )
    public static boolean showHeader = true;

    @Switch(
            name = "Show Footer",
            category = "Tab", subcategory = "Headers/Footers"
    )
    public static boolean showFooter = true;

    @Switch(
            name = "Show Ping",
            category = "Tab", subcategory = "Ping"
    )
    public static boolean renderPing = true;

    @Checkbox(
            name = "Hide Ping Ingame",
            category = "Tab", subcategory = "Ping"
    )
    public static boolean hidePingInGame = true;

    @Slider(
            name = "Fix Margins",
            category = "Tab", subcategory = "Margins", max = 10, min = 0, step = 1
    )
    public static int marginFix = 0;

    @Switch(
            name = "Show Heads",
            category = "Tab", subcategory = "Heads"
    )
    public static boolean showHeads = true;

    @DualOption(
            name = "Head Position",
            category = "Tab", subcategory = "Heads",
            left = "Left", right = "Right"
    )
    public static boolean headPos = false;

    @Info(
            type = InfoType.INFO, category = "Tabulous Customization", subcategory = "Custom Text", size = OptionSize.DUAL,
            text = "Leave any of them blank to disable them and show them normally."
    )
    public static boolean ignored1 = false;

    @Text(
            name = "Custom Header Text",
            category = "Tabulous Customization", subcategory = "Custom Text"
    )
    public static String headerText;

    @Text(
            name = "Custom Footer Text",
            category = "Tabulous Customization", subcategory = "Custom Text"
    )
    public static String footerText;

    @Text(
            name = "Custom Name Text",
            category = "Tabulous Customization", subcategory = "Custom Text"
    )
    public static String myNameText;

    @Checkbox(
            name = "Hide Custom Name Ingame",
            category = "Tabulous Customization", subcategory = "Custom Text"
    )
    public static boolean hideCustomNameIngame = false;

    @cc.polyfrost.oneconfig.config.annotations.Color(
            name = "Tab Color",
            category = "Tabulous Customization", subcategory = "Colors"
    )
    public static OneColor tabColor = new OneColor(50, 50, 50, 128);

    @cc.polyfrost.oneconfig.config.annotations.Color(
            name = "Tab Entry Color",
            category = "Tabulous Customization", subcategory = "Colors"
    )
    public static OneColor tabItemColor = new OneColor(255, 255, 255, 32);


    @Checkbox(
            name = "Hide Guild Tags in Tab",
            category = "Hypixel", subcategory = "Players"
    )
    public static boolean hideGuilds = false;

    @Checkbox(
            name = "Hide Player Ranks in Tab",
            category = "Hypixel", subcategory = "Players"
    )
    public static boolean hidePlayerRanksInTab = false;

    @Checkbox(
            name = "Force Hide NPCs",
            category = "Hypixel", subcategory = "NPCs"
    )
    public static boolean hideNPCs = true;

    @Info(
            type = InfoType.INFO, category = "Hypixel", subcategory = "Bedwars", size = OptionSize.DUAL,
            text = "This option will make your custom name show your team in BedWars, (e.g. on Green team: [YOUTUBE] Bobfish21 -> G Bobfish21)"
    )
    public static boolean ignored = false;

    @Checkbox(
            name = "Special Custom Name in Bedwars",
            category = "Hypixel", subcategory = "Bedwars"
    )
    public static boolean customNameBW = false;

    @Switch(
            name = "Cleaner Tab in SkyBlock",
            category = "Hypixel", subcategory = "SkyBlock"
    )
    public static boolean cleanerSkyBlockTabInfo = true;

    @Switch(
            name = "Default Tab in SkyBlock",
            category = "Hypixel", subcategory = "SkyBlock"
    )
    public static boolean defaultSkyBlockTab = false;

    public TabulousConfig() {
        super(new Mod("Tabulous", ModType.UTIL_QOL, new VigilanceMigrator("./W-OVERFLOW/Tabulous/tabulous.toml")), "tabulous.json");
        initialize();
        addDependency("animSpeed", "animations");
        addDependency("hidePingInGame", "renderPing");
        addDependency("headPos", "showHeads");
        addDependency("headerText", "showHeader");
        addDependency("footerText", "showFooter");
    }
}
