package MainEntrance;

import com.itdoater.access.dataaccess.SysConfigAccess;
import com.itdoater.access.dataaccess.UserAccess;
import com.itdoater.access.pojo.Article;
import com.itdoater.access.pojo.SysConfig;
import com.itdoater.access.pojo.User;
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
        UserAccess userAccess = new UserAccess();

        //AddUser
        User addUser = new User();
        addUser.setUserName("harry");
        addUser.setUserAge("26");
        addUser.setUserAddress("SOHO");

        userAccess.addUser(addUser);

        User user = userAccess.getUserById(1);

        System.out.println(String.format("%s\t$%s\t%s\t%s\t$s", user.getId(), user.getUserName(),
                user.getUserAge(), user.getUserAddress(), user.getPhoneNumber().toString()));

        List<User> users = userAccess.getUsers("%");

        for(User user1 : users){
            System.out.println(String.format("%s\t$%s\t%s\t%s\t%s", user1.getId(), user1.getUserName(),
                    user1.getUserAge(), user1.getUserAddress(), user1.getPhoneNumber().toString()));
        }

        //UpdateUser
        user.setUserName("胡江涛");
        userAccess.updateUser(user);

        //DeleteUser
        userAccess.deleteUserById(4);
        userAccess.deleteUserByUserName("harry");

        List<Article> articles = userAccess.getUserArtices(1);
        for(Article article:articles){
            System.out.println(article.getTitle()+":"+article.getContent()+
                    ":作者是:"+article.getUser().getUserName()+":地址:"+
                    article.getUser().getUserAddress()+":电话:"+article.getUser().getPhoneNumber().toString());
        }

        userAccess.close();

        Logger logger = LoggerFactory.getLogger(MainEntrance.class);
        logger.info("slf4j: Hello World");
    }
}