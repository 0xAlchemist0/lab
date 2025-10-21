package assignments.command_pattern;

public class CutCommand implements Command {
    private TextEditorReceiver editor;
    private String word;
    private int index = -1;
    private String cutText = "";

    public CutCommand(TextEditorReceiver editor, String word) {
        this.editor = editor;
        this.word = word;
    }

    @Override
    public void execute() {
        index = editor.getText().indexOf(word);
        if (index != -1) {
            // perform cut (receiver will set clipboard)
            editor.cut(word);
            cutText = editor.getClipboard();
        } else {
            System.out.println("Word not found to cut!");
        }
    }

    @Override
    public void undo() {
        if (index != -1 && !cutText.isEmpty()) {
            editor.getBuffer().insert(index, cutText);
            System.out.println("Undo cut: restored \"" + cutText + "\" at index " + index);
        } else {
            System.out.println("Nothing to undo for cut.");
        }
    }
}
