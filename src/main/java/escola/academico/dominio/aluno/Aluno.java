package escola.academico.dominio.aluno;

import java.util.ArrayList;
import java.util.List;

import escola.shared.dominio.CPF;

// Aluno representa uma entidade e um aggregate root
public class Aluno {
			
	private CPF cpf;
	private String nome;
	
	private Email email;
	
	private List<Telefone> telefones = new ArrayList<>();
	
	private String senha;
	
	public Aluno(CPF cpf, String nome, Email email) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}

	public void adicionarTelefone(String ddd, String numero) {
		if (telefones.size() == 2) {
			// aqui é uma invariante - "É uma regra de negócio que deve sempre ser verdadeira para os objetos serem válidos"
			throw new IllegalArgumentException("Numero maximo de telefones ja atingido!");
		}
		this.telefones.add(new Telefone(ddd, numero));
	}
	
	public CPF getCpf() {
		return cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email.getEndereco();
	}
	
	public List<Telefone> getTelefones() {
		return telefones;
	}

	public String getSenha() {
		return senha;
	}
}






