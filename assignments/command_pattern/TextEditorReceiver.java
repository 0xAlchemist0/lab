package assignments.command_pattern;

public class TextEditorReceiver {
    private StringBuilder text;
    private String clipboard = "";

    public TextEditorReceiver(String initialText) {
        this.text = new StringBuilder(initialText);
    }

 public void copy(String word) {
    String normalizedText = text.toString();
    int index = normalizedText.indexOf(word);
    if (index != -1) {
        clipboard = normalizedText.substring(index, index + word.length());
        System.out.println("Copied: \"" + clipboard + "\"");
    } else {
        System.out.println("Word or phrase not found.");
    }
}

public void cut(String word) {
    String normalizedText = text.toString();
    int index = normalizedText.indexOf(word);
    if (index != -1) {
        clipboard = normalizedText.substring(index, index + word.length());
        text.delete(index, index + word.length());
        System.out.println("Cut: \"" + clipboard + "\"");
    } else {
        System.out.println("Word or phrase not found.");
    }
}

    public void paste() {
        if (!clipboard.isEmpty()) {
            text.append(" ").append(clipboard);
            System.out.println("Pasted: \"" + clipboard + "\"");
        } else {
            System.out.println("Clipboard is empty.");
        }
    }

    public void undoPaste(int length) {
        if (text.length() >= length) {
            text.delete(text.length() - length - 1, text.length());
            System.out.println("Undo paste.");
        }
    }

    public void insertAt(int index, String word) {
        if (index >= 0 && index <= text.length()) {
            text.insert(index, word);
        }
    }

    public String getClipboard() {
        return clipboard;
    }

    public String getText() {
        return text.toString();
    }

    public void printState() {
        System.out.println("\nCurrent Text:\n" + text);
        System.out.println("Clipboard: \"" + clipboard + "\"");
    }
}
