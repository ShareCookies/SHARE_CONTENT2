package com.rongji.egov.pdfutil;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @autor hecaigui
 * @date 2020-5-21
 * @description
 */
public class ImgUtil {
    public static void main(final String[] args) {
        try {
            for (File file : ImgUtil.traverseFolder("C:\\Users\\Administrator\\Desktop\\imagecompressor (3)")){
                Thumbnails.of(file).scale(0.25f)
                        .outputQuality(1f)
                        .toFile(file);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
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
}
