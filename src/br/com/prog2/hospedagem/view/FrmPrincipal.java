package br.com.prog2.hospedagem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					frame.setTitle("Sistema de Hospedagem");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnHospedagem = new JMenu("Hospedagem");
		menuBar.add(mnHospedagem);
		
		JMenuItem mntmCriarHospedagem = new JMenuItem("Criar Hospedagem");
		mntmCriarHospedagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmHospedagem fh = new FrmHospedagem();
				//fh.pack();
				fh.setVisible(true);
				
			}
		});
		mnHospedagem.add(mntmCriarHospedagem);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JMenuItem mntmCriarServio = new JMenuItem("Criar Servi\u00E7o");
		mntmCriarServio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmServico fs = new FrmServico();
				fs.setVisible(true);
			}
		});
		mnHospedagem.add(mntmCriarServio);
		
		JMenuItem mntmAdicionarServioA = new JMenuItem("Adicionar Servi\u00E7o a Hospedagem");
		mntmAdicionarServioA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmHospedagemServico fhs = new FrmHospedagemServico();
				fhs.setVisible(true);
			}
		});
		mnHospedagem.add(mntmAdicionarServioA);
		mnHospedagem.add(mntmSair);
		
		JMenu mnCadastroDeClientes = new JMenu("Cadastro de Clientes");
		menuBar.add(mnCadastroDeClientes);
		
		JMenuItem mntmCadastrarCliente = new JMenuItem("Cadastrar Cliente");
		mntmCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmCliente fc = new FrmCliente();
				fc.setVisible(true);
			}
		});
		mnCadastroDeClientes.add(mntmCadastrarCliente);
		
		JMenuItem mntmAdicionarTelefone = new JMenuItem("Adicionar Telefone");
		mntmAdicionarTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmTelefone ft = new FrmTelefone();
				ft.setVisible(true);
			}
		});
		mnCadastroDeClientes.add(mntmAdicionarTelefone);
		
		JMenu mnCadastroDeChals = new JMenu("Cadastro de Chal\u00E9s");
		menuBar.add(mnCadastroDeChals);
		
		JMenuItem mntmCadastrarChale = new JMenuItem("Cadastrar Chale");
		mntmCadastrarChale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmChale fc = new FrmChale();
				fc.setVisible(true);
			}
		});
		mnCadastroDeChals.add(mntmCadastrarChale);
		
		JMenuItem mntmCadastrarItem = new JMenuItem("Cadastrar Item");
		mntmCadastrarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmItem fi = new FrmItem();
				fi.setVisible(true);
			}
		});
		mntmCadastrarItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		mnCadastroDeChals.add(mntmCadastrarItem);
		
		JMenuItem mntmAdicionarItemAo = new JMenuItem("Adicionar Item ao Chale");
		mntmAdicionarItemAo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmChaleItem fci = new FrmChaleItem();
				fci.setVisible(true);
			}
		});
		mnCadastroDeChals.add(mntmAdicionarItemAo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 251, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}

}
