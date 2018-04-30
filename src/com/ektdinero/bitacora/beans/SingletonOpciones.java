package com.ektdinero.bitacora.beans;

import java.util.ArrayList;

public class SingletonOpciones {

	private ArrayList<String> listaProblemas = new ArrayList<String>();
	private ArrayList<String> listaRol = new ArrayList<String>();
	private static SingletonOpciones singletonInstance;
	
	public static SingletonOpciones getInstance(){
		
		return singletonInstance = singletonInstance == null?new SingletonOpciones(): singletonInstance;
	}
	private SingletonOpciones (){
		listaProblemas.add("Configuración del servidor");
		listaProblemas.add("Instancia del balanceador");
		listaProblemas.add("Otro tipo de error");
		listaRol.add("Administrador");
		
	}
	public ArrayList<String> getListaProblemas() {
		return listaProblemas;
	}
	public void setListaProblemas(ArrayList<String> listaProblemas) {
		this.listaProblemas = listaProblemas;
	}
	public ArrayList<String> getListaRol() {
		return listaRol;
	}
	public void setListaRol(ArrayList<String> listaRol) {
		this.listaRol = listaRol;
	}
}
