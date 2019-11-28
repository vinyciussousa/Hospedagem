package br.com.prog2.hospedagem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.prog2.hospedagem.controller.ChaleController;
import br.com.prog2.hospedagem.negocio.Chale;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class FrmChale extends JFrame {

	private JPanel contentPane;
	private JTable tblConsulta;
	private JTextField txtCodChale;
	private JTextField txtLocalizacao;
	private JTextField txtCapacidade;
	private JTextField txtValorAltaEstacao;
	private JTextField txtValorBaixaEstacao;
	private JLabel lblMensagem;
	
	private void pesquisar() {
		List<Chale> listaCha = new ArrayList();
		ChaleController controller = new ChaleController();
		listaCha = controller.listarTodos();
		DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
		for (int i = tbm.getRowCount()-1; i >= 0; i--) {
			tbm.removeRow(i);
		}
		int i = 0;
		for (Chale cha : listaCha) {
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(cha.getCodChale(), i, 0);
			tblConsulta.setValueAt(cha.getLocalizacao(), i, 1);
			tblConsulta.setValueAt(cha.getCapacidade(), i, 2);
			tblConsulta.setValueAt(cha.getValorAltaEstacao(), i, 3);
			tblConsulta.setValueAt(cha.getValorBaixaEstacao(), i, 4);
			i++;
		}
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmChale frame = new FrmChale();
					frame.setTitle("Cadastro de Chale");
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
	public FrmChale() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 520, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tblConsulta = new JTable();
		tblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer linha = tblConsulta.getSelectedRow();
				String codChale = tblConsulta.getValueAt(linha, 0).toString();
				String localizacao = tblConsulta.getValueAt(linha, 1).toString();
				String capacidade = tblConsulta.getValueAt(linha, 2).toString();
				String valorAltaEstacao = tblConsulta.getValueAt(linha, 3).toString();
				String valorBaixaEstacao = tblConsulta.getValueAt(linha, 4).toString();
				txtCodChale.setText(codChale);
				txtLocalizacao.setText(localizacao);
				txtCapacidade.setText(capacidade);
				txtValorAltaEstacao.setText(valorAltaEstacao);
				txtValorBaixaEstacao.setText(valorBaixaEstacao);
			}
		});
		tblConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Localiza\u00E7\u00E3o", "Capacidade", "Valor Alta Esta\u00E7\u00E3o", "Valor Baixa Esta\u00E7\u00E3o"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tblConsulta);
		panel_2.setLayout(gl_panel_2);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chale cha = new Chale();
				ChaleController controller = new ChaleController();
				cha.setCodChale(txtCodChale.getText());
				cha.setLocalizacao(txtLocalizacao.getText());
				cha.setCapacidade(Integer.parseInt(txtCapacidade.getText()));
				cha.setValorAltaEstacao(Double.parseDouble(txtValorAltaEstacao.getText()));
				cha.setValorBaixaEstacao(Double.parseDouble(txtValorBaixaEstacao.getText()));
				Chale c = new Chale();
				c.setCodChale(cha.getCodChale());
				c = controller.pesquisarPorCodigo(c.getCodChale());
				if(c != null) {
					txtCodChale.setText(c.getCodChale());
					txtLocalizacao.setText(c.getLocalizacao());
					txtCapacidade.setText(Integer.toString(c.getCapacidade()));
					txtValorAltaEstacao.setText(Double.toString(c.getValorAltaEstacao()));
					txtValorBaixaEstacao.setText(Double.toString(c.getValorBaixaEstacao()));
					JOptionPane.showMessageDialog(null, "Chale com este código já existente");
				}
				else {
					lblMensagem.setText(controller.inserir(cha));
				}
			}
		});
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chale cha = new Chale();
				ChaleController controller = new ChaleController();
				cha.setCodChale(txtCodChale.getText());
				cha.setLocalizacao(txtLocalizacao.getText());
				cha.setCapacidade(Integer.parseInt(txtCapacidade.getText()));
				cha.setValorAltaEstacao(Double.parseDouble(txtValorAltaEstacao.getText()));
				cha.setValorBaixaEstacao(Double.parseDouble(txtValorBaixaEstacao.getText()));
				lblMensagem.setText(controller.alterar(cha));
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chale cha = new Chale();
				ChaleController controller = new ChaleController();
				cha.setCodChale(txtCodChale.getText());
				Object[] opcoes = { "SIM", "NAO" };
				int i = JOptionPane.showOptionDialog(null, "Deseja excluir esse Chalé?", "Exclusão",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
				if (JOptionPane.YES_OPTION == i) {
					lblMensagem.setText(controller.excluir(cha));
				}
			}
		});
		
		
		
		JButton btnListar = new JButton("Listar");
		btnListar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pesquisar();
			}
		});
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCodChale.setText("");
				txtLocalizacao.setText("");
				txtCapacidade.setText("");
				txtValorAltaEstacao.setText("");
				txtValorBaixaEstacao.setText("");
				DefaultTableModel tbm = (DefaultTableModel)tblConsulta.getModel();
				for (int i = tbm.getRowCount()-1; i >= 0; i--) {
					tbm.removeRow(i);
				}
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrmChale.this.dispose();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnInserir)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAlterar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExcluir)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnListar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLimpar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSair)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnAlterar)
							.addComponent(btnExcluir)
							.addComponent(btnListar)
							.addComponent(btnLimpar)
							.addComponent(btnSair))
						.addComponent(btnInserir, Alignment.TRAILING))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		
		JLabel lblLocalizao = new JLabel("Localiza\u00E7\u00E3o");
		
		JLabel lblCapacidade = new JLabel("Capacidade");
		
		JLabel lblValorAltaEstao = new JLabel("Valor Alta Esta\u00E7\u00E3o");
		
		JLabel lblValorBaixaEstao = new JLabel("Valor Baixa Esta\u00E7\u00E3o");
		
		txtCodChale = new JTextField();
		txtCodChale.setColumns(10);
		
		txtLocalizacao = new JTextField();
		txtLocalizacao.setColumns(10);
		
		txtCapacidade = new JTextField();
		txtCapacidade.setColumns(10);
		
		txtValorAltaEstacao = new JTextField();
		txtValorAltaEstacao.setColumns(10);
		
		txtValorBaixaEstacao = new JTextField();
		txtValorBaixaEstacao.setColumns(10);
		
		lblMensagem = new JLabel("Mensagem: ");
		lblMensagem.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblCdigo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCodChale, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblLocalizao)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtLocalizacao, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblCapacidade)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCapacidade, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblValorAltaEstao)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtValorAltaEstacao, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblValorBaixaEstao)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtValorBaixaEstacao, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))
						.addComponent(lblMensagem))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(0, 0, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCdigo)
						.addComponent(txtCodChale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocalizao)
						.addComponent(txtLocalizacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCapacidade)
						.addComponent(txtCapacidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValorAltaEstao)
						.addComponent(txtValorAltaEstacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValorBaixaEstao)
						.addComponent(txtValorBaixaEstacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblMensagem)
					.addGap(23))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
