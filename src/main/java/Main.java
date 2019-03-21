import dao.KeysDao;
import entity.Keys;
import entity.Words;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        ApplicationContext context =
                new ClassPathXmlApplicationContext("Spring.xml");
        KeysDao keysDao = context.getBean(KeysDao.class);
        Words words2 = new Words();
        Keys keys2 = new Keys();
        words2.setKey(keys2);
        words2.setWord("apple2");
        keys2.setWords(Collections.singletonList(words2));
        keys2.setKey("vlad");
        //Keys keys = new Keys("vlajkjkvghghdosng", words2);
        keysDao.save(keys2);
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


