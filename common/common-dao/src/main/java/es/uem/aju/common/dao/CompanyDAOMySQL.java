package es.uem.aju.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import es.uem.aju.common.dao.interfaces.CompanyDAO;
import es.uem.aju.common.dto.CompanyDTO;
import es.uem.aju.common.dto.CompanyListDTO;

public class CompanyDAOMySQL extends BaseDAO implements CompanyDAO {
	
	
	private final static String SQL_FIND_COMNAPIES_BY_NAME = "select * from company where name =?";
	
	private final static String SQL_FIND_COMPANIES = "select * from company where id =?";
	
	private final static String SQL_FIND_ALL_COMPANIES = "select * from company";
	
	public CompanyDAOMySQL(DataSource datasource) {
		super(datasource);
	}

	public CompanyDTO findCompanyByName(String name) {
		List<CompanyDTO> results = new ArrayList<CompanyDTO>();
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = datasource.getConnection();
			ps = con.prepareStatement(SQL_FIND_COMNAPIES_BY_NAME);
			ps.setString(1, name);
			
			results = (List<CompanyDTO>) processListResultSet(ps.executeQuery());
			if (results.size() == 1){
				return results.get(0);
			}			
		}catch(SQLException e){
			return null;
		}finally{			
		    if (ps != null) {
		        try {
		            ps.close();
		        } catch (SQLException e){
		        	log.error(e.getMessage());
		    }
		    if (con != null) {
		        try {
		            con.close();
		        } catch (SQLException e){
		        	log.error("Error closing connection : "+e.getMessage());
		        	}
		        }
		    }
		}		
		return null;	
	}
	
	public List<CompanyDTO> processListResultSet(ResultSet resultSet) throws SQLException {
		List<CompanyDTO> result = new ArrayList<CompanyDTO>();
		try{
			while (resultSet.next()){
				result.add(new CompanyDTO(
								resultSet.getInt("id"),
								resultSet.getString("name"),
								resultSet.getInt("location_id")
								));			
			}			
		}catch(SQLException e){	
			log.error(e.getMessage());
			}
		finally{
			try {
				resultSet.close();
			} catch (SQLException e){
				log.error("Error closing resultrest: "+e.getMessage());
			}			
		}	
		return result;
	}

	public CompanyDTO find(Integer pk) {
		List<CompanyDTO> results = new ArrayList<CompanyDTO>();
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = datasource.getConnection();
			ps = con.prepareStatement(SQL_FIND_COMPANIES);
			ps.setInt(1, pk);
			
			results = (List<CompanyDTO>) processListResultSet(ps.executeQuery());
			if (results.size() ==1){
				return results.get(0);
			}			
		}catch(SQLException e){
			return null;
		}finally{			
		    if (ps != null) {
		        try {
		            ps.close();
		        } catch (SQLException e){
		        	log.error(e.getMessage());
		    }
		    if (con != null) {
		        try {
		            con.close();
		        } catch (SQLException e){
		        	log.error("Error closing connection : "+e.getMessage());
		        	}
		        }
		    }
		}		
		return null;
	}
	
	public CompanyListDTO findAll() {		
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = datasource.getConnection();
			ps = con.prepareStatement(SQL_FIND_ALL_COMPANIES);
			return new CompanyListDTO(processListResultSet(ps.executeQuery()));

		} catch (SQLException e) {
			return null;
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					log.error(e.getMessage());
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						log.error("Error closing connection : " + e.getMessage());
					}
				}
			}
		}				
	}

	public void store(CompanyDTO o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void update(CompanyDTO o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public int delete(Integer pk) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}	
}
