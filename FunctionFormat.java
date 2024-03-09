import java.awt.Font;

public class FunctionFormat {
    Gui gui;
    Font arial, comicSanaWs, timesNewRoman;
    String selectedFont;

    public FunctionFormat(Gui gui) {
        this.gui = gui;
    }

    // word wrap method
    public void wordWrap() {
        if (gui.wordWrapOn == false) {
            gui.wordWrapOn = true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.iWrap.setText("Word Wrap: On");
        } else {
            gui.wordWrapOn = false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.iWrap.setText("Word Wrap: Off");
        }
    }

    // font type
    public void createFont(int fontSize) {
        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSanaWs = new Font("Comic Sans MS", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);

        setFont(selectedFont);
    }

    // set font method
    public void setFont(String font) {
        selectedFont = font;
        switch (selectedFont) {
            case "Arial":
                gui.textArea.setFont(arial);
                break;
            case "Comic Sans MS":
                gui.textArea.setFont(comicSanaWs);
                break;
            case "Times New Roman":
                gui.textArea.setFont(timesNewRoman);
                break;
        }
    }
}
