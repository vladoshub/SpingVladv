import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vocabulary.ChangeOps;
import vocabulary.Library;
import vocabulary.ServiceWorker;

public class Main {

    public static void main(String[] args) {
       ApplicationContext context =
                new ClassPathXmlApplicationContext("Spring.xml");
        ChangeOps changeOps = (ChangeOps) context.getBean("ChangeOps");
        try {
            changeOps.enterPoint();
        }
        catch (Exception e){
            System.out.println("Error");
        }

    }





    }


