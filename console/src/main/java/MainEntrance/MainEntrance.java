package MainEntrance;

import com.ctrip.access.SysConfigAccess;
import com.ctrip.access.UserAccess;
import com.ctrip.pojo.SysConfig;
import com.ctrip.pojo.User;

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

        System.out.println(String.format("%s\t$%s\t%s\t%s", user.getId(), user.getUserName(),
                user.getUserAge(), user.getUserAddress()));

        List<User> users = userAccess.getUsers("%");

        for(User user1 : users){
            System.out.println(String.format("%s\t$%s\t%s\t%s", user1.getId(), user1.getUserName(),
                    user1.getUserAge(), user1.getUserAddress()));
        }

        //UpdateUser
        user.setUserName("胡江涛");
        userAccess.updateUser(user);

        //DeleteUser
        userAccess.deleteUserById(4);
        userAccess.deleteUserByUserName("harry");

        userAccess.close();
    }
}