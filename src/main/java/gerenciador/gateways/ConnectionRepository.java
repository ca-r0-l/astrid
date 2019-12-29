package gerenciador.gateways;

import java.sql.Connection;

public interface ConnectionRepository {
		
	public Connection connect();
}