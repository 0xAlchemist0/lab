package assignments.command_pattern;

public class CutCommand implements Command {
    private TextEditorReceiver editor;
    private String word;
    private int index = -1;

    public CutCommand(TextEditorReceiver editor, String word) {
        this.editor = editor;
        this.word = word;
    }

    @Override
    public void execute() {
        index = editor.getText().indexOf(word);
        if (index != -1) {
            editor.cut(word);
        } else {
            System.out.println("Word not found to cut.");
        }
    }

    @Override
    public void undo() {
        if (index != -1) {
            editor.insertAt(index, word);
            System.out.println("Undo cut: \"" + word + "\" reinserted.");
        }
    }
}
