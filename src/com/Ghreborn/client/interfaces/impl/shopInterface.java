package com.Ghreborn.client.interfaces.impl;

import com.Ghreborn.client.cache.graphics.RSFont;
import com.Ghreborn.client.interfaces.Widget;

public class shopInterface extends Widget {
	
	public static void shopInterface(RSFont[] tda) {
		Widget tab = addTabInterface(3824);
		addSprite(10961, 0, "shop/shop");
		addHoverButton(10962, "/shop/shop", 1, 21, 21, "Close Window", 201,
				10963, 3);
		addHoveredButton(10963, "/shop/shop", 2, 21, 21, 3902);
		setChildren(5, tab);
		setBounds(10961, 10, 15, 0, tab);
		setBounds(3900, 69, 60, 1, tab);
		setBounds(3901, 230, 25, 2, tab);
		setBounds(10962, 482, 22, 3, tab);
		setBounds(10963, 482, 22, 4, tab);
	}
}
