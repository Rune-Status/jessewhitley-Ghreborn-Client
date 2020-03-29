package com.Ghreborn.client;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;

import com.Ghreborn.client.AccountData;
import com.Ghreborn.client.AccountManager;
import com.Ghreborn.client.Applet_Sub1;
import com.Ghreborn.client.CacheDownloader;
import com.Ghreborn.client.Censor;
import com.Ghreborn.client.Constants;
import com.Ghreborn.client.FileOperations;
import com.Ghreborn.client.InformationFile;
import com.Ghreborn.client.MouseDetection;
import com.Ghreborn.client.PlayerTitles;
import com.Ghreborn.client.SizeConstants;
import com.Ghreborn.client.Skills;
import com.Ghreborn.client.StopWatch;
import com.Ghreborn.client.TextClass;
import com.Ghreborn.client.TextInput;
import com.Ghreborn.client.Varp;
import com.Ghreborn.client.SignLink;
import com.Ghreborn.client.cache.Decompressor;
import com.Ghreborn.client.cache.StreamLoader;
import com.Ghreborn.client.cache.anim.Frame;
import com.Ghreborn.client.cache.def.ItemDefinition;
import com.Ghreborn.client.cache.def.NpcDefinition;
import com.Ghreborn.client.cache.def.Animation;
import com.Ghreborn.client.cache.def.FloorDefinition;
import com.Ghreborn.client.cache.def.Graphic;
import com.Ghreborn.client.cache.def.IdentityKit;
import com.Ghreborn.client.cache.def.ObjectDefinition;
import com.Ghreborn.client.cache.def.VarBit;
import com.Ghreborn.client.cache.graphics.Background;
import com.Ghreborn.client.cache.graphics.RSFont;
import com.Ghreborn.client.cache.graphics.Sprite;
import com.Ghreborn.client.cache.graphics.TextDrawingArea;
import com.Ghreborn.client.draw.DrawingArea;
import com.Ghreborn.client.draw.RSImageProducer;
import com.Ghreborn.client.draw.Rasterizer;
import com.Ghreborn.client.draw.DrawingArea;
import com.Ghreborn.client.draw.Texture;
import com.Ghreborn.client.entity.Animable_Sub3;
import com.Ghreborn.client.entity.Animable_Sub4;
import com.Ghreborn.client.entity.Animable_Sub5;
import com.Ghreborn.client.entity.Entity;
import com.Ghreborn.client.entity.Item;
import com.Ghreborn.client.entity.Npc;
import com.Ghreborn.client.entity.Player;
import com.Ghreborn.client.entity.model.Model;
import com.Ghreborn.client.entity.model.ModelDecompressor;
import com.Ghreborn.client.features.ExperienceDrop;
import com.Ghreborn.client.features.gametimers.GameTimerHandler;
import com.Ghreborn.client.features.items.ItemEditor;
import com.Ghreborn.client.interfaces.Widget;
import com.Ghreborn.client.interfaces.impl.ge.GrandExchange;
import com.Ghreborn.client.interfaces.loaders.SpriteLoader;
import com.Ghreborn.client.interfaces.loaders.SpriteLoader1;
import com.Ghreborn.client.interfaces.loaders.SpriteLoader2;
import com.Ghreborn.client.interfaces.loaders.SpriteLoader3;
import com.Ghreborn.client.interfaces.loaders.SpriteLoader4;
import com.Ghreborn.client.io.jaggrab.JagGrab;
import com.Ghreborn.client.io.Buffer;
import com.Ghreborn.client.link.NodeList;
import com.Ghreborn.client.map.CollisionMap;
import com.Ghreborn.client.map.Class30_Sub1;
import com.Ghreborn.client.map.Object1;
import com.Ghreborn.client.map.Object2;
import com.Ghreborn.client.map.Object3;
import com.Ghreborn.client.map.Object5;
import com.Ghreborn.client.map.ObjectManager;
import com.Ghreborn.client.map.WorldController;
import com.Ghreborn.client.net.BackgroundRequester;
import com.Ghreborn.client.net.ISAACRandomGen;
import com.Ghreborn.client.net.OnDemandData;
import com.Ghreborn.client.net.OnDemandFetcher;
import com.Ghreborn.client.net.RSSocket;
import com.Ghreborn.client.particles.Particle;
import com.Ghreborn.client.particles.ParticleDefinition;
import com.Ghreborn.client.sound.SoundLoader;
import com.Ghreborn.client.sound.MidiPlayer;
import com.Ghreborn.client.sound.SoundPlayer;
import com.Ghreborn.client.sound.Sounds;

import java.applet.AppletContext;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Queue;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.zip.CRC32;
import java.util.zip.GZIPOutputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class Main extends Applet_Sub1 {


    public static int getComplementaryColor(int colorToInvert) {
        float[] hsv = new float[3];
        RGBToHSV(red(colorToInvert), green(colorToInvert),
                blue(colorToInvert), hsv);
        hsv[0] = (hsv[0] + 180) % 360;
        return HSVToColor(hsv);
    }

    public static int HSVToColor(float[] hsv) {
        if (hsv.length < 3) {
            throw new RuntimeException("3 components required for hsv");
        }
        return nativeHSVToColor(hsv);
    }

    /**
     * Convert RGB components to HSV.
     * hsv[0] is Hue [0 .. 360)
     * hsv[1] is Saturation [0...1]
     * hsv[2] is Value [0...1]
     *
     * @param red   red component value [0..255]
     * @param green green component value [0..255]
     * @param blue  blue component value [0..255]
     * @param hsv   3 element array which holds the resulting HSV components.
     */
    public static void RGBToHSV(int red, int green, int blue, float[] hsv) {
        if (hsv.length < 3) {
            throw new RuntimeException("3 components required for hsv");
        }
        nativeRGBToHSV(red, green, blue, hsv);
    }

    private static native void nativeRGBToHSV(int red, int greed, int blue, float[] hsv);

    private static native int nativeHSVToColor(float[] hsv);

    /**
     * Return the red component of a color int. This is the same as saying
     * (color >> 16) & 0xFF
     */
    public static int red(int color) {
        return (color >> 16) & 0xFF;
    }

    /**
     * Return the green component of a color int. This is the same as saying
     * (color >> 8) & 0xFF
     */
    public static int green(int color) {
        return (color >> 8) & 0xFF;
    }

    /**
     * Return the blue component of a color int. This is the same as saying
     * color & 0xFF
     */
    public static int blue(int color) {
        return color & 0xFF;
    }

    public static String insertCommas(long i) {
        return String.format("%,d", i);
    }

    /**
     * Get the String residing on the clipboard.
     *
     * @return any text found on the Clipboard; if none found, return an empty
     * String.
     */
    public static String getClipboardContents() {
        String result = "";
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // odd: the Object param of getContents is not currently used
        Transferable contents = clipboard.getContents(null);
        boolean hasTransferableText = (contents != null) && contents.isDataFlavorSupported(DataFlavor.stringFlavor);
        if (hasTransferableText) {
            try {
                result = (String) contents.getTransferData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException ex) {
                // highly unlikely since we are using a standard DataFlavor
                System.out.println(ex);
                ex.printStackTrace();
            } catch (IOException ex) {
                System.out.println(ex);
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * Place a String on the clipboard, and make this class the owner of the
     * Clipboard's contents.
     * Clipboard's contents
     */
    public static void setClipboardContents(String aString) {
        StringSelection stringSelection = new StringSelection(aString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
    private void drawInputField(Widget child, int xPosition, int yPosition, int width, int height) {
        int clickX = super.saveClickX, clickY = super.saveClickY;
        Sprite[] inputSprites = this.inputSprites;
        int xModification = 0, yModification = 0;
        for (int row = 0; row < width; row += 12) {
            if (row + 12 > width)
                row -= 12 - (width - row);
            inputSprites[6].drawSprite(xModification <= 0 ? xPosition + row : xPosition + xModification, yPosition);
            for (int collumn = 0; collumn < height; collumn += 12) {
                if (collumn + 12 > height)
                    collumn -= 12 - (height - collumn);
                inputSprites[6].drawSprite(xPosition + row,
                        yModification <= 0 ? yPosition + collumn : yPosition + yModification);
            }
        }
        inputSprites[1].drawSprite(xPosition, yPosition);
        inputSprites[0].drawSprite(xPosition, yPosition + height - 8);
        inputSprites[2].drawSprite(xPosition + width - 4, yPosition);
        inputSprites[3].drawSprite(xPosition + width - 4, yPosition + height - 8);
        xModification = 0;
        yModification = 0;
        for (int top = 0; top < width; top += 8) {
            if (top + 8 > width)
                top -= 8 - (width - top);
            inputSprites[5].drawSprite(xPosition + top, yPosition);
            inputSprites[5].drawSprite(xPosition + top, yPosition + height - 1);
        }
        for (int bottom = 0; bottom < height; bottom += 8) {
            if (bottom + 8 > height)
                bottom -= 8 - (height - bottom);
            inputSprites[4].drawSprite(xPosition, yPosition + bottom);
            inputSprites[4].drawSprite(xPosition + width - 1, yPosition + bottom);
        }
        String message = child.message;
        if (smallText.getTextWidth(message) > child.width - 10)
            message = message.substring(message.length() - (child.width / 10) - 1, message.length());
        if (child.displayAsterisks)
            this.smallText.method389(false, (xPosition + 4), child.textColor,
                    new StringBuilder().append("").append(TextClass.passwordAsterisks(message))
                            .append(((!child.isInFocus ? 0 : 1) & (loopCycle % 40 < 20 ? 1 : 0)) != 0 ? "|" : "")
                            .toString(),
                    (yPosition + (height / 2) + 6));
        else
            this.smallText.method389(false, (xPosition + 4), child.textColor,
                    new StringBuilder().append("").append(message)
                            .append(((!child.isInFocus ? 0 : 1) & (loopCycle % 40 < 20 ? 1 : 0)) != 0 ? "|" : "")
                            .toString(),
                    (yPosition + (height / 2) + 6));
        if (clickX >= xPosition && clickX <= xPosition + child.width && clickY >= yPosition
                && clickY <= yPosition + child.height) {
            if (!child.isInFocus && getInputFieldFocusOwner() != child) {
                if ((super.clickMode2 == 1 && !menuOpen)) {
                    Widget.currentInputFieldId = child.id;
                    setInputFieldFocusOwner(child);
                    if (child.message != null && child.message.equals(child.defaultInputFieldText))
                        child.message = "";
                    if (child.message == null)
                        child.message = "";
                }
            }
        }
    }
    static AbstractMap.SimpleEntry<Integer, Integer> getMostFrequentN2(ArrayList<Integer> values) {
        ArrayList<AbstractMap.SimpleEntry<Integer, Integer>> frequencies = new ArrayList<>();

        int maxIndex = 0;

        main:
        for (int i = 0; i < values.size(); ++i) {
            int value = values.get(i);

            for (int j = 0; j < frequencies.size(); ++j) {
                if (frequencies.get(j).getKey() == value) {
                    frequencies.get(j).setValue(frequencies.get(j).getValue() + 1);

                    if (frequencies.get(maxIndex).getValue() < frequencies.get(j).getValue()) {
                        maxIndex = j;
                    }

                    continue main;
                }
            }

            frequencies.add(new AbstractMap.SimpleEntry<Integer, Integer>(value, 1));
        }

        return frequencies.get(maxIndex);
    }

    public static String formatNumber(double number) {
        return NumberFormat.getInstance().format(number);
    }

    public static void printInterfaceData() {
        try {
            File file = new File(SignLink.findcachedir() + "/interfaceDump.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            Widget[] var6 = Widget.interfaceCache;
            int var5 = Widget.interfaceCache.length;

            for (int var4 = 0; var4 < var5; ++var4) {
                Widget r = var6[var4];
                if (r != null && r.children != null) {
                    bw.write("Dump for interface: " + r.id);
                    bw.newLine();

                    for (int i = 0; i < r.children.length; ++i) {
                        bw.write("Child #" + i + "     Child ID: " + r.children[i] + "    Child X: " + r.childX[i]
                                + "    Child Y: " + r.childY[i]);
                        bw.newLine();
                    }

                    bw.newLine();
                    bw.newLine();
                    bw.newLine();
                    bw.newLine();
                }
            }

            bw.close();
        } catch (Exception var8) {
        }

    }

    private static final String method14(int i, int j) {
        String s = String.valueOf(i);

        for (int k = s.length() - 3; k > 0; k -= 3) {
            s = s.substring(0, k) + "," + s.substring(k);
        }

        if (j != 0) {
            aBoolean1224 = !aBoolean1224;
        }

        if (s.length() > 8) {
            s = "@gre@" + s.substring(0, s.length() - 8) + " million @gre@(" + s + ")";
        } else if (s.length() > 4) {
            s = "@Whi@" + s.substring(0, s.length() - 4) + "K @whi@(" + s + ")";
        }

        return " " + s;
    }

    public static String getFileNameWithoutExtension(String fileName) {
        File tmpFile = new File(fileName);
        tmpFile.getName();
        int whereDot = tmpFile.getName().lastIndexOf(46);
        return whereDot > 0 && whereDot <= tmpFile.getName().length() - 2 ? tmpFile.getName().substring(0, whereDot)
                : "";
    }

    public static final byte[] ReadFile(String s) {
        try {
            File var51 = new File(s);
            int i = (int) var51.length();
            byte[] e = new byte[i];
            DataInputStream datainputstream = new DataInputStream(new BufferedInputStream(new FileInputStream(s)));
            datainputstream.readFully(e, 0, i);
            datainputstream.close();
            ++TotalRead;
            return e;
        } catch (Exception var5) {
            System.out.println("Read Error: " + s);
            return null;
        }
    }

    private static void handleGEItemSearchClick(int itemId) {
        // TODO Send Item Packet
        System.out.println("Clicking Item: " + itemId);
    }

    public static String capitalize(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                s = String.format("%s%s", Character.toUpperCase(s.charAt(0)), s.substring(1));
            }
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                if (i + 1 < s.length()) {
                    s = String.format("%s%s%s", s.subSequence(0, i + 1), Character.toUpperCase(s.charAt(i + 1)),
                            s.substring(i + 2));
                }
            }
        }
        return s;
    }

    private static String combatDiffColor(int i, int j) {
        int k = i - j;
        if (k < -9)
            return "<col=ff0000>";//red
        if (k < -6)
            return "<col=ff3000>";//or3
        if (k < -3)
            return "<col=ff7000>";//or2
        if (k < 0)
            return "<col=ffb000>";//or1
        if (k > 9)
            return "<col=65280>";//green
        if (k > 6)
            return "<col=40ff00>";//gre3
        if (k > 3)
            return "<col=80ff00>";//gre2
        if (k > 0)
            return "<col=c0ff00>";//gre1
        else
            return "<col=ffff00>";//yel
    }

    public static void setTab(int id) {
        tabID = id;
        tabAreaAltered = true;
    }

    private static final String method43(int j) {
        return j < 100000 ? String.valueOf(j) : (j < 10000000 ? j / 1000 + "K" : j / 1000000 + "M");
    }

    public static void setHighMem() {
        WorldController.lowMem = false;
        Rasterizer.lowMem = false;
        lowMem = false;
        ObjectManager.lowMem = false;
        ObjectDefinition.lowMem = false;
    }

    public static final void main(String[] args) {
        try {
            anInt957 = 10;
            portOff = 0;
            lowMem = false;
            setHighMem();
            isMembers = true;
            SignLink.storeid = 32;
            SignLink.startpriv(InetAddress.getLocalHost());
            instance = new ClientWindow(args);
        } catch (Exception var2) {
        }

    }

    public static Main getInstance() {
        return instance;
    }

    public static void mouseMoved() {
        if (loggedIn)
            // if(idleTime >= (Client.IDLE_TIME - 500))
            stream.createFrame(187);
    }

    static boolean centerMainScreenInterface() {
        return (currentGameWidth <= 900 || currentGameHeight <= 650);
    }

    public static boolean scrollbarVisible(Widget widget) {
        if (widget.id == 55010) {
            return Widget.interfaceCache[55024].message.length() > 0;
        } else if (widget.id == 55050) {
            return Widget.interfaceCache[55064].message.length() > 0;
        }
        return true;
    }

    public static boolean centerInterface() {
        int minimumScreenWidth = 900, minimumScreenHeight = 650;
        return currentGameWidth >= minimumScreenWidth && currentGameHeight >= minimumScreenHeight;
    }

    public static final void method138(byte byte0) {
        WorldController.lowMem = true;
        if (byte0 != aByte823) {
            for (int i = 1; i > 0; ++i) {
            }
        }

        Rasterizer.lowMem = true;
        lowMem = true;
        ObjectManager.lowMem = true;
        ObjectDefinition.lowMem = true;
    }

    public static void continueDialogue() {
        if (System.currentTimeMillis() - timer < 400) {
            return;
        }
        timer = System.currentTimeMillis();
        String text = "::dialoguecontinuation continue";
        stream.createFrame(103);
        stream.writeWordBigEndian(text.length() - 1);
        stream.writeString(text.substring(2));
    }

    public static void dialogueOptions(String option) {
        if (System.currentTimeMillis() - timer < 400) {
            return;
        }
        timer = System.currentTimeMillis();
        String text = option == "one" ? "::dialoguecontinuation option_one"
                : option == "two" ? "::dialoguecontinuation option_two"
                : option == "three" ? "::dialoguecontinuation option_three"
                : option == "four" ? "::dialoguecontinuation option_four"
                : "::dialoguecontinuation option_five";
        stream.createFrame(103);
        stream.writeWordBigEndian(text.length() - 1);
        stream.writeString(text.substring(2));
    }

    private void addToXPCounter(int skill, int xp) {
        int font_height = 24;
        if (xp <= 0)
            return;

        xpCounter += xp;

        int lowest_y_off = Integer.MAX_VALUE;
        for (int i = 0; i < xp_added.length; i++)
            if (xp_added[i][0] > -1)
                lowest_y_off = Math.min(lowest_y_off, xp_added[i][2]);

        if (Constants.xp_merge && lowest_y_off != Integer.MAX_VALUE && lowest_y_off <= 0) {
            for (int i = 0; i < xp_added.length; i++) {
                if (xp_added[i][2] != lowest_y_off)
                    continue;

                xp_added[i][0] |= (1 << skill);
                xp_added[i][1] += xp;
                return;
            }
        } else {
            ArrayList<Integer> list = new ArrayList<Integer>();
            int y = font_height;

            boolean go_on = true;
            while (go_on) {
                go_on = false;

                for (int i = 0; i < xp_added.length; i++) {
                    if (xp_added[i][0] == -1 || list.contains(new Integer(i)))
                        continue;

                    if (xp_added[i][2] < y) {
                        xp_added[i][2] = y;
                        y += font_height;
                        go_on = true;
                        list.add(new Integer(i));
                    }
                }
            }

            if (lowest_y_off == Integer.MAX_VALUE || lowest_y_off >= font_height)
                lowest_y_off = 0;
            else
                lowest_y_off = 0;

            for (int i = 0; i < xp_added.length; i++)
                if (xp_added[i][0] == -1) {
                    xp_added[i][0] = (1 << skill);
                    xp_added[i][1] = xp;
                    xp_added[i][2] = lowest_y_off;
                    return;
                }
        }
    }

    public void dumpCacheIndex(int cacheIndex) {
        try {
            for (int i = 0; ; i++) {
                try {
                    byte[] indexByteArray = Indexes[cacheIndex].decompress(i);
                    if (indexByteArray == null) {
                        System.out.println("Finished dumping index " + cacheIndex
                                + ", exiting dump operation.");
                        break;
                    }

                    final File dir = new File("./dump" + cacheIndex + "/");

                    if (!dir.exists()) {
                        dir.mkdirs();
                    }

                    BufferedOutputStream gzip = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("./dump" + cacheIndex + "/" + i + ".gz")));

                    if (indexByteArray.length == 0) {
                        continue;
                    } else {
                        gzip.write(indexByteArray);
                        System.out.println("Unpacked " + i + ".");
                        gzip.close();

                    }
                } catch (IOException ex) {
                    throw new IOException(
                            "Error writing to folder. Ensure you have this directory created: '"
                                    + "./dump"
                                    + cacheIndex + "'");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void drawExpCounterDrops() {

        final boolean wilderness = openWalkableInterface == 23300;

        RSFont xp_font = newSmallFont;
        int font_height = 24;
        int x = currentGameWidth - 280;
        int x2 = currentGameWidth;
        int y = wilderness ? -100 : -100;
        String xpString = insertCommas(totalExp);
        digits = xpCounter == 0 ? 1 : 1 + (int) Math.floor(Math.log10(xpCounter));
        int lengthToRemove = Integer.toString(xpCounter).length();
        int i = regularText.getTextWidth(Integer.toString(xpCounter))
                - regularText.getTextWidth(Integer.toString(xpCounter)) / 2;
        int a = lengthToRemove == 1 ? 5 : ((lengthToRemove - 1) * 5);
        DrawingArea.drawBoxOutline(x2 - 380, 4, 120, 30, 0x383023); // 5a5245
        DrawingArea.drawBoxOutline(x2 - 379, 5, 118, 28, 0x5a5245); // 5a5245
        DrawingArea.drawTransparentBox(x2 - 378, 6, 116, 26, 0x5a5245, 150); // 5a5245
        gameframe[56].drawSprite(x2 - 379, 1);
        smallText.drawTextWithPotentialShadow(true, x2 - 265 - smallText.getTextWidth(xpString), 0xffffff, xpString,
                25);
        for (i = 0; i < xp_added.length; i++) {
            if (xp_added[i][0] > -1) {
                if (xp_added[i][2] >= 0) {
                    int transparency = 256;
                    if (xp_added[i][2] > 120)
                        transparency = (10 - (xp_added[i][2] - 120)) * 256 / 20;
                    if (transparency > 0) {
                        String s = "@whi@<shad=000000><trans=" + transparency + ">+"
                                + NumberFormat.getIntegerInstance().format(xp_added[i][1]);
                        int icons_x_off = 0;
                        Sprite sprite = null;
                        for (int i2 = 0; i2 < skill_sprites.length; i2++) {
                            if ((xp_added[i][0] & (1 << i2)) == 0)
                                continue;

                            sprite = skill_sprites[i2];
                            icons_x_off += sprite.myWidth + 3;
                            sprite.drawSprite(x - a + 12 - xp_font.getTextWidth(s) - icons_x_off,
                                    y + 157 + (140 - xp_added[i][2]) - (font_height / 2) - (sprite.myHeight / 2),
                                    transparency);
                        }
                        xp_font.drawBasicString(s, x - a + 12 - xp_font.getTextWidth(s),
                                y + 150 + (140 - xp_added[i][2]), 0xFF9900, -1);
                    }

                }

                xp_added[i][2]++;

                if (xp_added[i][2] >= (wilderness ? 60 : 240))
                    xp_added[i][0] = -1;
            }
        }
    }

    public void appearInChat(String x) {
        this.pushMessage(" ", 80, x);
        System.out.println("Reached appearInChat for: " + x);
    }

    public void loadExtraSprites() {
        for (int i = 0; i <= 1; ++i) {
            this.LOGINBUTTON[i] = new Sprite("Login/LOGINBUTTON " + i);
        }

    }

    public void drawTargetInfo() {
        Entity entity = targetedplayer ? playerArray[targetindex] : npcArray[targetindex];
        if (entity == null) {
            return;
        }
        if (Widget.interfaceCache[35000] == null) {
            return;
        }

        if (entity instanceof Npc && ((Npc) entity).desc == null) {
            return;
        }

        if (entity.maxHealth == 0) {
            return;
        }

        if (!hoverOverlay) {
            return;
        }

        String name = targetedplayer ? playerArray[targetindex].name : npcArray[targetindex].desc.name;
        double oponentsMaxHealth = entity.currentHealth;//currentHealth
        double oponentsHealth = entity.maxHealth;
        double percentage = oponentsHealth / oponentsMaxHealth;

        if (percentage > 1) {
            percentage = 1;
        }
        int width = (int) (135 * percentage);
        DrawingArea.drawAlphaGradient(3, 19, 145, 37, 000000, 000000, 100);
        DrawingArea.drawAlphaGradient(3, 19, 145, 37, 000000, 000000, 85);
        DrawingArea.drawAlphaGradient(9, 37, 135, 15, 0xCC0000, 0xCC0000, 100);// Health
        DrawingArea.drawAlphaGradient(9, 37, width, 15, 0x09900, 0x09900, 250);// Health
        newSmallFont.drawCenteredString((int) oponentsHealth + " / " + (int) oponentsMaxHealth, 75, 49, 0xFDFDFD,
                10);
        newSmallFont.drawCenteredString(name, 75, 32, 0xFDFDFD, 10);
    }

    public void setSpinClick(boolean spinClick) {
        this.spinClick = spinClick;
    }


    public void spin() {
        if (openInterfaceID != INTERFACE_ID || !spinClick) {
            return;
        }

        Widget items = Widget.interfaceCache[47100];
        Widget boxes = Widget.interfaceCache[47200];
        if (spins < 100) {
            shift(items, boxes, 8);
        } else if (spins < 200) {
            shift(items, boxes, 5);
        } else if (spins < 300) {
            shift(items, boxes, 4);
        } else if (spins < 400) {
            shift(items, boxes, 3);
        } else if (spins < 488) {
            shift(items, boxes, 2);
        } else if (spins < 562) {
            shift(items, boxes, 1);
        } else {
            spinComplete();
        }
    }
	 public int getOrbX(int orb) {
	        switch (orb) {
	        case 0:
	            return currentScreenMode != Main.ScreenMode.FIXED ? currentGameWidth - 207 : 172;
	        case 1:
	            return currentScreenMode != Main.ScreenMode.FIXED ? currentGameWidth - 210 : 188;
	        case 2:
	            return currentScreenMode != Main.ScreenMode.FIXED ? currentGameWidth - 198 : 188;
	        case 3:
	            return currentScreenMode != Main.ScreenMode.FIXED ? currentGameWidth - 176 : 172;
	        }
	        return 0;
	    }

	    public int getOrbY(int orb) {
	        switch (orb) {
	        case 0:
	            return currentScreenMode != Main.ScreenMode.FIXED ? 40 : 15;
	        case 1:
	            return currentScreenMode != Main.ScreenMode.FIXED ? 75 : 54;
	        case 2:
	            return currentScreenMode != Main.ScreenMode.FIXED ? 109 : 93;
	        case 3:
	            return currentScreenMode != Main.ScreenMode.FIXED ? 138 : 128;
	        }
	        return 0;
	    }
    private void shift(Widget items, Widget boxes, int shiftAmount) {
        items.childX[0] -= shiftAmount;
        for (int i = 0; i < BOXES64; i++) {
            boxes.childX[i] -= shiftAmount;
        }
        spins++;
    }

    private void spinComplete() {
        // Reset
        spins = 0;
        spinClick = false;
        spinNum++;
        // Notify server: spin complete
        stream.createFrame(145);
        stream.method432(696969);
        stream.method432(0);
        stream.method432(0);
    }

    public boolean handledPacket34(int frame) {
        if (openInterfaceID != INTERFACE_ID) {
            return false;
        }

        Widget items = Widget.interfaceCache[frame];
        while (incoming.currentOffset < packetSize) {
            int slot = incoming.method422();
            int itemId = incoming.readUnsignedWord();


            incoming.readUnsignedByte();
            int amount = incoming.readDWord();

            if (slot >= 0 && slot < items.inventoryItemId.length) {
                items.inventoryItemId[slot] = itemId;
                items.inventoryAmounts[slot] = amount;

                //System.out.println("item: "+itemId+", amount: "+amount);
            }
        }
        return true;
    }

    public void reset() {
        //System.out.println("test1");
        if (spinClick) {
            return;
        }

        //System.out.println("test2");

        spinNum = 0;
        Widget items = Widget.interfaceCache[47100];
        Widget boxes = Widget.interfaceCache[47200];
        items.childX[0] = 0;
        int x = 0;
        for (int z = 0; z < BOXES64; z++) {
            boxes.childX[z] = x;
            x += 2880;
        }
    }

    public void drawBlackBox(int xPos, int yPos) {
        DrawingArea.drawPixels(71, yPos - 1, xPos - 2, 7496785, 1);
        DrawingArea.drawPixels(69, yPos, xPos + 174, 7496785, 1);
        DrawingArea.drawPixels(1, yPos - 2, xPos - 2, 7496785, 178);
        DrawingArea.drawPixels(1, yPos + 68, xPos, 7496785, 174);
        DrawingArea.drawPixels(71, yPos - 1, xPos - 1, 3025699, 1);
        DrawingArea.drawPixels(71, yPos - 1, xPos + 175, 3025699, 1);
        DrawingArea.drawPixels(1, yPos - 1, xPos, 3025699, 175);
        DrawingArea.drawPixels(1, yPos + 69, xPos, 3025699, 175);
        DrawingArea.method335(0, yPos, 174, 68, 220, xPos);
    }

    private void aCoolMethod() {
        if (this.anInt546 == this.anInt547) {
            this.plane = 0;
        } else if (this.anInt546 == this.anInt548) {
            this.plane = 1;
        } else if (this.anInt546 == this.anInt549) {
            this.plane = 2;
        } else if (this.anInt546 == this.anInt550) {
            this.plane = 3;
        }

        // this.dropClient();
        System.out.println(myPlayer.name + " client was dropped. - plane:" + this.plane);
    }

    public void musics() {
        for (int MusicIndex = 0; MusicIndex < 3536; ++MusicIndex) {
            byte[] abyte0 = this.GetMusic(MusicIndex);
            if (abyte0 != null && abyte0.length > 0) {
                this.Indexes[3].method234(abyte0.length, abyte0, MusicIndex);
            }
        }

    }

    public byte[] GetMusic(int Indexes) {
        try {
            File var5 = new File("./Music/" + Indexes + ".gz");
            byte[] aByte = new byte[(int) var5.length()];
            FileInputStream Fis = new FileInputStream(var5);
            Fis.read(aByte);
            System.out.println(Indexes + " aByte = [" + aByte + "]!");
            Fis.close();
            return aByte;
        } catch (Exception var51) {
            return null;
        }
    }

    public void drawSpellTooltip(int x, int y, int width, int height, int alpha) {
        DrawingArea.drawAlphaFilledPixels(x, y, width, height, 0, alpha);
        Texture.drawRectangle(x + 1, y + 1, width, height - 1, 3025699, 255);
        Texture.drawRectangle(x, y, width - 1, height - 1, 7496785, 255);
    }

    public void tabToReplyPm() {
        String name = null;

        for (int var6 = 0; var6 < 100; ++var6) {
            if (this.chatMessages[var6] != null) {
                int l = this.chatTypes[var6];
                if (l == 3 || l == 7) {
                    name = this.chatNames[var6];
                    break;
                }
            }
        }

        if (name == null) {
            this.pushMessage("You haven\'t received any messages to which you can reply.", 0, "");
        } else {
            if (name.startsWith("@cr")) {
                name = name.substring(5);
            }

            long var61 = TextClass.longForName(name.trim());
            int k3 = -1;

            for (int i4 = 0; i4 < this.friendsCount; ++i4) {
                if (this.friendsListAsLongs[i4] == var61) {
                    k3 = i4;
                    break;
                }
            }

            if (k3 != -1) {
                if (this.friendsNodeIDs[k3] > 0) {
                    inputTaken = true;
                    inputDialogState = 0;
                    this.messagePromptRaised = true;
                    this.promptInput = "";
                    this.friendsListAction = 3;
                    this.aLong953 = this.friendsListAsLongs[k3];
                    this.aString1121 = "Enter message to send to " + this.friendsList[k3];
                } else {
                    this.pushMessage("That player is currently offline.", 0, "");
                }
            }
        }

    }

    public void loadTabArea() {
        if (oldGameframe == false && Gameframe508 == false) {
            for (int i = 0; i < redStones.length; i++)
                redStones[i] = new Sprite("GameframeOsrs/redstones/redstone" + i);

            for (int i = 0; i < sideIcons.length; i++)
                sideIcons[i] = new Sprite("GameframeOsrs/sideicons/sideicon" + i);

            mapArea[0] = new Sprite("GameframeOsrs/fixed/mapArea");
            mapArea[1] = new Sprite("GameframeOsrs/fixed/mapBorder");
            mapArea[2] = new Sprite("GameframeOsrs/resizable/mapArea");
            mapArea[3] = new Sprite("GameframeOsrs/fixed/blackMapArea");
            mapArea[4] = new Sprite("GameframeOsrs/resizable/mapBlack");
            mapArea[5] = new Sprite("GameframeOsrs/fixed/topframe");
            mapArea[6] = new Sprite("GameframeOsrs/fixed/chatborder");
            mapArea[7] = new Sprite("GameframeOsrs/fixed/frame");

            tabAreaFixed = new Sprite("GameframeOsrs/fixed/tabArea");
            compassImage = new Sprite("GameframeOsrs/compassImage");
        } else if (oldGameframe == true && Gameframe508 == false) {
            for (int i = 0; i < redStones.length; i++)
                redStones[i] = new Sprite("Gameframe317/redstones/redstone" + i);

            for (int i = 0; i < sideIcons.length; i++)
                sideIcons[i] = new Sprite("Gameframe317/sideicons/sideicon" + i);

            mapArea[0] = new Sprite("GameframeOsrs/fixed/mapArea");
            mapArea[1] = new Sprite("GameframeOsrs/fixed/mapBorder");
            mapArea[2] = new Sprite("GameframeOsrs/resizable/mapArea");
            mapArea[3] = new Sprite("GameframeOsrs/fixed/blackMapArea");
            mapArea[4] = new Sprite("GameframeOsrs/resizable/mapBlack");
            mapArea[5] = new Sprite("GameframeOsrs/fixed/topframe");
            mapArea[6] = new Sprite("GameframeOsrs/fixed/chatborder");
            mapArea[7] = new Sprite("GameframeOsrs/fixed/frame");

            tabAreaFixed = new Sprite("Gameframe317/fixed/tabArea");
            compassImage = new Sprite("Gameframe317/compassImage");
        } else if (oldGameframe == false && Gameframe508 == true) {
            for (int i = 0; i < redStones.length; i++)
                redStones[i] = new Sprite("Gameframe508/redstones/redstone" + i);

            for (int i = 0; i < sideIcons.length; i++)
                sideIcons[i] = new Sprite("Gameframe508/sideicons/sideicon" + i);

            mapArea[0] = new Sprite("Gameframe508/fixed/mapArea");
            mapArea[1] = new Sprite("Gameframe508/fixed/mapBorder");
            mapArea[2] = new Sprite("Gameframe508/resizable/mapArea");
            mapArea[3] = new Sprite("Gameframe508/fixed/blackMapArea");
            mapArea[4] = new Sprite("Gameframe508/resizable/mapBlack");
            mapArea[5] = new Sprite("Gameframe508/fixed/topframe");
            mapArea[6] = new Sprite("Gameframe508/fixed/chatborder");
            mapArea[7] = new Sprite("Gameframe508/fixed/frame");

            tabAreaFixed = new Sprite("Gameframe508/fixed/tabArea");
            compassImage = new Sprite("Gameframe508/compassImage");
            worldmap = new Sprite("Gameframe508/orbs/worldmap");
            worldmapborder = new Sprite("Gameframe508/orbs/44");
        }
    }

    public void setNewMaps() {
        try {
            BufferedReader var4 = new BufferedReader(new FileReader(SignLink.findcachedir() + "mapConfig.txt"));

            String s;
            int D;
            for (D = 0; (s = var4.readLine()) != null; ++D) {
                this.positions[D] = Integer.parseInt(s.substring(s.indexOf("=") + 1, s.indexOf("(")));
                this.landScapes[D] = Integer.parseInt(s.substring(s.indexOf("(") + 1, s.indexOf(")")));
                this.objects[D] = Integer.parseInt(s.substring(s.indexOf("[") + 1, s.indexOf("]")));
            }

            System.out.println("Total of " + D + " Maps added on the world map!");
        } catch (IOException var41) {
            var41.printStackTrace();
        }

    }

    public int getOrbTextColor(int statusInt) {
        return statusInt >= 75 && statusInt <= Integer.MAX_VALUE ? '\uff00'
                : (statusInt >= 50 && statusInt <= 74 ? 16776960
                : (statusInt >= 25 && statusInt <= 49 ? 16750623 : 16711680));
    }

    public int getOrbFill(int statusInt) {
        return statusInt <= Integer.MAX_VALUE && statusInt >= 97 ? 0
                : (statusInt <= 96 && statusInt >= 93 ? 1
                : (statusInt <= 92 && statusInt >= 89 ? 2
                : (statusInt <= 88 && statusInt >= 85 ? 3
                : (statusInt <= 84 && statusInt >= 81 ? 4
                : (statusInt <= 80 && statusInt >= 77 ? 5
                : (statusInt <= 76 && statusInt >= 73 ? 6
                : (statusInt <= 72 && statusInt >= 69 ? 7
                : (statusInt <= 68 && statusInt >= 65 ? 8
                : (statusInt <= 64 && statusInt >= 61
                ? 9
                : (statusInt <= 60
                && statusInt >= 57
                ? 10
                : (statusInt <= 56
                && statusInt >= 53
                ? 11
                : (statusInt <= 52
                && statusInt >= 49
                ? 12
                : (statusInt <= 48
                && statusInt >= 45
                ? 13
                : (statusInt <= 44
                && statusInt >= 41
                ? 14
                : (statusInt <= 40
                && statusInt >= 37
                ? 15
                : (statusInt <= 36
                && statusInt >= 33
                ? 16
                : (statusInt <= 32
                && statusInt >= 29
                ? 17
                : (statusInt <= 28
                && statusInt >= 25
                ? 18
                : (statusInt <= 24
                && statusInt >= 21
                ? 19
                : (statusInt <= 20
                && statusInt >= 17
                ? 20
                : (statusInt <= 16
                && statusInt >= 13
                ? 21
                : (statusInt <= 12
                && statusInt >= 9
                ? 22
                : (statusInt <= 8
                && statusInt >= 7
                ? 23
                : (statusInt <= 6
                && statusInt >= 5
                ? 24
                : (statusInt <= 4
                && statusInt >= 3
                ? 25
                : (statusInt <= 2
                && statusInt >= 1
                ? 26
                : (statusInt <= 0
                ? 27
                : 0)))))))))))))))))))))))))));
    }

    private void loadHpOrb(int xOffset) {
        int yOff = Constants.osbuddyGameframe ? currentScreenMode == ScreenMode.FIXED ? 0 : -5
                : currentScreenMode == ScreenMode.FIXED ? 0 : -5;
        int xOff = Constants.osbuddyGameframe ? currentScreenMode == ScreenMode.FIXED ? 0 : -6
                : currentScreenMode == ScreenMode.FIXED ? 0 : -6;
        String cHP = Widget.interfaceCache[4016].message;
        String mHP = Widget.interfaceCache[4017].message;
        int currentHP = Integer.parseInt(cHP);
        int maxHP = Integer.parseInt(mHP);
        int health = (int) (((double) currentHP / (double) maxHP) * 100D);
        int hover = poisonType == 0 ? 173 : 173;
        Sprite bg = cacheSprite3[hpHover ? hover : 172];
        int id = 0;
        Sprite fg = null;
        if (poisonType == 0) {
            id = 161;
            fg = cacheSprite3[id];
        }
        if (poisonType == 1) {
            id = 162;
            fg = cacheSprite3[id];
        }
        if (poisonType == 2) {
            id = 172;
            fg = cacheSprite3[id];
        }
        id = 0;
        if (poisonType == 1)
            id = 177;
        if (poisonType == 2)
            id = 5;
        bg.drawSprite(0 + xOffset - xOff, 41 - yOff);
        fg.drawSprite(27 + xOffset - xOff, 45 - yOff);
        if (getOrbFill(health) <= 26) {
            cacheSprite3[160].myHeight = getOrbFill(health);
        } else {
            cacheSprite3[160].myHeight = 26;
        }
        cacheSprite3[160].drawSprite(27 + xOffset - xOff, 45 - yOff);
        cacheSprite3[168].drawSprite(27 + xOffset - xOff, 45 - yOff);
        smallText.method382(getOrbTextColor(health), 15 + xOffset - xOff, "" + cHP, 67 - yOff, true);
    }

    private void drawSpecialOrb(int xOffset) {
        Sprite image = cacheSprite1[specialHover ? 8 : 7];
        Sprite fill = cacheSprite5[specialEnabled == 0 ? 9 : 6];
        Sprite sword = cacheSprite5[12];
        double percent = specialAttack / (double) 100;
        //int percent = 100;
        boolean isFixed = currentScreenMode == ScreenMode.FIXED;
        image.drawSprite((isFixed ? 37 : 37) + xOffset, isFixed ? 134 : 139);
        if (specialEnabled == 1) {
            //fill.drawSprite((isFixed ? 60 : 133) + xOffset, isFixed ? 134 : 151);
            fill.drawSprite((isFixed ? 63 : 63) + xOffset, isFixed ? 137 : 141);
        } else {
            fill.drawSprite((isFixed ? 64 : 64) + xOffset, isFixed ? 138 : 143);
            //fill.drawSprite((isFixed ? 65 : 133) + xOffset, isFixed ? 139 : 151);
        }
        sword.drawSprite((isFixed ? 65 : 65) + xOffset, isFixed ? 139 : 144);
        smallText.method382(getOrbTextColor((int) (percent * 100)),
                (isFixed ? 53 : 53) + xOffset, specialAttack + "", isFixed ? 159 : 164,
                true);
    }

    private void loadPrayerOrb(int xOffset) {
        int yOff = Constants.osbuddyGameframe ? currentScreenMode == ScreenMode.FIXED ? 10 : 2
                : currentScreenMode == ScreenMode.FIXED ? 0 : -5;
        int xOff = Constants.osbuddyGameframe ? currentScreenMode == ScreenMode.FIXED ? -1 : -7
                : currentScreenMode == ScreenMode.FIXED ? -1 : -7;
        Sprite bg = cacheSprite1[prayHover ? 8 : 7];
        Sprite fg = prayClicked ? new Sprite("GameframeOsrs/newprayclicked") : cacheSprite1[1];
        bg.drawSprite(0 + xOffset - xOff, 75 - yOff);
        fg.drawSprite(27 + xOffset - xOff, 79 - yOff);
        int level = Integer.parseInt(Widget.interfaceCache[4012].message.replaceAll("%", ""));
        int max = maximumLevels[5];
        double percent = level / (double) max;
        cacheSprite1[14].myHeight = (int) (26 * (1 - percent));
        cacheSprite1[14].drawSprite(27 + xOffset - xOff, 79 - yOff);
        if (percent <= .25) {
            cacheSprite1[10].drawSprite(30 + xOffset - xOff, 82 - yOff);
        } else {
            cacheSprite1[10].drawSprite(30 + xOffset - xOff, 82 - yOff);
        }
        smallText.method382(getOrbTextColor((int) (percent * 100)), 14 + xOffset - xOff, level + "", 101 - yOff, true);
    }

    private void loadRunOrb(int xOffset) {
        int current = Integer.parseInt(Widget.interfaceCache[149].message.replaceAll("%", ""));
        int yOff = Constants.osbuddyGameframe ? currentScreenMode == ScreenMode.FIXED ? 15 : 5
                : currentScreenMode == ScreenMode.FIXED ? 1 : -4;
        int xMinus = Constants.osbuddyGameframe ? currentScreenMode == ScreenMode.FIXED ? 11 : 5
                : currentScreenMode == ScreenMode.FIXED ? -1 : -6;
        Sprite bg = cacheSprite1[runHover ? 8 : 7];
        boolean running = anIntArray1045[173] == 1;
        Sprite fg = cacheSprite1[running ? 4 : 3];
        bg.drawSprite(10 + xOffset - xMinus, 109 - yOff);
        fg.drawSprite(37 + xOffset - xMinus, 113 - yOff);
        int level = current;
        double percent = level / (double) 100;
        cacheSprite1[14].myHeight = (int) (26 * (1 - percent));
        cacheSprite1[14].drawSprite(37 + xOffset - xMinus, 113 - yOff);
        if (percent <= .25) {
            cacheSprite1[running ? 12 : 11].drawSprite(43 + xOffset - xMinus, 117 - yOff);
        } else {
            cacheSprite1[running ? 12 : 11].drawSprite(43 + xOffset - xMinus, 117 - yOff);
        }
        smallText.method382(getOrbTextColor((int) (percent * 100)), 25 + xOffset - xMinus, level + "", 135 - yOff,
                true);
    }

    private void loadAllOrbs(int xOffset) {
        loadHpOrb(xOffset);
        loadPrayerOrb(xOffset);
        loadRunOrb(xOffset);
        drawSpecialOrb(xOffset);
		if (drawExperienceCounter) {
			if (counterHover) {
				cacheSprite2[5].drawSprite(
						Constants.loadOrbs && currentScreenMode == ScreenMode.FIXED ? 0 : currentGameWidth - 211,
						currentScreenMode == ScreenMode.FIXED ? 21 : 25);
			} else {
				cacheSprite2[3].drawSprite(
						Constants.loadOrbs && currentScreenMode == ScreenMode.FIXED ? 0 : currentGameWidth - 211,
						currentScreenMode == ScreenMode.FIXED ? 21 : 25);
			}
		} else {
			if (counterHover) {
				cacheSprite2[4].drawSprite(
						Constants.loadOrbs && currentScreenMode == ScreenMode.FIXED ? 0 : currentGameWidth - 211,
						currentScreenMode == ScreenMode.FIXED ? 21 : 25);
			} else {
				cacheSprite2[2].drawSprite(
						Constants.loadOrbs && currentScreenMode == ScreenMode.FIXED ? 0 : currentGameWidth - 211,
						currentScreenMode == ScreenMode.FIXED ? 21 : 25);
			}
		}
		if (currentScreenMode == ScreenMode.FIXED) {
		 //cacheSprite5[worldHover ? 5 : 4].drawSprite(202, 20);
		} else {
			// cacheSprite5[worldHover ? 3 : 2].drawSprite(Main.currentGameWidth - 118,
			//154);
		}
		//if (Configuration.osbuddyGameframe) {
			//loadSpecialOrb(xOffset);
		//}
        DrawingArea.drawAlphaBox(0, 0, 1, 200, 0x332B16, 250);
    }

    public void drawChannelButtons() {
        int yOffset = currentScreenMode == Main.ScreenMode.FIXED ? 0 : currentGameHeight - 165;
        this.gameframe[27].drawSprite(0, 143 + yOffset);
        String[] text = {"On", "Friends", "Off", "Hide", "Autochat"};
        int[] textColor = {65280, 0xffff00, 0xff0000, 65535, 0x0d9ddc};
        switch (this.cButtonCPos) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                this.gameframe[5].drawSprite(this.channelButtonsX[this.cButtonCPos], 143 + yOffset);
            default:
                if (this.cButtonHPos == this.cButtonCPos) {
                    switch (this.cButtonHPos) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            this.gameframe[6].drawSprite(this.channelButtonsX[this.cButtonHPos], 143 + yOffset);
                    }
                } else {
                    switch (this.cButtonHPos) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            this.gameframe[3].drawSprite(this.channelButtonsX[this.cButtonHPos], 143 + yOffset);
                            break;
                        case 6:
                            this.gameframe[8].drawSprite(this.channelButtonsX[this.cButtonHPos], 143 + yOffset);
                    }
                }

                int[] modes = new int[]{this.publicChatMode, this.privateChatMode, this.clanChatMode, this.tradeMode};

                int i;
                for (i = 0; i < this.modeNamesX.length; ++i) {
                    this.smallText.method389(true, this.modeNamesX[i], 16777215, this.modeNames[i],
                            this.modeNamesY[i] + yOffset);
                }

                for (i = 0; i < this.modeX.length; ++i) {
                    this.smallText.method382(textColor[modes[i]], this.modeX[i], text[modes[i]], 164 + yOffset, true);
                }

        }
    }
	public boolean logHover = false;
	public Sprite magicAuto;

	public Sprite[] xpOrb = new Sprite[2];
	public Sprite xpSprite;
	Sprite[] counter;

	public Sprite xpbg1 = new Sprite("487");
	public Sprite xpbg2 = new Sprite("488");

	private Queue<ExperienceDrop> experienceDrops = new LinkedList<>();

	private void processExperienceCounter() {
		if (loopCycle % 1 <= 1 && !experienceDrops.isEmpty()) {
			Collection<ExperienceDrop> remove = new ArrayList<>();
			for (ExperienceDrop drop : experienceDrops) {
				drop.pulse();
				if (drop.getYPosition() == -1) {
					experienceCounter += drop.getAmount();
					remove.add(drop);
				}
			}
			experienceDrops.removeAll(remove);
		}

		if (!drawExperienceCounter || openInterfaceID > -1) {
			return;
		}

		for (ExperienceDrop drop : experienceDrops) {
			String text = drop.toString();
			int x = (currentScreenMode == ScreenMode.FIXED ? 507 : currentGameWidth - 246)
					- newSmallFont.getTextWidth(text);
			int y = drop.getYPosition() - 15;
			int transparency = 256;
			newSmallFont.drawString(text, x, y, 0xFFFFFF, 0x000000, 256);
			for (int skill : drop.getSkills()) {
				if(skill==22){
					continue;
				}
				Sprite sprite = smallXpSprites[skill];
				x -= sprite.myWidth + 3;
				y -= sprite.myHeight - 4;
				sprite.drawAdvancedTransparentSprite(x, y, transparency);
				y += sprite.myHeight - 4;
			}
		}

		String experience = NumberFormat.getInstance().format(experienceCounter);

		xpbg1.drawAdvancedSprite(currentScreenMode == ScreenMode.FIXED ? 395 : currentGameWidth - 365, 6);
		xpbg2.drawSprite(currentScreenMode == ScreenMode.FIXED ? 398 : currentGameWidth - 363, 9);

		newSmallFont.drawBasicString(experience, (currentScreenMode == ScreenMode.FIXED ? 510 : currentGameWidth - 252)
				- newSmallFont.getTextWidth(experience), 24, 0xFFFFFF, 0x000000);
	}

	private boolean drawExperienceCounter = true;

    void sendPacket(int packet) {
        if (packet == 103) {
            stream.createFrame(103);
            stream.writeByte(inputString.length() - 1);
            stream.method405(inputString.substring(2));
            inputString = "";
        }

    }

    public void maps() {
        for (int MapIndex = 0; MapIndex < 5536; ++MapIndex) {
            byte[] abyte0 = this.GetMap(MapIndex);
            if (abyte0 != null && abyte0.length > 0) {
                this.Indexes[4].method234(abyte0.length, abyte0, MapIndex);
            }
        }

    }

    private void launchURL(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException var3) {
            var3.printStackTrace();
        }

    }

    public void currentScreenMode(Main.ScreenMode mode) {
        if (currentScreenMode == mode)
            return;

        JFrame component = ClientWindow.getFrame();

        component.dispose();
        currentScreenMode = mode;
        if (mode.isUndecorated()) {
            component.setUndecorated(true);
            component.setLocation(0, 0);
            component.setVisible(true);
        } else {
            if (component.isUndecorated()) {
                component.setUndecorated(false);
                component.setVisible(true);
            }
        }

        component.setMinimumSize(new Dimension(765, mode == ScreenMode.FIXED ? 503 : 610));
        //component.setMinimumSize(new Dimension(
        // mode == ScreenMode.FIXED ? 765+30 : 850,
        //mode == ScreenMode.FIXED ? 503+39 : 600));

        component.setResizable(mode.isResizable());
        Insets insets = ClientWindow.getInset();

        int clientWidth = mode.getWidth();
        int clientHeight = mode.getHeight();

        final int xInsetOffset = insets.left + insets.right;
        final int yInsetOffset = insets.top + insets.bottom;

        int totalClientWidth = clientWidth;
        int totalClientHeight = clientHeight;
        if (mode == ScreenMode.FIXED) {
            cameraZoom = 600;
            WorldController.viewDistance = 9;
        } else if (mode == ScreenMode.RESIZABLE) {
            cameraZoom = 700;
            WorldController.viewDistance = 10;
        } else if (mode == ScreenMode.FULLSCREEN) {
            cameraZoom = 800;
            WorldController.viewDistance = 10;
        }
        if (mode == ScreenMode.FULLSCREEN) {
/*			if (SystemUtils.IS_OS_MAC)
				component.setLocation(0, insets.top);*/
            totalClientWidth = (int) MAXIMUM_SCREEN_BOUNDS.getWidth();
            totalClientHeight = (int) MAXIMUM_SCREEN_BOUNDS.getHeight();
        } else {
            totalClientWidth += xInsetOffset;
            totalClientHeight += yInsetOffset;
        }

        component.setSize(totalClientWidth, totalClientHeight);

        currentGameWidth = totalClientWidth;
        currentGameHeight = totalClientHeight;

        gameScreenWidth = currentScreenMode == ScreenMode.FIXED ? 516 : totalClientWidth;
        gameScreenHeight = currentScreenMode == ScreenMode.FIXED ? 338 : totalClientHeight;

        if (mode != ScreenMode.FULLSCREEN)
            component.setLocationRelativeTo(null);

        component.setVisible(true);
        graphics = super.getGameComponent().getGraphics();
        setBounds();
    }

    private void loadSpecialOrb(int xOffset) {
        Sprite image = gameframe[specialHover ? 55 : 53];
        Sprite fill = gameframe[specialEnabled == 0 ? 51 : 52];
        Sprite sword = gameframe[54];
        double percent = specialAttack / (double) 100;
        boolean isFixed = currentScreenMode == ScreenMode.FIXED;
        image.drawSprite((isFixed ? 170 : 159) + xOffset, isFixed ? 122 : 147);
        fill.drawSprite((isFixed ? 174 : 163) + xOffset, isFixed ? 126 : 151);
        gameframe[36].myHeight = (int) (26 * (1 - percent));
        gameframe[36].drawSprite((isFixed ? 175 : 163) + xOffset, isFixed ? 127 : 151);
        sword.drawSprite((isFixed ? 179 : 168) + xOffset, isFixed ? 131 : 156);
        smallText.method382(getOrbTextColor((int) (percent * 100)), (isFixed ? 212 : 202) + xOffset, specialAttack + "",
                isFixed ? 148 : 173, true);
    }

    void mouseWheelDragged(int i, int j) {
        if (this.mouseWheelDown) {
            this.anInt1186 += i * 3;
            this.anInt1187 += j << 1;
        }

    }

    public void savePlayerData() {
        try {
            File file = new File(SignLink.findcachedir() + "/newsettings.dat");
            if (!file.exists()) {
                file.createNewFile();
            }
            DataOutputStream stream = new DataOutputStream(new FileOutputStream(file));
            if (stream != null) {
                stream.writeBoolean(rememberMe);
                stream.writeUTF(rememberMe ? myUsername : "");
                stream.writeBoolean(skillOrbs);
                stream.writeBoolean(expDrops);
                stream.writeBoolean(Constants.hdTexturing);
                stream.writeBoolean(Constants.hp);
                stream.writeBoolean(Constants.HPBarToggle);
                stream.writeBoolean(Constants.loadOrbs);
                stream.writeBoolean(Constants.roofsOff);
                stream.writeBoolean(Constants.distanceFog);
                stream.writeBoolean(hoverOverlay);
                stream.writeBoolean(NewMenu);
                //stream.writeBoolean(oldGameframe);
                //stream.writeBoolean(hideUsername);
                stream.write(settings[166]); //Brightness
                stream.write(settings[168]); //music

/*				for(int i = 0; i < 14; i++) {
					stream.writeByte(TabBindings.tabBindings[i]);
				}*/

                stream.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadPlayerData() throws IOException {

        File file = new File(SignLink.findcachedir() + "/newsettings.dat");
        if (!file.exists()) {
            return;
        }

        DataInputStream stream = new DataInputStream(new FileInputStream(file));

        try {

            rememberMe = stream.readBoolean();
            myUsername = stream.readUTF();
            skillOrbs = stream.readBoolean();
            expDrops = stream.readBoolean();
            Constants.hdTexturing = stream.readBoolean();
            Constants.hp = stream.readBoolean();
            Constants.HPBarToggle = stream.readBoolean();
            Constants.loadOrbs = stream.readBoolean();
            Constants.roofsOff = stream.readBoolean();
            Constants.distanceFog = stream.readBoolean();
            hoverOverlay = stream.readBoolean();
            NewMenu = stream.readBoolean();
            //oldGameframe = stream.readBoolean();
            //hideUsername = stream.readBoolean();
            int brightnessState = stream.readByte();
            int musicState = stream.readByte();
/*			for(int i = 0; i < TabBindings.tabBindings.length; i++) {
				TabBindings.tabBindings[i] = stream.readByte();
			}
		*/
            if (rememberMe) {
                if (myUsername.length() > 0) {
                    loginScreenCursorPos = 1;
                }
            }

            //Brightness
            if (brightnessState == 1) {
                Rasterizer.method372(0.9);
            } else if (brightnessState == 2) {
                Rasterizer.method372(0.8);
            } else if (brightnessState == 3) {
                Rasterizer.method372(0.7);
            } else if (brightnessState == 4) {
                Rasterizer.method372(0.6);
            }
            settings[166] = brightnessState;
            if (musicState == 0) {
                this.setMidiVolume(0);
                this.musicEnabled = true;
            } else if (musicState == 1) {
                this.setMidiVolume(16);
                this.musicEnabled = true;
            } else if (musicState == 2) {
                this.setMidiVolume(32);
                this.musicEnabled = true;
            } else if (musicState == 3) {
                this.setMidiVolume(64);
                this.musicEnabled = true;
            }
            settings[168] = musicState;


        } catch (IOException e) {
            file.delete();
        } finally {
            stream.close();
        }
    }

    private void updateSettings() {
        settings[809] = Constants.hdTexturing ? 1 : 0;
        settings[810] = Constants.hp ? 1 : 0;
        settings[811] = Constants.HPBarToggle ? 1 : 0;
        settings[812] = Constants.loadOrbs ? 1 : 0;
        //settings[813] = Constants.enableTweening ? 1 : 0;
        settings[813] = Constants.roofsOff ? 1 : 0;
        settings[814] = Constants.distanceFog ? 1 : 0;
        //settings[816] = Constants.escapeCloseInterface ? 1 : 0;
    }

    private void setBounds() {
        Rasterizer.method365(gameScreenHeight, gameScreenHeight);
        Rasterizer.method365(gameScreenWidth, gameScreenHeight);
        fullScreenTextureArray = Rasterizer.lineOffsets;
        Rasterizer.method365(
                currentScreenMode == ScreenMode.FIXED ? 516
                        : gameScreenWidth,
                currentScreenMode == ScreenMode.FIXED ? 168
                        : gameScreenHeight);
        anIntArray1180 = Rasterizer.lineOffsets;
        Rasterizer.method365(
                currentScreenMode == ScreenMode.FIXED ? 249
                        : gameScreenWidth,
                currentScreenMode == ScreenMode.FIXED ? 335
                        : gameScreenHeight);
        anIntArray1181 = Rasterizer.lineOffsets;
        Rasterizer.method365(gameScreenWidth, gameScreenHeight);
        anIntArray1182 = Rasterizer.lineOffsets;
        method456();
    }

    public void method456() {
        int[] ai = new int[9];
        for (int i8 = 0; i8 < 9; i8++) {
            int k8 = 128 + i8 * 32 + 15;
            int l8 = 600 + k8 * 3;
            int i9 = Rasterizer.anIntArray1470[k8];
            ai[i8] = (l8 * i9 >> 16);
        }
        if (currentScreenMode == ScreenMode.FIXED && (currentGameWidth >= 756) && (currentGameWidth <= 1025)
                && (currentGameHeight >= 494) && (currentGameHeight <= 850)) {
            WorldController.viewDistance = 9;
            cameraZoom = 575;
        } else if (currentScreenMode == ScreenMode.FIXED) {
            cameraZoom = 600;
        } else if (currentScreenMode != ScreenMode.FIXED) {
            WorldController.viewDistance = 10;
            cameraZoom = 600;
        }
        WorldController.method310(500, 800, currentScreenMode == ScreenMode.FIXED ? 516 : currentGameWidth,
                currentScreenMode == ScreenMode.FIXED ? 335 : currentGameHeight, ai);
        if (loggedIn) {
            aRSImageProducer_1165 = new RSImageProducer(gameScreenWidth, gameScreenHeight, getGameComponent());
        }
    }

    public boolean getMousePositions() {
        if (this.mouseInRegion(currentGameWidth - (currentGameWidth <= 1000 ? 240 : 420),
                currentGameHeight - (currentGameWidth <= 1000 ? 90 : 37), currentGameWidth, currentGameHeight)) {
            return false;
        } else {
            if (showChatComponents) {
                if (changeChatArea) {
                    if (super.mouseX > 0 && super.mouseX < 494 && super.mouseY > currentGameHeight - 175
                            && super.mouseY < currentGameHeight) {
                        return true;
                    }

                    if (super.mouseX > 494 && super.mouseX < 515 && super.mouseY > currentGameHeight - 175
                            && super.mouseY < currentGameHeight) {
                        return false;
                    }
                } else if (!changeChatArea && super.mouseX > 0 && super.mouseX < 519 && super.mouseY > currentGameHeight - 175
                        && super.mouseY < currentGameHeight) {
                    return false;
                }
            }

            if (this.mouseInRegion(currentGameWidth - 216, 0, currentGameWidth, 172)) {
                return false;
            } else if (!changeTabArea) {
                return (super.mouseX > 0 && super.mouseY > 0 && super.mouseY < currentGameWidth && super.mouseY < currentGameHeight) && (super.mouseX < currentGameWidth - 242 || super.mouseY < currentGameHeight - 335);
            } else {
                if (showTabComponents) {
                    if (currentGameWidth > 1000) {
                        return (super.mouseX < currentGameWidth - 420 || super.mouseX > currentGameWidth
                                || super.mouseY < currentGameHeight - 37 || super.mouseY > currentGameHeight)
                                && (super.mouseX <= currentGameWidth - 225 || super.mouseX >= currentGameWidth
                                || super.mouseY <= currentGameHeight - 37 - 274 || super.mouseY >= currentGameHeight);
                    } else return (super.mouseX < currentGameWidth - 210 || super.mouseX > currentGameWidth
                            || super.mouseY < currentGameHeight - 74 || super.mouseY > currentGameHeight)
                            && (super.mouseX <= currentGameWidth - 225 || super.mouseX >= currentGameWidth
                            || super.mouseY <= currentGameHeight - 74 - 274 || super.mouseY >= currentGameHeight);
                }

                return true;
            }
        }
    }

    public void drawOnBankInterface() {
        if (openInterfaceID == 5292 && Widget.interfaceCache[27000].message.equals("1")) {
            int tabs = Integer.parseInt(Widget.interfaceCache[27001].message);
            int tab = Integer.parseInt(Widget.interfaceCache[27002].message);

            int i;
            for (i = 0; i <= tabs; ++i) {
                Widget.interfaceCache[22025 + i].disabledSprite = new Sprite("Bank/TAB 3");
                Widget.interfaceCache[22025 + i].tooltip = "Click here to select tab " + (i + 1);
            }

            for (i = tabs + 1; i <= 8; ++i) {
                Widget.interfaceCache[22024 + i].disabledSprite = new Sprite("");
                Widget.interfaceCache[22024 + i].tooltip = "";
            }

            if (tabs != 8) {
                Widget.interfaceCache[22025 + tabs].disabledSprite = new Sprite("Bank/TAB 4");
                Widget.interfaceCache[22025 + tabs].tooltip = "Drag an item here to create a new tab";
            }

            if (tab == -1) {
                Widget.interfaceCache[22024].disabledSprite = new Sprite("Bank/TAB 1");
            } else if (tab > 0) {
                Widget.interfaceCache[22024 + tab].disabledSprite = new Sprite("Bank/TAB 2");
                Widget.interfaceCache[22024].disabledSprite = new Sprite("Bank/TAB 1");
            } else {
                Widget.interfaceCache[22024].disabledSprite = new Sprite("Bank/TAB 0");
            }

            Widget.interfaceCache[27000].message = "0";
        }

    }

    public boolean mouseInRegion(int x1, int y1, int x2, int y2) {
        return super.mouseX >= x1 && super.mouseX <= x2 && super.mouseY >= y1 && super.mouseY <= y2;
    }

    public boolean mouseMapPosition() {
        return super.mouseX < currentGameWidth - 21 || super.mouseX > currentGameWidth || super.mouseY < 0 || super.mouseY > 21;
    }

    public byte[] GetMap(int Indexes) {
        try {
            File var51 = new File("./Maps/" + Indexes + ".gz");
            byte[] aByte = new byte[(int) var51.length()];
            FileInputStream is = new FileInputStream(var51);
            is.read(aByte);
            System.out.println(Indexes + " aByte = [" + aByte + "]!");
            is.close();
            return aByte;
        } catch (Exception var5) {
            return null;
        }
    }

    public void deletethatobject(int i, int j) {
        int k1 = mapX - 6;
        int l1 = mapY - 6;
        int i2 = i - k1 * 8;
        int j2 = j - l1 * 8;
        byte byte0 = 10;
        int k2 = this.anIntArray1177[byte0];
        if (j2 > 0 && j2 < 103 && i2 > 0 && i2 < 103) {
            this.method130(404, -1, 6951, -1, k2, j2, 10, 0, i2, 0);
        }

    }

    private boolean clickConfigButton(int i) {
        System.out.println("" + i);
        switch (i) {
            case 31024:
                if (currentScreenMode != ScreenMode.FIXED) {
                    setConfigButton(i, true);
                    setConfigButton(31025, false);
                    setConfigButton(23005, false);
                    currentScreenMode(ScreenMode.FIXED);
                }
                return true;
            case 31028:
                if (currentScreenMode != ScreenMode.RESIZABLE) {
                    setConfigButton(i, true);
                    setConfigButton(31029, false);
                    setConfigButton(23005, false);
                    currentScreenMode(ScreenMode.RESIZABLE);
                }
                return true;

        }

        return false;
    }

    private void setConfigButton(int interfaceFrame, boolean configSetting) {
        int config = configSetting ? 1 : 0;
        anIntArray1045[interfaceFrame] = config;
        if (settings[interfaceFrame] != config) {
            settings[interfaceFrame] = config;
            // needDrawTabArea = true;
            if (dialogID != -1)
                inputTaken = true;
        }
    }

    public void makeGlobalObject(int i, int j, int k, int l, int i1, int j1) {
        int k1 = mapX - 6;
        int l1 = mapY - 6;
        int i2 = i - k1 * 8;
        int j2 = j - l1 * 8;
        byte byte0 = 10;
        int k2 = this.anIntArray1177[byte0];
        if (j2 > 0 && j2 < 103 && i2 > 0 && i2 < 103) {
            this.method130(404, -1, k, l, k2, j2, i1, j1, i2, 0);
        }

    }

    public void loadNewObjects() {
        this.makeGlobalObject(2807, 2787, 6943, 1, 10, 1);
        this.makeGlobalObject(2807, 2786, 6943, 1, 10, 1);
        this.makeGlobalObject(2807, 2785, 6943, 1, 10, 1);
        this.makeGlobalObject(2807, 2784, 6943, 1, 10, 1);
        this.makeGlobalObject(2807, 2783, 6943, 1, 10, 1);
    }

    public final void method15(int i) {
        SignLink.midifade = 0;
        SignLink.midi = "stop";
        if (i <= 0) {
            this.aBoolean1206 = !this.aBoolean1206;
        }

    }

    private final void minimapHovers() {
    	if(!Gameframe508){
        final boolean fixed = currentScreenMode == ScreenMode.FIXED;

        hpHover = fixed
                ? hpHover = super.mouseX >= 516 && super.mouseX <= 571 && super.mouseY >= 47 && super.mouseY < 72
                : super.mouseX >= currentGameWidth - 220 && super.mouseX <= currentGameWidth - 160 && super.mouseY >= 42
                && super.mouseY < 74;

        prayHover = fixed
                ? prayHover = super.mouseX >= 518 && super.mouseX <= 572 && super.mouseY >= 85 && super.mouseY < 117
                : super.mouseX >= currentGameWidth - 220 && super.mouseX <= currentGameWidth - 160 && super.mouseY >= 85
                && super.mouseY < 117;

        runHover = fixed
                ? runHover = super.mouseX >= 540 && super.mouseX <= 593 && super.mouseY >= 123 && super.mouseY < 154
                : super.mouseX >= currentGameWidth - 193 && super.mouseX <= currentGameWidth - 137 && super.mouseY >= 123
                && super.mouseY < 153;

        worldHover = fixed ? super.mouseX >= 710 && super.mouseX <= 738 && super.mouseY >= 130 && super.mouseY <= 154
                : super.mouseX >= currentGameWidth - 35 && super.mouseX <= currentGameWidth - 10 && super.mouseY >= 133
                && super.mouseY <= 160;

        // specialHover = fixed ? super.mouseX >= 686 && super.mouseX <= 742 &&
        // super.mouseY >= 124 && super.mouseY <= 156 :
        // super.mouseX >= currentGameWidth - 58 && super.mouseX <= currentGameWidth && super.mouseY
        // >= 151 && super.mouseY <= 179;

        		counterHover = fixed ? super.mouseX >= 522 && super.mouseX <= 544 && super.mouseY >= 20 && super.mouseY <= 47
        				: super.mouseX >= currentGameWidth - 205 && super.mouseX <= currentGameWidth - 184 && super.mouseY >= 27
        				&& super.mouseY <= 44;
    	} else {
    		prayHover = super.mouseX >= 704 && super.mouseX <= 760 && super.mouseY >= 49 && super.mouseY < 83;
    		runHover = super.mouseX >= 704 && super.mouseX <= 760 && super.mouseY >= 88 && super.mouseY < 120;
    		//sumHover = super.mouseX > 687 && super.mouseX < 744 && super.mouseY > 119 && super.mouseY < 157;
    		logHover = super.mouseX >= 744 && super.mouseX <= 765 && super.mouseY >= 3 && super.mouseY <= 19;
    	}
    }

    public void processMinimapActions() {
        boolean fixed = currentScreenMode == Main.ScreenMode.FIXED;
        if (fixed ? super.mouseX >= 542 && super.mouseX <= 579 && super.mouseY >= 2 && super.mouseY <= 38
                : super.mouseX >= currentGameWidth - 180 && super.mouseX <= currentGameWidth - 139 && super.mouseY >= 0
                && super.mouseY <= 40) {

            this.menuActionName[1] = "Look North";
            this.menuActionID[1] = 1150;
            this.menuActionRow = 2;
        }

        if (currentScreenMode != Main.ScreenMode.FIXED && changeTabArea && super.mouseX >= currentGameWidth - 26
                && super.mouseX <= currentGameWidth - 1 && super.mouseY >= 2 && super.mouseY <= 24) {
            this.menuActionName[1] = "Logout";
            this.menuActionID[1] = 700;
            this.menuActionRow = 2;
        }
        if (worldHover && Constants.loadOrbs) {
            menuActionName[1] = "Floating <col=ff9040>World Map";
            menuActionID[1] = 850;
            menuActionRow = 2;
        }
		if (counterHover && Constants.loadOrbs) {
			menuActionName[1] = "Reset @or1@XP total";
			menuActionID[1] = 475;
			menuActionName[2] = drawExperienceCounter ? "Hide @or1@XP drops" : "Show @or1@XP drops";
			menuActionID[2] = 474;
			menuActionRow = 3;
		}
        if (this.prayHover && Constants.loadOrbs) {
            this.menuActionName[2] = this.prayClicked ? "Turn quick-prayers off" : "Turn quick-prayers on";
            this.menuActionID[2] = 1500;
            this.menuActionRow = 2;
            this.menuActionName[1] = "Select quick-prayers";
            this.menuActionID[1] = 1506;
            this.menuActionRow = 3;
        }

        if (this.runHover && Constants.loadOrbs) {
        	if(!Gameframe508){
            this.menuActionName[1] = !this.runClicked ? "Turn run mode on" : "Turn run mode off";
            this.menuActionID[1] = 1050;
            this.menuActionRow = 2;
        	} else {
        	    if (mouseInRegion(currentScreenMode == Main.ScreenMode.FIXED ? currentGameWidth - 58 : getOrbX(2),
        	            getOrbY(2), (currentScreenMode == Main.ScreenMode.FIXED ? currentGameWidth - 58 : getOrbX(2)) + 57,
        	            getOrbY(2) + 34)) {
        			menuActionName[1] = !runClicked ? "Turn run mode on" : "Turn run mode off";
        			menuActionID[1] = 1050;
        			menuActionRow = 2;
        		}
        	}
        }

    }

    public void drawTransparentScrollBar(int x, int y, int height, int maxScroll, int pos) {
        this.gameframe[33].drawARGBSprite(x, y, 120);
        this.gameframe[34].drawARGBSprite(x, y + height - 16, 120);
        DrawingArea.drawVerticalLine(x, y + 16, height - 32, 16777215, 64);
        DrawingArea.drawVerticalLine(x + 15, y + 16, height - 32, 16777215, 64);
        int barHeight = (height - 32) * height / maxScroll;
        if (barHeight < 10) {
            barHeight = 10;
        }

        int barPos = 0;
        if (maxScroll != height) {
            barPos = (height - 32 - barHeight) * pos / (maxScroll - height);
        }

        DrawingArea.drawRectangle(x, y + 16 + barPos, 16, 5 + y + 16 + barPos + barHeight - 5 - (y + 16 + barPos),
                16777215, 32);
    }

    public void updateStrings(String str, int i) {
        switch (i) {
            case 1675:
                this.sendFrame126(str, 17508);
                break;
            case 1676:
                this.sendFrame126(str, 17509);
                break;
            case 1677:
                this.sendFrame126(str, 17510);
                break;
            case 1678:
                this.sendFrame126(str, 17511);
                break;
            case 1679:
                this.sendFrame126(str, 17512);
                break;
            case 1680:
                this.sendFrame126(str, 17513);
                break;
            case 1681:
                this.sendFrame126(str, 17514);
                break;
            case 1682:
                this.sendFrame126(str, 17515);
                break;
            case 1683:
                this.sendFrame126(str, 17516);
                break;
            case 1684:
                this.sendFrame126(str, 17517);
            case 1685:
            default:
                break;
            case 1686:
                this.sendFrame126(str, 17518);
                break;
            case 1687:
                this.sendFrame126(str, 17519);
        }

    }

    public void preloadModels() {
        File file = new File(SignLink.findcachedir() + "/raw/");
        File[] fileArray = file.listFiles();

        for (int y = 0; y < fileArray.length; ++y) {
            String sss = fileArray[y].getName();
            System.out.println("Parsing model file " + sss);
            byte[] buffer = ReadFile(SignLink.findcachedir() + "/raw/" + sss);
            Model.method460(buffer, Integer.parseInt(getFileNameWithoutExtension(sss)));
        }

    }

    public final boolean menuHasAddFriend(int j) {
        if (j < 0) {
            return false;
        } else {
            int k = this.menuActionID[j];
            if (k >= 2000) {
                k -= 2000;
            }

            return k == 337;
        }
    }

    public final String prefixRank(int s) {
        switch (s) {
            case 1:
                return "Lord ";
            case 2:
                return "Lady ";
            case 3:
                return "Sir ";
            case 4:
                return "Dame ";
            case 5:
                return "Duderino ";
            case 6:
                return "Dudette ";
            case 7:
                return "Lionheart ";
            case 8:
                return "Crusader ";
            case 9:
                return "Hellraiser ";
            case 10:
                return "Desperado ";
            case 11:
                return "Baron ";
            case 12:
                return "Baroness ";
            case 13:
                return "Count ";
            case 14:
                return "Countess ";
            case 15:
                return "Overlord ";
            case 16:
                return "Overlordess ";
            case 17:
                return "Bandito ";
            case 18:
                return "Duke ";
            case 19:
                return "Duchess ";
            case 20:
                return "Big Cheese ";
            case 21:
                return "Bigwig ";
            case 22:
                return "King ";
            case 23:
                return "Queen ";
            case 24:
                return "Wunderkind ";
            case 592:
                return "The eternal ";
            default:
                return "";
        }
    }

    public final String suffixRank(int s) {
        switch (s) {
            case 1000:
                return " the Brave";
            case 1001:
                return " the Warrior";
            case 1002:
                return " the Mage";
            case 1003:
                return " the Ranger";
            case 1004:
                return " the Cow";
            default:
                return "";
        }
    }

    public final String prefixColor(int s) {
        switch (s) {
            case 1:
                return "@or2@";
            case 2:
                return "@or2@";
            case 3:
                return "@or2@";
            case 4:
                return "@or2@";
            case 5:
                return "@or2@";
            case 6:
                return "@or2@";
            case 7:
                return "@or2@";
            case 8:
                return "@or2@";
            case 9:
                return "@or2@";
            case 10:
                return "@or2@";
            case 11:
                return "@or2@";
            case 12:
                return "@or2@";
            case 13:
                return "@red@";
            case 14:
                return "@red@";
            case 15:
                return "@red@";
            case 16:
                return "@red@";
            case 17:
                return "@or2@";
            case 18:
                return "@or2@";
            case 19:
                return "@or2@";
            case 20:
                return "@or2@";
            case 21:
                return "@or2@";
            case 22:
                return "@or2@";
            case 23:
                return "@or2@";
            case 24:
                return "@or2@";
            case 592:
                return "@whi@";
            default:
                return "@or2@";
        }
    }

    public final String suffixColor(int s) {
        switch (s) {
            case 1000:
                return "@or2@";
            case 1001:
                return "@or2@";
            case 1002:
                return "@or2@";
            case 1003:
                return "@or2@";
            case 1004:
                return "@whi@";
            default:
                return "@or2@";
        }
    }

    private boolean chatStateCheck() {
        return this.messagePromptRaised || inputDialogState != 0 || this.aString844 != null
                || backDialogID != -1 || this.dialogID != -1;
    }

    private void drawChatArea() {

        int yOffset = currentScreenMode == Main.ScreenMode.FIXED ? 0 : currentGameHeight - 165;
        final int yOffset2 = currentScreenMode == ScreenMode.FIXED ? 338 : 0;
        if (currentScreenMode == Main.ScreenMode.FIXED) {
            aRSImageProducer_1166.initDrawingArea();
        }

        Rasterizer.lineOffsets = anIntArray1180;
        if (this.chatStateCheck()) {
            showChatComponents = true;
            this.gameframe[0].drawSprite(0, yOffset);
        }

        if (showChatComponents) {
            if (changeChatArea && !this.chatStateCheck()) {
                DrawingArea.method339(7 + yOffset, 5723991, 506, 7);
                DrawingArea.drawAlphaGradient(7, 7 + yOffset, 506, 135, 0, 16777215, 20);
            } else {
                this.gameframe[0].drawSprite(0, yOffset);
            }
        }

        if (!showChatComponents || changeChatArea) {
            DrawingArea.drawAlphaPixels(7, currentGameHeight - 23, 506, 24, 0, 100);
        }

        this.drawChannelButtons();
        TextDrawingArea textDrawingArea = this.regularText;
        if (super.saveClickX >= 0 && super.saveClickX <= 518) {
            if (super.saveClickY >= (currentScreenMode == ScreenMode.FIXED ? 343 : currentGameHeight - 164)
                    && super.saveClickY <= (currentScreenMode == ScreenMode.FIXED ? 484 : currentGameHeight - 30)) {
                if (this.isFieldInFocus()) {
                    Main.inputString = "";
                    this.resetInputFieldFocus();
                }
            }
        }
        if (this.messagePromptRaised) {
            this.newBoldFont.drawCenteredString(this.aString1121, 259, 60 + yOffset, 0, -1);
            this.newBoldFont.drawCenteredString(this.promptInput + "*", 259, 80 + yOffset, 128, -1);
        } else if (inputDialogState == 1) {
            this.newBoldFont.drawCenteredString("Enter amount:", 259, yOffset + 60, 0, -1);
            this.newBoldFont.drawCenteredString(this.amountOrNameInput + "*", 259, 80 + yOffset, 128, -1);
        } else if (inputDialogState == 2) {
            this.newBoldFont.drawCenteredString("Enter Name:", 259, 60 + yOffset, 0, -1);
            this.newBoldFont.drawCenteredString(this.amountOrNameInput + "*", 259, 80 + yOffset, 128, -1);
        } else if (inputDialogState == 7) {
            newBoldFont.drawCenteredString("Enter the price for the item:", 259, 60 + yOffset, 0, -1);
            newBoldFont.drawCenteredString(amountOrNameInput + "*", 259, 80 + yOffset, 128, -1);
        } else if (inputDialogState == 8) {
            newBoldFont.drawCenteredString("Amount you want to sell:", 259, 60 + yOffset, 0, -1);
            newBoldFont.drawCenteredString(amountOrNameInput + "*", 259, 80 + yOffset, 128, -1);
        } else if (inputDialogState == 3) {
            DrawingArea.fillPixels(8, 505, 108, 0x463214, 28 + yOffset);
            DrawingArea.drawAlphaBox(8, 28 + yOffset, 505, 108, 0x746346, 75);

            newBoldFont.drawCenteredString(
                    "<col=0>What would you like to buy?</col> <col=0000FF>" + amountOrNameInput + "</col>*", 259,
                    20 + yOffset, 128, -1);
            if (amountOrNameInput != "") {
                grandExchangeItemSearch = new ItemSearch(amountOrNameInput, 100, true);

                final int xPosition = 15;
                final int yPosition = 32 + yOffset - grandExchangeSearchScrollPostion;
                int rowCountX = 0;
                int rowCountY = 0;

                int itemAmount = grandExchangeItemSearch.getItemSearchResultAmount();

                if (amountOrNameInput.length() == 0) {
                    newRegularFont.drawCenteredString("Start typing the name of an item to search for it.", 259,
                            70 + yOffset, 0, -1);
                } else if (itemAmount == 0) {
                    newRegularFont.drawCenteredString("No matching items found!", 259, 70 + yOffset, 0, -1);
                } else {
                    DrawingArea.setDrawingArea(134 + yOffset, 8, 497, 29 + yOffset);
                    for (int itemId = 0; itemId < itemAmount; itemId++) {
                        int[] itemResults = grandExchangeItemSearch.getItemSearchResults();

                        if (itemResults[itemId] != -1) {
                            final int startX = xPosition + rowCountX * 160;
                            final int startY = yPosition + rowCountY * 35;
                            Sprite itemSprite = ItemDefinition.getSprite(itemResults[itemId], 1, 0);
                            if (itemSprite != null)
                                itemSprite.drawSprite(startX, startY);

                            ItemDefinition itemDef = ItemDefinition.lookup(itemResults[itemId]);
                            newRegularFont.drawBasicString(itemDef.name, startX + 40, startY + 14, 0, -1);

                            if (super.mouseX >= startX && super.mouseX <= startX + 160) {
                                if (super.mouseY >= (startY + yOffset2) && super.mouseY <= (startY + yOffset2) + 35) {
                                    DrawingArea.drawAlphaBox(startX, startY, 160, 35, 0xFFFFFF, 120);

                                    if (super.clickMode3 == 1)
                                        handleGEItemSearchClick(itemDef.id);
                                }
                            }
                        }

                        rowCountX++;

                        if (rowCountX > 2) {
                            rowCountY++;
                            rowCountX = 0;
                        }
                    }
                    DrawingArea.defaultDrawingAreaSize();
                }

                int maxScrollPosition = itemAmount / 3 * 35;
                if (itemAmount > 9)
                    drawScrollbar(106,
                            grandExchangeSearchScrollPostion > maxScrollPosition ? 0 : grandExchangeSearchScrollPostion,
                            29 + yOffset, 496, itemAmount / 3 * 35, false);

            }
        } else if (this.aString844 != null) {
            this.newBoldFont.drawCenteredString(this.aString844, 259, 60 + yOffset, 0, -1);
            this.newBoldFont.drawCenteredString("Click to continue", 259, 80 + yOffset, 128, -1);
        } else if (backDialogID != -1) {
            this.drawInterface(0, 20, Widget.interfaceCache[backDialogID], 20 + yOffset);
        } else if (this.dialogID != -1) {
            this.drawInterface(0, 20, Widget.interfaceCache[this.dialogID], 20 + yOffset);
        } else if (showChatComponents) {
            int j77 = -3;
            int j = 0;
            int shadow = changeChatArea ? 0 : -1;
            DrawingArea.setDrawingArea(122 + yOffset, 8, 497, 7 + yOffset);

            int xOffset;
            for (int var16 = 0; var16 < 500; ++var16) {
                if (this.chatMessages[var16] != null) {
                    xOffset = this.chatTypes[var16];
                    int yPos = 70 - j77 * 14 + anInt1089 + 5;
                    String s1 = this.chatNames[var16];
                    byte byte0 = 0;
                    if (s1.startsWith("@cr")) {
                        String s2 = s1.substring(3);
                        int index = s2.indexOf("@");
                        if (index != -1) {
                            s2 = s2.substring(0, index);
                            byte0 = Byte.parseByte(s2);
                            s1 = s1.substring(4 + s2.length());
                        }
                    }

                    if (xOffset == 0 && (this.chatTypeView == 5 || this.chatTypeView == 0)) {
                        this.newRegularFont.drawBasicString(this.chatMessages[var16], 11, yPos + yOffset,
                                changeChatArea ? 16777215 : 0, shadow);
                        ++j;
                        ++j77;
                    }

                    int xPos;
                    if ((xOffset == 1 || xOffset == 2)
                            && (xOffset == 1 || this.publicChatMode == 0
                            || this.publicChatMode == 1 && this.isFriendOrSelf(s1))
                            && (this.chatTypeView == 1 || this.chatTypeView == 0)) {
                        xPos = 11;
                        if (byte0 > 0) {
                            for (int right = 0; right < ModIcons.length; right++) {
                                if (right == (byte0 - 1) && ModIcons[right] != null) {
                                    ModIcons[right].drawAdvancedSprite(xPos - 1,
                                            yPos + yOffset - ModIcons[right].myHeight);
                                    xPos += ModIcons[right].myWidth;
                                    if (right == 11) {
                                        xPos -= 2;
                                    }
                                    break;
                                }
                            }
                        }
                        String title = playerTitles[var16] != null ? playerTitles[var16] : "";
                        name = playerTitle.placement(name, title);

                        this.newRegularFont.drawBasicString(s1 + ":", xPos, yPos + yOffset,
                                changeChatArea ? 16777215 : 0, shadow);
                        xPos += textDrawingArea.getTextWidth(s1) + 8;
                        this.newRegularFont.drawBasicString(this.chatMessages[var16], xPos, yPos + yOffset,
                                changeChatArea ? 8366591 : 255, shadow);
                        ++j;
                        ++j77;
                    }

                    if ((xOffset == 3 || xOffset == 7) && (this.splitPrivateChat == 0 || this.chatTypeView == 2)
                            && (xOffset == 7 || this.privateChatMode == 0
                            || this.privateChatMode == 1 && this.isFriendOrSelf(s1))
                            && (this.chatTypeView == 2 || this.chatTypeView == 0)) {
                        byte j2 = 11;
                        this.newRegularFont.drawBasicString("From", j2, yPos + yOffset, changeChatArea ? 0 : 16777215,
                                shadow);
                        xPos = j2 + textDrawingArea.getTextWidth("From ");
                        if (byte0 > 0) {
                            for (int right = 0; right < ModIcons.length; right++) {
                                if (right == (byte0 - 1) && ModIcons[right] != null) {
                                    ModIcons[right].drawAdvancedSprite(xPos,
                                            yPos + yOffset - ModIcons[right].myHeight);
                                    xPos += ModIcons[right].myWidth;
                                    break;
                                }
                            }
                        }
                        this.newRegularFont.drawBasicString(s1 + ":", xPos, yPos + yOffset,
                                changeChatArea ? 16777215 : 0, shadow);
                        xPos += textDrawingArea.getTextWidth(s1) + 8;
                        this.newRegularFont.drawBasicString(this.chatMessages[var16], xPos, yPos + yOffset, 8388736,
                                shadow);
                        ++j;
                        ++j77;
                    }

                    if (xOffset == 4 && (this.tradeMode == 0 || this.tradeMode == 1 && this.isFriendOrSelf(s1))
                            && (this.chatTypeView == 3 || this.chatTypeView == 0)) {
                        this.newRegularFont.drawBasicString(s1 + " " + this.chatMessages[var16], 11, yPos + yOffset,
                                8388736, shadow);
                        ++j;
                        ++j77;
                    }

                    if (xOffset == 5 && this.splitPrivateChat == 0 && this.privateChatMode < 2
                            && (this.chatTypeView == 2 || this.chatTypeView == 0)) {
                        this.newRegularFont.drawBasicString(s1 + " " + this.chatMessages[var16], 11, yPos + yOffset,
                                8388736, shadow);
                        ++j;
                        ++j77;
                    }

                    if (xOffset == 6 && (this.splitPrivateChat == 0 || this.chatTypeView == 2)
                            && this.privateChatMode < 2 && (this.chatTypeView == 2 || this.chatTypeView == 0)) {
                        this.newRegularFont.drawBasicString("To " + s1 + ":", 11, yPos + yOffset,
                                changeChatArea ? 16777215 : 0, shadow);
                        this.newRegularFont.drawBasicString(this.chatMessages[var16],
                                15 + textDrawingArea.getTextWidth("To :" + s1), yPos + yOffset, 8388736, shadow);
                        ++j;
                        ++j77;
                    }

                    if (xOffset == 8 && (this.tradeMode == 0 || this.tradeMode == 1 && this.isFriendOrSelf(s1))) {
                        if (this.chatTypeView == 3 || this.chatTypeView == 0) {
                            this.newRegularFont.drawBasicString(s1 + " " + this.chatMessages[var16], 11, yPos + yOffset,
                                    8270336, shadow);
                            ++j;
                            ++j77;
                        }

                        if (xOffset == 11 && this.clanChatMode == 0) {
                            if (this.chatTypeView == 11) {
                                this.newRegularFont.drawBasicString(s1 + " " + this.chatMessages[var16], 11,
                                        yPos + yOffset, 8270336, shadow);
                                ++j;
                                ++j77;
                            }

                            if (xOffset == 12) {
                                this.newRegularFont.drawBasicString(this.chatMessages[var16], 11, yPos + yOffset,
                                        8270336, shadow);
                                ++j;
                            }
                        }
                        if (xOffset == 16) {
                            int j2 = 40 + 11;
                            String clanname = clanList[var16];
                            int clanNameWidth = textDrawingArea
                                    .getTextWidth(clanname);
                            if (chatTypeView == 11 || chatTypeView == 0) {
                                if (yPos > 0 && yPos < 110)
                                    if (this.chatRights[var16] > 0) {
                                        j2 += clanNameWidth;
                                        this.ModIcons[this.chatRights[var16] - 1].drawSprite(j2 - 18, yPos - 12);
                                        j2 += 15;
                                        if (this.chatRights[var16] == 0) {
                                            j2 += clanNameWidth;
                                            break;
                                        }
                                    }
                            }
                            newRegularFont
                                    .drawBasicString("[", 19, yPos, changeChatArea ? 0xffffff : 0, shadow);
                            newRegularFont.drawBasicString("]",
                                    clanNameWidth + 16 + 11, yPos, changeChatArea ? 0xffffff : 0, shadow);
                            newRegularFont.drawBasicString(""
                                            + capitalize(clanname) + "", 25, yPos, 255,
                                    -1);
                            newRegularFont.drawBasicString(
                                    capitalize(chatNames[var16]) + ":", j2 - 17,
                                    yPos);
                            j2 += newRegularFont.getTextWidth(chatNames[var16]) + 7;
                            newRegularFont.drawBasicString(
                                    capitalize(chatMessages[var16]), j2 - 16, yPos,
                                    0x800000, -1);

                            j++;
                            j77++;
                        }
                    }
                }
            }

            DrawingArea.defaultDrawingAreaSize();
            anInt1211 = j * 14 + 7 + 5;
            if (anInt1211 < 111) {
                anInt1211 = 111;
            }

			this.drawScrollbar(114, this.anInt1211 - anInt1089 - 113, 7 + yOffset, 496, this.anInt1211, changeChatArea);
			String s;
			if (myPlayer != null && myPlayer.name != null) {
				s = playerTitle.placement(myPlayer.name, playerTitle.title(myPlayer.title, myPlayer));
			} else {
				s = playerTitle.placement(TextClass.fixName(this.myUsername),
						playerTitle.title(myPlayer.title, myPlayer));
			}

			DrawingArea.setDrawingArea(140 + yOffset, 8, 509, 120 + yOffset);
			xOffset = 0;
			if (this.myPrivilege > 0) {
				this.ModIcons[this.myPrivilege - 1].drawSprite(10, 122 + yOffset);
				xOffset += 14;
			}

			this.newRegularFont.drawBasicString(s + ":", xOffset + 11, 133 + yOffset, changeChatArea ? 16777215 : 0,
					shadow);
			if (!isFieldInFocus())
			this.newRegularFont.drawBasicString(this.inputString + "*",
					xOffset + 12 + textDrawingArea.getTextWidth(s + ": "), 133 + yOffset,
					changeChatArea ? 8366591 : 255, shadow);
			DrawingArea.method339(121 + yOffset, changeChatArea ? 5723991 : 8418912, 506, 7);
			DrawingArea.defaultDrawingAreaSize();
		}

        if (this.menuOpen) {
            this.drawMenu(0, currentScreenMode == Main.ScreenMode.FIXED ? 338 : 0);
        }

        if (currentScreenMode == Main.ScreenMode.FIXED) {
            aRSImageProducer_1166.drawGraphics(338, super.graphics, 0);
        }

        aRSImageProducer_1165.initDrawingArea();
        Rasterizer.lineOffsets = anIntArray1182;
    }

    public void init() {
        try {
            anInt957 = 10;
            portOff = 0;
            setHighMem();
            isMembers = true;
            initClientFrame(currentScreenMode.getWidth(), currentScreenMode.getHeight());
            instance = this;
        } catch (Exception exception) {
            return;
        }

    }

    public final void method12(Runnable runnable, int i) {
        if (i > 10) {
            i = 10;
        }

        if (SignLink.mainapp != null) {
            SignLink.startthread(runnable, i);
        } else {
            super.method12(runnable, i);
        }

    }

    public Socket openSocket(int port) throws IOException {
        return new Socket(InetAddress.getByName(server), port);
    }

    private boolean processMenuClick() {
        if (activeInterfaceType != 0)
            return false;
        int j = super.clickMode3;
        if (spellSelected == 1 && super.saveClickX >= 516 && super.saveClickY >= 160 && super.saveClickX <= 765
                && super.saveClickY <= 205)
            j = 0;
        if (menuOpen) {
            if (j != 1) {
                int k = super.mouseX;
                int j1 = super.mouseY;
                if (menuScreenArea == 0) {
                    k -= 0;
                    j1 -= 0;
                }
                if (menuScreenArea == 1) {
                    k -= 516;
                    j1 -= 160;
                }
                if (menuScreenArea == 2) {
                    k -= 17;
                    j1 -= 343;
                }
                if (menuScreenArea == 3) {
                    k -= 516;
                    j1 -= 0;
                }
                if (k < menuOffsetX - 10 || k > menuOffsetX + menuWidth + 10 || j1 < menuOffsetY - 10
                        || j1 > menuOffsetY + menuHeight + 10) {
                    menuOpen = false;
                    if (menuScreenArea == 1)
                        needDrawTabArea = true;
                    if (menuScreenArea == 2)
                        inputTaken = true;
                }
            }
            if (j == 1) {
                int l = menuOffsetX;
                int k1 = menuOffsetY;
                int i2 = menuWidth;
                int k2 = super.saveClickX;
                int l2 = super.saveClickY;
                if (menuScreenArea == 0) {
                    k2 -= 0;
                    l2 -= 0;
                }
                if (menuScreenArea == 1) {
                    k2 -= 516;
                    l2 -= 160;
                }
                if (menuScreenArea == 2) {
                    k2 -= 17;
                    l2 -= 343;
                }
                if (menuScreenArea == 3) {
                    k2 -= 516;
                    l2 -= 0;
                }
                int i3 = -1;
                for (int j3 = 0; j3 < menuActionRow; j3++) {
                    int k3 = k1 + 31 + (menuActionRow - 1 - j3) * 15;
                    if (k2 > l && k2 < l + i2 && l2 > k3 - 13 && l2 < k3 + 3)
                        i3 = j3;
                }
                if (i3 != -1)
                    doAction(i3);
                menuOpen = false;
                if (menuScreenArea == 1)
                    needDrawTabArea = true;
                if (menuScreenArea == 2) {
                    inputTaken = true;
                }
            }
            return true;
        } else {
            if (j == 1 && menuActionRow > 0) {
                int i1 = menuActionID[menuActionRow - 1];
                if (i1 == 632 || i1 == 78 || i1 == 867 || i1 == 431 || i1 == 53 || i1 == 74 || i1 == 454 || i1 == 539
                        || i1 == 493 || i1 == 847 || i1 == 447 || i1 == 1125) {
                    int l1 = menuActionCmd2[menuActionRow - 1];
                    int j2 = menuActionCmd3[menuActionRow - 1];
                    Widget class9 = Widget.interfaceCache[j2];
                    if (class9.allowSwapItems || class9.replaceItems) {
                        aBoolean1242 = false;
                        anInt989 = 0;
                        anInt1084 = j2;
                        anInt1085 = l1;
                        activeInterfaceType = 2;
                        anInt1087 = super.saveClickX;
                        anInt1088 = super.saveClickY;
                        if (Widget.interfaceCache[j2].parentID == openInterfaceID)
                            activeInterfaceType = 1;
                        if (Widget.interfaceCache[j2].parentID == backDialogID)
                            activeInterfaceType = 3;
                        return true;
                    }
                }
            }
            if (j == 1 && (anInt1253 == 1 || menuHasAddFriend(menuActionRow - 1)) && menuActionRow > 2)
                j = 2;
            if (j == 1 && menuActionRow > 0)
                doAction(menuActionRow - 1);
            if (j == 2 && menuActionRow > 0)
                determineMenuSize();
            minimapHovers();
            return false;
        }
    }

    public void processChatModeClick() {
        final int yOffset = currentScreenMode == ScreenMode.FIXED ? 0 : currentGameHeight - 503;
        if (super.mouseX >= 5 && super.mouseX <= 61 && super.mouseY >= yOffset + 482 && super.mouseY <= yOffset + 503) {
            cButtonHPos = 0;
            inputTaken = true;
        } else if (super.mouseX >= 71 && super.mouseX <= 127 && super.mouseY >= yOffset + 482
                && super.mouseY <= yOffset + 503) {
            cButtonHPos = 1;
            inputTaken = true;
        } else if (super.mouseX >= 137 && super.mouseX <= 193 && super.mouseY >= yOffset + 482
                && super.mouseY <= yOffset + 503) {
            cButtonHPos = 2;
            inputTaken = true;
        } else if (super.mouseX >= 203 && super.mouseX <= 259 && super.mouseY >= yOffset + 482
                && super.mouseY <= yOffset + 503) {
            cButtonHPos = 3;
            inputTaken = true;
        } else if (super.mouseX >= 269 && super.mouseX <= 325 && super.mouseY >= yOffset + 482
                && super.mouseY <= yOffset + 503) {
            cButtonHPos = 4;
            inputTaken = true;
        } else if (super.mouseX >= 335 && super.mouseX <= 391 && super.mouseY >= yOffset + 482
                && super.mouseY <= yOffset + 503) {
            cButtonHPos = 5;
            inputTaken = true;
        } else if (super.mouseX >= 404 && super.mouseX <= 515 && super.mouseY >= yOffset + 482
                && super.mouseY <= yOffset + 503) {
            cButtonHPos = 6;
            inputTaken = true;
        } else {
            cButtonHPos = -1;
            inputTaken = true;
        }
        if (super.clickMode3 == 1) {
            if (super.saveClickX >= 5 && super.saveClickX <= 61 && super.saveClickY >= yOffset + 482
                    && super.saveClickY <= yOffset + 505) {
                if (currentScreenMode != ScreenMode.FIXED) {
                    if (setChannel != 0) {
                        cButtonCPos = 0;
                        chatTypeView = 0;
                        inputTaken = true;
                        setChannel = 0;
                    } else {
                        showChatComponents = !showChatComponents;
                    }
                } else {
                    cButtonCPos = 0;
                    chatTypeView = 0;
                    inputTaken = true;
                    setChannel = 0;
                }
            } else if (super.saveClickX >= 71 && super.saveClickX <= 127 && super.saveClickY >= yOffset + 482
                    && super.saveClickY <= yOffset + 505) {
                if (currentScreenMode != ScreenMode.FIXED) {
                    if (setChannel != 1 && currentScreenMode != ScreenMode.FIXED) {
                        cButtonCPos = 1;
                        chatTypeView = 5;
                        inputTaken = true;
                        setChannel = 1;
                    } else {
                        showChatComponents = !showChatComponents;
                    }
                } else {
                    cButtonCPos = 1;
                    chatTypeView = 5;
                    inputTaken = true;
                    setChannel = 1;
                }
            } else if (super.saveClickX >= 137 && super.saveClickX <= 193 && super.saveClickY >= yOffset + 482
                    && super.saveClickY <= yOffset + 505) {
                if (currentScreenMode != ScreenMode.FIXED) {
                    if (setChannel != 2 && currentScreenMode != ScreenMode.FIXED) {
                        cButtonCPos = 2;
                        chatTypeView = 1;
                        inputTaken = true;
                        setChannel = 2;
                    } else {
                        showChatComponents = !showChatComponents;
                    }
                } else {
                    cButtonCPos = 2;
                    chatTypeView = 1;
                    inputTaken = true;
                    setChannel = 2;
                }
            } else if (super.saveClickX >= 203 && super.saveClickX <= 259 && super.saveClickY >= yOffset + 482
                    && super.saveClickY <= yOffset + 505) {
                if (currentScreenMode != ScreenMode.FIXED) {
                    if (setChannel != 3 && currentScreenMode != ScreenMode.FIXED) {
                        cButtonCPos = 3;
                        chatTypeView = 2;
                        inputTaken = true;
                        setChannel = 3;
                    } else {
                        showChatComponents = !showChatComponents;
                    }
                } else {
                    cButtonCPos = 3;
                    chatTypeView = 2;
                    inputTaken = true;
                    setChannel = 3;
                }
            } else if (super.saveClickX >= 269 && super.saveClickX <= 325 && super.saveClickY >= yOffset + 482
                    && super.saveClickY <= yOffset + 505) {
                if (currentScreenMode != ScreenMode.FIXED) {
                    if (setChannel != 4 && currentScreenMode != ScreenMode.FIXED) {
                        cButtonCPos = 4;
                        chatTypeView = 11;
                        inputTaken = true;
                        setChannel = 4;
                    } else {
                        showChatComponents = !showChatComponents;
                    }
                } else {
                    cButtonCPos = 4;
                    chatTypeView = 11;
                    inputTaken = true;
                    setChannel = 4;
                }
            } else if (super.saveClickX >= 335 && super.saveClickX <= 391 && super.saveClickY >= yOffset + 482
                    && super.saveClickY <= yOffset + 505) {
                if (currentScreenMode != ScreenMode.FIXED) {
                    if (setChannel != 5 && currentScreenMode != ScreenMode.FIXED) {
                        cButtonCPos = 5;
                        chatTypeView = 3;
                        inputTaken = true;
                        setChannel = 5;
                    } else {
                        showChatComponents = !showChatComponents;
                    }
                } else {
                    cButtonCPos = 5;
                    chatTypeView = 3;
                    inputTaken = true;
                    setChannel = 5;
                }
            } else if (super.saveClickX >= 404 && super.saveClickX <= 515 && super.saveClickY >= yOffset + 482
                    && super.saveClickY <= yOffset + 505) {
                if (openInterfaceID == -1) {
                    clearTopInterfaces();
                    reportAbuseInput = "";
                    canMute = false;
                    for (int i = 0; i < Widget.interfaceCache.length; i++) {
                        if (Widget.interfaceCache[i] == null || Widget.interfaceCache[i].contentType != 600) {
                            continue;
                        }
                        reportAbuseInterfaceID = openInterfaceID = Widget.interfaceCache[i].parentID;
                        break;
                    }
                } else {
                    pushMessage("Please close the interface you have open before using 'report abuse'", 0, "");
                }
            }
        }
    }

    public String indexLocation(int cacheIndex, int index) {
        return "index" + cacheIndex + "/" + (index != -1 ? index + ".gz" : "");
    }

    private String forId(int type) {
        switch (type) {
            case 1:
                return "Models";
            case 2:
                return "Animations";
            case 3:
                return "Sounds";
            case 4:
                return "Maps";
        }
        return "";
    }

    public void repackCacheIndex(int cacheIndex) {
        System.out.println("Started repacking index " + cacheIndex + ".");
        int indexLength = new File(indexLocation(cacheIndex, -1)).listFiles().length;
        File[] file = new File(indexLocation(cacheIndex, -1)).listFiles();
        try {
            for (int index = 0; index < indexLength; index++) {
                int fileIndex = Integer.parseInt(getFileNameWithoutExtension(file[index].toString()));
                byte[] data = fileToByteArray(cacheIndex, fileIndex);
                if (data != null && data.length > 0) {
                    Indexes[cacheIndex].method234(data.length, data, fileIndex);
                    this.drawLoadingText(90, "Repacking " + forId(cacheIndex) + ", File: " + fileIndex + ".");
                    System.out.println("Repacked " + fileIndex + ".");
                } else {
                    System.out.println("Unable to locate index " + fileIndex + ".");
                }
            }
        } catch (Exception e) {
            System.out.println("Error packing cache index " + cacheIndex + ".");
        }
        System.out.println("Finished repacking " + cacheIndex + ".");
    }

    public byte[] fileToByteArray(int cacheIndex, int index) {
        try {
            if (this.indexLocation(cacheIndex, index).length() > 0 && this.indexLocation(cacheIndex, index) != null) {
                File var61 = new File(this.indexLocation(cacheIndex, index));
                byte[] fileData = new byte[(int) var61.length()];
                FileInputStream fis = new FileInputStream(var61);
                fis.read(fileData);
                fis.close();
                return fileData;
            } else {
                return null;
            }
        } catch (Exception var6) {
            return null;
        }
    }

    public final void method21(boolean flag, int i, byte[] abyte0) {
        SignLink.midifade = flag ? 1 : 0;
        SignLink.midisave(abyte0, abyte0.length);
        if (i != 0) {
            this.incomingPacket = this.incoming.readUnsignedByte();
        }

    }

    public final void method22() {
        try {
            this.anInt985 = -1;
            this.aClass19_1056.method256();
            this.aClass19_1013.method256();
            Rasterizer.method366();
            this.method23(false);
            this.worldController.method274(619);
            System.gc();
            this.loadNewObjects();

            for (int k = 0; k < 4; ++k)
                this.aClass11Array1230[k].method210();
            for (int k = 0; k < 4; ++k) {
                for (int j1 = 0; j1 < 104; ++j1) {
                    for (int i2 = 0; i2 < 104; ++i2)
                        this.byteGroundArray[k][j1][i2] = 0;
                }
            }
            ObjectManager var15 = new ObjectManager(this.byteGroundArray, this.anIntArrayArrayArray1214);
            int j1 = this.aByteArrayArray1183.length;
            byte var17 = 64;

            if (loggedIn)
                stream.createFrame(0);
            if (!this.aBoolean1159) {
                try {
                    byte[] i11;
                    for (int l2 = 0; l2 < j1; ++l2) {
                        int l3 = (this.anIntArray1234[l2] >> 8) * 64 - this.baseX;
                        int j5 = (this.anIntArray1234[l2] & 255) * 64 - this.baseY;
                        i11 = this.aByteArrayArray1183[l2];

                        if (i11 != null) {
                            var15.method180(i11, j5, l3, (this.mapRegionsX - 6) * 8, (this.mapRegionsY - 6) * 8,
                                    this.aClass11Array1230);
                        }
                    }

                    for (int l2 = 0; l2 < j1; ++l2) {
                        int l3 = (this.anIntArray1234[l2] >> 8) * 64 - this.baseX;
                        int j5 = (this.anIntArray1234[l2] & 255) * 64 - this.baseY;
                        i11 = this.aByteArrayArray1183[l2];
                        if (i11 == null && this.mapRegionsY < 800) {
                            var15.method174(j5, 64, 64, l3);
                        }
                    }

                    ++anInt1097;
                    if (anInt1097 > 160) {
                        anInt1097 = 0;
                        stream.createFrame(238);
                        stream.writeByte(96);
                    }

                    if (loggedIn)
                        stream.createFrame(0);

                    for (int l2 = 0; l2 < j1; ++l2) {
                        byte[] k11 = this.aByteArrayArray1247[l2];

                        if (k11 != null) {
                            int j5 = (this.anIntArray1234[l2] >> 8) * 64 - this.baseX;
                            int var19 = (this.anIntArray1234[l2] & 255) * 64 - this.baseY;
                            var15.method190(j5, this.aClass11Array1230, var19, this.worldController, k11);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            int i12;
            int j12;
            int k12;
            int var18;
            int var191;
            for (int l2 = 0; l2 < 4; ++l2) {
                for (int l3 = 0; l3 < 13; ++l3) {
                    for (int j5 = 0; j5 < 13; ++j5) {
                        int var19 = this.anIntArrayArrayArray1129[l2][l3][j5];
                        if (var19 != -1) {
                            int k8 = var19 >> 24 & 3;
                            var18 = var19 >> 1 & 3;
                            var191 = var19 >> 14 & 1023;
                            i12 = var19 >> 3 & 2047;
                            j12 = (var191 / 8 << 8) + i12 / 8;

                            for (k12 = 0; k12 < this.anIntArray1234.length; ++k12) {
                                if (this.anIntArray1234[k12] == j12 && this.aByteArrayArray1183[k12] != null) {
                                    var15.method179(k8, var18, this.aClass11Array1230, l3 * 8, (var191 & 7) * 8,
                                            this.aByteArrayArray1183[k12], (i12 & 7) * 8, l2, j5 * 8);
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            for (int l2 = 0; l2 < 13; ++l2) {
                for (int l3 = 0; l3 < 13; ++l3) {
                    int j5 = this.anIntArrayArrayArray1129[0][l2][l3];
                    if (j5 == -1)
                        var15.method174(l3 * 8, 8, 8, l2 * 8);
                }
            }
            if (loggedIn)
                stream.createFrame(0);
            for (int l2 = 0; l2 < 4; ++l2) {
                for (int l3 = 0; l3 < 13; ++l3) {
                    for (int j5 = 0; j5 < 13; ++j5) {
                        int var19 = this.anIntArrayArrayArray1129[l2][l3][j5];
                        if (var19 != -1) {
                            int k8 = var19 >> 24 & 3;
                            var18 = var19 >> 1 & 3;
                            var191 = var19 >> 14 & 1023;
                            i12 = var19 >> 3 & 2047;
                            j12 = (var191 / 8 << 8) + i12 / 8;

                            for (k12 = 0; k12 < this.anIntArray1234.length; ++k12) 
                            {
                                if (anIntArray1234[k12] != j12 || aByteArrayArray1247[k12] == null)
                                    continue;
                                var15.method183(this.aClass11Array1230, this.worldController, k8, l3 * 8,
                                        (i12 & 7) * 8, l2, this.aByteArrayArray1247[k12], (var191 & 7) * 8, var18,
                                        j5 * 8);
                                break;
                            }
                        }
                    }
                }
            }
                stream.createFrame(0);
            var15.method171(this.aClass11Array1230, this.worldController);
            aRSImageProducer_1165.initDrawingArea();
            if (loggedIn)
                stream.createFrame(0);
            int l2 = ObjectManager.maximumPlane;
            if (l2 > this.plane)
                l2 = this.plane;

            if (l2 < this.plane - 1)
                l2 = this.plane - 1;
            if (lowMem)

                this.worldController.method275(ObjectManager.maximumPlane, -34686);
            else

                this.worldController.method275(0, -34686);
            for (int l3 = 0; l3 < 104; ++l3) {
                for (int j5 = 0; j5 < 104; ++j5)
                    this.spawnGroundItem(l3, j5);
            }

            ++anInt1051;
            if (anInt1051 > 98) {
                anInt1051 = 0;
                if (loggedIn)
                    stream.createFrame(150);
            }

            this.method63(-919);
        } catch (Exception var171) {
            var171.printStackTrace();
        }

        ObjectDefinition.aClass12_785.method224();
        stream.createFrame(210);
        stream.writeDWord(0x3f008edd);
        System.gc();
        Rasterizer.method367();
        onDemandFetcher.method566();
        int k = (this.mapRegionsX - 6) / 8 - 1;
        int j1 = (this.mapRegionsX + 6) / 8 + 1;
        int i2 = (this.mapRegionsY - 6) / 8 - 1;
        int l2 = (this.mapRegionsY + 6) / 8 + 1;
        if (this.aBoolean1141) {
            k = 49;
            j1 = 50;
            i2 = 49;
            l2 = 50;
        }

        for (int l3 = k; l3 <= j1; ++l3) {
            for (int j5 = i2; j5 <= l2; ++j5)
                if (l3 == k || l3 == j1 || j5 == i2 || j5 == l2) {
                    int var19 = onDemandFetcher.method562(0, j5, l3);
                    if (var19 != -1)
                        onDemandFetcher.method560(var19, 3);
                    int k8 = onDemandFetcher.method562(1, j5, l3);
                    if (k8 != -1)
                        onDemandFetcher.method560(k8, 3);
                }
        }

    }

    public final void method23(boolean flag) {
        ObjectDefinition.aClass12_785.method224();
        ObjectDefinition.aClass12_780.method224();
        NpcDefinition.aClass12_95.method224();
        ItemDefinition.aClass12_159.method224();
        ItemDefinition.aClass12_158.method224();
        if (flag) {
            this.incomingPacket = -1;
        }

        Player.aClass12_1704.method224();
        Graphic.aClass12_415.method224();
    }

    public void sendStringAsLong(String string) {
        stream.createFrame(60);
        stream.writeQWord(TextClass.longForName(string));
    }

    private void method24(int i) {
        int[] ai = this.minimapImage.myPixels;
        int j = ai.length;

        int j1;
        for (j1 = 0; j1 < j; ++j1) {
            ai[j1] = 0;
        }

        int l1;
        int k2;
        for (j1 = 1; j1 < 103; ++j1) {
            l1 = 24628 + (103 - j1) * 512 * 4;

            for (k2 = 1; k2 < 103; ++k2) {
                if ((this.byteGroundArray[i][k2][j1] & 24) == 0) {
                    this.worldController.method309(ai, l1, i, k2, j1);
                }

                if (i < 3 && (this.byteGroundArray[i + 1][k2][j1] & 8) != 0) {
                    this.worldController.method309(ai, l1, i + 1, k2, j1);
                }

                l1 += 4;
            }
        }

        j1 = 16777215;
        l1 = 15597568;
        this.minimapImage.method343(0);

        int l2;
        for (k2 = 1; k2 < 103; ++k2) {
            for (l2 = 1; l2 < 103; ++l2) {
                if ((this.byteGroundArray[i][l2][k2] & 24) == 0) {
                    this.method50(k2, j1, l2, l1, i);
                }

                if (i < 3 && (this.byteGroundArray[i + 1][l2][k2] & 8) != 0) {
                    this.method50(k2, j1, l2, l1, i + 1);
                }
            }
        }

        aRSImageProducer_1165.initDrawingArea();
        this.anInt1071 = 0;

        for (k2 = 0; k2 < 104; ++k2) {
            for (l2 = 0; l2 < 104; ++l2) {
                int objectId = this.worldController.fetchGroundDecorationNewUID(this.plane, k2, l2);
                if (objectId >= 0) {
                    //i3 = i3 >> 14 & 32767;
                    int j3 = ObjectDefinition.forID(objectId).mapIcon;
                    if (j3 >= 0) {
                        int k3 = k2;
                        int l3 = l2;
                        if (j3 >= 15 && j3 <= 67) {
                            j3 -= 2;
                        } else if (j3 >= 68 && j3 <= 84) {
                            j3 -= 1;
                        }
                        this.aSpriteArray1140[this.anInt1071] = this.MapFunction[j3];
                        this.anIntArray1072[this.anInt1071] = k2;
                        this.anIntArray1073[this.anInt1071] = l2;
                        ++this.anInt1071;
                    }
                }
            }
        }

        /*
         * File directory = new File("MapImageDumps/"); if (!directory.exists()) {
         * directory.mkdir(); } BufferedImage bufferedimage = new
         * BufferedImage(minimapImage.myWidth, minimapImage.myHeight, 1);
         * bufferedimage.setRGB(0, 0, minimapImage.myWidth, minimapImage.myHeight,
         * minimapImage.myPixels, 0, minimapImage.myWidth); Graphics2D graphics2d =
         * bufferedimage.createGraphics(); graphics2d.dispose(); try { File file1 = new
         * File("MapImageDumps/"+(directory.listFiles().length+1)+".png");
         * ImageIO.write(bufferedimage, "png", file1); } catch (Exception e) {
         * e.printStackTrace(); }
         */

    }

    public final void spawnGroundItem(int i, int j) {
        NodeList class19 = this.aClass19ArrayArrayArray827[this.plane][i][j];
        if (class19 == null) {
            this.worldController.method295(this.plane, i, j);
        } else {
            int k = -99999999;
            Item obj = null;

            Item obj1;
            int i1;
            for (obj1 = (Item) class19.reverseGetFirst(); obj1 != null; obj1 = (Item) class19.reverseGetNext()) {
                ItemDefinition obj211 = ItemDefinition.lookup(obj1.anInt1558);
                i1 = obj211.value;
                if (obj211.stackable) {
                    i1 *= obj1.anInt1559 + 1;
                }

                if (i1 > k) {
                    k = i1;
                    obj = obj1;
                }
            }

            class19.method250(-493, obj);
            obj1 = null;
            Item obj2111 = null;

            for (Item i11 = (Item) class19.reverseGetFirst(); i11 != null; i11 = (Item) class19.reverseGetNext()) {
                if (i11.anInt1558 != obj.anInt1558 && obj1 == null) {
                    obj1 = i11;
                }

                if (i11.anInt1558 != obj.anInt1558 && i11.anInt1558 != obj1.anInt1558 && obj2111 == null) {
                    obj2111 = i11;
                }
            }

            i1 = i + (j << 7) + 1610612736;
            this.worldController.method281((byte) 7, i, i1, obj1, this.method42(this.plane, j * 128 + 64, i * 128 + 64),
                    obj2111, obj, this.plane, j);
        }

    }

    private void method26(boolean flag) {
        for (int j = 0; j < npcCount; j++) {
            Npc npc = npcArray[npcIndices[j]];
            int k = 0x20000000 + (npcIndices[j] << 14);
            if (npc == null || !npc.isVisible() || npc.desc.aBoolean93 != flag)
                continue;
            int l = npc.x >> 7;
            int i1 = npc.y >> 7;
            if (l < 0 || l >= 104 || i1 < 0 || i1 >= 104)
                continue;
            if (npc.anInt1540 == 1 && (npc.x & 0x7f) == 64 && (npc.y & 0x7f) == 64) {
                if (anIntArrayArray929[l][i1] == anInt1265)
                    continue;
                anIntArrayArray929[l][i1] = anInt1265;
            }
            if (!npc.desc.aBoolean84)
                k += 0x80000000;
            worldController.method285(plane, npc.anInt1552, method42(plane, npc.y, npc.x), k, npc.y,
                    (npc.anInt1540 - 1) * 64 + 60, npc.x, npc, npc.aBoolean1541);
        }
    }

    private void menuActionsRow(String action, int index, int actionID, int row) {
        if (!this.menuOpen) {
            this.menuActionName[index] = action;
            this.menuActionID[index] = actionID;
            this.menuActionRow = row;
        }

    }
/*	private void method50(int i, int primaryColor, int l, int i1, int j1) {
		int k1 = this.worldController.method300(j1, l, i);
		if ((k1 ^ 0xffffffffffffffffL) != -1L) {
			int j2 = this.worldController.method304(j1, l, i, k1);
			int class46 = j2 >> 6 & 3;
			int type = j2 & 31;
			int i4 = primaryColor;
			if (k1 > 0)
				i4 = i1;

			int[] j4 = this.minimapImage.myPixels;
			int l4 = 24624 + l * 4 + (103 - i) * 512 * 4;
			int ai1 = worldController.fetchWallDecorationNewUID(j1, l, i);
			ObjectDefinition l5 = ObjectDefinition.forID(ai1);
			if ((l5.mapscene ^ 0xffffffff) == 0) {
				if (type == 0 || type == 2) {
					if (class46 == 0) {
						j4[l4] = i4;
						j4[l4 + 512] = i4;
						j4[l4 + 1024] = i4;
						j4[l4 + 1536] = i4;
					} else if (class46 == 1) {
						j4[l4] = i4;
						j4[l4 + 1] = i4;
						j4[l4 + 2] = i4;
						j4[l4 + 3] = i4;
					} else if (class46 == 2) {
						j4[l4 + 3] = i4;
						j4[l4 + 3 + 512] = i4;
						j4[l4 + 3 + 1024] = i4;
						j4[l4 + 3 + 1536] = i4;
					} else if (class46 == 3) {
						j4[l4 + 1536] = i4;
						j4[l4 + 1536 + 1] = i4;
						j4[l4 + 1536 + 2] = i4;
						j4[l4 + 1536 + 3] = i4;
					}
				}

				if (type == 3) {
					if (class46 == 0) {
						j4[l4] = i4;
					} else if (class46 == 1) {
						j4[l4 + 3] = i4;
					} else if (class46 == 2) {
						j4[l4 + 3 + 1536] = i4;
					} else if (class46 == 3) {
						j4[l4 + 1536] = i4;
					}
				}

				if (type == 2) {
					if (class46 == 3) {
						j4[l4] = i4;
						j4[l4 + 512] = i4;
						j4[l4 + 1024] = i4;
						j4[l4 + 1536] = i4;
					} else if (class46 == 0) {
						j4[l4] = i4;
						j4[l4 + 1] = i4;
						j4[l4 + 2] = i4;
						j4[l4 + 3] = i4;
					} else if (class46 == 1) {
						j4[l4 + 3] = i4;
						j4[l4 + 3 + 512] = i4;
						j4[l4 + 3 + 1024] = i4;
						j4[l4 + 3 + 1536] = i4;
					} else if (class46 == 2) {
						j4[l4 + 1536] = i4;
						j4[l4 + 1536 + 1] = i4;
						j4[l4 + 1536 + 2] = i4;
						j4[l4 + 1536 + 3] = i4;
					}
				}
			}
		}

		k1 = this.worldController.method302(j1, l, i);
		if (k1 != 0) {
			int j2 = this.worldController.method304(j1, l, i, k1);
			int class46 = j2 >> 6 & 3;
			int background = j2 & 31;
			int i4 = worldController.fetchObjectMeshNewUID(j1, l, i);
			ObjectDefinition j41 = ObjectDefinition.forID(i4);
			int l51;
			if (j41.mapscene != -1) {
				Sprite l41 = this.aBackgroundArray1060[j41.mapscene];
				if (l41 != null) {
					int ai1 = (j41.width * 4 - l41.myWidth) / 2;
					l51 = (j41.length * 4 - l41.myHeight) / 2;
					l41.drawSprite(48 + l * 4 + ai1, 48 + (104 - i - j41.length) * 4 + l51);
				}
			} else if (background == 9) {
				int l4 = 15658734;
				if (k1 > 0) {
					l4 = 15597568;
				}

				int[] ai11 = this.minimapImage.myPixels;
				l51 = 24624 + l * 4 + (103 - i) * 512 * 4;
				if (class46 != 0 && class46 != 2) {
					ai11[l51] = l4;
					ai11[l51 + 512 + 1] = l4;
					ai11[l51 + 1024 + 2] = l4;
					ai11[l51 + 1536 + 3] = l4;
				} else {
					ai11[l51 + 1536] = l4;
					ai11[l51 + 1024 + 1] = l4;
					ai11[l51 + 512 + 2] = l4;
					ai11[l51 + 3] = l4;
				}
			}
		}

		k1 = this.worldController.fetchGroundDecorationNewUID(j1, l, i);
		if (k1 > 0) {
			ObjectDefinition class461 = ObjectDefinition.forID(k1);
			if (class461.mapscene != -1) {
				Sprite background1 = this.aBackgroundArray1060[class461.mapscene];
				if (background1 != null) {
					int i4 = (class461.width * 4 - background1.myWidth) / 2;
					int j42 = (class461.length * 4 - background1.myHeight) / 2;
					background1.drawSprite(48 + l * 4 + i4, 48 + (104 - i - class461.length) * 4 + j42);
				}
			}
		}

	}*/

    public final boolean method27(int i) {
        if (i != 11456) {
            throw new NullPointerException();
        } else {
            return SignLink.wavereplay();
        }
    }

    public final void buildInterfaceMenu(int i, Widget class9, int k, int l, int i1, int j1) {
        if (class9 == null) {
            return;
        }
        if (class9.type != 0 || class9.children == null || class9.isMouseoverTriggered)
            return;
        if (k < i || i1 < l || k >= i + class9.width || i1 >= l + class9.height)
            return;
        int k1 = class9.children.length;

        for (int l1 = 0; l1 < k1; ++l1) {
            int i2 = class9.childX[l1] + i;
            int j2 = class9.childY[l1] + l - j1;
            Widget class9_1 = Widget.interfaceCache[class9.children[l1]];
            if (class9_1.isMouseoverTriggered && anInt886 != class9_1.id)
                continue;
            i2 += class9_1.anInt263;
            j2 += class9_1.anInt265;
            if (class9_1.type == 22) {
                Widget class9_2;
                int slot = class9_1.grandExchangeSlot;
                if (grandExchangeInformation[slot][0] == -1)
                    class9_2 = Widget.interfaceCache[GrandExchange.grandExchangeBuyAndSellBoxIds[slot]];
                else
                    class9_2 = Widget.interfaceCache[GrandExchange.grandExchangeItemBoxIds[slot]];
                buildInterfaceMenu(i2, class9_2, k, j2, i1, j1);
            }
            if (class9_1.type == 9 && k >= i2 && i1 >= j2 && k < i2 + class9_1.width && i1 < j2 + class9_1.height) {
                anInt1315 = class9_1.id;
            }
            if ((class9_1.hoverType >= 0 || class9_1.defaultHoverColor != 0) && k >= i2 && i1 >= j2
                    && k < i2 + class9_1.width && i1 < j2 + class9_1.height) {
                if (class9_1.hoverType >= 0) {
                    this.anInt886 = class9_1.hoverType;
                } else {
                    this.anInt886 = class9_1.id;
                }
            }

            if (class9_1.type == 8 && k >= i2 && i1 >= j2 && k < i2 + class9_1.width && i1 < j2 + class9_1.height) {
                this.anInt1315 = class9_1.id;
            }

            if (class9_1.type == 0) {
                this.buildInterfaceMenu(i2, class9_1, k, j2, i1, class9_1.scrollPosition);
                if (class9_1.scrollMax > class9_1.height) {
                    this.method65(i2 + class9_1.width, class9_1.height, k, i1, class9_1, j2, true,
                            class9_1.scrollMax, 0);
                }
            } else {
                if (class9_1.atActionType == 1 && k >= i2 && i1 >= j2 && k < i2 + class9_1.width
                        && i1 < j2 + class9_1.height) {
                    boolean var21 = false;
                    if (class9_1.contentType != 0) {
                        var21 = this.buildFriendsListMenu(class9_1);
                    }

                    if (!var21 && (class9_1.id != 5985 || this.myPrivilege == 1 || this.myPrivilege == 2
                            || this.myPrivilege == 9 || this.myPrivilege == 10 || this.myPrivilege == 4)) {
                        this.menuActionName[this.menuActionRow] = class9_1.tooltip;
                        this.menuActionID[this.menuActionRow] = 315;
                        this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                        ++this.menuActionRow;
                    }
                }

                if (class9_1.atActionType == 2 && this.spellSelected == 0 && k >= i2 && i1 >= j2
                        && k < i2 + class9_1.width && i1 < j2 + class9_1.height) {
                    String var20 = class9_1.selectedActionName;
                    if (var20.indexOf(" ") != -1) {
                        var20 = var20.substring(0, var20.indexOf(" "));
                    }

                    this.menuActionName[this.menuActionRow] = var20 + " <col=65280>" + class9_1.spellName;
                    this.menuActionID[this.menuActionRow] = 626;
                    this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                    ++this.menuActionRow;
                }

                if (class9_1.atActionType == 3 && k >= i2 && i1 >= j2 && k < i2 + class9_1.width
                        && i1 < j2 + class9_1.height) {
                    this.menuActionName[this.menuActionRow] = "Close";
                    this.menuActionID[this.menuActionRow] = 200;
                    this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                    ++this.menuActionRow;
                }

                if (class9_1.atActionType == 4 && k >= i2 && i1 >= j2 && k < i2 + class9_1.width
                        && i1 < j2 + class9_1.height) {
                    this.menuActionName[this.menuActionRow] = class9_1.tooltip;
                    this.menuActionID[this.menuActionRow] = 169;
                    this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                    ++this.menuActionRow;
                }

                if (class9_1.atActionType == 5 && k >= i2 && i1 >= j2 && k < i2 + class9_1.width
                        && i1 < j2 + class9_1.height) {
                    this.menuActionName[this.menuActionRow] = class9_1.tooltip;
                    this.menuActionID[this.menuActionRow] = 646;
                    this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                    ++this.menuActionRow;
                }

                if (class9_1.atActionType == 6 && !this.aBoolean1149 && k >= i2 && i1 >= j2
                        && k < i2 + class9_1.width && i1 < j2 + class9_1.height) {
                    this.menuActionName[this.menuActionRow] = class9_1.tooltip;
                    this.menuActionID[this.menuActionRow] = 679;
                    this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                    ++this.menuActionRow;
                }
                if (class9_1.atActionType == 8 && !aBoolean1149 && k >= i2 && i1 >= j2 && k < i2 + class9_1.width
                        && i1 < j2 + class9_1.height) {
                    for (int s1 = 0; s1 < class9_1.tooltips.length; s1++) {
                        menuActionName[menuActionRow] = class9_1.tooltips[s1];
                        menuActionID[menuActionRow] = 1700 + s1;
                        menuActionCmd3[menuActionRow] = class9_1.id;
                        menuActionRow++;
                    }
                    if (class9_1.atActionType == 11 && k >= i2 && i1 >= j2 && k < i2 + class9_1.width
                            && i1 < j2 + class9_1.height) {
                        menuActionName[menuActionRow] = class9_1.tooltip;
                        menuActionID[menuActionRow] = 201;
                        menuActionCmd3[menuActionRow] = class9_1.id;
                        menuActionRow++;
                    }
                }
                // clan chat
                if (k >= i2 && i1 >= j2
                        && k < i2 + (class9_1.type == 4 ? 100 : class9_1.width)
                        && i1 < j2 + class9_1.height) {
                    if (class9_1.actions != null) {
                        if ((class9_1.type == 4 && class9_1.message.length() > 0)
                                || class9_1.type == 5) {
                            for (int action = class9_1.actions.length - 1; action >= 0; action--) {
                                if (class9_1.actions[action] != null) {
                                    menuActionName[menuActionRow] = class9_1.actions[action]
                                            + (class9_1.type == 4 ? " "
                                            + class9_1.message : "");
                                    menuActionID[menuActionRow] = 647;
                                    menuActionCmd2[menuActionRow] = action;
                                    menuActionCmd3[menuActionRow] = class9_1.id;
                                    menuActionRow++;
                                }
                            }
                        }
                    }
                }
                if (class9_1.type == 2) {
                    int var211 = 0;

                    for (int l2 = 0; l2 < class9_1.height; ++l2) {
                        for (int i3 = 0; i3 < class9_1.width; ++i3) {
                            boolean smallSprite = openInterfaceID == 26000
                                    && GrandExchange.isSmallItemSprite(class9_1.id);
                            int size = smallSprite ? 18 : 32;
                            int j3 = i2 + i3 * (size + class9_1.spritePaddingX);
                            int k3 = j2 + l2 * (size + class9_1.spritePaddingY);
                            if (var211 < 20) {
                                j3 += class9_1.spritesX[var211];
                                k3 += class9_1.spritesY[var211];
                            }

                            if (k >= j3 && i1 >= k3 && k < j3 + size && i1 < k3 + size) {
                                this.mouseInvInterfaceIndex = var211;
                                this.lastActiveInvInterface = class9_1.id;
                                if (class9_1.inventoryItemId[var211] > 0) {
                                    ItemDefinition class8 = ItemDefinition.lookup(class9_1.inventoryItemId[var211] - 1);
                                    boolean hasDestroyOption = false;
                                    if (this.itemSelected == 1 && class9_1.hasActions) {
                                        if (class9_1.id != this.anInt1284 || var211 != this.anInt1283) {
                                            this.menuActionName[this.menuActionRow] = "Use " + this.aString1286
                                                    + " with <col=ff9040>" + class8.name;
                                            this.menuActionID[this.menuActionRow] = 870;
                                            this.menuActionCmd1[this.menuActionRow] = class8.id;
                                            this.menuActionCmd2[this.menuActionRow] = var211;
                                            this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                                            ++this.menuActionRow;
                                        }
                                    } else if (this.spellSelected == 1 && class9_1.hasActions) {
                                        if ((this.anInt1138 & 16) == 16) {
                                            this.menuActionName[this.menuActionRow] = this.aString1139 + " <col=ff9040>"
                                                    + class8.name;
                                            this.menuActionID[this.menuActionRow] = 543;
                                            this.menuActionCmd1[this.menuActionRow] = class8.id;
                                            this.menuActionCmd2[this.menuActionRow] = var211;
                                            this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                                            ++this.menuActionRow;
                                        }
                                    } else {
                                        if (class9_1.hasActions) {
                                            for (int j4 = 4; j4 >= 3; --j4)
                                                if (class8.itemActions != null && class8.itemActions[j4] != null) {
                                                    this.menuActionName[this.menuActionRow] = class8.itemActions[j4]
                                                            + " <col=ff9040>" + class8.name;
                                                    if (j4 == 3)
                                                        this.menuActionID[this.menuActionRow] = 493;

                                                    if (j4 == 4)
                                                        this.menuActionID[this.menuActionRow] = 847;
                                                    hasDestroyOption = class8.itemActions[j4].contains("Destroy");

                                                    this.menuActionCmd1[this.menuActionRow] = class8.id;
                                                    this.menuActionCmd2[this.menuActionRow] = var211;
                                                    this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                                                    ++this.menuActionRow;
                                                } else if (j4 == 4) {
                                                    this.menuActionName[this.menuActionRow] = "Drop <col=ff9040>"
                                                            + class8.name;
                                                    this.menuActionID[this.menuActionRow] = 847;
                                                    this.menuActionCmd1[this.menuActionRow] = class8.id;
                                                    this.menuActionCmd2[this.menuActionRow] = var211;
                                                    this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                                                    ++this.menuActionRow;
                                                }

                                        }

                                        if (class9_1.usableItems) {
                                            this.menuActionName[this.menuActionRow] = "Use <col=ff9040>"
                                                    + class8.name;
                                            this.menuActionID[this.menuActionRow] = 447;
                                            this.menuActionCmd1[this.menuActionRow] = class8.id;
                                            this.menuActionCmd2[this.menuActionRow] = var211;
                                            this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                                            ++this.menuActionRow;
                                            if (!hasDestroyOption && !menuOpen && shiftDrop && shiftDown) {
                                                menuActionsRow("Drop @lre@" + class8.name, 1, 847, 2);
                                                removeShiftDropOnMenuOpen = true;
                                            }
                                        }

                                        if (class9_1.hasActions && class8.itemActions != null) {
                                            for (int j4 = 2; j4 >= 0; --j4)
                                                if (class8.itemActions[j4] != null) {
                                                    this.menuActionName[this.menuActionRow] = class8.itemActions[j4]
                                                            + " <col=ff9040>" + class8.name;
                                                    if (j4 == 0)
                                                        this.menuActionID[this.menuActionRow] = 74;

                                                    if (j4 == 1)
                                                        this.menuActionID[this.menuActionRow] = 454;

                                                    if (j4 == 2)
                                                        this.menuActionID[this.menuActionRow] = 539;

                                                    this.menuActionCmd1[this.menuActionRow] = class8.id;
                                                    this.menuActionCmd2[this.menuActionRow] = var211;
                                                    this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                                                    ++this.menuActionRow;
                                                }

                                            if (!hasDestroyOption && !this.menuOpen && shiftDrop && shiftDown) {
                                                this.menuActionsRow("Drop <col=ff9040>" + class8.name, 1, 847, 2);
                                                removeShiftDropOnMenuOpen = true;
                                            }

                                        }

                                        if (class9_1.actions != null) {
                                            for (int j4 = 8; j4 >= 0; j4--) {
                                                if (j4 > class9_1.actions.length - 1)
                                                    continue;
                                                if (class9_1.actions[j4] != null) {

                                                    if (class9_1.parentID == 5292) {
                                                        if (class9_1.id == 5382 && placeHolders
                                                                && class9_1.inventoryAmounts[var211] <= 0) {
                                                            // menuActionName[menuActionRow] = "Release " + " @lre@"
                                                            // +itemDef.name;
                                                            class9_1.actions = new String[8];
                                                            class9_1.actions[1] = "Release";
                                                        } else {
                                                            if (modifiableXValue > 0) {// so issue is when x = 0
                                                                if (class9_1.actions.length < 9) {
                                                                    class9_1.actions = new String[]{"Withdraw 1",
                                                                            "Withdraw 5", "Withdraw 10", "Withdraw All",
                                                                            "Withdraw X",
                                                                            "Withdraw " + modifiableXValue,
                                                                            "Withdraw All but one", "Placeholder"};
                                                                }
                                                                class9_1.actions[5] = "Withdraw " + modifiableXValue;
                                                            }
                                                        }
                                                    }
                                                    menuActionName[menuActionRow] = class9_1.actions[j4] + " @lre@"
                                                            + class8.name;
                                                    if (class9_1.id != 1688) {
                                                        if (j4 == 0)
                                                            menuActionID[menuActionRow] = 632;
                                                        if (j4 == 1)
                                                            menuActionID[menuActionRow] = 78;
                                                        if (j4 == 2)
                                                            menuActionID[menuActionRow] = 867;
                                                        if (j4 == 3)
                                                            menuActionID[menuActionRow] = 431;
                                                        if (j4 == 4)
                                                            menuActionID[menuActionRow] = 53;// can u pull up commands?
                                                        if (j4 == 7)
                                                            menuActionID[menuActionRow] = 1337;// placeholders
                                                    } else {
                                                        if (class8.equipActions[j4] == null) {
                                                            menuActionName[3] = "Operate @lre@" + class8.name;
                                                            menuActionName[4] = "Remove @lre@" + class8.name;
                                                        } else {
                                                            class9_1.actions = class8.equipActions;
                                                            menuActionName[menuActionRow] = class8.equipActions[j4]
                                                                    + " @lre@" + class8.name;
                                                        }
                                                        if (j4 == 0)
                                                            menuActionID[menuActionRow] = 632; // remove
                                                        if (j4 == 1)
                                                            menuActionID[menuActionRow] = 661; // operate 1
                                                        if (j4 == 2)
                                                            menuActionID[menuActionRow] = 662; // operate 2
                                                        if (j4 == 3)
                                                            menuActionID[menuActionRow] = 663; // operate 3
                                                        if (j4 == 4)
                                                            menuActionID[menuActionRow] = 664; // operate 4
                                                    }

                                                    if (class9_1.parentID == 5292) {
                                                        if (class9_1.actions.length < 8) {
                                                            if (j4 == 5)
                                                                menuActionID[menuActionRow] = 291;
                                                        } else {
                                                            if (j4 == 5)
                                                                menuActionID[menuActionRow] = 300;
                                                            if (j4 == 6)
                                                                menuActionID[menuActionRow] = 291;
                                                        }
                                                    }
                                                    menuActionCmd1[menuActionRow] = class8.id;
                                                    menuActionCmd2[menuActionRow] = var211;
                                                    menuActionCmd3[menuActionRow] = class9_1.id;
                                                    menuActionRow++;
                                                }
                                            }
                                        }
                                        if (class9_1.parentID >= 58040 && class9_1.parentID <= 58048
                                                || class9_1.parentID >= 32100 && class9_1.parentID <= 32156
                                                || class9_1.parentID >= 32200 && class9_1.parentID <= 32222) {
                                            return;
                                        }
                                        if (class9_1.isItemSearchComponent) {
                                            menuActionName[menuActionRow] = "Select <col=ff9040>" + class8.name;
                                            menuActionID[menuActionRow] = 1130;
                                            menuActionCmd1[menuActionRow] = class8.id;
                                            menuActionCmd2[menuActionRow] = var211;
                                            menuActionCmd3[menuActionRow] = class9_1.id;
                                            menuActionRow++;
                                        } else {
                                            if
                                            (!Widget.interfaceCache[32007].isMouseoverTriggered) {
                                                if (class9_1.id > 32016) {
                                                    continue;
                                                }
                                            }

                                            if (this.myPrivilege == 2 || this.myPrivilege == 9
                                                    || this.myPrivilege == 10 || this.myPrivilege == 4) {
                                                this.menuActionName[this.menuActionRow] = "Examine <col=ff9040>"
                                                        + class8.name + "<col=65280>(@whi@" + class8.id
                                                        + "<col=65280>)";
                                            } else {
                                                this.menuActionName[this.menuActionRow] = "Examine <col=ff9040>"
                                                        + class8.name;
                                            }
                                            this.menuActionID[this.menuActionRow] = 1125;
                                            this.menuActionCmd1[this.menuActionRow] = class8.id;
                                            this.menuActionCmd2[this.menuActionRow] = var211;
                                            this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                                            ++this.menuActionRow;
                                        }
                                    }
                                }
                            }

                            ++var211;
                        }
                    }
                }
            }
        }
    }

    public void draw508Scrollbar(int height, int pos, int y, int x, int maxScroll,
                                 boolean transparent) {
        if (transparent) {
            drawTransparentScrollBar(x, y, height, maxScroll, pos);
        } else {

            scrollBar3.drawSprite(x, y); // <- custom sprite
            scrollBar4.drawSprite(x, (y + height) - 16); // <- custom sprite
            DrawingArea.drawBox(x, y + 16, 16, height - 32, 0x746241);
            DrawingArea.drawBox(x, y + 16, 15, height - 32, 0x77603e);
            DrawingArea.drawBox(x, y + 16, 14, height - 32, 0x95784a);
            DrawingArea.drawBox(x, y + 16, 12, height - 32, 0x997c52);
            DrawingArea.drawBox(x, y + 16, 11, height - 32, 0x9e8155);
            DrawingArea.drawBox(x, y + 16, 10, height - 32, 0xa48558);
            DrawingArea.drawBox(x, y + 16, 8, height - 32, 0xaa8b5c);
            DrawingArea.drawBox(x, y + 16, 6, height - 32, 0xb09060);
            DrawingArea.drawBox(x, y + 16, 3, height - 32, 0x866c44);
            DrawingArea.drawBox(x, y + 16, 1, height - 32, 0x7c6945);

            int k1 = ((height - 32) * height) / maxScroll;
            if (k1 < 8) {
                k1 = 8;
            }
            int l1 = ((height - 32 - k1) * pos) / (maxScroll - height);
            int l2 = ((height - 32 - k1) * pos) / (maxScroll - height) + 6;
            DrawingArea.drawVerticalLine(x + 1, y + 16 + l1, k1, 0x5c492d);
            DrawingArea.drawVerticalLine(x + 14, y + 16 + l1, k1, 0x5c492d);
            DrawingArea.drawHorizontalLine(x + 1, y + 16 + l1, 14, 0x5c492d);
            DrawingArea.drawHorizontalLine(x + 1, y + 15 + l1 + k1, 14, 0x5c492d);
            DrawingArea.drawHorizontalLine(x + 4, y + 18 + l1, 8, 0x664f2b);
            DrawingArea.drawHorizontalLine(x + 4, y + 13 + l1 + k1, 8, 0x664f2b);
            DrawingArea.drawHorizontalLine(x + 3, y + 19 + l1, 2, 0x664f2b);
            DrawingArea.drawHorizontalLine(x + 11, y + 19 + l1, 2, 0x664f2b);
            DrawingArea.drawHorizontalLine(x + 3, y + 12 + l1 + k1, 2, 0x664f2b);
            DrawingArea.drawHorizontalLine(x + 11, y + 12 + l1 + k1, 2, 0x664f2b);
            DrawingArea.drawHorizontalLine(x + 3, y + 14 + l1 + k1, 11, 0x866c44);
            DrawingArea.drawHorizontalLine(x + 3, y + 17 + l1, 11, 0x866c44);
            DrawingArea.drawVerticalLine(x + 13, y + 12 + l2, k1 - 4, 0x866c44);
            DrawingArea.drawVerticalLine(x + 3, y + 13 + l2, k1 - 6, 0x664f2b);
            DrawingArea.drawVerticalLine(x + 12, y + 13 + l2, k1 - 6, 0x664f2b);
            DrawingArea.drawHorizontalLine(x + 2, y + 18 + l1, 2, 0x866c44);
            DrawingArea.drawHorizontalLine(x + 2, y + 13 + l1 + k1, 2, 0x866c44);
            DrawingArea.drawHorizontalLine(x + 12, y + 18 + l1, 1, 0x866c44);
            DrawingArea.drawHorizontalLine(x + 12, y + 13 + l1 + k1, 1, 0x866c44);
        }
    }

    public void drawScrollbar(int height, int pos, int y, int x, int maxScroll, boolean transparent) {
        if (transparent) {
            this.drawTransparentScrollBar(x, y, height, maxScroll, pos);
        } else {
            this.scrollBar1.drawSprite(x, y);
            this.scrollBar2.drawSprite(x, y + height - 16);
            DrawingArea.drawPixels(height - 32, y + 16, x, 1, 16);
            DrawingArea.drawPixels(height - 32, y + 16, x, 4011046, 15);
            DrawingArea.drawPixels(height - 32, y + 16, x, 3419425, 13);
            DrawingArea.drawPixels(height - 32, y + 16, x, 3024925, 11);
            DrawingArea.drawPixels(height - 32, y + 16, x, 2696219, 10);
            DrawingArea.drawPixels(height - 32, y + 16, x, 2433049, 9);
            DrawingArea.drawPixels(height - 32, y + 16, x, 1, 1);
            int k1 = (height - 32) * height / maxScroll;
            if (k1 < 8) {
                k1 = 8;
            }

            int l1 = (height - 32 - k1) * pos / (maxScroll - height);
            DrawingArea.drawPixels(k1, y + 16 + l1, x, this.anInt1063, 16);
            DrawingArea.method341(y + 16 + l1, 1, k1, x);
            DrawingArea.method341(y + 16 + l1, 8482897, k1, x + 1);
            DrawingArea.method341(y + 16 + l1, 7562570, k1, x + 2);
            DrawingArea.method341(y + 16 + l1, 6970435, k1, x + 3);
            DrawingArea.method341(y + 16 + l1, 6970435, k1, x + 4);
            DrawingArea.method341(y + 16 + l1, 6641729, k1, x + 5);
            DrawingArea.method341(y + 16 + l1, 6641729, k1, x + 6);
            DrawingArea.method341(y + 16 + l1, 6378814, k1, x + 7);
            DrawingArea.method341(y + 16 + l1, 6378814, k1, x + 8);
            DrawingArea.method341(y + 16 + l1, 6115644, k1, x + 9);
            DrawingArea.method341(y + 16 + l1, 6115644, k1, x + 10);
            DrawingArea.method341(y + 16 + l1, 5852730, k1, x + 11);
            DrawingArea.method341(y + 16 + l1, 5852730, k1, x + 12);
            DrawingArea.method341(y + 16 + l1, 5326389, k1, x + 13);
            DrawingArea.method341(y + 16 + l1, 4931889, k1, x + 14);
            DrawingArea.method339(y + 16 + l1, 1, 15, x);
            DrawingArea.method339(y + 17 + l1, 1, 15, x);
            DrawingArea.method339(y + 17 + l1, 6641729, 14, x);
            DrawingArea.method339(y + 17 + l1, 6970435, 13, x);
            DrawingArea.method339(y + 17 + l1, 7167816, 11, x);
            DrawingArea.method339(y + 17 + l1, 7562570, 10, x);
            DrawingArea.method339(y + 17 + l1, 7759947, 7, x);
            DrawingArea.method339(y + 17 + l1, 8088141, 5, x);
            DrawingArea.method339(y + 17 + l1, 8285776, 4, x);
            DrawingArea.method339(y + 17 + l1, 8482897, 3, x);
            DrawingArea.method339(y + 17 + l1, 1, 2, x);
            DrawingArea.method339(y + 18 + l1, 1, 16, x);
            DrawingArea.method339(y + 18 + l1, 5655352, 15, x);
            DrawingArea.method339(y + 18 + l1, 6115644, 14, x);
            DrawingArea.method339(y + 18 + l1, 6444608, 11, x);
            DrawingArea.method339(y + 18 + l1, 6641729, 10, x);
            DrawingArea.method339(y + 18 + l1, 6970435, 7, x);
            DrawingArea.method339(y + 18 + l1, 7233606, 5, x);
            DrawingArea.method339(y + 18 + l1, 7430727, 4, x);
            DrawingArea.method339(y + 18 + l1, 8088141, 3, x);
            DrawingArea.method339(y + 18 + l1, 8482897, 2, x);
            DrawingArea.method339(y + 18 + l1, 1, 1, x);
            DrawingArea.method339(y + 19 + l1, 1, 16, x);
            DrawingArea.method339(y + 19 + l1, 5326389, 15, x);
            DrawingArea.method339(y + 19 + l1, 5655352, 14, x);
            DrawingArea.method339(y + 19 + l1, 6115644, 11, x);
            DrawingArea.method339(y + 19 + l1, 6378814, 9, x);
            DrawingArea.method339(y + 19 + l1, 6641729, 7, x);
            DrawingArea.method339(y + 19 + l1, 6970435, 5, x);
            DrawingArea.method339(y + 19 + l1, 7233606, 4, x);
            DrawingArea.method339(y + 19 + l1, 7562570, 3, x);
            DrawingArea.method339(y + 19 + l1, 8482897, 2, x);
            DrawingArea.method339(y + 19 + l1, 1, 1, x);
            DrawingArea.method339(y + 20 + l1, 1, 16, x);
            DrawingArea.method339(y + 20 + l1, 4931889, 15, x);
            DrawingArea.method339(y + 20 + l1, 5523766, 14, x);
            DrawingArea.method339(y + 20 + l1, 5852730, 13, x);
            DrawingArea.method339(y + 20 + l1, 6115644, 10, x);
            DrawingArea.method339(y + 20 + l1, 6378814, 8, x);
            DrawingArea.method339(y + 20 + l1, 6641729, 6, x);
            DrawingArea.method339(y + 20 + l1, 6970435, 4, x);
            DrawingArea.method339(y + 20 + l1, 7562570, 3, x);
            DrawingArea.method339(y + 20 + l1, 8482897, 2, x);
            DrawingArea.method339(y + 20 + l1, 1, 1, x);
            DrawingArea.method341(y + 16 + l1, 1, k1, x + 15);
            DrawingArea.method339(y + 15 + l1 + k1, 1, 16, x);
            DrawingArea.method339(y + 14 + l1 + k1, 1, 15, x);
            DrawingArea.method339(y + 14 + l1 + k1, 4142890, 14, x);
            DrawingArea.method339(y + 14 + l1 + k1, 4471853, 10, x);
            DrawingArea.method339(y + 14 + l1 + k1, 4734511, 9, x);
            DrawingArea.method339(y + 14 + l1 + k1, 4866095, 7, x);
            DrawingArea.method339(y + 14 + l1 + k1, 4931889, 4, x);
            DrawingArea.method339(y + 14 + l1 + k1, 5655352, 3, x);
            DrawingArea.method339(y + 14 + l1 + k1, 1, 2, x);
            DrawingArea.method339(y + 13 + l1 + k1, 1, 16, x);
            DrawingArea.method339(y + 13 + l1 + k1, 4471853, 15, x);
            DrawingArea.method339(y + 13 + l1 + k1, 4931889, 11, x);
            DrawingArea.method339(y + 13 + l1 + k1, 5326389, 9, x);
            DrawingArea.method339(y + 13 + l1 + k1, 5523766, 7, x);
            DrawingArea.method339(y + 13 + l1 + k1, 5655352, 6, x);
            DrawingArea.method339(y + 13 + l1 + k1, 5852730, 4, x);
            DrawingArea.method339(y + 13 + l1 + k1, 6444608, 3, x);
            DrawingArea.method339(y + 13 + l1 + k1, 6970435, 2, x);
            DrawingArea.method339(y + 13 + l1 + k1, 1, 1, x);
            DrawingArea.method339(y + 12 + l1 + k1, 1, 16, x);
            DrawingArea.method339(y + 12 + l1 + k1, 4471853, 15, x);
            DrawingArea.method339(y + 12 + l1 + k1, 4931889, 14, x);
            DrawingArea.method339(y + 12 + l1 + k1, 5523766, 12, x);
            DrawingArea.method339(y + 12 + l1 + k1, 5655352, 11, x);
            DrawingArea.method339(y + 12 + l1 + k1, 5852730, 10, x);
            DrawingArea.method339(y + 12 + l1 + k1, 6115644, 7, x);
            DrawingArea.method339(y + 12 + l1 + k1, 6378814, 4, x);
            DrawingArea.method339(y + 12 + l1 + k1, 7233606, 3, x);
            DrawingArea.method339(y + 12 + l1 + k1, 8088141, 2, x);
            DrawingArea.method339(y + 12 + l1 + k1, 1, 1, x);
            DrawingArea.method339(y + 11 + l1 + k1, 1, 16, x);
            DrawingArea.method339(y + 11 + l1 + k1, 4931889, 15, x);
            DrawingArea.method339(y + 11 + l1 + k1, 5326389, 14, x);
            DrawingArea.method339(y + 11 + l1 + k1, 5655352, 13, x);
            DrawingArea.method339(y + 11 + l1 + k1, 5852730, 11, x);
            DrawingArea.method339(y + 11 + l1 + k1, 6115644, 9, x);
            DrawingArea.method339(y + 11 + l1 + k1, 6378814, 7, x);
            DrawingArea.method339(y + 11 + l1 + k1, 6641729, 5, x);
            DrawingArea.method339(y + 11 + l1 + k1, 6970435, 4, x);
            DrawingArea.method339(y + 11 + l1 + k1, 7562570, 3, x);
            DrawingArea.method339(y + 11 + l1 + k1, 8088141, 2, x);
            DrawingArea.method339(y + 11 + l1 + k1, 1, 1, x);
        }

    }

    private final void method31(Buffer stream, int i) {
        this.anInt839 = 0;
        this.anInt893 = 0;
        this.method139(stream, -45, i);
        this.method46(i, stream, (byte) 2);
        this.method86(i, stream, true);

        for (int i1 = 0; i1 < this.anInt839; ++i1) {
            int l = this.anIntArray840[i1];
            if (this.npcArray[l].anInt1537 != loopCycle) {
                this.npcArray[l].desc = null;
                this.npcArray[l] = null;
            }
        }
        // Cheaphax fix to it doesnt throw exception and boot player
        if (stream.currentOffset == -1 || stream.currentOffset != i) {
            System.out.println("[NPC] Size mismatch : returning");
            return;
        }
        if (stream.currentOffset != i) {
            SignLink.reporterror(
                    myUsername + " size mismatch in getnpcpos - pos:" + stream.currentOffset + " psize:" + i);
            throw new RuntimeException("eek");
        }
        for (int i1 = 0; i1 < npcCount; i1++)
            if (npcArray[npcIndices[i1]] == null) {
                SignLink.reporterror(myUsername + " null entry in npc list - pos:" + i1 + " size:" + npcCount);
                throw new RuntimeException("eek");
            }

    }

    public final void method32(boolean flag) {
        loggedIn &= flag;
        int yOffset = currentScreenMode == Main.ScreenMode.FIXED ? 0 : currentGameHeight - 503;
        if (super.mouseX >= 5 && super.mouseX <= 61 && super.mouseY >= yOffset + 482 && super.mouseY <= yOffset + 503) {
            this.cButtonHPos = 0;
            inputTaken = true;
        } else if (super.mouseX >= 71 && super.mouseX <= 127 && super.mouseY >= yOffset + 482
                && super.mouseY <= yOffset + 503) {
            this.cButtonHPos = 1;
            inputTaken = true;
        } else if (super.mouseX >= 137 && super.mouseX <= 193 && super.mouseY >= yOffset + 482
                && super.mouseY <= yOffset + 503) {
            this.cButtonHPos = 2;
            inputTaken = true;
        } else if (super.mouseX >= 203 && super.mouseX <= 259 && super.mouseY >= yOffset + 482
                && super.mouseY <= yOffset + 503) {
            this.cButtonHPos = 3;
            inputTaken = true;
        } else if (super.mouseX >= 269 && super.mouseX <= 325 && super.mouseY >= yOffset + 482
                && super.mouseY <= yOffset + 503) {
            this.cButtonHPos = 4;
            inputTaken = true;
        } else if (super.mouseX >= 335 && super.mouseX <= 391 && super.mouseY >= yOffset + 482
                && super.mouseY <= yOffset + 503) {
            this.cButtonHPos = 5;
            inputTaken = true;
        } else if (super.mouseX >= 404 && super.mouseX <= 515 && super.mouseY >= yOffset + 482
                && super.mouseY <= yOffset + 503) {
            this.cButtonHPos = 6;
            inputTaken = true;
        } else {
            this.cButtonHPos = -1;
            inputTaken = true;
        }

        if (super.clickMode3 == 1) {
            if (super.saveClickX >= 5 && super.saveClickX <= 61 && super.saveClickY >= yOffset + 482
                    && super.saveClickY <= yOffset + 505) {
                if (currentScreenMode != Main.ScreenMode.FIXED) {
                    if (this.setChannel != 0) {
                        this.cButtonCPos = 0;
                        this.chatTypeView = 0;
                        inputTaken = true;
                        this.setChannel = 0;
                    } else {
                        showChatComponents = !showChatComponents;
                    }
                } else {
                    this.cButtonCPos = 0;
                    this.chatTypeView = 0;
                    inputTaken = true;
                    this.setChannel = 0;
                }
            } else if (super.saveClickX >= 71 && super.saveClickX <= 127 && super.saveClickY >= yOffset + 482
                    && super.saveClickY <= yOffset + 505) {
                if (currentScreenMode != Main.ScreenMode.FIXED) {
                    if (this.setChannel != 1 && currentScreenMode != Main.ScreenMode.FIXED) {
                        this.cButtonCPos = 1;
                        this.chatTypeView = 5;
                        inputTaken = true;
                        this.setChannel = 1;
                    } else {
                        showChatComponents = !showChatComponents;
                    }
                } else {
                    this.cButtonCPos = 1;
                    this.chatTypeView = 5;
                    inputTaken = true;
                    this.setChannel = 1;
                }
            } else if (super.saveClickX >= 137 && super.saveClickX <= 193 && super.saveClickY >= yOffset + 482
                    && super.saveClickY <= yOffset + 505) {
                if (currentScreenMode != Main.ScreenMode.FIXED) {
                    if (this.setChannel != 2 && currentScreenMode != Main.ScreenMode.FIXED) {
                        this.cButtonCPos = 2;
                        this.chatTypeView = 1;
                        inputTaken = true;
                        this.setChannel = 2;
                    } else {
                        showChatComponents = !showChatComponents;
                    }
                } else {
                    this.cButtonCPos = 2;
                    this.chatTypeView = 1;
                    inputTaken = true;
                    this.setChannel = 2;
                }
            } else if (super.saveClickX >= 203 && super.saveClickX <= 259 && super.saveClickY >= yOffset + 482
                    && super.saveClickY <= yOffset + 505) {
                if (currentScreenMode != Main.ScreenMode.FIXED) {
                    if (this.setChannel != 3 && currentScreenMode != Main.ScreenMode.FIXED) {
                        this.cButtonCPos = 3;
                        this.chatTypeView = 2;
                        inputTaken = true;
                        this.setChannel = 3;
                    } else {
                        showChatComponents = !showChatComponents;
                    }
                } else {
                    this.cButtonCPos = 3;
                    this.chatTypeView = 2;
                    inputTaken = true;
                    this.setChannel = 3;
                }
            } else if (super.saveClickX >= 269 && super.saveClickX <= 325 && super.saveClickY >= yOffset + 482
                    && super.saveClickY <= yOffset + 505) {
                if (currentScreenMode != Main.ScreenMode.FIXED) {
                    if (this.setChannel != 4 && currentScreenMode != Main.ScreenMode.FIXED) {
                        this.cButtonCPos = 4;
                        this.chatTypeView = 11;
                        inputTaken = true;
                        this.setChannel = 4;
                    } else {
                        showChatComponents = !showChatComponents;
                    }
                } else {
                    this.cButtonCPos = 4;
                    this.chatTypeView = 11;
                    inputTaken = true;
                    this.setChannel = 4;
                }
            } else if (super.saveClickX >= 335 && super.saveClickX <= 391 && super.saveClickY >= yOffset + 482
                    && super.saveClickY <= yOffset + 505) {
                if (currentScreenMode != Main.ScreenMode.FIXED) {
                    if (this.setChannel != 5 && currentScreenMode != Main.ScreenMode.FIXED) {
                        this.cButtonCPos = 5;
                        this.chatTypeView = 3;
                        inputTaken = true;
                        this.setChannel = 5;
                    } else {
                        showChatComponents = !showChatComponents;
                    }
                } else {
                    this.cButtonCPos = 5;
                    this.chatTypeView = 3;
                    inputTaken = true;
                    this.setChannel = 5;
                }
            } else if (super.saveClickX >= 404 && super.saveClickX <= 515 && super.saveClickY >= yOffset + 482
                    && super.saveClickY <= yOffset + 505) {
                if (openInterfaceID == -1) {
                    this.clearTopInterfaces();
                    this.reportAbuseInput = "";
                    this.canMute = false;

                    for (int i = 0; i < Widget.interfaceCache.length; ++i) {
                        if (Widget.interfaceCache[i] != null && Widget.interfaceCache[i].contentType == 600) {
                            this.reportAbuseInterfaceID = openInterfaceID = Widget.interfaceCache[i].parentID;
                            break;
                        }
                    }
                } else {
                    this.pushMessage("Please close the interface you have open before using \'report abuse\'", 0, "");
                }
            }
        }

    }

    private void setWaveVolume(int i) {
        SignLink.wavevol = i;
    }

    void setMidiVolume(int vol) {
        this.midiVolume = vol;
        if (this.midiPlayer.playing()) {
            this.midiPlayer.setVolume(0, this.midiVolume);
        }

    }

    public void playMidi(byte[] abyte0) {
        boolean quickSong = this.prevSong > 0;
        if (this.midiPlayer.playing() && !quickSong) {
            this.midiPlayer.play(abyte0, false, this.midiVolume);
        } else {
            this.midiPlayer.play(abyte0, false, this.midiVolume);
        }

    }

    public void stopMidi() {
        this.midiPlayer.stop();
        this.currentSong = -1;
    }

    public final void method33(int i) {
        int j = Varp.cache[i].anInt709;
        if (j != 0) {
            int k = this.settings[i];
            System.out.println("" + i);
            if (j == 1) {
                if (k == 1) {
                    Rasterizer.method372(0.9D);
                    savePlayerData();
                }

                if (k == 2) {
                    Rasterizer.method372(0.8D);
                    savePlayerData();
                }

                if (k == 3) {
                    Rasterizer.method372(0.7D);
                    savePlayerData();
                }

                if (k == 4) {
                    Rasterizer.method372(0.6D);
                    savePlayerData();
                }

                ItemDefinition.aClass12_158.method224();
                this.aBoolean1255 = true;
            }

            if (j == 3) {
                boolean flag1 = this.musicEnabled;
                if (k == 0) {
                    this.setMidiVolume(0);
                    this.musicEnabled = true;
                    savePlayerData();
                }

                if (k == 1) {
                    this.setMidiVolume(16);
                    this.musicEnabled = true;
                    savePlayerData();
                }

                if (k == 2) {
                    this.setMidiVolume(32);
                    this.musicEnabled = true;
                    savePlayerData();
                }

                if (k == 3) {
                    this.setMidiVolume(64);
                    this.musicEnabled = true;
                    savePlayerData();
                }

                if (k == 4) {
                    this.musicEnabled = false;
                }

                if (this.musicEnabled != flag1 && !lowMem) {
                    if (this.musicEnabled) {
                        this.nextSong = this.currentSong;
                        this.songChanging = true;
                        onDemandFetcher.method558(2, this.nextSong);
                    } else {
                        this.stopMidi();
                    }

                    this.prevSong = 0;
                }
            }

            if (j == 4) {
                SoundPlayer.setVolume(k);
                if (k == 0) {
                    this.aBoolean848 = true;
                    this.setWaveVolume(0);
                }

                if (k == 1) {
                    this.aBoolean848 = true;
                    this.setWaveVolume(-400);
                }

                if (k == 2) {
                    this.aBoolean848 = true;
                    this.setWaveVolume(-800);
                }

                if (k == 3) {
                    this.aBoolean848 = true;
                    this.setWaveVolume(-1200);
                }

                if (k == 4) {
                    this.aBoolean848 = false;
                }
            }

            if (j == 5) {
                this.anInt1253 = k;
            }

            if (j == 6) {
                this.anInt1249 = k;
            }
            if (j == 8) {
                this.anInt1195 = k;
                inputTaken = true;
            }
            if (j == 9) {
                this.anInt913 = k;
            }
        }

    }

    public final void updateEntities() {

        this.anInt974 = 0;

        for (int k = -1; k < this.playerCount + this.npcCount; ++k) {
            boolean drawBig = false;
            Object var14;
            if (k == -1) {
                var14 = myPlayer;
            } else if (k < this.playerCount) {
                var14 = this.playerArray[this.playerIndices[k]];
            } else {
                var14 = this.npcArray[this.npcIndices[k - this.playerCount]];
            }

            if (var14 != null || ((Entity) var14).isVisible()) {
                NpcDefinition var141;
                if (var14 instanceof Npc) {
                    var141 = ((Npc) var14).desc;
                    if (var141.morphisms != null) {
                        var141 = var141.method161();
                    }

                    if (var141 == null) {
                        continue;
                    }
                }

                if (k < this.playerCount) {
                    int var13 = 30;
                    Player var151 = (Player) var14;
                    if (var151.headIcon >= 0) {
                        this.method127(true, (Entity) var14, ((Entity) var14).anInt1507 + 15);
                        if (this.spriteDrawX > -1) {
                            if (var151.skullIcon < 2) {
                                this.skullIcons[var151.skullIcon].drawSprite(this.spriteDrawX - 12,
                                        this.spriteDrawY - var13);
                                var13 += 25;
                            }

                            if (var151.headIcon < 7) {
                                this.headIcons[var151.headIcon].drawSprite(this.spriteDrawX - 12,
                                        this.spriteDrawY - var13);
                                var13 += 18;
                            }
                        }
                    }

                    if (k >= 0 && this.anInt855 == 10 && this.anInt933 == this.playerIndices[k]) {
                        this.method127(true, (Entity) var14, ((Entity) var14).anInt1507 + 15);
                        if (this.spriteDrawX > -1) {
                            this.headIconsHint[var151.hintIcon].drawSprite(this.spriteDrawX - 12, this.spriteDrawY - var13);
                        }
                    }
                } else {
                    var141 = ((Npc) var14).desc;
                    if (var141.headIcon >= 0 && var141.headIcon < this.headIcons.length) {
                        this.method127(true, (Entity) var14, ((Entity) var14).anInt1507 + 15);
                        if (this.spriteDrawX > -1) {
                            this.headIcons[var141.headIcon].drawSprite(this.spriteDrawX - 12, this.spriteDrawY - 30);
                        }
                    }

                    if (this.anInt855 == 1 && this.anInt1222 == this.npcIndices[k - this.playerCount]
                            && loopCycle % 20 < 10) {
                        this.method127(true, (Entity) var14, ((Entity) var14).anInt1507 + 15);
                        if (this.spriteDrawX > -1) {
                            this.headIconsHint[0].drawSprite(this.spriteDrawX - 12, this.spriteDrawY - 28);
                        }
                    }
                }

                if (((Entity) var14).aString1506 != null
                        && (k >= this.playerCount || this.publicChatMode == 0 || this.publicChatMode == 3
                        || this.publicChatMode == 1 && this.isFriendOrSelf(((Player) var14).name))) {
                    this.method127(true, (Entity) var14, ((Entity) var14).anInt1507);
                    if (this.spriteDrawX > -1 && this.anInt974 < this.anInt975) {
                        this.anIntArray979[this.anInt974] = this.boldText.method384(((Entity) var14).aString1506) / 2;
                        this.anIntArray978[this.anInt974] = this.boldText.anInt1497;
                        this.anIntArray976[this.anInt974] = this.spriteDrawX;
                        this.anIntArray977[this.anInt974] = this.spriteDrawY;
                        this.anIntArray980[this.anInt974] = ((Entity) var14).anInt1513;
                        this.anIntArray981[this.anInt974] = ((Entity) var14).anInt1531;
                        this.anIntArray982[this.anInt974] = ((Entity) var14).textCycle;
                        this.aStringArray983[this.anInt974++] = ((Entity) var14).aString1506;
                        if (this.anInt1249 == 0 && ((Entity) var14).anInt1531 >= 1 && ((Entity) var14).anInt1531 <= 3) {
                            this.anIntArray978[this.anInt974] += 10;
                            this.anIntArray977[this.anInt974] += 5;
                        }

                        if (this.anInt1249 == 0 && ((Entity) var14).anInt1531 == 4) {
                            this.anIntArray979[this.anInt974] = 60;
                        }

                        if (this.anInt1249 == 0 && ((Entity) var14).anInt1531 == 5) {
                            this.anIntArray978[this.anInt974] += 5;
                        }
                    }
                }

                if (((Entity) var14).anInt1532 > loopCycle) {
                    try {
                        this.method127(true, (Entity) var14, ((Entity) var14).anInt1507 + 15);
                        if (spriteDrawX > -1) {
                            int i1 = (((Entity) (var14)).maxHealth * 30) / ((Entity) (var14)).currentHealth;
                            int i2 = (((Entity) (var14)).maxHealth * 30) / ((Entity) (var14)).currentHealth;
                            if (i1 > 30)
                                i1 = 30;
                            if (((Entity) (var14)).currentHealth >= 255) {
                                DrawingArea.drawPixels(5, spriteDrawY - 3, spriteDrawX - 15, 65280, i2);
                                DrawingArea.drawPixels(5, spriteDrawY - 3, (spriteDrawX - 15) + i2, 0xff0000, 30 - i2);
                            } else {
                                DrawingArea.drawPixels(5, spriteDrawY - 3, spriteDrawX - 15, 65280, i1);
                                DrawingArea.drawPixels(5, spriteDrawY - 3, (spriteDrawX - 15) + i1, 0xff0000, 30 - i1);
                            }
                        }
                    } catch (Exception var1311) {
                    }
                }

                for (int var13 = 0; var13 < 4; ++var13) {
                    if (((Entity) var14).anIntArray1516[var13] > loopCycle) {
                        this.method127(true, (Entity) var14, ((Entity) var14).anInt1507 / 2);
                        if (this.spriteDrawX > -1) {
                            if (var13 == 1) {
                                this.spriteDrawY -= 20;
                            }

                            if (var13 == 2) {
                                this.spriteDrawX -= 15;
                                this.spriteDrawY -= 10;
                            }

                            if (var13 == 3) {
                                this.spriteDrawX += 15;
                                this.spriteDrawY -= 10;
                            }

                            this.aSpriteArray987[((Entity) var14).anIntArray1515[var13]]
                                    .drawSprite(this.spriteDrawX - 12, this.spriteDrawY - 12);
                            this.smallText.method381(0, String.valueOf(((Entity) var14).anIntArray1514[var13]), 23693,
                                    this.spriteDrawY + 4, this.spriteDrawX);
                            this.smallText.method381(16777215, String.valueOf(((Entity) var14).anIntArray1514[var13]),
                                    23693, this.spriteDrawY + 3, this.spriteDrawX - 1);
                        }
                    }
                }
            }
        }

        for (int k = 0; k < this.anInt974; ++k) {
            int var141 = this.anIntArray976[k];
            int var13 = this.anIntArray977[k];
            int var15 = this.anIntArray979[k];
            int var161 = this.anIntArray978[k];
            boolean var17 = true;

            while (var17) {
                var17 = false;

                for (int var16 = 0; var16 < k; ++var16) {
                    if (var13 + 2 > this.anIntArray977[var16] - this.anIntArray978[var16]
                            && var13 - var161 < this.anIntArray977[var16] + 2
                            && var141 - var15 < this.anIntArray976[var16] + this.anIntArray979[var16]
                            && var141 + var15 > this.anIntArray976[var16] - this.anIntArray979[var16]
                            && this.anIntArray977[var16] - this.anIntArray978[var16] < var13) {
                        var13 = this.anIntArray977[var16] - this.anIntArray978[var16];
                        var17 = true;
                    }
                }
            }

            this.spriteDrawX = this.anIntArray976[k];
            this.spriteDrawY = this.anIntArray977[k] = var13;
            String var18 = this.aStringArray983[k];
            if (this.anInt1249 == 0) {
                int var19 = 16776960;
                if (this.anIntArray980[k] < 6) {
                    var19 = this.anIntArray965[this.anIntArray980[k]];
                }

                if (this.anIntArray980[k] == 6) {
                    var19 = this.anInt1265 % 20 >= 10 ? 16776960 : 16711680;
                }

                if (this.anIntArray980[k] == 7) {
                    var19 = this.anInt1265 % 20 >= 10 ? '\uffff' : 255;
                }

                if (this.anIntArray980[k] == 8) {
                    var19 = this.anInt1265 % 20 >= 10 ? 8454016 : '\ub000';
                }

                int j4;
                if (this.anIntArray980[k] == 9) {
                    j4 = 150 - this.anIntArray982[k];
                    if (j4 < 50) {
                        var19 = 16711680 + 1280 * j4;
                    } else if (j4 < 100) {
                        var19 = 16776960 - 327680 * (j4 - 50);
                    } else if (j4 < 150) {
                        var19 = '\uff00' + 5 * (j4 - 100);
                    }
                }

                if (this.anIntArray980[k] == 10) {
                    j4 = 150 - this.anIntArray982[k];
                    if (j4 < 50) {
                        var19 = 16711680 + 5 * j4;
                    } else if (j4 < 100) {
                        var19 = 16711935 - 327680 * (j4 - 50);
                    } else if (j4 < 150) {
                        var19 = 255 + 327680 * (j4 - 100) - 5 * (j4 - 100);
                    }
                }

                if (this.anIntArray980[k] == 11) {
                    j4 = 150 - this.anIntArray982[k];
                    if (j4 < 50) {
                        var19 = 16777215 - 327685 * j4;
                    } else if (j4 < 100) {
                        var19 = '\uff00' + 327685 * (j4 - 50);
                    } else if (j4 < 150) {
                        var19 = 16777215 - 327680 * (j4 - 100);
                    }
                }

                if (this.anIntArray981[k] == 0) {
                    this.boldText.method381(0, var18, 23693, this.spriteDrawY + 1, this.spriteDrawX);
                    this.boldText.method381(var19, var18, 23693, this.spriteDrawY, this.spriteDrawX);
                }

                if (this.anIntArray981[k] == 1) {
                    this.boldText.method386(0, true, var18, this.spriteDrawX, this.anInt1265, this.spriteDrawY + 1);
                    this.boldText.method386(var19, true, var18, this.spriteDrawX, this.anInt1265, this.spriteDrawY);
                }

                if (this.anIntArray981[k] == 2) {
                    this.boldText.method387(this.spriteDrawX, var18, this.anInt1265, this.spriteDrawY + 1,
                            this.aByte1194, 0);
                    this.boldText.method387(this.spriteDrawX, var18, this.anInt1265, this.spriteDrawY, this.aByte1194,
                            var19);
                }

                if (this.anIntArray981[k] == 3) {
                    this.boldText.method388(150 - this.anIntArray982[k], var18, true, this.anInt1265,
                            this.spriteDrawY + 1, this.spriteDrawX, 0);
                    this.boldText.method388(150 - this.anIntArray982[k], var18, true, this.anInt1265, this.spriteDrawY,
                            this.spriteDrawX, var19);
                }

                int l4;
                if (this.anIntArray981[k] == 4) {
                    j4 = this.boldText.method384(var18);
                    l4 = (150 - this.anIntArray982[k]) * (j4 + 100) / 150;
                    DrawingArea.method333(334, this.spriteDrawX - 50, this.spriteDrawX + 50, 0);
                    this.boldText.method385(0, var18, this.spriteDrawY + 1, this.spriteDrawX + 50 - l4);
                    this.boldText.method385(var19, var18, this.spriteDrawY, this.spriteDrawX + 50 - l4);
                    DrawingArea.method332(4);
                }

                if (this.anIntArray981[k] == 5) {
                    j4 = 150 - this.anIntArray982[k];
                    l4 = 0;
                    if (j4 < 25) {
                        l4 = j4 - 25;
                    } else if (j4 > 125) {
                        l4 = j4 - 125;
                    }

                    DrawingArea.method333(this.spriteDrawY + 5, 0, 512, this.spriteDrawY - this.boldText.anInt1497 - 1);
                    this.boldText.method381(0, var18, 23693, this.spriteDrawY + 1 + l4, this.spriteDrawX);
                    this.boldText.method381(var19, var18, 23693, this.spriteDrawY + l4, this.spriteDrawX);
                    DrawingArea.method332(4);
                }
            } else {
                this.boldText.method381(0, var18, 23693, this.spriteDrawY + 1, this.spriteDrawX);
                this.boldText.method381(16776960, var18, 23693, this.spriteDrawY, this.spriteDrawX);
            }
        }

    }

    public final void method35(boolean flag, long l) {
        try {
            if (l != 0L) {
                for (int var61 = 0; var61 < this.friendsCount; ++var61) {
                    if (this.friendsListAsLongs[var61] == l) {
                        --this.friendsCount;
                        needDrawTabArea = true;
                        for (int j = var61; j < this.friendsCount; ++j) {
                            this.friendsList[j] = this.friendsList[j + 1];
                            this.friendsNodeIDs[j] = this.friendsNodeIDs[j + 1];
                            this.friendsListAsLongs[j] = this.friendsListAsLongs[j + 1];
                        }

                        stream.createFrame(215);
                        stream.method404(5, l);
                        break;
                    }
                }

                if (!flag) {
                }
            }

        } catch (RuntimeException var6) {
            SignLink.reporterror("18622, " + flag + ", " + l + ", " + var6.toString());
            throw new RuntimeException();
        }
    }

    private boolean stackTabs() {
        return !(currentGameWidth >= 1100);
    }

    private void drawTabs() {
        if (currentScreenMode == ScreenMode.FIXED) {
            final int[][] sideIconCoordinates = new int[][]{{17, 17}, {49, 15}, {83, 15}, {113, 13},
                    {146, 10}, {180, 11}, {214, 15}, {14, 311}, {49, 314}, {82, 314}, {116, 310},
                    {148, 312}, {184, 311}, {216, 311}};
            final int[][] sideIconCoordinates1 = new int[][]{{24, 8}, {49, 5}, {79, 5}, {108, 3}, {147, 5},
                    {176, 5}, {205, 8}, {22, 300}, {49, 304}, {77, 304}, {111, 303}, {147, 301},
                    {180, 303}, {204, 303}};
            if (Main.tabInterfaceIDs[Main.tabID] != -1) {
                if (oldGameframe == false || Gameframe508 == true) {
                    if (Main.tabID == 0)
                        redStones[0].drawSprite(5, 0);
                    if (Main.tabID == 1)
                        redStones[4].drawSprite(43, 0);
                    if (Main.tabID == 2)
                        redStones[4].drawSprite(76, 0);
                    if (Main.tabID == 3)
                        redStones[4].drawSprite(109, 0);
                    if (Main.tabID == 4)
                        redStones[4].drawSprite(142, 0);
                    if (Main.tabID == 5)
                        redStones[4].drawSprite(175, 0);
                    if (Main.tabID == 6)
                        redStones[1].drawSprite(208, 0);
                    if (Main.tabID == 7)
                        redStones[2].drawSprite(5, 298);
                    if (Main.tabID == 8)
                        redStones[4].drawSprite(43, 298);
                    if (Main.tabID == 9)
                        redStones[4].drawSprite(76, 298);
                    if (Main.tabID == 10)
                        redStones[4].drawSprite(109, 298);
                    if (Main.tabID == 11)
                        redStones[4].drawSprite(142, 298);
                    if (Main.tabID == 12)
                        redStones[4].drawSprite(175, 298);
                    if (Main.tabID == 13)
                        redStones[3].drawSprite(208, 298);
                } else {
                    if (Main.tabID == 0)
                        redStones[1].drawSprite(14, 0);
                    if (Main.tabID == 1)
                        redStones[2].drawSprite(47, 0);
                    if (Main.tabID == 2)
                        redStones[2].drawSprite(74, 0);
                    if (Main.tabID == 3)
                        redStones[3].drawSprite(102, 0);
                    if (Main.tabID == 4)
                        redStones[2].drawSprite(144, 0);
                    if (Main.tabID == 5)
                        redStones[2].drawSprite(172, 0);
                    if (Main.tabID == 6)
                        redStones[0].drawSprite(201, 0);
                    if (Main.tabID == 7)
                        redStones[4].drawSprite(13, 296);
                    if (Main.tabID == 8)
                        redStones[2].drawSprite(46, 297);
                    if (Main.tabID == 9)
                        redStones[2].drawSprite(74, 298);
                    if (Main.tabID == 10)
                        redStones[3].drawSprite(102, 297);
                    if (Main.tabID == 11)
                        redStones[2].drawSprite(144, 296);
                    if (Main.tabID == 12)
                        redStones[2].drawSprite(171, 296);
                    if (Main.tabID == 13)
                        redStones[5].drawSprite(201, 298);
                }

            }
            for (int index = 0; index <= 14; index++) {
                if (Main.tabInterfaceIDs[index] != -1 && anInt1054 == index) {
                    if (Main.loopCycle % 20 >= 10)
                        ;
                }
                if (oldGameframe == false || Gameframe508 == true) {
            		if(tabInterfaceIDs[0] != -1)//attack
            			sideIcons[0].drawSprite(17, 17 - 8);
            		if(tabInterfaceIDs[1] != -1)//stat
            			sideIcons[1].drawSprite(49, 15 - 8);
            		if(tabInterfaceIDs[2] != -1)//quest
            			sideIcons[2].drawSprite(83, 15 - 8);
            		if(tabInterfaceIDs[3] != -1)//inventory
            			sideIcons[3].drawSprite(113, 13 - 8);
            		if(tabInterfaceIDs[4] != -1)//equipment
            			sideIcons[4].drawSprite(146, 10 - 8);
            		if(tabInterfaceIDs[5] != -1)//prayer
            			sideIcons[5].drawSprite(180, 11 - 8);
            		if(tabInterfaceIDs[6] != -1)//magic
            			sideIcons[6].drawSprite(214, 15 - 8);
            		/* Bottom sideIcons */
            		if(tabInterfaceIDs[7] != -1)//clan
            			sideIcons[7].drawSprite(14, 311 - 8);
            		if(tabInterfaceIDs[8] != -1)//friends
            			if(tabInterfaceIDs[8] == 5065)
            			sideIcons[8].drawSprite(49, 314 - 8);
        			if(tabInterfaceIDs[8] == 5715)
        			sideIcons[9].drawSprite(49, 314 - 8);
            		if(tabInterfaceIDs[9] != -1)//ignore
            			sideIcons[14].drawSprite(82, 314 - 8);
            		if(tabInterfaceIDs[10] != -1)//options
            			sideIcons[10].drawSprite(116, 310 - 8);
            		if(tabInterfaceIDs[11] != -1)//options
            			sideIcons[11].drawSprite(148, 312 - 8);
            		if(tabInterfaceIDs[12] != -1)//emotes
            			sideIcons[12].drawSprite(184, 311 - 8);
            		if(tabInterfaceIDs[13] != -1)//music
            			sideIcons[13].drawSprite(216, 311 - 8);
                } else {
                    sideIcons[index].drawSprite(sideIconCoordinates1[index][0], sideIconCoordinates1[index][1]);

                }
            }
        } else {
            final int[][] sideIconOffsets = new int[][]{{7, 8}, {4, 6}, {6, 7}, {3, 4}, {3, 2}, {4, 3},
                    {4, 6}, {5, 5}, {5, 6}, {5, 6}, {6, 3}, {5, 5}, {6, 4}, {5, 5}};
            int x = Main.currentGameWidth - (stackTabs() ? 231 : 462);
            int y = Main.currentGameHeight - (stackTabs() ? 73 : 37);
            for (int tabIndex = 0; tabIndex < 14; tabIndex++) {
                if (Main.tabID == tabIndex) {
                    redStones[4].drawSprite(x, y);
                }
                if (stackTabs()) {
                    if (tabIndex != 6) {
                        x += 33;
                    } else if (tabIndex == 6) {
                        y += 36;
                        x = Main.currentGameWidth - 231;
                    }
                } else {
                    x += 33;
                }
            }
            x = Main.currentGameWidth - (stackTabs() ? 231 : 462);
            y = Main.currentGameHeight - (stackTabs() ? 73 : 37);
            for (int index = 0; index < 14; index++) {
                if (Main.tabInterfaceIDs[index] != -1 && anInt1054 == index) {
                    if (Main.loopCycle % 20 >= 10)
                        ;
                }
                sideIcons[index].drawSprite(x + sideIconOffsets[index][0], y + sideIconOffsets[index][1]);
                if (stackTabs()) {
                    if (index != 6) {
                        x += 33;
                    } else if (index == 6) {
                        y += 36;
                        x = Main.currentGameWidth - 231;
                    }
                } else {
                    x += 33;
                }
            }
        }

    }

    public final void drawTabArea() {
        if (currentScreenMode == Main.ScreenMode.FIXED)
            aRSImageProducer_1163.initDrawingArea();

        Rasterizer.lineOffsets = anIntArray1181;
        if (currentScreenMode == ScreenMode.FIXED) {
            tabAreaFixed.drawSprite(0, 0);
            if (invOverlayInterfaceID == -1)
                drawTabs();

        } else {
            (stackTabs() ? tabAreaResizable[1] : tabAreaResizable[2]).drawSpriteWithOpacity(
                    Main.currentGameWidth - (stackTabs() ? 231 : 462),
                    Main.currentGameHeight - (stackTabs() ? 73 : 37), 220);

            tabAreaResizable[0].drawSpriteWithOpacity(Main.currentGameWidth - 204,
                    Main.currentGameHeight - 275 - (stackTabs() ? 73 : 37), 220);

            if (invOverlayInterfaceID == -1)
                drawTabs();
        }
        int y = stackTabs() ? 73 : 37;
        if (invOverlayInterfaceID != -1) {
            drawInterface(0, currentScreenMode == ScreenMode.FIXED ? 31 : currentGameWidth - 197,
                    Widget.interfaceCache[invOverlayInterfaceID],
                    currentScreenMode == ScreenMode.FIXED ? 37 : currentGameHeight - 275 - y + 10);
        } else if (Main.tabInterfaceIDs[Main.tabID] != -1) {
            drawInterface(0, currentScreenMode == ScreenMode.FIXED ? 31 : currentGameWidth - 197,
                    Widget.interfaceCache[Main.tabInterfaceIDs[Main.tabID]],
                    currentScreenMode == ScreenMode.FIXED ? 37 : currentGameHeight - 275 - y + 10);
        }
        //if (currentScreenMode == ScreenMode.FIXED) {
        ///	mapArea[6].drawSprite(0, 178);
        //}
        if (menuOpen) {
            drawMenu(currentScreenMode == ScreenMode.FIXED ? 516 : 0, currentScreenMode == ScreenMode.FIXED ? 168 : 0);
        }

        if (this.menuOpen) {
            this.drawMenu(currentScreenMode == Main.ScreenMode.FIXED ? 516 : 0,
                    currentScreenMode == Main.ScreenMode.FIXED ? 168 : 0);
        }

        if (currentScreenMode == Main.ScreenMode.FIXED) {
            aRSImageProducer_1163.drawGraphics(168, super.graphics, 516);
            aRSImageProducer_1165.initDrawingArea();
        }

        Rasterizer.lineOffsets = anIntArray1182;
    }

    public final void method38(byte byte0) {
        if (byte0 != -92) {
            stream.writeByte(214);
        }

        int k;
        int l;
        for (k = -1; k < this.playerCount; ++k) {
            if (k == -1) {
                l = this.myPlayerIndex;
            } else {
                l = this.playerIndices[k];
            }

            Player var51 = this.playerArray[l];
            if (var51 != null && var51.textCycle > 0) {
                --var51.textCycle;
                if (var51.textCycle == 0) {
                    var51.aString1506 = null;
                }
            }
        }

        for (k = 0; k < this.npcCount; ++k) {
            l = this.npcIndices[k];
            Npc var5 = this.npcArray[l];
            if (var5 != null && var5.textCycle > 0) {
                --var5.textCycle;
                if (var5.textCycle == 0) {
                    var5.aString1506 = null;
                }
            }
        }

    }

    public final void method39(byte byte0) {
        int i = this.anInt1098 * 128 + 64;
        int j = this.anInt1099 * 128 + 64;
        int k = this.method42(this.plane, j, i) - this.anInt1100;
        if (this.xCameraPos < i) {
            this.xCameraPos += this.anInt1101 + (i - this.xCameraPos) * this.anInt1102 / 1000;
            if (this.xCameraPos > i) {
                this.xCameraPos = i;
            }
        }

        if (this.xCameraPos > i) {
            this.xCameraPos -= this.anInt1101 + (this.xCameraPos - i) * this.anInt1102 / 1000;
            if (this.xCameraPos < i) {
                this.xCameraPos = i;
            }
        }

        if (this.zCameraPos < k) {
            this.zCameraPos += this.anInt1101 + (k - this.zCameraPos) * this.anInt1102 / 1000;
            if (this.zCameraPos > k) {
                this.zCameraPos = k;
            }
        }

        if (this.zCameraPos > k) {
            this.zCameraPos -= this.anInt1101 + (this.zCameraPos - k) * this.anInt1102 / 1000;
            if (this.zCameraPos < k) {
                this.zCameraPos = k;
            }
        }

        if (this.yCameraPos < j) {
            this.yCameraPos += this.anInt1101 + (j - this.yCameraPos) * this.anInt1102 / 1000;
            if (this.yCameraPos > j) {
                this.yCameraPos = j;
            }
        }

        if (this.yCameraPos > j) {
            this.yCameraPos -= this.anInt1101 + (this.yCameraPos - j) * this.anInt1102 / 1000;
            if (this.yCameraPos < j) {
                this.yCameraPos = j;
            }
        }

        i = this.anInt995 * 128 + 64;
        j = this.anInt996 * 128 + 64;
        k = this.method42(this.plane, j, i) - this.anInt997;
        int l = i - this.xCameraPos;
        int i1 = k - this.zCameraPos;
        int j1 = j - this.yCameraPos;
        int k1 = (int) Math.sqrt((double) (l * l + j1 * j1));
        int l1 = (int) (Math.atan2((double) i1, (double) k1) * 325.949D) & 2047;
        if (byte0 != 5) {
            aBoolean919 = !aBoolean919;
        }

        int i2 = (int) (Math.atan2((double) l, (double) j1) * -325.949D) & 2047;
        if (l1 < 128) {
            l1 = 128;
        }

        if (l1 > 383) {
            l1 = 383;
        }

        if (this.yCameraCurve < l1) {
            this.yCameraCurve += this.anInt998 + (l1 - this.yCameraCurve) * this.anInt999 / 1000;
            if (this.yCameraCurve > l1) {
                this.yCameraCurve = l1;
            }
        }

        if (this.yCameraCurve > l1) {
            this.yCameraCurve -= this.anInt998 + (this.yCameraCurve - l1) * this.anInt999 / 1000;
            if (this.yCameraCurve < l1) {
                this.yCameraCurve = l1;
            }
        }

        int j2 = i2 - this.xCameraCurve;
        if (j2 > 1024) {
            j2 -= 2048;
        }

        if (j2 < -1024) {
            j2 += 2048;
        }

        if (j2 > 0) {
            this.xCameraCurve += this.anInt998 + j2 * this.anInt999 / 1000;
            this.xCameraCurve &= 2047;
        }

        if (j2 < 0) {
            this.xCameraCurve -= this.anInt998 + -j2 * this.anInt999 / 1000;
            this.xCameraCurve &= 2047;
        }

        int k2 = i2 - this.xCameraCurve;
        if (k2 > 1024) {
            k2 -= 2048;
        }

        if (k2 < -1024) {
            k2 += 2048;
        }

        if (k2 < 0 && j2 > 0 || k2 > 0 && j2 < 0) {
            this.xCameraCurve = i2;
        }

    }

    private void drawMenu(int xOffSet, int yOffSet) {
    	if(NewMenu == false){
        int xPos = menuOffsetX - (xOffSet);
        int yPos = (-yOffSet) + menuOffsetY;
        int menuW = menuWidth;
        int menuH = menuHeight + 1;
        needDrawTabArea = true;
        inputTaken = true;
        tabAreaAltered = true;
        DrawingArea.drawBox(xPos, yPos, menuW, menuH, 0x5d5447);
        DrawingArea.drawBox(xPos + 1, yPos + 1, menuW - 2, 16, 0);
        DrawingArea.drawBoxOutline(xPos + 1, yPos + 18, menuW - 2, menuH - 19, 0);
        newBoldFont.drawBasicString("Choose Option", xPos + 3, yPos + 14, 0x5d5447, 0x000000);
        int mouseX = super.mouseX - (xOffSet);
        int mouseY = (-yOffSet) + super.mouseY;
        for (int l1 = 0; l1 < menuActionRow; l1++) {
            int textY = yPos + 31 + (menuActionRow - 1 - l1) * 15;
            int disColor = 0xffffff;
            if (mouseX > xPos && mouseX < xPos + menuW && mouseY > textY - 13 && mouseY < textY + 3) {
				if(MouseIcons){
					detectCursor(l1);
				}
            	disColor = 0xffff00;
            }
            newBoldFont.drawBasicString(menuActionName[l1], xPos + 3, textY, disColor, 0x000000);
        }
    	}else{
    		int xPos = menuOffsetX - (xOffSet - 4);
    		int yPos = (-yOffSet + 4) + menuOffsetY;
    		int menuW = menuWidth;
    		int menuH = menuHeight + 1;
    		needDrawTabArea = true;
    		inputTaken = true;
    		tabAreaAltered = true;
    		//DrawingArea.drawPixels(height, yPos, xPos, color, width);
    		//DrawingArea.fillPixels(xPos, width, height, color, yPos);
    		DrawingArea.drawPixels(menuH - 4, yPos + 2, xPos, 0x706a5e, menuW);
    		DrawingArea.drawPixels(menuH - 2, yPos + 1, xPos + 1, 0x706a5e, menuW - 2);
    		DrawingArea.drawPixels(menuH, yPos, xPos + 2, 0x706a5e, menuW - 4);
    		DrawingArea.drawPixels(menuH - 2, yPos + 1, xPos + 3, 0x2d2822, menuW - 6);
    		DrawingArea.drawPixels(menuH - 4, yPos + 2, xPos + 2, 0x2d2822, menuW - 4);
    		DrawingArea.drawPixels(menuH - 6, yPos + 3, xPos + 1, 0x2d2822, menuW - 2);
    		DrawingArea.drawPixels(menuH - 22, yPos + 19, xPos + 2, 0x524a3d, menuW - 4);
    		DrawingArea.drawPixels(menuH - 22, yPos + 20, xPos + 3, 0x524a3d, menuW - 6);
    		DrawingArea.drawPixels(menuH - 23, yPos + 20, xPos + 3, 0x2b271c, menuW - 6);
    		DrawingArea.fillPixels(xPos + 3, menuW - 6, 1, 0x2a291b, yPos + 2);
    		DrawingArea.fillPixels(xPos + 2, menuW - 4, 1, 0x2a261b, yPos + 3);
    		DrawingArea.fillPixels(xPos + 2, menuW - 4, 1, 0x252116, yPos + 4);
    		DrawingArea.fillPixels(xPos + 2, menuW - 4, 1, 0x211e15, yPos + 5);
    		DrawingArea.fillPixels(xPos + 2, menuW - 4, 1, 0x1e1b12, yPos + 6);
    		DrawingArea.fillPixels(xPos + 2, menuW - 4, 1, 0x1a170e, yPos + 7);
    		DrawingArea.fillPixels(xPos + 2, menuW - 4, 2, 0x15120b, yPos + 8);
    		DrawingArea.fillPixels(xPos + 2, menuW - 4, 1, 0x100d08, yPos + 10);
    		DrawingArea.fillPixels(xPos + 2, menuW - 4, 1, 0x090a04, yPos + 11);
    		DrawingArea.fillPixels(xPos + 2, menuW - 4, 1, 0x080703, yPos + 12);
    		DrawingArea.fillPixels(xPos + 2, menuW - 4, 1, 0x090a04, yPos + 13);
    		DrawingArea.fillPixels(xPos + 2, menuW - 4, 1, 0x070802, yPos + 14);
    		DrawingArea.fillPixels(xPos + 2, menuW - 4, 1, 0x090a04, yPos + 15);
    		DrawingArea.fillPixels(xPos + 2, menuW - 4, 1, 0x070802, yPos + 16);
    		DrawingArea.fillPixels(xPos + 2, menuW - 4, 1, 0x090a04, yPos + 17);
    		DrawingArea.fillPixels(xPos + 2, menuW - 4, 1, 0x2a291b, yPos + 18);
    		DrawingArea.fillPixels(xPos + 3, menuW - 6, 1, 0x564943, yPos + 19);
    		newBoldFont.drawBasicString("Choose Option", xPos + 3, yPos + 14, 0xc6b895, 0x000000);
    		int j1 = super.mouseX;
    		int k1 = super.mouseY;
    		int mouseX = super.mouseX - (xOffSet);
    		int mouseY = (-yOffSet) + super.mouseY;
    		for(int l1 = 0; l1 < menuActionRow; l1++) {
    			int textY = yPos + 31 + (menuActionRow - 1 - l1) * 15;
    			int disColor = 0xc6b895;
    			if(mouseX > xPos && mouseX < xPos + menuW && mouseY > textY - 13 && mouseY < textY + 3) {
    				DrawingArea.drawPixels(15, textY - 11, xPos + 3, 0x6f695d, menuWidth - 6);
    				if(MouseIcons){
    					detectCursor(l1);
    				}
    				disColor = 0xeee5c6;
    			}
    			newBoldFont.drawBasicString(menuActionName[l1], xPos + 3, textY, disColor, 0x000000);
    		}
    	}
    }
	   public void detectCursor(int menuAction) {
 boolean hasFoundCursor = false;

 for (int i2 = 0; i2 < cursorInfo.length; i2++) {
     if (menuActionName[menuAction].startsWith(cursorInfo[i2])) {
         hasFoundCursor = true;
         super.setCursor(i2);
     }
 }
 if (!hasFoundCursor) super.setCursor(0);
}
    public final void method41(byte byte0, long l) {
        try {
            if (l != 0L) {
                if (this.friendsCount >= 100 && this.anInt1046 != 1) {
                    this.pushMessage("Your friendlist is full. Max of 100 for free users, and 200 for members", 0, "");
                } else if (this.friendsCount >= 200) {
                    this.pushMessage("Your friendlist is full. Max of 100 for free users, and 200 for members", 0, "");
                } else {
                    String var61 = TextClass.fixName(TextClass.nameForLong(l));

                    int j;
                    for (j = 0; j < this.friendsCount; ++j) {
                        if (this.friendsListAsLongs[j] == l) {
                            this.pushMessage(var61 + " is already on your friend list", 0, "");
                            return;
                        }
                    }

                    if (byte0 != 68) {
                        this.incomingPacket = -1;
                    }

                    for (j = 0; j < this.anInt822; ++j) {
                        if (this.aLongArray925[j] == l) {
                            this.pushMessage("Please remove " + var61 + " from your ignore list first", 0, "");
                            return;
                        }
                    }

                    if (!var61.equals(myPlayer.name)) {
                        this.friendsList[this.friendsCount] = var61;
                        this.friendsListAsLongs[this.friendsCount] = l;
                        this.friendsNodeIDs[this.friendsCount] = 0;
                        ++this.friendsCount;
                        needDrawTabArea = true;
                        stream.createFrame(188);
                        stream.method404(5, l);
                    }
                }
            }

        } catch (RuntimeException var6) {
            SignLink.reporterror("15283, " + byte0 + ", " + l + ", " + var6.toString());
            throw new RuntimeException();
        }
    }

    public final int method42(int i, int j, int k) {
        int l = k >> 7;
        int i1 = j >> 7;
        if (l >= 0 && i1 >= 0 && l <= 103 && i1 <= 103) {
            int j1 = i;
            if (i < 3 && (this.byteGroundArray[1][l][i1] & 2) == 2) {
                j1 = i + 1;
            }

            int k1 = k & 127;
            int l1 = j & 127;
            int i2 = this.anIntArrayArrayArray1214[j1][l][i1] * (128 - k1)
                    + this.anIntArrayArrayArray1214[j1][l + 1][i1] * k1 >> 7;
            int j2 = this.anIntArrayArrayArray1214[j1][l][i1 + 1] * (128 - k1)
                    + this.anIntArrayArrayArray1214[j1][l + 1][i1 + 1] * k1 >> 7;
            return i2 * (128 - l1) + j2 * l1 >> 7;
        } else {
            return 0;
        }
    }

    public final void resetLogout() {
        loginMessage1 = "@whi@Enter your username & password.";
        loginMessage2 = "";
        try {
            if (this.aRSSocket_1168 != null) {
                this.aRSSocket_1168.method267();
            }
        } catch (Exception var2) {
        }

        this.aRSSocket_1168 = null;
        loggedIn = false;
        this.loginScreenState = 0;
        this.method23(false);
        this.worldController.method274(619);

        for (int i = 0; i < 4; ++i) {
            this.aClass11Array1230[i].method210();
        }

        System.gc();
        this.stopMidi();
        this.currentSong = -1;
        GameTimerHandler.getSingleton().stopAll();
        myUsername = "";
        myPassword = "";
        this.nextSong = -1;
        this.prevSong = 0;
        experienceCounter = 0;
        currentScreenMode(Main.ScreenMode.FIXED);
    }

    public final void method45(int i) {
        if (i != 0) {
            this.incomingPacket = -1;
        }

        this.aBoolean1031 = true;

        for (int j = 0; j < 7; ++j) {
            this.anIntArray1065[j] = -1;

            for (int k = 0; k < IdentityKit.length; ++k) {
                if (!IdentityKit.kits[k].validStyle
                        && IdentityKit.kits[k].bodyPartId == j + (this.aBoolean1047 ? 0 : 7)) {
                    this.anIntArray1065[j] = k;
                    break;
                }
            }
        }

    }

    private final void method46(int i, Buffer stream, byte byte0) {
        int k;
        if (byte0 != 2) {
            for (k = 1; k > 0; ++k) {
            }
        }

        while (stream.anInt1407 + 21 < i * 8) {
            k = stream.method419(14, 0);
            if (k == 16383) {
                break;
            }

            if (this.npcArray[k] == null) {
                this.npcArray[k] = new Npc();
            }

            Npc npc = this.npcArray[k];
            this.npcIndices[this.npcCount++] = k;
            npc.anInt1537 = loopCycle;
            int l = stream.method419(5, 0);
            if (l > 15) {
                l -= 32;
            }

            int i1 = stream.method419(5, 0);
            if (i1 > 15) {
                i1 -= 32;
            }
            int j1 = stream.method419(1, 0);
            npc.desc = NpcDefinition.lookup(stream.method419(14, 0));
            int k1 = stream.method419(1, 0);
            if (k1 == 1) {
                this.anIntArray894[this.anInt893++] = k;
            }

            npc.anInt1540 = npc.desc.spaceOccupied;
            npc.anInt1504 = npc.desc.rotation;
            npc.anInt1554 = npc.desc.walkingAnimation;
            npc.anInt1555 = npc.desc.halfTurnAnimation;
            npc.anInt1556 = npc.desc.quarterClockwiseTurnAnimation;
            npc.anInt1557 = npc.desc.quarterAnticlockwiseTurnAnimation;
            npc.anInt1511 = npc.desc.standingAnimation;
            npc.method445(myPlayer.smallX[0] + i1, myPlayer.smallY[0] + l, j1 == 1, false);
        }

        stream.method420(true);
    }

    public void method7() {
        if (!this.aBoolean1252 && !this.aBoolean926 && !this.aBoolean1176) {
            ++loopCycle;
        }

        if (!loggedIn) {
            this.method140();
        } else {
            this.mainGameProcessor();
        }

        this.method57(false);
    }

    private void method47(boolean flag) {
        if (myPlayer.x >> 7 == destX && myPlayer.y >> 7 == destY)
            destX = 0;
        int j = playerCount;
        if (flag)
            j = 1;
        for (int l = 0; l < j; l++) {
            Player player;
            int i1;
            if (flag) {
                player = myPlayer;
                i1 = myPlayerIndex << 14;
            } else {
                player = playerArray[playerIndices[l]];
                i1 = playerIndices[l] << 14;
            }
            if (player == null || !player.isVisible())
                continue;
            player.aBoolean1699 = (lowMem && playerCount > 50 || playerCount > 200) && !flag
                    && player.anInt1517 == player.anInt1511;
            int j1 = player.x >> 7;
            int k1 = player.y >> 7;
            if (j1 < 0 || j1 >= 104 || k1 < 0 || k1 >= 104)
                continue;
            if (player.aModel_1714 != null && loopCycle >= player.anInt1707 && loopCycle < player.anInt1708) {
                player.aBoolean1699 = false;
                player.anInt1709 = method42(plane, player.y, player.x);
                worldController.method286(plane, player.y, player, player.anInt1552, player.anInt1722, player.x, player.anInt1709, player.anInt1719, player.anInt1721, i1, player.anInt1720);
                continue;
            }
            if ((player.x & 0x7f) == 64 && (player.y & 0x7f) == 64) {
                if (anIntArrayArray929[j1][k1] == anInt1265)
                    continue;
                anIntArrayArray929[j1][k1] = anInt1265;
            }
            player.anInt1709 = method42(plane, player.y, player.x);
            worldController.method285(plane, player.anInt1552, player.anInt1709, i1, player.y, 60, player.x, player,
                    player.aBoolean1541);
        }
    }

    public final boolean promptUserForInput(Widget class9) {
        int j = class9.contentType;
        if (this.anInt900 == 2) {
            if (j == 201) {
                inputTaken = true;
                inputDialogState = 0;
                this.messagePromptRaised = true;
                this.promptInput = "";
                this.friendsListAction = 1;
                this.aString1121 = "Enter name of friend to add to list";
            }

            if (j == 202) {
                inputTaken = true;
                inputDialogState = 0;
                this.messagePromptRaised = true;
                this.promptInput = "";
                this.friendsListAction = 2;
                this.aString1121 = "Enter name of friend to delete from list";
            }
        }

        if (j == 205) {
            this.anInt1011 = 250;
            return true;
        } else {
            if (j == 501) {
                inputTaken = true;
                inputDialogState = 0;
                this.messagePromptRaised = true;
                this.promptInput = "";
                this.friendsListAction = 4;
                this.aString1121 = "Enter name of player to add to list";
            }

            if (j == 502) {
                inputTaken = true;
                inputDialogState = 0;
                this.messagePromptRaised = true;
                this.promptInput = "";
                this.friendsListAction = 5;
                this.aString1121 = "Enter name of player to delete from list";
            }
            if (j == 550) {
                inputTaken = true;
                inputDialogState = 0;
                messagePromptRaised = true;
                promptInput = "";
                friendsListAction = 6;
                aString1121 = "Enter the name of the chat you wish to join";
            }

            int l1;
            int k1;
            int j2;
            if (j >= 300 && j <= 313) {
                l1 = (j - 300) / 2;
                k1 = j & 1;
                j2 = this.anIntArray1065[l1];
                if (j2 != -1) {
                    while (true) {
                        if (k1 == 0) {
                            --j2;
                            if (j2 < 0) {
                                j2 = IdentityKit.length - 1;
                            }
                        }

                        if (k1 == 1) {
                            ++j2;
                            if (j2 >= IdentityKit.length) {
                                j2 = 0;
                            }
                        }

                        if (!IdentityKit.kits[j2].validStyle
                                && IdentityKit.kits[j2].bodyPartId == l1 + (this.aBoolean1047 ? 0 : 7)) {
                            this.anIntArray1065[l1] = j2;
                            this.aBoolean1031 = true;
                            break;
                        }
                    }
                }
            }

            if (j >= 314 && j <= 323) {
                l1 = (j - 314) / 2;
                k1 = j & 1;
                j2 = this.anIntArray990[l1];
                if (k1 == 0) {
                    --j2;
                    if (j2 < 0) {
                        j2 = PLAYER_BODY_RECOLOURS[l1].length - 1;
                    }
                }

                if (k1 == 1) {
                    ++j2;
                    if (j2 >= PLAYER_BODY_RECOLOURS[l1].length) {
                        j2 = 0;
                    }
                }

                this.anIntArray990[l1] = j2;
                this.aBoolean1031 = true;
            }

            if (j == 324 && !this.aBoolean1047) {
                this.aBoolean1047 = true;
                this.method45(0);
            }

            if (j == 325 && this.aBoolean1047) {
                this.aBoolean1047 = false;
                this.method45(0);
            }

            if (j != 326) {
                if (j == 620) {
                    this.canMute = !this.canMute;
                    if (this.myPrivilege >= 1) {
                        if (this.canMute) {
                            class9.message = "Moderator option: Mute player for 48 hours: <ON>";
                        } else {
                            class9.message = "Moderator option: Mute player for 48 hours: <OFF>";
                        }
                    }
                }

                if (j >= 601 && j <= 613) {
                    this.clearTopInterfaces();
                    if (this.reportAbuseInput.length() > 0) {
                        stream.createFrame(218);
                        stream.method404(5, TextClass.longForName(this.reportAbuseInput));
                        stream.writeByte(j - 601);
                        stream.writeByte(this.canMute ? 1 : 0);
                    }
                }

                return false;
            } else {
                stream.createFrame(101);
                stream.writeByte(this.aBoolean1047 ? 0 : 1);

                for (l1 = 0; l1 < 7; ++l1) {
                    stream.writeByte(this.anIntArray1065[l1]);
                }

                for (l1 = 0; l1 < 5; ++l1) {
                    stream.writeByte(this.anIntArray990[l1]);
                }
                return true;
            }
        }
    }

    private final void method49(int i, byte byte0, Buffer stream) {
        if (byte0 == 2) {
            for (int j = 0; j < this.anInt893; ++j) {
                int k = this.anIntArray894[j];
                Player player = this.playerArray[k];
                int l = stream.readUnsignedByte();
                if ((l & 64) != 0) {
                    l += stream.readUnsignedByte() << 8;
                }

                this.method107(l, k, stream, player);
            }
        }

    }

    public void method50(int y, int primaryColor, int x, int secondaryColor, int z) {
        int uid = worldController.method300(z, x, y);
        if ((uid ^ 0xffffffffffffffffL) != -1L) {
            int resourceTag = worldController.method304(z, x, y, uid);
            int direction = resourceTag >> 6 & 3;//direction
            int type = resourceTag & 0x1f;//type
            int color = primaryColor;//color
            if (uid > 0)
                color = secondaryColor;
            int[] mapPixels = minimapImage.myPixels;
            int pixel = 24624 + x * 4 + (103 - y) * 512 * 4;
            int objectId = worldController.fetchWallDecorationNewUID(z, x, y);//uid >> 14 & 0x7fff;
            ObjectDefinition objDef = ObjectDefinition.forID(objectId);
            if ((objDef.mapscene ^ 0xffffffff) == 0) {
                if (type == 0 || type == 2)
                    if (direction == 0) {
                        mapPixels[pixel] = color;
                        mapPixels[pixel + 512] = color;
                        mapPixels[1024 + pixel] = color;
                        mapPixels[1536 + pixel] = color;
                    } else if ((direction ^ 0xffffffff) == -2) {
                        mapPixels[pixel] = color;
                        mapPixels[pixel + 1] = color;
                        mapPixels[pixel + 2] = color;
                        mapPixels[3 + pixel] = color;
                    } else if (direction == 2) {
                        mapPixels[pixel - -3] = color;
                        mapPixels[3 + (pixel + 512)] = color;
                        mapPixels[3 + (pixel + 1024)] = color;
                        mapPixels[1536 + (pixel - -3)] = color;
                    } else if (direction == 3) {
                        mapPixels[pixel + 1536] = color;
                        mapPixels[pixel + 1536 + 1] = color;
                        mapPixels[2 + pixel + 1536] = color;
                        mapPixels[pixel + 1539] = color;
                    }
                if (type == 3)
                    if (direction == 0)
                        mapPixels[pixel] = color;
                    else if (direction == 1)
                        mapPixels[pixel + 3] = color;
                    else if (direction == 2)
                        mapPixels[pixel + 3 + 1536] = color;
                    else if (direction == 3)
                        mapPixels[pixel + 1536] = color;
                if (type == 2)
                    if (direction == 3) {
                        mapPixels[pixel] = color;
                        mapPixels[pixel + 512] = color;
                        mapPixels[pixel + 1024] = color;
                        mapPixels[pixel + 1536] = color;
                    } else if (direction == 0) {
                        mapPixels[pixel] = color;
                        mapPixels[pixel + 1] = color;
                        mapPixels[pixel + 2] = color;
                        mapPixels[pixel + 3] = color;
                    } else if (direction == 1) {
                        mapPixels[pixel + 3] = color;
                        mapPixels[pixel + 3 + 512] = color;
                        mapPixels[pixel + 3 + 1024] = color;
                        mapPixels[pixel + 3 + 1536] = color;
                    } else if (direction == 2) {
                        mapPixels[pixel + 1536] = color;
                        mapPixels[pixel + 1536 + 1] = color;
                        mapPixels[pixel + 1536 + 2] = color;
                        mapPixels[pixel + 1536 + 3] = color;
                    }
            }
        }
        uid = worldController.method302(z, x, y);
        if (uid != 0) {
            int resourceTag = worldController.method304(z, x, y, uid);
            int direction = resourceTag >> 6 & 3;
            int type = resourceTag & 0x1f;
            int objectId = worldController.fetchObjectMeshNewUID(z, x, y);//uid >> 14 & 0x7fff;
            ObjectDefinition objDef = ObjectDefinition.forID(objectId);
            if (objDef.mapscene != -1) {
                Sprite scene = aBackgroundArray1060[objDef.mapscene];
                if (scene != null) {
                    int sceneX = (objDef.width * 4 - scene.myWidth) / 2;
                    int sceneY = (objDef.length * 4 - scene.myHeight) / 2;
                    scene.drawSprite(48 + x * 4 + sceneX, 48 + (104 - y - objDef.length) * 4 + sceneY);
                }
            } else if (type == 9) {
                int color = 0xeeeeee;
                if (uid > 0)
                    color = 0xee0000;
                int[] mapPixels = minimapImage.myPixels;
                int pixel = 24624 + x * 4 + (103 - y) * 512 * 4;
                if (direction == 0 || direction == 2) {
                    mapPixels[pixel + 1536] = color;
                    mapPixels[pixel + 1024 + 1] = color;
                    mapPixels[pixel + 512 + 2] = color;
                    mapPixels[pixel + 3] = color;
                } else {
                    mapPixels[pixel] = color;
                    mapPixels[pixel + 512 + 1] = color;
                    mapPixels[pixel + 1024 + 2] = color;
                    mapPixels[pixel + 1536 + 3] = color;
                }
            }
        }
        uid = worldController.fetchGroundDecorationNewUID(z, x, y);
        if (uid > 0) {
            ObjectDefinition objDef = ObjectDefinition.forID(uid);
            if (objDef.mapscene != -1) {
                Sprite scene = aBackgroundArray1060[objDef.mapscene];
                if (scene != null) {
                    int sceneX = (objDef.width * 4 - scene.myWidth) / 2;
                    int sceneY = (objDef.length * 4 - scene.myHeight) / 2;
                    scene.drawSprite(48 + x * 4 + sceneX, 48 + (104 - y - objDef.mapscene) * 4 + sceneY);
                }
            }
        }
    }

    public final void loadTitleScreen() {
        if (this.normalLogin) {
            this.aBackground_966 = new Background(this.titleStreamLoader, "titlebox", 0);
            this.aBackground_967 = new Background(this.titleStreamLoader, "titlebutton", 0);
        }

        int j = 0;

        try {
            j = Integer.parseInt(this.getParameter("fl_icon"));
        } catch (Exception var3) {
        }

        int j4;
        if (j == 0) {
            for (j4 = 0; j4 < 12; ++j4) {
            }
        } else {
            for (j4 = 0; j4 < 12; ++j4) {
            }
        }

        this.aSprite_1201 = new Sprite(128, 265);
        this.aSprite_1202 = new Sprite(128, 265);

        for (j4 = 0; j4 < '\u8480'; ++j4) {
            this.aSprite_1201.myPixels[j4] = this.aRSImageProducer_1110.canvasRaster[j4];
        }

        for (j4 = 0; j4 < '\u8480'; ++j4) {
            this.aSprite_1202.myPixels[j4] = this.aRSImageProducer_1111.canvasRaster[j4];
        }

        this.anIntArray851 = new int[256];

        for (j4 = 0; j4 < 64; ++j4) {
            this.anIntArray851[j4] = j4 * 262144;
        }

        for (j4 = 0; j4 < 64; ++j4) {
            this.anIntArray851[j4 + 64] = 6684672 + 1024 * j4;
        }

        for (j4 = 0; j4 < 64; ++j4) {
            this.anIntArray851[j4 + 128] = 419328 + 4 * j4;
        }

        for (j4 = 0; j4 < 64; ++j4) {
            this.anIntArray851[j4 + 192] = 6710886;
        }

        this.anIntArray852 = new int[256];

        for (j4 = 0; j4 < 64; ++j4) {
            this.anIntArray852[j4] = j4 * 1024;
        }

        for (j4 = 0; j4 < 64; ++j4) {
            this.anIntArray852[j4 + 64] = '\uff00' + 4 * j4;
        }

        for (j4 = 0; j4 < 64; ++j4) {
            this.anIntArray852[j4 + 128] = '\uffff' + 262144 * j4;
        }

        for (j4 = 0; j4 < 64; ++j4) {
            this.anIntArray852[j4 + 192] = 6710886;
        }

        this.anIntArray853 = new int[256];

        for (j4 = 0; j4 < 64; ++j4) {
            this.anIntArray853[j4] = j4 * 4;
        }

        for (j4 = 0; j4 < 64; ++j4) {
            this.anIntArray853[j4 + 64] = 255 + 393216 * j4;
        }

        for (j4 = 0; j4 < 64; ++j4) {
            this.anIntArray853[j4 + 128] = 6684774 + 1024 * j4;
        }

        for (j4 = 0; j4 < 64; ++j4) {
            this.anIntArray853[j4 + 192] = 6710886;
        }

        this.anIntArray850 = new int[256];
        this.anIntArray1190 = new int['\u8000'];
        this.anIntArray1191 = new int['\u8000'];
        this.method106(null, -135);
        this.anIntArray828 = new int['\u8000'];
        this.drawLoadingText(10, "Connecting To Fileserver");
        if (!this.aBoolean831) {
            this.aBoolean880 = true;
            this.aBoolean831 = true;
            this.method12(this, 2);
        }

    }

    public final void loadingStages() {
        if (lowMem && this.anInt1023 == 2 && ObjectManager.anInt131 != this.plane) {
            aRSImageProducer_1165.initDrawingArea();
            drawLoadingMessages(1, "Loading - please wait.", null);
            aRSImageProducer_1165.drawGraphics(currentScreenMode == Main.ScreenMode.FIXED ? 4 : 0, super.graphics,
                    currentScreenMode == Main.ScreenMode.FIXED ? 4 : 0);
            this.anInt1023 = 1;
            this.aLong824 = System.currentTimeMillis();
        }

        if (this.anInt1023 == 1) {
            int j = this.method54();
            if (j != 0 && System.currentTimeMillis() - this.aLong824 > 360000L) {
                SignLink.reporterror(this.myUsername + " glcfb " + this.aLong1215 + "," + j + "," + lowMem + ","
                        + this.Indexes[0] + "," + onDemandFetcher.getNodeCount() + "," + this.plane + ","
                        + this.mapRegionsX + "," + this.mapRegionsY);
                this.aLong824 = System.currentTimeMillis();
            }
        }

        if (this.anInt1023 == 2 && this.plane != this.anInt985) {
            this.anInt985 = this.plane;
            this.method24(this.plane);
        }

    }

    public int method54() {
        for (int var6 = 0; var6 < this.aByteArrayArray1183.length; ++var6) {
            if (this.aByteArrayArray1183[var6] == null && this.anIntArray1235[var6] != -1) {
                return -1;
            }

            if (this.aByteArrayArray1247[var6] == null && this.anIntArray1236[var6] != -1) {
                return -2;
            }
        }

        boolean var61 = true;

        for (int j = 0; j < this.aByteArrayArray1183.length; ++j) {
            byte[] abyte0 = this.aByteArrayArray1247[j];
            if (abyte0 != null) {
                int k = (this.anIntArray1234[j] >> 8) * 64 - this.baseX;
                int l = (this.anIntArray1234[j] & 255) * 64 - this.baseY;
                if (this.aBoolean1159) {
                    k = 10;
                    l = 10;
                }

                var61 &= ObjectManager.method189(k, abyte0, l);
            }
        }

        if (!var61) {
            return -3;
        } else if (this.aBoolean1080) {
            return -4;
        } else {
            this.anInt1023 = 2;
            ObjectManager.anInt131 = this.plane;
            this.method22();
            stream.createFrame(121);
            return 0;
        }
    }

    public final void method55() {
        for (Animable_Sub4 class30_sub2_sub4_sub4 = (Animable_Sub4) this.aClass19_1013
                .reverseGetFirst(); class30_sub2_sub4_sub4 != null; class30_sub2_sub4_sub4 = (Animable_Sub4) this.aClass19_1013
                .reverseGetNext()) {
            if (class30_sub2_sub4_sub4.anInt1597 == this.plane && loopCycle <= class30_sub2_sub4_sub4.anInt1572) {
                if (loopCycle >= class30_sub2_sub4_sub4.anInt1571) {
                    if (class30_sub2_sub4_sub4.anInt1590 > 0) {
                        Npc j11 = this.npcArray[class30_sub2_sub4_sub4.anInt1590 - 1];
                        if (j11 != null && j11.x >= 0 && j11.x < 13312 && j11.y >= 0 && j11.y < 13312) {
                            class30_sub2_sub4_sub4.method455(loopCycle, j11.y,
                                    this.method42(class30_sub2_sub4_sub4.anInt1597, j11.y, j11.x)
                                            - class30_sub2_sub4_sub4.anInt1583,
                                    j11.x, (byte) -83);
                        }
                    }

                    if (class30_sub2_sub4_sub4.anInt1590 < 0) {
                        int j111 = -class30_sub2_sub4_sub4.anInt1590 - 1;
                        Player player;
                        if (j111 == this.unknownInt10) {
                            player = myPlayer;
                        } else {
                            player = this.playerArray[j111];
                        }

                        if (player != null && player.x >= 0
                                && player.x < 13312 && player.y >= 0
                                && player.y < 13312) {
                            class30_sub2_sub4_sub4.method455(loopCycle, player.y,
                                    this.method42(class30_sub2_sub4_sub4.anInt1597, player.y,
                                            player.x) - class30_sub2_sub4_sub4.anInt1583,
                                    player.x, (byte) -83);
                        }
                    }

                    class30_sub2_sub4_sub4.method456(this.tickDelta, this.anInt1020);
                    this.worldController.method285(this.plane, class30_sub2_sub4_sub4.anInt1595,
                            (int) class30_sub2_sub4_sub4.aDouble1587, -1, (int) class30_sub2_sub4_sub4.aDouble1586, 60,
                            (int) class30_sub2_sub4_sub4.aDouble1585, class30_sub2_sub4_sub4, false);
                }
            } else {
                class30_sub2_sub4_sub4.unlink();
            }
        }

    }

    public final AppletContext getAppletContext() {
        return SignLink.mainapp != null ? SignLink.mainapp.getAppletContext() : super.getAppletContext();
    }

    public final void method56(int i) {
        byte[] abyte0 = this.titleStreamLoader.readFile("title.dat");
        Sprite Sprite = new Sprite(abyte0, this);
        this.aRSImageProducer_1110.initDrawingArea();
        Sprite.method346(0, 0);
        this.aRSImageProducer_1111.initDrawingArea();
        Sprite.method346(-637, 0);
        this.aRSImageProducer_1107.initDrawingArea();
        Sprite.method346(-128, 0);
        this.aRSImageProducer_1108.initDrawingArea();
        Sprite.method346(-202, -371);
        this.aRSImageProducer_1109.initDrawingArea();
        Sprite.method346(-202, -171);
        this.aRSImageProducer_1112.initDrawingArea();
        Sprite.method346(0, -265);
        this.aRSImageProducer_1113.initDrawingArea();
        Sprite.method346(-562, -265);
        this.aRSImageProducer_1114.initDrawingArea();
        Sprite.method346(-128, -171);
        this.aRSImageProducer_1115.initDrawingArea();
        Sprite.method346(-562, -171);
        int[] ai = new int[Sprite.myWidth];

        for (int obj = 0; obj < Sprite.myHeight; ++obj) {
            int obj1;
            for (obj1 = 0; obj1 < Sprite.myWidth; ++obj1) {
                ai[obj1] = Sprite.myPixels[Sprite.myWidth - obj1 - 1 + Sprite.myWidth * obj];
            }

            for (obj1 = 0; obj1 < Sprite.myWidth; ++obj1) {
                Sprite.myPixels[obj1 + Sprite.myWidth * obj] = ai[obj1];
            }
        }

        if (i == 0) {
            Sprite = null;
            System.gc();
        }

    }

    private boolean saveWave(byte[] abyte0, int i) {
        return abyte0 == null || SignLink.wavesave(abyte0, i);
    }

	public final void method57(boolean flag) {
		while (true) {
			OnDemandData onDemandData = onDemandFetcher.getNextNode();
			if (onDemandData == null) {
				return;
			}

			if (onDemandData.dataType == 0) {
				Model.method460(onDemandData.buffer, onDemandData.ID);
				if (this.backDialogID != -1) {
					this.inputTaken = true;
				}
			}

			if (onDemandData.dataType == 1 && onDemandData.buffer != null)
				Frame.load(onDemandData.ID, onDemandData.buffer);
			if (onDemandData.dataType == 2 && onDemandData.ID == this.nextSong && onDemandData.buffer != null)
				this.playMidi(onDemandData.buffer);
			if (onDemandData.dataType == 3 && this.anInt1023 == 1)
				for (int i = 0; i < this.aByteArrayArray1183.length; ++i) {
					if (this.anIntArray1235[i] == onDemandData.ID) {
						this.aByteArrayArray1183[i] = onDemandData.buffer;
						if (onDemandData.buffer == null) {
							this.anIntArray1235[i] = -1;
						}
						break;
					}

					if (this.anIntArray1236[i] == onDemandData.ID) {
						this.aByteArrayArray1247[i] = onDemandData.buffer;
						if (onDemandData.buffer == null) {
							this.anIntArray1236[i] = -1;
						}
						break;
					}
				}
			if (onDemandData.dataType == 4)
				Texture.decode(onDemandData.ID, onDemandData.buffer);
			if (onDemandData.dataType == 93 && onDemandFetcher.method564(onDemandData.ID)) {
				ObjectManager.method173(new Buffer(onDemandData.buffer, 891), onDemandFetcher);
			}
		}
	}

    public final boolean method59(byte[] abyte0, byte byte0, int i) {
        if (byte0 != 116) {
            throw new NullPointerException();
        } else {
            return abyte0 == null || SignLink.wavesave(abyte0, i);
        }
    }

    public final void method60(int i, byte byte0) {
        Widget class9 = Widget.interfaceCache[i];

        for (int j = 0; j < class9.children.length && class9.children[j] != -1; ++j) {
            Widget class9_1 = Widget.interfaceCache[class9.children[j]];
            if (class9_1.type == 1) {
                this.method60(class9_1.id, (byte) 6);
            }

            class9_1.anInt246 = 0;
            class9_1.anInt208 = 0;
        }

    }

    public final void drawHeadIcon() {
        if (this.anInt855 == 2) {
            this.calcEntityScreenPos((this.anInt934 - this.baseX << 7) + this.anInt937, this.anInt936 * 2,
                    this.anInt875, (this.anInt935 - this.baseY << 7) + this.anInt938);
            if (this.spriteDrawX > -1 && loopCycle % 20 < 10) {
                this.headIconsHint[0].drawSprite(this.spriteDrawX - 12, this.spriteDrawY - 28);
            }
        }

    }

    public void TargetInformation(int xPos, int yPos, String text, String text1, int xPos1, int yPos1) {
        if (text != null) {
            String[] results1 = text1.split("\n");
            String[] results = text.split("\n");
            int height = results.length * 16 + 6;
            int width = results.length * 16 + 6;
            int height1 = results1.length * 12 + 6;
            int width1 = results1.length * 16 + 6;
            width = this.regularText.getTextWidth(results[0]);

            int box;
            for (box = 1; box < results.length; ++box) {
                if (width <= this.regularText.getTextWidth(results[box])) {
                    width = this.regularText.getTextWidth(results[box]);
                }
            }

            width1 = this.regularText.getTextWidth(results1[0]) + 10;

            for (box = 1; box < results1.length; ++box) {
                if (width1 <= this.regularText.getTextWidth(results1[box]) + 6) {
                    width1 = this.regularText.getTextWidth(results1[box]) + 6;
                }
            }

            box = width1 + 12;
            DrawingArea.drawPixels(height, yPos, xPos, 5918788, width + box);
            DrawingArea.fillPixels(xPos, width + box, height, 8811872, yPos);
            DrawingArea.drawPixels(height1, yPos1, xPos1, 4603186, width1);
            DrawingArea.fillPixels(xPos1, width1, height1, 8811872, yPos1);
            yPos += 14;
            yPos1 += 14;

            int i;
            for (i = 0; i < results.length; ++i) {
                this.regularText.method389(false, xPos + width1 + 6, 9, results[i], yPos);
                yPos += 16;
            }

            for (i = 0; i < results1.length; ++i) {
                this.regularText.method389(false, xPos1 + 5, 9, results1[i], yPos1);
                yPos1 += 16;
            }
        }

    }

    public void mainGameProcessor() {
        if (currentScreenMode != ScreenMode.FIXED && currentScreenMode != ScreenMode.FULLSCREEN) {
            if (currentGameWidth != getGameComponent().getWidth()) {
                currentGameWidth = getGameComponent().getWidth();
                gameScreenWidth = getGameComponent().getWidth();
                graphics = super.getGameComponent().getGraphics();
                setBounds();
            }
            if (currentGameHeight != getGameComponent().getHeight()) {
                currentGameHeight = getGameComponent().getHeight();
                gameScreenHeight = getGameComponent().getHeight();
                graphics = super.getGameComponent().getGraphics();
                setBounds();
            }
        }
        spin();
        if (anInt1104 > 1)
            anInt1104--;
        if (anInt1011 > 0)
            anInt1011--;
        for (int j = 0; j < 5; j++)
            if (!this.method145(true))
                break;
        if (!loggedIn)
            return;
        synchronized (mouseDetection.syncObject) {
            if (aBoolean1205) {
                if (super.clickMode3 != 0 || mouseDetection.coordsIndex >= 40) {
                    stream.createFrame(45);
                    stream.writeWordBigEndian(0);
                    int j2 = stream.currentOffset;
                    int j3 = 0;
                    for (int j4 = 0; j4 < mouseDetection.coordsIndex; j4++) {
                        if (j2 - stream.currentOffset >= 240)
                            break;
                        j3++;
                        int l4 = mouseDetection.coordsY[j4];
                        if (l4 < 0)
                            l4 = 0;
                        else if (l4 > 502)
                            l4 = 502;
                        int k5 = mouseDetection.coordsX[j4];
                        if (k5 < 0)
                            k5 = 0;
                        else if (k5 > 764)
                            k5 = 764;
                        int i6 = l4 * 765 + k5;
                        if (mouseDetection.coordsY[j4] == -1 && mouseDetection.coordsX[j4] == -1) {
                            k5 = -1;
                            l4 = -1;
                            i6 = 0x7ffff;
                        }
                        if (k5 == anInt1237 && l4 == anInt1238) {
                            if (anInt1022 < 2047)
                                anInt1022++;
                        } else {
                            int j6 = k5 - anInt1237;
                            anInt1237 = k5;
                            int k6 = l4 - anInt1238;
                            anInt1238 = l4;
                            if (anInt1022 < 8 && j6 >= -32 && j6 <= 31 && k6 >= -32 && k6 <= 31) {
                                j6 += 32;
                                k6 += 32;
                                stream.writeWord((anInt1022 << 12) + (j6 << 6) + k6);
                                anInt1022 = 0;
                            } else if (anInt1022 < 8) {
                                stream.writeDWordBigEndian(0x800000 + (anInt1022 << 19) + i6);
                                anInt1022 = 0;
                            } else {
                                stream.writeDWord(0xc0000000 + (anInt1022 << 19) + i6);
                                anInt1022 = 0;
                            }
                        }
                    }

                    stream.writeBytes(stream.currentOffset - j2);
                    if (j3 >= mouseDetection.coordsIndex) {
                        mouseDetection.coordsIndex = 0;
                    } else {
                        mouseDetection.coordsIndex -= j3;
                        for (int i5 = 0; i5 < mouseDetection.coordsIndex; i5++) {
                            mouseDetection.coordsX[i5] = mouseDetection.coordsX[i5 + j3];
                            mouseDetection.coordsY[i5] = mouseDetection.coordsY[i5 + j3];
                        }

                    }
                }
            } else {
                mouseDetection.coordsIndex = 0;
            }
        }
        if (super.clickMode3 != 0) {
            long l = (super.aLong29 - aLong1220) / 50L;
            if (l > 4095L)
                l = 4095L;
            aLong1220 = super.aLong29;
            int k2 = super.saveClickY;
            if (k2 < 0)
                k2 = 0;
            else if (k2 > 502)
                k2 = 502;
            int k3 = super.saveClickX;
            if (k3 < 0)
                k3 = 0;
            else if (k3 > 764)
                k3 = 764;
            int k4 = k2 * 765 + k3;
            int j5 = 0;
            if (super.clickMode3 == 2)
                j5 = 1;
            int l5 = (int) l;
            stream.createFrame(241);
            stream.writeDWord((l5 << 20) + (j5 << 19) + k4);
        }
        if (anInt1016 > 0)
            anInt1016--;
        if (super.anIntArray30[1] == 1 || super.anIntArray30[2] == 1 || super.anIntArray30[3] == 1
                || super.anIntArray30[4] == 1)
            aBoolean1017 = true;
        if (aBoolean1017 && anInt1016 <= 0) {
            anInt1016 = 20;
            aBoolean1017 = false;
            stream.createFrame(86);
            stream.writeWord(anInt1184);
            stream.method432(anInt1185);
        }
        if (super.aBoolean17 && !aBoolean954) {
            aBoolean954 = true;
            stream.createFrame(3);
            stream.writeWordBigEndian(1);
        }
        if (!super.aBoolean17 && aBoolean954) {
            aBoolean954 = false;
            stream.createFrame(3);
            stream.writeWordBigEndian(0);
        }
        this.loadingStages();
        this.method115((byte) 8);
        this.method90();
        ++this.anInt1009;
        if (this.anInt1009 > 750)
            this.dropClient();
        this.method114();
        this.method95();
        this.method38((byte) -92);
        ++this.tickDelta;
        if (this.crossType != 0) {
            this.crossIndex += 20;
            if (this.crossIndex >= 400) {
                this.crossType = 0;
            }
        }

        if (this.atInventoryInterfaceType != 0) {
            ++this.atInventoryLoopCycle;
            if (this.atInventoryLoopCycle >= 15) {
                if (atInventoryInterfaceType == 2)
                    needDrawTabArea = true;
                if (atInventoryInterfaceType == 3)
                    inputTaken = true;

                this.atInventoryInterfaceType = 0;
            }
        }

        if (this.activeInterfaceType != 0) {
            ++this.anInt989;
            if (super.mouseX > this.anInt1087 + 5 || super.mouseX < this.anInt1087 - 5
                    || super.mouseY > this.anInt1088 + 5 || super.mouseY < this.anInt1088 - 5) {
                this.aBoolean1242 = true;
            }

            if (super.clickMode2 == 0) {
                if (activeInterfaceType == 2)
                    needDrawTabArea = true;
                if (activeInterfaceType == 3)
                    inputTaken = true;

                this.activeInterfaceType = 0;
                if (this.aBoolean1242 && this.anInt989 >= 10) {
                    this.lastActiveInvInterface = -1;
                    this.processRightClick();
                    if (anInt1084 == 5382) {
                        Point southWest, northEast;
                        int xOffset = currentScreenMode == ScreenMode.FIXED ? 0
                                : (centerInterface() ? (currentGameWidth / 2) - 256 : 0);
                        int yOffset = currentScreenMode == ScreenMode.FIXED ? 0
                                : (centerInterface() ? (currentGameHeight / 2) - 167 : 0);
                        southWest = new Point(68 + xOffset, 75 + yOffset);
                        northEast = new Point(457 + xOffset, 41 + yOffset);
                        int[] slots = new int[9];
                        for (int i = 0; i < slots.length; i++)
                            slots[i] = i == 0 ? (int) southWest.getX() : (41 * i) + (int) southWest.getX();
                        for (int i = 0; i < slots.length; i++) {
                            if (super.mouseX >= slots[i] && super.mouseX <= slots[i] + 42
                                    && super.mouseY >= northEast.getY() && super.mouseY <= southWest.getY()) {
                                Widget rsi = Widget.interfaceCache[58050 + i];
                                if (rsi.isMouseoverTriggered) {
                                    continue;
                                }
                                stream.createFrame(214);
                                stream.method433(anInt1084);
                                stream.method424(0, 0);
                                stream.method433(anInt1085);
                                stream.method431(1000 + i);
                                return;
                            }
                        }
                    }
                    if (lastActiveInvInterface == anInt1084 && mouseInvInterfaceIndex != anInt1085) {
                        Widget class9 = Widget.interfaceCache[anInt1084];
                        int j1 = 0;
                        if (anInt913 == 1 && class9.contentType == 206)
                            j1 = 1;
                        if (class9.inventoryItemId[mouseInvInterfaceIndex] <= 0)
                            j1 = 0;
                        if (class9.replaceItems) {
                            int l2 = anInt1085;
                            int l3 = mouseInvInterfaceIndex;
                            class9.inventoryItemId[l3] = class9.inventoryItemId[l2];
                            class9.inventoryAmounts[l3] = class9.inventoryAmounts[l2];
                            class9.inventoryItemId[l2] = -1;
                            class9.inventoryAmounts[l2] = 0;
                        } else if (j1 == 1) {
                            int i3 = anInt1085;
                            for (int i4 = mouseInvInterfaceIndex; i3 != i4; )
                                if (i3 > i4) {
                                    class9.method204(i3, (byte) 9, i3 - 1);
                                    i3--;
                                } else if (i3 < i4) {
                                    class9.method204(i3, (byte) 9, i3 + 1);
                                    i3++;
                                }

                        } else {
                            class9.method204(anInt1085, (byte) 9, mouseInvInterfaceIndex);
                        }
                        stream.createFrame(214);
                        stream.method433(anInt1084);
                        stream.method424(j1, 0);
                        stream.method433(anInt1085);
                        stream.method431(mouseInvInterfaceIndex);
                    }
                } else if ((this.anInt1253 == 1 || this.menuHasAddFriend(this.menuActionRow - 1))
                        && this.menuActionRow > 2) {
                    this.determineMenuSize();
                } else if (this.menuActionRow > 0) {
                    this.doAction(this.menuActionRow - 1);
                }

                this.atInventoryLoopCycle = 10;
                super.clickMode3 = 0;
            }
        }

        if (WorldController.anInt470 != -1) {
            int exception = WorldController.anInt470;
            int k1 = WorldController.anInt471;
            boolean var181 = this.doWalkTo(0, 0, 0, 0, myPlayer.smallY[0], 0, 0, k1, myPlayer.smallX[0], true,
                    exception);
            WorldController.anInt470 = -1;
            if (var181) {
                this.anInt914 = super.saveClickX;
                this.anInt915 = super.saveClickY;
                this.crossType = 1;
                this.crossIndex = 0;
            }
        }

        if (super.clickMode3 == 1 && this.aString844 != null) {
            this.aString844 = null;
            inputTaken = true;
            super.clickMode3 = 0;
        }

        if (!processMenuClick()) {
            processTabClick();
            processMainScreenClick();

            // processTabClick2();
            processChatModeClick();
        }
        if (super.clickMode2 == 1 || super.clickMode3 == 1) {
            ++this.anInt1213;
        }

        if (this.anInt1500 == 0 && this.anInt1044 == 0 && this.anInt1129 == 0) {
            if (this.anInt1501 < tooltipDelay) {
                ++this.anInt1501;
                if (anInt1501 == tooltipDelay) {
                    if (anInt1500 != 0) {
                        inputTaken = true;
                    }
                    if (anInt1044 != 0) {
                        needDrawTabArea = true;
                    }
                }
            }
        } else {
            if (this.anInt1501 < tooltipDelay && !this.menuOpen) {
                ++this.anInt1501;
                if (anInt1501 == tooltipDelay) {
                    if (anInt1500 != 0) {
                        inputTaken = true;
                    }
                    if (anInt1044 != 0) {
                        needDrawTabArea = true;
                    }
                }
            }

            if (this.anInt1501 > tooltipDelay) {
                --this.anInt1501;
            }
        }

        if (this.anInt1023 == 2) {
            this.method108(3);
        }

        if (this.anInt1023 == 2 && this.aBoolean1160) {
            this.method39((byte) 5);
        }

        for (int exception = 0; exception < 5; ++exception) {
            ++this.anIntArray1030[exception];
        }

        this.method73(732);
        ++super.idleTime;
        if (super.idleTime > IDLE_TIME) {
            anInt1011 = 250;
            super.idleTime -= 500;
            stream.createFrame(202);
        }
        anInt1010++;
        if (anInt1010 > 50)
            stream.createFrame(0);
        try {
            if (aRSSocket_1168 != null && stream.currentOffset > 0) {
                aRSSocket_1168.method271(stream.currentOffset, stream.buffer);
                stream.currentOffset = 0;
                anInt1010 = 0;
            }
        } catch (IOException var131) {
            this.dropClient();
            return;
        } catch (Exception var14) {
            this.resetLogout();
        }

    }

    private final void method63(int i) {
        Class30_Sub1 class30_sub1 = (Class30_Sub1) this.aClass19_1179.reverseGetFirst();

        while (i >= 0) {
            for (int j = 1; j > 0; ++j) {
            }
        }

        for (; class30_sub1 != null; class30_sub1 = (Class30_Sub1) this.aClass19_1179.reverseGetNext()) {
            if (class30_sub1.anInt1294 == -1) {
                class30_sub1.anInt1302 = 0;
                this.method89(false, class30_sub1);
            } else {
                class30_sub1.unlink();
            }
        }

    }

    public final void resetImageProducers() {
        if (this.aRSImageProducer_1107 == null) {
            super.aRSImageProducer_13 = null;
            aRSImageProducer_1166 = null;
            this.aRSImageProducer_1164 = null;
            aRSImageProducer_1163 = null;
            aRSImageProducer_1165 = null;
            this.aRSImageProducer_1125 = null;
            this.aRSImageProducer_1110 = new RSImageProducer(128, 265, getGameComponent());
            DrawingArea.setAllPixelsToZero();
            this.aRSImageProducer_1111 = new RSImageProducer(128, 265, getGameComponent());
            DrawingArea.setAllPixelsToZero();
            this.aRSImageProducer_1107 = new RSImageProducer(509, 171, getGameComponent());
            DrawingArea.setAllPixelsToZero();
            this.aRSImageProducer_1108 = new RSImageProducer(360, 132, getGameComponent());
            DrawingArea.setAllPixelsToZero();
            this.aRSImageProducer_1109 = new RSImageProducer(500, 153, getGameComponent());
            DrawingArea.setAllPixelsToZero();
            this.aRSImageProducer_1112 = new RSImageProducer(602, 438, getGameComponent());
            DrawingArea.setAllPixelsToZero();
            this.aRSImageProducer_1113 = new RSImageProducer(203, 238, getGameComponent());
            DrawingArea.setAllPixelsToZero();
            this.aRSImageProducer_1114 = new RSImageProducer(74, 94, getGameComponent());
            DrawingArea.setAllPixelsToZero();
            this.aRSImageProducer_1115 = new RSImageProducer(75, 94, getGameComponent());
            DrawingArea.setAllPixelsToZero();
            if (this.titleStreamLoader != null) {
                this.method56(0);
                this.loadTitleScreen();
            }

            this.aBoolean1255 = true;
        }

    }

    public final void drawLoadingText(int i, String s) {
        this.anInt1079 = i;
        this.aString1049 = s;
        this.resetImageProducers();
        if (this.titleStreamLoader == null) {
            super.drawLoadingText(i, s);
        } else {
            this.aRSImageProducer_1109.initDrawingArea();
            short c = 360;
            short c1 = 200;
            byte byte1 = 20;
            this.boldText.method381(16777215, "Ghreborn is Loading...", 23693, c1 / 2 - 26 - byte1, c / 2);
            int j = c1 / 2 - 18 - byte1;
            DrawingArea.fillPixels(c / 2 - 152, 304, 18, 13421772, j);
            DrawingArea.fillPixels(c / 2 - 151, 302, 16, 10855845, j + 1);
            DrawingArea.drawPixels(14, j + 2, c / 2 - 150, 7368816, i * 3);
            DrawingArea.drawPixels(14, j + 2, c / 2 - 150 + i * 3, 0, 300 - i * 3);
            this.smallText.method381(16777215, s, 23693, c1 / 2 - 5 - byte1, c / 2);
            this.aRSImageProducer_1109.drawGraphics(171, super.graphics, 202);
            if (this.aBoolean1255) {
                this.aBoolean1255 = false;
                if (!this.aBoolean831) {
                    this.aRSImageProducer_1110.drawGraphics(0, super.graphics, 0);
                    this.aRSImageProducer_1111.drawGraphics(0, super.graphics, 637);
                }

                this.aRSImageProducer_1107.drawGraphics(0, super.graphics, 128);
                this.aRSImageProducer_1108.drawGraphics(371, super.graphics, 202);
                this.aRSImageProducer_1112.drawGraphics(265, super.graphics, 0);
                this.aRSImageProducer_1113.drawGraphics(265, super.graphics, 562);
                this.aRSImageProducer_1114.drawGraphics(171, super.graphics, 128);
                this.aRSImageProducer_1115.drawGraphics(171, super.graphics, 562);
            }
        }

    }

    public final void method65(int i, int j, int k, int l, Widget class9, int i1, boolean flag, int j1, int k1) {
        if (this.aBoolean972) {
            this.anInt992 = 32;
        } else {
            this.anInt992 = 0;
        }

        this.aBoolean972 = false;
        packetSize += k1;
        if (k >= i && k < i + 16 && l >= i1 && l < i1 + 16) {
            class9.scrollPosition -= this.anInt1213 * 4;
            if (flag) {
                needDrawTabArea = true;
            }
        } else if (k >= i && k < i + 16 && l >= i1 + j - 16 && l < i1 + j) {
            class9.scrollPosition += this.anInt1213 * 4;
            if (flag) {
                needDrawTabArea = true;
            }
        } else if (k >= i - this.anInt992 && k < i + 16 + this.anInt992 && l >= i1 + 16 && l < i1 + j - 16
                && this.anInt1213 > 0) {
            int l1 = (j - 32) * j / j1;
            if (l1 < 8) {
                l1 = 8;
            }

            int i2 = l - i1 - 16 - l1 / 2;
            int j2 = j - 32 - l1;
            class9.scrollPosition = (j1 - j) * i2 / j2;
            if (flag) {
                needDrawTabArea = true;
                this.aBoolean972 = true;
            }
        }

    }

    public boolean method66(int i, int j, int k, int id) {
        int j1 = this.worldController.method304(this.plane, k, j, i);
        if (j1 == -1) {
            return false;
        } else {
            int k1 = j1 & 31;
            int l1 = j1 >> 6 & 3;
            if (k1 == 10 || k1 == 11 || k1 == 22) {
  
                ObjectDefinition class46 = ObjectDefinition.forID(id);
                int i2;
                int j2;
                if (l1 == 0 || l1 == 2) {
                    i2 = class46.length;
                    j2 = class46.width;
                } else {
                    i2 = class46.width;
                    j2 = class46.length;
                }

                int k2 = class46.surroundings;
                if (l1 != 0)
                	k2 = (k2 << l1 & 0xf) + (k2 >> 4 - l1);

                this.doWalkTo(2, 0, j2, 0, myPlayer.smallY[0], i2, k2, j, myPlayer.smallX[0], false, k);
    		} else {
    			doWalkTo(2, l1, 0, k1 + 1, myPlayer.smallY[0], 0, 0, j, myPlayer.smallX[0], false, k);
            }

            this.anInt914 = super.saveClickX;
            this.anInt915 = super.saveClickY;
            this.crossType = 2;
            this.crossIndex = 0;
            return true;
        }
    }

    /*	private StreamLoader createArchive(int file, String displayedName, String name,
			int expectedCRC, int x) {
		byte buffer[] = null;

		try {
			if (Indexes[0] != null)
				buffer = Indexes[0].decompress(file);
		} catch (Exception _ex) {
		}

		//Compare crc...
		if(buffer != null) {
			if(Constants.JAGCACHED_ENABLED) {
				if (!JagGrab.compareCrc(buffer, expectedCRC)) {
					buffer = null;
				}
			}
		}

		if (buffer != null) {
			StreamLoader streamLoader = new StreamLoader(buffer);
			return streamLoader;
		}

		//Retry to redl cache cause it's obvious corrupt or something
		if(buffer == null && !Constants.JAGCACHED_ENABLED) {
			CacheDownloader.start(this, CacheDownloader.FileType.CACHE);
			CacheDownloader.start(this, CacheDownloader.FileType.FILEDATA);
			CacheDownloader.start(this, CacheDownloader.FileType.ANIMS);
			CacheDownloader.start(this, CacheDownloader.FileType.MODELS);
			return createArchive(file, displayedName, name, expectedCRC, x);
		}

		while (buffer == null) {
			drawLoadingText(x, "Requesting " + displayedName);
			try(DataInputStream in = JagGrab.openJagGrabRequest(name)) {

				//Try to get the file..
				buffer = JagGrab.getBuffer(in);

				//Compare crc again...
				if(buffer != null) {
					if (!JagGrab.compareCrc(buffer, expectedCRC)) {
						buffer = null;
					}
				}

				//Write file
				if(buffer != null) {
					try {
						if (Indexes[0] != null)
							Indexes[0].method234(buffer.length, buffer, file);
					} catch (Exception _ex) {
						Indexes[0] = null;
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				buffer = null;
			}

			if(buffer == null) {
				JagGrab.error("Archives");
			}
		}

		StreamLoader streamLoader_1 = new StreamLoader(buffer);
		return streamLoader_1;
	}*/
/*    private StreamLoader createArchive(int file, String displayedName, String name, int j, int k) {
        byte abyte0[] = null;
        int l = 5;
        try {
            if (Indexes[0] != null)
                abyte0 = Indexes[0].decompress(file);
        } catch (Exception _ex) {
        }
        if (abyte0 != null) {
            StreamLoader streamLoader = new StreamLoader(abyte0);
            return streamLoader;
        }
        int j1 = 0;
        while (abyte0 == null) {
            String s2 = "Unknown error";
            drawLoadingText(k, "Requesting " + displayedName);
            try {
                int k1 = 0;
                DataInputStream datainputstream = method132(name + j);
                byte abyte1[] = new byte[6];
                datainputstream.readFully(abyte1, 0, 6);
                Buffer stream = new Buffer(abyte1);
                stream.currentOffset = 3;
                int i2 = stream.read3Bytes() + 6;
                int j2 = 6;
                abyte0 = new byte[i2];
                System.arraycopy(abyte1, 0, abyte0, 0, 6);

                while (j2 < i2) {
                    int l2 = i2 - j2;
                    if (l2 > 1000)
                        l2 = 1000;
                    int j3 = datainputstream.read(abyte0, j2, l2);
                    if (j3 < 0) {
                        s2 = "Length error: " + j2 + "/" + i2;
                        throw new IOException("EOF");
                    }
                    j2 += j3;
                    int k3 = (j2 * 100) / i2;
                    if (k3 != k1)
                        drawLoadingText(k, "Loading " + displayedName + " - " + k3 + "%");
                    k1 = k3;
                }
                datainputstream.close();
                try {
                    if (Indexes[0] != null)
                    	Indexes[0].method234(abyte0.length, abyte0, file);
                } catch (Exception _ex) {
                	Indexes[0] = null;
                }

                aCRC32_930.reset();
                aCRC32_930.update(abyte0);
				int crc = (int) aCRC32_930.getValue();
				if (crc != j) {
					abyte0 = null;
					j1++;
					s2 = "Checksum error: " + crc;
				}
            } catch (IOException ioexception) {
                if (s2.equals("Unknown error"))
                    s2 = "Connection error";
                abyte0 = null;
            } catch (NullPointerException _ex) {
                s2 = "Null error";
                abyte0 = null;
                if (!SignLink.reporterror)
                    return null;
            } catch (ArrayIndexOutOfBoundsException _ex) {
                s2 = "Bounds error";
                abyte0 = null;
                if (!SignLink.reporterror)
                    return null;
            } catch (Exception _ex) {
                s2 = "Unexpected error";
                abyte0 = null;
                if (!SignLink.reporterror)
                    return null;
            }
            if (abyte0 == null) {
                for (int l1 = l; l1 > 0; l1--) {
                    if (j1 >= 3) {
                        drawLoadingText(k, "Game updated - please reload page");
                        l1 = 10;
                    } else {
                        drawLoadingText(k, s2 + " - Retrying in " + l1);
                    }
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception _ex) {
                    }
                }

                l *= 2;
                if (l > 60)
                    l = 60;
                aBoolean872 = !aBoolean872;
            }

        }

        StreamLoader streamLoader_1 = new StreamLoader(abyte0);
        return streamLoader_1;
    }*/
    public final StreamLoader createArchive(int i, String s, String s1, int j, int k) {
        byte[] abyte0 = null;
        int l = 5;

        try {
            if (this.Indexes[0] != null) {
                abyte0 = this.Indexes[0].decompress(i);
            }
        } catch (Exception var22) {
        }
        if (abyte0 != null) {
            StreamLoader var27 = new StreamLoader(abyte0);
            return var27;
        }
        byte j1 = 0;

        while (abyte0 == null) {
            String var28 = "Unknown error";
            this.drawLoadingText(k, "Requesting " + s);

            int l1;
            try {
                l1 = 0;
                DataInputStream var26 = this.method132(s1 + j);
                byte[] abyte1 = new byte[6];
                var26.readFully(abyte1, 0, 6);
                Buffer stream = new Buffer(abyte1, 891);
                stream.currentOffset = 3;
                int i2 = stream.readTriByte() + 6;
                int j2 = 6;
                abyte0 = new byte[i2];

                int _ex;
                for (_ex = 0; _ex < 6; ++_ex) {
                    abyte0[_ex] = abyte1[_ex];
                }

                int k3;
                for (; j2 < i2; l1 = k3) {
                    _ex = i2 - j2;
                    if (_ex > 1000) {
                        _ex = 1000;
                    }

                    int var21 = var26.read(abyte0, j2, _ex);
                    if (var21 < 0) {
                        throw new IOException("EOF");
                    }

                    j2 += var21;
                    k3 = j2 * 100 / i2;
                    if (k3 != l1) {
                        this.drawLoadingText(k, "Loading " + s + " - " + k3 + "%");
                    }
                }

                var26.close();

                try {
                    if (this.Indexes[0] != null) {
                        this.Indexes[0].method234(abyte0.length, abyte0, i);
                    }
                } catch (Exception var211) {
                    this.Indexes[0] = null;
                }
            } catch (IOException var23) {
                if (var28.equals("Unknown error")) {
                    var28 = "Connection error";
                }

                abyte0 = null;
            } catch (NullPointerException var24) {
                var28 = "Null error";
                abyte0 = null;
                if (!SignLink.reporterror) {
                    return null;
                }
            } catch (ArrayIndexOutOfBoundsException var25) {
                var28 = "Bounds error";
                abyte0 = null;
                if (!SignLink.reporterror) {
                    return null;
                }
            } catch (Exception var261) {
                var28 = "Unexpected error";
                abyte0 = null;
                if (!SignLink.reporterror) {
                    return null;
                }
            }

            if (abyte0 == null) {
                for (l1 = l; l1 > 0; --l1) {
                    if (j1 >= 3) {
                        this.drawLoadingText(k, "Game updated - please reload page");
                        l1 = 10;
                    } else {
                        this.drawLoadingText(k, var28 + " - Retrying in " + l1);
                    }

                    try {
                        Thread.sleep(1000L);
                    } catch (Exception var20) {
                    }
                }

                l *= 2;
                if (l > 60) {
                    l = 60;
                }

                this.aBoolean872 = !this.aBoolean872;
            }
        }

        StreamLoader var281 = new StreamLoader(abyte0);
        return var281;
    }

    private void drawLoadingMessages(int used, String s, String s1) {
        int width = regularText.getTextWidth(used == 1 ? s : s1);
        int height = s1 == null ? 25 : 38;
        DrawingArea.drawBox(1, 1, width + 6, height, 0);
        DrawingArea.drawBox(1, 1, width + 6, 1, 0xffffff);
        DrawingArea.drawBox(1, 1, 1, height, 0xffffff);
        DrawingArea.drawBox(1, height, width + 6, 1, 0xffffff);
        DrawingArea.drawBox(width + 6, 1, 1, height, 0xffffff);
        regularText.drawText(0xffffff, s, 18, width / 2 + 5);
        if (s1 != null) {
            regularText.drawText(0xffffff, s1, 31, width / 2 + 5);
        }
    }

    public final void dropClient() {
        if (this.anInt1011 > 0) {
            this.resetLogout();
        } else {
            aRSImageProducer_1165.initDrawingArea();
            DrawingArea.fillPixels(2, 229, 39, 0xffffff, 2); //white box around
            DrawingArea.method336(37, 3, 3, 0, 227); //black fill
            this.regularText.method381(0, "Connection lost", 23693, 19, 120);
            this.regularText.method381(16777215, "Connection lost", 23693, 18, 119);
            this.regularText.method381(0, "Please wait - attempting to reestablish", 23693, 34, 117);
            this.regularText.method381(16777215, "Please wait - attempting to reestablish", 23693, 34, 116);
            aRSImageProducer_1165.drawGraphics(currentScreenMode == Main.ScreenMode.FIXED ? 4 : 0, super.graphics,
                    currentScreenMode == Main.ScreenMode.FIXED ? 4 : 0);
            this.anInt1021 = 0;
            this.destX = 0;
            RSSocket class24 = this.aRSSocket_1168;
            loggedIn = false;
            this.loginScreenCursorPos = 0;
            this.login(this.myUsername, this.myPassword, true);
            if (!loggedIn) {
                this.resetLogout();
            }

            try {
                class24.method267();
            } catch (Exception var3) {
            }

        }
    }

    public void sendString(int identifier, String text) {
        text = identifier + "," + text;
        stream.createFrame(127);
        stream.writeWordBigEndian(text.length() + 1);
        stream.writeString(text);
    }

    public final void doAction(int i) {
        if (i < 0)
            return;
        if (inputDialogState != 0 && inputDialogState != 3) {
            inputDialogState = 0;
            inputTaken = true;
        }
        int j = this.menuActionCmd2[i];
        int k = this.menuActionCmd3[i];
        int cmd4 = menuActionCmd4[i];
        int l = this.menuActionID[i];
        int i1 = this.menuActionCmd1[i];

        int x = j;
        int y = k;
        int id = (i1 > 0x7fff ? cmd4 : i1 >> 14 & 0x7fff);
        /*
         * System.out.println("" + "menuActionCmd2: " + j + " menuActionCmd3: " + k +
         * " menuActionID: " + l +" menuActionCmd1: " +i1 );
         */
        if (l >= 2000) {
            l -= 2000;
        }

        if (l == 1150) {
            this.anInt1184 = 140;
            this.anInt1185 = 0;
        }

        if (l == 700 && tabInterfaceIDs[10] != -1) {
            if (tabID == 10) {
                showTabComponents = !showTabComponents;
            } else {
                showTabComponents = true;
            }

            tabID = 10;
            tabAreaAltered = true;
        }
		if (l == 474) {
			drawExperienceCounter = !drawExperienceCounter;
		}
		if (l == 475) {
			stream.createFrame(185);
			stream.writeWord(-1);
			experienceCounter = 0L;
		}
        if (l >= 1700 && l <= 1710) {
            stream.createFrame(185);
            int offset = 0;
            offset = k + (k - 58030) * 10 + (l - 1700);
            stream.writeWord(offset);
        }
        if (l == 300) {
            stream.createFrame(141);
            stream.method432(j);
            stream.writeWord(k);
            stream.method432(i1);
            stream.writeDWord(modifiableXValue);
        }
        if (l == 291) {
            stream.createFrame(140);
            stream.writeLEShortA(k);
            stream.writeLEShortA(i1);
            stream.writeLEShort(j);
            this.atInventoryLoopCycle = 0;
            this.atInventoryInterface = k;
            this.atInventoryIndex = j;
            this.atInventoryInterfaceType = 2;
            if (Widget.interfaceCache[k].parentID == openInterfaceID)
                atInventoryInterfaceType = 1;
            if (Widget.interfaceCache[k].parentID == backDialogID)
                atInventoryInterfaceType = 3;
        }
        if (l == 1003) {
            this.clanChatMode = 2;
            inputTaken = true;
        }

        if (l == 1002) {
            this.clanChatMode = 1;
            inputTaken = true;
        }

        if (l == 1001) {
            this.clanChatMode = 0;
            inputTaken = true;
        }

        if (l == 1000) {
            this.cButtonCPos = 4;
            this.chatTypeView = 11;
            inputTaken = true;
        }

        if (l == 999) {
            this.cButtonCPos = 0;
            this.chatTypeView = 0;
            inputTaken = true;
        }

        if (l == 998) {
            this.cButtonCPos = 1;
            this.chatTypeView = 5;
            inputTaken = true;
        }

        if (l == 997) {
            this.publicChatMode = 3;
            inputTaken = true;
        }

        if (l == 996) {
            this.publicChatMode = 2;
            inputTaken = true;
        }

        if (l == 995) {
            this.publicChatMode = 1;
            inputTaken = true;
        }

        if (l == 994) {
            this.publicChatMode = 0;
            inputTaken = true;
        }

        if (l == 993) {
            this.cButtonCPos = 2;
            this.chatTypeView = 1;
            inputTaken = true;
        }

        if (l == 992) {
            this.privateChatMode = 2;
            inputTaken = true;
        }

        if (l == 991) {
            this.privateChatMode = 1;
            inputTaken = true;
        }

        if (l == 990) {
            this.privateChatMode = 0;
            inputTaken = true;
        }

        if (l == 989) {
            this.cButtonCPos = 3;
            this.chatTypeView = 2;
            inputTaken = true;
        }

        if (l == 987) {
            this.tradeMode = 2;
            inputTaken = true;
        }

        if (l == 986) {
            this.tradeMode = 1;
            inputTaken = true;
        }

        if (l == 985) {
            this.tradeMode = 0;
            inputTaken = true;
        }

        if (l == 984) {
            this.cButtonCPos = 5;
            this.chatTypeView = 3;
            inputTaken = true;
        }

        if (l == 980) {
            this.cButtonCPos = 6;
            this.chatTypeView = 4;
            inputTaken = true;
        }

        if (showpackets) {
            System.out.println("packet: " + l);
            System.out.println("packet1: " + j);
        }

        Npc class8_1;
        if (l == 582) {
            class8_1 = this.npcArray[i1];
            if (class8_1 != null) {
                this.doWalkTo(2, 0, 1, 0, myPlayer.smallY[0], 1, 0, class8_1.smallY[0], myPlayer.smallX[0],
                        false, class8_1.smallX[0]);
                this.anInt914 = super.saveClickX;
                this.anInt915 = super.saveClickY;
                this.crossType = 2;
                this.crossIndex = 0;
                stream.createFrame(57);
                stream.method432(this.anInt1285);
                stream.method432(i1);
                stream.method431(this.anInt1283);
                stream.method432(this.anInt1284);
            }
        }

        boolean var12;
        if (l == 234) {
            var12 = this.doWalkTo(2, 0, 0, 0, myPlayer.smallY[0], 0, 0, k, myPlayer.smallX[0], false, j);
            if (!var12) {
                this.doWalkTo(2, 0, 1, 0, myPlayer.smallY[0], 1, 0, k, myPlayer.smallX[0], false, j);
            }

            this.anInt914 = super.saveClickX;
            this.anInt915 = super.saveClickY;
            this.crossType = 2;
            this.crossIndex = 0;
            stream.createFrame(236);
            stream.method431(k + this.baseY);
            stream.method399(i1);
            stream.method431(j + this.baseX);
        }

        if (l == 62 && this.method66(i1, y, x, id)) {
            stream.createFrame(192);
            stream.method399(this.anInt1284);
            stream.method431(id);
            stream.method433(y + this.baseY);
            stream.method431(this.anInt1283);
            stream.method433(x + this.baseX);
            stream.method399(this.anInt1285);
        }

        if (l == 511) {
            var12 = this.doWalkTo(2, 0, 0, 0, myPlayer.smallY[0], 0, 0, k, myPlayer.smallX[0], false, j);
            if (!var12) {
                this.doWalkTo(2, 0, 1, 0, myPlayer.smallY[0], 1, 0, k, myPlayer.smallX[0], false, j);
            }

            this.anInt914 = super.saveClickX;
            this.anInt915 = super.saveClickY;
            this.crossType = 2;
            this.crossIndex = 0;
            stream.createFrame(25);
            stream.method431(this.anInt1284);
            stream.method432(this.anInt1285);
            stream.method399(i1);
            stream.method432(k + this.baseY);
            stream.method433(this.anInt1283);
            stream.method399(j + this.baseX);
        }

        if (l == 74) {
            stream.createFrame(122);
            stream.method433(k);
            stream.method432(j);
            stream.method431(i1);
            this.atInventoryLoopCycle = 0;
            this.atInventoryInterface = k;
            this.atInventoryIndex = j;
            this.atInventoryInterfaceType = 2;
            if (Widget.interfaceCache[k].parentID == openInterfaceID) {
                this.atInventoryInterfaceType = 1;
            }

            if (Widget.interfaceCache[k].parentID == backDialogID) {
                this.atInventoryInterfaceType = 3;
            }
        }

        Widget widget;
        // widget action
        if (l == 315) {
            widget = Widget.interfaceCache[k];
            boolean var221 = true;
            if (widget.contentType > 0) {
                var221 = this.promptUserForInput(widget);
            }

            if (var221) {
                System.out.println("Action Botton : " + k);
                switch (k) {
                    case 62013:
                        Widget input = Widget.interfaceCache[Widget.selectedItemInterfaceId + 1];
                        Widget itemContainer = Widget.interfaceCache[Widget.selectedItemInterfaceId];
                        if (Widget.selectedItemInterfaceId <= 0) {
                            return;
                        }
                        if (input != null && itemContainer != null) {
                            int amount = -1;
                            try {
                                amount = Integer.parseInt(input.message);
                            } catch (NumberFormatException nfe) {
                                pushMessage("The amount must be a non-negative numerical value.", 0, "");
                                break;
                            }
                            if (itemContainer.itemSearchSelectedId < 0) {
                                itemContainer.itemSearchSelectedId = 0;
                            }
                            if (itemContainer.itemSearchSelectedSlot < 0) {
                                itemContainer.itemSearchSelectedSlot = 0;
                            }
                            stream.createFrame(124);
                            stream.writeDWord(Widget.selectedItemInterfaceId);
                            stream.writeDWord(itemContainer.itemSearchSelectedSlot);
                            stream.writeDWord(itemContainer.itemSearchSelectedId - 1);
                            stream.writeDWord(amount);
                        }
                        break;

                    case 32013:
                        Widget input2 = Widget.interfaceCache[Widget.selectedItemInterfaceId + 1];
                        Widget itemContainer2 = Widget.interfaceCache[Widget.selectedItemInterfaceId];
                        if (Widget.selectedItemInterfaceId <= 0) {
                            return;
                        }
                        if (input2 != null && itemContainer2 != null) {
                            int amount = -1;
                            try {
                                amount = Integer.parseInt(input2.message);
                            } catch (NumberFormatException nfe) {
                                pushMessage("The amount must be a non-negative numerical value.", 0, "");
                                break;
                            }
                            if (itemContainer2.itemSearchSelectedId < 0) {
                                itemContainer2.itemSearchSelectedId = 0;
                            }
                            if (itemContainer2.itemSearchSelectedSlot < 0) {
                                itemContainer2.itemSearchSelectedSlot = 0;
                            }
                            stream.createFrame(124);
                            stream.writeDWord(Widget.selectedItemInterfaceId);
                            stream.writeDWord(itemContainer2.itemSearchSelectedSlot);
                            stream.writeDWord(itemContainer2.itemSearchSelectedId - 1);
                            stream.writeDWord(amount);
                        }
                        break;
                    case 17895:
                        if (!newDamage) {
                            newDamage = true;
                        } else if (newDamage) {
                            newDamage = false;
                        }
                        break;

                    case 31032:
                        openInterfaceID = 36000;
                        break;

                    case 27651:
                        openInterfaceID = 26000;
                        break;

                    default:
                        stream.createFrame(185);
                        stream.method399(k);
                }
            }
        }

        Player var23;
        if (l == 561) {
            var23 = this.playerArray[i1];
            if (var23 != null) {
                this.doWalkTo(2, 0, 1, 0, myPlayer.smallY[0], 1, 0, var23.smallY[0], myPlayer.smallX[0],
                        false, var23.smallX[0]);
                this.anInt914 = super.saveClickX;
                this.anInt915 = super.saveClickY;
                this.crossType = 2;
                this.crossIndex = 0;
                anInt1188 += i1;
                if (anInt1188 >= 90) {
                    stream.createFrame(136);
                    anInt1188 = 0;
                }

                stream.createFrame(128);
                stream.method399(i1);
            }
        }

        if (l == 20) {
            class8_1 = this.npcArray[i1];
            if (class8_1 != null) {
                this.doWalkTo(2, 0, 1, 0, myPlayer.smallY[0], 1, 0, class8_1.smallY[0], myPlayer.smallX[0],
                        false, class8_1.smallX[0]);
                this.anInt914 = super.saveClickX;
                this.anInt915 = super.saveClickY;
                this.crossType = 2;
                this.crossIndex = 0;
                stream.createFrame(155);
                stream.method431(i1);
            }
        }

        if (l == 779) {
            var23 = this.playerArray[i1];
            if (var23 != null) {
                this.doWalkTo(2, 0, 1, 0, myPlayer.smallY[0], 1, 0, var23.smallY[0], myPlayer.smallX[0],
                        false, var23.smallX[0]);
                this.anInt914 = super.saveClickX;
                this.anInt915 = super.saveClickY;
                this.crossType = 2;
                this.crossIndex = 0;
                stream.createFrame(153);
                stream.method431(i1);
            }
        }

        if (l == 516) {
            if (!this.menuOpen) {
                x = this.saveClickX - 4;
                y = this.saveClickY - 4;
            } else {
                x = j - 4;
                y = k - 4;
            }
            this.worldController.method312(y, x);
        }

        if (l == 1062) {
            anInt924 += this.baseX;
            if (anInt924 >= 113) {
                stream.createFrame(183);
                stream.writeDWordBigEndian(0xe63271);
                anInt924 = 0;
            }

            this.method66(i1, y, x, id);
            stream.createFrame(228);
            stream.method432(id);
            stream.method432(y + this.baseY);
            stream.writeWord(x + this.baseX);
        }

        if (l == 679 && !this.aBoolean1149) {
            stream.createFrame(40);
            stream.method399(k);
            this.aBoolean1149 = true;
        }

        if (l == 431) {
            stream.createFrame(129);
            stream.method432(j);
            stream.method399(k);
            stream.method432(i1);
            this.atInventoryLoopCycle = 0;
            this.atInventoryInterface = k;
            this.atInventoryIndex = j;
            this.atInventoryInterfaceType = 2;
            if (Widget.interfaceCache[k].parentID == openInterfaceID) {
                this.atInventoryInterfaceType = 1;
            }

            if (Widget.interfaceCache[k].parentID == backDialogID) {
                this.atInventoryInterfaceType = 3;
            }
        }

        long s10;
        int var15;
        String var16;
        if (l == 337 || l == 42 || l == 792 || l == 322) {
            var16 = this.menuActionName[i];
            var15 = var16.indexOf("@whi@");
            if (var15 != -1) {
                s10 = TextClass.longForName(var16.substring(var15 + 5).trim());
                if (l == 337) {
                    this.method41((byte) 68, s10);
                }

                if (l == 42) {
                    this.method113(s10, 4);
                }

                if (l == 792) {
                    this.method35(false, s10);
                }

                if (l == 322) {
                    this.method122(3, s10);
                }
            }
        }

        int k3;
        int i4;
        String var21;
        if (l == 638) {
            var16 = this.menuActionName[i];
            var15 = var16.indexOf("@whi@");
            if (var15 != -1) {
                s10 = TextClass.longForName(var16.substring(var15 + 5).trim());
                k3 = -1;

                for (i4 = 0; i4 < this.friendsCount; ++i4) {
                    if (this.friendsListAsLongs[i4] == s10) {
                        k3 = i4;
                        break;
                    }
                }

                var21 = this.friendsList[k3];
                inputString = "::xteletome " + var21;
                this.sendPacket(103);
            }
        }

        if (l == 637) {
            var16 = this.menuActionName[i];
            var15 = var16.indexOf("@whi@");
            if (var15 != -1) {
                s10 = TextClass.longForName(var16.substring(var15 + 5).trim());
                k3 = -1;

                for (i4 = 0; i4 < this.friendsCount; ++i4) {
                    if (this.friendsListAsLongs[i4] == s10) {
                        k3 = i4;
                        break;
                    }
                }

                var21 = this.friendsList[k3];
                inputString = "::xteleto " + var21;
                this.sendPacket(103);
            }
        }
        if (l == 1337) { // Placeholders
            inputString = "::placeholder-" + j + "-" + i1;
            stream.createFrame(103);
            stream.writeWordBigEndian(inputString.length() - 1);
            stream.writeString(inputString.substring(2));
            inputString = "";
        }
        if (l == 53) {
            stream.createFrame(135);
            stream.method431(j);
            stream.method432(k);
            stream.method431(i1);
            this.atInventoryLoopCycle = 0;
            this.atInventoryInterface = k;
            this.atInventoryIndex = j;
            this.atInventoryInterfaceType = 2;
            if (Widget.interfaceCache[k].parentID == openInterfaceID)
                this.atInventoryInterfaceType = 1;
            if (Widget.interfaceCache[k].parentID == backDialogID)
                this.atInventoryInterfaceType = 3;
        }
        if (l == 539) {
            stream.createFrame(16);
            stream.method432(i1);
            stream.method433(j);
            stream.method433(k);
            this.atInventoryLoopCycle = 0;
            this.atInventoryInterface = k;
            this.atInventoryIndex = j;
            this.atInventoryInterfaceType = 2;
            if (Widget.interfaceCache[k].parentID == openInterfaceID)
                this.atInventoryInterfaceType = 1;
            if (Widget.interfaceCache[k].parentID == backDialogID)
                this.atInventoryInterfaceType = 3;

        }

        String var17;
        if (l == 484 || l == 6) {
            var16 = this.menuActionName[i];
            var15 = var16.indexOf("@whi@");
            if (var15 != -1) {
                var16 = var16.substring(var15 + 5).trim();
                var17 = TextClass.fixName(TextClass.nameForLong(TextClass.longForName(var16)));
                boolean var231 = false;

                for (k3 = 0; k3 < this.playerCount; ++k3) {
                    Player var24 = this.playerArray[this.playerIndices[k3]];
                    if (var24 != null && var24.name != null && var24.name.equalsIgnoreCase(var17)) {
                        this.doWalkTo(2, 0, 1, 0, myPlayer.smallY[0], 1, 0, var24.smallY[0],
                                myPlayer.smallX[0], false, var24.smallX[0]);
                        if (l == 484) {
                            stream.createFrame(139);
                            stream.method431(this.playerIndices[k3]);
                        }

                        if (l == 6) {
                            anInt1188 += i1;
                            if (anInt1188 >= 90) {
                                stream.createFrame(136);
                                anInt1188 = 0;
                            }

                            stream.createFrame(128);
                            stream.method399(this.playerIndices[k3]);
                        }

                        var231 = true;
                        break;
                    }
                }

                if (!var231) {
                    this.pushMessage("Unable to find " + var17, 0, "");
                }
            }
        }

        if (l == 870) {
            stream.createFrame(53);
            stream.method399(j);
            stream.method432(this.anInt1283);
            stream.method433(i1);
            stream.method399(this.anInt1284);
            stream.method431(this.anInt1285);
            stream.method399(k);
            this.atInventoryLoopCycle = 0;
            this.atInventoryInterface = k;
            this.atInventoryIndex = j;
            this.atInventoryInterfaceType = 2;
            if (Widget.interfaceCache[k].parentID == openInterfaceID) {
                this.atInventoryInterfaceType = 1;
            }

            if (Widget.interfaceCache[k].parentID == backDialogID) {
                this.atInventoryInterfaceType = 3;
            }
        }

        if (l == 847) {
            stream.createFrame(87);
            stream.method432(i1);
            stream.method399(k);
            stream.method432(j);
            this.atInventoryLoopCycle = 0;
            this.atInventoryInterface = k;
            this.atInventoryIndex = j;
            this.atInventoryInterfaceType = 2;
            if (Widget.interfaceCache[k].parentID == openInterfaceID) {
                this.atInventoryInterfaceType = 1;
            }

            if (Widget.interfaceCache[k].parentID == backDialogID) {
                this.atInventoryInterfaceType = 3;
            }
        }

        String var241;
        if (l == 626) {
            widget = Widget.interfaceCache[k];
            this.spellSelected = 1;
            this.spellID = k;
            this.anInt1138 = widget.spellUsableOn;
            this.itemSelected = 0;
            needDrawTabArea = true;
            var241 = widget.selectedActionName;
            if (var241.indexOf(" ") != -1) {
                var241 = var241.substring(0, var241.indexOf(" "));
            }

            var17 = widget.selectedActionName;
            if (var17.indexOf(" ") != -1) {
                var17 = var17.substring(var17.indexOf(" ") + 1);
            }

            this.aString1139 = var241 + " " + widget.spellName + " " + var17;
            if (this.anInt1138 == 16) {
                needDrawTabArea = true;
                tabID = 3;
                tabAreaAltered = true;
            }
        } else {
            if (l == 78) {
                stream.createFrame(117);
                stream.method433(k);
                stream.method433(i1);
                stream.method431(j);
                this.atInventoryLoopCycle = 0;
                this.atInventoryInterface = k;
                this.atInventoryIndex = j;
                this.atInventoryInterfaceType = 2;
                if (Widget.interfaceCache[k].parentID == openInterfaceID) {
                    this.atInventoryInterfaceType = 1;
                }

                if (Widget.interfaceCache[k].parentID == backDialogID) {
                    this.atInventoryInterfaceType = 3;
                }
            }

            if (l == 27) {
                var23 = this.playerArray[i1];
                if (var23 != null) {
                    this.doWalkTo(2, 0, 1, 0, myPlayer.smallY[0], 1, 0, var23.smallY[0], myPlayer.smallX[0],
                            false, var23.smallX[0]);
                    this.anInt914 = super.saveClickX;
                    this.anInt915 = super.saveClickY;
                    this.crossType = 2;
                    this.crossIndex = 0;
                    targetindex = i1;
                    targetedplayer = true;
                    anInt986 += i1;
                    if (anInt986 >= 54) {
                        stream.createFrame(189);
                        stream.writeByte(234);
                        anInt986 = 0;
                    }

                    stream.createFrame(73);
                    stream.method431(i1);
                }
            }

            if (l == 213) {
                var12 = this.doWalkTo(2, 0, 0, 0, myPlayer.smallY[0], 0, 0, k, myPlayer.smallX[0], false,
                        j);
                if (!var12) {
                    this.doWalkTo(2, 0, 1, 0, myPlayer.smallY[0], 1, 0, k, myPlayer.smallX[0], false, j);
                }

                this.anInt914 = super.saveClickX;
                this.anInt915 = super.saveClickY;
                this.crossType = 2;
                this.crossIndex = 0;
                stream.createFrame(79);
                stream.method431(k + this.baseY);
                stream.method399(i1);
                stream.method432(j + this.baseX);
            }

            if (l == 632) {
                stream.createFrame(145);
                stream.method432(k);
                stream.method432(j);
                stream.method432(i1);
                this.atInventoryLoopCycle = 0;
                this.atInventoryInterface = k;
                this.atInventoryIndex = j;
                this.atInventoryInterfaceType = 2;
                if (Widget.interfaceCache[k].parentID == openInterfaceID) {
                    this.atInventoryInterfaceType = 1;
                }

                if (Widget.interfaceCache[k].parentID == backDialogID) {
                    this.atInventoryInterfaceType = 3;
                }
            }
            if (l == 661) { // intid, slot, itemid;
                stream.createFrame(232);
                stream.method432(1);
                stream.method432(i1);
            }
            if (l == 662) {
                stream.createFrame(232);
                stream.method432(2);
                stream.method432(i1);
            }
            if (l == 663) {
                stream.createFrame(232);
                stream.method432(3);
                stream.method432(i1);
            }
            if (l == 664) {
                stream.createFrame(232);
                stream.method432(4);
                stream.method432(i1);
            }
            switch (l) {
                case 1500: //Toggle quick prayers
                    prayClicked = !prayClicked;
                    stream.createFrame(185);
                    stream.writeWord(5000);
                    break;

                case 1506: //Select quick prayers
                    stream.createFrame(185);
                    stream.writeWord(5001);
                    setTab(5);
                    break;
            }
            int var25;
            if (l == 258) {
                expDrops = !expDrops;
                // savePlayerData();
            } else if (l == 257) {
                skillOrbs = !skillOrbs;
                // savePlayerData();
            }
            if (l == 1050) {
                var25 = Integer.parseInt(Widget.interfaceCache[4016].message);
                if (var25 > 0) {
                    this.runClicked = !this.runClicked;
                    this.sendFrame36(429, this.runClicked ? 1 : 0);
                    stream.createFrame(185);
                    stream.writeWord(152);
                }
            }

            if (this.menuActionName[i].contains("Toggle Run")) {
                var25 = Integer.parseInt(Widget.interfaceCache[4016].message);
                if (var25 > 0) {
                    this.runClicked = !this.runClicked;
                    this.sendFrame36(429, this.runClicked ? 1 : 0);
                }
            }

            if (l == 493) {
                stream.createFrame(75);
                stream.method433(k);
                stream.method431(j);
                stream.method432(i1);
                this.atInventoryLoopCycle = 0;
                this.atInventoryInterface = k;
                this.atInventoryIndex = j;
                this.atInventoryInterfaceType = 2;
                if (Widget.interfaceCache[k].parentID == openInterfaceID) {
                    this.atInventoryInterfaceType = 1;
                }

                if (Widget.interfaceCache[k].parentID == backDialogID) {
                    this.atInventoryInterfaceType = 3;
                }
            }

            if (l == 652) {
                var12 = this.doWalkTo(2, 0, 0, 0, myPlayer.smallY[0], 0, 0, k, myPlayer.smallX[0], false,
                        j);
                if (!var12) {
                    this.doWalkTo(2, 0, 1, 0, myPlayer.smallY[0], 1, 0, k, myPlayer.smallX[0], false, j);
                }

                this.anInt914 = super.saveClickX;
                this.anInt915 = super.saveClickY;
                this.crossType = 2;
                this.crossIndex = 0;
                stream.createFrame(156);
                stream.method432(j + this.baseX);
                stream.method431(k + this.baseY);
                stream.method433(i1);
            }

            if (l == 94) {
                var12 = this.doWalkTo(2, 0, 0, 0, myPlayer.smallY[0], 0, 0, k, myPlayer.smallX[0], false,
                        j);
                if (!var12) {
                    this.doWalkTo(2, 0, 1, 0, myPlayer.smallY[0], 1, 0, k, myPlayer.smallX[0], false, j);
                }

                this.anInt914 = super.saveClickX;
                this.anInt915 = super.saveClickY;
                this.crossType = 2;
                this.crossIndex = 0;
                stream.createFrame(181);
                stream.writeLEShort(k + baseY);
                stream.writeWord(i1);
                stream.writeLEShort(j + baseX);
                stream.method432(spellID);
            }
            if (l == 647) {
                stream.createFrame(213);
                stream.writeWord(k);
                stream.writeWord(j);

                switch (k) {

                    case 18304:
                        if (j == 0) {
                            inputTaken = true;
                            inputDialogState = 0;
                            messagePromptRaised = true;
                            promptInput = "";
                            friendsListAction = 8;
                            aString1121 = "Enter your clan chat title";
                        }
                        break;

                    case 18144:
                    case 18145:
                    case 18146:
                    case 18147:
                    case 18148:
                    case 18149:
                    case 18150:
                    case 18151:
                    case 18152:
                    case 18153:
                    case 18154:
                    case 18155:
                    case 18156:
                    case 18157:
                    case 18158:
                    case 18159:
                    case 18160:
                    case 18161:
                    case 18162:
                    case 18163:
                    case 18164:
                    case 18165:
                    case 18166:
                    case 18167:
                    case 18168:
                    case 18169:
                    case 18170:
                    case 18171:
                    case 18172:
                    case 18173:
                    case 18174:
                    case 18175:
                    case 18176:
                    case 18177:
                    case 18178:
                    case 18179:
                    case 18180:
                    case 18181:
                    case 18182:
                    case 18183:
                    case 18184:
                    case 18185:
                    case 18186:
                    case 18187:
                    case 18188:
                    case 18189:
                    case 18190:
                    case 18191:
                    case 18192:
                    case 18193:
                    case 18194:
                    case 18195:
                    case 18196:
                    case 18197:
                    case 18198:
                    case 18199:
                    case 18200:
                    case 18201:
                    case 18202:
                    case 18203:
                    case 18204:
                    case 18205:
                    case 18206:
                    case 18207:
                    case 18208:
                    case 18209:
                    case 18210:
                    case 18211:
                    case 18212:
                    case 18213:
                    case 18214:
                    case 18215:
                    case 18216:
                    case 18217:
                    case 18218:
                    case 18219:
                    case 18220:
                    case 18221:
                    case 18222:
                    case 18223:
                    case 18224:
                    case 18225:
                    case 18226:
                    case 18227:
                    case 18228:
                    case 18229:
                    case 18230:
                    case 18231:
                    case 18232:
                    case 18233:
                    case 18234:
                    case 18235:
                    case 18236:
                    case 18237:
                    case 18238:
                    case 18239:
                    case 18240:
                    case 18241:
                    case 18243:
                        String s = menuActionName[i];
                        int k1 = s.indexOf("@whi@Clan 1");
                        int k2 = s.indexOf("@whi@Clan 1");
                        if (k1 != -1 || k1 != 0) {
                            long l3 = TextClass.longForName(s.substring(k1 + 14).trim());
                            if (j == 3)
                                method41((byte) 68, l3);
                        }
                        if (k2 != -1 || k2 != 0) {
                            long l4 = TextClass.longForName(s.substring(k2 + 16).trim());
                            if (j == 4)
                                method113(l4, 4);
                        }
                        break;
                }
                stream.createFrame(213);
                stream.writeWord(k);
                stream.writeWord(j);
            }
            if (l == 646) {
                stream.createFrame(185);
                stream.writeWord(k);
                Widget var131 = Widget.interfaceCache[k];
                if (var131.valueIndexArray != null && var131.valueIndexArray[0][0] == 5) {
                    var15 = var131.valueIndexArray[0][1];
                    if (this.settings[var15] != var131.anIntArray212[0]) {
                        this.settings[var15] = var131.anIntArray212[0];
                        this.method33(var15);
                        needDrawTabArea = true;
                    }
                    System.out.println(
                            var131.id + ", " + var15 + ", " + settings[var15] + ", " + var131.anIntArray212[0]);
                }
                switch (k) {
                    // clan chat
                    case 18129:
                        if (Widget.interfaceCache[18135].message.toLowerCase().contains("join")) {
                            inputTaken = true;
                            inputDialogState = 0;
                            messagePromptRaised = true;
                            promptInput = "";
                            friendsListAction = 6;
                            aString1121 = "Enter the name of the chat you wish to join";
                        } else {
                            sendString(0, "");
                        }
                        break;
                    case 18132:
                        openInterfaceID = 18300;
                        break;
                    case 18526:
                        inputTaken = true;
                        inputDialogState = 0;
                        messagePromptRaised = true;
                        promptInput = "";
                        friendsListAction = 9;
                        aString1121 = "Enter a name to add";
                        break;
                    case 18527:
                        inputTaken = true;
                        inputDialogState = 0;
                        messagePromptRaised = true;
                        promptInput = "";
                        friendsListAction = 10;
                        aString1121 = "Enter a name to add";
                        break;
                }
            }

            if (l == 225) {
                class8_1 = this.npcArray[i1];
                if (class8_1 != null) {
                    this.doWalkTo(2, 0, 1, 0, myPlayer.smallY[0], 1, 0, class8_1.smallY[0],
                            myPlayer.smallX[0], false, class8_1.smallX[0]);
                    this.anInt914 = super.saveClickX;
                    this.anInt915 = super.saveClickY;
                    this.crossType = 2;
                    this.crossIndex = 0;
                    anInt1226 += i1;
                    System.out.println(i1);
                    if (anInt1226 >= 85) {
                        stream.createFrame(230);
                        stream.writeByte(239);
                        anInt1226 = 0;
                    }

                    stream.createFrame(17);
                    stream.method433(i1);
                }
            }

            if (l == 965) {
                class8_1 = this.npcArray[i1];
                if (class8_1 != null) {
                    this.doWalkTo(2, 0, 1, 0, myPlayer.smallY[0], 1, 0, class8_1.smallY[0],
                            myPlayer.smallX[0], false, class8_1.smallX[0]);
                    this.anInt914 = super.saveClickX;
                    this.anInt915 = super.saveClickY;
                    this.crossType = 2;
                    this.crossIndex = 0;
                    ++anInt1134;
                    if (anInt1134 >= 96) {
                        stream.createFrame(152);
                        stream.writeByte(88);
                        anInt1134 = 0;
                    }

                    stream.createFrame(21);
                    stream.method399(i1);
                }
            }

            if (l == 413) {
                class8_1 = this.npcArray[i1];
                if (class8_1 != null) {
                    this.doWalkTo(2, 0, 1, 0, myPlayer.smallY[0], 1, 0, class8_1.smallY[0],
                            myPlayer.smallX[0], false, class8_1.smallX[0]);
                    this.anInt914 = super.saveClickX;
                    this.anInt915 = super.saveClickY;
                    this.crossType = 2;
                    this.crossIndex = 0;
                    targetindex = i1;
                    targetedplayer = false;
                    stream.createFrame(131);
                    stream.method433(i1);
                    stream.method432(this.spellID);
                }
            }

            if (l == 200) {
                this.clearTopInterfaces();
            }

            if (l == 201) {
                for (int index = 0; index < GrandExchange.grandExchangeItemBoxIds.length; index++)
                    if (k == GrandExchange.grandExchangeItemBoxIds[index] + 1)
                        openInterfaceID = GrandExchange.grandExchangeOfferStatusInterfaceIds[index];

                switch (k) {

                    case 25705:
                    case 25557:
                        openInterfaceID = 25000;
                        break;

                }
            }
            if (l == 1025) {
                class8_1 = this.npcArray[i1];
                if (class8_1 != null) {
                    NpcDefinition var27 = class8_1.desc;
                    if (var27.morphisms != null) {
                        var27 = var27.method161();
                    }

                    if (var27 != null) {
                        if (var27.description != null) {
                            var17 = new String(var27.description);
                        } else {
                            var17 = "It\'s a " + var27.name + ".";
                        }

                        this.pushMessage(var17, 0, "");
                    }
                }
            }

            if (l == 900) {
                this.method66(i1, y, x, id);
                stream.createFrame(252);
                stream.method433(id);
                stream.method431(y + this.baseY);
                stream.method432(x + this.baseX);
            }

            if (l == 412) {
                class8_1 = this.npcArray[i1];
                if (class8_1 != null) {
                    this.doWalkTo(2, 0, 1, 0, myPlayer.smallY[0], 1, 0, class8_1.smallY[0],
                            myPlayer.smallX[0], false, class8_1.smallX[0]);
                    this.anInt914 = super.saveClickX;
                    this.anInt915 = super.saveClickY;
                    this.crossType = 2;
                    this.crossIndex = 0;
                    targetindex = i1;
                    targetedplayer = false;
                    stream.createFrame(72);
                    stream.method432(i1);
                }
            }

            if (l == 365) {
                var23 = this.playerArray[i1];
                if (var23 != null) {
                    this.doWalkTo(2, 0, 1, 0, myPlayer.smallY[0], 1, 0, var23.smallY[0], myPlayer.smallX[0],
                            false, var23.smallX[0]);
                    this.anInt914 = super.saveClickX;
                    this.anInt915 = super.saveClickY;
                    this.crossType = 2;
                    this.crossIndex = 0;
                    targetindex = i1;
                    targetedplayer = true;
                    stream.createFrame(249);
                    stream.method432(i1);
                    stream.method431(this.spellID);
                }
            }

            if (l == 729) {
                var23 = this.playerArray[i1];
                if (var23 != null) {
                    this.doWalkTo(2, 0, 1, 0, myPlayer.smallY[0], 1, 0, var23.smallY[0], myPlayer.smallX[0],
                            false, var23.smallX[0]);
                    this.anInt914 = super.saveClickX;
                    this.anInt915 = super.saveClickY;
                    this.crossType = 2;
                    this.crossIndex = 0;
                    stream.createFrame(39);
                    stream.method431(i1);
                }
            }

            if (l == 577) {
                var23 = this.playerArray[i1];
                if (var23 != null) {
                    this.doWalkTo(2, 0, 1, 0, myPlayer.smallY[0], 1, 0, var23.smallY[0], myPlayer.smallX[0],
                            false, var23.smallX[0]);
                    this.anInt914 = super.saveClickX;
                    this.anInt915 = super.saveClickY;
                    this.crossType = 2;
                    this.crossIndex = 0;
                    stream.createFrame(139);
                    stream.method431(i1);
                }
            }

            if (l == 956 && this.method66(i1, y, x, id)) {
                stream.createFrame(35);
                stream.method431(x + this.baseX);
                stream.method432(this.spellID);
                stream.method432(y + this.baseY);
                stream.method431(id);
            }

            if (l == 567) {
                var12 = this.doWalkTo(2, 0, 0, 0, myPlayer.smallY[0], 0, 0, k, myPlayer.smallX[0], false,
                        j);
                if (!var12) {
                    this.doWalkTo(2, 0, 1, 0, myPlayer.smallY[0], 1, 0, k, myPlayer.smallX[0], false, j);
                }

                this.anInt914 = super.saveClickX;
                this.anInt915 = super.saveClickY;
                this.crossType = 2;
                this.crossIndex = 0;
                stream.createFrame(23);
                stream.method431(k + this.baseY);
                stream.method431(i1);
                stream.method431(j + this.baseX);
            }

            if (l == 867) {
                if ((i1 & 3) == 0) {
                    ++anInt1175;
                }

                if (anInt1175 >= 59) {
                    stream.createFrame(200);
                    stream.method399(25501);
                    anInt1175 = 0;
                }

                stream.createFrame(43);
                stream.method431(k);
                stream.method432(i1);
                stream.method432(j);
                this.atInventoryLoopCycle = 0;
                this.atInventoryInterface = k;
                this.atInventoryIndex = j;
                this.atInventoryInterfaceType = 2;
                if (Widget.interfaceCache[k].parentID == openInterfaceID) {
                    this.atInventoryInterfaceType = 1;
                }

                if (Widget.interfaceCache[k].parentID == backDialogID) {
                    this.atInventoryInterfaceType = 3;
                }
            }

            if (l == 543) {
                stream.createFrame(237);
                stream.method399(j);
                stream.method432(i1);
                stream.method399(k);
                stream.method432(this.spellID);
                this.atInventoryLoopCycle = 0;
                this.atInventoryInterface = k;
                this.atInventoryIndex = j;
                this.atInventoryInterfaceType = 2;
                if (Widget.interfaceCache[k].parentID == openInterfaceID) {
                    this.atInventoryInterfaceType = 1;
                }

                if (Widget.interfaceCache[k].parentID == backDialogID) {
                    this.atInventoryInterfaceType = 3;
                }
            }

            if (l == 606) {
                var16 = this.menuActionName[i];
                var15 = var16.indexOf("@whi@");
                if (var15 != -1) {
                    if (openInterfaceID == -1) {
                        this.clearTopInterfaces();
                        this.reportAbuseInput = var16.substring(var15 + 5).trim();
                        this.canMute = false;

                        for (var25 = 0; var25 < Widget.interfaceCache.length; ++var25) {
                            if (Widget.interfaceCache[var25] != null
                                    && Widget.interfaceCache[var25].contentType == 600) {
                                this.reportAbuseInterfaceID = openInterfaceID = Widget.interfaceCache[var25].parentID;
                                break;
                            }
                        }
                    } else {
                        this.pushMessage("Please close the interface you have open before using \'report abuse\'",
                                0, "");
                    }
                }
            }

            if (l == 491) {
                var23 = this.playerArray[i1];
                if (var23 != null) {
                    this.doWalkTo(2, 0, 1, 0, myPlayer.smallY[0], 1, 0, var23.smallY[0], myPlayer.smallX[0],
                            false, var23.smallX[0]);
                    this.anInt914 = super.saveClickX;
                    this.anInt915 = super.saveClickY;
                    this.crossType = 2;
                    this.crossIndex = 0;
                    stream.createFrame(14);
                    stream.method432(this.anInt1284);
                    stream.method399(i1);
                    stream.method399(this.anInt1285);
                    stream.method431(this.anInt1283);
                }
            }

            if (l == 639) {
                var16 = this.menuActionName[i];
                var15 = var16.indexOf("@whi@");
                if (var15 != -1) {
                    s10 = TextClass.longForName(var16.substring(var15 + 5).trim());
                    k3 = -1;

                    for (i4 = 0; i4 < this.friendsCount; ++i4) {
                        if (this.friendsListAsLongs[i4] == s10) {
                            k3 = i4;
                            break;
                        }
                    }

                    if (k3 != -1 && this.friendsNodeIDs[k3] > 0) {
                        inputTaken = true;
                        inputDialogState = 0;
                        this.messagePromptRaised = true;
                        this.promptInput = "";
                        this.friendsListAction = 3;
                        this.aLong953 = this.friendsListAsLongs[k3];
                        this.aString1121 = "Enter message to send to " + this.friendsList[k3];
                    }
                }
            }

            if (l == 454) {
                stream.createFrame(41);
                stream.method399(i1);
                stream.method432(j);
                stream.method432(k);
                this.atInventoryLoopCycle = 0;
                this.atInventoryInterface = k;
                this.atInventoryIndex = j;
                this.atInventoryInterfaceType = 2;
                if (Widget.interfaceCache[k].parentID == openInterfaceID) {
                    this.atInventoryInterfaceType = 1;
                }

                if (Widget.interfaceCache[k].parentID == backDialogID) {
                    this.atInventoryInterfaceType = 3;
                }
            }

            if (l == 478) {
                class8_1 = this.npcArray[i1];
                if (class8_1 != null) {
                    this.doWalkTo(2, 0, 1, 0, myPlayer.smallY[0], 1, 0, class8_1.smallY[0],
                            myPlayer.smallX[0], false, class8_1.smallX[0]);
                    this.anInt914 = super.saveClickX;
                    this.anInt915 = super.saveClickY;
                    this.crossType = 2;
                    this.crossIndex = 0;
                    if ((i1 & 3) == 0)
                        ++anInt1155;
                    if (anInt1155 >= 53) {
                        stream.createFrame(85);
                        stream.writeWordBigEndian(66);
                        anInt1155 = 0;
                    }
                    stream.createFrame(18);
                    stream.method431(i1);
                }
            }

            if (l == 113) {//3rd click
                this.method66(i1, y, x, id);
                stream.createFrame(70);
                stream.method431(x + baseX);
                stream.writeWord(y + baseY);
                stream.method433(id);
            }

            if (l == 872) {//4th click
                this.method66(i1, y, x, id);
                stream.createFrame(234);
                stream.method433(x + this.baseX);
                stream.method432(id);
                stream.method433(y + this.baseY);
            }

            if (l == 502) {//first click object
                this.method66(i1, y, x, id);
                stream.createFrame(132);
                stream.method433(x + this.baseX);
                stream.writeWord(id);
                //System.out.print("x"+x+"y"+y);
                stream.method432(y + this.baseY);
            }

            ItemDefinition var26;
            if (l == 1125) {
                var26 = ItemDefinition.lookup(i1);
                Widget var261 = Widget.interfaceCache[k];
                if (var261 != null && var261.inventoryAmounts[j] >= 100000) {
                    var17 = formatNumber((double) var261.inventoryAmounts[j]) + " x " + var26.name;
                } else if (var26.description != null) {
                    var17 = var26.description.replaceAll("RuneScape", "Ghreborn");
                } else {
                    var17 = "It\'s a " + var26.name + ".";
                }

                this.pushMessage(var17, 0, "");
            }
            if (l == 1130) {
                Widget class9_4 = Widget.interfaceCache[k];
                if (class9_4 != null) {
                    class9_4.itemSearchSelectedId = class9_4.inventoryItemId[j];
                    class9_4.itemSearchSelectedSlot = j;
                    Widget.selectedItemInterfaceId = class9_4.id;
                }
            }
            if (l == 169) {
                stream.createFrame(185);
                stream.method399(k);
                widget = Widget.interfaceCache[k];
                if (widget.valueIndexArray != null && widget.valueIndexArray[0][0] == 5) {
                    var15 = widget.valueIndexArray[0][1];
                    this.settings[var15] = 1 - this.settings[var15];
                    this.method33(var15);
                    needDrawTabArea = true;
                    System.out.println("" + k);
                    switch (k) {
                        case 31024:
                            if (currentScreenMode != ScreenMode.FIXED) {
                                currentScreenMode(ScreenMode.FIXED);
                            }
                            break;
                        case 31028:
                            if (currentScreenMode != ScreenMode.RESIZABLE) {
                                currentScreenMode(ScreenMode.RESIZABLE);
                            }
                            break;

                    }
                }
            }

            if (l == 447) {
                this.itemSelected = 1;
                this.anInt1283 = j;
                this.anInt1284 = k;
                this.anInt1285 = i1;
                this.aString1286 = ItemDefinition.lookup(i1).name;
                this.spellSelected = 0;
                needDrawTabArea = true;
            } else {
                if (l == 1226) {
                    ObjectDefinition var22 = ObjectDefinition.forID(id);
                    String examine;
                    if (var22.description != null) {
                        examine = new String(var22.description);
                        examine += ".  (id: " + id + ")";
                    } else {
                        examine = "It's a " + var22.name + ".";
                        if (myPrivilege == 2 || myPrivilege == 9 || myPrivilege == 10 || myPrivilege == 4) {
                            String objectCoords = "" + (j + baseX) + ", " + (k + baseY) + "";
                            StringSelection stringSelection = new StringSelection(objectCoords);
                            Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                            clpbrd.setContents(stringSelection, null);
                        }
                    }
                    this.pushMessage(examine, 0, "");
                }

                if (l == 244) {
                    var12 = this.doWalkTo(2, 0, 0, 0, myPlayer.smallY[0], 0, 0, k, myPlayer.smallX[0],
                            false, j);
                    if (!var12) {
                        this.doWalkTo(2, 0, 1, 0, myPlayer.smallY[0], 1, 0, k, myPlayer.smallX[0], false,
                                j);
                    }

                    this.anInt914 = super.saveClickX;
                    this.anInt915 = super.saveClickY;
                    this.crossType = 2;
                    this.crossIndex = 0;
                    stream.createFrame(253);
                    stream.method431(j + this.baseX);
                    stream.method433(k + this.baseY);
                    stream.method432(i1);
                }

                if (l == 1448) {
                    var26 = ItemDefinition.lookup(i1);
                    if (var26.description != null) {
                        var241 = var26.description;
                    } else {
                        var241 = "It\'s a " + var26.name + ".";
                    }

                    this.pushMessage(var241, 0, "");
                }

                this.spellSelected = 0;
                this.itemSelected = 0;
                needDrawTabArea = true;
            }
        }
    }

    public void sendFrame36(int id, int state) {
        this.anIntArray1045[id] = state;
        if (this.settings[id] != state) {
            this.settings[id] = state;
            this.method33(id);
            if (this.dialogID != -1) {
                inputTaken = true;
            }
        }

    }

    public final void method70() {
        this.anInt1251 = 0;
        int j = (myPlayer.x >> 7) + this.baseX;
        int k = (myPlayer.y >> 7) + this.baseY;
        if (j >= 3053 && j <= 3156 && k >= 3056 && k <= 3136) {
            this.anInt1251 = 1;
        }

        if (j >= 3072 && j <= 3118 && k >= 9492 && k <= 9535) {
            this.anInt1251 = 1;
        }

        if (this.anInt1251 == 1 && j >= 3139 && j <= 3199 && k >= 3008 && k <= 3062) {
            this.anInt1251 = 0;
        }

    }

    public final void run() {
        if (this.aBoolean880) {
            this.method136((byte) 59);
        } else {
            super.run();
        }

    }

    public final void build3dScreenMenu() {
        if (this.itemSelected == 0 && this.spellSelected == 0) {
            this.menuActionName[this.menuActionRow] = "Walk Here";
            this.menuActionID[this.menuActionRow] = 516;
            this.menuActionCmd2[this.menuActionRow] = super.mouseX;
            this.menuActionCmd3[this.menuActionRow] = super.mouseY;
            ++this.menuActionRow;
        }

        int j = -1;

        for (int k = 0; k < Model.anInt1687; ++k) {
            int l = Model.anIntArray1688[k];
            int i1 = l & 127;//x
            int j1 = l >> 7 & 127;//y
            int k1 = l >> 29 & 3;//face
            int l1 = -1;//objId
            if (k1 != 2)
                l1 = l >> 14 & 0x7fff;
            if (l == j)
                continue;
            j = l;
            int class30_sub2_sub4_sub2;
            if (k1 == 2 && this.worldController.method304(this.plane, i1, j1, l) >= 0) {
                l1 = Model.mapObjIds[k];
                ObjectDefinition var15 = ObjectDefinition.forID(l1);
                if (var15.morphisms != null) {
                    var15 = var15.morph();
                }

                if (var15 == null) {
                    continue;
                }

                if (this.itemSelected == 1) {
                    this.menuActionName[this.menuActionRow] = "Use " + this.aString1286 + " with <col=65535>"
                            + var15.name;
                    this.menuActionID[this.menuActionRow] = 62;
                    this.menuActionCmd1[this.menuActionRow] = l;
                    this.menuActionCmd2[this.menuActionRow] = i1;
                    this.menuActionCmd3[this.menuActionRow] = j1;
                    menuActionCmd4[menuActionRow] = l1;
                    ++this.menuActionRow;
                } else if (this.spellSelected == 1) {
                    if ((this.anInt1138 & 4) == 4) {
                        this.menuActionName[this.menuActionRow] = this.aString1139 + " <col=65535>" + var15.name;
                        this.menuActionID[this.menuActionRow] = 956;
                        this.menuActionCmd1[this.menuActionRow] = l;
                        this.menuActionCmd2[this.menuActionRow] = i1;
                        this.menuActionCmd3[this.menuActionRow] = j1;
                        menuActionCmd4[menuActionRow] = l1;
                        ++this.menuActionRow;
                    }
                } else {
                    if (var15.actions != null) {
                        for (class30_sub2_sub4_sub2 = 4; class30_sub2_sub4_sub2 >= 0; --class30_sub2_sub4_sub2) {
                            if (var15.actions[class30_sub2_sub4_sub2] != null) {
                                this.menuActionName[this.menuActionRow] = var15.actions[class30_sub2_sub4_sub2]
                                        + " <col=65535>" + var15.name;
                                if (class30_sub2_sub4_sub2 == 0) {
                                    this.menuActionID[this.menuActionRow] = 502;
                                }

                                if (class30_sub2_sub4_sub2 == 1) {
                                    this.menuActionID[this.menuActionRow] = 900;
                                }

                                if (class30_sub2_sub4_sub2 == 2) {
                                    this.menuActionID[this.menuActionRow] = 113;
                                }

                                if (class30_sub2_sub4_sub2 == 3) {
                                    this.menuActionID[this.menuActionRow] = 872;
                                }

                                if (class30_sub2_sub4_sub2 == 4) {
                                    this.menuActionID[this.menuActionRow] = 1062;
                                }

                                this.menuActionCmd1[this.menuActionRow] = l;
                                this.menuActionCmd2[this.menuActionRow] = i1;
                                this.menuActionCmd3[this.menuActionRow] = j1;
                                menuActionCmd4[menuActionRow] = l1;
                                ++this.menuActionRow;
                            }
                        }
                    }

                    if (this.myPrivilege == 2 || this.myPrivilege == 10 || this.myPrivilege == 9
                            || this.myPrivilege == 4) {
                        this.menuActionName[this.menuActionRow] = "Examine <col=65535>" + var15.name
                                + "<col=255>(@whi@" + var15.type + "<col=255>)";
                    } else {
                        this.menuActionName[this.menuActionRow] = "Examine <col=65535>" + var15.name + ".";
                    }

                    this.menuActionID[this.menuActionRow] = 1226;
                    this.menuActionCmd1[this.menuActionRow] = var15.type << 14;
                    this.menuActionCmd2[this.menuActionRow] = i1;
                    this.menuActionCmd3[this.menuActionRow] = j1;
                    menuActionCmd4[menuActionRow] = l1;
                    ++this.menuActionRow;
                }

            }

            Player var15;
            Npc var151;
            if (k1 == 1) {
                Npc var14 = this.npcArray[l1];
                if (var14.desc.spaceOccupied == 1 && (var14.x & 127) == 64 && (var14.y & 127) == 64) {
                    for (class30_sub2_sub4_sub2 = 0; class30_sub2_sub4_sub2 < this.npcCount; ++class30_sub2_sub4_sub2) {
                        var151 = this.npcArray[this.npcIndices[class30_sub2_sub4_sub2]];
                        if (var151 != null && var151 != var14 && var151.desc.spaceOccupied == 1
                                && var151.x == var14.x && var151.y == var14.y) {
                            this.buildAtNPCMenu(var151.desc, this.npcIndices[class30_sub2_sub4_sub2], j1,
                                    i1);
                        }
                    }

                    for (class30_sub2_sub4_sub2 = 0; class30_sub2_sub4_sub2 < this.playerCount; ++class30_sub2_sub4_sub2) {
                        var15 = this.playerArray[this.playerIndices[class30_sub2_sub4_sub2]];
                        if (var15 != null && var15.x == var14.x && var15.y == var14.y) {
                            this.method88(i1, this.playerIndices[class30_sub2_sub4_sub2], var15, false, j1);
                        }
                    }
                }

                this.buildAtNPCMenu(var14.desc, l1, j1, i1);
            }

            if (k1 == 0) {
                Player var13 = this.playerArray[l1];
                if ((var13.x & 127) == 64 && (var13.y & 127) == 64) {
                    for (class30_sub2_sub4_sub2 = 0; class30_sub2_sub4_sub2 < this.npcCount; ++class30_sub2_sub4_sub2) {
                        var151 = this.npcArray[this.npcIndices[class30_sub2_sub4_sub2]];
                        if (var151 != null && var151.desc.spaceOccupied == 1 && var151.x == var13.x
                                && var151.y == var13.y) {
                            this.buildAtNPCMenu(var151.desc, this.npcIndices[class30_sub2_sub4_sub2], j1,
                                    i1);
                        }
                    }

                    for (class30_sub2_sub4_sub2 = 0; class30_sub2_sub4_sub2 < this.playerCount; ++class30_sub2_sub4_sub2) {
                        var15 = this.playerArray[this.playerIndices[class30_sub2_sub4_sub2]];
                        if (var15 != null && var15 != var13 && var15.x == var13.x && var15.y == var13.y) {
                            this.method88(i1, this.playerIndices[class30_sub2_sub4_sub2], var15, false, j1);
                        }
                    }
                }

                this.method88(i1, l1, var13, false, j1);
            }

            if (k1 == 3) {
                NodeList var171 = this.aClass19ArrayArrayArray827[this.plane][i1][j1];
                if (var171 != null) {
                    for (Item var17 = (Item) var171.method253(5); var17 != null; var17 = (Item) var171
                            .method255(8)) {
                        ItemDefinition var16 = ItemDefinition.lookup(var17.anInt1558);
                        if (this.itemSelected == 1) {
                            this.menuActionName[this.menuActionRow] = "Use " + this.aString1286 + " with <col=ff9040>"
                                    + var16.name;
                            this.menuActionID[this.menuActionRow] = 511;
                            this.menuActionCmd1[this.menuActionRow] = var17.anInt1558;
                            this.menuActionCmd2[this.menuActionRow] = i1;
                            this.menuActionCmd3[this.menuActionRow] = j1;
                            ++this.menuActionRow;
                        } else if (this.spellSelected == 1) {
                            if ((this.anInt1138 & 1) == 1) {
                                this.menuActionName[this.menuActionRow] = this.aString1139 + " <col=ff9040>"
                                        + var16.name;
                                this.menuActionID[this.menuActionRow] = 94;
                                this.menuActionCmd1[this.menuActionRow] = var17.anInt1558;
                                this.menuActionCmd2[this.menuActionRow] = i1;
                                this.menuActionCmd3[this.menuActionRow] = j1;
                                ++this.menuActionRow;
                            }
                        } else {
                            for (int j3 = 4; j3 >= 0; --j3) {
                                if (var16.groundActions != null && var16.groundActions[j3] != null) {
                                    menuActionName[menuActionRow] = var16.groundActions[j3] + " <col=ff9040>"
                                            + var16.name;
                                    if (j3 == 0)
                                        menuActionID[menuActionRow] = 652;
                                    if (j3 == 1)
                                        menuActionID[menuActionRow] = 567;
                                    if (j3 == 2)
                                        menuActionID[menuActionRow] = 234;
                                    if (j3 == 3)
                                        menuActionID[menuActionRow] = 244;
                                    if (j3 == 4)
                                        menuActionID[menuActionRow] = 213;
                                    menuActionCmd1[menuActionRow] = var17.anInt1558;
                                    menuActionCmd2[menuActionRow] = i1;
                                    menuActionCmd3[menuActionRow] = j1;
                                    menuActionRow++;
                                } else if (j3 == 2) {
                                    this.menuActionName[this.menuActionRow] = "Take <col=ff9040>" + var16.name;
                                    this.menuActionID[this.menuActionRow] = 234;
                                    this.menuActionCmd1[this.menuActionRow] = var17.anInt1558;
                                    this.menuActionCmd2[this.menuActionRow] = i1;
                                    this.menuActionCmd3[this.menuActionRow] = j1;
                                    ++this.menuActionRow;
                                }
                            }

                            if (this.myPrivilege == 2 || this.myPrivilege == 9 || this.myPrivilege == 10
                                    || this.myPrivilege == 4) {
                                this.menuActionName[this.menuActionRow] = "Examine <col=ff9040>" + var16.name
                                        + "<col=65280>(@whi@" + var16.id + "<col=65280>)";
                            } else {
                                this.menuActionName[this.menuActionRow] = "Examine <col=ff9040>" + var16.name;
                            }

                            this.menuActionID[this.menuActionRow] = 1448;
                            this.menuActionCmd1[this.menuActionRow] = var17.anInt1558;
                            this.menuActionCmd2[this.menuActionRow] = i1;
                            this.menuActionCmd3[this.menuActionRow] = j1;
                            ++this.menuActionRow;
                        }
                    }
                }
            }
        }
    }

    public final void method8(int i) {
        exitRequested = true;
        SignLink.reporterror = false;

        try {
            if (this.aRSSocket_1168 != null) {
                this.aRSSocket_1168.method267();
            }
        } catch (Exception var3) {
        }

        this.aRSSocket_1168 = null;
        this.method15(860);
        if (this.mouseDetection != null) {
            this.mouseDetection.running = false;
        }

        this.mouseDetection = null;
        onDemandFetcher.disable();
        onDemandFetcher = null;
        this.astream_834 = null;
        stream = null;
        this.CustomMapback = null;
        chatArea = null;
        cacheSprite = null;
        cacheSprite1 = null;
        cacheSprite2 = null;
        cacheSprite3 = null;
        cacheSprite4 = null;
        cacheSprite5 = null;
        chatButtons = null;
        channelButtons = null;
        this.gameframe = null;
        this.astream_847 = null;
        this.incoming = null;
        this.anIntArray1234 = null;
        BlackMap = null;
        this.aByteArrayArray1183 = null;
        this.aByteArrayArray1247 = null;
        this.anIntArray1235 = null;
        this.anIntArray1236 = null;
        this.anIntArrayArrayArray1214 = null;
        this.byteGroundArray = null;
        this.worldController = null;
        this.aClass11Array1230 = null;
        this.anIntArrayArray901 = null;
        this.anIntArrayArray825 = null;
        this.anIntArray1280 = null;
        this.anIntArray1281 = null;
        this.animatedPixels = null;
        aRSImageProducer_1163 = null;
        this.aRSImageProducer_1164 = null;
        aRSImageProducer_1165 = null;
        aRSImageProducer_1166 = null;
        this.aRSImageProducer_1125 = null;
        this.aRSImageProducer_903 = null;
        this.aRSImageProducer_904 = null;
        this.aRSImageProducer_905 = null;
        this.aRSImageProducer_906 = null;
        this.aRSImageProducer_907 = null;
        this.aRSImageProducer_908 = null;
        this.aRSImageProducer_909 = null;
        this.aRSImageProducer_910 = null;
        this.aRSImageProducer_911 = null;
        this.mapBack = null;
        this.Mapicon = null;
        frame = null;
        this.sideIcons = null;
        this.aBackground_867 = null;
        this.aSprite_868 = null;
        this.aBackground_869 = null;
        this.compass = null;
        this.aSpriteArray987 = null;
        headIconsHint = null;
        this.headIcons = null;
        this.skullIcons = null;
        this.aSpriteArray1150 = null;
        //this.hporbs = null;
        this.aSprite_1074 = null;
        this.aSprite_1075 = null;
        this.aSprite_1076 = null;
        this.aSprite_1077 = null;
        this.aSprite_1078 = null;
        this.aBackgroundArray1060 = null;
        this.MapFunction = null;
        this.anIntArrayArray929 = null;
        this.playerArray = null;
        this.playerIndices = null;
        this.anIntArray894 = null;
        this.astreamArray895 = null;
        this.anIntArray840 = null;
        this.npcArray = null;
        this.npcIndices = null;
        this.aClass19ArrayArrayArray827 = null;
        this.aClass19_1179 = null;
        i = 55 / i;
        this.aClass19_1013 = null;
        this.aClass19_1056 = null;
        this.menuActionCmd2 = null;
        this.menuActionCmd3 = null;
        this.menuActionCmd4 = null;
        this.menuActionID = null;
        this.menuActionCmd1 = null;
        this.menuActionName = null;
        this.settings = null;
        this.anIntArray1072 = null;
        this.anIntArray1073 = null;
        this.aSpriteArray1140 = null;
        this.minimapImage = null;
        this.friendsList = null;
        this.friendsListAsLongs = null;
        this.friendsNodeIDs = null;
        this.aRSImageProducer_1110 = null;
        this.aRSImageProducer_1111 = null;
        this.aRSImageProducer_1107 = null;
        this.aRSImageProducer_1108 = null;
        this.aRSImageProducer_1109 = null;
        this.aRSImageProducer_1112 = null;
        this.aRSImageProducer_1113 = null;
        this.aRSImageProducer_1114 = null;
        this.aRSImageProducer_1115 = null;
        multiOverlay = null;
        this.method118(3);
        ObjectDefinition.method575(-501);
        NpcDefinition.method163(-501);
        ItemDefinition.nullLoader();
        IdentityKit.kits = null;
        Widget.interfaceCache = null;
        Animation.anims = null;
        Graphic.cache = null;
        Graphic.aClass12_415 = null;
        Varp.cache = null;
        super.aRSImageProducer_13 = null;
        Player.aClass12_1704 = null;
        Rasterizer.nullLoader();
        WorldController.method273(-501);
        Model.nullLoader();
        Frame.nullLoader();
        System.gc();
    }

    public void method72(byte byte0) {
        System.out.println("============");
        System.out.println("flame-cycle:" + this.anInt1208);
        if (onDemandFetcher != null) {
            System.out.println("Od-cycle:" + onDemandFetcher.onDemandCycle);
        }

        System.out.println("loop-cycle:" + loopCycle);
        System.out.println("draw-cycle:" + anInt1061);
        System.out.println("ptype:" + this.incomingPacket);
        System.out.println("psize:" + packetSize);
        if (this.aRSSocket_1168 != null) {
            this.aRSSocket_1168.method272((byte) 1);
        }

        super.aBoolean9 = true;
    }

    public Widget getInputFieldFocusOwner() {
        for (Widget rsi : Widget.interfaceCache)
            if (rsi != null)
                if (rsi.isInFocus)
                    return rsi;
        return null;
    }

    public void setInputFieldFocusOwner(Widget owner) {
        for (Widget rsi : Widget.interfaceCache)
            if (rsi != null)
                rsi.isInFocus = rsi == owner;
    }

    public void resetInputFieldFocus() {
        for (Widget rsi : Widget.interfaceCache)
            if (rsi != null)
                rsi.isInFocus = false;
        Widget.currentInputFieldId = -1;
    }

    public boolean isFieldInFocus() {
        if (openInterfaceID == -1) {
            return false;
        }
        for (Widget rsi : Widget.interfaceCache) {
            if (rsi != null) {
                if (rsi.type == 16 && rsi.isInFocus) {
                    return true;
                }
            }
        }
        return false;
    }

    Component getGameComponent() {
        if (SignLink.mainapp != null)
            return SignLink.mainapp;
        return this;
    }

    public final void method73(int i) {
        i = 55 / i;

        while (true) {
            int j = this.readChar(-796);
            if (j == -1) {
                break;
            }

            if (openInterfaceID != -1 && openInterfaceID == this.reportAbuseInterfaceID) {
                if (j == 8 && this.reportAbuseInput.length() > 0) {
                    this.reportAbuseInput = this.reportAbuseInput.substring(0, this.reportAbuseInput.length() - 1);
                }

                if ((j >= 97 && j <= 122 || j >= 65 && j <= 90 || j >= 48 && j <= 57 || j == 32)
                        && this.reportAbuseInput.length() < 12) {
                    this.reportAbuseInput = this.reportAbuseInput + (char) j;
                }
            } else {
                int s;
                if (this.messagePromptRaised) {
                    if (j >= 32 && j <= 122 && this.promptInput.length() < 80) {
                        this.promptInput = this.promptInput + (char) j;
                        inputTaken = true;
                    }

                    if (j == 8 && this.promptInput.length() > 0) {
                        this.promptInput = this.promptInput.substring(0, this.promptInput.length() - 1);
                        inputTaken = true;
                    }

                    if (j == 13 || j == 10) {
                        this.messagePromptRaised = false;
                        inputTaken = true;
                        long var14;
                        if (this.friendsListAction == 1) {
                            var14 = TextClass.longForName(this.promptInput);
                            this.method41((byte) 68, var14);
                        }

                        if (this.friendsListAction == 2 && this.friendsCount > 0) {
                            var14 = TextClass.longForName(this.promptInput);
                            this.method35(false, var14);
                        }

                        if (friendsListAction == 3 && promptInput.length() > 0) {
                            stream.createFrame(126);
                            stream.writeWordBigEndian(0);
                            int k = stream.currentOffset;
                            stream.writeQWord(aLong953);
                            TextInput.method526(promptInput, stream);
                            stream.writeBytes(stream.currentOffset - k);
                            promptInput = TextInput.processText(promptInput);
                            // promptInput = Censor.doCensor(promptInput);
                            pushMessage(promptInput, 6, TextClass.fixName(TextClass.nameForLong(aLong953)));
                            if (privateChatMode == 2) {
                                privateChatMode = 1;
                                stream.createFrame(95);
                                stream.writeWordBigEndian(publicChatMode);
                                stream.writeWordBigEndian(privateChatMode);
                                stream.writeWordBigEndian(tradeMode);
                            }
                        }
                        if (this.friendsListAction == 4 && this.anInt822 < 100) {
                            var14 = TextClass.longForName(this.promptInput);
                            this.method113(var14, 4);
                        }

                        if (this.friendsListAction == 5 && this.anInt822 > 0) {
                            var14 = TextClass.longForName(this.promptInput);
                            this.method122(3, var14);
                        }
                        if (friendsListAction == 6) {
                            sendStringAsLong(promptInput);
                        } else if (friendsListAction == 8) {
                            sendString(1, promptInput);
                        } else if (friendsListAction == 9) {
                            sendString(2, promptInput);
                        } else if (friendsListAction == 10) {
                            sendString(3, promptInput);
                        } else if (friendsListAction == 12) {
                            sendString(5, promptInput);
                        } else if (friendsListAction == 13) {
                            sendString(6, promptInput);
                        }
                    }

                } else if (inputDialogState == 1) {
                    if (j >= 48 && j <= 57 && this.amountOrNameInput.length() < 10) {
                        this.amountOrNameInput = this.amountOrNameInput + (char) j;
                        inputTaken = true;
                    }

                    if (j == 8 && this.amountOrNameInput.length() > 0) {
                        this.amountOrNameInput = this.amountOrNameInput.substring(0,
                                this.amountOrNameInput.length() - 1);
                        inputTaken = true;
                    }

                    if (j == 13 || j == 10) {
                        if (this.amountOrNameInput.length() > 0) {
                            s = 0;

                            try {
                                s = Integer.parseInt(this.amountOrNameInput);
                            } catch (Exception var12) {
                            }

                            stream.createFrame(208);
                            stream.method402(s);
                        }

                        inputDialogState = 0;
                        inputTaken = true;
                    }
                } else if (inputDialogState == 2) {
                    if (j >= 32 && j <= 122 && this.amountOrNameInput.length() < 12) {
                        this.amountOrNameInput = this.amountOrNameInput + (char) j;
                        inputTaken = true;
                    }

                    if (j == 8 && this.amountOrNameInput.length() > 0) {
                        this.amountOrNameInput = this.amountOrNameInput.substring(0,
                                this.amountOrNameInput.length() - 1);
                        inputTaken = true;
                    }

                    if (j == 13 || j == 10) {
                        if (this.amountOrNameInput.length() > 0) {
                            stream.createFrame(60);
                            stream.method404(5, TextClass.longForName(this.amountOrNameInput));
                        }

                        inputDialogState = 0;
                        inputTaken = true;
                    }
                } else if (inputDialogState == 3) {
                    if (j == 10) {
                        inputDialogState = 0;
                        inputTaken = true;
                    }
                    if (j >= 32 && j <= 122 && amountOrNameInput.length() < 40) {
                        amountOrNameInput += (char) j;
                        inputTaken = true;
                    }
                    if (j == 8 && amountOrNameInput.length() > 0) {
                        amountOrNameInput = amountOrNameInput.substring(0, amountOrNameInput.length() - 1);
                        inputTaken = true;
                    }
                } else if (inputDialogState == 7) {
                    if (j >= 48 && j <= 57 && amountOrNameInput.length() < 10) {
                        amountOrNameInput += (char) j;
                        inputTaken = true;
                    }
                    if ((!amountOrNameInput.toLowerCase().contains("k") && !amountOrNameInput.toLowerCase().contains("m") && !amountOrNameInput.toLowerCase().contains("b")) && (j == 107 || j == 109) || j == 98) {
                        amountOrNameInput += (char) j;
                        inputTaken = true;
                    }
                    if (j == 8 && amountOrNameInput.length() > 0) {
                        amountOrNameInput = amountOrNameInput.substring(0, amountOrNameInput.length() - 1);
                        inputTaken = true;
                    }
                    if (j == 13 || j == 10) {
                        if (amountOrNameInput.length() > 0) {
                            if (amountOrNameInput.toLowerCase().contains("k")) {
                                amountOrNameInput = amountOrNameInput.replaceAll(
                                        "k", "000");
                            } else if (amountOrNameInput.toLowerCase()
                                    .contains("m")) {
                                amountOrNameInput = amountOrNameInput.replaceAll(
                                        "m", "000000");
                            } else if (amountOrNameInput.toLowerCase()
                                    .contains("b")) {
                                amountOrNameInput = amountOrNameInput.replaceAll(
                                        "b", "000000000");
                            }
                            int amount = 0;
                            amount = Integer.parseInt(amountOrNameInput);
                            stream.createFrame(208);
                            stream.writeDWord(amount);
                            modifiableXValue = amount;
                        }
                        inputDialogState = 0;
                        inputTaken = true;
                    }
                } else if (inputDialogState == 8) {
                    if (j >= 48 && j <= 57 && amountOrNameInput.length() < 10) {
                        amountOrNameInput += (char) j;
                        inputTaken = true;
                    }
                    if ((!amountOrNameInput.toLowerCase().contains("k") && !amountOrNameInput.toLowerCase().contains("m") && !amountOrNameInput.toLowerCase().contains("b")) && (j == 107 || j == 109) || j == 98) {
                        amountOrNameInput += (char) j;
                        inputTaken = true;
                    }
                    if (j == 8 && amountOrNameInput.length() > 0) {
                        amountOrNameInput = amountOrNameInput.substring(0, amountOrNameInput.length() - 1);
                        inputTaken = true;
                    }
                    if (j == 13 || j == 10) {
                        if (amountOrNameInput.length() > 0) {
                            if (amountOrNameInput.toLowerCase().contains("k")) {
                                amountOrNameInput = amountOrNameInput.replaceAll(
                                        "k", "000");
                            } else if (amountOrNameInput.toLowerCase()
                                    .contains("m")) {
                                amountOrNameInput = amountOrNameInput.replaceAll(
                                        "m", "000000");
                            } else if (amountOrNameInput.toLowerCase()
                                    .contains("b")) {
                                amountOrNameInput = amountOrNameInput.replaceAll(
                                        "b", "000000000");
                            }
                            int amount = 0;
                            amount = Integer.parseInt(amountOrNameInput);
                            stream.createFrame(208);
                            stream.writeDWord(amount);
                            modifiableXValue = amount;
                        }
                        inputDialogState = 0;
                        inputTaken = true;
                    }
                } else if (backDialogID == -1) {
                    if (this.isFieldInFocus()) {
                        Widget rsi = this.getInputFieldFocusOwner();
                        if (rsi == null) {
                            return;
                        }
                        if (j >= 32 && j <= 122 && rsi.message.length() < rsi.characterLimit) {
                            if (rsi.inputRegex.length() > 0) {
                                pattern = Pattern.compile(rsi.inputRegex);
                                matcher = pattern.matcher(Character.toString(((char) j)));
                                if (matcher.matches()) {
                                    rsi.message += (char) j;
                                    inputTaken = true;
                                }
                            } else {
                                rsi.message += (char) j;
                                inputTaken = true;
                            }
                        }
                        if (j == 8 && rsi.message.length() > 0) {
                            rsi.message = rsi.message.substring(0, rsi.message.length() - 1);
                            inputTaken = true;
                        }
                        if (rsi.isItemSearchComponent && rsi.message.length() > 2
                                && rsi.defaultInputFieldText.equals("Name")) {
                            Widget subcomponent = Widget.interfaceCache[rsi.id + 2];
                            Widget scroll = Widget.interfaceCache[rsi.id + 4];
                            Widget toggle = Widget.interfaceCache[rsi.id + 9];
                            scroll.itemSearchSelectedId = 0;
                            scroll.itemSearchSelectedSlot = -1;
                            Widget.selectedItemInterfaceId = 0;
                            rsi.itemSearchSelectedSlot = -1;
                            rsi.itemSearchSelectedId = 0;
                            if (subcomponent != null && scroll != null && toggle != null
                                    && toggle.valueIndexArray != null) {
                                ItemSearch itemSearch = new ItemSearch(rsi.message.toLowerCase(), 60, false);
                                int[] results = itemSearch.getItemSearchResults();
                                if (subcomponent != null) {
                                    int position = 0;
                                    int length = subcomponent.inventoryItemId.length;
                                    subcomponent.inventoryItemId = new int[length];
                                    subcomponent.inventoryAmounts = new int[subcomponent.inventoryItemId.length];
                                    for (int result : results) {
                                        if (result > 0) {
                                            subcomponent.inventoryItemId[position] = result + 1;
                                            subcomponent.inventoryAmounts[position] = 1;
                                            position++;
                                        }
                                    }
                                }
                            }
                        } else if (rsi.updatesEveryInput && rsi.message.length() > 0 && j != 10 && j != 13) {
                            stream.createFrame(142);
                            stream.writeWordBigEndian(4 + rsi.message.length() + 1);
                            stream.writeDWord(rsi.id);
                            stream.writeString(rsi.message);
                            inputString = "";
                            promptInput = "";
                            break;
                        } else if ((j == 10 || j == 13) && rsi.message.length() > 0 && !rsi.updatesEveryInput) {
                            stream.createFrame(142);
                            stream.writeWordBigEndian(4 + rsi.message.length() + 1);
                            stream.writeDWord(rsi.id);
                            stream.writeString(rsi.message);
                            inputString = "";
                            promptInput = "";
                            break;
                        }
                    } else {
                        if (j >= 32 && j <= 122 && inputString.length() < 80) {
                            inputString = inputString + (char) j;
                            inputTaken = true;
                        }

                        if (j == 8 && inputString.length() > 0) {
                            inputString = inputString.substring(0, inputString.length() - 1);
                            inputTaken = true;
                        }
                        if (j == 9)
                            tabToReplyPm();

                        if ((j == 13 || j == 10) && inputString.length() > 0) {

                            if (this.myPrivilege >= 0) {
                                if (inputString.equals("::hd")) {
                                    Constants.hdTexturing = !Constants.hdTexturing;
                                    savePlayerData();
                                    updateSettings();
                                }

                                if (inputString.equals("::fog")) {
                                    Constants.distanceFog = !Constants.distanceFog;
                                    savePlayerData();
                                    updateSettings();
                                }
                                if (inputString.equals("::orbs")) {
                                    Constants.loadOrbs = !Constants.loadOrbs;
                                    savePlayerData();
                                    updateSettings();
                                }
                                if (inputString.equals("::toggleroof")) {
                                    Constants.roofsOff = !Constants.roofsOff;
                                    savePlayerData();
                                    updateSettings();
                                }


                                if (inputString.equals("::317")) {
                                    if (oldGameframe == false && Gameframe508 == false) {
                                        oldGameframe = true;
                                        Gameframe508 = false;
                                        loadTabArea();
                                        drawTabArea();
                                        //savePlayerData();
                                        //updateSettings();
                                    } else {
                                        oldGameframe = false;
                                        Gameframe508 = false;
                                        loadTabArea();
                                        drawTabArea();
                                        //savePlayerData();
                                        //updateSettings();
                                    }
                                }
        						if (inputString.equals("::togglecounter"))
        							drawExperienceCounter = !drawExperienceCounter;

        						if (inputString.equals("::resetcounter") && (j == 13 || j == 10)) {
        							stream.createFrame(185);
        							stream.writeWord(-1);
        							experienceCounter = 0L;
        						}

                                if (inputString.equals("::fixed")) {
                                    currentScreenMode(Main.ScreenMode.FIXED);
                                }

                                if (inputString.equals("::togglenames")) {
                                    Constants.Render_item_names = !Constants.Render_item_names;

                                }
                                if (inputString.equals("::resize")) {
                                    currentScreenMode(Main.ScreenMode.RESIZABLE);
                                }
                                if (inputString.equals("::fullscreen")) {
                                    currentScreenMode(Main.ScreenMode.FULLSCREEN);
                                }

                                if (inputString.equals("::displayfps")) {
                                    fpsOn = !fpsOn;

                                }
                                if (inputString.equals("::spin")) {
                                    setSpinClick(true);
                                    spin();
                                }
                                if (inputString.equals("::toggleoverlay")) {
                                    hoverOverlay = !hoverOverlay;
                                }
                                if(inputString.equals("::togglemenu")){
                                	NewMenu = !NewMenu;
                                }
                                if(inputString.equals("::toggleMouse")){
                                	MouseIcons = !MouseIcons;
                                }
                                if (inputString.equals("::testsave")) {
                                    savePlayerData();
                                    updateSettings();
                                }

                            }

                            int j2;
                            String var11;
                            if (this.myPrivilege == 9 || this.myPrivilege == 10 || this.myPrivilege == 2
                                    || this.myPrivilege == 4) {
                                if (inputString.equals("::clientdrop")) {
                                    this.dropClient();
                                }
                                if (inputString.equals("::grid")) {
                                    Constants.enablegrid = !Constants.enablegrid;
                                }
                                if (inputString.equals("::lag")) {
                                    this.method72((byte) 1);
                                }

                                if (inputString.equals("::prefetchmusic")) {
                                    for (s = 0; s < onDemandFetcher.getVersionCount(2); ++s) {
                                        onDemandFetcher.requestExtra((byte) 1, 2, s);
                                    }
                                }

                                if (inputString.equals("::fpson")) {
                                    fpsOn = !fpsOn;
                                }

                                if (inputString.equals("::dataon")) {
                                    clientData = true;
                                }
                                if (inputString.equals("::dumpitemimg")) {

                                    for (int id = 0; id < 30000; id++) {
                                        Sprite image = ItemDefinition.getSprite(id, 1, 0);
                                        if (image != null) {
                                            image.dumpImage("directory/", "" + id, image, true);
                                        }
                                    }

                                }
                                if(inputString.equals("::edititem")){
                                	ItemEditor.getInstance(1040);
                                }
                                if (inputString.startsWith("::testxp")) {
                                    drawExpCounterDrops();
                                }
                                if (inputString.equals("::508")) {
                                    if (oldGameframe == false && Gameframe508 == false) {
                                        Gameframe508 = true;
                                        oldGameframe = false;
                                        loadTabArea();
                                        drawTabArea();
                                        //savePlayerData();
                                        //updateSettings();
                                    } else {
                                        Gameframe508 = false;
                                        oldGameframe = false;
                                        loadTabArea();
                                        drawTabArea();
                                        //savePlayerData();
                                        //updateSettings();
                                    }
                                }
                                if (inputString.startsWith("::dialogstate")) {
                                    String state;
                                    try {
                                        state = inputString.split(" ")[1];
                                        inputDialogState = Integer.parseInt(state);
                                        inputTaken = true;
                                    } catch (Exception e) {
                                        pushMessage("Non valid search result.", 0, "");
                                        e.printStackTrace();
                                    }
                                }

                                if (inputString.equals("::dataoff")) {
                                    clientData = false;
                                }


                            }

                            if (inputString.startsWith("/"))
                                inputString = "::" + inputString;
                            if (inputString.startsWith("::")) {
                                stream.createFrame(103);
                                stream.writeWordBigEndian(inputString.length() - 1);
                                stream.writeString(inputString.substring(2));
                            } else {
                                var11 = inputString.toLowerCase();
                                if (var11.startsWith("@or1@")) {
                                    inputString = inputString.substring(5);
                                    this.pushMessage(inputString, 14, "");
                                    inputString = "";
                                    break;
                                }

                                if (var11.startsWith("@yel@")) {
                                    inputString = inputString.substring(5);
                                    this.pushMessage(inputString, 15, "");
                                    inputString = "";
                                    break;
                                }

                                if (var11.startsWith("@red@")) {
                                    inputString = inputString.substring(5);
                                    this.pushMessage(inputString, 16, "");
                                    inputString = "";
                                    break;
                                }

                                if (var11.startsWith("@gre@")) {
                                    inputString = inputString.substring(5);
                                    this.pushMessage(inputString, 17, "");
                                    inputString = "";
                                    break;
                                }

                                if (var11.startsWith("@pur@")) {
                                    inputString = inputString.substring(5);
                                    this.pushMessage(inputString, 20, "");
                                    inputString = "";
                                    break;
                                }

                                if (var11.startsWith("@blu@")) {
                                    inputString = inputString.substring(5);
                                    this.pushMessage(inputString, 19, "");
                                    inputString = "";
                                    break;
                                }

                                byte[] var161;

                                if (var11.startsWith("dumpcfg")) {
                                    ItemDefinition.dumpCfg();
                                }

                                if (var11.startsWith("dumpinterface")) {
                                    printInterfaceData();
                                }

                                if (var11.startsWith("dumpitems")) {
                                    ItemDefinition.dumpItems();
                                }

                                if (var11.startsWith("dumpnpc")) {
                                    NpcDefinition.dumpNpc();
                                }

                                if (var11.startsWith("dumpncfgpc")) {
                                    NpcDefinition.dumpNpccfg();
                                }

                                var11.startsWith("dump");
                                byte var171 = 0;
                                byte var181 = 0;
                                if (var11.startsWith("yellow:")) {
                                    var171 = 0;
                                    inputString = inputString.substring(7);
                                } else if (var11.startsWith("red:")) {
                                    var171 = 1;
                                    inputString = inputString.substring(4);
                                } else if (var11.startsWith("green:")) {
                                    var171 = 2;
                                    inputString = inputString.substring(6);
                                } else if (var11.startsWith("cyan:")) {
                                    var171 = 3;
                                    inputString = inputString.substring(5);
                                } else if (var11.startsWith("purple:")) {
                                    var171 = 4;
                                    inputString = inputString.substring(7);
                                } else if (var11.startsWith("white:")) {
                                    var171 = 5;
                                    inputString = inputString.substring(6);
                                } else if (var11.startsWith("flash1:")) {
                                    var171 = 6;
                                    inputString = inputString.substring(7);
                                } else if (var11.startsWith("flash2:")) {
                                    var171 = 7;
                                    inputString = inputString.substring(7);
                                } else if (var11.startsWith("flash3:")) {
                                    var171 = 8;
                                    inputString = inputString.substring(7);
                                } else if (var11.startsWith("glow1:")) {
                                    var171 = 9;
                                    inputString = inputString.substring(6);
                                } else if (var11.startsWith("glow2:")) {
                                    var171 = 10;
                                    inputString = inputString.substring(6);
                                } else if (var11.startsWith("glow3:")) {
                                    var171 = 11;
                                    inputString = inputString.substring(6);
                                }

                                var11 = inputString.toLowerCase();
                                if (var11.startsWith("wave:")) {
                                    var181 = 1;
                                    inputString = inputString.substring(5);
                                } else if (var11.startsWith("wave2:")) {
                                    var181 = 2;
                                    inputString = inputString.substring(6);
                                } else if (var11.startsWith("shake:")) {
                                    var181 = 3;
                                    inputString = inputString.substring(6);
                                } else if (var11.startsWith("scroll:")) {
                                    var181 = 4;
                                    inputString = inputString.substring(7);
                                } else if (var11.startsWith("slide:")) {
                                    var181 = 5;
                                    inputString = inputString.substring(6);
                                }

                                stream.createFrame(4);
                                stream.writeByte(0);
                                int j3 = stream.currentOffset;
                                stream.method425(301, var181);
                                stream.method425(301, var171);
                                this.astream_834.currentOffset = 0;
                                TextInput.method526(inputString, this.astream_834);
                                stream.method441(0, this.aByte1217, this.astream_834.buffer,
                                        this.astream_834.currentOffset);
                                stream.method407(stream.currentOffset - j3, (byte) 0);
                                inputString = TextInput.processText(inputString);
                                inputString = Censor.method497(inputString, 0);
                                myPlayer.aString1506 = inputString;
                                myPlayer.anInt1513 = var171;
                                myPlayer.anInt1531 = var181;
                                myPlayer.textCycle = 150;
                                switch (this.myPrivilege) {
                                    case 1:
                                        this.pushMessage(myPlayer.aString1506, 1, "@cr1@" + myPlayer.name,
                                                playerTitle.title(myPlayer.title, myPlayer));
                                        break;
                                    case 2:
                                        this.pushMessage(myPlayer.aString1506, 1, "@cr2@" + myPlayer.name,
                                                playerTitle.title(myPlayer.title, myPlayer));
                                        break;
                                    case 3:
                                        this.pushMessage(myPlayer.aString1506, 1, "@cr3@" + myPlayer.name,
                                                playerTitle.title(myPlayer.title, myPlayer));
                                        break;
                                    case 4:
                                        this.pushMessage(myPlayer.aString1506, 1, "@cr4@" + myPlayer.name,
                                                playerTitle.title(myPlayer.title, myPlayer));
                                        break;
                                    case 5:
                                        this.pushMessage(myPlayer.aString1506, 1, "@cr5@" + myPlayer.name,
                                                playerTitle.title(myPlayer.title, myPlayer));
                                        break;
                                    case 6:
                                        this.pushMessage(myPlayer.aString1506, 1, "@cr6@" + myPlayer.name,
                                                playerTitle.title(myPlayer.title, myPlayer));
                                        break;
                                    case 7:
                                        this.pushMessage(myPlayer.aString1506, 1, "@cr7@" + myPlayer.name,
                                                playerTitle.title(myPlayer.title, myPlayer));
                                        break;
                                    case 8:
                                        this.pushMessage(myPlayer.aString1506, 1, "@cr8@" + myPlayer.name,
                                                playerTitle.title(myPlayer.title, myPlayer));
                                        break;
                                    case 9:
                                        this.pushMessage(myPlayer.aString1506, 1, "@cr9@" + myPlayer.name,
                                                playerTitle.title(myPlayer.title, myPlayer));
                                        break;
                                    case 10:
                                        this.pushMessage(myPlayer.aString1506, 1, "@cr10@" + myPlayer.name,
                                                playerTitle.title(myPlayer.title, myPlayer));
                                        break;
                                    case 11:
                                        this.pushMessage(myPlayer.aString1506, 1, "@cr11@" + myPlayer.name,
                                                playerTitle.title(myPlayer.title, myPlayer));
                                        break;
                                    case 12:
                                        this.pushMessage(myPlayer.aString1506, 1, "@cr12@" + myPlayer.name,
                                                playerTitle.title(myPlayer.title, myPlayer));
                                        break;
                                    case 13:
                                        this.pushMessage(myPlayer.aString1506, 1, "@cr13@" + myPlayer.name,
                                                playerTitle.title(myPlayer.title, myPlayer));
                                        break;
                                    case 14:
                                        this.pushMessage(myPlayer.aString1506, 1, "@cr14@" + myPlayer.name,
                                                playerTitle.title(myPlayer.title, myPlayer));
                                        break;
                                    case 15:
                                        this.pushMessage(myPlayer.aString1506, 1, "@cr15@" + myPlayer.name,
                                                playerTitle.title(myPlayer.title, myPlayer));
                                        break;
                                    case 16:
                                        this.pushMessage(myPlayer.aString1506, 1, "@cr16@" + myPlayer.name,
                                                playerTitle.title(myPlayer.title, myPlayer));
                                        break;
                                    case 17:
                                        this.pushMessage(myPlayer.aString1506, 1, "@cr17@" + myPlayer.name,
                                                playerTitle.title(myPlayer.title, myPlayer));
                                        break;
                                    case 18:
                                        this.pushMessage(myPlayer.aString1506, 1, "@cr18@" + myPlayer.name,
                                                playerTitle.title(myPlayer.title, myPlayer));
                                        break;
                                    case 19:
                                        this.pushMessage(myPlayer.aString1506, 1, "@cr19@" + myPlayer.name,
                                                playerTitle.title(myPlayer.title, myPlayer));
                                        break;
                                    case 20:
                                        this.pushMessage(myPlayer.aString1506, 1, "@cr20@" + myPlayer.name,
                                                playerTitle.title(myPlayer.title, myPlayer));
                                        break;
                                    case 21:
                                        this.pushMessage(myPlayer.aString1506, 1, "@cr21@" + myPlayer.name,
                                                playerTitle.title(myPlayer.title, myPlayer));
                                        break;
                                    case 22:
                                        this.pushMessage(myPlayer.aString1506, 1, "@cr22@" + myPlayer.name,
                                                playerTitle.title(myPlayer.title, myPlayer));
                                        break;
                                    case 23:
                                        this.pushMessage(myPlayer.aString1506, 1, "@cr23@" + myPlayer.name,
                                                playerTitle.title(myPlayer.title, myPlayer));
                                        break;
                                    case 24:
                                        this.pushMessage(myPlayer.aString1506, 1, "@cr24@" + myPlayer.name,
                                                playerTitle.title(myPlayer.title, myPlayer));
                                        break;
                                    case 25:
                                        this.pushMessage(myPlayer.aString1506, 1, "@cr25@" + myPlayer.name,
                                                playerTitle.title(myPlayer.title, myPlayer));
                                        break;
                                    default:
                                        this.pushMessage(myPlayer.aString1506, 2, myPlayer.name,
                                                playerTitle.title(myPlayer.title, myPlayer));
                                }

                                if (this.publicChatMode == 2) {
                                    this.publicChatMode = 3;
                                    stream.createFrame(95);
                                    stream.writeByte(this.publicChatMode);
                                    stream.writeByte(this.privateChatMode);
                                    stream.writeByte(this.tradeMode);
                                }
                            }

                            inputString = "";
                            inputTaken = true;
                        }
                    }
                }
            }
        }


    }

    public byte[] GetModel(int Indexes) {
        try {
            File var51 = new File("./Models/" + Indexes + ".gz");
            byte[] aByte = new byte[(int) var51.length()];
            FileInputStream Fis = new FileInputStream(var51);
            Fis.read(aByte);
            this.pushMessage("aByte = [" + aByte + "]!", 0, "");
            Fis.close();
            return aByte;
        } catch (Exception var5) {
            return null;
        }
    }

    public void anims() {
        for (int animIndex = 0; animIndex < 3700; ++animIndex) {
            byte[] data = this.GetAnim(animIndex);
            if (data != null && data.length > 0) {
                this.Indexes[2].method234(data.length, data, animIndex);
            }
        }

    }

    public byte[] GetAnim(int Indexes) {
        try {
            File var51 = new File("./anims/" + Indexes + ".gz");
            byte[] data = new byte[(int) var51.length()];
            FileInputStream Fis = new FileInputStream(var51);
            Fis.read(data);
            System.out.println(Indexes + " data = [" + data + "]!");
            Fis.close();
            return data;
        } catch (Exception var5) {
            return null;
        }
    }

    private void buildPublicChat(int j) {
        int l = 0;

        for (int i1 = 0; i1 < 500; ++i1) {
            if (this.chatMessages[i1] != null && this.chatTypeView == 1) {
                int j1 = this.chatTypes[i1];
                String s = this.chatNames[i1];
                int k1 = 70 - l * 14 + 42 + anInt1089 + 4 + 5;
                if (k1 < -25) {
                    break;
                }

                if (s != null && s.startsWith("@cr1@")) {
                    s = s.substring(5);
                }

                if (s != null && s.startsWith("@cr2@")) {
                    s = s.substring(5);
                }

                if (s != null && s.startsWith("@cr3@")) {
                    s = s.substring(5);
                }

                if (s != null && s.startsWith("@cr4@")) {
                    s = s.substring(5);
                }

                if (s != null && s.startsWith("@cr5@")) {
                    s = s.substring(5);
                }

                if (s != null && s.startsWith("@cr6@")) {
                    s = s.substring(5);
                }

                if (s != null && s.startsWith("@cr7@")) {
                    s = s.substring(5);
                }

                if (s != null && s.startsWith("@cr8@")) {
                    s = s.substring(5);
                }

                if (s != null && s.startsWith("@cr9@")) {
                    s = s.substring(5);
                }

                if (s != null && s.startsWith("@cr10@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr11@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr12@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr13@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr14@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr15@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr16@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr17@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr18@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr19@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr20@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr21@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr22@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr23@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr24@")) {
                    s = s.substring(6);
                }
                if (s != null && s.startsWith("@cr25@")) {
                    s = s.substring(6);
                }
                if ((j1 == 1 || j1 == 2) && (j1 == 1 || this.publicChatMode == 0
                        || this.publicChatMode == 1 && this.isFriendOrSelf(s))) {
                    if (j > k1 - 14 && j <= k1 && !s.equals(myPlayer.name)) {
                        if (this.myPrivilege == 1 || this.myPrivilege == 2 || this.myPrivilege == 9
                                || this.myPrivilege == 10 || this.myPrivilege == 4) {
                            this.menuActionName[this.menuActionRow] = "Report abuse @whi@" + s;
                            this.menuActionID[this.menuActionRow] = 606;
                            ++this.menuActionRow;
                        }

                        this.menuActionName[this.menuActionRow] = "Add ignore @whi@" + s;
                        this.menuActionID[this.menuActionRow] = 42;
                        ++this.menuActionRow;
                        this.menuActionName[this.menuActionRow] = "Add friend @whi@" + s;
                        this.menuActionID[this.menuActionRow] = 337;
                        ++this.menuActionRow;
                    }

                    ++l;
                }
            }
        }

    }

    private void buildFriendChat(int j) {
        int l = 0;

        for (int i1 = 0; i1 < 500; ++i1) {
            if (this.chatMessages[i1] != null && this.chatTypeView == 2) {
                int j1 = this.chatTypes[i1];
                String s = this.chatNames[i1];
                int k1 = 70 - l * 14 + 42 + anInt1089 + 4 + 5;
                if (k1 < -25)
                    break;
                if (s != null && s.startsWith("@cr1@"))
                    s = s.substring(5);
                if (s != null && s.startsWith("@cr2@"))
                    s = s.substring(5);
                if (s != null && s.startsWith("@cr3@"))
                    s = s.substring(5);
                if (s != null && s.startsWith("@cr4@"))
                    s = s.substring(5);
                if (s != null && s.startsWith("@cr5@"))
                    s = s.substring(5);
                if (s != null && s.startsWith("@cr6@"))
                    s = s.substring(5);
                if (s != null && s.startsWith("@cr7@"))
                    s = s.substring(5);
                if (s != null && s.startsWith("@cr8@"))
                    s = s.substring(5);
                if (s != null && s.startsWith("@cr9@"))
                    s = s.substring(5);
                if (s != null && s.startsWith("@cr10@"))
                    s = s.substring(6);
                if (s != null && s.startsWith("@cr11@"))
                    s = s.substring(6);
                if (s != null && s.startsWith("@cr12@"))
                    s = s.substring(6);
                if (s != null && s.startsWith("@cr13@"))
                    s = s.substring(6);
                if (s != null && s.startsWith("@cr14@"))
                    s = s.substring(6);
                if (s != null && s.startsWith("@cr15@"))
                    s = s.substring(6);
                if (s != null && s.startsWith("@cr16@"))
                    s = s.substring(6);
                if (s != null && s.startsWith("@cr17@"))
                    s = s.substring(6);
                if (s != null && s.startsWith("@cr18@"))
                    s = s.substring(6);
                if (s != null && s.startsWith("@cr19@"))
                    s = s.substring(6);
                if (s != null && s.startsWith("@cr20@"))
                    s = s.substring(6);
                if (s != null && s.startsWith("@cr21@"))
                    s = s.substring(6);
                if (s != null && s.startsWith("@cr22@"))
                    s = s.substring(6);
                if (s != null && s.startsWith("@cr23@"))
                    s = s.substring(6);
                if (s != null && s.startsWith("@cr24@"))
                    s = s.substring(6);
                if (s != null && s.startsWith("@cr25@"))
                    s = s.substring(6);
                if ((j1 == 5 || j1 == 6) && (this.splitPrivateChat == 0 || this.chatTypeView == 2) && (j1 == 6
                        || this.privateChatMode == 0 || this.privateChatMode == 1 && this.isFriendOrSelf(s))) {
                    ++l;
                }

                if ((j1 == 3 || j1 == 7) && (this.splitPrivateChat == 0 || this.chatTypeView == 2) && (j1 == 7
                        || this.privateChatMode == 0 || this.privateChatMode == 1 && this.isFriendOrSelf(s))) {
                    if (j > k1 - 14 && j <= k1) {
                        if (this.myPrivilege == 1 || this.myPrivilege == 2 || this.myPrivilege == 9
                                || this.myPrivilege == 10 || this.myPrivilege == 4) {
                            this.menuActionName[this.menuActionRow] = "Report abuse @whi@" + s;
                            this.menuActionID[this.menuActionRow] = 606;
                            ++this.menuActionRow;
                        }

                        this.menuActionName[this.menuActionRow] = "Add ignore @whi@" + s;
                        this.menuActionID[this.menuActionRow] = 42;
                        ++this.menuActionRow;
                        this.menuActionName[this.menuActionRow] = "Add friend @whi@" + s;
                        this.menuActionID[this.menuActionRow] = 337;
                        ++this.menuActionRow;
                    }

                    ++l;
                }
            }
        }

    }

    private void buildDuelorTrade(int j) {
        int l = 0;

        for (int i1 = 0; i1 < 500; ++i1) {
            if (this.chatMessages[i1] != null && (this.chatTypeView == 3 || this.chatTypeView == 4)) {
                int j1 = this.chatTypes[i1];
                String s = this.chatNames[i1];
                int k1 = 70 - l * 14 + 42 + anInt1089 + 4 + 5;
                if (k1 < -25) {
                    break;
                }

                if (s != null && s.startsWith("@cr1@")) {
                    s = s.substring(5);
                }

                if (s != null && s.startsWith("@cr2@")) {
                    s = s.substring(5);
                }

                if (s != null && s.startsWith("@cr3@")) {
                    s = s.substring(5);
                }

                if (s != null && s.startsWith("@cr4@")) {
                    s = s.substring(5);
                }

                if (s != null && s.startsWith("@cr5@")) {
                    s = s.substring(5);
                }

                if (s != null && s.startsWith("@cr6@")) {
                    s = s.substring(5);
                }

                if (s != null && s.startsWith("@cr7@")) {
                    s = s.substring(5);
                }

                if (s != null && s.startsWith("@cr8@")) {
                    s = s.substring(5);
                }

                if (s != null && s.startsWith("@cr9@")) {
                    s = s.substring(5);
                }

                if (s != null && s.startsWith("@cr10@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr11@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr12@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr13@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr14@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr15@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr16@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr17@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr18@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr19@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr20@")) {
                    s = s.substring(6);
                }
                if (s != null && s.startsWith("@cr21@")) {
                    s = s.substring(6);
                }
                if (s != null && s.startsWith("@cr22@")) {
                    s = s.substring(6);
                }
                if (s != null && s.startsWith("@cr23@")) {
                    s = s.substring(6);
                }
                if (s != null && s.startsWith("@cr24@")) {
                    s = s.substring(6);
                }
                if (s != null && s.startsWith("@cr25@")) {
                    s = s.substring(6);
                }
                if (this.chatTypeView == 3 && j1 == 4
                        && (this.tradeMode == 0 || this.tradeMode == 1 && this.isFriendOrSelf(s))) {
                    if (j > k1 - 14 && j <= k1) {
                        this.menuActionName[this.menuActionRow] = "Accept trade @whi@" + s;
                        this.menuActionID[this.menuActionRow] = 484;
                        ++this.menuActionRow;
                    }

                    ++l;
                }

                if (this.chatTypeView == 4 && j1 == 8
                        && (this.tradeMode == 0 || this.tradeMode == 1 && this.isFriendOrSelf(s))) {
                    if (j > k1 - 14 && j <= k1) {
                        this.menuActionName[this.menuActionRow] = "Accept challenge @whi@" + s;
                        this.menuActionID[this.menuActionRow] = 6;
                        ++this.menuActionRow;
                    }

                    ++l;
                }

                if (j1 == 12) {
                    if (j > k1 - 14 && j <= k1) {
                        this.menuActionName[this.menuActionRow] = "Go-to <col=255>" + s;
                        this.menuActionID[this.menuActionRow] = 915;
                        ++this.menuActionRow;
                    }

                    ++l;
                }
            }
        }

    }

    private void buildChatAreaMenu(int j) {
        int l = 0;

        for (int i1 = 0; i1 < 500; ++i1) {
            if (this.chatMessages[i1] != null) {
                int j1 = this.chatTypes[i1];
                int k1 = 70 - l * 14 + 42 + anInt1089 + 4 + 5;
                String s = this.chatNames[i1];
                if (this.chatTypeView == 1) {
                    this.buildPublicChat(j);
                    break;
                }

                if (this.chatTypeView == 2) {
                    this.buildFriendChat(j);
                    break;
                }

                if (this.chatTypeView == 3 || this.chatTypeView == 4) {
                    this.buildDuelorTrade(j);
                    break;
                }

                if (this.chatTypeView == 5) {
                    break;
                }

                if (s != null && s.startsWith("@cr1@")) {
                    s = s.substring(5);
                }

                if (s != null && s.startsWith("@cr2@")) {
                    s = s.substring(5);
                }

                if (s != null && s.startsWith("@cr3@")) {
                    s = s.substring(5);
                }

                if (s != null && s.startsWith("@cr4@")) {
                    s = s.substring(5);
                }

                if (s != null && s.startsWith("@cr5@")) {
                    s = s.substring(5);
                }

                if (s != null && s.startsWith("@cr6@")) {
                    s = s.substring(5);
                }

                if (s != null && s.startsWith("@cr7@")) {
                    s = s.substring(5);
                }

                if (s != null && s.startsWith("@cr8@")) {
                    s = s.substring(5);
                }

                if (s != null && s.startsWith("@cr9@")) {
                    s = s.substring(5);
                }

                if (s != null && s.startsWith("@cr10@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr11@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr12@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr13@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr14@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr15@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr16@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr17@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr18@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr19@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr20@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr21@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr22@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr23@")) {
                    s = s.substring(6);
                }

                if (s != null && s.startsWith("@cr24@")) {
                    s = s.substring(6);
                }
                if (s != null && s.startsWith("@cr25@")) {
                    s = s.substring(6);
                }
                if (j1 == 0) {
                    ++l;
                }

                if ((j1 == 1 || j1 == 2) && (j1 == 1 || this.publicChatMode == 0
                        || this.publicChatMode == 1 && this.isFriendOrSelf(s))) {
                    if (j > k1 - 14 && j <= k1 && !s.equals(myPlayer.name)) {
                        if (this.myPrivilege == 1 || this.myPrivilege == 2 || this.myPrivilege == 9
                                || this.myPrivilege == 10 || this.myPrivilege == 4) {
                            this.menuActionName[this.menuActionRow] = "Report abuse @whi@" + s;
                            this.menuActionID[this.menuActionRow] = 606;
                            ++this.menuActionRow;
                        }

                        this.menuActionName[this.menuActionRow] = "Add ignore @whi@" + s;
                        this.menuActionID[this.menuActionRow] = 42;
                        ++this.menuActionRow;
                        this.menuActionName[this.menuActionRow] = "Add friend @whi@" + s;
                        this.menuActionID[this.menuActionRow] = 337;
                        ++this.menuActionRow;
                    }

                    ++l;
                }

                if ((j1 == 3 || j1 == 7) && this.splitPrivateChat == 0 && (j1 == 7 || this.privateChatMode == 0
                        || this.privateChatMode == 1 && this.isFriendOrSelf(s))) {
                    if (j > k1 - 14 && j <= k1) {
                        if (this.myPrivilege == 1 || this.myPrivilege == 2 || this.myPrivilege == 9
                                || this.myPrivilege == 10 || this.myPrivilege == 4) {
                            this.menuActionName[this.menuActionRow] = "Report abuse @whi@" + s;
                            this.menuActionID[this.menuActionRow] = 606;
                            ++this.menuActionRow;
                        }

                        this.menuActionName[this.menuActionRow] = "Add ignore @whi@" + s;
                        this.menuActionID[this.menuActionRow] = 42;
                        ++this.menuActionRow;
                        this.menuActionName[this.menuActionRow] = "Add friend @whi@" + s;
                        this.menuActionID[this.menuActionRow] = 337;
                        ++this.menuActionRow;
                    }

                    ++l;
                }

                if (j1 == 4 && (this.tradeMode == 0 || this.tradeMode == 1 && this.isFriendOrSelf(s))) {
                    if (j > k1 - 14 && j <= k1) {
                        this.menuActionName[this.menuActionRow] = "Accept trade @whi@" + s;
                        this.menuActionID[this.menuActionRow] = 484;
                        ++this.menuActionRow;
                    }

                    ++l;
                }

                if ((j1 == 5 || j1 == 6) && this.splitPrivateChat == 0 && this.privateChatMode < 2) {
                    ++l;
                }

                if (j1 == 8 && (this.tradeMode == 0 || this.tradeMode == 1 && this.isFriendOrSelf(s))) {
                    if (j > k1 - 14 && j <= k1) {
                        this.menuActionName[this.menuActionRow] = "Accept challenge @whi@" + s;
                        this.menuActionID[this.menuActionRow] = 6;
                        ++this.menuActionRow;
                    }

                    ++l;
                }
            }
        }

    }

    public final void drawFriendsListOrWelcomeScreen(Widget class9) {
        int j = class9.contentType;
        int s1;
        if ((j < 1 || j > 100) && (j < 701 || j > 800)) {
            if ((j < 101 || j > 200) && (j < 801 || j > 900)) {
                if (j == 203) {
                    s1 = this.friendsCount;
                    if (this.anInt900 != 2) {
                        s1 = 0;
                    }

                    class9.scrollMax = s1 * 15 + 20;
                    if (class9.scrollMax <= class9.height) {
                        class9.scrollMax = class9.height + 1;
                    }
                } else if (j >= 401 && j <= 500) {
                    j -= 401;
                    if (j == 0 && this.anInt900 == 0) {
                        class9.message = "Loading ignore list";
                        class9.atActionType = 0;
                    } else if (j == 1 && this.anInt900 == 0) {
                        class9.message = "Please wait...";
                        class9.atActionType = 0;
                    } else {
                        s1 = this.anInt822;
                        if (this.anInt900 == 0) {
                            s1 = 0;
                        }

                        if (j >= s1) {
                            class9.message = "";
                            class9.atActionType = 0;
                        } else {
                            class9.message = TextClass.fixName(TextClass.nameForLong(this.aLongArray925[j]));
                            class9.atActionType = 1;
                        }
                    }
                } else if (j == 503) {
                    class9.scrollMax = this.anInt822 * 15 + 20;
                    if (class9.scrollMax <= class9.height) {
                        class9.scrollMax = class9.height + 1;
                    }
                } else {
                    int animationSpeed;
                    int staticFrame;
                    if (j == 327) {
                        class9.modelRotation1 = 150;
                        class9.modelRotation2 = (int) (Math.sin((double) loopCycle / 40.0D) * 256.0D) & 2047;
                        if (this.aBoolean1031) {
                            for (int k1 = 0; k1 < 7; k1++) {
                                int l1 = anIntArray1065[k1];
                                if (l1 >= 0 && !IdentityKit.kits[l1].method537())
                                    return;
                            }

                            this.aBoolean1031 = false;
                            Model[] var101 = new Model[7];
                            int var111 = 0;

                            for (animationSpeed = 0; animationSpeed < 7; ++animationSpeed) {
                                staticFrame = this.anIntArray1065[animationSpeed];
                                if (staticFrame >= 0) {
                                    var101[var111++] = IdentityKit.kits[staticFrame].method538();
                                }
                            }

                            Model var11 = new Model(var111, var101);

                            for (staticFrame = 0; staticFrame < 5; ++staticFrame) {
                                if (this.anIntArray990[staticFrame] != 0) {
                                    var11.recolor(PLAYER_BODY_RECOLOURS[staticFrame][0],
                                            PLAYER_BODY_RECOLOURS[staticFrame][this.anIntArray990[staticFrame]]);
                                    if (staticFrame == 1) {
                                        var11.recolor(anIntArray1204[0],
                                                anIntArray1204[this.anIntArray990[staticFrame]]);
                                    }
                                }
                            }

                            var11.method469((byte) -71);
                            var11.method470(Animation.anims[myPlayer.anInt1511].primary[0]);
                            var11.method479(64, 850, -30, -50, -30, true);
                            class9.anInt233 = 5;
                            class9.anInt234 = 0;
                            Widget.method208(this.aBoolean994, var11);
                        }
                    } else if (j == 324) {
                        if (this.aSprite_931 == null) {
                            this.aSprite_931 = class9.disabledSprite;
                            this.aSprite_932 = class9.enabledSprite;
                        }

                        if (this.aBoolean1047) {
                            class9.disabledSprite = this.aSprite_932;
                        } else {
                            class9.disabledSprite = this.aSprite_931;
                        }
                    } else {
                        if (j == 328) {
                            short var9 = 150;
                            animationSpeed = (int) (Math.sin((double) loopCycle / 40.0D) * 256.0D) & 2047;
                            class9.modelRotation1 = var9;
                            class9.modelRotation2 = animationSpeed;
                            if (this.aBoolean1031) {
                                Model var10 = myPlayer.method452(0);

                                for (staticFrame = 0; staticFrame < 5; ++staticFrame) {
                                    if (this.anIntArray990[staticFrame] != 0) {
                                        var10.recolor(PLAYER_BODY_RECOLOURS[staticFrame][0],
                                                PLAYER_BODY_RECOLOURS[staticFrame][this.anIntArray990[staticFrame]]);
                                        if (staticFrame == 1) {
                                            var10.recolor(anIntArray1204[0],
                                                    anIntArray1204[this.anIntArray990[staticFrame]]);
                                        }
                                    }
                                }

                                staticFrame = myPlayer.anInt1511;
                                var10.method469((byte) -71);
                                var10.method470(Animation.anims[staticFrame].primary[0]);
                                class9.anInt233 = 5;
                                class9.anInt234 = 0;
                                Widget.method208(this.aBoolean994, var10);
                            }
                        }

                        if (j == 325) {
                            if (this.aSprite_931 == null) {
                                this.aSprite_931 = class9.disabledSprite;
                                this.aSprite_932 = class9.enabledSprite;
                            }

                            if (this.aBoolean1047) {
                                class9.disabledSprite = this.aSprite_931;
                            } else {
                                class9.disabledSprite = this.aSprite_932;
                            }
                        } else if (j == 600) {
                            class9.message = this.reportAbuseInput;
                            if (loopCycle % 20 < 10) {
                                class9.message = class9.message + "|";
                            } else {
                                class9.message = class9.message + " ";
                            }
                        } else {
                            if (j == 620 && class9.message != " " && this.myPrivilege < 1) {
                                class9.message = " ";
                            }

                            String var111;
                            if (j == 650 || j == 655) {
                                if (this.anInt1193 != 0) {
                                    if (this.anInt1006 == 0) {
                                        var111 = "earlier today";
                                    } else if (this.anInt1006 == 1) {
                                        var111 = "yesterday";
                                    } else {
                                        var111 = this.anInt1006 + " days ago";
                                    }

                                    class9.message = "You last logged in " + var111 + " from: " + SignLink.dns;
                                } else {
                                    class9.message = "";
                                }
                            }

                            if (j == 651) {
                                if (this.anInt1154 == 0) {
                                    class9.message = "0 unread messages";
                                    class9.textColor = 16776960;
                                }

                                if (this.anInt1154 == 1) {
                                    class9.message = "1 unread message";
                                    class9.textColor = '\uff00';
                                }

                                if (this.anInt1154 > 1) {
                                    class9.message = this.anInt1154 + " unread messages";
                                    class9.textColor = '\uff00';
                                }
                            }

                            if (j == 652) {
                                if (this.anInt1167 == 201) {
                                    if (this.anInt1120 == 1) {
                                        class9.message = "@yel@This is a non-members world: @whi@Since you are a member we";
                                    } else {
                                        class9.message = "";
                                    }
                                } else if (this.anInt1167 == 200) {
                                    class9.message = "You have not yet set any password recovery questions.";
                                } else {
                                    if (this.anInt1167 == 0) {
                                        var111 = "Earlier today";
                                    } else if (this.anInt1167 == 1) {
                                        var111 = "Yesterday";
                                    } else {
                                        var111 = this.anInt1167 + " days ago";
                                    }

                                    class9.message = var111 + " you changed your recovery questions";
                                }
                            }

                            if (j == 653) {
                                if (this.anInt1167 == 201) {
                                    if (this.anInt1120 == 1) {
                                        class9.message = "@whi@recommend you use a members world instead. You may use";
                                    } else {
                                        class9.message = "";
                                    }
                                } else if (this.anInt1167 == 200) {
                                    class9.message = "We strongly recommend you do so now to secure your account.";
                                } else {
                                    class9.message = "If you do not remember making this change then cancel it immediately";
                                }
                            }

                            if (j == 654) {
                                if (this.anInt1167 == 201) {
                                    if (this.anInt1120 == 1) {
                                        class9.message = "@whi@this world but member benef are unavailable whilst here.";
                                        return;
                                    }

                                    class9.message = "";
                                    return;
                                }

                                if (this.anInt1167 == 200) {
                                    class9.message = "Do this from the \'account management\' area on our front webpage";
                                    return;
                                }

                                class9.message = "Do this from the \'account management\' area on our front webpage";
                            }
                        }
                    }
                }
            } else {
                s1 = this.friendsCount;
                if (this.anInt900 != 2) {
                    s1 = 0;
                }

                if (j > 800) {
                    j -= 701;
                } else {
                    j -= 101;
                }

                if (j >= s1) {
                    class9.message = "";
                    class9.atActionType = 0;
                } else {
                    if (this.friendsNodeIDs[j] == 0) {
                        class9.message = "<col=DD5C3E>Offline";
                    } else if (this.friendsNodeIDs[j] == 1) {
                        class9.message = "<col=3CB71E>Online";
                    } else {
                        class9.message = "@red@Offline";
                    }

                    class9.atActionType = 1;
                }
            }
        } else if (j == 1 && this.anInt900 == 0) {
            class9.message = "Loading friend list";
            class9.atActionType = 0;
        } else if (j == 1 && this.anInt900 == 1) {
            class9.message = "Connecting to friendserver";
            class9.atActionType = 0;
        } else if (j == 2 && this.anInt900 != 2) {
            class9.message = "Please wait...";
            class9.atActionType = 0;
        } else {
            s1 = this.friendsCount;
            if (this.anInt900 != 2) {
                s1 = 0;
            }

            if (j > 700) {
                j -= 601;
            } else {
                --j;
            }

            if (j >= s1) {
                class9.message = "";
                class9.atActionType = 0;
            } else {
                class9.message = this.friendsList[j];
                class9.atActionType = 1;
            }
        }

    }

    public final void method76(byte byte0) {
        if (this.anInt1195 != 0) {
            TextDrawingArea textDrawingArea = this.regularText;
            if (byte0 != this.aByte1274) {
                aBoolean1231 = !aBoolean1231;
            }

            int i = 0;
            if (this.anInt1104 != 0) {
                i = 1;
            }

            for (int j = 0; j < 500; ++j) {
                if (this.chatMessages[j] != null) {
                    int k = this.chatTypes[j];
                    String s = this.chatNames[j];
                    byte byte1 = 0;
                    if (s != null && s.startsWith("@cr1@")) {
                        s = s.substring(5);
                        byte1 = 1;
                    }

                    if (s != null && s.startsWith("@cr2@")) {
                        s = s.substring(5);
                        byte1 = 2;
                    }

                    if (s != null && s.startsWith("@cr3@")) {
                        s = s.substring(5);
                        byte1 = 3;
                    }

                    if (s != null && s.startsWith("@cr4@")) {
                        s = s.substring(5);
                        byte1 = 4;
                    }

                    if (s != null && s.startsWith("@cr5@")) {
                        s = s.substring(5);
                        byte1 = 5;
                    }

                    if (s != null && s.startsWith("@cr6@")) {
                        s = s.substring(5);
                        byte1 = 6;
                    }

                    if (s != null && s.startsWith("@cr7@")) {
                        s = s.substring(5);
                        byte1 = 7;
                    }

                    if (s != null && s.startsWith("@cr8@")) {
                        s = s.substring(5);
                        byte1 = 8;
                    }

                    if (s != null && s.startsWith("@cr9@")) {
                        s = s.substring(5);
                        byte1 = 9;
                    }

                    int j1;
                    if ((k == 3 || k == 7) && (k == 7 || this.privateChatMode == 0
                            || this.privateChatMode == 1 && this.isFriendOrSelf(s))) {
                        j1 = 329 - i * 13;
                        if (currentScreenMode != Main.ScreenMode.FIXED) {
                            j1 = currentGameHeight - 170 - i * 13;
                        }

                        byte k1 = 4;
                        textDrawingArea.method385(0, "From", j1, k1);
                        textDrawingArea.method385('\uffff', "From", j1 - 1, k1);
                        int var10 = k1 + textDrawingArea.method383(this.anInt1116, "From ");
                        if (byte1 == 1) {
                            this.ModIcons[0].drawSprite(var10, j1 - 12);
                            var10 += 14;
                        }

                        if (byte1 == 2) {
                            this.ModIcons[1].drawSprite(var10, j1 - 12);
                            var10 += 14;
                        }

                        if (byte1 == 3) {
                            this.ModIcons[2].drawSprite(var10, j1 - 12);
                            var10 += 14;
                        }

                        if (byte1 == 4) {
                            this.ModIcons[3].drawSprite(var10, j1 - 12);
                            var10 += 14;
                        }

                        if (byte1 == 5) {
                            this.ModIcons[4].drawSprite(var10, j1 - 12);
                            var10 += 14;
                        }

                        if (byte1 == 6) {
                            this.ModIcons[7].drawSprite(var10, j1 - 12);
                            var10 += 14;
                        }

                        if (byte1 == 7) {
                            this.ModIcons[8].drawSprite(var10, j1 - 12);
                            var10 += 14;
                        }

                        if (byte1 == 8) {
                            this.ModIcons[9].drawSprite(var10, j1 - 12);
                            var10 += 14;
                        }

                        if (byte1 == 9) {
                            this.ModIcons[10].drawSprite(var10, j1 - 12);
                            var10 += 14;
                        }
                        if (byte1 == 10) {
                            this.ModIcons[11].drawSprite(var10, j1 - 12);
                            var10 += 14;
                        }
                        if (byte1 == 11) {
                            this.ModIcons[12].drawSprite(var10, j1 - 12);
                            var10 += 14;
                        }
                        if (byte1 == 12) {
                            this.ModIcons[13].drawSprite(var10, j1 - 12);
                            var10 += 14;
                        }
                        if (byte1 == 14) {
                            this.ModIcons[15].drawSprite(var10, j1 - 12);
                            var10 += 14;
                        }
                        textDrawingArea.method385(0, s + ": " + this.chatMessages[j], j1, var10);
                        textDrawingArea.method385('\uffff', s + ": " + this.chatMessages[j], j1 - 1, var10);
                        ++i;
                        if (i >= 5) {
                            return;
                        }
                    }

                    if (k == 5 && this.privateChatMode < 2) {
                        j1 = 329 - i * 13;
                        if (currentScreenMode != Main.ScreenMode.FIXED) {
                            j1 = currentGameHeight - 170 - i * 13;
                        }

                        textDrawingArea.method385(0, this.chatMessages[j], j1, 4);
                        textDrawingArea.method385('\uffff', this.chatMessages[j], j1 - 1, 4);
                        ++i;
                        if (i >= 5) {
                            return;
                        }
                    }

                    if (k == 6 && this.privateChatMode < 2) {
                        j1 = 329 - i * 13;
                        if (currentScreenMode != Main.ScreenMode.FIXED) {
                            j1 = currentGameHeight - 170 - i * 13;
                        }

                        textDrawingArea.method385(0, "To " + s + ": " + this.chatMessages[j], j1, 4);
                        textDrawingArea.method385('\uffff', "To " + s + ": " + this.chatMessages[j], j1 - 1, 4);
                        ++i;
                        if (i >= 5) {
                            return;
                        }
                    }
                }
            }
        }

    }

    public void pushMessage(String message, int view, String name) {
        this.pushMessage(message, view, name, "");
    }

    public void pushMessage(String message, int view, String name, String title) {
        if (view == 0 && this.dialogID != -1) {
            this.aString844 = message;
            super.clickMode3 = 0;
        }

        if (backDialogID == -1) {
            inputTaken = true;
        }

        for (int previous = 499; previous > 0; --previous) {
            this.chatTypes[previous] = this.chatTypes[previous - 1];
            this.chatNames[previous] = this.chatNames[previous - 1];
            this.chatMessages[previous] = this.chatMessages[previous - 1];
            this.chatRights[previous] = this.chatRights[previous - 1];
            clanTitles[previous] = clanTitles[previous - 1];
            this.playerTitles[previous] = this.playerTitles[previous - 1];
        }

        this.chatTypes[0] = view;
        this.chatNames[0] = name;
        this.chatMessages[0] = message;
        this.chatRights[0] = channelRights;
        clanTitles[0] = clanTitle;
        this.playerTitles[0] = title;
    }

    public void processTabClick() {
        if (clickMode3 == 1) {
            if (currentScreenMode == ScreenMode.FIXED) {
                int x = 516;
                int y = 168;
                int[] points = new int[]{3, 41, 74, 107, 140, 173, 206, 244};
                for (int index = 0; index < points.length - 1; index++) {
                    int tabIndex = index < points.length ? points.length : points.length * 2;
                    if (Main.tabInterfaceIDs[tabIndex] != -1) {
                        if (super.saveClickX >= x + points[index] && super.saveClickX <= x + points[index + 1]) {
                            if (super.saveClickY >= y && super.saveClickY <= y + 36) {
                                Main.tabID = index;
                            } else if (super.saveClickY >= y + 298 && super.saveClickY <= y + 36 + 298) {
                                Main.tabID = index + 7;
                            }
                            Main.needDrawTabArea = true;
                            Main.tabAreaAltered = true;
                        }
                    }
                }
            } else {
                int x = Main.currentGameWidth - (stackTabs() ? 231 : 462);
                int y = Main.currentGameHeight - (stackTabs() ? 73 : 37);
                for (int index = 0; index < 14; index++) {
                    if (Main.tabInterfaceIDs[index] != -1) {
                        if (super.saveClickX >= x && super.saveClickX <= x + 33) {
                            if (super.saveClickY >= y && super.saveClickY <= y + 36) {
                                Main.tabID = index;
                            } else if (stackTabs() && super.saveClickY >= y + 36 && super.saveClickY <= y + 36 + 36) {
                                Main.tabID = index + 7;
                            }
                            Main.needDrawTabArea = true;
                            Main.tabAreaAltered = true;
                        }
                    }
                    x += 33;
                }
            }
        }
    }

    public final void resetImageProducers2() {
        if (aRSImageProducer_1166 == null) {
            this.method118(3);
            super.aRSImageProducer_13 = null;
            this.aRSImageProducer_1107 = null;
            this.aRSImageProducer_1108 = null;
            this.aRSImageProducer_1109 = null;
            this.aRSImageProducer_1110 = null;
            this.aRSImageProducer_1111 = null;
            this.aRSImageProducer_1112 = null;
            this.aRSImageProducer_1113 = null;
            this.aRSImageProducer_1114 = null;
            this.aRSImageProducer_1115 = null;
            aRSImageProducer_1166 = new RSImageProducer(516, 165, getGameComponent());
            this.aRSImageProducer_1164 = new RSImageProducer(249, 168, getGameComponent());
            DrawingArea.setAllPixelsToZero();
            this.gameframe[29].drawSprite(0, 0);
            aRSImageProducer_1163 = new RSImageProducer(249, 335, getGameComponent());
            aRSImageProducer_1165 = new RSImageProducer(
                    currentScreenMode == ScreenMode.FIXED ? 516 : currentScreenMode.getWidth(),
                    currentScreenMode == ScreenMode.FIXED ? 338 : currentScreenMode.getHeight(), getGameComponent());
            DrawingArea.setAllPixelsToZero();
            this.aRSImageProducer_1125 = new RSImageProducer(249, 45, getGameComponent());
            this.aBoolean1255 = true;
        }

    }

    public String getDocumentBaseHost() {
        if (SignLink.mainapp != null) {
            return SignLink.mainapp.getDocumentBase().getHost().toLowerCase();
        }
        return "";
    }

    public final void method81(Sprite Sprite, int j, int k) {
        int l = k * k + j * j;
        if (l > 4225 && l < 90000) {
            int i1 = this.anInt1185 + this.anInt1209 & 2047;
            int j1 = Model.SINE[i1];
            int k1 = Model.COSINE[i1];
            j1 = j1 * 256 / (this.anInt1170 + 256);
            k1 = k1 * 256 / (this.anInt1170 + 256);
        } else {
            this.markMinimap(Sprite, k, j);
        }

    }

    public void rightClickChatButtons() {
        if (super.mouseY >= (currentScreenMode == ScreenMode.FIXED ? 482 : currentGameHeight - 22)
                && super.mouseY <= (currentScreenMode == ScreenMode.FIXED ? 503 : currentGameHeight)) {

            if (super.mouseX >= 5 && super.mouseX <= 61) {
                this.menuActionName[1] = "View All";
                this.menuActionCmd3[1] = 999;
                this.menuActionRow = 2;
            } else if (super.mouseX >= 71 && super.mouseX <= 127) {
                this.menuActionName[1] = "View Game";
                this.menuActionCmd3[1] = 998;
                this.menuActionRow = 2;
            } else if (super.mouseX >= 137 && super.mouseX <= 193) {
                this.menuActionName[1] = "Hide public";
                this.menuActionCmd3[1] = 997;
                this.menuActionName[2] = "Off public";
                this.menuActionCmd3[2] = 996;
                this.menuActionName[3] = "Friends public";
                this.menuActionCmd3[3] = 995;
                this.menuActionName[4] = "On public";
                this.menuActionCmd3[4] = 994;
                this.menuActionName[5] = "View public";
                this.menuActionCmd3[5] = 993;
                this.menuActionRow = 6;
            } else if (super.mouseX >= 203 && super.mouseX <= 259) {
                this.menuActionName[1] = "Off private";
                this.menuActionCmd3[1] = 992;
                this.menuActionName[2] = "Friends private";
                this.menuActionCmd3[2] = 991;
                this.menuActionName[3] = "On private";
                this.menuActionCmd3[3] = 990;
                this.menuActionName[4] = "View private";
                this.menuActionCmd3[4] = 989;
                this.menuActionRow = 5;
            } else if (super.mouseX >= 269 && super.mouseX <= 325) {
                this.menuActionName[1] = "Off clan chat";
                this.menuActionCmd3[1] = 1003;
                this.menuActionName[2] = "Friends clan chat";
                this.menuActionCmd3[2] = 1002;
                this.menuActionName[3] = "On clan chat";
                this.menuActionCmd3[3] = 1001;
                this.menuActionName[4] = "View clan chat";
                this.menuActionCmd3[4] = 1000;
                this.menuActionRow = 5;
            } else if (super.mouseX >= 335 && super.mouseX <= 391) {
                this.menuActionName[1] = "Off trade";
                this.menuActionCmd3[1] = 987;
                this.menuActionName[2] = "Friends trade";
                this.menuActionCmd3[2] = 986;
                this.menuActionName[3] = "On trade";
                this.menuActionCmd3[3] = 985;
                this.menuActionName[4] = "View trade";
                this.menuActionCmd3[4] = 984;
                this.menuActionRow = 5;
            } else if (super.mouseX >= 404 && super.mouseX <= 515) {
                this.menuActionName[1] = "Report Abuse";
                this.menuActionCmd3[1] = 606;
                this.menuActionRow = 2;
            }
        }

    }

    private boolean checkMainScreenBounds() {
        if (checkBounds(0, currentGameWidth - (stackTabs() ? 231 : 462), currentGameHeight - (stackTabs() ? 73 : 37),
                currentGameWidth, currentGameHeight)) {
            return false;
        }
        if (checkBounds(0, currentGameWidth - 225, 0, currentGameWidth, 170)) {
            return false;
        }
        if (checkBounds(0, currentGameWidth - 204, currentGameHeight - (stackTabs() ? 73 : 37) - 275, currentGameWidth,
                currentGameHeight)) {
            return false;
        }
        return !checkBounds(0, 0, currentGameHeight - 168, 516, currentGameHeight);
    }

    private boolean checkBounds(int type, int x1, int y1, int x2, int y2) {
        if (type == 0)
            return mouseX >= x1 && mouseX <= x2 && mouseY >= y1 && mouseY <= y2;
        else
            return Math.pow((x1 + type - x2), 2) + Math.pow((y1 + type - y2), 2) < Math.pow(type, 2);
    }

    private void processRightClick() {
        if (loggedIn) {
            if (activeInterfaceType != 0)
                return;
            menuActionName[0] = "Cancel";
            menuActionID[0] = 1107;
            menuActionRow = 1;
            if (currentScreenMode != ScreenMode.FIXED) {
                if (fullscreenInterfaceID != -1) {
                    anInt886 = 0;
                    anInt1315 = 0;
                    buildInterfaceMenu((currentGameWidth / 2) - 765 / 2,
                            Widget.interfaceCache[fullscreenInterfaceID], super.mouseX,
                            (currentGameHeight / 2) - 503 / 2, super.mouseY, 0);
                    if (anInt886 != anInt1026) {
                        anInt1026 = anInt886;
                    }
                    if (anInt1315 != anInt1129) {
                        anInt1129 = anInt1315;
                    }
                    return;
                }
            }
            buildSplitPrivateChatMenu();
            anInt886 = 0;
            anInt1315 = 0;

            if (currentScreenMode == ScreenMode.FIXED) {
                if (mouseX > 0 && mouseY > 0 && mouseX < 516 && mouseY < 343) {
                    if (openInterfaceID != -1) {
                        buildInterfaceMenu(0, Widget.interfaceCache[openInterfaceID], mouseX, 0, mouseY, 0);
                    } else {
                        build3dScreenMenu();
                    }
                }
            } else {
                if (checkMainScreenBounds()) {
                    if (openInterfaceID != -1) {
                        if (currentGameWidth > 900 && currentGameHeight > 650 && mouseX > (currentGameWidth / 2) - 356
                                && mouseX < ((currentGameWidth / 2) + 356) && mouseY > (currentGameHeight / 2) - 230
                                && mouseY < (currentGameHeight / 2) + 230) {
                            buildInterfaceMenu((currentGameWidth / 2) - 256 - 99,
                                    Widget.interfaceCache[openInterfaceID], mouseX, (currentGameHeight / 2) - 167 - 63,
                                    mouseY, 0);
                        } else if (centerMainScreenInterface()) {
                            if (mouseX > 0 && mouseY > 0 && mouseX < 516 && mouseY < 343) {
                                buildInterfaceMenu(0, Widget.interfaceCache[openInterfaceID], mouseX, 0, mouseY,
                                        0);
                            }
                        }
                    } else {
                        build3dScreenMenu();
                    }
                }
            }

            if (anInt1315 != anInt1129) {
                anInt1129 = anInt1315;
            }
            anInt886 = 0;
            anInt1315 = 0;
            if (currentScreenMode == ScreenMode.FIXED) {
                if (mouseX > 516 && mouseY > 205 && mouseX < 765 && mouseY < 466) {
                    if (invOverlayInterfaceID != -1) {
                        buildInterfaceMenu(547, Widget.interfaceCache[invOverlayInterfaceID], mouseX, 205, mouseY,
                                0);
                    } else if (tabInterfaceIDs[tabID] != -1) {
                        buildInterfaceMenu(547, Widget.interfaceCache[tabInterfaceIDs[tabID]], mouseX, 205, mouseY,
                                0);
                    }
                }
            } else {
                int y = stackTabs() ? 73 : 37;
                if (mouseX > currentGameWidth - 197 && mouseY > currentGameHeight - 275 - y + 10
                        && mouseX < currentGameWidth - 7 && mouseY < currentGameHeight - y - 5) {
                    if (invOverlayInterfaceID != -1) {
                        buildInterfaceMenu(currentGameWidth - 197, Widget.interfaceCache[invOverlayInterfaceID],
                                mouseX, currentGameHeight - 275 - y + 10, mouseY, 0);
                    } else if (tabInterfaceIDs[tabID] != -1) {
                        buildInterfaceMenu(currentGameWidth - 197, Widget.interfaceCache[tabInterfaceIDs[tabID]],
                                mouseX, currentGameHeight - 275 - y + 10, mouseY, 0);
                    }
                }
            }
            if (anInt886 != anInt1048) {
                needDrawTabArea = true;
                tabAreaAltered = true;
                anInt1048 = anInt886;
            }
            if (anInt1315 != anInt1044) {
                needDrawTabArea = true;
                tabAreaAltered = true;
                anInt1044 = anInt1315;
            }
            anInt886 = 0;
            anInt1315 = 0;
            /* Chat area clicking */
            if (currentScreenMode == ScreenMode.FIXED) {
                if (mouseX > 0 && mouseY > 338 && mouseX < 490 && mouseY < 463) {
                    if (backDialogID != -1)
                        buildInterfaceMenu(20, Widget.interfaceCache[backDialogID], mouseX, 358, mouseY, 0);
                    else if (mouseY < 463 && mouseX < 490)
                        buildChatAreaMenu(mouseY - 338);
                }
            } else {
                if (mouseX > 0 && mouseY > currentGameHeight - 165 && mouseX < 490 && mouseY < currentGameHeight - 40) {
                    if (backDialogID != -1)
                        buildInterfaceMenu(20, Widget.interfaceCache[backDialogID], mouseX,
                                currentGameHeight - 145, mouseY, 0);
                    else if (mouseY < currentGameHeight - 40 && mouseX < 490)
                        buildChatAreaMenu(mouseY - (currentGameHeight - 165));
                }
            }
            if (backDialogID != -1 && anInt886 != anInt1039) {
                inputTaken = true;
                anInt1039 = anInt886;
            }
            if (backDialogID != -1 && anInt1315 != anInt1500) {
                inputTaken = true;
                anInt1500 = anInt1315;
            }
            /* Enable custom right click areas */
            if (anInt886 != anInt1026)
                anInt1026 = anInt886;
            anInt886 = 0;

            rightClickChatButtons();
            processMinimapActions();
            boolean flag = false;
            while (!flag) {
                flag = true;
                for (int j = 0; j < menuActionRow - 1; j++) {
                    if (menuActionID[j] < 1000 && menuActionID[j + 1] > 1000) {
                        String s = menuActionName[j];
                        menuActionName[j] = menuActionName[j + 1];
                        menuActionName[j + 1] = s;
                        int k = menuActionID[j];
                        menuActionID[j] = menuActionID[j + 1];
                        menuActionID[j + 1] = k;
                        k = menuActionCmd2[j];
                        menuActionCmd2[j] = menuActionCmd2[j + 1];
                        menuActionCmd2[j + 1] = k;
                        k = menuActionCmd3[j];
                        menuActionCmd3[j] = menuActionCmd3[j + 1];
                        menuActionCmd3[j + 1] = k;
                        k = menuActionCmd1[j];
                        menuActionCmd1[j] = menuActionCmd1[j + 1];
                        menuActionCmd1[j + 1] = k;
                        k = menuActionCmd4[j];
                        menuActionCmd4[j] = menuActionCmd4[j + 1];
                        menuActionCmd4[j + 1] = k;
                        flag = false;
                    }
                }
            }
        }
    }

    public final int method83(boolean flag, int i, int j, int k) {
        if (!flag) {
            this.aClass19ArrayArrayArray827 = null;
        }

        int l = 256 - k;
        return ((i & 16711935) * l + (j & 16711935) * k & -16711936)
                + ((i & '\uff00') * l + (j & '\uff00') * k & 16711680) >> 8;
    }

    public final void login(String s, String s1, boolean flag) {
        SignLink.errorname = s;

        try {
            if (this.myUsername.length() <= 3) {
                this.loginMessage2 = "@whi@Please enter a valid username";
                return;
            }

            if (this.myPassword.length() <= 3) {
                this.loginMessage2 = "@whi@Please enter a valid password";
                return;
            }

            if (!flag) {
                this.loginMessage1 = "@whi@Connecting to";
                this.loginMessage2 = "@whi@Connecting to Ghreborn.";
                this.drawLoginScreen(true);
            }

            try {
                aPort = Integer.parseInt(port);
            } catch (NumberFormatException var15) {
            }

            this.aRSSocket_1168 = new RSSocket(this, -978, this.openSocket(aPort + portOff));
            long var171 = TextClass.longForName(s);
            int i = (int) (var171 >> 16 & 31L);
            stream.currentOffset = 0;
            stream.writeByte(14);
            stream.writeByte(i);
            this.aRSSocket_1168.method271(2, stream.buffer);

            int k;
            for (k = 0; k < 8; ++k) {
                this.aRSSocket_1168.method268();
            }

            k = this.aRSSocket_1168.method268();
            int i1 = k;
            int i3;
            if (k == 0) {
                this.aRSSocket_1168.method270(this.incoming.buffer, 0, 8);
                this.incoming.currentOffset = 0;
                this.aLong1215 = this.incoming.method414(-35089);
                int[] var181 = new int[]{(int) (Math.random() * 9.9999999E7D), (int) (Math.random() * 9.9999999E7D),
                        (int) (this.aLong1215 >> 32), (int) this.aLong1215};
                stream.currentOffset = 0;
                stream.writeByte(10);
                stream.method402(var181[0]);
                stream.method402(var181[1]);
                stream.method402(var181[2]);
                stream.method402(var181[3]);
                stream.writeQWord(SignLink.uid);
                stream.writeString(CreateUID.generateUID());
                stream.method405(s);
                stream.method405(s1);
                stream.encodeRSA(aBigInteger1032, aBigInteger856);
                this.astream_847.currentOffset = 0;
                if (flag) {
                    this.astream_847.writeByte(18);
                } else {
                    this.astream_847.writeByte(16);
                }

                this.astream_847.writeByte(stream.currentOffset + 36 + 1 + 1 + 2);
                this.astream_847.writeByte(255);
                this.astream_847.method399(317);
                this.astream_847.writeByte(lowMem ? 1 : 0);
                this.astream_847.writeByte(resize ? 1 : 0);
                this.astream_847.putShort(currentGameWidth);
                this.astream_847.putShort(currentGameHeight);
                this.astream_847.putShort(ClientVerison);
                for (i3 = 0; i3 < 9; ++i3) {
                    this.astream_847.method402(JagGrab.CRCs[i3]);
                }

                this.astream_847.writeBytes(stream.buffer, stream.currentOffset, 0);
                stream.encryption = new ISAACRandomGen(-436, var181);

                for (i3 = 0; i3 < 4; ++i3) {
                    var181[i3] += 50;
                }

                this.aClass17_1000 = new ISAACRandomGen(-436, var181);
                this.aRSSocket_1168.method271(this.astream_847.currentOffset,
                        this.astream_847.buffer);
                k = this.aRSSocket_1168.method268();
            }

            if (k == 1) {
                try {
                    Thread.sleep(2000L);
                } catch (Exception var12) {
                }

                this.login(s, s1, flag);
                return;
            }

            int var18;
            if (k == 2) {
                this.myPrivilege = this.aRSSocket_1168.method268();
                aBoolean1205 = this.aRSSocket_1168.method268() == 1;
                currentSkill = -1;
                this.aLong1220 = 0L;
                this.anInt1022 = 0;
                this.mouseDetection.coordsIndex = 0;
                super.aBoolean17 = true;
                this.aBoolean954 = true;
                loggedIn = true;
                final AccountData account = new AccountData(s, s1);
                if (informationFile.isUsernameRemembered()) {
                    AccountManager.addAccount(account);
                    currentAccount = AccountManager.getAccount(s);
                    if (currentAccount == null) {
                        currentAccount = account;
                    }
                    AccountManager.saveAccount();
                }
                stream.currentOffset = 0;
                this.incoming.currentOffset = 0;
                this.incomingPacket = -1;
                this.dealtWithPacket = -1;
                dealtWithPacketSize = -1;
                this.previousPacket1 = -1;
                this.previousPacket2 = -1;
                previousPacketSize1 = -1;
                previousPacketSize2 = -1;
                packetSize = 0;
                this.anInt1009 = 0;
                this.anInt1104 = 0;
                this.anInt1011 = 0;
                this.anInt855 = 0;
                this.menuActionRow = 0;
                this.menuOpen = false;
                super.idleTime = 0;

                for (var18 = 0; var18 < 100; ++var18) {
                    this.chatMessages[var18] = null;
                }

                this.itemSelected = 0;
                this.spellSelected = 0;
                this.anInt1023 = 0;
                this.anInt1062 = 0;
                this.anInt1278 = (int) (Math.random() * 100.0D) - 50;
                this.anInt1131 = (int) (Math.random() * 110.0D) - 55;
                this.anInt896 = (int) (Math.random() * 80.0D) - 40;
                this.anInt1209 = (int) (Math.random() * 120.0D) - 60;
                this.anInt1170 = (int) (Math.random() * 30.0D) - 20;
                this.anInt1185 = (int) (Math.random() * 20.0D) - 10 & 2047;
                this.anInt1021 = 0;
                this.anInt985 = -1;
                this.destX = 0;
                this.destY = 0;
                this.playerCount = 0;
                this.npcCount = 0;

                for (var18 = 0; var18 < this.anInt888; ++var18) {
                    this.playerArray[var18] = null;
                    this.astreamArray895[var18] = null;
                }

                for (var18 = 0; var18 < 16384; ++var18) {
                    this.npcArray[var18] = null;
                }

                myPlayer = this.playerArray[this.myPlayerIndex] = new Player();
                this.aClass19_1013.method256();
                this.aClass19_1056.method256();

                for (var18 = 0; var18 < 4; ++var18) {
                    for (i3 = 0; i3 < 104; ++i3) {
                        for (int k3 = 0; k3 < 104; ++k3) {
                            this.aClass19ArrayArrayArray827[var18][i3][k3] = null;
                        }
                    }
                }

                this.aClass19_1179 = new NodeList(169);
                fullscreenInterfaceID = -1;
                this.anInt900 = 0;
                this.friendsCount = 0;
                this.dialogID = -1;
                backDialogID = -1;
                openInterfaceID = -1;
                this.invOverlayInterfaceID = -1;
                this.openWalkableInterface = -1;
                this.aBoolean1149 = false;
                tabID = 3;
                inputDialogState = 0;
                this.menuOpen = false;
                this.messagePromptRaised = false;
                this.aString844 = null;
                this.anInt1055 = 0;
                this.anInt1054 = -1;
                this.aBoolean1047 = true;
                this.method45(0);

                for (var18 = 0; var18 < 5; ++var18) {
                    this.anIntArray990[var18] = 0;
                }

                for (var18 = 0; var18 < 5; ++var18) {
                    this.aStringArray1127[var18] = null;
                    this.aBooleanArray1128[var18] = false;
                }

                anInt1175 = 0;
                anInt1134 = 0;
                anInt986 = 0;
                anInt1288 = 0;
                anInt924 = 0;
                anInt1188 = 0;
                anInt1155 = 0;
                anInt1226 = 0;
                this.resetImageProducers2();
                return;
            }

            if (k == 3) {
                this.loginMessage1 = "";
                this.loginMessage2 = "@whi@Invalid username or password.";
                return;
            }

            if (k == 4) {
                this.loginMessage1 = "@whi@Your account has been disabled.";
                this.loginMessage2 = "@whi@ check your message-centre for details.";
                return;
            }

            if (k == 5) {
                this.loginMessage1 = "@lre@Your account is already logged in.";
                this.loginMessage2 = "@lre@Try again in 60 secs...";
                return;
            }

            if (k == 6) {
                this.loginMessage1 = "@gre@Server has been updated!";
                this.loginMessage2 = "@gre@Please reload this Main.";
                return;
            }

            if (k == 7) {
                this.loginMessage1 = "@gre@This world is full.";
                this.loginMessage2 = "@gre@Please use a different server.";
                return;
            }

            if (k == 8) {
                this.loginMessage1 = "@blu@Unable to connect.";
                this.loginMessage2 = "@blu@Login server offline.";
                return;
            }

            if (k == 9) {
                this.loginMessage1 = "@blu@Login limit exceeded.";
                this.loginMessage2 = "@blu@Too many connections from your address.";
                return;
            }

            if (k == 10) {
                this.loginMessage1 = "@blu@Unable to connect.";
                this.loginMessage2 = "@blu@Bad session id.";
                return;
            }

            if (k == 11) {
                this.loginMessage2 = "@red@Login server rejected session.";
                this.loginMessage2 = "@lre@Please try again.";
                return;
            }

            if (k == 12) {
                this.loginMessage1 = "@gre@You need a members account to login to this world.";
                this.loginMessage2 = "@gre@Please subscribe, or use a different world.";
                return;
            }

            if (k == 13) {
                this.loginMessage1 = "@blu@Could not complete login.";
                this.loginMessage2 = "@blu@Please try using a different world.";
                return;
            }

            if (k == 14) {
                this.loginMessage1 = "@gre@The server is being updated.";
                this.loginMessage2 = "@gre@Please wait 1 minute and try again.";
                return;
            }

            if (k == 15) {
                loggedIn = true;
                stream.currentOffset = 0;
                this.incoming.currentOffset = 0;
                this.incomingPacket = -1;
                this.dealtWithPacket = -1;
                dealtWithPacketSize = -1;
                this.previousPacket1 = -1;
                this.previousPacket2 = -1;
                previousPacketSize1 = -1;
                previousPacketSize2 = -1;
                packetSize = 0;
                this.anInt1009 = 0;
                this.anInt1104 = 0;
                this.menuActionRow = 0;
                this.menuOpen = false;
                this.aLong824 = System.currentTimeMillis();
                return;
            }

            if (k == 16) {
                this.loginMessage1 = "@blu@Login attempts exceeded.";
                this.loginMessage2 = "@blu@Please wait 1 minute and try again.";
                return;
            }

            if (k == 17) {
                this.loginMessage1 = "@gre@You are standing in a members-only area.";
                this.loginMessage2 = "@gre@To play on this world move to a free area first";
                return;
            }

            if (k == 20) {
                this.loginMessage1 = "@blu@Invalid loginserver requested";
                this.loginMessage2 = "@blu@Please try using a different world.";
                return;
            }
            if (k == 23) {
                this.loginMessage1 = "@whi@You are @red@Not@whi@ apart of the Alpha.";
                this.loginMessage2 = "@whi@Please apply on the Discord.";
                return;
            }
            if (k == 24) {
                this.loginMessage1 = "@whi@You are Using a VPN.";
                this.loginMessage2 = "@whi@Please Turn it off if u want to play.";
                return;
            }

            if (k == 42) {
                this.loginMessage1 = "@blu@Client has been updated,";
                this.loginMessage2 = "@blu@Reload the Client.";
                return;
            }
            if (k == 43) {
                this.loginMessage1 = "@whi@Your account is nulled,";
                this.loginMessage2 = "@whi@Relog to fix..";
                return;
            }
            if(k == 44) {
				loginMessage1 = "Your computer has been UUID banned.";
				loginMessage2 = "Please appeal on the Discord.";
				return;
			}
            if (k != 21) {
                if (k == -1) {
                    if (i1 == 0) {
                        if (this.loginScreenCursorPos < 2) {
                            try {
                                Thread.sleep(2000L);
                            } catch (Exception var13) {
                            }

                            ++this.loginScreenCursorPos;
                            this.login(s, s1, flag);
                            return;
                        }

                        this.loginMessage1 = "@blu@No response from loginserver";
                        this.loginMessage2 = "@blu@Please wait 1 minute and try again.";
                        return;
                    }

                    this.loginMessage1 = "@blu@No response from server";
                    this.loginMessage2 = "@blu@Please try using a different world.";
                    return;
                }

                if (k == 22) {
                    this.loginMessage1 = "";
                    this.loginMessage2 = "@blu@Error Connecting to Server.";
                    return;
                }

                System.out.println("response:" + k);
                this.loginMessage1 = "@blu@Unexpected server response";
                this.loginMessage2 = "@blu@Please try using a different world.";
                return;
            }

            for (var18 = this.aRSSocket_1168.method268(); var18 >= 0; --var18) {
                this.loginMessage1 = "@gre@You have only just left another world";
                this.loginMessage2 = "@gre@Your profile will be transferred in: " + var18 + " seconds";
                this.drawLoginScreen(true);

                try {
                    Thread.sleep(1000L);
                } catch (Exception var14) {
                }
            }

            this.login(s, s1, flag);
            return;
        } catch (IOException var16) {
            this.loginMessage1 = "";
        } catch (Exception var17) {
            var17.printStackTrace();
        }

        this.loginMessage2 = "@blu@Error Connecting to Server.";
    }

    public final boolean doWalkTo(int i, int j, int k, int i1, int j1, int k1, int l1, int i2, int j2,
                                  boolean flag, int k2) {
        byte byte0 = 104;
        byte byte1 = 104;

        int j3;
        int k3;
        for (j3 = 0; j3 < byte0; ++j3) {
            for (k3 = 0; k3 < byte1; ++k3) {
                this.anIntArrayArray901[j3][k3] = 0;
                this.anIntArrayArray825[j3][k3] = 99999999;
            }
        }

        j3 = j2;
        k3 = j1;
        this.anIntArrayArray901[j2][j1] = 99;
        this.anIntArrayArray825[j2][j1] = 0;
        byte l3 = 0;
        int i4 = 0;
        this.anIntArray1280[l3] = j2;
        int var27 = l3 + 1;
        this.anIntArray1281[l3] = j1;
        boolean flag1 = false;
        int j4 = this.anIntArray1280.length;
        int[][] ai = this.aClass11Array1230[this.plane].anIntArrayArray294;

        int l5;
        while (i4 != var27) {
            j3 = this.anIntArray1280[i4];
            k3 = this.anIntArray1281[i4];
            i4 = (i4 + 1) % j4;
            if (j3 == k2 && k3 == i2) {
                flag1 = true;
                break;
            }

            if (i1 != 0) {
                if ((i1 < 5 || i1 == 10) && this.aClass11Array1230[this.plane].method219(k2, j3, k3, j, i1 - 1, i2)) {
                    flag1 = true;
                    break;
                }

                if (i1 < 10 && this.aClass11Array1230[this.plane].method220(k2, i2, k3, i1 - 1, j, j3)) {
                    flag1 = true;
                    break;
                }
            }

            if (k1 != 0 && k != 0 && this.aClass11Array1230[this.plane].method221(i2, k2, j3, k, l1, k1, k3)) {
                flag1 = true;
                break;
            }

            l5 = this.anIntArrayArray825[j3][k3] + 1;
            if (j3 > 0 && this.anIntArrayArray901[j3 - 1][k3] == 0 && (ai[j3 - 1][k3] & 19398920) == 0) {
                this.anIntArray1280[var27] = j3 - 1;
                this.anIntArray1281[var27] = k3;
                var27 = (var27 + 1) % j4;
                this.anIntArrayArray901[j3 - 1][k3] = 2;
                this.anIntArrayArray825[j3 - 1][k3] = l5;
            }

            if (j3 < byte0 - 1 && this.anIntArrayArray901[j3 + 1][k3] == 0 && (ai[j3 + 1][k3] & 19399040) == 0) {
                this.anIntArray1280[var27] = j3 + 1;
                this.anIntArray1281[var27] = k3;
                var27 = (var27 + 1) % j4;
                this.anIntArrayArray901[j3 + 1][k3] = 8;
                this.anIntArrayArray825[j3 + 1][k3] = l5;
            }

            if (k3 > 0 && this.anIntArrayArray901[j3][k3 - 1] == 0 && (ai[j3][k3 - 1] & 19398914) == 0) {
                this.anIntArray1280[var27] = j3;
                this.anIntArray1281[var27] = k3 - 1;
                var27 = (var27 + 1) % j4;
                this.anIntArrayArray901[j3][k3 - 1] = 1;
                this.anIntArrayArray825[j3][k3 - 1] = l5;
            }

            if (k3 < byte1 - 1 && this.anIntArrayArray901[j3][k3 + 1] == 0 && (ai[j3][k3 + 1] & 19398944) == 0) {
                this.anIntArray1280[var27] = j3;
                this.anIntArray1281[var27] = k3 + 1;
                var27 = (var27 + 1) % j4;
                this.anIntArrayArray901[j3][k3 + 1] = 4;
                this.anIntArrayArray825[j3][k3 + 1] = l5;
            }

            if (j3 > 0 && k3 > 0 && this.anIntArrayArray901[j3 - 1][k3 - 1] == 0 && (ai[j3 - 1][k3 - 1] & 19398926) == 0
                    && (ai[j3 - 1][k3] & 19398920) == 0 && (ai[j3][k3 - 1] & 19398914) == 0) {
                this.anIntArray1280[var27] = j3 - 1;
                this.anIntArray1281[var27] = k3 - 1;
                var27 = (var27 + 1) % j4;
                this.anIntArrayArray901[j3 - 1][k3 - 1] = 3;
                this.anIntArrayArray825[j3 - 1][k3 - 1] = l5;
            }

            if (j3 < byte0 - 1 && k3 > 0 && this.anIntArrayArray901[j3 + 1][k3 - 1] == 0
                    && (ai[j3 + 1][k3 - 1] & 19399043) == 0 && (ai[j3 + 1][k3] & 19399040) == 0
                    && (ai[j3][k3 - 1] & 19398914) == 0) {
                this.anIntArray1280[var27] = j3 + 1;
                this.anIntArray1281[var27] = k3 - 1;
                var27 = (var27 + 1) % j4;
                this.anIntArrayArray901[j3 + 1][k3 - 1] = 9;
                this.anIntArrayArray825[j3 + 1][k3 - 1] = l5;
            }

            if (j3 > 0 && k3 < byte1 - 1 && this.anIntArrayArray901[j3 - 1][k3 + 1] == 0
                    && (ai[j3 - 1][k3 + 1] & 19398968) == 0 && (ai[j3 - 1][k3] & 19398920) == 0
                    && (ai[j3][k3 + 1] & 19398944) == 0) {
                this.anIntArray1280[var27] = j3 - 1;
                this.anIntArray1281[var27] = k3 + 1;
                var27 = (var27 + 1) % j4;
                this.anIntArrayArray901[j3 - 1][k3 + 1] = 6;
                this.anIntArrayArray825[j3 - 1][k3 + 1] = l5;
            }

            if (j3 < byte0 - 1 && k3 < byte1 - 1 && this.anIntArrayArray901[j3 + 1][k3 + 1] == 0
                    && (ai[j3 + 1][k3 + 1] & 19399136) == 0 && (ai[j3 + 1][k3] & 19399040) == 0
                    && (ai[j3][k3 + 1] & 19398944) == 0) {
                this.anIntArray1280[var27] = j3 + 1;
                this.anIntArray1281[var27] = k3 + 1;
                var27 = (var27 + 1) % j4;
                this.anIntArrayArray901[j3 + 1][k3 + 1] = 12;
                this.anIntArrayArray825[j3 + 1][k3 + 1] = l5;
            }
        }

        this.anInt1264 = 0;
        int k4;
        int k6;
        int i7;
        if (!flag1) {
            if (flag) {
                l5 = 100;

                for (k4 = 1; k4 < 2; ++k4) {
                    for (k6 = k2 - k4; k6 <= k2 + k4; ++k6) {
                        for (i7 = i2 - k4; i7 <= i2 + k4; ++i7) {
                            if (k6 >= 0 && i7 >= 0 && k6 < 104 && i7 < 104 && this.anIntArrayArray825[k6][i7] < l5) {
                                l5 = this.anIntArrayArray825[k6][i7];
                                j3 = k6;
                                k3 = i7;
                                this.anInt1264 = 1;
                                flag1 = true;
                            }
                        }
                    }

                    if (flag1) {
                        break;
                    }
                }
            }

            if (!flag1) {
                return false;
            }
        }

        byte var28 = 0;
        this.anIntArray1280[var28] = j3;
        i4 = var28 + 1;
        this.anIntArray1281[var28] = k3;
        for (k4 = l5 = this.anIntArrayArray901[j3][k3]; j3 != j2 || k3 != j1; k4 = this.anIntArrayArray901[j3][k3]) {
            if (k4 != l5) {
                l5 = k4;
                this.anIntArray1280[i4] = j3;
                this.anIntArray1281[i4++] = k3;
            }

            if ((k4 & 2) != 0) {
                ++j3;
            } else if ((k4 & 8) != 0) {
                --j3;
            }

            if ((k4 & 1) != 0) {
                ++k3;
            } else if ((k4 & 4) != 0) {
                --k3;
            }
        }

        if (i4 <= 0) {
            return i != 1;
        } else {
            k4 = i4;
            if (i4 > 25) {
                k4 = 25;
            }

            --i4;
            k6 = this.anIntArray1280[i4];
            i7 = this.anIntArray1281[i4];
            anInt1288 += k4;
            if (anInt1288 >= 92) {
                stream.createFrame(36);
                stream.method402(0);
                anInt1288 = 0;
            }

            if (i == 0) {
                stream.createFrame(164);
                stream.writeByte(k4 + k4 + 3);
            }

            if (i == 1) {
                stream.createFrame(248);
                stream.writeByte(k4 + k4 + 3 + 14);
            }

            if (i == 2) {
                stream.createFrame(98);
                stream.writeByte(k4 + k4 + 3);
            }

            stream.method433(k6 + this.baseX);
            this.destX = this.anIntArray1280[0];
            this.destY = this.anIntArray1281[0];

            for (int j7 = 1; j7 < k4; ++j7) {
                --i4;
                stream.writeByte(this.anIntArray1280[i4] - k6);
                stream.writeByte(this.anIntArray1281[i4] - i7);
            }

            stream.method431(i7 + this.baseY);
            stream.method424(super.anIntArray30[5] != 1 ? 0 : 1, 0);
            return true;
        }
    }

    private final void method86(int i, Buffer stream, boolean flag) {
        for (int j = 0; j < this.anInt893; ++j) {
            int k = this.anIntArray894[j];
            Npc npc = this.npcArray[k];
            int l = stream.readUnsignedByte();
            int l1;
            int k2;
            if ((l & 16) != 0) {
                l1 = stream.method434();
                if (l1 == '\uffff') {
                    l1 = -1;
                }

                k2 = stream.readUnsignedByte();
                if (l1 == npc.anim && l1 != -1) {
                    int l2 = Animation.anims[l1].replayMode;
                    if (l2 == 1) {
                        npc.anInt1527 = 0;
                        npc.anInt1528 = 0;
                        npc.anInt1529 = k2;
                        npc.anInt1530 = 0;
                    }

                    if (l2 == 2) {
                        npc.anInt1530 = 0;
                    }
                } else if (l1 == -1 || npc.anim == -1
                        || Animation.anims[l1].forcedwalkingPrecedence >= Animation.anims[npc.anim].forcedwalkingPrecedence) {
                    npc.anim = l1;
                    npc.anInt1527 = 0;
                    npc.anInt1528 = 0;
                    npc.anInt1529 = k2;
                    npc.anInt1530 = 0;
                    npc.anInt1542 = npc.smallXYIndex;
                }
            }

            if ((l & 8) != 0) {
                l1 = stream.method426(0);
                k2 = stream.method427();
                npc.method447(k2, l1, loopCycle);
                npc.anInt1532 = loopCycle + 300;
                npc.maxHealth = stream.readUnsignedWord();
                npc.currentHealth = stream.readUnsignedWord();
            }

            if ((l & 128) != 0) {
                npc.anInt1520 = stream.readUnsignedWord();
                l1 = stream.readInt();
                npc.anInt1524 = l1 >> 16;
                npc.anInt1523 = loopCycle + (l1 & '\uffff');
                npc.anInt1521 = 0;
                npc.anInt1522 = 0;
                if (npc.anInt1523 > loopCycle) {
                    npc.anInt1521 = -1;
                }

                if (npc.anInt1520 == '\uffff') {
                    npc.anInt1520 = -1;
                }
            }

            if ((l & 32) != 0) {
                npc.interactingEntity = stream.readUnsignedWord();
                if (npc.interactingEntity == '\uffff') {
                    npc.interactingEntity = -1;
                }
            }

            if ((l & 1) != 0) {
                npc.aString1506 = stream.method415();
                npc.textCycle = 100;
            }

            if ((l & 64) != 0) {
                l1 = stream.method427();
                k2 = stream.method428();
                npc.method447(k2, l1, loopCycle);
                npc.anInt1532 = loopCycle + 300;
                npc.maxHealth = stream.readUnsignedWord();
                npc.currentHealth = stream.readUnsignedWord();
            }

            if ((l & 2) != 0) {
                npc.desc = NpcDefinition.lookup(stream.method436());
                npc.anInt1540 = npc.desc.spaceOccupied;
                npc.anInt1504 = npc.desc.rotation;
                npc.anInt1554 = npc.desc.walkingAnimation;
                npc.anInt1555 = npc.desc.halfTurnAnimation;
                npc.anInt1556 = npc.desc.quarterClockwiseTurnAnimation;
                npc.anInt1557 = npc.desc.quarterAnticlockwiseTurnAnimation;
                npc.anInt1511 = npc.desc.standingAnimation;
            }

            if ((l & 4) != 0) {
                npc.anInt1538 = stream.method434();
                npc.anInt1539 = stream.method434();
            }
        }

        loggedIn &= flag;
    }

    public final void buildAtNPCMenu(NpcDefinition class5, int i, int j, int k) {
        if (this.menuActionRow < 400) {
            if (class5.morphisms != null) {
                class5 = class5.method161();
            }

            if (class5 != null && class5.aBoolean84) {
                String s = class5.name;
                if (class5.combatLevel != 0) {
                    s = s + combatDiffColor(myPlayer.combatLevel, class5.combatLevel) + " (level-" + class5.combatLevel
                            + ")";
                }

                if (this.itemSelected == 1) {
                    this.menuActionName[this.menuActionRow] = "Use " + this.aString1286 + " with <col=ffff00>" + s;
                    this.menuActionID[this.menuActionRow] = 582;
                    this.menuActionCmd1[this.menuActionRow] = i;
                    this.menuActionCmd2[this.menuActionRow] = k;
                    this.menuActionCmd3[this.menuActionRow] = j;
                    ++this.menuActionRow;
                } else if (this.spellSelected == 1) {
                    if ((this.anInt1138 & 2) == 2) {
                        this.menuActionName[this.menuActionRow] = this.aString1139 + " <col=ffff00>" + s;
                        this.menuActionID[this.menuActionRow] = 413;
                        this.menuActionCmd1[this.menuActionRow] = i;
                        this.menuActionCmd2[this.menuActionRow] = k;
                        this.menuActionCmd3[this.menuActionRow] = j;
                        ++this.menuActionRow;
                        return;
                    }
                } else {
                    int i1;
                    if (class5.actions != null) {
                        for (i1 = 4; i1 >= 0; --i1) {
                            if (class5.actions[i1] != null && !class5.actions[i1].equalsIgnoreCase("attack")) {
                                this.menuActionName[this.menuActionRow] = class5.actions[i1] + " <col=ffff00>" + s;
                                if (i1 == 0) {
                                    this.menuActionID[this.menuActionRow] = 20;
                                }

                                if (i1 == 1) {
                                    this.menuActionID[this.menuActionRow] = 412;
                                }

                                if (i1 == 2) {
                                    this.menuActionID[this.menuActionRow] = 225;
                                }

                                if (i1 == 3) {
                                    this.menuActionID[this.menuActionRow] = 965;
                                }

                                if (i1 == 4) {
                                    this.menuActionID[this.menuActionRow] = 478;
                                }

                                this.menuActionCmd1[this.menuActionRow] = i;
                                this.menuActionCmd2[this.menuActionRow] = k;
                                this.menuActionCmd3[this.menuActionRow] = j;
                                ++this.menuActionRow;
                            }
                        }
                    }

                    if (class5.actions != null) {
                        for (i1 = 4; i1 >= 0; --i1) {
                            if (class5.actions[i1] != null && class5.actions[i1].equalsIgnoreCase("attack")) {
                                short c = 0;
                                if (class5.combatLevel > myPlayer.combatLevel) {
                                    c = 2000;
                                }

                                this.menuActionName[this.menuActionRow] = class5.actions[i1] + " <col=ffff00>" + s;
                                if (i1 == 0) {
                                    this.menuActionID[this.menuActionRow] = 20 + c;
                                }

                                if (i1 == 1) {
                                    this.menuActionID[this.menuActionRow] = 412 + c;
                                }

                                if (i1 == 2) {
                                    this.menuActionID[this.menuActionRow] = 225 + c;
                                }

                                if (i1 == 3) {
                                    this.menuActionID[this.menuActionRow] = 965 + c;
                                }

                                if (i1 == 4) {
                                    this.menuActionID[this.menuActionRow] = 478 + c;
                                }

                                this.menuActionCmd1[this.menuActionRow] = i;
                                this.menuActionCmd2[this.menuActionRow] = k;
                                this.menuActionCmd3[this.menuActionRow] = j;
                                ++this.menuActionRow;
                            }
                        }
                    }

                    if (this.myPrivilege == 2 || this.myPrivilege == 9 || this.myPrivilege == 10
                            || this.myPrivilege == 4) {
                        this.menuActionName[this.menuActionRow] = "Examine <col=ffff00>" + s + "<col=65280>(@whi@" + class5.aLong78
                                + "<col=65280>)";
                    } else {
                        this.menuActionName[this.menuActionRow] = "Examine <col=ffff00>" + s;
                    }

                    this.menuActionID[this.menuActionRow] = 1025;
                    this.menuActionCmd1[this.menuActionRow] = i;
                    this.menuActionCmd2[this.menuActionRow] = k;
                    this.menuActionCmd3[this.menuActionRow] = j;
                    ++this.menuActionRow;
                }
            }
        }

    }

    public final void method88(int i, int j, Player player, boolean flag, int k) {
        if (player != myPlayer && this.menuActionRow < 400 && !flag) {
            String s;
            if (player.skill == 0)
                s = playerTitle.placement(player.name, playerTitle.title(player.title, player)) + combatDiffColor(myPlayer.combatLevel, player.combatLevel) + " (level-" + player.combatLevel + ")";
            else
                s = playerTitle.placement(player.name, playerTitle.title(player.title, player)) + " (skill-" + player.skill + ")";

            int i1;
            if (this.itemSelected == 1) {
                this.menuActionName[this.menuActionRow] = "Use " + this.aString1286 + " with @whi@" + s;
                this.menuActionID[this.menuActionRow] = 491;
                this.menuActionCmd1[this.menuActionRow] = j;
                this.menuActionCmd2[this.menuActionRow] = i;
                this.menuActionCmd3[this.menuActionRow] = k;
                ++this.menuActionRow;
            } else if (this.spellSelected == 1) {
                if ((this.anInt1138 & 8) == 8) {
                    this.menuActionName[this.menuActionRow] = this.aString1139 + " @whi@" + s;
                    this.menuActionID[this.menuActionRow] = 365;
                    this.menuActionCmd1[this.menuActionRow] = j;
                    this.menuActionCmd2[this.menuActionRow] = i;
                    this.menuActionCmd3[this.menuActionRow] = k;
                    ++this.menuActionRow;
                }
            } else {
                for (i1 = 4; i1 >= 0; --i1) {
                    if (this.aStringArray1127[i1] != null) {
                        this.menuActionName[this.menuActionRow] = this.aStringArray1127[i1] + " @whi@" + s;
                        short c = 0;
                        if (this.aStringArray1127[i1].equalsIgnoreCase("attack")) {
                            if (player.combatLevel > myPlayer.combatLevel) {
                                c = 2000;
                            }

                            if (myPlayer.anInt1701 != 0 && player.anInt1701 != 0) {
                                if (myPlayer.anInt1701 == player.anInt1701) {
                                    c = 2000;
                                } else {
                                    c = 0;
                                }
                            }
                        } else if (this.aBooleanArray1128[i1]) {
                            c = 2000;
                        }

                        if (i1 == 0) {
                            this.menuActionID[this.menuActionRow] = 561 + c;
                        }

                        if (i1 == 1) {
                            this.menuActionID[this.menuActionRow] = 779 + c;
                        }

                        if (i1 == 2) {
                            this.menuActionID[this.menuActionRow] = 27 + c;
                        }

                        if (i1 == 3) {
                            this.menuActionID[this.menuActionRow] = 577 + c;
                        }

                        if (i1 == 4) {
                            this.menuActionID[this.menuActionRow] = 729 + c;
                        }

                        this.menuActionCmd1[this.menuActionRow] = j;
                        this.menuActionCmd2[this.menuActionRow] = i;
                        this.menuActionCmd3[this.menuActionRow] = k;
                        ++this.menuActionRow;
                    }
                }
            }

            for (i1 = 0; i1 < this.menuActionRow; ++i1) {
                if (this.menuActionID[i1] == 516) {
                    this.menuActionName[i1] = "Walk here @whi@" + s;
                    return;
                }
            }
        }

    }

    private final void method89(boolean flag, Class30_Sub1 class30_sub1) {
        int i = 0;
        int j = -1;
        int k = 0;
        int l = 0;
        if (class30_sub1.anInt1296 == 0) {
            i = this.worldController.method300(class30_sub1.anInt1295, class30_sub1.anInt1297, class30_sub1.anInt1298);
        }

        if (class30_sub1.anInt1296 == 1) {
            i = this.worldController.method301(class30_sub1.anInt1295, class30_sub1.anInt1297,
                    class30_sub1.anInt1298);
        }

        if (class30_sub1.anInt1296 == 2) {
            i = this.worldController.method302(class30_sub1.anInt1295, class30_sub1.anInt1297, class30_sub1.anInt1298);
        }

        if (class30_sub1.anInt1296 == 3) {
            i = this.worldController.method303(class30_sub1.anInt1295, class30_sub1.anInt1297, class30_sub1.anInt1298);
        }

        int j1;
        if (i != 0) {
            j1 = this.worldController.method304(class30_sub1.anInt1295, class30_sub1.anInt1297, class30_sub1.anInt1298,
                    i);
            j = i >> 14 & 32767;
            k = j1 & 31;
            l = j1 >> 6;
        }

        class30_sub1.anInt1299 = j;
        class30_sub1.anInt1301 = k;
        if (flag) {
            for (j1 = 1; j1 > 0; ++j1) {
            }
        }

        class30_sub1.anInt1300 = l;
    }

    private void method90() {
        for (int i = 0; i < this.anInt1062; ++i) {
            if (this.anIntArray1250[i] > 0) {
                --this.anIntArray1250[i];
            } else {
                boolean flag1 = false;

                try {
                    Buffer j = Sounds.method241(this.anIntArray1241[i], this.anIntArray1207[i]);
                    new SoundPlayer(new ByteArrayInputStream(j.buffer, 0, j.currentOffset), this.soundVolume[i],
                            this.anIntArray1250[i]);
                    if (System.currentTimeMillis() + (long) (j.currentOffset / 22) > this.aLong1172
                            + (long) (this.anInt1257 / 22)) {
                        this.anInt1257 = j.currentOffset;
                        this.aLong1172 = System.currentTimeMillis();
                    }
                } catch (Exception var4) {
                    var4.printStackTrace();
                }

                if (flag1 && this.anIntArray1250[i] != -5) {
                    this.anIntArray1250[i] = -5;
                } else {
                    --this.anInt1062;

                    for (int var5 = i; var5 < this.anInt1062; ++var5) {
                        this.anIntArray1207[var5] = this.anIntArray1207[var5 + 1];
                        this.anIntArray1241[var5] = this.anIntArray1241[var5 + 1];
                        this.anIntArray1250[var5] = this.anIntArray1250[var5 + 1];
                        this.soundVolume[var5] = this.soundVolume[var5 + 1];
                    }

                    --i;
                }
            }
        }

        if (this.prevSong > 0) {
            this.prevSong -= 20;
            if (this.prevSong < 0) {
                this.prevSong = 0;
            }

            if (this.prevSong == 0 && this.musicEnabled && !lowMem) {
                this.nextSong = this.currentSong;
                this.songChanging = true;
                onDemandFetcher.method558(2, this.nextSong);
            }
        }

    }

    public void playSound(int id, int type, int delay, int volume) {
        this.anIntArray1207[this.anInt1062] = id;
        this.anIntArray1241[this.anInt1062] = type;
        this.anIntArray1250[this.anInt1062] = delay + Sounds.anIntArray326[id];
        this.soundVolume[this.anInt1062] = volume;
        ++this.anInt1062;
    }

    public void playSong(int id) {
        if (id != this.currentSong && this.musicEnabled && !lowMem && this.prevSong == 0) {
            this.nextSong = id;
            this.songChanging = true;
            onDemandFetcher.method558(2, this.nextSong);
            this.currentSong = id;
        }

    }

    public void playQuickSong(int id, int time) {
        if (this.musicEnabled && !lowMem) {
            this.nextSong = id;
            this.songChanging = false;
            onDemandFetcher.method558(2, this.nextSong);
            this.prevSong = time;
        }

    }

    public void drawStatusBox(String var0, boolean var1) {
        byte var2 = 4;
        int var3 = var2 + 6;
        int var4 = var2 + 6;
        int var5 = regularText.method383(250, var0);
        int var6 = regularText.method383(250, var0) * 13;
        DrawingArea.Rasterizer2D_fillRectangle(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var6 + var2, 0);
        DrawingArea.drawRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6, 16777215);
        // BaseVarType.font_p12full.method4895(var0, var3, var4, var5, var6,
        // 16777215, -1, 1, 1, 0);
        // WorldMapData.method381(var3 - var2, var4 - var2, var2 + var5 + var2,
        // var2 + var6 + var2);

    }

    public void method6() {
        this.drawLoadingText(20, "Starting up");
        CacheDownloader.start(this, CacheDownloader.FileType.CACHE);
        CacheDownloader.start(this, CacheDownloader.FileType.MODELS);
        CacheDownloader.start(this, CacheDownloader.FileType.FILEDATA);
        CacheDownloader.start(this, CacheDownloader.FileType.SOUNDS);
        if (SignLink.sunjava) {
            super.anInt6 = 5;
        }

        if (aBoolean993) {
            this.aBoolean1252 = true;
        } else {
            aBoolean993 = true;
            this.getDocumentBaseHost();
            if (SignLink.cache_dat != null) {
                for (int var23 = 0; var23 < Constants.IndexAmount; ++var23) {
                    this.Indexes[var23] = new Decompressor(SignLink.cache_dat, SignLink.cache_idx[var23],
                            var23 + 1);
                }
            }

            try {
                this.titleStreamLoader = this.createArchive(JagGrab.TITLE_CRC, "title screen", "title", JagGrab.CRCs[JagGrab.TITLE_CRC],
                        25);
                this.smallText = new TextDrawingArea(false, "p11_full", 0, this.titleStreamLoader);
                this.regularText = new TextDrawingArea(false, "p12_full", 0, this.titleStreamLoader);
                this.boldText = new TextDrawingArea(false, "b12_full", 0, this.titleStreamLoader);
                this.fencyText = new TextDrawingArea(true, "q8_full", 0, this.titleStreamLoader);
                this.newSmallFont = new RSFont(false, "p11_full", this.titleStreamLoader);
                this.newRegularFont = new RSFont(false, "p12_full", this.titleStreamLoader);
                this.newBoldFont = new RSFont(false, "b12_full", this.titleStreamLoader);
                this.newFancyFont = new RSFont(true, "q8_full", this.titleStreamLoader);
                this.newSmallFont.unpackChatImages(this.ModIcons);
                this.newRegularFont.unpackChatImages(this.ModIcons);
                this.newBoldFont.unpackChatImages(this.ModIcons);
                this.newFancyFont.unpackChatImages(this.ModIcons);
                this.method56(0);
                this.loadTitleScreen();
                StreamLoader var24 = this.createArchive(JagGrab.CONFIG_CRC, "config", "config", JagGrab.CRCs[JagGrab.CONFIG_CRC], 30);
                StreamLoader class44_1 = this.createArchive(JagGrab.INTERFACE_CRC, "interface", "interface", JagGrab.CRCs[JagGrab.INTERFACE_CRC],
                        35);
                StreamLoader class44_2 = this.createArchive(JagGrab.MEDIA_CRC, "2d graphics", "media", JagGrab.CRCs[JagGrab.MEDIA_CRC],
                        40);
                StreamLoader class44_3 = this.createArchive(JagGrab.TEXTURES_CRC, "textures", "textures", JagGrab.CRCs[JagGrab.TEXTURES_CRC],
                        45);
                StreamLoader class44_4 = this.createArchive(JagGrab.CHAT_CRC, "chat system", "wordenc", JagGrab.CRCs[JagGrab.CHAT_CRC],
                        50);
                StreamLoader class44_5 = this.createArchive(JagGrab.SOUNDS_CRC, "sound effects", "sounds", JagGrab.CRCs[JagGrab.SOUNDS_CRC],
                        55);
                this.byteGroundArray = new byte[4][104][104];
                this.anIntArrayArrayArray1214 = new int[4][105][105];
                this.worldController = new WorldController(104, 104, this.anIntArrayArrayArray1214, 4);

                for (int var25 = 0; var25 < 4; ++var25) {
                    this.aClass11Array1230[var25] = new CollisionMap();
                }

                this.minimapImage = new Sprite(512, 512);
                StreamLoader var251 = this.createArchive(JagGrab.UPDATE_CRC, "update list", "versionlist", JagGrab.CRCs[JagGrab.UPDATE_CRC],
                        60);
                this.drawLoadingText(60, "Connecting to update server");
                Frame.animationlist = new Frame[5000][0];
                onDemandFetcher = new OnDemandFetcher();
                onDemandFetcher.start(var251, this);
                Model.method459(onDemandFetcher.getModelCount(), onDemandFetcher);
                this.drawLoadingText(80, "Loading Custom Models");
                ModelDecompressor.loadModels();
                //preloadModels();
                if (Constants.repackIndex1) {
                    repackCacheIndex(1);
                }
                if (Constants.repackIndex2) {
                    repackCacheIndex(2);
                }
                if (Constants.repackIndex3) {
                    repackCacheIndex(3);
                }
                if (Constants.repackIndex4) {
                    repackCacheIndex(4);
                }
                if (Constants.repackIndex5) {
                    repackCacheIndex(5);
                }
                if (Constants.repackIndex6) {
                    repackCacheIndex(6);
                }
                if (Constants.DumpIndex1) {
                    dumpCacheIndex(1);
                }
                if (Constants.DumpIndex2) {
                    dumpCacheIndex(2);
                }
                if (Constants.DumpIndex3) {
                    dumpCacheIndex(3);
                }
                if (Constants.DumpIndex4) {
                    dumpCacheIndex(4);
                }
                if (Constants.DumpIndex5) {
                    dumpCacheIndex(5);
                }
                SpriteLoader1.loadSprites();
                cacheSprite1 = SpriteLoader1.sprites;
                SpriteLoader2.loadSprites();
                cacheSprite2 = SpriteLoader2.sprites;
                SpriteLoader3.loadSprites();
                cacheSprite3 = SpriteLoader3.sprites;
                SpriteLoader4.loadSprites();
                cacheSprite4 = SpriteLoader4.sprites;
                this.drawLoadingText(85, "Loading Sprites.");
                SpriteLoader.load474Sprites();
                cacheSprite474 = SpriteLoader.sprites474;
                System.out.println("Welcome to Ghreborn.com");
                this.Mapicon = new Sprite("Minimap/Gen");
                this.frame = new Sprite("frame");
                this.CustomMapback = new Sprite(class44_2, "mapback", 0);
                //this.hporbs = new Background(class44_2, "orbs", 12);
                for (int index = 0; index < skill_sprites.length; index++) {
                    skill_sprites[index] = new Sprite("expdrop/" + index);
                }
                for (int i = 0; i < inputSprites.length; i++)
                    inputSprites[i] = new Sprite("Interfaces/Inputfield/SPRITE " + (i + 1));

                multiOverlay = new Sprite(class44_2, "overlay_multiway", 0);
                this.loadExtraSprites();
                for (int i = 0; i < tabAreaResizable.length; i++)
                    tabAreaResizable[i] = new Sprite("GameframeOsrs/resizable/tabArea " + i);

                loadTabArea();
                if (oldGameframe == false && Gameframe508 == false) {
                    chatArea = new Sprite("GameframeOsrs/chatarea");
                } else if (oldGameframe == false && Gameframe508 == true) {
                    chatArea = new Sprite("Gameframe508/chatarea");
                }
                channelButtons = new Sprite("GameframeOsrs/channelbuttons");
                chatButtons[3] = new Sprite("1025_0");
                Sprite[] clanIcons = new Sprite[9];
                for (int index = 0; index < clanIcons.length; index++) {
                    clanIcons[index] = new Sprite("Clan Chat/Icons/" + index);
                }
    			for (int index = 0; index < smallXpSprites.length; index++) {
    				smallXpSprites[index] = new Sprite("expdrop/" + index);

    			}
                int Sprite;
                for (int i = 0; i <= 1; i++)
                    BlackMap[i] = new Sprite("BlackMap " + i);
                for (Sprite = 0; Sprite < 70; ++Sprite) {
                    this.gameframe[Sprite] = new Sprite("Gameframe/gameframe " + Sprite);
                }
    			File[] file = new File(SignLink.findcachedir() + "/sprites/sprites/").listFiles();
    			int size = file.length;
    			cacheSprite5 = new Sprite[size];
    			for (int i = 0; i < size; i++) {
    				cacheSprite5[i] = new Sprite("Sprites/" + i);
    			}
                this.compass = new Sprite("COMPASS 0");
                this.aSprite_1001 = new Sprite(class44_2, "mapedge", 0);
                this.aSprite_1001.method345(5059);

                try {
                    for (Sprite = 0; Sprite < 300; ++Sprite) {
                        this.aBackgroundArray1060[Sprite] = new Sprite("mapscene/317_" + Sprite);
                    }
                } catch (Exception var22) {
                }

                try {
                    for (Sprite = 0; Sprite < 700; ++Sprite) {
                        this.MapFunction[Sprite] = new Sprite(class44_2, "mapfunction", Sprite);
                    }
                } catch (Exception var21) {
                }

                try {
                    for (Sprite = 0; Sprite < 20; ++Sprite) {
                        this.aSpriteArray987[Sprite] = new Sprite(class44_2, "hitmarks", Sprite);
                    }
                } catch (Exception var20) {
                }
                try {
                    for (int h1 = 0; h1 < 6; h1++)
                        headIconsHint[h1] = new Sprite(class44_2, "headicons_hint", h1);
                } catch (Exception _ex) {
                }
                try {
                    for (Sprite = 0; Sprite < 8; ++Sprite) {
                        this.headIcons[Sprite] = new Sprite(class44_2, "headicons_prayer", Sprite);
                    }

                    for (Sprite = 0; Sprite < 3; ++Sprite) {
                        this.skullIcons[Sprite] = new Sprite(class44_2, "headicons_pk", Sprite);
                    }
                } catch (Exception var19) {
                }

                this.aSprite_870 = new Sprite(class44_2, "mapmarker", 0);
                this.aSprite_871 = new Sprite(class44_2, "mapmarker", 1);

                for (Sprite = 0; Sprite < 8; ++Sprite) {
                    this.aSpriteArray1150[Sprite] = new Sprite(class44_2, "cross", Sprite);
                }

                this.aSprite_1074 = new Sprite(class44_2, "mapdots", 0);
                this.aSprite_1075 = new Sprite(class44_2, "mapdots", 1);
                this.aSprite_1076 = new Sprite(class44_2, "mapdots", 2);
                this.aSprite_1077 = new Sprite(class44_2, "mapdots", 3);
                this.aSprite_1078 = new Sprite(class44_2, "mapdots", 4);
                this.scrollBar1 = new Sprite(class44_2, "scrollbar", 0);
                this.scrollBar2 = new Sprite(class44_2, "scrollbar", 1);
                scrollBar3 = new Sprite("/Interfaces/skillguide/skillGude 3");
                scrollBar4 = new Sprite("/Interfaces/skillguide/skillGude 4");
                RSFont.unpackImages(ModIcons, clanIcons);
                flip = true;
                flip = false;
                flip_s = true;
                this.aBackground_867 = new Background(class44_2, "redstone3", 0);
                flip_s = false;
                flip_r = true;
                this.aBackground_867.method359(true);
                this.aSprite_868 = new Sprite(class44_2, "redstone1", 0);
                this.aBackground_869 = new Background(class44_2, "redstone2", 0);
                this.aBackground_869.method358(0);
                this.aBackground_869.method359(true);

                for (Sprite = 0; Sprite < 26; ++Sprite) {
                    this.ModIcons[Sprite] = new Sprite("player/icon " + Sprite);
                }
                for (int index = 0; index < GameTimerHandler.TIMER_IMAGES.length; index++) {
                    GameTimerHandler.TIMER_IMAGES[index] = new Sprite("GameTimer/TIMER " + index);
                }
                Sprite var28 = new Sprite(class44_2, "backleft1", 0);
                this.aRSImageProducer_903 = new RSImageProducer(var28.myWidth, var28.myHeight, getGameComponent());
                var28.method346(0, 0);
                var28 = new Sprite(class44_2, "backleft2", 0);
                this.aRSImageProducer_904 = new RSImageProducer(var28.myWidth, var28.myHeight, getGameComponent());
                var28.method346(0, 0);
                var28 = new Sprite(class44_2, "backright1", 0);
                this.aRSImageProducer_905 = new RSImageProducer(var28.myWidth, var28.myHeight, getGameComponent());
                var28.method346(0, 0);
                var28 = new Sprite(class44_2, "backright2", 0);
                this.aRSImageProducer_906 = new RSImageProducer(var28.myWidth, var28.myHeight, getGameComponent());
                var28.method346(0, 0);
                var28 = new Sprite(class44_2, "backtop1", 0);
                this.aRSImageProducer_907 = new RSImageProducer(var28.myWidth, var28.myHeight, getGameComponent());
                var28.method346(0, 0);
                var28 = new Sprite(class44_2, "backvmid1", 0);
                this.aRSImageProducer_908 = new RSImageProducer(var28.myWidth, var28.myHeight, getGameComponent());
                var28.method346(0, 0);
                var28 = new Sprite(class44_2, "backvmid2", 0);
                this.aRSImageProducer_909 = new RSImageProducer(var28.myWidth, var28.myHeight, getGameComponent());
                var28.method346(0, 0);
                var28 = new Sprite(class44_2, "backvmid3", 0);
                this.aRSImageProducer_910 = new RSImageProducer(var28.myWidth, var28.myHeight, getGameComponent());
                var28.method346(0, 0);
                var28 = new Sprite(class44_2, "backhmid2", 0);
                this.aRSImageProducer_911 = new RSImageProducer(var28.myWidth, var28.myHeight, getGameComponent());
                var28.method346(0, 0);
                int i5 = (int) (Math.random() * 21.0D) - 10;
                int j5 = (int) (Math.random() * 21.0D) - 10;
                int k5 = (int) (Math.random() * 21.0D) - 10;
                int l5 = (int) (Math.random() * 41.0D) - 20;

                for (int var27 = 0; var27 < 300; ++var27) {
                    if (this.MapFunction[var27] != null) {
                        this.MapFunction[var27].method344(i5 + l5, j5 + l5, k5 + l5, 0);
                    }

                    if (this.aBackgroundArray1060[var27] != null) {
                        this.aBackgroundArray1060[var27].method344(i5 + l5, j5 + l5, k5 + l5, 0);
                    }
                }

                this.drawLoadingText(83, "Unpacking textures");
                Rasterizer.method368(class44_3);
                Rasterizer.method372(0.8D);
                Rasterizer.method367();
                this.drawLoadingText(86, "Unpacking Animation config");
                Animation.method257(0, var24);
                this.drawLoadingText(87, "Unpacking Obj/Npc/Item/Player config");
                ObjectDefinition.method576(var24);
                ItemDefinition.init(var24);
                NpcDefinition.method162(var24);
                IdentityKit.init(var24);
                Graphic.unpackConfig(var24);
                PlayerTitles.unpack();
                this.drawLoadingText(86, "Unpacking Maps config");
                Varp.unpackConfig(var24);
                FloorDefinition.unpackConfig(var24);
                VarBit.method533(var24);
                ItemDefinition.aBoolean182 = isMembers;
                if (!lowMem) {
                    this.drawLoadingText(90, "Unpacking sounds");
                    byte[] var26 = class44_5.readFile("sounds.dat");
                    Buffer j7 = new Buffer(var26, 891);
                    Sounds.method240(0, j7);
                }
               // this.drawLoadingText(93, "Unpacking 179 sounds");
                //SoundLoader.preloadSounds();
                this.drawLoadingText(95, "Unpacking 317/474 interfaces");
                /*
                 * RSFont[] var271 = new RSFont[] { this.smallText, this.regularText,
                 * this.boldText, this.fencyText };
                 */
                RSFont[] rsFont = {newSmallFont, newRegularFont, newBoldFont, newFancyFont};
                Widget.unpack(class44_1, rsFont, class44_2);
                this.drawLoadingText(100, "Preparing game engine");
                if (oldGameframe == false && Gameframe508 == false) {
                    mapBack = new Sprite("GameframeOsrs/fixed/mapBack");
                } else if (oldGameframe == true && Gameframe508 == false) {
                    mapBack = new Sprite("Gameframe317/fixed/mapBack");
                } else if (oldGameframe == false && Gameframe508 == true) {
                    mapBack = new Sprite("Gameframe508/fixed/mapBack");
                }
                for (int pixelY = 0; pixelY < 33; pixelY++) {
                    int k6 = 999;
                    int i7 = 0;
                    for (int pixelX = 0; pixelX < 34; pixelX++) {
                        if (mapBack.myPixels[pixelX + pixelY * mapBack.myWidth] == 0) {
                            if (k6 == 999)
                                k6 = pixelX;
                            continue;
                        }
                        if (k6 == 999)
                            continue;
                        i7 = pixelX;
                        break;
                    }
                    anIntArray968[pixelY] = k6;
                    anIntArray1057[pixelY] = i7 - k6;
                }
                for (int pixelY = 1; pixelY < 153; pixelY++) {
                    int j7 = 999;
                    int l7 = 0;
                    for (int pixelX = 24; pixelX < 177; pixelX++) {
                        if (mapBack.myPixels[pixelX + pixelY * mapBack.myWidth] == 0 && (pixelX > 34 || pixelY > 34)) {
                            if (j7 == 999) {
                                j7 = pixelX;
                            }
                            continue;
                        }
                        if (j7 == 999) {
                            continue;
                        }
                        l7 = pixelX;
                        break;
                    }
                    anIntArray1052[pixelY - 1] = j7 - 24;
                    anIntArray1229[pixelY - 1] = l7 - j7;
                }
/*				informationFile.read();
				if (informationFile.isUsernameRemembered()) {
					myUsername = informationFile.getStoredUsername();
				}
				if (informationFile.isRememberRoof()) {
					// removeRoofs = true;
				}
				if (informationFile.isRememberVisibleItemNames()) {
					// groundItemsOn = true;
				}*/
                setBounds();
                Censor.method487(class44_4);
                this.mouseDetection = new MouseDetection(this);
                this.method12(this.mouseDetection, 10);
                Animable_Sub5.aClient1609 = this;
                ObjectDefinition.clientInstance = this;
                NpcDefinition.clientInstance = this;
                loadPlayerData();
                updateSettings();

                //onDemandFetcher.writeAll();
            } catch (Exception var231) {
                var231.printStackTrace();
                SignLink.reporterror("loaderror " + this.aString1049 + " " + this.anInt1079);
                this.aBoolean926 = true;
            }
        }

    }

    private final void method91(Buffer stream, int i, byte byte0) {
        if (byte0 != 8) {
            this.anInt1119 = -50;
        }

        Player player;
        int l;
        int i1;
        int j1;
        for (; stream.anInt1407 + 10 < i * 8; player.method445(myPlayer.smallX[0] + j1,
                myPlayer.smallY[0] + i1, l == 1, false)) {
            int j = stream.method419(11, 0);
            if (j == 2047) {
                break;
            }

            if (this.playerArray[j] == null) {
                this.playerArray[j] = new Player();
                if (this.astreamArray895[j] != null) {
                    this.playerArray[j].method451(this.astreamArray895[j]);
                }
            }

            this.playerIndices[this.playerCount++] = j;
            player = this.playerArray[j];
            player.anInt1537 = loopCycle;
            int k = stream.method419(1, 0);
            if (k == 1) {
                this.anIntArray894[this.anInt893++] = j;
            }

            l = stream.method419(1, 0);
            i1 = stream.method419(5, 0);
            if (i1 > 15) {
                i1 -= 32;
            }

            j1 = stream.method419(5, 0);
            if (j1 > 15) {
                j1 -= 32;
            }
        }

        stream.method420(true);
    }

    public boolean inCircle(int circleX, int circleY, int clickX, int clickY, int radius) {
        return Math.pow((double) (circleX + radius - clickX), 2.0D)
                + Math.pow((double) (circleY + radius - clickY), 2.0D) < Math.pow((double) radius, 2.0D);
    }

    private void teleport(int x, int y) {
        String text = "::tele " + x + " " + y;
        stream.createFrame(103);
        stream.writeWordBigEndian(text.length() - 1);
        stream.writeString(text.substring(2));
    }

    public void processMainScreenClick() {
        if (anInt1021 != 0)
            return;
        if (super.clickMode3 == 1) {
            int i = super.saveClickX - 25 - 547;
            int j = super.saveClickY - 5 - 3;
            if (currentScreenMode != ScreenMode.FIXED) {
                i = super.saveClickX - (currentGameWidth - 182 + 24);
                j = super.saveClickY - 8;
            }
            int l;
            if (this.inCircle(0, 0, i, j, 76) && this.mouseMapPosition() && !this.runHover) {
                i -= 73;
                j -= 75;
                l = this.anInt1185 + this.anInt1209 & 2047;
                int i1 = Rasterizer.anIntArray1470[l];
                int j1 = Rasterizer.anIntArray1471[l];
                i1 = i1 * (this.anInt1170 + 256) >> 8;
                j1 = j1 * (this.anInt1170 + 256) >> 8;
                int k1 = j * i1 + i * j1 >> 11;
                int l1 = j * j1 - i * i1 >> 11;
                int i2 = myPlayer.x + k1 >> 7;
                int j2 = myPlayer.y - l1 >> 7;
                if ((controlIsDown && this.myPrivilege == 9) || (controlIsDown && this.myPrivilege == 2)
                        || (controlIsDown && this.myPrivilege == 10) || (controlIsDown && this.myPrivilege == 4)) {
                    this.teleport(this.baseX + i2, this.baseY + j2);
                } else {
                    boolean flag1 = this.doWalkTo(1, 0, 0, 0, myPlayer.smallY[0], 0, 0, j2, myPlayer.smallX[0],
                            true, i2);
                    if (flag1) {
                        stream.writeByte(i);
                        stream.writeByte(j);
                        stream.method399(this.anInt1185);
                        stream.writeByte(57);
                        stream.writeByte(this.anInt1209);
                        stream.writeByte(this.anInt1170);
                        stream.writeByte(89);
                        stream.method399(myPlayer.x);
                        stream.method399(myPlayer.y);
                        stream.writeByte(this.anInt1264);
                        stream.writeByte(63);
                    }
                }
            }

            ++anInt1117;
            if (anInt1117 > 1151) {
                anInt1117 = 0;
                stream.createFrame(246);
                stream.writeByte(0);
                l = stream.currentOffset;
                if ((int) (Math.random() * 2.0D) == 0) {
                    stream.writeByte(101);
                }

                stream.writeByte(197);
                stream.method399((int) (Math.random() * 65536.0D));
                stream.writeByte((int) (Math.random() * 256.0D));
                stream.writeByte(67);
                stream.method399(14214);
                if ((int) (Math.random() * 2.0D) == 0) {
                    stream.method399(29487);
                }

                stream.method399((int) (Math.random() * 65536.0D));
                if ((int) (Math.random() * 2.0D) == 0) {
                    stream.writeByte(220);
                }

                stream.writeByte(180);
                stream.method407(stream.currentOffset - l, (byte) 0);
            }
        }

    }

    private void render_ground_item_names() {
        for (int x = 0; x < 104; x++) {
            for (int y = 0; y < 104; y++) {
                NodeList node = aClass19ArrayArrayArray827[plane][x][y];
                int offset = 12;
                if (node != null) {
                    for (Item item = (Item) node.method253(5); item != null; item = (Item) node.method255(8)) {
                        ItemDefinition itemDef = ItemDefinition.lookup(item.anInt1558);
                        calcEntityScreenPos((x << 7) + 64, 64, this.anInt875, (y << 7) + 64);
                        newSmallFont.drawCenteredString((itemDef.value >= 0xC350 || item.anInt1559 >= 0x186A0 ? "<col=DA6EA2>" : "<trans=120>") + itemDef.name + (item.anInt1559 > 1 ? "</col> (" + item.anInt1559 + "</col>)" : ""), spriteDrawX, spriteDrawY - offset, 0xffffff, 1);
                        offset += 12;
                    }
                }
            }
        }
    }

    public final String interfaceIntToString(int j) {
        return j < 999999999 ? String.valueOf(j) : "?";
    }

    public final void method94(int i) {
        if (i != -13873) {
            for (int var51 = 1; var51 > 0; ++var51) {
            }
        }

        Graphics var51 = this.getGameComponent().getGraphics();
        var51.setColor(Color.black);
        var51.fillRect(0, 0, 765, 503);
        this.method4(false, 1);
        byte l;
        int var5;
        if (this.aBoolean926) {
            this.aBoolean831 = false;
            var51.setFont(new Font("Helvetica", 1, 16));
            var51.setColor(Color.yellow);
            l = 35;
            var51.drawString("Sorry, an error has occured whilst loading Ghreborn", 30, l);
            var5 = l + 50;
            var51.setColor(Color.white);
            var51.drawString("To fix this try the following (in order):", 30, var5);
            var5 += 50;
            var51.setColor(Color.white);
            var51.setFont(new Font("Helvetica", 1, 12));
            var51.drawString("1: Try reloading the client if its your first time loading it.", 30, var5);
            var5 += 30;
            var51.drawString("2: Try Deleting the cache by going to " + SignLink.findcachedir(), 30, var5);
            var5 += 30;
            var51.drawString("3: If nothing else works for you. contect Sgsrocks on dicord.", 30, var5);
            var5 += 30;
            var51.drawString("4: Try rebooting your computer", 30, var5);
            //var5 += 30;
            //var51.drawString("5: Try selecting a different version of Java from the play-game menu", 30, var5);
        }

        if (this.aBoolean1176) {
            this.aBoolean831 = false;
            var51.setFont(new Font("Helvetica", 1, 20));
            var51.setColor(Color.white);
            var51.drawString("Error - unable to load game!", 50, 50);
            var51.drawString("", 50, 100);
            var51.drawString("", 50, 150);
        }

        if (this.aBoolean1252) {
            this.aBoolean831 = false;
            var51.setColor(Color.yellow);
            l = 35;
            var51.drawString("Error a copy of Ghreborn already appears to be loaded", 30, l);
            var5 = l + 50;
            var51.setColor(Color.white);
            var51.drawString("To fix this try the following (in order):", 30, var5);
            var5 += 50;
            var51.setColor(Color.white);
            var51.setFont(new Font("Helvetica", 1, 12));
            var51.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, var5);
            var5 += 30;
            var51.drawString("2: Try rebooting your computer, and reloading", 30, var5);
            var5 += 30;
        }

    }

    @Override
    public URL getCodeBase() {
        try {
            return new URL(server + ":" + (80 + portOff));
        } catch (Exception _ex) {
        }
        return null;
    }

    private void method95() {
        for (int j = 0; j < this.npcCount; ++j) {
            int k = this.npcIndices[j];
            Npc npc = this.npcArray[k];
            if (npc != null) {
                this.method96(npc);
            }
        }

    }

    private void method96(Entity entity) {
        if (entity.x < 128 || entity.y < 128 || entity.x >= 13184 || entity.y >= 13184) {
            entity.anim = -1;
            entity.anInt1520 = -1;
            entity.anInt1547 = 0;
            entity.anInt1548 = 0;
            entity.x = entity.smallX[0] * 128 + entity.anInt1540 * 64;
            entity.y = entity.smallY[0] * 128 + entity.anInt1540 * 64;
            entity.method446();
        }

        if (entity == myPlayer && (entity.x < 1536 || entity.y < 1536 || entity.x >= 11776 || entity.y >= 11776)) {
            entity.anim = -1;
            entity.anInt1520 = -1;
            entity.anInt1547 = 0;
            entity.anInt1548 = 0;
            entity.x = entity.smallX[0] * 128 + entity.anInt1540 * 64;
            entity.y = entity.smallY[0] * 128 + entity.anInt1540 * 64;
            entity.method446();
        }

        if (entity.anInt1547 > loopCycle) {
            this.method97(entity);
        } else if (entity.anInt1548 >= loopCycle) {
            this.method98(entity);
        } else {
            this.method99(entity);
        }

        this.method100(entity);
        this.method101(entity);
    }

    private void method97(Entity entity) {
        int i = entity.anInt1547 - loopCycle;
        int j = entity.anInt1543 * 128 + entity.anInt1540 * 64;
        int k = entity.anInt1545 * 128 + entity.anInt1540 * 64;
        entity.x += (j - entity.x) / i;
        entity.y += (k - entity.y) / i;
        entity.anInt1503 = 0;
        if (entity.anInt1549 == 0) {
            entity.turnDirection = 1024;
        }

        if (entity.anInt1549 == 1) {
            entity.turnDirection = 1536;
        }

        if (entity.anInt1549 == 2) {
            entity.turnDirection = 0;
        }

        if (entity.anInt1549 == 3) {
            entity.turnDirection = 512;
        }

    }

    private void method98(Entity entity) {
        if (entity.anInt1548 == loopCycle || entity.anim == -1 || entity.anInt1529 != 0
                || entity.anInt1528 + 1 > Animation.anims[entity.anim].method258(entity.anInt1527)) {
            int i = entity.anInt1548 - entity.anInt1547;
            int j = loopCycle - entity.anInt1547;
            int k = entity.anInt1543 * 128 + entity.anInt1540 * 64;
            int l = entity.anInt1545 * 128 + entity.anInt1540 * 64;
            int i1 = entity.anInt1544 * 128 + entity.anInt1540 * 64;
            int j1 = entity.anInt1546 * 128 + entity.anInt1540 * 64;
            entity.x = (k * (i - j) + i1 * j) / i;
            entity.y = (l * (i - j) + j1 * j) / i;
        }

        entity.anInt1503 = 0;
        if (entity.anInt1549 == 0) {
            entity.turnDirection = 1024;
        }

        if (entity.anInt1549 == 1) {
            entity.turnDirection = 1536;
        }

        if (entity.anInt1549 == 2) {
            entity.turnDirection = 0;
        }

        if (entity.anInt1549 == 3) {
            entity.turnDirection = 512;
        }

        entity.anInt1552 = entity.turnDirection;
    }

    public final void method99(Entity class30_sub2_sub4_sub1) {
        class30_sub2_sub4_sub1.anInt1517 = class30_sub2_sub4_sub1.anInt1511;
        if (class30_sub2_sub4_sub1.smallXYIndex == 0) {
            class30_sub2_sub4_sub1.anInt1503 = 0;
        } else {
            if (class30_sub2_sub4_sub1.anim != -1 && class30_sub2_sub4_sub1.anInt1529 == 0) {
                Animation var9 = Animation.anims[class30_sub2_sub4_sub1.anim];
                if (class30_sub2_sub4_sub1.anInt1542 > 0 && var9.animatingPrecedence == 0) {
                    ++class30_sub2_sub4_sub1.anInt1503;
                    return;
                }

                if (class30_sub2_sub4_sub1.anInt1542 <= 0 && var9.walkingPrecedence == 0) {
                    ++class30_sub2_sub4_sub1.anInt1503;
                    return;
                }
            }

            int var91 = class30_sub2_sub4_sub1.x;
            int j = class30_sub2_sub4_sub1.y;
            int k = class30_sub2_sub4_sub1.smallX[class30_sub2_sub4_sub1.smallXYIndex - 1] * 128
                    + class30_sub2_sub4_sub1.anInt1540 * 64;
            int l = class30_sub2_sub4_sub1.smallY[class30_sub2_sub4_sub1.smallXYIndex - 1] * 128
                    + class30_sub2_sub4_sub1.anInt1540 * 64;
            if (k - var91 <= 256 && k - var91 >= -256 && l - j <= 256 && l - j >= -256) {
                if (var91 < k) {
                    if (j < l) {
                        class30_sub2_sub4_sub1.turnDirection = 1280;
                    } else if (j > l) {
                        class30_sub2_sub4_sub1.turnDirection = 1792;
                    } else {
                        class30_sub2_sub4_sub1.turnDirection = 1536;
                    }
                } else if (var91 > k) {
                    if (j < l) {
                        class30_sub2_sub4_sub1.turnDirection = 768;
                    } else if (j > l) {
                        class30_sub2_sub4_sub1.turnDirection = 256;
                    } else {
                        class30_sub2_sub4_sub1.turnDirection = 512;
                    }
                } else if (j < l) {
                    class30_sub2_sub4_sub1.turnDirection = 1024;
                } else {
                    class30_sub2_sub4_sub1.turnDirection = 0;
                }

                int i1 = class30_sub2_sub4_sub1.turnDirection - class30_sub2_sub4_sub1.anInt1552 & 2047;
                if (i1 > 1024) {
                    i1 -= 2048;
                }

                int j1 = class30_sub2_sub4_sub1.anInt1555;
                if (i1 >= -256 && i1 <= 256) {
                    j1 = class30_sub2_sub4_sub1.anInt1554;
                } else if (i1 >= 256 && i1 < 768) {
                    j1 = class30_sub2_sub4_sub1.anInt1557;
                } else if (i1 >= -768 && i1 <= -256) {
                    j1 = class30_sub2_sub4_sub1.anInt1556;
                }

                if (j1 == -1) {
                    j1 = class30_sub2_sub4_sub1.anInt1554;
                }

                class30_sub2_sub4_sub1.anInt1517 = j1;
                int k1 = 4;
                if (class30_sub2_sub4_sub1.anInt1552 != class30_sub2_sub4_sub1.turnDirection
                        && class30_sub2_sub4_sub1.interactingEntity == -1 && class30_sub2_sub4_sub1.anInt1504 != 0) {
                    k1 = 2;
                }

                if (class30_sub2_sub4_sub1.smallXYIndex > 2) {
                    k1 = 6;
                }

                if (class30_sub2_sub4_sub1.smallXYIndex > 3) {
                    k1 = 8;
                }

                if (class30_sub2_sub4_sub1.anInt1503 > 0 && class30_sub2_sub4_sub1.smallXYIndex > 1) {
                    k1 = 8;
                    --class30_sub2_sub4_sub1.anInt1503;
                }

                if (class30_sub2_sub4_sub1.aBooleanArray1553[class30_sub2_sub4_sub1.smallXYIndex - 1]) {
                    k1 <<= 1;
                }

                if (k1 >= 8 && class30_sub2_sub4_sub1.anInt1517 == class30_sub2_sub4_sub1.anInt1554
                        && class30_sub2_sub4_sub1.anInt1505 != -1) {
                    class30_sub2_sub4_sub1.anInt1517 = class30_sub2_sub4_sub1.anInt1505;
                }

                if (var91 < k) {
                    class30_sub2_sub4_sub1.x += k1;
                    if (class30_sub2_sub4_sub1.x > k) {
                        class30_sub2_sub4_sub1.x = k;
                    }
                } else if (var91 > k) {
                    class30_sub2_sub4_sub1.x -= k1;
                    if (class30_sub2_sub4_sub1.x < k) {
                        class30_sub2_sub4_sub1.x = k;
                    }
                }

                if (j < l) {
                    class30_sub2_sub4_sub1.y += k1;
                    if (class30_sub2_sub4_sub1.y > l) {
                        class30_sub2_sub4_sub1.y = l;
                    }
                } else if (j > l) {
                    class30_sub2_sub4_sub1.y -= k1;
                    if (class30_sub2_sub4_sub1.y < l) {
                        class30_sub2_sub4_sub1.y = l;
                    }
                }

                if (class30_sub2_sub4_sub1.x == k && class30_sub2_sub4_sub1.y == l) {
                    --class30_sub2_sub4_sub1.smallXYIndex;
                    if (class30_sub2_sub4_sub1.anInt1542 > 0) {
                        --class30_sub2_sub4_sub1.anInt1542;
                    }
                }
            } else {
                class30_sub2_sub4_sub1.x = k;
                class30_sub2_sub4_sub1.y = l;
            }
        }

    }

    private void method100(Entity entity) {
        if (entity.anInt1504 != 0) {
            int j1;
            if (entity.interactingEntity != -1 && entity.interactingEntity < '\u8000') {
                Npc l11 = this.npcArray[entity.interactingEntity];
                if (l11 != null) {
                    j1 = entity.x - l11.x;
                    int l1 = entity.y - l11.y;
                    if (j1 != 0 || l1 != 0) {
                        entity.turnDirection = (int) (Math.atan2((double) j1, (double) l1) * 325.949D) & 2047;
                    }
                }
            }

            int l111;
            if (entity.interactingEntity >= '\u8000') {
                l111 = entity.interactingEntity - '\u8000';
                if (l111 == this.unknownInt10) {
                    l111 = this.myPlayerIndex;
                }

                Player j11 = this.playerArray[l111];
                if (j11 != null) {
                    l111 = entity.x - j11.x;
                    int i2 = entity.y - j11.y;
                    if (l111 != 0 || i2 != 0) {
                        entity.turnDirection = (int) (Math.atan2((double) l111, (double) i2) * 325.949D) & 2047;
                    }
                }
            }

            if ((entity.anInt1538 != 0 || entity.anInt1539 != 0)
                    && (entity.smallXYIndex == 0 || entity.anInt1503 > 0)) {
                l111 = entity.x - (entity.anInt1538 - this.baseX - this.baseX) * 64;
                j1 = entity.y - (entity.anInt1539 - this.baseY - this.baseY) * 64;
                if (l111 != 0 || j1 != 0) {
                    entity.turnDirection = (int) (Math.atan2((double) l111, (double) j1) * 325.949D) & 2047;
                }

                entity.anInt1538 = 0;
                entity.anInt1539 = 0;
            }

            l111 = entity.turnDirection - entity.anInt1552 & 2047;
            if (l111 != 0) {
                if (l111 >= entity.anInt1504 && l111 <= 2048 - entity.anInt1504) {
                    if (l111 > 1024) {
                        entity.anInt1552 -= entity.anInt1504;
                    } else {
                        entity.anInt1552 += entity.anInt1504;
                    }
                } else {
                    entity.anInt1552 = entity.turnDirection;
                }

                entity.anInt1552 &= 2047;
                if (entity.anInt1517 == entity.anInt1511 && entity.anInt1552 != entity.turnDirection) {
                    if (entity.anInt1512 != -1) {
                        entity.anInt1517 = entity.anInt1512;
                        return;
                    }

                    entity.anInt1517 = entity.anInt1554;
                }
            }
        }

    }

    public void method101(Entity entity) {
        try {
        if (entity.anInt1517 >= Animation.anims.length){
            entity.anInt1517 = -1;
        }
        entity.aBoolean1541 = false;
        if (entity.anInt1517 != -1) {
            Animation animation = Animation.anims[entity.anInt1517];
            entity.anInt1519++; // should I? yeah go ahead
            if (entity.anInt1518 < animation.frameCount && entity.anInt1519 > animation.method258(entity.anInt1518)) {
                entity.anInt1519 = 1;
                entity.anInt1518++;
            }
            if (entity.anInt1518 >= animation.frameCount) {
                entity.anInt1519 = 1;
                entity.anInt1518 = 0;
            }
        }
        if (entity.anInt1520 != -1 && loopCycle >= entity.anInt1523) {
            if (entity.anInt1521 < 0)
                entity.anInt1521 = 0;
            Animation animation_1 = Graphic.cache[entity.anInt1520].aAnimation_407;
            if (animation_1 == null) {
                return;
            }
            for (entity.anInt1522++; entity.anInt1521 < animation_1.frameCount
                    && entity.anInt1522 > animation_1.method258(entity.anInt1521); entity.anInt1521++)
                entity.anInt1522 -= animation_1.method258(entity.anInt1521);

            if (entity.anInt1521 >= animation_1.frameCount
                    && (entity.anInt1521 < 0 || entity.anInt1521 >= animation_1.frameCount))
                entity.anInt1520 = -1;
        }
        if (entity.anim != -1 && entity.anInt1529 <= 1) {
            Animation animation_2 = Animation.anims[entity.anim];
            if (animation_2.animatingPrecedence == 1 && entity.anInt1542 > 0 && entity.anInt1547 <= loopCycle
                    && entity.anInt1548 < loopCycle) {
                entity.anInt1529 = 1;
                return;
            }
        }
        if (entity.anim != -1 && entity.anInt1529 == 0) {
            Animation animation_3 = Animation.anims[entity.anim];
            for (entity.anInt1528++; entity.anInt1527 < animation_3.frameCount
                    && entity.anInt1528 > animation_3.method258(entity.anInt1527); entity.anInt1527++)
                entity.anInt1528 -= animation_3.method258(entity.anInt1527);

            if (entity.anInt1527 >= animation_3.frameCount) {
                entity.anInt1527 -= animation_3.loopOffset;
                entity.anInt1530++;
                if (entity.anInt1530 >= animation_3.frameCount)
                    entity.anim = -1;
                if (entity.anInt1527 < 0 || entity.anInt1527 >= animation_3.frameCount)
                    entity.anim = -1;
            }
            entity.aBoolean1541 = animation_3.stretches;
        }
        if (entity.anInt1529 > 0)
            entity.anInt1529--;
        } catch (Exception var3) {
            var3.printStackTrace();
         }
    }

    public void sendFrame219() {
        if (this.invOverlayInterfaceID != -1) {
            this.invOverlayInterfaceID = -1;
            tabAreaAltered = true;
        }

        openInterfaceID = -1;
        this.aBoolean1149 = false;
    }

    public final void drawGameScreen() {
        if (this.drawCount != 0) {
            this.resetImageProducers2();
        }

        if (this.aBoolean1255) {
            this.aBoolean1255 = false;
            if (currentScreenMode == Main.ScreenMode.FIXED) {
                this.aRSImageProducer_903.drawGraphics(4, super.graphics, 0);
                this.aRSImageProducer_907.drawGraphics(0, super.graphics, 0);
            }
            needDrawTabArea = true;
            inputTaken = true;
            tabAreaAltered = true;
            if (this.anInt1023 != 2 && currentScreenMode == Main.ScreenMode.FIXED) {
                aRSImageProducer_1165.drawGraphics(0,
                        super.graphics, 0);
                this.aRSImageProducer_1164.drawGraphics(0, super.graphics, 516);
            }
        }

        if (invOverlayInterfaceID != -1) {
            boolean flag1 = method119(tickDelta, invOverlayInterfaceID);
            if (flag1)
                needDrawTabArea = true;
        }
        if (atInventoryInterfaceType == 2)
            needDrawTabArea = true;
        if (activeInterfaceType == 2)
            needDrawTabArea = true;
        this.drawTabArea();
        if (backDialogID == -1) {
            if (inputDialogState == 3) {
                /*
                 * if(grandExchangeItemSeach != null) { int itemSearchAmount =
                 * grandExchangeItemSeach.getItemSearchResultAmount(); int
                 * maxScrollPosition = itemSearchAmount / 3 * 35;
                 *
                 * aClass9_1059.scrollPosition = maxScrollPosition -
                 * grandExchangeSearchScrollPostion;
                 *
                 *
                 * if (mouseX > 478 && mouseX < 580 && mouseY >
                 * (currentScreenMode == ScreenMode.FIXED ? 342 :
                 * gameScreenHeight - 159)) { method65(494, 110, mouseX, mouseY
                 * - (currentScreenMode == ScreenMode.FIXED ? 348 :
                 * gameScreenHeight - 155), aClass9_1059, 0, false,
                 * maxScrollPosition); //System.out.println("" + position); }
                 * int scrollPosition = maxScrollPosition -
                 * aClass9_1059.scrollPosition; if (scrollPosition < 0) {
                 * scrollPosition = 0; } if (scrollPosition > maxScrollPosition
                 * - 104) { scrollPosition = maxScrollPosition - 104; }
                 * if(grandExchangeSearchScrollPostion != scrollPosition) {
                 * grandExchangeSearchScrollPostion = scrollPosition; inputTaken
                 * = true; } }
                 */
            } else {
                this.aClass9_1059.scrollPosition = anInt1211 - anInt1089 - 110;
                if (super.mouseX > 496 && super.mouseX < 511
                        && super.mouseY > (currentScreenMode == Main.ScreenMode.FIXED ? 345 : currentGameHeight - 158)) {
                    this.method65(494, 110, super.mouseX,
                            super.mouseY - (currentScreenMode == Main.ScreenMode.FIXED ? 345 : currentGameHeight - 158),
                            this.aClass9_1059, 0, false, anInt1211, 0);
                }

                int flag211 = anInt1211 - 110 - this.aClass9_1059.scrollPosition;
                if (flag211 < 0) {
                    flag211 = 0;
                }

                if (flag211 > anInt1211 - 110) {
                    flag211 = anInt1211 - 110;
                }

                if (anInt1089 != flag211) {
                    anInt1089 = flag211;
                    inputTaken = true;
                }
            }
        }
        if (backDialogID != -1) {
            boolean flag2111 = this.method119(this.tickDelta, backDialogID);
            if (flag2111) {
                inputTaken = true;
            }
        }

        if (this.atInventoryInterfaceType == 3) {
            inputTaken = true;
        }

        if (this.activeInterfaceType == 3) {
            inputTaken = true;
        }

        if (this.aString844 != null) {
            inputTaken = true;
        }
        if (menuOpen && menuScreenArea == 1) {
            needDrawTabArea = true;
        }
        if (this.menuOpen && this.menuScreenArea == 2) {
            inputTaken = true;
        }

        if (inputTaken) {
            this.drawChatArea();
            inputTaken = false;
        }

        if (this.anInt1023 == 2) {
            this.method146();
        }

        if (this.anInt1023 == 2 && currentScreenMode == Main.ScreenMode.FIXED) {
            this.drawMinimap();
            this.aRSImageProducer_1164.drawGraphics(0, super.graphics, 516);
        }

        if (this.anInt1054 != -1) {
            tabAreaAltered = true;
        }

        if (tabAreaAltered) {
            if (this.anInt1054 != -1 && this.anInt1054 == tabID) {
                this.anInt1054 = -1;
                stream.createFrame(120);
                stream.writeByte(tabID);
            }
            if (this.fullscreenInterfaceID != -1 && (this.anInt1023 == 2 || super.fullGameScreen != null)) {
                if (this.anInt1023 == 2) {
                    this.method119(this.tickDelta, this.fullscreenInterfaceID);
                    if (openInterfaceID != -1) {
                        this.method119(this.tickDelta, openInterfaceID);
                    }

                    this.tickDelta = 0;
                    this.resetAllImageProducers();
                    super.fullGameScreen.initDrawingArea();
                    Rasterizer.lineOffsets = fullScreenTextureArray;
                    DrawingArea.setAllPixelsToZero();
                    this.aBoolean1255 = true;
                    Widget flag2112;
                    if (openInterfaceID != -1) {
                        flag2112 = Widget.interfaceCache[openInterfaceID];
                        if (flag2112.width == 512 && flag2112.height == 334 && flag2112.type == 0) {
                            flag2112.width = currentGameWidth;
                            flag2112.height = currentGameHeight;
                        }

                        this.drawInterface((currentScreenMode == ScreenMode.FIXED ? 0 : currentGameHeight / 2 - 503), (currentScreenMode == ScreenMode.FIXED ? 0 : currentGameWidth / 2 - 383), flag2112, 8);
                    }

                    flag2112 = Widget.interfaceCache[this.fullscreenInterfaceID];
                    if (flag2112.width == 512 && flag2112.height == 334 && flag2112.type == 0) {
                        flag2112.width = currentGameWidth;
                        flag2112.height = currentGameHeight;
                    }

                    this.drawInterface((currentScreenMode == ScreenMode.FIXED ? 0 : currentGameHeight / 2 - 400), (currentScreenMode == ScreenMode.FIXED ? 0 : currentGameWidth / 2 - 383), flag2112, 8);
                    if (!menuOpen) {
                        processRightClick();
                        drawTooltip();
                    } else {
                        drawMenu(currentScreenMode == ScreenMode.FIXED ? 0 : 0,
                                currentScreenMode == ScreenMode.FIXED ? 0 : 0);
                    }
                }

                ++this.drawCount;
                super.fullGameScreen.drawGraphics(0, super.graphics, 0);
                tabAreaAltered = false;
                this.aRSImageProducer_1125.initDrawingArea();
                aRSImageProducer_1165.initDrawingArea();
            }

            this.tickDelta = 0;
        }

    }

    private boolean buildFriendsListMenu(Widget class9) {
        int i = class9.contentType;
        if ((i < 1 || i > 200) && (i < 701 || i > 900)) {
            if (i >= 401 && i <= 500) {
                this.menuActionName[this.menuActionRow] = "Remove @whi@" + class9.message;
                this.menuActionID[this.menuActionRow] = 322;
                ++this.menuActionRow;
                return true;
            } else {
                return false;
            }
        } else {
            if (i >= 801) {
                i -= 701;
            } else if (i >= 701) {
                i -= 601;
            } else if (i >= 101) {
                i -= 101;
            } else {
                --i;
            }

            if (this.myPrivilege == 2 || this.myPrivilege == 9 || this.myPrivilege == 10 || this.myPrivilege == 4) {
                this.menuActionName[this.menuActionRow] = "TeleToMe @whi@" + this.friendsList[i];
                this.menuActionID[this.menuActionRow] = 638;
                ++this.menuActionRow;
                this.menuActionName[this.menuActionRow] = "TeleTo @whi@" + this.friendsList[i];
                this.menuActionID[this.menuActionRow] = 637;
                ++this.menuActionRow;
                this.menuActionName[this.menuActionRow] = "Remove @whi@" + this.friendsList[i];
                this.menuActionID[this.menuActionRow] = 792;
                ++this.menuActionRow;
                this.menuActionName[this.menuActionRow] = "Message @whi@" + this.friendsList[i];
                this.menuActionID[this.menuActionRow] = 639;
                ++this.menuActionRow;
                return true;
            } else {
                this.menuActionName[this.menuActionRow] = "Remove @whi@" + this.friendsList[i];
                this.menuActionID[this.menuActionRow] = 792;
                ++this.menuActionRow;
                this.menuActionName[this.menuActionRow] = "Message @whi@" + this.friendsList[i];
                this.menuActionID[this.menuActionRow] = 639;
                ++this.menuActionRow;
                return true;
            }
        }
    }

    public final void method104(boolean flag) {
        Animable_Sub3 class30_sub2_sub4_sub3 = (Animable_Sub3) this.aClass19_1056.reverseGetFirst();

        for (loggedIn &= flag; class30_sub2_sub4_sub3 != null; class30_sub2_sub4_sub3 = (Animable_Sub3) this.aClass19_1056
                .reverseGetNext()) {
            if (class30_sub2_sub4_sub3.anInt1560 == this.plane && !class30_sub2_sub4_sub3.aBoolean1567) {
                if (loopCycle >= class30_sub2_sub4_sub3.anInt1564) {
                    class30_sub2_sub4_sub3.method454(this.tickDelta, true);
                    if (class30_sub2_sub4_sub3.aBoolean1567) {
                        class30_sub2_sub4_sub3.unlink();
                    } else {
                        this.worldController.method285(class30_sub2_sub4_sub3.anInt1560, 0,
                                class30_sub2_sub4_sub3.anInt1563, -1, class30_sub2_sub4_sub3.anInt1562, 60,
                                class30_sub2_sub4_sub3.anInt1561, class30_sub2_sub4_sub3, false);
                    }
                }
            } else {
                class30_sub2_sub4_sub3.unlink();
            }
        }

    }

    public final String methodR(int j) {
        if (j >= 0 && j < 10000)
            return String.valueOf(j);
        if (j >= 10000 && j < 10000000)
            return j / 1000 + "K";
        if (j >= 10000000 && j < 999999999)
            return j / 1000000 + "M";
        if (j >= 999999999)
            return "*";
        else
            return "?";
    }

    public void drawInterface(int j, int k, Widget class9, int l) {
        if (class9 == null) {
            class9 = Widget.interfaceCache[30000];
        }

        if (class9.type == 0 && class9.children != null && (!class9.isMouseoverTriggered || this.anInt1026 == class9.id
                || this.anInt1048 == class9.id || this.anInt1039 == class9.id)) {
            int i1 = DrawingArea.leftX;
            int j1 = DrawingArea.topY;
            int k1 = DrawingArea.bottomX;
            int l1 = DrawingArea.bottomY;
            DrawingArea.method333(l + class9.height, k, k + class9.width, l);
            if (class9.id >= 59570 && class9.id <= 59670) {
                DrawingArea.method333(200, 110, 450, 30);
            }
            if (class9.id == 36100) {
                DrawingArea.drawTransparentBox(-100, 0, DrawingArea.width + 100, DrawingArea.height, 0x3e2f1d, 100);
            }
            int i2 = class9.children.length;
            int alpha = class9.transparency;

            for (int j2 = 0; j2 < i2; ++j2) {
                int k2 = class9.childX[j2] + k;
                int l2 = class9.childY[j2] + l - j;
                Widget class9_1 = Widget.interfaceCache[class9.children[j2]];
                k2 += class9_1.anInt263;
                l2 += class9_1.anInt265;
                if (class9_1.contentType > 0) {
                    this.drawFriendsListOrWelcomeScreen(class9_1);
                }

                int[] IDs = new int[]{1196, 1199, 1206, 1215, 1224, 1231, 1240, 1249, 1258, 1267, 1274, 1283, 1573,
                        1290, 1299, 1308, 1315, 1324, 1333, 1340, 1349, 1358, 1367, 1374, 1381, 1388, 1397, 1404, 1583,
                        12038, 1414, 1421, 1430, 1437, 1446, 1453, 1460, 1469, 15878, 1602, 1613, 1624, 7456, 1478,
                        1485, 1494, 1503, 1512, 1521, 1530, 1544, 1553, 1563, 1593, 1635, 12426, 12436, 12446, 12456,
                        6004, 18471, 18977};

                int boxWidth;
                for (boxWidth = 0; boxWidth < IDs.length; ++boxWidth) {
                    if (class9_1.id == IDs[boxWidth] + 1) {
                        this.drawBlackBox(k2, l2 + 1);
                    }
                }

                if (class9_1.type == 0) {
                    if (this.showIds) {
                        class9_1.message = Integer.toString(class9_1.id);
                    }

                    if (class9_1.scrollPosition > class9_1.scrollMax - class9_1.height) {
                        class9_1.scrollPosition = class9_1.scrollMax - class9_1.height;
                    }

                    if (class9_1.scrollPosition < 0) {
                        class9_1.scrollPosition = 0;
                    }

                    this.drawInterface(class9_1.scrollPosition, k2, class9_1, l2);
                    if (class9_1.scrollMax > class9_1.height) {
                        // clan chat
                        if (class9_1.id == 18143) {
                            int clanMates = 0;
                            for (int i = 18155; i < 18244; i++) {
                                Widget line = Widget.interfaceCache[i];
                                if (line.message.length() > 0) {
                                    clanMates++;
                                }
                            }
                            class9_1.scrollMax = (clanMates * 14) + class9_1.height + 1;
                        }
                        if (class9_1.id == 18322 || class9_1.id == 18423) {
                            int members = 0;
                            for (int i = class9_1.id + 1; i < class9_1.id + 1 + 100; i++) {
                                Widget line = Widget.interfaceCache[i];
                                if (line != null && line.message != null) {
                                    if (line.message.length() > 0) {
                                        members++;
                                    }
                                }
                            }
                            class9_1.scrollMax = (members * 14) + 1;
                        }
                        if (scrollbarVisible(class9_1)) {
                            if (class9.id == 36100) {
                                this.draw508Scrollbar(class9_1.height, class9_1.scrollPosition, l2, k2 + class9_1.width,
                                        class9_1.scrollMax, false);
                            } else {
                                this.drawScrollbar(class9_1.height, class9_1.scrollPosition, l2, k2 + class9_1.width,
                                        class9_1.scrollMax, false);
                            }
                        }
                    }
                } else if (class9_1.type != 1) {
                    int boxHeight;
                    int textDrawingArea_2;
                    int xPos;
                    int yPos;
                    int s2;
                    Sprite itemSprite = null;
                    int j11;
                    int l11;
                    if (class9_1.type == 2) {
                        boxWidth = 0;

                        for (boxHeight = 0; boxHeight < class9_1.height; ++boxHeight) {
                            for (textDrawingArea_2 = 0; textDrawingArea_2 < class9_1.width; ++textDrawingArea_2) {
                                xPos = k2 + textDrawingArea_2 * (32 + class9_1.spritePaddingX);
                                yPos = l2 + boxHeight * (32 + class9_1.spritePaddingY);
                                if (boxWidth < 20) {
                                    xPos += class9_1.spritesX[boxWidth];
                                    yPos += class9_1.spritesY[boxWidth];
                                }

                                if (class9_1.inventoryItemId[boxWidth] <= 0) {
                                    s2 = 0;
                                    j11 = 0;
                                    l11 = class9_1.inventoryItemId[boxWidth] - 1;
                                    if (xPos > DrawingArea.leftX - 32 && xPos < DrawingArea.bottomX
                                            && yPos > DrawingArea.topY - 32 && yPos < DrawingArea.bottomY
                                            || this.activeInterfaceType != 0 && this.anInt1085 == boxWidth) {
                                        int var32 = 0;
                                        if (this.itemSelected == 1 && this.anInt1283 == boxWidth
                                                && this.anInt1284 == class9_1.id)
                                            var32 = 16777215;

                                        int itemSpriteOpacity = 256;
                                        /**
                                         * Placeholder opacity editing
                                         */
                                        if (class9_1.inventoryAmounts[boxWidth] <= 0)
                                            itemSpriteOpacity = 100;

                                        if (openInterfaceID == 29875) {
                                            if (class9_1.inventoryItemId[boxWidth] < 555
                                                    || class9_1.inventoryItemId[boxWidth] > 567 && class9_1.inventoryItemId[boxWidth] != 9076) {
                                                itemSpriteOpacity = 100;
                                            }
                                        }
                                        boolean smallSprite = openInterfaceID == 26000
                                                && GrandExchange.isSmallItemSprite(class9_1.id);

                                        itemSprite = ItemDefinition.getSprite(l11, class9_1.inventoryAmounts[boxWidth], var32);
                                        if (itemSprite != null) {
                                            int var361;
                                            if (this.activeInterfaceType != 0 && this.anInt1085 == boxWidth
                                                    && this.anInt1084 == class9_1.id) {
                                                s2 = super.mouseX - this.anInt1087;
                                                j11 = super.mouseY - this.anInt1088;
                                                if (s2 < 5 && s2 > -5) {
                                                    s2 = 0;
                                                }

                                                if (j11 < 5 && j11 > -5) {
                                                    j11 = 0;
                                                }

                                                if (this.anInt989 < 5) {
                                                    s2 = 0;
                                                    j11 = 0;
                                                }

                                                itemSprite.drawSprite1(xPos + s2, yPos + j11);
                                                if (yPos + j11 < DrawingArea.topY && class9.scrollPosition > 0) {
                                                    var361 = this.tickDelta * (DrawingArea.topY - yPos - j11) / 3;
                                                    if (var361 > this.tickDelta * 10) {
                                                        var361 = this.tickDelta * 10;
                                                    }

                                                    if (var361 > class9.scrollPosition) {
                                                        var361 = class9.scrollPosition;
                                                    }

                                                    class9.scrollPosition -= var361;
                                                    this.anInt1088 += var361;
                                                }

                                                if (yPos + j11 + 32 > DrawingArea.bottomY
                                                        && class9.scrollPosition < class9.scrollMax - class9.height) {
                                                    var361 = this.tickDelta * (yPos + j11 + 32 - DrawingArea.bottomY)
                                                            / 3;
                                                    if (var361 > this.tickDelta * 10) {
                                                        var361 = this.tickDelta * 10;
                                                    }

                                                    if (var361 > class9.scrollMax - class9.height
                                                            - class9.scrollPosition) {
                                                        var361 = class9.scrollMax - class9.height
                                                                - class9.scrollPosition;
                                                    }

                                                    class9.scrollPosition += var361;
                                                    this.anInt1088 -= var361;
                                                }
                                            } else if (this.atInventoryInterfaceType != 0 && this.atInventoryIndex == boxWidth
                                                    && this.atInventoryInterface == class9_1.id)
                                                itemSprite.drawSprite(xPos, yPos);
                                             else
                                                itemSprite.drawSprite(xPos, yPos);
                                                /**
                                                 * Draws item sprite
                                                 */
                                                //itemSprite.drawTransparentSprite(xPos, yPos, itemSpriteOpacity);
                                            if (class9_1.id == Widget.selectedItemInterfaceId
                                                    && class9_1.itemSearchSelectedSlot > -1
                                                    && class9_1.itemSearchSelectedSlot == boxWidth) {
                                                for (int i = 32; i > 0; i--) {
                                                    DrawingArea.method338(yPos + j11, i, 256 - Byte.MAX_VALUE, 0x395D84, i,
                                                            xPos + s2);
                                                }
                                                DrawingArea.method338(yPos + j11, 32, 256, 0x395D84, 32, xPos + s2);
                                            }
                                                    if (itemSprite.maxWidth == 33 || class9_1.inventoryAmounts[boxWidth] != 1) {
                                                        var361 = class9_1.inventoryAmounts[boxWidth];
                                                        this.smallText.method385(0, method43(var361), yPos + 10 + j11,
                                                                xPos + 1 + s2);
                                                        if (var361 >= 0) {
                                                            this.smallText.method385(16776960, method43(var361), yPos + 9 + j11,
                                                                    xPos + s2);
                                                        }

                                                        if (var361 >= 100000) {
                                                            this.smallText.method385(16777215, method43(var361), yPos + 9 + j11,
                                                                    xPos + s2);
                                                        }

                                                        if (var361 >= 10000000) {
                                                            this.smallText.method385('\uff80', method43(var361), yPos + 9 + j11,
                                                                    xPos + s2);
                                                        }

                                                        if (var361 >= 1000000000) {
                                                            this.smallText.method385('\uff80', method43(var361), yPos + 9 + j11,
                                                                    xPos + s2);
                                                        }
                                                    }
                                                }
                                            }
                                } else if (class9_1.sprites != null && boxWidth < 20) {
                                    Sprite var33 = class9_1.sprites[boxWidth];
                                    if (var33 != null)
                                        var33.drawSprite(xPos, yPos);
                                }

                                ++boxWidth;
                            }
                        }
                    } else if (class9_1.type == 3) {
                        boolean flag = false;
                        if (anInt1039 == class9_1.id || anInt1048 == class9_1.id || anInt1026 == class9_1.id)
                            flag = true;
                        int j3;
                        if (method131(class9_1)) {
                            j3 = class9_1.secondaryColor;
                            if (flag && class9_1.secondaryHoverColor != 0)
                                j3 = class9_1.secondaryHoverColor;
                        } else {
                            j3 = class9_1.textColor;
                            if (flag && class9_1.defaultHoverColor != 0)
                                j3 = class9_1.defaultHoverColor;
                        }
                        if (class9_1.opacity == 0) {
                            if (class9_1.filled)
                                DrawingArea.method336(class9_1.height, l2, k2, j3, class9_1.width);
                            else
                                DrawingArea.fillPixels(k2, class9_1.width, class9_1.height, j3, l2);
                        } else if (class9_1.filled)
                            DrawingArea.method335(j3, l2, class9_1.width, class9_1.height,
                                    256 - (class9_1.opacity & 0xff), k2);
                        else
                            DrawingArea.method338(l2, class9_1.height, 256 - (class9_1.opacity & 0xff), j3,
                                    class9_1.width, k2);
                    } else if (class9_1.type == 4) {
                        RSFont textDrawingArea = class9_1.textDrawingAreas;
                        String s = class9_1.message;
                        boolean var351 = false;
                        if (this.anInt1039 == class9_1.id || this.anInt1048 == class9_1.id
                                || this.anInt1026 == class9_1.id) {
                            var351 = true;
                        }

                        if (this.method131(class9_1)) {
                            xPos = class9_1.secondaryColor;
                            if (var351 && class9_1.secondaryHoverColor != 0) {
                                xPos = class9_1.secondaryHoverColor;
                            }

                            if (class9_1.secondaryText.length() > 0) {
                                s = class9_1.secondaryText;
                            }
                        } else {
                            xPos = class9_1.textColor;
                            if (var351 && class9_1.defaultHoverColor != 0) {
                                xPos = class9_1.defaultHoverColor;
                            }
                        }

                        if (class9_1.atActionType == 6 && this.aBoolean1149) {
                            s = "Please wait...";
                            xPos = class9_1.textColor;
                        }

                        if (DrawingArea.width == 516) {
                            if (xPos == 16776960) {
                                xPos = 255;
                            }

                            if (xPos == '\uc000') {
                                xPos = 16777215;
                            }
                        }

                        if (currentScreenMode != Main.ScreenMode.FIXED
                                && (backDialogID != -1 || this.dialogID != -1
                                || class9_1.message.contains("Click here to continue"))
                                && (class9.id == backDialogID || class9.id == this.dialogID)) {
                            if (xPos == 16776960) {
                                xPos = 255;
                            }

                            if (xPos == '\uc000') {
                                xPos = 16777215;
                            }
                        }

                        if (class9_1.parentID == 1151 || class9_1.parentID == 12855) {
                            switch (xPos) {
                                case 7040819:
                                    xPos = 11495962;
                                    break;
                                case 16773120:
                                    xPos = 16685087;
                            }
                        }
                        for (int l6 = l2 + textDrawingArea.baseCharacterHeight; s
                                .length() > 0; l6 += textDrawingArea.baseCharacterHeight) {
                            if (s.indexOf("%") != -1) {
                                do {
                                    int k7 = s.indexOf("%1");
                                    if (k7 == -1)
                                        break;
                                    if (class9_1.id < 4000 || class9_1.id > 5000 && class9_1.id != 13921
                                            && class9_1.id != 13922 && class9_1.id != 12171 && class9_1.id != 12172)
                                        s = s.substring(0, k7) + methodR(extractInterfaceValues(class9_1, 0))
                                                + s.substring(k7 + 2); // spellbook value formatting: 100k/10m etc.
                                    else
                                        s = s.substring(0, k7)
                                                + interfaceIntToString(extractInterfaceValues(class9_1, 0))
                                                + s.substring(k7 + 2);
                                } while (true);
                                do {
                                    int l7 = s.indexOf("%2");
                                    if (l7 == -1)
                                        break;
                                    s = s.substring(0, l7) + interfaceIntToString(extractInterfaceValues(class9_1, 1))
                                            + s.substring(l7 + 2);
                                } while (true);
                                do {
                                    int i8 = s.indexOf("%3");
                                    if (i8 == -1)
                                        break;
                                    s = s.substring(0, i8) + interfaceIntToString(extractInterfaceValues(class9_1, 2))
                                            + s.substring(i8 + 2);
                                } while (true);
                                do {
                                    int j8 = s.indexOf("%4");
                                    if (j8 == -1)
                                        break;
                                    s = s.substring(0, j8) + interfaceIntToString(extractInterfaceValues(class9_1, 3))
                                            + s.substring(j8 + 2);
                                } while (true);
                                do {
                                    int k8 = s.indexOf("%5");
                                    if (k8 == -1)
                                        break;
                                    s = s.substring(0, k8) + interfaceIntToString(extractInterfaceValues(class9_1, 4))
                                            + s.substring(k8 + 2);
                                } while (true);
                            }
                            int l8 = s.indexOf("\\n");
                            String s1;
                            if (l8 != -1) {
                                s1 = s.substring(0, l8);
                                s = s.substring(l8 + 2);
                            } else {
                                s1 = s;
                                s = "";
                            }
                            if (class9_1.centerText) {
                                // textDrawingArea.method382(i4, k2 + class9_1.width / 2, s1, l6,
                                // class9_1.aBoolean268);
                                textDrawingArea.drawCenteredString(s1, k2 + class9_1.width / 2, l6, xPos,
                                        class9_1.textShadow ? 0 : -1);
                            } else {
                                // textDrawingArea.method389(class9_1.aBoolean268, k2, i4, s1, l6);
                                // newRegularFont.drawBasicString(s1, k2, l6, 0, -1);
                                textDrawingArea.drawBasicString(s1, k2, l6, xPos, class9_1.textShadow ? 0 : -1);
                            }
                        }

                    } else if (class9_1.type == 5) {
                        if (this.method131(class9_1)) {
                            itemSprite = class9_1.enabledSprite;
                        } else {
                            itemSprite = class9_1.disabledSprite;
                        }
                        if (class9_1.id >= 58032 && class9_1.id <= 58040) {
                            int tabId = 0;
                            try {
                                tabId = Integer.parseInt(Widget.interfaceCache[5292].message);
                            } catch (NumberFormatException nfe) {
                            }
                            if (Widget.interfaceCache[class9.id + 1] != null
                                    && !Widget.interfaceCache[class9.id + 1].isMouseoverTriggered
                                    || class9_1.id == 58039 && interfaceContainsItem(58048))
                                itemSprite = new Sprite("BankTab/TAB 3");
                            if (tabId > 0) {
                                if (tabId + 58031 == class9_1.id) {
                                    itemSprite = new Sprite("BankTab/TAB 2");
                                }
                            }
                        }

                        if (this.spellSelected == 1 && class9_1.id == this.spellID && this.spellID != 0
                                && itemSprite != null) {
                            itemSprite.drawSprite(k2, l2, 16777215);
                        } else if (itemSprite != null) {
                            if (class9_1.drawsTransparent) {
                                itemSprite.drawTransparentSprite(k2, l2, alpha);
                            } else {
                                itemSprite.drawSprite(k2, l2);
                            }
                        }

                        if (itemSprite != null) {
                            if (class9_1.drawsTransparent) {
                                itemSprite.drawSprite1(k2, l2);
                            } else {
                                itemSprite.drawSprite(k2, l2);
                            }
                        }
                    } else if (class9_1.type == 6) {
                        int k3 = Rasterizer.centerX;
                        int j4 = Rasterizer.centerY;
                        Rasterizer.centerX = k2 + class9_1.width / 2;
                        Rasterizer.centerY = l2 + class9_1.height / 2;
                        int i5 = Rasterizer.anIntArray1470[class9_1.modelRotation1] * class9_1.modelZoom >> 16;
                        int l5 = Rasterizer.anIntArray1471[class9_1.modelRotation1] * class9_1.modelZoom >> 16;
                        boolean flag2 = method131(class9_1);
                        int i7;
                        if (flag2)
                            i7 = class9_1.anInt258;
                        else
                            i7 = class9_1.anInt257;
                        Model model;
                        if (i7 == -1) {
                            model = class9_1.method209(0, -1, -1, flag2);
                        } else {
                            Animation animation = Animation.anims[i7];
                            model = class9_1.method209(0, animation.secondary[class9_1.anInt246],
                                    animation.primary[class9_1.anInt246], flag2);
                        }
                        if (model != null)
                            model.method482(class9_1.modelRotation2, 0, class9_1.modelRotation1, 0, i5, l5);
                        Rasterizer.centerX = k3;
                        Rasterizer.centerY = j4;
                    } else if (class9_1.type == 7) {
                        RSFont textDrawingArea = class9_1.textDrawingAreas;
                        boxHeight = 0;

                        for (textDrawingArea_2 = 0; textDrawingArea_2 < class9_1.height; ++textDrawingArea_2) {
                            for (xPos = 0; xPos < class9_1.width; ++xPos) {
                                if (class9_1.inventoryItemId[boxHeight] > 0) {
                                    ItemDefinition var34 = ItemDefinition.lookup(class9_1.inventoryItemId[boxHeight] - 1);
                                    String s = var34.name;
                                    if (var34.stackable || class9_1.inventoryAmounts[boxHeight] != 1) {
                                        s = s + " x" + method14(class9_1.inventoryAmounts[boxHeight], 0);
                                    }

                                    j11 = k2 + xPos * (115 + class9_1.spritePaddingX);
                                    l11 = l2 + textDrawingArea_2 * (12 + class9_1.spritePaddingY);
                                    if (class9_1.centerText) {
                                        // var27.method382(class9_1.textColor, j11 + class9_1.width / 2, var40, l11,
                                        // class9_1.textShadow);
                                        textDrawingArea.drawCenteredString(s, j11 + class9_1.width / 2, l11,
                                                class9_1.textColor, class9_1.textShadow ? 0 : -1);
                                    } else {
                                        // var27.method389(class9_1.textShadow, j11, class9_1.textColor, var40, l11);
                                        textDrawingArea.drawBasicString(s, j11, l11, class9_1.textColor,
                                                class9_1.textShadow ? 0 : -1);
                                    }
                                }

                                ++boxHeight;
                            }
                        }
                    } else if (class9_1.type == 8
                            && (anInt1500 == class9_1.id || anInt1044 == class9_1.id || anInt1129 == class9_1.id)
                            && anInt1501 == tooltipDelay && !menuOpen) {
                        boxWidth = 0;
                        boxHeight = 0;
                        TextDrawingArea textDrawingArea_21 = regularText;
                        for (String s1 = class9_1.message; s1.length() > 0; ) {
                            if (s1.indexOf("%") != -1) {
                                do {
                                    int k7 = s1.indexOf("%1");
                                    if (k7 == -1)
                                        break;
                                    s1 = s1.substring(0, k7) + interfaceIntToString(extractInterfaceValues(class9_1, 0))
                                            + s1.substring(k7 + 2);
                                } while (true);
                                do {
                                    int l7 = s1.indexOf("%2");
                                    if (l7 == -1)
                                        break;
                                    s1 = s1.substring(0, l7) + interfaceIntToString(extractInterfaceValues(class9_1, 1))
                                            + s1.substring(l7 + 2);
                                } while (true);
                                do {
                                    int i8 = s1.indexOf("%3");
                                    if (i8 == -1)
                                        break;
                                    s1 = s1.substring(0, i8) + interfaceIntToString(extractInterfaceValues(class9_1, 2))
                                            + s1.substring(i8 + 2);
                                } while (true);
                                do {
                                    int j8 = s1.indexOf("%4");
                                    if (j8 == -1)
                                        break;
                                    s1 = s1.substring(0, j8) + interfaceIntToString(extractInterfaceValues(class9_1, 3))
                                            + s1.substring(j8 + 2);
                                } while (true);
                                do {
                                    int k8 = s1.indexOf("%5");
                                    if (k8 == -1)
                                        break;
                                    s1 = s1.substring(0, k8) + interfaceIntToString(extractInterfaceValues(class9_1, 4))
                                            + s1.substring(k8 + 2);
                                } while (true);
                            }
                            int l7 = s1.indexOf("\\n");
                            String s4;
                            if (l7 != -1) {
                                s4 = s1.substring(0, l7);
                                s1 = s1.substring(l7 + 2);
                            } else {
                                s4 = s1;
                                s1 = "";
                            }
                            int j10 = textDrawingArea_21.getTextWidth(s4);
                            if (j10 > boxWidth) {
                                boxWidth = j10;
                            }
                            boxHeight += textDrawingArea_21.anInt1497 + 1;
                        }
                        boxWidth += 6;
                        boxHeight += 7;
                        xPos = (k2 + class9_1.width) - 5 - boxWidth;
                        yPos = l2 + class9_1.height + 5;
                        if (xPos < k2 + 5)
                            xPos = k2 + 5;
                        if (xPos + boxWidth > k + class9.width)
                            xPos = (k + class9.width) - boxWidth;
                        if (yPos + boxHeight > l + class9.height)
                            yPos = (l2 - boxHeight);
                        //System.out.println("Box Id : "+class9_1.id);
                        switch (class9_1.id) {
                            case 27389:
                            case 27392:
                            case 27395:
                            case 27398:
                            case 27401:
                            case 27408:
                            case 27411:
                                xPos -= 80;
                                break;
                        }
                        DrawingArea.method336(boxHeight, yPos, xPos, 0xFFFFA0, boxWidth);
                        DrawingArea.fillPixels(xPos, boxWidth, boxHeight, 0, yPos);
                        String s21 = class9_1.message;
                        for (j11 = yPos + textDrawingArea_21.anInt1497 + 2; s21
                                .length() > 0; j11 += textDrawingArea_21.anInt1497 + 1) {
                            if (s21.indexOf("%") != -1) {
                                do {
                                    int k7 = s21.indexOf("%1");
                                    if (k7 == -1)
                                        break;
                                    s21 = s21.substring(0, k7)
                                            + interfaceIntToString(extractInterfaceValues(class9_1, 0))
                                            + s21.substring(k7 + 2);
                                } while (true);
                                do {
                                    int l7 = s21.indexOf("%2");
                                    if (l7 == -1)
                                        break;
                                    s21 = s21.substring(0, l7)
                                            + interfaceIntToString(extractInterfaceValues(class9_1, 1))
                                            + s21.substring(l7 + 2);
                                } while (true);
                                do {
                                    int i8 = s21.indexOf("%3");
                                    if (i8 == -1)
                                        break;
                                    s21 = s21.substring(0, i8)
                                            + interfaceIntToString(extractInterfaceValues(class9_1, 2))
                                            + s21.substring(i8 + 2);
                                } while (true);
                                do {
                                    int j8 = s21.indexOf("%4");
                                    if (j8 == -1)
                                        break;
                                    s21 = s21.substring(0, j8)
                                            + interfaceIntToString(extractInterfaceValues(class9_1, 3))
                                            + s21.substring(j8 + 2);
                                } while (true);
                                do {
                                    int k8 = s21.indexOf("%5");
                                    if (k8 == -1)
                                        break;
                                    s21 = s21.substring(0, k8)
                                            + interfaceIntToString(extractInterfaceValues(class9_1, 4))
                                            + s21.substring(k8 + 2);
                                } while (true);
                            }
                            int l111 = s21.indexOf("\\n");
                            String s5;
                            if (l111 != -1) {
                                s5 = s21.substring(0, l111);
                                s21 = s21.substring(l111 + 2);
                            } else {
                                s5 = s21;
                                s21 = "";
                            }
                            if (class9_1.centerText) {
                                textDrawingArea_21.method382(yPos, xPos + class9_1.width / 2, s5, j11, false);
                            } else {
                                if (s5.contains("\\r")) {
                                    String text = s5.substring(0, s5.indexOf("\\r"));
                                    String text2 = s5.substring(s5.indexOf("\\r") + 2);
                                    textDrawingArea_21.method389(false, xPos + 3, 0, text, j11);
                                    int rightX = boxWidth + xPos - textDrawingArea_21.getTextWidth(text2) - 2;
                                    textDrawingArea_21.method389(false, rightX, 0, text2, j11);
                                    System.out.println("Box: " + boxWidth + "");
                                } else
                                    textDrawingArea_21.method389(false, xPos + 3, 0, s5, j11);
                            }
                        }
                    } else if (class9_1.type == 16) {
                        drawInputField(class9_1, k2, l2, class9_1.width, class9_1.height);
                    }else if (class9_1.type == 18) {
                        // Draw outline
                        DrawingArea.drawBox(k2 - 2, l2 - 2, class9_1.width + 4, class9_1.height + 4, 0x0e0e0c);
                        DrawingArea.drawBox(k2 - 1, l2 - 1, class9_1.width + 2, class9_1.height + 2, 0x474745);
                        // Draw base box
                        if (class9_1.toggled) {
                            DrawingArea.drawBox(k2, l2, class9_1.width, class9_1.height, class9_1.secondaryHoverColor);
                            class9_1.toggled = false;
                        } else {
                            DrawingArea.drawBox(k2, l2, class9_1.width, class9_1.height, class9_1.hoverTextColor);
                        }
                    } else if (class9_1.type == 19) {
                        if (class9_1.backgroundSprites.length > 1) {
                            if (class9_1.enabledSprite != null) {
                                class9_1.enabledSprite.drawAdvancedSprite(k2, l2);
                            }
                        }
                    } else if (class9_1.type == 22) {
                        Widget rsinterface = null;
                        int slot = class9_1.grandExchangeSlot;
                        if (grandExchangeInformation[slot][0] == -1)
                            rsinterface = Widget.interfaceCache[GrandExchange.grandExchangeBuyAndSellBoxIds[slot]];
                        else {
                            int childId = GrandExchange.grandExchangeItemBoxIds[slot] + 4;

                            Widget class9_2 = Widget.interfaceCache[childId];

                            int itemId = grandExchangeInformation[slot][1] + 1;
                            int itemAmount = grandExchangeInformation[slot][3];

                            class9_2.inventoryItemId[0] = itemId;
                            class9_2.inventoryAmounts[0] = itemAmount;

                            rsinterface = Widget.interfaceCache[GrandExchange.grandExchangeItemBoxIds[slot]];

                            Widget text = null;

                            text = Widget.interfaceCache[GrandExchange.grandExchangeItemBoxIds[slot] + 6];

                            if (grandExchangeInformation[slot][0] == 0)
                                text.message = "Buy";
                            else if (grandExchangeInformation[slot][0] == 1)
                                text.message = "Sell";
                            else if (grandExchangeInformation[slot][0] == 2)
                                text.message = "Canceled";
                        }
                        drawInterface(0, k2, rsinterface, l2);
                    } else if (class9_1.type == 23) {
                        int displayColor = class9_1.colorTypes[class9_1.progressBarState];
                        int drawingWidth = class9_1.progressBarPercentage * class9_1.width / 100;

                        DrawingArea.drawPixels(class9_1.height, l2, k2, 0x2B261E, class9_1.width);
                        DrawingArea.drawPixels(class9_1.height, l2, k2, displayColor, drawingWidth);
                        DrawingArea.drawAlphaBox(k2, l2, class9_1.width, 4, 0, 75);
                        DrawingArea.drawAlphaBox(k2, l2 + 4, 4, class9_1.height - 4, 0, 75);
                        DrawingArea.fillPixels(k2, class9_1.width, class9_1.height, 0, l2);
                    }
                }

            }

            DrawingArea.method333(l1, i1, k1, j1);
        }

    }

    public final void method106(Background Background, int i) {
        short j = 256;
        if (i >= 0) {
            stream.writeByte(126);
        }

        int l1;
        for (l1 = 0; l1 < this.anIntArray1190.length; ++l1) {
            this.anIntArray1190[l1] = 0;
        }

        int j2;
        for (l1 = 0; l1 < 5000; ++l1) {
            j2 = (int) (Math.random() * 128.0D * (double) j);
            this.anIntArray1190[j2] = (int) (Math.random() * 256.0D);
        }

        int l2;
        int i3;
        for (l1 = 0; l1 < 20; ++l1) {
            for (j2 = 1; j2 < j - 1; ++j2) {
                for (l2 = 1; l2 < 127; ++l2) {
                    i3 = l2 + (j2 << 7);
                    this.anIntArray1191[i3] = (this.anIntArray1190[i3 - 1] + this.anIntArray1190[i3 + 1]
                            + this.anIntArray1190[i3 - 128] + this.anIntArray1190[i3 + 128]) / 4;
                }
            }

            int[] var10 = this.anIntArray1190;
            this.anIntArray1190 = this.anIntArray1191;
            this.anIntArray1191 = var10;
        }

        if (Background != null) {
            l1 = 0;

            for (j2 = 0; j2 < Background.anInt1453; ++j2) {
                for (l2 = 0; l2 < Background.anInt1452; ++l2) {
                    if (Background.aByteArray1450[l1++] != 0) {
                        i3 = l2 + 16 + Background.anInt1454;
                        int var101 = j2 + 16 + Background.anInt1455;
                        int k3 = i3 + (var101 << 7);
                        this.anIntArray1190[k3] = 0;
                    }
                }
            }
        }

    }

    private void method107(int i, int j, Buffer stream, Player player) {

        if ((i & 0x400) != 0) {
            player.anInt1543 = stream.method428();
            player.anInt1545 = stream.method428();
            player.anInt1544 = stream.method428();
            player.anInt1546 = stream.method428();
            player.anInt1547 = stream.method436() + loopCycle;
            player.anInt1548 = stream.method435() + loopCycle;
            player.anInt1549 = stream.method428();
            player.method446();
        }

        if ((i & 0x100) != 0) {
            player.anInt1520 = stream.method434();
            int l1 = stream.readInt();
            player.anInt1524 = l1 >> 16;
            player.anInt1523 = loopCycle + (l1 & '\uffff');
            player.anInt1521 = 0;
            player.anInt1522 = 0;
            if (player.anInt1523 > loopCycle) {
                player.anInt1521 = -1;
            }

            if (player.anInt1520 == '\uffff') {
                player.anInt1520 = -1;
            }
        }

        if ((i & 8) != 0) {
           int l1 = stream.method434();
            if (l1 == '\uffff')
                l1 = -1;
            int l2 = stream.method427();
            if (l1 == player.anim && l1 != -1) {
                int i3  = Animation.anims[l1].replayMode;
                if (i3  == 1) {
                    player.anInt1527 = 0;
                    player.anInt1528 = 0;
                    player.anInt1529 = l2;
                    player.anInt1530 = 0;
                }

                if (i3  == 2)
                    player.anInt1530 = 0;
            } else if (l1 == -1 || player.anim == -1
                    || Animation.anims[l1].forcedwalkingPrecedence >= Animation.anims[player.anim].forcedwalkingPrecedence) {
                player.anim = l1;
                player.anInt1527 = 0;
                player.anInt1528 = 0;
                player.anInt1529 = l2;
                player.anInt1530 = 0;
                player.anInt1542 = player.smallXYIndex;
            }
        }

        if ((i & 4) != 0) {
            player.aString1506 = stream.method415();
            if (player.aString1506.charAt(0) == 126) {
                player.aString1506 = player.aString1506.substring(1);
                this.pushMessage(player.aString1506, 2, player.name);
            } else if (player == myPlayer) {
                this.pushMessage(player.aString1506, 2, player.name);
            }

            player.anInt1513 = 0;
            player.anInt1531 = 0;
            player.textCycle = 150;
        }

        if ((i & 0x80) != 0) {
            int l1 = stream.method434();
            int l2 = stream.readUnsignedByte();
            int stream_1 = stream.method427();
            int var151 = stream.currentOffset;
            if (player.name != null && player.visible) {
                long var161 = TextClass.longForName(player.name);
                boolean flag = false;
                if (l2 <= 1) {
                    for (int var141 = 0; var141 < this.anInt822; ++var141) {
                        if (this.aLongArray925[var141] == var161) {
                            flag = true;
                            break;
                        }
                    }
                }

                if (!flag && this.anInt1251 == 0) {
                    try {
                        this.astream_834.currentOffset = 0;
                        stream.method442(stream_1, 0, true,
                                this.astream_834.buffer);
                        this.astream_834.currentOffset = 0;
                        String var17 = TextInput.method525(stream_1, true, this.astream_834);
                        var17 = Censor.method497(var17, 0);
                        player.aString1506 = var17;
                        player.anInt1513 = l1 >> 8;
                        player.anInt1531 = l1 & 255;
                        player.textCycle = 150;
                        switch (l2) {
                            case 1:
                                this.pushMessage(var17, 1, "@cr1@" + player.name,
                                        playerTitle.title(player.title, player));
                                break;
                            case 2:
                                this.pushMessage(var17, 1, "@cr2@" + player.name,
                                        playerTitle.title(player.title, player));
                                break;
                            case 3:
                                this.pushMessage(var17, 1, "@cr3@" + player.name,
                                        playerTitle.title(player.title, player));
                                break;
                            case 4:
                                this.pushMessage(var17, 1, "@cr4@" + player.name,
                                        playerTitle.title(player.title, player));
                                break;
                            case 5:
                                this.pushMessage(var17, 1, "@cr5@" + player.name,
                                        playerTitle.title(player.title, player));
                                break;
                            case 6:
                                this.pushMessage(var17, 1, "@cr6@" + player.name,
                                        playerTitle.title(player.title, player));
                                break;
                            case 7:
                                this.pushMessage(var17, 1, "@cr7@" + player.name,
                                        playerTitle.title(player.title, player));
                                break;
                            case 8:
                                this.pushMessage(var17, 1, "@cr8@" + player.name,
                                        playerTitle.title(player.title, player));
                                break;
                            case 9:
                                this.pushMessage(var17, 1, "@cr9@" + player.name,
                                        playerTitle.title(player.title, player));
                                break;
                            case 10:
                                this.pushMessage(var17, 1, "@cr10@" + player.name,
                                        playerTitle.title(player.title, player));
                                break;
                            case 11:
                                this.pushMessage(var17, 1, "@cr11@" + player.name,
                                        playerTitle.title(player.title, player));
                                break;
                            case 12:
                                this.pushMessage(var17, 1, "@cr12@" + player.name,
                                        playerTitle.title(player.title, player));
                                break;
                            case 13:
                                this.pushMessage(var17, 1, "@cr13@" + player.name,
                                        playerTitle.title(player.title, player));
                                break;
                            case 14:
                                this.pushMessage(var17, 1, "@cr14@" + player.name,
                                        playerTitle.title(player.title, player));
                                break;
                            case 15:
                                this.pushMessage(var17, 1, "@cr15@" + player.name,
                                        playerTitle.title(player.title, player));
                                break;
                            case 16:
                                this.pushMessage(var17, 1, "@cr16@" + player.name,
                                        playerTitle.title(player.title, player));
                                break;
                            case 17:
                                this.pushMessage(var17, 1, "@cr17@" + player.name,
                                        playerTitle.title(player.title, player));
                                break;
                            case 18:
                                this.pushMessage(var17, 1, "@cr18@" + player.name,
                                        playerTitle.title(player.title, player));
                                break;
                            case 19:
                                this.pushMessage(var17, 1, "@cr19@" + player.name,
                                        playerTitle.title(player.title, player));
                                break;
                            case 20:
                                this.pushMessage(var17, 1, "@cr20@" + player.name,
                                        playerTitle.title(player.title, player));
                                break;
                            case 21:
                                this.pushMessage(var17, 1, "@cr21@" + player.name,
                                        playerTitle.title(player.title, player));
                                break;
                            case 22:
                                this.pushMessage(var17, 1, "@cr22@" + player.name,
                                        playerTitle.title(player.title, player));
                                break;
                            case 23:
                                this.pushMessage(var17, 1, "@cr23@" + player.name,
                                        playerTitle.title(player.title, player));
                                break;
                            case 24:
                                this.pushMessage(var17, 1, "@cr24@" + player.name,
                                        playerTitle.title(player.title, player));
                                break;
                            case 25:
                                this.pushMessage(var17, 1, "@cr25@" + player.name,
                                        playerTitle.title(player.title, player));
                                break;
                            default:
                                this.pushMessage(var17, 2, player.name,
                                        playerTitle.title(player.title, player));
                        }
                    } catch (Exception var14) {
                        SignLink.reporterror("cde2");
                    }
                }
            }

            stream.currentOffset = var151 + stream_1;
        }

        if ((i & 1) != 0) {
            player.interactingEntity = stream.method434();
            if (player.interactingEntity == '\uffff') {
                player.interactingEntity = -1;
            }
        }

        if ((i & 16) != 0) {
            int l1 = stream.method427();
            byte[] var15 = new byte[l1];
            Buffer var16 = new Buffer(var15, 891);
            stream.readBytes(l1, this.aByte920, 0, var15);
            this.astreamArray895[j] = var16;
            player.method451(var16);
        }

        if ((i & 2) != 0) {
            player.anInt1538 = stream.method436();
            player.anInt1539 = stream.method434();
        }

        if ((i & 32) != 0) {
           int l1 = stream.readUnsignedByte();
           int l2 = stream.method426(0);
            player.method447(l2, l1, loopCycle);
            player.anInt1532 = loopCycle + 300;
            player.maxHealth = stream.method427();
            player.currentHealth = stream.readUnsignedByte();
        }

        if ((i & 512) != 0) {
           int l1 = stream.readUnsignedByte();
           int l2 = stream.method428();
            player.method447(l2, l1, loopCycle);
            player.anInt1532 = loopCycle + 300;
            player.maxHealth = stream.readUnsignedByte();
            player.currentHealth = stream.method427();
        }

    }

    public final void method108(int i) {
        if (i != 3) {
            this.incomingPacket = -1;
        }

        try {
            int var121 = myPlayer.x + this.anInt1278;
            int k = myPlayer.y + this.anInt1131;
            if (this.anInt1014 - var121 < -500 || this.anInt1014 - var121 > 500 || this.anInt1015 - k < -500
                    || this.anInt1015 - k > 500) {
                this.anInt1014 = var121;
                this.anInt1015 = k;
            }

            if (this.anInt1014 != var121) {
                this.anInt1014 += (var121 - this.anInt1014) / 16;
            }

            if (this.anInt1015 != k) {
                this.anInt1015 += (k - this.anInt1015) / 16;
            }

            if (super.anIntArray30[1] == 1) {
                this.anInt1186 += (-24 - this.anInt1186) / 2;
            } else if (super.anIntArray30[2] == 1) {
                this.anInt1186 += (24 - this.anInt1186) / 2;
            } else {
                this.anInt1186 /= 2;
            }

            if (super.anIntArray30[3] == 1) {
                this.anInt1187 += (12 - this.anInt1187) / 2;
            } else if (super.anIntArray30[4] == 1) {
                this.anInt1187 += (-12 - this.anInt1187) / 2;
            } else {
                this.anInt1187 /= 2;
            }

            this.anInt1185 = this.anInt1185 + this.anInt1186 / 2 & 2047;
            this.anInt1184 += this.anInt1187 / 2;
            if (this.anInt1184 < 128) {
                this.anInt1184 = 128;
            }

            if (this.anInt1184 > 383) {
                this.anInt1184 = 383;
            }

            int l = this.anInt1014 >> 7;
            int i1 = this.anInt1015 >> 7;
            int j1 = this.method42(this.plane, this.anInt1015, this.anInt1014);
            int k1 = 0;
            int j2;
            if (l > 3 && i1 > 3 && l < 100 && i1 < 100) {
                for (j2 = l - 4; j2 <= l + 4; ++j2) {
                    for (int k2 = i1 - 4; k2 <= i1 + 4; ++k2) {
                        int l2 = this.plane;
                        if (l2 < 3 && (this.byteGroundArray[1][j2][k2] & 2) == 2) {
                            ++l2;
                        }

                        int i3 = j1 - this.anIntArrayArrayArray1214[l2][j2][k2];
                        if (i3 > k1) {
                            k1 = i3;
                        }
                    }
                }
            }

            ++anInt1005;
            if (anInt1005 > 1512) {
                anInt1005 = 0;
                stream.createFrame(77);
                stream.writeByte(0);
                j2 = stream.currentOffset;
                stream.writeByte((int) (Math.random() * 256.0D));
                stream.writeByte(101);
                stream.writeByte(233);
                stream.method399('\ub024');
                if ((int) (Math.random() * 2.0D) == 0) {
                    stream.method399('\u8bc8');
                }

                stream.writeByte((int) (Math.random() * 256.0D));
                stream.writeByte(64);
                stream.writeByte(38);
                stream.method399((int) (Math.random() * 65536.0D));
                stream.method399((int) (Math.random() * 65536.0D));
                stream.method407(stream.currentOffset - j2, (byte) 0);
            }

            j2 = k1 * 192;
            if (j2 > 98048) {
                j2 = 98048;
            }

            if (j2 < '\u8000') {
                j2 = '\u8000';
            }

            if (j2 > this.anInt984) {
                this.anInt984 += (j2 - this.anInt984) / 24;
            } else if (j2 < this.anInt984) {
                this.anInt984 += (j2 - this.anInt984) / 80;
            }

        } catch (Exception var12) {
            SignLink.reporterror(
                    "glfc_ex " + myPlayer.x + "," + myPlayer.y + "," + this.anInt1014 + "," + this.anInt1015 + ","
                            + this.mapRegionsX + "," + this.mapRegionsY + "," + this.baseX + "," + this.baseY);
            throw new RuntimeException("eek");
        }
    }

    public final void method9(int i) {
        if (!this.aBoolean1252 && !this.aBoolean926 && !this.aBoolean1176) {
            ++anInt1061;
            if (i != 0) {
                this.incomingPacket = -1;
            }

            if (!loggedIn) {
                this.drawLoginScreen(false);
            } else {
                this.drawGameScreen();
            }

            this.anInt1213 = 0;
        } else {
            this.method94(-13873);
        }

    }

    public final boolean isFriendOrSelf(String s) {
        if (s == null) {
            return false;
        } else {
            for (int i = 0; i < this.friendsCount; ++i) {
                if (s.equalsIgnoreCase(this.friendsList[i])) {
                    return true;
                }
            }

            return s.equalsIgnoreCase(myPlayer.name);
        }
    }

    private void drawGrid() {
        for (int index = 0; index < 516; index += 10) {
            if (index < 334) {
                DrawingArea.drawTransparentHorizontalLine(0, index, 516, 0xff0000, 90);
            }
            DrawingArea.drawTransparentVerticalLine(index, 0, 334, 0xff0000, 90);
        }

        int xPos = super.mouseX - 4 - ((super.mouseX - 4) % 10);
        int yPos = super.mouseY - 4 - ((super.mouseY - 4) % 10);

        DrawingArea.drawTransparentBoxOutline(xPos, yPos, 10, 10, 0xffffff, 255);
        newSmallFont.drawCenteredString("(" + (xPos + 4) + ", " + (yPos + 4) + ")", xPos + 4, yPos - 1, 0xffff00, 0);
        this.pushMessage("(" + (xPos + 4) + ", " + (yPos + 4) + ")", 0, "");
    }

    public final void method111(byte byte0, int i) {
        if (byte0 != 2) {
            this.method6();
        }

        SignLink.wavevol = i;
    }

    public final void draw3dScreen() {
        if (currentScreenMode == ScreenMode.FIXED) {
            mapArea[1].drawSprite(516, 0);
            mapArea[7].drawSprite(0, 0);
        }
        drawTargetInfo();
        if (fadingScreen != null) {
            fadingScreen.draw();
        }
        if (gameTimers) {
            try {
                int startX = 516;
                int startY = Main.currentScreenMode == ScreenMode.FIXED ? 294 : Main.currentGameHeight - 209;
                GameTimerHandler.getSingleton().drawGameTimers(this, startX, startY);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        int y;
        if (this.crossType == 1) {
            y = currentScreenMode == Main.ScreenMode.FIXED ? 4 : 0;
            this.aSpriteArray1150[this.crossIndex / 100].drawSprite(this.anInt914 - 8 - y, this.anInt915 - 8 - y);
            ++anInt1142;
            if (anInt1142 > 67) {
                anInt1142 = 0;
                stream.createFrame(78);
            }
        }

        if (this.crossType == 2) {
            y = currentScreenMode == Main.ScreenMode.FIXED ? 4 : 0;
            this.aSpriteArray1150[4 + this.crossIndex / 100].drawSprite(this.anInt914 - 8 - y, this.anInt915 - 8 - y);
        }

/*		if (openWalkableInterface != -1) {
			method119(tickDelta, openWalkableInterface);
			if (openWalkableInterface == 197 && currentScreenMode != ScreenMode.FIXED) {
				skullIcons[0].drawSprite(currentGameWidth - 157, 168);
				String text = Widget.interfaceCache[199].message.replace("@yel@", "");
				regularText.drawChatInput(0xE1981D, currentGameWidth - 165, text, 207, true);
			} else if (openWalkableInterface == 201 && currentScreenMode != ScreenMode.FIXED) {
				drawInterface(0, currentGameWidth - 560, Widget.interfaceCache[openWalkableInterface], -109);
			} else {
				drawInterface(0, currentScreenMode == ScreenMode.FIXED ? 0 : (currentGameWidth / 2) - 356,
						Widget.interfaceCache[openWalkableInterface],
						currentScreenMode == ScreenMode.FIXED ? 0 : (currentGameHeight / 2) - 230);
			}
		}*/
        if (openWalkableInterface != -1) {
            method119(tickDelta, openWalkableInterface);
            Widget rsinterface = Widget.interfaceCache[openWalkableInterface];
            if (currentScreenMode == ScreenMode.FIXED) {
                drawInterface(0, 0, rsinterface, 0);
            } else {
                if (openWalkableInterface == 28000 || openWalkableInterface == 28020 || openWalkableInterface == 16210
                        || openWalkableInterface == 27500 || openWalkableInterface == 196) {
                    /**
                     * Interfaces to draw at the top right corner nex to the minimap (Ex. Wildy
                     * Target)
                     **/
                    drawInterface(0, currentGameWidth - 730, rsinterface, 20);
                } else if (openWalkableInterface == 197) {
                    drawInterface(0, currentGameWidth - 530, rsinterface, -70);
                    // } else if (openInterfaceID == 5292) {
                    // method119(tickDelta, openInterfaceID);
                    // drawInterface(0, currentScreenMode == ScreenMode.FIXED ? 0 :
                    // (currentGameWidth / 2) - 356, Widget.interfaceCache[openInterfaceID],
                    // currentScreenMode == ScreenMode.FIXED ? 0 : (gameScreenHeight / 2) - 230);
                } else if (openWalkableInterface == 21100 || openWalkableInterface == 21119
                        || openWalkableInterface == 29230) {
                    /**
                     * Interfaces to draw at top left corner (Ex. Pest Control)
                     **/
                    drawInterface(0, 0, rsinterface, 0);
                } else if (openWalkableInterface == 201) {
                    /** Duel arena interface **/
                    drawInterface(0, currentGameWidth - 510, rsinterface, -110);
                } else if (centerInterface() || openInterfaceID == 29230) {
                    drawInterface(0, (currentGameWidth / 2) - 356, rsinterface,
                            currentScreenMode == ScreenMode.FIXED ? 0 : (currentGameHeight / 2) - 230);
                } else {
                    if (currentGameWidth >= 900 && currentGameHeight >= 650) {
                        drawInterface(0, (currentGameWidth / 2) - 356, Widget.interfaceCache[openWalkableInterface], currentScreenMode == ScreenMode.FIXED ? 0 : (currentGameHeight / 2) - 230);
                    } else {
                        drawInterface(0, 0, Widget.interfaceCache[openWalkableInterface], 0);
                    }
                }
            }
        }
        if (openInterfaceID != -1) {
            method119(tickDelta, openInterfaceID);
            Widget rsinterface = Widget.interfaceCache[openInterfaceID];
            if (currentScreenMode == ScreenMode.FIXED)
                drawInterface(0, 0, rsinterface, 0);
            else if (currentGameWidth >= 900 && currentGameHeight >= 650) {
                drawInterface(0, (currentGameWidth / 2) - 356, rsinterface, currentScreenMode == ScreenMode.FIXED ? 0 : (currentGameHeight / 2) - 230);
            } else {
                drawInterface(0, 0, rsinterface, 0);
            }

        }
        method70();
        if (this.anInt1055 == 1) {
            multiOverlay.drawSprite(currentScreenMode == Main.ScreenMode.FIXED ? 472 : currentGameWidth - 85,
                    currentScreenMode == Main.ScreenMode.FIXED ? 296 : 186);
        }
        if (!menuOpen) {
            processRightClick();
            drawTooltip();
        } else if (menuScreenArea == 0) {
            drawMenu(currentScreenMode == ScreenMode.FIXED ? 0 : 0, currentScreenMode == ScreenMode.FIXED ? 0 : 0);
        }
        int var14;
        if (fpsOn) {
            int yPosition = 30;
            int xPosition = currentScreenMode == ScreenMode.FIXED ? 515 : currentGameWidth - 222;
            int textColor = 0xffff00;
            if (super.fps < 15)
                textColor = 0xff0000;
            this.regularText.method380("Fps:" + super.fps, xPosition, textColor, yPosition);
            yPosition += 15;
            Runtime runtime = Runtime.getRuntime();
            int var12 = (int) ((runtime.totalMemory() - runtime.freeMemory()) / 1024L);
            y = 16776960;
            if (var12 > 0x2000000 && lowMem) {
                y = 0xff0000;
            }

            this.regularText.method380("Mem:" + var12 + "k", xPosition, textColor,
                    yPosition);
            yPosition += 15;
        }

        var14 = this.baseX + (myPlayer.x - 6 >> 7);
        y = this.baseY + (myPlayer.y - 6 >> 7);
        int var131 = var14 >> 6;
        int var12 = y >> 6;
        int chunkX = var14 >> 3;
        int var141 = y >> 3;
        int regionid = var131 * 256 + var12;
        int mapx = mapRegionsX; // map region x
        int mapy = mapRegionsY; // map region y
        int var17;
        if (clientData) {
            if (super.fps < 15) {

            }
            Runtime runtime = Runtime.getRuntime();
            int j1 = (int) ((runtime.totalMemory() - runtime.freeMemory()) / 1024L);
            if (j1 > 0x2000000 && lowMem) {

            }
            regularText.method385(0x00FF00, "Players Nearby: " + playerCount, 27, 5);
            regularText.method385(0x00FF00, "Npcs Nearby: " + npcCount, 41, 5);

            if (mapx > 1000 || mapy > 1000) {
                regularText.method385(0xffff00, "Current Region: " + mapx + ", " + mapy + ", Region ID: " + regionid, 55, 5);
            } else {
                regularText.method385(0xffff00, "Current Region: 0" + mapx + ", 0" + mapy + ", Region ID: " + regionid, 55, 5);
            }
            for (int num = 0; num < anIntArray1235.length; num++) {
                int[] flo = anIntArray1235;
                regularText.method385(0xffff00, "Floor map: " + Arrays.toString(flo), 69, 5);
            }
            for (int num = 0; num < anIntArray1236.length; num++) {
                int[] obj = anIntArray1236;
                regularText.method385(0xffff00, "Object map: " + Arrays.toString(obj), 83, 5);
                // output: "Object map: "[1, 3, 5, 7, 9]"
            }

            regularText.method385(0xffff00, "Map Data: " + anIntArray1235[0] + ".dat", 97, 5);
            regularText.method385(0xffff00, "Fps: " + super.fps, 111, 5);
            regularText.method385(0xffff00, "Memory Used: " + j1 + "k", 125, 5);
            regularText.method385(0xffff00,
                    "Mouse Position: X: " + super.mouseX + " , Mouse Y: " + super.mouseY, 139, 5);
            regularText.method385(0xffff00, "Coordinates: X: " + var14 + ", Y: " + y, 153, 5);

            regularText.method385(0xffff00,
                    "Camera Position: X: " + xCameraPos + ", Y: " + yCameraPos + ", Z: " + zCameraPos, 167, 5);
            regularText.method385(0xffff00, "Camera Curve: X: " + xCameraCurve + ", Y: " + yCameraCurve, 181,
                    5);

            // private int xCameraPos;ds
            // private int zCameraPos;
            // private int yCameraPos;
            // private int yCameraCurve;
            // private int xCameraCurve;
        }

        if (this.anInt1104 != 0) {
            int var15 = this.anInt1104 / 50;
            var17 = var15 / 60;
            int var16 = currentScreenMode == Main.ScreenMode.FIXED ? 0 : currentGameHeight - 498;
            var15 %= 60;
            if (var15 < 10) {
                this.regularText.method385(16776960,
                        "Please log out to save your character - system update in: " + var17 + ":0" + var15,
                        329 + var16, 4);
            } else {
                this.regularText.method385(16776960,
                        "Please log out to save your character - system update in:  " + var17 + ":" + var15,
                        329 + var16, 4);
            }

            ++anInt849;
            if (anInt849 > 75) {
                anInt849 = 0;
                stream.createFrame(148);
            }
        }

    }

    public final void method113(long l, int i) {
        try {
            if (l != 0L) {
                if (this.anInt822 >= 100) {
                    this.pushMessage("Your ignore list is full. Max of 100 hit", 0, "");
                } else {
                    String var61 = TextClass.fixName(TextClass.nameForLong(l));

                    int k;
                    for (k = 0; k < this.anInt822; ++k) {
                        if (this.aLongArray925[k] == l) {
                            this.pushMessage(var61 + " is already on your ignore list", 0, "");
                            return;
                        }
                    }

                    if (i >= 4 && i <= 4) {
                        for (k = 0; k < this.friendsCount; ++k) {
                            if (this.friendsListAsLongs[k] == l) {
                                this.pushMessage("Please remove " + var61 + " from your friend list first", 0, "");
                                return;
                            }
                        }

                        this.aLongArray925[this.anInt822++] = l;
                        stream.createFrame(133);
                        stream.method404(5, l);
                    }
                }
            }

        } catch (RuntimeException var6) {
            SignLink.reporterror("45688, " + l + ", " + i + ", " + var6.toString());
            throw new RuntimeException();
        }
    }

    public void method114() {
        for (int i = -1; i < this.playerCount; ++i) {
            int j;
            if (i == -1)
                j = this.myPlayerIndex;
            else
                j = this.playerIndices[i];
            Player player = this.playerArray[j];
            if (player != null)
                this.method96(player);
        }
    }

    private final void method115(byte byte0) {
        if (byte0 != 8) {
            stream.writeByte(101);
        }

        if (this.anInt1023 == 2) {
            for (Class30_Sub1 class30_sub1 = (Class30_Sub1) this.aClass19_1179
                    .reverseGetFirst(); class30_sub1 != null; class30_sub1 = (Class30_Sub1) this.aClass19_1179
                    .reverseGetNext()) {
                if (class30_sub1.anInt1294 > 0) {
                    --class30_sub1.anInt1294;
                }

                if (class30_sub1.anInt1294 == 0) {
                    if (class30_sub1.anInt1299 < 0
                            || ObjectManager.method178(class30_sub1.anInt1299, class30_sub1.anInt1301)) {
                        this.method142(class30_sub1.anInt1298, class30_sub1.anInt1295, class30_sub1.anInt1300,
                                class30_sub1.anInt1301, class30_sub1.anInt1297, class30_sub1.anInt1296,
                                class30_sub1.anInt1299, 4);
                        class30_sub1.unlink();
                    }
                } else {
                    if (class30_sub1.anInt1302 > 0) {
                        --class30_sub1.anInt1302;
                    }

                    if (class30_sub1.anInt1302 == 0 && class30_sub1.anInt1297 >= 1 && class30_sub1.anInt1298 >= 1
                            && class30_sub1.anInt1297 <= 102 && class30_sub1.anInt1298 <= 102
                            && (class30_sub1.anInt1291 < 0
                            || ObjectManager.method178(class30_sub1.anInt1291, class30_sub1.anInt1293))) {
                        this.method142(class30_sub1.anInt1298, class30_sub1.anInt1295, class30_sub1.anInt1292,
                                class30_sub1.anInt1293, class30_sub1.anInt1297, class30_sub1.anInt1296,
                                class30_sub1.anInt1291, 4);
                        class30_sub1.anInt1302 = -1;
                        if (class30_sub1.anInt1291 == class30_sub1.anInt1299 && class30_sub1.anInt1299 == -1) {
                            class30_sub1.unlink();
                        } else if (class30_sub1.anInt1291 == class30_sub1.anInt1299
                                && class30_sub1.anInt1292 == class30_sub1.anInt1300
                                && class30_sub1.anInt1293 == class30_sub1.anInt1301) {
                            class30_sub1.unlink();
                        }
                    }
                }
            }
        }

    }

    private void determineMenuSize() {
        int i = newBoldFont.getTextWidth("Choose Option");
        for (int j = 0; j < menuActionRow; j++) {
            int k = newBoldFont.getTextWidth(menuActionName[j]);
            if (k > i)
                i = k;
        }
        i += 8;
        int l = 15 * menuActionRow + 21;
        if (super.saveClickX > 0 && super.saveClickY > 0 && super.saveClickX < currentGameWidth
                && super.saveClickY < currentGameHeight) {
            int xClick = super.saveClickX - i / 2;
            if (xClick + i > currentGameWidth - 4) {
                xClick = currentGameWidth - 4 - i;
            }
            if (xClick < 0) {
                xClick = 0;
            }
            int yClick = super.saveClickY - 0;
            if (yClick + l > currentGameHeight - 2) {
                yClick = currentGameHeight - 2 - l;
            }
            if (yClick < 0) {
                yClick = 0;
            }
            menuOpen = true;
            menuOffsetX = xClick;
            menuOffsetY = yClick;
            menuWidth = i;
            menuHeight = 15 * menuActionRow + 22;
        }

    }

    private final void method117(Buffer stream, int i, byte byte0) {
        stream.method418(this.anInt1118);
        if (byte0 != 5) {
            this.incomingPacket = stream.readUnsignedByte();
        }

        int j = stream.method419(1, 0);
        if (j != 0) {
            int k = stream.method419(2, 0);
            if (k == 0) {
                this.anIntArray894[this.anInt893++] = this.myPlayerIndex;
            } else {
                int j1;
                int i2;
                if (k == 1) {
                    j1 = stream.method419(3, 0);
                    myPlayer.method448(false, (byte) 20, j1);
                    i2 = stream.method419(1, 0);
                    if (i2 == 1) {
                        this.anIntArray894[this.anInt893++] = this.myPlayerIndex;
                    }
                } else {
                    int k2;
                    if (k == 2) {
                        j1 = stream.method419(3, 0);
                        myPlayer.method448(true, (byte) 20, j1);
                        i2 = stream.method419(3, 0);
                        myPlayer.method448(true, (byte) 20, i2);
                        k2 = stream.method419(1, 0);
                        if (k2 == 1) {
                            this.anIntArray894[this.anInt893++] = this.myPlayerIndex;
                        }
                    } else if (k == 3) {
                        this.plane = stream.method419(2, 0);
                        j1 = stream.method419(1, 0);
                        i2 = stream.method419(1, 0);
                        if (i2 == 1) {
                            this.anIntArray894[this.anInt893++] = this.myPlayerIndex;
                        }

                        k2 = stream.method419(7, 0);
                        int l2 = stream.method419(7, 0);
                        myPlayer.method445(l2, k2, j1 == 1, false);
                    }
                }
            }
        }

    }

    public final void method118(int i) {
        this.aBoolean831 = false;

        while (this.aBoolean962) {
            this.aBoolean831 = false;

            try {
                Thread.sleep(50L);
            } catch (Exception var3) {
            }
        }

        this.aBackground_966 = null;
        this.aBackground_967 = null;
        this.anIntArray850 = null;
        this.anIntArray851 = null;
        this.anIntArray852 = null;
        this.anIntArray853 = null;
        this.anIntArray1190 = null;
        this.anIntArray1191 = null;
        this.anIntArray828 = null;
        this.aSprite_1201 = null;
        this.aSprite_1202 = null;
        if (i < 3 || i > 3) {
            this.aClass19ArrayArrayArray827 = null;
        }

    }

    /*
     * public final boolean method119(int i, int j) { boolean flag1 = false; Widget
     * class9 = Widget.interfaceCache[j];
     *
     * for (int k = 0; k < class9.children.length && class9.children[k] != -1; ++k)
     * { Widget class9_1 = Widget.interfaceCache[class9.children[k]]; if
     * (class9_1.type == 1) { flag1 |= this.method119(i, class9_1.id); }
     *
     * if (class9_1.type == 6 && (class9_1.anInt257 != -1 || class9_1.anInt258 !=
     * -1)) { boolean flag2 = this.method131(class9_1); int l; if (flag2) { l =
     * class9_1.anInt258; } else { l = class9_1.anInt257; }
     *
     * if (l != -1) { Animation class20 = Animation.anims[l];
     *
     * for (class9_1.anInt208 += i; class9_1.anInt208 >
     * class20.method258(class9_1.anInt246); flag1 = true) { class9_1.anInt208 -=
     * class20.method258(class9_1.anInt246) + 1; ++class9_1.anInt246; if
     * (class9_1.anInt246 >= class20.frameCount) { class9_1.anInt246 -=
     * class20.loopOffset; if (class9_1.anInt246 < 0 || class9_1.anInt246 >=
     * class20.frameCount) { class9_1.anInt246 = 0; } } } } } }
     *
     * return flag1; }
     */
    private boolean method119(int i, int j) {
        boolean flag1 = false;
        Widget class9 = Widget.interfaceCache[j];
        for (int k = 0; k < class9.children.length; k++) {
            if (class9.children[k] == -1)
                break;
            Widget class9_1 = Widget.interfaceCache[class9.children[k]];
            if (class9_1.type == 1)
                flag1 |= method119(i, class9_1.id);
            if (class9_1.type == 6 && (class9_1.anInt257 != -1 || class9_1.anInt258 != -1)) {
                boolean flag2 = method131(class9_1);
                int l;
                if (flag2)
                    l = class9_1.anInt258;
                else
                    l = class9_1.anInt257;
                if (l != -1) {
                    Animation animation = Animation.anims[l];
                    for (class9_1.anInt208 += i; class9_1.anInt208 > animation.method258(class9_1.anInt246); ) {
                        class9_1.anInt208 -= animation.method258(class9_1.anInt246) + 1;
                        class9_1.anInt246++;
                        if (class9_1.anInt246 >= animation.frameCount) {
                            class9_1.anInt246 -= animation.loopOffset;
                            if (class9_1.anInt246 < 0 || class9_1.anInt246 >= animation.frameCount)
                                class9_1.anInt246 = 0;
                        }
                        flag1 = true;
                    }

                }
            }
        }

        return flag1;
    }

    public final int method120(int i) {
        if (i <= 0) {
            aBoolean1224 = !aBoolean1224;
        }

        if (Constants.roofsOff) {
            return this.plane;
        } else {
            int j = 3;
            if (this.yCameraCurve < 310) {
                int k = this.xCameraPos >> 7;
                int l = this.yCameraPos >> 7;
                int i1 = myPlayer.x >> 7;
                int j1 = myPlayer.y >> 7;
                if ((this.byteGroundArray[this.plane][k][l] & 4) != 0) {
                    j = this.plane;
                }

                int k1;
                if (i1 > k) {
                    k1 = i1 - k;
                } else {
                    k1 = k - i1;
                }

                int l1;
                if (j1 > l) {
                    l1 = j1 - l;
                } else {
                    l1 = l - j1;
                }

                int j2;
                int l2;
                if (k1 > l1) {
                    j2 = l1 * 65536 / k1;
                    l2 = '\u8000';

                    while (k != i1) {
                        if (k < i1) {
                            ++k;
                        } else if (k > i1) {
                            --k;
                        }

                        if ((this.byteGroundArray[this.plane][k][l] & 4) != 0) {
                            j = this.plane;
                        }

                        l2 += j2;
                        if (l2 >= 65536) {
                            l2 -= 65536;
                            if (l < j1) {
                                ++l;
                            } else if (l > j1) {
                                --l;
                            }

                            if ((this.byteGroundArray[this.plane][k][l] & 4) != 0) {
                                j = this.plane;
                            }
                        }
                    }
                } else {
                    j2 = k1 * 65536 / l1;
                    l2 = '\u8000';

                    while (l != j1) {
                        if (l < j1) {
                            ++l;
                        } else if (l > j1) {
                            --l;
                        }

                        if ((this.byteGroundArray[this.plane][k][l] & 4) != 0) {
                            j = this.plane;
                        }

                        l2 += j2;
                        if (l2 >= 65536) {
                            l2 -= 65536;
                            if (k < i1) {
                                ++k;
                            } else if (k > i1) {
                                --k;
                            }

                            if ((this.byteGroundArray[this.plane][k][l] & 4) != 0) {
                                j = this.plane;
                            }
                        }
                    }
                }
            }

            if ((this.byteGroundArray[this.plane][myPlayer.x >> 7][myPlayer.y >> 7] & 4) != 0) {
                j = this.plane;
            }

            return j;
        }
    }

    public final int method121(int i) {
        if (Constants.roofsOff) {
            return this.plane;
        } else {
            int j = this.method42(this.plane, this.yCameraPos, this.xCameraPos);
            return j - this.zCameraPos < 800
                    && (this.byteGroundArray[this.plane][this.xCameraPos >> 7][this.yCameraPos >> 7] & 4) != 0
                    ? this.plane
                    : 3;
        }
    }

    public final void method122(int i, long l) {
        try {
            if (i != 3) {
                this.method6();
            }

            if (l != 0L) {
                for (int var61 = 0; var61 < this.anInt822; ++var61) {
                    if (this.aLongArray925[var61] == l) {
                        --this.anInt822;

                        for (int k = var61; k < this.anInt822; ++k) {
                            this.aLongArray925[k] = this.aLongArray925[k + 1];
                        }

                        stream.createFrame(74);
                        stream.method404(5, l);
                        return;
                    }
                }
            }

        } catch (RuntimeException var6) {
            SignLink.reporterror("47229, " + i + ", " + l + ", " + var6.toString());
            throw new RuntimeException();
        }
    }

    public String getParameter(String s) {
        return SignLink.mainapp != null ? SignLink.mainapp.getParameter(s) : super.getParameter(s);
    }

    public final void method123(byte byte0, boolean flag, int i) {
        if (byte0 != 0) {
            this.aClass19ArrayArrayArray827 = null;
        }

        SignLink.midivol = i;
        if (flag) {
            SignLink.midi = "voladjust";
        }

    }

    public final int extractInterfaceValues(Widget class9, int j) {
        if (class9.valueIndexArray != null && j < class9.valueIndexArray.length) {
            try {
                int[] var191 = class9.valueIndexArray[j];
                int k = 0;
                int l = 0;
                byte i1 = 0;

                while (true) {
                    int j1 = var191[l++];
                    int k1 = 0;
                    byte byte0 = 0;
                    if (j1 == 0) {
                        return k;
                    }

                    if (j1 == 1) {
                        k1 = this.currentLevels[var191[l++]];
                    }

                    if (j1 == 2) {
                        k1 = this.maximumLevels[var191[l++]];
                    }

                    if (j1 == 3) {
                        k1 = this.currentExp[var191[l++]];
                    }

                    Widget j2;
                    int class37;
                    int l3;
                    if (j1 == 4) {
                        j2 = Widget.interfaceCache[var191[l++]];
                        class37 = var191[l++];
                        if (class37 >= 0 && class37 < ItemDefinition.totalItems
                                && (!ItemDefinition.lookup(class37).membersObject || isMembers)) {
                            for (l3 = 0; l3 < j2.inventoryItemId.length; ++l3) {
                                if (j2.inventoryItemId[l3] == class37 + 1) {
                                    k1 += j2.inventoryAmounts[l3];
                                }
                            }
                        }
                    }

                    if (j1 == 5) {
                        k1 = this.settings[var191[l++]];
                    }

                    if (j1 == 6) {
                        k1 = anIntArray1019[this.maximumLevels[var191[l++]] - 1];
                    }

                    if (j1 == 7) {
                        k1 = this.settings[var191[l++]] * 100 / '\ub71b';
                    }

                    if (j1 == 8) {
                        k1 = myPlayer.combatLevel;
                    }

                    int var18;
                    if (j1 == 9) {
                        for (var18 = 0; var18 < 25; ++var18) {
                            if (Skills.skillEnabled[var18]) {
                                k1 += this.maximumLevels[var18];
                            }
                        }
                    }

                    if (j1 == 10) {
                        j2 = Widget.interfaceCache[var191[l++]];
                        class37 = var191[l++] + 1;
                        if (class37 >= 0 && class37 < ItemDefinition.totalItems
                                && (!ItemDefinition.lookup(class37).membersObject || isMembers)) {
                            for (l3 = 0; l3 < j2.inventoryItemId.length; ++l3) {
                                if (j2.inventoryItemId[l3] == class37) {
                                    k1 = 999999999;
                                    break;
                                }
                            }
                        }
                    }

                    if (j1 == 11) {
                        k1 = this.anInt1148;
                    }

                    if (j1 == 12) {
                        k1 = this.anInt878;
                    }

                    if (j1 == 13) {
                        var18 = this.settings[var191[l++]];
                        class37 = var191[l++];
                        k1 = (var18 & 1 << class37) == 0 ? 0 : 1;
                    }

                    if (j1 == 14) {
                        var18 = var191[l++];
                        VarBit var19 = VarBit.cache[var18];
                        l3 = var19.configId;
                        int i4 = var19.lsb;
                        int j4 = var19.msb;
                        int k4 = BIT_MASKS[j4 - i4];
                        k1 = this.settings[l3] >> i4 & k4;
                    }

                    if (j1 == 15) {
                        byte0 = 1;
                    }

                    if (j1 == 16) {
                        byte0 = 2;
                    }

                    if (j1 == 17) {
                        byte0 = 3;
                    }

                    if (j1 == 18) {
                        k1 = (myPlayer.x >> 7) + this.baseX;
                    }

                    if (j1 == 19) {
                        k1 = (myPlayer.y >> 7) + this.baseY;
                    }

                    if (j1 == 20) {
                        k1 = var191[l++];
                    }

                    if (byte0 == 0) {
                        if (i1 == 0) {
                            k += k1;
                        }

                        if (i1 == 1) {
                            k -= k1;
                        }

                        if (i1 == 2 && k1 != 0) {
                            k /= k1;
                        }

                        if (i1 == 3) {
                            k *= k1;
                        }

                        i1 = 0;
                    } else {
                        i1 = byte0;
                    }
                }
            } catch (Exception var191) {
                return -1;
            }
        } else {
            return -2;
        }
    }

    private void drawTooltip() {
        String s;
        if (menuActionRow < 2 && itemSelected == 0 && spellSelected == 0) {
        	if(MouseIcons){
        		super.setCursor(0);
        	}
        	return;
        }
            if (this.itemSelected == 1 && this.menuActionRow < 2) {
                s = "Use " + this.aString1286 + " with...";
            } else if (this.spellSelected == 1 && this.menuActionRow < 2) {
                s = this.aString1139 + "...";
            } else {
                s = this.menuActionName[this.menuActionRow - 1];
            }

            if (this.menuActionRow > 2) {
                s = s + "@whi@ / " + (this.menuActionRow - 2) + " more options";
            }

            this.newBoldFont.drawBasicString(s, 4, 15, 0xffffff, 0);
            if(MouseIcons){
                boolean hasFoundCursor = false;
                for (int i1 = 0; i1 < cursorInfo.length; i1++) {
                    if (menuActionName[menuActionRow - 1].startsWith(cursorInfo[i1])) {
                        super.setCursor(i1);
                        hasFoundCursor = true;
                    }
                }
                if (!hasFoundCursor) 
                	if(MouseIcons){
                	super.setCursor(0);
                	}
            }
    }

    public final void drawMinimap() {
        if (currentScreenMode == Main.ScreenMode.FIXED) {
            this.aRSImageProducer_1164.initDrawingArea();
        }
		if(currentScreenMode != Main.ScreenMode.FIXED) {
			for(int i = 0; i < 76; i++) {
				int amt = (int)(Math.sqrt(Math.pow(77, 2) - Math.pow(75-i, 2)));
				anIntArray1229[i] = 2 * amt + 2;
				anIntArray1229[150-i] = 2 * amt + 2;
				anIntArray1052[i] = -amt + 73;
				anIntArray1052[150-i] = -amt + 73;
			}
		}
        if (this.anInt1021 == 2) {
            if (currentScreenMode == Main.ScreenMode.FIXED) {
                mapArea[3].drawSprite(0, 4);
            } else {
            	if(!Gameframe508){
                mapArea[2].drawSprite(currentGameWidth - 183, 0);
                mapArea[4].drawSprite(currentGameWidth - 160, 8);
            	} else {
            		  mapArea[2].drawSprite(gameScreenWidth - 182 + 18, 0);
            		worldmapborder.drawSprite(gameScreenWidth - 182 + 11, 0); 
            	}
            }

            if (currentScreenMode != Main.ScreenMode.FIXED && changeTabArea) {
                if ((super.mouseX < currentGameWidth - 26 || super.mouseX > currentGameWidth - 1 || super.mouseY < 2
                        || super.mouseY > 24) && tabID != 10) {
                    this.gameframe[31].drawARGBSprite(currentGameWidth - 25, 2, 165);
                } else {
                    this.gameframe[31].drawSprite(currentGameWidth - 25, 2);
                }
            }

            if (Constants.loadOrbs) {
                this.loadAllOrbs(currentScreenMode == Main.ScreenMode.FIXED ? 0 : currentGameWidth - 217);
            }
            if (oldGameframe && currentScreenMode == ScreenMode.FIXED) {
                compassImage.method352(33, this.anInt1185, anIntArray1057, 256, anIntArray968,
                        (currentScreenMode == ScreenMode.FIXED ? 28 : 25), 4,
                        (currentScreenMode == ScreenMode.FIXED ? 27 : currentGameWidth - 178), 33, 25);
            } else {
                compassImage.method352(33, this.anInt1185, anIntArray1057, 256, anIntArray968,
                        (currentScreenMode == ScreenMode.FIXED ? 25 : 25), 4,
                        (currentScreenMode == ScreenMode.FIXED ? 29 : currentGameWidth - 178), 33, 25);
            }
            if (Gameframe508 && currentScreenMode == ScreenMode.FIXED) {
                compassImage.method352(33, this.anInt1185, anIntArray1057, 256, anIntArray968,
                        (currentScreenMode == ScreenMode.FIXED ? 25 : 25), 8,
                        (currentScreenMode == ScreenMode.FIXED ? 11 : currentGameWidth - 178), 33, 25);
            } else {
                compassImage.method352(33, this.anInt1185, anIntArray1057, 256, anIntArray968,
                        (currentScreenMode == ScreenMode.FIXED ? 25 : 25), 4,
                        (currentScreenMode == ScreenMode.FIXED ? 29 : currentGameWidth - 178), 33, 25);
            }
			if(oldGameframe == true  && Gameframe508 == false && currentScreenMode == ScreenMode.FIXED ){
				compassImage.method352(33, this.anInt1185, anIntArray1057, 256, anIntArray968,
						(currentScreenMode == ScreenMode.FIXED ? 25 : 25), 4,
						(currentScreenMode == ScreenMode.FIXED ? 29 : gameScreenWidth - 178), 33, 25);
			}else if(oldGameframe == true  && Gameframe508 == false && currentScreenMode == ScreenMode.FULLSCREEN ){
				compassImage.method352(33, this.anInt1185, anIntArray1057, 256, anIntArray968,
						(currentScreenMode == ScreenMode.FIXED ? 25 : 25), 4,
						(currentScreenMode == ScreenMode.FIXED ? 29 : currentGameWidth - 178), 33, 25);
			} else if(oldGameframe == false && Gameframe508 == true && currentScreenMode == ScreenMode.FIXED ){
				compassImage.method352(33, this.anInt1185, anIntArray1057, 256, anIntArray968,
						(currentScreenMode == ScreenMode.FIXED ? 29 : 25), 8,
						(currentScreenMode == ScreenMode.FIXED ? 11 : currentGameWidth - 178), 33, 25);
			}else if(oldGameframe == false && Gameframe508 == true && currentScreenMode == ScreenMode.FULLSCREEN ){
				compassImage.method352(33, this.anInt1185, anIntArray1057, 256, anIntArray968,
						(currentScreenMode == ScreenMode.FIXED ? 25 : 25), 8,
						(currentScreenMode == ScreenMode.FIXED ? 29 : currentGameWidth - 178), 33, 25);
			}
            if (this.menuOpen) {
                this.drawMenu(currentScreenMode == Main.ScreenMode.FIXED ? 516 : 0, 0);
            }

            if (currentScreenMode == Main.ScreenMode.FIXED) {
                aRSImageProducer_1165.initDrawingArea();
            }
        } else {
            int i = this.anInt1185 + this.anInt1209 & 2047;
            int j = 48 + myPlayer.x / 32;
            int l2 = 464 - myPlayer.y / 32;		
            if (currentScreenMode == Main.ScreenMode.FIXED) {
    			for (int x = 0; x < anIntArray1229.length; x++){
    				anIntArray1229[x] = 170;
    				anIntArray1052[x] = -23;
    			}
    		}
            if (oldGameframe == false && Gameframe508 == false) {
                this.minimapImage.method352(151, i, this.anIntArray1229, 256 + this.anInt1170, this.anIntArray1052,
                        l2, currentScreenMode == Main.ScreenMode.FIXED ? 9 : 7,
                        currentScreenMode == Main.ScreenMode.FIXED ? 54 : currentGameWidth - 158, 146, j);
            } else if (oldGameframe == true && Gameframe508 == false) {
                this.minimapImage.method352(151, i, this.anIntArray1229, 256 + this.anInt1170, this.anIntArray1052,
                        l2, currentScreenMode == Main.ScreenMode.FIXED ? 9 : 7,
                        currentScreenMode == Main.ScreenMode.FIXED ? 54 : currentGameWidth - 158, 146, j);
            } else if (oldGameframe == false && Gameframe508 == true) {
                this.minimapImage.method352(151, i, this.anIntArray1229, 256 + this.anInt1170, this.anIntArray1052,
                        l2, currentScreenMode == Main.ScreenMode.FIXED ? 10 : 7,
                        currentScreenMode == Main.ScreenMode.FIXED ? 45 : currentGameWidth - 158, 146, j);
            }
            for (int j2 = 0; j2 < this.anInt1071; ++j2) {
                int l4 = this.anIntArray1072[j2] * 4 + 2 - myPlayer.x / 32;
                int k4 = this.anIntArray1073[j2] * 4 + 2 - myPlayer.y / 32;
                this.markMinimap(this.aSpriteArray1140[j2], l4, k4);
                this.markMinimap(this.MapFunction[0], (3255 - this.baseX) * 4 + 2 - myPlayer.x / 32,
                        (3290 - this.baseY) * 4 + 2 - myPlayer.y / 32);
                this.markMinimap(this.MapFunction[5], (1772 - this.baseX) * 4 + 2 - myPlayer.x / 32,
                        (5497 - this.baseY) * 4 + 2 - myPlayer.y / 32);
            }

            for (int j2 = 0; j2 < 104; ++j2) {
                for (int l4 = 0; l4 < 104; ++l4) {
                    NodeList var17 = this.aClass19ArrayArrayArray827[this.plane][j2][l4];
                    if (var17 != null) {
                        int l3 = j2 * 4 + 2 - myPlayer.x / 32;
                        int j3 = l4 * 4 + 2 - myPlayer.y / 32;
                        this.markMinimap(this.aSprite_1074, l3, j3);
                    }
                }
            }

            Npc var14;
            for (int j2 = 0; j2 < this.npcCount; ++j2) {
                var14 = this.npcArray[this.npcIndices[j2]];
                if (var14 != null && var14.isVisible()) {
                    NpcDefinition var18 = var14.desc;
                    if (var18.morphisms != null) {
                        var18 = var18.method161();
                    }

                    if (var18 != null && var18.aBoolean87 && var18.aBoolean84) {
                        int l3 = var14.x / 32 - myPlayer.x / 32;
                        int j3 = var14.y / 32 - myPlayer.y / 32;
                        this.markMinimap(this.aSprite_1075, l3, j3);
                    }
                }
            }

            for (int j2 = 0; j2 < this.playerCount; ++j2) {
                Player player = this.playerArray[this.playerIndices[j2]];
                if (player != null && player.isVisible()) {
                    int k4 = player.x / 32 - myPlayer.x / 32;
                    int l3 = player.y / 32 - myPlayer.y / 32;
                    boolean flag1 = false;
                    boolean flag3 = false;
                    String clanname;
                    for (int j3 = 0; j3 < clanList.length; j3++) {
                        if (clanList[j3] == null)
                            continue;
                        clanname = clanList[j3];
                        if (clanname.startsWith("<clan"))
                            clanname = clanname.substring(clanname.indexOf(">") + 1);
                        if (!clanname.equalsIgnoreCase(player.name))
                            continue;
                        flag3 = true;
                        break;
                    }

                    long var171 = TextClass.longForName(player.name);

                    for (int var19 = 0; var19 < this.friendsCount; ++var19) {
                        if (var171 == this.friendsListAsLongs[var19] && this.friendsNodeIDs[var19] != 0) {
                            flag1 = true;
                            break;
                        }
                    }

                    boolean var181 = false;
                    if (myPlayer.anInt1701 != 0 && player.anInt1701 != 0 && myPlayer.anInt1701 == player.anInt1701) {
                        var181 = true;
                    }

                    if (flag1) {
                        this.markMinimap(this.aSprite_1077, k4, l3);
                    } else if (var181) {
                        this.markMinimap(this.aSprite_1078, k4, l3);
                    } else {
                        this.markMinimap(this.aSprite_1076, k4, l3);
                    }
                }
            }

            if (this.anInt855 != 0 && loopCycle % 20 < 10) {
                if (this.anInt855 == 1 && this.anInt1222 >= 0 && this.anInt1222 < this.npcArray.length) {
                    var14 = this.npcArray[this.anInt1222];
                    if (var14 != null) {
                        int l4 = var14.x / 32 - myPlayer.x / 32;
                        int k4 = var14.y / 32 - myPlayer.y / 32;
                        this.method81(this.aSprite_871, k4, l4);
                    }
                }

                if (this.anInt855 == 2) {
                    int j2 = (this.anInt934 - this.baseX) * 4 + 2 - myPlayer.x / 32;
                    int l4 = (this.anInt935 - this.baseY) * 4 + 2 - myPlayer.y / 32;
                    this.method81(this.aSprite_871, l4, j2);
                }

                if (this.anInt855 == 10 && this.anInt933 >= 0 && this.anInt933 < this.playerArray.length) {
                    Player var15 = this.playerArray[this.anInt933];
                    if (var15 != null) {
                        int l4 = var15.x / 32 - myPlayer.x / 32;
                        int k4 = var15.y / 32 - myPlayer.y / 32;
                        this.method81(this.aSprite_871, k4, l4);
                    }
                }
            }

            if (this.destX != 0) {
                int j2 = this.destX * 4 + 2 - myPlayer.x / 32;
                int l4 = this.destY * 4 + 2 - myPlayer.y / 32;
                this.markMinimap(this.aSprite_870, j2, l4);
            }

            DrawingArea.drawPixels(3, currentScreenMode == Main.ScreenMode.FIXED ? 83 : 80,
                    currentScreenMode == Main.ScreenMode.FIXED ? 127 : currentGameWidth - 88, 16777215, 3);
            if (currentScreenMode == Main.ScreenMode.FIXED) {
                mapArea[0].drawSprite(0, 4);
                mapArea[5].drawSprite(0, 0);
            } else {
            	if(!Gameframe508){
                mapArea[2].drawSprite(currentGameWidth - 183, 0);
            	}else{
            		mapArea[2].drawSprite(currentGameWidth - 183 + 17, 0);
            		worldmapborder.drawSprite(gameScreenWidth - 182 + 11, 0); 
            	}
            }
            if(oldGameframe){
            compassImage.method352(33, anInt1185, anIntArray1057, 256, anIntArray968,
                    (currentScreenMode == ScreenMode.FIXED ? 25 : 25), 4,
                    (currentScreenMode == ScreenMode.FIXED ? 29 : currentGameWidth - 178), 33, 25);
            }
			if(oldGameframe == false && Gameframe508 == false){
			this.compassImage.method352(33, this.anInt1185, this.anIntArray1057, 256, this.anIntArray968,
					currentScreenMode == Main.ScreenMode.FIXED ? 28 : 24, 4,
					currentScreenMode == Main.ScreenMode.FIXED ? 27 : gameScreenWidth - 176, 33, 25);
			}else if(oldGameframe == true && Gameframe508 == false){
				this.compassImage.method352(33, this.anInt1185, this.anIntArray1057, 256, this.anIntArray968,
						currentScreenMode == Main.ScreenMode.FIXED ? 25 : 24, 4,
						currentScreenMode == Main.ScreenMode.FIXED ? 29 : currentGameWidth - 176, 33, 25);
				}else if(oldGameframe == false && Gameframe508 == true){
					this.compassImage.method352(33, this.anInt1185, this.anIntArray1057, 256, this.anIntArray968,
							currentScreenMode == Main.ScreenMode.FIXED ? 25 : 25, (currentScreenMode == ScreenMode.FIXED ? 8 : 5),
							currentScreenMode == Main.ScreenMode.FIXED ? 11 : currentGameWidth - 182 + 15, 33, 25);
					}
            if (currentScreenMode != Main.ScreenMode.FIXED && changeTabArea) {
                if ((super.mouseX < currentGameWidth - 26 || super.mouseX > currentGameWidth - 1 || super.mouseY < 2
                        || super.mouseY > 24) && tabID != 10) {
                    this.gameframe[31].drawARGBSprite(currentGameWidth - 25, 2, 165);
                } else {
                    this.gameframe[31].drawSprite(currentGameWidth - 25, 2);
                }
            }

            if (Constants.loadOrbs) {
                this.loadAllOrbs(currentScreenMode == Main.ScreenMode.FIXED ? 0 : currentGameWidth - 217);
            }
            if(Constants.loadOrbs && !Gameframe508){
    		if (currentScreenMode == ScreenMode.FIXED) {
    			cacheSprite2[6].drawSprite(198 - 2, 17 + 110);
    			if (worldHover) {
    				cacheSprite2[1].drawSprite(202 - 2, 20 + 111);
    			} else {
    				cacheSprite2[0].drawSprite(202 - 2, 20 + 111);
    			}
    		} else {


    			cacheSprite2[6].drawSprite(currentGameWidth - 35, 141);
    			if (worldHover) {
    				cacheSprite2[1].drawSprite(currentGameWidth - 31, 145);
    			} else {
    				cacheSprite2[0].drawSprite(currentGameWidth - 31, 145);
    			}

    		}
            }
            if(Gameframe508){
            	if (currentScreenMode == ScreenMode.FIXED) {
            	worldmap.drawSprite(11, 124);
            	}else {
            		worldmapborder.drawSprite(gameScreenWidth - 45, 119); 
            		worldmap.drawSprite(gameScreenWidth - 40, 124);
            	}
            }
            if (this.menuOpen) {
                this.drawMenu(currentScreenMode == Main.ScreenMode.FIXED ? 516 : 0, 0);
            }

            if (currentScreenMode == Main.ScreenMode.FIXED) {
                aRSImageProducer_1165.initDrawingArea();
            }
        }

    }

    public final void method127(boolean flag, Entity class30_sub2_sub4_sub1, int i) {
        if (!flag) {
            this.incomingPacket = this.incoming.readUnsignedByte();
        }

        this.calcEntityScreenPos(class30_sub2_sub4_sub1.x, i, this.anInt875, class30_sub2_sub4_sub1.y);
    }

    public final void calcEntityScreenPos(int i, int j, int k, int l) {
        if (i >= 128 && l >= 128 && i <= 13056 && l <= 13056) {
            int i1 = this.method42(this.plane, l, i) - j;
            i -= this.xCameraPos;
            i1 -= this.zCameraPos;
            l -= this.yCameraPos;
            int j1 = Model.SINE[this.yCameraCurve];
            int k1 = Model.COSINE[this.yCameraCurve];
            int l1 = Model.SINE[this.xCameraCurve];
            int i2 = Model.COSINE[this.xCameraCurve];
            int j2 = l * l1 + i * i2 >> 16;
            l = l * i2 - i * l1 >> 16;
            i = j2;
            if (k >= 0) {
                stream.writeByte(27);
            }

            j2 = i1 * k1 - l * j1 >> 16;
            l = i1 * j1 + l * k1 >> 16;
            if (l >= 50) {
                this.spriteDrawX = Rasterizer.centerX + (i << WorldController.viewDistance) / l;
                this.spriteDrawY = Rasterizer.centerY + (j2 << WorldController.viewDistance) / l;
            } else {
                this.spriteDrawX = -1;
                this.spriteDrawY = -1;
            }
        } else {
            this.spriteDrawX = -1;
            this.spriteDrawY = -1;
        }

    }

    private void buildSplitPrivateChatMenu() {
        if (this.splitPrivateChat != 0) {
            int i = 0;
            if (this.anInt1104 != 0) {
                i = 1;
            }

            for (int j = 0; j < 100; ++j) {
                if (this.chatMessages[j] != null) {
                    int k = this.chatTypes[j];
                    String s = this.chatNames[j];
                    if (s != null && s.startsWith("@cr1@")) {
                        s = s.substring(5);
                    }

                    if (s != null && s.startsWith("@cr2@")) {
                        s = s.substring(5);
                    }

                    if (s != null && s.startsWith("@cr3@")) {
                        s = s.substring(5);
                    }

                    if (s != null && s.startsWith("@cr4@")) {
                        s = s.substring(5);
                    }

                    if (s != null && s.startsWith("@cr5@")) {
                        s = s.substring(5);
                    }

                    if (s != null && s.startsWith("@cr6@")) {
                        s = s.substring(5);
                    }

                    if (s != null && s.startsWith("@cr7@")) {
                        s = s.substring(5);
                    }

                    if (s != null && s.startsWith("@cr8@")) {
                        s = s.substring(5);
                    }

                    if (s != null && s.startsWith("@cr9@")) {
                        s = s.substring(5);
                    }

                    if (s != null && s.startsWith("@cr10@")) {
                        s = s.substring(6);
                    }

                    if (s != null && s.startsWith("@cr11@")) {
                        s = s.substring(6);
                    }

                    if (s != null && s.startsWith("@cr12@")) {
                        s = s.substring(6);
                    }

                    if (s != null && s.startsWith("@cr13@")) {
                        s = s.substring(6);
                    }

                    if (s != null && s.startsWith("@cr14@")) {
                        s = s.substring(6);
                    }

                    if (s != null && s.startsWith("@cr15@")) {
                        s = s.substring(6);
                    }

                    if (s != null && s.startsWith("@cr16@")) {
                        s = s.substring(6);
                    }

                    if (s != null && s.startsWith("@cr17@")) {
                        s = s.substring(6);
                    }

                    if (s != null && s.startsWith("@cr18@")) {
                        s = s.substring(6);
                    }

                    if (s != null && s.startsWith("@cr19@")) {
                        s = s.substring(6);
                    }

                    if (s != null && s.startsWith("@cr20@")) {
                        s = s.substring(6);
                    }

                    if (s != null && s.startsWith("@cr21@")) {
                        s = s.substring(6);
                    }

                    if (s != null && s.startsWith("@cr22@")) {
                        s = s.substring(6);
                    }

                    if (s != null && s.startsWith("@cr23@")) {
                        s = s.substring(6);
                    }

                    if (s != null && s.startsWith("@cr24@")) {
                        s = s.substring(6);
                    }
                    if (s != null && s.startsWith("@cr25@")) {
                        s = s.substring(6);
                    }
                    if ((k == 3 || k == 7) && (k == 7 || this.privateChatMode == 0
                            || this.privateChatMode == 1 && this.isFriendOrSelf(s))) {
                        int offSet = currentScreenMode == Main.ScreenMode.FIXED ? 4 : 0;
                        int l = 329 - i * 13;
                        if (currentScreenMode != Main.ScreenMode.FIXED) {
                            l = currentGameHeight - 170 - i * 13;
                        }

                        if (super.mouseX > 4 && super.mouseY - offSet > l - 10 && super.mouseY - offSet <= l + 3) {
                            int i1 = this.regularText.getTextWidth("From:  " + s + this.chatMessages[j]) + 25;
                            if (i1 > 450) {
                                i1 = 450;
                            }

                            if (super.mouseX < 4 + i1) {
                                if (this.myPrivilege == 1 || this.myPrivilege == 2 || this.myPrivilege == 9
                                        || this.myPrivilege == 10 || this.myPrivilege == 4) {
                                    this.menuActionName[this.menuActionRow] = "Report abuse @whi@" + s;
                                    this.menuActionID[this.menuActionRow] = 2606;
                                    ++this.menuActionRow;
                                }

                                this.menuActionName[this.menuActionRow] = "Add ignore @whi@" + s;
                                this.menuActionID[this.menuActionRow] = 2042;
                                ++this.menuActionRow;
                                this.menuActionName[this.menuActionRow] = "Add friend @whi@" + s;
                                this.menuActionID[this.menuActionRow] = 2337;
                                ++this.menuActionRow;
                            }
                        }

                        ++i;
                        if (i >= 5) {
                            return;
                        }
                    }

                    if ((k == 5 || k == 6) && this.privateChatMode < 2) {
                        ++i;
                        if (i >= 5) {
                            return;
                        }
                    }
                }
            }
        }

    }

    private final void method130(int i, int j, int k, int l, int i1, int j1, int k1, int l1, int i2, int j2) {
        Class30_Sub1 class30_sub1 = null;

        for (Class30_Sub1 class30_sub1_1 = (Class30_Sub1) this.aClass19_1179
                .reverseGetFirst(); class30_sub1_1 != null; class30_sub1_1 = (Class30_Sub1) this.aClass19_1179
                .reverseGetNext()) {
            if (class30_sub1_1.anInt1295 == l1 && class30_sub1_1.anInt1297 == i2 && class30_sub1_1.anInt1298 == j1
                    && class30_sub1_1.anInt1296 == i1) {
                class30_sub1 = class30_sub1_1;
                break;
            }
        }

        if (class30_sub1 == null) {
            class30_sub1 = new Class30_Sub1();
            class30_sub1.anInt1295 = l1;
            class30_sub1.anInt1296 = i1;
            class30_sub1.anInt1297 = i2;
            class30_sub1.anInt1298 = j1;
            this.method89(false, class30_sub1);
            this.aClass19_1179.insertHead(class30_sub1);
        }

        class30_sub1.anInt1291 = k;
        class30_sub1.anInt1293 = k1;
        class30_sub1.anInt1292 = l;
        class30_sub1.anInt1302 = j2;
        class30_sub1.anInt1294 = j;
        if (i > 0) {
        }

    }

    public final boolean method131(Widget class9) {
        if (class9.anIntArray245 == null) {
            return false;
        } else {
            for (int i = 0; i < class9.anIntArray245.length; ++i) {
                int j = this.extractInterfaceValues(class9, i);
                int k = class9.anIntArray212[i];
                if (class9.anIntArray245[i] == 2) {
                    if (j >= k) {
                        return false;
                    }
                } else if (class9.anIntArray245[i] == 3) {
                    if (j <= k) {
                        return false;
                    }
                } else if (class9.anIntArray245[i] == 4) {
                    if (j == k) {
                        return false;
                    }
                } else if (j != k) {
                    return false;
                }
            }

            return true;
        }
    }

    public final DataInputStream method132(String s) throws IOException {
        if (!this.aBoolean872) {
            return SignLink.mainapp != null ? SignLink.openurl(s)
                    : new DataInputStream((new URL(this.getCodeBase(), s)).openStream());
        } else {
            if (this.aSocket832 != null) {
                try {
                    this.aSocket832.close();
                } catch (Exception var4) {
                }

                this.aSocket832 = null;
            }

            this.aSocket832 = this.openSocket('\uaa4b');
            this.aSocket832.setSoTimeout(10000);
            InputStream inputstream = this.aSocket832.getInputStream();
            OutputStream outputstream = this.aSocket832.getOutputStream();
            outputstream.write(("JAGGRAB /" + s + "\n\n").getBytes());
            return new DataInputStream(inputstream);
        }
    }

    public final void method133(byte byte0) {
        short c = 256;
        int i1;
        if (this.anInt1040 > 0) {
            for (i1 = 0; i1 < 256; ++i1) {
                if (this.anInt1040 > 768) {
                    this.anIntArray850[i1] = this.method83(true, this.anIntArray851[i1], this.anIntArray852[i1],
                            1024 - this.anInt1040);
                } else if (this.anInt1040 > 256) {
                    this.anIntArray850[i1] = this.anIntArray852[i1];
                } else {
                    this.anIntArray850[i1] = this.method83(true, this.anIntArray852[i1], this.anIntArray851[i1],
                            256 - this.anInt1040);
                }
            }
        } else if (this.anInt1041 > 0) {
            for (i1 = 0; i1 < 256; ++i1) {
                if (this.anInt1041 > 768) {
                    this.anIntArray850[i1] = this.method83(true, this.anIntArray851[i1], this.anIntArray853[i1],
                            1024 - this.anInt1041);
                } else if (this.anInt1041 > 256) {
                    this.anIntArray850[i1] = this.anIntArray853[i1];
                } else {
                    this.anIntArray850[i1] = this.method83(true, this.anIntArray853[i1], this.anIntArray851[i1],
                            256 - this.anInt1041);
                }
            }
        } else {
            for (i1 = 0; i1 < 256; ++i1) {
                this.anIntArray850[i1] = this.anIntArray851[i1];
            }
        }

        for (i1 = 0; i1 < '\u8480'; ++i1) {
            this.aRSImageProducer_1110.canvasRaster[i1] = this.aSprite_1201.myPixels[i1];
        }

        i1 = 0;
        int j1 = 1152;

        int k2;
        int i3;
        int k3;
        int i4;
        int k4;
        int i5;
        int j5;
        int k5;
        for (k2 = 1; k2 < c - 1; ++k2) {
            i3 = this.anIntArray969[k2] * (c - k2) / c;
            k3 = 22 + i3;
            if (k3 < 0) {
                k3 = 0;
            }

            i1 += k3;

            for (i4 = k3; i4 < 128; ++i4) {
                k4 = this.anIntArray828[i1++];
                if (k4 != 0) {
                    i5 = k4;
                    j5 = 256 - k4;
                    k4 = this.anIntArray850[k4];
                    k5 = this.aRSImageProducer_1110.canvasRaster[j1];
                    this.aRSImageProducer_1110.canvasRaster[j1++] = ((k4 & 16711935) * i5 + (k5 & 16711935) * j5
                            & -16711936) + ((k4 & '\uff00') * i5 + (k5 & '\uff00') * j5 & 16711680) >> 8;
                } else {
                    ++j1;
                }
            }

            j1 += k3;
        }

        this.aRSImageProducer_1110.drawGraphics(0, super.graphics, 0);

        for (k2 = 0; k2 < '\u8480'; ++k2) {
            this.aRSImageProducer_1111.canvasRaster[k2] = this.aSprite_1202.myPixels[k2];
        }

        i1 = 0;
        j1 = 1176;

        for (k2 = 1; k2 < c - 1; ++k2) {
            i3 = this.anIntArray969[k2] * (c - k2) / c;
            k3 = 103 - i3;
            j1 += i3;

            for (i4 = 0; i4 < k3; ++i4) {
                k4 = this.anIntArray828[i1++];
                if (k4 != 0) {
                    i5 = k4;
                    j5 = 256 - k4;
                    k4 = this.anIntArray850[k4];
                    k5 = this.aRSImageProducer_1111.canvasRaster[j1];
                    this.aRSImageProducer_1111.canvasRaster[j1++] = ((k4 & 16711935) * i5 + (k5 & 16711935) * j5
                            & -16711936) + ((k4 & '\uff00') * i5 + (k5 & '\uff00') * j5 & 16711680) >> 8;
                } else {
                    ++j1;
                }
            }

            i1 += 128 - k3;
            j1 += 128 - k3 - i3;
        }

        this.aRSImageProducer_1111.drawGraphics(0, super.graphics, 637);
        if (byte0 != 9) {
            this.incomingPacket = this.incoming.readUnsignedByte();
        }

    }

    private final void method134(byte byte0, int i, Buffer stream) {
        int j = stream.method419(8, 0);
        int l;
        if (j < this.playerCount) {
            for (l = j; l < this.playerCount; ++l) {
                this.anIntArray840[this.anInt839++] = this.playerIndices[l];
            }
        }

        if (j > this.playerCount) {
            SignLink.reporterror(this.myUsername + " Too many players");
            throw new RuntimeException("eek");
        } else {
            this.playerCount = 0;

            for (l = 0; l < j; ++l) {
                int i1 = this.playerIndices[l];
                Player player = this.playerArray[i1];
                int j1 = stream.method419(1, 0);
                if (j1 == 0) {
                    this.playerIndices[this.playerCount++] = i1;
                    player.anInt1537 = loopCycle;
                } else {
                    int k1 = stream.method419(2, 0);
                    if (k1 == 0) {
                        this.playerIndices[this.playerCount++] = i1;
                        player.anInt1537 = loopCycle;
                        this.anIntArray894[this.anInt893++] = i1;
                    } else {
                        int i2;
                        int k2;
                        if (k1 == 1) {
                            this.playerIndices[this.playerCount++] = i1;
                            player.anInt1537 = loopCycle;
                            i2 = stream.method419(3, 0);
                            player.method448(false, (byte) 20, i2);
                            k2 = stream.method419(1, 0);
                            if (k2 == 1) {
                                this.anIntArray894[this.anInt893++] = i1;
                            }
                        } else if (k1 == 2) {
                            this.playerIndices[this.playerCount++] = i1;
                            player.anInt1537 = loopCycle;
                            i2 = stream.method419(3, 0);
                            player.method448(true, (byte) 20, i2);
                            k2 = stream.method419(3, 0);
                            player.method448(true, (byte) 20, k2);
                            int l2 = stream.method419(1, 0);
                            if (l2 == 1) {
                                this.anIntArray894[this.anInt893++] = i1;
                            }
                        } else if (k1 == 3) {
                            this.anIntArray840[this.anInt839++] = i1;
                        }
                    }
                }
            }

        }
    }

    public final void drawLoginScreen(boolean flag) {
        this.resetImageProducers();
        this.aRSImageProducer_1109.initDrawingArea();
        Sprite loginTest = new Sprite("Login/login");
        loginTest.drawSprite(0, 0);
        if (this.loginMessage1.length() > 0) {
            this.boldText.method382('\uccff', 255, this.loginMessage1, 45, true);
            this.boldText.method382('\uccff', 255, this.loginMessage2, 60, true);
        } else {
            this.boldText.method382('\uccff', 255, this.loginMessage2, 60, true);
        }

        if (this.loginButtonint == 0) {
            this.LOGINBUTTON[0].drawSprite(382, 89);
        } else if (this.loginButtonint == 1) {
            this.LOGINBUTTON[1].drawSprite(382, 89);
        }

        if (rememberMe) {
        } else if (rememberMehover == 0) {
            Sprite unclickedR2 = new Sprite("Login/unclicked");
            unclickedR2.drawSprite(13, 130);
        } else if (rememberMehover == 1) {
            Sprite hoverR = new Sprite("Login/hoverboxR");
            hoverR.drawSprite(13, 130);
        }
        Sprite textbox1;
        if (this.textbox == 0) {
            textbox1 = new Sprite("Login/textbox");
            textbox1.drawSprite(13, 91);
        } else if (this.textbox == 1) {
            textbox1 = new Sprite("Login/textbox1");
            textbox1.drawSprite(13, 91);
        }

        if (this.textbox1 == 0) {
            textbox1 = new Sprite("Login/textbox");
            textbox1.drawSprite(197, 91);
        } else if (this.textbox1 == 1) {
            textbox1 = new Sprite("Login/textbox1");
            textbox1.drawSprite(197, 91);
        }

        this.regularText.method389(false, 18, 0,
                this.myUsername + (this.loginScreenCursorPos == 0 & loopCycle % 40 < 20 ? "|" : ""), 110);
        this.regularText.method389(false, 203, 0, TextClass.passwordAsterisks(this.myPassword)
                + (this.loginScreenCursorPos == 1 & loopCycle % 40 < 20 ? "|" : ""), 110);
        this.aRSImageProducer_1109.drawGraphics(171, super.graphics, 133);
        if (this.aBoolean1255) {
            this.aBoolean1255 = false;
            this.aRSImageProducer_1107.drawGraphics(0, super.graphics, 128);
            this.aRSImageProducer_1108.drawGraphics(371, super.graphics, 202);
            this.aRSImageProducer_1112.drawGraphics(265, super.graphics, 0);
            this.aRSImageProducer_1113.drawGraphics(265, super.graphics, 562);
            this.aRSImageProducer_1114.drawGraphics(171, super.graphics, 128);
            this.aRSImageProducer_1115.drawGraphics(171, super.graphics, 562);
        }

    }

    public final void method136(byte byte0) {
        this.aBoolean962 = true;
        if (byte0 != 59) {
            this.anInt1058 = -186;
        }

        try {
            long l = System.currentTimeMillis();
            int i = 0;
            int j = 20;

            while (this.aBoolean831) {
                ++this.anInt1208;
                this.method133((byte) 9);
                ++i;
                if (i > 10) {
                    long l1 = System.currentTimeMillis();
                    int k = (int) (l1 - l) / 10 - j;
                    j = 40 - k;
                    if (j < 5) {
                        j = 5;
                    }

                    i = 0;
                    l = l1;
                }

                try {
                    Thread.sleep((long) j);
                } catch (Exception var9) {
                }
            }
        } catch (Exception var10) {
        }

        this.aBoolean962 = false;
    }

    public final void method10(byte byte0) {
        this.aBoolean1255 = true;
        if (byte0 != 1) {
            this.anInt1218 = this.aClass17_1000.method246();
        }

    }

    public final void method137(int i, Buffer stream, int j) {
        while (i >= 0) {
            j = -1;
        }

        int i3;
        int l5;
        int k8;
        int j11;
        int k13;
        int l15;
        Item var31;
        if (j == 84) {
            i3 = stream.readUnsignedByte();
            l5 = this.anInt1268 + (i3 >> 4 & 7);
            k8 = this.anInt1269 + (i3 & 7);
            j11 = stream.readUnsignedWord();
            k13 = stream.readUnsignedWord();
            l15 = stream.readUnsignedWord();
            if (l5 >= 0 && k8 >= 0 && l5 < 104 && k8 < 104) {
                NodeList var32 = this.aClass19ArrayArrayArray827[this.plane][l5][k8];
                if (var32 != null) {
                    for (var31 = (Item) var32.reverseGetFirst(); var31 != null; var31 = (Item) var32.reverseGetNext()) {
                        if (var31.anInt1558 == (j11 & 32767) && var31.anInt1559 == k13) {
                            var31.anInt1559 = l15;
                            break;
                        }
                    }

                    this.spawnGroundItem(l5, k8);
                }
            }
        } else {
            int var321;
            if (j == 105) {
                i3 = stream.readUnsignedByte();
                l5 = this.anInt1268 + (i3 >> 4 & 7);
                k8 = this.anInt1269 + (i3 & 7);
                j11 = stream.readUnsignedWord();
                k13 = stream.readUnsignedByte();
                l15 = k13 >> 4 & 15;
                var321 = k13 & 7;
                if (myPlayer.smallX[0] >= l5 - l15 && myPlayer.smallX[0] <= l5 + l15 && myPlayer.smallY[0] >= k8 - l15
                        && myPlayer.smallY[0] <= k8 + l15 && this.aBoolean848 && !lowMem && this.anInt1062 < 50) {
                    this.anIntArray1207[this.anInt1062] = j11;
                    this.anIntArray1241[this.anInt1062] = var321;
                    this.anIntArray1250[this.anInt1062] = Sounds.anIntArray326[j11];
                    ++this.anInt1062;
                }
            }

            if (j == 215) {
                i3 = stream.method435();
                l5 = stream.method428();
                k8 = this.anInt1268 + (l5 >> 4 & 7);
                j11 = this.anInt1269 + (l5 & 7);
                k13 = stream.method435();
                l15 = stream.readUnsignedWord();
                if (k8 >= 0 && j11 >= 0 && k8 < 104 && j11 < 104 && k13 != this.unknownInt10) {
                    var31 = new Item();
                    var31.anInt1558 = i3;
                    var31.anInt1559 = l15;
                    if (this.aClass19ArrayArrayArray827[this.plane][k8][j11] == null) {
                        this.aClass19ArrayArrayArray827[this.plane][k8][j11] = new NodeList(169);
                    }

                    this.aClass19ArrayArrayArray827[this.plane][k8][j11].insertHead(var31);
                    this.spawnGroundItem(k8, j11);
                }
            } else if (j == 156) {
                i3 = stream.method426(0);
                l5 = this.anInt1268 + (i3 >> 4 & 7);
                k8 = this.anInt1269 + (i3 & 7);
                j11 = stream.readUnsignedWord();
                if (l5 >= 0 && k8 >= 0 && l5 < 104 && k8 < 104) {
                    NodeList l18 = this.aClass19ArrayArrayArray827[this.plane][l5][k8];
                    if (l18 != null) {
                        for (var31 = (Item) l18.reverseGetFirst(); var31 != null; var31 = (Item) l18.reverseGetNext()) {
                            if (var31.anInt1558 == (j11 & 32767)) {
                                var31.unlink();
                                break;
                            }
                        }

                        if (l18.reverseGetFirst() == null) {
                            this.aClass19ArrayArrayArray827[this.plane][l5][k8] = null;
                        }

                        this.spawnGroundItem(l5, k8);
                    }
                }
            } else {
                int k19;
                int j20;
                int i21;
                int class30_sub2_sub4_sub4;
                int var33;
                int var331;
                if (j == 160) {
                    i3 = stream.method428();
                    l5 = this.anInt1268 + (i3 >> 4 & 7);
                    k8 = this.anInt1269 + (i3 & 7);
                    j11 = stream.method428();
                    k13 = j11 >> 2;
                    l15 = j11 & 3;
                    var321 = this.anIntArray1177[k13];
                    var33 = stream.method435();
                    if (l5 >= 0 && k8 >= 0 && l5 < 103 && k8 < 103) {
                        var331 = this.anIntArrayArrayArray1214[this.plane][l5][k8];
                        k19 = this.anIntArrayArrayArray1214[this.plane][l5 + 1][k8];
                        j20 = this.anIntArrayArrayArray1214[this.plane][l5 + 1][k8 + 1];
                        i21 = this.anIntArrayArrayArray1214[this.plane][l5][k8 + 1];
                        if (var321 == 0) {
                            Object1 var40 = this.worldController.method296(this.plane, l5, k8, false);
                            if (var40 != null) {
                                class30_sub2_sub4_sub4 = var40.uid >> 14 & 32767;
                                if (k13 == 2) {
                                    var40.aClass30_Sub2_Sub4_278 = new Animable_Sub5(class30_sub2_sub4_sub4, 4 + l15, 2,
                                            k19, j20, var331, i21, var33, false);
                                    var40.aClass30_Sub2_Sub4_279 = new Animable_Sub5(class30_sub2_sub4_sub4,
                                            l15 + 1 & 3, 2, k19, j20, var331, i21, var33, false);
                                } else {
                                    var40.aClass30_Sub2_Sub4_278 = new Animable_Sub5(class30_sub2_sub4_sub4, l15, k13,
                                            k19, j20, var331, i21, var33, false);
                                }
                            }
                        }

                        if (var321 == 1) {
                            Object2 var34 = this.worldController.method297(l5, 866, k8, this.plane);
                            if (var34 != null) {
                                var34.aClass30_Sub2_Sub4_504 = new Animable_Sub5(var34.uid >> 14 & 32767, 0, 4,
                                        k19, j20, var331, i21, var33, false);
                            }
                        }

                        if (var321 == 2) {
                            Object5 var35 = this.worldController.method298(l5, k8, (byte) 4, this.plane);
                            if (k13 == 11) {
                                k13 = 10;
                            }

                            if (var35 != null) {
                                var35.aClass30_Sub2_Sub4_521 = new Animable_Sub5(var35.uid >> 14 & 32767, l15, k13, k19,
                                        j20, var331, i21, var33, false);
                            }
                        }

                        if (var321 == 3) {
                            Object3 var36 = this.worldController.method299(k8, l5, this.plane, 0);
                            if (var36 != null) {
                                var36.aClass30_Sub2_Sub4_814 = new Animable_Sub5(var36.uid >> 14 & 32767, l15, 22,
                                        k19, j20, var331, i21, var33, false);
                            }
                        }
                    }
                } else {
                    if (j == 147) {
                        i3 = stream.method428();
                        l5 = this.anInt1268 + (i3 >> 4 & 7);
                        k8 = this.anInt1269 + (i3 & 7);
                        j11 = stream.readUnsignedWord();
                        byte var37 = stream.method430(0);
                        l15 = stream.method434();
                        byte var38 = stream.method429((byte) -57);
                        var33 = stream.readUnsignedWord();
                        var331 = stream.method428();
                        k19 = var331 >> 2;
                        j20 = var331 & 3;
                        i21 = this.anIntArray1177[k19];
                        byte j21 = stream.method409();
                        class30_sub2_sub4_sub4 = stream.readUnsignedWord();
                        byte byte3 = stream.method429((byte) -57);
                        Player player;
                        if (j11 == this.unknownInt10) {
                            player = myPlayer;
                        } else {
                            player = this.playerArray[j11];
                        }

                        if (player != null) {
                            ObjectDefinition class46 = ObjectDefinition.forID(class30_sub2_sub4_sub4);
                            int i22 = this.anIntArrayArrayArray1214[this.plane][l5][k8];
                            int j22 = this.anIntArrayArrayArray1214[this.plane][l5 + 1][k8];
                            int k22 = this.anIntArrayArrayArray1214[this.plane][l5 + 1][k8 + 1];
                            int l22 = this.anIntArrayArrayArray1214[this.plane][l5][k8 + 1];
                            Model Model = class46.method578(k19, j20, i22, j22, k22, l22, -1);
                            if (Model != null) {
                                this.method130(404, var33 + 1, -1, 0, i21, k8, 0, this.plane, l5, l15 + 1);
                                player.anInt1707 = l15 + loopCycle;
                                player.anInt1708 = var33 + loopCycle;
                                player.aModel_1714 = Model;
                                int i23 = class46.width;
                                int j23 = class46.length;
                                if (j20 == 1 || j20 == 3) {
                                    i23 = class46.length;
                                    j23 = class46.width;
                                }

                                player.anInt1711 = l5 * 128 + i23 * 64;
                                player.anInt1713 = k8 * 128 + j23 * 64;
                                player.anInt1712 = this.method42(this.plane,
                                        player.anInt1713, player.anInt1711);
                                byte byte5;
                                if (j21 > var37) {
                                    byte5 = j21;
                                    j21 = var37;
                                    var37 = byte5;
                                }

                                if (byte3 > var38) {
                                    byte5 = byte3;
                                    byte3 = var38;
                                    var38 = byte5;
                                }

                                player.anInt1719 = l5 + j21;
                                player.anInt1721 = l5 + var37;
                                player.anInt1720 = k8 + byte3;
                                player.anInt1722 = k8 + var38;
                            }
                        }
                    }

                    if (j == 151) {
                        i3 = stream.method426(0);
                        l5 = this.anInt1268 + (i3 >> 4 & 7);
                        k8 = this.anInt1269 + (i3 & 7);
                        j11 = stream.method434();
                        k13 = stream.method428();
                        l15 = k13 >> 2;
                        var321 = k13 & 3;
                        var33 = this.anIntArray1177[l15];
                        if (l5 >= 0 && k8 >= 0 && l5 < 104 && k8 < 104) {
                            this.method130(404, -1, j11, var321, var33, k8, l15, this.plane, l5, 0);
                        }
                    } else if (j == 4) {
                        i3 = stream.readUnsignedByte();
                        l5 = this.anInt1268 + (i3 >> 4 & 7);
                        k8 = this.anInt1269 + (i3 & 7);
                        j11 = stream.readUnsignedWord();
                        k13 = stream.readUnsignedByte();
                        l15 = stream.readUnsignedWord();
                        if (l5 >= 0 && k8 >= 0 && l5 < 104 && k8 < 104) {
                            l5 = l5 * 128 + 64;
                            k8 = k8 * 128 + 64;
                            Animable_Sub3 var39 = new Animable_Sub3(this.plane, loopCycle, 6, l15, j11,
                                    this.method42(this.plane, k8, l5) - k13, k8, l5);
                            this.aClass19_1056.insertHead(var39);
                        }
                    } else if (j == 44) {
                        i3 = stream.method436();
                        l5 = stream.readUnsignedWord();
                        k8 = stream.readUnsignedByte();
                        j11 = this.anInt1268 + (k8 >> 4 & 7);
                        k13 = this.anInt1269 + (k8 & 7);
                        if (j11 >= 0 && k13 >= 0 && j11 < 104 && k13 < 104) {
                            var31 = new Item();
                            var31.anInt1558 = i3;
                            var31.anInt1559 = l5;
                            if (this.aClass19ArrayArrayArray827[this.plane][j11][k13] == null) {
                                this.aClass19ArrayArrayArray827[this.plane][j11][k13] = new NodeList(169);
                            }

                            this.aClass19ArrayArrayArray827[this.plane][j11][k13].insertHead(var31);
                            this.spawnGroundItem(j11, k13);
                        }
                    } else if (j == 101) {
                        i3 = stream.method427();
                        l5 = i3 >> 2;
                        k8 = i3 & 3;
                        j11 = this.anIntArray1177[l5];
                        k13 = stream.readUnsignedByte();
                        l15 = this.anInt1268 + (k13 >> 4 & 7);
                        var321 = this.anInt1269 + (k13 & 7);
                        if (l15 >= 0 && var321 >= 0 && l15 < 104 && var321 < 104) {
                            this.method130(404, -1, -1, k8, j11, var321, l5, this.plane, l15, 0);
                        }
                    } else if (j == 117) {
                        i3 = stream.readUnsignedByte();
                        l5 = this.anInt1268 + (i3 >> 4 & 7);
                        k8 = this.anInt1269 + (i3 & 7);
                        j11 = l5 + stream.method409();
                        k13 = k8 + stream.method409();
                        l15 = stream.method411();
                        var321 = stream.readUnsignedWord();
                        var33 = stream.readUnsignedByte() * 4;
                        var331 = stream.readUnsignedByte() * 4;
                        k19 = stream.readUnsignedWord();
                        j20 = stream.readUnsignedWord();
                        i21 = stream.readUnsignedByte();
                        int var401 = stream.readUnsignedByte();
                        if (l5 >= 0 && k8 >= 0 && l5 < 104 && k8 < 104 && j11 >= 0 && k13 >= 0 && j11 < 104 && k13 < 104
                                && var321 != '\uffff') {
                            l5 = l5 * 128 + 64;
                            k8 = k8 * 128 + 64;
                            j11 = j11 * 128 + 64;
                            k13 = k13 * 128 + 64;
                            Animable_Sub4 var381 = new Animable_Sub4(i21, var331, '\ub723', k19 + loopCycle,
                                    j20 + loopCycle, var401, this.plane, this.method42(this.plane, k8, l5) - var33, k8,
                                    l5, l15, var321);
                            var381.method455(k19 + loopCycle, k13, this.method42(this.plane, k13, j11) - var331, j11,
                                    (byte) -83);
                            this.aClass19_1013.insertHead(var381);
                        }
                    }
                }
            }
        }

    }
	private static final Comparator<ExperienceDrop> HIGHEST_POSITION = new Comparator<ExperienceDrop>() {

		@Override
		public int compare(ExperienceDrop o1, ExperienceDrop o2) {
			return Integer.compare(o2.getYPosition(), o1.getYPosition());
		}

	};

    private final void method139(Buffer stream, int i, int j) {
        if (i >= 0) {
            this.anInt1118 = -7;
        }

        stream.method418(this.anInt1118);
        int k = stream.method419(8, 0);
        int i1;
        if (k < this.npcCount) {
            for (i1 = k; i1 < this.npcCount; ++i1) {
                this.anIntArray840[this.anInt839++] = this.npcIndices[i1];
            }
        }

        if (k > this.npcCount) {
            SignLink.reporterror(this.myUsername + " Too many npcs");
            throw new RuntimeException("eek");
        } else {
            this.npcCount = 0;

            for (i1 = 0; i1 < k; ++i1) {
                int j1 = this.npcIndices[i1];
                Npc npc = this.npcArray[j1];
                int k1 = stream.method419(1, 0);
                if (k1 == 0) {
                    this.npcIndices[this.npcCount++] = j1;
                    npc.anInt1537 = loopCycle;
                } else {
                    int l1 = stream.method419(2, 0);
                    if (l1 == 0) {
                        this.npcIndices[this.npcCount++] = j1;
                        npc.anInt1537 = loopCycle;
                        this.anIntArray894[this.anInt893++] = j1;
                    } else {
                        int j2;
                        int l2;
                        if (l1 == 1) {
                            this.npcIndices[this.npcCount++] = j1;
                            npc.anInt1537 = loopCycle;
                            j2 = stream.method419(3, 0);
                            npc.method448(false, (byte) 20, j2);
                            l2 = stream.method419(1, 0);
                            if (l2 == 1) {
                                this.anIntArray894[this.anInt893++] = j1;
                            }
                        } else if (l1 == 2) {
                            this.npcIndices[this.npcCount++] = j1;
                            npc.anInt1537 = loopCycle;
                            j2 = stream.method419(3, 0);
                            npc.method448(true, (byte) 20, j2);
                            l2 = stream.method419(3, 0);
                            npc.method448(true, (byte) 20, l2);
                            int i3 = stream.method419(1, 0);
                            if (i3 == 1) {
                                this.anIntArray894[this.anInt893++] = j1;
                            }
                        } else if (l1 == 3) {
                            this.anIntArray840[this.anInt839++] = j1;
                        }
                    }
                }
            }

        }
    }

    public final void method140() {
        if (super.clickMode3 == 1 && super.saveClickX >= 145 && super.saveClickX <= 321 && super.saveClickY >= 261
                && super.saveClickY <= 288) {
            this.loginScreenCursorPos = 0;
        }

        if (super.clickMode3 == 1 && super.saveClickX >= 331 && super.saveClickX <= 505 && super.saveClickY >= 261
                && super.saveClickY <= 288) {
            this.loginScreenCursorPos = 1;
        }

        if (super.mouseX >= 145 && super.mouseX <= 321 && super.mouseY >= 261 && super.mouseY <= 288) {
            this.textbox = 1;
        } else {
            this.textbox = 0;
        }

        if (super.mouseX >= 331 && super.mouseX <= 505 && super.mouseY >= 261 && super.mouseY <= 288) {
            this.textbox1 = 1;
        } else {
            this.textbox1 = 0;
        }

        if (super.clickMode3 == 1 && super.saveClickX >= 145 && super.saveClickX <= 157 && super.saveClickY >= 302
                && super.saveClickY <= 315) {
            if (informationFile.isUsernameRemembered()) {
                if (AccountManager.accounts != null) {
                    for (int index = 0; index < AccountManager.getAccounts().size(); index++) {
                        AccountData account = AccountManager.getAccounts().get(index);
                        if (super.clickMode3 == 1) {
                            if (account.username.length() > 0 && account.password.length() > 0) {
                                // loginFailures = 0;
                                if (myUsername != account.username || myPassword != account.password) {
                                    myUsername = account.username;
                                    myPassword = account.password;
                                }
                                login(account.username, account.password, false);
                                if (loggedIn) {
                                    return;
                                }
                            }
                        }
                        if (super.clickMode3 == 1) {
                            AccountManager.removeAccount(account);
                        }
                    }
                }
            }
        }

        if (super.clickMode3 == 1 && super.saveClickX >= 515 && super.saveClickX <= 608 && super.saveClickY >= 261
                && super.saveClickY <= 292) {
            this.login(this.myUsername, this.myPassword, false);
            if (loggedIn) {
                return;
            }
        }

        if (super.mouseX >= 515 && super.mouseX <= 608 && super.mouseY >= 261 && super.mouseY <= 292) {
            this.loginButtonint = 1;
        } else {
            this.loginButtonint = 0;
        }
        //RememberMe Hover
        if (super.mouseX >= 145 && super.mouseX <= 157 && super.mouseY >= 302 && super.mouseY <= 315) {
            rememberMehover = 1;
        } else {
            rememberMehover = 0;
        }
        //RememberMe clicking
        if (super.clickMode3 == 1 && super.saveClickX >= 145 && super.saveClickX <= 157 && super.saveClickY >= 302 && super.saveClickY <= 315) {
            rememberMe = !rememberMe;
            savePlayerData();

        }
        while (true) {
            while (true) {
                int l1 = this.readChar(-796);
                if (l1 == -1) {
                    return;
                }

                boolean flag1 = false;

                for (int i2 = 0; i2 < aString1162.length(); ++i2) {
                    if (l1 == aString1162.charAt(i2)) {
                        flag1 = true;
                        break;
                    }
                }

                if (this.loginScreenCursorPos == 0) {
                    if (l1 == 8 && this.myUsername.length() > 0) {
                        this.myUsername = this.myUsername.substring(0, this.myUsername.length() - 1);
                    }

                    if (l1 == 9 || l1 == 10 || l1 == 13) {
                        this.loginScreenCursorPos = 1;
                    }

                    if (flag1) {
                        this.myUsername = this.myUsername + (char) l1;
                    }

                    if (this.myUsername.length() > 12) {
                        this.myUsername = this.myUsername.substring(0, 12);
                    }
                } else if (this.loginScreenCursorPos == 1) {
                    if (l1 == 8 && this.myPassword.length() > 0) {
                        this.myPassword = this.myPassword.substring(0, this.myPassword.length() - 1);
                    }

                    if (l1 == 9 || l1 == 10 || l1 == 13) {
                        if (this.myUsername == "") {
                            this.loginScreenCursorPos = 0;
                        } else if (this.myPassword != "") {
                            this.login(this.myUsername, this.myPassword, false);
                        }
                    }

                    if (flag1) {
                        this.myPassword = this.myPassword + (char) l1;
                    }

                    if (this.myPassword.length() > 20) {
                        this.myPassword = this.myPassword.substring(0, 20);
                    }
                }
            }
        }
    }

    public final void markMinimap(Sprite Sprite, int i, int j) {
        if (Sprite != null) {
            int k = this.anInt1185 + this.anInt1209 & 2047;
            int l = i * i + j * j;
            if (l <= 6400) {
                int i1 = Model.SINE[k];
                int j1 = Model.COSINE[k];
                i1 = i1 * 256 / (this.anInt1170 + 256);
                j1 = j1 * 256 / (this.anInt1170 + 256);
                int k1 = j * i1 + i * j1 >> 16;
                int l1 = j * j1 - i * i1 >> 16;
                if (oldGameframe == true && Gameframe508 == false && currentScreenMode == Main.ScreenMode.FIXED) {
                    Sprite.drawSprite(94 + k1 - Sprite.maxWidth / 2 + 4 + 30, 83 - l1 - Sprite.maxHeight / 2 - 4 + 5);
                } else if (oldGameframe == false && Gameframe508 == false && currentScreenMode == Main.ScreenMode.FIXED) {
                    Sprite.drawSprite(94 + k1 - Sprite.maxWidth / 2 + 4 + 30, 83 - l1 - Sprite.maxHeight / 2 - 4 + 5);
                } else if (oldGameframe == false && Gameframe508 == false && currentScreenMode == Main.ScreenMode.RESIZABLE) {
                    Sprite.drawSprite(77 + k1 - Sprite.maxWidth / 2 + 4 + (currentGameWidth - 167), 83 - l1 - Sprite.maxHeight / 2 - 4);
                } else if (oldGameframe == false && Gameframe508 == true && currentScreenMode == Main.ScreenMode.FIXED) {
                    Sprite.drawSprite((94 + k1) - Sprite.maxWidth / 2 + 4 + 20, 83 - l1 - Sprite.maxHeight / 2 - 4 + 5);
                } else if (oldGameframe == false && Gameframe508 == true && currentScreenMode == Main.ScreenMode.RESIZABLE) {
                    Sprite.drawSprite(77 + k1 - Sprite.maxWidth / 2 + 4 + (currentGameWidth - 167), 83 - l1 - Sprite.maxHeight / 2 - 4);
                }
            }
        }

    }

    private final void method142(int i, int j, int k, int l, int i1, int j1, int k1, int l1) {
        if (l1 < 4 || l1 > 4) {
            this.incomingPacket = this.incoming.readUnsignedByte();
        }

        if (i1 >= 1 && i >= 1 && i1 <= 102 && i <= 102) {
            if (lowMem && j != this.plane) {
                return;
            }

            int i2 = 0;
            if (j1 == 0) {
                i2 = this.worldController.method300(j, i1, i);
            }

            if (j1 == 1) {
                i2 = this.worldController.method301(j, i1, i);
            }

            if (j1 == 2) {
                i2 = this.worldController.method302(j, i1, i);
            }

            if (j1 == 3) {
                i2 = this.worldController.method303(j, i1, i);
            }

            int j3;
            if (i2 != 0) {
                j3 = this.worldController.method304(j, i1, i, i2);
                int j2 = i2 >> 14 & 32767;
                int k2 = j3 & 31;
                int l2 = j3 >> 6;
                ObjectDefinition class46_2;
                if (j1 == 0) {
                    this.worldController.method291(i1, j, i, (byte) -119);
                    class46_2 = ObjectDefinition.forID(j2);
                    if (class46_2.clipType != 0) {
                        this.aClass11Array1230[j].method215(l2, k2, class46_2.impenetrable, i1, i);
                    }
                }

                if (j1 == 1) {
                    this.worldController.method292(0, i, j, i1);
                }

                if (j1 == 2) {
                    this.worldController.method293(j, -978, i1, i);
                    class46_2 = ObjectDefinition.forID(j2);
                    if (i1 + class46_2.width > 103 || i + class46_2.width > 103 || i1 + class46_2.length > 103
                            || i + class46_2.length > 103) {
                        return;
                    }

                    if (class46_2.clipType != 0) {
                        this.aClass11Array1230[j].method216(l2, class46_2.width, i1, i, class46_2.length,
                                class46_2.impenetrable);
                    }
                }

                if (j1 == 3) {
                    this.worldController.method294((byte) 9, j, i, i1);
                    class46_2 = ObjectDefinition.forID(j2);
                    if (class46_2.clipType == 1 && class46_2.interactive != 0) {
                        this.aClass11Array1230[j].method218(i, i1);
                    }
                }
            }

            if (k1 >= 0) {
                j3 = j;
                if (j < 3 && (this.byteGroundArray[1][i1][i] & 2) == 2) {
                    j3 = j + 1;
                }

                ObjectManager.method188(this.worldController, k, i, l, j3, this.aClass11Array1230[j],
                        this.anIntArrayArrayArray1214, i1, k1, j);
            }
        }

    }

    private final void method143(int i, Buffer stream, int j) {
        this.anInt839 = 0;
        if (j != 9759) {
            this.incomingPacket = stream.readUnsignedByte();
        }

        this.anInt893 = 0;
        this.method117(stream, i, (byte) 5);
        this.method134((byte) 2, i, stream);
        this.method91(stream, i, (byte) 8);
        this.method49(i, (byte) 2, stream);

        int i1;
        for (i1 = 0; i1 < this.anInt839; ++i1) {
            int l = this.anIntArray840[i1];
            if (this.playerArray[l].anInt1537 != loopCycle) {
                this.playerArray[l] = null;
            }
        }

        if (stream.currentOffset != i) {
            SignLink.reporterror(
                    "Error packet size mismatch in getplayer pos:" + stream.currentOffset + " psize:" + i);
            throw new RuntimeException("eek");
        } else {
            for (i1 = 0; i1 < this.playerCount; ++i1) {
                if (this.playerArray[this.playerIndices[i1]] == null) {
                    SignLink.reporterror(
                            this.myUsername + " null entry in pl list - pos:" + i1 + " size:" + this.playerCount);
                    throw new RuntimeException("eek");
                }
            }

        }
    }

    public final void method144(int i, int j, int k, int l, int i1, int j1, int k1) {
        int l1 = 2048 - k & 2047;
        int i2 = 2048 - j1 & 2047;
        int j2 = 0;
        int k2 = 0;
        int l2 = j;
        if (i != 0) {
            this.method6();
        }

        int j3;
        int l3;
        int j4;
        if (l1 != 0) {
            j3 = Model.SINE[l1];
            l3 = Model.COSINE[l1];
            j4 = k2 * l3 - j * j3 >> 16;
            l2 = k2 * j3 + j * l3 >> 16;
            k2 = j4;
        }

        if (i2 != 0) {
            if (cameratoggle == 1) {
                if (zoom == 0) {
                    zoom = k2;
                }

                if (lftrit == 0) {
                    lftrit = j2;
                }

                if (fwdbwd == 0) {
                    fwdbwd = l2;
                }

                k2 = zoom;
                j2 = lftrit;
                l2 = fwdbwd;
            }

            j3 = Model.SINE[i2];
            l3 = Model.COSINE[i2];
            j4 = l2 * j3 + j2 * l3 >> 16;
            l2 = l2 * l3 - j2 * j3 >> 16;
            j2 = j4;
        }

        this.xCameraPos = l - j2;
        this.zCameraPos = i1 - k2;
        this.yCameraPos = k1 - l2;
        this.yCameraCurve = k;
        this.xCameraCurve = j1;
    }

    public final boolean method145(boolean flag) {
        if (!flag) {
            this.aClass19ArrayArrayArray827 = null;
        }

        if (this.aRSSocket_1168 == null) {
            return false;
        } else {
            String s2;
            int j15;
            try {
                int var271 = this.aRSSocket_1168.method269();
                if (var271 == 0) {
                    return false;
                }

                if (this.incomingPacket == -1) {
                    this.aRSSocket_1168.method270(this.incoming.buffer, 0, 1);
                    this.incomingPacket = this.incoming.buffer[0] & 255;
                    if (this.aClass17_1000 != null) {
                        this.incomingPacket = this.incomingPacket - this.aClass17_1000.method246() & 255;
                    }

                    packetSize = SizeConstants.packetSizes[this.incomingPacket];
                    --var271;
                }

                if (packetSize == -1) {
                    if (var271 <= 0) {
                        return false;
                    }

                    this.aRSSocket_1168.method270(this.incoming.buffer, 0, 1);
                    packetSize = this.incoming.buffer[0] & 255;
                    --var271;
                }

                if (packetSize == -2) {
                    if (var271 <= 1) {
                        return false;
                    }

                    this.aRSSocket_1168.method270(this.incoming.buffer, 0, 2);
                    this.incoming.currentOffset = 0;
                    packetSize = this.incoming.readUnsignedWord();
                    var271 -= 2;
                }

                if (var271 < packetSize) {
                    return false;
                }

                this.incoming.currentOffset = 0;
                this.aRSSocket_1168.method270(this.incoming.buffer, 0, packetSize);
                this.anInt1009 = 0;
                previousPacket2 = previousPacket1;
                previousPacketSize2 = previousPacketSize1;
                previousPacketSize1 = dealtWithPacketSize;
                previousPacket1 = dealtWithPacket;
                dealtWithPacket = incomingPacket;
                dealtWithPacketSize = packetSize;
                if (this.incomingPacket == 81) {
                    this.method143(packetSize, this.incoming, 9759);
                    this.aBoolean1080 = false;
                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket != -1 && showframeids == 1) {
                    System.out.println("Frameid:" + this.incomingPacket);
                }

                if (this.incomingPacket == 9) {
                    String var53 = this.incoming.readString();
                    byte var32 = this.incoming.readSignedByte();
                    byte var301 = this.incoming.readSignedByte();
                    this.fadingScreen = new Main.FadingScreen(var53, var32, var301, null);
                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 176) {
                    this.anInt1167 = this.incoming.method427();
                    this.anInt1154 = this.incoming.method435();
                    this.anInt1120 = this.incoming.readUnsignedByte();
                    this.anInt1193 = this.incoming.method440();
                    this.anInt1006 = this.incoming.readUnsignedWord();
                    if (this.anInt1193 != 0 && openInterfaceID == -1) {
                        SignLink.dnslookup(TextClass.method586(this.anInt1193));
                        this.clearTopInterfaces();
                        short var511 = 650;
                        if (this.anInt1167 != 201 || this.anInt1120 == 1) {
                            var511 = 655;
                        }

                        this.reportAbuseInput = "";
                        this.canMute = false;

                        for (j15 = 0; j15 < Widget.interfaceCache.length; ++j15) {
                            if (Widget.interfaceCache[j15] != null
                                    && Widget.interfaceCache[j15].contentType == var511) {
                                openInterfaceID = Widget.interfaceCache[j15].parentID;
                                break;
                            }
                        }
                    }

                    this.incomingPacket = -1;
                    return true;
                }

                int var23;
                if (this.incomingPacket == 64) {
                    this.anInt1268 = this.incoming.method427();
                    this.anInt1269 = this.incoming.method428();

                    for (var23 = this.anInt1268; var23 < this.anInt1268 + 8; ++var23) {
                        for (j15 = this.anInt1269; j15 < this.anInt1269 + 8; ++j15) {
                            if (this.aClass19ArrayArrayArray827[this.plane][var23][j15] != null) {
                                this.aClass19ArrayArrayArray827[this.plane][var23][j15] = null;
                                this.spawnGroundItem(var23, j15);
                            }
                        }
                    }

                    for (Class30_Sub1 var31 = (Class30_Sub1) this.aClass19_1179
                            .reverseGetFirst(); var31 != null; var31 = (Class30_Sub1) this.aClass19_1179
                            .reverseGetNext()) {
                        if (var31.anInt1297 >= this.anInt1268 && var31.anInt1297 < this.anInt1268 + 8
                                && var31.anInt1298 >= this.anInt1269 && var31.anInt1298 < this.anInt1269 + 8
                                && var31.anInt1295 == this.plane) {
                            var31.anInt1294 = 0;
                        }
                    }

                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 185) {
                    var23 = this.incoming.method436();
                    Widget.interfaceCache[var23].anInt233 = 3;
                    if (myPlayer.aClass5_1698 == null) {
                        Widget.interfaceCache[var23].anInt234 = (myPlayer.anIntArray1700[0] << 25)
                                + (myPlayer.anIntArray1700[4] << 20) + (myPlayer.equipment[0] << 15)
                                + (myPlayer.equipment[8] << 10) + (myPlayer.equipment[11] << 5) + myPlayer.equipment[1];
                    } else {
                        Widget.interfaceCache[var23].anInt234 = (int) (305419896L + myPlayer.aClass5_1698.aLong78);
                    }

                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 217) {
                    try {
                        clanUsername = incoming.readString();
                        clanMessage = TextInput.processText(incoming.readString());
                        clanTitle = incoming.readString();
                        channelRights = incoming.readUnsignedWord();
                        pushMessage(clanMessage, 12, clanUsername);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

                    this.incomingPacket = -1;
                    return true;
                }
/*if(incomingPacket == 217){
	try {
		clanUsername = incoming.readString();
		clanMessage = TextInput.processText(incoming.readString());
		clanTitle = incoming.readString();
		channelRights = inStream.readUnsignedWord();
		pushMessage(clanMessage, 12, clanUsername);
	} catch (Exception e) {
		e.printStackTrace();
	}
	incomingPacket = -1;
	return true;
}*/
                if (this.incomingPacket == 107) {
                    this.aBoolean1160 = false;

                    for (var23 = 0; var23 < 5; ++var23) {
                        this.aBooleanArray876[var23] = false;
                    }
                    xpCounter = 0;
                    this.incomingPacket = -1;
                    return true;
                }

                int j20;
                Widget var24;
                if (this.incomingPacket == 72) {
                    var23 = this.incoming.method434();
                    var24 = Widget.interfaceCache[var23];

                    for (j20 = 0; j20 < var24.inventoryItemId.length; ++j20) {
                        var24.inventoryItemId[j20] = -1;
                        var24.inventoryItemId[j20] = 0;
                    }

                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 214) {
                    this.anInt822 = packetSize / 8;

                    for (var23 = 0; var23 < this.anInt822; ++var23) {
                        this.aLongArray925[var23] = this.incoming.method414(-35089);
                    }

                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 166) {
                    this.aBoolean1160 = true;
                    this.anInt1098 = this.incoming.readUnsignedByte();
                    this.anInt1099 = this.incoming.readUnsignedByte();
                    this.anInt1100 = this.incoming.readUnsignedWord();
                    this.anInt1101 = this.incoming.readUnsignedByte();
                    this.anInt1102 = this.incoming.readUnsignedByte();
                    if (this.anInt1102 >= 100) {
                        this.xCameraPos = this.anInt1098 * 128 + 64;
                        this.yCameraPos = this.anInt1099 * 128 + 64;
                        this.zCameraPos = this.method42(this.plane, this.yCameraPos, this.xCameraPos) - this.anInt1100;
                    }

                    this.incomingPacket = -1;
                    return true;
                }

                int i23;
                if (this.incomingPacket == 134) {
                	needDrawTabArea = true;
                    int skillId = incoming.readUnsignedByte();
                    int experience2 = incoming.method439();
                    int currentLevel = incoming.readUnsignedByte();
                    int xp = currentExp[skillId];

                    currentExp[skillId] = experience2;
                    currentLevels[skillId] = currentLevel;
                    maximumLevels[skillId] = 1;
                    xpCounter += currentExp[skillId] - xp;
                    expAdded = currentExp[skillId] - xp;
                    for (int k20 = 0; k20 < 98; k20++)
                        if (experience2 >= anIntArray1019[k20])
                            maximumLevels[skillId] = k20 + 2;
                    this.incomingPacket = -1;
                    return true;
                }

                int l25;
                if (this.incomingPacket == 150) {
                    var23 = this.incoming.readUnsignedByte();
                    j15 = this.incoming.readUnsignedByte();
                    j20 = this.incoming.readUnsignedByte();
                    i23 = this.incoming.readUnsignedByte();
                    l25 = this.incoming.readUnsignedByte();
                    ItemDefinition var39 = ItemDefinition.lookup(var23);
                    var39.modifiedModelColors = new int[j15];
                    var39.originalModelColors = new int[j15];
                    var39.modifiedModelColors[j20] = i23;
                    var39.originalModelColors[j20] = l25;
                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 149) {
                    var23 = this.incoming.readUnsignedByte();
                    j15 = this.incoming.readUnsignedByte();
                    if (this.skillLevel != -1) {
                        this.didLevelUp2 = true;
                    } else {
                        this.skillLevel = var23;
                    }

                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 71) {
                    var23 = this.incoming.readUnsignedWord();
                    j15 = this.incoming.method426(0);
                    if (var23 == '\uffff') {
                        var23 = -1;
                    }

                    tabInterfaceIDs[j15] = var23;
                    tabAreaAltered = true;
                    this.incomingPacket = -1;
                    return true;
                }

                int j28;
                if (this.incomingPacket == 74) {
                    j28 = this.incoming.method434();
                    if (j28 == '\uffff') {
                        j28 = -1;
                    }

                    if (j28 != this.currentSong && this.musicEnabled && !lowMem && this.prevSong == 0) {
                        this.nextSong = j28;
                        this.songChanging = true;
                        onDemandFetcher.method558(2, this.nextSong);
                    }

                    this.currentSong = j28;
                    this.incomingPacket = -1;
                    return true;
                }

                int i30;
                if (this.incomingPacket == 121) {
                    j28 = this.incoming.method436();
                    i30 = this.incoming.method435();
                    if (this.musicEnabled && !lowMem) {
                        this.nextSong = j28;
                        this.songChanging = false;
                        onDemandFetcher.method558(2, this.nextSong);
                        this.prevSong = i30;
                    }

                    this.incomingPacket = -1;
                    return true;
                }
                if (this.incomingPacket == 7) {
                    int componentId = incoming.readDWord();
                    byte spriteIndex = incoming.readSignedByte();
                    Widget component = Widget.interfaceCache[componentId];
                    if (component != null) {
                        if (component.backgroundSprites != null && spriteIndex <= component.backgroundSprites.length - 1) {
                            Sprite sprite = component.backgroundSprites[spriteIndex];
                            if (sprite != null) {
                                component.disabledSprite = component.backgroundSprites[spriteIndex];
                            }
                        }
                    }
                    incomingPacket = -1;
                    return true;
                }


                if (this.incomingPacket == 109) {
                    this.resetLogout();
                    this.incomingPacket = -1;
                    return false;
                }

                if (this.incomingPacket == 70) {
                    var23 = this.incoming.method411();
                    j15 = this.incoming.method437(-665);
                    j20 = this.incoming.method434();
                    Widget var35 = Widget.interfaceCache[j20];
                    var35.anInt263 = var23;
                    var35.anInt265 = j15;
                    this.incomingPacket = -1;
                    return true;
                }

                byte var25;
                int var47;
                if (this.incomingPacket == 73 || this.incomingPacket == 241) {
                    var23 = this.mapRegionsX;
                    j15 = this.mapRegionsY;
                    if (this.incomingPacket == 73) {
                        var23 = mapX = MapX = this.incoming.method435();
                        j15 = mapY = MapY = this.incoming.readUnsignedWord();
                        this.aBoolean1159 = false;
                    }

                    if (this.incomingPacket == 241) {
                        j15 = this.incoming.method435();
                        this.incoming.method418(this.anInt1118);
                        j20 = 0;

                        while (true) {
                            if (j20 >= 4) {
                                this.incoming.method420(true);
                                var23 = this.incoming.readUnsignedWord();
                                this.aBoolean1159 = true;
                                break;
                            }

                            for (i23 = 0; i23 < 13; ++i23) {
                                for (l25 = 0; l25 < 13; ++l25) {
                                    j28 = this.incoming.method419(1, 0);
                                    if (j28 == 1) {
                                        this.anIntArrayArrayArray1129[j20][i23][l25] = this.incoming.method419(26, 0);
                                    } else {
                                        this.anIntArrayArrayArray1129[j20][i23][l25] = -1;
                                    }
                                }
                            }

                            ++j20;
                        }
                    }

                    if (this.incomingPacket != 241 && this.mapRegionsX == var23 && this.mapRegionsY == j15
                            && this.anInt1023 == 2) {
                        this.incomingPacket = -1;
                        return true;
                    }

                    this.mapRegionsX = var23;
                    this.mapRegionsY = j15;
                    this.baseX = (this.mapRegionsX - 6) * 8;
                    this.baseY = (this.mapRegionsY - 6) * 8;
                    this.aBoolean1141 = (this.mapRegionsX / 8 == 48 || this.mapRegionsX / 8 == 49) && this.mapRegionsY / 8 == 48;

                    if (this.mapRegionsX / 8 == 48 && this.mapRegionsY / 8 == 148) {
                        this.aBoolean1141 = true;
                    }

                    this.anInt1023 = 1;
                    this.aLong824 = System.currentTimeMillis();
                    aRSImageProducer_1165.initDrawingArea();
                    drawLoadingMessages(1, "Loading - please wait.", null);
                    aRSImageProducer_1165.drawGraphics(0,
                            super.graphics, 0);
                    int var331;
                    int var36;
                    int var521;
                    if (this.incomingPacket == 73) {
                        var331 = 0;
                        var36 = (this.mapRegionsX - 6) / 8;

                        label1399:
                        while (true) {
                            int var37;
                            if (var36 > (this.mapRegionsX + 6) / 8) {
                                this.aByteArrayArray1183 = new byte[var331][];
                                this.aByteArrayArray1247 = new byte[var331][];
                                this.anIntArray1234 = new int[var331];
                                this.anIntArray1235 = new int[var331];
                                this.anIntArray1236 = new int[var331];
                                var331 = 0;
                                var36 = (this.mapRegionsX - 6) / 8;

                                while (true) {
                                    if (var36 > (this.mapRegionsX + 6) / 8) {
                                        break label1399;
                                    }

                                    for (var37 = (this.mapRegionsY - 6) / 8; var37 <= (this.mapRegionsY + 6) / 8; ++var37) {
                                        this.anIntArray1234[var331] = (var36 << 8) + var37;
                                        if (!this.aBoolean1141 || var37 != 49 && var37 != 149 && var37 != 147
                                                && var36 != 50 && (var36 != 49 || var37 != 47)) {
                                            var47 = this.anIntArray1235[var331] = onDemandFetcher.method562(0, var37,
                                                    var36);
                                            if (var47 != -1) {
                                                onDemandFetcher.method558(3, var47);
                                            }

                                            var521 = this.anIntArray1236[var331] = onDemandFetcher.method562(1,
                                                    var37, var36);
                                            if (var521 != -1) {
                                                onDemandFetcher.method558(3, var521);
                                            }

                                            ++var331;
                                        } else {
                                            this.anIntArray1235[var331] = -1;
                                            this.anIntArray1236[var331] = -1;
                                            ++var331;
                                        }
                                    }

                                    ++var36;
                                }
                            }

                            for (var37 = (this.mapRegionsY - 6) / 8; var37 <= (this.mapRegionsY + 6) / 8; ++var37) {
                                ++var331;
                            }

                            ++var36;
                        }
                    }

                    if (this.incomingPacket == 241) {
                        j20 = 0;
                        int[] var421 = new int[676];
                        l25 = 0;

                        label1358:
                        while (true) {
                            int var431;
                            if (l25 >= 4) {
                                this.aByteArrayArray1183 = new byte[j20][];
                                this.aByteArrayArray1247 = new byte[j20][];
                                this.anIntArray1234 = new int[j20];
                                this.anIntArray1235 = new int[j20];
                                this.anIntArray1236 = new int[j20];
                                l25 = 0;

                                while (true) {
                                    if (l25 >= j20) {
                                        break label1358;
                                    }

                                    j28 = this.anIntArray1234[l25] = var421[l25];
                                    i30 = j28 >> 8 & 255;
                                    var521 = j28 & 255;
                                    var431 = this.anIntArray1235[l25] = onDemandFetcher.method562(0, var521, i30);
                                    if (var431 != -1) {
                                        onDemandFetcher.method558(3, var431);
                                    }

                                    var47 = this.anIntArray1236[l25] = onDemandFetcher.method562(1, var521, i30);
                                    if (var47 != -1) {
                                        onDemandFetcher.method558(3, var47);
                                    }

                                    ++l25;
                                }
                            }

                            for (j28 = 0; j28 < 13; ++j28) {
                                for (i30 = 0; i30 < 13; ++i30) {
                                    var521 = this.anIntArrayArrayArray1129[l25][j28][i30];
                                    if (var521 != -1) {
                                        var431 = var521 >> 14 & 1023;
                                        var47 = var521 >> 3 & 2047;
                                        var331 = (var431 / 8 << 8) + var47 / 8;

                                        for (var36 = 0; var36 < j20; ++var36) {
                                            if (var421[var36] == var331) {
                                                var331 = -1;
                                                break;
                                            }
                                        }

                                        if (var331 != -1) {
                                            var421[j20++] = var331;
                                        }
                                    }
                                }
                            }

                            ++l25;
                        }
                    }

                    j20 = this.baseX - this.anInt1036;
                    i23 = this.baseY - this.anInt1037;
                    this.anInt1036 = this.baseX;
                    this.anInt1037 = this.baseY;

                    for (l25 = 0; l25 < 16384; ++l25) {
                        Npc var45 = this.npcArray[l25];
                        if (var45 != null) {
                            for (i30 = 0; i30 < 10; ++i30) {
                                var45.smallX[i30] -= j20;
                                var45.smallY[i30] -= i23;
                            }

                            var45.x -= j20 * 128;
                            var45.y -= i23 * 128;
                        }
                    }

                    for (l25 = 0; l25 < this.anInt888; ++l25) {
                        Player var49 = this.playerArray[l25];
                        if (var49 != null) {
                            for (i30 = 0; i30 < 10; ++i30) {
                                var49.smallX[i30] -= j20;
                                var49.smallY[i30] -= i23;
                            }

                            var49.x -= j20 * 128;
                            var49.y -= i23 * 128;
                        }
                    }

                    this.aBoolean1080 = true;
                    byte var50 = 0;
                    byte var48 = 104;
                    var25 = 1;
                    if (j20 < 0) {
                        var50 = 103;
                        var48 = -1;
                        var25 = -1;
                    }

                    byte var51 = 0;
                    byte var46 = 104;
                    byte var42 = 1;
                    if (i23 < 0) {
                        var51 = 103;
                        var46 = -1;
                        var42 = -1;
                    }

                    for (var331 = var50; var331 != var48; var331 += var25) {
                        for (var36 = var51; var36 != var46; var36 += var42) {
                            int var52 = var331 + j20;
                            int j34 = var36 + i23;

                            for (int k34 = 0; k34 < 4; ++k34) {
                                if (var52 >= 0 && j34 >= 0 && var52 < 104 && j34 < 104) {
                                    this.aClass19ArrayArrayArray827[k34][var331][var36] = this.aClass19ArrayArrayArray827[k34][var52][j34];
                                } else {
                                    this.aClass19ArrayArrayArray827[k34][var331][var36] = null;
                                }
                            }
                        }
                    }

                    for (Class30_Sub1 var54 = (Class30_Sub1) this.aClass19_1179
                            .reverseGetFirst(); var54 != null; var54 = (Class30_Sub1) this.aClass19_1179
                            .reverseGetNext()) {
                        var54.anInt1297 -= j20;
                        var54.anInt1298 -= i23;
                        if (var54.anInt1297 < 0 || var54.anInt1298 < 0 || var54.anInt1297 >= 104
                                || var54.anInt1298 >= 104) {
                            var54.unlink();
                        }
                    }

                    if (this.destX != 0) {
                        this.destX -= j20;
                        this.destY -= i23;
                    }

                    this.aBoolean1160 = false;
                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 208) {
                    var23 = this.incoming.method437(-665);
                    if (var23 >= 0) {
                        this.method60(var23, (byte) 6);
                    }

                    this.openWalkableInterface = var23;
                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 99) {
                    this.anInt1021 = this.incoming.readUnsignedByte();
                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 75) {
                    var23 = this.incoming.method436();
                    j15 = this.incoming.method436();
                    Widget.interfaceCache[j15].anInt233 = 2;
                    Widget.interfaceCache[j15].anInt234 = var23;
                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 114) {
                    this.anInt1104 = this.incoming.method434() * 30;
                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 60) {
                    this.anInt1269 = this.incoming.readUnsignedByte();
                    this.anInt1268 = this.incoming.method427();

                    while (this.incoming.currentOffset < packetSize) {
                        var23 = this.incoming.readUnsignedByte();
                        this.method137(this.anInt1119, this.incoming, var23);
                    }

                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 35) {
                    var23 = this.incoming.readUnsignedByte();
                    j15 = this.incoming.readUnsignedByte();
                    j20 = this.incoming.readUnsignedByte();
                    i23 = this.incoming.readUnsignedByte();
                    this.aBooleanArray876[var23] = true;
                    this.anIntArray873[var23] = j15;
                    this.anIntArray1203[var23] = j20;
                    this.anIntArray928[var23] = i23;
                    this.anIntArray1030[var23] = 0;
                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 174) {
                    var23 = this.incoming.readUnsignedWord();
                    j15 = this.incoming.readUnsignedByte();
                    j20 = this.incoming.readUnsignedWord();
                    var47 = this.incoming.readUnsignedWord();
                    if (this.aBoolean848 && !lowMem && this.anInt1062 < 50) {
                        this.anIntArray1207[this.anInt1062] = var23;
                        this.anIntArray1241[this.anInt1062] = j15;
                        this.anIntArray1250[this.anInt1062] = j20 + Sounds.anIntArray326[var23];
                        this.soundVolume[this.anInt1062] = var47;
                        ++this.anInt1062;
                    }

                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 104) {
                    var23 = this.incoming.method427();
                    j15 = this.incoming.method426(0);
                    String var40 = this.incoming.method415();
                    if (var23 >= 1 && var23 <= 5) {
                        if (var40.equalsIgnoreCase("null")) {
                            var40 = null;
                        }

                        this.aStringArray1127[var23 - 1] = var40;
                        this.aBooleanArray1128[var23 - 1] = j15 == 0;
                    }

                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 78) {
                    this.destX = 0;
                    this.incomingPacket = -1;
                    return true;
                }

                boolean var33;
                String var34;
                String var43;
                if (this.incomingPacket == 253) {
                    s2 = this.incoming.method415();
                    String var341;
                    if (s2.endsWith(":test:")) {
                        var341 = s2.substring(0, s2.indexOf(":"));
                        System.out.println("s3: " + var341);
                    }
                    if (s2.equals(":spin")) {
                        setSpinClick(true);
                        spin();
                        incomingPacket = -1;
                        return true;
                    } else if (s2.equals(":resetBox")) {
                        reset();
                        incomingPacket = -1;
                        return true;
                    }
                    long var27;
                    if (s2.endsWith(":tradereq:")) {
                        var341 = s2.substring(0, s2.indexOf(":"));
                        var27 = TextClass.longForName(var341);
                        var33 = false;

                        for (j28 = 0; j28 < this.anInt822; ++j28) {
                            if (this.aLongArray925[j28] == var27) {
                                var33 = true;
                                break;
                            }
                        }

                        if (!var33 && this.anInt1251 == 0) {
                            this.pushMessage("wishes to trade with you.", 4, var341);
                        }
                    } else if (s2.endsWith(":clan:")) {
                        var43 = s2.substring(0, s2.indexOf(":"));
                        TextClass.longForName(var43);
                        this.pushMessage("Clan: ", 8, var43);
                    } else if (s2.endsWith(":duelreq:")) {
                        var341 = s2.substring(0, s2.indexOf(":"));
                        var27 = TextClass.longForName(var341);
                        var33 = false;

                        for (j28 = 0; j28 < this.anInt822; ++j28) {
                            if (this.aLongArray925[j28] == var27) {
                                var33 = true;
                                break;
                            }
                        }

                        if (!var33 && this.anInt1251 == 0) {
                            this.pushMessage("wishes to duel with you.", 8, var341);
                        }
                    } else if (!s2.endsWith(":chalreq:")) {
                        this.pushMessage(s2, 0, "");
                    } else {
                        var341 = s2.substring(0, s2.indexOf(":"));
                        var27 = TextClass.longForName(var341);
                        var33 = false;

                        for (j28 = 0; j28 < this.anInt822; ++j28) {
                            if (this.aLongArray925[j28] == var27) {
                                var33 = true;
                                break;
                            }
                        }

                        if (!var33 && this.anInt1251 == 0) {
                            var34 = s2.substring(s2.indexOf(":") + 1, s2.length() - 9);
                            this.pushMessage(var34, 8, var341);
                        }
                    }

                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 1) {
                    for (var23 = 0; var23 < this.playerArray.length; ++var23) {
                        if (this.playerArray[var23] != null) {
                            this.playerArray[var23].anim = -1;
                        }
                    }

                    for (var23 = 0; var23 < this.npcArray.length; ++var23) {
                        if (this.npcArray[var23] != null) {
                            this.npcArray[var23].anim = -1;
                        }
                    }

                    this.incomingPacket = -1;
                    return true;
                }

                long var30;
                if (this.incomingPacket == 50) {
                    var30 = this.incoming.method414(-35089);
                    j20 = this.incoming.readUnsignedByte();
                    String var38 = TextClass.fixName(TextClass.nameForLong(var30));

                    for (l25 = 0; l25 < this.friendsCount; ++l25) {
                        if (var30 == this.friendsListAsLongs[l25]) {
                            if (this.friendsNodeIDs[l25] != j20) {
                                this.friendsNodeIDs[l25] = j20;
                                if (j20 > 0) {
                                    this.pushMessage(var38 + " has logged in.", 5, "");
                                }

                                if (j20 == 0) {
                                    this.pushMessage(var38 + " has logged out.", 5, "");
                                }
                            }

                            var38 = null;
                            break;
                        }
                    }

                    if (var38 != null && this.friendsCount < 200) {
                        this.friendsListAsLongs[this.friendsCount] = var30;
                        this.friendsList[this.friendsCount] = var38;
                        this.friendsNodeIDs[this.friendsCount] = j20;
                        ++this.friendsCount;
                    }

                    var33 = false;

                    while (!var33) {
                        var33 = true;

                        for (j28 = 0; j28 < this.friendsCount - 1; ++j28) {
                            if (this.friendsNodeIDs[j28] != anInt957 && this.friendsNodeIDs[j28 + 1] == anInt957
                                    || this.friendsNodeIDs[j28] == 0 && this.friendsNodeIDs[j28 + 1] != 0) {
                                i30 = this.friendsNodeIDs[j28];
                                this.friendsNodeIDs[j28] = this.friendsNodeIDs[j28 + 1];
                                this.friendsNodeIDs[j28 + 1] = i30;
                                var43 = this.friendsList[j28];
                                this.friendsList[j28] = this.friendsList[j28 + 1];
                                this.friendsList[j28 + 1] = var43;
                                long var461 = this.friendsListAsLongs[j28];
                                this.friendsListAsLongs[j28] = this.friendsListAsLongs[j28 + 1];
                                this.friendsListAsLongs[j28 + 1] = var461;
                                var33 = false;
                            }
                        }
                    }

                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 110) {
                    if (tabID == 12) {
                        this.anInt1148 = this.incoming.readUnsignedByte();
                    }

                    this.incomingPacket = -1;
                    return true;
                }
                /*
                 * Sound packet
                 */
                if (incomingPacket == 25) {
                    int id = incoming.readUnsignedByte();
                    int loop = incoming.readUnsignedByte();
                    int dist = incoming.readUnsignedByte();
                    // System.out.println("Received sound packet: "+id+", "+loop+", "+dist+", ");
                    SoundLoader.playSound(id, loop, dist);
                    incomingPacket = -1;
                    return true;
                }
                if (this.incomingPacket == 254) {
                    this.anInt855 = this.incoming.readUnsignedByte();
                    if (this.anInt855 == 1) {
                        this.anInt1222 = this.incoming.readUnsignedWord();
                    }

                    if (this.anInt855 >= 2 && this.anInt855 <= 6) {
                        if (this.anInt855 == 2) {
                            this.anInt937 = 64;
                            this.anInt938 = 64;
                        }

                        if (this.anInt855 == 3) {
                            this.anInt937 = 0;
                            this.anInt938 = 64;
                        }

                        if (this.anInt855 == 4) {
                            this.anInt937 = 128;
                            this.anInt938 = 64;
                        }

                        if (this.anInt855 == 5) {
                            this.anInt937 = 64;
                            this.anInt938 = 0;
                        }

                        if (this.anInt855 == 6) {
                            this.anInt937 = 64;
                            this.anInt938 = 128;
                        }

                        this.anInt855 = 2;
                        this.anInt934 = this.incoming.readUnsignedWord();
                        this.anInt935 = this.incoming.readUnsignedWord();
                        this.anInt936 = this.incoming.readUnsignedByte();
                    }

                    if (this.anInt855 == 10) {
                        this.anInt933 = this.incoming.readUnsignedWord();
                    }

                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 248) {
                    var23 = this.incoming.method435();
                    j15 = this.incoming.readUnsignedWord();
                    if (backDialogID != -1) {
                        backDialogID = -1;
                        inputTaken = true;
                    }

                    if (inputDialogState != 0) {
                        inputDialogState = 0;
                        inputTaken = true;
                    }

                    openInterfaceID = var23;
                    this.invOverlayInterfaceID = j15;
                    tabAreaAltered = true;
                    this.aBoolean1149 = false;
                    this.incomingPacket = -1;
                    return true;
                }

                Widget var26;
                if (this.incomingPacket == 79) {
                    var23 = this.incoming.method434();
                    j15 = this.incoming.method435();
                    var26 = Widget.interfaceCache[var23];
                    if (var26 != null && var26.type == 0) {
                        if (j15 < 0) {
                            j15 = 0;
                        }

                        if (j15 > var26.scrollMax - var26.height) {
                            j15 = var26.scrollMax - var26.height;
                        }

                        var26.scrollPosition = j15;
                    }

                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 68) {
                    for (var23 = 0; var23 < this.settings.length; ++var23) {
                        if (this.settings[var23] != this.anIntArray1045[var23]) {
                            this.settings[var23] = this.anIntArray1045[var23];
                            this.method33(var23);
                        }
                    }

                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 196) {
                    var30 = this.incoming.method414(-35089);
                    j20 = this.incoming.readInt();
                    i23 = this.incoming.readUnsignedByte();
                    var33 = false;

                    for (j28 = 0; j28 < 100; ++j28) {
                        if (this.anIntArray1240[j28] == j20) {
                            var33 = true;
                            break;
                        }
                    }

                    if (i23 <= 1) {
                        for (j28 = 0; j28 < this.anInt822; ++j28) {
                            if (this.aLongArray925[j28] == var30) {
                                var33 = true;
                                break;
                            }
                        }
                    }

                    if (!var33 && this.anInt1251 == 0) {
                        try {
                            this.anIntArray1240[this.anInt1169] = j20;
                            this.anInt1169 = (this.anInt1169 + 1) % 100;
                            var34 = TextInput.method525(packetSize - 13, true, this.incoming);
                            if (i23 != 3) {
                                var34 = Censor.method497(var34, 0);
                            }

                            switch (i23) {
                                case 1:
                                    this.pushMessage(var34, 7, "@cr1@" + TextClass.fixName(TextClass.nameForLong(var30)));
                                    break;
                                case 2:
                                    this.pushMessage(var34, 7, "@cr2@" + TextClass.fixName(TextClass.nameForLong(var30)));
                                    break;
                                case 3:
                                    this.pushMessage(var34, 7, "@cr3@" + TextClass.fixName(TextClass.nameForLong(var30)));
                                    break;
                                case 4:
                                    this.pushMessage(var34, 7, "@cr4@" + TextClass.fixName(TextClass.nameForLong(var30)));
                                    break;
                                case 5:
                                    this.pushMessage(var34, 7, "@cr5@" + TextClass.fixName(TextClass.nameForLong(var30)));
                                    break;
                                case 6:
                                    this.pushMessage(var34, 7, "@cr6@" + TextClass.fixName(TextClass.nameForLong(var30)));
                                    break;
                                case 7:
                                    this.pushMessage(var34, 7, "@cr7@" + TextClass.fixName(TextClass.nameForLong(var30)));
                                    break;
                                case 8:
                                    this.pushMessage(var34, 7, "@cr8@" + TextClass.fixName(TextClass.nameForLong(var30)));
                                    break;
                                case 9:
                                    this.pushMessage(var34, 7, "@cr9@" + TextClass.fixName(TextClass.nameForLong(var30)));
                                    break;
                                case 10:
                                    this.pushMessage(var34, 7, "@cr10@" + TextClass.fixName(TextClass.nameForLong(var30)));
                                    break;
                                case 11:
                                    this.pushMessage(var34, 7, "@cr11@" + TextClass.fixName(TextClass.nameForLong(var30)));
                                    break;
                                case 12:
                                    this.pushMessage(var34, 7, "@cr12@" + TextClass.fixName(TextClass.nameForLong(var30)));
                                    break;
                                case 13:
                                    this.pushMessage(var34, 7, "@cr13@" + TextClass.fixName(TextClass.nameForLong(var30)));
                                    break;
                                case 14:
                                    this.pushMessage(var34, 7, "@cr14@" + TextClass.fixName(TextClass.nameForLong(var30)));
                                    break;
                                case 15:
                                    this.pushMessage(var34, 7, "@cr15@" + TextClass.fixName(TextClass.nameForLong(var30)));
                                    break;
                                case 16:
                                    this.pushMessage(var34, 7, "@cr16@" + TextClass.fixName(TextClass.nameForLong(var30)));
                                    break;
                                case 17:
                                    this.pushMessage(var34, 7, "@cr17@" + TextClass.fixName(TextClass.nameForLong(var30)));
                                    break;
                                case 18:
                                    this.pushMessage(var34, 7, "@cr18@" + TextClass.fixName(TextClass.nameForLong(var30)));
                                    break;
                                case 19:
                                    this.pushMessage(var34, 7, "@cr19@" + TextClass.fixName(TextClass.nameForLong(var30)));
                                    break;
                                case 20:
                                    this.pushMessage(var34, 7, "@cr20@" + TextClass.fixName(TextClass.nameForLong(var30)));
                                    break;
                                case 21:
                                    this.pushMessage(var34, 7, "@cr21@" + TextClass.fixName(TextClass.nameForLong(var30)));
                                    break;
                                case 22:
                                    this.pushMessage(var34, 7, "@cr22@" + TextClass.fixName(TextClass.nameForLong(var30)));
                                    break;

                                case 23:
                                    this.pushMessage(var34, 7, "@cr23@" + TextClass.fixName(TextClass.nameForLong(var30)));
                                    break;

                                case 24:
                                    this.pushMessage(var34, 7, "@cr24@" + TextClass.fixName(TextClass.nameForLong(var30)));
                                    break;

                                case 25:
                                    this.pushMessage(var34, 7, "@cr25@" + TextClass.fixName(TextClass.nameForLong(var30)));
                                    break;
                                default:
                                    this.pushMessage(var34, 3, TextClass.fixName(TextClass.nameForLong(var30)));
                            }
                        } catch (Exception var261) {
                            SignLink.reporterror("cde1");
                        }
                    }

                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 85) {
                    this.anInt1269 = this.incoming.method427();
                    this.anInt1268 = this.incoming.method427();
                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 24) {
                    this.anInt1054 = this.incoming.method428();
                    if (this.anInt1054 == tabID) {
                        if (this.anInt1054 == 3)
                            tabID = 1;
                        else
                            tabID = 3;
                        needDrawTabArea = true;
                    }

                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 246) {
                    var23 = this.incoming.method434();
                    j15 = this.incoming.readUnsignedWord();
                    j20 = this.incoming.readUnsignedWord();
                    if (j20 == '\uffff') {
                        Widget.interfaceCache[var23].anInt233 = 0;
                        this.incomingPacket = -1;
                        return true;
                    }

                    ItemDefinition var44 = ItemDefinition.lookup(j20);
                    Widget.interfaceCache[var23].anInt233 = 4;
                    Widget.interfaceCache[var23].anInt234 = j20;
                    Widget.interfaceCache[var23].modelRotation1 = var44.spritePitch;
                    Widget.interfaceCache[var23].modelRotation2 = var44.spriteCameraRoll;
                    Widget.interfaceCache[var23].modelZoom = var44.spriteScale * 100 / j15;
                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 171) {
                    boolean var41 = this.incoming.readUnsignedByte() == 1;
                    j15 = this.incoming.readUnsignedWord();
                    Widget.interfaceCache[j15].isMouseoverTriggered = var41;
                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 142) {
                    var23 = this.incoming.method434();
                    this.method60(var23, (byte) 6);
                    if (backDialogID != -1) {
                        backDialogID = -1;
                        inputTaken = true;
                    }

                    if (inputDialogState != 0) {
                        inputDialogState = 0;
                        inputTaken = true;
                    }

                    this.invOverlayInterfaceID = var23;
                    tabAreaAltered = true;
                    openInterfaceID = -1;
                    this.aBoolean1149 = false;
                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 126) {
                    try {
                        s2 = this.incoming.readString();
                        j15 = this.incoming.method435();
                        if (s2.startsWith("www.")) {
                            this.launchURL(s2);
                            this.incomingPacket = -1;
                            return true;
                        }
                        if (s2.startsWith("https://")) {
                            this.launchURL(s2);
                            this.incomingPacket = -1;
                            return true;
                        }
                        if (s2.startsWith(":quicks:") && s2.startsWith(":prayer:")) {
                            this.updateStrings(s2, j15);
                        }

                        this.sendFrame126(s2, j15);
                        if (j15 >= 18144 && j15 <= 18244) {
                            this.clanList[j15 - 18144] = s2;
                        }
                    } catch (Exception var251) {
                    }

                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 206) {
                    this.publicChatMode = this.incoming.readUnsignedByte();
                    this.privateChatMode = this.incoming.readUnsignedByte();
                    this.tradeMode = this.incoming.readUnsignedByte();
                    inputTaken = true;
                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 240) {
                    if (tabID == 12) {
                        this.anInt878 = this.incoming.method411();
                    }

                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 8) {
                    var23 = this.incoming.method436();
                    j15 = this.incoming.readUnsignedWord();
                    Widget.interfaceCache[var23].anInt233 = 1;
                    Widget.interfaceCache[var23].anInt234 = j15;
                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 122) {
                    var23 = this.incoming.method436();
                    j15 = this.incoming.method436();
                    j20 = j15 >> 10 & 31;
                    i23 = j15 >> 5 & 31;
                    l25 = j15 & 31;
                    Widget.interfaceCache[var23].textColor = (j20 << 19) + (i23 << 11) + (l25 << 3);
                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 53) {
                    var23 = this.incoming.readUnsignedWord();
                    var24 = Widget.interfaceCache[var23];
                    j20 = this.incoming.readUnsignedWord();

                    for (i23 = 0; i23 < j20; ++i23) {
                        l25 = this.incoming.readUnsignedByte();
                        if (l25 == 255) {
                            l25 = this.incoming.method440();
                        }

                        var24.inventoryItemId[i23] = this.incoming.method436();
                        var24.inventoryAmounts[i23] = l25;
                    }

                    for (i23 = j20; i23 < var24.inventoryItemId.length; ++i23) {
                        var24.inventoryItemId[i23] = 0;
                        var24.inventoryAmounts[i23] = 0;
                    }

                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 230) {
                    var23 = this.incoming.method435();
                    j15 = this.incoming.readUnsignedWord();
                    j20 = this.incoming.readUnsignedWord();
                    i23 = this.incoming.method436();
                    Widget.interfaceCache[j15].modelRotation1 = j20;
                    Widget.interfaceCache[j15].modelRotation2 = i23;
                    Widget.interfaceCache[j15].modelZoom = var23;
                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 221) {
                    this.anInt900 = this.incoming.readUnsignedByte();
                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 177) {
                    this.aBoolean1160 = true;
                    this.anInt995 = this.incoming.readUnsignedByte();
                    this.anInt996 = this.incoming.readUnsignedByte();
                    this.anInt997 = this.incoming.readUnsignedWord();
                    this.anInt998 = this.incoming.readUnsignedByte();
                    this.anInt999 = this.incoming.readUnsignedByte();
                    if (this.anInt999 >= 100) {
                        var23 = this.anInt995 * 128 + 64;
                        j15 = this.anInt996 * 128 + 64;
                        j20 = this.method42(this.plane, j15, var23) - this.anInt997;
                        i23 = var23 - this.xCameraPos;
                        l25 = j20 - this.zCameraPos;
                        j28 = j15 - this.yCameraPos;
                        i30 = (int) Math.sqrt((double) (i23 * i23 + j28 * j28));
                        this.yCameraCurve = (int) (Math.atan2((double) l25, (double) i30) * 325.949D) & 2047;
                        this.xCameraCurve = (int) (Math.atan2((double) i23, (double) j28) * -325.949D) & 2047;
                        if (this.yCameraCurve < 128) {
                            this.yCameraCurve = 128;
                        }

                        if (this.yCameraCurve > 383) {
                            this.yCameraCurve = 383;
                        }
                    }

                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 249) {
                    this.anInt1046 = this.incoming.method426(0);
                    this.unknownInt10 = this.incoming.method436();
                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 65) {//afk packet
                    this.method31(this.incoming, packetSize);
                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 27) {
                    this.messagePromptRaised = false;
                    inputDialogState = 1;
                    this.amountOrNameInput = "";
                    inputTaken = true;
                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 187) {
                    this.messagePromptRaised = false;
                    inputDialogState = 2;
                    this.amountOrNameInput = "";
                    inputTaken = true;
                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 97) {
                    var23 = this.incoming.readUnsignedWord();
                    this.method60(var23, (byte) 6);
                    if (this.invOverlayInterfaceID != -1) {
                        this.invOverlayInterfaceID = -1;
                        inputTaken = true;
                        tabAreaAltered = true;
                    }

                    if (backDialogID != -1) {
                        backDialogID = -1;
                        inputTaken = true;
                    }

                    if (inputDialogState != 0) {
                        inputDialogState = 0;
                        inputTaken = true;
                    }

                    openInterfaceID = var23;
                    this.aBoolean1149 = false;
                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 218) {
                    var23 = this.incoming.method438(false);
                    this.dialogID = var23;
                    inputTaken = true;
                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 87) {
                    var23 = this.incoming.method434();
                    j15 = this.incoming.readInt();
                    this.anIntArray1045[var23] = j15;
                    if (this.settings[var23] != j15) {
                        this.settings[var23] = j15;
                        this.method33(var23);
                        if (this.dialogID != -1) {
                            inputTaken = true;
                        }
                    }

                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 36) {
                    var23 = this.incoming.method434();
                    var25 = this.incoming.method409();
                    this.anIntArray1045[var23] = var25;
                    if (this.settings[var23] != var25) {
                        this.settings[var23] = var25;
                        this.method33(var23);
                        if (this.dialogID != -1) {
                            inputTaken = true;
                        }
                    }

                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 61) {
                    this.anInt1055 = this.incoming.readUnsignedByte();
                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 200) {
                    var23 = this.incoming.readUnsignedWord();
                    j15 = this.incoming.method411();
                    var26 = Widget.interfaceCache[var23];
                    var26.anInt257 = j15;
                    var26.modelZoom = 900;
                    if (j15 == -1) {
                        var26.anInt246 = 0;
                        var26.anInt208 = 0;
                    }

                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 219) {
                    if (this.invOverlayInterfaceID != -1) {
                        this.invOverlayInterfaceID = -1;
                        tabAreaAltered = true;
                    }

                    if (backDialogID != -1) {
                        backDialogID = -1;
                        inputTaken = true;
                    }

                    if (inputDialogState != 0) {
                        inputDialogState = 0;
                        inputTaken = true;
                    }
                    if (this.isFieldInFocus()) {
                        this.resetInputFieldFocus();
                        Main.inputString = "";
                    }
                    openInterfaceID = -1;
                    this.aBoolean1149 = false;
                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 34) {
                    var23 = this.incoming.readUnsignedWord();
                    var24 = Widget.interfaceCache[var23];

                    while (this.incoming.currentOffset < packetSize) {
                        j20 = this.incoming.method422();
                        i23 = this.incoming.readUnsignedWord();
                        l25 = this.incoming.readUnsignedByte();
                        if (l25 == 255) {
                            l25 = this.incoming.readInt();
                        }
                        // System.out.println("Frame id: "+j20);
                        if (j20 >= 0 && j20 < var24.inventoryItemId.length) {
                            var24.inventoryItemId[j20] = i23;
                            var24.inventoryAmounts[j20] = l25;
                        }
                    }

                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 105 || this.incomingPacket == 84 || this.incomingPacket == 147 || this.incomingPacket == 215
                        || this.incomingPacket == 4 || this.incomingPacket == 117 || this.incomingPacket == 156 || this.incomingPacket == 44
                        || this.incomingPacket == 160 || this.incomingPacket == 101 || this.incomingPacket == 151) {
                    this.method137(this.anInt1119, this.incoming, this.incomingPacket);
                    this.incomingPacket = -1;
                    return true;
                }

                if (this.incomingPacket == 106) {
                    tabID = this.incoming.method427();
                    tabAreaAltered = true;
                    this.incomingPacket = -1;
                    return true;
                }
                if (this.incomingPacket == 223) {
                    byte timerId = (byte) incoming.readUnsignedByte();
                    short secondsToAdd = (short) incoming.readUnsignedWord();
                    GameTimerHandler.getSingleton().startGameTimer(timerId, TimeUnit.SECONDS, secondsToAdd);
                    incomingPacket = -1;
                    return true;
                }
                if(this.incomingPacket == 11){
					long experience = incoming.readQWord();
					byte length = incoming.readSignedByte();
					int[] skills = new int[length];

					for (int j = 0; j < length; j++) {
						skills[j] = incoming.readSignedByte();
					}

					ExperienceDrop drop = new ExperienceDrop(experience, skills);

					if (!experienceDrops.isEmpty()) {
						List<ExperienceDrop> sorted = new ArrayList<ExperienceDrop>(experienceDrops);
						Collections.sort(sorted, HIGHEST_POSITION);
						ExperienceDrop highest = sorted.get(0);
						if (highest.getYPosition() >= ExperienceDrop.START_Y - 5) {
							drop.increasePosition(highest.getYPosition() - ExperienceDrop.START_Y + 20);
						}
					}

					experienceDrops.offer(drop);
					incomingPacket = -1;
					return true;
                }
                if (this.incomingPacket == 164) {
                    var23 = this.incoming.method434();
                    this.method60(var23, (byte) 6);
                    if (this.invOverlayInterfaceID != -1) {
                        this.invOverlayInterfaceID = -1;
                        tabAreaAltered = true;
                    }

                    backDialogID = var23;
                    inputTaken = true;
                    openInterfaceID = -1;
                    this.aBoolean1149 = false;
                    this.incomingPacket = -1;
                    return true;
                }
                SignLink.reporterror("T1 - Packet: " + incomingPacket + ", Packet Size: " + packetSize
                        + " - Previous packet: " + previousPacket1 + " Previous packet size: " + previousPacketSize1
                        + ", 2nd Previous packet: " + previousPacket2 + ", 2nd Previous packet size: "
                        + previousPacketSize2);
                resetLogout();
            } catch (IOException var28) {
                this.dropClient();
            } catch (Exception var29) {
                s2 = "T2 - " + this.incomingPacket + "," + this.previousPacket1 + "," + this.previousPacket2 + " - " + packetSize + ","
                        + (this.baseX + myPlayer.smallX[0]) + "," + (this.baseY + myPlayer.smallY[0]) + " - ";

                for (j15 = 0; j15 < packetSize && j15 < 50; ++j15) {
                    s2 = s2 + this.incoming.buffer[j15] + ",";
                }

                SignLink.reporterror(s2);
                this.resetLogout();
            }

            return true;
        }
    }

    public void sendFrame126(String str, int i) {
        Widget.interfaceCache[i].message = str;
    }

    public final void method37(int j) {
        if (!lowMem) {
            Background Background_2;
            int i1;
            int l1;
            byte[] abyte2;
            byte[] abyte5;
            int k2;
            if (Rasterizer.textureLastUsed[24] >= j) {
                Background_2 = Rasterizer.textures[24];
                i1 = Background_2.anInt1452 * Background_2.anInt1453 - 1;
                l1 = Background_2.anInt1452 * this.tickDelta * 2;
                abyte2 = Background_2.aByteArray1450;
                abyte5 = this.animatedPixels;

                for (k2 = 0; k2 <= i1; ++k2) {
                    abyte5[k2] = abyte2[k2 - l1 & i1];
                }

                Background_2.aByteArray1450 = abyte5;
                this.animatedPixels = abyte2;
                Rasterizer.method370(24);
            }

            if (Rasterizer.textureLastUsed[54] >= j) {
                Background_2 = Rasterizer.textures[54];
                i1 = Background_2.anInt1452 * Background_2.anInt1453 - 1;
                l1 = Background_2.anInt1452 * this.tickDelta * 2;
                abyte2 = Background_2.aByteArray1450;
                abyte5 = this.animatedPixels;

                for (k2 = 0; k2 <= i1; ++k2) {
                    abyte5[k2] = abyte2[k2 - l1 & i1];
                }

                Background_2.aByteArray1450 = abyte5;
                this.animatedPixels = abyte2;
                Rasterizer.method370(54);
            }

            if (Rasterizer.textureLastUsed[17] >= j) {
                Background_2 = Rasterizer.textures[17];
                i1 = Background_2.anInt1452 * Background_2.anInt1453 - 1;
                l1 = Background_2.anInt1452 * this.tickDelta * 2;
                abyte2 = Background_2.aByteArray1450;
                abyte5 = this.animatedPixels;

                for (k2 = 0; k2 <= i1; ++k2) {
                    abyte5[k2] = abyte2[k2 - l1 & i1];
                }

                Background_2.aByteArray1450 = abyte5;
                this.animatedPixels = abyte2;
                Rasterizer.method370(17);
                ++anInt854;
                if (anInt854 > 1235) {
                    anInt854 = 0;
                    stream.createFrame(226);
                    stream.writeByte(0);
                    k2 = stream.currentOffset;
                    stream.method399('\ue562');
                    stream.writeByte(240);
                    stream.method399((int) (Math.random() * 65536.0D));
                    stream.writeByte((int) (Math.random() * 256.0D));
                    if ((int) (Math.random() * 2.0D) == 0) {
                        stream.method399('\uca71');
                    }

                    stream.writeByte((int) (Math.random() * 256.0D));
                    stream.method399((int) (Math.random() * 65536.0D));
                    stream.method399(7130);
                    stream.method399((int) (Math.random() * 65536.0D));
                    stream.method399('\uf0d9');
                    stream.method407(stream.currentOffset - k2, (byte) 0);
                }
            }

            if (Rasterizer.textureLastUsed[59] >= j) {
                Background_2 = Rasterizer.textures[59];
                i1 = Background_2.anInt1452 * Background_2.anInt1453 - 1;
                l1 = Background_2.anInt1452 * this.tickDelta * 2;
                abyte2 = Background_2.aByteArray1450;
                abyte5 = this.animatedPixels;

                for (k2 = 0; k2 <= i1; ++k2) {
                    abyte5[k2] = abyte2[k2 - l1 & i1];
                }

                Background_2.aByteArray1450 = abyte5;
                this.animatedPixels = abyte2;
                Rasterizer.method370(59);
            }
            if (Rasterizer.textureLastUsed[61] >= j) {
                Background_2 = Rasterizer.textures[61];
                i1 = Background_2.anInt1452 * Background_2.anInt1453 - 1;
                l1 = Background_2.anInt1452 * this.tickDelta * 2;
                abyte2 = Background_2.aByteArray1450;
                abyte5 = this.animatedPixels;

                for (k2 = 0; k2 <= i1; ++k2) {
                    abyte5[k2] = abyte2[k2 - l1 & i1];
                }

                Background_2.aByteArray1450 = abyte5;
                this.animatedPixels = abyte2;
                Rasterizer.method370(61);
            }

            if (Rasterizer.textureLastUsed[62] >= j) {
                Background_2 = Rasterizer.textures[62];
                i1 = Background_2.anInt1452 * Background_2.anInt1453 - 1;
                l1 = Background_2.anInt1452 * this.tickDelta * 2;
                abyte2 = Background_2.aByteArray1450;
                abyte5 = this.animatedPixels;

                for (k2 = 0; k2 <= i1; ++k2) {
                    abyte5[k2] = abyte2[k2 - l1 & i1];
                }

                Background_2.aByteArray1450 = abyte5;
                this.animatedPixels = abyte2;
                Rasterizer.method370(62);
            }

            if (Rasterizer.textureLastUsed[63] >= j) {
                Background_2 = Rasterizer.textures[63];
                i1 = Background_2.anInt1452 * Background_2.anInt1453 - 1;
                l1 = Background_2.anInt1452 * this.tickDelta * 2;
                abyte2 = Background_2.aByteArray1450;
                abyte5 = this.animatedPixels;

                for (k2 = 0; k2 <= i1; ++k2) {
                    abyte5[k2] = abyte2[k2 - l1 & i1];
                }

                Background_2.aByteArray1450 = abyte5;
                this.animatedPixels = abyte2;
                Rasterizer.method370(63);
            }

            if (Rasterizer.textureLastUsed[64] >= j) {
                Background_2 = Rasterizer.textures[64];
                i1 = Background_2.anInt1452 * Background_2.anInt1453 - 1;
                l1 = Background_2.anInt1452 * this.tickDelta * 2;
                abyte2 = Background_2.aByteArray1450;
                abyte5 = this.animatedPixels;

                for (k2 = 0; k2 <= i1; ++k2) {
                    abyte5[k2] = abyte2[k2 - l1 & i1];
                }

                Background_2.aByteArray1450 = abyte5;
                this.animatedPixels = abyte2;
                Rasterizer.method370(64);
            }
            if (Rasterizer.textureLastUsed[24] >= j) {
                Background_2 = Rasterizer.textures[24];
                i1 = Background_2.anInt1452 * Background_2.anInt1453 - 1;
                l1 = Background_2.anInt1452 * this.tickDelta * 2;
                abyte2 = Background_2.aByteArray1450;
                abyte5 = this.animatedPixels;

                for (k2 = 0; k2 <= i1; ++k2) {
                    abyte5[k2] = abyte2[k2 - l1 & i1];
                }

                Background_2.aByteArray1450 = abyte5;
                this.animatedPixels = abyte2;
                Rasterizer.method370(24);
            }

            if (Rasterizer.textureLastUsed[40] >= j) {
                Background_2 = Rasterizer.textures[40];
                i1 = Background_2.anInt1452 * Background_2.anInt1453 - 1;
                l1 = Background_2.anInt1452 * this.tickDelta * 2;
                abyte2 = Background_2.aByteArray1450;
                abyte5 = this.animatedPixels;

                for (k2 = 0; k2 <= i1; ++k2) {
                    abyte5[k2] = abyte2[k2 - l1 & i1];
                }

                Background_2.aByteArray1450 = abyte5;
                this.animatedPixels = abyte2;
                Rasterizer.method370(40);
            }

            if (Rasterizer.textureLastUsed[49] >= j) {
                Background_2 = Rasterizer.textures[49];
                i1 = Background_2.anInt1452 * Background_2.anInt1453 - 1;
                l1 = Background_2.anInt1452 * this.tickDelta * 2;
                abyte2 = Background_2.aByteArray1450;
                abyte5 = this.animatedPixels;

                for (k2 = 0; k2 <= i1; ++k2) {
                    abyte5[k2] = abyte2[k2 - l1 & i1];
                }

                Background_2.aByteArray1450 = abyte5;
                this.animatedPixels = abyte2;
                Rasterizer.method370(49);
            }
            if (Rasterizer.textureLastUsed[34] >= j) {
                Background_2 = Rasterizer.textures[34];
                i1 = Background_2.anInt1452 * Background_2.anInt1453 - 1;
                l1 = Background_2.anInt1452 * this.tickDelta * 2;
                abyte2 = Background_2.aByteArray1450;
                abyte5 = this.animatedPixels;

                for (k2 = 0; k2 <= i1; ++k2) {
                    abyte5[k2] = abyte2[k2 - l1 & i1];
                }

                Background_2.aByteArray1450 = abyte5;
                this.animatedPixels = abyte2;
                Rasterizer.method370(34);
            }

        }

    }

    public void method146() {
        ++this.anInt1265;
        this.method47(true);
        this.method26(true);
        this.method47(false);
        this.method26(false);
        this.method55();
        this.method104(true);
        int j;
        int l;
        if (!this.aBoolean1160) {
            j = this.anInt1184;
            if (this.anInt984 / 256 > j) {
                j = this.anInt984 / 256;
            }

            if (this.aBooleanArray876[4] && this.anIntArray1203[4] + 128 > j) {
                j = this.anIntArray1203[4] + 128;
            }

            l = this.anInt1185 + this.anInt896 & 2047;
            this.method144(0,
                    cameraZoom + j * (WorldController.viewDistance == 9 && currentScreenMode == Main.ScreenMode.RESIZABLE ? 2
                            : (WorldController.viewDistance == 10 ? 5 : 3)),
                    j, this.anInt1014, this.method42(this.plane, myPlayer.y, myPlayer.x) - 50, l, this.anInt1015);
        }

        if (!this.aBoolean1160) {
            j = this.method120(111);
        } else {
            j = this.method121(this.anInt1081);
        }

        l = this.xCameraPos;
        int i1 = this.zCameraPos;
        int j1 = this.yCameraPos;
        int k1 = this.yCameraCurve;
        int l1 = this.xCameraCurve;

        int k2;
        for (k2 = 0; k2 < 5; ++k2) {
            if (this.aBooleanArray876[k2]) {
                int var12 = (int) (Math.random() * (double) (this.anIntArray873[k2] * 2 + 1)
                        - (double) this.anIntArray873[k2]
                        + Math.sin((double) this.anIntArray1030[k2] * ((double) this.anIntArray928[k2] / 100.0D))
                        * (double) this.anIntArray1203[k2]);
                if (k2 == 0) {
                    this.xCameraPos += var12;
                }

                if (k2 == 1) {
                    this.zCameraPos += var12;
                }

                if (k2 == 2) {
                    this.yCameraPos += var12;
                }

                if (k2 == 3) {
                    this.xCameraCurve = this.xCameraCurve + var12 & 2047;
                }

                if (k2 == 4) {
                    this.yCameraCurve += var12;
                    if (this.yCameraCurve < 128) {
                        this.yCameraCurve = 128;
                    }

                    if (this.yCameraCurve > 383) {
                        this.yCameraCurve = 383;
                    }
                }
            }
        }

        k2 = Rasterizer.anInt1481;
        Model.aBoolean1684 = true;
        Model.anInt1687 = 0;
        Model.anInt1685 = super.mouseX - 4;
        Model.anInt1686 = super.mouseY - 4;
        DrawingArea.setAllPixelsToZero();
        if (Constants.distanceFog) {
            if (!switching && currentFogColor != fadingTo) {
                switching = true;
            }

            if (switching) {
                ++step;
                if (step >= 100) {
                    step = 1;
                    switching = false;
                    currentFogColor = fadingTo;
                } else {
                    currentFogColor = this.mixColors(new Color(currentFogColor), new Color(fadingTo), (float) step);
                }
            }
        }

        DrawingArea.drawPixels(currentGameHeight, 0, 0, Constants.distanceFog ? currentFogColor : 0, currentGameWidth);
        if (loggedIn) {
            try {
                this.worldController.method313(this.xCameraPos, this.yCameraPos, this.xCameraCurve, this.zCameraPos, j,
                        this.yCameraCurve);
                this.worldController.method288((byte) 104);
                if (Constants.enableFogRendering && !Constants.enableRainbowFog) {
                    currentFog = 0;
                    if (currentScreenMode == ScreenMode.FIXED) {
                        Rasterizer.drawFog(Constants.fogColor, 2250, 2800);
                    } else {
                        Rasterizer.drawFog(Constants.fogColor, 1800, 2800);
                    }
                } else if (Constants.enableRainbowFog) {
                    if (System.currentTimeMillis() - lastFog > Constants.fogDelay) {
                        currentFog += 1;
                        lastFog = System.currentTimeMillis();
                    }
                    if (currentFog > 6) {
                        currentFog = 0;
                    }
                    if (currentScreenMode == ScreenMode.FIXED) {
                        Rasterizer.drawFog(rainbowFog[currentFog], 2250, 2800);
                    } else {
                        Rasterizer.drawFog(rainbowFog[currentFog], 1800, 2800);
                    }
                }
            } catch (Exception var9) {
            }
        }
        Iterator<Particle> iterator;
        Particle particle;
        if (particlesToggle) {
            iterator = currentParticles.iterator();
            while (iterator.hasNext()) {
                particle = iterator.next();
                if (particle != null) {
                    particle.tick();
                    if (particle.isDead()) {
                        removeParticles.add(particle);
                    } else {
                        ParticleDefinition def = particle.getDefinition();
                        int displayX = particle.getPosition().getX();
                        int displayY = particle.getPosition().getY();
                        int displayZ = particle.getPosition().getZ();
                        int width;
                        int height;
                        if (def.getSprite() == null) {
                            width = 8;
                            height = 8;
                        } else {
                            def.getSprite();
                            width = DrawingArea.width / 4;
                            def.getSprite();
                            height = DrawingArea.height / 4;
                        }
                        width = (int) (width * particle.getSize());
                        height = (int) (height * particle.getSize());
                        int[] projection = projection(displayX, displayY, displayZ, width, height);
                        width = projection[5] - projection[3];
                        height = projection[6] - projection[4];
                        float size = particle.getSize();
                        int alpha = (int) (particle.getAlpha() * 255.0F);
                        int radius = (int) ((4.0F) * particle.getSize());
                        int srcAlpha = 256 - alpha;
                        int srcR = (particle.getColor() >> 16 & 255) * alpha;
                        int srcG = (particle.getColor() >> 8 & 255) * alpha;
                        int srcB = (particle.getColor() & 255) * alpha;
                        int y1 = projection[1] - radius;
                        if (y1 < 0) {
                            y1 = 0;
                        }
                        int y2 = projection[1] + radius;
                        if (y2 >= DrawingArea.height) {
                            y2 = DrawingArea.height - 1;
                        }
                        for (int iy = y1; iy <= y2; ++iy) {
                            int dy = iy - projection[1];
                            int dist = (int) Math.sqrt(radius * radius - dy * dy);
                            int x1 = projection[0] - dist;
                            if (x1 < 0) {
                                x1 = 0;
                            }
                            int x2 = projection[0] + dist;
                            if (x2 >= DrawingArea.width) {
                                x2 = DrawingArea.width - 1;
                            }
                            int pixel = x1 + iy * DrawingArea.width;
                            try {
                                if (Rasterizer.depthBuffer != null) {
                                    if (Rasterizer.depthBuffer[pixel] >= projection[2] - size - 15 || Rasterizer.depthBuffer[pixel++] >= projection[2] + size + 15) {
                                        for (int ix = x1; ix <= x2; ++ix) {
                                            int dstR = (aRSImageProducer_1165.canvasRaster[pixel] >> 16 & 255) * srcAlpha;
                                            int dstG = (aRSImageProducer_1165.canvasRaster[pixel] >> 8 & 255) * srcAlpha;
                                            int dstB = (aRSImageProducer_1165.canvasRaster[pixel] & 255) * srcAlpha;
                                            int rgb = (srcR + dstR >> 8 << 16) + (srcG + dstG >> 8 << 8) + (srcB + dstB >> 8);
                                            aRSImageProducer_1165.canvasRaster[pixel++] = rgb;
                                        }
                                    }
                                }
                            } catch (Exception exception) {
                            }
                        }
                    }
                }
            }
        } else {
            iterator = currentParticles.iterator();
            while (iterator.hasNext()) {
                particle = iterator.next();
                if (particle != null) {
                    particle.tick();
                    if (particle.isDead()) {
                        removeParticles.add(particle);
                    }
                }
            }
            currentParticles.removeAll(removeParticles);
            removeParticles.clear();
        }
        currentParticles.removeAll(removeParticles);
        removeParticles.clear();
        this.updateEntities();
        this.drawHeadIcon();
        this.method37(k2);
        if (loggedIn) {
            if (openInterfaceID == -1) {

                //Combat hp overlay
/*				if(shouldDrawCombatBox()) {
					drawCombatBox();
				}

				if(skillOrbs) {
					SkillOrbs.process();
				}*/
                if (expDrops) {
                    drawExpCounterDrops();
                }
            }
            if (currentScreenMode != Main.ScreenMode.FIXED) {
                this.drawChatArea();
                this.drawMinimap();
                this.drawTabArea();
            }
            if (Constants.Render_item_names) {
                render_ground_item_names();
            }
            this.draw3dScreen();
            processExperienceCounter();
            if (Constants.enablegrid) {
                drawGrid();
            }
            aRSImageProducer_1165.drawGraphics(0, super.graphics, 0);
            this.xCameraPos = l;
            this.zCameraPos = i1;
            this.yCameraPos = j1;
            this.yCameraCurve = k1;
            this.xCameraCurve = l1;
        }

    }

    public final void clearTopInterfaces() {
        stream.createFrame(130);
        if (this.invOverlayInterfaceID != -1) {
            this.invOverlayInterfaceID = -1;
            this.aBoolean1149 = false;
            tabAreaAltered = true;
        }

        if (backDialogID != -1) {
            backDialogID = -1;
            inputTaken = true;
            this.aBoolean1149 = false;
        }

        openInterfaceID = -1;
        this.fullscreenInterfaceID = -1;
    }

    public int mixColors(Color color1, Color color2, float i) {
        float ratio = i / 100.0F;
        int red = (int) ((float) color2.getRed() * ratio + (float) color1.getRed() * (1.0F - ratio));
        int green = (int) ((float) color2.getGreen() * ratio + (float) color1.getGreen() * (1.0F - ratio));
        int blue = (int) ((float) color2.getBlue() * ratio + (float) color1.getBlue() * (1.0F - ratio));
        return (new Color(red, green, blue)).getRGB();
    }

    private boolean interfaceContainsItem(int interfaceId) {
        Widget rsi = Widget.interfaceCache[interfaceId];
        if (rsi == null)
            return false;
        if (rsi.inventoryItemId == null) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < rsi.inventoryItemId.length; i++) {
            if (rsi.inventoryItemId[i] > 0) {
                count++;
            }
        }
        return count > 0;
    }

    public int[] projection(int i, int j, int l, int width, int height) {
        if (i >= 128 && l >= 128 && i <= 13056 && l <= 13056) {
            int i1 = this.method42(this.plane, l, i) - j;
            i -= this.xCameraPos;
            i1 -= this.zCameraPos;
            l -= this.yCameraPos;
            int j1 = Model.SINE[this.yCameraCurve];
            int k1 = Model.COSINE[this.yCameraCurve];
            int l1 = Model.SINE[this.xCameraCurve];
            int i2 = Model.COSINE[this.xCameraCurve];
            int j2 = l * l1 + i * i2 >> 16;
            l = l * i2 - i * l1 >> 16;
            i = j2;
            j2 = i1 * k1 - l * j1 >> 16;
            l = i1 * j1 + l * k1 >> 16;
            return l >= 50 && l <= 3500
                    ? new int[]{Rasterizer.centerX + (i << WorldController.viewDistance) / l,
                    Rasterizer.centerY + (j2 << WorldController.viewDistance) / l, l,
                    Rasterizer.centerX + (i - width / 2 << WorldController.viewDistance) / l,
                    Rasterizer.centerY + (j2 - height / 2 << WorldController.viewDistance) / l,
                    Rasterizer.centerX + (i + width / 2 << WorldController.viewDistance) / l,
                    Rasterizer.centerY + (j2 + height / 2 << WorldController.viewDistance) / l}
                    : new int[7];
        } else {
            return new int[7];
        }
    }

    public void addParticle(Particle particle) {
        currentParticles.add(particle);
    }

    public void resetAllImageProducers() {
        if (super.fullGameScreen == null) {
            aRSImageProducer_1166 = null;
            this.aRSImageProducer_1164 = null;
            aRSImageProducer_1163 = null;
            aRSImageProducer_1165 = null;
            this.aRSImageProducer_1125 = null;
            this.aRSImageProducer_1107 = null;
            this.aRSImageProducer_1108 = null;
            this.aRSImageProducer_1109 = null;
            this.aRSImageProducer_1110 = null;
            this.aRSImageProducer_1111 = null;
            this.aRSImageProducer_1112 = null;
            this.aRSImageProducer_1113 = null;
            this.aRSImageProducer_1114 = null;
            this.aRSImageProducer_1115 = null;
            super.fullGameScreen = new RSImageProducer(765, 503, getGameComponent());
            this.aBoolean1255 = true;
        }

    }

    public enum ScreenMode {

        FIXED(1, 765, 503, false, false),
        RESIZABLE(2, 902, 702, true, false),
        FULLSCREEN(3, (int) Main.MAXIMUM_SCREEN_BOUNDS.getWidth(), (int) Main.MAXIMUM_SCREEN_BOUNDS.getHeight(), false, true);

        private final int numericalValue;

        private final int width;

        private final int height;

        private final boolean resizable;

        private final boolean undecorated;

        ScreenMode(int numericalValue, int width, int height, boolean resizable, boolean undecorated) {
            this.numericalValue = numericalValue;
            this.width = width;
            this.height = height;
            this.resizable = resizable;
            this.undecorated = undecorated;
        }

        public int getNumericalValue() {
            return numericalValue;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public boolean isResizable() {
            return resizable;
        }

        public boolean isUndecorated() {
            return undecorated;
        }

    }

    private class FadingScreen {
        private String text;
        private byte state;
        private byte seconds;
        private StopWatch watch;

        private FadingScreen() {
        }

        private FadingScreen(String text, byte state, byte seconds) {
            this.text = text;
            this.state = state;
            this.seconds = seconds;
            this.watch = new StopWatch();
            this.watch.start();
        }

        FadingScreen(Main.FadingScreen var2) {
            this();
        }

        FadingScreen(String var2, byte var3, byte var4, Main.FadingScreen var5) {
            this(var2, var3, var4);
        }

        private void draw() {
            if (this.state != 0) {
                long end = this.watch.getStartTime() + 1000L * (long) this.seconds;
                long increment = (end - this.watch.getStartTime()) / 100L;
                if (increment > 0L) {
                    long percentile = this.watch.getTime() / increment;
                    int opacity = (int) (percentile * 1L * 2L);
                    if (this.state < 0) {
                        opacity = 255 - opacity;
                    }

                    if (percentile > -1L && percentile <= 100L) {
                        DrawingArea.setDrawingArea(334, 0, 512, 0);
                        DrawingArea.drawAlphaBox(0, 0, 512, 334, 0, opacity);
                        if (percentile > 85L && this.state == 1 || percentile < 50L && this.state == -1) {
                            Main.this.newRegularFont.drawCenteredString(this.text, 256, 167, 16777215, 0);
                        } else if (percentile == 100L) {
                            this.watch.stop();
                            this.state = 0;
                        }
                    }
                }
            }

        }
    }
    public Main() {
        try {
            this.midiPlayer = new MidiPlayer();
        } catch (Exception var2) {
            var2.printStackTrace();
        }

        currentParticles = new ArrayList<Particle>(10000);
        removeParticles = new ArrayList<Particle>();
        instance = this;
        openInterfaceID = -1;
        this.currentExp = new int[25];
        clanTitles = new String[500];
        experienceCounter = 0;
        resize = false;
        xpAddedPos = expAdded = 0;
        this.musicEnabled = true;
        this.anIntArray873 = new int[5];
        BlackMap = new Sprite[2];
        this.soundVolume = new int[50];
        this.anInt874 = -1;
        this.currentSong = -1;
        this.songChanging = true;
        this.anInt875 = -680;
        this.aBooleanArray876 = new boolean[5];
        this.anInt877 = 1834;
        this.aBoolean880 = false;
        this.reportAbuseInput = "";
        this.anInt882 = -30815;
        this.unknownInt10 = -1;
        this.menuOpen = false;
        inputString = "";
        this.anInt888 = 2048;
        this.myPlayerIndex = 2047;
        this.playerArray = new Player[this.anInt888];
        this.playerIndices = new int[this.anInt888];
        this.anIntArray894 = new int[this.anInt888];
        this.astreamArray895 = new Buffer[this.anInt888];
        this.anInt897 = 1;
        this.anIntArrayArray901 = new int[104][104];
        this.animatedPixels = new byte[16384];
        this.aByte920 = 14;
        this.currentLevels = new int[25];
        this.aByte923 = 25;
        this.aLongArray925 = new long[100];
        this.aBoolean926 = false;
        this.anIntArray928 = new int[5];
        this.anIntArrayArray929 = new int[104][104];
        this.aCRC32_930 = new CRC32();
        this.chatTypes = new int[500];
        this.chatNames = new String[500];
        this.playerTitles = new String[500];
        this.chatMessages = new String[500];
        this.sideIcons = new Sprite[15];
        this.aBoolean954 = true;
        this.friendsListAsLongs = new long[200];
        this.anInt956 = -1;
        this.aBoolean962 = false;
        this.spriteDrawX = -1;
        this.spriteDrawY = -1;
        this.anIntArray968 = new int[33];
        this.anIntArray969 = new int[256];
        this.Indexes = new Decompressor[Constants.IndexAmount];
        this.settings = new int[10000];
        this.aBoolean972 = false;
        this.aByte973 = -74;
        this.anInt975 = 50;
        currentExp = new int[Skills.skillsCount];
        this.anIntArray976 = new int[this.anInt975];
        this.anIntArray977 = new int[this.anInt975];
        this.anIntArray978 = new int[this.anInt975];
        this.anIntArray979 = new int[this.anInt975];
        this.anIntArray980 = new int[this.anInt975];
        this.anIntArray981 = new int[this.anInt975];
        this.anIntArray982 = new int[this.anInt975];
        this.aStringArray983 = new String[this.anInt975];
        this.anInt985 = -1;
        this.aSpriteArray987 = new Sprite[20];
        this.anIntArray990 = new int[5];
        this.amountOrNameInput = "";
        this.aByte1012 = 24;
        this.aClass19_1013 = new NodeList(169);
        this.aBoolean1017 = false;
        this.openWalkableInterface = -1;
        this.anIntArray1030 = new int[5];
        this.aBoolean1031 = false;
        this.MapFunction = new Sprite[700];
        this.dialogID = -1;
        this.maximumLevels = new int[25];
        this.anIntArray1045 = new int[2000];
        this.aBoolean1047 = true;
        this.anIntArray1052 = new int[152];
        this.anInt1054 = -1;
        this.aClass19_1056 = new NodeList(169);
        this.anIntArray1057 = new int[33];
        this.anInt1058 = 24869;
        this.aClass9_1059 = new Widget();
        this.aBackgroundArray1060 = new Sprite[300];
        this.gameframe = new Sprite[70];
        this.anInt1063 = 5063219;
        this.anIntArray1065 = new int[7];
        this.anIntArray1072 = new int[1000];
        this.anIntArray1073 = new int[1000];
        this.aBoolean1080 = false;
        this.anInt1081 = -733;
        this.friendsList = new String[200];
        headIconsHint = new Sprite[20];
        this.incoming = Buffer.create();
        this.expectedCRCs = new int[9];
        this.menuActionCmd2 = new int[500];
        this.menuActionCmd3 = new int[500];
        this.menuActionCmd4 = new int[500];
        this.menuActionID = new int[500];
        this.menuActionCmd1 = new int[500];
        this.headIcons = new Sprite[20];
        this.skullIcons = new Sprite[20];
        chatButtons = new Sprite[4];
        tabAreaAltered = false;
        this.anInt1105 = 519;
        this.anInt1116 = 445;
        this.anInt1118 = -29508;
        this.anInt1119 = -77;
        this.aString1121 = "";
        this.aStringArray1127 = new String[5];
        this.aBooleanArray1128 = new boolean[5];
        this.anIntArrayArrayArray1129 = new int[4][13][13];
        this.anInt1132 = 2;
        this.aSpriteArray1140 = new Sprite[1000];
        this.aBoolean1141 = false;
        this.aBoolean1149 = false;
        this.aSpriteArray1150 = new Sprite[8];
        this.aBoolean1151 = true;
        loggedIn = false;
        this.canMute = false;
        this.aBoolean1159 = false;
        this.aBoolean1160 = false;
        this.anInt1171 = 1;
        this.myUsername = "";
        this.myPassword = "";
        this.cButtonHPos = -1;
        this.npcArray = new Npc[16384];
        this.cButtonCPos = 0;
        server = Constants.localHost ? Constants.localAddress : Constants.liveAddress;
        //server = "127.0.0.1";
        // server = "185.219.133.188";
        port = "43594";
        this.aBoolean1176 = false;
        this.reportAbuseInterfaceID = -1;
        this.aClass19_1179 = new NodeList(169);
        this.anInt1184 = 128;
        this.invOverlayInterfaceID = -1;
        stream = Buffer.create();
        this.aByte1194 = 5;
        this.menuActionName = new String[500];
        this.anIntArray1203 = new int[5];
        this.aBoolean1206 = true;
        this.anIntArray1207 = new int[50];
        this.anInt1210 = 2;
        anInt1211 = 78;
        this.promptInput = "";
        this.aByte1217 = 6;
        this.anInt1218 = -589;
        this.ModIcons = new Sprite[26];
        tabID = 3;
        inputTaken = false;
        this.aBoolean1228 = true;
        this.anIntArray1229 = new int[152];
        this.aClass11Array1230 = new CollisionMap[4];
        this.anIntArray1240 = new int[100];
        this.anIntArray1241 = new int[50];
        this.aBoolean1242 = false;
        this.anIntArray1250 = new int[50];
        this.aBoolean1252 = false;
        this.aBoolean1255 = false;
        this.messagePromptRaised = false;
        this.loginMessage1 = "";
        this.loginMessage2 = "";
        this.aByte1274 = -13;
        backDialogID = -1;
        this.aBoolean1277 = true;
        this.anInt1279 = 2;
        this.anIntArray1280 = new int[4000];
        this.anIntArray1281 = new int[4000];
        this.anInt1289 = -1;
    }
    static {
        cameraZoom = 600;
        showChatComponents = true;
        showTabComponents = true;
        //changeChatArea = Main.currentScreenMode != Main.ScreenMode.FIXED;
        //changeTabArea = Main.currentScreenMode != Main.ScreenMode.FIXED;
        transparentTabArea = false;
        hdminimap = false;
        controlIsDown = false;
        skillName = new String[]{"Attack", "Defence", "Strength", "Hitpoints", "Ranging", "Prayer", "Magic",
                "Cooking", "Woodcutting", "Fletching", "Fishing", "Firemaking", "Crafting", "Smithing", "Mining",
                "Herblore", "Agility", "Thieving", "Slayer", "Farming", "Runecrafting", "Construction", "Hunter"};
        itemDebug = false;
        debuggingItem = 0;
        iRotx = 0;
        iRoty = 0;
        iZoom = 0;
        iOffx = 0;
        iOffy = 0;
        flip = false;
        newDamage = false;
        flip_s = false;
        flip_r = false;
        cameraPos2 = 600;
        clientWidth = 765;
        clientHeight = 503;
        clientSize = 0;
        TotalRead = 0;
        nearby = true;
        chatCensor = true;
        aByte823 = 77;
        aBigInteger856 = new BigInteger(
                "7162900525229798032761816791230527296329313291232324290237849263501208207972894053929065636522363163621000728841182238772712427862772219676577293600221789");
        aBoolean919 = true;
        anInt957 = 10;
        isMembers = true;
        PLAYER_BODY_RECOLOURS = new int[][]{
                {6798, 107, 10283, 16, 4797, 7744, 5799, 4634, -31839, 22433, 2983, -11343, 8, 5281, 10438, 3650,
                        -27322, -21845, 200, 571, 908, 21830, 28946, -15701, -14010},
                {8741, 12, '\ufa1e', '\ua89a', 7735, 8404, 1701, '\u961e', 24094, 10153, '\udd2d', 4783, 1341, 16578,
                        '\u88bb', 25239},
                {25238, 8742, 12, '\ufa1e', '\ua89a', 7735, 8404, 1701, '\u961e', 24094, 10153, '\udd2d', 4783, 1341,
                        16578, '\u88bb'},
                {4626, 11146, 6439, 12, 4758, 10270}, {4550, 4537, 5681, 5673, 5790, 6806, 8076, 4574}};
        anIntArray1019 = new int[1000];
        aBigInteger1032 = new BigInteger(
                "58778699976184461502525193738213253649000149147835990136706041084440742975821");
        tabInterfaceIDs = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        aString1162 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"�$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ";
        aByte1200 = 9;
        anIntArray1204 = new int[]{9104, 10275, 7595, 3610, 7975, 8526, 918, '\u9792', 24466, 10145, '\ue51e', 5027,
                1457, 16565, '\u88af', 25486};
        CachePath = null;
        aBoolean1224 = true;
        int i = 0;

        int k;
        for (k = 0; k < 1000; ++k) {
            int l = k + 1;
            int i1 = (int) ((double) l + 300.0D * Math.pow(2.0D, (double) l / 7.0D));
            i += i1;
            Main.anIntArray1019[k] = i / 4;
        }

        BIT_MASKS = new int[32];
        i = 2;

        for (k = 0; k < 32; ++k) {
            Main.BIT_MASKS[k] = i - 1;
            i += i;
        }

        step = 1;
        switching = false;
    }
	public final int[] 
			orbX = {174, 190, 190, 174},
			orbY = {14, 53, 92, 127},
			orbTextX = {215, 231, 231, 215},
			orbIconX = {183, 197, 200, 183}, 
			orbIconY = {23, 60, 99, 136}, 
			orbTextY = {40, 79, 118, 153},
			coloredOrbX = {177, 193, 193, 177},
			coloredOrbY = {17, 56, 95, 130},
			currentInterface = {4016, 4012, 149, 4030},
			maximumInterface = {4017, 4013, 149, 4031};
    private final int[] modeX = new int[]{164, 230, 296, 362};
    private final int[] modeNamesX = new int[]{26, 86, 150, 212, 286, 349, 427};
    private final int[] modeNamesY = new int[]{158, 158, 153, 153, 153, 153, 158};
    private final int[] channelButtonsX = new int[]{5, 71, 137, 203, 269, 335, 404};
    private final String[] modeNames = new String[]{"All", "Game", "Public", "Private", "Clan", "Trade",
            "Report Abuse"};
    private final int[] chatRights = new int[500];
    private final int[] anIntArray1177 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            3};
    private final int[] soundVolume;
    private final String[] clanTitles;
    public boolean isPoisoned;
    public boolean clickedQuickPrayers;
    public int xpAddedPos;
    public int expAdded;
    public boolean expDrops = true;
    public boolean skillOrbs = true;
    public int[] currentExp;
    /**
     * Main Verison
     */
    public int ClientVerison = 4;
    public int rememberMehover;
    public String message;
    public String name;
    public int anInt1315;
    public int spriteDrawX;
    public int spriteDrawY;
    public int anInt1501;
    public Npc[] npcArray;
    public int[] settings;
    public boolean FogToggle = true;
    public int anInt1129;
    public int anInt1044;
    public int anInt1500;
    public RSFont newSmallFont;
    public RSFont newRegularFont;
    public RSFont newBoldFont;
    public RSFont newFancyFont;
    public int drawCount;
    public int textbox;
    public int textbox1;
    public int loginButtonint;
    public String clanname;
    public int rights;
    public boolean didLevelUp2 = false;
    public int fullscreenInterfaceID = -1;
    public Sprite[] chatImages = new Sprite[2];
    public boolean normalLogin = false;
    public boolean rememberMe = false;
    public boolean hitmarks554 = true;
    public boolean hpBar554 = true;
    public boolean runEnergy = false;
    public int[] positions = new int[12000];
    public int[] landScapes = new int[12000];
    public int[] objects = new int[12000];
    public PlayerTitles playerTitle = new PlayerTitles();
    public SoundLoader soundloader = new SoundLoader();
    public int skiilLevel = -1;
    public int skiliToLvl1 = -1;
    public int siklllevel1 = -1;
    public int levelUpInstances = 0;
    public boolean didLeveIUp = false;
    public boolean skyLoad = true;
    public int resizeable = 0;
    public int chattab = 0;
    public String[] playerTitles;
    public Decompressor[] Indexes;
    public double fillHP;
    public Sprite worldMap1, worldMap2, worldMap3;
    public int tooltipDelay = 50;
    public boolean exitRequested = false;
    public int currentFog = 0;
    public int[] rainbowFog = {0xFF0000, 0xFF7F00, 0xFFFF00, 0x00FF00, 0x0000FF, 0x4B0082, 0x9400D3};
    public long lastFog = 0;
    int midiVolume = 256;
    long aLong1220;
    boolean aBoolean954;
    int anInt1237;
    int anInt1238;
    int anInt1022;
    String aString1139;
    String aString1286;
    MouseDetection mouseDetection;
    int[] playerIndices;
    int[] anIntArray840 = new int[1000];
    int[] npcIndices = new int[16384];
    int skillToLvi = -1;
    MidiPlayer midiPlayer;
    int winheight = Toolkit.getDefaultToolkit().getScreenSize().height;
    int taskbarheight = winheight - MAXIMUM_SCREEN_BOUNDS.height;
    int targetindex;
    boolean targetedplayer;
    Sprite[] sideIcons = new Sprite[15];
    Sprite[] redStones = new Sprite[6];
    Sprite tabAreaFixed;
    Sprite[] tabAreaResizable = new Sprite[3];
    ItemSearch grandExchangeItemSearch = null;
    private int splitPrivateChat;
    private int anInt898;
    private Pattern pattern;
    private int gameMode;
    private Matcher matcher;
    private Sprite multiOverlay;
    private int menuScreenArea;
    private boolean aBoolean994;
    private boolean placeHolders = true;
    /**
     * The current skill being practised.
     */
    private int currentSkill = -1;
    private int anInt1020;
    private int anInt1040;
    private int anInt1041;
    private int anInt546;
    private int anInt1227;
    private int anInt1259;
    private int anInt1216;
    private int modifiableXValue = 1; // u dont care if it starts at 1? Can't see a real problem with it :P kk
    private InformationFile informationFile = new InformationFile();
    private int plane;
    private boolean messagePromptRaised;
    private String promptInput;
    private int friendsListAction;
    private long aLong953;
    private String aString1121;
    private int anInt1186;
    private int anInt1187;
    private boolean aBoolean1206;
    private boolean runHover, prayHover, hpHover, prayClicked, specialHover, expCounterHover, worldHover, autocast;
    private int menuActionRow;
    private boolean aBoolean872;
    private boolean aBoolean1242;
    private int anInt989;
    private int anInt1084;
    private int anInt1085;
    private int activeInterfaceType;
    private int anInt1087;
    private int anInt1088;
    private boolean menuOpen;
    private int cButtonHPos = -1;
    private int cButtonCPos = 0;
    private int chatTypeView = 0;
    private int setChannel;
    private String reportAbuseInput;
    private boolean canMute;
    private int reportAbuseInterfaceID;
    private int incomingPacket;
    private int anInt985;
    private int anInt1071;
    private int anInt886;
    private int mouseInvInterfaceIndex;
    private int lastActiveInvInterface;
    private int anInt839;
    private int anInt893;
    private int anInt877;
    private int currentSong;
    private boolean musicEnabled;
    private boolean aBoolean848 = true;
    private int anInt1253;
    private boolean aBoolean1255;
    private int anInt1249;
    private int anInt1195;
    private int anInt913;
    private int nextSong;
    private boolean songChanging;
    private int prevSong;
    private int anInt974;
    private int friendsCount;
    private int xCameraPos;
    private int zCameraPos;
    private int yCameraPos;
    private int yCameraCurve;
    private int xCameraCurve;
    private RSSocket aRSSocket_1168;
    private int loginScreenState;
    private boolean aBoolean1031;
    private int npcCount;
    private int destX;
    private int anInt1011;
    private boolean aBoolean1047;
    private Background aBackground_966;
    private Background aBackground_967;
    private Sprite aSprite_1201;
    private Sprite aSprite_1202;
    private int[] anIntArray851;
    private int[] anIntArray852;
    private int[] anIntArray853;
    private int[] anIntArray850;
    private int[] anIntArray1190;
    private int[] anIntArray1191;
    private int[] anIntArray828;
    private volatile boolean aBoolean880;
    private volatile boolean aBoolean831 = false;
    private long aLong824;
    private int anInt1023;
    private int anInt1104;
    private int anInt1016;
    private boolean aBoolean1017;
    private int anInt1009;
    private int tickDelta;
    private int crossIndex;
    private int crossType;
    private int atInventoryLoopCycle;
    private int atInventoryInterfaceType;
    private int anInt914;
    private int anInt915;
    private String aString844;
    private int anInt1213;
    private int anInt988;
    private NodeList[][][] aClass19ArrayArrayArray827 = new NodeList[4][104][104];
    private int anInt1278;
    private int anInt1279;
    private int anInt1131;
    private int anInt896;
    private int anInt1132;
    private int anInt897;
    private int anInt1254;
    private int anInt1209;
    private int anInt1210;
    private int anInt1170;
    private int anInt1171;
    private int anInt1010;
    private RSImageProducer aRSImageProducer_1164;
    private RSImageProducer aRSImageProducer_1125;
    private RSImageProducer aRSImageProducer_1110;
    private RSImageProducer aRSImageProducer_1111;
    private RSImageProducer aRSImageProducer_1107;
    private RSImageProducer aRSImageProducer_1108;
    private RSImageProducer aRSImageProducer_1109;
    private RSImageProducer aRSImageProducer_1112;
    private RSImageProducer aRSImageProducer_1113;
    private RSImageProducer aRSImageProducer_1114;
    private RSImageProducer aRSImageProducer_1115;
    private int anInt1079;
    private String aString1049;
    private int anInt992;
    private boolean aBoolean972;
    private int anInt1021;
    private int loginScreenCursorPos;
    private int anInt1184;
    private int anInt1185;
    private int clanChatMode = 0;
    private int publicChatMode;
    private int privateChatMode;
    private int tradeMode;
    private int atInventoryInterface;
    private int atInventoryIndex;
    private boolean aBoolean1149;
    private int spellSelected;
    private int spellID;
    private int anInt1138;
    private int itemSelected;
    private boolean runClicked = true;
    private int anInt1283;
    private int anInt1284;
    private int anInt1285;
    private int anInt1251;
    private Buffer astream_834 = new Buffer(new byte[5000], 891);
    private Sprite CustomMapback;
    private Sprite[] gameframe;
    private Buffer astream_847 = Buffer.create();
	private boolean counterHover;
    private Buffer incoming;
    private int[] anIntArray1234;
    private byte[][] aByteArrayArray1183;
    private byte[][] aByteArrayArray1247;
    private int[] anIntArray1235;
    private int[] anIntArray1236;
    private int[][][] anIntArrayArrayArray1214;
    private byte[][][] byteGroundArray;
    private WorldController worldController;
    private CollisionMap[] aClass11Array1230;
    private int[][] anIntArrayArray901;
    private int[][] anIntArrayArray825 = new int[104][104];
    private int[] anIntArray1280;
    private int[] anIntArray1281;
    private byte[] animatedPixels;
    private RSImageProducer aRSImageProducer_903;
    private RSImageProducer aRSImageProducer_904;
    private RSImageProducer aRSImageProducer_905;
    private RSImageProducer aRSImageProducer_906;
    private RSImageProducer aRSImageProducer_907;
    private RSImageProducer aRSImageProducer_908;
    private RSImageProducer aRSImageProducer_909;
    private RSImageProducer aRSImageProducer_910;
    private RSImageProducer aRSImageProducer_911;
    private Sprite mapBack;
    private Sprite Mapicon;
    private Sprite frame;
    private Background aBackground_867;
    private Sprite aSprite_868;
    private Background aBackground_869;
    private Sprite compass;
    private Sprite[] aSpriteArray987;
    private Sprite[] headIcons;
    private Sprite[] headIconsHint;
    private Sprite[] skullIcons;
    private Sprite[] aSpriteArray1150;
    //private Background hporbs;
    private Sprite aSprite_1074;
    private Sprite aSprite_1075;
    private Sprite aSprite_1076;
    private Sprite aSprite_1077;
    private Sprite aSprite_1078;
    private Sprite[] aBackgroundArray1060;
    private Sprite[] MapFunction;
    private int[][] anIntArrayArray929;
    private Player[] playerArray;
    private Sprite chatArea;
    private int[] anIntArray894;
    private Buffer[] astreamArray895;
    private NodeList aClass19_1179;
    private NodeList aClass19_1013;
    private NodeList aClass19_1056;
    private int[] menuActionCmd2;
    private int[] menuActionCmd3;
    private int[] menuActionCmd4;
    private int[] menuActionID;
    private int[] menuActionCmd1;
    private String[] menuActionName;
    private int[] anIntArray1072;
    private int[] anIntArray1073;
    private Sprite[] aSpriteArray1140;
    private Sprite minimapImage;
    private String[] friendsList;
    private long[] friendsListAsLongs;
    private int[] friendsNodeIDs = new int[200];
    private String amountOrNameInput;
    private Sprite aSprite_931;
    private Sprite aSprite_932;
    private int anInt1026;
    private int anInt1048;
    private int anInt1039;
    private String loginMessage1;
    private String loginMessage2;
    private long aLong1215;
    private int myPrivilege;
    private int dealtWithPacket;
    private int dealtWithPacketSize;
    private int previousPacket1;
    private int previousPacket2;
    private int previousPacketSize2;
    private int previousPacketSize1;
    private int anInt855;
    private int anInt1062;
    private int destY;
    private int playerCount;
    private ISAACRandomGen aClass17_1000;
    private int anInt900;
    private int dialogID;
    private int invOverlayInterfaceID;
    private int openWalkableInterface;
    private int anInt1055;
    private int anInt1054;
    private int anInt1264;
    private int anInt1257;
    private long aLong1172;
    private boolean aBoolean1252;
    private StreamLoader titleStreamLoader;
    private TextDrawingArea smallText;
    private TextDrawingArea regularText;
    private TextDrawingArea boldText;
    private TextDrawingArea fencyText;
    private boolean aBoolean926;
    private Sprite aSprite_1001;
    private Sprite aSprite_870;
    private Sprite aSprite_871;
    private Sprite scrollBar1;
    private Sprite scrollBar2;
    private Sprite scrollBar3;
    private Sprite scrollBar4;
    private int anInt1119;
    private int anInt1014;
    private int anInt1015;
    private int anInt984;
    private int anInt822;
    private int menuOffsetX;
    private int menuOffsetY;
    private int menuWidth;
    private int menuHeight;
    private Socket aSocket832;
    private volatile boolean aBoolean962;
    private int anInt1058;
    private int anInt1208;
    private int anInt1218;
    private int anInt1118;
    private String myUsername;
    private String myPassword;
    private boolean aBoolean1080;
    private Main.FadingScreen fadingScreen = new Main.FadingScreen(null);
    private int anInt1167;
    private int anInt1154;
    private int anInt1120;
    private int anInt1193;
    private int anInt1006;
    private int anInt1268;
    private int anInt1269;
    private boolean aBoolean1160;
    private int anInt1098;
    private int anInt1099;
    private int anInt1100;
    private int anInt1101;
    private int anInt1102;
    private int skillLevel = -1;
    private boolean aBoolean1159;
    private int mapRegionsX;
    private int mapRegionsY;
    private int baseX;
    private int baseY;
    private boolean aBoolean1141;
    private int anInt1036;
    private int anInt1037;
    private int anInt1148;
    private int anInt1222;
    private int anInt933;
    private int anInt937;
    private int anInt938;
    private int anInt934;
    private int anInt935;
    private int anInt936;
    private int anInt1169;
    private int anInt878;
    private int anInt995;
    private int anInt996;
    private int anInt997;
    private int anInt998;
    private int anInt999;
    private int anInt1046;
    private int unknownInt10;
    private int anInt1265;
    private boolean particlesToggle = true;
    private Sprite[] LOGINBUTTON = new Sprite[2];
    private int anInt547 = (int) Math.ceil(Math.random() * 2000.0D) + 100;
    private int anInt548 = (int) Math.ceil(Math.random() * 2000.0D) + 100;
    private int anInt549 = (int) Math.ceil(Math.random() * 2000.0D) + 100;
    private int anInt550 = (int) Math.ceil(Math.random() * 2000.0D) + 100;
    private boolean showIds = true;
    private int anInt838 = 9;
    private int[] anIntArray965 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
    private String[] clanList = new String[100];
    private int[] anIntArray873;
    private int anInt874;
    private int anInt875;
    private boolean[] aBooleanArray876;
    private int anInt882;
    private int anInt888;
    private int myPlayerIndex;
    private byte aByte920;
    private int[] currentLevels;
    private byte aByte923;
    private long[] aLongArray925;
    private int[] anIntArray928;
    private CRC32 aCRC32_930;
    private int[] chatTypes;
    private String[] chatNames;
    private String[] chatMessages;
    private int anInt956;
    private int[] anIntArray968;
    private int[] anIntArray969;
    private byte aByte973;
    private int anInt975;
    private int[] anIntArray976;
    private int[] anIntArray977;
    private int[] anIntArray978;
    private int[] anIntArray979;
    private int[] anIntArray980;
    private int[] anIntArray981;
    private int[] anIntArray982;
    private String[] aStringArray983;
    private int[] anIntArray990;
    private byte aByte1012;
    private int[] anIntArray1030;
    private int[] maximumLevels;
    private int[] anIntArray1045;
    private int[] anIntArray1052;
    private int[] anIntArray1057;
    private Widget aClass9_1059;
    private int anInt1063;
    private int[] anIntArray1065;
    private int anInt1081;
    private int[] expectedCRCs;
    private int anInt1105;
    private int anInt1116;
    private String[] aStringArray1127;
    private boolean[] aBooleanArray1128;
    private int[][][] anIntArrayArrayArray1129;
    private boolean aBoolean1151;
    private boolean aBoolean1176;
    private byte aByte1194;
    private int[] anIntArray1203;
    private int[] anIntArray1207;
    /**
     * Drawing of exp counter drops
     */
    private byte aByte1217;
    private Sprite[] ModIcons;
    private boolean aBoolean1228;
    private int[] anIntArray1229;
    private int[] anIntArray1240;
    private int[] anIntArray1241;
    private int[] anIntArray1250;
    private byte aByte1274;
    private boolean aBoolean1277;
    private int anInt1289;
    private int[][] xp_added = new int[10][3];
    private Sprite[] skill_sprites = new Sprite[Skills.skillsCount];
    /**
     * The player's total exp
     */
    private long totalExp;
    private int digits, xpCounter;
    private boolean hoverOverlay;
    private boolean spinClick;
    private int spins;
    private int spinNum;
    private Sprite compassImage;
    private Sprite worldmap, worldmapborder;
    private Sprite[] mapArea = new Sprite[8];
    private boolean sendingAutochat = false;
    private int poisonType = 0;
    private Sprite channelButtons;
    private int specialEnabled = 0;
    private int specialAttack = 0;
    private String clanUsername;
    private String clanMessage;
    private String clanTitle;
    private int channelRights;
    private AccountData currentAccount;
    private Sprite[] chatButtons;
    private int[][] grandExchangeInformation = new int[][]{{-1, -1, -1, -1}, {-1, -1, -1, -1}, {-1, -1, -1, -1},
            {-1, -1, -1, -1}, {-1, -1, -1, -1}, {-1, -1, -1, -1}, {-1, -1, -1, -1}, {-1, -1, -1, -1},
            {-1, -1, -1, -1},
            // { 0, 11802, 0, 10 },
            // { 0, 11804, 4, 14 },
            // { 2, 11826, 2, 2 },
            // { 1, 555, 47500, 52500 },
            // { 0, 560, 35000, 50000 },
            // { 1, 11847, 0, 1 },
            // { -1, -1, -1, -1 }
    };
    private Sprite[] BlackMap;
    private boolean gameTimers = true;
    private boolean NewMenu = false;
    public static String cursorInfo[] = {
"Walk-to",
    "Take",
    "Use",
    "Talk-to",
    "Pointless",
    "Net",
    "Bait",
    "Cage",
    "Harpo",
    "Chop",
    "Bury",
    "Pray-at",
    "Mine",
    "Eat",
    "Drink",
    "Wield",
    "Wear",
    "aweeeeeeeeeeee",
//"Remove",
"Pointless",
    "Enter",
    "Logout",
    "Climb-up",
    "Climb-down",
    "Search",
    "Steal",
    "Smelt",
    "Clean",
    "Back",
    "Deposit Bank",
    "Inspect",
    "Pickpocket",
    "Zoom",
    "Pointless",
    "Settings",
    "Pointless",
    "Pointless",
    "Accept",
    "Decline",
    "Cast Ice Barrage",
    "Cast Blood Barrage",
    "Cast Shadow Barrage",
    "Cast Smoke Barrage",
    "Cast Ice Blitz",
    "Cast Blood Blitz",
    "Cast Shadow Blitz",
    "Cast Smoke Blitz",
    "Cast Ice Burst",
    "Cast Blood Burst",
    "Cast Shadow Burst",
    "Cast Smoke Burst",
    "Cast Ice Rush",
    "Cast Blood Rush",
    "Cast Shadow Rush",
    "Cast Smoke Rush",
    "Link",
    "Split Private",
    "Graphics",
    "Audio",
    "Pointless",
    "Pointless",
    "Choose",
    "Informati",
    "Cast High level alchemy",
    "Cast Low level alchemy",
    "Pointless",
    "Select Starter",
    "Craft-rune",
    "World Map",
    "Withdraw",
    "Slash",
    "Pull",
    "Cast Superheat Item",
    "Cast Wind strike",
    "Cast Earth strike",
    "Cast Fire strike",
    "Cast Water strike",
    "Cast Earth bolt",
    "Cast Wind bolt",
    "Cast Water bolt",
    "Cast Fire bolt",
    "Cast Wind blast",
    "Cast Water blast",
    "Cast Earth blast",
    "Cast Fire blast",
    "Cast Wind wave",
    "Cast Water wave",
    "Cast Earth wave",
    "Cast Fire wave",
    "Cast Magic Dart",
    "Cast Flames of Zamorak",
    "Cast Claws of Guthix",
    "Cast Saradomin strike",
    "Cast Tele Block",
    "Cast Teleother Lumbridge",
    "Cast Teleother Falador",
    "Cast Teleother Camelot",
    "Cast Crumble undead",
    "Cast Charge water orb",
    "Cast Charge earth orb",
    "Cast Charge fire orb",
    "Cast Charge air orb",
    "Dig",
    "Cast Enchant Lvl-1 Jewelry",
    "Cast Enchant Lvl-2 Jewelry",
    "Cast Enchant Lvl-3 Jewelry",
    "Cast Enchant Lvl-4 Jewelry",
    "Cast Enchant Lvl-5 Jewelry",
    "Cast Enchant Lvl-6 Jewelry",
    "Cast Telekinetic grab",
    "Cast Bind",
    "Cast Snare",
    "Cast Entangle",
    "awwwwwwwwwwwwwwwwwwwwwww",
//"Cast Confuse",
"Attack",
    "Close",
};
    private ArrayList<Particle> currentParticles;
    private ArrayList<Particle> removeParticles;
    public static final int[][] PLAYER_BODY_RECOLOURS;
    public static final int[] anIntArray1204;
    public static final String CachePath;
    public static final Rectangle MAXIMUM_SCREEN_BOUNDS = GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getMaximumWindowBounds();
    public static final int INTERFACE_ID = 47000;
    public static final int BOXES64 = 28; // 28 * 64 boxes
    private static final long serialVersionUID = 1823951154553352024L;
    public static boolean shiftDown;
    public static int cameratoggle;
    public static boolean oldGameframe = false;
    public static boolean Gameframe508 = false;
    public static boolean MouseIcons = false;
    public static int IDLE_TIME = 4500; // 1 minute = 3000
    public static int anInt1290;
    public static boolean showpackets = false;
    public static int showframeids;
    public static Sprite[] cacheSprite474;
    public static int currentFogColor = 0;
    public static int cameraZoom;
    public static boolean showChatComponents;
    public static boolean showTabComponents;
    public static boolean changeChatArea;
    public static boolean changeTabArea;
    public static boolean transparentTabArea;
    public static boolean controlIsDown;
	private Sprite[] smallXpSprites = new Sprite[22];
    public static String[] skillName;
    public static boolean itemDebug;
    public static int debuggingItem;
    public static int iRotx;
    public static int iRoty;
    public static int iZoom;
    public static int iOffx;
    public static int iOffy;
    public static boolean flip;
    public static boolean newDamage;
    public static boolean flip_s;
    public static boolean flip_r;
    public static boolean needDrawTabArea;
    public static int cameraPos2;
    public static int clientWidth;
    public static int clientHeight;
    public static int clientSize;
    public static int TotalRead;
    public static boolean nearby;
    public static boolean chatCensor;
    public static int[] tabInterfaceIDs;
    //private static final ScreenMode currentScreenMode = null;
    public static boolean hdminimap;
    public static int[] BIT_MASKS;
    public static int[] fullScreenTextureArray;
    public static int portOff;
    public static Main instance;
    public static boolean loggedIn;
    public static int fadingTo;
    public static int tabID;
    public static int loopCycle;
    public static OnDemandFetcher onDemandFetcher;
    public static boolean aBoolean1205;
    public static Player myPlayer;
    public static int zoom;
    public static int lftrit;
    public static int fwdbwd;
    public static int MapX;
    public static int mapX;
    public static int MapY;
    public static int mapY;
    public static Sprite[] cacheSprite, cacheSprite1, cacheSprite2, cacheSprite3, cacheSprite4, cacheSprite5;
    public static Sprite[] cacheInterface;
    public static ScreenMode currentScreenMode = ScreenMode.FIXED;
    public static int currentGameWidth = currentScreenMode.equals(ScreenMode.FIXED) ? 765 : 0;
    public static int currentGameHeight = currentScreenMode.equals(ScreenMode.FIXED) ? 503 : 0;
    public static int gameScreenWidth = 516;
    public static int gameScreenHeight = 338;
    public static int grandExchangeSearchScrollPostion;
    protected static String server;
    static int step;
    static boolean switching;
    static boolean inputTaken;
    static int inputDialogState;
    static String inputString;
    static int anInt1211;
    static int openInterfaceID;
    static boolean tabAreaAltered;
    static Buffer stream;
    static boolean fpsOn;
    static boolean clientData;
    static int backDialogID;
    static int anInt1089;
    static int anInt1061;
    static long timer = 0;
    private static boolean shiftDrop = true;
    private static int anInt846;
    private static boolean flagged;
    private static byte aByte823;
    private static BigInteger aBigInteger856;
    private static boolean aBoolean919;
    private static int anInt957;
    private static boolean isMembers;
    private static int[] anIntArray1019;
    private static BigInteger aBigInteger1032;
    private static String aString1162;
    private static byte aByte1200;
    private static boolean aBoolean1224;
    private static int[] anIntArray1180;
    private static int[] anIntArray1181;
    private static int[] anIntArray1182;
    private static RSImageProducer aRSImageProducer_1165;
    private static int anInt1097;
    private static int anInt1051;
    private static boolean removeShiftDropOnMenuOpen;
    private static boolean lowMem;
    private static String port;
    private static RSImageProducer aRSImageProducer_1166;
	private long experienceCounter;
    private static RSImageProducer aRSImageProducer_1163;
    private static int packetSize;
    private static int anInt1188;
    private static int anInt924;
    private static int anInt986;
    private static int anInt1226;
    private static int anInt1134;
    private static int anInt1175;
    private static int anInt1155;
    private static boolean aBoolean1231;
    private static int aPort;
    private static int anInt1288;
    private static boolean aBoolean993;
    private static int anInt1117;
    private static int anInt1005;
    private static int anInt1142;
    private static int anInt849;
    private static int anInt854;
    private static boolean resize;
    private Sprite[] inputSprites = new Sprite[7];
    public static final SpriteCache spriteCache = new SpriteCache();
}