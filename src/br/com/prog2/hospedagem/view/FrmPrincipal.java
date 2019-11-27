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
