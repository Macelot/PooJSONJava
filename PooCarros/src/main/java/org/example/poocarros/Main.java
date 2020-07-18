package org.example.poocarros;

import org.json.simple.JSONArray;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args ){
        System.out.println("Inicio");

        Carro car;
        car = new Carro();

        ArrayList<Carro> carros;
        carros =  new ArrayList();

        try{
            JSONArray carrosArquivo;
            JSONParser parser = new JSONParser();
            InputStreamReader isr = new InputStreamReader(new FileInputStream("30Carros.json"),"UTF-8");
            carrosArquivo = (JSONArray) parser.parse(isr);
            System.out.println(carrosArquivo.size());
            for (Object o : carrosArquivo){
                JSONObject car_ = (JSONObject) o;
                String nome = car_.get("nome").toString();
                String marca = (String) car_.get("marca");
                Double preco = Double.parseDouble(car_.get("preco").toString().replace(",", ""));
                Integer portas = Integer.parseInt(car_.get("portas").toString());

                car= new Carro();
                car.setNome(nome);
                car.setMarca(marca);
                car.setPreco(preco);
                car.setPortas(portas);
                carros.add(car);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        car.print(carros);

        System.out.println("===================================NOME==========");

        ComparaPorNome cpn;
        cpn=new ComparaPorNome();
        Collections.sort(carros,cpn);

        car.print(carros);

        System.out.println("===================================PREÇO=========");
        ComparaPorPreco cpp;
        cpp=new ComparaPorPreco();
        Collections.sort(carros,cpp);

        car.print(carros);


    }
}
