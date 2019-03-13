package DataBase;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="KEYS")
public class Keys {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String key;
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Words> words;
    public Keys() {
        super();
    }
    public Keys(String key, List<Words> words) {
        this.key = key;
        this.words = words;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public List<Words> getWords() {
        return words;
    }
    public void SetWords(List<Words> words) {
        this.words = words;
    }
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", Key='" + key + '\'' +
                ", Words=" + words +
                '}';
    }
}
