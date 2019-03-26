import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.Beans;
import vocabulary.ChangeOps;

public class Main {

    public static void main(String[] args) {





       /* Words words2 = new Words();
        Keys keys2 = new Keys();
        words2.setKey(keys2);
        words2.setWord("apple2");
        keys2.setWords(Collections.singletonList(words2));
        keys2.setKey("vlad3");
        keysDao.save(keys2);
        String s = keysDao.findByKey("vlad1").get(0).getKey();
        // System.out.println("Keys::" + keys);
        // List<Keys> list = keysDao.getKeysList();
        //  for (Keys p : list) {
        //       System.out.println("Keys List::" + p);
        //   }
        //  System.out.println(keysDao.findByKey("vita"));
         //keysDao.delete(new Keys());
        ((ClassPathXmlApplicationContext) context).close();
*/
        Beans beans = new Beans();
        ChangeOps changeOps = (ChangeOps) Beans.context.getBean("ChangeOps");
        try {
            changeOps.enterPoint();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        ((ClassPathXmlApplicationContext) Beans.context).close();

    }
}


