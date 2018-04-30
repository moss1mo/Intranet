package com.shq.entities;
// Generated 10-feb-2018 22:29:04 by Hibernate Tools 5.2.3.Final


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name="usuario"
    ,catalog="shq"
    , uniqueConstraints = {@UniqueConstraint(columnNames="id_externo"), @UniqueConstraint(columnNames="id_empleado")} 
)
public class Usuario  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 2274115346507261777L;
	
	private BigDecimal idUsuario;
     private Empleado empleado;
     private Externo externo;
     private UsuarioRol usuarioRol;
     private String password;
     private String nombreUsuario;
     private boolean activo;

    public Usuario() {
    }

	
    public Usuario(BigDecimal idUsuario, String password, String nombreUsuario) {
        this.idUsuario = idUsuario;
        this.password = password;
        this.nombreUsuario = nombreUsuario;
    }
    public Usuario(BigDecimal idUsuario, Empleado empleado, Externo externo, UsuarioRol usuarioRol, String password, String nombreUsuario) {
       this.idUsuario = idUsuario;
       this.empleado = empleado;
       this.externo = externo;
       this.usuarioRol = usuarioRol;
       this.password = password;
       this.nombreUsuario = nombreUsuario;
    }
   
    @Id 
    @Column(name="id_usuario", unique=true, nullable=false, precision=50, scale=0)
    @GeneratedValue(strategy = GenerationType.AUTO) 
    public BigDecimal getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }


@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_empleado", unique=true)
    public Empleado getEmpleado() {
        return this.empleado;
    }
    
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_externo", unique=true)
    public Externo getExterno() {
        return this.externo;
    }
    
    public void setExterno(Externo externo) {
        this.externo = externo;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_rol")
    public UsuarioRol getUsuarioRol() {
        return this.usuarioRol;
    }
    
    public void setUsuarioRol(UsuarioRol usuarioRol) {
        this.usuarioRol = usuarioRol;
    }

    
    @Column(name="password", nullable=false, length=20)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="nombre_usuario", nullable=false, length=30)
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Column(name="activo", nullable=false)
	public boolean isActivo() {
		return activo;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}




}

