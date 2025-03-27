import java.awt.*;
import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;

public class GameBoard extends JFrame {
    private static final int SIZE = 8;
    private JPanel[][] squares = new JPanel[SIZE][SIZE];
    public String[][] piecesArray;

    public GameBoard() {
        setTitle("Retro Tile Game Board");
        setSize(750, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(SIZE, SIZE));

        // Initialize the 2D array of panels
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                squares[row][col] = new JPanel();
                if ((row + col) % 2 == 0) {
                    squares[row][col].setBackground(new Color(220, 220, 220));
                } else {
                    squares[row][col].setBackground(new Color(169, 169, 169));
                }
                add(squares[row][col]);
            }
        }

        // Initialize game pieces array
        piecesArray = new String[30][3];
        loadPieces();

        // Print the array contents (unsorted)
        for (int i = 0; i < piecesArray.length; i++) {
            for (int j = 0; j < piecesArray[i].length; j++) {
                System.out.println("piecesArray[" + i + "][" + j + "] = " + piecesArray[i][j]);
            }
        }

        // Sort the array based on board position
        sortPieces();

        // Place images onto the board
        populateBoard();
    }

    private void sortPieces() {
        Arrays.sort(piecesArray, new Comparator<String[]>() {
            public int compare(String[] a, String[] b) {
                return Integer.compare(Integer.parseInt(a[2]), Integer.parseInt(b[2]));
            }
        });
    }

    private void populateBoard() {
        int squareNumber = 1;
        int pieceIndex = 0;

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (pieceIndex < piecesArray.length && squareNumber == Integer.parseInt(piecesArray[pieceIndex][2])) {
                    String imagePath = piecesArray[pieceIndex][0];
                    String hpText = piecesArray[pieceIndex][1];

                    ImageIcon icon = new ImageIcon(imagePath);
                    Image scaledImage = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
                    JLabel hpLabel = new JLabel(hpText, SwingConstants.CENTER);
                    hpLabel.setForeground(Color.BLACK);

                    JPanel piecePanel = new JPanel(new BorderLayout());
                    piecePanel.setOpaque(false);
                    piecePanel.add(imageLabel, BorderLayout.CENTER);
                    piecePanel.add(hpLabel, BorderLayout.SOUTH);

                    squares[row][col].setLayout(new BorderLayout());
                    squares[row][col].add(piecePanel, BorderLayout.CENTER);

                    pieceIndex++;
                }
                squareNumber++;
            }
        }
    }

    private void loadPieces() {
        piecesArray[0] = new String[]{"tile1.png", "HP:100", "5"};
        piecesArray[1] = new String[]{"tile1.png", "HP:100", "9"};
        piecesArray[2] = new String[]{"tile1.png", "HP:100", "17"};
        piecesArray[3] = new String[]{"tile1.png", "HP:100", "18"};
        piecesArray[4] = new String[]{"tile1.png", "HP:100", "21"};
        piecesArray[5] = new String[]{"tile1.png", "HP:110", "29"};
        piecesArray[6] = new String[]{"tile2.png", "HP:110", "11"};
        piecesArray[7] = new String[]{"tile2.png", "HP:110", "28"};
        piecesArray[8] = new String[]{"tile2.png", "HP:110", "35"};
        piecesArray[9] = new String[]{"tile2.png", "HP:110", "37"};
        piecesArray[10] = new String[]{"tile3.png", "HP:120", "33"};
        piecesArray[11] = new String[]{"tile3.png", "HP:120", "42"};
        piecesArray[12] = new String[]{"tile3.png", "HP:120", "50"};
        piecesArray[13] = new String[]{"tile3.png", "HP:120", "52"};
        piecesArray[14] = new String[]{"tile3.png", "HP:120", "59"};
        piecesArray[15] = new String[]{"tile4.png", "HP:130", "14"};
        piecesArray[16] = new String[]{"tile4.png", "HP:130", "27"};
        piecesArray[17] = new String[]{"tile4.png", "HP:130", "43"};
        piecesArray[18] = new String[]{"tile4.png", "HP:130", "53"};
        piecesArray[19] = new String[]{"tile5.png", "HP:140", "10"};
        piecesArray[20] = new String[]{"tile5.png", "HP:140", "12"};
        piecesArray[21] = new String[]{"tile5.png", "HP:140", "19"};
        piecesArray[22] = new String[]{"tile5.png", "HP:140", "25"};
        piecesArray[23] = new String[]{"tile5.png", "HP:140", "31"};
        piecesArray[24] = new String[]{"tile5.png", "HP:140", "47"};
        piecesArray[25] = new String[]{"tile5.png", "HP:140", "55"};
        piecesArray[26] = new String[]{"tile6.png", "HP:150", "2"};
        piecesArray[27] = new String[]{"tile6.png", "HP:150", "7"};
        piecesArray[28] = new String[]{"tile6.png", "HP:150", "56"};
        piecesArray[29] = new String[]{"tile6.png", "HP:150", "64"};
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameBoard board = new GameBoard();
            board.setVisible(true);
        });
    }
}