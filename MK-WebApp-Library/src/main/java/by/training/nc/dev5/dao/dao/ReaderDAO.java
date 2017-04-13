package by.training.nc.dev5.dao.dao;

import by.training.nc.dev5.model.Reader;

import java.util.Collection;


public interface ReaderDAO {

    int insertReader(Reader pReader);
    boolean deleteReader(int id);
    Reader findReader(int id);
    boolean updateReader(Reader reader);
    Collection<Reader> selectReaders();
}
