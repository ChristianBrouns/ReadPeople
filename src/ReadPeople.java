import sun.misc.Sort;

import java.io.*;
import java.util.Scanner;



/**
 * Created by Christian on 27-2-2016.
 */
public class ReadPeople{
    public static void main(String[] args)throws IOException {

        BufferedReader inputStream = null;


        PrintWriter outputStream = null;

        Scanner scan = null;
        Scanner scan2 = null;

        try {
            inputStream = new BufferedReader(new FileReader("Kubla"));


            outputStream = new PrintWriter(new FileWriter("KublaOut"));

            scan = new Scanner (new BufferedReader(new FileReader("Kubla")));
            scan2 = new Scanner (new FileReader("People"));
            scan.useDelimiter(",");

            String line;
            while ((line = inputStream.readLine()) != null)
                outputStream.println(line);

            //while (scan.hasNext()){
            //    System.out.println(scan.next());

            while (scan2.hasNext()) {
                scan2.useDelimiter(",");
                System.out.println(scan2.next());
            }


        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            if (scan != null){
                scan.close();
            }
            if (scan2 != null) {
                scan2.close();
            }
        }

    }
}
    /*  catch(FileNotFoundException f){
            System.out.println("No such file" + f);
        }

    catch(IOException e) {
        System.out.println("IO Exception" + e);
        }
    }
}
    */