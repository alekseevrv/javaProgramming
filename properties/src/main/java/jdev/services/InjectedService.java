package jdev.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class InjectedService {

    @Value("${int.prop}")
    Integer intProp;

    @Value("${bool.prop}")
    Boolean boolProp;

    @PostConstruct
    public void init() {
        System.out.println("intProp = " + intProp);
        System.out.println("boolProp = " + boolProp);
    }

}
