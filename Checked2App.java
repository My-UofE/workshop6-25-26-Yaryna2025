import java.io.*;

/**
 * Checked2App demonstrates handling of checked exceptions in Java.
 *
 * QA Notes:
 * Are both throws declarations needed?
 *    No, only 'throws IOException' is required because FileNotFoundException is a subclass of IOException.
 * What happens if you reverse the catch blocks (IOException first)?
 *    Compiler error: "exception FileNotFoundException has already been caught".
 *    Must catch specific (subclass) exceptions first, then general ones.
 * Why catch separate exception classes?
 *    Allows handling different exceptions differently.
 *    catch(Exception e) is too general and may unintentionally catch unrelated exceptions.
 */

public class Checked2App {

    public static void main(String[] args) {

        System.out.println("### Enter main() ...");

        if (args.length == 0) {
            System.out.println("No filename provided.");
            return;
        }

        String fileName = args[0];

        try {
            readTxtFile(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("### FileNotFoundException caught");
            System.out.println("### message: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("### IOException caught");
            System.out.println("### message: " + e.getMessage());
        }

        System.out.println("### Exit main()!");
    }

    public static void readTxtFile(String fileName)
            throws FileNotFoundException, IOException {

        System.out.println("### Enter readTxtFile() ...");

        BufferedReader bufferedReader =
                new BufferedReader(new FileReader(fileName));

        String line;

        line = String.format("Contents of '%s'", fileName);

        while (line != null) {
            System.out.println(line);
            line = bufferedReader.readLine();
        }

        bufferedReader.close();

        System.out.println("### Exit readTxtFile()!");
    }
}