package com.company;

import java.io.File;
/**
 * Created by miyunluo on 16/10/11.
 */
public class CheckUSB extends Thread{
    private File Volumes = new File("/Volumes");/*OSX所有盘都在Volumes文件夹下*/
    private File[] SysVolumesList = Volumes.listFiles();

    public void run(){
        File[] currentVolumesList = null;
        for(;;)
        {
            currentVolumesList = Volumes.listFiles();
            if(currentVolumesList.length > SysVolumesList.length)
            {
                for(int i = currentVolumesList.length-1;i>=0;--i)
                {
                    boolean FindNewDevice = true;
                    for(int j = SysVolumesList.length-1;j>=0;--j)
                        if(currentVolumesList[i].equals(SysVolumesList[j])) FindNewDevice = false;
                    if(FindNewDevice) {
                        System.out.println("Find an USB device");
                        System.out.println(currentVolumesList[i]);
                        new Copy(currentVolumesList[i]).start();
                    }
                }
            }
            SysVolumesList = Volumes.listFiles();

            try{Thread.sleep(1000);} /*检测时间间隙*/
            catch(InterruptedException e){e.printStackTrace();}
        }
    }
}
