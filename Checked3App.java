import java.io.*;

/**
 * Checked3App demonstrates handling of checked exceptions entirely within the readTxtFile() method.
 *
 * QA Notes:
 * When the readTxtFile() method handles the exceptions internally:
 * - No throws declaration is needed for readTxtFile().
 * - main() does not need to declare or handle any exceptions.
 * - This is because all potential exceptions (FileNotFoundException, IOException) are caught inside the method.
 */

public class Checked3App {

    public static void main(String[] args) {

        System.out.println("### Enter main() ...");

        if (args.length == 0) {
            System.out.println("No filename provided.");
            return;
        }

        String fileName = args[0];

        readTxtFile(fileName);

        System.out.println("### Exit main()!");
    }

    public static void readTxtFile(String fileName) {

        System.out.println("### Enter readTxtFile() ...");

        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(fileName));

            String line = String.format("Contents of '%s'", fileName);

            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }

            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("### FileNotFoundException caught in readTxtFile()");
            System.out.println("### message: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("### IOException caught in readTxtFile()");
            System.out.println("### message: " + e.getMessage());
        }

        System.out.println("### Exit readTxtFile()!");
    }
}