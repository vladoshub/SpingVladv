package DataBase;

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
