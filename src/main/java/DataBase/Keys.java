package DataBase;

import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="keys")
public class Keys {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
  // @Column(unique = true)
    private String key;
    //@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    //@JoinColumn(name = "keys_id")
    //@OneToMany(mappedBy="keys")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Words> words;
    public Keys() {
        super();
    }
    public Keys(String key, List<Words> words) {
        this.key = key;
        this.words = words;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
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
        return "KEYS{" +
                "id=" + id +
                ", Key='" + key + '\'' +
                ", Words=" + words +
                '}';
    }
}
