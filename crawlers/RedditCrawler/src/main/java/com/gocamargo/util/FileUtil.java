package com.gocamargo.util;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<String> readFile(String path, String fileName){
        try(CSVReader reader = new CSVReader(new FileReader(getFullPath(path, fileName)))){
            List<String> values;
            values = new ArrayList<>();
            String[] data, splitedData;
            while ((data = reader.readNext()) != null){
                splitedData = data[0].split(";");
                for (String content:splitedData) {
                    values.add(content);
                }
            }
            return values;
        }catch (Exception e){
            throw new RuntimeException("Não foi possível ler o arquivo.");
        }
    }

    private static String getFullPath(String path, String fileName){
        if(!path.endsWith("/"))
            path = path.concat("/");
        return path.concat(fileName);
    }
}
