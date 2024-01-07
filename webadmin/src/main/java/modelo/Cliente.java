package modelo;

public class Cliente extends Usuario {

	private String documento;
	private String email;

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", dataCriacao=" + dataCriacao + ", getDocumento()="
				+ getDocumento() + ", getEmail()=" + getEmail() + "]";
	}

}
