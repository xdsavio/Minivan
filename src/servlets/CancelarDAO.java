package servlets;

public class CancelarDAO {
	private Connection connection;

	  public CancelarDao() {
	    this.connection = new ConnectionFactory().getConnection();
	  }
	 
	  
	  public boolean delete (Comprar comprar) throws SQLException {
		  try{
	          Connection connection = new ConnectionFactory().getConnection();
	          } catch (RuntimeException e){
	          	System.out.println("Error 3115");
	          	return false;
	          
	          }
		  String sql = "DELETE FROM tb_comprar" +
				       "WHERE NOME = ?"+
				       "AND CODIGO = ?;";
				        
		             
		     try {
		    	 
		         PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		         
		 
		         stmt.setString(1,comprar.getName());
		         stmt.setString(2,comprar.getCodigo());
		        
		         
		         stmt.execute();
		         stmt.close();
		         
		         
		     } catch (SQLException e) {
		         throw new RuntimeException(e);
		     }
		     return true;
	  }
	  
	  public void disconnect() throws SQLException {
			this.connection.close();	
	  }
	
}
