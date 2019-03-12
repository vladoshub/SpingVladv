package vocabulary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.*;
@Component("ServiceWorker")
public class ServiceWorker {


@Autowired
   public ServiceWorker(InfoBase infoBase){
        this.firstVoc=infoBase.getRegexVocFirst();
        this.secondVoc=infoBase.getRegexVocSecond();
    }

   private String firstVoc;
   private String secondVoc;
  //  private char[] Latinsk = {'A', 'B', 'C', 'D', 'E', 'F', 'Z', 'H', 'I', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'V', 'X'};
   // private char[] Number = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    public void del(Library Library) throws IOException{//метод для работы с методом удаление клаасс аLibrary
        System.out.println("введите ключ:");
        String key = Input.input();
        Library.deleteFromTxt(key);
    }

    public void seacrh(Library Library) throws IOException {//метод для работы с методом поиска по ключу клаасса Library
        System.out.println("введите ключ:");
        String key = Input.input();
        Library.readFromTxt(key);
    }

    public void add(Library Library, int type)throws IOException {//метод для работы с методом добавление клаасса Library
        System.out.println("введите ключ:");
        String key = Input.input();
        System.out.println("введите слово:");
        String word = Input.input();
        if(validation(type,key))
            Library.addToTxt(key,word);
        else System.out.println("несоответсвие правилам словаря ");
    }

    public void printAll(Library Library){//метод для работы с методом печать всего словаря клаасса Library
        Library.printAll();
    }

    public boolean searchFromVocabulary(String word,ListOfVocabulary num){//поставить регулярку
        boolean flag=false;
        int n=0;
        n=word.length();
        if(num==ListOfVocabulary.Latins_Rus) {
            if(word.matches(firstVoc))
                return true;
            return false;
        }
         if(num==ListOfVocabulary.Number) {

            if(word.matches(secondVoc))
                return true;
            return false;
        }
        return false;
    }

    public Boolean validation(int num, String key) {//проверка
        if(num==1){
            if(key.length()==4&searchFromVocabulary(key,ListOfVocabulary.Latins_Rus))//проверяем длину и принадлежность алфавиту
                return true;
            else return false;
        }
        else if(num==2){
            if(key.length()==5&searchFromVocabulary(key,ListOfVocabulary.Number))
                return true;
             return false;
        }
        return false;
    }






}