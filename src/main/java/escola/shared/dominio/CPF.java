package escola.shared.dominio;

public class CPF {
	
	//TODO: representa um value object (VO) 

	private String numero;

	public CPF(String numero) {
		if (numero == null || 
				!numero.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
			throw new IllegalArgumentException("CPF invalido!");
		}
		this.numero = numero;
	}
	
	public String getNumero() {
		return numero;
	}

	@Override
	public String toString() {
		return "CPF [numero=" + numero + "]";
	}
	
	
}
