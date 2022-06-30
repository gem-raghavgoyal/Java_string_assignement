package com.raghav.fileOperations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.function.Predicate;
import java.util.logging.Logger;

public class FileOperations {
    static Logger logger =  Logger.getLogger(FileOperations.class.getName());

    public static String inputFileRead(String path){
        System.out.println("Input file- " + path);
        try{
            return Files.readString(Path.of(path));
        }catch (IOException e){
            logger.severe("Exception occurred while reading " + path + " file " + e.getMessage());
        }
        return null;
    }


    public static String processData(String path){
        Predicate<String> includeZero = s -> getIntegerFromString(s.strip()) == null || getIntegerFromString(s.strip()) == 0;

        StringBuilder contentBuilder = new StringBuilder();

        inputFileRead(path).lines().filter(Predicate.not(includeZero))
                .map(s -> getIntegerFromString(s.strip()))
                .forEach(value -> contentBuilder.append(value+5).append("\n"));

        return contentBuilder.toString();
    }

    public static Integer getIntegerFromString(String s){
        try{
            return Integer.parseInt(s);
        }catch (Exception e){
            logger.severe("Exception occurred while parsing string value to integer - " + e.getMessage());
        }
        return null;
    }

    public static void outputIntoFile(String path, String data)throws IOException{
        System.out.println("Writing data into  output file- " + path);
        Files.writeString(Path.of(path),data, StandardOpenOption.APPEND);
    }
}
