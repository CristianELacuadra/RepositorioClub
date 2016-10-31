/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ProyectoClub.Modelo.Persistencia.Dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.validation.ConstraintViolation;
import javax.validation.Path;

import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

@SuppressWarnings("serial")
public class BussinessException extends Exception {

    private Set<BussinessMessage> bussinessMessages = new TreeSet<>();

    public BussinessException(List<BussinessMessage> bussinessMessages) {
        this.bussinessMessages.addAll(bussinessMessages);
    }

    public BussinessException(BussinessMessage bussinessMessage) {
        this.bussinessMessages.add(bussinessMessage);
    }

    public BussinessException(Exception ex) {
        bussinessMessages.add(new BussinessMessage(null, ex.toString()));
    }

    @SuppressWarnings("rawtypes")
	public BussinessException(javax.validation.ConstraintViolationException cve) {
        for (ConstraintViolation constraintViolation : cve.getConstraintViolations()) {
            String fieldName;
            String message;

            fieldName = getCaptions(constraintViolation.getRootBeanClass(), constraintViolation.getPropertyPath());
            message = constraintViolation.getMessage();

            bussinessMessages.add(new BussinessMessage(fieldName, message));
        }
    }

    public BussinessException(org.hibernate.exception.ConstraintViolationException cve) {
        bussinessMessages.add(new BussinessMessage(null, cve.getLocalizedMessage()));
    }

    public Set<BussinessMessage> getBussinessMessages() {
        return bussinessMessages;
    }

    @SuppressWarnings("rawtypes")
	private String getCaptions(Class clazz, Path path) {
        StringBuilder sb = new StringBuilder();
        if (path != null) {
            Class currentClazz = clazz;
            for (Path.Node node : path) {
                ClassAndCaption clazzAndCaption = getSingleCaption(currentClazz, node.getName());
                if (clazzAndCaption.caption != null) {
                    if (sb.length() != 0) {
                        sb.append(".");
                    }
                    if (node.isInIterable()) {
                        if (node.getIndex() != null) {
                            sb.append(node.getIndex());
                            sb.append("º ");
                            sb.append(clazzAndCaption.caption);
                        } else if (node.getKey() != null) {
                            sb.append(clazzAndCaption.caption);
                            sb.append(" de ");
                            sb.append(node.getKey());
                        } else {
                            sb.append(clazzAndCaption.caption);
                        }
                    } else {
                        sb.append(clazzAndCaption.caption);
                    }
                } else {
                    sb.append("");
                }
                currentClazz = clazzAndCaption.clazz;
            }

            return sb.toString();

        } else {
            return null;
        }

    }

    @SuppressWarnings("rawtypes")
	private ClassAndCaption getSingleCaption(Class clazz, String fieldName) {
        ClassAndCaption clazzAndCaptionField;
        ClassAndCaption clazzAndCaptionMethod;

        if ((fieldName == null) || (fieldName.trim().equals(""))) {
            return new ClassAndCaption(clazz, null);
        }

        clazzAndCaptionField = getFieldCaption(clazz, fieldName);
        if ((clazzAndCaptionField != null) && (clazzAndCaptionField.caption != null)) {
            return clazzAndCaptionField;
        }

        clazzAndCaptionMethod = getMethodCaption(clazz, fieldName);
        if ((clazzAndCaptionMethod != null) && (clazzAndCaptionMethod.caption != null)) {
            return clazzAndCaptionMethod;
        }

        if (clazzAndCaptionField != null) {
            return new ClassAndCaption(clazzAndCaptionField.clazz, fieldName);
        } else if (clazzAndCaptionMethod != null) {
            return new ClassAndCaption(clazzAndCaptionMethod.clazz, fieldName);
        } else {
            return new ClassAndCaption(clazz, fieldName);
        }
    }

    @SuppressWarnings("rawtypes")
	private ClassAndCaption getFieldCaption(Class clazz, String fieldName) {
        Field field = ReflectionUtils.findField(clazz, fieldName);
        if (field == null) {
            return null;
        }

        Caption caption = field.getAnnotation(Caption.class);
        if (caption != null) {
            return new ClassAndCaption(field.getType(), caption.value());
        } else {
            return new ClassAndCaption(field.getType(), null);
        }
    }

    @SuppressWarnings("rawtypes")
	private ClassAndCaption getMethodCaption(Class clazz, String methodName) {
        String suffixMethodName = StringUtils.capitalize(methodName);
        Method method = ReflectionUtils.findMethod(clazz, "get" + suffixMethodName);
        if (method == null) {
            method = ReflectionUtils.findMethod(clazz, "is" + suffixMethodName);
            if (method == null) {
                return null;
            }
        }

        Caption caption = method.getAnnotation(Caption.class);
        if (caption != null) {
            return new ClassAndCaption(method.getReturnType(), caption.value());
        } else {
            return new ClassAndCaption(method.getReturnType(), null);
        }


    }

    private class ClassAndCaption {

        @SuppressWarnings("rawtypes")
		Class clazz;
        String caption;

        @SuppressWarnings("rawtypes")
		public ClassAndCaption(Class clazz, String caption) {
            this.clazz = clazz;
            this.caption = caption;
        }
    }
}
