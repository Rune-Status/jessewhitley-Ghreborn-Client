package com.Ghreborn.client.interfaces.impl;

import com.Ghreborn.client.cache.graphics.RSFont;
import com.Ghreborn.client.interfaces.Widget;

public class slayerInterface extends Widget {

	   public static void Unpack(RSFont[] tda) {
		      Widget rsInterface = addInterface(51000);
		      addSprite(51001, 1, "Interfaces/SlayerInterface/IMAGE");
		      addHoverButton(51002, "Interfaces/SlayerInterface/IMAGE", 4, 16, 16, "Close window", 0, 51003, 1);
		      addHoveredButton(51003, "Interfaces/SlayerInterface/IMAGE", 5, 16, 16, 51004);
		      addHoverButton(51005, "", 0, 85, 20, "Buy", 0, 51006, 1);
		      addHoverButton(51007, "", 0, 85, 20, "Learn", 0, 51030, 1);
		      addHoverButton(51009, "", 0, 85, 20, "Assignment", 0, 51010, 1);
		      addText(51011, "Slayer Points: ", tda, 3, 16750623);
		      addTextButton(51012, "Slayer Experience                           50", "Buy Slayer Experience", 16750623, false, true, tda, 1, 400);
		      addTextButton(51013, "Slayer\'s Respite                             25", "Buy Slayer\'s Respite", 16750623, false, true, tda, 1, 401);
		      addTextButton(51014, "Slayer Darts                                     35", "Buy Slayer Darts", 16750623, false, true, tda, 1, 402);
		      addTextButton(51015, "Broad Arrows                                    25", "Buy Broad Arrows", 16750623, false, true, tda, 1, 403);
		      setChildren(11, rsInterface);
		      rsInterface.child(0, 51001, 12, 10);
		      rsInterface.child(1, 51002, 473, 20);
		      rsInterface.child(2, 51003, 473, 20);
		      rsInterface.child(3, 51005, 21, 23);
		      rsInterface.child(4, 51007, 107, 23);
		      rsInterface.child(5, 51009, 193, 23);
		      rsInterface.child(6, 51011, 98, 74);
		      rsInterface.child(7, 51012, 124, 128);
		      rsInterface.child(8, 51013, 125, 160);
		      rsInterface.child(9, 51014, 125, 190);
		      rsInterface.child(10, 51015, 124, 220);
		   }

		   public static void Unpack2(RSFont[] tda) {
		      Widget rsInterface = addInterface(51500);
		      addSprite(51501, 2, "Interfaces/SlayerInterface/IMAGE");
		      addHoverButton(51502, "Interfaces/SlayerInterface/IMAGE", 4, 16, 16, "Close window", 0, 51503, 1);
		      addHoveredButton(51503, "Interfaces/SlayerInterface/IMAGE", 5, 16, 16, 51504);
		      addHoverButton(51505, "", 0, 85, 20, "Buy", 0, 51506, 1);
		      addHoverButton(51507, "", 0, 85, 20, "Learn", 0, 51508, 1);
		      addHoverButton(51509, "", 0, 85, 20, "Assignment", 0, 51510, 1);
		      addText(51511, "Slayer Points: ", tda, 3, 16750623);
				addTextButton(51512, "Learn how to create slayer helmet								   (350)", "Learn",
						0xFF981F, false, true, tda, 1, 404);
				addTextButton(51513, "Learn how to create slayer helmet (imbued)				  (150)", "Learn", 0xFF981F,
						false, true, tda, 1, 405);
				addTextButton(51514, "Learn the route into cerberus cave				  (1250)", "Learn", 0xFF981F, false,
						true, tda, 1, 406);
				addTextButton(51515, "Learn how to encounter Superior Slayer NPCS				  (250)", "Learn", 0xFF981F,
						false, true, tda, 1, 407);
				setChildren(11, rsInterface);
				rsInterface.child(0, 51501, 12, 10);
				rsInterface.child(1, 51502, 473, 20);
				rsInterface.child(2, 51503, 473, 20);
				rsInterface.child(3, 51505, 21, 23);
				rsInterface.child(4, 51507, 107, 23);
				rsInterface.child(5, 51509, 193, 23);
				rsInterface.child(6, 51511, 98, 74);
				rsInterface.child(7, 51512, 67, 120);
				rsInterface.child(8, 51513, 67, 145);
				rsInterface.child(9, 51514, 67, 170);
				rsInterface.child(10, 51515, 67, 195);
		   }
		   public static void Unpack3(RSFont[] tda) {
			      Widget rsInterface = addInterface(52000);
			  	addSprite(52001, 3, "Interfaces/SlayerInterface/IMAGE");
				addHoverButton(52002, "Interfaces/SlayerInterface/IMAGE", 4, 16, 16, "Close window", 0, 52003, 1);
				addHoveredButton(52003, "Interfaces/SlayerInterface/IMAGE", 5, 16, 16, 52004);
				addHoverButton(52005, "", 0, 85, 20, "Buy", 0, 52006, 1);
				addHoverButton(52007, "", 0, 85, 20, "Learn", 0, 52008, 1);
				addHoverButton(52009, "", 0, 85, 20, "Assignment", 0, 52010, 1);
				addText(52011, "Slayer Points: ", tda, 3, 0xFF981F);
				addTextButton(52012, "Cancel Task", "Temporarily cancel your current slayer task", 0xFF981F, false, true, tda,
						1, 300);
				addTextButton(52013, "Remove Task permanently", "Permanently remove this monster as a task", 0xFF981F, false,
						true, tda, 1, 305);
				addText(52014, "line 1", tda, 1, 0xFF981F);
				addText(52015, "line 2", tda, 1, 0xFF981F);
				addText(52016, "line 3", tda, 1, 0xFF981F);
				addText(52017, "line 4", tda, 1, 0xFF981F);
				addButton(52018, 6, "Interfaces/SlayerInterface/IMAGE", "Delete removed slayer task");
				addButton(52019, 6, "Interfaces/SlayerInterface/IMAGE", "Delete removed slayer task");
				addButton(52020, 6, "Interfaces/SlayerInterface/IMAGE", "Delete removed slayer task");
				addButton(52021, 6, "Interfaces/SlayerInterface/IMAGE", "Delete removed slayer task");
				setChildren(17, rsInterface);
				rsInterface.child(0, 52001, 12, 10);
				rsInterface.child(1, 52002, 473, 20);
				rsInterface.child(2, 52003, 473, 20);
				rsInterface.child(3, 52005, 21, 23);
				rsInterface.child(4, 52007, 107, 23);
				rsInterface.child(5, 52009, 193, 23);
				rsInterface.child(6, 52011, 98, 74);
				rsInterface.child(7, 52012, 71, 127);
				rsInterface.child(8, 52013, 71, 146);
				rsInterface.child(9, 52014, 71, 216);
				rsInterface.child(10, 52015, 71, 234);
				rsInterface.child(11, 52016, 71, 252);
				rsInterface.child(12, 52017, 71, 270);
				rsInterface.child(13, 52018, 303, 215);
				rsInterface.child(14, 52019, 303, 233);
				rsInterface.child(15, 52020, 303, 251);
				rsInterface.child(16, 52021, 303, 269);
			   }

}
