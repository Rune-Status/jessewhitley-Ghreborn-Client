package com.Ghreborn.client.features.items;

import java.net.*;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.plaf.metal.MetalLookAndFeel;

import com.Ghreborn.client.cache.def.ItemDefinition;
 
public class ItemEditor implements ActionListener, ChangeListener, MouseListener, MouseMotionListener
{
        private static ItemEditor instance;
        private int itemId = -1;
        public int x = -1;
        public int y = -1;
        public int saveClickX = -1;
        public int saveClickY = -1;
        private boolean selected = false;
        private int modifiedModelColor = 0;
       
        // gui stuff
        private JMenuItem menuItem;
        private JFrame frame;
        private ItemPanel gamePanel;
        private JPanel toolBox;
        private JPanel innerToolBox;
        private JLabel xRotSliderLabel;
        private JSlider rotationXSlider;
        private JLabel yRotSliderLabel;
        private JSlider rotationYSlider;
        private JLabel zoomSliderLabel;
        private JSlider zoomSlider;
        private JLabel xOffSliderLabel;
        private JSlider offsetXSlider;
        private JLabel yOffSliderLabel;
        private JSlider offsetYSlider;
        private JLabel colorLabel;
        private JSlider colorSlider;
        private JLabel presetsLabel;
        private JComboBox presets;
        private JPopupMenu rightClickMenu;
        private JMenuItem menuItem1;
        private JMenu menuItem2;
        private JMenuItem menuItem3;
        private JMenuItem menuItem4;
        private JMenuItem menuItem5;
        private JMenuItem menuItem6;
        private JMenuItem menuItem7;
        private JMenuItem menuItem8;
        private JMenuItem menuItem9;
       
        public boolean isSelected()
        {
                return selected;
        }
       
        public JFrame getFrame()
        {
                return frame;
        }
       
        public int getItemID()
        {
                return itemId;
        }
        public static ItemEditor getInstance()
        {
                return instance;
        }
       
        public static ItemEditor getInstance(int item)
        {
                if (instance != null && instance.itemId != item)
                {
                        instance.frame.dispose();
                        instance = null;
                }
               
                if (instance == null)
                {
                        instance = new ItemEditor(new String[] { item + "" });
                }
               
                return instance;
        }
 
        public ItemEditor(String[] args)
        {
                try
                {
                        itemId = Integer.parseInt(args[0]);
                        initUI();
                }
                catch (Exception ex)
                {
                        ex.printStackTrace();
                }
        }
       
        public void initUI()
        {
                try
                {
                        ItemDefinition iDef = ItemDefinition.lookup(getItemID());
                       
                        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                       
                        frame = new JFrame("Inventory Model Calibrator - By Supah Fly");
                        frame.setLayout(new BorderLayout());
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // DISPOSE_ON_CLOSE
                        frame.addMouseListener(this);
                        frame.addMouseMotionListener(this);
                       
                        rightClickMenu = new JPopupMenu();
                       
                        menuItem1 = new JMenuItem("Choose Item");
                        menuItem1.addActionListener(this);
                       
                        menuItem2 = new JMenu("Set");
                        menuItem2.addActionListener(this);
                       
                        menuItem3 = new JMenuItem("Sprite Pitch");
                        menuItem3.addActionListener(this);
                       
                        menuItem4 = new JMenuItem("Sprite Camera Roll");
                        menuItem4.addActionListener(this);
                       
                        menuItem5 = new JMenuItem("Sprite Scale");
                        menuItem5.addActionListener(this);
                       
                        menuItem6 = new JMenuItem("Sprite Translate X");
                        menuItem6.addActionListener(this);
                       
                        menuItem7 = new JMenuItem("Sprite Translate Y");
                        menuItem7.addActionListener(this);
                       
                        menuItem2.add(menuItem3);
                        menuItem2.add(menuItem4);
                        menuItem2.add(menuItem5);
                        menuItem2.add(menuItem6);
                        menuItem2.add(menuItem7);
                       
                        rightClickMenu.add(menuItem1);
                        rightClickMenu.add(menuItem2);
                       
                        gamePanel = new ItemPanel(this);
                        gamePanel.setLayout(new BorderLayout());
                        gamePanel.setPreferredSize(new Dimension(240, 324));
                       
                        toolBox = new JPanel();
                        toolBox.setLayout(new BoxLayout(toolBox, BoxLayout.Y_AXIS));
                        toolBox.setPreferredSize(new Dimension(225, 324));
                       
                        innerToolBox = new JPanel();
                        innerToolBox.setLayout(new FlowLayout());
                       
                        xRotSliderLabel = new JLabel("Sprite Pitch (" + iDef.spritePitch + ")", JLabel.CENTER);
                        xRotSliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                        xRotSliderLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
                       
                        rotationXSlider = new JSlider(JSlider.HORIZONTAL, 0, 4000, iDef.spritePitch);
                        rotationXSlider.addChangeListener(this);
                        rotationXSlider.setMajorTickSpacing(500);
                        rotationXSlider.setMinorTickSpacing(100);
                        rotationXSlider.setPaintTicks(true);
                        rotationXSlider.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 5));
                       
