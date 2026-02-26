// import java.io.*;

// public class Checked1App {

//     public static void main(String[] args) throws IOException {
//         System.out.println("### Enter main() ...");

//         String fileName = args[0];

//         readTxtFile(fileName);

//         System.out.println("### Exit main()!");
//     }

//     public static void readTxtFile(String fileName) throws IOException {
//         System.out.println("### Enter readTxtFile() ...");

//         BufferedReader bufferedReader =
//                 new BufferedReader(new FileReader(fileName));

//         String line;

//         line = String.format("Contents of '%s'", fileName);

//         while (line != null) {
//             System.out.println(line);
//             line = bufferedReader.readLine();
//         }

//         bufferedReader.close();

//         System.out.println("### Exit readTxtFile()!");
//     }
// }



import java.io.*;

public class Checked1App {

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

            String line;

            line = String.format("Contents of '%s'", fileName);

            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }

            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("IO error occurred.");
        }

        System.out.println("### Exit readTxtFile()!");
    }
}