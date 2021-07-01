package controle.controleTelaEditar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import view.Editar;
import modelo.Fachada;
import modelo.VOs.Funcionario;

public class ControlePreencherTelaEditar {
	
	private Editar tela;
	private Fachada fachada;
	private Funcionario funcVO;
	
	public ControlePreencherTelaEditar(Editar tela, int id) {
		this.tela = tela;
		this.fachada = new Fachada();
		try {
			this.funcVO = fachada.getFuncionario(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.funcVO.idFunc = id;
		
		carregarFichaFuncional();
		carregarHistorico();
		carregarDependentes();
		
	}
	
	public void carregarFichaFuncional(){
		
		tela.getFichaFuncional().getTextField_nome().setText(funcVO.nome);
		tela.getFichaFuncional().getTextField_pai().setText(funcVO.nomePai);
		tela.getFichaFuncional().getTextField_mae().setText(funcVO.nomeMae);
		tela.getFichaFuncional().getTextField_nasc().setText(new SimpleDateFormat("dd/MM/yyyy").format(funcVO.dataNasc));
		tela.getFichaFuncional().getTextField_civil().setText(funcVO.estCivil);
		tela.getFichaFuncional().getTextField_pasep().setText(funcVO.pasep);
		tela.getFichaFuncional().getTextField_matr().setText(funcVO.matricula);
		tela.getFichaFuncional().getTextField_grau().setText(funcVO.grauDeInst);
		tela.getFichaFuncional().getTextField_cpf().setText(funcVO.cpf);
		
		String sexo = funcVO.sexo;
		
		if(sexo.equalsIgnoreCase("Masculino"))
			tela.getFichaFuncional().getRdbtnMasc().setSelected(true);
		else
			tela.getFichaFuncional().getRdbtnFem().setSelected(true);
		
		tela.getFichaFuncional().getTextField_cidade().setText(funcVO.naturalidade.getCidade());
		tela.getFichaFuncional().getComboBox().setSelectedItem(funcVO.naturalidade.getEstado());
		tela.getFichaFuncional().getTextField_bairro().setText(funcVO.endereco.getBairro());
		tela.getFichaFuncional().getTextField_rua().setText(funcVO.endereco.getRua());
		tela.getFichaFuncional().getTextField_numero().setText(funcVO.endereco.getNumero());
		tela.getFichaFuncional().getTextField_identNum().setText(funcVO.identidade.getNumero());
		tela.getFichaFuncional().getTextField_ssp().setText(funcVO.identidade.getSsp());
		tela.getFichaFuncional().getTextField_dataIdent().setText(new SimpleDateFormat("dd/MM/yyyy").format(funcVO.identidade.getData()));
		tela.getFichaFuncional().getTextField_numTitulo().setText(funcVO.titulo.getNumero());
		tela.getFichaFuncional().getTextField_zona().setText(funcVO.titulo.getZona());
		tela.getFichaFuncional().getTextField_secao().setText(funcVO.titulo.getSecao());
		
		if(funcVO.sexo.equalsIgnoreCase("Masculino")){	
			tela.getFichaFuncional().getTextField_situacaoMil().setText(funcVO.alistamento.getSituacaoMilitar());
			tela.getFichaFuncional().getTextField_serieMil().setText(funcVO.alistamento.getSerie());
			tela.getFichaFuncional().getTextField_esp().setText(funcVO.alistamento.getEsp());
		}
		
		tela.getFichaFuncional().getTextField_ctps().setText(funcVO.carteira.getCtpsNumero());
		tela.getFichaFuncional().getTextField_dataCtps().setText(new SimpleDateFormat("dd/MM/yyyy").format(funcVO.carteira.getData()));
		tela.getFichaFuncional().getTextField_serieCtps().setText(funcVO.carteira.getSerie());
		
		try {
			tela.getFichaFuncional().getTextField_nasc().commitEdit();
			tela.getFichaFuncional().getTextField_cpf().commitEdit();
			tela.getFichaFuncional().getTextField_dataIdent().commitEdit();
			tela.getFichaFuncional().getTextField_dataCtps().commitEdit();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		tela.getFichaFuncional().remove(tela.getFichaFuncional().getBtnSalvar());
		
		JButton alterar = new JButton("Alterar");
		alterar.setBounds(615, 384, 90, 28);
		alterar.addActionListener(new AlterarFichaFuncional(tela.getFichaFuncional(), this.funcVO.idFunc));
		tela.getFichaFuncional().add(alterar);
		
		
	}

	public void carregarHistorico(){
		
		adicionarComponentesHistorico();
		
		funcVO.historico = funcVO.getHistorico();
		
		for (int a = 0; a < funcVO.historico.size(); a++) {
			
			tela.getHistorico().getModelo_vidaFunc().addRow(
					
					new String[]{
							funcVO.historico.get(a).port, 
							""+new SimpleDateFormat("dd/MM/yyyy").format(funcVO.historico.get(a).dataNomeacao),
							""+new SimpleDateFormat("dd/MM/yyyy").format(funcVO.historico.get(a).dataExercicio),
							""+new SimpleDateFormat("dd/MM/yyyy").format(funcVO.historico.get(a).dataLicenca),
							""+new SimpleDateFormat("dd/MM/yyyy").format(funcVO.historico.get(a).dataAlteracao),
							funcVO.historico.get(a).cargo, 
							funcVO.historico.get(a).fs, funcVO.historico.get(a).p, funcVO.historico.get(a).secretaria,
							funcVO.historico.get(a).localizacao,
							funcVO.historico.get(a).observacao
					});
			
		}
		
		funcVO.licencas = funcVO.getLicencas();
		
		
		for (int b = 0; b < funcVO.licencas.size(); b++) {
			
			try {
				funcVO.licencas.get(b).tipo_Licenca.setNomeTipo(fachada.getTipoLicenca(funcVO.licencas.get(b)).getNomeTipo());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			tela.getHistorico().getModelo_Licenca().addRow(
					
					new String[]{
							""+new String(funcVO.licencas.get(b).tipo_Licenca.getNomeTipo()),
							""+new SimpleDateFormat("dd/MM/yyyy").format(funcVO.licencas.get(b).inicio),
							""+new SimpleDateFormat("dd/MM/yyyy").format(funcVO.licencas.get(b).termino),
							funcVO.licencas.get(b).portaria,
							funcVO.licencas.get(b).observ
			});
			
		}
		
		funcVO.ferias = funcVO.getFerias();
		
		for (int c = 0; c < funcVO.ferias.size(); c++) {
			
			tela.getHistorico().getModelo_Ferias().addRow(
					
					new String[]{
							funcVO.ferias.get(c).periodoAq,
							funcVO.ferias.get(c).periodoGozo,
							funcVO.ferias.get(c).portaria		
					});
			
		}
		
	}
	
	public void carregarDependentes(){
		
		tela.getDependentes().getbDeletar().removeActionListener(tela.getDependentes());
		tela.getDependentes().getbSalvar().removeActionListener(tela.getDependentes());
		tela.getDependentes().getbAdicionar().setBounds(408, 290, 100, 30);
		
		JButton btnEditarDep = new JButton("Editar");
		btnEditarDep.setBounds(513, 290, 100, 30);
		tela.add(btnEditarDep);
		btnEditarDep.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				if(tela.getDependentes().getTable().getSelectedRow() == -1) JOptionPane.showMessageDialog(tela, "Selecione uma linha.");
				else{
					
					tela.getDependentes().getTextField().setText((String)tela.getDependentes().getModelo().getValueAt(tela.getDependentes().getTable().getSelectedRow(), 1));
					tela.getDependentes().getTextField_1().setText((String)tela.getDependentes().getModelo().getValueAt(tela.getDependentes().getTable().getSelectedRow(), 2));
					tela.getDependentes().getTextField_2().setText((String)tela.getDependentes().getModelo().getValueAt(tela.getDependentes().getTable().getSelectedRow(), 3));
					tela.getDependentes().getTextField_3().setText((String)tela.getDependentes().getModelo().getValueAt(tela.getDependentes().getTable().getSelectedRow(), 4));
					tela.getDependentes().getTextField_4().setText((String)tela.getDependentes().getModelo().getValueAt(tela.getDependentes().getTable().getSelectedRow(), 5));
				
					tela.getDependentes().getModelo().removeRow(tela.getDependentes().getTable().getSelectedRow());
														   
					
					try {
						tela.getDependentes().getTextField_2().commitEdit();
						tela.getDependentes().getTextField_3().commitEdit();
						tela.getDependentes().getTextField_4().commitEdit();
						
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
		});
		tela.getDependentes().add(btnEditarDep);
		
		funcVO.dependentes = funcVO.getDependentes();
		
		for (int j = 0; j < funcVO.dependentes.size(); j++) {
			
			tela.getDependentes().getModelo().addRow(
					
					new String[]{
							""+(j+1),
							funcVO.dependentes.get(j).nome,
							funcVO.dependentes.get(j).parentesco,
							""+new SimpleDateFormat("dd/MM/yyyy").format(funcVO.dependentes.get(j).dataNasc),
							""+new SimpleDateFormat("dd/MM/yyyy").format(funcVO.dependentes.get(j).inicio),
							""+new SimpleDateFormat("dd/MM/yyyy").format(funcVO.dependentes.get(j).termino),
					});
			
		}
		
	}
	
	private void adicionarComponentesHistorico(){
		
		tela.getHistorico().getTextField_atoFunc().setEnabled(false);
		tela.getHistorico().getTextField_portLicen().setEnabled(false);
		tela.getHistorico().getTextField_portFerias().setEnabled(false);
		
		tela.getHistorico().remove(tela.getHistorico().getSalvar_1());
		tela.getHistorico().remove(tela.getHistorico().getSalvar_2());
		tela.getHistorico().remove(tela.getHistorico().getSalvar_3());
		//tela.getHistorico().getDeletar_1().removeActionListener(getHistorico());
		//tela.getHistorico().getDeletar_2().removeActionListener(getHistorico());
		//tela.getHistorico().getDeletar_3().removeActionListener(getHistorico());
		
		tela.getHistorico().getButtonAdd_1().setBounds(345, 190, 100, 30);
		tela.getHistorico().getButtonAdd_2().setBounds(345, 495, 100, 30);
		tela.getHistorico().getButtonAdd_3().setBounds(345, 730, 100, 30);
		
		JButton alterar_1 = new JButton("Alterar");
		alterar_1.setBounds(761, 70, 100, 30);
		alterar_1.addActionListener(new AlterarVidaFuncional(tela.getHistorico(), funcVO.idFunc));
		tela.getHistorico().add(alterar_1);
		
		JButton alterar_2 = new JButton("Alterar");
		alterar_2.setBounds(761, 391, 100, 30);
		alterar_2.addActionListener(new AlterarLicenca(tela.getHistorico()));
		tela.getHistorico().add(alterar_2);
		
		JButton alterar_3 = new JButton("Alterar");
		alterar_3.setBounds(761, 660, 100, 30);
		alterar_3.addActionListener(new AlterarFerias(tela.getHistorico()));
		tela.getHistorico().add(alterar_3);
		
		JButton btnEditar_1 = new JButton("<< Editar   ");
		btnEditar_1.setBounds(345, 225, 100, 30);
		tela.add(btnEditar_1);
		btnEditar_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				if(tela.getHistorico().getTable_vidaFunc().getSelectedRow() == -1) JOptionPane.showMessageDialog(tela, "Selecione uma linha.");
				else{
					tela.getHistorico().getTextField_atoFunc().setText((String) tela.getHistorico().getTable_vidaFunc().getValueAt(tela.getHistorico().getTable_vidaFunc().getSelectedRow(), 0));
					tela.getHistorico().getTextField_nom().setText((String) tela.getHistorico().getTable_vidaFunc().getValueAt(tela.getHistorico().getTable_vidaFunc().getSelectedRow(), 1));
					tela.getHistorico().getTextField_exer().setText((String) tela.getHistorico().getTable_vidaFunc().getValueAt(tela.getHistorico().getTable_vidaFunc().getSelectedRow(), 2));
					tela.getHistorico().getTextField_licen().setText((String) tela.getHistorico().getTable_vidaFunc().getValueAt(tela.getHistorico().getTable_vidaFunc().getSelectedRow(), 3));
					tela.getHistorico().getTextField_alt().setText((String) tela.getHistorico().getTable_vidaFunc().getValueAt(tela.getHistorico().getTable_vidaFunc().getSelectedRow(), 4));
					tela.getHistorico().getTextField_carg().setText((String) tela.getHistorico().getTable_vidaFunc().getValueAt(tela.getHistorico().getTable_vidaFunc().getSelectedRow(), 5));
					tela.getHistorico().getTextField_fs().setText((String) tela.getHistorico().getTable_vidaFunc().getValueAt(tela.getHistorico().getTable_vidaFunc().getSelectedRow(), 6));
					tela.getHistorico().getTextField_p().setText((String) tela.getHistorico().getTable_vidaFunc().getValueAt(tela.getHistorico().getTable_vidaFunc().getSelectedRow(), 7));
					tela.getHistorico().getTextArea_licen().setText((String) tela.getHistorico().getTable_vidaFunc().getValueAt(tela.getHistorico().getTable_vidaFunc().getSelectedRow(), 10));
				
					tela.getHistorico().getModelo_vidaFunc().removeRow(tela.getHistorico().getTable_vidaFunc().getSelectedRow());
					
					try {
						tela.getHistorico().getTextField_nom().commitEdit();
						tela.getHistorico().getTextField_exer().commitEdit();
						tela.getHistorico().getTextField_licen().commitEdit();
						tela.getHistorico().getTextField_alt().commitEdit();
						
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		tela.getHistorico().add(btnEditar_1);
		
		JButton btnEditar_2 = new JButton("<< Editar   ");
		btnEditar_2.setBounds(345, 530, 100, 30);
		tela.add(btnEditar_2);
		btnEditar_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			
				if(tela.getHistorico().getTable_licenca().getSelectedRow() == -1) JOptionPane.showMessageDialog(tela, "Selecione uma linha.");
				else{
					tela.getHistorico().getComboBox().setSelectedItem(tela.getHistorico().getModelo_Licenca().getValueAt(tela.getHistorico().getTable_licenca().getSelectedRow(), 0));
					tela.getHistorico().getTextField_inicio().setText((String) tela.getHistorico().getModelo_Licenca().getValueAt(tela.getHistorico().getTable_licenca().getSelectedRow(), 1));
					tela.getHistorico().getTextField_term().setText((String) tela.getHistorico().getModelo_Licenca().getValueAt(tela.getHistorico().getTable_licenca().getSelectedRow(), 2));
					tela.getHistorico().getTextField_portLicen().setText((String) tela.getHistorico().getModelo_Licenca().getValueAt(tela.getHistorico().getTable_licenca().getSelectedRow(), 3));
					tela.getHistorico().getTextArea_licen().setText((String) tela.getHistorico().getModelo_Licenca().getValueAt(tela.getHistorico().getTable_licenca().getSelectedRow(), 4));
					
					tela.getHistorico().getModelo_Licenca().removeRow(tela.getHistorico().getTable_licenca().getSelectedRow());
					
					try {
						tela.getHistorico().getTextField_inicio().commitEdit();
						tela.getHistorico().getTextField_term().commitEdit();
						
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		tela.getHistorico().add(btnEditar_2);
			
		JButton btnEditar_3 = new JButton("<< Editar   ");
		btnEditar_3.setBounds(345, 765, 100, 30);
		tela.add(btnEditar_3);
		btnEditar_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			
				if(tela.getHistorico().getTable_ferias().getSelectedRow() == -1) JOptionPane.showMessageDialog(tela, "Selecione uma linha.");
				else{
					tela.getHistorico().getTextField_pAq().setText((String)tela.getHistorico().getModelo_Ferias().getValueAt(tela.getHistorico().getTable_ferias().getSelectedRow(), 0));
					tela.getHistorico().getTextField_pGozo().setText((String)tela.getHistorico().getModelo_Ferias().getValueAt(tela.getHistorico().getTable_ferias().getSelectedRow(), 1));
					tela.getHistorico().getTextField_portFerias().setText((String)tela.getHistorico().getModelo_Ferias().getValueAt(tela.getHistorico().getTable_ferias().getSelectedRow(), 2));
					
					tela.getHistorico().getModelo_Ferias().removeRow(tela.getHistorico().getTable_ferias().getSelectedRow());
					
				}
			}
		});
		tela.getHistorico().add(btnEditar_3);
		
	}

}
