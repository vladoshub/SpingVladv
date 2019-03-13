package DataBase;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="WORDS")
public class Words {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String word;
    public Words() {
        super();
    }
    public Words(String word) {
        this.word = word;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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
