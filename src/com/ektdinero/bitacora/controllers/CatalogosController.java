package com.ektdinero.bitacora.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;

import com.ektdinero.bitacora.beans.CatalogosBean;
import com.ektdinero.bitacora.dao.ExternoDAO;
import com.ektdinero.bitacora.dao.UsuariosDAO;
import com.shq.entities.CatBancos;
import com.shq.entities.CatPaises;
import com.shq.entities.CatPaisesId;
import com.shq.entities.CatSepomex;
import com.shq.entities.CuentaBanco;
import com.shq.entities.Usuario;
import com.shq.entities.UsuarioRol;
import com.ektdinero.bitacora.table.datamodel.ProveedorDataModel;


@ManagedBean
@SessionScoped
public class CatalogosController implements Serializable{

	private static final long serialVersionUID = 8568309221535780646L;
	
	public List<CatPaises>getPaises(){
			return CatalogosBean.getInstance().getCatPais();
	}
	
	public List<CatSepomex>getEstados(){
		return CatalogosBean.getInstance().getCatEstados();
	}
	
	public CatSepomex getEstado(String est){
		est = est.replace("[", "").replace("]", "");
		return CatalogosBean.getInstance().getCatEstado(est);
	}
	
	public List<CatSepomex>getMunicipios(String estadoCod){
		estadoCod = estadoCod.replace("[", "").replace("]", "");
		return CatalogosBean.getInstance().getCatMunicipios(estadoCod);
	}
	
	public CatSepomex getMunicipio(String mun,String codEstado){
		mun = mun.replace("[", "").replace("]", "");
		codEstado = codEstado.replace("[", "").replace("]", "");
		return CatalogosBean.getInstance().getCatMunicipio(mun,codEstado);
	}
	
	public List<CatSepomex>getColonias(String estadoCod,String munCod){
		estadoCod = estadoCod.replace("[", "").replace("]", "");
		munCod = munCod.replace("[", "").replace("]", "");
		return CatalogosBean.getInstance().getCatColonias(estadoCod,munCod);
	}
	
	public CatSepomex getColonia(String idColonia,String codEstado,String codMun){
		idColonia = idColonia.replace("[", "").replace("]", "");
		codEstado = codEstado.replace("[", "").replace("]", "");
		codMun = codMun.replace("[", "").replace("]", "");
		return CatalogosBean.getInstance().getCatColonia(idColonia,codEstado,codMun);
	}
	
	public List<CatSepomex>getCP(String estadoCod,String munCod,String coloniaCod){
		estadoCod = estadoCod.replace("[", "").replace("]", "");
		munCod = munCod.replace("[", "").replace("]", "");
		coloniaCod = coloniaCod.replace("[", "").replace("]", "");
		return CatalogosBean.getInstance().getCP(estadoCod,munCod,coloniaCod);
	}
	
	public CatSepomex getUnicoCP(String estadoCod,String munCod,String coloniaCod){
		estadoCod = estadoCod.replace("[", "").replace("]", "");
		munCod = munCod.replace("[", "").replace("]", "");
		coloniaCod = coloniaCod.replace("[", "").replace("]", "");
		List<CatSepomex> cp = CatalogosBean.getInstance().getCP(estadoCod,munCod,coloniaCod);
		
		if( cp != null && cp.size()>0){
			return cp.get(0);
		}
		return null;
	}
	
	public List<CatBancos>getBancos(){
		return CatalogosBean.getInstance().getBancos();
	}
	
	
}
