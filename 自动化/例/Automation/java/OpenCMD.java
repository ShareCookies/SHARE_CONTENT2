import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @autor hecaigui
 * @date 2020-1-19
 * @description
 */
public class OpenCMD {
    public void tryOpenCmd() {
        try {
            Process process = Runtime.getRuntime().exec("cmd.exe");
            OutputStream outputStream = process.getOutputStream();
            final InputStream inputStream = process.getInputStream();
            new Thread(new Runnable() {
                byte[] cache = new byte[1024];

                @Override
                public void run() {
                    System.out.println("listener started");
                    try {
                        while (inputStream.read(cache) != -1) {

                            System.out.println(new String(cache));
                        }
                    } catch (IOException e) {
                        //e.printStackTrace();
                    }
                }
            }).start();
            outputStream.write(new byte[]{'d', 'i', 'r', '\n'});
            //inputStream.
            int i = process.waitFor();
            System.out.println("i=" + i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        OpenCMD test = new OpenCMD();
        test.tryOpenCmd();
    }
}
