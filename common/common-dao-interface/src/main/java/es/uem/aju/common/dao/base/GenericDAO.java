package es.uem.aju.common.dao.base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import es.uem.aju.common.dto.BaseDTO;


/**
 * Generic interface for DAO objects
 * @author emartinezagra
 *
 * @param <T> type
 * @param <PK> primary key
 */
public interface GenericDAO<T, PK>
{
    
    /**
     * Find the Object in the system backend by it's primary key.
     *
     * @param pk
     *            the pk
     * @return the t
     * @throws SQLException
     *             the SQL exception
     */
    public abstract BaseDTO find( PK pk ) throws SQLException;
    
    
    /**
     * Find the all the Objects in the system
     * 
     * @return the t
     * @throws SQLException
     *             the SQL exception
     */
    public abstract BaseDTO findAll( ) throws SQLException;
        
    
    /**
     * Store a object in the system backend.
     *
     * @param o
     *            the o
     * @throws SQLException
     *             the SQL exception
     */
    public abstract void store( T o ) throws SQLException;
    
    
    /**
     * Update an Object in the system backend.
     *
     * @param o
     *            the o
     * @throws SQLException
     *             the SQL exception
     */
    public abstract void update( T o ) throws SQLException;
    
    
    /**
     * Delete an object in the system backend by it's primary key.
     *
     * @param pk
     *            the pk
     * @return the rows affected
     * @throws SQLException
     *             the SQL exception
     */
    public abstract int delete( PK pk ) throws SQLException;
          
    /**
     * Converts a resultset into a collection of DTOs
     * 
     * @param resultSet
     * @return
     * @throws SQLException
     */
    abstract Collection<? extends BaseDTO> processListResultSet( ResultSet resultSet ) throws SQLException;
    
}

