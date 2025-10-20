package write_examples;

import java.io.File;
import java.io.IOException;

public class FileClassTest {
    public static void main(String[] args) throws IOException {
        File inFile = new File( "src/write_examples/numbers.txt" );
        System.out.println("    Does it exist? " + inFile.exists());
        System.out.println("   Can it be read? " + inFile.canRead());
        System.out.println("Can it be written? " + inFile.canWrite());
        System.out.println("Is it a directory? " + inFile.isDirectory());
        System.out.println("     Is it a file? " + inFile.isFile());
        System.out.println("     Is it hidden? " + inFile.isHidden());
        System.out.println("  Number of bytes: " + inFile.length() + " bytes");
        System.out.println("    Absolute path: " + inFile.getAbsolutePath());
        System.out.println("             Path: " + inFile.getPath());
        System.out.println("           Parent: " + inFile.getParent());
        System.out.println("    Last modified: " + new java.util.Date(inFile.lastModified()));

        // Derive the absolute path without the file name.
        String absPath = inFile.getAbsolutePath();
        int posEndPath = absPath.lastIndexOf(File.separator);
        String filePath = absPath.substring(0,posEndPath+1);
        System.out.println("Abs path (derived): " + filePath);
    }
}