package com.generating.xml.fl.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.util.List;

public class ActionFile {

    private static Logger logger = LogManager.getLogger(ActionFile.class);

    public void writeFileTextByName(String nameFile, List<String> contenido){
        logger.debug("entering method writeFileTextByName");
        logger.debug("param: "+ nameFile);
        logger.debug("param: "+ contenido);
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(nameFile, "UTF-8");
            for (String str: contenido) {
                writer.println(contenido);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            logger.debug("error exception "+ e.getMessage());
            e.printStackTrace();
        }finally{
            writer.close();
        }
        logger.debug("exiting method writeFileTextByName");
    }

    public void writeFileTextByName(String nameFile, String contenido){
        logger.debug("entering method writeFileTextByName");
        logger.debug("param: "+ nameFile);
        logger.debug("param: "+ contenido);
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(nameFile, "UTF-8");
            writer.println(contenido);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            logger.debug("error exception "+ e.getMessage());
            e.printStackTrace();
        }finally{
            writer.close();
        }
        logger.debug("exiting method writeFileTextByName");
    }

    public void writeFileBinaryByName(String nameFile, String contenido){
        logger.debug("entering method writeFileBinaryByName");
        logger.debug("param: "+ nameFile);
        logger.debug("param: "+ contenido);
        byte data[] = contenido.getBytes();
        try {
            FileOutputStream out = new FileOutputStream(nameFile);
            out.write(data);
            out.close();
        } catch (IOException e) {
            logger.debug("error write binary file: "+ e.getMessage());
            e.printStackTrace();
        }
        logger.debug("exiting method writeFileBinaryByName");
    }

    public void writeFileBinaryByName(String nameFile, Object contenido){
        logger.debug("entering method writeFileBinaryByName");
        logger.debug("param: "+ nameFile);
        logger.debug("param: "+ contenido);
        try {
            FileOutputStream fileOut = new FileOutputStream(nameFile);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(contenido);
            objectOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.debug("exiting method writeFileBinaryByName");
    }


}
