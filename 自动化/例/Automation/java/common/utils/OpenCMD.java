package common.utils;

import java.io.*;

/**
 * @autor hecaigui
 * @date 2020-1-19
 * @description
 */
public class OpenCMD {
    private   Process process ;
    private   PrintWriter writeIntoCmdWriter;

    public OpenCMD(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                startCmd();
            }
        }).start();

    }
    public void startCmd() {
        try {
            //Process process = Runtime.getRuntime().exec("cmd.exe /c ipconfig /all");
            process = Runtime.getRuntime().exec("cmd.exe");
            OutputStream outputStream = process.getOutputStream();
            final InputStream inputStream = process.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,"gbk"));//使用gbk编码解决输出乱码问题
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("打开了cmd，并监听cmd界面信息");
                    StringBuffer stringBuffer=new StringBuffer();
                    String line=null;
                    try {
                        while ((line = br.readLine())!=null) {
                            System.out.println(line);
                            stringBuffer.append(line+"\n");
                        }
                        System.out.println(stringBuffer.toString());
                        System.out.println("监听结束");
                    } catch (IOException e) {
                        System.err.println("命令结果读取失败");
                        e.printStackTrace();
                    }
                }
            }).start();
            //outputStream.write(new byte[]{'d', 'i', 'r', '\n'});
            //写入命令案例
            writeIntoCmdWriter = new PrintWriter(outputStream);
//            String cmd ; //你的cmd命令
//            out.println("dir \n"); //输入你的命令
//            out.flush(); //写到控制台
            int i = process.waitFor();
            System.out.println("cmd已经关了");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void closeCmd() {
        this.process.destroyForcibly();
        //todo：线程怎么结束了
    }
    /**
     * @description
     * @param  cmdCommand cmd命令
     * @return
     */

    public void writeIntoCmd(String cmdCommand){
        while (writeIntoCmdWriter == null){
            ThreadUtils.sleep(1000);
        }
        //输入你的命令
        writeIntoCmdWriter.println(cmdCommand+" \n");
        //写到控制台
        writeIntoCmdWriter.flush();
    }
    public static void main(String[] args) {
//        OpenCMD test = new OpenCMD();
//        test.startCmd();
        int seeVedioNum = 300/15;
        System.out.println(seeVedioNum);
    }
}
