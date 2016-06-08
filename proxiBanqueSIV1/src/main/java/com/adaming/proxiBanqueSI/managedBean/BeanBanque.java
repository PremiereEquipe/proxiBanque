package com.adaming.proxiBanqueSI.managedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.adaming.beanManage.ManagedProperty;
import com.adaming.proxiBanqueSI.model.Client;
import com.adaming.proxiBanqueSI.service.IBanqueService;
import com.adaming.service.IVillesService;

@ManagedBean(name="beanBanque")
@RequestScoped
public class BeanBanque {

	private static final long SerialVersionUID = 1L;
	
	@Autowired
	private IBanqueService banqueService;
	
	public List<Client> getListeClients(){
		return banqueService.getAllClients();
	}
}
