import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FunctionFile {

    Gui gui;
    String fileName;
    String fileAddress;
    public Object newFile;

    public FunctionFile(Gui gui) {
        this.gui = gui;
    }

    // function to create a new text file
    public void newFile() {
        gui.textArea.setText(""); // erase the current text
        gui.window.setTitle("new"); // set the default name of the file
    }



    // function to open a existing file
    public void newOpen() {
        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        // logic to open files
        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            // System.out.println(fileName + fileAddress);
            gui.window.setTitle(fileName);
        }

        // for display the content of files
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
            gui.textArea.setText("");

            String line = null;

            while ((line = br.readLine()) != null) {
                gui.textArea.append(line + "\n");
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    // function to save
    public void save() {
        if (fileName == null) {
            SaveAs();
        } else {
            try {
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(gui.textArea.getText());
                gui.window.setTitle(fileName);
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    

    // function to save as
    public void SaveAs() {
        FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }

        try {
            FileWriter fw = new FileWriter(fileAddress + fileName);
            fw.write(gui.textArea.getText());
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    
    // function for crreate exit operation
    public void exit(){
        System.exit(0);
    }
}
