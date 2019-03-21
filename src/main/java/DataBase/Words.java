package DataBase;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="words")
public class Words {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String word;
   // @ManyToOne
    //@JoinColumn(name="keys_id", nullable=false)
   // private Keys keys_id;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="keyID")
   private Keys keyID;


    public Words() {
        super();
    }
    public Words(String word) {
        this.word = word;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }



    @Override
    public String toString() {
        return "Words{" +
                "id=" + id +
                ", words=" + word +
                '}';
    }

}
