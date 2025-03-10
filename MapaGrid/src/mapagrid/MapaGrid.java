package mapagrid;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MapaGrid {
    private static JButton[][] grid = new JButton[10][10]; // Matriz de botões
    private static int heroiX = 0; // Posição inicial do herói
    private static int heroiY = 0; // Posição inicial do herói

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mapa Grid");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(10, 10));

        // Adiciona os botões na matriz e no frame
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = new JButton();
                grid[i][j].setEnabled(false); // Botão inicialmente desabilitado
                frame.add(grid[i][j]);
            }
        }

        frame.setVisible(true);

        // Carregar a imagem do herói e redimensioná-la
        ImageIcon heroiIcon = new ImageIcon("src/mapagrid/heroi.png");
        Image img = heroiIcon.getImage(); // Obtém a imagem
        Image imgRedimensionada = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Redimensiona para 50x50

        // Define o ícone redimensionado no botão
        grid[heroiX][heroiY].setIcon(new ImageIcon(imgRedimensionada));
        grid[heroiX][heroiY].setEnabled(true); // Habilita o botão do herói

        // Adiciona KeyListener para capturar as teclas de direção
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
        switch (keyCode) {
               case KeyEvent.VK_LEFT -> // Setas para a esquerda
                   moverHeroi(-1, 0);  // Movimenta para a esquerda (diminuindo X)
               case KeyEvent.VK_RIGHT -> // Setas para a direita
                   moverHeroi(1, 0);   // Movimenta para a direita (aumentando X)
               case KeyEvent.VK_UP -> // Setas para cima
                    moverHeroi(0, -1);  // Movimenta para cima (diminuindo Y)
               case KeyEvent.VK_DOWN -> // Setas para baixo
                    moverHeroi(0, 1);   // Movimenta para baixo (aumentando Y)
}
            }
        });

        frame.setFocusable(true); // Torna o frame focado para capturar eventos de teclado
    }

    // Método para mover o herói
    private static void moverHeroi(int deltaX, int deltaY) {
        int novoX = heroiX + deltaX;
        int novoY = heroiY + deltaY;
        // Verifica se a nova posição está dentro dos limites do grid
        if (novoX >= 0 && novoX < 10 && novoY >= 0 && novoY < 10) {
            // Limpa a posição atual do herói
            grid[heroiX][heroiY].setIcon(null);
            // Atualiza a posição do herói
            heroiX = novoX;
            heroiY = novoY;
            // Redefine o ícone do herói na nova posição
            ImageIcon heroiIcon = new ImageIcon("src/mapagrid/heroi.png");
            Image img = heroiIcon.getImage(); // Obtém a imagem
            Image imgRedimensionada = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Redimensiona para 50x50
            grid[heroiX][heroiY].setIcon(new ImageIcon(imgRedimensionada));
        }
    }
}
