package basicannotationdemo;

import java.io.File;

public class FileCheck {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");

        System.out.println(path);

        String path1 = System.getProperty("user.home")+"/Downloads/";
        System.out.println(path1);
        File folder = new File(path1);
        File[] filesdata = folder.listFiles();
        for(File file : filesdata){
            if(file.getName().endsWith(".zip")) {
                System.out.println(file.getName());
            }
        }
    }
}
