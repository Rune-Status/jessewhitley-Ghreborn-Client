package com.Ghreborn.client.interfaces.impl;

import com.Ghreborn.client.cache.graphics.RSFont;
import com.Ghreborn.client.cache.graphics.TextDrawingArea;
import com.Ghreborn.client.interfaces.Widget;

public class clueInterface extends Widget{
	
	public static void clueInterface(RSFont[] tda) {
	Widget tab = addTabInterface(6960);
	addHoverButton(6961, "/clue/reward/close", 0, 26, 23, "Close Window", 0,
			19974, 3);
	AddInterfaceModel2(6962, 3395, 639, 511, 2047);
	AddInventoryItemGroup(6963, 3, 3);
	AddInterfaceModel2(6964, 1226, 914, 104, 761);
	addHoveredButton(19974, "/clue/reward/close", 1, 26, 23, 19975);
    tab.totalChildren(5);
    tab.child(0, 6961, 430, 8);
    tab.child(1, 6962, 232, 158);
    tab.child(2, 6963, 239, 89);
    tab.child(3, 6964, 174, 212);
    tab.child(4, 19974, 430, 8);
}
}
