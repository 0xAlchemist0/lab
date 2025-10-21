package assignments.command_pattern;

public class PasteCommand implements Command {
    private TextEditorReceiver editor;
    private String pastedText = "";

    public PasteCommand(TextEditorReceiver editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        pastedText = editor.getClipboard();
        editor.paste();
    }

    @Override
    public void undo() {
        if (!pastedText.isEmpty()) {
            editor.undoPaste(pastedText.length());
        }
    }
}
