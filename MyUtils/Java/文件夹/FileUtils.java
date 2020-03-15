package utils;

import jdk.nashorn.internal.runtime.regexp.JdkRegExp;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * @autor hecaigui
 * @date 2020-3-9
 * @description
 */
public class FileUtils {
    /**
     * @description 读取文件夹下的所有文件
     * @param  * @param path
     * @return
     */
    public static List<File> traverseFolder(String path) {
        List<File> traverseFolderResults = new ArrayList<File>();
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                System.out.println("文件夹是空的!");
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        //System.out.println("文件夹:" + file2.getAbsolutePath());
                        traverseFolder(file2.getAbsolutePath());
                    } else {
                        traverseFolderResults.add(file2);
                        //System.out.println("文件:" + file2.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }

        return traverseFolderResults;
    }
    /**
     * @description 文件复制
     * @param  * @param path
     * @param  destFilePathName F:\autoGenerateMapper\test.txt
     * @return
     */
    public static void copyFileUsingFileStreams(File source, String destFilePathName) {
        File dest ;
        if (destFilePathName !=null && ! "".equals(destFilePathName)){
            dest =  new File(destFilePathName);
        } else{
            return;
        }
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];

            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } catch (IOException exception){
            System.err.println(exception);
        } finally {
            try {
                input.close();
                output.close();
            } catch (IOException exception){
                System.err.println(exception);
            }
        }
    }


    /**
     * @description 读取文本内容
     * @param  * @param file
     * @return
     */
    public static String readFileContent(File file) {
        StringBuilder content = new StringBuilder();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
             fileReader = new FileReader(file);
             bufferedReader = new BufferedReader(fileReader);
            String line =bufferedReader.readLine();
            while (line != null){
                //System.out.println(line);
                line = bufferedReader.readLine();
                if (line != null){
                    content.append(line+"\n");
                }
            }
        }catch (IOException exception){
            System.err.println(exception);
        }finally {
            try {
                fileReader.close();
                bufferedReader.close();
            } catch (IOException exception){
                System.err.println(exception);
            }
        }
        return content.toString();
    }

    /**
     * @description 往文本写入内容
     * @param  * @param file
     * @return
     */
    public static void writeToFile(File file,String content) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content);
            bufferedWriter.flush(); // 把缓存区内容压入文件
        }catch (IOException exception){
            System.err.println(exception);
        }finally {
            try {
                fileWriter.close();
                bufferedWriter.close();
            } catch (IOException exception){
                System.err.println(exception);
            }
        }
    }
//    /**
//     * @description 二进制流（来源要为字符）转字符串。
//     * @param  * @param args
//     * @return
//     */
//    public static String streamToString(InputStream inputStream)
//    {
//        //Original byte[]
//        byte[] bytes = "hello world".getBytes();
//
//        //Base64 Encoded
//        String encoded = Base64.getEncoder().encodeToString(bytes);
//
//        //Base64 Decoded
//        byte[] decoded = Base64.getDecoder().decode(encoded);
//
//        //Verify original content
//        System.out.println( new String(decoded) );
//    }

    public static void main(String[] args)
    {
        //Original byte[]
        byte[] bytes = "hello world".getBytes();

        //Base64 Encoded
        String encoded = Base64.getEncoder().encodeToString(bytes);

        //Base64 Decoded
        byte[] decoded = Base64.getDecoder().decode(encoded);

        //Verify original content
        //System.out.println( new String(decoded) );
    }

//    public static void readFileContent(File file) {
//        String content = "";
//        FileReader fileReader = null;
//        BufferedReader bufferedReader = null;
//        try {
//            fileReader = new FileReader(file);
//            bufferedReader = new BufferedReader(fileReader);
//            String line =bufferedReader.readLine();
//            while (line!=null){
//                System.out.println(line);
//                line = bufferedReader.readLine();
//            }
//        }catch (IOException exception){
//            System.err.println(exception);
//        }finally {
//            try {
//                fileReader.close();
//                bufferedReader.close();
//            } catch (IOException exception){
//                System.out.println(exception);
//            }
//        }
//    }
}
