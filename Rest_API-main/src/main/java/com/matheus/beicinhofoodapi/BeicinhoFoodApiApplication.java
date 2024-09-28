package com.matheus.beicinhofoodapi;

import com.matheus.beicinhofoodapi.infrastructure.repository.CustomJpaRepositoryImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Scanner;
import java.util.TimeZone;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class BeicinhoFoodApiApplication {

    public static void main(String[] args) {

        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

        SpringApplication.run(BeicinhoFoodApiApplication.class, args);

//        Scanner sc = new Scanner(System.in);
//
//        double i,fact=1;
//        double number= sc.nextDouble();//It is the number to calculate factorial
//        for(i=1;i<=number;i++){
//            fact=fact*i;
//            System.out.println(fact);
//        }
//        System.out.printf("Factorial of "+number+" is: "+ "%.2f%n",fact);

//        System.out.println("insira um valor inteiro");
//        int valor = s.nextInt();
//        for(int i = valor-1; i >= 1; i--) {
//            valor += valor * i;
//        }
//        System.out.println(valor);



    }

}
