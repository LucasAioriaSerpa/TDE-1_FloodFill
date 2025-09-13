package algorithms;

import ImageInterpreter.ImagemHandler;
import ImageInterpreter.Pixel;

import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;

public class FloodFill {
    private final EstruturaDeDados estrutura;

    public FloodFill(EstruturaDeDados estrutura) {
        this.estrutura = estrutura;
    }

    public void colorir(ImagemHandler imgHangler, int startX, int starY, int newRed, int newGreen, int newBlue) {
        BufferedImage image = imgHangler.getImage();
        int width = image.getWidth();
        int height = image.getHeight();

        //? Pega a cor original do Pixel inicial
        int targetRGB = image.getRGB(startX, starY);

        int newRGB = (newRed << 16) | (newGreen << 8) | newBlue;

        //? Se a cor original for igual a nova cor, para
        if (targetRGB == newRGB) {
            return;
        }

        //? Controla os Pixels que já foram visitados
        Set<String> pixelsVisitados = new HashSet<>();

        estrutura.adicionar(new Pixel(startX, starY, newRed, newGreen, newBlue));

        while (!estrutura.estaVazia()) {
            //? Remove o próximo Pixel
            Pixel atual = estrutura.remover();
            int x = atual.getPosition().get("X");
            int y = atual.getPosition().get("Y");

            //? Cria uma chave única para cada Pixel
            String chave = x + "," + y;

            //? Verifica se o Pixel ainda não foi visitado, se está dentro dos limites da imagem e se a cor dele é igual a cor original
            if (!pixelsVisitados.contains(chave) &&
                    x >= 0 && x < width &&
                    y >= 0 && y < height &&
                    image.getRGB(x, y) == targetRGB) {

                pixelsVisitados.add(chave);
                image.setRGB(x, y, newRGB);

                //? Adiciona os 4 vizinhos (cima, baixo, esquerda, direita) na estrutura dessa forma, eles serão analizados depois no loop
                estrutura.adicionar(new Pixel(x + 1, y, newRed, newGreen, newBlue));
                estrutura.adicionar(new Pixel(x - 1, y, newRed, newGreen, newBlue));
                estrutura.adicionar(new Pixel(x, y + 1, newRed, newGreen, newBlue));
                estrutura.adicionar(new Pixel(x, y - 1, newRed, newGreen, newBlue));
            }
        }

    }
}
