package org.example.poocarros;

import java.util.Comparator;

class ComparaPorPreco implements Comparator<Carro>{
    @Override
    public int compare(Carro c1, Carro c2) {
        if(c1 == null || c2 == null)
            System.out.println("Preço em branco");
        Double  preco1 = c1.getPreco();
        Double  preco2 = c2.getPreco();

        return  preco1.compareTo( preco2);
    }
}
