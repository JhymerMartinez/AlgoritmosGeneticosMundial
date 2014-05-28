package ec.unl.edu.visual;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import ec.unl.edu.clases.Equipo;
import ec.unl.edu.operaciones.Operaciones;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaEdicion extends JFrame {

	JPanel contentPane;
	JTextField txtIngresarNumCopas;
	JPanel panel;
	JLabel label_1;
	JLabel label_4;
	JLabel label_5;
	JLabel label_6;
	JLabel label_8;
	JLabel label_10;
	JLabel label_12;
	JComboBox cboxSeleccionarAntepenultimo;
	JComboBox cboxSeleccionarPenultimo;
	JComboBox cboxSeleccionarUltimo;
	JLabel lblNombreEquipo;
	JButton btnCancelar;
	JButton btnGuardar;
	Operaciones operaciones;
	JLabel lblGrupo;
	Equipo equipo_nuevo;
	Integer indice;
	ArrayList<Equipo> listaEquiposMundial;
	VentanaPrincipal ventanaPrincipal;
	Equipo equipo;
	ArrayList<Integer> lista_ranking_fifa;
	JTextField txtRanking;

	public ArrayList<Equipo> getListaEquiposMundial() {
		return listaEquiposMundial;
	}

	public void setListaEquiposMundial(ArrayList<Equipo> listaEquiposMundial) {
		this.listaEquiposMundial = listaEquiposMundial;
	}

	public Integer getIndice() {
		return indice;
	}

	public void setIndice(Integer indice) {
		this.indice = indice;
	}

	public ArrayList<Integer> getLista_ranking_fifa() {
		return lista_ranking_fifa;
	}

	public void setLista_ranking_fifa(ArrayList<Integer> lista_ranking_fifa) {
		this.lista_ranking_fifa = lista_ranking_fifa;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	/**
	 * Create the frame.
	 */
	public VentanaEdicion() {

		operaciones = new Operaciones();

		setDefaultCloseOperation(0);
		setBounds(100, 100, 659, 517);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(76, 66, 498, 325);
		contentPane.add(panel);

		label_1 = new JLabel("Ranking FIFA:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(102, 44, 86, 23);
		panel.add(label_1);

		label_4 = new JLabel("Grupo:");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(143, 78, 45, 24);
		panel.add(label_4);

		label_5 = new JLabel("RESULTADOS ULTIMOS 3 ENCUENTROS");
		label_5.setForeground(new Color(0, 128, 128));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(55, 155, 317, 16);
		panel.add(label_5);

		label_6 = new JLabel("Antepenúltimo Partido:");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(55, 189, 132, 23);
		panel.add(label_6);

		label_8 = new JLabel("Penúltimo Partido:");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(74, 229, 112, 23);
		panel.add(label_8);

		label_10 = new JLabel("Último Partido:");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setBounds(91, 271, 95, 23);
		panel.add(label_10);

		label_12 = new JLabel("Copas mundiales:");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(93, 113, 95, 24);
		panel.add(label_12);

		txtIngresarNumCopas = new JTextField();
		txtIngresarNumCopas.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtIngresarNumCopas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char car = e.getKeyChar();
				if ((car < '0' || car > '9'))
					e.consume();

			}
		});
		txtIngresarNumCopas.setColumns(10);
		txtIngresarNumCopas.setBounds(198, 115, 139, 29);
		panel.add(txtIngresarNumCopas);

		cboxSeleccionarAntepenultimo = new JComboBox();
		cboxSeleccionarAntepenultimo.setBounds(197, 182, 138, 28);
		panel.add(cboxSeleccionarAntepenultimo);

		cboxSeleccionarPenultimo = new JComboBox();
		cboxSeleccionarPenultimo.setBounds(196, 221, 139, 29);
		panel.add(cboxSeleccionarPenultimo);

		cboxSeleccionarUltimo = new JComboBox();
		cboxSeleccionarUltimo.setBounds(196, 263, 139, 29);
		panel.add(cboxSeleccionarUltimo);

		lblGrupo = new JLabel("");
		lblGrupo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGrupo.setBounds(198, 78, 116, 24);
		panel.add(lblGrupo);

		txtRanking = new JTextField();
		txtRanking.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtRanking.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char car = e.getKeyChar();
				if ((car < '0' || car > '9'))
					e.consume();

			}
		});

		txtRanking.setColumns(10);
		txtRanking.setBounds(198, 37, 139, 28);
		panel.add(txtRanking);
		
		JLabel lblmaximoDigitos = new JLabel("(máximo 3 digitos)");
		lblmaximoDigitos.setBounds(351, 48, 118, 14);
		panel.add(lblmaximoDigitos);
		
		JLabel lblmximoDigitos = new JLabel("(máximo 3 digitos)");
		lblmximoDigitos.setBounds(351, 118, 118, 14);
		panel.add(lblmximoDigitos);

		btnCancelar = new JButton(" <<< Atras");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ventanaPrincipal = new VentanaPrincipal();
				ventanaPrincipal.setIndiceRespuesta(indice);
				ventanaPrincipal.setVisible(true);
				ventanaPrincipal.setLocationRelativeTo(null);
				setVisible(false);

			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancelar.setBounds(434, 413, 131, 44);
		contentPane.add(btnCancelar);

		lblNombreEquipo = new JLabel("¿?");
		lblNombreEquipo.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {

				// se obtiene el equipo enviado de la Ventana principal
				equipo = getEquipo();

				// obtiene nombre equipo
				lblNombreEquipo.setText(equipo.getNombre());

				txtRanking.setText(String.valueOf(equipo.getRanking()));
				txtIngresarNumCopas.setText(String.valueOf(equipo
						.getNumero_copas()));

				lblGrupo.setText(String.valueOf(equipo.getGrupo()));

				if (equipo.getAntepenultimo_partido() == -1) {
					cboxSeleccionarAntepenultimo.addItem("Perdido");
					cboxSeleccionarAntepenultimo.addItem("Empatado");
					cboxSeleccionarAntepenultimo.addItem("Ganado");
				}

				if (equipo.getAntepenultimo_partido() == 0) {
					cboxSeleccionarAntepenultimo.addItem("Empatado");
					cboxSeleccionarAntepenultimo.addItem("Perdido");
					cboxSeleccionarAntepenultimo.addItem("Ganado");
				}
				if (equipo.getAntepenultimo_partido() == 1) {
					cboxSeleccionarAntepenultimo.addItem("Ganado");
					cboxSeleccionarAntepenultimo.addItem("Empatado");
					cboxSeleccionarAntepenultimo.addItem("Perdido");

				}

				if (equipo.getPenultimo_partido() == -1) {
					cboxSeleccionarPenultimo.addItem("Perdido");
					cboxSeleccionarPenultimo.addItem("Empatado");
					cboxSeleccionarPenultimo.addItem("Ganado");
				}

				if (equipo.getPenultimo_partido() == -0) {
					cboxSeleccionarPenultimo.addItem("Empatado");
					cboxSeleccionarPenultimo.addItem("Perdido");
					cboxSeleccionarPenultimo.addItem("Ganado");
				}
				if (equipo.getPenultimo_partido() == 1) {
					cboxSeleccionarPenultimo.addItem("Ganado");
					cboxSeleccionarPenultimo.addItem("Empatado");
					cboxSeleccionarPenultimo.addItem("Perdido");

				}

				if (equipo.getUltimo_partido() == -1) {
					cboxSeleccionarUltimo.addItem("Perdido");
					cboxSeleccionarUltimo.addItem("Empatado");
					cboxSeleccionarUltimo.addItem("Ganado");
				}

				if (equipo.getUltimo_partido() == 0) {
					cboxSeleccionarUltimo.addItem("Empatado");
					cboxSeleccionarUltimo.addItem("Perdido");
					cboxSeleccionarUltimo.addItem("Ganado");
				}
				if (equipo.getUltimo_partido() == 1) {
					cboxSeleccionarUltimo.addItem("Ganado");
					cboxSeleccionarUltimo.addItem("Empatado");
					cboxSeleccionarUltimo.addItem("Perdido");

				}

			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		lblNombreEquipo.setBounds(217, 19, 221, 36);
		contentPane.add(lblNombreEquipo);
		lblNombreEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreEquipo.setForeground(new Color(51, 102, 153));
		lblNombreEquipo.setFont(new Font("Tahoma", Font.BOLD, 18));

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtIngresarNumCopas.getText().equals("")
						|| txtRanking.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"No deben quedar campos vacios", "Advertencia",
							JOptionPane.WARNING_MESSAGE);

				} else {

					if (txtRanking.getText().length() > 3
							|| txtIngresarNumCopas.getText().length() > 3) {
						JOptionPane.showMessageDialog(null,
								"Debe ingresar un máximo de 3 digitos en los campos",
								"Advertencia", JOptionPane.WARNING_MESSAGE);
					} else {

						equipo_nuevo = new Equipo();

						equipo_nuevo.setNombre(getEquipo().getNombre());
						equipo_nuevo.setGrupo(getEquipo().getGrupo());
						equipo_nuevo.setNumero_copas(Integer
								.parseInt(txtIngresarNumCopas.getText()));
						equipo_nuevo.setRanking(Integer.parseInt(txtRanking
								.getText()));

						String antep = String
								.valueOf(cboxSeleccionarAntepenultimo
										.getSelectedItem());
						if (antep.equals("Ganado")) {
							equipo_nuevo.setAntepenultimo_partido(1);
						}
						if (antep.equals("Empatado")) {
							equipo_nuevo.setAntepenultimo_partido(0);
						}
						if (antep.equals("Perdido")) {
							equipo_nuevo.setAntepenultimo_partido(-1);
						}

						String penul = String.valueOf(cboxSeleccionarPenultimo
								.getSelectedItem());
						if (penul.equals("Ganado")) {
							equipo_nuevo.setPenultimo_partido(1);
						}
						if (penul.equals("Empatado")) {
							equipo_nuevo.setPenultimo_partido(0);
						}
						if (penul.equals("Perdido")) {
							equipo_nuevo.setPenultimo_partido(-1);
						}

						String ultim = String.valueOf(cboxSeleccionarUltimo
								.getSelectedItem());
						if (ultim.equals("Ganado")) {
							equipo_nuevo.setUltimo_partido(1);
						}
						if (ultim.equals("Empatado")) {
							equipo_nuevo.setUltimo_partido(0);
						}
						if (ultim.equals("Perdido")) {
							equipo_nuevo.setUltimo_partido(-1);
						}

						// graba nuevamente datos modificados
						operaciones.escribirEquiposModificados(getIndice(),
								equipo_nuevo, listaEquiposMundial);
						JOptionPane
								.showMessageDialog(null,
										"Los valores fueron actualizados correctamente");
					}

				}
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnGuardar.setBounds(97, 413, 131, 44);
		contentPane.add(btnGuardar);

	}
}
