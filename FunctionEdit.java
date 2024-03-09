public class FunctionEdit {
    Gui gui;
    public FunctionEdit(Gui gui){
        this.gui=gui;
    }

    public void Undo(){
        gui.um.undo();
    }

    public void Redo(){
        gui.um.redo();
    }
}
