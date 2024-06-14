public class DesignATextEditor_Q2296 {
    private StringBuilder writeUp;
    private int cursorPos;

    public DesignATextEditor_Q2296() {
        writeUp = new StringBuilder();
        cursorPos = 0;
    }

    public void addText(String text) {
        writeUp.insert(cursorPos, text);
        cursorPos += text.length();
    }

    public int deleteText(int k) {
        int charsToDelete = Math.min(k, cursorPos);
        writeUp.delete(cursorPos - charsToDelete, cursorPos);
        cursorPos -= charsToDelete;
        return charsToDelete;
    }

    public String cursorLeft(int k) {
        cursorPos = Math.max(0, cursorPos - k);
        int start = Math.max(0, cursorPos - 10);
        return writeUp.substring(start, cursorPos);
    }

    public String cursorRight(int k) {
        cursorPos = Math.min(writeUp.length(), cursorPos + k);
        int start = Math.max(0, cursorPos - 10);
        return writeUp.substring(start, cursorPos);
    }

    public static void main(String[] args) {
        DesignATextEditor_Q2296 editor = new DesignATextEditor_Q2296();

        // Test case 1: Add text and move cursor right
        editor.addText("hello");
        System.out.println("Test 1: " + ("hello".equals(editor.cursorRight(0)) ? "Passed" : "Failed"));

        // Test case 2: Delete text and check cursor position
        editor.addText("world");
        int deleted = editor.deleteText(3);
        System.out.println("Test 2: " + (deleted == 3 && "hellowo".equals(editor.cursorRight(0)) ? "Passed" : "Failed"));

        // Test case 3: Move cursor left and check the output
        String left = editor.cursorLeft(2);
        System.out.println("Test 3: " + ("hello".equals(left) ? "Passed" : "Failed"));

        // Test case 4: Move cursor right and check the output
        String right = editor.cursorRight(1);
        System.out.println("Test 4: " + ("hellow".equals(right) ? "Passed" : "Failed"));
    }
}
