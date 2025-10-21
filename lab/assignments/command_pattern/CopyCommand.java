package assignments.command_pattern;

public class CopyCommand implements Command {
    private TextEditorReceiver editor;
    private String word;

    public CopyCommand(TextEditorReceiver editor, String word) {
        this.editor = editor;
        this.word = word;
    }

    @Override
    public void execute() {
        editor.copy(word);
    }

    @Override
    public void undo() {
        // nothing to undo for copy
    }
}
