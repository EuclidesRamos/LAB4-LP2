package lab4;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class AlunoTest {

	private Aluno aluno1, aluno2, aluno3;
	
	@Before
	public void exemploAluno() {
		this.aluno1 = new Aluno("123", "Euclides", "Computacao");
		this.aluno2 = new Aluno("123", "Ramos", "Computacao");
		this.aluno3 = new Aluno("456", "Euclides", "Computacao");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoMatriculaInvalidaVazia() {
		assertEquals("MATRÍCULA INVÁLIDA!", this.aluno1 = new Aluno("", "Euclides", "Computacao"));
	}
	
	@Test(expected=NullPointerException.class)
	public void testAlunoMatriculaInvalidaNula() {
		assertEquals("MATRÍCULA INVÁLIDA!", this.aluno1 = new Aluno(null, "Euclides", "Computacao"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoNomeInvalidoVazio() {
		assertEquals("NOME INVÁLIDO!", this.aluno1 = new Aluno("123", "", "Computacao"));
	}
	
	@Test(expected=NullPointerException.class)
	public void testAlunoNomeInvalidoNulo() {
		assertEquals("NOME INVÁLIDO!", this.aluno1 = new Aluno("123", null, "Computacao"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoCursoInvalidoVazio() {
		assertEquals("CURSO INVÁLIDO!", this.aluno1 = new Aluno("123", "Euclides", ""));
	}
	
	@Test(expected=NullPointerException.class)
	public void testAlunoCursoInvalidoNulo() {
		assertEquals("CURSO INVÁLIDO!", this.aluno1 = new Aluno("123", "Euclides", null));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoInvalidoVazio() {
		assertEquals("MATRÍCULA INVÁLIDA!", this.aluno1 = new Aluno("", "", ""));
	}
	
	@Test(expected=NullPointerException.class)
	public void testAlunoInvalidoNulo() {
		assertEquals("MATRÍCULA INVÁLIDA!", this.aluno1 = new Aluno(null, null, null));
	}
	
	@Test
	public void testGetMatricula() {
		assertEquals("123", aluno1.getMatricula());
	}
	
	@Test
	public void testToString() {
		assertEquals("123 - Euclides - Computacao", aluno1.toString());
	}
	
	@Test
	public void testHashCode() {
		assertEquals(this.aluno1.hashCode(), this.aluno2.hashCode());
	}
	
	@Test
	public void testEqualsIguais() {
		assertEquals(true, this.aluno1.equals(aluno2));
	}
	
	@Test
	public void testEqualsDiferentes() {
		assertEquals(false, this.aluno1.equals(aluno3));
	}
}
