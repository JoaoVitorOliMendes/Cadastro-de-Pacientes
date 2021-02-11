package main;

public class methods {
		
	public void salvar(String nome,String tel,String cpf,String data,String med)
	{
		conexao ctl = new conexao();
		paciente p = new paciente();
		
		p.setNome(nome);
		p.setTelefone(tel);
		p.setCpf(cpf);
		p.setData(data);
		p.setMedico(med);
		
		ctl.salvar(p);
	}
	public void deletar(int id)
	{
		conexao ctl = new conexao();
		paciente p = new paciente();
		
		p.setId(id);
		
		ctl.delete(p);
	}
	
}
