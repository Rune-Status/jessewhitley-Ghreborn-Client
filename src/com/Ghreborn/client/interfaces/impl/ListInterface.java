package com.Ghreborn.client.interfaces.impl;

import com.Ghreborn.client.cache.graphics.RSFont;
import com.Ghreborn.client.interfaces.Widget;

public class ListInterface extends Widget {

	   public static void Unpack(RSFont[] tda) {
		      Widget rsinterface = addInterface(54550);
		      addSprite(54551, 501, "Interfaces/Player list/IMAGE");
		      addHoverButton(54552, "Interfaces/Player list/IMAGE", 1337, 23, 23, "Close", -1, '\u8234', 1);
		      addHoveredButton(54553, "Interfaces/Player list/IMAGE", 500, 23, 23, '\u8235');
		      rsinterface.totalChildren(4);
		      rsinterface.child(0, 54551, 1, 15);
		      rsinterface.child(1, 54552, 451, 37);
		      rsinterface.child(2, 54553, 451, 37);
		      rsinterface.child(3, 54554, 165, 70);
		      Widget scrollInterface = addTabInterface(54554);
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
		         addText(54555 + i, ""+i, tda, 1, 4600330, true, true);
		         scrollInterface.child(i, 54555 + i, x, y);
		         y += 22;
		      }

		   }
}
