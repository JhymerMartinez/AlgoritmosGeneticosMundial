package ec.unl.edu.visual;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import org.jgap.Configuration;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;

import ec.unl.edu.ag.TestEquipoFitness;
import ec.unl.edu.clases.Equipo;
import ec.unl.edu.operaciones.Operaciones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.ImageIcon;

public class VentanaPrincipal extends JFrame {

	JPanel contentPane;
	JTextField txtEquipo1;
	JTextField txtEquipo2;
	JTextField txtEquipo3;
	JTextField txtEquipo4;
	JLabel lblAlgoritmosGenticos;
	JLabel lblListaDeEquipos;
	JScrollPane scrollPane;
	DefaultListModel modeloLista;
	Operaciones operaciones;
	ArrayList<Equipo> lista_equipos_archivo;
	JList listEquiposMundial;
	JPanel panel;
	JLabel lblEquipo;
	JLabel lblEquipo_1;
	JLabel lblEquipo_2;
	JLabel lblEquipo_3;
	JLabel lblMejoresEquipos;
	JPanel panel_1;
	JLabel salida_nombreEquipo;
	JLabel lblRankingFifa;
	JLabel salida_RankingFIFA;
	JLabel salida_grupo;
	JLabel lblResultadosUltimos;
	JLabel lblPrimerPartido;
	JLabel salida_antepenultimo;
	JLabel lblSegundoPartido;
	JLabel salida_penultimo;
	JLabel lblTercero;
	JLabel salida_ultimo;
	JButton btnModificarValores;
	JButton btnObtener;
	JLabel lblGrupo;
	JLabel lblNumeroDeCopas;
	JLabel salida_copas;
	Equipo equipo;
	JLabel lblBandera;
	JPanel panel_2;
	JButton btnLimpiar;
	Equipo equipoRespuesta;
	Integer indiceRespuesta;
	JTextArea txtAreaConsola;
	JPanel panel_3;

	public Integer getIndiceRespuesta() {
		return indiceRespuesta;
	}

	public void setIndiceRespuesta(Integer indiceRespuesta) {
		this.indiceRespuesta = indiceRespuesta;
	}

	public Equipo getEquipoRespuesta() {
		return equipoRespuesta;
	}

	public void setEquipoRespuesta(Equipo equipoRespuesta) {
		this.equipoRespuesta = equipoRespuesta;
	}

	public VentanaPrincipal() {
		
		try {
			UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel");
			//UIManager.setLookAndFeel("napkin.NapkinLookAndFeel");
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1086, 717);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblListaDeEquipos = new JLabel("Lista de Equipos");
		lblListaDeEquipos.setForeground(new Color(128, 0, 0));
		lblListaDeEquipos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblListaDeEquipos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeEquipos.setBounds(44, 89, 133, 19);
		contentPane.add(lblListaDeEquipos);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 120, 175, 332);
		contentPane.add(scrollPane);

		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(754, 120, 277, 277);
		contentPane.add(panel);
		panel.setLayout(null);

		lblEquipo = new JLabel("Equipo 1:");
		lblEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo.setBounds(6, 24, 71, 16);
		panel.add(lblEquipo);

		lblEquipo_1 = new JLabel("Equipo 2:");
		lblEquipo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo_1.setBounds(6, 69, 71, 16);
		panel.add(lblEquipo_1);

		lblEquipo_2 = new JLabel("Equipo 3:");
		lblEquipo_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo_2.setBounds(6, 110, 71, 16);
		panel.add(lblEquipo_2);

		lblEquipo_3 = new JLabel("Equipo 4:");
		lblEquipo_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo_3.setBounds(6, 156, 71, 16);
		panel.add(lblEquipo_3);

		txtEquipo1 = new JTextField();
		txtEquipo1.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtEquipo1.setEditable(false);
		txtEquipo1.setBounds(89, 18, 167, 28);
		panel.add(txtEquipo1);
		txtEquipo1.setColumns(10);

		txtEquipo2 = new JTextField();
		txtEquipo2.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtEquipo2.setEditable(false);
		txtEquipo2.setColumns(10);
		txtEquipo2.setBounds(89, 63, 167, 28);
		panel.add(txtEquipo2);

		txtEquipo3 = new JTextField();
		txtEquipo3.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtEquipo3.setEditable(false);
		txtEquipo3.setColumns(10);
		txtEquipo3.setBounds(89, 104, 167, 28);
		panel.add(txtEquipo3);

