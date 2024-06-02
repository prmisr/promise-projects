
package za.ac.tut.bl;

import java.sql.SQLException;
import java.util.List;
import za.ac.tut.entity.Employee;

public interface DAOInterface<T> {
    public boolean add(T t)throws SQLException;
    public boolean delete(Integer idNum)throws SQLException;
    public boolean update(T t)throws SQLException;
    public T get(Integer idNum)throws SQLException;
    public List<Employee> getAll()throws SQLException; 
}
