package com.ektdinero.bitacora.beans;

import java.io.Serializable;
import java.util.List;

import com.ektdinero.bitacora.dao.BancosDAO;
import com.ektdinero.bitacora.dao.PaisesDAO;
import com.ektdinero.bitacora.dao.SepomexDAO;
import com.shq.entities.CatBancos;
import com.shq.entities.CatPaises;
import com.shq.entities.CatSepomex;



 public class CatalogosBean implements Serializable{

	private static final long serialVersionUID = 8568309221535780646L;

	

	private List<String> catRegimenFiscal;
	private List<CatPaises> catPais;
	private List<CatSepomex> catEstados;
	private List<CatBancos> catBancos;
	private static CatalogosBean singletonInstance;

	
	public static CatalogosBean getInstance(){
		return singletonInstance = singletonInstance == null?new CatalogosBean(): singletonInstance;
	}
	private CatalogosBean(){
		PaisesDAO paisesDAO = new PaisesDAO();
		SepomexDAO sepomexDAO = new SepomexDAO();
		BancosDAO bancosDAO = new BancosDAO();
		catPais = paisesDAO.getLista();
		catEstados = sepomexDAO.getEstados();
		catBancos = bancosDAO.getBancos();

	}
	
	
	public List<String> getCatRegimenFiscal() {
		return catRegimenFiscal;
	}
	
	public List<CatPaises> getCatPais() {
		return catPais;
	}

	public List<CatSepomex> getCatEstados() {
		return catEstados;
	}
	
	public CatSepomex getCatEstado(String codEstado) {
		SepomexDAO sepomexDAO = new SepomexDAO();
		return sepomexDAO.getEstado(codEstado);
	}
	
	public List<CatSepomex> getCatMunicipios(String codEstado) {
		SepomexDAO sepomexDAO = new SepomexDAO();
		return sepomexDAO.getMunicipios(codEstado);
	}
	
	public CatSepomex getCatMunicipio(String mun,String codEstado) {
		SepomexDAO sepomexDAO = new SepomexDAO();
		return sepomexDAO.getMunicipio(mun,codEstado);
	}
	
	public List<CatSepomex> getCatColonias(String codEstado, String codMun) {
		SepomexDAO sepomexDAO = new SepomexDAO();
		return sepomexDAO.getColonias(codEstado,codMun);
	}
	
	public CatSepomex getCatColonia(String idColonia,String codEstado,String codMun) {
		SepomexDAO sepomexDAO = new SepomexDAO();
		return sepomexDAO.getColonia(idColonia,codEstado,codMun);
	}
	
	public List<CatSepomex> getCP(String codEstado, String codMun,String codColonia) {
		SepomexDAO sepomexDAO = new SepomexDAO();
		return sepomexDAO.getCP(codEstado,codMun,codColonia);
	}
	
	

	public List<CatBancos> getBancos() {
		return catBancos;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	


 

	


	
}
