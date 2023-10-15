package br.com.daniellima.todolist.utils;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class Utils {

    public static void copyNonNullProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }

    // Pegar todas as propriedades nulas e vai abribuir para dentro do
    // copyProperties para obter as mesclas das informações
    public static String[] getNullPropertyNames(Object source) {
        // BeanWrapper interface para acessar as propriedades de um objeto.
        // BeanWrapperImpl implementação dessa propriedade
        final BeanWrapper src = new BeanWrapperImpl(source);

        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();

        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());

            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }

        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
