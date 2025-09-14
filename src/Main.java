import ImageInterpreter.ImagemHandler;
import algorithms.EstruturaDeDados;
import algorithms.FloodFill;
import algorithms.Pilha;
import utils.LoggingManager;
import viewer.Window;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static LoggingManager logger = new LoggingManager();
    public static void main(String[] args) {
        try {
            logger.logInfo(
                    "MAIN-100",
                    "INICIALIZANDO CRIAÇÃO DOS FRAMES"
            );
            ImagemHandler imagemHandler = new ImagemHandler("Sprite-0001.png");
            EstruturaDeDados estruturaDeDados = new Pilha();
            FloodFill floodFill = new FloodFill(estruturaDeDados);
            HashMap<String, Integer> pointer = new HashMap<>();
            pointer.put("x", 50);
            pointer.put("y", 15);
            pointer.put("red", 5);
            pointer.put("green", 5);
            pointer.put("blue", 5);
            floodFill.colorir(imagemHandler, pointer.get("x"), pointer.get("y"), pointer.get("red"), pointer.get("green"), pointer.get("blue"));
            Window window = new Window(
                    "FloodFill em pratica!",
                    800,
                    600,
                    imagemHandler,
                    floodFill.getFrameCounter(),
                    20
            );
            logger.logInfo(
                    "MAIN-200",
                    "Execução de exemplo FloodFill executada com sucesso!"
            );
        } catch (IllegalArgumentException e) {
            logger.logError("MAIN-404", "Parâmetros inválidos passados ao algoritmo FloodFill.", e);
        } catch (IndexOutOfBoundsException e) {
            logger.logError("MAIN-404", "Coordenadas iniciais fora dos limites da imagem.", e);
        } catch (IOException e) {
            logger.logError("MAIN-404", "Erro ao carregar ou salvar a imagem!", e);
        } catch (Exception e) {
            logger.logError("MAIN-404", "Erro inesperado durante a execução.", e);
        }
    }
    public static void creationFrames() {
        try {
            //? Inicializa a imagem
            String caminhoDaImagem = "Sprite-0001.png";
            logger.logInfo("MAIN-100","Carregando Imagem: " + caminhoDaImagem);

            ImagemHandler imagem = new ImagemHandler(caminhoDaImagem);

            //? Escolhe a estrutura de dados (Pilha ou Fila)
            EstruturaDeDados estrutura = new Pilha();
            logger.logInfo("MAIN-100","Estrutura escolhida: " + estrutura.getClass().getSimpleName());

            //? Inicializa o algoritmo
            FloodFill floodFill = new FloodFill(estrutura);

            //? Define o Pixel inicial e nova cor
            int startX = 50;
            int startY = 15;
            int newRed = 255;
            int newGreen = 0;
            int newBlue = 0;
            logger.logInfo("MAIN-100",
                    String.format("Aplicando FloodFill em (%d, %d) com cor RGB(%d,%d,%d)",
                            startX, startY, newRed, newGreen, newBlue)
            );

            floodFill.colorir(imagem, startX, startY, newRed, newGreen, newBlue);
            logger.logInfo("MAIN-200","Algoritmo FloodFill concluído com sucesso!");

            //? Cria a pasta de saída se não existir e salva a imagem
            String pastaDeSaida = "../TDE-1_FloodFill/output";
            File pastaSaida = new File(pastaDeSaida);
            if (!pastaSaida.exists()) {
                pastaSaida.mkdirs();
            }

            String nomeDoArquivoDeSaida = "Sprite-0001_floodfill.png";
            String caminhoCompletoSaida = pastaSaida.getAbsolutePath() + "/" + nomeDoArquivoDeSaida;

            ImageIO.write(imagem.getImage(), "png", new File(caminhoCompletoSaida));
            logger.logInfo("MAIN-200", "Imagem salva em: " + caminhoCompletoSaida);

        } catch (IllegalArgumentException e) {
            logger.logError("MAIN-404", "Parâmetros inválidos passados ao algoritmo FloodFill.", e);
        } catch (IndexOutOfBoundsException e) {
            logger.logError("MAIN-404", "Coordenadas iniciais fora dos limites da imagem.", e);
        } catch (IOException e) {
            logger.logError("MAIN-404", "Erro ao carregar ou salvar a imagem!", e);
        } catch (Exception e) {
            logger.logError("MAIN-404", "Erro inesperado durante a execução.", e);
        }
    }
}