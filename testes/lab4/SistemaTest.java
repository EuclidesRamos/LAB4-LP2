package lab4;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class SistemaTest {

	private Sistema sistema;
	private Aluno aluno1, aluno2, aluno3;
	private Grupo grupo1, grupo2, grupo3;
	
	@Before
	public void exemploSistema() {
		this.sistema = new Sistema();
		this.aluno1 = new Aluno("123", "Euclides", "Computacao");
		this.aluno2 = new Aluno("456", "Ramos", "Engenharia Elétrica");
		this.aluno3 = new Aluno("789", "Araujo", "Computacao");
		this.grupo1 = new Grupo("Listas");
		this.grupo2 = new Grupo("Provas");
		this.grupo3 = new Grupo("Simulados");
		this.sistema.cadastraAluno("123", aluno1);
		this.sistema.cadastraAluno("789", aluno3);
		this.sistema.setGrupo("Provas", grupo2);
		this.sistema.setGrupo("Simulados", grupo3);
		this.sistema.setAlunoGrupo("123", "Simulados");
	}
	
	@Test
	public void testCadastraAluno() {
		assertEquals(true, sistema.cadastraAluno("456", this.aluno2));
	}
	
	@Test
	public void testCadastraAlunoExistente() {
		assertEquals(false, sistema.cadastraAluno("123", this.aluno1));
	}

	@Test
	public void testExibeAluno() {
		assertEquals("Aluno: 123 - Euclides - Computacao", sistema.exibeAluno("123"));
	}
	
	@Test
	public void testExibeAlunoInexistente() {
		assertEquals("ALUNO NÃO CADASTRADO.", sistema.exibeAluno("111"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testExibeAlunoMatriculaInvalidaVazia() {
		assertEquals("MATRÍCULA INVÁLIDA!", sistema.exibeAluno(""));
	}
	
	@Test(expected=NullPointerException.class)
	public void testExibeAlunoMatriculaInvalidaNula() {
		assertEquals("MATRÍCULA INVÁLIDA!", sistema.exibeAluno(null));
	}

	@Test
	public void testSetGrupo() {
		assertEquals(true, sistema.setGrupo("Listas", this.grupo1));
	}
	
	@Test
	public void testSetGrupoExistente() {
		assertEquals(false, sistema.setGrupo("Provas", this.grupo2));
	}

	@Test
	public void testSetAlunoGrupo() {
		assertEquals("ALUNO ALOCADO!", sistema.setAlunoGrupo("123", "PROVAS"));
	}
	
	@Test
	public void testSetAlunoGrupoInexistente() {
		assertEquals("GRUPO NÃO CADASTRADO.", sistema.setAlunoGrupo("123", "TRABALHOS"));
	}
	
	@Test
	public void testSetAlunoInexistenteGrupo() {
		assertEquals("ALUNO NÃO CADASTRADO.", sistema.setAlunoGrupo("111", "Provas"));
	}
	
	@Test
	public void testSetAlunoInexistenteGrupoInexistente() {
		assertEquals("ALUNO E GRUPO NÃO CADASTRADOS.", sistema.setAlunoGrupo("111", "trabalhos"));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetAlunoInvalidoVazioGrupo() {
		assertEquals("MATRÍCULA INVÁLIDA!", sistema.setAlunoGrupo("", "Provas"));
	}
	
	@Test(expected=NullPointerException.class)
	public void testSetAlunoInvalidoNuloGrupo() {
		assertEquals("MATRÍCULA INVÁLIDA!", sistema.setAlunoGrupo(null, "Provas"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetAlunoGrupoInvalidoVazio() {
		assertEquals("GRUPO INVÁLIDO!", sistema.setAlunoGrupo("123", ""));
	}
	
	@Test(expected=NullPointerException.class)
	public void testSetAlunoGrupoInvalidoNulo() {
		assertEquals("GRUPO INVÁLIDO!", sistema.setAlunoGrupo("123", null));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetAlunoInvalidoVazioGrupoInvalidoVazio() {
		assertEquals("MATRÍCULA INVÁLIDA!", sistema.setAlunoGrupo("", ""));
	}
	
	@Test(expected=NullPointerException.class)
	public void testSetAlunoInvalidoNuloGrupoInvalidoNulo() {
		assertEquals("MATRÍCULA INVÁLIDA!", sistema.setAlunoGrupo(null, null));
	}
	
	@Test
	public void testImprimeGrupo() {
		assertEquals("Alunos do grupo Simulados:" + System.lineSeparator() + "* 123 - Euclides - Computacao" + System.lineSeparator(), sistema.imprimeGrupo("Simulados"));
	}
	
	@Test
	public void testImprimeGrupoVazio() {
		assertEquals("Alunos do grupo Provas:" + System.lineSeparator() + "", sistema.imprimeGrupo("Provas"));
	}
	
	@Test
	public void testImprimeGrupoInexistente() {
		assertEquals("GRUPO NÃO CADASTRADO.", sistema.imprimeGrupo("Trabalhos"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testImprimeGrupoInvalidoVazio() {
		assertEquals("GRUPO INVÁLIDO!", sistema.imprimeGrupo(""));
	}
	
	@Test(expected=NullPointerException.class)
	public void testImprimeGrupoInvalidoNulo() {
		assertEquals("GRUPO INVÁLIDO!", sistema.imprimeGrupo(null));
	}

	@Test
	public void testAddAlunoQueRespondeu() {
		assertEquals(true, sistema.addAlunoQueRespondeu("123"));
	}
	
	@Test
	public void testAddAlunoInexistenteQueRespondeu() {
		assertEquals(false, sistema.addAlunoQueRespondeu("111"));
	}
	
	@Test
	public void testAddAlunoQueRespondeuNovamente() {
		this.sistema.addAlunoQueRespondeu("789");
		assertEquals(true, sistema.addAlunoQueRespondeu("789"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddAlunoQueRespondeuMatriculaInvalidaVazia() {
		assertEquals("MATRÍCULA INVÁLIDA!", sistema.addAlunoQueRespondeu(""));
	}
	
	@Test(expected=NullPointerException.class)
	public void testAddAlunoQueRespondeuMatriculaInvalidaNula() {
		assertEquals("MATRÍCULA INVÁLIDA!", sistema.addAlunoQueRespondeu(null));
	}

	@Test
	public void testImprimeAlunosQueResponderam() {
		this.sistema.addAlunoQueRespondeu("789");
		assertEquals("Alunos:" + System.lineSeparator() + "1. 789 - Araujo - Computacao" + System.lineSeparator(), sistema.imprimeAlunosQueResponderam());
	}
	
	@Test
	public void testImprimeAlunosQueResponderamMaisDeUm() {
		this.sistema.addAlunoQueRespondeu("123");
		this.sistema.addAlunoQueRespondeu("789");
		assertEquals("Alunos:" + System.lineSeparator() + "1. 123 - Euclides - Computacao" + System.lineSeparator() + "2. 789 - Araujo - Computacao" + System.lineSeparator(), sistema.imprimeAlunosQueResponderam());
	}
	
	@Test
	public void testImprimeAlunosQueResponderamIguais() {
		this.sistema.addAlunoQueRespondeu("123");
		this.sistema.addAlunoQueRespondeu("123");
		assertEquals("Alunos:" + System.lineSeparator() + "1. 123 - Euclides - Computacao" + System.lineSeparator() + "2. 123 - Euclides - Computacao" + System.lineSeparator(), sistema.imprimeAlunosQueResponderam());
	}
	
	@Test
	public void testImprimeAlunosQueResponderamVazio() {
		assertEquals("Alunos:" + System.lineSeparator(), sistema.imprimeAlunosQueResponderam());
	}
}
