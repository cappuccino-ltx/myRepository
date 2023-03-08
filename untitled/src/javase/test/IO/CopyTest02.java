package javase.test.IO;

import java.io.*;

public class CopyTest02 {
    public static void main(String[] args){
        File srcFile = new File("C:\\，李同学。\\学习笔记");//要复制的文件源
        File destFile = new File("D:\\");//要复制到的路径

        CopyDir(srcFile,destFile);
    }

    /**
     * 文件和目录的拷贝
     * @param srcFile 文件源
     * @param destFile 复制到路径
     */
    private static void CopyDir(File srcFile, File destFile) {
        //在递归的过程中，如果srcFile是文件的话，对其进行复制

        if (srcFile.isFile()){
            FileInputStream fis = null;
            FileOutputStream fos = null;
            try {
                fis = new FileInputStream(srcFile);
                fos = new FileOutputStream((destFile.getAbsolutePath().endsWith("\\") ?
                        destFile.getAbsolutePath() : destFile.getAbsolutePath() + "\\") +
                        srcFile.getAbsolutePath().substring(3));
                int readCount  = 0;
                byte[] bytes = new byte[1024 * 1024];
                while ((readCount = fis.read(bytes)) != -1) {
                    fos.write(bytes, 0, readCount);
                }
                fos.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                if (fis != null){
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fos != null){
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return;
        }


        //获取文件下的子目录
        File[] files = srcFile.listFiles();
        for(File file : files){
            //如果file是一个目录
            if (file.isDirectory()){
                //拿到源目录路径
                //System.out.println(file.getAbsolutePath());
                String srcDir = file.getAbsolutePath();
                //目标目录:
                String destDir = (destFile.getAbsolutePath().endsWith("\\")?destFile.getAbsolutePath()
                        : destFile.getAbsolutePath()+"\\") + srcDir.substring(3);
                File newFile = new File(destDir);
                //如果目录不存在的话，那新建目录
                if (!newFile.exists()){
                    newFile.mkdirs();
                }
            }

            //递归调用
            CopyDir(file,destFile);
        }
    }

}
