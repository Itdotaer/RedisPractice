package MainEntrance;

import com.itdotaer.access.dataaccess.SysConfigAccess;
import com.itdotaer.access.dataaccess._UserAccess;
import com.itdotaer.access.pojo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

class MainEntrance{
    public static  void main(String[] args){
        //SysConfig
        System.out.println("-----SysConfig-----");
        SysConfigAccess sysConfigAccess = new SysConfigAccess();
        List<SysConfig> sysConfigs = sysConfigAccess.select("");

        for(SysConfig sysConfig : sysConfigs){
            String rs = String.format("%s\t%s\t%s\t%s", sysConfig.getVariable(), sysConfig.getValue(),
                    sysConfig.getSetTime(), sysConfig.getSetBy());
            System.out.println(rs);
        }

        sysConfigAccess.close();

        //User
        System.out.println("-----User-----");
        _UserAccess userAccess = new _UserAccess();

        //AddUser
        _User addUser = new _User();
        addUser.setUserName("harry");
        addUser.setUserAge("26");
        addUser.setUserAddress("SOHO");

        userAccess.addUser(addUser);

        _User user = userAccess.getUserById(1);

        System.out.println(String.format("%s\t$%s\t%s\t%s\t$s", user.getId(), user.getUserName(),
                user.getUserAge(), user.getUserAddress(), user.getPhoneNumber().toString()));

        List<_User> users = userAccess.getUsers("%");

        for(_User user1 : users){
            System.out.println(String.format("%s\t$%s\t%s\t%s\t%s", user1.getId(), user1.getUserName(),
                    user1.getUserAge(), user1.getUserAddress(), user1.getPhoneNumber().toString()));
        }

        //UpdateUser
        user.setUserName("胡江涛");
        userAccess.updateUser(user);

        //DeleteUser
        userAccess.deleteUserById(4);
        userAccess.deleteUserByUserName("harry");

        //一对一查询
        List<Article> articles = userAccess.getUserArticles(1);
        for(Article article:articles){
            System.out.println(article.getTitle()+":"+article.getContent()+
                    ":作者是:"+article.getUser().getUserName()+":地址:"+
                    article.getUser().getUserAddress()+":电话:"+article.getUser().getPhoneNumber().toString());
        }

        //一对多查询
        UserArticles userArticles = userAccess.getUserArticlesBySelect(1);

        if(userArticles != null){
            _User _user = userArticles.getUser();
            for(OneArticle article:userArticles.getArticles()){
                System.out.println(article.getTitle()+":"+article.getContent()+
                        ":作者是:"+_user.getUserName()+":地址:"+
                        _user.getUserAddress()+":电话:"+_user.getPhoneNumber().toString());
            }
        }

        userAccess.close();

        Logger logger = LoggerFactory.getLogger(MainEntrance.class);
        logger.info("slf4j: Hello World");
    }
}