package javase.test.reflect;

/**
 *
 * ��ȡһ���ļ��ľ���·��
 *
 *      ���ַ�����Ҫ��Ҫ��ȡ���ļ��ŵ���·���£�src���������Ļ��������Ժ��ļ���ô��ֲ��������Ҫ�Ĵ���
 *
 */
public class AboutPath {
    public static void main(String[] args){
        //��ȡһ����ľ���·�� ��ǰsrc·���µ�db.properties����ļ��ľ���·��

        String path = Thread.currentThread().getContextClassLoader()
                .getResource("javase/test/reflect/db.properties").getPath();
        System.out.println(path);
    }
}
