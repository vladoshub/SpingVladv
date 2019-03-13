package DataBase;

import java.util.List;

public interface KeysDao {
    public void save(Keys K);
    public List<Keys> getKeysList();
}