                        yRotSliderLabel = new JLabel("Sprite Camera Roll (" + iDef.spriteCameraRoll + ")", JLabel.CENTER);
                        yRotSliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                       
                        rotationYSlider = new JSlider(JSlider.HORIZONTAL, 0, 4000, iDef.spriteCameraRoll);
                        rotationYSlider.addChangeListener(this);
                        rotationYSlider.setMajorTickSpacing(500);
                        rotationYSlider.setMinorTickSpacing(100);
                        rotationYSlider.setPaintTicks(true);
                        rotationYSlider.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 5));
                       
                        zoomSliderLabel = new JLabel("Sprite Scale (" + iDef.spriteScale + ")", JLabel.CENTER);
                        zoomSliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                       
                        zoomSlider = new JSlider(JSlider.HORIZONTAL, 317, 4000, iDef.spriteScale);
                        zoomSlider.addChangeListener(this);
                        zoomSlider.setMajorTickSpacing(500);
                        zoomSlider.setMinorTickSpacing(100);
                        zoomSlider.setPaintTicks(true);
                        zoomSlider.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 5));
                       
                        xOffSliderLabel = new JLabel("Sprite Translate X (" + iDef.spriteTranslateX + ")", JLabel.CENTER);
                        xOffSliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                        xOffSliderLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
                       
                        offsetXSlider = new JSlider(JSlider.HORIZONTAL, -200, 200, iDef.spriteTranslateX);
                        offsetXSlider.addChangeListener(this);
                        offsetXSlider.setMajorTickSpacing(50);
                        offsetXSlider.setMinorTickSpacing(10);
                        offsetXSlider.setPaintTicks(true);
                        offsetXSlider.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 5));
                       
                        yOffSliderLabel = new JLabel("Sprite Translate Y (" + iDef.spriteTranslateY + ")", JLabel.CENTER);
                        yOffSliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                        yOffSliderLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
                       
                        offsetYSlider = new JSlider(JSlider.HORIZONTAL, -200, 200, iDef.spriteTranslateY);
                        offsetYSlider.addChangeListener(this);
                        offsetYSlider.setMajorTickSpacing(50);
                        offsetYSlider.setMinorTickSpacing(10);
                        offsetYSlider.setPaintTicks(true);
                        offsetYSlider.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 5));
                       
                        presetsLabel = new JLabel("Presets:", JLabel.CENTER);
                        presetsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                       
                        presets = new JComboBox(new String[] { "Custom", "Top View", "Helmet", "Platebody", "Ring", "Amulet", "Kite Shield", "Square Shield", "Platelegs", "Boots", "Scimitar", "Whip", "Claws", "Dragon Claws", "Defender" });
                        presets.addActionListener(this);
                       
                        innerToolBox.add(presetsLabel);
                        innerToolBox.add(presets);
                       
                        toolBox.add(xRotSliderLabel);
                        toolBox.add(rotationXSlider);
                        toolBox.add(yRotSliderLabel);
                        toolBox.add(rotationYSlider);
                        toolBox.add(zoomSliderLabel);
                        toolBox.add(zoomSlider);
                        toolBox.add(xOffSliderLabel);
                        toolBox.add(offsetXSlider);
                        toolBox.add(yOffSliderLabel);
                        toolBox.add(offsetYSlider);
                       
                        toolBox.add(innerToolBox);
                       
                        frame.getContentPane().add(gamePanel, BorderLayout.WEST);
                        frame.getContentPane().add(toolBox, BorderLayout.EAST);
                        frame.pack();
                       
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                        frame.setResizable(false);
                }
                catch (Exception e)
                {
                        e.printStackTrace();
                }
        }
       
        public void stateChanged(ChangeEvent e)
        {
                presets.setSelectedIndex(0);
                updateModel();
        }
       
        public void updateModel()
        {
                ItemDefinition iDef = ItemDefinition.lookup(getItemID());
               
                iDef.spritePitch = rotationXSlider.getValue();
                iDef.spriteCameraRoll = rotationYSlider.getValue();
                iDef.spriteScale = zoomSlider.getValue();
                iDef.spriteTranslateX = offsetXSlider.getValue();
                iDef.spriteTranslateY = offsetYSlider.getValue();
               
                xRotSliderLabel.setText("Sprite Pitch (" + iDef.spritePitch + ")");
                yRotSliderLabel.setText("Sprite Camera Roll (" + iDef.spriteCameraRoll + ")");
                zoomSliderLabel.setText("Sprite Scale (" + iDef.spriteScale + ")");
                xOffSliderLabel.setText("Sprite Translate X (" + iDef.spriteTranslateX + ")");
                yOffSliderLabel.setText("Sprite Translate Y (" + iDef.spriteTranslateY + ")");
               
                gamePanel.repaint();
        }
       
        public void loadModel(int id)
        {
                //ItemDef.defaultOverride();
                ItemDefinition iDef = ItemDefinition.lookup(id);
                itemId = id;
               
                int rotX = iDef.spritePitch;
                int rotY = iDef.spriteCameraRoll;
                int zoom = iDef.spriteScale;
                int offX = iDef.spriteTranslateX;
                int offY = iDef.spriteTranslateY;
               
                rotationXSlider.setValue(rotX);
                rotationYSlider.setValue(rotY);
                zoomSlider.setValue(zoom);
                offsetXSlider.setValue(offX);
                offsetYSlider.setValue(offY);
               
                selected = false;
                updateModel();
        }
       
        public void actionPerformed(ActionEvent evt)
        {
                if (evt.getSource() instanceof JComboBox)
                {
                        int idx = ((JComboBox)evt.getSource()).getSelectedIndex();
                       
                        switch (idx)
                        {
                                case 1: // top view
                                        rotationXSlider.setValue(520);
                                        rotationYSlider.setValue(0);
                                        zoomSlider.setValue(1740);
                                        offsetXSlider.setValue(0);
                                        offsetYSlider.setValue(0);
                                        break;
                                case 2: // helmet
                                        rotationXSlider.setValue(160);
                                        rotationYSlider.setValue(152);
                                        zoomSlider.setValue(800);
                                        offsetXSlider.setValue(-1);
                                        offsetYSlider.setValue(6);
                                        break;
                                case 3: // platebody
                                        rotationXSlider.setValue(452);
                                        rotationYSlider.setValue(0);
                                        zoomSlider.setValue(1180);
                                        offsetXSlider.setValue(-1);
                                        offsetYSlider.setValue(-1);
                                        break;
                                case 4: // ring
                                        rotationXSlider.setValue(322);
                                        rotationYSlider.setValue(135);
                                        zoomSlider.setValue(830);
                                        offsetXSlider.setValue(-1);
                                        offsetYSlider.setValue(1);
                                        break;
                                case 5: // amulet
                                        rotationXSlider.setValue(424);
                                        rotationYSlider.setValue(68);
                                        zoomSlider.setValue(620);
                                        offsetXSlider.setValue(1);
                                        offsetYSlider.setValue(16);
                                        break;
                                case 6: // kiteshield
                                        rotationXSlider.setValue(344);
                                        rotationYSlider.setValue(1104);
                                        zoomSlider.setValue(1560);
                                        offsetXSlider.setValue(-6);
                                        offsetYSlider.setValue(-14);
                                        break;
                                case 7: // square shield
                                        rotationXSlider.setValue(268);
                                        rotationYSlider.setValue(60);
                                        zoomSlider.setValue(1410);
                                        offsetXSlider.setValue(2);
                                        offsetYSlider.setValue(174);
                                        break;
                                case 8: // platelegs
                                        rotationXSlider.setValue(444);
                                        rotationYSlider.setValue(0);
                                        zoomSlider.setValue(1740);
                                        offsetXSlider.setValue(0);
                                        offsetYSlider.setValue(-8);
                                        break;
                                case 9: // boots
                                        rotationXSlider.setValue(152);
                                        rotationYSlider.setValue(160);
                                        zoomSlider.setValue(770);
                                        offsetXSlider.setValue(1);
                                        offsetYSlider.setValue(-6);
                                        break;
                                case 10: // scimitar
                                        rotationXSlider.setValue(456);
                                        rotationYSlider.setValue(12);
                                        zoomSlider.setValue(1640);
                                        offsetXSlider.setValue(0);
                                        offsetYSlider.setValue(6);
                                        break;
                                case 11: // whip
                                        rotationXSlider.setValue(280);
                                        rotationYSlider.setValue(0);
                                        zoomSlider.setValue(840);
                                        offsetXSlider.setValue(-2);
                                        offsetYSlider.setValue(56);
                                        break;
                                case 12: // claws
                                        rotationXSlider.setValue(268);
                                        rotationYSlider.setValue(1340);
                                        zoomSlider.setValue(630);
                                        offsetXSlider.setValue(-7);
                                        offsetYSlider.setValue(-13);
                                        break;
                                case 13: // dragon claws
                                        rotationXSlider.setValue(239);
                                        rotationYSlider.setValue(70);
                                        zoomSlider.setValue(836);
                                        offsetXSlider.setValue(-2);
                                        offsetYSlider.setValue(-40);
                                        break;
                                case 14: // defender
                                        rotationXSlider.setValue(344);
                                        rotationYSlider.setValue(192);
                                        zoomSlider.setValue(490);
                                        offsetXSlider.setValue(1);
                                        offsetYSlider.setValue(20);
                                        break;
                                default:
                                        break;
                        }
                       
                        //presets.setSelectedIndex(idx);
                }
                else if (evt.getSource() instanceof JMenuItem)
                {
                        JMenuItem item = (JMenuItem)evt.getSource();
                       
                        if (item == menuItem1)
                        {
                                String id = JOptionPane.showInputDialog(null, "Enter the item ID you want to calibrate:", getItemID() + "");
                               
                                if (id != null)
                                {
                                        try
                                        {
                                                loadModel(Integer.parseInt(id));
                                        }
                                        catch (Exception ex)
                                        {
                                                ex.printStackTrace();
                                                JOptionPane.showMessageDialog(null, "Invalid Item ID. Please try again.", "Error", 1);
                                        }
                                }
                        }
                        else if (item == menuItem3)
                        {
                                String id = JOptionPane.showInputDialog(null, "Enter the X-Axis Rotation:", rotationXSlider.getValue() + "");
                               
                                if (id != null)
                                {
                                        try
                                        {
                                                rotationXSlider.setValue(Integer.parseInt(id));
                                        }
                                        catch (Exception ex)
                                        {
                                                JOptionPane.showMessageDialog(null, "Invalid rotation. Please try again.", "Error", 1);
                                        }
                                }
                        }
                        else if (item == menuItem4)
                        {
                                String id = JOptionPane.showInputDialog(null, "Enter the Y-Axis Rotation:", rotationYSlider.getValue() + "");
                               
                                if (id != null)
                                {
                                        try
                                        {
                                                rotationYSlider.setValue(Integer.parseInt(id));
                                        }
                                        catch (Exception ex)
                                        {
                                                JOptionPane.showMessageDialog(null, "Invalid rotation. Please try again.", "Error", 1);
                                        }
                                }
                        }
                        else if (item == menuItem5)
                        {
                                String id = JOptionPane.showInputDialog(null, "Enter the Z-Axis Zoom:", zoomSlider.getValue() + "");
                               
                                if (id != null)
                                {
                                        try
                                        {
                                                zoomSlider.setValue(Integer.parseInt(id));
                                        }
                                        catch (Exception ex)
                                        {
                                                JOptionPane.showMessageDialog(null, "Invalid zoom. Please try again.", "Error", 1);
                                        }
                                }
                        }
                        else if (item == menuItem6)
                        {
                                String id = JOptionPane.showInputDialog(null, "Enter the X Offset:", offsetXSlider.getValue() + "");
                               
                                if (id != null)
                                {
                                        try
                                        {
                                                offsetXSlider.setValue(Integer.parseInt(id));
                                        }
                                        catch (Exception ex)
                                        {
                                                JOptionPane.showMessageDialog(null, "Invalid offset. Please try again.", "Error", 1);
                                        }
                                }
                        }
                        else if (item == menuItem7)
                        {
                                String id = JOptionPane.showInputDialog(null, "Enter the Y Offset:", offsetYSlider.getValue() + "");
                               
                                if (id != null)
                                {
                                        try
                                        {
                                                offsetYSlider.setValue(Integer.parseInt(id));
                                        }
                                        catch (Exception ex)
                                        {
                                                JOptionPane.showMessageDialog(null, "Invalid offset. Please try again.", "Error", 1);
                                        }
                                }
                        }
                }
        }
       
        public void mousePressed(MouseEvent ev)
        {
                saveClickX = ev.getX();
                saveClickY = ev.getY();
               
                if (ev.isPopupTrigger())
                {
                        rightClickMenu.show(ev.getComponent(), saveClickX, saveClickY);
                }
        }
       
        public void mouseReleased(MouseEvent ev)
        {
                if (ev.isPopupTrigger())
                {
                        rightClickMenu.show(ev.getComponent(), saveClickX, saveClickY);
                        saveClickX = -1;
                        saveClickY = -1;
                }
        }
       
        public void mouseClicked(MouseEvent ev)
        {
                if (saveClickX >= 40 && saveClickX <= 82 && saveClickY >= 70 && saveClickY <= 102)
                {                      
                        selected = (selected ? false : true);
                }
                else
                {
                        selected = false;
                }
               
                updateModel();
               
                saveClickX = -1;
                saveClickY = -1;
        }
       
        public void mouseExited(MouseEvent ev)
        {
                x = -1;
                y = -1;
        }
       
        public void mouseEntered(MouseEvent ev)
        {
               
        }
       
        public void mouseMoved(MouseEvent ev)
        {
                x = ev.getX();
                y = ev.getY();
        }
       
        public void mouseDragged(MouseEvent ev)
        {
                int differenceX = ev.getXOnScreen() - saveClickX;
                int differenceY = ev.getYOnScreen() - saveClickY;
               
                //rotationXSlider.setValue(rotationXSlider.getValue() - differenceX);
                //rotationYSlider.setValue(rotationYSlider.getValue() - differenceY);
        }
}