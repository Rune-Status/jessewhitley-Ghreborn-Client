package com.Ghreborn.client.interfaces;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import com.Ghreborn.client.FileOperations;
import com.Ghreborn.client.Main;
import com.Ghreborn.client.TextClass;
import com.Ghreborn.client.SignLink;
import com.Ghreborn.client.cache.StreamLoader;
import com.Ghreborn.client.cache.anim.Frame;
import com.Ghreborn.client.cache.def.ItemDefinition;
import com.Ghreborn.client.cache.def.NpcDefinition;
import com.Ghreborn.client.cache.graphics.RSFont;
import com.Ghreborn.client.cache.graphics.RSFont;
import com.Ghreborn.client.cache.graphics.Sprite;
import com.Ghreborn.client.entity.model.Model;
import com.Ghreborn.client.interfaces.impl.ListInterface;
import com.Ghreborn.client.interfaces.impl.MainTeleInterface;
import com.Ghreborn.client.interfaces.impl.SkillingTeleInterface;
import com.Ghreborn.client.interfaces.impl.priceChecker;
import com.Ghreborn.client.interfaces.impl.shopInterface;
import com.Ghreborn.client.interfaces.impl.slayerInterface;
import com.Ghreborn.client.interfaces.impl.staffTab;
import com.Ghreborn.client.interfaces.impl.ge.GrandExchange;
import com.Ghreborn.client.io.Buffer;
import com.Ghreborn.client.link.MRUNodes;

public class Widget {
   public int anInt208;
   public int anInt246;
   public int anInt263;
   public int anInt265;
	public int hoverXOffset = 0;
	public int hoverYOffset = 0;
	public int spriteXOffset = 0;
	public int spriteYOffset = 0;
	public boolean regularHoverBox;
	public boolean toggled = false;
	public static final int OPTION_OK = 1;
	public static final int OPTION_USABLE = 2;
	public static final int OPTION_CLOSE = 3;
	public static final int OPTION_TOGGLE_SETTING = 4;
	public static final int OPTION_RESET_SETTING = 5;
	public static final int OPTION_CONTINUE = 6;

	public static final int TYPE_CONTAINER = 0;
	public static final int TYPE_MODEL_LIST = 1;
	public static final int TYPE_INVENTORY = 2;
	public static final int TYPE_RECTANGLE = 3;
	public static final int TYPE_TEXT = 4;
	public static final int TYPE_SPRITE = 5;
	public static final int TYPE_MODEL = 6;
	public static final int TYPE_ITEM_LIST = 7;
   private static final int CLOSE_BUTTON = 141;
   private static final int CLOSE_BUTTON_HOVER = 142;
   public int summonReq;
   static MRUNodes aClass12_264 = new MRUNodes(30);
   public static int[] boxIds = new int[]{4041, 4077, 4113, 4047, 4083, 4119, 4053, 4089, 4125, 4059, 4095, 4131, 4065, 4101, 4137, 4071, 4107, 4143, 4154, 12168, 13918};
   private int mouseY3 = 9;
   private int anInt229 = 891;
	public boolean fancy = false;
   public boolean hasExamine = true;
   public boolean advancedSprite = false;
   public int disabledSpriteId;
   public int enabledSpriteId;
	/**
	 * An array of background sprites
	 */
	public Sprite[] backgroundSprites;
   public int id;
   public int parentID;
   public int type;
	public boolean isItemSearchComponent;
   public int atActionType;
   public int contentType;
   public int transparency;
   public int hoverType;
   public Sprite disabledSprite;
   public Sprite enabledSprite;
   public int width;
   public int height;
   public boolean drawsTransparent;
   public int scrollPosition;
   public int scrollMax;
   public byte opacity;
   public String tooltip;
   private boolean interfaceShown;
   public int[] inventoryItemId;
   public int[] inventoryAmounts;
   public boolean usableItems;
   public boolean hasActions;
   public int spritePaddingX;
   public int spritePaddingY;
   public int[] spritesX;
   public int[] spritesY;
   public Sprite[] sprites;
   public String[] actions;
   public int[] children;
   public int[] childX;
   public int[] childY;
   public boolean centerText;
   public boolean textShadow;
   public boolean replaceItems;
   public boolean allowSwapItems;
   public String message;
   public boolean inventoryhover;
   public boolean filled;
   public int[] anIntArray245;
   public int[] anIntArray212;
   public int[][] valueIndexArray;
   public RSFont textDrawingAreas;
   public String secondaryText;
   public int secondaryColor;
   public int textColor;
   private boolean newScroller;
   public boolean isMouseoverTriggered;
   public int defaultHoverColor;
   public int secondaryHoverColor;
   public int anInt233;
   public int anInt234;
   public int modelZoom;
   public int modelRotation1;
   public int modelRotation2;
   public int anInt257;
   public int anInt258;
   private static MRUNodes spriteCache;
   public static Widget[] interfaceCache;
   static StreamLoader aClass44;
   public int mouseY1;
   public boolean aBoolean251;
   public int anInt255;
   public int anInt256;
   public String selectedActionName;
   public String spellName;
   public int spellUsableOn;
private String hoverText;

   public Widget() {
      this.enabledSpriteId = this.disabledSpriteId = -1;
   }
	public static void homeTeleport(){
        Widget Widget = addInterface(30000);
        Widget.tooltip = "Cast <col=65280>Lunar Home Teleport";
        Widget.id = 30000;
        Widget.parentID = 30000;
        Widget.type = 5;
        Widget.atActionType = 5;
        Widget.contentType = 0;
        Widget.opacity = 0;
        Widget.hoverType = 30001;
        Widget.disabledSprite =  imageLoader(1, "Lunar/SPRITE");
        Widget.width = 20;
        Widget.height = 20;
        Widget Int = addInterface(30001);
        Int.isMouseoverTriggered = true;
    	Int.hoverType = -1;
        setChildren(1, Int);
        addLunarSprite(30002, 0, "SPRITE");
        setBounds(30002, 0, 0,0, Int);
	}

	public static void addLunarSprite(int i, int j, String name) {
		Widget Widget = addInterface(i);
		Widget.id = i;
		Widget.parentID = i;
		Widget.type = 5;
		Widget.atActionType = 5;
		Widget.contentType = 0;
		Widget.opacity = 0;
		Widget.hoverType = 52;
		Widget.disabledSprite = LoadLunarSprite(j, name);
		Widget.width = 500;
		Widget.height = 500;
		Widget.tooltip = "";
	}
	public static void achievementPopup2(RSFont[] tda) {
		Widget tab = addInterface(36000);
		String dir = "Interfaces/Achievements2/SPRITE";
		addSprite(36001, 0, dir);
		addHoverButton(36002, dir, 1, 21, 21, "Close", -1, 36003, 1);
		addHoveredButton(36003, dir, 2, 21, 21, 36004);
		addText(36005, "Achievement Viewer", tda, 2, 0xff9040, true, true);
		addText(36550, "All rewards for completing this achievement:", tda, 0, 0xFFA500, false, true);
		addText(36026, "Easy", tda, 2, 0xff9040, true, true);
		int x = 5, y = 5;
		tab.totalChildren(19);
		tab.child(0, 36001, x, y);
		tab.child(1, 36002, 469 + x, 7 + y);
		tab.child(2, 36003, 469 + x, 7 + y);
		tab.child(3, 36005, 248 + x, 10 + y);
		String[] titles = { "Easy", "Medium", "Hard" };
		int xx = 7;
		for (int i = 0; i < 3; i++) {
			addHoverButton(46006 + i, dir, 3, 160, 20, "View", -1, 36010 + i, 1);
			addHoveredButton(46010 + i, dir, 4, 160, 20, 36014 + i);
			addText(46018 + i, titles[i], tda, 1, 0xff7000, true, true);
			tab.child(4 + i, 46006 + i, xx + x, 36 + y);
			tab.child(7 + i, 46010 + i, xx + x, 36 + y);
			tab.child(10 + i, 46018 + i, xx + x + 80, 40 + y);
			xx += 161;
		}
		tab.child(13, 36023, 8 + x, 82 + y);
		tab.child(14, 36500, 152 + x, 68 + y);
		tab.child(15, 36510, 317 + x, 232 + y);
		tab.child(16, 36520, 152 + x, 232 + y);
		tab.child(17, 36550, 171 + x, 218 + y);
		tab.child(18, 36026, 70 + x, 62 + y);

		Widget info = addInterface(36500);
		addText(36501, "Title Of Achievement", tda, 3, 0xff9040, true, true);
		addText(36502, "Progress: @gre@0% (0/0)", tda, 1, 0xffffff, true, true);
		info.totalChildren(8);
		info.child(0, 36501, 163, 6);
		info.child(1, 36502, 163, 26);
		for (int i = 0; i < 6; i++) {
			addText(36503 + i, "Description #" + i, tda, 0, 0xffffff, true, true);
			info.child(2 + i, 36503 + i, 163, 51 + (i * 13));
		}

		Widget exp = addInterface(36510);
		exp.totalChildren(5);
		for (int i = 0; i < 5; i++) {
			addText(36511 + i, "Text", tda, 0, 0xffffff, false, true);
			exp.child(i, 36511, 3, 3 + (i * 13));
		}
		exp.width = 146;
		exp.height = 72;
		exp.scrollMax = 200;

		Widget items = addInterface(36520);
		items.totalChildren(1);
		itemGroup(36521, 4, 3, 4, 5, true, true);
		// fill(36521);
		interfaceCache[36521].contentType = 206;
		items.child(0, 36521, 5, 5);
		items.width = 146;
		items.height = 72;
		items.scrollMax = 200;

		for (int i = 0; i < 3; i++) {
			Widget scroll = addInterface(36023 + i);
			scroll.totalChildren(100);
			for (int j = 0; j < 100; j++) {
				addClickableText(36037 + j + (i * 100), "Achievement: " + j, "Select", tda, 0, 0xff9040, false, true,
						112);
				scroll.child(j, 36037 + j + (i * 100), 2, 4 + (j * 13));
			}
			scroll.width = 109;
			scroll.height = 232;
			scroll.scrollMax = 1325;
		}
	}
	public static void achievements(RSFont[] tda) {
		Widget rsi = addInterface(59000);
		addSprite(59001, 1, "Interfaces/Achievements/IMAGE");
		addHoverButton(59002, "Interfaces/Achievements/IMAGE", 15, 16, 16, "Close Window", -1, 59003, 3);
		addHoveredButton(59003, "Interfaces/Achievements/IMAGE", 16, 16, 16, 59004);
		addConfigButton(59005, 59000, 12, 20, "Interfaces/Achievements/IMAGE", 71, 29, "Tier Tier I", 1, 1, 800);
		addConfigButton(59006, 59000, 13, 20, "Interfaces/Achievements/IMAGE", 71, 29, "Tier Tier II", 1, 1, 801);
		addConfigButton(59007, 59000, 14, 20, "Interfaces/Achievements/IMAGE", 71, 29, "View Tier III", 1, 1, 802);
		addSprite(59014, 11, "Interfaces/Achievements/IMAGE");
		addText(59016, "1000", tda, 0, 0xff981f, true, true);
		addText(59017, "Tier I", tda, 0, 0xff981f, false, true);
		addText(59018, "Tier II", tda, 0, 0xff981f, false, true);
		addText(59019, "Tier III", tda, 0, 0xff981f, false, true);
		addText(59020, "100", tda, 0, 0xff981f, false, true);

		setChildren(14, rsi);
		setBounds(59001, 0, 0, 0, rsi);
		setBounds(59002, 490, 6, 1, rsi);
		setBounds(59003, 490, 6, 2, rsi);

		setBounds(59005, 15, 10, 3, rsi);
		setBounds(59006, 90, 10, 4, rsi);
		setBounds(59007, 165, 10, 5, rsi);

		setBounds(59014, 415, 14, 6, rsi);
		setBounds(59016, 443, 19, 7, rsi);
		setBounds(59017, 37, 19, 8, rsi);
		setBounds(59018, 111, 19, 9, rsi);
		setBounds(59019, 184, 19, 10, rsi);

		setBounds(59100, 3, 48, 11, rsi);
		setBounds(51100, 3, 48, 12, rsi);
		setBounds(63100, 3, 48, 13, rsi);

		Widget scroll = addInterface(59100);
		setChildren(800, scroll);
		scroll.scrollMax = 6502;
		scroll.height = 281;
		scroll.width = 486;
		int y = 0;
		for (int i = 0; i < 100; i++) {
			addSprite(59101 + i, 10, "Interfaces/Achievements/IMAGE");
			addSprite(59201 + i, 2, "Interfaces/Achievements/IMAGE");
			addSprite(59301 + i, 5, "Interfaces/Achievements/IMAGE");
			addText(59401 + i, "", tda, 2, 0xFFFFFF, true, true);
			addText(59501 + i, "", tda, 2, 0xFFFFFF, false, true);
			addText(59601 + i, "", tda, 2, 0x425619, false, true);
			addSprite(59701 + i, 6, "Interfaces/Achievements/IMAGE");
			addText(59801 + i, "0/1", tda, 1, 0xFFFFFF, true, true);
			setBounds(59101 + i, 1, y, i, scroll);
			setBounds(59201 + i, 8, y + 5, 100 + i, scroll);
			setBounds(59301 + i, 430, y + 12, 200 + i, scroll);
			setBounds(59401 + i, 448, y + 24, 300 + i, scroll);
			setBounds(59501 + i, 65, y + 9, 400 + i, scroll);
			setBounds(59601 + i, 65, y + 24, 500 + i, scroll);
			setBounds(59701 + i, 65, y + 41, 600 + i, scroll);
			setBounds(59801 + i, 160, y + 43, 700 + i, scroll);
			y += 65;
		}
		Widget tier2 = addInterface(61100);
		setChildren(800, tier2);
		tier2.scrollMax = 6502;
		tier2.height = 281;
		tier2.width = 486;
		y = 0;
		for (int i = 0; i < 100; i++) {
			addSprite(61101 + i, 10, "Interfaces/Achievements/IMAGE");
			addSprite(61201 + i, 3, "Interfaces/Achievements/IMAGE");
			addSprite(61301 + i, 5, "Interfaces/Achievements/IMAGE");
			addText(61401 + i, "", tda, 2, 0xFFFFFF, true, true);
			addText(61501 + i, "", tda, 2, 0xFFFFFF, false, true);
			addText(61601 + i, "", tda, 2, 0x425619, false, true);
			addSprite(61701 + i, 6, "Interfaces/Achievements/IMAGE");
			addText(61801 + i, "0/1", tda, 1, 0xFFFFFF, true, true);
			setBounds(61101 + i, 1, y, i, tier2);
			setBounds(61201 + i, 8, y + 5, 100 + i, tier2);
			setBounds(61301 + i, 430, y + 12, 200 + i, tier2);
			setBounds(61401 + i, 448, y + 24, 300 + i, tier2);
			setBounds(61501 + i, 65, y + 9, 400 + i, tier2);
			setBounds(61601 + i, 65, y + 24, 500 + i, tier2);
			setBounds(61701 + i, 65, y + 41, 600 + i, tier2);
			setBounds(61801 + i, 160, y + 43, 700 + i, tier2);
			y += 65;
		}
		Widget tier3 = addInterface(63100);
		setChildren(800, tier3);
		tier3.scrollMax = 6502;
		tier3.height = 281;
		tier3.width = 486;
		y = 0;
		for (int i = 0; i < 100; i++) {
			addSprite(63101 + i, 10, "Interfaces/Achievements/IMAGE");
			addSprite(63201 + i, 4, "Interfaces/Achievements/IMAGE");
			addSprite(63301 + i, 5, "Interfaces/Achievements/IMAGE");
			addText(63401 + i, "", tda, 2, 0xFFFFFF, true, true);
			addText(63501 + i, "", tda, 2, 0xFFFFFF, false, true);
			addText(63601 + i, "", tda, 2, 0x425619, false, true);
			addSprite(63701 + i, 6, "Interfaces/Achievements/IMAGE");
			addText(63801 + i, "0/1", tda, 1, 0xFFFFFF, true, true);
			setBounds(63101 + i, 1, y, i, tier3);
			setBounds(63201 + i, 8, y + 5, 100 + i, tier3);
			setBounds(63301 + i, 430, y + 12, 200 + i, tier3);
			setBounds(63401 + i, 448, y + 24, 300 + i, tier3);
			setBounds(63501 + i, 65, y + 9, 400 + i, tier3);
			setBounds(63601 + i, 65, y + 24, 500 + i, tier3);
			setBounds(63701 + i, 65, y + 41, 600 + i, tier3);
			setBounds(63801 + i, 160, y + 43, 700 + i, tier3);
			y += 65;
		}
	}
	public static void OsDropViewer(RSFont[] tda) {
		Widget tab = addInterface(39500);
		String dir = "Interfaces/DropViewer/SPRITE";
		addSprite(39501, 0, dir);
		addHoverButton(39502, dir, 1, 21, 21, "Close", 0, 39503, 1);
		addHoveredButton(39503, dir, 2, 21, 21, 39504);
		addText(43005, "Monster Drop Viewer", tda, 2, 0xFFA500, true, true);
		addText(43110, "Health: @whi@0", tda, 1, 0xff9040, false, true);// overrides
		addText(43111, "Combat Level: @whi@0", tda, 1, 0xff9040, false, true);
		addText(43112, "Max Hit: @whi@0", tda, 1, 0xff9040, false, true);
		addText(43113, "Aggressive: @whi@false", tda, 1, 0xff9040, false, true);

		addInputField(39806, 30, 0xFF981F, "NPC/Item Name..", 130, 28, false, false, "[A-Za-z0-9 .,]");
		//addText(42522, "Find npc/item drops", drawingArea, 0, 0xFF981F, true, false);
		int x = 7, y = 7;
		tab.totalChildren(11);
		tab.child(0, 39501, 0 + x, 0 + y);
		tab.child(1, 39502, 472 + x, 7 + y);
		tab.child(2, 39503, 472 + x, 7 + y);
		tab.child(3, 43005, 250 + x, 11 + y);
		tab.child(4, 39806, 8+x, 37+y);
		tab.child(5, 39507, 6 + x, 66 + y);
		tab.child(6, 34000, 150 + x, 86 + y);
		tab.child(7, 43110, 250 + x, 40 + y);
		tab.child(8, 43111, 250 + x, 60 + y);
		tab.child(9, 43112, 360 + x, 40 + y);
		tab.child(10, 43113, 360 + x, 60 + y);

		Widget results = addInterface(39507);
		results.width = 122;
		results.height = 250;
		results.scrollMax = 1800;
		results.totalChildren(200);
		for (int j = 0; j < 200; j++) {
			addClickableText(33008 + j, "", "View Drops", tda, 0, 0xff0000, false, true, 110);
			results.child(j, 33008 + j, 6, 8 + (j * 14));
		}

		Widget main = addInterface(34000);
		main.totalChildren(720);
		main.width = 328;
		main.height = 230;
		main.scrollMax = 2560;
		addSprite(34001, 3, dir);
		addSprite(34002, 4, dir);
		for (int i = 0; i < 40; i++) {
			main.child(i, 34001, 0, (i * 64));
			main.child(i + 40, 34002, 0, 32 + (i * 64));
		}
		addText(34003, "Amount:", tda, 0, 0xff9040, true, true);
		addText(34004, "Rarity:", tda, 0, 0xff9040, true, true);
		addText(34005, "Chance:", tda, 0, 0xff9040, true, true);
		for (int i = 0; i < 80; i++) {
			itemGroup(34010 + i, 1, 1, 1, 1, false, false);
			interfaceCache[34010 + i].inventoryItemId[0] = 14485;
			interfaceCache[34010 + i].inventoryAmounts[0] = 1;
			addText(34100 + i, "Item Name", tda, 1, 0xFFA500, false, true);
			addText(34200 + i, "1-50", tda, 0, 0xffffff, true, true);
			addText(34300 + i, "Common", tda, 0, 0xffffff, true, true);
			addText(34400 + i, "1/200", tda, 0, 0xffffff, true, true);
			int yy = (i * 32);
			main.child(80 + i, 34010 + i, 1, 0 + yy);
			main.child(160 + i, 34100 + i, 39, 6 + yy);
			main.child(240 + i, 34003, 175, 2 + yy);
			main.child(320 + i, 34004, 234, 2 + yy);
			main.child(400 + i, 34005, 293, 2 + yy);
			main.child(480 + i, 34200 + i, 175, 14 + yy);
			main.child(560 + i, 34300 + i, 234, 14 + yy);
			main.child(640 + i, 34400 + i, 293, 14 + yy);
		}

	}
	public static void addClickableText(int id, String text, String tooltip, RSFont[] tda, int idx, int color,
										boolean center, boolean shadow, int width) {
		Widget tab = addTabInterface(id);
		tab.parentID = id;
		tab.id = id;
		tab.type = 4;
		tab.atActionType = 1;
		tab.width = width;
		tab.height = 11;
		tab.contentType = 0;
		tab.opacity = 0;
		tab.hoverType = -1;
		tab.centerText = center;
		tab.textShadow = shadow;
		tab.textDrawingAreas = tda[idx];
		tab.message = text;
		tab.hoverText = text;
		tab.textColor = color;
		tab.secondaryColor = 0;
		tab.hoverTextColor = 0xffffff;
		tab.secondaryHoverColor = 0;
		tab.tooltip = tooltip;
	}
	public int hoverTextColor;

	public static void itemGroup(int id, int w, int h, int x, int y, boolean drag, boolean examine) {
		Widget rsi = addInterface(id);
		rsi.width = w;
		rsi.height = h;
		rsi.inventoryItemId = new int[w * h];
		rsi.inventoryAmounts = new int[w * h];
		rsi.usableItems = false;
		rsi.hasActions = false;
		rsi.spritePaddingX = x;
		rsi.spritePaddingY = y;
		rsi.spritesX = new int[20];
		rsi.spritesY = new int[20];
		rsi.sprites = new Sprite[20];
		rsi.type = 2;
	}
	public static void mysteryBox(RSFont[] tda) {
		Widget iface = addInterface(47000);
		/* Base interface */
		//addSpriteLoader(47001, 1073);
		addSprite(47001, 1073, "Interfaces/MysteryBox/SPRITE");
		//addSprite(65001, 0, "Interfaces/Teleporting/Background");
		addText(47002, "Mystery Box", tda, 2, 0xFFA500, true, true);
		addButton(47003, 527, "Interfaces/MysteryBox/SPRITE", "Close");
		addButton(47004, 810, "Interfaces/MysteryBox/SPRITE", "Spin!");
		addText(47005, "@gre@Spin!", tda, 2, 0xFFA500, true, true);
		addSprite(47006, 530, "Interfaces/MysteryBox/SPRITE");
		addSprite(47007, 531, "Interfaces/MysteryBox/SPRITE");
		addText(47008, "Feeling lucky?", tda, 2, 0xFFA500, true, true);
		addText(47009, "Sacrifice your box for a chance at something rare!", tda, 1, 0xFFA500, true, true);
		addSprite(47010, 528, "Interfaces/MysteryBox/SPRITE");
		addSprite(47011, 533, "Interfaces/MysteryBox/SPRITE");


		setChildren(13, iface);
		setBounds(47001, 10, 10, 0, iface);
		setBounds(47002, 253, 13, 1, iface);
		setBounds(47003, 473, 14, 2, iface);
		setBounds(47004, 218, 256, 3, iface);
		setBounds(47005, 253, 263, 4, iface);
		setBounds(47006, 17, 185, 5, iface);
		setBounds(47007, 33, 65, 6, iface);
		setBounds(47008, 253, 78, 7, iface);
		setBounds(47009, 253, 108, 8, iface);
		// Boxes
		setBounds(47200, 10, 187, 9, iface);
		// Items
		setBounds(47100, 17, 192, 10, iface);
		// Item selector
		setBounds(47010, 252, 187, 11, iface);
		setBounds(47011, 10, 185, 12, iface);

		/* Boxes */
		Widget box = addInterface(47200);
		box.width = 480;
		setChildren(Main.BOXES64, box);
		// 64 boxes in each sprite
		int x = 0;
		for(int i=0; i<Main.BOXES64; i++){
			//addSpriteLoader(47201, 1076);
			addSprite(47201, 532, "Interfaces/MysteryBox/SPRITE");
			//addSprite(47201, 0, "");
			setBounds(47201, 0 + x, 0, i, box);
			x += 2880;
		}

		/* Items */
		Widget scroll = addInterface(47100);
		scroll.width = 474;
		addToItemGroup(47101, 1750, 1, 13, 10, false, null, null, null);
		setChildren(1, scroll);
		setBounds(47101, 0, 0, 0, scroll);
	}
	public static void drawRune(int i, int id, String runeName) {
		Widget Widget = addInterface(i);
		Widget.type = 5;
		Widget.atActionType = 0;
		Widget.contentType = 0;
		Widget.opacity = 0;
		Widget.hoverType = 52;
		Widget.disabledSprite = LoadLunarSprite(id, "RUNE");
		Widget.width = 500;
		Widget.height = 500;
	}
	
	public static void drawRune(int i, int id) {
		Widget Widget = addInterface(i);
		Widget.type = 5;
		Widget.atActionType = 0;
		Widget.contentType = 0;
		Widget.opacity = 0;
		Widget.hoverType = 52;
		Widget.disabledSprite = LoadLunarSprite(id, "RUNE");
		Widget.width = 500;
		Widget.height = 500;
	}

	public static void addButtons(int id, int sid, String spriteName,
			String tooltip, int mOver, int atAction) {
		Widget rsinterface = interfaceCache[id] = new Widget();
		rsinterface.id = id;
		rsinterface.parentID = id;
		rsinterface.type = 5;
		rsinterface.atActionType = atAction;
		rsinterface.contentType = 0;
		rsinterface.opacity = (byte) 0;
		rsinterface.hoverType = mOver;
		rsinterface.disabledSprite = imageLoader(sid, spriteName);
		rsinterface.enabledSprite = imageLoader(sid, spriteName);
		rsinterface.width = rsinterface.disabledSprite.myWidth;
		rsinterface.height = rsinterface.enabledSprite.myHeight;
		rsinterface.tooltip = tooltip;
		rsinterface.inventoryhover = true;
	}

	public static void addHoveredButton_sprite_loader(int i, int spriteId, int w, int h, int IMAGEID, String spriteName) {// hoverable
		// button
		Widget tab = addTabInterface(i);
		tab.parentID = i;
		tab.id = i;
		tab.type = 0;
		tab.atActionType = 0;
		tab.width = w;
		tab.height = h;
		tab.isMouseoverTriggered = true;
		tab.opacity = 0;
		tab.hoverType = -1;
		tab.scrollMax = 0;
		addHoverImage_sprite_loader(IMAGEID, spriteId, spriteName);
		tab.totalChildren(1);
		tab.child(0, IMAGEID, 0, 0);
	}
	public static void addHoverImage_sprite_loader(int i, int spriteId, String spriteName) {
		Widget tab = addTabInterface(i);
		tab.id = i;
		tab.parentID = i;
		tab.type = 5;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.width = 512;
		tab.height = 334;
		tab.opacity = 0;
		tab.hoverType = 52;
		tab.disabledSprite = imageLoader(spriteId, spriteName);
		tab.enabledSprite = imageLoader(spriteId, spriteName);
	}
	public static void addButton(int i,int type, int parent, int w, int h, int configFrame, int sprite1, int sprite2, String tooltip, String spriteName) {
		Widget p = addInterface(i);
		p.parentID = parent;
		p.type = 5;
		p.atActionType = type;
				p.width = w;
		p.height = h;
/*		p.anIntArray245 = new int[1];
		p.anIntArray212 = new int[1];
		p.anIntArray212[0] = 1;
		p.anIntArray245[0] = config;*/
		p.valueIndexArray = new int[1][3];
		p.valueIndexArray[0][0] = 5;
		p.valueIndexArray[0][1] = configFrame;
		p.valueIndexArray[0][2] = 0;
		p.tooltip = tooltip;
		p.message = tooltip;
/*		p.hoverType = hoverOver;*/
		p.disabledSprite = imageLoader(sprite1, spriteName);
		p.enabledSprite = imageLoader(sprite2, spriteName);
	}
	public static void addTitle(int id, String text, RSFont[] tda, int idx, int color, boolean center,
								boolean shadow, boolean fancy) {
		Widget tab = addTabInterface(id);
		tab.parentID = id;
		tab.id = id;
		tab.type = 4;
		tab.atActionType = 0;
		tab.width = 0;
		tab.height = 11;
		tab.contentType = 0;
		tab.opacity = 0;
		tab.hoverType = -1;
		tab.centerText = center;
		tab.textShadow = shadow;
		tab.textDrawingAreas = tda[idx];
		tab.message = text;
		tab.secondaryText = "";
		tab.textColor = color;
		tab.secondaryColor = 0;
		tab.defaultHoverColor = 0;
		tab.secondaryHoverColor = 0;
		tab.fancy = fancy;
		
	}
	
	public static void Teleports(RSFont[] tda) {
		Widget rsInterface = addInterface(65000);
		addSprite(65001, 0, "Interfaces/Teleporting/Background");
		addHoverButton(65002, "Interfaces/Teleporting/Tab", 0, 120, 26, "Select", 0, 65003, 1);
		addHoveredButton(65003, "Interfaces/Teleporting/Tab", 1, 120, 26, 65004);
		addHoverButton(65005, "Interfaces/Teleporting/Tab", 0, 120, 26, "Select", 0, 65006, 1);
		addHoveredButton(65006, "Interfaces/Teleporting/Tab", 1, 120, 26, 65007);
		addHoverButton(65008, "Interfaces/Teleporting/Tab", 0, 120, 26, "Select", 0, 65009, 1);
		addHoveredButton(65009, "Interfaces/Teleporting/Tab", 1, 120, 26, 65010);
		addHoverButton(65011, "Interfaces/Teleporting/Tab", 0, 120, 26, "Select", 0, 65012, 1);
		addHoveredButton(65012, "Interfaces/Teleporting/Tab", 1, 120, 26, 65013);
		addHoverButton(65014, "Interfaces/Teleporting/Tab", 0, 120, 26, "Select", 0, 65015, 1);
		addHoveredButton(65015, "Interfaces/Teleporting/Tab", 1, 120, 26, 65016);
		addHoverButton(65017, "Interfaces/Teleporting/Tab", 0, 120, 26, "Select", 0, 65018, 1);
		addHoveredButton(65018, "Interfaces/Teleporting/Tab", 1, 120, 26, 65019);
		addHoverButton(65020, "Interfaces/Teleporting/Tab", 0, 120, 26, "Select", 0, 65021, 1);
		addHoveredButton(65021, "Interfaces/Teleporting/Tab", 1, 120, 26, 65022);
		addHoverButton(65023, "Interfaces/Teleporting/Close", 0, 16, 16, "Close", 0, 65024, 3);
		addHoveredButton(65024, "Interfaces/Teleporting/Close", 1, 16, 16, 65025);
		addText(65026, "Monsters", tda, 1, 0xF7FE2E, true, true);
		addText(65027, "Minigames", tda, 1, 0xF7FE2E, true, true);
		addText(65028, "Bosses", tda, 1, 0xF7FE2E, true, true);
		addText(65029, "Wilderness", tda, 1, 0xF7FE2E, true, true);
		addText(65030, "City", tda, 1, 0xF7FE2E, true, true);
		addText(65031, "Donator", tda, 1, 0xF7FE2E, true, true);
		addText(65032, "Skills", tda, 1, 0xF7FE2E, true, true);
		addText(65033, "Teleporting - Select your destination", tda, 2, 0xff981f, true, true);
		setChildren(26, rsInterface);
		rsInterface.child(0, 65001, 1, 5); // Background
		rsInterface.child(1, 65002, 14, 41); // Tab 1 Hover
		rsInterface.child(2, 65003, 14, 41); // Tab 1
		rsInterface.child(3, 65005, 14, 67); // Tab 2 Hover
		rsInterface.child(4, 65006, 14, 67); // Tab 2
		rsInterface.child(5, 65008, 14, 93); // Tab 3 Hover
		rsInterface.child(6, 65009, 14, 93); // Tab 3
		rsInterface.child(7, 65011, 14, 119); // Tab 4 Hover
		rsInterface.child(8, 65012, 14, 119); // Tab 4
		rsInterface.child(9, 65014, 14, 145); // Tab 5 Hover
		rsInterface.child(10, 65015, 14, 145); // Tab 5
		rsInterface.child(11, 65017, 14, 171); // Tab 6 Hover
		rsInterface.child(12, 65018, 14, 171); // Tab 6
		rsInterface.child(13, 65020, 14, 197); // Tab 7 Hover
		rsInterface.child(14, 65021, 14, 197); // Tab 7
		rsInterface.child(15, 65023, 480, 17); // Close Hover
		rsInterface.child(16, 65024, 480, 17); // Close
		rsInterface.child(17, 65026, 75, 50); // Title 1
		rsInterface.child(18, 65027, 75, 75); // Title 2
		rsInterface.child(19, 65028, 75, 103); // Title 3
		rsInterface.child(20, 65029, 75, 127); // Title 4
		rsInterface.child(21, 65030, 75, 155); // Title 5
		rsInterface.child(22, 65031, 75, 179); // Title 6
		rsInterface.child(23, 65032, 75, 203); // Title 7
		rsInterface.child(24, 65033, 258, 18); // Title
		rsInterface.child(25, 65049, 135, 41); // Scroll menu
		Widget scroll = addInterface(65049);
		scroll.width = 346;
		scroll.height = 238;
		scroll.scrollMax = 550;
		int ChildNum = 40; // Must be a multiple of 2 (This adds more buttons)
		setChildren(ChildNum, scroll);
		int count = 0, y = 0, id = 65050;
		for (int i = 0; i < 10; i++) {
			addButton(id, 0, "Interfaces/Teleporting/Button", "Teleport");
			scroll.child(count, id++, 20, 15 + y); // Button 1
			count++;
			addText(id, "" + id + "", tda, 0, 0xff981f, true, true); // ""+id+"" prints the id of the text
			scroll.child(count, id++, 88, 25 + y); // Button 1 text
			count++;
			addButton(id, 0, "Interfaces/Teleporting/Button", "Teleport");
			scroll.child(count, id++, 190, 15 + y); // Button 2
			count++;
			addText(id, "" + id + "", tda, 0, 0xff981f, true, true); // ""+id+"" prints the id of the text
			scroll.child(count, id++, 255, 25 + y); // Button 2 text
			count++;
			y += 47;
		}
	}

public static void skillGuide(RSFont[] tda) {
		
		Widget mainScroll = addTabInterface(36100);
		Widget list = addTabInterface(36350);
		Widget side = addTabInterface(36150);
		int pos = 36151;
		int y = 0;
		side.height = 75;
		side.width = 260;
		list.height = 237;
		list.width = 284;
		list.scrollMax = 1750;
		addSprite(36101, 0, "Interfaces/skillguide/skillGude");
		addSprite(36351, 1, "Interfaces/skillguide/skillGude");
		addSprite(36352, 2, "Interfaces/skillguide/skillGude");
		addButton(36104, 3, 36100, 24, 24, 5, 5, 36105, "Close", "Interfaces/skillguide/skillGude");
		addHoveredButton_sprite_loader(36105, 6, 24, 24, 36106, "Interfaces/skillguide/skillGude");
		addHoverText(36353, "Weapons", "Open", tda, 3, 0x46320a, true, false, 150);
		addHoverText(36354, "Armour", "Open", tda, 3, 0x46320a, true, false, 150);
		addHoverText(36355, "Salamanders", "Open", tda, 3, 0x46320a, true, false, 150);
		addTitle(36102, "Attack", tda, 3, 0x46320a, true, false, true);
		addText(36103, "Weapons", tda, 0, 0x446320a, true, false);
		Widget container = addTabInterface(36250);
		container.spritesX = new int[20];
		container.spritesY = new int[20];
		container.inventoryItemId = new int[58];
		container.inventoryAmounts = new int[58];
		container.filled = false;
		container.replaceItems = false;
		container.usableItems = false;
		container.allowSwapItems = false;
		container.spritePaddingX = 0;
		container.spritePaddingY = 3;
		container.height = 58;
		container.width = 1;
		container.parentID = 42000;
		container.type = TYPE_INVENTORY;
		for(int i = 0; i < 200; i++) {
			addText(pos + i, "" + i, tda, 1, 0x46320a, true, false);
			addText(pos + (i + 1), "" + (i + 1), tda, 1, 0x46320a, false, false);
			addText(pos + (i + 2), "" + (i + 2), tda, 1, 0x46320a, false, false);
			i += 3;
		}
		mainScroll.totalChildren(7);
		side.totalChildren(5);
		list.totalChildren(451);
		int scrollChild = 0;
		mainScroll.child(scrollChild++, 36101, 0, 0);
		mainScroll.child(scrollChild++, 36104, 470, 5);
		mainScroll.child(scrollChild++, 36105, 470, 5);
		mainScroll.child(scrollChild++, 36102, 180, 15);
		mainScroll.child(scrollChild++, 36103, 180, 32);
		mainScroll.child(scrollChild++, 36150, 355, 35);
		mainScroll.child(scrollChild++, 36350, 30, 75);
		int sideChild = 0;
		side.child(sideChild++, 36351, 0, 0);
		side.child(sideChild++, 36352, 0, 66);
		side.child(sideChild++, 36353, 0, 10);
		side.child(sideChild++, 36354, 0, 28);
		side.child(sideChild++, 36355, 0, 46);
		int listChild = 0;
		list.child(listChild++, 36250, 23, 0);
		for(int i = 0; i < 600; i++) {
			list.child(listChild++, pos + i, 11, y + 2);
			list.child(listChild++, pos + (i + 1), 61, y);
			list.child(listChild++, pos + (i + 2), 61, y + 13);
			y += 35;
			i += 3;
		}
	}
	public static void addLunar2RunesSmallBox(int ID, int r1, int r2, int ra1, int ra2,int rune1, int lvl,String name, String descr,RSFont[] RSFont,int sid,int suo,int type){
		Widget rsInterface = addInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 5;
		rsInterface.atActionType = type;
		rsInterface.contentType = 0;
		rsInterface.hoverType = ID+1;
		rsInterface.spellUsableOn = suo;
		rsInterface.selectedActionName = "Cast On";
		rsInterface.width = 20;
		rsInterface.height = 20;
		rsInterface.tooltip = "Cast <col=65280>"+name;
		rsInterface.spellName = name;
		rsInterface.anIntArray245 = new int[3];
		rsInterface.anIntArray212 = new int[3];
		rsInterface.anIntArray245[0] = 3;
		rsInterface.anIntArray212[0] = ra1;
		rsInterface.anIntArray245[1] = 3;
		rsInterface.anIntArray212[1] = ra2;
		rsInterface.anIntArray245[2] = 3;
		rsInterface.anIntArray212[2] = lvl;
		rsInterface.valueIndexArray = new int[3][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[4];
		rsInterface.valueIndexArray[1][0] = 4;
		rsInterface.valueIndexArray[1][1] = 3214;
		rsInterface.valueIndexArray[1][2] = r2;
		rsInterface.valueIndexArray[1][3] = 0;
		rsInterface.valueIndexArray[2] = new int[3];
		rsInterface.valueIndexArray[2][0] = 1;
		rsInterface.valueIndexArray[2][1] = 6;
		rsInterface.valueIndexArray[2][2] = 0;
		rsInterface.enabledSprite =  imageLoader(sid, "Lunar/LUNARON");
		rsInterface.disabledSprite =  imageLoader(sid, "Lunar/LUNAROFF");
		Widget INT = addInterface(ID+1);
		INT.isMouseoverTriggered = true;
		INT.hoverType = -1;
		setChildren(7, INT);
		addLunarSprite(ID+2, 0, "BOX");
		setBounds(ID+2, 0, 0, 0, INT);
		addText(ID+3, "Level "+(lvl+1)+": "+name, 0xFF981F, true, true, 52, RSFont, 1);
		setBounds(ID+3, 90, 4, 1, INT);
		addText(ID+4, descr, 0xAF6A1A, true, true, 52, RSFont, 0);	
		setBounds(ID+4, 90, 19, 2, INT);
		setBounds(30016, 37, 35, 3, INT);//Rune
		setBounds(rune1, 112, 35, 4, INT);//Rune
		addRuneText(ID+5, ra1+1, r1, RSFont);
		setBounds(ID+5, 50, 66, 5, INT);
		addRuneText(ID+6, ra2+1, r2, RSFont);
		setBounds(ID+6, 123, 66, 6, INT);

	}

	public static void addRuneText(int ID, int runeAmount, int RuneID, RSFont[] font) {
		Widget rsInterface = addTabInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 4;
		rsInterface.atActionType = 0;
		rsInterface.contentType = 0;
		rsInterface.width = 0;
		rsInterface.height = 14;
		rsInterface.opacity = 0;
		rsInterface.hoverType = -1;
		rsInterface.anIntArray245 = new int[1];
		rsInterface.anIntArray212 = new int[1];
		rsInterface.anIntArray245[0] = 3;
		rsInterface.anIntArray212[0] = runeAmount;
		rsInterface.valueIndexArray = new int[1][4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = RuneID;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.centerText = true;
		rsInterface.textDrawingAreas = font[0];
		rsInterface.textShadow = true;
		rsInterface.message = "%1/" + runeAmount + "";
		rsInterface.secondaryText = "";
		rsInterface.textColor = 12582912;
		rsInterface.secondaryColor = 49152;
	}
	public static void configureLunar(RSFont[] RSFont) {
		constructLunar();
		homeTeleport();
		drawRune(30003, 1, "Fire");
		drawRune(30004, 2, "Water");
		drawRune(30005, 3, "Air");
		drawRune(30006, 4, "Earth");
		drawRune(30007, 5, "Mind");
		drawRune(30008, 6, "Body");
		drawRune(30009, 7, "Death");
		drawRune(30010, 8, "Nature");
		drawRune(30011, 9, "Chaos");
		drawRune(30012, 10, "Law");
		drawRune(30013, 11, "Cosmic");
		drawRune(30014, 12, "Blood");
		drawRune(30015, 13, "Soul");
		drawRune(30016, 14, "Astral");
		addLunar3RunesSmallBox(30017, 9075, 554, 555, 0, 4, 3, 30003, 30004,
				64, "Bake Pie", "Bake pies without a stove", RSFont, 0, 16, 2);
		addLunar2RunesSmallBox(30025, 9075, 557, 0, 7, 30006, 65, "Cure Plant",
				"Cure disease on farming patch", RSFont, 1, 4, 2);
		addLunar3RunesBigBox(30032, 9075, 564, 558, 0, 0, 0, 30013, 30007, 65,
				"Monster Examine",
				"Detect the combat statistics of a\\nmonster", RSFont, 2, 2, 2);
		addLunar3RunesSmallBox(30040, 9075, 564, 556, 0, 0, 1, 30013, 30005,
				66, "NPC Contact", "Speak with varied NPCs", RSFont, 3, 0, 2);
		addLunar3RunesSmallBox(30048, 9075, 563, 557, 0, 0, 9, 30012, 30006,
				67, "Cure Other", "Cure poisoned players", RSFont, 4, 8, 2);
		addLunar3RunesSmallBox(30056, 9075, 555, 554, 0, 2, 0, 30004, 30003,
				67, "Humidify", "fills certain vessels with water", RSFont, 5, 0,
				5);
		addLunar3RunesSmallBox(30064, 9075, 563, 557, 1, 0, 1, 30012, 30006,
				68, "Moonclan Teleport", "Teleports you to moonclan island",
				RSFont, 6, 0, 5);
		addLunar3RunesBigBox(30075, 9075, 563, 557, 1, 0, 3, 30012, 30006, 69,
				"Tele Group Moonclan",
				"Teleports players to Moonclan\\nisland", RSFont, 7, 0, 5);
		addLunar3RunesSmallBox(30083, 9075, 563, 557, 1, 0, 5, 30012, 30006,
				70, "Ourania Teleport", "Teleports you to ourania rune altar",
				RSFont, 8, 0, 5);
		addLunar3RunesSmallBox(30091, 9075, 564, 563, 1, 1, 0, 30013, 30012,
				70, "Cure Me", "Cures Poison", RSFont, 9, 0, 5);
		addLunar2RunesSmallBox(30099, 9075, 557, 1, 1, 30006, 70, "Hunter Kit",
				"Get a kit of hunting gear", RSFont, 10, 0, 5);
		addLunar3RunesSmallBox(30106, 9075, 563, 555, 1, 0, 0, 30012, 30004,
				71, "Waterbirth Teleport",
				"Teleports you to Waterbirth island", RSFont, 11, 0, 5);
		addLunar3RunesBigBox(30114, 9075, 563, 555, 1, 0, 4, 30012, 30004, 72,
				"Tele Group Waterbirth",
				"Teleports players to Waterbirth\\nisland", RSFont, 12, 0, 5);
		addLunar3RunesSmallBox(30122, 9075, 564, 563, 1, 1, 1, 30013, 30012,
				73, "Cure Group", "Cures Poison on players", RSFont, 13, 0, 5);
		addLunar3RunesBigBox(30130, 9075, 564, 559, 1, 1, 4, 30013, 30008, 74,
				"Stat Spy",
				"Cast on another player to see their\\nskill levels", RSFont, 14,
				8, 2);
		addLunar3RunesBigBox(30138, 9075, 563, 554, 1, 1, 2, 30012, 30003, 74,
				"Barbarian Teleport",
				"Teleports you to the Barbarian\\noutpost", RSFont, 15, 0, 5);
		addLunar3RunesBigBox(30146, 9075, 563, 554, 1, 1, 5, 30012, 30003, 75,
				"Tele Group Barbarian",
				"Teleports players to the Barbarian\\noutpost", RSFont, 16, 0, 5);
		addLunar3RunesSmallBox(30154, 9075, 554, 556, 1, 5, 9, 30003, 30005,
				76, "Superglass Make", "Make glass without a furnace", RSFont, 17,
				16, 2);
		addLunar3RunesSmallBox(30162, 9075, 563, 555, 1, 1, 3, 30012, 30004,
				77, "Khazard Teleport", "Teleports you to Port khazard", RSFont,
				18, 0, 5);
		addLunar3RunesSmallBox(30170, 9075, 563, 555, 1, 1, 7, 30012, 30004,
				78, "Tele Group Khazard", "Teleports players to Port khazard",
				RSFont, 19, 0, 5);
		addLunar3RunesBigBox(30178, 9075, 564, 559, 1, 0, 4, 30013, 30008, 78,
				"Dream", "Take a rest and restore hitpoints 3\\n times faster",
				RSFont, 20, 0, 5);
		addLunar3RunesSmallBox(30186, 9075, 557, 555, 1, 9, 4, 30006, 30004,
				79, "String Jewellery", "String amulets without wool", RSFont, 21,
				0, 5);
		addLunar3RunesLargeBox(30194, 9075, 557, 555, 1, 9, 9, 30006, 30004,
				80, "Stat Restore Pot\\nShare",
				"Share a potion with up to 4 nearby\\nplayers", RSFont, 22, 0, 5);
		addLunar3RunesSmallBox(30202, 9075, 554, 555, 1, 6, 6, 30003, 30004,
				81, "Magic Imbue", "Combine runes without a talisman", RSFont, 23,
				0, 5);
		addLunar3RunesBigBox(30210, 9075, 561, 557, 2, 1, 14, 30010, 30006, 82,
				"Fertile Soil",
				"Fertilise a farming patch with super\\ncompost", RSFont, 24, 4, 2);
		addLunar3RunesBigBox(30218, 9075, 557, 555, 2, 11, 9, 30006, 30004, 83,
				"Boost Potion Share",
				"Shares a potion with up to 4 nearby\\nplayers", RSFont, 25, 0, 5);
		addLunar3RunesSmallBox(30226, 9075, 563, 555, 2, 2, 9, 30012, 30004,
				84, "Fishing Guild Teleport",
				"Teleports you to the fishing guild", RSFont, 26, 0, 5);
		addLunar3RunesLargeBox(30234, 9075, 563, 555, 1, 2, 13, 30012, 30004,
				85, "Tele Group Fishing\\nGuild",
				"Teleports players to the Fishing\\nGuild", RSFont, 27, 0, 5);
		addLunar3RunesSmallBox(30242, 9075, 557, 561, 2, 14, 0, 30006, 30010,
				85, "Plank Make", "Turn Logs into planks", RSFont, 28, 16, 5);
		/******** Cut Off Limit **********/
		addLunar3RunesSmallBox(30250, 9075, 563, 555, 2, 2, 9, 30012, 30004,
				86, "Catherby Teleport", "Teleports you to Catherby", RSFont, 29,
				0, 5);
		addLunar3RunesSmallBox(30258, 9075, 563, 555, 2, 2, 14, 30012, 30004,
				87, "Tele Group Catherby", "Teleports players to Catherby",
				RSFont, 30, 0, 5);
		addLunar3RunesSmallBox(30266, 9075, 563, 555, 2, 2, 7, 30012, 30004,
				88, "Ice Plateau Teleport", "Teleports you to Ice Plateau",
				RSFont, 31, 0, 5);
		addLunar3RunesBigBox(30274, 9075, 563, 555, 2, 2, 15, 30012, 30004, 89,
				"Tele Group Ice\\n Plateau",
				"Teleports players to Ice Plateau", RSFont, 32, 0, 5);
		addLunar3RunesBigBox(
				30282,
				9075,
				563,
				561,
				2,
				1,
				0,
				30012,
				30010,
				90,
				"Energy Transfer",
				"Spend hitpoints and SA Energy to\\n give another player hitpoints and run energy",
				RSFont, 33, 8, 2);
		addLunar3RunesBigBox(30290, 9075, 563, 565, 2, 2, 0, 30012, 30014, 91,
				"Heal Other",
				"Transfer up to 75% of hitpoints\\n to another player", RSFont,
				34, 8, 2);
		addLunar3RunesBigBox(30298, 9075, 560, 557, 2, 1, 9, 30009, 30006, 92,
				"Vengeance Other",
				"Allows another player to rebound\\ndamage to an opponent",
				RSFont, 35, 8, 2);
		addLunar3RunesSmallBox(30306, 9075, 560, 557, 3, 1, 9, 30009, 30006,
				93, "Vengeance", "Rebound damage to an opponent", RSFont, 36, 0, 5);
		addLunar3RunesBigBox(30314, 9075, 565, 563, 3, 2, 5, 30014, 30012, 94,
				"Heal Group", "Transfer up to 75% of hitpoints to a group",
				RSFont, 37, 0, 5);
		addLunar3RunesBigBox(30322, 9075, 564, 563, 2, 1, 0, 30013, 30012, 95,
				"Spellbook Swap",
				"Change to another spellbook for 1\\nspell cast", RSFont, 38, 0, 5);
	}

	public static void constructLunar() {
		Widget Interface = addInterface(29999);
		setChildren(80, Interface); //71
			int[] Cid = {30000, 30017, 30025, 30032, 30040, 30048, 30056, 30064, 30075,
						 30083, 30091, 30099, 30106, 30114, 30122, 30130, 30138, 30146,
						 30154, 30162, 30170, 30178, 30186, 30194, 30202, 30210, 30218,
						 30226, 30234, 30242, 30250, 30258, 30266, 30274, 30282, 30290,
						 30298, 30306, 30314, 30322, 30001, 30018, 30026, 30033, 30041,
						 30049, 30057, 30065, 30076, 30084, 30092, 30100, 30107, 30115,
						 30123, 30131, 30139, 30147, 30155, 30163, 30171, 30179, 30187,
						 30195, 30203, 30211, 30219, 30227, 30235, 30243, 30251,
						 30259, 30267, 30275, 30283, 30291,
						 30299, 30307, 30315, 30323 };
			
			int[] xCord = {11, 40, 71, 103, 135, 165, 8, 39, 71, 103, 135, 165, 12, 42, 71,
						   103, 135, 165, 14, 42, 71, 101, 135, 168, 11, 42, 74, 103, 135,
						   164, 10, 42, 71, 103, 136, 165, 13, 42, 71, 104, 6, 5, 5, 5, 5,
						   5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
						   5, 5, 5, 5, 5,
						   5, 5, 5, 5, 5,
						   5, 5, 5, 5 };
			
			int[] yCord = {9, 9, 12, 10, 12, 10, 39, 39, 39, 39, 39, 37, 68, 68, 68, 68, 68,
						   68, 97, 97, 97, 97, 98, 98, 125, 124, 125, 125, 125, 126, 155, 155,
						   155, 155, 155, 155, 185, 185, 184, 184, 184, 176, 176, 163, 176,
						   176, 176, 176, 163, 176, 176, 176, 176, 163, 176, 163, 163, 163, 176,
						   176, 176, 163, 176, 149, 176, 163, 163, 176, 149, 176, 176,
						   176, 176, 176, 9, 9,
						   9, 9, 9, 9 };
			
			for(int i = 0; i < Cid.length; i++) {
				setBounds(Cid[i], xCord[i], yCord[i], i, Interface);
			}
	}

	public static void addLunar3RunesSmallBox(int ID, int r1, int r2, int r3, int ra1, int ra2, int ra3,int rune1, int rune2, int lvl,String name, String descr,RSFont[] RSFont, int sid,int suo,int type){
		Widget rsInterface = addInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 5;
		rsInterface.atActionType = type;
		rsInterface.contentType = 0;
		rsInterface.hoverType = ID+1;
		rsInterface.spellUsableOn = suo;
		rsInterface.selectedActionName = "Cast on";
		rsInterface.width = 20;
		rsInterface.height = 20;
		rsInterface.tooltip = "Cast <col=65280>"+name;
		rsInterface.spellName = name;
		rsInterface.anIntArray245 = new int[4];
		rsInterface.anIntArray212 = new int[4];
		rsInterface.anIntArray245[0] = 3;
		rsInterface.anIntArray212[0] = ra1;
		rsInterface.anIntArray245[1] = 3;
		rsInterface.anIntArray212[1] = ra2;
		rsInterface.anIntArray245[2] = 3;
		rsInterface.anIntArray212[2] = ra3;
		rsInterface.anIntArray245[3] = 3;
		rsInterface.anIntArray212[3] = lvl;
		rsInterface.valueIndexArray = new int[4][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[4];
		rsInterface.valueIndexArray[1][0] = 4;
		rsInterface.valueIndexArray[1][1] = 3214;
		rsInterface.valueIndexArray[1][2] = r2;
		rsInterface.valueIndexArray[1][3] = 0;
		rsInterface.valueIndexArray[2] = new int[4];
		rsInterface.valueIndexArray[2][0] = 4;
		rsInterface.valueIndexArray[2][1] = 3214;
		rsInterface.valueIndexArray[2][2] = r3;
		rsInterface.valueIndexArray[2][3] = 0;
		rsInterface.valueIndexArray[3] = new int[3];
		rsInterface.valueIndexArray[3][0] = 1;
		rsInterface.valueIndexArray[3][1] = 6;
		rsInterface.valueIndexArray[3][2] = 0;
		rsInterface.enabledSprite =  imageLoader(sid, "Lunar/LUNARON");
		rsInterface.disabledSprite =  imageLoader(sid, "Lunar/LUNAROFF");
		Widget INT = addInterface(ID+1);
		INT.isMouseoverTriggered = true;
		INT.hoverType = -1;
		setChildren(9, INT);
		addLunarSprite(ID+2, 0, "BOX");
		setBounds(ID+2, 0, 0, 0, INT);
		addText(ID+3, "Level "+(lvl+1)+": "+name, 0xFF981F, true, true, 52, RSFont, 1);setBounds(ID+3, 90, 4, 1, INT);
		addText(ID+4, descr, 0xAF6A1A, true, true, 52, RSFont, 0);	setBounds(ID+4, 90, 19, 2, INT);
		setBounds(30016, 14, 35, 3, INT);
		setBounds(rune1, 74, 35, 4, INT);
		setBounds(rune2, 130, 35, 5, INT);
		addRuneText(ID+5, ra1+1, r1, RSFont);
		setBounds(ID+5, 26, 66, 6, INT);
		addRuneText(ID+6, ra2+1, r2, RSFont);
		setBounds(ID+6, 87, 66, 7, INT);
		addRuneText(ID+7, ra3+1, r3, RSFont);
		setBounds(ID+7, 142, 66, 8, INT);
	}

	public static void addLunar3RunesBigBox(int ID, int r1, int r2, int r3, int ra1, int ra2, int ra3,int rune1, int rune2, int lvl,String name, String descr,RSFont[] RSFont, int sid,int suo,int type){
		Widget rsInterface = addInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 5;
		rsInterface.atActionType = type;
		rsInterface.contentType = 0;
		rsInterface.hoverType = ID+1;
		rsInterface.spellUsableOn = suo;
		rsInterface.selectedActionName = "Cast on";
		rsInterface.width = 20;
		rsInterface.height = 20;
		rsInterface.tooltip = "Cast <col=65280>"+name;
		rsInterface.spellName = name;
		rsInterface.anIntArray245 = new int[4];
		rsInterface.anIntArray212 = new int[4];
		rsInterface.anIntArray245[0] = 3;
		rsInterface.anIntArray212[0] = ra1;
		rsInterface.anIntArray245[1] = 3;
		rsInterface.anIntArray212[1] = ra2;
		rsInterface.anIntArray245[2] = 3;
		rsInterface.anIntArray212[2] = ra3;
		rsInterface.anIntArray245[3] = 3;
		rsInterface.anIntArray212[3] = lvl;
		rsInterface.valueIndexArray = new int[4][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[4];
		rsInterface.valueIndexArray[1][0] = 4;
		rsInterface.valueIndexArray[1][1] = 3214;
		rsInterface.valueIndexArray[1][2] = r2;
		rsInterface.valueIndexArray[1][3] = 0;
		rsInterface.valueIndexArray[2] = new int[4];
		rsInterface.valueIndexArray[2][0] = 4;
		rsInterface.valueIndexArray[2][1] = 3214;
		rsInterface.valueIndexArray[2][2] = r3;
		rsInterface.valueIndexArray[2][3] = 0;
		rsInterface.valueIndexArray[3] = new int[3];
		rsInterface.valueIndexArray[3][0] = 1;
		rsInterface.valueIndexArray[3][1] = 6;
		rsInterface.valueIndexArray[3][2] = 0;
		rsInterface.enabledSprite =  imageLoader(sid, "Lunar/LUNARON");
		rsInterface.disabledSprite =  imageLoader(sid, "Lunar/LUNAROFF");
		Widget INT = addInterface(ID+1);
		INT.isMouseoverTriggered = true;
		INT.hoverType = -1;
		setChildren(9, INT);
		addLunarSprite(ID+2, 1, "BOX");
		setBounds(ID+2, 0, 0, 0, INT);
		addText(ID+3, "Level "+(lvl+1)+": "+name, 0xFF981F, true, true, 52, RSFont, 1);setBounds(ID+3, 90, 4, 1, INT);
		addText(ID+4, descr, 0xAF6A1A, true, true, 52, RSFont, 0);	setBounds(ID+4, 90, 21, 2, INT);
		setBounds(30016, 14, 48, 3, INT);
		setBounds(rune1, 74, 48, 4, INT);
		setBounds(rune2, 130, 48, 5, INT);
		addRuneText(ID+5, ra1+1, r1, RSFont);
		setBounds(ID+5, 26, 79, 6, INT);
		addRuneText(ID+6, ra2+1, r2, RSFont);
		setBounds(ID+6, 87, 79, 7, INT);
		addRuneText(ID+7, ra3+1, r3, RSFont);
		setBounds(ID+7, 142, 79, 8, INT);
	}


public static void addLunar3RunesLargeBox(int ID, int r1, int r2, int r3, int ra1, int ra2, int ra3,int rune1, int rune2, int lvl,String name, String descr,RSFont[] RSFont, int sid,int suo,int type){
	Widget rsInterface = addInterface(ID);
	rsInterface.id = ID;
	rsInterface.parentID = 1151;
	rsInterface.type = 5;
	rsInterface.atActionType = type;
	rsInterface.contentType = 0;
	rsInterface.hoverType = ID+1;
	rsInterface.spellUsableOn = suo;
	rsInterface.selectedActionName = "Cast on";
	rsInterface.width = 20;
	rsInterface.height = 20;
	rsInterface.tooltip = "Cast <col=65280>"+name;
	rsInterface.spellName = name;
	rsInterface.anIntArray245 = new int[4];
	rsInterface.anIntArray212 = new int[4];
	rsInterface.anIntArray245[0] = 3;
	rsInterface.anIntArray212[0] = ra1;
	rsInterface.anIntArray245[1] = 3;
	rsInterface.anIntArray212[1] = ra2;
	rsInterface.anIntArray245[2] = 3;
	rsInterface.anIntArray212[2] = ra3;
	rsInterface.anIntArray245[3] = 3;
	rsInterface.anIntArray212[3] = lvl;
	rsInterface.valueIndexArray = new int[4][];
	rsInterface.valueIndexArray[0] = new int[4];
	rsInterface.valueIndexArray[0][0] = 4;
	rsInterface.valueIndexArray[0][1] = 3214;
	rsInterface.valueIndexArray[0][2] = r1;
	rsInterface.valueIndexArray[0][3] = 0;
	rsInterface.valueIndexArray[1] = new int[4];
	rsInterface.valueIndexArray[1][0] = 4;
	rsInterface.valueIndexArray[1][1] = 3214;
	rsInterface.valueIndexArray[1][2] = r2;
	rsInterface.valueIndexArray[1][3] = 0;
	rsInterface.valueIndexArray[2] = new int[4];
	rsInterface.valueIndexArray[2][0] = 4;
	rsInterface.valueIndexArray[2][1] = 3214;
	rsInterface.valueIndexArray[2][2] = r3;
	rsInterface.valueIndexArray[2][3] = 0;
	rsInterface.valueIndexArray[3] = new int[3];
	rsInterface.valueIndexArray[3][0] = 1;
	rsInterface.valueIndexArray[3][1] = 6;
	rsInterface.valueIndexArray[3][2] = 0;
	rsInterface.enabledSprite =  imageLoader(sid, "Lunar/LUNARON");
	rsInterface.disabledSprite =  imageLoader(sid, "Lunar/LUNAROFF");
	Widget INT = addInterface(ID+1);
	INT.isMouseoverTriggered = true;
	INT.hoverType = -1;
	setChildren(9, INT);
	addLunarSprite(ID+2, 2, "BOX");
	setBounds(ID+2, 0, 0, 0, INT);
	addText(ID+3, "Level "+(lvl+1)+": "+name, 0xFF981F, true, true, 52, RSFont, 1);
	setBounds(ID+3, 90, 4, 1, INT);
	addText(ID+4, descr, 0xAF6A1A, true, true, 52, RSFont, 0);	
	setBounds(ID+4, 90, 34, 2, INT);
	setBounds(30016, 14, 61, 3, INT);
	setBounds(rune1, 74, 61, 4, INT);
	setBounds(rune2, 130, 61, 5, INT);
	addRuneText(ID+5, ra1+1, r1, RSFont);
	setBounds(ID+5, 26, 92, 6, INT);
	addRuneText(ID+6, ra2+1, r2, RSFont);
	setBounds(ID+6, 87, 92, 7, INT);
	addRuneText(ID+7, ra3+1, r3, RSFont);
	setBounds(ID+7, 142, 92, 8, INT);
}

	private static Sprite LoadLunarSprite(int i, String s) {
		Sprite sprite = imageLoader(i, "/Lunar/" + s);
		return sprite;
	}
   private static void printFreeIdRange(int minimumFreeSlotsAvailable){
		for(int i = 0; i < interfaceCache.length; i++){
			int freeSlots = 0;
			while(interfaceCache.length > (i+1) && interfaceCache[i++] == null)
				freeSlots++;
			if(freeSlots >= minimumFreeSlotsAvailable)
				System.out.println("RANGE	["+i+", "+(i+freeSlots)+"]	(has "+freeSlots+" free slots)");
		}
	}
	private static void skotizo(RSFont[] tda) {
		Widget tab = addInterface(29230);
		tab.totalChildren(5);
		addSprite(29231, 0, "Interfaces/Skotizo/SKOTIZOM");
		tab.child(0, 29231, 36, 141);
		addSprites(29232, "Interfaces/Skotizo/SKOTIZO", 3, 0);
		tab.child(1, 29232, 56, 128);
		addSprites(29233, "Interfaces/Skotizo/SKOTIZO", 3, 0);
		tab.child(2, 29233, 56, 193);
		addSprites(29234, "Interfaces/Skotizo/SKOTIZO", 3, 0);
		tab.child(3, 29234, 23, 160);
		addSprites(29235, "Interfaces/Skotizo/SKOTIZO", 3, 0);
		tab.child(4, 29235, 88, 160);
	}

   private static void addTransparentSprite(int id, int spriteId, String spriteName, int transparency) {
      Widget tab = interfaceCache[id] = new Widget();
      tab.id = id;
      tab.parentID = id;
      tab.type = 5;
      tab.atActionType = 0;
      tab.contentType = 0;
      tab.transparency = (byte)transparency;
      tab.hoverType = 52;
      tab.disabledSprite = imageLoader(spriteId, spriteName);
      tab.enabledSprite = imageLoader(spriteId, spriteName);
      tab.width = 512;
      tab.height = 334;
      tab.drawsTransparent = true;
   }
	public static void addSprites(int id, String path, int... spriteIds) {
		if (spriteIds.length < 2) {
			throw new IllegalStateException(
					"Error adding sprites, not enough sprite id's provided.");
		}
		Widget component = addInterface(id);
		component.id = id;
		component.type = 19;
		component.backgroundSprites = new Sprite[spriteIds.length];
		for (int i = 0; i < spriteIds.length; i++) {
			component.backgroundSprites[i] = imageLoader(spriteIds[i], path);
			if (component.backgroundSprites[i] == null) {
				throw new IllegalStateException(
						"Error adding sprites, unable to find one of the images.");
			}
		}
		component.enabledSprite = component.backgroundSprites[0];
	}
	public static void addClickableSprites(int id, String tooltip, String path,
			int... spriteIds) {
		addSprites(id, path, spriteIds);
		Widget component = interfaceCache[id];
		component.atActionType = 4;
		component.tooltip = tooltip;
		component.width = component.backgroundSprites[0].myWidth;
		component.height = component.backgroundSprites[0].myHeight;
	}
	public static void Pestpanel(RSFont[] tda) {
		Widget RSinterface = addTab(21119);
		addText(21120, "Next Departure:", 0xCCCBCB, false, true, 52, tda, 1);
		addText(21121, "Players Ready:", 0x5BD230, false, true, 52, tda, 1);
		addText(21122, "(Need 5 to 25 players)", 0xDED36A, false, true, 52, tda, 1);
		addText(21123, "Pest Points:", 0x99FFFF, false, true, 52, tda, 1);
		int last = 4;
		RSinterface.children = new int[last];
		RSinterface.childX = new int[last];
		RSinterface.childY = new int[last];
		setBounds(21120, 15, 12, 0, RSinterface);
		setBounds(21121, 15, 30, 1, RSinterface);
		setBounds(21122, 15, 48, 2, RSinterface);
		setBounds(21123, 15, 66, 3, RSinterface);

		Widget rsi = interfaceCache[6114] = new Widget();
		rsi.type = 4;
		rsi.width = 390;
		rsi.centerText = true;
	}
	public int grandExchangeSlot;

	public int[] colorTypes;
	public byte progressBarState, progressBarPercentage;
	
	public static final int BEGIN_READING_PRAYER_INTERFACE = 6;// Amount of total custom prayers we've added
	public static final int CUSTOM_PRAYER_HOVERS = 3; // Amount of custom prayer hovers we've added

	public static final int PRAYER_INTERFACE_CHILDREN = 80 + BEGIN_READING_PRAYER_INTERFACE + CUSTOM_PRAYER_HOVERS;


	
	public static void addProgressBar(int identity, int width, int height, int[] colorTypes) {
		Widget component = addInterface(identity);
		component.id = identity;
		component.type = 23;
		component.width = width;
		component.height = height;
		component.colorTypes = colorTypes;
	}
	public static void Pestpanel2(RSFont[] tda) {
		Widget RSinterface = addInterface(21100);
		addSprite(21101, 0, "Interfaces/Pest Control/PEST1");
		addSprite(21102, 1, "Interfaces/Pest Control/PEST1");
		addSprite(21103, 2, "Interfaces/Pest Control/PEST1");
		addSprite(21104, 3, "Interfaces/Pest Control/PEST1");
		addSprite(21105, 4, "Interfaces/Pest Control/PEST1");
		addSprite(21106, 5, "Interfaces/Pest Control/PEST1");
		addText(21107, "", 0xCC00CC, false, true, 52, tda, 1);
		addText(21108, "", 0x0000FF, false, true, 52, tda, 1);
		addText(21109, "", 0xFFFF44, false, true, 52, tda, 1);
		addText(21110, "", 0xCC0000, false, true, 52, tda, 1);
		addText(21111, "", 0x99FF33, false, true, 52, tda, 1);// w purp
		addText(21112, "", 0x99FF33, false, true, 52, tda, 1);// e blue
		addText(21113, "", 0x99FF33, false, true, 52, tda, 1);// se yel
		addText(21114, "", 0x99FF33, false, true, 52, tda, 1);// sw red
		addText(21115, "200", 0x99FF33, false, true, 52, tda, 1);// attacks
		addText(21116, "", 0x99FF33, false, true, 52, tda, 1);// knights hp
		addText(21117, "Time Remaining:", 0xFFFFFF, false, true, 52, tda, 0);
		addText(21118, "", 0xFFFFFF, false, true, 52, tda, 0);
		int last = 18;
		RSinterface.children = new int[last];
		RSinterface.childX = new int[last];
		RSinterface.childY = new int[last];
		setBounds(21101, 361, 26, 0, RSinterface);
		setBounds(21102, 396, 26, 1, RSinterface);
		setBounds(21103, 436, 26, 2, RSinterface);
		setBounds(21104, 474, 26, 3, RSinterface);
		setBounds(21105, 3, 21, 4, RSinterface);
		setBounds(21106, 3, 50, 5, RSinterface);
		setBounds(21107, 371, 60, 6, RSinterface);
		setBounds(21108, 409, 60, 7, RSinterface);
		setBounds(21109, 443, 60, 8, RSinterface);
		setBounds(21110, 479, 60, 9, RSinterface);
		setBounds(21111, 362, 10, 10, RSinterface);
		setBounds(21112, 398, 10, 11, RSinterface);
		setBounds(21113, 436, 10, 12, RSinterface);
		setBounds(21114, 475, 10, 13, RSinterface);
		setBounds(21115, 32, 32, 14, RSinterface);
		setBounds(21116, 32, 62, 15, RSinterface);
		setBounds(21117, 8, 88, 16, RSinterface);
		setBounds(21118, 87, 88, 17, RSinterface);
	}
	public static Widget addScreenInterface(int id) {
		Widget tab = interfaceCache[id] = new Widget();
		tab.id = id;
		tab.parentID = id;
		tab.type = 0;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.width = 512;
		tab.height = 334;
		tab.opacity = (byte) 0;
		tab.hoverType = 0;
		return tab;
	}
	public static void barrowText(RSFont[] tda) {
		Widget tab = addScreenInterface(16128);
		addText(16129, "Barrows Brothers", tda, 2, 0xff981f, true, true);
		addText(16130, "Dharoks", tda, 1, 0x86B404, true, true);
		addText(16131, "Veracs", tda, 1, 0x86B404, true, true);
		addText(16132, "Ahrims", tda, 1, 0x86B404, true, true);
		addText(16133, "Torags", tda, 1, 0x86B404, true, true);
		addText(16134, "Guthans", tda, 1, 0x86B404, true, true);
		addText(16135, "Karils", tda, 1, 0x86B404, true, true);
		addText(16136, "Killcount:", tda, 2, 0xff981f, true, true);
		addText(16137, "#", tda, 1, 0x86B404, true, true);
		tab.totalChildren(9);
		tab.child(0, 16129, 452, 220);
		tab.child(1, 16130, 460, 240);
		tab.child(2, 16131, 460, 255);
		tab.child(3, 16132, 460, 270);
		tab.child(4, 16133, 460, 285);
		tab.child(5, 16134, 460, 300);
		tab.child(6, 16135, 460, 315);
		tab.child(7, 16136, 30, 318);
		tab.child(8, 16137, 68, 318);
	}

	public static void runepouch(RSFont[] tda) {
		Widget tab = addInterface(41700);
		addSprite(41701, 0, "runepouch/sprite");
		addSprite(41705, 0, "runepouch/rune");
		addSprite(41706, 1, "runepouch/rune");
		addText(41702, "Rune pouch", tda, 2, 0xFFA500, true, true);
		addText(41703, "Pouch", tda, 2, 0xFFA500, true, true);
		addText(41704, "Inventory", tda, 2, 0xFFA500, true, true);
		addHoverButton(41707, "runepouch/close", 0, 21, 21, "Close window", 0, 41708, 1);
		addHoveredButton(41708, "runepouch/close", 1, 21, 21, 41709);
		Widget add = addInterface(41710);
		addToItemGroup(add, 3, 1, 26, 1, false, null, null, null);
		add = addInterface(41711);
		addToItemGroup(add, 7, 4, 16, 4, false, null, null, null);
		tab.totalChildren(10);
		tab.child(0, 41701, 0, 0);
		tab.child(1, 41702, 253, 29);
		tab.child(2, 41703, 253, 62);
		tab.child(3, 41704, 253, 137);
		tab.child(4, 41705, 105, 57);
		tab.child(5, 41706, 342, 57);
		tab.child(6, 41707, 406, 26);
		tab.child(7, 41708, 406, 26);
		tab.child(8, 41710, 186, 86);
		tab.child(9, 41711, 98, 154);
	}
	public static void prayerBook(RSFont[] tda) {
		Widget tab = addTabInterface(15608);
		tab.totalChildren(10);
		Widget prayerBook = interfaceCache[5608];

		// Switches the Chivalry & Piety positions.
		/** Chivalry **/
		int xMinus = 1;
		int minusX = 37;
/*		prayerBook.childX[50] = 41 - minusX;
		prayerBook.childY[50] = 195 - xMinus;
		prayerBook.childX[51] = 48 - minusX;
		prayerBook.childY[51] = 197 - xMinus;
		prayerBook.childX[63] = 41 - minusX;
		prayerBook.childY[63] = 200 - xMinus;

		*//** Piety **//*
		prayerBook.childX[52] = 41;
		prayerBook.childY[52] = 195 - xMinus;
		prayerBook.childX[53] = 43;
		prayerBook.childY[53] = 206 - xMinus;
		prayerBook.childX[64] = 48;
		prayerBook.childY[64] = 197 - xMinus;*/

		addPrayer(39401, 0, 708, 55, 26, "Preserve");
		addPrayer(39404, 0, 710, 74, 27, "Rigour");
		addPrayer(39407, 0, 712, 77, 28, "Augury");
		addPrayerHover(tda, 1, 39409,
				"Level 77\\nAugury\\nIncreases your Magic attack\\nby 25% and your defence by\\n25%", -110, -100);
		addPrayerHover(tda, 1, 39403, "Level 55\\nPreserve\\nBoosted stats last 20%\nlonger.", -135, -60);
		addPrayerHover(tda, 1, 39406,
				"Level 74\\nRigour\\nIncreases your Ranged attack\\nby 20% and damage by 23%,\\nand your defence by 25%",
				-70, -100);
		setBounds(39401, 152, 158 - xMinus, 0, tab);
		setBounds(39404, 78, 195 - xMinus, 1, tab);
		setBounds(39407, 115, 195 - xMinus, 2, tab);
		setBounds(39402, 154, 158 - xMinus, 3, tab);
		setBounds(39405, 81, 198 - xMinus, 4, tab);
		setBounds(39408, 118, 198 - xMinus, 5, tab);
		setBounds(5608, 0, 0 - xMinus, 6, tab);
		setBounds(39403, 154, 158 - xMinus, 7, tab);
		setBounds(39406, 84, 198 - xMinus, 8, tab);
		setBounds(39409, 120, 198 - xMinus, 9, tab);

	}
	public static void addPrayerHover(RSFont[] tda, int idx, int ID, String hover, int xOffset, int yOffset) {
		// Adding hover box
		Widget p = addTabInterface(ID);
		p.inventoryhover = true;
		p.parentID = 5608;
		p.type = 8;
		p.width = 40;
		p.height = 32;
		p.hoverText = p.message = hover;
		p.textDrawingAreas = tda[idx];
		p.hoverXOffset = xOffset;
		p.hoverYOffset = yOffset;
		p.regularHoverBox = true;
	}
	public static void ancients(RSFont[] tda) {
		Widget p = addTabInterface(838);
		Widget rsinterface = interfaceCache[12855];
		// rsinterface.childX[6] = 10;
		rsinterface.childY[22] = 153;
		rsinterface.childX[22] = 18;
		rsinterface.childY[30] = 153;
		rsinterface.childX[30] = 65;
		rsinterface.childY[44] = 153; // ANNAKARL
		rsinterface.childX[44] = 112;
		rsinterface.childY[46] = 180; // GHORROCK
		rsinterface.childX[46] = 65;
		rsinterface.childY[7] = 181; // ICE BARRAGE
		rsinterface.childX[7] = 18;
		rsinterface.childY[15] = 153; // BLOOD BARRAGE
		rsinterface.childX[15] = 152;

		addSpellBig2(34674, 563, 560, 562, 10, 10, 10, 30009, 30009, 30011, 85, "Teleport to Target",
				"Teleports you near your Bounty\\nHunter Target", tda, 9, 7, 5);
		setChildren(3, p);
		setBounds(12855, 0, 0, 0, p);
		setBounds(34674, 150, 123, 1, p);
		setBounds(34675, 5, -5, 2, p);
	}
	public static void addSpellBig2(int ID, int r1, int r2, int r3, int ra1, int ra2, int ra3, int rune1,
			int rune2, int rune3, int lvl, String name, String descr, RSFont[] TDA, int sid, int suo, int type) {
		Widget rsInterface = addInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 5;
		rsInterface.atActionType = type;
		rsInterface.contentType = 0;
		rsInterface.hoverType = ID + 1;
		rsInterface.spellUsableOn = suo;
		rsInterface.selectedActionName = "Cast on";
		rsInterface.width = 20;
		rsInterface.height = 20;
		rsInterface.tooltip = "Cast @gre@" + name;
		rsInterface.spellName = name;
		rsInterface.anIntArray245 = new int[4];
		rsInterface.anIntArray212 = new int[4];
		rsInterface.anIntArray245[0] = 3;
		rsInterface.anIntArray212[0] = ra1;
		rsInterface.anIntArray245[1] = 3;
		rsInterface.anIntArray212[1] = ra2;
		rsInterface.anIntArray245[2] = 3;
		rsInterface.anIntArray212[2] = ra3;
		rsInterface.anIntArray245[3] = 3;
		rsInterface.anIntArray212[3] = lvl;
		rsInterface.valueIndexArray = new int[4][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[4];
		rsInterface.valueIndexArray[1][0] = 4;
		rsInterface.valueIndexArray[1][1] = 3214;
		rsInterface.valueIndexArray[1][2] = r2;
		rsInterface.valueIndexArray[1][3] = 0;
		rsInterface.valueIndexArray[2] = new int[4];
		rsInterface.valueIndexArray[2][0] = 4;
		rsInterface.valueIndexArray[2][1] = 3214;
		rsInterface.valueIndexArray[2][2] = r3;
		rsInterface.valueIndexArray[2][3] = 0;
		rsInterface.valueIndexArray[3] = new int[3];
		rsInterface.valueIndexArray[3][0] = 1;
		rsInterface.valueIndexArray[3][1] = 6;
		rsInterface.valueIndexArray[3][2] = 0;
		rsInterface.disabledSprite = Main.cacheSprite2[sid];
		rsInterface.enabledSprite = Main.cacheSprite2[sid];
		Widget INT = addInterface(ID + 1);
		INT.isMouseoverTriggered = true;
		INT.hoverType = -1;
		setChildren(9, INT);
		addLunarSprite(ID + 2, 1, "BOX");
		setBounds(ID + 2, 0, 0, 0, INT);
		addText(ID + 3, "Level " + (lvl + 1) + ": " + name, 0xFF981F, true, true, 52, TDA, 1);
		setBounds(ID + 3, 90, 4, 1, INT);
		addText(ID + 4, descr, 0xAF6A1A, true, true, 52, TDA, 0);
		setBounds(ID + 4, 90, 21, 2, INT);
		setBounds(rune1, 14, 48, 3, INT);
		setBounds(rune2, 74, 48, 4, INT);
		setBounds(rune3, 130, 48, 5, INT);
		addRuneText(ID + 5, ra1, r1, TDA);
		setBounds(ID + 5, 26, 79, 6, INT);
		addRuneText(ID + 6, ra2, r2, TDA);
		setBounds(ID + 6, 87, 79, 7, INT);
		addRuneText(ID + 7, ra3, r3, TDA);
		setBounds(ID + 7, 142, 79, 8, INT);
	}
	public static void prayerTab(RSFont[] tda) {
		Widget tab = addTabInterface(5608);
		Widget currentPray = interfaceCache[687];
		addSprite(5651, 0, "Prayer/PRAYER");
		currentPray.textColor = 0xFF981F;
		currentPray.textShadow = true;
		currentPray.message = "%1/%2";

		int[] ID1 = { 18016, 18017, 18018, 18019, 18020, 18021, 18022, 18023, 18024, 18025, 18026, 18027, 18028, 18029,
				18030, 18031, 18032, 18033, 18034, 18035, 18036, 18037, 18038, 18039, 18040, 18041 };
		int[] X = { 8, 44, 80, 114, 150, 8, 44, 80, 116, 152, 8, 42, 78, 116, 152, 8, 44, 80, 116, 150, 6, 44, 80, 116,
				150, 6 };
		int[] Y = { 6, 6, 6, 4, 4, 42, 42, 42, 42, 42, 79, 76, 76, 78, 78, 114, 114, 114, 114, 112, 148, 150, 150, 150,
				148, 184 };

		int[] hoverIDs = { 18050, 18052, 18054, 18056, 18058, 18060, 18062, 18064, 18066, 18068, 18070, 18072, 18074,
				18076, 18078, 18080, 18082, 18084, 18086, 18088, 18090, 18092, 18094, 18096, 18098, 18100 };
		int[] hoverX = { 12, 8, 20, 12, 24, 2, 2, 6, 6, 50, 6, 6, 10, 6, 6, 5, 5, 5, 5, 5, 18, 28, 28, 50, 1, 1 };
		int[] hoverY = { 42, 42, 42, 42, 42, 80, 80, 80, 80, 80, 118, 118, 118, 118, 118, 150, 150, 150, 150, 150, 105,
				80, 65, 65, 65, 110 };
		String[] hoverStrings = { "Level 01\nThick Skin\nIncreases your Defence by 5%",
				"Level 04\nBurst of Strength\nIncreases your Strength by 5%",
				"Level 07\nCharity of Thought\nIncreases your Attack by 5%",
				"Level 08\nSharp Eye\nIncreases your Ranged by 5%", "Level 09\nMystic Will\nIncreases your Magic by 5%",
				"Level 10\nRock Skin\nIncreases your Defence by 10%",
				"Level 13\nSuperhuman Strength\nIncreases your Strength by 10%",
				"Level 16\nImproved Reflexes\nIncreases your Attack by 10%",
				"Level 19\nRapid Restore\n2x restore rate for all stats\nexcept Hitpoints and Prayer",
				"Level 22\nRapid Heal\n2x restore rate for the\nHitpoints stat",
				"Level 25\nProtect Item\nKeep one extra item if you die",
				"Level 26\nHawk Eye\nIncreases your Ranged by 10%",
				"Level 27\nMystic Lore\nIncreases your Magic by 10%",
				"Level 28\nSteel Skin\nIncreases your Defence by 15%",
				"Level 31\nUltimate Strength\nIncreases your Strength by 15%",
				"Level 34\nIncredible Reflexes\nIncreases your Attack by 15%",
				"Level 37\nProtect from Magic\nProtection from magical attacks",
				"Level 40\nProtect from Missiles\nProtection from ranged attacks",
				"Level 43\nProtect from Melee\nProtection from close attacks",
				"Level 44\nEagle Eye\nIncreases your Ranged by 15%",
				"Level 45\nMystic Might\nIncreases your Magic by 15%",
				"Level 46\nRetribution\nInflicts damage to nearby\ntargets if you die",
				"Level 49\nRedemption\nHeals you when damaged\nand Hitpoints falls\nbelow 10%",
				"Level 52\nSmite\n1/4 of damage dealt is\nalso removed from\nopponents Prayer",
				"Level 60\nChivalry\nIncreases your Defence by 20%,\nStrength by 18% and Attack by\n15%",
				"Level 70\nPiety\nIncreases your Defence by 25%,\nStrength by 23% and Attack by\n20%" };

		int[] ID2 = {5609, 5610, 5611, 5612, 5613, 5614, 5615, 5616, 5617, 5618, 5619, 5620, 5621, 5622, 5623, 683,
				684, 685, 5632, 5633, 5634, 5635, 5636, 5637, 5638, 5639, 5640, 5641, 5642, 5643, 5644, 686, 5645, 5649,
				5647, 5648, 18000, 18001, 18002, 18003, 18004, 18005, 18006, 18007, 18008, 18009, 18010, 18011, 18012,
				18013, 18014, 18015, 5651, 687};
		int[] X2 = {6, 42, 78, 6, 42, 78, 114, 150, 6, 114, 150, 6, 42, 78, 114, 42, 78, 114, 8, 44, 80, 8, 44, 80,
				116, 152, 8, 116, 152, 8, 44, 80, 116, 44, 80, 116, 114, 117, 150, 153, 42, 45, 78, 81, 150, 153, 6, 9,
				150, 157, 6, 8, 68, 90};
		int[] Y2 = {4, 4, 4, 40, 40, 40, 40, 40, 76, 76, 76, 112, 112, 112, 112, 148, 148, 148, 6, 6, 6, 42, 42, 42,
				42, 42, 79, 78, 78, 114, 114, 114, 114, 150, 150, 150, 4, 8, 4, 7, 76, 80, 76, 79, 112, 116, 148, 151,
				148, 151, 184, 194, 242, 244};

		String[] oldPrayerNames = { "Thick Skin", "Burst of Strength", "Charity of Thought", "Rock Skin",
				"Superhuman Strength", "Improved Reflexes", "Rapid Restore", "Rapid Heal", "Protect Item", "Steel Skin",
				"Ultimate Strength", "Incredible Reflexes", "Protect from Magic", "Protect from Missiles",
				"Protect from Melee", "Retribution", "Redemption", "Smite" };
		addPrayer(18000, 0, 601, 7, 0, "Sharp Eye");
		addPrayer(18002, 0, 602, 8, 1, "Mystic Will");
		addPrayer(18004, 0, 603, 25, 2, "Hawk Eye");
		addPrayer(18006, 0, 604, 26, 3, "Mystic Lore");
		addPrayer(18008, 0, 605, 43, 4, "Eagle Eye");
		addPrayer(18010, 0, 606, 44, 5, "Mystic Might");
		addPrayer(18012, 0, 607, 59, 6, "Chivalry");
		addPrayer(18014, 0, 608, 69, 7, "Piety");

		for (int i = 0; i < 18; i++) {
			addOldPrayer(ID2[i], oldPrayerNames[i]);
		}

		for (int i = 0; i < 26; i++) {
			addPrayerHover(ID1[i], hoverIDs[i], i, hoverStrings[i]);
		}

		tab.totalChildren(106); // 54
		tab.child(52, 5651, 70, 242);
		for (int ii = 0; ii < 54; ii++) {
			tab.child(ii, ID2[ii], X2[ii], Y2[ii]);
		}

		int frame = 54;
		int frame2 = 0;
		for (int i : ID1) {
			tab.child(frame, i, X[frame2], Y[frame2]);
			frame++;
			frame2++;
		}

		int frame3 = 0;
		for (int i : hoverIDs) {
			tab.child(frame, i, hoverX[frame3], hoverY[frame3]);
			frame++;
			frame3++;
		}
	}
	/**
	 * Adds your current character to an interface.
	 **/

	protected static void addOldPrayer(int id, String prayerName) {
		Widget rsi = interfaceCache[id];
		if (Main.tabInterfaceIDs[Main.tabID] != 17200) {
			rsi.tooltip = "Activate@or1@ " + prayerName;
		}
	}


	public static void addPrayerHover(int i, int hoverID, int prayerSpriteID,
			String hoverText) {
		Widget Interface = addTabInterface(i);
		Interface.id = i;
		Interface.parentID = 5608;
		Interface.type = 5;
		Interface.atActionType = 0;
		Interface.contentType = 0;
		Interface.opacity = 0;
		Interface.hoverType = hoverID;
		Interface.disabledSprite = imageLoader(0, "tabs/prayer/hover/PRAYERH");
		Interface.enabledSprite = imageLoader(0, "tabs/prayer/hover/PRAYERH");
		Interface.width = 34;
		Interface.height = 34;

		Interface = addTabInterface(hoverID);
		Interface.id = hoverID;
		Interface.parentID = 5608;
		Interface.type = 0;
		Interface.atActionType = 0;
		Interface.contentType = 0;
		Interface.opacity = 0;
		Interface.hoverType = -1;
		Interface.width = 512;
		Interface.height = 334;
		Interface.isMouseoverTriggered = true;
		addBox(hoverID + 1, 0, false, 0x000000, hoverText);
		setChildren(1, Interface);
		setBounds(hoverID + 1, 0, 0, 0, Interface);
	}
	public static void addBox(int id, int byte1, boolean filled, int color,
			String text) {
		Widget Interface = addInterface(id);
		Interface.id = id;
		Interface.parentID = id;
		Interface.type = 9;
		Interface.opacity = (byte) byte1;
		Interface.filled = filled;
		Interface.hoverType = -1;
		Interface.atActionType = 0;
		Interface.contentType = 0;
		Interface.textColor = color;
		Interface.message = text;
	}

   public static void addAlphaBox(int id, int width, int height, int color, int opacity) {
		Widget rsInterface = interfaceCache[id] = new Widget();
		rsInterface.id = id;
		rsInterface.parentID = id;
		rsInterface.type = 3;
		rsInterface.hoverType = 52;
		rsInterface.filled = true;
		rsInterface.width = width;
		rsInterface.height = height;
		rsInterface.opacity = (byte) (256 -(-1*opacity));
		rsInterface.textColor = color;
		rsInterface.secondaryColor = color;
		rsInterface.defaultHoverColor = color;
		rsInterface.secondaryHoverColor = color;
	}
   public static void addHoverImage(int i, int j, int k) {
      Widget tab = addTabInterface(i);
      tab.id = i;
      tab.parentID = i;
      tab.type = 5;
      tab.atActionType = 0;
      tab.contentType = 0;
      tab.width = 512;
      tab.height = 334;
      tab.opacity = 0;
      tab.hoverType = 52;
      tab.disabledSpriteId = j;
      tab.enabledSpriteId = k;
   }

   public static void addHoverButton(int i, int disabledSprite, int enabledSprite, int width, int height, String text, int contentType, int hoverOver, int aT) {
      Widget tab = addTabInterface(i);
      tab.id = i;
      tab.parentID = i;
      tab.type = 5;
      tab.atActionType = aT;
      tab.contentType = contentType;
      tab.opacity = 0;
      tab.hoverType = hoverOver;
      tab.disabledSpriteId = disabledSprite;
      tab.enabledSpriteId = enabledSprite;
      tab.width = width;
      tab.height = height;
      tab.tooltip = text;
	   tab.toggled = false;
   }

   public static void addHoveredButton(int i, int disabledSprite, int enabledSprite, int w, int h, int IMAGEID) {
      Widget tab = addTabInterface(i);
      tab.parentID = i;
      tab.id = i;
      tab.type = 0;
      tab.atActionType = 0;
      tab.width = w;
      tab.height = h;
      tab.interfaceShown = true;
      tab.opacity = 0;
      tab.hoverType = -1;
      tab.scrollMax = 0;
      addHoverImage(IMAGEID, disabledSprite, enabledSprite);
      tab.totalChildren(1);
      tab.child(0, IMAGEID, 0, 0);
   }

   public static void addHoverImage(int a, int i, int j, int k, String name) {
      Widget tab = addTabInterface(i);
      tab.id = i;
      tab.parentID = i;
      tab.type = 5;
      tab.atActionType = 0;
      tab.contentType = 0;
      tab.width = 512;
      tab.height = 334;
      tab.opacity = 0;
      tab.hoverType = 52;
      tab.disabledSpriteId = j;
      tab.enabledSpriteId = k;
   }

   public static void addToItemGroup(Widget rsi, int w, int h, int x, int y, boolean actions, String action1, String action2, String action3) {
      rsi.width = w;
      rsi.height = h;
      rsi.inventoryItemId = new int[w * h];
      rsi.inventoryAmounts = new int[w * h];
      rsi.usableItems = false;
      rsi.hasActions = false;
      rsi.spritePaddingX = x;
      rsi.spritePaddingY = y;
      rsi.spritesX = new int[20];
      rsi.spritesY = new int[20];
      rsi.sprites = new Sprite[20];
      rsi.actions = new String[6];
      if(actions) {
         rsi.actions[0] = action1;
         rsi.actions[1] = action2;
         rsi.actions[2] = action3;
      }

      rsi.type = 2;
   }
	public static void addToItemGroup(int id, int w, int h, int x, int y,
			boolean actions, String action1, String action2, String action3) {
		Widget rsi = addInterface(id);
		rsi.width = w;
		rsi.height = h;
		rsi.inventoryItemId = new int[w * h];
		rsi.inventoryAmounts = new int[w * h];
		rsi.usableItems = false;
		rsi.hasActions = false;
		rsi.isMouseoverTriggered = false;
		rsi.spritePaddingX = x;
		rsi.spritePaddingY = y;
		rsi.spritesX = new int[20];
		rsi.spritesY = new int[20];
		rsi.sprites = new Sprite[20];
		rsi.actions = new String[5];
		if (actions) {
			rsi.actions[0] = action1;
			rsi.actions[1] = action2;
			rsi.actions[2] = action3;
		}
		rsi.type = 2;
	}
	public static void lootingBag(RSFont[] tda) {
		Widget tab = addInterface(26700);
		addSprite(26701, 0, "looting/BAG");
		addHoverButton(26702, "looting/BAG", 1, 16, 16, "Close", 0, 26703, 1);
		addHoveredButton(26703, "looting/BAG", 2, 16, 16, 26704);
		addText(26705, "Looting bag", tda, 2, 0xFF9900, true, true);
		int index = 0;
		//itemGroup(26706, 4, 7, 13, 0);
		addToItemGroup(26706 + index, 4, 7, 13, 0, false, "", "", "");
		addText(26707, "Value: 0 coins", tda, 0, 0xFF9900, true, true);
		tab.totalChildren(6);
		tab.child(0, 26701, 9, 21);
		tab.child(1, 26702, 168, 4);
		tab.child(2, 26703, 168, 4);
		tab.child(3, 26705, 95, 4);
		tab.child(4, 26706, 12, 23);
		tab.child(5, 26707, 95, 250);
	}
   public static void collectSell(RSFont[] RSFont) {
	   Widget rsinterface = addTabInterface(54700);
	   int x = 9;
	   addSprite(54701, 1, "Interfaces/GE/sellCollect");

	   addHoverButton(54702, "Interfaces/GrandExchange/close", 1, 16, 16,
	   "Close", 0, 54703, 1);
	   addHoveredButton(54703, "Interfaces/GrandExchange/close", 2, 16, 16,
	   54704);
	   addHoverButton(54758, "Interfaces/GrandExchange/sprite", 25, 29, 23,
	   "Back", 0, 54759, 1);
	   addHoveredButton(54759, "Interfaces/GrandExchange/sprite", 26, 29, 23,
	   54760);
	   addText(54769, "Choose an item to exchange", RSFont, 0, 0x96731A, false,
	   true);
	   addText(54770, "Select an item from your invertory to sell.", RSFont, 0,
	   0x958E60, false, true);
	   addText(54771, "0", RSFont, 0, 0xB58338, true, true);
	   addText(54772, "1 gp", RSFont, 0, 0xB58338, true, true);
	   addText(54773, "0 gp", RSFont, 0, 0xB58338, true, true);
	   addHoverButton(54793, "Interfaces/GE/collectNoHover", 1, 40, 36,
	   "[GE]", 0, 54794, 1);
	   addHoveredButton(54794, "Interfaces/GE/collectHover", 1, 40, 36, 54795);
	   addHoverButton(54796, "Interfaces/GE/collectNoHover", 1, 40, 36,
	   "[GE]", 0, 54797, 1);
	   addHoveredButton(54797, "Interfaces/GE/collectHover", 1, 40, 36, 54798);
	   Widget add = addInterface(54780);
	   addToItemGroup(add, 1, 1, 24, 24, true, "[GE]", "[GE]", "[GE]");
	   add = addInterface(54781);
	   addToItemGroup(add, 1, 1, 24, 24, true, "[COINS]Collect", "[GE]",
	   "[GE]");
	   add = addInterface(54782);
	   addToItemGroup(add, 1, 1, 24, 24, true, "[ITEM]Collect", "[GE]", "[GE]");
	   addText(54784, "", RSFont, 0, 0xFFFF00, false, true);
	   addText(54785, "", RSFont, 0, 0xFFFF00, false, true);
	   addText(54787, "N/A", RSFont, 0, 0xB58338, false, true);
	   addText(54788, "", RSFont, 0, 0xFFFF00, true, true);
	   addText(54789, "", RSFont, 0, 0xFFFF00, true, true);
	   addHoverButton(54800, "Interfaces/GE/clickAbort", 1, 20, 20,
	   "Abort offer", 0, 54801, 1);
	   addHoveredButton(54801, "Interfaces/GE/clickAbort", 2, 20, 20, 54802);
	   rsinterface.totalChildren(24);
	   rsinterface.child(0, 54701, 4 + x, 23);// 385, 260
	   rsinterface.child(1, 54702, 464 + x, 33);// 435, 260
	   rsinterface.child(2, 54703, 464 + x, 33);
	   rsinterface.child(3, 54758, 19 + x, 284);
	   rsinterface.child(4, 54759, 19 + x, 284);
	   rsinterface.child(5, 54769, 202 + x, 71);
	   rsinterface.child(6, 54770, 202 + x, 98);
	   rsinterface.child(7, 54771, 142 + x, 185);
	   rsinterface.child(8, 54772, 354 + x, 185);
	   rsinterface.child(9, 54773, 252 + x, 246);
	   rsinterface.child(10, 54793, 386 + x, 256 + 23);
	   rsinterface.child(11, 54794, 386 + x, 256 + 23);
	   rsinterface.child(12, 54796, 435 + x, 256 + 23);
	   rsinterface.child(13, 54797, 435 + x, 256 + 23);
	   rsinterface.child(14, 54780, 97 + x, 97);
	   rsinterface.child(15, 54781, 385 + 4 + x, 260 + 23);
	   rsinterface.child(16, 54782, 435 + 4 + x, 260 + 23);
	   rsinterface.child(17, 54784, 385 + 4 + x, 260 + 23);
	   rsinterface.child(18, 54785, 435 + 4 + x, 260 + 23);
	   rsinterface.child(19, 54787, 108, 136);
	   rsinterface.child(20, 54788, 214 + x, 249 + 23);
	   rsinterface.child(21, 54789, 214 + x, 263 + 23);
	   rsinterface.child(22, 54800, 345 + x, 250 + 23);
	   rsinterface.child(23, 54801, 345 + x, 250 + 23);
	   }

	   public static void collectBuy(RSFont[] RSFont) {
	   Widget rsinterface = addTabInterface(53700);
	   int x = 9;
	   addSprite(53701, 1, "Interfaces/GE/buyCollect");
	   addHoverButton(53702, "Interfaces/GrandExchange/close", 1, 16, 16,
	   "Close", 0, 53703, 1);
	   addHoveredButton(53703, "Interfaces/GrandExchange/close", 2, 16, 16,
	   53704);
	   addHoverButton(53758, "Interfaces/GrandExchange/sprite", 25, 29, 23,
	   "Back", 0, 53759, 1);
	   addHoveredButton(53759, "Interfaces/GrandExchange/sprite", 26, 29, 23,
	   53760);
	   addText(53769, "Choose an item to exchange", RSFont, 0, 0x96731A, false,
	   true);
	   addText(53770, "Select an item from your invertory to sell.", RSFont, 0,
	   0x958E60, false, true);
	   addText(53771, "0", RSFont, 0, 0xB58338, true, true);
	   addText(53772, "1 gp", RSFont, 0, 0xB58338, true, true);
	   addText(53773, "0 gp", RSFont, 0, 0xB58338, true, true);
	   addHoverButton(53793, "Interfaces/GE/collectNoHover", 1, 40, 36,
	   "[GE]", 0, 53794, 1);
	   addHoveredButton(53794, "Interfaces/GE/collectHover", 1, 40, 36, 53795);
	   addHoverButton(53796, "Interfaces/GE/collectNoHover", 1, 40, 36,
	   "[GE]", 0, 53797, 1);
	   addHoveredButton(53797, "Interfaces/GE/collectHover", 1, 40, 36, 53798);
	   Widget add = addInterface(53780);
	   addToItemGroup(add, 1, 1, 24, 24, true, "[GE]", "[GE]", "[GE]");
	   add = addInterface(53781);
	   addToItemGroup(add, 1, 1, 24, 24, true, "[ITEM]Collect", "[GE]", "[GE]");
	   add = addInterface(53782);
	   addToItemGroup(add, 1, 1, 24, 24, true, "[COINS]Collect", "[GE]",
	   "[GE]");
	   addText(53784, "", RSFont, 0, 0xFFFF00, false, true);
	   addText(53785, "", RSFont, 0, 0xFFFF00, false, true);
	   addText(53787, "N/A", RSFont, 0, 0xB58338, false, true);
	   addText(53788, "", RSFont, 0, 0xFFFF00, true, true);
	   addText(53789, "", RSFont, 0, 0xFFFF00, true, true);
	   addHoverButton(53800, "Interfaces/GE/clickAbort", 1, 20, 20,
	   "Abort offer", 0, 53801, 1);
	   addHoveredButton(53801, "Interfaces/GE/clickAbort", 2, 20, 20, 53802);
	   rsinterface.totalChildren(24);
	   rsinterface.child(0, 53701, 4 + x, 23);// 385, 260
	   rsinterface.child(1, 53702, 464 + x, 33);// 435, 260
	   rsinterface.child(2, 53703, 464 + x, 33);
	   rsinterface.child(3, 53758, 19 + x, 284);
	   rsinterface.child(4, 53759, 19 + x, 284);
	   rsinterface.child(5, 53769, 202 + x, 71);
	   rsinterface.child(6, 53770, 202 + x, 98);
	   rsinterface.child(7, 53771, 142 + x, 185);
	   rsinterface.child(8, 53772, 354 + x, 185);
	   rsinterface.child(9, 53773, 252 + x, 246);
	   rsinterface.child(10, 53793, 386 + x, 256 + 23);
	   rsinterface.child(11, 53794, 386 + x, 256 + 23);
	   rsinterface.child(12, 53796, 435 + x, 256 + 23);
	   rsinterface.child(13, 53797, 435 + x, 256 + 23);
	   rsinterface.child(14, 53780, 97 + x, 97);
	   rsinterface.child(15, 53781, 385 + 4 + x, 260 + 23);
	   rsinterface.child(16, 53782, 435 + 4 + x, 260 + 23);
	   rsinterface.child(17, 53784, 385 + 4 + x, 260 + 23);
	   rsinterface.child(18, 53785, 435 + 4 + x, 260 + 23);
	   rsinterface.child(19, 53787, 108, 136);
	   rsinterface.child(20, 53788, 214 + x, 249 + 23);
	   rsinterface.child(21, 53789, 214 + x, 263 + 23);
	   rsinterface.child(22, 53800, 345 + x, 250 + 23);
	   rsinterface.child(23, 53801, 345 + x, 250 + 23);
	   }
	   private static void tradeUIAddon(RSFont[] tda) {
			
			Widget main = addInterface(55000);
			interfaceCache[3557].message = "";
			interfaceCache[3558].message = "";
			
			setChildren(3, main);
			
			setBounds(3443, 0, 0, 0, main);
			setBounds(55010, 25, 85, 1, main);
			setBounds(55050, 265, 85, 2, main);
			
			Widget widget = addInterface(55010);
			setChildren(28, widget);
			widget.width = 213;
			widget.height = 205;
			widget.scrollMax = 28 * 15;
			for (int child = 0; child < widget.children.length; child++) {
				addText(55011 + child, "", tda, 2, 0xFFFFFF, true, true);
				setBounds(55011 + child, 100, child * 15, child, widget);
			}
			
			widget = addInterface(55050);
			setChildren(28, widget);
			widget.width = 213;
			widget.height = 205;
			widget.scrollMax = 28 * 15;
			for (int child = 0; child < widget.children.length; child++) {
				addText(55051 + child, "", tda, 2, 0xFFFFFF, true, true);
				setBounds(55051 + child, 100, child * 15, child, widget);
			}
			
		}
	   public static void Buy(RSFont[] RSFont) {
	   Widget rsinterface = addTabInterface(24600);
	   int x = 9;
	   addSprite(24601, 0, "Interfaces/GrandExchange/buy");
	   addHoverButton(24602, "Interfaces/GrandExchange/close", 1, 16, 16,
	   "Close", 0, 24603, 1);
	   addHoveredButton(24603, "Interfaces/GrandExchange/close", 2, 16, 16,
	   24604);
	   addHoverButton(24606, "Interfaces/GrandExchange/sprite", 1, 13, 13,
	   "Decrease Quantity", 0, 24607, 1);
	   addHoveredButton(24607, "Interfaces/GrandExchange/sprite", 3, 13, 13,
	   24608);
	   addHoverButton(24610, "Interfaces/GrandExchange/sprite", 2, 13, 13,
	   "Increase Quantity", 0, 24611, 1);
	   addHoveredButton(24611, "Interfaces/GrandExchange/sprite", 4, 13, 13,
	   24612);
	   addHoverButton(24614, "Interfaces/GrandExchange/sprite", 5, 35, 25,
	   "Add 1", 0, 24615, 1);
	   addHoveredButton(24615, "Interfaces/GrandExchange/sprite", 6, 35, 25,
	   24616);
	   addHoverButton(24618, "Interfaces/GrandExchange/sprite", 7, 35, 25,
	   "Add 10", 0, 24619, 1);
	   addHoveredButton(24619, "Interfaces/GrandExchange/sprite", 8, 35, 25,
	   24620);
	   addHoverButton(24622, "Interfaces/GrandExchange/sprite", 9, 35, 25,
	   "Add 100", 0, 24623, 1);
	   addHoveredButton(24623, "Interfaces/GrandExchange/sprite", 10, 35, 25,
	   24624);
	   addHoverButton(24626, "Interfaces/GrandExchange/sprite", 11, 35, 25,
	   "Add 1000", 0, 24627, 1);
	   addHoveredButton(24627, "Interfaces/GrandExchange/sprite", 12, 35, 25,
	   24628);
	   addHoverButton(24630, "Interfaces/GrandExchange/sprite", 13, 35, 25,
	   "Edit Quantity", 7712, 24631, 1);
	   addHoveredButton(24631, "Interfaces/GrandExchange/sprite", 14, 35, 25,
	   24632);
	   addHoverButton(24634, "Interfaces/GrandExchange/sprite", 15, 35, 25,
	   "Decrease Price", 0, 24635, 1);
	   addHoveredButton(24635, "Interfaces/GrandExchange/sprite", 16, 35, 25,
	   24636);
	   addHoverButton(24638, "Interfaces/GrandExchange/sprite", 17, 35, 25,
	   "Offer Guild Price", 0, 24639, 1);
	   addHoveredButton(24639, "Interfaces/GrandExchange/sprite", 18, 35, 25,
	   24640);
	   addHoverButton(24642, "Interfaces/GrandExchange/sprite", 13, 35, 25,
	   "Edit Price", 7714, 24643, 1);
	   addHoveredButton(24643, "Interfaces/GrandExchange/sprite", 14, 35, 25,
	   24644);
	   addHoverButton(24646, "Interfaces/GrandExchange/sprite", 19, 35, 25,
	   "Increase Price", 0, 24647, 1);
	   addHoveredButton(24647, "Interfaces/GrandExchange/sprite", 20, 35, 25,
	   24648);
	   addHoverButton(24650, "Interfaces/GrandExchange/sprite", 21, 120, 43,
	   "Confirm Offer", 0, 24651, 1);
	   addHoveredButton(24651, "Interfaces/GrandExchange/sprite", 22, 120, 43,
	   24652);
//	   	addHoverButton(1, 24654, "Interfaces/GrandExchange/sprite", 23, 40, 36,
//	   	"Choose Item", 0, 24655, 1);
	   addHoveredButton(24655, "Interfaces/GrandExchange/sprite", 24, 40, 36,
	   24656);
	   addHoverButton(24658, "Interfaces/GrandExchange/sprite", 25, 29, 23,
	   "Back", 0, 24659, 1);
	   addHoveredButton(24659, "Interfaces/GrandExchange/sprite", 26, 29, 23,
	   24660);
	   addHoverButton(24662, "Interfaces/GrandExchange/sprite", 1, 13, 13,
	   "Decrease Price", 0, 24663, 1);
	   addHoveredButton(24663, "Interfaces/GrandExchange/sprite", 3, 13, 13,
	   24664);
	   addHoverButton(24665, "Interfaces/GrandExchange/sprite", 2, 13, 13,
	   "Increase Price", 0, 24666, 1);
	   addHoveredButton(24666, "Interfaces/GrandExchange/sprite", 4, 13, 13,
	   24667);
	   addText(24669, "Choose an item to exchange", RSFont, 0, 0x96731A, false,
	   true);
	   addText(24670, "Click the icon to the left to search for items.", RSFont,
	   0, 0x958E60, false, true);
	   addText(24671, "0", RSFont, 0, 0xB58338, true, true);
	   addText(24672, "1 gp", RSFont, 0, 0xB58338, true, true);
	   addText(24673, "0 gp", RSFont, 0, 0xB58338, true, true);
	   Widget add = addInterface(24680);
	   addToItemGroup(add, 1, 1, 24, 24, true, "[GE]", "[GE]", "[GE]");
	   addText(24682, "N/A", RSFont, 0, 0xB58338, false, true);
	   rsinterface.totalChildren(42);
	   rsinterface.child(0, 24601, 4 + x, 23);
	   rsinterface.child(1, 24602, 464 + x, 33);
	   rsinterface.child(2, 24603, 464 + x, 33);
	   rsinterface.child(3, 24606, 46 + x, 184);
	   rsinterface.child(4, 24607, 46 + x, 184);
	   rsinterface.child(5, 24610, 226 + x, 184);
	   rsinterface.child(6, 24611, 226 + x, 184);
	   rsinterface.child(7, 24614, 43 + x, 208);
	   rsinterface.child(8, 24615, 43 + x, 208);
	   rsinterface.child(9, 24618, 84 + x, 208);
	   rsinterface.child(10, 24619, 84 + x, 208);
	   rsinterface.child(11, 24622, 125 + x, 208);
	   rsinterface.child(12, 24623, 125 + x, 208);
	   rsinterface.child(13, 24626, 166 + x, 208);
	   rsinterface.child(14, 24627, 166 + x, 208);
	   rsinterface.child(15, 24630, 207 + x, 208);
	   rsinterface.child(16, 24631, 207 + x, 208);
	   rsinterface.child(17, 24634, 260 + x, 208);
	   rsinterface.child(18, 24635, 260 + x, 208);
	   rsinterface.child(19, 24638, 316 + x, 208);
	   rsinterface.child(20, 24639, 316 + x, 208);
	   rsinterface.child(21, 24642, 357 + x, 208);
	   rsinterface.child(22, 24643, 357 + x, 208);
	   rsinterface.child(23, 24646, 413 + x, 208);
	   rsinterface.child(24, 24647, 413 + x, 208);
	   rsinterface.child(25, 24650, 191 + x, 273);
	   rsinterface.child(26, 24651, 191 + x, 273);
	   rsinterface.child(27, 24654, 93 + x, 95);
	   rsinterface.child(28, 24655, 93 + x, 95);
	   rsinterface.child(29, 24658, 19 + x, 284);
	   rsinterface.child(30, 24659, 19 + x, 284);
	   rsinterface.child(31, 24662, 260 + x, 184);
	   rsinterface.child(32, 24663, 260 + x, 184);
	   rsinterface.child(33, 24665, 435 + x, 184);
	   rsinterface.child(34, 24666, 435 + x, 184);
	   rsinterface.child(35, 24669, 202 + x, 71);
	   rsinterface.child(36, 24670, 202 + x, 98);
	   rsinterface.child(37, 24671, 142 + x, 185);
	   rsinterface.child(38, 24672, 354 + x, 185);
	   rsinterface.child(39, 24673, 252 + x, 246);
	   rsinterface.child(40, 24680, 97 + x, 97);
	   rsinterface.child(41, 24682, 121, 136);
	   }


	   public static void Sell(RSFont[] RSFont) {
	   Widget rsinterface = addTabInterface(24700);
	   int x = 9;
	   addSprite(24701, 0, "Interfaces/GrandExchange/sell");
	   addHoverButton(24702, "Interfaces/GrandExchange/close", 1, 16, 16,
	   "Close", 0, 24703, 1);
	   addHoveredButton(24703, "Interfaces/GrandExchange/close", 2, 16, 16,
	   24704);
	   addHoverButton(24706, "Interfaces/GrandExchange/sprite", 1, 13, 13,
	   "Decrease Quantity", 0, 24707, 1);
	   addHoveredButton(24707, "Interfaces/GrandExchange/sprite", 3, 13, 13,
	   24708);
	   addHoverButton(24710, "Interfaces/GrandExchange/sprite", 2, 13, 13,
	   "Increase Quantity", 0, 24711, 1);
	   addHoveredButton(24711, "Interfaces/GrandExchange/sprite", 4, 13, 13,
	   24712);
	   addHoverButton(24714, "Interfaces/GrandExchange/sprite", 5, 35, 25,
	   "Sell 1", 0, 24715, 1);
	   addHoveredButton(24715, "Interfaces/GrandExchange/sprite", 6, 35, 25,
	   24716);
	   addHoverButton(24718, "Interfaces/GrandExchange/sprite", 7, 35, 25,
	   "Sell 10", 0, 24719, 1);
	   addHoveredButton(24719, "Interfaces/GrandExchange/sprite", 8, 35, 25,
	   24720);
	   addHoverButton(24722, "Interfaces/GrandExchange/sprite", 9, 35, 25,
	   "Sell 100", 0, 24723, 1);
	   addHoveredButton(24723, "Interfaces/GrandExchange/sprite", 10, 35, 25,
	   24724);
	   addHoverButton(24726, "Interfaces/GrandExchange/sprite", 29, 35, 25,
	   "Sell All", 0, 24727, 1);
	   addHoveredButton(24727, "Interfaces/GrandExchange/sprite", 30, 35, 25,
	   24728);
	   addHoverButton(24730, "Interfaces/GrandExchange/sprite", 13, 35, 25,
	   "Edit Quantity", 7713, 24731, 1);
	   addHoveredButton(24731, "Interfaces/GrandExchange/sprite", 14, 35, 25,
	   24732);
	   addHoverButton(24734, "Interfaces/GrandExchange/sprite", 15, 35, 25,
	   "Decrease Price", 0, 24735, 1);
	   addHoveredButton(24735, "Interfaces/GrandExchange/sprite", 16, 35, 25,
	   24736);
	   addHoverButton(24738, "Interfaces/GrandExchange/sprite", 17, 35, 25,
	   "Offer Guild Price", 0, 24739, 1);
	   addHoveredButton(24739, "Interfaces/GrandExchange/sprite", 18, 35, 25,
	   24740);
	   addHoverButton(24742, "Interfaces/GrandExchange/sprite", 13, 35, 25,
	   "Edit Price", 7715, 24743, 1);
	   addHoveredButton(24743, "Interfaces/GrandExchange/sprite", 14, 35, 25,
	   24744);
	   addHoverButton(24746, "Interfaces/GrandExchange/sprite", 19, 35, 25,
	   "Increase Price", 0, 24747, 1);
	   addHoveredButton(24747, "Interfaces/GrandExchange/sprite", 20, 35, 25,
	   24748);
	   addHoverButton(24750, "Interfaces/GrandExchange/sprite", 21, 120, 43,
	   "Confirm Offer", 0, 24751, 1);
	   addHoveredButton(24751, "Interfaces/GrandExchange/sprite", 22, 120, 43,
	   24752);
	   addHoverButton(24758, "Interfaces/GrandExchange/sprite", 25, 29, 23,
	   "Back", 0, 24759, 1);
	   addHoveredButton(24759, "Interfaces/GrandExchange/sprite", 26, 29, 23,
	   24760);
	   addHoverButton(24762, "Interfaces/GrandExchange/sprite", 1, 13, 13,
	   "Decrease Price", 0, 24763, 1);
	   addHoveredButton(24763, "Interfaces/GrandExchange/sprite", 3, 13, 13,
	   24764);
	   addHoverButton(24765, "Interfaces/GrandExchange/sprite", 2, 13, 13,
	   "Increase Price", 0, 24766, 1);
	   addHoveredButton(24766, "Interfaces/GrandExchange/sprite", 4, 13, 13,
	   24767);
	   addText(24769, "Choose an item to exchange", RSFont, 0, 0x96731A, false,
	   true);
	   addText(24770, "Select an item from your invertory to sell.", RSFont, 0,
	   0x958E60, false, true);
	   addText(24771, "0", RSFont, 0, 0xB58338, true, true);
	   addText(24772, "1 gp", RSFont, 0, 0xB58338, true, true);
	   addText(24773, "0 gp", RSFont, 0, 0xB58338, true, true);
	   Widget add = addInterface(24780);
	   addToItemGroup(add, 1, 1, 24, 24, true, "[GE]", "[GE]", "[GE]");
	   addText(24782, "N/A", RSFont, 0, 0xB58338, false, true);
	   rsinterface.totalChildren(40);
	   rsinterface.child(0, 24701, 4 + x, 23);
	   rsinterface.child(1, 24702, 464 + x, 33);
	   rsinterface.child(2, 24703, 464 + x, 33);
	   rsinterface.child(3, 24706, 46 + x, 184);
	   rsinterface.child(4, 24707, 46 + x, 184);
	   rsinterface.child(5, 24710, 226 + x, 184);
	   rsinterface.child(6, 24711, 226 + x, 184);
	   rsinterface.child(7, 24714, 43 + x, 208);
	   rsinterface.child(8, 24715, 43 + x, 208);
	   rsinterface.child(9, 24718, 84 + x, 208);
	   rsinterface.child(10, 24719, 84 + x, 208);
	   rsinterface.child(11, 24722, 125 + x, 208);
	   rsinterface.child(12, 24723, 125 + x, 208);
	   rsinterface.child(13, 24726, 166 + x, 208);
	   rsinterface.child(14, 24727, 166 + x, 208);
	   rsinterface.child(15, 24730, 207 + x, 208);
	   rsinterface.child(16, 24731, 207 + x, 208);
	   rsinterface.child(17, 24734, 260 + x, 208);
	   rsinterface.child(18, 24735, 260 + x, 208);
	   rsinterface.child(19, 24738, 316 + x, 208);
	   rsinterface.child(20, 24739, 316 + x, 208);
	   rsinterface.child(21, 24742, 357 + x, 208);
	   rsinterface.child(22, 24743, 357 + x, 208);
	   rsinterface.child(23, 24746, 413 + x, 208);
	   rsinterface.child(24, 24747, 413 + x, 208);
	   rsinterface.child(25, 24750, 191 + x, 273);
	   rsinterface.child(26, 24751, 191 + x, 273);
	   rsinterface.child(27, 24758, 19 + x, 284);
	   rsinterface.child(28, 24759, 19 + x, 284);
	   rsinterface.child(29, 24762, 260 + x, 184);
	   rsinterface.child(30, 24763, 260 + x, 184);
	   rsinterface.child(31, 24765, 435 + x, 184);
	   rsinterface.child(32, 24766, 435 + x, 184);
	   rsinterface.child(33, 24769, 202 + x, 71);
	   rsinterface.child(34, 24770, 202 + x, 98);
	   rsinterface.child(35, 24771, 142 + x, 185);
	   rsinterface.child(36, 24772, 354 + x, 185);
	   rsinterface.child(37, 24773, 252 + x, 246);
	   rsinterface.child(38, 24780, 97 + x, 97);
	   rsinterface.child(39, 24782, 121, 136);
	   }

	   public static void BuyandSell(RSFont[] RSFont) {
	   Widget Interface = addTabInterface(24500);
	   setChildren(67, Interface);
	   addHoverButton(24541, "b", 3, 115, 110, "Abort offer", 0, 24542, 1);
	   addHoverButton(24543, "b", 3, 115, 110, "View offer", 0, 24544, 1);
	   addHoverButton(24545, "b", 3, 115, 110, "Abort offer", 0, 24546, 1);
	   addHoverButton(24547, "b", 3, 115, 110, "View offer", 0, 24548, 1);
	   addHoverButton(24549, "b", 3, 115, 110, "Abort offer", 0, 24550, 1);
	   addHoverButton(24551, "b", 3, 115, 110, "View offer", 0, 24552, 1);
	   addHoverButton(24553, "b", 3, 115, 110, "Abort offer", 0, 24554, 1);
	   addHoverButton(24555, "b", 3, 115, 110, "View offer", 0, 24556, 1);
	   addHoverButton(24557, "b", 3, 115, 110, "Abort offer", 0, 24558, 1);
	   addHoverButton(24559, "b", 3, 115, 110, "View offer", 0, 24560, 1);
	   addHoverButton(24561, "b", 3, 115, 110, "Abort offer", 0, 24562, 1);
	   addHoverButton(24563, "b", 3, 115, 110, "View offer", 0, 24564, 1);
	   
	   addHoverButton(24589, "b", 3, 115, 110, "Abort offer", 0, 24590, 1);
	   addHoverButton(24591, "b", 3, 115, 110, "View offer", 0, 24592, 1);
	   
	   addSprite(1, 24579, 2, "Interfaces/GE/IMAGE", false, 115, 110);
	   	addSprite(1, 24580, 2, "Interfaces/GE/IMAGE", false, 115, 110);
	   addSprite(1, 24581, 2, "Interfaces/GE/IMAGE", false, 115, 110);
	   	addSprite(1, 24582, 2, "Interfaces/GE/IMAGE", false, 115, 110);
	   	addSprite(1, 24583, 2, "Interfaces/GE/IMAGE", false, 115, 110);
	   	addSprite(1, 24584, 2, "Interfaces/GE/IMAGE", false, 115, 110);
	   	addSprite(1, 24586, 2, "Interfaces/GE/IMAGE", false, 115, 110);
	   	addSprite(1, 24587, 2, "Interfaces/GE/IMAGE", false, 115, 110);
	   addSprite(24501, 1, "Interfaces/GE/IMAGE");
	   addHoverButton(24502, "Interfaces/GE/CLOSE", 0, 21, 21, "Close", 250, 24503, 3);
	   addHoveredButton(24503, "Interfaces/GE/CLOSE", 1, 21, 21, 24504);
	   
	   addHoverButton(24505, "Interfaces/GE/IMAGE", 3, 47, 46, "Buy", 0, 24506, 1);//done
	   addHoveredButton(24506, "Interfaces/GE/IMAGE", 4, 47, 46, 24507);
	   
	   addHoverButton(24508, "Interfaces/GE/IMAGE", 3, 47, 46, "Buy", 0, 24509,
	   1);//done
	   addHoveredButton(24509, "Interfaces/GE/IMAGE", 4, 47, 46, 24510);
	   addHoverButton(24514, "Interfaces/GE/IMAGE", 3, 47, 46, "Buy", 0, 24515,
	   1);//done
	   addHoveredButton(24515, "Interfaces/GE/IMAGE", 4, 47, 46, 24516);
	   addHoverButton(24517, "Interfaces/GE/IMAGE", 3, 47, 46, "Buy", 0, 24518,
	   1);//done
	   addHoveredButton(24518, "Interfaces/GE/IMAGE", 4, 47, 46, 24519);
	   addHoverButton(24520, "Interfaces/GE/IMAGE", 3, 47, 46, "Buy", 0, 24521,
	   1);//done
	   addHoveredButton(24521, "Interfaces/GE/IMAGE", 4, 50, 50, 24522);
	   addHoverButton(24523, "Interfaces/GE/IMAGE", 3, 50, 50, "Buy", 0, 24524,
	   1);//done
	   addHoveredButton(24524, "Interfaces/GE/IMAGE", 4, 47, 46, 24525);
	   addHoverButton(24511, "Interfaces/GE/IMAGE", 5, 47, 46, "Sell", 0, 24512,
	   1);//done
	   addHoveredButton(24512, "Interfaces/GE/IMAGE", 6, 47, 46, 24513);
	   addHoverButton(24526, "Interfaces/GE/IMAGE", 5, 47, 46, "Sell", 0, 24527,
	   1);//done
	   addHoveredButton(24527, "Interfaces/GE/IMAGE", 6, 47, 46, 24528);
	   addHoverButton(24529, "Interfaces/GE/IMAGE", 5, 47, 46, "Sell", 0, 24530,
	   1);
	   addHoveredButton(24530, "Interfaces/GE/IMAGE", 6, 47, 46, 24531);
	   addHoverButton(24532, "Interfaces/GE/IMAGE", 5, 47, 46, "Sell", 0, 24533,
	   1);//done
	   addHoveredButton(24533, "Interfaces/GE/IMAGE", 6, 47, 46, 24534);
	   addHoverButton(24535, "Interfaces/GE/IMAGE", 5, 47, 46, "Sell", 0, 24536,
	   1);//done
	   addHoveredButton(24536, "Interfaces/GE/IMAGE", 6, 47, 46, 24537);
	   addHoverButton(24538, "Interfaces/GE/IMAGE", 5, 47, 46, "Sell", 0, 24539,
	   1);//done
	   addHoveredButton(24539, "Interfaces/GE/IMAGE", 6, 47, 46, 24540);
	   
	   addHoverButton(84999, "Interfaces/GE/IMAGE", 5, 47, 46, "Sell", 0, 85000,
	   1);//done
	   addHoveredButton(85001, "Interfaces/GE/IMAGE", 6, 47, 46, 85002);

	   addHoverButton(85003, "Interfaces/GE/IMAGE", 5, 47, 46, "Sell", 0, 85004,
	   1);//done
	   addHoveredButton(85005, "Interfaces/GE/IMAGE", 6, 47, 46, 85006);

	   getext(24585, "Grand Exchange", RSFont, 2, 16750623, true, true, 472, 24);
	   getext(24588, "Select an offer slot to set up or view an offer.", RSFont, 1, 16750623, true, true, 472, 20);
	   getext(24589, "Empty", RSFont, 2, 16750623, true, true, 115, 25);
	   getext(24590, "Empty", RSFont, 2, 16750623, true, true, 115, 25);
	   getext(24591, "Empty", RSFont, 2, 16750623, true, true, 115, 25);
	   getext(24592, "Empty", RSFont, 2, 16750623, true, true, 115, 25);
	   getext(24593, "Empty", RSFont, 2, 16750623, true, true, 115, 25);
	   getext(24594, "Empty", RSFont, 2, 16750623, true, true, 115, 25);
	   getext(24595, "Empty", RSFont, 2, 16750623, true, true, 115, 25);
	   getext(24596, "Empty", RSFont, 2, 16750623, true, true, 115, 25);
	   Widget add = addInterface(24567);
	   addToItemGroup(add, 1, 1, 24, 24, true, "[GE]", "[GE]", "[GE]");
	   add = addInterface(24569);
	   addToItemGroup(add, 1, 1, 24, 24, true, "[GE]", "[GE]", "[GE]");
	   add = addInterface(24571);
	   addToItemGroup(add, 1, 1, 24, 24, true, "[GE]", "[GE]", "[GE]");
	   add = addInterface(24573);
	   addToItemGroup(add, 1, 1, 24, 24, true, "[GE]", "[GE]", "[GE]");
	   add = addInterface(24575);
	   addToItemGroup(add, 1, 1, 24, 24, true, "[GE]", "[GE]", "[GE]");
	   add = addInterface(24577);
	   addToItemGroup(add, 1, 1, 24, 24, true, "[GE]", "[GE]", "[GE]");

	   setBounds(24541, 15, 90, 0, Interface);
	   setBounds(24543, 15, 90, 1, Interface);
	   setBounds(24545, 133, 90, 2, Interface);
	   setBounds(24547, 133, 90, 3, Interface);
	   setBounds(24549, 251, 90, 4, Interface);
	   setBounds(24551, 251, 90, 5, Interface);
	   setBounds(24553, 15, 211, 6, Interface);
	   setBounds(24555, 15, 211, 7, Interface);
	   setBounds(24557, 133, 211, 8, Interface);
	   setBounds(24559, 133, 211, 9, Interface);
	   setBounds(24561, 251, 211, 10, Interface);
	   setBounds(24563, 260, 218, 11, Interface);
	   setBounds(24501, 18, 19, 12, Interface);
	   /*setBounds(24579, 30 + 6, 74 + 30, 13, Interface);
	   setBounds(24580, 186 + 6, 74 + 30, 14, Interface);
	   setBounds(24581, 342 + 6, 74 + 30, 15, Interface);
	   setBounds(24582, 30 + 6, 194 + 30, 16, Interface);
	   setBounds(24583, 186 + 6, 194 + 30, 17, Interface);
	   setBounds(24584, 342 + 6, 194 + 30, 18, Interface);*/
	   setBounds(24579, 27, 83, 13, Interface);
	   setBounds(24580, 144, 83, 14, Interface);
	   setBounds(24581, 261, 83, 15, Interface);
	   setBounds(24582, 27, 203, 16, Interface);
	   setBounds(24583, 144, 203, 17, Interface);
	   setBounds(24584, 261, 203, 18, Interface);
	   setBounds(24586, 378, 83, 19, Interface);
	   setBounds(24587, 378, 203, 20, Interface);
	   setBounds(24502, 473, 25, 21, Interface);
	   setBounds(24503, 473, 25, 22, Interface);
	   setBounds(24505, 34, 126, 23, Interface);//frist buy
	   setBounds(24506, 33, 126, 24, Interface);//frist buy
	   setBounds(24508, 150, 126, 25, Interface);//2nd buy
	   setBounds(24509, 150, 126, 26, Interface);//2nd buy
	   setBounds(24511, 90, 127, 27, Interface);//first sell
	   setBounds(24512, 89, 127, 28, Interface);//frist sell
	   setBounds(24514, 267, 127, 29, Interface);//3rd buy
	   setBounds(24515, 267, 127, 30, Interface);//3rd buy
	   setBounds(24517, 268, 247, 31, Interface);
	   setBounds(24518, 268, 247, 32, Interface);
	   setBounds(24520, 151, 247, 33, Interface);
	   setBounds(24521, 151, 247, 34, Interface);
	   setBounds(24523, 34, 247, 35, Interface);
	   setBounds(24524, 34, 247, 36, Interface);
	   setBounds(24526, 90, 247, 37, Interface);
	   setBounds(24527, 90, 247, 38, Interface);
	   setBounds(24529, 207, 247, 39, Interface);
	   setBounds(24530, 207, 247, 40, Interface);
	   setBounds(24532, 207, 127, 41, Interface);
	   setBounds(24533, 207, 127, 42, Interface);
	   setBounds(24535, 324, 247, 43, Interface);
	   setBounds(24536, 324, 247, 44, Interface);
	   setBounds(24538, 324, 127, 45, Interface);
	   setBounds(24539, 324, 127, 46, Interface);

	   setBounds(24585, 24, 25, 47, Interface);
	   setBounds(24588, 24, 59, 48, Interface);
	   setBounds(24589, 27, 83, 49, Interface);
	   setBounds(24590, 144, 83, 50, Interface);
	   setBounds(24591, 261, 83, 51, Interface);
	   setBounds(24592, 378, 83, 52, Interface);
	   setBounds(24589, 27, 203, 53, Interface);
	   setBounds(24590, 144, 203, 54, Interface);
	   setBounds(24591, 261, 203, 55, Interface);
	   setBounds(24592, 378, 203, 56, Interface);
	   setBounds(84999, 441, 127, 57, Interface);
	   setBounds(85001, 441, 127, 58, Interface);
	   setBounds(85003, 441, 247, 59, Interface);
	   setBounds(85005, 441, 247, 60, Interface);
	   
	   setBounds(24567, 39, 106, 61, Interface);
	   setBounds(24569, 46 + 156 - 7, 114 - 7, 62, Interface);
	   setBounds(24571, 46 + 156 + 156 - 7, 114 - 7, 63, Interface);
	   setBounds(24573, 39, 234 - 7, 64, Interface);
	   setBounds(24575, 46 + 156 - 7, 234 - 7, 65, Interface);
	   setBounds(24577, 46 + 156 + 156 - 7, 234 - 7, 66, Interface);
	   }
   public static void addSprite(int a, int id, int spriteId, String spriteName, boolean l, int w, int h) {
      Widget tab = interfaceCache[id] = new Widget();
      tab.id = id;
      tab.parentID = id;
      tab.type = 5;
      tab.atActionType = 0;
      tab.contentType = 0;
      tab.opacity = 0;
      tab.hoverType = 52;
      tab.disabledSprite = imageLoader(spriteId, spriteName);
      tab.enabledSprite = imageLoader(spriteId, spriteName);
      tab.width = w;
      tab.height = h;
   }

   public static void addHDSprite(int id, int spriteId, int enabledSprite) {
      Widget tab = interfaceCache[id] = new Widget();
      tab.id = id;
      tab.parentID = id;
      tab.type = 5;
      tab.advancedSprite = true;
      tab.atActionType = 0;
      tab.contentType = 0;
      tab.opacity = 0;
      tab.hoverType = 52;
      tab.disabledSpriteId = spriteId;
      tab.enabledSpriteId = enabledSprite;
      tab.width = 512;
      tab.height = 1024;
   }

   public static void addItemOnInterface(int childId, int interfaceId, String[] options) {
      Widget rsi = interfaceCache[childId] = new Widget();
      rsi.actions = new String[10];
      rsi.spritesX = new int[20];
      rsi.inventoryItemId = new int[30];
      rsi.inventoryAmounts = new int[25];
      rsi.spritesY = new int[20];
      rsi.children = new int[0];
      rsi.childX = new int[0];
      rsi.childY = new int[0];

      for(int i = 0; i < rsi.actions.length; ++i) {
         if(i < options.length && options[i] != null) {
            rsi.actions[i] = options[i];
         }
      }

      rsi.centerText = true;
      rsi.textShadow = false;
      rsi.replaceItems = false;
      rsi.usableItems = false;
      rsi.hasActions = false;
      rsi.allowSwapItems = true;
      rsi.spritePaddingX = 23;
      rsi.spritePaddingY = 22;
      rsi.height = 5;
      rsi.width = 6;
      rsi.parentID = interfaceId;
      rsi.id = childId;
      rsi.type = 2;
   }

   public void method204(int i, byte byte0, int j) {
      int k = this.inventoryItemId[i];
      this.inventoryItemId[i] = this.inventoryItemId[j];
      if(byte0 == 9) {
         boolean var5 = false;
      } else {
         this.anInt229 = -76;
      }

      this.inventoryItemId[j] = k;
      k = this.inventoryAmounts[i];
      this.inventoryAmounts[i] = this.inventoryAmounts[j];
      this.inventoryAmounts[j] = k;
   }

   public static void addPrayerTooltip(int i, String string) {
      Widget hover = addTabInterface(i);
      hover.type = 8;
      hover.message = string;
      hover.height = 34;
      hover.width = 34;
      hover.inventoryhover = true;
   }

   public static void addPriceChecker(int index) {
      Widget rsi = interfaceCache[index] = new Widget();
      rsi.actions = new String[10];
      rsi.spritesX = new int[20];
      rsi.inventoryAmounts = new int[25];
      rsi.inventoryItemId = new int[30];
      rsi.spritesY = new int[20];
      rsi.children = new int[0];
      rsi.childX = new int[0];
      rsi.childY = new int[0];
      rsi.actions[0] = "Take 1";
      rsi.actions[1] = "Take 5";
      rsi.actions[2] = "Take 10";
      rsi.actions[3] = "Take All";
      rsi.actions[4] = "Take X";
      rsi.centerText = true;
      rsi.filled = false;
      rsi.replaceItems = false;
      rsi.usableItems = false;
      rsi.hasActions = false;
      rsi.allowSwapItems = true;
      rsi.textShadow = false;
      rsi.spritePaddingX = 57;
      rsi.spritePaddingY = 28;
      rsi.height = 5;
      rsi.width = 5;
      rsi.parentID = 22099;
      rsi.id = 4393;
      rsi.type = 2;
   }

   public static void removeConfig(int id) {
      Widget rsi = interfaceCache[id] = new Widget();
   }

   public static void equipmentTab(RSFont[] wid) {
      Widget Interface = interfaceCache[1644];
      addSprite(15101, 0, "Interfaces/Equipment/bl");
      addSprite(15102, 1, "Interfaces/Equipment/bl");
      addSprite(15109, 2, "Interfaces/Equipment/bl");
      removeConfig(21338);
      removeConfig(21344);
      removeConfig(21342);
      removeConfig(21341);
      removeConfig(21340);
      removeConfig(15103);
      removeConfig(15104);
      Interface.children[24] = 15102;
      Interface.childX[24] = 110;
      Interface.childY[24] = 205;
      Interface.children[25] = 15109;
      Interface.childX[25] = 39;
      Interface.childY[25] = 240;
      Interface.children[26] = 27650;
      Interface.childX[26] = 0;
      Interface.childY[26] = 0;
      Interface = addInterface(27650);
      addHoverButton(27651, "Interfaces/Equipment/BOX", 2, 40, 40, "View guide prices", -1, 27652, 1);
      addHoveredButton(27652, "Interfaces/Equipment/HOVER", 2, 40, 40, 27658);
      addHoverButton(27653, "Interfaces/Equipment/BOX", 1, 40, 40, "View Equipment Stats", -1, 27655, 1);
      addHoveredButton(27655, "Interfaces/Equipment/HOVER", 1, 40, 40, 27665);
      addHoverButton(27654, "Interfaces/Equipment/BOX", 3, 40, 40, "View items kept on death", -1, 27657, 1);
      addHoveredButton(27657, "Interfaces/Equipment/HOVER", 3, 40, 40, 27666);
      addHoverButton(27668, "Interfaces/Equipment/BOX", 4, 40, 40, "Call follower", -1, 27669, 1);
      addHoveredButton(27669, "Interfaces/Equipment/HOVER", 4, 40, 40, 27667);
      setChildren(8, Interface);
      setBounds(27651, 50, 205, 0, Interface);
      setBounds(27652, 50, 205, 1, Interface);
      setBounds(27653, 4, 205, 2, Interface);
      setBounds(27654, 96, 205, 3, Interface);
      setBounds(27655, 4, 205, 4, Interface);
      setBounds(27657, 96, 205, 5, Interface);
      setBounds(27668, 142, 205, 6, Interface);
      setBounds(27669, 142, 205, 7, Interface);
   }

   public static void addPrayer(int i, int configId, int configFrame, int requiredValues, int spriteID, String prayerName) {
      Widget tab = addTabInterface(i);
      tab.id = i;
      tab.parentID = 5608;
      tab.type = 5;
      tab.atActionType = 4;
      tab.contentType = 0;
      tab.opacity = 0;
      tab.hoverType = -1;
      tab.disabledSprite = imageLoader(0, "PRAYERGLOW");
      tab.enabledSprite = imageLoader(1, "PRAYERGLOW");
      tab.width = 34;
      tab.height = 34;
      tab.anIntArray245 = new int[1];
      tab.anIntArray212 = new int[1];
      tab.anIntArray245[0] = 1;
      tab.anIntArray212[0] = configId;
      tab.valueIndexArray = new int[1][3];
      tab.valueIndexArray[0][0] = 5;
      tab.valueIndexArray[0][1] = configFrame;
      tab.valueIndexArray[0][2] = 0;
      tab.tooltip = "Select@or2@";
      Widget tab2 = addTabInterface(i + 1);
      tab2.id = i + 1;
      tab2.parentID = 5608;
      tab2.type = 5;
      tab2.atActionType = 0;
      tab2.contentType = 0;
      tab2.opacity = 0;
      tab2.hoverType = -1;
      tab2.disabledSprite = imageLoader(spriteID, "PRAYON");
      tab2.enabledSprite = imageLoader(spriteID, "PRAYOFF");
      tab2.width = 34;
      tab2.height = 34;
      tab2.anIntArray245 = new int[1];
      tab2.anIntArray212 = new int[1];
      tab2.anIntArray245[0] = 2;
      tab2.anIntArray212[0] = requiredValues + 1;
      tab2.valueIndexArray = new int[1][3];
      tab2.valueIndexArray[0][0] = 2;
      tab2.valueIndexArray[0][1] = 5;
      tab2.valueIndexArray[0][2] = 0;
   }

   private static void logInterface(RSFont[] tda) {
      Widget rsi = addInterface('\ubb80');
      String dir = "LOGS/ICON";
      addSprite('\ubb81', 0, dir);
      addHoverButton('\ubb82', dir, 1, 16, 16, "Close Window", 0, '\ubb83', 1);
      addHoveredButton('\ubb83', dir, 2, 16, 16, '\ubb84');
      addHoverButton('\ubb85', dir, 5, 101, 80, "Logs", 0, '\ubb86', 1);
      addHoveredButton('\ubb86', dir, 6, 101, 80, '\ubb87');
      addHoverButton('\ubb88', dir, 7, 101, 80, "Oak", 0, '\ubb89', 1);
      addHoveredButton('\ubb89', dir, 8, 101, 80, '\ubb8a');
      addHoverButton('\ubb8b', dir, 9, 101, 80, "Teak", 0, '\ubb8c', 1);
      addHoveredButton('\ubb8c', dir, 10, 101, 80, '\ubb8d');
      addHoverButton('\ubb8e', dir, 3, 101, 80, "Mahogony", 0, '\ubb8f', 1);
      addHoveredButton('\ubb8f', dir, 4, 101, 80, '\ubb90');
      addText('\ubb91', "What wood would you like to convert to planks?", tda, 0, 16777215, false, true);
      addText('\ubb92', "Wood", tda, 0, 16777215, false, true);
      addText('\ubb93', "Oak", tda, 0, 16777215, false, true);
      addText('\ubb94', "Teak", tda, 0, 16777215, false, true);
      addText('\ubb95', "Mahogony", tda, 0, 16777215, false, true);
      rsi.totalChildren(16);
      rsi.child(0, '\ubb81', 40, 15);
      rsi.child(1, '\ubb82', 475, 18);
      rsi.child(2, '\ubb83', 475, 18);
      rsi.child(3, '\ubb85', 120, 70);
      rsi.child(4, '\ubb86', 120, 70);
      rsi.child(5, '\ubb88', 300, 70);
      rsi.child(6, '\ubb89', 300, 70);
      rsi.child(7, '\ubb8b', 120, 180);
      rsi.child(8, '\ubb8c', 120, 180);
      rsi.child(9, '\ubb8e', 300, 180);
      rsi.child(10, '\ubb8f', 300, 180);
      rsi.child(11, '\ubb91', 170, 22);
      rsi.child(12, '\ubb92', 150, 160);
      rsi.child(13, '\ubb93', 330, 160);
      rsi.child(14, '\ubb94', 150, 270);
      rsi.child(15, '\ubb95', 330, 270);
   }

   public static void addSprite(int i, int j, int k) {
      Widget rsinterface = interfaceCache[i] = new Widget();
      rsinterface.id = i;
      rsinterface.parentID = i;
      rsinterface.type = 5;
      rsinterface.atActionType = 1;
      rsinterface.contentType = 0;
      rsinterface.width = 20;
      rsinterface.height = 20;
      rsinterface.opacity = 0;
      rsinterface.hoverType = 52;
      rsinterface.disabledSprite = imageLoader(j, "Interfaces/Equipment/SPRITE");
      rsinterface.enabledSprite = imageLoader(k, "Interfaces/Equipment/SPRITE");
   }

   public static void addTextButton(int i, String s, String tooltip, int k, boolean l, boolean m, RSFont[] RSFont, int j, int w) {
      Widget rsinterface = addInterface(i);
      rsinterface.parentID = i;
      rsinterface.id = i;
      rsinterface.type = 4;
      rsinterface.atActionType = 1;
      rsinterface.width = w;
      rsinterface.height = 16;
      rsinterface.contentType = 0;
      rsinterface.opacity = 31;
      rsinterface.hoverType = -1;
      rsinterface.centerText = l;
      rsinterface.textShadow = m;
      rsinterface.textDrawingAreas = RSFont[j];
      rsinterface.message = s;
      rsinterface.secondaryText = "";
      rsinterface.secondaryColor = 16750623;
      rsinterface.textColor = 16750623;
      rsinterface.tooltip = tooltip;
   }

   public static void itemsOnDeathDATA(RSFont[] tda) {
      Widget RSinterface = addInterface(17115);
      addText(17109, "", 16750623, false, false, 0, tda, 0);
      addText(17110, "The normal amount of", 16750623, false, false, 0, tda, 0);
      addText(17111, "items kept is three.", 16750623, false, false, 0, tda, 0);
      addText(17112, "", 16750623, false, false, 0, tda, 0);
      addText(17113, "If you are skulled,", 16750623, false, false, 0, tda, 0);
      addText(17114, "you will lose all your", 16750623, false, false, 0, tda, 0);
      addText(17117, "items, unless an item", 16750623, false, false, 0, tda, 0);
      addText(17118, "protecting prayer is", 16750623, false, false, 0, tda, 0);
      addText(17119, "used.", 16750623, false, false, 0, tda, 0);
      addText(17120, "", 16750623, false, false, 0, tda, 0);
      addText(17121, "Item protecting prayers", 16750623, false, false, 0, tda, 0);
      addText(17122, "will allow you to keep", 16750623, false, false, 0, tda, 0);
      addText(17123, "one extra item.", 16750623, false, false, 0, tda, 0);
      addText(17124, "", 16750623, false, false, 0, tda, 0);
      addText(17125, "The items kept are", 16750623, false, false, 0, tda, 0);
      addText(17126, "selected by the server", 16750623, false, false, 0, tda, 0);
      addText(17127, "and include the most", 16750623, false, false, 0, tda, 0);
      addText(17128, "expensive items you\'re", 16750623, false, false, 0, tda, 0);
      addText(17129, "carrying.", 16750623, false, false, 0, tda, 0);
      addText(17130, "", 16750623, false, false, 0, tda, 0);
      RSinterface.parentID = 17115;
      RSinterface.id = 17115;
      RSinterface.type = 0;
      RSinterface.atActionType = 0;
      RSinterface.contentType = 0;
      RSinterface.width = 130;
      RSinterface.height = 197;
      RSinterface.opacity = 0;
      RSinterface.hoverType = -1;
      RSinterface.scrollMax = 280;
      RSinterface.children = new int[20];
      RSinterface.childX = new int[20];
      RSinterface.childY = new int[20];
      RSinterface.children[0] = 17109;
      RSinterface.childX[0] = 0;
      RSinterface.childY[0] = 0;
      RSinterface.children[1] = 17110;
      RSinterface.childX[1] = 0;
      RSinterface.childY[1] = 12;
      RSinterface.children[2] = 17111;
      RSinterface.childX[2] = 0;
      RSinterface.childY[2] = 24;
      RSinterface.children[3] = 17112;
      RSinterface.childX[3] = 0;
      RSinterface.childY[3] = 36;
      RSinterface.children[4] = 17113;
      RSinterface.childX[4] = 0;
      RSinterface.childY[4] = 48;
      RSinterface.children[5] = 17114;
      RSinterface.childX[5] = 0;
      RSinterface.childY[5] = 60;
      RSinterface.children[6] = 17117;
      RSinterface.childX[6] = 0;
      RSinterface.childY[6] = 72;
      RSinterface.children[7] = 17118;
      RSinterface.childX[7] = 0;
      RSinterface.childY[7] = 84;
      RSinterface.children[8] = 17119;
      RSinterface.childX[8] = 0;
      RSinterface.childY[8] = 96;
      RSinterface.children[9] = 17120;
      RSinterface.childX[9] = 0;
      RSinterface.childY[9] = 108;
      RSinterface.children[10] = 17121;
      RSinterface.childX[10] = 0;
      RSinterface.childY[10] = 120;
      RSinterface.children[11] = 17122;
      RSinterface.childX[11] = 0;
      RSinterface.childY[11] = 132;
      RSinterface.children[12] = 17123;
      RSinterface.childX[12] = 0;
      RSinterface.childY[12] = 144;
      RSinterface.children[13] = 17124;
      RSinterface.childX[13] = 0;
      RSinterface.childY[13] = 156;
      RSinterface.children[14] = 17125;
      RSinterface.childX[14] = 0;
      RSinterface.childY[14] = 168;
      RSinterface.children[15] = 17126;
      RSinterface.childX[15] = 0;
      RSinterface.childY[15] = 180;
      RSinterface.children[16] = 17127;
      RSinterface.childX[16] = 0;
      RSinterface.childY[16] = 192;
      RSinterface.children[17] = 17128;
      RSinterface.childX[17] = 0;
      RSinterface.childY[17] = 204;
      RSinterface.children[18] = 17129;
      RSinterface.childX[18] = 0;
      RSinterface.childY[18] = 216;
      RSinterface.children[19] = 17130;
      RSinterface.childX[19] = 0;
      RSinterface.childY[19] = 228;
   }

   public static void questTab(RSFont[] RSFont) {
      Widget Interface = addInterface(638);
      setChildren(6, Interface);
      addText(29155, "Quest Tab", 16750623, false, true, 52, RSFont, 2);
      addButton(29156, 1, "Interfaces/QuestTab/QUEST", 18, 18, "View Achievement Diaries", 1);
      addButton(29270, 3, "Interfaces/QuestTab/QUEST", 18, 18, "View Minigames", 1);
      addButton(49270, 6, "Interfaces/QuestTab/QUEST", 18, 18, "View Kourend Favour", 1);
      addSprite(29157, 0, "Interfaces/QuestTab/QUEST");
      setBounds(29155, 10, 5, 0, Interface);
      setBounds(29156, 134, 4, 1, Interface);
      setBounds(29157, 3, 24, 2, Interface);
      setBounds(29160, 5, 29, 3, Interface);
      setBounds(29270, 152, 4, 4, Interface);
      setBounds(49270, 171, 4, 5, Interface);
      Interface = addInterface(29160);
      Interface.height = 214;
      Interface.width = 165;
      Interface.scrollMax = 1700;
      Interface.newScroller = false;
      setChildren(104, Interface);
      addText(29161, " GodzHell Reborn", 16750623, false, true, 22, RSFont, 1);
      addHoverText(29162, "", "View Progress", RSFont, 0, 16711680, false, true, 150);
      addHoverText(29163, "Players Online", "View Progress", RSFont, 0, 16711680, false, true, 150);
      addHoverText(29164, "Server Information", "View Progress", RSFont, 0, 16711680, false, true, 150);
      addHoverText(29165, "", "View Progress", RSFont, 0, 16711680, false, true, 150);
      addHoverText(29166, "", "View Progress", RSFont, 0, 16711680, false, true, 150);
      setBounds(29161, 4, 4, 0, Interface);
      setBounds(29162, 8, 22, 1, Interface);
      setBounds(29163, 8, 35, 2, Interface);
      setBounds(29164, 8, 48, 3, Interface);
      setBounds(29165, 8, 61, 4, Interface);
      setBounds(29166, 8, 74, 5, Interface);
      int Ypos = 87;
      int frameID = 6;

      for(int iD = 29167; iD <= 29264; ++iD) {
         addHoverText(iD, "", "View" + iD, RSFont, 0, 16711680, false, true, 150);
         setBounds(iD, 8, Ypos, frameID, Interface);
         ++frameID;
         Ypos += 13;
         ++Ypos;
      }

      Interface = addInterface(29265);
      setChildren(5, Interface);
      addText(29266, "        Achievements", 16750623, false, true, -1, RSFont, 2);
      addButton(29267, 2, "Interfaces/QuestTab/QUEST", 18, 18, "Swap to Quests", 1);
      addButton(29271, 3, "Interfaces/QuestTab/QUEST", 18, 18, "Swap to Minigames", 1);
      addSprite(29269, 0, "Interfaces/QuestTab/QUEST");
      setBounds(29266, 10, 5, 0, Interface);
      setBounds(29267, 154, 4, 1, Interface);
      setBounds(29269, 3, 24, 2, Interface);
      setBounds(29268, 5, 29, 3, Interface);
      setBounds(29271, 172, 4, 4, Interface);
      Interface = addInterface(29268);
      Interface.height = 214;
      Interface.width = 165;
      Interface.scrollMax = 215;
      Interface.newScroller = false;
      setChildren(14, Interface);
      setBounds(29295, 8, 6, 0, Interface);
      setBounds(29287, 8, 21, 1, Interface);
      setBounds(29305, 8, 36, 2, Interface);
      setBounds(29306, 8, 51, 3, Interface);
      setBounds(29307, 8, 66, 4, Interface);
      setBounds(29308, 8, 81, 5, Interface);
      setBounds(29309, 8, 96, 6, Interface);
      setBounds(29310, 8, 110, 7, Interface);
      setBounds(29311, 8, 125, 8, Interface);
      setBounds(29312, 8, 155, 9, Interface);
      setBounds(29313, 8, 170, 10, Interface);
      setBounds(29314, 8, 140, 11, Interface);
      setBounds(29315, 8, 185, 12, Interface);
      setBounds(29316, 8, 200, 13, Interface);
      addHoverText(29295, "Tasks Completed: 0", "View Achievements", RSFont, 0, '\uff00', false, true, 150);
      addHoverText(29287, "Easy Tasks", "View Achievements", RSFont, 0, 16750623, false, true, 150);
      addHoverText(29305, "        Task", "View Achievements", RSFont, 0, 16711680, false, true, 150);
      addHoverText(29306, "        Task", "View Achievements", RSFont, 0, 16711680, false, true, 150);
      addHoverText(29307, "        Task", "View Achievements", RSFont, 0, 16711680, false, true, 150);
      addHoverText(29308, "        Task", "View Achievements", RSFont, 0, 16711680, false, true, 150);
      addHoverText(29309, "        Task", "View Achievements", RSFont, 0, 16711680, false, true, 150);
      addHoverText(29310, "Medium Tasks", "View Achievements", RSFont, 0, 16750623, false, true, 150);
      addHoverText(29311, "        Task", "View Achievements", RSFont, 0, 16711680, false, true, 150);
      addHoverText(29314, "        Task", "View Achievements", RSFont, 0, 16711680, false, true, 150);
      addHoverText(29312, "Hard Tasks", "View Achievements", RSFont, 0, 16750623, false, true, 150);
      addHoverText(29313, "        Task", "View Achievements", RSFont, 0, 16711680, false, true, 150);
      addHoverText(29315, "        Task", "View Achievements", RSFont, 0, 16711680, false, true, 150);
      addHoverText(29316, "        Task", "View Achievements", RSFont, 0, 16711680, false, true, 150);
      Interface = addInterface(29300);
      addText(29301, "        MiniGames", 16750623, false, true, -1, RSFont, 2);
      addButton(29302, 2, "Interfaces/QuestTab/QUEST", 18, 18, "Swap to Quests", 1);
      addButton(29303, 1, "Interfaces/QuestTab/QUEST", 18, 18, "Swap to Achievements", 1);
      addSprite(29304, 0, "Interfaces/QuestTab/QUEST");
      setChildren(5, Interface);
      setBounds(29301, 10, 5, 0, Interface);
      setBounds(29302, 154, 4, 1, Interface);
      setBounds(29304, 3, 24, 2, Interface);
      setBounds(29350, 5, 29, 3, Interface);
      setBounds(29303, 172, 4, 4, Interface);
      Interface = addInterface(29350);
      addHoverText(29352, "Barrows", "Teleport to Barrows", RSFont, 0, 16750623, false, true, 150);
      addHoverText(29353, "Castle Wars", "Teleport to Castle Wars", RSFont, 0, 16750623, false, true, 150);
      addHoverText(29351, "Duel Arena", "Teleport to Duel Arena", RSFont, 0, 16750623, false, true, 150);
      addHoverText(29354, "Fight Caves", "Teleport to Fight Caves", RSFont, 0, 16750623, false, true, 150);
      addHoverText(29355, "Fight Pits", "Teleport to Fight Pits", RSFont, 0, 16750623, false, true, 150);
      addHoverText(29356, "Pest Control ", "Teleport to Pest Control", RSFont, 0, 16750623, false, true, 150);
      addHoverText(29357, "Nightmarezone ", "Teleport to Nightmarezone", RSFont, 0, 16750623, false, true, 150);
      addHoverText(29358, "Rouges Den", "Teleport to Rouges Den", RSFont, 0, 16750623, false, true, 150);
      addHoverText(29359, "Warriors Guild", "Teleport to Warriors Guild", RSFont, 0, 16750623, false, true, 150);
      addHoverText(29360, "Clan wars", "Teleport to Clan wars", RSFont, 0, 16750623, false, true, 150);
      addHoverText(29361, "", "", RSFont, 0, 16750623, false, true, 150);
      addHoverText(29362, "", "", RSFont, 0, 16750623, false, true, 150);
      Interface.height = 214;
      Interface.width = 165;
      Interface.scrollMax = 215;
      Interface.newScroller = false;
      setChildren(12, Interface);
      setBounds(29352, 8, 6, 0, Interface);
      setBounds(29353, 8, 21, 1, Interface);
      setBounds(29351, 8, 36, 2, Interface);
      setBounds(29354, 8, 51, 3, Interface);
      setBounds(29355, 8, 66, 4, Interface);
      setBounds(29356, 8, 81, 5, Interface);
      setBounds(29357, 8, 96, 6, Interface);
      setBounds(29358, 8, 110, 7, Interface);
      setBounds(29359, 8, 125, 8, Interface);
      setBounds(29360, 8, 140, 9, Interface);
      setBounds(29361, 8, 155, 10, Interface);
      setBounds(29362, 8, 170, 11, Interface);
   }

   public static void itemsKeptOnDeath(RSFont[] tda) {
      Widget Interface = addInterface(22030);
      addSprite(22031, 1, "Interfaces/Death/SPRITE");
      addHoverButton(22032, "Interfaces/Death/SPRITE", 2, 17, 17, "Close", 250, 22033, 3);
      addHoveredButton(22033, "Interfaces/Death/SPRITE", 3, 17, 17, 22034);
      addText(22035, "", tda, 0, 16750623, false, true);
      addText(22036, "", tda, 0, 16750623, false, true);
      addText(22037, "", tda, 0, 16750623, false, true);
      addText(22038, "", tda, 0, 16750623, false, true);
      addText(22039, "", tda, 0, 16750623, false, true);
      addText(22040, "", tda, 1, 16763955, false, true);
      setChildren(9, Interface);
      setBounds(22031, 7, 8, 0, Interface);
      setBounds(22032, 480, 18, 1, Interface);
      setBounds(22033, 480, 18, 2, Interface);
      setBounds(22035, 348, 98, 3, Interface);
      setBounds(22036, 348, 110, 4, Interface);
      setBounds(22037, 348, 122, 5, Interface);
      setBounds(22038, 348, 134, 6, Interface);
      setBounds(22039, 348, 146, 7, Interface);
      setBounds(22040, 398, 297, 8, Interface);
   }

   public static void itemsOnDeath(RSFont[] wid) {
      Widget rsinterface = addInterface(17100);
      addSprite(17101, 2, 2);
      addText(17103, "Items kept on death", wid, 2, 16750623);
      addText(17104, "Items I will keep...", wid, 1, 16750623);
      addText(17105, "Items I will lose...", wid, 1, 16750623);
      addText(17106, "Info", wid, 1, 16750623);
      addText(17107, "", wid, 1, 16763955);
      addText(17108, "", wid, 1, 16763955);
      rsinterface.interfaceShown = false;
      rsinterface.children = new int[12];
      rsinterface.childX = new int[12];
      rsinterface.childY = new int[12];
      rsinterface.children[0] = 17101;
      rsinterface.childX[0] = 7;
      rsinterface.childY[0] = 8;
      rsinterface.children[1] = 15210;
      rsinterface.childX[1] = 478;
      rsinterface.childY[1] = 17;
      rsinterface.children[2] = 17103;
      rsinterface.childX[2] = 185;
      rsinterface.childY[2] = 18;
      rsinterface.children[3] = 17104;
      rsinterface.childX[3] = 22;
      rsinterface.childY[3] = 49;
      rsinterface.children[4] = 17105;
      rsinterface.childX[4] = 22;
      rsinterface.childY[4] = 109;
      rsinterface.children[5] = 17106;
      rsinterface.childX[5] = 347;
      rsinterface.childY[5] = 49;
      rsinterface.children[6] = 17107;
      rsinterface.childX[6] = 348;
      rsinterface.childY[6] = 270;
      rsinterface.children[7] = 17108;
      rsinterface.childX[7] = 401;
      rsinterface.childY[7] = 293;
      rsinterface.children[8] = 17115;
      rsinterface.childX[8] = 348;
      rsinterface.childY[8] = 64;
      rsinterface.children[9] = 10494;
      rsinterface.childX[9] = 26;
      rsinterface.childY[9] = 71;
      rsinterface.children[10] = 10600;
      rsinterface.childX[10] = 26;
      rsinterface.childY[10] = 129;
      rsinterface.children[11] = 15211;
      rsinterface.childX[11] = 478;
      rsinterface.childY[11] = 17;
      rsinterface = interfaceCache[10494];
      rsinterface.spritePaddingX = 6;
      rsinterface.spritePaddingY = 5;
      rsinterface = interfaceCache[10600];
      rsinterface.spritePaddingX = 6;
      rsinterface.spritePaddingY = 5;
   }


   public static void overlayListener(RSFont[] tda) {
      addText('\u88b8', "", tda, 0, 0);
   }


   public static void skilllevel(RSFont[] tda) {
      Widget text = interfaceCache[7202];
      Widget attack = interfaceCache[6247];
      Widget defence = interfaceCache[6253];
      Widget str = interfaceCache[6206];
      Widget hits = interfaceCache[6216];
      Widget rng = interfaceCache[4443];
      Widget pray = interfaceCache[6242];
      Widget mage = interfaceCache[6211];
      Widget cook = interfaceCache[6226];
      Widget wood = interfaceCache[4272];
      Widget flet = interfaceCache[6231];
      Widget fish = interfaceCache[6258];
      Widget fire = interfaceCache[4282];
      Widget craf = interfaceCache[6263];
      Widget smit = interfaceCache[6221];
      Widget mine = interfaceCache[4416];
      Widget herb = interfaceCache[6237];
      Widget agil = interfaceCache[4277];
      Widget thie = interfaceCache[4261];
      Widget slay = interfaceCache[12122];
      Widget farm = addInterface(25267);
      Widget rune = interfaceCache[4267];
      Widget cons = addInterface(7267);
      Widget hunt = addInterface(29267);
      Widget summ = addInterface(9267);
      addSprite(17878, 0, "Interfaces/skillchat/skill");
      addSprite(17879, 1, "Interfaces/skillchat/skill");
      addSprite(17880, 2, "Interfaces/skillchat/skill");
      addSprite(17881, 3, "Interfaces/skillchat/skill");
      addSprite(17882, 4, "Interfaces/skillchat/skill");
      addSprite(17883, 5, "Interfaces/skillchat/skill");
      addSprite(17884, 6, "Interfaces/skillchat/skill");
      addSprite(17885, 7, "Interfaces/skillchat/skill");
      addSprite(17886, 8, "Interfaces/skillchat/skill");
      addSprite(17887, 9, "Interfaces/skillchat/skill");
      addSprite(17888, 10, "Interfaces/skillchat/skill");
      addSprite(17889, 11, "Interfaces/skillchat/skill");
      addSprite(17890, 12, "Interfaces/skillchat/skill");
      addSprite(17891, 13, "Interfaces/skillchat/skill");
      addSprite(17892, 14, "Interfaces/skillchat/skill");
      addSprite(17893, 15, "Interfaces/skillchat/skill");
      addSprite(17894, 16, "Interfaces/skillchat/skill");
      addSprite(17895, 17, "Interfaces/skillchat/skill");
      addSprite(17896, 18, "Interfaces/skillchat/skill");
      addSprite(27897, 19, "Interfaces/skillchat/skill");
      addSprite(17898, 20, "Interfaces/skillchat/skill");
      addSprite(17899, 21, "Interfaces/skillchat/skill");
      addSprite(17900, 22, "Interfaces/skillchat/skill");
      addSprite(17901, 23, "Interfaces/skillchat/skill");
      setChildren(4, attack);
      setBounds(17878, 20, 30, 0, attack);
      setBounds(4268, 80, 15, 1, attack);
      setBounds(4269, 80, 45, 2, attack);
      setBounds(358, 95, 75, 3, attack);
      setChildren(4, defence);
      setBounds(17879, 20, 30, 0, defence);
      setBounds(4268, 80, 15, 1, defence);
      setBounds(4269, 80, 45, 2, defence);
      setBounds(358, 95, 75, 3, defence);
      setChildren(4, str);
      setBounds(17880, 20, 30, 0, str);
      setBounds(4268, 80, 15, 1, str);
      setBounds(4269, 80, 45, 2, str);
      setBounds(358, 95, 75, 3, str);
      setChildren(4, hits);
      setBounds(17881, 20, 30, 0, hits);
      setBounds(4268, 80, 15, 1, hits);
      setBounds(4269, 80, 45, 2, hits);
      setBounds(358, 95, 75, 3, hits);
      setChildren(4, rng);
      setBounds(17882, 20, 30, 0, rng);
      setBounds(4268, 80, 15, 1, rng);
      setBounds(4269, 80, 45, 2, rng);
      setBounds(358, 95, 75, 3, rng);
      setChildren(4, pray);
      setBounds(17883, 20, 30, 0, pray);
      setBounds(4268, 80, 15, 1, pray);
      setBounds(4269, 80, 45, 2, pray);
      setBounds(358, 95, 75, 3, pray);
      setChildren(4, mage);
      setBounds(17884, 20, 30, 0, mage);
      setBounds(4268, 80, 15, 1, mage);
      setBounds(4269, 80, 45, 2, mage);
      setBounds(358, 95, 75, 3, mage);
      setChildren(4, cook);
      setBounds(17885, 20, 30, 0, cook);
      setBounds(4268, 80, 15, 1, cook);
      setBounds(4269, 80, 45, 2, cook);
      setBounds(358, 95, 75, 3, cook);
      setChildren(4, wood);
      setBounds(17886, 20, 30, 0, wood);
      setBounds(4268, 80, 15, 1, wood);
      setBounds(4269, 80, 45, 2, wood);
      setBounds(358, 95, 75, 3, wood);
      setChildren(4, flet);
      setBounds(17887, 20, 30, 0, flet);
      setBounds(4268, 80, 15, 1, flet);
      setBounds(4269, 80, 45, 2, flet);
      setBounds(358, 95, 75, 3, flet);
      setChildren(4, fish);
      setBounds(17888, 20, 30, 0, fish);
      setBounds(4268, 80, 15, 1, fish);
      setBounds(4269, 80, 45, 2, fish);
      setBounds(358, 95, 75, 3, fish);
      setChildren(4, fire);
      setBounds(17889, 20, 30, 0, fire);
      setBounds(4268, 80, 15, 1, fire);
      setBounds(4269, 80, 45, 2, fire);
      setBounds(358, 95, 75, 3, fire);
      setChildren(4, craf);
      setBounds(17890, 20, 30, 0, craf);
      setBounds(4268, 80, 15, 1, craf);
      setBounds(4269, 80, 45, 2, craf);
      setBounds(358, 95, 75, 3, craf);
      setChildren(4, smit);
      setBounds(17891, 20, 30, 0, smit);
      setBounds(4268, 80, 15, 1, smit);
      setBounds(4269, 80, 45, 2, smit);
      setBounds(358, 95, 75, 3, smit);
      setChildren(4, mine);
      setBounds(17892, 20, 30, 0, mine);
      setBounds(4268, 80, 15, 1, mine);
      setBounds(4269, 80, 45, 2, mine);
      setBounds(358, 95, 75, 3, mine);
      setChildren(4, herb);
      setBounds(17893, 20, 30, 0, herb);
      setBounds(4268, 80, 15, 1, herb);
      setBounds(4269, 80, 45, 2, herb);
      setBounds(358, 95, 75, 3, herb);
      setChildren(4, agil);
      setBounds(17894, 20, 30, 0, agil);
      setBounds(4268, 80, 15, 1, agil);
      setBounds(4269, 80, 45, 2, agil);
      setBounds(358, 95, 75, 3, agil);
      setChildren(4, thie);
      setBounds(17895, 20, 30, 0, thie);
      setBounds(4268, 80, 15, 1, thie);
      setBounds(4269, 80, 45, 2, thie);
      setBounds(358, 95, 75, 3, thie);
      setChildren(4, slay);
      setBounds(17896, 20, 30, 0, slay);
      setBounds(4268, 80, 15, 1, slay);
      setBounds(4269, 80, 45, 2, slay);
      setBounds(358, 95, 75, 3, slay);
      setChildren(4, farm);
      setBounds(27897, 20, 30, 0, farm);
      setBounds(4268, 80, 15, 1, farm);
      setBounds(4269, 80, 45, 2, farm);
      setBounds(358, 95, 75, 3, farm);
      setChildren(4, rune);
      setBounds(17898, 20, 30, 0, rune);
      setBounds(4268, 80, 15, 1, rune);
      setBounds(4269, 80, 45, 2, rune);
      setBounds(358, 95, 75, 3, rune);
      setChildren(4, cons);
      setBounds(17899, 20, 30, 0, cons);
      setBounds(4268, 80, 15, 1, cons);
      setBounds(4269, 80, 45, 2, cons);
      setBounds(358, 95, 75, 3, cons);
      setChildren(4, hunt);
      setBounds(17900, 20, 30, 0, hunt);
      setBounds(4268, 80, 15, 1, hunt);
      setBounds(4269, 80, 45, 2, hunt);
      setBounds(358, 95, 75, 3, hunt);
   }

	public static void bank(RSFont[] tda) {
		Widget rs = addInterface(5292);
		rs.message = "";
		setChildren(28, rs);
		addSprite(58001, 0, "BankTab/BANK");
		addHoverButton(5384, "BankTab/BANK", 1, 24, 24, "Close Window", 250, 5380, 3);
		addHoveredButton(5380, "BankTab/BANK", 2, 24, 24, 5379);
		addHoverButton(5294, "BankTab/BANK", 3, 100, 33, "Set A Bank PIN", 250, 5295, 4);
		addHoveredButton(5295, "BankTab/BANK", 4, 100, 33, 5296);
		addBankHover(58002, 4, 58003, 5, 8, "BankTab/BANK", 37, 29, 304, 1,
				"Swap Withdraw Mode", 58004, 7, 6, "BankTab/BANK", 58005,
				"Switch to insert items \nmode",
				"Switch to swap items \nmode.", 12, 20);
		addBankHover(58010, 4, 58011, 9, 11, "BankTab/BANK", 37, 29, 115, 1,
				"Swap Withdrawal Mode", 58012, 10, 12, "BankTab/BANK", 58013,
				"Switch to note withdrawal \nmode",
				"Switch to item withdrawal \nmode", 12, 20);
		
		addBankHover(58014, 4, 58015, 24, 25, "BankTab/BANK", 37, 29, 116, 1,
				"Enable/Disable Always Placeholders", 58016, 10, 12, "BankTab/BANK", 58017,
				"Enable Always Placeholders",
				"Disable Always Placeholders", 12, 20);
		addBankHover1(58018, 5, 58019, 17, "BankTab/BANK", 37, 29,
				"Deposit carried items", 58020, 18, "BankTab/BANK", 58021,
				"Empty your backpack into\nyour bank", 0, 20);
		addBankHover1(58026, 5, 58027, 19, "BankTab/BANK", 35, 25,
				"Deposit worn items", 58028, 20, "BankTab/BANK", 58029,
				"Empty the items your are\nwearing into your bank", 0, 20);
		for(int i = 0; i < 9; i++) {
			addInterface(58050 + i);
			if(i == 0)
				addConfigButton(58031, 5292, 1, 0, "BankTab/TAB", 48, 38, new String[] {"Price Check", "View"}, 1, 700);
			else
				addConfigButton(58031 + i, 5292, 4, 2, "BankTab/TAB", 48, 38, new String[] {"Price Check", "Collapse", "View"}, 1, 700 + i);
			addToItemGroup(58040 + i, 1, 1, 0, 0, false, "", "", "");
		}
		addSprite(58060, 21, "BankTab/BANK");
		addText(58061, "0", tda, 0, 0xE68A00, true, true);
		addText(58062, "350", tda, 0, 0xE68A00, true, true);
		//addInputField(58063, 50, 0xE68A00, "Search", 132, 23, false, true);
		addText(58064, "Bank of Ghreborn.", tda, 1, 0xE68A00, true, true);
		Widget Interface = interfaceCache[5385];
		Interface.height = 208;
		Interface.width = 481;
		Interface = interfaceCache[5382];
		Interface.width = 10;
		Interface.spritePaddingX = 12;
		Interface.height = 35;
		Interface.actions = new String[] {"Withdraw 1", "Withdraw 5", "Withdraw 10", "Withdraw All", "Withdraw X", "Withdraw All but one"};
		setBounds(58001, 13, 1, 0, rs);
		setBounds(5384, 475, 10, 1, rs);
		setBounds(5380, 475, 10, 2, rs);
		setBounds(5294, 193, 297, 3, rs);
		setBounds(5295, 193, 297, 4, rs);
		setBounds(58002, 25, 297, 5, rs);
		setBounds(58003, 10, 237, 6, rs);
		setBounds(58010, 67, 297, 7, rs);
		setBounds(58011, 52, 237, 8, rs);
		
		setBounds(58018, 109, 297, 9, rs);
		setBounds(58019, 94, 237, 10, rs);
		setBounds(58026, 151, 297, 11, rs);
		setBounds(58014, 314, 297, 27, rs); // Placeholder
		setBounds(58027, 136, 237, 12, rs);
		setBounds(5385, -3, 76, 13, rs);
		Widget.interfaceCache[5385].height = 216;
		int x = 68;
		for(int i = 0; i < 9; i++) {
			setBounds(58050 + i, 0, 0, 14 + i, rs);
			Widget rsi = interfaceCache[58050 + i];
			setChildren(2, rsi);
			setBounds(58031 + i, x, 36, 0, rsi);
			setBounds(58040 + i, x + 5, 39, 1, rsi);
			x += 41;
		}
		setBounds(58060, 452, 295, 23, rs);
		setBounds(58061, 473, 299, 24, rs);
		setBounds(58062, 473, 310, 25, rs);
		//setBounds(58063, 315, 298, 26, rs);
		setBounds(58064, 250, 11, 26, rs);
	}
	public static void addInputField(int identity, int characterLimit, int color, String text, int width, int height, boolean asterisks, boolean updatesEveryInput, String regex) {
		Widget field = addFullScreenInterface(identity);
		field.id = identity;
		field.type = 16;
		field.atActionType = 8;
		field.message = text;
		field.width = width;
		field.height = height;
		field.characterLimit = characterLimit;
		field.textColor = color;
		field.displayAsterisks = asterisks;
		field.tooltips = new String[] {"Clear", "Edit"};
		field.defaultInputFieldText = text;
		field.updatesEveryInput = updatesEveryInput;
		field.inputRegex = regex;
	}
	public static void addConfigButton(int ID, int pID, int bID, int bID2,
			String bName, int width, int height, String[] tooltips, int configID, int configFrame) {
		Widget Tab = addTabInterface(ID);
		Tab.parentID = pID;
		Tab.id = ID;
		Tab.type = 5;
		Tab.atActionType = 8;
		Tab.contentType = 0;
		Tab.width = width;
		Tab.height = height;
		Tab.opacity = 0;
		Tab.hoverType = -1;
		Tab.anIntArray245 = new int[1];
		Tab.anIntArray212 = new int[1];
		Tab.anIntArray245[0] = 1;
		Tab.anIntArray212[0] = configID;
		Tab.valueIndexArray = new int[1][3];
		Tab.valueIndexArray = new int[1][3];
		Tab.valueIndexArray[0][0] = 5;
		Tab.valueIndexArray[0][1] = configFrame;
		Tab.valueIndexArray[0][2] = 0;
		Tab.disabledSprite = imageLoader(bID, bName);
		Tab.enabledSprite = imageLoader(bID2, bName);
		Tab.tooltips = tooltips;
	}
	public static void addInputField(int identity, int characterLimit, int color, String text, int width, int height, boolean asterisks, boolean updatesEveryInput) {
		Widget field = addFullScreenInterface(identity);
		field.id = identity;
		field.type = 16;
		field.atActionType = 8;
		field.message = text;
		field.width = width;
		field.height = height;
		field.characterLimit = characterLimit;
		field.textColor = color;
		field.displayAsterisks = asterisks;
		field.defaultInputFieldText = text;
		field.tooltips = new String[] {"Clear", "Edit"};
		field.updatesEveryInput = updatesEveryInput;
	}
	
	public static void addInputField(int identity, int characterLimit, int color, String text, int width, int height, boolean asterisks) {
		Widget field = addFullScreenInterface(identity);
		field.id = identity;
		field.type = 16;
		field.atActionType = 8;
		field.message = text;
		field.width = width;
		field.height = height;
		field.characterLimit = characterLimit;
		field.textColor = color;
		field.displayAsterisks = asterisks;
		field.defaultInputFieldText = text;
		field.tooltips = new String[] {"Clear", "Edit"};
	}
	public static Widget addFullScreenInterface(int id) {
		Widget rsi = interfaceCache[id] = new Widget();
		rsi.id = id;
		rsi.parentID = id;
		rsi.width = 765;
		rsi.height = 503;
		return rsi;
	}
	public boolean updatesEveryInput;
	public String defaultInputFieldText = "";
	int[] inputFieldTriggers;
	public boolean displayAsterisks;
	public int characterLimit;
	public static int currentInputFieldId;
	public int itemSearchSelectedId, itemSearchSelectedSlot = -1;
	public static int selectedItemInterfaceId = -1;
	public String inputRegex = "";
	public boolean isInFocus;
	public String[] tooltips;
   public static void addBankHover(int interfaceID, int actionType, int hoverid, int spriteId, int spriteId2, String NAME, int Width, int Height, int configFrame, int configId, String Tooltip, int hoverId2, int hoverSpriteId, int hoverSpriteId2, String hoverSpriteName, int hoverId3, String hoverDisabledText, String hoverEnabledText, int X, int Y) {
      Widget hover = addTabInterface(interfaceID);
      hover.id = interfaceID;
      hover.parentID = interfaceID;
      hover.type = 5;
      hover.atActionType = actionType;
      hover.contentType = 0;
      hover.opacity = 0;
      hover.hoverType = hoverid;
      hover.disabledSprite = imageLoader(spriteId, NAME);
      hover.enabledSprite = imageLoader(spriteId2, NAME);
      hover.width = Width;
      hover.tooltip = Tooltip;
      hover.height = Height;
      hover.anIntArray245 = new int[1];
      hover.anIntArray212 = new int[1];
      hover.anIntArray245[0] = 1;
      hover.anIntArray212[0] = configId;
      hover.valueIndexArray = new int[1][3];
      hover.valueIndexArray[0][0] = 5;
      hover.valueIndexArray[0][1] = configFrame;
      hover.valueIndexArray[0][2] = 0;
      hover = addTabInterface(hoverid);
      hover.parentID = hoverid;
      hover.id = hoverid;
      hover.type = 0;
      hover.atActionType = 0;
      hover.width = 550;
      hover.height = 334;
      hover.isMouseoverTriggered = true;
      hover.hoverType = -1;
      addSprites(hoverId2, hoverSpriteId, hoverSpriteId2, hoverSpriteName, configId, configFrame);
      addHoverBox(hoverId3, interfaceID, hoverDisabledText, hoverEnabledText, configId, configFrame);
      setChildren(2, hover);
      setBounds(hoverId2, 15, 60, 0, hover);
      setBounds(hoverId3, X, Y, 1, hover);
   }

   public static void addBankHover1(int interfaceID, int actionType, int hoverid, int spriteId, String NAME, int Width, int Height, String Tooltip, int hoverId2, int hoverSpriteId, String hoverSpriteName, int hoverId3, String hoverDisabledText, int X, int Y) {
      Widget hover = addTabInterface(interfaceID);
      hover.id = interfaceID;
      hover.parentID = interfaceID;
      hover.type = 5;
      hover.atActionType = actionType;
      hover.contentType = 0;
      hover.opacity = 0;
      hover.hoverType = hoverid;
      hover.disabledSprite = imageLoader(spriteId, NAME);
      hover.width = Width;
      hover.tooltip = Tooltip;
      hover.height = Height;
      hover = addTabInterface(hoverid);
      hover.parentID = hoverid;
      hover.id = hoverid;
      hover.type = 0;
      hover.atActionType = 0;
      hover.width = 550;
      hover.height = 334;
      hover.isMouseoverTriggered = true;
      hover.hoverType = -1;
      addSprites(hoverId2, hoverSpriteId, hoverSpriteId, hoverSpriteName, 0, 0);
      addHoverBox(hoverId3, interfaceID, hoverDisabledText, hoverDisabledText, 0, 0);
      setChildren(2, hover);
      setBounds(hoverId2, 15, 60, 0, hover);
      setBounds(hoverId3, X, Y, 1, hover);
   }

   public static void addBankItem(int index, boolean hasOption) {
      Widget rsi = interfaceCache[index] = new Widget();
      rsi.actions = new String[5];
      rsi.spritesX = new int[20];
      rsi.inventoryAmounts = new int[30];
      rsi.inventoryItemId = new int[30];
      rsi.spritesY = new int[20];
      rsi.children = new int[0];
      rsi.childX = new int[0];
      rsi.childY = new int[0];
      rsi.hasExamine = false;
      rsi.spritePaddingX = 24;
      rsi.spritePaddingY = 24;
      rsi.height = 5;
      rsi.width = 6;
      rsi.parentID = 5292;
      rsi.id = index;
      rsi.type = 2;
   }



   public static void setBoundry(int frame, int ID, int X, int Y, Widget RSinterface) {
      RSinterface.children[frame] = ID;
      RSinterface.childX[frame] = X;
      RSinterface.childY[frame] = Y;
   }

   private static Sprite CustomSpriteLoader(int id, String s) {
      long l = (TextClass.method585(s) << 8) + (long)id;
      Sprite Sprite = (Sprite)spriteCache.insertFromCache(l);
      if(Sprite != null) {
         return Sprite;
      } else {
         try {
            Sprite = new Sprite("attack/" + id + s);
            spriteCache.removeFromCache(Sprite, l);
            return Sprite;
         } catch (Exception var6) {
            return null;
         }
      }
   }

   public static Widget addTabInterface(int id) {
      Widget tab = interfaceCache[id] = new Widget();
      tab.id = id;
      tab.parentID = id;
      tab.type = 0;
      tab.atActionType = 0;
      tab.contentType = 0;
      tab.width = 512;
      tab.height = 700;
      tab.opacity = 0;
      tab.hoverType = -1;
      return tab;
   }

   public static Widget addInterface(int id) {
      Widget widget = interfaceCache[id] = new Widget();
      widget.id = id;
      widget.parentID = id;
      widget.width = 512;
      widget.height = 334;
      return widget;
   }

   public static void addText(int id, String text, RSFont[] var271, int idx, int color, boolean center, boolean shadow) {
      Widget tab = addTabInterface(id);
      tab.parentID = id;
      tab.id = id;
      tab.type = 4;
      tab.atActionType = 0;
      tab.width = 0;
      tab.height = 11;
      tab.contentType = 0;
      tab.opacity = 0;
      tab.hoverType = -1;
      tab.centerText = center;
      tab.textShadow = shadow;
      tab.textDrawingAreas = var271[idx];
      tab.message = text;
      tab.secondaryText = "";
      tab.textColor = color;
      tab.secondaryColor = 0;
      tab.defaultHoverColor = 0;
   }
   public static void getext(int id, String text, RSFont[] tda, int idx, int color, boolean center, boolean shadow, int width, int height) {
	      Widget tab = addTabInterface(id);
	      tab.parentID = id;
	      tab.id = id;
	      tab.type = 4;
	      tab.atActionType = 0;
	      tab.width = width;
	      tab.height = height;
	      tab.contentType = 0;
	      tab.opacity = 0;
	      tab.hoverType = -1;
	      tab.centerText = center;
	      tab.textShadow = shadow;
	      tab.textDrawingAreas = tda[idx];
	      tab.message = text;
	      tab.secondaryText = "";
	      tab.textColor = color;
	      tab.secondaryColor = 0;
	      tab.defaultHoverColor = 0;
	   }

   public static void addHoverButton(int i, String imageName, int j, int width, int height, String text, int contentType, int hoverOver, int aT) {
      Widget tab = addTabInterface(i);
      tab.id = i;
      tab.parentID = i;
      tab.type = 5;
      tab.atActionType = aT;
      tab.contentType = contentType;
      tab.opacity = 0;
      tab.hoverType = hoverOver;
      tab.disabledSprite = imageLoader(j, imageName);
      tab.enabledSprite = imageLoader(j, imageName);
      tab.width = width;
      tab.height = height;
      tab.tooltip = text;
   }

   public static void addHoveredButton(int i, String imageName, int j, int w, int h, int IMAGEID) {
      Widget tab = addTabInterface(i);
      tab.parentID = i;
      tab.id = i;
      tab.type = 0;
      tab.atActionType = 0;
      tab.width = w;
      tab.height = h;
      tab.isMouseoverTriggered = true;
      tab.opacity = 0;
      tab.hoverType = -1;
      tab.scrollMax = 0;
      addHoverImage(IMAGEID, j, j, imageName);
      tab.totalChildren(1);
      tab.child(0, IMAGEID, 0, 0);
   }

   protected static Sprite imageLoader(int i, String s) {
      long l = (TextClass.method585(s) << 8) + (long)i;
      Sprite sprite = (Sprite)spriteCache.insertFromCache(l);
      if(sprite != null) {
         return sprite;
      } else {
         try {
            sprite = new Sprite(s + " " + i);
            spriteCache.removeFromCache(sprite, l);
            return sprite;
         } catch (Exception var6) {
            return null;
         }
      }
   }

   private static Sprite BloodIsleSpriteLoader(int i, String s) {
      long l = (TextClass.method585(s) << 8) + (long)i;
      Sprite sprite = (Sprite)spriteCache.insertFromCache(l);
      if(sprite != null) {
         return sprite;
      } else {
         try {
            sprite = new Sprite("signframe/Custom/" + s + " " + i + ".png");
            spriteCache.removeFromCache(sprite, l);
            return sprite;
         } catch (Exception var6) {
            return null;
         }
      }
   }

   public static void drawYellowBox(int id, int width, int height) {
      Widget rsinterface = interfaceCache[id + 1] = new Widget();
      rsinterface.parentID = id + 1;
      rsinterface.id = id + 1;
      rsinterface.type = 3;
      rsinterface.atActionType = 0;
      rsinterface.contentType = 0;
      rsinterface.width = width;
      rsinterface.height = height;
      rsinterface.opacity = 0;
      rsinterface.hoverType = -1;
      rsinterface.filled = true;
      rsinterface.textColor = 0;
      rsinterface.secondaryColor = 0;
      rsinterface.defaultHoverColor = 0;
      rsinterface.secondaryHoverColor = 0;
      rsinterface = addTab(id + 2);
      rsinterface.parentID = id + 2;
      rsinterface.id = id + 2;
      rsinterface.type = 3;
      rsinterface.atActionType = 0;
      rsinterface.contentType = 0;
      rsinterface.width = width - 2;
      rsinterface.height = height - 2;
      rsinterface.opacity = 0;
      rsinterface.hoverType = -1;
      rsinterface.filled = true;
      rsinterface.textColor = 16777120;
      rsinterface.secondaryColor = 0;
      rsinterface.defaultHoverColor = 0;
      rsinterface.secondaryHoverColor = 0;
      rsinterface = addTab(id);
      rsinterface.children = new int[2];
      rsinterface.childX = new int[2];
      rsinterface.childY = new int[2];
      rsinterface.children[0] = id + 1;
      rsinterface.childX[0] = 0;
      rsinterface.childY[0] = 0;
      rsinterface.children[1] = id + 2;
      rsinterface.childX[1] = 1;
      rsinterface.childY[1] = 1;
   }

   public static void addExp(int i, String s, RSFont[] atextdrawingarea, int j, int k) {
      Widget rsinterface = addTab(i);
      rsinterface.parentID = i;
      rsinterface.id = i;
      rsinterface.type = 4;
      rsinterface.atActionType = 0;
      rsinterface.width = 174;
      rsinterface.height = 11;
      rsinterface.contentType = 0;
      rsinterface.opacity = 0;
      rsinterface.hoverType = -1;
      rsinterface.centerText = true;
      rsinterface.textShadow = false;
      rsinterface.textDrawingAreas = atextdrawingarea[j];
      rsinterface.message = s;
      rsinterface.secondaryText = "";
      rsinterface.textColor = k;
      rsinterface.secondaryColor = 0;
      rsinterface.defaultHoverColor = 0;
      rsinterface.secondaryHoverColor = 0;
   }

   public static void addSpellClick2(int i, int j, int k) {
      Widget rsinterface = interfaceCache[i] = new Widget();
      rsinterface.id = i;
      rsinterface.parentID = i;
      rsinterface.type = 5;
      rsinterface.atActionType = 1;
      rsinterface.contentType = 0;
      rsinterface.width = 2;
      rsinterface.height = 2;
      rsinterface.opacity = 0;
      rsinterface.hoverType = 52;
      rsinterface.disabledSprite = BloodIsleSpriteLoader(j, "custom");
      rsinterface.enabledSprite = BloodIsleSpriteLoader(k, "custom");
   }

   public static void addSkill(int id, String skillName, int nameWidth, int skillWidth, RSFont[] atextdrawingarea) {
      String s = "";
      boolean i = false;
      Widget rsinterface = addTab(id);
      rsinterface.parentID = 5608;
      rsinterface.id = id;
      rsinterface.type = 0;
      addExp(id + 3, skillName, atextdrawingarea, 1, 0);
      addExp(id + 4, "85/85", atextdrawingarea, 1, 0);
      addExp(id + 5, "3,261,822", atextdrawingarea, 1, 0);
      addExp(id + 6, "3,597,792", atextdrawingarea, 1, 0);
      addExp(id + 7, "335,970", atextdrawingarea, 1, 0);
      rsinterface.atActionType = 0;
      rsinterface.width = 300;
      rsinterface.height = 300;
      rsinterface.isMouseoverTriggered = true;
      rsinterface.contentType = 0;
      rsinterface.opacity = 0;
      rsinterface.hoverType = -1;
      rsinterface.scrollMax = 0;
      rsinterface.children = new int[9];
      rsinterface.childX = new int[9];
      rsinterface.childY = new int[9];
      rsinterface.children[0] = 16235;
      rsinterface.childX[0] = 0;
      rsinterface.childY[0] = 0;
      rsinterface.children[1] = id + 3;
      rsinterface.childX[1] = nameWidth;
      rsinterface.childY[1] = 2;
      rsinterface.children[2] = id + 4;
      rsinterface.childX[2] = skillWidth;
      rsinterface.childY[2] = 4;
      rsinterface.children[3] = id + 5;
      rsinterface.childX[3] = 15;
      rsinterface.childY[3] = 20;
      rsinterface.children[4] = id + 6;
      rsinterface.childX[4] = 15;
      rsinterface.childY[4] = 37;
      rsinterface.children[5] = id + 7;
      rsinterface.childX[5] = 15;
      rsinterface.childY[5] = 54;
      rsinterface.children[6] = 16238;
      rsinterface.childX[6] = -54;
      rsinterface.childY[6] = 20;
      rsinterface.children[7] = 16239;
      rsinterface.childX[7] = -54;
      rsinterface.childY[7] = 37;
      rsinterface.children[8] = 16240;
      rsinterface.childX[8] = -54;
      rsinterface.childY[8] = 54;
      rsinterface = addTab(id + 2);
      rsinterface.id = id + 2;
      rsinterface.parentID = 5608;
      rsinterface.type = 5;
      rsinterface.atActionType = 1;
      rsinterface.width = 51;
      rsinterface.height = 29;
      rsinterface.hoverType = id;
      rsinterface.tooltip = "Select";
   }

   public static void friendsTab(RSFont[] tda) {
      Widget tab = addTabInterface(5065);
      Widget list = interfaceCache[5066];
      addText(5067, "Friends List", tda, 1, 16750899, true, true);
      addText(5070, "Add Friend", tda, 0, 16750899, false, true);
      addText(5071, "Delete Friend", tda, 0, 16750899, false, true);
      addSprite(16126, 4, "/Friends/SPRITE");
      addSprite(16127, 8, "/Friends/SPRITE");
      addHoverButton(5068, "/Friends/SPRITE", 6, 72, 32, "Add Friend", 201, 5072, 1);
      addHoveredButton(5072, "/Friends/SPRITE", 7, 72, 32, 5073);
      addHoverButton(5069, "/Friends/SPRITE", 6, 72, 32, "Delete Friend", 202, 5074, 1);
      addHoveredButton(5074, "/Friends/SPRITE", 7, 72, 32, 5075);
      tab.totalChildren(11);
      tab.child(0, 5067, 95, 4);
      tab.child(1, 16127, 0, 25);
      tab.child(2, 16126, 0, 221);
      tab.child(3, 5066, 0, 24);
      tab.child(4, 16126, 0, 22);
      tab.child(5, 5068, 15, 226);
      tab.child(6, 5072, 15, 226);
      tab.child(7, 5069, 103, 226);
      tab.child(8, 5074, 103, 226);
      tab.child(9, 5070, 25, 237);
      tab.child(10, 5071, 106, 237);
      list.height = 196;
      list.width = 174;
      int id = 5092;

      int i;
      for(i = 0; id <= 5191 && i <= 99; ++i) {
         list.children[i] = id;
         list.childX[i] = 3;
         list.childY[i] -= 7;
         ++id;
      }

      id = 5192;

      for(i = 100; id <= 5291 && i <= 199; ++i) {
         list.children[i] = id;
         list.childX[i] = 131;
         list.childY[i] -= 7;
         ++id;
      }

   }

   public static void ignoreTab(RSFont[] tda) {
      Widget tab = addTabInterface(5715);
      Widget list = interfaceCache[5716];
      addText(5717, "Ignore List", tda, 1, 16750899, true, true);
      addText(5720, "Add Name", tda, 0, 16750899, false, true);
      addText(5721, "Delete Name", tda, 0, 16750899, false, true);
      addHoverButton(5718, "/Friends/SPRITE", 6, 72, 32, "Add Name", 501, 5722, 1);
      addHoveredButton(5722, "/Friends/SPRITE", 7, 72, 32, 5723);
      addHoverButton(5719, "/Friends/SPRITE", 6, 72, 32, "Delete Name", 502, 5724, 1);
      addHoveredButton(5724, "/Friends/SPRITE", 7, 72, 32, 5725);
      tab.totalChildren(11);
      tab.child(0, 5717, 95, 4);
      tab.child(1, 16127, 0, 25);
      tab.child(2, 16126, 0, 221);
      tab.child(3, 5716, 0, 24);
      tab.child(4, 16126, 0, 22);
      tab.child(5, 5718, 15, 226);
      tab.child(6, 5722, 15, 226);
      tab.child(7, 5719, 103, 226);
      tab.child(8, 5724, 103, 226);
      tab.child(9, 5720, 27, 237);
      tab.child(10, 5721, 108, 237);
      list.height = 196;
      list.width = 174;
      int id = 5742;

      for(int i = 0; id <= 5841 && i <= 99; ++i) {
         list.children[i] = id;
         list.childX[i] = 3;
         list.childY[i] -= 7;
         ++id;
      }

   }

   public static void addConfigHover(int interfaceID, int actionType, int hoverid, int spriteId, int spriteId2, String NAME, int Width, int Height, int configFrame, int configId, String Tooltip, int hoverId2, int hoverSpriteId, int hoverSpriteId2, String hoverSpriteName, int hoverId3, String hoverDisabledText, String hoverEnabledText, int X, int Y) {
      Widget hover = addTabInterface(interfaceID);
      hover.id = interfaceID;
      hover.parentID = interfaceID;
      hover.type = 5;
      hover.atActionType = actionType;
      hover.contentType = 0;
      hover.opacity = 0;
      hover.hoverType = hoverid;
      hover.disabledSprite = imageLoader(spriteId, NAME);
      hover.enabledSprite = imageLoader(spriteId2, NAME);
      hover.width = Width;
      hover.tooltip = Tooltip;
      hover.height = Height;
      hover.anIntArray245 = new int[1];
      hover.anIntArray212 = new int[1];
      hover.anIntArray245[0] = 1;
      hover.anIntArray212[0] = configId;
      hover.valueIndexArray = new int[1][3];
      hover.valueIndexArray[0][0] = 5;
      hover.valueIndexArray[0][1] = configFrame;
      hover.valueIndexArray[0][2] = 0;
      hover = addTabInterface(hoverid);
      hover.parentID = hoverid;
      hover.id = hoverid;
      hover.type = 0;
      hover.atActionType = 0;
      hover.width = 550;
      hover.height = 334;
      hover.isMouseoverTriggered = true;
      hover.hoverType = -1;
      addSprites(hoverId2, hoverSpriteId, hoverSpriteId2, hoverSpriteName, configId, configFrame);
      addHoverBox(hoverId3, interfaceID, hoverDisabledText, hoverEnabledText, configId, configFrame);
      setChildren(2, hover);
      setBounds(hoverId2, 15, 60, 0, hover);
      setBounds(hoverId3, X, Y, 1, hover);
   }

   public static void addHoverBox(int id, int ParentID, String text, String text2, int configId, int configFrame) {
      Widget rsi = addTabInterface(id);
      rsi.id = id;
      rsi.parentID = ParentID;
      rsi.type = 8;
      rsi.secondaryText = text;
      rsi.message = text2;
      rsi.anIntArray245 = new int[1];
      rsi.anIntArray212 = new int[1];
      rsi.anIntArray245[0] = 1;
      rsi.anIntArray212[0] = configId;
      rsi.valueIndexArray = new int[1][3];
      rsi.valueIndexArray[0][0] = 5;
      rsi.valueIndexArray[0][1] = configFrame;
      rsi.valueIndexArray[0][2] = 0;
   }

   public static void addSprites(int ID, int i, int i2, String name, int configId, int configFrame) {
      Widget Tab = addTabInterface(ID);
      Tab.id = ID;
      Tab.parentID = ID;
      Tab.type = 5;
      Tab.atActionType = 0;
      Tab.contentType = 0;
      Tab.width = 512;
      Tab.height = 334;
      Tab.opacity = 0;
      Tab.hoverType = -1;
      Tab.anIntArray245 = new int[1];
      Tab.anIntArray212 = new int[1];
      Tab.anIntArray245[0] = 1;
      Tab.anIntArray212[0] = configId;
      Tab.valueIndexArray = new int[1][3];
      Tab.valueIndexArray[0][0] = 5;
      Tab.valueIndexArray[0][1] = configFrame;
      Tab.valueIndexArray[0][2] = 0;
      Tab.disabledSprite = imageLoader(i, name);
      Tab.enabledSprite = imageLoader(i2, name);
   }

   public static void advancedOptions(RSFont[] var271) {
      Widget widget = addInterface('\u8ca0');
      addSprite('\u8ca1', 0, "Interfaces/WrenchTab/Advanced/WIDGET");
      addHoverButton('\u8ca2', "Interfaces/WrenchTab/Advanced/WIDGET", 1, 21, 21, "Close", -1, '\u8ca3', 1);
      addHoveredButton('\u8ca3', "Interfaces/WrenchTab/Advanced/WIDGET", 2, 21, 21, '\u8ca4');
      addText('\u8ca5', "Advanced Options", var271, 2, 16750623, false, true);
      addConfigHover('\u8ca6', 4, '\u8ca7', 1, 2, "Interfaces/WrenchTab/Advanced/side-panel", 40, 40, 604, 1, "Transparant side-panel", '\u8ca8', 1, 2, "Interfaces/WrenchTab/Advanced/side-panel", '\u8ca9', "", "", 12, 20);
      addConfigHover('\u8caa', 4, '\u8cab', 1, 2, "Interfaces/WrenchTab/Advanced/xp", 40, 40, 605, 1, "\'Remaining XP\' tooltips", '\u8cac', 1, 2, "Interfaces/WrenchTab/Advanced/xp", '\u8cad', "", "", 12, 20);
      addConfigHover('\u8cae', 4, '\u8caf', 1, 2, "Interfaces/WrenchTab/Advanced/roof", 40, 40, 606, 0, "Roof-removal", '\u8cb0', 1, 2, "Interfaces/WrenchTab/Advanced/roof", '\u8cb1', "", "", 12, 20);
      addConfigHover('\u8cb2', 4, '\u8cb3', 1, 2, "Interfaces/WrenchTab/Advanced/orbs", 40, 40, 607, 0, "Data orbs", '\u8cb4', 1, 2, "Interfaces/WrenchTab/Advanced/orbs", '\u8cb5', "", "", 12, 20);
      addConfigHover('\u8cb6', 4, '\u8cb7', 1, 2, "Interfaces/WrenchTab/Advanced/chatbox", 40, 40, 608, 1, "Transparent Chatbox", '\u8cb8', 1, 2, "Interfaces/WrenchTab/Advanced/chatbox", '\u8cb9', "", "", 12, 20);
      addConfigHover('\u8cba', 4, '\u8cbb', 1, 2, "Interfaces/WrenchTab/Advanced/side-stones", 40, 40, 609, 1, "Side-stones arrangement", '\u8cbc', 1, 2, "Interfaces/WrenchTab/Advanced/side-stones", '\u8cbd', "", "", 12, 20);
      addText('\u8cbe', "Transparent chatbox...", var271, 1, 9145227, false, true);
      addText('\u8cbf', "Side-panels...", var271, 1, 9145227, false, true);
      addConfigHover('\u8cc0', 4, '\u8cc1', 2, 1, "Interfaces/WrenchTab/check", 15, 15, 610, 1, "Auto", '\u8cc2', 2, 1, "Interfaces/WrenchTab/Advanced/check", '\u8cc3', "", "", 12, 20);
      addConfigHover('\u8cc4', 4, '\u8cc5', 2, 1, "Interfaces/WrenchTab/check", 15, 15, 611, 1, "Auto", '\u8cc6', 2, 1, "Interfaces/WrenchTab/Advanced/check", '\u8cc7', "", "", 12, 20);
      addText('\u8cc8', "Can be clicked trough.", var271, 0, 9145227, false, true);
      addText('\u8cc9', "Can be closed by the hotkeys.", var271, 0, 9145227, false, true);
      setChildren(24, widget);
      setBounds('\u8ca1', 160, 50, 0, widget);
      setBounds('\u8ca2', 376, 56, 1, widget);
      setBounds('\u8ca3', 376, 56, 2, widget);
      setBounds('\u8ca5', 217, 58, 3, widget);
      setBounds('\u8ca6', 167, 88, 4, widget);
      setBounds('\u8ca8', 167, 88, 5, widget);
      setBounds('\u8caa', 229, 88, 6, widget);
      setBounds('\u8cac', 229, 88, 7, widget);
      setBounds('\u8cae', 295, 90, 8, widget);
      setBounds('\u8cb0', 295, 90, 9, widget);
      setBounds('\u8cb2', 355, 90, 10, widget);
      setBounds('\u8cb4', 355, 90, 11, widget);
      setBounds('\u8cb6', 167, 140, 12, widget);
      setBounds('\u8cb8', 167, 140, 13, widget);
      setBounds('\u8cba', 167, 195, 14, widget);
      setBounds('\u8cbc', 167, 195, 15, widget);
      setBounds('\u8cbe', 215, 145, 16, widget);
      setBounds('\u8cbf', 215, 200, 17, widget);
      setBounds('\u8cc0', 215, 165, 18, widget);
      setBounds('\u8cc2', 215, 165, 19, widget);
      setBounds('\u8cc4', 215, 220, 20, widget);
      setBounds('\u8cc6', 215, 220, 21, widget);
      setBounds('\u8cc8', 235, 165, 22, widget);
      setBounds('\u8cc9', 235, 220, 23, widget);
   }

   public static void wrenchTab(RSFont[] tda) {
      Widget rsi = addInterface(904);
      addSprite(31001, 0, "Interfaces/WrenchTab/main tab/sprite");
      addHoverButton(31002, "Interfaces/WrenchTab/main tab/display", 2, 40, 40, "Display Test", -1, 31003, 1);
      addHoveredButton(31003, "Interfaces/WrenchTab/main tab/display", 4, 40, 40, 31004);
      addHoverButton(31005, "Interfaces/WrenchTab/main tab/audio", 1, 40, 40, "Audio Test", -1, 31006, 1);
      addHoveredButton(31006, "Interfaces/WrenchTab/main tab/audio", 3, 40, 40, 31007);
      addHoverButton(31008, "Interfaces/WrenchTab/main tab/chat", 1, 40, 40, "Chat Test", -1, 31009, 1);
      addHoveredButton(31009, "Interfaces/WrenchTab/main tab/chat", 3, 40, 40, 31010);
      addHoverButton(31011, "Interfaces/WrenchTab/main tab/controls", 1, 40, 40, "Controls Test", -1, 31012, 1);
      addHoveredButton(31012, "Interfaces/WrenchTab/main tab/controls", 3, 40, 40, 31013);
      addConfigHover(31014, 4, 31015, 1, 2, "Interfaces/WrenchTab/main tab/aid", 40, 40, 304, 1, "Toggle Accept Aid", 31016, 1, 2, "Interfaces/WrenchTab/main tab/aid", 31017, "", "", 12, 20);
      addConfigHover(31018, 4, 31019, 1, 2, "Interfaces/WrenchTab/main tab/run", 40, 40, 504, 0, "Toggle Run", 31020, 1, 2, "Interfaces/WrenchTab/main tab/run", 31021, "", "", 12, 20);
      addButton(31022, 1, "Interfaces/WrenchTab/main tab/house", 40, 40, "Open House Options", 1);
      addButton(31023, 1, "Interfaces/WrenchTab/main tab/bond", 40, 40, "View Membership Bonds", 1);
      addConfigHover(31024, 4, 31025, 1, 2, "Interfaces/WrenchTab/fixed", 53, 45, 406, 0, "Fixed mode", 31026, 1, 2, "Interfaces/WrenchTab/fixed", 31027, "", "", 12, 20);
      addConfigHover(31028, 4, 31029, 1, 2, "Interfaces/WrenchTab/resize", 53, 45, 407, 1, "Resizable mode", 31030, 1, 2, "Interfaces/WrenchTab/resize", 31031, "", "", 12, 20);
      addButton(31032, 1, "Interfaces/WrenchTab/advanced", 148, 36, "View Advanced Options", 1);
      addText(31034, "", 16750623, false, true, 52, tda, 1);
      addText(149, "", 16750623, false, true, 52, tda, 1);
      addSprite(31035, 0, "Interfaces/WrenchTab/sun");
      addSprite(31036, 0, "Interfaces/WrenchTab/bar");
      addConfigHover(31037, 4, 31038, 2, 1, "Interfaces/WrenchTab/bar", 16, 16, 505, 1, "Adjust Screen Brightness", 31039, 2, 1, "Interfaces/WrenchTab/bar", 31108, "", "", 12, 20);
      addConfigHover(31109, 4, 31110, 2, 1, "Interfaces/WrenchTab/bar", 16, 16, 506, 1, "Adjust Screen Brightness", 31111, 2, 1, "Interfaces/WrenchTab/bar", 31112, "", "", 12, 20);
      addConfigHover(31113, 4, 31114, 2, 1, "Interfaces/WrenchTab/bar", 16, 16, 507, 1, "Adjust Screen Brightness", 31115, 2, 1, "Interfaces/WrenchTab/bar", 31116, "", "", 12, 20);
      addConfigHover(31117, 4, 31118, 2, 1, "Interfaces/WrenchTab/bar", 16, 16, 508, 1, "Adjust Screen Brightness", 31119, 2, 1, "Interfaces/WrenchTab/bar", 31120, "", "", 12, 20);
      setChildren(31, rsi);
      setBounds(31001, 3, 45, 0, rsi);
      setBounds(31002, 6, 3, 1, rsi);
      setBounds(31003, 6, 3, 2, rsi);
      setBounds(31005, 52, 3, 3, rsi);
      setBounds(31006, 52, 3, 4, rsi);
      setBounds(31008, 98, 3, 5, rsi);
      setBounds(31009, 98, 3, 6, rsi);
      setBounds(31011, 144, 3, 7, rsi);
      setBounds(31012, 144, 3, 8, rsi);
      setBounds(31014, 6, 221, 9, rsi);
      setBounds(31016, 6, 221, 10, rsi);
      setBounds(31018, 52, 221, 11, rsi);
      setBounds(31020, 52, 221, 12, rsi);
      setBounds(31022, 98, 221, 13, rsi);
      setBounds(31023, 144, 221, 14, rsi);
      setBounds(149, 57, 241, 15, rsi);
      setBounds(31035, 11, 89, 16, rsi);
      setBounds(31036, 45, 97, 17, rsi);
      setBounds(31037, 52, 98, 18, rsi);
      setBounds(31039, 52, 98, 19, rsi);
      setBounds(31109, 82, 98, 20, rsi);
      setBounds(31111, 82, 98, 21, rsi);
      setBounds(31113, 118, 98, 22, rsi);
      setBounds(31115, 118, 98, 23, rsi);
      setBounds(31117, 150, 98, 24, rsi);
      setBounds(31119, 150, 98, 25, rsi);
      setBounds(31024, 18, 120, 26, rsi);
      setBounds(31026, 18, 120, 27, rsi);
      setBounds(31028, 98, 120, 28, rsi);
      setBounds(31030, 98, 120, 29, rsi);
      setBounds(31032, 20, 177, 30, rsi);
      rsi = addInterface(31040);
      addHoverButton(31041, "Interfaces/WrenchTab/main tab/display", 1, 40, 40, "Display Test", -1, 31042, 1);
      addHoveredButton(31042, "Interfaces/WrenchTab/main tab/display", 3, 40, 40, 31043);
      addHoverButton(31044, "Interfaces/WrenchTab/main tab/audio", 2, 40, 40, "Audio Test", -1, 31045, 1);
      addHoveredButton(31045, "Interfaces/WrenchTab/main tab/audio", 4, 40, 40, 31046);
      addSprite(31121, 0, "Interfaces/WrenchTab/sprite");
      addSprite(31122, 1, "Interfaces/WrenchTab/sprite");
      addSprite(31123, 2, "Interfaces/WrenchTab/sprite");
      addSprite(31124, 0, "Interfaces/WrenchTab/bar");
      addSprite(31125, 0, "Interfaces/WrenchTab/bar");
      addSprite(31126, 0, "Interfaces/WrenchTab/bar");
      addConfigHover(31128, 4, 31129, 2, 1, "Interfaces/WrenchTab/bar", 16, 16, 509, 1, "Adjust Music Volume", 31130, 2, 1, "Interfaces/WrenchTab/bar", 31131, "", "", 12, 20);
      addConfigHover(31132, 4, 31133, 2, 1, "Interfaces/WrenchTab/bar", 16, 16, 510, 1, "Adjust Music Volume", 31134, 2, 1, "Interfaces/WrenchTab/bar", 31135, "", "", 12, 20);
      addConfigHover(31136, 4, 31137, 1, 2, "Interfaces/WrenchTab/bar", 16, 16, 511, 1, "Adjust Music Volume", 31138, 1, 2, "Interfaces/WrenchTab/bar", 31139, "", "", 12, 20);
      addConfigHover(31140, 4, 31141, 2, 1, "Interfaces/WrenchTab/bar", 16, 16, 512, 1, "Adjust Music Volume", 31142, 2, 1, "Interfaces/WrenchTab/bar", 31143, "", "", 12, 20);
      addConfigHover(31144, 4, 31145, 1, 2, "Interfaces/WrenchTab/bar", 16, 16, 513, 1, "Adjust Sound Effect Volume", 31146, 1, 2, "Interfaces/WrenchTab/bar", 31147, "", "", 12, 20);
      addConfigHover(31148, 4, 31149, 2, 1, "Interfaces/WrenchTab/bar", 16, 16, 514, 1, "Adjust Sound Effect Volume", 31150, 2, 1, "Interfaces/WrenchTab/bar", 31151, "", "", 12, 20);
      addConfigHover(31152, 4, 31153, 2, 1, "Interfaces/WrenchTab/bar", 16, 16, 515, 1, "Adjust Sound Effect Volume", 31154, 2, 1, "Interfaces/WrenchTab/bar", 31155, "", "", 12, 20);
      addConfigHover(31156, 4, 31157, 2, 1, "Interfaces/WrenchTab/bar", 16, 16, 516, 1, "Adjust Sound Effect Volume", 31158, 2, 1, "Interfaces/WrenchTab/bar", 31159, "", "", 12, 20);
      addConfigHover(31160, 4, 31161, 1, 2, "Interfaces/WrenchTab/bar", 16, 16, 517, 1, "Adjust Area Sound Effect Volume", 31162, 1, 2, "Interfaces/WrenchTab/bar", 31163, "", "", 12, 20);
      addConfigHover(31164, 4, 31165, 2, 1, "Interfaces/WrenchTab/bar", 16, 16, 518, 1, "Adjust Area Sound Effect Volume", 31166, 2, 1, "Interfaces/WrenchTab/bar", 31167, "", "", 12, 20);
      addConfigHover(31168, 4, 31169, 2, 1, "Interfaces/WrenchTab/bar", 16, 16, 519, 1, "Adjust Area Sound Effect Volume", 31170, 2, 1, "Interfaces/WrenchTab/bar", 31171, "", "", 12, 20);
      addConfigHover(31172, 4, 31173, 2, 1, "Interfaces/WrenchTab/bar", 16, 16, 520, 1, "Adjust Area Sound Effect Volume", 31174, 2, 1, "Interfaces/WrenchTab/bar", 31175, "", "", 12, 20);
      setChildren(46, rsi);
      setBounds(31001, 3, 45, 0, rsi);
      setBounds(31041, 6, 3, 1, rsi);
      setBounds(31042, 6, 3, 2, rsi);
      setBounds(31044, 52, 3, 3, rsi);
      setBounds(31045, 52, 3, 4, rsi);
      setBounds(31008, 98, 3, 5, rsi);
      setBounds(31009, 98, 3, 6, rsi);
      setBounds(31011, 144, 3, 7, rsi);
      setBounds(31012, 144, 3, 8, rsi);
      setBounds(31014, 6, 221, 9, rsi);
      setBounds(31016, 6, 221, 10, rsi);
      setBounds(31018, 52, 221, 11, rsi);
      setBounds(31020, 52, 221, 12, rsi);
      setBounds(31022, 98, 221, 13, rsi);
      setBounds(31023, 144, 221, 14, rsi);
      setBounds(149, 57, 241, 15, rsi);
      setBounds(31121, 12, 68, 16, rsi);
      setBounds(31122, 12, 117, 17, rsi);
      setBounds(31123, 12, 166, 18, rsi);
      setBounds(31124, 51, 76, 19, rsi);
      setBounds(31125, 51, 124, 20, rsi);
      setBounds(31126, 51, 173, 21, rsi);
      setBounds(31128, 59, 77, 22, rsi);
      setBounds(31130, 59, 77, 23, rsi);
      setBounds(31132, 90, 77, 24, rsi);
      setBounds(31134, 90, 77, 25, rsi);
      setBounds(31136, 121, 77, 26, rsi);
      setBounds(31138, 121, 77, 27, rsi);
      setBounds(31140, 152, 77, 28, rsi);
      setBounds(31142, 152, 77, 29, rsi);
      setBounds(31144, 59, 125, 30, rsi);
      setBounds(31146, 59, 125, 31, rsi);
      setBounds(31148, 90, 125, 32, rsi);
      setBounds(31150, 90, 125, 33, rsi);
      setBounds(31152, 121, 125, 34, rsi);
      setBounds(31154, 121, 125, 35, rsi);
      setBounds(31156, 152, 125, 36, rsi);
      setBounds(31158, 152, 125, 37, rsi);
      setBounds(31160, 59, 173, 38, rsi);
      setBounds(31162, 59, 173, 39, rsi);
      setBounds(31164, 90, 173, 40, rsi);
      setBounds(31166, 90, 173, 41, rsi);
      setBounds(31168, 121, 173, 42, rsi);
      setBounds(31170, 121, 173, 43, rsi);
      setBounds(31172, 152, 173, 44, rsi);
      setBounds(31174, 152, 173, 45, rsi);
      rsi = addInterface(31060);
      addHoverButton(31061, "Interfaces/WrenchTab/main tab/chat", 2, 40, 40, "Chat Test", -1, 31062, 1);
      addHoveredButton(31062, "Interfaces/WrenchTab/main tab/chat", 4, 40, 40, 31063);
      addConfigHover(31064, 4, 31065, 2, 1, "Interfaces/WrenchTab/main tab/ceffects", 40, 40, 171, 1, "Toggle Chat Effects", 31066, 2, 1, "Interfaces/WrenchTab/main tab/ceffects", 31067, "", "", 12, 20);
      addConfigHover(31068, 4, 31069, 1, 2, "Interfaces/WrenchTab/main tab/pchat", 40, 40, 287, 1, "Toggle Split Chat", 31070, 1, 2, "Interfaces/WrenchTab/main tab/pchat", 31071, "", "", 12, 20);
      addConfigHover(31072, 4, 31073, 1, 2, "Interfaces/WrenchTab/main tab/profanity", 40, 40, 311, 1, "Toggle Profanity Filter", 31074, 1, 2, "Interfaces/WrenchTab/main tab/profanity", 31075, "", "", 12, 20);
      addConfigHover(31076, 4, 31077, 1, 2, "Interfaces/WrenchTab/main tab/lnotification", 40, 40, 312, 1, "Toggle Login/Logout notification timeout", 31078, 1, 2, "Interfaces/WrenchTab/main tab/lnotification", 31079, "", "", 12, 20);
      setChildren(24, rsi);
      setBounds(31001, 3, 45, 0, rsi);
      setBounds(31041, 6, 3, 1, rsi);
      setBounds(31042, 6, 3, 2, rsi);
      setBounds(31005, 52, 3, 3, rsi);
      setBounds(31006, 52, 3, 4, rsi);
      setBounds(31061, 98, 3, 5, rsi);
      setBounds(31062, 98, 3, 6, rsi);
      setBounds(31011, 144, 3, 7, rsi);
      setBounds(31012, 144, 3, 8, rsi);
      setBounds(31014, 6, 221, 9, rsi);
      setBounds(31016, 6, 221, 10, rsi);
      setBounds(31018, 52, 221, 11, rsi);
      setBounds(31020, 52, 221, 12, rsi);
      setBounds(31022, 98, 221, 13, rsi);
      setBounds(31023, 144, 221, 14, rsi);
      setBounds(149, 57, 241, 15, rsi);
      setBounds(31064, 39, 81, 16, rsi);
      setBounds(31066, 39, 81, 17, rsi);
      setBounds(31068, 111, 81, 18, rsi);
      setBounds(31070, 111, 81, 19, rsi);
      setBounds(31072, 39, 144, 20, rsi);
      setBounds(31074, 39, 144, 21, rsi);
      setBounds(31076, 111, 144, 22, rsi);
      setBounds(31078, 111, 144, 23, rsi);
      rsi = addInterface(31080);
      addHoverButton(31081, "Interfaces/WrenchTab/main tab/controls", 2, 40, 40, "Controls Test", -1, 31082, 1);
      addHoveredButton(31082, "Interfaces/WrenchTab/main tab/controls", 4, 40, 40, 31083);
      addConfigHover(31084, 4, 31085, 1, 2, "Interfaces/WrenchTab/main tab/mouse", 40, 40, 313, 1, "Toggle number of mouse buttons", 31086, 1, 2, "Interfaces/WrenchTab/main tab/mouse", 31087, "Toggle xp 2", "Toggle xp 3", 12, 20);
      addConfigHover(31088, 4, 31089, 1, 2, "Interfaces/WrenchTab/main tab/camera", 40, 40, 314, 1, "Toggle Mouse Camera", 31090, 1, 2, "Interfaces/WrenchTab/main tab/camera", 31091, "Toggle xp 2", "Toggle xp 3", 12, 20);
      addText(31092, "Attack option walkingPrecedence:", 16750623, false, true, 52, tda, 1);
      addConfigHover(31093, 4, 31094, 2, 1, "Interfaces/WrenchTab/main tab/check", 15, 15, 315, 1, "Auto", 31095, 2, 1, "Interfaces/WrenchTab/main tab/check", 31096, "", "", 12, 20);
      addConfigHover(31097, 4, 31098, 1, 2, "Interfaces/WrenchTab/main tab/check", 15, 15, 316, 1, "Left-click ", 31099, 1, 2, "Interfaces/WrenchTab/main tab/check", 31100, "", "", 12, 20);
      addConfigHover(31101, 4, 31102, 1, 2, "Interfaces/WrenchTab/main tab/check", 15, 15, 317, 1, "Right-click ", 31103, 1, 2, "Interfaces/WrenchTab/main tab/check", 31104, "", "", 12, 20);
      addHoverText(31105, "Depends on combat levels.", "Depends on combat levels.", tda, 0, 16750623, false, true, 150);
      addHoverText(31106, "Left-click where available.", "Left-click where available.", tda, 0, 16750623, false, true, 150);
      addHoverText(31107, "Always right-click.", "Always right-click.", tda, 0, 16750623, false, true, 150);
      setChildren(30, rsi);
      setBounds(31001, 3, 45, 0, rsi);
      setBounds(31041, 6, 3, 1, rsi);
      setBounds(31042, 6, 3, 2, rsi);
      setBounds(31005, 52, 3, 3, rsi);
      setBounds(31006, 52, 3, 4, rsi);
      setBounds(31008, 98, 3, 5, rsi);
      setBounds(31009, 98, 3, 6, rsi);
      setBounds(31081, 144, 3, 7, rsi);
      setBounds(31082, 144, 3, 8, rsi);
      setBounds(31014, 6, 221, 9, rsi);
      setBounds(31016, 6, 221, 10, rsi);
      setBounds(31018, 52, 221, 11, rsi);
      setBounds(31020, 52, 221, 12, rsi);
      setBounds(31022, 98, 221, 13, rsi);
      setBounds(31023, 144, 221, 14, rsi);
      setBounds(149, 57, 241, 15, rsi);
      setBounds(31084, 40, 71, 16, rsi);
      setBounds(31086, 40, 71, 17, rsi);
      setBounds(31088, 110, 71, 18, rsi);
      setBounds(31090, 110, 71, 19, rsi);
      setBounds(31092, 9, 126, 20, rsi);
      setBounds(31093, 10, 145, 21, rsi);
      setBounds(31095, 10, 145, 22, rsi);
      setBounds(31097, 10, 162, 23, rsi);
      setBounds(31099, 10, 162, 24, rsi);
      setBounds(31101, 10, 179, 25, rsi);
      setBounds(31103, 10, 179, 26, rsi);
      setBounds(31105, 26, 145, 27, rsi);
      setBounds(31106, 26, 162, 28, rsi);
      setBounds(31107, 26, 179, 29, rsi);
   }
	public static void addHoveredButton_sprite_loader5(int i, String spriteId, int w, int h, int IMAGEID) {// hoverable
		// button
		Widget tab = addTabInterface(i);
		tab.parentID = i;
		tab.id = i;
		tab.type = 0;
		tab.atActionType = 3;
		tab.width = w;
		tab.height = h;
		tab.hasActions = true;
		tab.opacity = 0;
		tab.hoverType = -1;
		tab.scrollMax = 0;
		addHoverImage_sprite_loader(IMAGEID, spriteId);
		tab.totalChildren(1);
		tab.child(0, IMAGEID, 0, 0);
	}
	public static void addHoverImage_sprite_loader(int i, String imageName) {
		Widget tab = addTabInterface(i);
		tab.id = i;
		tab.parentID = i;
		tab.type = 5;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.width = 512;
		tab.height = 334;
		tab.opacity = 0;
		tab.hoverType = 52;
		tab.disabledSprite = imageLoader(i, imageName);
		tab.enabledSprite = imageLoader(i, imageName);
	}
   public static void addText(int i, String s, int k, boolean l, boolean m, int a, RSFont[] RSFont, int j) {
      Widget Widget = addInterface(i);
      Widget.parentID = i;
      Widget.id = i;
      Widget.type = 4;
      Widget.atActionType = 0;
      Widget.width = 0;
      Widget.height = 0;
      Widget.contentType = 0;
      Widget.opacity = 0;
      Widget.hoverType = a;
      Widget.centerText = l;
      Widget.textShadow = m;
      Widget.textDrawingAreas = RSFont[j];
      Widget.message = s;
      Widget.secondaryText = "";
      Widget.textColor = k;
   }

   public static void addText1(int id, String text, RSFont[] tda, int idx, int color, boolean center, boolean shadow) {
      Widget tab = addTabInterface(id);
      tab.parentID = id;
      tab.id = id;
      tab.type = 4;
      tab.atActionType = 0;
      tab.width = 0;
      tab.height = 11;
      tab.contentType = 0;
      tab.opacity = 0;
      tab.hoverType = -1;
      tab.centerText = center;
      tab.textShadow = shadow;
      tab.textDrawingAreas = tda[idx];
      tab.message = text;
      tab.secondaryText = "";
      tab.textColor = color;
      tab.secondaryColor = 0;
      tab.defaultHoverColor = 0;
      tab.secondaryHoverColor = 0;
   }

   public static void addText1(int id, String text, RSFont[] tda, int idx, int color, boolean centered) {
      Widget rsi = interfaceCache[id] = new Widget();
      if(centered) {
         rsi.centerText = true;
      }

      rsi.textShadow = true;
      rsi.textDrawingAreas = tda[idx];
      rsi.message = text;
      rsi.textColor = color;
      rsi.id = id;
      rsi.type = 4;
   }

   public static void addHoverText(int id, String text, String tooltip, RSFont[] tda, int idx, int color, boolean centerText, boolean textShadowed, int width) {
      Widget rsinterface = addInterface(id);
      rsinterface.id = id;
      rsinterface.parentID = id;
      rsinterface.type = 4;
      rsinterface.atActionType = 1;
      rsinterface.width = width;
      rsinterface.height = 11;
      rsinterface.contentType = 0;
      rsinterface.opacity = 0;
      rsinterface.hoverType = -1;
      rsinterface.centerText = centerText;
      rsinterface.textShadow = textShadowed;
      rsinterface.textDrawingAreas = tda[idx];
      rsinterface.message = text;
      rsinterface.secondaryText = "";
      rsinterface.textColor = color;
      rsinterface.secondaryColor = 0;
      rsinterface.defaultHoverColor = 16777215;
      rsinterface.secondaryHoverColor = 0;
      rsinterface.tooltip = tooltip;
   }

   public static void Skillsdata(StreamLoader streamloader, RSFont[] atextdrawingarea) {
      String s = "";
      boolean i = false;
      addExp(16238, "Current Xp:", atextdrawingarea, 1, 0);
      addExp(16239, "Next level:", atextdrawingarea, 1, 0);
      addExp(16240, "Remainder:", atextdrawingarea, 1, 0);
      addText(16429, "85", atextdrawingarea, 0, 16776960);
      addText(16430, "85", atextdrawingarea, 0, 16776960);
      addText(16431, "85", atextdrawingarea, 0, 16776960);
      addText(16432, "85", atextdrawingarea, 0, 16776960);
      addText(16433, "85", atextdrawingarea, 0, 16776960);
      addText(16434, "85", atextdrawingarea, 0, 16776960);
      addText(16435, "Total Level: 1284", atextdrawingarea, 2, 16776960);
      addSkill(16227, "Attack:", -65, 0, atextdrawingarea);
      addSkill(16245, "Strength:", -59, 0, atextdrawingarea);
      addSkill(16253, "Defence:", -60, 0, atextdrawingarea);
      addSkill(16261, "Ranged:", -63, 0, atextdrawingarea);
      addSkill(16269, "Prayer:", -65, 0, atextdrawingarea);
      addSkill(16277, "Magic:", -68, 0, atextdrawingarea);
      addSkill(16285, "Runecraft:", -55, 0, atextdrawingarea);
      addSkill(16293, "Hitpoints:", -58, 0, atextdrawingarea);
      addSkill(16301, "Agility:", -65, 0, atextdrawingarea);
      addSkill(16309, "Herblore:", -60, 0, atextdrawingarea);
      addSkill(16317, "Thieving:", -60, 0, atextdrawingarea);
      addSkill(16325, "Crafting:", -60, 0, atextdrawingarea);
      addSkill(16333, "Fletching:", -58, 0, atextdrawingarea);
      addSkill(16341, "Slayer:", -66, 0, atextdrawingarea);
      addSkill(16349, "Mining:", -66, 0, atextdrawingarea);
      addSkill(16357, "Smithing:", -60, 0, atextdrawingarea);
      addSkill(16365, "Fishing:", -64, 0, atextdrawingarea);
      addSkill(16373, "Cooking:", -62, 0, atextdrawingarea);
      addSkill(16381, "Firemaking:", -54, 0, atextdrawingarea);
      addSkill(16389, "Woodcutting:", -49, 11, atextdrawingarea);
      addSkill(16397, "Farming:", -62, 0, atextdrawingarea);
      addSkill(16405, "Construction:", -47, 11, atextdrawingarea);
      addSkill(16413, "Hunter:", -65, 0, atextdrawingarea);
      addSkill(16421, "Summoning:", -52, 11, atextdrawingarea);
      Widget rsinterface = addTab(16221);
      rsinterface.parentID = 16220;
      rsinterface.id = 16221;
      rsinterface.type = 0;
      rsinterface.atActionType = 0;
      rsinterface.contentType = 0;
      rsinterface.width = 164;
      rsinterface.height = 227;
      rsinterface.opacity = 0;
      rsinterface.hoverType = -1;
      rsinterface.scrollMax = 260;
      rsinterface.isMouseoverTriggered = false;
      rsinterface.children = new int[73];
      rsinterface.childX = new int[73];
      rsinterface.childY = new int[73];
      rsinterface.children[0] = 16222;
      rsinterface.childX[0] = 0;
      rsinterface.childY[0] = 0;
      rsinterface.children[1] = 16229;
      rsinterface.childX[1] = 0;
      rsinterface.childY[1] = 2;
      rsinterface.children[2] = 16247;
      rsinterface.childX[2] = 0;
      rsinterface.childY[2] = 34;
      rsinterface.children[3] = 16255;
      rsinterface.childX[3] = 0;
      rsinterface.childY[3] = 66;
      rsinterface.children[4] = 16263;
      rsinterface.childX[4] = 0;
      rsinterface.childY[4] = 98;
      rsinterface.children[5] = 16271;
      rsinterface.childX[5] = 0;
      rsinterface.childY[5] = 130;
      rsinterface.children[6] = 16279;
      rsinterface.childX[6] = 0;
      rsinterface.childY[6] = 162;
      rsinterface.children[7] = 16287;
      rsinterface.childX[7] = 0;
      rsinterface.childY[7] = 194;
      rsinterface.children[8] = 16295;
      rsinterface.childX[8] = 54;
      rsinterface.childY[8] = 2;
      rsinterface.children[9] = 16303;
      rsinterface.childX[9] = 54;
      rsinterface.childY[9] = 34;
      rsinterface.children[10] = 16311;
      rsinterface.childX[10] = 54;
      rsinterface.childY[10] = 66;
      rsinterface.children[11] = 16319;
      rsinterface.childX[11] = 54;
      rsinterface.childY[11] = 98;
      rsinterface.children[12] = 16327;
      rsinterface.childX[12] = 54;
      rsinterface.childY[12] = 130;
      rsinterface.children[13] = 16335;
      rsinterface.childX[13] = 54;
      rsinterface.childY[13] = 162;
      rsinterface.children[14] = 16343;
      rsinterface.childX[14] = 54;
      rsinterface.childY[14] = 194;
      rsinterface.children[15] = 16351;
      rsinterface.childX[15] = 108;
      rsinterface.childY[15] = 2;
      rsinterface.children[16] = 16359;
      rsinterface.childX[16] = 108;
      rsinterface.childY[16] = 34;
      rsinterface.children[17] = 16367;
      rsinterface.childX[17] = 108;
      rsinterface.childY[17] = 66;
      rsinterface.children[18] = 16375;
      rsinterface.childX[18] = 108;
      rsinterface.childY[18] = 98;
      rsinterface.children[19] = 16383;
      rsinterface.childX[19] = 108;
      rsinterface.childY[19] = 130;
      rsinterface.children[20] = 16391;
      rsinterface.childX[20] = 108;
      rsinterface.childY[20] = 162;
      rsinterface.children[21] = 16399;
      rsinterface.childX[21] = 108;
      rsinterface.childY[21] = 194;
      rsinterface.children[22] = 16407;
      rsinterface.childX[22] = 0;
      rsinterface.childY[22] = 226;
      rsinterface.children[23] = 16415;
      rsinterface.childX[23] = 54;
      rsinterface.childY[23] = 226;
      rsinterface.children[24] = 16423;
      rsinterface.childX[24] = 108;
      rsinterface.childY[24] = 226;
      rsinterface.children[25] = 4004;
      rsinterface.childX[25] = 27;
      rsinterface.childY[25] = 5;
      rsinterface.children[26] = 4005;
      rsinterface.childX[26] = 36;
      rsinterface.childY[26] = 19;
      rsinterface.children[27] = 4006;
      rsinterface.childX[27] = 27;
      rsinterface.childY[27] = 37;
      rsinterface.children[28] = 4007;
      rsinterface.childX[28] = 36;
      rsinterface.childY[28] = 50;
      rsinterface.children[29] = 4008;
      rsinterface.childX[29] = 27;
      rsinterface.childY[29] = 69;
      rsinterface.children[30] = 4009;
      rsinterface.childX[30] = 36;
      rsinterface.childY[30] = 82;
      rsinterface.children[31] = 4010;
      rsinterface.childX[31] = 27;
      rsinterface.childY[31] = 101;
      rsinterface.children[32] = 4011;
      rsinterface.childX[32] = 36;
      rsinterface.childY[32] = 114;
      rsinterface.children[33] = 4012;
      rsinterface.childX[33] = 27;
      rsinterface.childY[33] = 133;
      rsinterface.children[34] = 4013;
      rsinterface.childX[34] = 36;
      rsinterface.childY[34] = 146;
      rsinterface.children[35] = 4014;
      rsinterface.childX[35] = 27;
      rsinterface.childY[35] = 165;
      rsinterface.children[36] = 4015;
      rsinterface.childX[36] = 36;
      rsinterface.childY[36] = 178;
      rsinterface.children[37] = 4152;
      rsinterface.childX[37] = 27;
      rsinterface.childY[37] = 197;
      rsinterface.children[38] = 4153;
      rsinterface.childX[38] = 36;
      rsinterface.childY[38] = 210;
      rsinterface.children[39] = 4016;
      rsinterface.childX[39] = 81;
      rsinterface.childY[39] = 5;
      rsinterface.children[40] = 4017;
      rsinterface.childX[40] = 92;
      rsinterface.childY[40] = 22;
      rsinterface.children[41] = 4018;
      rsinterface.childX[41] = 82;
      rsinterface.childY[41] = 37;
      rsinterface.children[42] = 4019;
      rsinterface.childX[42] = 91;
      rsinterface.childY[42] = 53;
      rsinterface.children[43] = 4020;
      rsinterface.childX[43] = 81;
      rsinterface.childY[43] = 69;
      rsinterface.children[44] = 4021;
      rsinterface.childX[44] = 90;
      rsinterface.childY[44] = 85;
      rsinterface.children[45] = 4022;
      rsinterface.childX[45] = 82;
      rsinterface.childY[45] = 101;
      rsinterface.children[46] = 4023;
      rsinterface.childX[46] = 91;
      rsinterface.childY[46] = 117;
      rsinterface.children[47] = 4024;
      rsinterface.childX[47] = 82;
      rsinterface.childY[47] = 133;
      rsinterface.children[48] = 4025;
      rsinterface.childX[48] = 91;
      rsinterface.childY[48] = 149;
      rsinterface.children[49] = 4026;
      rsinterface.childX[49] = 81;
      rsinterface.childY[49] = 165;
      rsinterface.children[50] = 4027;
      rsinterface.childX[50] = 90;
      rsinterface.childY[50] = 181;
      rsinterface.children[51] = 12166;
      rsinterface.childX[51] = 82;
      rsinterface.childY[51] = 197;
      rsinterface.children[52] = 12167;
      rsinterface.childX[52] = 91;
      rsinterface.childY[52] = 213;
      rsinterface.children[53] = 4028;
      rsinterface.childX[53] = 135;
      rsinterface.childY[53] = 5;
      rsinterface.children[54] = 4029;
      rsinterface.childX[54] = 144;
      rsinterface.childY[54] = 22;
      rsinterface.children[55] = 4030;
      rsinterface.childX[55] = 136;
      rsinterface.childY[55] = 37;
      rsinterface.children[56] = 4031;
      rsinterface.childX[56] = 145;
      rsinterface.childY[56] = 53;
      rsinterface.children[57] = 4032;
      rsinterface.childX[57] = 136;
      rsinterface.childY[57] = 69;
      rsinterface.children[58] = 4033;
      rsinterface.childX[58] = 145;
      rsinterface.childY[58] = 85;
      rsinterface.children[59] = 4034;
      rsinterface.childX[59] = 136;
      rsinterface.childY[59] = 101;
      rsinterface.children[60] = 4035;
      rsinterface.childX[60] = 145;
      rsinterface.childY[60] = 117;
      rsinterface.children[61] = 4036;
      rsinterface.childX[61] = 135;
      rsinterface.childY[61] = 133;
      rsinterface.children[62] = 4037;
      rsinterface.childX[62] = 144;
      rsinterface.childY[62] = 149;
      rsinterface.children[63] = 4038;
      rsinterface.childX[63] = 136;
      rsinterface.childY[63] = 165;
      rsinterface.children[64] = 4039;
      rsinterface.childX[64] = 146;
      rsinterface.childY[64] = 181;
      rsinterface.children[65] = 13926;
      rsinterface.childX[65] = 136;
      rsinterface.childY[65] = 197;
      rsinterface.children[66] = 13927;
      rsinterface.childX[66] = 146;
      rsinterface.childY[66] = 213;
      rsinterface.children[67] = 16431;
      rsinterface.childX[67] = 27;
      rsinterface.childY[67] = 229;
      rsinterface.children[68] = 16432;
      rsinterface.childX[68] = 36;
      rsinterface.childY[68] = 242;
      rsinterface.children[69] = 16429;
      rsinterface.childX[69] = 136;
      rsinterface.childY[69] = 229;
      rsinterface.children[70] = 16430;
      rsinterface.childX[70] = 146;
      rsinterface.childY[70] = 245;
      rsinterface.children[71] = 16433;
      rsinterface.childX[71] = 80;
      rsinterface.childY[71] = 229;
      rsinterface.children[72] = 16434;
      rsinterface.childX[72] = 87;
      rsinterface.childY[72] = 245;
   }

   public static void skills() {
      Widget rsinterface = addTab(3917);
      addSpellClick2(16222, 29, 29);
      addSpellClick2(16223, 30, 30);
      drawYellowBox(16235, 138, 70);
      rsinterface.scrollMax = 0;
      rsinterface.isMouseoverTriggered = false;
      rsinterface.children = new int[28];
      rsinterface.childX = new int[28];
      rsinterface.childY = new int[28];
      rsinterface.children[0] = 16223;
      rsinterface.childX[0] = 0;
      rsinterface.childY[0] = 15;
      rsinterface.children[1] = 16221;
      rsinterface.childX[1] = 2;
      rsinterface.childY[1] = 17;
      rsinterface.children[2] = 3985;
      rsinterface.childX[2] = -32;
      rsinterface.childY[2] = 0;
      rsinterface.children[3] = 16227;
      rsinterface.childX[3] = 34;
      rsinterface.childY[3] = 51;
      rsinterface.children[4] = 16245;
      rsinterface.childX[4] = 34;
      rsinterface.childY[4] = 83;
      rsinterface.children[5] = 16253;
      rsinterface.childX[5] = 34;
      rsinterface.childY[5] = 115;
      rsinterface.children[6] = 16261;
      rsinterface.childX[6] = 34;
      rsinterface.childY[6] = 147;
      rsinterface.children[7] = 16269;
      rsinterface.childX[7] = 34;
      rsinterface.childY[7] = 179;
      rsinterface.children[8] = 16277;
      rsinterface.childX[8] = 34;
      rsinterface.childY[8] = 107;
      rsinterface.children[9] = 16285;
      rsinterface.childX[9] = 34;
      rsinterface.childY[9] = 139;
      rsinterface.children[10] = 16293;
      rsinterface.childX[10] = 48;
      rsinterface.childY[10] = 51;
      rsinterface.children[11] = 16301;
      rsinterface.childX[11] = 48;
      rsinterface.childY[11] = 83;
      rsinterface.children[12] = 16309;
      rsinterface.childX[12] = 48;
      rsinterface.childY[12] = 115;
      rsinterface.children[13] = 16317;
      rsinterface.childX[13] = 48;
      rsinterface.childY[13] = 147;
      rsinterface.children[14] = 16325;
      rsinterface.childX[14] = 48;
      rsinterface.childY[14] = 179;
      rsinterface.children[15] = 16333;
      rsinterface.childX[15] = 48;
      rsinterface.childY[15] = 107;
      rsinterface.children[16] = 16341;
      rsinterface.childX[16] = 48;
      rsinterface.childY[16] = 139;
      rsinterface.children[17] = 16349;
      rsinterface.childX[17] = 50;
      rsinterface.childY[17] = 51;
      rsinterface.children[18] = 16357;
      rsinterface.childX[18] = 50;
      rsinterface.childY[18] = 83;
      rsinterface.children[19] = 16365;
      rsinterface.childX[19] = 50;
      rsinterface.childY[19] = 115;
      rsinterface.children[20] = 16373;
      rsinterface.childX[20] = 50;
      rsinterface.childY[20] = 147;
      rsinterface.children[21] = 16381;
      rsinterface.childX[21] = 50;
      rsinterface.childY[21] = 179;
      rsinterface.children[22] = 16389;
      rsinterface.childX[22] = 50;
      rsinterface.childY[22] = 107;
      rsinterface.children[23] = 16397;
      rsinterface.childX[23] = 50;
      rsinterface.childY[23] = 139;
      rsinterface.children[24] = 16405;
      rsinterface.childX[24] = 34;
      rsinterface.childY[24] = 139;
      rsinterface.children[25] = 16413;
      rsinterface.childX[25] = 48;
      rsinterface.childY[25] = 139;
      rsinterface.children[26] = 16421;
      rsinterface.childX[26] = 50;
      rsinterface.childY[26] = 139;
      rsinterface.children[27] = 16435;
      rsinterface.childX[27] = 0;
      rsinterface.childY[27] = 0;
   }

   private static Sprite GetInterfaceImage(String interfaceName, String s) {
      long l = TextClass.method585(s) << 8;
      Sprite Sprite = (Sprite)spriteCache.insertFromCache(l);
      if(Sprite != null) {
         return Sprite;
      } else {
         try {
            Sprite = new Sprite("/SPRITES/Interface Images/" + interfaceName + "/" + s);
            spriteCache.removeFromCache(Sprite, l);
            return Sprite;
         } catch (Exception var6) {
            return null;
         }
      }
   }

   public static void AddInterfaceImage(int i, String interfaceName, String spriteName) {
      Widget dSprite = interfaceCache[i] = new Widget();
      dSprite.id = i;
      dSprite.parentID = i;
      dSprite.type = 5;
      dSprite.atActionType = 1;
      dSprite.contentType = 0;
      dSprite.width = 20;
      dSprite.height = 20;
      dSprite.opacity = 0;
      dSprite.hoverType = 52;
      dSprite.disabledSprite = GetInterfaceImage(interfaceName, spriteName);
      dSprite.enabledSprite = GetInterfaceImage(interfaceName, spriteName);
   }

   public static void AddInterfaceButton(int i, int width, int height, String tooltip, String interfaceName, String spriteName) {
      Widget widget = interfaceCache[i] = new Widget();
      widget.id = i;
      widget.parentID = i;
      widget.type = 5;
      widget.atActionType = 1;
      widget.contentType = 0;
      widget.width = width;
      widget.height = height;
      widget.opacity = 0;
      widget.hoverType = 52;
      widget.disabledSprite = GetInterfaceImage(interfaceName, spriteName);
      widget.enabledSprite = GetInterfaceImage(interfaceName, spriteName);
      widget.tooltip = tooltip;
   }

   public static void AddInterfaceLabel(int id, String text, RSFont[] wid, int font, int color) {
      Widget Tab = AddTab(id);
      Tab.id = id;
      Tab.parentID = id;
      Tab.type = 4;
      Tab.atActionType = 0;
      Tab.width = 174;
      Tab.height = 11;
      Tab.contentType = 0;
      Tab.opacity = 0;
      Tab.hoverType = -1;
      Tab.centerText = false;
      Tab.textShadow = true;
      Tab.textDrawingAreas = wid[font];
      Tab.message = text;
      Tab.secondaryText = "";
      Tab.textColor = color;
      Tab.secondaryColor = 0;
      Tab.defaultHoverColor = 0;
      Tab.secondaryHoverColor = 0;
   }

   public static void AddClickableText(int i, String text, String tooltip, RSFont[] wid, int font, int color, int width, int height) {
      Widget Tab = AddTab(i);
      Tab.id = i;
      Tab.parentID = i;
      Tab.type = 4;
      Tab.atActionType = 1;
      Tab.width = width;
      Tab.height = height;
      Tab.contentType = 0;
      Tab.opacity = 0;
      Tab.hoverType = -1;
      Tab.centerText = false;
      Tab.textShadow = true;
      Tab.textDrawingAreas = wid[font];
      Tab.message = text;
      Tab.tooltip = tooltip;
      Tab.secondaryText = "";
      Tab.textColor = color;
      Tab.secondaryColor = 0;
      Tab.defaultHoverColor = 0;
      Tab.secondaryHoverColor = 0;
   }
   public static void printInterfaceData() {
   	try{
		File file = new File(SignLink.findcachedir()+"/interfaceDump.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		for (Widget r : Widget.interfaceCache) {
			if (r != null) {
				if (r.children != null) {
					bw.write("Dump for interface: "+r.id+"");
					bw.newLine();
					for (int i = 0; i < r.children.length; i++) {
						bw.write("Child #"+i+"     Child ID: "+r.children[i]+"    Child X: "+r.childX[i]+"    Child Y: "+r.childY[i]+"");
						bw.newLine();
					}
					bw.newLine();
					bw.newLine();
					bw.newLine();
					bw.newLine();
				}
			}
		}
		bw.close();
   	} catch (Exception e) {
   	}
   }
	public static void addTransparentSprite(int id, int spriteId, String spriteName) {
		Widget tab = interfaceCache[id] = new Widget();
		tab.id = id;
		tab.parentID = id;
		tab.type = 5;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.opacity = (byte) 0;
		tab.hoverType = 52;
		tab.disabledSprite = imageLoader(spriteId, spriteName);
		tab.enabledSprite = imageLoader(spriteId, spriteName);
		tab.width = 512;
		tab.height = 334;
		tab.drawsTransparent = true;
	}
	public static void addConfigButton(int ID, int pID, int bID, int bID2, String bName, int width, int height, String tT, int configID, int aT, int configFrame) {
		Widget Tab = addTabInterface(ID);
		Tab.parentID = pID;
		Tab.id = ID;
		Tab.type = 5;
		Tab.atActionType = aT;
		Tab.contentType = 0;
		Tab.width = width;
		Tab.height = height;
		Tab.opacity = 0;
		Tab.hoverType = -1;
		Tab.anIntArray245 = new int[1];
		Tab.anIntArray212 = new int[1];
		Tab.anIntArray245[0] = 1;
		Tab.anIntArray212[0] = configID;
		Tab.valueIndexArray = new int[1][3];
		Tab.valueIndexArray[0][0] = 5;
		Tab.valueIndexArray[0][1] = configFrame;
		Tab.valueIndexArray[0][2] = 0;
		Tab.disabledSprite = imageLoader(bID, bName);
		Tab.enabledSprite = imageLoader(bID2, bName);
		Tab.tooltip = tT;
	}
	public static void quickPrayers(final RSFont[] TDA) {
		int i = 0;
		final Widget localWidget = addInterface(17200);
		addSprite(17201, 3, "QuickPrayer/Sprite");
		addText(17240, "Select your quick prayers:", TDA, 0, 16750623, false,
				true);
		addTransparentSprite(17249, 0, "QuickPrayer/SPRITE");
		int j = 17202;
		for (int k = 630; j <= 17227 || k <= 655; ++k) {
			addConfigButton(j, 17200, 2, 1, "QuickPrayer/Sprite", 14, 15,
					"Select", 0, 1, k);
			j++;
		}
		addHoverButton(17241, "QuickPrayer/SPRITE", 4, 190, 24,
				"Confirm Selection", -1, 17242, 1);
		addHoveredButton(17242, "QuickPrayer/SPRITE", 5, 190, 24, 17243);
		setChildren(58, localWidget);
		setBounds(25001, 5, 28, i++, localWidget);
		setBounds(25003, 44, 28, i++, localWidget);
		setBounds(25005, 79, 31, i++, localWidget);
		setBounds(25007, 116, 30, i++, localWidget);
		setBounds(25009, 153, 29, i++, localWidget);
		setBounds(25011, 5, 68, i++, localWidget);
		setBounds(25013, 44, 67, i++, localWidget);
		setBounds(25015, 79, 69, i++, localWidget);
		setBounds(25017, 116, 70, i++, localWidget);
		setBounds(25019, 154, 70, i++, localWidget);
		setBounds(25021, 4, 104, i++, localWidget);
		setBounds(25023, 44, 107, i++, localWidget);
		setBounds(25025, 81, 105, i++, localWidget);
		setBounds(25027, 117, 105, i++, localWidget);
		setBounds(25029, 156, 107, i++, localWidget);
		setBounds(25031, 5, 145, i++, localWidget);
		setBounds(25033, 43, 144, i++, localWidget);
		setBounds(25035, 83, 144, i++, localWidget);
		setBounds(25037, 115, 141, i++, localWidget);
		setBounds(25039, 154, 144, i++, localWidget);
		setBounds(25041, 5, 180, i++, localWidget);
		setBounds(25043, 41, 178, i++, localWidget);
		setBounds(25045, 79, 183, i++, localWidget);
		setBounds(25047, 116, 178, i++, localWidget);
		setBounds(25049, 161, 180, i++, localWidget);
		setBounds(25051, 4, 219, i++, localWidget);
		// setBounds(18061, 78, 212, i++, localWidget);
		// setBounds(18121, 116, 208, i++, localWidget);
		setBounds(17249, 0, 25, i++, localWidget);
		setBounds(17201, 0, 22, i++, localWidget);
		setBounds(17201, 0, 237, i++, localWidget);
		setBounds(17202, 2, 25, i++, localWidget);
		setBounds(17203, 41, 25, i++, localWidget);
		setBounds(17204, 76, 25, i++, localWidget);
		setBounds(17205, 113, 25, i++, localWidget);
		setBounds(17206, 150, 25, i++, localWidget);
		setBounds(17207, 2, 65, i++, localWidget);
		setBounds(17208, 41, 65, i++, localWidget);
		setBounds(17209, 76, 65, i++, localWidget);
		setBounds(17210, 113, 65, i++, localWidget);
		setBounds(17211, 150, 65, i++, localWidget);
		setBounds(17212, 2, 102, i++, localWidget);
		setBounds(17213, 41, 102, i++, localWidget);
		setBounds(17214, 76, 102, i++, localWidget);
		setBounds(17215, 113, 102, i++, localWidget);
		setBounds(17216, 150, 102, i++, localWidget);
		setBounds(17217, 2, 141, i++, localWidget);
		setBounds(17218, 41, 141, i++, localWidget);
		setBounds(17219, 76, 141, i++, localWidget);
		setBounds(17220, 113, 141, i++, localWidget);
		setBounds(17221, 150, 141, i++, localWidget);
		setBounds(17222, 2, 177, i++, localWidget);
		setBounds(17223, 41, 177, i++, localWidget);
		setBounds(17224, 76, 177, i++, localWidget);
		setBounds(17225, 113, 177, i++, localWidget);
		setBounds(17226, 150, 177, i++, localWidget);
		setBounds(17227, 1, 211, i++, localWidget);
		setBounds(17240, 5, 5, i++, localWidget);
		setBounds(17241, 0, 237, i++, localWidget);
		setBounds(17242, 0, 237, i++, localWidget);
		j = 0;
		addPrayerWithTooltip(25000, 0, 83, 0, j, 25052,
				"Activate @lre@Thick Skin");
		j++;
		addPrayerWithTooltip(25002, 0, 84, 3, 0, 25054,
				"Activate @lre@Burst of Strength");

		addSprite(25003, 1, "QuickPrayer/normal/PRAYERON");
		j++;
		addPrayerWithTooltip(25004, 0, 85, 6, j, 25056,
				"Activate @lre@Clarity of Thought");
		j++;
		addPrayerWithTooltip(25006, 0, 601, 7, j, 25058,
				"Activate @lre@Sharp Eye");
		j++;
		addPrayerWithTooltip(25008, 0, 602, 8, j, 25060,
				"Activate @lre@Mystic Will");
		j++;
		addPrayerWithTooltip(25010, 0, 86, 9, j, 25062,
				"Activate @lre@Rock Skin");
		j++;
		addPrayerWithTooltip(25012, 0, 87, 12, j, 25064,
				"Activate @lre@Superhuman Strength");
		j++;
		addPrayerWithTooltip(25014, 0, 88, 15, j, 25066,
				"Activate @lre@Improved Reflexes");
		j++;
		addPrayerWithTooltip(25016, 0, 89, 18, j, 25068,
				"Activate @lre@Rapid Restore");
		j++;
		addPrayerWithTooltip(25018, 0, 90, 21, j, 25070,
				"Activate @lre@Rapid Heal");
		j++;
		addPrayerWithTooltip(25020, 0, 91, 24, j, 25072,
				"Activate @lre@Protect Item");
		j++;
		addPrayerWithTooltip(25022, 0, 603, 25, j, 25074,
				"Activate @lre@Hawk Eye");
		j++;
		addPrayerWithTooltip(25024, 0, 604, 26, j, 25076,
				"Activate @lre@Mystic Lore");
		j++;
		addPrayerWithTooltip(25026, 0, 92, 27, j, 25078,
				"Activate @lre@Steel Skin");
		j++;
		addPrayerWithTooltip(25028, 0, 93, 30, j, 25080,
				"Activate @lre@Ultimate Strength");
		j++;
		addPrayerWithTooltip(25030, 0, 94, 33, j, 25082,
				"Activate @lre@Incredible Reflexes");
		j++;
		addPrayerWithTooltip(25032, 0, 95, 36, j, 25084,
				"Activate @lre@Protect from Magic");
		j++;
		addPrayerWithTooltip(25034, 0, 96, 39, j, 25086,
				"Activate @lre@Protect from Missles");
		j++;
		addPrayerWithTooltip(25036, 0, 97, 42, j, 25088,
				"Activate @lre@Protect from Melee");
		j++;
		addPrayerWithTooltip(25038, 0, 605, 43, j, 25090,
				"Activate @lre@Eagle Eye");
		j++;
		addPrayerWithTooltip(25040, 0, 606, 44, j, 25092,
				"Activate @lre@Mystic Might");
		j++;
		addPrayerWithTooltip(25042, 0, 98, 45, j, 25094,
				"Activate @lre@Retribution");
		j++;
		addPrayerWithTooltip(25044, 0, 99, 48, j, 25096,
				"Activate @lre@Redemption");
		j++;
		addPrayerWithTooltip(25046, 0, 100, 51, j, 25098, "Activate @lre@Smite");
		j++;
		addPrayerWithTooltip(25048, 0, 607, 59, j, 25100,
				"Activate @lre@Chivalry");
		j++;
		addPrayerWithTooltip(25050, 0, 608, 69, j, 25102, "Activate @lre@Piety");
	}
	private static void addPrayerWithTooltip(final int i, final int j,
			final int k, final int l, final int j2, final int m,
			final String string) {
		addPrayer(i, j, k, l, j2, string, m, "normal/PRAYERON");
	}
	public static void addPrayer(final int i, final int configId,
			final int configFrame, final int requiredValues,
			final int prayerSpriteID, final String PrayerName, final int Hover,
			final String loca) {
		Widget Interface = addTabInterface(i);
		Interface.id = i;
		Interface.parentID = 22500;
		Interface.type = 5;
		Interface.atActionType = 4;
		Interface.contentType = 0;
		Interface.opacity = 0;
		Interface.hoverType = Hover;
		Interface.disabledSprite = imageLoader(prayerSpriteID, "QuickPrayer/" + loca
				+ "");
		Interface.enabledSprite = imageLoader(prayerSpriteID, "QuickPrayer/" + loca
				+ "");
		Interface.width = 34;
		Interface.height = 34;
		Interface.anIntArray212 = new int[1];
		Interface.anIntArray245 = new int[1];
		Interface.anIntArray212[0] = 1;
		Interface.anIntArray245[0] = configId;
		Interface.valueIndexArray = new int[1][3];
		Interface.valueIndexArray[0][0] = 5;
		Interface.valueIndexArray[0][1] = configFrame;
		Interface.valueIndexArray[0][2] = 0;
		Interface.tooltip = "Activate@lre@ " + PrayerName;
		Interface = addTabInterface(i + 1);
		Interface.id = i + 1;
		Interface.parentID = 22500;
		Interface.type = 5;
		Interface.atActionType = 0;
		Interface.contentType = 0;
		Interface.opacity = 0;
		Interface.disabledSprite = imageLoader(prayerSpriteID, "QuickPrayer/" + loca
				+ "");
		Interface.enabledSprite = imageLoader(prayerSpriteID, "QuickPrayer/" + loca
				+ "");
		Interface.width = 34;
		Interface.height = 34;
		Interface.anIntArray212 = new int[1];
		Interface.anIntArray245 = new int[1];
		Interface.anIntArray212[0] = 2;
		Interface.anIntArray245[0] = requiredValues + 1;
		Interface.valueIndexArray = new int[1][3];
		Interface.valueIndexArray[0][0] = 2;
		Interface.valueIndexArray[0][1] = 5;
		Interface.valueIndexArray[0][2] = 0;
	}
   public static void AddInterfaceModel(int ID, int mId, int modelZoom, int modelRT, int modelRT2) {
      Widget Tab = AddTab(ID);
      Tab.id = ID;
      Tab.parentID = ID;
      Tab.type = 6;
      Tab.atActionType = 0;
      Tab.anInt233 = 1;
      Tab.contentType = 0;
      Tab.width = 512;
      Tab.height = 334;
      Tab.opacity = 0;
      Tab.hoverType = -1;
      Tab.anInt234 = mId;
      Tab.modelZoom = modelZoom;
      Tab.modelRotation1 = modelRT;
      Tab.modelRotation2 = modelRT2;
   }
   
   public static void AddInterfaceModel2(int ID, int mId, int modelZoom, int modelRT, int modelRT2) {
	      Widget Tab = AddTab(ID);
	      Tab.id = ID;
	      Tab.parentID = ID;
	      Tab.type = 6;
	      Tab.atActionType = 0;
	      Tab.anInt233 = 1;
	      Tab.contentType = 0;
	      Tab.width = 32;
	      Tab.height = 32;
	      Tab.opacity = 0;
	      Tab.hoverType = -1;
	      Tab.anInt234 = mId;
	      Tab.modelZoom = modelZoom;
	      Tab.modelRotation1 = modelRT;
	      Tab.modelRotation2 = modelRT2;
	   }


   public static Widget AddTab(int id) {
      Widget Tab = interfaceCache[id] = new Widget();
      Tab.id = id;
      Tab.parentID = id;
      Tab.type = 0;
      Tab.atActionType = 0;
      Tab.contentType = 0;
      Tab.width = 512;
      Tab.height = 334;
      Tab.opacity = 0;
      Tab.hoverType = 0;
      return Tab;
   }

   public static Widget AddDTab(int i) {
      Widget widget = interfaceCache[i] = new Widget();
      widget.id = i;
      widget.parentID = i;
      widget.type = 0;
      widget.atActionType = 0;
      widget.contentType = 0;
      widget.width = 512;
      widget.height = 334;
      widget.opacity = 0;
      widget.hoverType = 0;
      return widget;
   }

   public static void AddCharacter(int ID) {
      Widget widget = interfaceCache[ID] = new Widget();
      widget.id = ID;
      widget.parentID = ID;
      widget.type = 6;
      widget.atActionType = 0;
      widget.contentType = 328;
      widget.width = 136;
      widget.height = 168;
      widget.opacity = 0;
      widget.hoverType = 0;
      widget.modelZoom = 650;
      widget.modelRotation1 = 150;
      widget.modelRotation2 = 0;
      widget.anInt257 = -1;
      widget.anInt258 = -1;
   }

   public static void AddInventoryItemGroup(int id, int h, int w) {
      Widget Tab = interfaceCache[id] = new Widget();
      Tab.inventoryItemId = new int[w * h];
      Tab.inventoryAmounts = new int[w * h];

      int i2;
      for(i2 = 0; i2 < w * h; ++i2) {
         Tab.inventoryAmounts[i2] = 0;
         Tab.inventoryItemId[i2] = 0;
      }

      Tab.spritesY = new int[20];
      Tab.spritesX = new int[20];

      for(i2 = 0; i2 < 20; ++i2) {
         Tab.spritesY[i2] = 0;
         Tab.spritesX[i2] = 0;
      }

      Tab.width = w;
      Tab.hoverType = -1;
      Tab.parentID = id;
      Tab.id = id;
      Tab.scrollMax = 0;
      Tab.type = 2;
      Tab.height = h;
   }

   public static void equipmentScreen(RSFont[] wid) {
      Widget tab = addTabInterface(15106);
      addSprite(15107, 7, "Equipment/CUSTOM");
      addHoverButton(15210, "Equipment/CUSTOM", 8, 21, 21, "Close", 250, 15211, 3);
      addHoveredButton(15211, "Equipment/CUSTOM", 9, 21, 21, 15212);
      addText(15111, "Equip Your Character...", wid, 2, 14983494, false, true);
      addText(15112, "Attack bonus", wid, 2, 14983494, false, true);
      addText(15113, "Defence bonus", wid, 2, 14983494, false, true);
      addText(15114, "Other bonuses", wid, 2, 14983494, false, true);

      int Child;
      for(Child = 1675; Child <= 1684; ++Child) {
         textSize(Child, wid, 1);
      }

      textSize(1686, wid, 1);
      textSize(1687, wid, 1);
      addChar(15125);
      tab.totalChildren(44);
      tab.child(0, 15107, 4, 20);
      tab.child(1, 15210, 476, 29);
      tab.child(2, 15211, 476, 29);
      tab.child(3, 15111, 14, 30);
      Child = 4;
      int Y = 69;

      int i;
      for(i = 1675; i <= 1679; ++i) {
         tab.child(Child, i, 20, Y);
         ++Child;
         Y += 14;
      }

      tab.child(9, 1680, 20, 161);
      tab.child(10, 1681, 20, 177);
      tab.child(11, 1682, 20, 192);
      tab.child(12, 1683, 20, 207);
      tab.child(13, 1684, 20, 221);
      tab.child(14, 1686, 20, 262);
      tab.child(15, 15125, 170, 200);
      tab.child(16, 15112, 16, 55);
      tab.child(17, 1687, 20, 276);
      tab.child(18, 15113, 16, 147);
      tab.child(19, 15114, 16, 248);
      tab.child(20, 1645, 399, 97);
      tab.child(21, 1646, 399, 163);
      tab.child(22, 1647, 399, 163);
      tab.child(23, 1648, 399, 204);
      tab.child(24, 1649, 343, 176);
      tab.child(25, 1650, 343, 212);
      tab.child(26, 1651, 455, 176);
      tab.child(27, 1652, 455, 212);
      tab.child(28, 1653, 369, 139);
      tab.child(29, 1654, 428, 139);
      tab.child(30, 1655, 379, 100);
      tab.child(31, 1656, 433, 99);
      tab.child(32, 1657, 399, 62);
      tab.child(33, 1658, 358, 101);
      tab.child(34, 1659, 399, 101);
      tab.child(35, 1660, 440, 101);
      tab.child(36, 1661, 343, 140);
      tab.child(37, 1662, 399, 140);
      tab.child(38, 1663, 455, 140);
      tab.child(39, 1664, 399, 180);
      tab.child(40, 1665, 399, 220);
      tab.child(41, 1666, 343, 220);
      tab.child(42, 1667, 455, 220);
      tab.child(43, 1688, 345, 102);

      Widget rsi;
      for(i = 1675; i <= 1684; ++i) {
         rsi = interfaceCache[i];
         rsi.textColor = 14983494;
         rsi.centerText = false;
      }

      for(i = 1686; i <= 1687; ++i) {
         rsi = interfaceCache[i];
         rsi.textColor = 14983494;
         rsi.centerText = false;
      }

   }

   public static void addChar(int ID) {
      Widget t = interfaceCache[ID] = new Widget();
      t.id = ID;
      t.parentID = ID;
      t.type = 6;
      t.atActionType = 0;
      t.contentType = 328;
      t.width = 136;
      t.height = 168;
      t.opacity = 0;
      t.hoverType = 0;
      t.modelZoom = 560;
      t.modelRotation1 = 150;
      t.modelRotation2 = 0;
      t.anInt257 = -1;
      t.anInt258 = -1;
   }

   public static void addHoverImage(int i, int j, int k, String name) {
      Widget tab = addTabInterface(i);
      tab.id = i;
      tab.parentID = i;
      tab.type = 5;
      tab.atActionType = 0;
      tab.contentType = 0;
      tab.width = 512;
      tab.height = 334;
      tab.opacity = 0;
      tab.hoverType = 52;
      tab.disabledSprite = imageLoader(j, name);
      tab.enabledSprite = imageLoader(k, name);
   }

   public static void addButton(int i, int j, String name, int W, int H, String S, int AT) {
      Widget Widget = addInterface(i);
      Widget.id = i;
      Widget.parentID = i;
      Widget.type = 5;
      Widget.atActionType = AT;
      Widget.contentType = 0;
      Widget.opacity = 0;
      Widget.hoverType = 52;
      Widget.disabledSprite = imageLoader(j, name);
      Widget.enabledSprite = imageLoader(j, name);
      Widget.width = W;
      Widget.height = H;
      Widget.tooltip = S;
   }

   public static void addButton(int id, int sid, String spriteName, String tooltip) {
      Widget tab = interfaceCache[id] = new Widget();
      tab.id = id;
      tab.parentID = id;
      tab.type = 5;
      tab.atActionType = 1;
      tab.contentType = 0;
      tab.opacity = 0;
      tab.hoverType = 52;
      tab.disabledSprite = imageLoader(sid, spriteName);
      tab.enabledSprite = imageLoader(sid, spriteName);
      tab.width = tab.disabledSprite.myWidth;
      tab.height = tab.enabledSprite.myHeight;
      tab.tooltip = tooltip;
   }
	public static void clanChatSetup(RSFont[] tda) {
		Widget rsi = addInterface(18300);
		rsi.totalChildren(12 + 21);
		int count = 0;
		/* Background */
		addSprite(18301, 1, "/Interfaces/Clan Chat/sprite");
		rsi.child(count++, 18301, 14, 17);
		/* Close button */
		addButton(18302, 0, "/Interfaces/Clan Chat/close", "Close");
		interfaceCache[18302].atActionType = 3;
		rsi.child(count++, 18302, 475, 26);
		/* Clan Setup title */
		addText(18303, "Clan Setup", tda, 2, 0xFF981F, true, true);
		rsi.child(count++, 18303, 256, 26);
		String[] titles = { "Clan name:", "Who can enter chat?",
				"Who can talk on chat?", "Who can kick on chat?",
				"Who can ban on chat?" };
		String[] defaults = { "Chat Disabled", "Anyone", "Anyone", "Anyone",
				"Anyone"};
		String[] whoCan = { "Anyone", "Recruit", "Corporal", "Sergeant",
				"Lieutenant", "Captain", "General", "Only Me" };
		for (int index = 0, id = 18304, y = 50; index < titles.length; index++, id += 3, y += 40) {
			addButton(id, 2, "/Interfaces/Clan Chat/sprite", "");
			interfaceCache[id].atActionType = 0;
			if (index > 0) {
				interfaceCache[id].actions = whoCan;
			} else {
				interfaceCache[id].actions = new String[] { "Change title",
						"Delete clan" };
			}
			addText(id + 1, titles[index], tda, 0, 0xFF981F, true, true);
			addText(id + 2, defaults[index], tda, 1, 0xFFFFFF, true, true);
			rsi.child(count++, id, 25, y);
			rsi.child(count++, id + 1, 100, y + 4);
			rsi.child(count++, id + 2, 100, y + 17);
		}
		/* Table */
		addSprite(18319, 5, "/Interfaces/Clan Chat/sprite");
		rsi.child(count++, 18319, 197, 70);
		/* Labels */
		int id = 18320;
		int y = 74;
		addText(id, "Ranked Members", tda, 2, 0xFF981F, false, true);
		rsi.child(count++, id++, 202, y);
		addText(id, "Banned Members", tda, 2, 0xFF981F, false, true);
		rsi.child(count++, id++, 339, y);
		/* Ranked members list */
		Widget list = addInterface(id++);
		int lines = 100;
		list.totalChildren(lines);
		String[] ranks = { "Demote", "Recruit", "Corporal", "Sergeant",
				"Lieutenant", "Captain", "General", "Owner" };
		list.childY[0] = 2;
		// System.out.println(id);
		for (int index = id; index < id + lines; index++) {
			addText(index, "", tda, 1, 0xffffff, false, true);
			interfaceCache[index].actions = ranks;
			list.children[index - id] = index;
			list.childX[index - id] = 2;
			list.childY[index - id] = (index - id > 0 ? list.childY[index - id
					- 1] + 14 : 0);
		}
		id += lines;
		list.width = 119;
		list.height = 210;
		list.scrollMax = (lines * 14) + 2;
		rsi.child(count++, list.id, 199, 92);
		/* Banned members list */
		list = addInterface(id++);
		list.totalChildren(lines);
		list.childY[0] = 2;
		// System.out.println(id);
		for (int index = id; index < id + lines; index++) {
			addText(index, "", tda, 1, 0xffffff, false, true);
			interfaceCache[index].actions = new String[] { "Unban" };
			list.children[index - id] = index;
			list.childX[index - id] = 0;
			list.childY[index - id] = (index - id > 0 ? list.childY[index - id
					- 1] + 14 : 0);
		}
		id += lines;
		list.width = 119;
		list.height = 210;
		list.scrollMax = (lines * 14) + 2;
		rsi.child(count++, list.id, 339, 92);
		/* Table info text */
		y = 47;
		addText(id, "You can manage both ranked and banned members here.", tda,
				0, 0xFF981F, true, true);
		rsi.child(count++, id++, 337, y);
		addText(id, "Right click on a name to edit the member.", tda, 0,
				0xFF981F, true, true);
		rsi.child(count++, id++, 337, y + 11);
		/* Add ranked member button */
		y = 75;
		addButton(id, 0, "/Interfaces/Clan Chat/plus", "Add ranked member");
		interfaceCache[id].atActionType = 5;
		rsi.child(count++, id++, 319, y);
		/* Add banned member button */
		addButton(id, 0, "/Interfaces/Clan Chat/plus", "Add banned member");
		interfaceCache[id].atActionType = 5;
		rsi.child(count++, id++, 459, y);
		
		//addButton(id, 2, "/Interfaces/Clan Chat/sprite", "Allow Teleports");
		addHoverButton(id, "Interfaces/Clan Chat/sprite", 9, 150, 27, "Allow Teleports", 201, id, 5);
		rsi.child(count++, id++, 25, 248);
		addText(id, "Allow Teleports :", tda, 1,
				0xFFFFFF, true, true);
		rsi.child(count++, id++, 101, 254);
		addText(id, "@red@No", tda, 1,
				0xff0000, true, true);
		rsi.child(count++, id++, 157, 255);
		
		addHoverButton(id, "Interfaces/Clan Chat/sprite", 12, 150, 27, "Copy-kit", 201, id, 5);
		rsi.child(count++, id++, 25, 278);
		addText(id, "Allow Copy Kit :", tda, 1,
				0xFFFFFF, true, true);
		rsi.child(count++, id++, 101, 284);
		addText(id, "No", tda, 1,
				0xff0000, true, true);
		rsi.child(count++, id++, 157, 285);

		/* Hovers */
		int[] clanSetup = { 18302, 18304, 18307, 18310, 18313, 18316, 18526,
				18527 };
		String[] names = { "close", "sprite", "sprite", "sprite", "sprite",
				"sprite", "plus", "plus" };
		int[] ids = { 1, 3, 3, 3, 3, 3, 1, 1 };
		for (int index = 0; index < clanSetup.length; index++) {
			rsi = interfaceCache[clanSetup[index]];
			rsi.disabledSprite = imageLoader(ids[index],
					"/Interfaces/Clan Chat/" + names[index]);
		}
	}
   public static void clanChatTab(RSFont[] tda) {
      Widget tab = addTabInterface(18128);
      addHoverButton(18129, "/Clan Chat/SPRITE", 6, 72, 32, "Join Clan", 550, 18130, 1);
      addHoveredButton(18130, "/Clan Chat/SPRITE", 7, 72, 32, 18131);
      addHoverButton(18132, "/Clan Chat/SPRITE", 6, 72, 32, "Clan Setup", -1, 18133, 5);
      addHoveredButton(18133, "/Clan Chat/SPRITE", 7, 72, 32, 18134);
      addButton(18250, 0, "/Clan Chat/Lootshare", "Toggle lootshare");
      addText(18135, "Join Clan", tda, 0, 16751360, true, true);
      addText(18136, "Clan Setup", tda, 0, 16751360, true, true);
      addSprite(18137, 37, "/Clan Chat/SPRITE");
      addText(18138, "Clan Chat", tda, 1, 16751360, true, true);
      addText(18139, "Talking in: Not in chat", tda, 0, 16751360, false, true);
      addText(18140, "Owner: None", tda, 0, 16751360, false, true);
      tab.totalChildren(14);
      tab.child(0, 16126, 0, 221);
      tab.child(1, 16126, 0, 59);
      tab.child(2, 18137, 0, 62);
      tab.child(3, 18143, 0, 62);
      tab.child(4, 18129, 15, 226);
      tab.child(5, 18130, 15, 226);
      tab.child(6, 18132, 103, 226);
      tab.child(7, 18133, 103, 226);
      tab.child(8, 18135, 51, 237);
      tab.child(9, 18136, 139, 237);
      tab.child(10, 18138, 95, 1);
      tab.child(11, 18139, 10, 23);
      tab.child(12, 18140, 25, 38);
      tab.child(13, 18250, 145, 15);
		/* Text area */
		Widget list = addTabInterface(18143);
		list.totalChildren(100);
		for (int i = 18144; i <= 18244; i++) {
			addText(i, "", tda, 0, 0xffffff, false, true);
		}
		for (int id = 18144, i = 0; id <= 18243 && i <= 99; id++, i++) {
			interfaceCache[id].actions = new String[] { "Edit Rank", "Kick",
					"Ban", "Add", "Ignore", "Tele-To", "Copy-Kit" };
			list.children[i] = id;
			list.childX[i] = 20;
			for (int id2 = 18144, i2 = 1; id2 <= 18243 && i2 <= 99; id2++, i2++) {
				list.childY[0] = 7;
				list.childY[i2] = list.childY[i2 - 1] + 14;
			}
		}
		list.height = 158;
		list.width = 174;
		list.scrollMax = 1405;
   }

   public void totalChildren(int t) {
      this.children = new int[t];
      this.childX = new int[t];
      this.childY = new int[t];
   }

   public static void addText(int id, String text, RSFont[] wid, int idx, int color, boolean centered) {
      Widget widget = interfaceCache[id] = new Widget();
      if(centered) {
         widget.centerText = true;
      }

      widget.textShadow = true;
      widget.textDrawingAreas = wid[idx];
      widget.message = text;
      widget.textColor = color;
      widget.id = id;
      widget.type = 4;
   }

   public static void textColor(int id, int color) {
      Widget widget = interfaceCache[id];
      widget.textColor = color;
   }

   public static void textSize(int id, RSFont[] wid, int idx) {
      Widget widget = interfaceCache[id];
      widget.textDrawingAreas = wid[idx];
   }

   public static void addCacheSprite(int id, int disabledSprite, int enabledSprite, String sprites) {
      Widget widget = interfaceCache[id] = new Widget();
      widget.disabledSprite = method207(disabledSprite,  aClass44, sprites);
      widget.enabledSprite = method207(enabledSprite,  aClass44, sprites);
      widget.parentID = id;
      widget.id = id;
      widget.type = 5;
   }

   public static void disabledSprite(int id, int sprite) {
      Widget widget = interfaceCache[id];
      widget.disabledSprite = CustomSpriteLoader(sprite, "");
   }

   public void specialBar(int id) {
      addActionButton(id - 12, 7587, -1, 150, 26, "Use <col=65280>Special Attack");

      for(int var41 = id - 11; var41 < id; ++var41) {
         removeSomething(var41);
      }

      Widget var4 = interfaceCache[id - 12];
      var4.width = 150;
      var4.height = 26;
      var4 = interfaceCache[id];
      var4.width = 150;
      var4.height = 26;
      var4.child(0, id - 12, 0, 0);
      var4.child(12, id + 1, 3, 7);
      var4.child(23, id + 12, 16, 8);

      int i;
      for(i = 13; i < 23; ++i) {
         --var4.childY[i];
      }

      var4 = interfaceCache[id + 1];
      var4.type = 5;
      var4.disabledSprite = CustomSpriteLoader(7600, "");

      for(i = id + 2; i < id + 12; ++i) {
         var4 = interfaceCache[i];
         var4.type = 5;
      }

      disabledSprite(id + 2, 7601);
      disabledSprite(id + 3, 7602);
      disabledSprite(id + 4, 7603);
      disabledSprite(id + 5, 7604);
      disabledSprite(id + 6, 7605);
      disabledSprite(id + 7, 7606);
      disabledSprite(id + 8, 7607);
      disabledSprite(id + 9, 7608);
      disabledSprite(id + 10, 7609);
      disabledSprite(id + 11, 7610);
   }

   public static void Sidebar0(RSFont[] wid) {
      Sidebar0a(1698, 1701, 7499, "Chop", "Hack", "Smash", "Block", 42, 75, 127, 75, 39, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, wid);
      Sidebar0a(2276, 2279, 7574, "Stab", "Lunge", "Slash", "Block", 43, 75, 124, 75, 41, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, wid);
      Sidebar0a(2423, 2426, 7599, "Chop", "Slash", "Lunge", "Block", 42, 75, 125, 75, 40, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, wid);
      Sidebar0a(3796, 3799, 7624, "Pound", "Pummel", "Spike", "Block", 39, 75, 121, 75, 41, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, wid);
      Sidebar0a(4679, 4682, 7674, "Lunge", "Swipe", "Pound", "Block", 40, 75, 124, 75, 39, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, wid);
      Sidebar0a(4705, 4708, 7699, "Chop", "Slash", "Smash", "Block", 42, 75, 125, 75, 39, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, wid);
      Sidebar0a(5570, 5573, 7724, "Spike", "Impale", "Smash", "Block", 41, 75, 123, 75, 39, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, wid);
      Sidebar0a(7762, 7765, 7800, "Chop", "Slash", "Lunge", "Block", 42, 75, 125, 75, 40, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, wid);
      Sidebar0b(776, 779, "Reap", "Chop", "Jab", "Block", 42, 75, 126, 75, 46, 128, 125, 128, 122, 103, 122, 50, 40, 103, 40, 50, wid);
      Sidebar0c(425, 428, 7474, "Pound", "Pummel", "Block", 39, 75, 121, 75, 42, 128, 40, 103, 40, 50, 122, 50, wid);
      Sidebar0c(1749, 1752, 7524, "Accurate", "Rapid", "Longrange", 33, 75, 125, 75, 29, 128, 40, 103, 40, 50, 122, 50, wid);
      Sidebar0c(1764, 1767, 7549, "Accurate", "Rapid", "Longrange", 33, 75, 125, 75, 29, 128, 40, 103, 40, 50, 122, 50, wid);
      Sidebar0c(4446, 4449, 7649, "Accurate", "Rapid", "Longrange", 33, 75, 125, 75, 29, 128, 40, 103, 40, 50, 122, 50, wid);
      Sidebar0c(5855, 5857, 7749, "Punch", "Kick", "Block", 40, 75, 129, 75, 42, 128, 40, 50, 122, 50, 40, 103, wid);
      Sidebar0c(6103, 6132, 6117, "Bash", "Pound", "Block", 43, 75, 124, 75, 42, 128, 40, 103, 40, 50, 122, 50, wid);
      Sidebar0c(8460, 8463, 8493, "Jab", "Swipe", "Fend", 46, 75, 124, 75, 43, 128, 40, 103, 40, 50, 122, 50, wid);
      Sidebar0c(12290, 12293, 12323, "Flick", "Lash", "Deflect", 44, 75, 127, 75, 36, 128, 40, 50, 40, 103, 122, 50, wid);
      Sidebar0d(328, 331, "Bash", "Pound", "Focus", 42, 66, 39, 101, 41, 136, 40, 120, 40, 50, 40, 85, wid);
      Widget widget = addInterface(19300);
      textSize(3983, wid, 0);
      addToggleButton(150, 150, 172, 150, 44, "Auto Retaliate");
      widget.totalChildren(2, 2, 2);
      widget.child(0, 3983, 52, 25);
      widget.child(1, 150, 21, 153);
      widget = interfaceCache[3983];
      widget.centerText = true;
      widget.textColor = 16750623;
   }

   public static void Sidebar0a(int id, int id2, int id3, String text1, String text2, String text3, String text4, int str1x, int str1y, int str2x, int str2y, int str3x, int str3y, int str4x, int str4y, int img1x, int img1y, int img2x, int img2y, int img3x, int img3y, int img4x, int img4y, RSFont[] wid) {
      Widget widget = addInterface(id);
      addText(id2, "-2", wid, 3, 16750623, true);
      addText(id2 + 11, text1, wid, 0, 16750623, false);
      addText(id2 + 12, text2, wid, 0, 16750623, false);
      addText(id2 + 13, text3, wid, 0, 16750623, false);
      addText(id2 + 14, text4, wid, 0, 16750623, false);
      widget.specialBar(id3);
      widget.width = 190;
      widget.height = 261;
      byte last = 15;
      byte frame = 0;
      widget.totalChildren(last, last, last);
      widget.child(frame, id2 + 3, 21, 46);
      int var28 = frame + 1;
      widget.child(var28, id2 + 4, 104, 99);
      ++var28;
      widget.child(var28, id2 + 5, 21, 99);
      ++var28;
      widget.child(var28, id2 + 6, 105, 46);
      ++var28;
      widget.child(var28, id2 + 7, img1x, img1y);
      ++var28;
      widget.child(var28, id2 + 8, img2x, img2y);
      ++var28;
      widget.child(var28, id2 + 9, img3x, img3y);
      ++var28;
      widget.child(var28, id2 + 10, img4x, img4y);
      ++var28;
      widget.child(var28, id2 + 11, str1x, str1y);
      ++var28;
      widget.child(var28, id2 + 12, str2x, str2y);
      ++var28;
      widget.child(var28, id2 + 13, str3x, str3y);
      ++var28;
      widget.child(var28, id2 + 14, str4x, str4y);
      ++var28;
      widget.child(var28, 19300, 0, 0);
      ++var28;
      widget.child(var28, id2, 94, 4);
      ++var28;
      widget.child(var28, id3, 21, 205);
      ++var28;

      for(int i = id2 + 3; i < id2 + 7; ++i) {
         widget = interfaceCache[i];
         widget.disabledSprite = CustomSpriteLoader(19301, "");
         widget.enabledSprite = CustomSpriteLoader(19301, "a");
         widget.width = 68;
         widget.height = 44;
      }

   }

   public static void Sidebar0b(int id, int id2, String text1, String text2, String text3, String text4, int str1x, int str1y, int str2x, int str2y, int str3x, int str3y, int str4x, int str4y, int img1x, int img1y, int img2x, int img2y, int img3x, int img3y, int img4x, int img4y, RSFont[] wid) {
      Widget widget = addInterface(id);
      addText(id2, "-2", wid, 3, 16750623, true);
      addText(id2 + 11, text1, wid, 0, 16750623, false);
      addText(id2 + 12, text2, wid, 0, 16750623, false);
      addText(id2 + 13, text3, wid, 0, 16750623, false);
      addText(id2 + 14, text4, wid, 0, 16750623, false);
      widget.width = 190;
      widget.height = 261;
      byte last = 14;
      byte frame = 0;
      widget.totalChildren(last, last, last);
      widget.child(frame, id2 + 3, 21, 46);
      int var27 = frame + 1;
      widget.child(var27, id2 + 4, 104, 99);
      ++var27;
      widget.child(var27, id2 + 5, 21, 99);
      ++var27;
      widget.child(var27, id2 + 6, 105, 46);
      ++var27;
      widget.child(var27, id2 + 7, img1x, img1y);
      ++var27;
      widget.child(var27, id2 + 8, img2x, img2y);
      ++var27;
      widget.child(var27, id2 + 9, img3x, img3y);
      ++var27;
      widget.child(var27, id2 + 10, img4x, img4y);
      ++var27;
      widget.child(var27, id2 + 11, str1x, str1y);
      ++var27;
      widget.child(var27, id2 + 12, str2x, str2y);
      ++var27;
      widget.child(var27, id2 + 13, str3x, str3y);
      ++var27;
      widget.child(var27, id2 + 14, str4x, str4y);
      ++var27;
      widget.child(var27, 19300, 0, 0);
      ++var27;
      widget.child(var27, id2, 94, 4);
      ++var27;

      for(int i = id2 + 3; i < id2 + 7; ++i) {
         widget = interfaceCache[i];
         widget.disabledSprite = CustomSpriteLoader(19301, "");
         widget.enabledSprite = CustomSpriteLoader(19301, "a");
         widget.width = 68;
         widget.height = 44;
      }

   }

   public static void Sidebar0c(int id, int id2, int id3, String text1, String text2, String text3, int str1x, int str1y, int str2x, int str2y, int str3x, int str3y, int img1x, int img1y, int img2x, int img2y, int img3x, int img3y, RSFont[] wid) {
      Widget widget = addInterface(id);
      addText(id2, "-2", wid, 3, 16750623, true);
      addText(id2 + 9, text1, wid, 0, 16750623, false);
      addText(id2 + 10, text2, wid, 0, 16750623, false);
      addText(id2 + 11, text3, wid, 0, 16750623, false);
      widget.specialBar(id3);
      widget.width = 190;
      widget.height = 261;
      byte last = 12;
      byte frame = 0;
      widget.totalChildren(last, last, last);
      widget.child(frame, id2 + 3, 21, 99);
      int var23 = frame + 1;
      widget.child(var23, id2 + 4, 105, 46);
      ++var23;
      widget.child(var23, id2 + 5, 21, 46);
      ++var23;
      widget.child(var23, id2 + 6, img1x, img1y);
      ++var23;
      widget.child(var23, id2 + 7, img2x, img2y);
      ++var23;
      widget.child(var23, id2 + 8, img3x, img3y);
      ++var23;
      widget.child(var23, id2 + 9, str1x, str1y);
      ++var23;
      widget.child(var23, id2 + 10, str2x, str2y);
      ++var23;
      widget.child(var23, id2 + 11, str3x, str3y);
      ++var23;
      widget.child(var23, 19300, 0, 0);
      ++var23;
      widget.child(var23, id2, 94, 4);
      ++var23;
      widget.child(var23, id3, 21, 205);
      ++var23;

      for(int i = id2 + 3; i < id2 + 6; ++i) {
         widget = interfaceCache[i];
         widget.disabledSprite = CustomSpriteLoader(19301, "");
         widget.enabledSprite = CustomSpriteLoader(19301, "a");
         widget.width = 68;
         widget.height = 44;
      }

   }

   public static void Sidebar0d(int id, int id2, String text1, String text2, String text3, int str1x, int str1y, int str2x, int str2y, int str3x, int str3y, int img1x, int img1y, int img2x, int img2y, int img3x, int img3y, RSFont[] wid) {
      Widget widget = addInterface(id);
      addText(id2, "-2", wid, 3, 16750623, true);
      addText(id2 + 9, text1, wid, 0, 16750623, false);
      addText(id2 + 10, text2, wid, 0, 16750623, false);
      addText(id2 + 11, text3, wid, 0, 16750623, false);
      addText(353, "Spell", wid, 0, 16750623, false);
      addText(354, "Spell", wid, 0, 16750623, false);
      addCacheSprite(337, 19, 0, "combaticons");
      addCacheSprite(338, 13, 0, "combaticons2");
      addCacheSprite(339, 14, 0, "combaticons2");
      addToggleButton(349, 349, 108, 68, 44, "Select");
      addToggleButton(350, 350, 108, 68, 44, "Select");
      widget.width = 190;
      widget.height = 261;
      byte last = 15;
      byte frame = 0;
      widget.totalChildren(last, last, last);
      widget.child(frame, id2 + 3, 20, 115);
      int var21 = frame + 1;
      widget.child(var21, id2 + 4, 20, 80);
      ++var21;
      widget.child(var21, id2 + 5, 20, 45);
      ++var21;
      widget.child(var21, id2 + 6, img1x, img1y);
      ++var21;
      widget.child(var21, id2 + 7, img2x, img2y);
      ++var21;
      widget.child(var21, id2 + 8, img3x, img3y);
      ++var21;
      widget.child(var21, id2 + 9, str1x, str1y);
      ++var21;
      widget.child(var21, id2 + 10, str2x, str2y);
      ++var21;
      widget.child(var21, id2 + 11, str3x, str3y);
      ++var21;
      widget.child(var21, 349, 105, 46);
      ++var21;
      widget.child(var21, 350, 104, 106);
      ++var21;
      widget.child(var21, 353, 125, 74);
      ++var21;
      widget.child(var21, 354, 125, 134);
      ++var21;
      widget.child(var21, 19300, 0, 0);
      ++var21;
      widget.child(var21, id2, 94, 4);
      ++var21;
   }

   public static void addActionButton(int id, int sprite, int enabledSprite, int width, int height, String s) {
      Widget widget = interfaceCache[id] = new Widget();
      widget.disabledSprite = CustomSpriteLoader(sprite, "");
      if(enabledSprite == sprite) {
         widget.enabledSprite = CustomSpriteLoader(sprite, "a");
      } else {
         widget.enabledSprite = CustomSpriteLoader(enabledSprite, "");
      }

      widget.tooltip = s;
      widget.contentType = 0;
      widget.atActionType = 1;
      widget.width = width;
      widget.hoverType = 52;
      widget.parentID = id;
      widget.id = id;
      widget.type = 5;
      widget.height = height;
   }

   public static void addToggleButton(int id, int sprite, int setconfig, int width, int height, String s) {
      Widget widget = addInterface(id);
      widget.disabledSprite = CustomSpriteLoader(sprite, "");
      widget.enabledSprite = CustomSpriteLoader(sprite, "a");
      widget.anIntArray212 = new int[1];
      widget.anIntArray212[0] = 1;
      widget.anIntArray245 = new int[1];
      widget.anIntArray245[0] = 1;
      widget.valueIndexArray = new int[1][3];
      widget.valueIndexArray[0][0] = 5;
      widget.valueIndexArray[0][1] = setconfig;
      widget.valueIndexArray[0][2] = 0;
      widget.atActionType = 4;
      widget.width = width;
      widget.hoverType = -1;
      widget.parentID = id;
      widget.id = id;
      widget.type = 5;
      widget.height = height;
      widget.tooltip = s;
   }

   public void child(int frame, int id, int x, int y) {
      this.children[frame] = id;
      this.childX[frame] = x;
      this.childY[frame] = y;
   }

   public void totalChildren(int id, int x, int y) {
      this.children = new int[id];
      this.childX = new int[x];
      this.childY = new int[y];
   }

   public static void removeSomething(int id) {
      Widget widget = interfaceCache[id] = new Widget();
   }

   public static void Settings(RSFont[] wid) {
      Widget intSettings = AddTab(17890);
      intSettings.children = new int[10];
      intSettings.childX = new int[10];
      intSettings.childY = new int[10];
      intSettings.children[0] = 17891;
      intSettings.childX[0] = 4;
      intSettings.childY[0] = 16;
      intSettings.children[1] = 17892;
      intSettings.childX[1] = 117;
      intSettings.childY[1] = 52;
      AddInterfaceImage(17892, "Settings", "options.png");
      intSettings.children[2] = 17893;
      intSettings.childX[2] = 132;
      intSettings.childY[2] = 105;
      AddInterfaceButton(17893, 40, 40, "Toggle Roof-removal", "Settings", "roof off setting.png");
      intSettings.children[3] = 17894;
      intSettings.childX[3] = 331;
      intSettings.childY[3] = 59;
      AddInterfaceButton(17894, 21, 21, "Close", "Settings", "close.png");
      intSettings.children[4] = 17895;
      intSettings.childX[4] = 182;
      intSettings.childY[4] = 105;
      AddInterfaceButton(17895, 40, 40, "Tpgg;e x!0 Hits", "Settings", "x10 2.png");
      intSettings.children[5] = 17896;
      intSettings.childX[5] = 240;
      intSettings.childY[5] = 105;
      AddInterfaceButton(17896, 40, 40, "Toggle Hp Above head", "Settings", "hp.png");
      intSettings.children[6] = 17897;
      intSettings.childX[6] = 298;
      intSettings.childY[6] = 105;
      AddInterfaceButton(17897, 40, 40, "Toggle New Hp Bars", "Settings", "hp bar.png");
      intSettings.children[7] = 17898;
      intSettings.childX[7] = 132;
      intSettings.childY[7] = 176;
      AddInterfaceButton(17898, 54, 46, "Toggle Fixed Screen", "Settings", "2177_0.png");
      intSettings.children[8] = 17899;
      intSettings.childX[8] = 211;
      intSettings.childY[8] = 176;
      AddInterfaceButton(17899, 54, 46, "Toggle Resizable Screen", "Settings", "2178_0.png");
      intSettings.children[9] = 17900;
      intSettings.childX[9] = 289;
      intSettings.childY[9] = 176;
      AddInterfaceButton(17900, 54, 46, "Toggle Fullscreen", "Settings", "2179_0.png");
   }

   public static void addHover(int i, int aT, int cT, int hoverid, int sId, String NAME, int W, int H, String tip) {
      Widget hover = addInterface(i);
      hover.id = i;
      hover.parentID = i;
      hover.type = 5;
      hover.atActionType = aT;
      hover.contentType = cT;
      hover.hoverType = hoverid;
      hover.disabledSprite = LoadSprite(sId, NAME);
      hover.enabledSprite = LoadSprite(sId, NAME);
      hover.width = W;
      hover.height = H;
      hover.tooltip = tip;
   }

   public static void addHovered(int i, int j, String imageName, int w, int h, int IMAGEID) {
      Widget hover = addInterface(i);
      hover.parentID = i;
      hover.id = i;
      hover.type = 0;
      hover.atActionType = 0;
      hover.width = w;
      hover.height = h;
      hover.isMouseoverTriggered = true;
      hover.hoverType = -1;
      addSprite(IMAGEID, j, imageName);
      setChildren(1, hover);
      setBounds(IMAGEID, 0, 0, 0, hover);
   }

   private static Sprite LoadSprite(int i, String s) {
      long l = (TextClass.method585(s) << 8) + (long)i;
      Sprite Sprite = (Sprite)spriteCache.insertFromCache(l);
      if(Sprite != null) {
         return Sprite;
      } else {
         try {
            Sprite = new Sprite(s + " " + i);
            spriteCache.removeFromCache(Sprite, l);
            return Sprite;
         } catch (Exception var6) {
            return null;
         }
      }
   }

   public static void setChildren(int total, Widget i) {
      i.children = new int[total];
      i.childX = new int[total];
      i.childY = new int[total];
   }

   public static void setBounds(int ID, int X, int Y, int frame, Widget Widget) {
      Widget.children[frame] = ID;
      Widget.childX[frame] = X;
      Widget.childY[frame] = Y;
   }

   public static void addSprite(int id, int spriteId, String spriteName) {
      Widget tab = interfaceCache[id] = new Widget();
      tab.id = id;
      tab.parentID = id;
      tab.type = 5;
      tab.atActionType = 0;
      tab.contentType = 0;
      tab.opacity = 0;
      tab.hoverType = 52;
      tab.disabledSprite = imageLoader(spriteId, spriteName);
      tab.enabledSprite = imageLoader(spriteId, spriteName);
      tab.width = 512;
      tab.height = 334;
   }

   public static void magicTab(RSFont[] tda) {
      Widget tab = addTabInterface(1151);
      Widget homeHover = addTabInterface(1196);
      Widget spellButtons = interfaceCache[12424];
      spellButtons.scrollMax = 0;
      spellButtons.height = 260;
      spellButtons.width = 190;
      int[] spellButton = new int[]{1196, 1199, 1206, 1215, 1224, 1231, 1240, 1249, 1258, 1267, 1274, 1283, 1573,
  			1290, 1299, 1308, 1315, 1324, 1333, 1340, 1349, 1358, 1367, 1374, 1381, 1388,
  			1397, 1404, 1583, 12038, 1414, 1421, 1430, 1437, 1446, 1453, 1460, 1469, 15878,
  			1602, 1613, 1624, 7456, 1478, 1485, 1494, 1503, 1512, 1521, 1530, 1544, 1553,
  			1563, 1593, 1635, 12426, 12436, 12446, 12456, 6004, 18471};
      tab.totalChildren(63);
      tab.child(0, 12424, 13, 24);

      int homeLevel;
      for(homeLevel = 0; homeLevel < spellButton.length; ++homeLevel) {
         int var81 = homeLevel > 34?8:183;
         tab.child(1, 1195, 13, 24);
         tab.child(homeLevel + 2, spellButton[homeLevel], 5, var81);
         addButton(1195, 1, "Magic/Home", "Cast <col=65280>Home Teleport");
         Widget homeButton = interfaceCache[1195];
         homeButton.hoverType = 1196;
      }

      for(homeLevel = 0; homeLevel < spellButton.length; ++homeLevel) {
         if(homeLevel < 60) {
            spellButtons.childX[homeLevel] += 24;
         }

         if(homeLevel == 6 || homeLevel == 12 || homeLevel == 19 || homeLevel == 35 || homeLevel == 41 || homeLevel == 44 || homeLevel == 49 || homeLevel == 51) {
            spellButtons.childX[homeLevel] = 0;
         }

         spellButtons.childY[6] = 24;
         spellButtons.childY[12] = 48;
         spellButtons.childY[19] = 72;
         spellButtons.childY[49] = 96;
         spellButtons.childY[44] = 120;
         spellButtons.childY[51] = 144;
         spellButtons.childY[35] = 170;
         spellButtons.childY[41] = 192;
      }

      homeHover.isMouseoverTriggered = true;
      addText(1197, "Level 0: Home Teleport", tda, 1, 16685087, true, true);
      Widget var8 = interfaceCache[1197];
      var8.width = 174;
      var8.height = 68;
      addText(1198, "A teleport which requires no", tda, 0, 11495962, true, true);
      addText(18998, "runes and no required level that", tda, 0, 11495962, true, true);
      addText(18999, "teleports you to the main land.", tda, 0, 11495962, true, true);
      homeHover.totalChildren(4);
      homeHover.child(0, 1197, 3, 4);
      homeHover.child(1, 1198, 91, 23);
      homeHover.child(2, 18998, 91, 34);
      homeHover.child(3, 18999, 91, 45);
   }

   public static void addText(int id, String text, RSFont[] wid, int idx, int color) {
      Widget Tab = addTab(id);
      Tab.id = id;
      Tab.parentID = id;
      Tab.type = 4;
      Tab.atActionType = 0;
      Tab.width = 174;
      Tab.height = 11;
      Tab.contentType = 0;
      Tab.opacity = 0;
      Tab.hoverType = -1;
      Tab.centerText = false;
      Tab.textShadow = true;
      Tab.textDrawingAreas = wid[idx];
      Tab.message = text;
      Tab.secondaryText = "";
      Tab.textColor = color;
      Tab.secondaryColor = 0;
      Tab.defaultHoverColor = 0;
      Tab.secondaryHoverColor = 0;
   }

   public static Widget addTab(int id) {
      Widget Tab = interfaceCache[id] = new Widget();
      Tab.id = id;
      Tab.parentID = id;
      Tab.type = 0;
      Tab.atActionType = 0;
      Tab.contentType = 0;
      Tab.width = 512;
      Tab.height = 334;
      Tab.opacity = 0;
      Tab.hoverType = 0;
      return Tab;
   }

   public static void GodWars(RSFont[] RSFont) {
      Widget rsinterface = addInterface(16210);
      addText(16211, "Npc killcount", RSFont, 0, 16748608);
      addText(16212, "Armadyl kills", RSFont, 0, 16748608);
      addText(16213, "Bandos kills", RSFont, 0, 16748608);
      addText(16214, "Saradomin kills", RSFont, 0, 16748608);
      addText(16215, "Zamorak kills", RSFont, 0, 16748608);
      addText(16216, "", RSFont, 0, 6750207);
      addText(16217, "", RSFont, 0, 6750207);
      addText(16218, "", RSFont, 0, 6750207);
      addText(16219, "", RSFont, 0, 6750207);
      rsinterface.scrollMax = 0;
      rsinterface.children = new int[9];
      rsinterface.childX = new int[9];
      rsinterface.childY = new int[9];
      rsinterface.children[0] = 16211;
      rsinterface.childX[0] = 353;
      rsinterface.childY[0] = 7;
      rsinterface.children[1] = 16212;
      rsinterface.childX[1] = 353;
      rsinterface.childY[1] = 30;
      rsinterface.children[2] = 16213;
      rsinterface.childX[2] = 353;
      rsinterface.childY[2] = 44;
      rsinterface.children[3] = 16214;
      rsinterface.childX[3] = 353;
      rsinterface.childY[3] = 58;
      rsinterface.children[4] = 16215;
      rsinterface.childX[4] = 353;
      rsinterface.childY[4] = 73;
      rsinterface.children[5] = 16216;
      rsinterface.childX[5] = 468;
      rsinterface.childY[5] = 31;
      rsinterface.children[6] = 16217;
      rsinterface.childX[6] = 468;
      rsinterface.childY[6] = 45;
      rsinterface.children[7] = 16218;
      rsinterface.childX[7] = 468;
      rsinterface.childY[7] = 59;
      rsinterface.children[8] = 16219;
      rsinterface.childX[8] = 468;
      rsinterface.childY[8] = 74;
   }
   public static void unpack(StreamLoader interfaces, RSFont[] var271,  StreamLoader class44_1) {
      spriteCache = new MRUNodes(70000);
      Buffer stream = new Buffer(interfaces.readFile("data"));
      int defaultParentId = -1;
      int j = stream.readUShort();
      interfaceCache = new Widget[j + 80000];
      
      while(stream.currentOffset < stream.buffer.length) {
            int interfaceId = stream.readUShort();
            if(interfaceId == 65535) {
            	defaultParentId = stream.readUShort();
               interfaceId = stream.readUShort();
            }

            Widget widget = interfaceCache[interfaceId] = new Widget();
            widget.id = interfaceId;
            widget.parentID = defaultParentId;
            widget.type = stream.readUnsignedByte();
            widget.atActionType = stream.readUnsignedByte();
            widget.contentType = stream.readUShort();
            widget.width = stream.readUShort();
            widget.height = stream.readUShort();
            widget.opacity = (byte)stream.readUnsignedByte();
            widget.hoverType = stream.readUnsignedByte();
            if(widget.hoverType != 0)
               widget.hoverType = (widget.hoverType - 1 << 8) + stream.readUnsignedByte();
             else 
               widget.hoverType = -1;

            int operators = stream.readUnsignedByte();
            if(operators > 0) {
               widget.anIntArray245 = new int[operators];
               widget.anIntArray212 = new int[operators];

               for(int index = 0; index < operators; ++index) {
                  widget.anIntArray245[index] = stream.readUnsignedByte();
                  widget.anIntArray212[index] = stream.readUShort();
               }
            }

            int scripts = stream.readUnsignedByte();
            if(scripts > 0) {
               widget.valueIndexArray = new int[scripts][];
               for(int script = 0; script < scripts; ++script) {
                  int instructions = stream.readUShort();
                  widget.valueIndexArray[script] = new int[instructions];
                  for(int instruction = 0; instruction < instructions; ++instruction)
                     widget.valueIndexArray[script][instruction] = stream.readUShort();
               }
            }

            if(widget.type == 0) {
               widget.drawsTransparent = false;
               widget.scrollMax = stream.readUShort();
               widget.isMouseoverTriggered = stream.readUnsignedByte() == 1;
               int i3 = stream.readUShort();
               widget.children = new int[i3];
               widget.childX = new int[i3];
               widget.childY = new int[i3];

               for(int k4 = 0; k4 < i3; ++k4) {
                  widget.children[k4] = stream.readUShort();
                  widget.childX[k4] = stream.readSignedWord();
                  widget.childY[k4] = stream.readSignedWord();
               }
            }

            if(widget.type == 1) {
              stream.readUShort();
              stream.readUnsignedByte();
            }

            String var151;
            if(widget.type == 2) {
               widget.inventoryItemId = new int[widget.width * widget.height];
               widget.inventoryAmounts = new int[widget.width * widget.height];
               widget.allowSwapItems = stream.readUnsignedByte() == 1;
               widget.hasActions = stream.readUnsignedByte() == 1;
               widget.usableItems = stream.readUnsignedByte() == 1;
               widget.replaceItems = stream.readUnsignedByte() == 1;
               widget.spritePaddingX = stream.readUnsignedByte();
               widget.spritePaddingY = stream.readUnsignedByte();
               widget.spritesX = new int[20];
               widget.spritesY = new int[20];
               widget.sprites = new Sprite[20];

               for(int i3 = 0; i3 < 20; ++i3) {
                  int k4 = stream.readUnsignedByte();
                  if(k4 == 1) {
                     widget.spritesX[i3] = stream.method411();
                     widget.spritesY[i3] = stream.method411();
                     var151 = stream.method415();
                     if(class44_1 != null && var151.length() > 0) {
                    	 int i5 = var151.lastIndexOf(",");
                    	 if(var151.substring(0, i5).toLowerCase().equals("mige")){
                    	 	int id = Integer.parseInt(var151.substring(i5 + 1));
                    	 	widget.sprites[i3] = Main.cacheSprite474[id];
                    	 } else
                    	 widget.sprites[i3] = method207(Integer.parseInt(var151.substring(i5 + 1)), class44_1, var151.substring(0, i5));
                     }
                  }
               }

               widget.actions = new String[6];

               for(int i3 = 0; i3 < 5; ++i3) {
                  widget.actions[i3] = stream.method415();
                  if(widget.actions[i3].length() == 0) {
                     widget.actions[i3] = null;
                  }
                  if(widget.parentID == 1644) {
                      widget.actions[2] = "Operate";
                   }

                   if(widget.parentID == 3824) {
                      widget.actions[4] = "Buy X";
                    }
                   if(widget.parentID == 3822) {
                       widget.actions[4] = "Sell X";
                  
                    }

               }
            }

            if(widget.type == 3) {
               widget.filled = stream.readUnsignedByte() == 1;
            }

            if(widget.type == 4 || widget.type == 1) {
               widget.centerText = stream.readUnsignedByte() == 1;
               int i3 = stream.readUnsignedByte();
               if(var271 != null) {
                  widget.textDrawingAreas = var271[i3];
               }

               widget.textShadow = stream.readUnsignedByte() == 1;
            }

            if(widget.type == 4) {
               widget.message = stream.method415().replaceAll("RuneScape", "Ghreborn");
               widget.secondaryText = stream.method415();
            }

            if(widget.type == 1 || widget.type == 3 || widget.type == 4) {
               widget.textColor = stream.readInt();
            }

            if(widget.type == 3 || widget.type == 4) {
               widget.secondaryColor = stream.readInt();
               widget.defaultHoverColor = stream.readInt();
               widget.secondaryHoverColor = stream.readInt();
            }

            if(widget.type == 5) {
               widget.drawsTransparent = false;
               var151 = stream.method415();
               if(class44_1 != null && var151.length() > 0) {
                  int k4 = var151.lastIndexOf(",");
          		if(var151.substring(0, k4).toLowerCase().equals("mige")){
        			int id = Integer.parseInt(var151.substring(k4 + 1));
        			widget.disabledSprite = Main.cacheSprite474[id];
        		} else
                  widget.disabledSprite = method207(Integer.parseInt(var151.substring(k4 + 1)), class44_1, var151.substring(0, k4));
               }

               var151 = stream.method415();
               if(class44_1 != null && var151.length() > 0) {
                  int k4 = var151.lastIndexOf(",");
                  if(var151.substring(0, k4).toLowerCase().equals("mige")){
          			int id = Integer.parseInt(var151.substring(k4 + 1));
        			widget.enabledSprite = Main.cacheSprite474[id];
                  }else{
                  widget.enabledSprite = method207(Integer.parseInt(var151.substring(k4 + 1)),  class44_1, var151.substring(0, k4));
               }
               }
            }

            if(widget.type == 6) {
               int i3 = stream.readUnsignedByte();
               if(i3 != 0) {
                  widget.anInt233 = 1;
                  widget.anInt234 = (i3 - 1 << 8) + stream.readUnsignedByte();
               }

               i3 = stream.readUnsignedByte();
               if(i3 != 0) {
                  widget.anInt255 = 1;
                  widget.anInt256 = (i3 - 1 << 8) + stream.readUnsignedByte();
               }

               i3 = stream.readUnsignedByte();
               if(i3 != 0) {
                  widget.anInt257 = (i3 - 1 << 8) + stream.readUnsignedByte();
               } else {
                  widget.anInt257 = -1;
               }

               i3 = stream.readUnsignedByte();
               if(i3 != 0) {
                  widget.anInt258 = (i3 - 1 << 8) + stream.readUnsignedByte();
               } else {
                  widget.anInt258 = -1;
               }

               widget.modelZoom = stream.readUShort();
               widget.modelRotation1 = stream.readUShort();
               widget.modelRotation2 = stream.readUShort();
            }

            if(widget.type == 7) {
               widget.inventoryItemId = new int[widget.width * widget.height];
               widget.inventoryAmounts = new int[widget.width * widget.height];
               widget.centerText = stream.readUnsignedByte() == 1;
               int i3 = stream.readUnsignedByte();
               if(var271 != null) {
                  widget.textDrawingAreas = var271[i3];
               }

               widget.textShadow = stream.readUnsignedByte() == 1;
               widget.textColor = stream.readInt();
               widget.spritePaddingX = stream.method411();
               widget.spritePaddingY = stream.method411();
               widget.hasActions = stream.readUnsignedByte() == 1;
               widget.actions = new String[6];

               for(int k4 = 0; k4 < 5; ++k4) {
                  widget.actions[k4] = stream.method415();
                  if(widget.actions[k4].length() == 0) {
                     widget.actions[k4] = null;
                  }
               }
            }

            if(widget.atActionType == 2 || widget.type == 2) {
               widget.selectedActionName = stream.method415();
               widget.spellName = stream.method415();
               widget.spellUsableOn = stream.readUShort();
            }

            if(widget.type == 8) {
               widget.message = stream.method415();
            }
         if(widget.atActionType == 1 || widget.atActionType == 4 || widget.atActionType == 5 || widget.atActionType == 6){

         widget.tooltip = stream.method415();
         if(widget.tooltip.length() == 0) {
            if(widget.atActionType == 1)
               widget.tooltip = "Ok";
            if(widget.atActionType == 4)
               widget.tooltip = "Select"; 
            if(widget.atActionType == 5)
               widget.tooltip = "Select";
            if(widget.atActionType == 6) 
               widget.tooltip = "Continue";
         }
         }
			if (widget.parentID == 6412) {
				if (widget.scrollMax > 0) {
					widget.scrollMax = 300;
				}
			}
      }
	   aClass44 = interfaces;
	    GodWars(var271);
	    skills();
	    Skillsdata(aClass44, var271);
	    wrenchTab(var271);
		configureLunar(var271);
		constructLunar();
	    GrandExchange.initializeInterfaces(var271);
	    //skilllevel(textDrawingAreas);
	    magicTab(var271);
	    equipmentScreen(var271);
	   // Buy(textDrawingAreas);
	   // plank.Unpack(textDrawingAreas);
	    //houseoptions.Unpack(textDrawingAreas);
	    //Sell(textDrawingAreas);
	    //BuyandSell(textDrawingAreas);
	    //Exchange.Unpack(textDrawingAreas);
	    skotizo(var271);
	    //collectSell(textDrawingAreas);
	    //collectBuy(textDrawingAreas);
	    lootingBag(var271);
	    //ancients(var271);
	    prayerBook(var271);
		runepouch(var271);
		barrowText(var271);
		Pestpanel(var271);
		Pestpanel2(var271);
		//addPestControlRewardWidget(textDrawingAreas);
	    clanChatTab(var271);
	    clanChatSetup(var271);
	    Sidebar0(var271);
	    OsDropViewer(var271);
	    bank(var271);
	    Teleports(var271);
	    quickPrayers(var271);
	    tradeUIAddon(var271);
	    ListInterface.Unpack(var271);
	    MainTeleInterface.Unpack(var271);
	    SkillingTeleInterface.Unpack(var271);
	    shopInterface.shopInterface(var271);
	    staffTab.staffTab(var271);
	    equipmentTab(var271);
	    //signpost.signpost(textDrawingAreas);
	    skillGuide(var271);
	    priceChecker.Unpack(var271);
	    advancedOptions(var271);
	    slayerInterface.Unpack(var271);
	    slayerInterface.Unpack2(var271);
	    slayerInterface.Unpack3(var271);
	    itemsKeptOnDeath(var271);
	    itemsOnDeathDATA(var271);
	    itemsOnDeath(var271);
	    questTab(var271);
	    mysteryBox(var271);
	    skillInterface(var271);
	    barrowsKillcount(var271);
	    //achievements(var271);
	    //achievementPopup2(var271);
	   spriteCache = null;
          }
	public static void wrathRune() {
		Widget rune = addTabInterface(28226);
		rune.totalChildren(1);
		addSprite(28228, 0, "Magic/wrath");
		setBounds(28228, 0, 0, 0, rune);
	}	
	private static void barrowsKillcount(RSFont[] tda) {
		Widget barrow = addInterface(27500);
		addText(27501, "Brothers", tda, 2, 0xFD851A, true, true);
		addText(27502, "Ahrim", tda, 0, 0xFD851A, true, true);
		addText(27503, "Dharok", tda, 0, 0xFD851A, true, true);
		addText(27504, "Guthan", tda, 0, 0xFD851A, true, true);
		addText(27505, "Karil", tda, 0, 0xFD851A, true, true);
		addText(27506, "Torag", tda, 0, 0xFD851A, true, true);
		addText(27507, "Verac", tda, 0, 0xFD851A, true, true);
		addText(27508, "Killcount", tda, 2, 0xFD851A, true, true);
		addText(27509, "0", tda, 0, 0xFD851A, true, true);
		setChildren(9, barrow);
		setBounds(27501, 470, 42, 0, barrow);
		for (int index = 1; index < 7; index++)
			setBounds(27501 + index, 470, 45 + index * 14, index, barrow);
		setBounds(27508, 470, 15, 7, barrow);
		setBounds(27509, 470, 30, 8, barrow);
	}

/*	public static void addSpellSmall2(int ID, int r1, int r2, int r3, int ra1, int ra2, int ra3, int rune1,
			int rune2, int rune3, int lvl, String name, String descr, RSFont[] TDA, int sid, int suo, int type) {
		Widget rsInterface = addInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 5;
		rsInterface.atActionType = type;
		rsInterface.contentType = 0;
		rsInterface.mOverInterToTrigger = ID + 1;
		rsInterface.spellUsableOn = suo;
		rsInterface.selectedActionName = "Cast on";
		rsInterface.width = 20;
		rsInterface.height = 20;
		rsInterface.tooltip = "Cast @gre@" + name;
		rsInterface.spellName = name;
		rsInterface.anIntArray245 = new int[4];
		rsInterface.anIntArray212 = new int[4];
		rsInterface.anIntArray245[0] = 3;
		rsInterface.anIntArray212[0] = ra1;
		rsInterface.anIntArray245[1] = 3;
		rsInterface.anIntArray212[1] = ra2;
		rsInterface.anIntArray245[2] = 3;
		rsInterface.anIntArray212[2] = ra3;
		rsInterface.anIntArray245[3] = 3;
		rsInterface.anIntArray212[3] = lvl;
		rsInterface.valueIndexArray = new int[4][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[4];
		rsInterface.valueIndexArray[1][0] = 4;
		rsInterface.valueIndexArray[1][1] = 3214;
		rsInterface.valueIndexArray[1][2] = r2;
		rsInterface.valueIndexArray[1][3] = 0;
		rsInterface.valueIndexArray[2] = new int[4];
		rsInterface.valueIndexArray[2][0] = 4;
		rsInterface.valueIndexArray[2][1] = 3214;
		rsInterface.valueIndexArray[2][2] = r3;
		rsInterface.valueIndexArray[2][3] = 0;
		rsInterface.valueIndexArray[3] = new int[3];
		rsInterface.valueIndexArray[3][0] = 1;
		rsInterface.valueIndexArray[3][1] = 6;
		rsInterface.valueIndexArray[3][2] = 0;
		rsInterface.sprite1 = new Sprite("magic/spell " + sid);
		rsInterface.sprite2 = new Sprite("magic/spell " + (sid + 1));
		Widget INT = addInterface(ID + 1);
		INT.isMouseoverTriggered = true;
		INT.mOverInterToTrigger = -1;
		setChildren(9, INT);
		addLunarSprite(ID + 2, 0, "BOX");
		setBounds(ID + 2, 0, 0, 0, INT);
		addText(ID + 3, "Level " + (lvl + 1) + ": " + name, 0xFF981F, true, true, 52, TDA, 1);
		setBounds(ID + 3, 90, 4, 1, INT);
		addText(ID + 4, descr, 0xAF6A1A, true, true, 52, TDA, 0);
		setBounds(ID + 4, 90, 19, 2, INT);
		setBounds(rune1, 14, 35, 3, INT);
		setBounds(rune2, 74, 35, 4, INT);
		setBounds(rune3, 130, 35, 5, INT);
		addRuneText(ID + 5, ra1, r1, TDA);
		setBounds(ID + 5, 26, 66, 6, INT);
		addRuneText(ID + 6, ra2, r2, TDA);
		setBounds(ID + 6, 87, 66, 7, INT);
		addRuneText(ID + 7, ra3, r3, TDA);
		setBounds(ID + 7, 142, 66, 8, INT);
	}
	
	public static void addSpellSmall(int ID, int r1, int r2, int r3, int ra1, int ra2, int ra3, int rune1,
			int rune2, int rune3, int lvl, String name, String descr, RSFont[] TDA, int sid, int suo, int type) {
		Widget rsInterface = addInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 5;
		rsInterface.atActionType = type;
		rsInterface.contentType = 0;
		rsInterface.hoverType = ID + 1;
		rsInterface.spellUsableOn = suo;
		rsInterface.selectedActionName = "Cast on";
		rsInterface.width = 20;
		rsInterface.height = 20;
		rsInterface.tooltip = "Cast @gre@" + name;
		rsInterface.spellName = name;
		rsInterface.anIntArray245 = new int[4];
		rsInterface.anIntArray212 = new int[4];
		rsInterface.anIntArray245[0] = 3;
		rsInterface.anIntArray212[0] = ra1;
		rsInterface.anIntArray245[1] = 3;
		rsInterface.anIntArray212[1] = ra2;
		rsInterface.anIntArray245[2] = 3;
		rsInterface.anIntArray212[2] = ra3;
		rsInterface.anIntArray245[3] = 3;
		rsInterface.anIntArray212[3] = lvl;
		rsInterface.valueIndexArray = new int[4][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[4];
		rsInterface.valueIndexArray[1][0] = 4;
		rsInterface.valueIndexArray[1][1] = 3214;
		rsInterface.valueIndexArray[1][2] = r2;
		rsInterface.valueIndexArray[1][3] = 0;
		rsInterface.valueIndexArray[2] = new int[4];
		rsInterface.valueIndexArray[2][0] = 4;
		rsInterface.valueIndexArray[2][1] = 3214;
		rsInterface.valueIndexArray[2][2] = r3;
		rsInterface.valueIndexArray[2][3] = 0;
		rsInterface.valueIndexArray[3] = new int[3];
		rsInterface.valueIndexArray[3][0] = 1;
		rsInterface.valueIndexArray[3][1] = 6;
		rsInterface.valueIndexArray[3][2] = 0;
		rsInterface.sprite1 = new Sprite("magic/spell " + sid); //Client.cacheSprite2[sid];
		rsInterface.sprite2 = new Sprite("magic/spell " + (sid + 1)); //Client.cacheSprite2[sid];
		Widget INT = addInterface(ID + 1);
		INT.isMouseoverTriggered = true;
		INT.mOverInterToTrigger = -1;
		setChildren(9, INT);
		addLunarSprite(ID + 2, 0, "BOX");
		setBounds(ID + 2, 0, 0, 0, INT);
		addText(ID + 3, "Level " + (lvl + 1) + ": " + name, 0xFF981F, true, true, 52, TDA, 1);
		setBounds(ID + 3, 90, 4, 1, INT);
		addText(ID + 4, descr, 0xAF6A1A, true, true, 52, TDA, 0);
		setBounds(ID + 4, 90, 19, 2, INT);
		setBounds(rune1, 14, 35, 3, INT);
		setBounds(rune2, 74, 35, 4, INT);
		setBounds(rune3, 130, 35, 5, INT);
		addRuneText(ID + 5, ra1, r1, TDA);
		setBounds(ID + 5, 26, 66, 6, INT);
		addRuneText(ID + 6, ra2, r2, TDA);
		setBounds(ID + 6, 87, 66, 7, INT);
		addRuneText(ID + 7, ra3, r3, TDA);
		setBounds(ID + 7, 145, 66, 8, INT);
	}
	
	public static void addSpellSmaller(int ID, int r1, int r2, int ra1, int ra2, int rune1,
			int rune2, int lvl, String name, String descr, RSFont[] TDA, int sid, int suo, int type) {
		Widget rsInterface = addInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 5;
		rsInterface.atActionType = type;
		rsInterface.contentType = 0;
		rsInterface.hoverType = ID + 1;
		rsInterface.spellUsableOn = suo;
		rsInterface.selectedActionName = "Cast on";
		rsInterface.width = 20;
		rsInterface.height = 20;
		rsInterface.tooltip = "Cast @gre@" + name;
		rsInterface.spellName = name;
		rsInterface.anIntArray245 = new int[3];
		rsInterface.anIntArray212 = new int[3];
		rsInterface.anIntArray245[0] = 3;
		rsInterface.anIntArray212[0] = ra1;
		rsInterface.anIntArray245[1] = 3;
		rsInterface.anIntArray212[1] = ra2;
		rsInterface.anIntArray245[2] = 3;
		rsInterface.anIntArray212[2] = lvl;
		rsInterface.valueIndexArray = new int[3][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[4];
		rsInterface.valueIndexArray[1][0] = 4;
		rsInterface.valueIndexArray[1][1] = 3214;
		rsInterface.valueIndexArray[1][2] = r2;
		rsInterface.valueIndexArray[1][3] = 0;
		rsInterface.valueIndexArray[2] = new int[3];
		rsInterface.valueIndexArray[2][0] = 1;
		rsInterface.valueIndexArray[2][1] = 6;
		rsInterface.valueIndexArray[2][2] = 0;
		rsInterface.sprite1 = new Sprite("magic/spell " + sid); //Client.cacheSprite2[sid];
		rsInterface.sprite2 = new Sprite("magic/spell " + (sid + 1)); //Client.cacheSprite2[sid];
		Widget INT = addInterface(ID + 1);
		INT.isMouseoverTriggered = true;
		INT.mOverInterToTrigger = -1;
		setChildren(7, INT);
		addLunarSprite(ID + 2, 0, "BOX");
		setBounds(ID + 2, 0, 0, 0, INT);
		addText(ID + 3, "Level " + (lvl + 1) + ": " + name, 0xFF981F, true, true, 52, TDA, 1);
		setBounds(ID + 3, 90, 4, 1, INT);
		addText(ID + 4, descr, 0xAF6A1A, true, true, 52, TDA, 0);
		setBounds(ID + 4, 90, 19, 2, INT);
		setBounds(rune1, 40, 35, 3, INT);
		setBounds(rune2, 110, 35, 4, INT);
		addRuneText(ID + 5, ra1, r1, TDA);
		setBounds(ID + 5, 53, 66, 5, INT);
		addRuneText(ID + 6, ra2, r2, TDA);
		setBounds(ID + 6, 124, 66, 6, INT);
	}

	public static void normals(RSFont[] tda) {
		Widget p = addTabInterface(938);
		Widget rsinterface = interfaceCache[1151];
		Widget rsinterface2 = interfaceCache[12424];
		rsinterface2.height = 250;
		for (int i = 57; i < 58; i++) {
			
			// earth wave
			rsinterface2.childX[36] = 96;
			rsinterface2.childY[36] = 168;
			
			// enfeeble
			rsinterface2.childX[46] = 120;
			rsinterface2.childY[46] = 168;
			
			// teleother lumbridge
			rsinterface2.childX[53] = 144;
			rsinterface2.childY[53] = 168;
			
			// fire wave
			rsinterface2.childX[37] = 1;
			rsinterface2.childY[37] = 192;
			
			// entangle
			rsinterface2.childX[50] = 23;
			rsinterface2.childY[50] = 192;
			
			// stun
			rsinterface2.childX[47] = 47;
			rsinterface2.childY[47] = 193;
			
			// charge
			rsinterface2.childX[41] = 71;
			rsinterface2.childY[41] = 192;
			
			// teleother falador
			rsinterface2.childX[54] = 120;
			rsinterface2.childY[54] = 192;
			
			// teleblock
			rsinterface2.childX[55] = 0;
			rsinterface2.childY[55] = 218;
			
			// lvl-6 enchant
			rsinterface2.childX[57] = 47;
			rsinterface2.childY[57] = 218;
			
			// teleother camelot
			rsinterface2.childX[56] = 71;
			rsinterface2.childY[56] = 218;
		}
		rsinterface.childY[1] = 12;
		rsinterface.childX[1] = 14;
		addSpellSmall2_3(31674 + 975, 563, 566, 555, 554, 2, 2, 4, 5, 30012, 30015, 30004, 30003, 68, "Teleport to Kourend",
				"Teleports you to Kourend", tda, 10, 7, 5);
		addSpellLarge2(13674 + 975, 563, 560, 562, 1, 1, 1, 30012, 30009, 30011, 84, "Teleport to Bounty\\nTarget",
				"Teleports you near your Bounty\\nHunter Target", tda, 8, 7, 5);

		addSpellSmall2(22674 + 975, 565, 566, 564, 20, 20, 1, 30014, 30015, 30013, 92, "Lvl-7 Enchant",
				"For use on zenyte jewellery", tda, 12, 8, 5);
		
		addSpellSmaller(22644 + 975, 556, 21880, 7, 1, 30005, 28226, 80, "Wind Surge",
				"A very high level Air missile", tda, 0, 10, 2);
		
		addSpellSmall(22658 + 975, 555, 556, 21880, 10, 7, 1, 30004, 30005, 28226, 84, "Water Surge",
				"A very high level Water missile", tda, 2, 10, 2);
		
		addSpellSmall(22628 + 975, 557, 556, 21880, 10, 7, 1, 30006, 30005, 28226, 89, "Earth Surge",
				"A very high level Earth missile", tda, 4, 10, 2);
		
		addSpellSmall(22608 + 975, 554, 556, 21880, 10, 7, 1, 30003, 30005, 28226, 94, "Fire Surge",
				"A very high level Fire missile", tda, 6, 10, 2);
		
		setChildren(15, p);
		setBounds(31674 + 975, 84, 178, 0, p);
		setBounds(13674 + 975, 35, 228, 1, p);
		setBounds(22674 + 975, 132, 227, 2, p);
		setBounds(22644 + 975, 108, 202, 3, p);
		setBounds(22658 + 975, 156, 202, 4, p);
		setBounds(22628 + 975, 108, 227, 5, p);
		setBounds(22608 + 975, 156, 227, 6, p);
		setBounds(1151, 0, 0, 7, p);
		setBounds(22609 + 975, 5, 5, 8, p);
		setBounds(22629 + 975, 5, 5, 9, p);
		setBounds(22659 + 975, 5, 5, 10, p);
		setBounds(22645 + 975, 5, 5, 11, p);
		setBounds(31675 + 975, 5, 5, 12, p);
		setBounds(13675 + 975, 5, 5, 13, p);
		setBounds(22675 + 975, 5, 5, 14, p);
	}*/
   public static void skillInterface(RSFont[] wid) {
      Widget Interface = addTab(3917);
      boolean index = false;
      skillInterface(19746, 255);
      skillInterface(19749, 52);
      addText(29801, "", wid, 0, 16772659);
      addText(29800, "", wid, 0, 16772659);
      addButton(19747, 51, 27700, "Interfaces/Skill/Skill", 62, 32, "View @lre@Hunter @whi@Guide", 1);
      addButton(19748, 50, 27701, "Interfaces/Skill/Skill", 62, 32, "View @lre@Construction @whi@Guide", 1);
      addText(13984, "Totalll", wid, 0, 16772659);
      addText(3985, "", wid, 0, 16772659);
      addText(13983, "", wid, 0, 16772659, true, true);

      for(int rsinterface = 0; rsinterface < boxIds.length; ++rsinterface) {
         skillInterface(boxIds[rsinterface], 256);
      }

      Widget var4 = addTab(3917);
      var4.children = new int[63];
      var4.childX = new int[63];
      var4.childY = new int[63];
      var4.children[0] = 3918;
      var4.childX[0] = 0;
      var4.childY[0] = 0;
      var4.children[1] = 3925;
      var4.childX[1] = 0;
      var4.childY[1] = 31;
      var4.children[2] = 3932;
      var4.childX[2] = 0;
      var4.childY[2] = 62;
      var4.children[3] = 3939;
      var4.childX[3] = 0;
      var4.childY[3] = 93;
      var4.children[4] = 3946;
      var4.childX[4] = 0;
      var4.childY[4] = 124;
      var4.children[5] = 3953;
      var4.childX[5] = 0;
      var4.childY[5] = 155;
      var4.children[6] = 4148;
      var4.childX[6] = 0;
      var4.childY[6] = 186;
      var4.children[7] = 19746;
      var4.childX[7] = 70;
      var4.childY[7] = 69;
      var4.children[8] = 19748;
      var4.childX[8] = 1;
      var4.childY[8] = 219;
      var4.children[9] = 19747;
      var4.childX[9] = 64;
      var4.childY[9] = 219;
      var4.children[10] = 14000;
      var4.childX[10] = 10;
      var4.childY[10] = 219;
      var4.children[11] = 19749;
      var4.childX[11] = 128;
      var4.childY[11] = 220;
      var4.children[12] = 13983;
      var4.childX[12] = 158;
      var4.childY[12] = 238;
      var4.children[13] = 3984;
      var4.childX[13] = 300;
      var4.childY[13] = 225;
      var4.children[14] = 3985;
      var4.childX[14] = 130;
      var4.childY[14] = 238;
      var4.children[15] = 29800;
      var4.childX[15] = 98;
      var4.childY[15] = 220;
      var4.children[16] = 29800;
      var4.childX[16] = 107;
      var4.childY[16] = 235;
      var4.children[17] = 29801;
      var4.childX[17] = 36;
      var4.childY[17] = 220;
      var4.children[18] = 29801;
      var4.childX[18] = 45;
      var4.childY[18] = 235;
      var4.children[19] = 4040;
      var4.childX[19] = 5;
      var4.childY[19] = 20;
      var4.children[20] = 8654;
      var4.childX[20] = 0;
      var4.childY[20] = 2;
      var4.children[21] = 8655;
      var4.childX[21] = 64;
      var4.childY[21] = 2;
      var4.children[22] = 4076;
      var4.childX[22] = 20;
      var4.childY[22] = 20;
      var4.children[23] = 8656;
      var4.childX[23] = 128;
      var4.childY[23] = 2;
      var4.children[24] = 4112;
      var4.childX[24] = 20;
      var4.childY[24] = 20;
      var4.children[25] = 8657;
      var4.childX[25] = 0;
      var4.childY[25] = 33;
      var4.children[26] = 4046;
      var4.childX[26] = 20;
      var4.childY[26] = 50;
      var4.children[27] = 8658;
      var4.childX[27] = 64;
      var4.childY[27] = 33;
      var4.children[28] = 4082;
      var4.childX[28] = 20;
      var4.childY[28] = 50;
      var4.children[29] = 8659;
      var4.childX[29] = 128;
      var4.childY[29] = 33;
      var4.children[30] = 4118;
      var4.childX[30] = 20;
      var4.childY[30] = 50;
      var4.children[31] = 8660;
      var4.childX[31] = 0;
      var4.childY[31] = 70;
      var4.children[32] = 4052;
      var4.childX[32] = 20;
      var4.childY[32] = 83;
      var4.children[33] = 8661;
      var4.childX[33] = 65;
      var4.childY[33] = 70;
      var4.children[34] = 4088;
      var4.childX[34] = 20;
      var4.childY[34] = 83;
      var4.children[35] = 8662;
      var4.childX[35] = 130;
      var4.childY[35] = 70;
      var4.children[36] = 4124;
      var4.childX[36] = 20;
      var4.childY[36] = 83;
      var4.children[37] = 8663;
      var4.childX[37] = 0;
      var4.childY[37] = 100;
      var4.children[38] = 4058;
      var4.childX[38] = 20;
      var4.childY[38] = 120;
      var4.children[39] = 8664;
      var4.childX[39] = 65;
      var4.childY[39] = 100;
      var4.children[40] = 4094;
      var4.childX[40] = 20;
      var4.childY[40] = 120;
      var4.children[41] = 8665;
      var4.childX[41] = 130;
      var4.childY[41] = 100;
      var4.children[42] = 4130;
      var4.childX[42] = 20;
      var4.childY[42] = 120;
      var4.children[43] = 8666;
      var4.childX[43] = 0;
      var4.childY[43] = 130;
      var4.children[44] = 4064;
      var4.childX[44] = 20;
      var4.childY[44] = 150;
      var4.children[45] = 8667;
      var4.childX[45] = 65;
      var4.childY[45] = 130;
      var4.children[46] = 4100;
      var4.childX[46] = 20;
      var4.childY[46] = 150;
      var4.children[47] = 8668;
      var4.childX[47] = 130;
      var4.childY[47] = 130;
      var4.children[48] = 4136;
      var4.childX[48] = 20;
      var4.childY[48] = 150;
      var4.children[49] = 8669;
      var4.childX[49] = 0;
      var4.childY[49] = 160;
      var4.children[50] = 4070;
      var4.childX[50] = 20;
      var4.childY[50] = 180;
      var4.children[51] = 8670;
      var4.childX[51] = 65;
      var4.childY[51] = 160;
      var4.children[52] = 4106;
      var4.childX[52] = 20;
      var4.childY[52] = 180;
      var4.children[53] = 8671;
      var4.childX[53] = 130;
      var4.childY[53] = 160;
      var4.children[54] = 4142;
      var4.childX[54] = 20;
      var4.childY[54] = 180;
      var4.children[55] = 8672;
      var4.childX[55] = 0;
      var4.childY[55] = 190;
      var4.children[56] = 4160;
      var4.childX[56] = 20;
      var4.childY[56] = 150;
      var4.children[57] = 4160;
      var4.childX[57] = 20;
      var4.childY[57] = 150;
      var4.children[58] = 12162;
      var4.childX[58] = 65;
      var4.childY[58] = 190;
      var4.children[59] = 2832;
      var4.childX[59] = 20;
      var4.childY[59] = 150;
      var4.children[60] = 13928;
      var4.childX[60] = 130;
      var4.childY[60] = 190;
      var4.children[61] = 13917;
      var4.childX[61] = 20;
      var4.childY[61] = 150;
      var4.children[62] = 13984;
      var4.childX[62] = 145;
      var4.childY[62] = 225;
   }

   public static void addButton(int i, int j, int hoverId, String name, int W, int H, String S, int AT) {
      Widget Widget = addInterface(i);
      Widget.id = i;
      Widget.parentID = i;
      Widget.type = 5;
      Widget.atActionType = AT;
      Widget.opacity = 0;
      Widget.hoverType = hoverId;
      Widget.disabledSprite = imageLoader(j, name);
      Widget.enabledSprite = imageLoader(j, name);
      Widget.width = W;
      Widget.height = H;
      Widget.tooltip = S;
   }

   public static void skillInterface(int i, int j) {
      Widget Tab = interfaceCache[i] = new Widget();
      Tab.id = i;
      Tab.parentID = i;
      Tab.type = 5;
      Tab.atActionType = 0;
      Tab.contentType = 0;
      Tab.width = 26;
      Tab.height = 34;
      Tab.opacity = 0;
      Tab.hoverType = 0;
      Tab.disabledSprite = imageLoader(j, "Interfaces/Skill/Skill");
      Tab.enabledSprite = imageLoader(j, "Interfaces/Skill/Skill");
   }

   public static void SetContextOptions(int ID, String[] options) {
      if(interfaceCache[ID] != null) {
         String[] real = new String[5];

         for(int i = 0; i < 5; ++i) {
            real[i] = i < options.length?options[i]:null;
         }

         interfaceCache[ID].actions = real;
      }

   }

   private Model method206(int i, int j) {
      Model model = (Model)aClass12_264.insertFromCache((long)((i << 16) + j));
      if(model != null) {
         return model;
      } else {
         if(i == 1) {
            model = Model.getModel(j);
         }

         if(i == 2) {
            model = NpcDefinition.lookup(j).method160(true);
         }

         if(i == 3) {
            model = Main.myPlayer.method453();
         }

         if(i == 4) {
            model = ItemDefinition.lookup(j).method202(50, true);
         }

         if(i == 5) {
            model = null;
         }

         if(model != null) {
            aClass12_264.removeFromCache(model, (long)((i << 16) + j));
         }

         return model;
      }
   }

   private static Sprite method207(int i, StreamLoader class44, String s) {
      long l = (TextClass.method585(s) << 8) + (long)i;

         Sprite Sprite = (Sprite)spriteCache.insertFromCache(l);
         if(Sprite != null) {
            return Sprite;
         } else {
            try {
               Sprite = new Sprite(class44, s, i);
               spriteCache.removeFromCache(Sprite, l);
               return Sprite;
            } catch (Exception var8) {
               return null;
            }
         }
      }
   
   public static void addtextwithsize(int id, String text, RSFont[] tda, int idx, int color, boolean center, boolean shadow, int width, int height) {
	      Widget tab = AddTab(id);
	      tab.parentID = id;
	      tab.id = id;
	      tab.type = 4;
	      tab.atActionType = 0;
	      tab.width = width;
	      tab.height = height;
	      tab.contentType = 0;
	      tab.opacity = 0;
	      tab.hoverType = -1;
	      tab.centerText = center;
	      tab.textShadow = shadow;
	      tab.textDrawingAreas = tda[idx];
	      tab.message = text;
	      tab.secondaryText = "";
	      tab.textColor = color;
	      tab.secondaryColor = 0;
	      tab.defaultHoverColor = 0;
	   }
public static void AddInterfaceModelClickable(int ID, int mId, int modelZoom, int modelRT, int modelRT2,String text, String tooltip, int w, int h) {
	      Widget Tab = AddTab(ID);
	      Tab.id = ID;
	      Tab.parentID = ID;
	      Tab.type = 6;
	      Tab.atActionType = 1;
	      Tab.anInt233 = 1;
	      Tab.contentType = 0;
Tab.message = text;
Tab.tooltip = tooltip;
	      Tab.width = w;
	      Tab.height = h;
	      Tab.opacity = 0;
	      Tab.hoverType = -1;
	      Tab.anInt234 = mId;
	      Tab.modelZoom = modelZoom;
	      Tab.modelRotation1 = modelRT;
	      Tab.modelRotation2 = modelRT2;
	   }
public static void addText(int id, String text, RSFont[] tda, int idx, int color, int width, int height, boolean center, boolean shadow) {
	      Widget tab = addTabInterface(id);
	      tab.parentID = id;
	      tab.id = id;
	      tab.type = 4;
	      tab.atActionType = 0;
	      tab.width = width;
	      tab.height = height;
	      tab.contentType = 0;
	      tab.opacity = 0;
	      tab.hoverType = -1;
	      tab.centerText = center;
	      tab.textShadow = shadow;
	      tab.textDrawingAreas = tda[idx];
	      tab.message = text;
	      tab.secondaryText = "";
	      tab.textColor = color;
	      tab.secondaryColor = 0;
	      tab.defaultHoverColor = 0;
	      tab.secondaryHoverColor = 0;
	   }
public static void addHoverText(int id, String text, String tooltip, RSFont[] tda, int idx, int color, boolean centerText, boolean textShadowed, int width, int height) {
	      Widget rsinterface = addInterface(id);
	      rsinterface.id = id;
	      rsinterface.parentID = id;
	      rsinterface.type = 4;
	      rsinterface.atActionType = 1;
	      rsinterface.width = width;
	      rsinterface.height = height;
	      rsinterface.contentType = 0;
	      rsinterface.opacity = 0;
	      rsinterface.hoverType = -1;
	      rsinterface.centerText = centerText;
	      rsinterface.textShadow = textShadowed;
	      rsinterface.textDrawingAreas = tda[idx];
	      rsinterface.message = text;
	      rsinterface.secondaryText = "";
	      rsinterface.textColor = color;
	      rsinterface.secondaryColor = 0;
	      rsinterface.defaultHoverColor = 16777215;
	      rsinterface.secondaryHoverColor = 0;
	      rsinterface.tooltip = tooltip;
}
   public static void method208(boolean flag, Model Model) {
      byte i = 0;
      byte j = 5;
      if(!flag) {
         aClass12_264.method224();
         if(Model != null && j != 4) {
            aClass12_264.removeFromCache(Model, (long)((j << 16) + i));
         }
      }

   }

   public Model method209(int i, int j, int k, boolean flag) {
      Model Model;
      if(flag) {
         Model = this.method206(this.anInt255, this.anInt256);
      } else {
         Model = this.method206(this.anInt233, this.anInt234);
      }

      if(Model == null) {
         return null;
      } else if(k == -1 && j == -1 && Model.anIntArray1640 == null) {
         return Model;
      } else {
         Model Model_1 = new Model(true, Frame.method532(k) & Frame.method532(j), false, Model);
         if(k != -1 || j != -1) {
            Model_1.method469((byte)-71);
         }

         if(k != -1) {
            Model_1.method470(k);
         }

         if(j != -1) {
            Model_1.method470(j);
         }

         Model_1.method479(64, 768, -50, -10, -50, true);
         if(i != 0) {
            throw new NullPointerException();
         } else {
            return Model_1;
         }
      }
   }
}
