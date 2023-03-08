package javase.test.IO;

import java.io.*;

public class CopyTest02 {
    public static void main(String[] args){
        File srcFile = new File("C:\\����ͬѧ��\\ѧϰ�ʼ�");//Ҫ���Ƶ��ļ�Դ
        File destFile = new File("D:\\");//Ҫ���Ƶ���·��

        CopyDir(srcFile,destFile);
    }

    /**
     * �ļ���Ŀ¼�Ŀ���
     * @param srcFile �ļ�Դ
     * @param destFile ���Ƶ�·��
     */
    private static void CopyDir(File srcFile, File destFile) {
        //�ڵݹ�Ĺ����У����srcFile���ļ��Ļ���������и���

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


        //��ȡ�ļ��µ���Ŀ¼
        File[] files = srcFile.listFiles();
        for(File file : files){
            //���file��һ��Ŀ¼
            if (file.isDirectory()){
                //�õ�ԴĿ¼·��
                //System.out.println(file.getAbsolutePath());
                String srcDir = file.getAbsolutePath();
                //Ŀ��Ŀ¼:
                String destDir = (destFile.getAbsolutePath().endsWith("\\")?destFile.getAbsolutePath()
                        : destFile.getAbsolutePath()+"\\") + srcDir.substring(3);
                File newFile = new File(destDir);
                //���Ŀ¼�����ڵĻ������½�Ŀ¼
                if (!newFile.exists()){
                    newFile.mkdirs();
                }
            }

            //�ݹ����
            CopyDir(file,destFile);
        }
    }

}
