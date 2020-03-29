package com.Ghreborn.client.interfaces.impl;

import com.Ghreborn.client.cache.graphics.RSFont;
import com.Ghreborn.client.interfaces.Widget;

public class MainTeleInterface extends Widget {

	   public static void Unpack(RSFont[] tda) {
		      Widget rsinterface = addInterface('\u830e');
		      addSprite('\u8232', 501, "Interfaces/Skill tele/IMAGE");
		      addHoverButton('\u8233', "Interfaces/Skill tele/IMAGE", 1337, 23, 23, "Close", -1, '\u8234', 1);
		      addHoveredButton('\u8234', "Interfaces/Skill tele/IMAGE", 500, 23, 23, '\u8235');
		      rsinterface.totalChildren(4);
		      rsinterface.child(0, '\u8232', 1, 15);
		      rsinterface.child(1, '\u8233', 451, 37);
		      rsinterface.child(2, '\u8234', 451, 37);
		      rsinterface.child(3, '\u8238', 165, 70);
		      Widget scrollInterface = addTabInterface('\u8238');
		      scrollInterface.scrollPosition = 0;
		      scrollInterface.contentType = 0;
		      scrollInterface.width = 280;
		      scrollInterface.height = 230;
		      scrollInterface.scrollMax = 2500;
		      byte x = 7;
		      int y = 11;
		      byte amountOfLines = 100;
		      scrollInterface.totalChildren(amountOfLines);

		      for(int i = 0; i < amountOfLines; ++i) {
		         addHoverText('\u8239' + i, "", "Select teleport", tda, 1, 4600330, true, true, 168);
		         scrollInterface.child(i, '\u8239' + i, x, y);
		         y += 22;
		      }

		   }
}
