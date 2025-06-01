package jogo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Bestiario implements ActionListener{
		Inimigos ini;
		InimigosDao iniDao = new InimigosDao();
	
		JFrame bestiario = new JFrame("Bestiario");
		JPanel painelBes = new JPanel(new GridLayout(6, 2));
		JPanel opições = new JPanel (new GridLayout(5, 3));
		JPanel salvos = new JPanel (new GridLayout(2, 1));
		JTextField txtnome = new JTextField("");
		JTextField txtvidaMaxima = new JTextField("");
		JTextField txtataque = new JTextField("");
		JTextField txtdefeza = new JTextField("");
		
		JButton salvar = new JButton ("Salvar monstro");
		JButton listar = new JButton ("Lista de monstros salvos");
		JButton alterar = new JButton ("Alterar monstro");
		JButton excluir = new JButton ("Excluir monstro");
		JButton buscar = new JButton ("Buscar monstro");
		
		JComboBox <String> feitos = new JComboBox <String> (new String[] {"-Nenhum-"}) ;
		
		
		void criarBestiario()
		{
			bestiario.setSize(400, 400);
			bestiario.setLocationRelativeTo(null);
			
			painelBes.setBorder(BorderFactory.createTitledBorder("Informações do Inimigo"));
			painelBes.add(new JLabel ("Nome do Inimigo:"));
			painelBes.add(txtnome);
		
			painelBes.add(new JLabel ("Vida Maxima do Inimigo: "));
			painelBes.add(txtvidaMaxima);
			
			painelBes.add(new JLabel ("Ataque do Inimigo: "));
			painelBes.add(txtataque);
			
			painelBes.add(new JLabel ("Defeza do Inimigo"));
			painelBes.add(txtdefeza);
			
			bestiario.add(painelBes, BorderLayout.NORTH);
			
			
			bestiario.add(salvos, BorderLayout.CENTER);
			salvos.add(salvar);
			salvos.add(feitos);
			salvar.addActionListener(this);
			salvos.add(buscar);
			buscar.addActionListener(this);
			
			opições.setBorder(BorderFactory.createTitledBorder("Opições"));
			bestiario.add(opições, BorderLayout.SOUTH);
			opições.add(alterar);
			alterar.addActionListener(this);
			opições.add(excluir);
			excluir.addActionListener(this);
			
			
			
			bestiario.setVisible(true);
		}
		
		void limpar()
		{
			txtnome.setText("");
			txtvidaMaxima.setText("");
			txtataque.setText("");
			txtdefeza.setText("");
			feitos.setSelectedIndex(0);
		}
		
	public static void main(String[] args) {
		Bestiario best = new Bestiario();
		best.criarBestiario();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Salvar//
		if(e.getSource() == salvar)
		{
			boolean ok = true;
			String n = txtnome.getText();
			int v = 0;
			int a = 0;
			int d = 0;
			try {
			v = Integer.parseInt(txtvidaMaxima.getText());
			a = Integer.parseInt(txtataque.getText());
			d = Integer.parseInt(txtdefeza.getText());
			} catch (NumberFormatException e1)
			{
				ok = false;
			}
			if(n.isEmpty())
			{
				ok = false;
			}
				
			if(ok)
			{
				ini = new Inimigos(n, v, a, d);
				iniDao.salvar(ini);
				feitos.addItem(n);
				limpar();
				JOptionPane.showMessageDialog(null, "Monstro salvo !!!");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Digite os parametros primeiro");
			}
		}
		
		
		//Buscar
		if(e.getSource() == buscar)
		{
			int y = feitos.getSelectedIndex();
			
			if(y == 0)
			{
				JOptionPane.showMessageDialog(null, "Escolha um monstro primeiro");
			}
			else
			{
				ini = new Inimigos();
				ini = iniDao.buscar(y);
				
				txtnome.setText(ini.getNome());
				txtvidaMaxima.setText(String.valueOf(ini.getVidaMaxima()));
				txtataque.setText(String.valueOf(ini.getAtaque()));
				txtdefeza.setText(String.valueOf(ini.getDefesa()));
				
			}
		}
		
		//Alterar
		if(e.getSource() == alterar)
		{
			int y = feitos.getSelectedIndex();
			if(y == 0)
			{
				JOptionPane.showMessageDialog(null, "Escolha um monstro primeiro");
			}
			else
			{
				boolean ok = true;
				String n = txtnome.getText();
				int v = 0;
				int a = 0;
				int d = 0;
				try {
				v = Integer.parseInt(txtvidaMaxima.getText());
				a = Integer.parseInt(txtataque.getText());
				d = Integer.parseInt(txtdefeza.getText());
				} catch (NumberFormatException e1)
				{
					ok = false;
				}
				if(n.isEmpty())
				{
					ok = false;
				}
					
				if(ok)
				{
					ini = new Inimigos(n, v, a, d);
					iniDao.alterar(y, ini);
					feitos.removeItemAt(y);
					feitos.insertItemAt(n, y);
					
					limpar();
					JOptionPane.showMessageDialog(null, "Monstro alterado !!!");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Digite os parametros primeiro");
				}
			}
			
		}
		
	}
}
