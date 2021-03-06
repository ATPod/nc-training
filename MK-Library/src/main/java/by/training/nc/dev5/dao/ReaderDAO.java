package by.training.nc.dev5.dao;

import by.training.nc.dev5.model.Reader;

import java.util.Collection;


public interface ReaderDAO {

    int insertReader(Reader pReader);
    boolean deleteReader(int id);
    Reader findReader(String pReaderId);
    boolean updateReader(String pReaderId);
    Collection<Reader> selectReaders();
}
