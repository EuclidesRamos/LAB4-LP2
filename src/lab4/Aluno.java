package lab4;

/**
 * Classe responsável por armazenar todas as informações acerca de um determinado aluno.
 * 
 * @author Euclides Ramos - 117210377
 *
 */
public class Aluno {

	/**
	 * Atributo responsável por armazenar a matrícula do aluno.
	 */
	private String matricula;
	
	/**
	 * Atributo responsável por armazenar o nome do aluno.
	 */
	private String nome;
	
	/**
	 * Atributo responsável por armazenar o curso do aluno.
	 */
	private String curso;
	
	/**
	 * Construtor responsável por construir um objeto do tipo Aluno, com matrícula, nome e curso associados a ele.
	 * 
	 * @param matricula -> Caso a matrícula seja nula ou vazia é lançada uma exceção.
	 * @param nome -> Caso o nome seja nulo ou vazio é lançada uma exceção.
	 * @param curso -> Caso o curso seja nulo ou vazio é lançada uma exceção.
	 */
	public Aluno(String matricula, String nome, String curso) {
		if (matricula.trim().equals("") || matricula.equals(null)) {
			throw new IllegalArgumentException("MATRÍCULA INVÁLIDA!");
		} else if (nome.trim().equals("") || nome.equals(null)) {
			throw new IllegalArgumentException("NOME INVÁLIDO!");
		} else if (curso.trim().equals("") || curso.equals(null)) {
			throw new IllegalArgumentException("CURSO INVÁLIDO!");
		}
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
		
	}
	
	/**
	 * Método responsável por retornar a matrícula do aluno.
	 * 
	 * @return
	 */
	public String getMatricula() {
		return this.matricula;
	}
	
	/**
	 * Método responsável por retornar uma String contendo todas as informações do aluno.
	 */
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso;
	}

	/**
	 * Método responsável por criar e retornar um valor único para cada Objeto do tipo Aluno.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * Método responsável por comparar se dois objetos do tipo Aluno são iguais. A comparação é realizada através da matrícula do aluno.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!this.getClass().equals(obj.getClass())) {
			return false;
		}
		Aluno outroAluno = (Aluno) obj;
		if (this.matricula.equals(outroAluno.matricula)) {
			return true;
		}
		return false;
	}
}
