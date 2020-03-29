package com.Ghreborn.client.interfaces.impl;

import com.Ghreborn.client.cache.graphics.RSFont;
import com.Ghreborn.client.interfaces.Widget;

public class signpost  extends Widget {

public static void signpost(RSFont[] tda) {
	Widget tab = addTabInterface(39000);
	addHoverButton(39001, "/clue/reward/close", 0, 26, 23, "Close Window", 0,
			39002, 3);
	addHoveredButton(39002, "/clue/reward/close", 1, 26, 23, 89003);
	AddInterfaceModel2(39003, 18535, 1162, 517, 0);
	AddInterfaceModel2(39004, 18533, 1418, 515, 513);
	AddInterfaceModel2(39005, 18530, 1290, 478, 3);
	AddInterfaceModel2(39006, 18530, 1290, 475, 0);
	AddInterfaceModel2(39007, 18533, 1418, 515, 513);
	addtextwithsize(39008, "To the NORTH", tda, 2, 3677962, true, false, 180, 15);
	addtextwithsize(39010, "To the NORTH", tda, 1, 3677962, true, false, 180, 71);
	addtextwithsize(39011, "To the EAST", tda, 2, 3677962, true, false, 118, 15);
	addtextwithsize(39012, "To the EAST", tda, 1, 3677962, true, false, 118, 137);
	addtextwithsize(39013, "To the SOUTH", tda, 2, 3677962, true, false, 177, 15);
	addtextwithsize(39014, "To the SOUTH", tda, 1, 3677962, true, false, 176, 66); 
	addtextwithsize(39015, "To the WEST", tda, 2, 3677962, true, false, 114, 14);
	addtextwithsize(39016, "To the WEST", tda, 1, 3677962, true, false, 115, 138);    
	addAlphaBox(39009, 512, 334, 10786175, 200);
	tab.totalChildren(16);
    tab.child(0, 39009, 0, 0);
    tab.child(1, 39001, 485, 11);
    tab.child(2, 39002, 485, 11);
    tab.child(3, 39004, 242, 32);
    tab.child(4, 39005, 418, 144);
    tab.child(5, 39006, 52, 142);
    tab.child(6, 39007, 242, 247);
    tab.child(7, 39008, 171, 14);
    tab.child(8, 39010, 171, 28);
    tab.child(9, 39011, 382, 86);
    tab.child(10,39012, 382, 103);
    tab.child(11, 39013, 172, 238);
    tab.child(12, 39014, 173, 253);
    tab.child(13, 39015, 18, 86);
    tab.child(14, 39016, 17, 100);
    tab.child(15, 39003, 242, 145);
}


}
