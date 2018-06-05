/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author HP
 */
@FacesValidator("ValidMark") 
public class CheckValidMark implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
       int val=(int) value;
        if((val>=2) && (val<=10)){
            
            
        }
        else{
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Некорректная оценка","Оценка должна быть от 2 до 10"));
        }
    }
    
}
