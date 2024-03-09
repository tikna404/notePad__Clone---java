import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {

    JFrame window;
    // text area
    JTextArea textArea;
    JScrollPane scrollPane;
    // top menu bar
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;
    // Files menu items
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
    // format menu items
    JMenuItem iWrap, iFontArial, iFontCSMS, iFontTMR, iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24,
            iFontSize28;
    JMenu menuFont, menuFontSize;
    // colors menu items
    JMenuItem iColor1, iColor2, iColor3;
    // Edit
    JMenuItem iUndo, iRedo;

    boolean wordWrapOn = false;

    FunctionFile file = new FunctionFile(this);
    FunctionFormat format = new FunctionFormat(this);
    FunctionsColor color = new FunctionsColor(this);
    FunctionEdit edit = new FunctionEdit(this);

    // undo and redo
    UndoManager um = new UndoManager();

    // constructor
    public Gui() {
        // calling all the methods
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createFormatMenu();
        createColorMenu();
        createEditMenu();

        // set default font and size
        format.selectedFont = "Arial";
        format.createFont(16);
        format.wordWrap();
        window.setVisible(true);
    }

    // define the createWindow method
    public void createWindow() {
        window = new JFrame("Note Pad Clone");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // define the text area method
    // which help us to write our text
    public void createTextArea() {
        textArea = new JTextArea();
        // undo and redo manager apply
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent e){
             um.addEdit(e.getEdit());
            }
        });
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(4, 12, 10, 0));
        window.add(scrollPane);
    }

    // create a method menubar
    // which creates the menu for our gui
    public void createMenuBar() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        // file
        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        // edit
        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        // format
        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        // color
        menuColor = new JMenu("Color");
        menuBar.add(menuColor);
    }

    // menu item method
    public void createFileMenu() {

        // new
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);

        // open
        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);

        // save
        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);

        // save as
        iSaveAs = new JMenuItem("Save as");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("Save as");
        menuFile.add(iSaveAs);

        // exit
        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);
    }

    // create a method for format menu
    public void createFormatMenu() {
        iWrap = new JMenuItem("Word Wrap: Off");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap");
        menuFormat.add(iWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        // FONT STYLE
        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(iFontCSMS);

        iFontTMR = new JMenuItem("Times New Roman");
        iFontTMR.addActionListener(this);
        iFontTMR.setActionCommand("Times New Roman");
        menuFont.add(iFontTMR);

        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("Size8");
        menuFontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("Size12");
        menuFontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("Size16");
        menuFontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("Size20");
        menuFontSize.add(iFontSize20);

        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("Size24");
        menuFontSize.add(iFontSize24);

        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("Size28");
        menuFontSize.add(iFontSize28);
    }

    public void createColorMenu() {
        iColor1 = new JMenuItem("White");
        iColor1.addActionListener(this);
        iColor1.setActionCommand("White");
        menuColor.add(iColor1);

        iColor2 = new JMenuItem("Black");
        iColor2.addActionListener(this);
        iColor2.setActionCommand("Black");
        menuColor.add(iColor2);

        iColor3 = new JMenuItem("Blue");
        iColor3.addActionListener(this);
        iColor3.setActionCommand("Blue");
        menuColor.add(iColor3);
    }

    public void createEditMenu() {
        iUndo = new JMenuItem("Undo");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        menuEdit.add(iUndo);

        iRedo = new JMenuItem("Redo");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        menuEdit.add(iRedo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "New":
                file.newFile();
                break;
            case "Open":
                file.newOpen();
                break;
            case "Save":
                file.save();
                break;
            case "Save as":
                file.SaveAs();
                break;
            case "Exit":
                file.exit();
                break;
            case "Word Wrap":
                format.wordWrap();
                break;
            case "Arial":
                format.setFont(command);
                break;
            case "Comic Sans MS":
                format.setFont(command);
                break;
            case "Times New Roman":
                format.setFont(command);
                break;
            case "Size8":
                format.createFont(8);
                break;
            case "Size12":
                format.createFont(12);
                break;
            case "Size16":
                format.createFont(16);
                break;
            case "Size20":
                format.createFont(20);
                break;
            case "Size24":
                format.createFont(24);
                break;
            case "Size28":
                format.createFont(28);
                break;
            case "White":
                color.changeColor(command);
                break;
            case "Black":
                color.changeColor(command);
                break;
            case "Blue":
                color.changeColor(command);
                break;
            case "Undo":
                edit.Undo();
                break;
            case "Redo":
                edit.Redo();
                break;
        }
    }
}
