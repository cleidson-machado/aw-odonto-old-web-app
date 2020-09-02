package br.com.odontoclinic.controller.gestudo.cliente;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.odontoclinic.model.base.gestudo.Cliente;
import br.com.odontoclinic.stuff.gestudo.cliente.ClienteRN;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {
	
	private Cliente cliente;
	private List<Cliente> clientes;
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Cliente> getClientes() {
		ClienteRN clienteRN = new ClienteRN();
		if (clientes == null) {
			clientes = clienteRN.listagem();
		}
		return clientes;
	}
	
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	//METODOS PADRÃO
	@PostConstruct
	public void listar() {
		
		try {
			ClienteRN clienteRN = new ClienteRN();
			this.clientes = clienteRN.listagem();
			
		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao tentar Listar o Cliente" + erro);
			erro.printStackTrace();
		}
		
	}
	
	public void novo() {
		
		try {
			this.cliente = new Cliente();
			
			ClienteRN clienteRN = new ClienteRN();
			this.clientes = clienteRN.listagem();

		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao tentar Criar o Cliente" + erro);
			erro.printStackTrace();
		}
		
	}
	
	public void salvar() {
		
		try {
			ClienteRN clienteRN = new ClienteRN();
			clienteRN.salvar(this.cliente);
			
			this.cliente = new Cliente();
			this.clientes = clienteRN.listagem();

		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao tentar Salvar o Cliente" + erro);
			erro.printStackTrace();
		}
		
	}
	
	public void excluir(ActionEvent evento) {
		
		try {
			this.cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");
			
			ClienteRN clienteRN = new ClienteRN();
			clienteRN.excluir(this.cliente);
			
			this.clientes = clienteRN.listagem();

		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao tentar Excluir o Cliente" + erro);
			erro.printStackTrace();
		}
		
	}
	
	//UTILIZADO APENAS NAS LIST COMO GATILHO!
	public void editar(ActionEvent evento) {
		this.cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");
	}
	
	//METODOS PERSONALIZADOS
	
	//UTILIZADO NAS DIALOGs
	public void salvarEditando() {
		try {
			ClienteRN clienteRN = new ClienteRN();
			clienteRN.editar(cliente);
			
			this.cliente = new Cliente();
			this.clientes = clienteRN.listagem();

		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao tentar Editar o Cliente" + erro);
			erro.printStackTrace();
		}
	}
}
