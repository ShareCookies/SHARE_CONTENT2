
import com.aspose.words.Document;
import com.aspose.words.License;

import java.io.*;

/**
 * @autor hecaigui
 * @date 2020-4-1
 * @description
 */
public class TransferToPdf {
    private static boolean getLicense() {
        boolean result = false;
        try {
            //InputStream is = TransferToPdf.class.getClassLoader().getResourceAsStream("license.xml"); // license.xml应放在..\WebRoot\WEB-INF\classes路径下
            String currentUserWorkingPath = System.getProperty("user.dir");
            String resourcePath = currentUserWorkingPath + "\\urger-business\\src\\main\\resources\\AsposeWordsLicense.xml";
            System.out.println(resourcePath);
            File file = new File(resourcePath);

            License aposeLic = new License();
            aposeLic.setLicense(new FileInputStream(file));
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * @param wordPath 需要被转换的word全路径带文件名
     * @param pdfPath 转换之后pdf的全路径带文件名
     */
    public static void doc2pdfFile(String wordPath, String pdfPath) {
        if (!getLicense()) { // 验证License 若不验证则转化出的pdf文档会有水印产生
            return;
        }
        try {
            long old = System.currentTimeMillis();
            File file = new File(pdfPath); //新建一个pdf文档
            FileOutputStream os = new FileOutputStream(file);
            Document doc = new Document(wordPath); //Address是将要被转化的word文档
            doc.save(os, com.aspose.words.SaveFormat.PDF);//全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
            long now = System.currentTimeMillis();
            os.close();
            System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒"); //转化用时
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static byte[] doc2pdfByte(InputStream wordInputStream) {
        if (!getLicense()) {
            return null;
        }
        try {
            long old = System.currentTimeMillis();
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            Document doc = new Document(wordInputStream); //Address是将要被转化的word文档
            doc.save(os, com.aspose.words.SaveFormat.PDF);//全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
            long now = System.currentTimeMillis();
            os.close();
            System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒"); //转化用时
            return os.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
//        String currentUserWorkingPath = System.getProperty("user.dir");
//        String resourcePath = currentUserWorkingPath + "\\src\\main\\resources\\AsposeWordsLicense.xml";
//        System.out.println(resourcePath);
//        new File("resourcePath");

        //word 和excel 转为pdf
        String filePaths="F:/自动新增常用联系人接口文档.doc";
        String fileName="zsqexcel78";
        String pdfPath="F:/"+fileName+".pdf";
        doc2pdfFile(filePaths, pdfPath);//filePaths需要转换的文件位置 pdfPath为存储位置
    }
}