		txtEquipo4 = new JTextField();
		txtEquipo4.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtEquipo4.setEditable(false);
		txtEquipo4.setColumns(10);
		txtEquipo4.setBounds(89, 150, 167, 28);
		panel.add(txtEquipo4);

		btnObtener = new JButton("Obtener");
		btnObtener.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnObtener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// llamado a la clase Fitness
				TestEquipoFitness test = new TestEquipoFitness();

				try {

					test.inicializar(" ");
					test.pruebaSeleccionarMejoresEquipos();
					String valorConsola = test.presentarRespuesta();

					txtAreaConsola.setText(valorConsola);

					ArrayList<String> resultados = test.getRespuestaVista();
					txtEquipo1.setText(resultados.get(0));
					txtEquipo2.setText(resultados.get(1));
					txtEquipo3.setText(resultados.get(2));
					txtEquipo4.setText(resultados.get(3));

					Configuration.reset();

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		btnObtener.setBounds(73, 203, 144, 54);
		panel.add(btnObtener);

		lblMejoresEquipos = new JLabel("Mejores Equipos");
		lblMejoresEquipos.setForeground(new Color(204, 0, 0));
		lblMejoresEquipos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMejoresEquipos.setBounds(835, 84, 143, 28);
		contentPane.add(lblMejoresEquipos);
		lblMejoresEquipos.setHorizontalAlignment(SwingConstants.CENTER);

		panel_1 = new JPanel();
		panel_1.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(255, 89, 466, 393);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		salida_nombreEquipo = new JLabel("");
		salida_nombreEquipo.setForeground(new Color(51, 102, 153));
		salida_nombreEquipo.setBounds(142, 10, 221, 36);
		panel_1.add(salida_nombreEquipo);
		salida_nombreEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		salida_nombreEquipo.setFont(new Font("Tahoma", Font.BOLD, 20));

		lblRankingFifa = new JLabel("Ranking FIFA:");
		lblRankingFifa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRankingFifa.setBounds(107, 58, 86, 23);
		panel_1.add(lblRankingFifa);
		lblRankingFifa.setHorizontalAlignment(SwingConstants.CENTER);

		salida_RankingFIFA = new JLabel("");
		salida_RankingFIFA.setBounds(215, 58, 95, 23);
		panel_1.add(salida_RankingFIFA);
		salida_RankingFIFA.setFont(new Font("Tahoma", Font.BOLD, 14));

		salida_grupo = new JLabel("");
		salida_grupo.setBounds(215, 93, 95, 23);
		panel_1.add(salida_grupo);
		salida_grupo.setFont(new Font("Tahoma", Font.BOLD, 14));

		lblGrupo = new JLabel("Grupo:");
		lblGrupo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGrupo.setBounds(142, 92, 51, 24);
		panel_1.add(lblGrupo);
		lblGrupo.setHorizontalAlignment(SwingConstants.CENTER);

		lblResultadosUltimos = new JLabel("RESULTADOS ULTIMOS 3 ENCUENTROS");
		lblResultadosUltimos.setForeground(new Color(0, 139, 139));
		lblResultadosUltimos.setBounds(92, 173, 317, 23);
		panel_1.add(lblResultadosUltimos);
		lblResultadosUltimos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResultadosUltimos.setHorizontalAlignment(SwingConstants.CENTER);

		lblPrimerPartido = new JLabel("Antepenúltimo Partido:");
		lblPrimerPartido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrimerPartido.setBounds(77, 208, 132, 23);
		panel_1.add(lblPrimerPartido);
		lblPrimerPartido.setHorizontalAlignment(SwingConstants.CENTER);

		salida_antepenultimo = new JLabel("");
		salida_antepenultimo.setBounds(240, 208, 95, 23);
		panel_1.add(salida_antepenultimo);
		salida_antepenultimo.setFont(new Font("Tahoma", Font.BOLD, 14));

		lblSegundoPartido = new JLabel("Penúltimo Partido:");
		lblSegundoPartido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSegundoPartido.setBounds(104, 242, 106, 23);
		panel_1.add(lblSegundoPartido);
		lblSegundoPartido.setHorizontalAlignment(SwingConstants.CENTER);

		salida_penultimo = new JLabel("");
		salida_penultimo.setBounds(239, 242, 95, 23);
		panel_1.add(salida_penultimo);
		salida_penultimo.setFont(new Font("Tahoma", Font.BOLD, 14));

		lblTercero = new JLabel("Último Partido:");
		lblTercero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTercero.setBounds(114, 276, 95, 23);
		panel_1.add(lblTercero);
		lblTercero.setHorizontalAlignment(SwingConstants.CENTER);

		salida_ultimo = new JLabel("");
		salida_ultimo.setBounds(239, 276, 95, 23);
		panel_1.add(salida_ultimo);
		salida_ultimo.setFont(new Font("Tahoma", Font.BOLD, 14));

		lblNumeroDeCopas = new JLabel("Copas mundiales:");
		lblNumeroDeCopas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumeroDeCopas.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroDeCopas.setBounds(92, 127, 101, 24);
		panel_1.add(lblNumeroDeCopas);

		salida_copas = new JLabel("");
		salida_copas.setFont(new Font("Tahoma", Font.BOLD, 14));
		salida_copas.setBounds(215, 128, 95, 23);
		panel_1.add(salida_copas);

		panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(310, 69, 113, 73);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		lblBandera = new JLabel("");
		lblBandera.setBounds(6, 6, 101, 61);

		panel_2.add(lblBandera);

		listEquiposMundial = new JList();
		/** Leer archivo y cargar registros en la ventana */
		modeloLista = new DefaultListModel();
		operaciones = new Operaciones();

		lista_equipos_archivo = operaciones.recuperarEquipos();
		for (int i = 0; i < lista_equipos_archivo.size(); i++) {
			modeloLista.addElement(lista_equipos_archivo.get(i));
		}

		listEquiposMundial.setModel(modeloLista);
		listEquiposMundial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				btnObtener.setEnabled(true);
				btnModificarValores.setEnabled(true);
				btnLimpiar.setEnabled(true);

				equipo = new Equipo();
				equipo = operaciones.seleccionarEquipo(
						listEquiposMundial.getSelectedIndex(),
						lista_equipos_archivo);

				salida_nombreEquipo.setText(equipo.getNombre());
				salida_RankingFIFA.setText(String.valueOf(equipo.getRanking()));
				salida_grupo.setText(String.valueOf(equipo.getGrupo()));
				salida_copas.setText(String.valueOf(equipo.getNumero_copas()));
				lblBandera.setIcon(new ImageIcon(VentanaPrincipal.class
						.getResource("/img/"
								+ (listEquiposMundial.getSelectedIndex() + 1)
								+ ".jpg")));

				// reemplazar valores numericos por texto
				if (equipo.getAntepenultimo_partido() == -1) {
					salida_antepenultimo.setText("Perdido");
				}
				if (equipo.getAntepenultimo_partido() == 0) {
					salida_antepenultimo.setText("Empatado");
				}
				if (equipo.getAntepenultimo_partido() == 1) {
					salida_antepenultimo.setText("Ganado");
				}
				if (equipo.getPenultimo_partido() == -1) {
					salida_penultimo.setText("Perdido");
				}
				if (equipo.getPenultimo_partido() == 0) {
					salida_penultimo.setText("Empatado");
				}
				if (equipo.getPenultimo_partido() == 1) {
					salida_penultimo.setText("Ganado");
				}
				if (equipo.getUltimo_partido() == -1) {
					salida_ultimo.setText("Perdido");
				}
				if (equipo.getUltimo_partido() == 0) {
					salida_ultimo.setText("Empatado");
				}
				if (equipo.getUltimo_partido() == 1) {
					salida_ultimo.setText("Ganado");
				}

			}
		});

		scrollPane.setViewportView(listEquiposMundial);
		listEquiposMundial.setValueIsAdjusting(true);
		listEquiposMundial.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null));

		btnModificarValores = new JButton("Modificar Valores");
		btnModificarValores.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificarValores.setBounds(131, 324, 221, 49);
		panel_1.add(btnModificarValores);

		btnModificarValores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setEnabled(false);

				VentanaEdicion frameEdicion = new VentanaEdicion();
				frameEdicion.setLocationRelativeTo(null);
				frameEdicion.setEquipo(equipo);
				frameEdicion.setIndice(listEquiposMundial.getSelectedIndex());
				frameEdicion.setListaEquiposMundial(lista_equipos_archivo);
				frameEdicion.setVisible(true);
				setVisible(false);
				setLocationRelativeTo(null);

			}
		});

		/**
		 * es el ultimo componente que se agrega a la vista
		 * 
		 */
		lblAlgoritmosGenticos = new JLabel("ALGORITMOS GENÉTICOS");
		lblAlgoritmosGenticos.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {

				// desabilitar botones iniciales
				btnObtener.setEnabled(false);
				btnModificarValores.setEnabled(false);
				btnLimpiar.setEnabled(false);

				if (indiceRespuesta != null) {
					/** Leer archivo y cargar registros en la ventana */
					modeloLista = new DefaultListModel();
					operaciones = new Operaciones();

					btnObtener.setEnabled(true);
					btnModificarValores.setEnabled(true);
					btnLimpiar.setEnabled(true);
					
					lista_equipos_archivo = operaciones.recuperarEquipos();
					for (int i = 0; i < lista_equipos_archivo.size(); i++) {
						modeloLista.addElement(lista_equipos_archivo.get(i));
					}
					listEquiposMundial.setModel(modeloLista);
					
					listEquiposMundial.setSelectedIndex(indiceRespuesta);
					
					equipo = new Equipo();
					equipo = operaciones.seleccionarEquipo(
							listEquiposMundial.getSelectedIndex(),
							lista_equipos_archivo);

					salida_nombreEquipo.setText(equipo.getNombre());
					salida_RankingFIFA.setText(String.valueOf(equipo.getRanking()));
					salida_grupo.setText(String.valueOf(equipo.getGrupo()));
					salida_copas.setText(String.valueOf(equipo.getNumero_copas()));
					lblBandera.setIcon(new ImageIcon(VentanaPrincipal.class
							.getResource("/img/"
									+ (listEquiposMundial.getSelectedIndex() + 1)
									+ ".jpg")));

					// reemplazar valores numericos por texto
					if (equipo.getAntepenultimo_partido() == -1) {
						salida_antepenultimo.setText("Perdido");
					}
					if (equipo.getAntepenultimo_partido() == 0) {
						salida_antepenultimo.setText("Empatado");
					}
					if (equipo.getAntepenultimo_partido() == 1) {
						salida_antepenultimo.setText("Ganado");
					}
					if (equipo.getPenultimo_partido() == -1) {
						salida_penultimo.setText("Perdido");
					}
					if (equipo.getPenultimo_partido() == 0) {
						salida_penultimo.setText("Empatado");
					}
					if (equipo.getPenultimo_partido() == 1) {
						salida_penultimo.setText("Ganado");
					}
					if (equipo.getUltimo_partido() == -1) {
						salida_ultimo.setText("Perdido");
					}
					if (equipo.getUltimo_partido() == 0) {
						salida_ultimo.setText("Empatado");
					}
					if (equipo.getUltimo_partido() == 1) {
						salida_ultimo.setText("Ganado");
					}
				
				}

			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});

		lblAlgoritmosGenticos.setBounds(358, 32, 291, 28);
		lblAlgoritmosGenticos.setForeground(new Color(0, 100, 0));
		lblAlgoritmosGenticos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlgoritmosGenticos.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblAlgoritmosGenticos);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(27, 507, 1004, 137);
		contentPane.add(scrollPane_1);

		txtAreaConsola = new JTextArea();
		txtAreaConsola.setEditable(false);
		txtAreaConsola.setForeground(Color.WHITE);
		txtAreaConsola.setBackground(Color.BLACK);
		scrollPane_1.setViewportView(txtAreaConsola);

		JLabel lblConsola = new JLabel("Consola:");
		lblConsola.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsola.setBounds(31, 478, 94, 28);
		contentPane.add(lblConsola);

		panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(754, 409, 277, 73);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		btnLimpiar = new JButton("Limpiar Campos");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lblBandera.setIcon(null);

				salida_nombreEquipo.setText("");
				salida_RankingFIFA.setText("");
				salida_grupo.setText("");
				salida_copas.setText("");
				salida_antepenultimo.setText("");
				salida_penultimo.setText("");
				salida_ultimo.setText("");
				txtEquipo1.setText("");
				txtEquipo2.setText("");
				txtEquipo3.setText("");
				txtEquipo4.setText("");
				txtAreaConsola.setText("");
				btnModificarValores.setEnabled(false);
				btnObtener.setEnabled(false);
				btnLimpiar.setEnabled(false);
			}
		});
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLimpiar.setBounds(71, 19, 144, 41);
		panel_3.add(btnLimpiar);
	}
}
