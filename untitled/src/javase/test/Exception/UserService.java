package javase.test.Exception;

public class UserService {
    //�û�������

    /**
     * �û��Ǽ��ࣨע�ᣩ
     * @param user �˺�
     * @param password ����
     */
    public static void register(String user, String password) throws CharacterLengthException {
        if (user == null || password == null)
            throw new CharacterLengthException("���Ϸ������룡");
        if (user.length() < 6 || user.length() > 14) {
            throw new CharacterLengthException("�˺Ų��Ϸ���");
        }
        if (password.length() < 6 || password.length() > 14){
            throw new CharacterLengthException("���볤���Ϸ���");
        }
        System.out.println("ע��ɹ�����ӭ" + user + "!!");
        /*String[][] usersql= new String[10][2];
        for (int i = 0; i < usersql.length; i++){
            if (usersql[i][0] == null){
                usersql[i][0] = user;
                usersql[i][1] = password;
                break;
            }
        }
        System.out.println(usersql[0][0]+"\n"+usersql[0][1]);*/

    }
}
