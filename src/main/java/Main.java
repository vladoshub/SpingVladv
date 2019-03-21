import dao.KeysDao;
import entity.Keys;
import entity.Words;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        ApplicationContext context =
                new ClassPathXmlApplicationContext("Spring.xml");
        KeysDao keysDao = context.getBean(KeysDao.class);
        ArrayList<Words> words = new ArrayList<Words>();
        words.add(new Words("владhgvghbvv"));
        Keys keys = new Keys("vlavghghdosng", words);
        keysDao.save(keys);
        // System.out.println("Keys::" + keys);
        // List<Keys> list = keysDao.getKeysList();
        //  for (Keys p : list) {
        //       System.out.println("Keys List::" + p);
        //   }
        //  System.out.println(keysDao.findByKey("vita"));
        // keysDao.delete(new Keys());
        ((ClassPathXmlApplicationContext) context).close();

       /* ChangeOps changeOps = (ChangeOps) context.getBean("ChangeOps");
        try {
            changeOps.enterPoint();
        }
        catch (Exception e){
            System.out.println("Error");
        }


    }
    */


    }
}


