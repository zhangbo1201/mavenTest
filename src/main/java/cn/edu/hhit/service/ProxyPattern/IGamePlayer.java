package cn.edu.hhit.service.ProxyPattern;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${代理接口}
 * @date 2018/8/2117:31
 */
public interface IGamePlayer {
    // 登录游戏
    public void login(String user, String password);

    // 杀怪， 网络游戏的主要特色
    public void killBoss();

    // 升级
    public void upgrade();
}
