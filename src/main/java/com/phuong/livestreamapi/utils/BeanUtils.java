package com.phuong.livestreamapi.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class BeanUtils {

    public <S, T> List<T> copyListToList(List<S> sources, Class<T> targetType) {
        List<T> targets = new ArrayList<>();

        for (S s : sources) {
            T t = org.springframework.beans.BeanUtils.instantiateClass(targetType);
            org.springframework.beans.BeanUtils.copyProperties(s, t);
            targets.add(t);
        }

        return targets;
    }

    public <S, T> T copyToObject(S sources, Class<T> targetType) {

        T t = org.springframework.beans.BeanUtils.instantiateClass(targetType);
        org.springframework.beans.BeanUtils.copyProperties(sources, t);

        return t;
    }

    public String objectToJsonString(Object object) {
        String returnVal = "";
        if (object != null) {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            try {
                returnVal = ow.writeValueAsString(object);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return returnVal;
    }

    public <T> List<T> convertToList(Set<T> set) {
        return new ArrayList<>(set);
    }

}