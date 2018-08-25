package cn.edu.hhit.service.ProxyPattern;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/8/2117:31
 */
public class GamePlayer_chenhao implements IGamePlayer{

    private String name = "";

    public GamePlayer_chenhao(String name){
        this.name = name;
    }
    @Override
    public void login(String user, String password) {
        System.out.println(user+"登陆了，密码为："+password);
    }

    @Override
    public void killBoss() {
        System.out.println(this.name+"正在杀boss");
    }

    @Override
    public void upgrade() {
        System.out.println(this.name+"升级了");
    }
}
