package dao;

import entity.Keys;
import entity.Words;

import java.util.List;

public interface KeysDao {
    public void save(Keys K);

    public void update(Keys K);

    public void delete(Object K);

    public Words findWordsById(int id);

    public List<Keys> findByKey(String key);

    public List<Keys> getKeysList();

}