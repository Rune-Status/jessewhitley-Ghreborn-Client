package com.Ghreborn.client.interfaces.impl;

import com.Ghreborn.client.cache.graphics.RSFont;
import com.Ghreborn.client.interfaces.Widget;

public class staffTab extends Widget {

	public static void staffTab(RSFont[] TDA) {
		Widget tab = addTabInterface(24999);
		int index = 0;
			addText(28024, "Staff List", 0xff9933, true, true, -1, TDA, 1);
			addSprite(16126, 0, "Interfaces/stafftab/SPRITE");
			addSprite(16127, 1, "Interfaces/stafftab/SPRITE");
			addHoverButton(28018, "Interfaces/stafftab/SPRITE", 2, 160, 32, "Request Staff Assistance", -1, 28019, 1);
			addHoveredButton(28019, "Interfaces/stafftab/SPRITE", 3, 160, 32, 28020);
			addText(28000, "User 1", 0xffffff, false, true, -1, TDA, 1);
			addText(28001, "Offline", 0xff0000, false, true, -1, TDA, 1);
			addText(28002, "User 2", 0xffffff, false, true, -1, TDA, 1);
			addText(28003, "Offline", 0xff0000, false, true, -1, TDA, 1);
			addText(28004, "User 3", 0xffffff, false, true, -1, TDA, 1);
			addText(28005, "Offline", 0xff0000, false, true, -1, TDA, 1);
			addText(28006, "User 4", 0xffffff, false, true, -1, TDA, 1);
			addText(28007, "Offline", 0xff0000, false, true, -1, TDA, 1);
			addText(28008, "User 5", 0xffffff, false, true, -1, TDA, 1);
			addText(28009, "Offline", 0xff0000, false, true, -1, TDA, 1);
			addText(28010, "User 6", 0xffffff, false, true, -1, TDA, 1);
			addText(28011, "Offline", 0xff0000, false, true, -1, TDA, 1);
			addText(28012, "User 7", 0xffffff, false, true, -1, TDA, 1);
			addText(28013, "Offline", 0xff0000, false, true, -1, TDA, 1);
			addText(28014, "User 8", 0xffffff, false, true, -1, TDA, 1);
			addText(28015, "Offline", 0xff0000, false, true, -1, TDA, 1);
			addText(28016, "User 9", 0xffffff, false, true, -1, TDA, 1);
			addText(28017, "Offline", 0xff0000, false, true, -1, TDA, 1);
			
			addText(28021, "Owners", 0xff9933, true, true, -1, TDA, 3);
			addText(28022, "Administrators", 0xff9933, true, true, -1, TDA, 3);
			addText(28023, "Moderators", 0xff9933, true, true, -1, TDA, 3);
		tab.totalChildren(32);
			tab.child(0, 28024, 95, 4);
			tab.child(1, 16127, 0, 25);
			tab.child(2, 16126, 0, 221);
			tab.child(3, 16126, 0, 22);
			tab.child(4, 16126, 0, 40);
			tab.child(5, 16126, 0, 73);
			tab.child(6, 16126, 0, 91);
			tab.child(7, 16126, 0, 124);
			tab.child(8, 16126, 0, 141);
			tab.child(9, 28000, 3, 42);
			tab.child(10, 28002, 3, 57);
			tab.child(11, 28004, 3, 93);
			tab.child(12, 28006, 3, 108);
			tab.child(13, 28008, 3, 144);
			tab.child(14, 28010, 3, 159);
			tab.child(15, 28012, 3, 174);
			tab.child(16, 28014, 3, 189);
			tab.child(17, 28016, 3, 204);
			tab.child(18, 28001, 146, 42);
			tab.child(19, 28003, 146, 57);
			tab.child(20, 28005, 146, 93);
			tab.child(21, 28007, 146, 108);
			tab.child(22, 28009, 146, 144);
			tab.child(23, 28011, 146, 159);
			tab.child(24, 28013, 146, 174);
			tab.child(25, 28015, 146, 189);
			tab.child(26, 28017, 146, 204);
			tab.child(27, 28018, 15, 226);
			tab.child(28, 28019, 15, 226);
			tab.child(29, 28021, 95, 24);
			tab.child(30, 28022, 95, 75);
			tab.child(31, 28023, 95, 125);
	}
}
