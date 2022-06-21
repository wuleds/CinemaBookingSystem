import com.wule.dao.SelectDao;
import com.wule.pojo.User;
import com.wule.service.SelectService;
import com.wule.util.DatabaseLinkUtils;

import javax.xml.soap.Text;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

//创建于2022/6/21 13:16
public class text
{
    public void Test() throws SQLException {
        SelectService service = new SelectService();
        List<User> users = service.login("12","12");
        if(users == null)
            System.out.println("null");
        else
            System.out.println("hhh");

    }

    public static void main(String[] args) throws SQLException {
        text text = new text();
        text.Test();
    }

}
