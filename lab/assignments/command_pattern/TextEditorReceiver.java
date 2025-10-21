package assignments.command_pattern;

public class TextEditorReceiver {
    private StringBuffer buffer;
    private String clipboard = "";

    public TextEditorReceiver(String initialText) {
        this.buffer = new StringBuffer(initialText);
    }

    public void copy(String word) {
        int index = buffer.indexOf(word);
        if (index != -1) {
            clipboard = buffer.substring(index, index + word.length());
            System.out.println("Copied: \"" + clipboard + "\"");
        } else {
            System.out.println("Word not found to copy!");
        }
    }

    public void cut(String word) {
        int index = buffer.indexOf(word);
        if (index != -1) {
            clipboard = buffer.substring(index, index + word.length());
            buffer.delete(index, index + word.length());
            System.out.println("Cut: \"" + clipboard + "\"");
        } else {
            System.out.println("Word not found to cut!");
        }
    }

    public void paste() {
        if (clipboard.isEmpty()) {
            System.out.println("Clipboard is empty. Nothing to paste.");
            return;
        }
        buffer.append(" " + clipboard);
        System.out.println("Pasted: \"" + clipboard + "\"");
    }

    public void undoPaste(int length) {
        if (length > 0 && buffer.length() >= length + 1) {
            buffer.delete(buffer.length() - length - 1, buffer.length());
            System.out.println("Undo paste removed: \"" + (length > 0 ? buffer.substring(buffer.length()-length, buffer.length()) : "") + "\"");
        } else {
            System.out.println("Nothing to undo for paste.");
        }
    }

    public String getClipboard() { return clipboard; }
    public String getText() { return buffer.toString(); }
    public StringBuffer getBuffer() { return buffer; }

    public void printState() {
        System.out.println("\nCurrent Text:\n" + buffer.toString());
        System.out.println("Clipboard: \"" + clipboard + "\"");
    }
}
