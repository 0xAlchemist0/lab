package assignments.command_pattern;

import java.util.Scanner;

public class TextEditor {
    public static void main(String[] args) {
        String initialText =
            "Hello! Welcome to my text editor program!\n" +
            "We are going to learn about copying, cutting, and pasting.\n" +
            "Are you ready to get started?\n" +
            "We will only be interacting with the first instance of any text!\n" +
            "Let's practice on this greeting!\n";

        TextEditorReceiver editor = new TextEditorReceiver(initialText);
        CommandInvoker invoker = new CommandInvoker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            editor.printState();
            System.out.print("\nChoose a command: copy / cut / paste / undo / redo / exit\n> ");
            String cmd = scanner.nextLine().trim().toLowerCase();

            switch (cmd) {
                case "copy":
                    System.out.print("Enter the word to copy: ");
                    String copyWord = scanner.nextLine();
                    invoker.executeCommand(new CopyCommand(editor, copyWord));
                    break;
                case "cut":
                    System.out.print("Enter the word to cut: ");
                    String cutWord = scanner.nextLine();
                    invoker.executeCommand(new CutCommand(editor, cutWord));
                    break;
                case "paste":
                    invoker.executeCommand(new PasteCommand(editor));
                    break;
                case "undo":
                    invoker.undo();
                    break;
                case "redo":
                    invoker.redo();
                    break;
                case "exit":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Unknown command! Try again.");
            }
        }
    }
}
