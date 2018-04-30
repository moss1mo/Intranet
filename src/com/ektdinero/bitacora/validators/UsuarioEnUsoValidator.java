package com.ektdinero.bitacora.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import com.ektdinero.bitacora.dao.UsuariosDAO;

@FacesValidator("com.ektdinero.bitacora.validators.UsuarioEnUsoValidator")
public class UsuarioEnUsoValidator implements Validator {

	private UsuariosDAO usuariosDAO = new UsuariosDAO();
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object textInput)
			throws ValidatorException {
		if (usuariosDAO.validaExistenciaUsuario((String)textInput)) {
            throw new ValidatorException(new FacesMessage(""));
        }

		
	}

}
