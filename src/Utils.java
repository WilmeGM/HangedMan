public class Utils {
    public static void ClearConsole() throws Exception {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public static void ShowCharArray(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public static void HideCharArray (char[] arr) {
        for (int i = 0; i < arr.length; i++) { // hiding the word
            arr[i] = '_';
        }
    }
}