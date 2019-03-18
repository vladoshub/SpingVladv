package DataBase;

import java.util.List;

public interface KeysDao {
    public void save(Keys K);
    public void update(Keys K);
    public void delete(Keys K);
    public Words findWordsById(int id);
    public Keys findById(int id);
    public List<Keys> getKeysList();
}
