package servlets;

public class TotalDAO {

	  private Connection connection;

	  public ComprarDao() {
	    this.connection = new ConnectionFactory().getConnection();
	  }
	 
	  
	  public boolean insert (Comprar comprar) throws SQLException {
		  try{
	          Connection connection = new ConnectionFactory().getConnection();
	          } catch (RuntimeException e){
	          	System.out.println("Error 3115");
	          	return false;
	          
	          }
		  String sql = "SELECT PRECO FROM tb_passagens;";
		             
		     try {
		    	 
		         PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
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
