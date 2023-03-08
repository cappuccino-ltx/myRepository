package javase.test.Exception;

public class UserService {
    //用户服务类

    /**
     * 用户登记类（注册）
     * @param user 账号
     * @param password 密码
     */
    public static void register(String user, String password) throws CharacterLengthException {
        if (user == null || password == null)
            throw new CharacterLengthException("不合法的输入！");
        if (user.length() < 6 || user.length() > 14) {
            throw new CharacterLengthException("账号不合法！");
        }
        if (password.length() < 6 || password.length() > 14){
            throw new CharacterLengthException("密码长不合法！");
        }
        System.out.println("注册成功！欢迎" + user + "!!");
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
