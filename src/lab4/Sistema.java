package lab4;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * Classe responsável pelo Sistema. Armazena informações com Alunos, Grupos de estudos e alunos que responderam perguntas no quadro.
 * 
 * @author Euclides Ramos - 117210377
 *
 */
public class Sistema {
	
	/**
	 * Mapa responsável por armazenar os alunos cadastrados no Sistema. A chave é a matrícula do aluno e o valor é um objeto do tipo Aluno.
	 */
	private HashMap<String, Aluno> alunos;
	
	/**
	 * Mapa responsável por armazenar os grupos de estudos cadastrados no Sistema. A chave é o nome do grupo de estudos e o valor é um objeto do tipo Grupo.
	 */
	private HashMap<String, Grupo> grupos;
	
	/**
	 * Lista responsável por armazenar os alunos que responderam questões no quadro. A sequência é importante.
	 */
	private ArrayList<Aluno> quemRespondeu;
	
	/**
	 * Construtor responsável por construir objetos do tipo Sistema. Cria dois mapas e uma lista.
	 */
	public Sistema() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.quemRespondeu = new ArrayList<>();
	}
	
	/**
	 * Método responsável por cadastrar alunos no sistema, armazenando esses objetos em um mapa. Caso o aluno seja novo para o Sistema retornará "true", 
	 * caso o aluno já esteja cadastrado no Sistema, retornará "false".
	 * 
	 * @param matricula
	 * @param aluno
	 * @return
	 */
	public boolean cadastraAluno(String matricula, Aluno aluno) {
		if (procuraAluno(matricula) == null) {
			this.alunos.put(matricula, aluno);
			return true;
		}
		return false;
	}

	/**
	 * Método responsável por exibir as informações contidas em um objeto Aluno. Atráves da matrícula, a busca é realizada. Caso o aluno não esteja cadastrado no 
	 * Sistema, retornará "ALUNO NÃO CADASTRADO.". Caso ele esteja cadastrado, retornará o toString() desse objeto.
	 * 
	 * @param matricula
	 * @return
	 */
	public String exibeAluno(String matricula) {
		if (procuraAluno(matricula) != null) {
			return "Aluno: " + this.alunos.get(matricula).toString();
		}
		return "ALUNO NÃO CADASTRADO.";
	}
	
	/**
	 * Método responsável por cadastrar grupos de estudos no Sistema. Através do nome do grupo, é realizado uma pesquisa no Sistema. Caso o grupo já exista, 
	 * retornará "false", caso o grupo ainda não esteja cadastrado no Sistema, retornará "true".
	 * 
	 * @param nome
	 * @param grupo
	 * @return
	 */
	public boolean setGrupo(String nome, Grupo grupo) {
		if (procuraGrupo(nome) == null) {
			this.grupos.put(nome.toLowerCase(), grupo);
			return true;
		}
		return false;
	}

	/**
	 * Metódo responsável por adicionar um determinado aluno em um determinado grupo de estudo. Alunos podem participar de mais de um grupo de estudos.
	 * 
	 * @param matriculaAdd -> matrícula do aluno a ser adicionado
	 * @param grupoAdd -> nome do grupo a ser incrementado por um novo aluno.
	 * @return
	 */
	public String setAlunoGrupo(String matricula, String nomeGrupo) {
		
		Aluno alunoAdd = null;
		Grupo grupoAdd = null;
		String saida = "ALUNO ALOCADO!";
		
		if (procuraAluno(matricula) != null && procuraGrupo(nomeGrupo) != null) {
			alunoAdd = this.alunos.get(matricula);
			grupoAdd = this.grupos.get(nomeGrupo.toLowerCase());
		}
		if (procuraAluno(matricula) == null && procuraGrupo(nomeGrupo) == null) {
			saida = "ALUNO E GRUPO NÃO CADASTRADOS.";
		} else if (procuraAluno(matricula) == null) {
			saida = "ALUNO NÃO CADASTRADO.";
		} else if (procuraGrupo(nomeGrupo) == null){
			saida = "GRUPO NÃO CADASTRADO.";
		}
		if (saida.endsWith("!")) {
			grupoAdd.alocarAlunoEmGrupo(alunoAdd);
		}
		return saida;
	}
	
	/**
	 * Método responsável por imprimir os participantes de um determinado grupo de estudo. Caso o grupo não exista, retornará "GRUPO NÃO CADASTRADO.".
	 * 
	 * @param nomeGrupo -> nome do grupo a ser impresso.
	 * @return
	 */
	public String imprimeGrupo(String nomeGrupo) {
		if (procuraGrupo(nomeGrupo) != null) {
			String saida = "Alunos do grupo " + this.grupos.get(nomeGrupo.toLowerCase()).getNomeGrupo() + ":" + System.lineSeparator();
			return saida + this.grupos.get(nomeGrupo.toLowerCase()).getAlunosAssociados();
		}
		return "GRUPO NÃO CADASTRADO.";
	}
	
	/**
	 * Método responsável por adiconar alunos que responderam perguntas no quadro. É possível adicionar o mesmo aluno várias vezes.
	 * 
	 * @param matricula -> matrícula do aluno a ser adicionado.
	 * @return
	 */
	public boolean addAlunoQueRespondeu(String matricula) {
		if (procuraAluno(matricula) != null) {
			this.quemRespondeu.add(this.alunos.get(matricula));
			return true;
		}
		return false;
	}
	
	/**
	 * Método responsável por imprimir todos os alunos que responderam questões no quadro. Nesse caso, a sequência é importante e deve ser considerada.
	 * 
	 * @return
	 */
	public String imprimeAlunosQueResponderam() {
		String saida = "Alunos:" + System.lineSeparator();
		for (int i = 0; i < quemRespondeu.size(); i++) {
			saida += (i + 1) + ". " + quemRespondeu.get(i).toString() + System.lineSeparator();
		}
		return saida;
	}
	
	/**
	 * Método responsável por verificar a entrada do usuário, lançar exceções, quando necessário, e procurar algum aluno no Sistema, a partir da matrícula.
	 * 
	 * @param matricula
	 * @return
	 */
	private Aluno procuraAluno(String matricula) {
		if (matricula.trim().equals("") || matricula.equals(null)) {
			throw new IllegalArgumentException("MATRÍCULA INVÁLIDA!");
		}
		return this.alunos.get(matricula);
	}
	
	/**
	 * Método responsável por verificar a entrada do usuário, lançar exceções, quando necessário, e procurar algum grupo de estudos no Sistema, a partir do seu nome.
	 * 
	 * @param nomeGrupo
	 * @return
	 */
	private Grupo procuraGrupo(String nomeGrupo) {
		if (nomeGrupo.trim().equals("") || nomeGrupo.equals(null)) {
			throw new IllegalArgumentException("GRUPO INVÁLIDO!");
		}
		return this.grupos.get(nomeGrupo.toLowerCase());
	}
}
