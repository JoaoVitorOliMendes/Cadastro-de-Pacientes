package main;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class conexao {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	//cria o gerenciador e a faz conexão a partir do persistence
	public conexao()
	{
		emf = Persistence.createEntityManagerFactory("pacientename");
		em = emf.createEntityManager();
	}
	
	//salvar              atributos |
	public void salvar(paciente _paciente)
	{
		em.getTransaction().begin();//faz a conexão
		em.merge(_paciente);//prepara para salvar os dados no banco de dados
		em.getTransaction().commit();//executa os comandos
		JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");//teste de funcionou
		emf.close();//fecha a conexão
	} 
	public void delete(paciente _paciente)
	{
		em.getTransaction().begin();
		Query q = em.createNativeQuery("delete from paciente where id = "+ _paciente.getId());
		q.executeUpdate();
		em.getTransaction().commit();
		JOptionPane.showMessageDialog(null, "Deletado com sucesso");
		emf.close();
	}  
	public List<paciente> listar()
	{
		em.getTransaction().begin();
		Query q1 = em.createQuery("from paciente");
		List<paciente> lista = q1.getResultList();
		em.getTransaction().commit();
		System.out.println("sucsex");
		emf.close();
		return lista;
	}
	
}
