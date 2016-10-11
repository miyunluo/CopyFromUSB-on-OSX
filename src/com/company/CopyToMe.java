package com.company;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Created by miyunluo on 16/10/11.
 */
public class CopyToMe {
    /*Localpath 保存本地文件存放路径*/
    private static String LocalPath = "/Users/miyunluo/Desktop/USB";
    File file = null;
    public CopyToMe(File f){this.file = f;}

    public void foo()
    {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try{
            File fPath = new File(LocalPath);
            if (!fPath.exists()) {fPath.mkdirs();}
            in = new BufferedInputStream(new FileInputStream(file));
            out = new BufferedOutputStream(new FileOutputStream(new File(fPath, file.getName())));

            byte[] buff = new byte[1024];
            int len = 0;
            while((len = in.read(buff)) != -1){
                out.write(buff,0,len);
                out.flush();
            }
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
        finally {
            try {if (in != null) in.close();}
            catch (IOException e) {e.printStackTrace();}

            try {if (out != null) out.close();}
            catch (IOException e) {e.printStackTrace();}
        }
    }
}
