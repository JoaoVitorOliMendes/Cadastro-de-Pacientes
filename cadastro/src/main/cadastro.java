package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import java.awt.Color;

public class cadastro {

	private JFrame frame;
	private JTextField txtnome;
	private JTextField txttel;
	private JTextField txtcpf;
	private JTextField txtdt;
	private JTextField txtid;
	private JTextField txtmed;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastro window = new cadastro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public cadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 890, 551);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		Object[] columns = {"Id", "Nome", "Telefone", "CPF", "Data", "Médico"};
		DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		table.setBounds(10, 137, 856, 313);
		frame.getContentPane().add(table);
		model.setColumnIdentifiers(columns);
		
		JLabel lbltitle = new JLabel("Cadastro de Pacientes");
		lbltitle.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbltitle.setBounds(335, 0, 206, 42);
		frame.getContentPane().add(lbltitle);
		
		txtnome = new JTextField();
		txtnome.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtnome.setBounds(10, 53, 265, 23);
		frame.getContentPane().add(txtnome);
		txtnome.setColumns(10);
		
		JButton btncadastro = new JButton("Cadastrar");
		btncadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!txtnome.getText().isEmpty() &&
				   !txttel.getText().isEmpty() &&
				   !txtcpf.getText().isEmpty() &&
				   !txtdt.getText().isEmpty() &&
				   !txtmed.getText().isEmpty())
				{
					methods m = new methods();
					m.salvar(txtnome.getText(),txttel.getText(),txtcpf.getText(),txtdt.getText(),txtmed.getText());
				}else
				{
					JOptionPane.showMessageDialog(null,"Digite algo!!");
				}
				model.setRowCount(0);
				conexao ctl = new conexao();
				List<paciente> lista = ctl.listar();
				
				Object[] row = new Object[6];
				
				for(int i = 0;i<ctl.listar().size();i++)
				{
				row[0] = lista.get(i).getId();
				row[1] = lista.get(i).getNome();
				row[2] = lista.get(i).getTelefone();
				row[3] = lista.get(i).getCpf();
				row[4] = lista.get(i).getData();
				row[5] = lista.get(i).getMedico();
				
				model.addRow(row);
				}
				
				
			}
		});
		btncadastro.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btncadastro.setBounds(10, 480, 206, 23);
		frame.getContentPane().add(btncadastro);
		
		JLabel lblNewLabel = new JLabel("Nome do paciente");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 39, 99, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblTelefone.setBounds(305, 39, 99, 14);
		frame.getContentPane().add(lblTelefone);
		
		txttel = new JTextField();
		txttel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txttel.setColumns(10);
		txttel.setBounds(305, 53, 159, 23);
		frame.getContentPane().add(txttel);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCpf.setBounds(491, 39, 99, 14);
		frame.getContentPane().add(lblCpf);
		
		txtcpf = new JTextField();
		txtcpf.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtcpf.setColumns(10);
		txtcpf.setBounds(491, 53, 136, 23);
		frame.getContentPane().add(txtcpf);
		
		JLabel lblDataDeConsulta = new JLabel("Data de Consulta");
		lblDataDeConsulta.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDataDeConsulta.setBounds(645, 39, 99, 14);
		frame.getContentPane().add(lblDataDeConsulta);
		
		txtdt = new JTextField();
		txtdt.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtdt.setColumns(10);
		txtdt.setBounds(645, 53, 136, 23);
		frame.getContentPane().add(txtdt);
		
		JLabel lblIdConsulta = new JLabel("ID consulta");
		lblIdConsulta.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblIdConsulta.setBounds(627, 466, 99, 14);
		frame.getContentPane().add(lblIdConsulta);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtid.setColumns(10);
		txtid.setBounds(627, 480, 76, 23);
		frame.getContentPane().add(txtid);
		
		JLabel lblMedicoAAtender = new JLabel("Medico a atender");
		lblMedicoAAtender.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblMedicoAAtender.setBounds(10, 87, 99, 14);
		frame.getContentPane().add(lblMedicoAAtender);
		
		txtmed = new JTextField();
		txtmed.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtmed.setColumns(10);
		txtmed.setBounds(10, 101, 206, 23);
		frame.getContentPane().add(txtmed);
		
		JButton btndel = new JButton("Deletar");
		btndel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtid.getText().isEmpty())
				{
					methods m = new methods();
					m.deletar(Integer.parseInt(txtid.getText()));
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Digite algo!!!");
				}
				model.setRowCount(0);
				conexao ctl = new conexao();
				List<paciente> lista = ctl.listar();
				
				Object[] row = new Object[6];
				
				for(int i = 0;i<ctl.listar().size();i++)
				{
				row[0] = lista.get(i).getId();
				row[1] = lista.get(i).getNome();
				row[2] = lista.get(i).getTelefone();
				row[3] = lista.get(i).getCpf();
				row[4] = lista.get(i).getData();
				row[5] = lista.get(i).getMedico();
				
				model.addRow(row);
				}
			}
		});
		btndel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btndel.setBounds(713, 480, 99, 23);
		frame.getContentPane().add(btndel);
		
		model.setRowCount(0);
		conexao ctl = new conexao();
		List<paciente> lista = ctl.listar();
		
		Object[] row = new Object[6];
		
		for(int i = 0;i<ctl.listar().size();i++)
		{
		row[0] = lista.get(i).getId();
		row[1] = lista.get(i).getNome();
		row[2] = lista.get(i).getTelefone();
		row[3] = lista.get(i).getCpf();
		row[4] = lista.get(i).getData();
		row[5] = lista.get(i).getMedico();
		
		model.addRow(row);
		}
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
