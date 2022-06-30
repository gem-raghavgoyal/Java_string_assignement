package com.raghav.fileOperations;

import java.io.IOException;
import java.util.logging.Logger;
//This program is to perform various file operations
public class Main {
    static Logger logger =  Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        String inputFilePath = "src/input_file.txt";
        String outputFilePath = "src/output_file.txt";
        String data  = FileOperations.inputFileRead(inputFilePath);
        if(data != null){
            System.out.println(data);
        }

        /* Read file*/

        data = FileOperations.processData(inputFilePath);
        System.out.println("Printing data after processing each line");
        System.out.println(data);

        /* Writing processed data into result file from doc file */

        try{
            FileOperations.outputIntoFile(outputFilePath,data);
        }catch (IOException e){
            logger.severe("Exception occurred while write operation " + e.getMessage());
        }

        /* Reading output file */

        data = FileOperations.inputFileRead(outputFilePath);
        if(data != null){
            System.out.println(data);
        }
    }
}
