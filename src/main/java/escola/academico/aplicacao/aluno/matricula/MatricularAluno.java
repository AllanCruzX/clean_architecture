package escola.academico.aplicacao.aluno.matricula;

import escola.academico.dominio.aluno.Aluno;
import escola.academico.dominio.aluno.AlunoMatriculado;
import escola.academico.dominio.aluno.RepositorioDeAlunos;
import escola.shared.dominio.evento.PublicadorDeEventos;

public class MatricularAluno {
	
	private final RepositorioDeAlunos repositorio;
	private final PublicadorDeEventos publicador;

	public MatricularAluno(RepositorioDeAlunos repositorio, PublicadorDeEventos publicador) {
		this.repositorio = repositorio;
		this.publicador = publicador;
	}
	
	// COMMAND
	public void executa(MatricularAlunoDto dados) {
		Aluno novo = dados.criarAluno();
		repositorio.matricular(novo);
		
		AlunoMatriculado evento = new AlunoMatriculado(novo.getCpf());
		publicador.publicar(evento);
	}

}
