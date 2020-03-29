package com.Ghreborn.client;

import com.Ghreborn.client.Main;
import com.Ghreborn.client.Main.ScreenMode;
import com.Ghreborn.client.ClientFrame;
import com.Ghreborn.client.cache.graphics.Sprite;
import com.Ghreborn.client.draw.RSImageProducer;
import com.Ghreborn.client.interfaces.Widget;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Applet_Sub1 extends Applet implements Runnable, MouseListener, MouseMotionListener, MouseWheelListener,
KeyListener, FocusListener, WindowListener {
	
	private static  long serialVersionUID = 1473917011474991756L;
   protected int rotationGliding;
   public boolean resized;
   public static int anInt34;
   public int key;
   public RSImageProducer fullGameScreen;
   public boolean aBoolean9 = false;
   private int anInt5 = 20;
   public boolean aBoolean16 = true;
   public boolean aBoolean17 = true;
   private boolean aBoolean1 = true;
	private long clickTime;
   private int anInt2 = 24869;
   private int anInt3 = 748;
   public int anInt6 = 1;
   private long[] aLongArray7 = new long[10];
   public Sprite[] aSpriteArray14 = new Sprite[6];
   public int[] anIntArray30 = new int[128];
   private int[] anIntArray31 = new int[128];
   int myWidth;
   int myHeight;
   public Graphics graphics;
   public boolean isApplet;
   public int anInt10;
   public int anInt11;
   public RSImageProducer aRSImageProducer_13;
   private int anInt4;
   public int clickMode3;
   public int saveClickX;
   public int saveClickY;
   public long aLong29;
   public boolean canZoom = true;
   public int clickMode1;
   private int anInt32;
   public int fps;
   public int idleTime;
   public int clickX;
   public int clickY;
   public long aLong25;
   public boolean mouseWheelDown;
   public int mouseWheelX;
   public int mouseWheelY;
   public int clickMode2;
   public int mouseX;
   public int mouseY;
   private int anInt33;

 


	 void initClientFrame(int clientWidth, int clientHeight) {
		myWidth = clientWidth;
		myHeight = clientHeight;
		graphics = getGameComponent().getGraphics();
		fullGameScreen = new RSImageProducer(myWidth, myHeight, getGameComponent());
		method12(this, 1);
	}

	Component getGameComponent() {
		return this;
	}
	public void handleInterfaceScrolling(MouseWheelEvent event) {
		int rotation = event.getWheelRotation();
		int positionX = 0;
		int positionY = 0;
		int width = 0;
		int height = 0;
		int offsetX = 0;
		int offsetY = 0;
		int childID = 0;
		int tabInterfaceID = Main.tabInterfaceIDs[Main.tabID];
		if (tabInterfaceID != -1) {
			Widget tab = Widget.interfaceCache[tabInterfaceID];
			offsetX = Main.currentScreenMode == Main.ScreenMode.FIXED ? Main.currentGameWidth - 218
					: (Main.currentScreenMode == Main.ScreenMode.FIXED ? 28
							: Main.currentGameWidth - 197);
			offsetY = Main.currentScreenMode == Main.ScreenMode.FIXED ? Main.currentGameHeight - 298
					: (Main.currentScreenMode == Main.ScreenMode.FIXED ? 37
							: Main.currentGameHeight
							- (Main.currentGameWidth >= 1000 ? 37 : 74) - 267);
			for (int index = 0; index < tab.children.length; index++) {
				if (Widget.interfaceCache[tab.children[index]].scrollMax > 0) {
					childID = index;
					positionX = tab.childX[index];
					positionY = tab.childY[index];
					width = Widget.interfaceCache[tab.children[index]].width;
					height = Widget.interfaceCache[tab.children[index]].height;
					break;
				}
			}
			if (mouseX > offsetX + positionX && mouseY > offsetY + positionY && mouseX < offsetX + positionX + width
					&& mouseY < offsetY + positionY + height) {
				canZoom = false;
				Widget.interfaceCache[tab.children[childID]].scrollPosition += rotation * 30;
			} else {
				canZoom = true;
			}
		}
		if (Main.openInterfaceID != -1) {
			Widget rsi = Widget.interfaceCache[Main.openInterfaceID];
			offsetX = Main.currentScreenMode == Main.ScreenMode.FIXED ? 4
					: (Main.currentGameWidth / 2) - 356;
			offsetY = Main.currentScreenMode == Main.ScreenMode.FIXED ? 4
					: (Main.currentGameHeight / 2) - 230;
			for (int index = 0; index < rsi.children.length; index++) {
				if (Widget.interfaceCache[rsi.children[index]].scrollMax > 0) {
					childID = index;
					positionX = rsi.childX[index];
					positionY = rsi.childY[index];
					width = Widget.interfaceCache[rsi.children[index]].width;
					height = Widget.interfaceCache[rsi.children[index]].height;
					break;
				}
			}
			if (mouseX > offsetX + positionX && mouseY > offsetY + positionY
					&& mouseX < offsetX + positionX + width
					&& mouseY < offsetY + positionY + height) {
				Widget.interfaceCache[rsi.children[childID]].scrollPosition += rotation * 30;
			}
		}
	}
   public void mouseWheelMoved(MouseWheelEvent e) {
      int moved = e.getWheelRotation();
		int rotation = e.getWheelRotation();
	if (Main.loggedIn) {

		/** ZOOMING **/
		boolean zoom = Main.currentScreenMode == ScreenMode.FIXED ? (mouseX < 512)
				: (mouseX < Main.currentGameWidth - 200);
		if (zoom && Main.openInterfaceID == -1) {
			Main.cameraZoom += rotation * 35;

			int max_zoom_1 = (Main.currentScreenMode == ScreenMode.FIXED ? -150 : -300);
			if (Main.cameraZoom < max_zoom_1) {
				Main.cameraZoom = max_zoom_1;
			}
			if (Main.cameraZoom > 1200) {
				Main.cameraZoom = 1200;
			}
			if (Main.currentScreenMode == ScreenMode.FIXED) {
				if (Main.cameraZoom < 70) {
					Main.cameraZoom = 70;
				}
			} else {
				if (Main.cameraZoom < 130) {
					Main.cameraZoom = 130;
				}
			}

			int setting = 0;
			if (Main.cameraZoom > 1000) {
				setting = 4;
			} else if (Main.cameraZoom > 800) {
				setting = 3;
			} else if (Main.cameraZoom > 600) {
				setting = 2;
			} else if (Main.cameraZoom > 400) {
				setting = 1;
			}
			
			//RSInterface.interfaceCache[SettingsWidget.ZOOMTOGGLE].active = true;
			
			/*
			//this is commented out because settings[168] is nulling when a value is set to it.
			try {
				Main.instance.settings[168] = setting;
			} catch (Exception e) {
				System.out.println("Failed to set settings[168] to: "+setting);
			}
			*/
			//RSInterface.interfaceCache[SettingsWidget.ZOOM_SLIDER].slider.setValue(Main.cameraZoom);
		}
	}
	  handleInterfaceScrolling(e);
		if(mouseX > 0 && mouseX < 512 && mouseY > Main.currentGameHeight - 165 && mouseY < Main.currentGameHeight - 25) {
			if(Main.inputDialogState == 3) {
				int scrollPos = Main.grandExchangeSearchScrollPostion;
				int itemSearchAmount = Main.getInstance().grandExchangeItemSearch.getItemSearchResultAmount();
				int maxScrollPosition = itemSearchAmount / 3 * 35;
				scrollPos += rotation * 30;		
				if(scrollPos > maxScrollPosition - 104)
					scrollPos = maxScrollPosition - 104;
				if(scrollPos < 0)
					scrollPos = 0;
				if(Main.grandExchangeSearchScrollPostion != scrollPos) {
					Main.grandExchangeSearchScrollPostion = scrollPos;
					Main.inputTaken = true;
				}
			} else {
				int scrollPos = Main.anInt1089;
				scrollPos -= rotation * 30;		
				if(scrollPos < 0)
					scrollPos = 0;
				if(scrollPos > Main.anInt1211 - 110)
					scrollPos = Main.anInt1211 - 110;
				if(Main.anInt1089 != scrollPos) {
					Main.anInt1089 = scrollPos;
					Main.inputTaken = true;
				}
			}
		}
   }

   public void run() {
      this.getGameComponent().addMouseListener(this);
      this.getGameComponent().addMouseMotionListener(this);
      this.getGameComponent().addKeyListener(this);
      this.getGameComponent().addFocusListener(this);
      this.getGameComponent().addMouseWheelListener(this);
      this.getGameComponent().setFocusTraversalKeysEnabled(false);

      //this.drawLoadingText(0, "Loading...");
      this.method6();
      int i = 0;
      int j = 256;
      int k = 1;
      int i1 = 0;
      int j1 = 0;

      for(int var15 = 0; var15 < 10; ++var15) {
         this.aLongArray7[var15] = System.currentTimeMillis();
      }

      long var151 = System.currentTimeMillis();

      while(true) {
         long l1;
         int l2;
         int i3;
         do {
            if(this.anInt4 < 0) {
               if(this.anInt4 == -1) {
            	   exit();
               }

               return;
            }

            if(this.anInt4 > 0) {
               --this.anInt4;
               if(this.anInt4 == 0) {
            	   exit();
                  return;
               }
            }

            i3 = j;
            int j2 = k;
            j = 300;
            k = 1;
            l1 = System.currentTimeMillis();
            if(this.aLongArray7[i] == 0L) {
               j = i3;
               k = j2;
            } else if(l1 > this.aLongArray7[i]) {
               j = (int)((long)(2560 * this.anInt5) / (l1 - this.aLongArray7[i]));
            }

            if(j < 25) {
               j = 25;
            }

            if(j > 256) {
               j = 256;
               k = (int)((long)this.anInt5 - (l1 - this.aLongArray7[i]) / 10L);
            }

            if(k > this.anInt5) {
               k = this.anInt5;
            }

            this.aLongArray7[i] = l1;
            i = (i + 1) % 10;
            if(k > 1) {
               for(l2 = 0; l2 < 10; ++l2) {
                  if(this.aLongArray7[l2] != 0L) {
                     this.aLongArray7[l2] += (long)k;
                  }
               }
            }

            if(k < this.anInt6) {
               k = this.anInt6;
            }

            try {
               Thread.sleep((long)k);
            } catch (InterruptedException var14) {
               ++j1;
            }

            while(i1 < 256) {
               this.clickMode3 = this.clickMode1;
               this.saveClickX = this.clickX;
               this.saveClickY = this.clickY;
               this.aLong29 = this.aLong25;
               this.clickMode1 = 0;
               this.method7();
               this.anInt32 = this.anInt33;
               i1 += j;
            }

            i1 &= 255;
            if(this.anInt5 > 0) {
               this.fps = 1000 * j / (this.anInt5 * 256);
            }

            this.method9(0);
         } while(!this.aBoolean9);

         System.out.println("ntime:" + l1);

         for(l2 = 0; l2 < 10; ++l2) {
            i3 = (i - l2 - 1 + 20) % 10;
            System.out.println("otim" + i3 + ":" + this.aLongArray7[i3]);
         }

         System.out.println("fps:" + this.fps + " ratio:" + j + " count:" + i1);
         System.out.println("del:" + k + " deltime:" + this.anInt5 + " mindel:" + this.anInt6);
         System.out.println("intex:" + j1 + " opos:" + i);
         this.aBoolean9 = false;
         j1 = 0;
 		if (anInt4 == -1)
			exit();
      }
   }

   public void exit() {
		anInt4 = -2;
		cleanUpForQuit();
		System.exit(0);
	}


   public  void method4(boolean flag, int i) {
      if(!flag) {
         this.anInt5 = 1000 / i;
      }

   }

   public  void start() {
      if(this.anInt4 >= 0) {
         this.anInt4 = 0;
      }

   }

   public  void stop() {
      if(this.anInt4 >= 0) {
         this.anInt4 = 4000 / this.anInt5;
      }

   }

   public  void destroy() {
      this.anInt4 = -1;

      try {
         Thread.sleep(5000L);
      } catch (Exception var2) {
      }

      if(this.anInt4 == -1) {
    	  exit();
      }

   }

   public  void update(Graphics g) {
      if(this.graphics == null) {
         this.graphics = g;
      }

      this.aBoolean16 = true;
      this.method10((byte)1);
   }

   public  void paint(Graphics g) {
      if(this.graphics == null) {
         this.graphics = g;
      }

      this.aBoolean16 = true;
      this.method10((byte)1);
   }

	public int clickType;
	public  int LEFT = 0;
	public  int RIGHT = 1;
	public  int DRAG = 2;
	public  int RELEASED = 3;
	public  int MOVE = 4;
	public int releasedX;
	public int releasedY;
	
	public  void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		int type = e.getButton();
		//System.out.println("Mouse Button : "+type);
		idleTime = 0;
		clickX = x;
		clickY = y;
		aLong29 = System.currentTimeMillis();
		if (SwingUtilities.isMiddleMouseButton(e)) {
			mouseWheelDown = true;
			mouseWheelX = x;
			mouseWheelY = y;
			return;
		}		
		if(SwingUtilities.isRightMouseButton(e)) {
			clickType = RIGHT;
			clickMode1 = 2;
			clickMode2 = 2;
		} else if(SwingUtilities.isLeftMouseButton(e)) {
			clickType = LEFT;
			clickMode1 = 1;
			clickMode2 = 1;
		}
	}

	public  void mouseReleased(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		releasedX = x;
		releasedY = y;
		idleTime = 0;
		clickMode2 = 0;
		clickType = RELEASED;
		mouseWheelDown = false;
	}

   public  void mouseDragged(MouseEvent mouseevent) {
      int i = mouseevent.getX();
      int j = mouseevent.getY();
		if (System.currentTimeMillis() - clickTime >= 250L || Math.abs(saveClickX - i) > 5
				|| Math.abs(saveClickY - j) > 5) {
			idleTime = 5;
			mouseX = i;
			mouseY = j;
		}
      if(this.mouseWheelDown) {
         j = this.mouseWheelX - mouseevent.getX();
         int k = this.mouseWheelY - mouseevent.getY();
         this.mouseWheelDragged(j, -k);
         this.mouseWheelX = mouseevent.getX();
         this.mouseWheelY = mouseevent.getY();
      } else {
         this.idleTime = 0;
         this.mouseX = i;
         this.mouseY = j;
      }

   }

   void mouseWheelDragged(int param1, int param2) {
   }


   public  void mouseClicked(MouseEvent mouseevent) {
   }

   public  void mouseEntered(MouseEvent mouseevent) {
   }

   public  void mouseExited(MouseEvent mouseevent) {
      this.idleTime = 0;
      this.mouseX = -1;
      this.mouseY = -1;
   }

   public  void mouseMoved(MouseEvent mouseevent) {
		// if(idleTime >= (Main.IDLE_TIME - 500)) {
		// Main.mouseMoved();
		// }
      int i = mouseevent.getX();
      int j = mouseevent.getY();
		if (System.currentTimeMillis() - clickTime >= 250L || Math.abs(saveClickX - i) > 5
				|| Math.abs(saveClickY - j) > 5) {
			idleTime = 3;
			mouseX = i;
			mouseY = j;
		}
   }

   public  void keyPressed(KeyEvent keyevent) {
      this.idleTime = 0;
      int i = keyevent.getKeyCode();
      int j = keyevent.getKeyChar();

      if(keyevent.isControlDown()) {
         Main.controlIsDown = true;
      }
		if (keyevent.isShiftDown()) {
			 Main.shiftDown = true;
		}
	    if((keyevent.isControlDown() && keyevent.getKeyCode() == KeyEvent.VK_V)) {
	    	Main.inputString += Main.getClipboardContents();
                    Main.inputTaken = true;
	    }
	    if((keyevent.isControlDown() && keyevent.getKeyCode() == KeyEvent.VK_X)) {
	    	Main.setClipboardContents(Main.inputString);
	    	Main.inputString = "";
                    Main.inputTaken = true;
	    }
      if(keyevent.isShiftDown()) {
         Main.shiftDown = true;
      }
		if(i ==  KeyEvent.VK_ESCAPE){
			Main.setTab(3);
		} else if(i == KeyEvent.VK_F5){
			Main.setTab(0);
		} else if(i == KeyEvent.VK_F11){
			Main.setTab(1);
		} else if(i == KeyEvent.VK_F12){
			Main.setTab(2);
		} else if(i == KeyEvent.VK_F1){
			Main.setTab(3);
		} else if(i == KeyEvent.VK_F2){
			Main.setTab(4);
		} else if(i == KeyEvent.VK_F3){
			Main.setTab(5);
		} else if(i == KeyEvent.VK_F4){
			Main.setTab(6);
		} else if(i ==  KeyEvent.VK_F8){
			Main.setTab(7);
		} else if(i == KeyEvent.VK_F9){
			Main.setTab(8);
		} else if(i ==  KeyEvent.VK_F10){
			Main.setTab(9);
		} else if(i ==  KeyEvent.VK_F11){
			Main.setTab(10);
		} else if(i ==  KeyEvent.VK_F12){
			Main.setTab(11);
		}


      if(i == 36) {
         Main.fwdbwd -= 15;
      }

      if(i == 35) {
         Main.fwdbwd += 15;
      }

      if(i == 34) {
         Main.lftrit -= 15;
      }

      if(i == 127) {
         Main.lftrit += 15;
      }


      if(j < 30) {
         j = 0;
      }

      if(i == 37) {
         j = 1;
      }

      if(i == 39) {
         j = 2;
      }

      if(i == 38) {
         j = 3;
      }

      if(i == 40) {
         j = 4;
      }

      if(i == 17) {
         j = 5;
      }

      if(i == 8) {
         j = 8;
      }

      if(i == 127) {
         j = 8;
      }

      if(i == 9) {
         j = 9;
      }

      if(i == 10) {
         j = 10;
      }

      if(i >= 112 && i <= 123) {
         j = 1008 + i - 112;
      }

      if(i == 36) {
         j = 1000;
      }

      if(i == 35) {
         j = 1001;
      }

      if(i == 33) {
         j = 1002;
      }

      if(i == 34) {
         j = 1003;
      }

      if(j > 0 && j < 128) {
         this.anIntArray30[j] = 1;
      }

      if(j > 4) {
         this.anIntArray31[this.anInt33] = j;
         this.anInt33 = this.anInt33 + 1 & 127;
      }

   }

   public  void keyReleased(KeyEvent keyevent) {
      this.idleTime = 0;
      int i = keyevent.getKeyCode();
      char c = keyevent.getKeyChar();
      if(i == 17) {
         Main.controlIsDown = false;
      }

		if (i == KeyEvent.VK_SHIFT) {
			Main.shiftDown = false;
		}
      if(c < 30) {
         c = 0;
      }

      if(i == 37) {
         c = 1;
      }

      if(i == 39) {
         c = 2;
      }

      if(i == 38) {
         c = 3;
      }

      if(i == 40) {
         c = 4;
      }

      if(i == 17) {
         c = 5;
      }

      if(i == 8) {
         c = 8;
      }

      if(i == 127) {
         c = 8;
      }

      if(i == 9) {
         c = 9;
      }

      if(i == 10) {
         c = 10;
      }

      if(c > 0 && c < 128) {
         this.anIntArray30[c] = 0;
      }

   }

   public  void keyTyped(KeyEvent keyevent) {
   }
	public void setCursor(int id) {
		if(Main.MouseIcons){
	    Image image = getGameComponent().getToolkit().createImage(FileOperations.ReadFile(SignLink.findcachedir() + "Sprites/Cursors/Cursor " + id + ".PNG"));
	    getGameComponent().setCursor(getGameComponent().getToolkit().createCustomCursor(image, new Point(0, 0), null));
		}
	}
   public  int readChar(int i) {
      int k;
      while(i >= 0) {
         for(k = 1; k > 0; ++k) {
         }
      }

      k = -1;
      if(this.anInt33 != this.anInt32) {
         k = this.anIntArray31[this.anInt32];
         this.anInt32 = this.anInt32 + 1 & 127;
      }

      return k;
   }

   public  void focusGained(FocusEvent focusevent) {
      this.aBoolean17 = true;
      this.aBoolean16 = true;
      this.method10((byte)1);
   }

   public  void focusLost(FocusEvent focusevent) {
      this.aBoolean17 = false;

      for(int i = 0; i < 128; ++i) {
         this.anIntArray30[i] = 0;
      }

   }

   public  void windowActivated(WindowEvent windowevent) {
   }
	@Override
   public  void windowClosed(WindowEvent windowevent) {
   }
	@Override
	public void windowClosing(WindowEvent windowevent) {
        String[] options = {"Yes", "No"};
        int userPrompt = JOptionPane.showOptionDialog(null, "Are you sure you wish to exit?", "Ghreborn", 
        		JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options , options[1]);
        if(userPrompt == JOptionPane.YES_OPTION) {
        	destroy();
            System.exit(0);
        }
	}

   public  void windowDeactivated(WindowEvent windowevent) {
   }

   public  void windowDeiconified(WindowEvent windowevent) {
   }

   public  void windowIconified(WindowEvent windowevent) {
   }

   public  void windowOpened(WindowEvent windowevent) {
   }

   public void method6() {
   }

   public void method7() {
   }

   public void cleanUpForQuit() {
   }

   public void method9(int i) {
      if(i != 0) {
         for(int j = 1; j > 0; ++j) {
         }
      }

   }

   public void method10(byte byte0) {
      if(byte0 == 1) {
         boolean var2 = false;
      }

   }


   public void method12(Runnable runnable, int i) {
      Thread thread = new Thread(runnable);
      thread.start();
      thread.setPriority(i);
   }

	void drawLoadingText(int percentage, String s) {
		while (graphics == null) {
			graphics = getGameComponent().getGraphics();
			try {
				getGameComponent().repaint();
			} catch (Exception _ex) {
			}
			try {
				Thread.sleep(1000L);
			} catch (Exception _ex) {
			}
		}
		Font font = new Font("Helvetica", 1, 13);
		FontMetrics fontmetrics = getGameComponent().getFontMetrics(font);
		Font font1 = new Font("Helvetica", 0, 13);
		getGameComponent().getFontMetrics(font1);
		// if (shouldClearScreen) {
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, myWidth, myHeight);
		aBoolean16 = false;
		// }
		Color color = new Color(140, 17, 17);
		int j = myHeight / 2 - 18;
		graphics.setColor(color);
		graphics.drawRect(myWidth / 2 - 152, j, 304, 34);
		graphics.fillRect(myWidth / 2 - 150, j + 2, percentage * 3, 30);
		graphics.setColor(Color.black);
		graphics.fillRect((myWidth / 2 - 150) + percentage * 3, j + 2, 300 - percentage * 3, 30);
		graphics.setFont(font);
		graphics.setColor(Color.white);
		graphics.drawString(s, (myWidth - fontmetrics.stringWidth(s)) / 2, j + 22);

	}

}
