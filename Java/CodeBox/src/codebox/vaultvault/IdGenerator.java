package codebox.vaultvault;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IdGenerator {
    String[] digits = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X",
            "Y","Z","0","1","2","3","4","5","6","7","8","9"};
    int n = 19;
    String[] code = new String[19];
    String id;
    File f = new File("D:/Blackstar Industries/KODA Systems/Projects/CodeBox/IdFile.txt");

    public String getRandom(String[] digits) {
        int randomIndex = (int) (Math.random() * digits.length);
        return digits[randomIndex];
    }

    public void id16bitgenerator() {
        for (int x = 0; x < 10; x++) {
            for (int i = 0; i < 19; i++)
                code[i] = getRandom(digits);

            code[4] = " ";
            code[9] = " ";
            code[14] = " ";
            id = String.join("",code);



            // Check to see if ID is already used
            try {
                File idfile = new File("idFile.txt");
                Scanner scan = new Scanner(idfile);
                while (scan.hasNextLine()) {
                    if (scan.nextLine().equals(id))
                        id16bitgenerator();
                }
                scan.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            // Save id to new file
            try {
                if(f.exists() && !f.isDirectory()) {
                    FileWriter idFile = new FileWriter("IdFile.txt", true);
                    idFile.write(id + "\n");
                    idFile.close();
                } else {
                    FileWriter idFile = new FileWriter("IdFile.txt");
                    // Write new ID to file
                    idFile.write(id+ "\n");
                    idFile.close();
                }

                System.out.println(id);
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        System.out.println("Successfully wrote to the file.");
    }

    public void testIdGenerator() {
        for (int i = 0; i < 19; i++)
            code[i] = getRandom(digits);

        code[4] = " ";
        code[9] = " ";
        code[14] = " ";
        id = String.join("",code);



        // Check to see if ID is already used
        try {
            File idfile = new File("idFile.txt");
            Scanner scan = new Scanner(idfile);
            while (scan.hasNextLine()) {
                if (scan.nextLine().equals(id))
                    id16bitgenerator();
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // Save id to new file
        try {
            if(f.exists() && !f.isDirectory()) {
                FileWriter idFile = new FileWriter("IdFile.txt", true);
                idFile.write(id + "\n");
                idFile.close();
            } else {
                FileWriter idFile = new FileWriter("IdFile.txt");
                // Write new ID to file
                idFile.write(id+ "\n");
                idFile.close();
            }

            System.out.println(id);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("Successfully wrote to the file.");
    }

    public void test() {
        id = "2RPZ EG5X YB77 M8RU";

        try {
            File idfile = new File("idFile.txt");
            Scanner scan = new Scanner(idfile);
            while (scan.hasNextLine()) {
                if (scan.nextLine().equals(id)) {
                    System.out.println("Already exists");
                    testIdGenerator();
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}