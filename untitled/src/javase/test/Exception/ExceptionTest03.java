package javase.test.Exception;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * try..catch ����һ�������finally
 *
 *      ��finally�Ӿ��еĴ��������ִ�еģ�������һ����ִ�еģ�
 *      ��ʹtry����еĴ���������쳣��һ���ǻ�ִ�У�
 */
public class ExceptionTest03 {

    public static void main(String[] rgs){
        FileInputStream fi = null;
        try {
            fi = new FileInputStream("E:\\����ͬѧ��\\linux\\Doc1(2).docx");
            //FIleInputStream()��������׳���һ���쳣����Ҫ����
            fi.read();//���ļ����ж�ȡ����׽IOException����쳣

            //����FIleInputStream()��һ��������Ҫ�ֶ��رգ���Ȼ�Ƿǳ��˷���Դ��
            //fi.close();
            //����Ϊ����ڶ�ȡ�ļ���ʱ��������쳣�����ʱ�����Ͳ�����ִ�е������ô����û�йرգ����Ƿǳ�Σ�յ�
            //���õ���finally���
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            /*
            finally����еĴ�����һ����ִ�еģ�
            ������try ����г������쳣�����´���û�б��رյ������Ϳ�����finally�����ȥ�ر�
             */
            if (fi != null) {
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
