package br.com.prog2.hospedagem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.prog2.hospedagem.controller.HospedagemController;
import br.com.prog2.hospedagem.negocio.Hospedagem;
import br.com.prog2.hospedagem.util.Util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmHospedagem extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodHospedagem;
	private JTextField txtCodChale;
	private JTextField txtCodCliente;
	private JTextField txtEstado;
	private JTextField txtQtdPessoas;
	private JTextField txtDesconto;
	private JTextField txtValorFinal;
	private JTable tblConsulta;
	private MaskFormatter mascaraData = null;
	private JFormattedTextField txtDataInicio;
	private JFormattedTextField txtDataFim;
	private JLabel lblMensagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmHospedagem frame = new FrmHospedagem();
					frame.setTitle("Criação de Hospedagem.");
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
	public FrmHospedagem() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 624, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCriar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hospedagem hos = new Hospedagem();
				HospedagemController controller = new HospedagemController();
				hos.setCodHospedagem(txtCodHospedagem.getText());
				hos.setCodChale(txtCodChale.getText());
				hos.setCodCliente(txtCodCliente.getText());
				hos.setEstado(txtEstado.getText());
				int[] dataFormatada = Util.formatarDataDeGuiParaLocalDate(txtDataInicio.getText());
				hos.setDataInicio(LocalDate.of(dataFormatada[2], dataFormatada[1], dataFormatada[0]));
				int[] dataFormatada2 = Util.formatarDataDeGuiParaLocalDate(txtDataFim.getText());
				hos.setDataFim(LocalDate.of(dataFormatada2[2], dataFormatada2[1], dataFormatada2[0]));
				hos.setQtdPessoas(Integer.parseInt(txtQtdPessoas.getText()));
				hos.setDesconto(Double.parseDouble(txtDesconto.getText()));
				hos.setValorFinal(Double.parseDouble(txtValorFinal.getText()));
				lblMensagem.setText(controller.inserir(hos));
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hospedagem hos = new Hospedagem();
				HospedagemController controller = new HospedagemController();
				hos.setCodHospedagem(txtCodHospedagem.getText());
				Object[] opcoes = { "SIM", "NÃO" };
				int i = JOptionPane.showOptionDialog(null, "Deseja excluir esta Hospedagem?", "Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
				if(JOptionPane.YES_OPTION == i) {
					lblMensagem.setText(controller.excluir(hos));
				}
			}
		});
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hospedagem hos = new Hospedagem();
				HospedagemController controller = new HospedagemController();
				hos.setCodHospedagem(txtCodHospedagem.getText());
				hos.setCodChale(txtCodChale.getText());
				hos.setCodCliente(txtCodCliente.getText());
				hos.setEstado(txtEstado.getText());
				int[] dataFormatada = Util.formatarDataDeGuiParaLocalDate(txtDataInicio.getText());
				hos.setDataInicio(LocalDate.of(dataFormatada[2], dataFormatada[1], dataFormatada[0]));
				int[] dataFormatada2 = Util.formatarDataDeGuiParaLocalDate(txtDataFim.getText());
				hos.setDataFim(LocalDate.of(dataFormatada2[2], dataFormatada2[1], dataFormatada2[0]));
				hos.setQtdPessoas(Integer.parseInt(txtQtdPessoas.getText()));
				hos.setDesconto(Double.parseDouble(txtDesconto.getText()));
				hos.setValorFinal(Double.parseDouble(txtValorFinal.getText()));
				lblMensagem.setText(controller.alterar(hos));
			}
		});
		
		JButton btnBuscarChal = new JButton("Buscar Chal\u00E9");
		btnBuscarChal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Hospedagem> listaHos = new ArrayList();
				HospedagemController controller = new HospedagemController();
				listaHos = controller.pesquisarPorCodChale(txtCodChale.getText());
				DefaultTableModel tbm = (DefaultTableModel)tblConsulta.getModel();
				for(int i = tbm.getRowCount()-1;i >= 0;i--) {
					tbm.removeRow(i);
				}
				int i = 0;
				if(listaHos != null) {
					for (Hospedagem hos : listaHos) {
						tbm.addRow(new String[1]);
						tblConsulta.setValueAt(hos.getCodHospedagem(), i, 0);
						tblConsulta.setValueAt(hos.getCodChale(), i, 1);
						tblConsulta.setValueAt(hos.getCodCliente(), i, 2);
						tblConsulta.setValueAt(hos.getEstado(), i, 3);
						tblConsulta.setValueAt(hos.getDataInicio(), i, 4);
						tblConsulta.setValueAt(hos.getDataFim(), i, 5);
						tblConsulta.setValueAt(hos.getQtdPessoas(), i, 6);
						tblConsulta.setValueAt(hos.getDesconto(), i, 7);
						tblConsulta.setValueAt(hos.getValorFinal(), i, 8);
						i++;
					}
				}	
			}
		});
		
		JButton btnBuscarCliente = new JButton("Buscar Cliente");
		btnBuscarCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				List<Hospedagem> listaHos = new ArrayList();
				HospedagemController controller = new HospedagemController();
				listaHos = controller.pesquisarPorCodCliente(txtCodCliente.getText());
				DefaultTableModel tbm = (DefaultTableModel)tblConsulta.getModel();
				for(int i = tbm.getRowCount()-1;i >= 0;i--) {
					tbm.removeRow(i);
				}
				int i = 0;
				if(listaHos != null) {
					for (Hospedagem hos : listaHos) {
						tbm.addRow(new String[1]);
						tblConsulta.setValueAt(hos.getCodHospedagem(), i, 0);
						tblConsulta.setValueAt(hos.getCodChale(), i, 1);
						tblConsulta.setValueAt(hos.getCodCliente(), i, 2);
						tblConsulta.setValueAt(hos.getEstado(), i, 3);
						tblConsulta.setValueAt(hos.getDataInicio(), i, 4);
						tblConsulta.setValueAt(hos.getDataFim(), i, 5);
						tblConsulta.setValueAt(hos.getQtdPessoas(), i, 6);
						tblConsulta.setValueAt(hos.getDesconto(), i, 7);
						tblConsulta.setValueAt(hos.getValorFinal(), i, 8);
						i++;
					}
				}
			}
		});
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Hospedagem> listaHos = new ArrayList();
				HospedagemController controller = new HospedagemController();
				listaHos = controller.listarTodos();
				DefaultTableModel tbm = (DefaultTableModel)tblConsulta.getModel();
				for(int i = tbm.getRowCount()-1;i >= 0;i--) {
					tbm.removeRow(i);
				}
				int i = 0;
				for (Hospedagem hos : listaHos) {
					tbm.addRow(new String[1]);
					tblConsulta.setValueAt(hos.getCodHospedagem(), i, 0);
					tblConsulta.setValueAt(hos.getCodChale(), i, 1);
					tblConsulta.setValueAt(hos.getCodCliente(), i, 2);
					tblConsulta.setValueAt(hos.getEstado(), i, 3);
					tblConsulta.setValueAt(hos.getDataInicio(), i, 4);
					tblConsulta.setValueAt(hos.getDataFim(), i, 5);
					tblConsulta.setValueAt(hos.getQtdPessoas(), i, 6);
					tblConsulta.setValueAt(hos.getDesconto(), i, 7);
					tblConsulta.setValueAt(hos.getValorFinal(), i, 8);
					i++;
				}
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrmHospedagem.this.dispose();
			}
		});
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCodHospedagem.setText("");
				txtCodChale.setText("");
				txtCodCliente.setText("");
				txtEstado.setText("");
				txtDataInicio.setText("");
				txtDataFim.setText("");
				txtQtdPessoas.setText("");
				txtDesconto.setText("");
				txtValorFinal.setText("");
				DefaultTableModel tbm = (DefaultTableModel)tblConsulta.getModel();
				for(int i = tbm.getRowCount()-1;i >= 0; i--) {
					tbm.removeRow(i);
				}
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnCriar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExcluir)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAlterar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBuscarChal)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBuscarCliente)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPesquisar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLimpar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSair)
					.addContainerGap(52, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(12, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCriar)
						.addComponent(btnExcluir)
						.addComponent(btnAlterar)
						.addComponent(btnBuscarChal)
						.addComponent(btnBuscarCliente)
						.addComponent(btnPesquisar)
						.addComponent(btnSair)
						.addComponent(btnLimpar))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
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
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tblConsulta = new JTable();
		tblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Integer linha = tblConsulta.getSelectedRow();
				String codHospedagem = tblConsulta.getValueAt(linha, 0).toString();
				String codChale = tblConsulta.getValueAt(linha, 1).toString();
				String codCliente = tblConsulta.getValueAt(linha, 2).toString();
				String estado = tblConsulta.getValueAt(linha, 3).toString();
				String dataInicio = tblConsulta.getValueAt(linha, 4).toString();
				DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate localDate = LocalDate.parse(dataInicio, dateTimeFormatter);
				dataInicio = Util.formatarDataDeLocalDateParaGui(localDate);
				String dataFim = tblConsulta.getValueAt(linha, 5).toString();
				DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate localDate2 = LocalDate.parse(dataFim, dateTimeFormatter2);
				dataFim = Util.formatarDataDeLocalDateParaGui(localDate2);
				String qtdPessoas = tblConsulta.getValueAt(linha, 6).toString();
				String desconto = tblConsulta.getValueAt(linha, 7).toString();
				String valorFinal = tblConsulta.getValueAt(linha, 8).toString();
				txtCodHospedagem.setText(codHospedagem);
				txtCodChale.setText(codChale);
				txtCodCliente.setText(codCliente);
				txtEstado.setText(estado);
				txtDataInicio.setText(dataInicio);
				txtDataFim.setText(dataFim);
				txtQtdPessoas.setText(qtdPessoas);
				txtDesconto.setText(desconto);
				txtValorFinal.setText(valorFinal);
			}
		});
		tblConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo da Hospedagem", "C\u00F3digo do Chal\u00E9", "C\u00F3digo do Cliente", "Estado", "Data Inicio", "Data Fim", "Quantidade de Pessoas", "Desconto", "Valor Final"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Integer.class, Object.class, Integer.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tblConsulta);
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblCdigoDaHospedagem = new JLabel("C\u00F3digo da Hospedagem");
		
		JLabel lblCdigoDoChale = new JLabel("C\u00F3digo do Chale");
		
		JLabel lblCdigoDoCliente = new JLabel("C\u00F3digo do Cliente");
		
		JLabel lblEstado = new JLabel("Estado");
		
		JLabel lblDataInicio = new JLabel("Data Inicio");
		
		JLabel lblDataFim = new JLabel("Data Fim");
		
		JLabel lblQuantidadeDePessoas = new JLabel("Quantidade de Pessoas");
		
		JLabel lblDesconto = new JLabel("Desconto");
		
		JLabel lblValorFinal = new JLabel("Valor Final");
		
		lblMensagem = new JLabel("Mensagem");
		lblMensagem.setForeground(Color.BLUE);
		
		txtCodHospedagem = new JTextField();
		txtCodHospedagem.setColumns(10);
		
		txtCodChale = new JTextField();
		txtCodChale.setColumns(10);
		
		txtCodCliente = new JTextField();
		txtCodCliente.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		
		txtQtdPessoas = new JTextField();
		txtQtdPessoas.setColumns(10);
		
		txtDesconto = new JTextField();
		txtDesconto.setColumns(10);
		
		txtValorFinal = new JTextField();
		txtValorFinal.setColumns(10);
		
		try {
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		}
		
		txtDataInicio = new JFormattedTextField(mascaraData);
		
		txtDataFim = new JFormattedTextField(mascaraData);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblCdigoDaHospedagem)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCodHospedagem, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblCdigoDoChale)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCodChale, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblCdigoDoCliente)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCodCliente, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblEstado)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtEstado, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblDataInicio)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtDataInicio, GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblDataFim)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtDataFim, GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblQuantidadeDePessoas)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtQtdPessoas, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblDesconto)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtDesconto, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblValorFinal)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtValorFinal, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
						.addComponent(lblMensagem))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCdigoDaHospedagem)
						.addComponent(txtCodHospedagem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCdigoDoChale)
						.addComponent(txtCodChale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCdigoDoCliente)
						.addComponent(txtCodCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstado)
						.addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataInicio)
						.addComponent(txtDataInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataFim)
						.addComponent(txtDataFim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuantidadeDePessoas)
						.addComponent(txtQtdPessoas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDesconto)
						.addComponent(txtDesconto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValorFinal)
						.addComponent(txtValorFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblMensagem)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
