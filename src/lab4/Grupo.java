package lab4;

import java.util.HashSet;

/**
 * Classe responsável por armazenar todas as informações acerca de um objeto do tipo Grupo.
 * 
 * @author Euclides Ramos - 117210377
 *
 */
public class Grupo {
	
	/**
	 * Atributo responsável por armazenar o nome do grupo em forma de String.
	 */
	private String nomeGrupo;
	
	/**
	 * Conjunto responsável por armazenar todos os alunos que fazem parte do grupo de estudo.
	 */
	private HashSet<Aluno> alunosAssociados;
	
	/**
	 * Construtor responsável por contruir um objeto do tipo Grupo. Além de criar um conjunto para armazenar os alunos que fazem parte desse grupo.
	 * 
	 * @param nomeGrupo - Caso o nome do grupo seja nulo ou vazio, é lançada uma exceção.
	 */
	public Grupo(String nomeGrupo) {
		if (nomeGrupo.trim().equals("") || nomeGrupo.equals(null)) {
			throw new IllegalArgumentException("GRUPO INVÁLIDO!");
		}
		this.nomeGrupo = nomeGrupo;
		this.alunosAssociados = new HashSet<>();
	}
	
	/**
	 * Método responsável por alocar um novo aluno no grupo desejado. Não há repetição de alunos nos grupos de estudo.
	 * 
	 * @param aluno
	 * @return
	 */
	public boolean alocarAlunoEmGrupo(Aluno aluno) {
		for (Aluno a : alunosAssociados) {
			if (a.getMatricula().equals(aluno.getMatricula())) {
				return true;
			}
		}
		alunosAssociados.add(aluno);
		return true;
	}
	
	/**
	 * Método responsável por retornar o nome do grupo de estudos.
	 * 
	 * @return
	 */
	public String getNomeGrupo() {
		return nomeGrupo;
	}
	
	/**
	 * Método responsável por retornar os alunos que fazem parte do grupo de estudos em forma de String.
	 * 
	 * @return
	 */
	public String getAlunosAssociados() {
		String saida = "";
		for (Aluno a : alunosAssociados) {
			saida += "* " + a.toString() + System.lineSeparator();
		}
		return saida;
	}

	/**
	 * Método responsável por criar e retornar um valor único para cada Objeto do tipo Grupo.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeGrupo == null) ? 0 : nomeGrupo.toLowerCase().hashCode());
		return result;
	}

	/**
	 * Método responsável por comparar se dois objetos do tipo Grupo são iguais. A comparação é realizada através do nome do grupo.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!this.getClass().equals(obj.getClass())) {
			return false;
		}
		Grupo outroGrupo = (Grupo) obj;
		if (this.nomeGrupo.toLowerCase().equals(outroGrupo.nomeGrupo.toLowerCase())) {
			return true;
		}
		return false;
	}
}
