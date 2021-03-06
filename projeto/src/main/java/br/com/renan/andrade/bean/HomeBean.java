package br.com.renan.andrade.bean;

import java.io.*;
import java.util.*;

import javax.annotation.*;
import javax.faces.bean.*;

import br.com.renan.andrade.domain.*;
import br.com.renan.andrade.util.*;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class HomeBean implements Serializable {
	
	public List<String> images;
	
	@PostConstruct
	public void initImgs() {
		images = new ArrayList<String>();
		for (int i = 1;i < 6; i++) {
	    	images.add(i+".png");
		}
		
	}
	
	public boolean isCliente() {
		Usuario user = SessionContext.getInstance().getUsuarioLogado();
		Cliente cliente = SessionContext.getInstance().getClienteSessao();
		return cliente != null && cliente.getUser().getCdUsuario().equals(user.getCdUsuario());
	}
	
	public boolean isUserLogado() {
		return SessionContext.getInstance().getUsuarioLogado() != null;
	}
	
	public boolean isUserFunc() {
		return SessionContext.getInstance().getUsuarioLogado() != null && SessionContext.getInstance().getClienteSessao() == null;
	}
	
	public String logout() {
		SessionContext.getInstance().encerrarSessao();
		return "/templates/home?faces-redirect=true";
	}
	
	public String getUserName() {
		return "Bem vindo " +SessionContext.getInstance().getUsuarioLogado().getDsLogin();
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}
	
	

}
