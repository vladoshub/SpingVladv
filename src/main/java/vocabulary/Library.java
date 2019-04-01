package vocabulary;

import dao.KeysDao;
import dao.KeysDaoImpl;
import entity.Keys;
import entity.Words;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("Library")
public class Library {

    @Value("nameFile")
    private String nameFile;
    private String regexVocFirstLib;
    private String regexVocSecondLib;
    private KeysDao keysDao;

    /*public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }
*/
    // private Map<String, String> states = new HashMap<String, String>();//будем хранить тут наш словарь


    @Autowired
    public Library(InfoBase infoBase, SessionFactory ses) {
        this.nameFile = infoBase.getFileName();
        this.regexVocFirstLib = infoBase.getRegexVocFirstLib();
        this.regexVocSecondLib = infoBase.getRegexVocSecondLib();
        keysDao = new KeysDaoImpl(ses);
    }


 /*   public void readAllFromTxt() { //-	инициализировать мапу словарем
        String[] word;
        try (FileInputStream fstream = new FileInputStream(nameFile);) {
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (strLine.matches(regexVocFirstLib) || strLine.matches(regexVocSecondLib)) {
                    word = strLine.split("_");
                    states.put(word[0], word[1]);
                }
            }

        } catch (Exception e) {
            Console.outError(e);
        }


    }
    */

    public void printAll() { //-	чтение списка пар из файла
      /*  try {
            for (Map.Entry<String, String> pair : states.entrySet()) {
                Console.outConsole(pair.getKey(), pair.getValue());
            }
        } catch (Exception e) {
            Console.outError(e);
        }
        */
        for (Keys k : keysDao.getKeysList()) {
            for (Words w : k.getWords()) {
                System.out.println("key: " + k.getKey() + " - " + "word: " + w.getWord());
            }
        }
    }

    public void readFromTxt(String key) {//-	поиск записи по ключу
     /*   try {
            Console.outConsole(key, states.get(key));
        } catch (Exception e) {
            Console.outError(e);
        }
        */
        for (Words w : keysDao.getWordsByKey(key)) {
            System.out.println("key: " + key + " - " + "word: " + w.getWord());
        }


    }

    public void deleteFromTxt(String key) {//-	удаление записи по ключу
       /* for (Iterator<Map.Entry<String, String>> it = states.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, String> entry = it.next();
            if (entry.getKey().equals(key)) {
                it.remove();
            }
        }
        saveToTxt();
        */
        keysDao.deleteByKey(key);


    }

    public void addToTxt(String key, String value) {//--	добавление записей
        // states.put(key, value);
        //saveToTxt();
        keysDao.AddKey(key, value);
        //readAllFromTxt();
    }

  /*  public void saveToTxt() {//сохранить мапу в документ
        try (PrintWriter pw = new PrintWriter(nameFile)) {
            for (Map.Entry<String, String> entry : states.entrySet()) {
                pw.println(entry.getKey() + "_" + entry.getValue());
            }
        } catch (Exception e) {
            Console.outError(e);

        }


    }
    */

}