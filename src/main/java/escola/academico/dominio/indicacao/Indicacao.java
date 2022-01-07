package escola.academico.dominio.indicacao;

import java.time.LocalDateTime;

import escola.academico.dominio.aluno.Aluno;

public class Indicacao {
	
	//TODO: representa uma classe de dominio da aplicacao

	private Aluno indicado;
	private Aluno indicante;
	private LocalDateTime dataIndicacao;

	public Indicacao(Aluno indicado, Aluno indicante) {
		this.indicado = indicado;
		this.indicante = indicante;
		this.dataIndicacao = LocalDateTime.now();
	}

	public Aluno getIndicado() {
		return indicado;
	}

	public Aluno getIndicante() {
		return indicante;
	}

	public LocalDateTime getDataIndicacao() {
		return dataIndicacao;
	}

}
