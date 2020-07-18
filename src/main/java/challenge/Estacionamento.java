package challenge;


import java.util.ArrayList;

import java.util.List;


public class Estacionamento {


    private int vagas = 10;

    private List<Carro> carrosEstacionados = new ArrayList<>();


    public void estacionar(Carro carro) {

        isValid(carro);

        if (!isLotado()) {

            carrosEstacionados.add(carro);

            vagas--;

        } else {

            verificaSePodeRetirarCarro(carro);

        }

    }


    public int carrosEstacionados() {

        return carrosEstacionados.size();

    }


    public boolean carroEstacionado(Carro carro) {

        return carrosEstacionados.contains(carro);

    }


    private void isValid(Carro carro) {

        if (carro.getMotorista() == null)

            throw new EstacionamentoException("Carro Autônomo");

    }


    private boolean isLotado() {

        if (vagas == 0)

            return true;

        return false;

    }


    private void verificaSePodeRetirarCarro(Carro carro) {

        int index = 0;


        if (carrosEstacionados.stream().allMatch(c -> c.getMotorista().getIdade() >= 55))

            throw new EstacionamentoException("Lotado!");


        while (index <= carrosEstacionados()) {

            if (carrosEstacionados.get(index).getMotorista().getIdade() < 55) {

                carrosEstacionados.remove(index);

                carrosEstacionados.add(carro);

                break;

            }

            index++;

        }

    }

}