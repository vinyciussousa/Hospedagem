package br.com.prog2.hospedagem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.prog2.hospedagem.controller.HospedagemController;
import br.com.prog2.hospedagem.controller.HospedagemServicoController;
import br.com.prog2.hospedagem.controller.TelefoneController;
import br.com.prog2.hospedagem.negocio.Hospedagem;
import br.com.prog2.hospedagem.negocio.HospedagemServico;
import br.com.prog2.hospedagem.negocio.Telefone;
import br.com.prog2.hospedagem.util.Util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;

public class FrmHospedagemServico extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodHospedagem;
	private JTextField txtCodServico;
	private JTextField txtValorServico;
	private JTable tblConsulta;
	private MaskFormatter mascaraData = null;
	private JFormattedTextField txtDataServico;
	private JLabel lblMensagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmHospedagemServico frame = new FrmHospedagemServico();
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
	public FrmHospedagemServico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		
		tblConsulta = new JTable();
		tblConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo da Hospedagem", "Data do Servi\u00E7o", "C\u00F3digo do Servi\u00E7o", "Valor do Servi\u00E7o"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tblConsulta);
		panel_2.setLayout(gl_panel_2);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				HospedagemServico i = new HospedagemServico();
				HospedagemServicoController controller = new HospedagemServicoController();
				i.setCodHospedagem(txtCodHospedagem.getText());
				int[] dataFormatada = Util.formatarDataDeGuiParaLocalDate(txtDataServico.getText());
				i.setDataServico(LocalDate.of(dataFormatada[2], dataFormatada[1], dataFormatada[0]));
				i.setCodServico(txtCodServico.getText());
				i.setValorServico(Double.parseDouble(txtValorServico.getText()));
				lblMensagem.setText(controller.inserir(i));
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HospedagemServico hos = new HospedagemServico();
				HospedagemServicoController controller = new HospedagemServicoController();
				hos.setCodHospedagem(txtCodHospedagem.getText());
				hos.setCodServico(txtCodServico.getText());
				Object[] opcoes = { "SIM", "NÃO" };
				int i = JOptionPane.showOptionDialog(null, "Deseja excluir o Serviço desta Hospedagem?", "Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
				if(JOptionPane.YES_OPTION == i) {
					lblMensagem.setText(controller.excluir(hos));
				}
			}
		});
		
		JButton btnListar = new JButton("Listar");
		btnListar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<HospedagemServico> listaHos = new ArrayList();
				HospedagemServicoController controller = new HospedagemServicoController();
				listaHos = controller.listarTodos();
				DefaultTableModel tbm = (DefaultTableModel)tblConsulta.getModel();
				for(int i = tbm.getRowCount()-1;i >= 0;i--) {
					tbm.removeRow(i);
				}
				int i = 0;
				for (HospedagemServico hos : listaHos) {
					tbm.addRow(new String[1]);
					tblConsulta.setValueAt(hos.getCodHospedagem(), i, 0);
					tblConsulta.setValueAt(hos.getDataServico(), i, 1);
					tblConsulta.setValueAt(hos.getCodServico(), i, 2);
					tblConsulta.setValueAt(hos.getValorServico(), i, 3);
					i++;
				}
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmHospedagemServico.this.dispose();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(75)
					.addComponent(btnCriar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExcluir)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnListar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSair)
					.addContainerGap(133, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(15, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCriar)
						.addComponent(btnExcluir)
						.addComponent(btnListar)
						.addComponent(btnSair))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblCdigoDaHospedagem = new JLabel("C\u00F3digo da Hospedagem");
		
		JLabel lblCdigoDoServio = new JLabel("C\u00F3digo do Servi\u00E7o");
		
		JLabel lblDataDoServio = new JLabel("Data do Servi\u00E7o");
		
		JLabel lblValorDoServio = new JLabel("Valor do Servi\u00E7o");
		
		txtCodHospedagem = new JTextField();
		txtCodHospedagem.setColumns(10);
		
		txtCodServico = new JTextField();
		txtCodServico.setColumns(10);
		
		txtValorServico = new JTextField();
		txtValorServico.setColumns(10);
		
		try {
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		}
		
		txtDataServico = new JFormattedTextField(mascaraData);
		
		lblMensagem = new JLabel("Mensagem:");
		lblMensagem.setFont(new Font("Tahoma", Font.BOLD, 11));
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
							.addComponent(lblCdigoDoServio)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCodServico, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblDataDoServio)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtDataServico, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblValorDoServio)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtValorServico, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE))
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
						.addComponent(lblCdigoDoServio)
						.addComponent(txtCodServico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataDoServio)
						.addComponent(txtDataServico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValorDoServio)
						.addComponent(txtValorServico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblMensagem)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
