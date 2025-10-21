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
        if (pastedText == null || pastedText.isEmpty()) {
            System.out.println("Clipboard empty, nothing pasted.");
            pastedText = "";
            return;
        }
        editor.paste();
    }

    @Override
    public void undo() {
        if (!pastedText.isEmpty()) {
            editor.undoPaste(pastedText.length());
            System.out.println("Undo paste: removed \"" + pastedText + "\"");
        } else {
            System.out.println("Nothing to undo for paste.");
        }
    }
}
