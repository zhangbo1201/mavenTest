package cn.edu.hhit.service.AdapterPattern;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/8/2423:45
 */
public class Client {
    public static void main(String[] args) {
        //没有与外系统连接的时候， 是这样写的
        IUserInfo youngGirl = new UserInfo();
        //从数据库中查到101个
        for(int i=0;i<101;i++){
            youngGirl.getMobileNumber();
        }
        //
        IUserInfo outUser = new OuterUserInfo();
        for (int i = 0; i < 100; i++) {
            outUser.getMobileNumber();

        }
    }
}
