package servlets;


import java.sql.*;


public class ComprarDAO {

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
		  String sql = "insert into tb_passagens " +
		             "(NOME,IDADE,ASSENTO,CODIGO,PRECO)" +
		             " values (?,?,?,?,?);";
		             
		     try {
		    	 
		         PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		         
		 
		         stmt.setString(1,comprar.getName());
		         stmt.setString(2,comprar.getIdade());
		         stmt.setString(3,comprar.getAssento());
		         stmt.setString(4,comprar.getCodigo());
		         stmt.setString(4,comprar.compararIdade());
		        
		         
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
