package br.com.prog2.hospedagem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.prog2.hospedagem.controller.HospedagemController;
import br.com.prog2.hospedagem.controller.ItemController;
import br.com.prog2.hospedagem.controller.TelefoneController;
import br.com.prog2.hospedagem.negocio.Hospedagem;
import br.com.prog2.hospedagem.negocio.Item;
import br.com.prog2.hospedagem.negocio.Telefone;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmTelefone extends JFrame {

	private JPanel contentPane;
	private JTextField txtTelefone;
	private JTextField txtCodCliente;
	private JTextField txtTipoTelefone;
	private JTable tblConsulta;
	private JLabel lblMensagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTelefone frame = new FrmTelefone();
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
	public FrmTelefone() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		tblConsulta = new JTable();
		tblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer linha = tblConsulta.getSelectedRow();
				String telefone = tblConsulta.getValueAt(linha, 0).toString();
				String codCliente = tblConsulta.getValueAt(linha, 1).toString();
				String tipoTelefone = tblConsulta.getValueAt(linha, 2).toString();
				txtTelefone.setText(telefone);
				txtCodCliente.setText(codCliente);
				txtTipoTelefone.setText(tipoTelefone);
			}
		});
		tblConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Telefone", "C\u00F3digo do Cliente", "Tipo de Telefone"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
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
				Telefone i = new Telefone();
				TelefoneController controller = new TelefoneController();
				i.setTelefone(txtTelefone.getText());
				i.setCodCliente(txtCodCliente.getText());
				i.setTipoTelefone(txtTipoTelefone.getText());
				Telefone i2 = new Telefone();
				i2.setTelefone(i.getTelefone());
				i2 = controller.pesquisarPorTelefone(i2.getTelefone());
				if(i2 != null) {
					txtTelefone.setText(i2.getTelefone());
					txtCodCliente.setText(i2.getCodCliente());
					txtTipoTelefone.setText(i2.getTipoTelefone());
					JOptionPane.showMessageDialog(null, "Este telefone já esta cadastrado");
				}
				else {
					lblMensagem.setText(controller.inserir(i));
				}
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Telefone i = new Telefone();
				TelefoneController controller = new TelefoneController();
				i.setTelefone(txtTelefone.getText());
				Object[] opcoes = { "SIM", "NAO" };
				int i2 = JOptionPane.showOptionDialog(null, "Deseja excluir esse Telefone?", "Exclusão",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
				if (JOptionPane.YES_OPTION == i2) {
					lblMensagem.setText(controller.excluir(i));
				}
			}
		});
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnBuscaPorCliente = new JButton("Busca por Cliente");
		btnBuscaPorCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Telefone> listaTel = new ArrayList();
				TelefoneController controller = new TelefoneController();
				listaTel = controller.pesquisarPorCodCliente(txtCodCliente.getText());
				DefaultTableModel tbm = (DefaultTableModel)tblConsulta.getModel();
				for(int i = tbm.getRowCount()-1;i >= 0;i--) {
					tbm.removeRow(i);
				}
				int i = 0;
				if(listaTel != null) {
					for (Telefone tel : listaTel) {
						tbm.addRow(new String[1]);
						tblConsulta.setValueAt(tel.getTelefone(), i, 0);
						tblConsulta.setValueAt(tel.getCodCliente(), i, 1);
						tblConsulta.setValueAt(tel.getTipoTelefone(), i, 2);
						i++;
					}
				}
			}
		});
		btnBuscaPorCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrmTelefone.this.dispose();
			}
		});
		
		JButton btnListar = new JButton("Listar");
		btnListar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Telefone> listaTelefone = new ArrayList();
				TelefoneController controller = new TelefoneController();
				listaTelefone = controller.listarTodos();
				DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
				for (int i = tbm.getRowCount()-1; i >= 0; i--) {
					tbm.removeRow(i);
				}
				int i = 0;
				for (Telefone i2: listaTelefone) {
					tbm.addRow(new String[1]);
					tblConsulta.setValueAt(i2.getTelefone(), i, 0);
					tblConsulta.setValueAt(i2.getCodCliente(), i, 1);
					tblConsulta.setValueAt(i2.getTipoTelefone(), i, 2);
					i++;
				
			}
			}
		}
		);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(13)
					.addComponent(btnInserir)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExcluir)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBuscaPorCliente)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnListar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSair)
					.addContainerGap(66, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInserir)
						.addComponent(btnExcluir)
						.addComponent(btnBuscaPorCliente)
						.addComponent(btnListar)
						.addComponent(btnSair))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNmeroDeTelefone = new JLabel("N\u00FAmero de Telefone");
		
		JLabel lblCdigoDoCliente = new JLabel("C\u00F3digo do Cliente");
		
		JLabel lblTipoDoTelefone = new JLabel("Tipo do Telefone");
		
		lblMensagem = new JLabel("Mensagem:");
		lblMensagem.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		
		txtCodCliente = new JTextField();
		txtCodCliente.setColumns(10);
		
		txtTipoTelefone = new JTextField();
		txtTipoTelefone.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNmeroDeTelefone)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblCdigoDoCliente)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCodCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblTipoDoTelefone)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTipoTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblMensagem))
					.addContainerGap(207, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNmeroDeTelefone)
						.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCdigoDoCliente)
						.addComponent(txtCodCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoDoTelefone)
						.addComponent(txtTipoTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addComponent(lblMensagem)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

}
