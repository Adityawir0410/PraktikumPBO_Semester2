package Laprak10;

public class PlayerData {
    private int no;
    private int tinggiTimA;
    private int beratTimA;
    private int tinggiTimB;
    private int beratTimB;

    public PlayerData(int no, int tinggiTimA, int beratTimA, int tinggiTimB, int beratTimB) {
        this.no = no;
        this.tinggiTimA = tinggiTimA;
        this.beratTimA = beratTimA;
        this.tinggiTimB = tinggiTimB;
        this.beratTimB = beratTimB;
    }

    public int getNo() {
        return no;
    }

    public int getTinggiTimA() {
        return tinggiTimA;
    }

    public int getBeratTimA() {
        return beratTimA;
    }

    public int getTinggiTimB() {
        return tinggiTimB;
    }

    public int getBeratTimB() {
        return beratTimB;
    }

    public static void main(String[] args) {
        PlayerData[] players = {
                new PlayerData(1, 168, 50, 170, 66),
                new PlayerData(2, 170, 60, 167, 60),
                new PlayerData(3, 165, 56, 165, 59),
                new PlayerData(4, 168, 55, 166, 58),
                new PlayerData(5, 172, 60, 168, 58),
                new PlayerData(6, 170, 70, 175, 71),
                new PlayerData(7, 169, 66, 172, 68),
                new PlayerData(8, 165, 56, 171, 68),
                new PlayerData(9, 167, 72, 168, 64),
                new PlayerData(10, 166, 56, 169, 60)
        };

        sortByHeightAscending(players);
        printPlayers(players);

        sortByHeightDescending(players);
        printPlayers(players);

        sortByWeightAscending(players);
        printPlayers(players);

        sortByWeightDescending(players);
        printPlayers(players);

        findMinMaxHeightWeight(players);

        PlayerData[] timC = copyTeamB(players);
        printPlayers(timC);

        int count168 = countPlayersWithHeight(players, 168, true);
        int count160 = countPlayersWithHeight(players, 160, true);
        System.out.println("Jumlah pemain Tim B dengan tinggi 168 cm: " + count168);
        System.out.println("Jumlah pemain Tim B dengan tinggi 160 cm: " + count160);

        int count56 = countPlayersWithWeight(players, 56, false);
        int count53 = countPlayersWithWeight(players, 53, false);
        System.out.println("Jumlah pemain Tim A dengan berat 56 kg: " + count56);
        System.out.println("Jumlah pemain Tim A dengan berat 53 kg: " + count53);

        boolean sameTinggi = checkSameHeight(players);
        boolean samaBerat = checkSameWeight(players);
        System.out.println("Apakah ada pemain di Tim A yang memiliki tinggi badan yang sama dengan pemain di Tim B? "
                + sameTinggi);
        System.out.println(
                "Apakah ada pemain di Tim A yang memiliki berat badan yang sama dengan pemain di Tim B? " + samaBerat);
    }

    private static void sortByHeightAscending(PlayerData[] players) {
        for (int i = 0; i < players.length - 1; i++) {
            for (int j = 0; j < players.length - i - 1; j++) {
                if (players[j].getTinggiTimA() > players[j + 1].getTinggiTimA()) {
                    swap(players, j, j + 1);
                } else if (players[j].getTinggiTimA() == players[j + 1].getTinggiTimA()
                        && players[j].getTinggiTimB() > players[j + 1].getTinggiTimB()) {
                    swap(players, j, j + 1);
                }
            }
        }
    }

    private static void sortByHeightDescending(PlayerData[] players) {
        for (int i = 0; i < players.length - 1; i++) {
            for (int j = 0; j < players.length - i - 1; j++) {
                if (players[j].getTinggiTimA() < players[j + 1].getTinggiTimA()) {
                    swap(players, j, j + 1);
                } else if (players[j].getTinggiTimA() == players[j + 1].getTinggiTimA()
                        && players[j].getTinggiTimB() < players[j + 1].getTinggiTimB()) {
                    swap(players, j, j + 1);
                }
            }
        }
    }

    private static void sortByWeightAscending(PlayerData[] players) {
        for (int i = 0; i < players.length - 1; i++) {
            for (int j = 0; j < players.length - i - 1; j++) {
                if (players[j].getBeratTimA() > players[j + 1].getBeratTimA()) {
                    swap(players, j, j + 1);
                } else if (players[j].getBeratTimA() == players[j + 1].getBeratTimA()
                        && players[j].getBeratTimB() > players[j + 1].getBeratTimB()) {
                    swap(players, j, j + 1);
                }
            }
        }
    }

    private static void sortByWeightDescending(PlayerData[] players) {
        for (int i = 0; i < players.length - 1; i++) {
            for (int j = 0; j < players.length - i - 1; j++) {
                if (players[j].getBeratTimA() < players[j + 1].getBeratTimA()) {
                    swap(players, j, j + 1);
                } else if (players[j].getBeratTimA() == players[j + 1].getBeratTimA()
                        && players[j].getBeratTimB() < players[j + 1].getBeratTimB()) {
                    swap(players, j, j + 1);
                }
            }
        }
    }

    private static void swap(PlayerData[] players, int i, int j) {
        PlayerData temp = players[i];
        players[i] = players[j];
        players[j] = temp;
    }

    private static void findMinMaxHeightWeight(PlayerData[] players) {
        int maxTinggiTimA = players[0].getTinggiTimA();
        int minTinggiTimA = players[0].getTinggiTimA();

        int maxBeratTimA = players[0].getBeratTimA();
        int minBeratTimA = players[0].getBeratTimA();
        int maxTinggiTimB = players[0].getTinggiTimB();
        int minTinggiTimB = players[0].getTinggiTimB();
        int maxBeratTimB = players[0].getBeratTimB();
        int minBeratTimB = players[0].getBeratTimB();

        for (PlayerData player : players) {
            if (player.getTinggiTimA() > maxTinggiTimA) {
                maxTinggiTimA = player.getTinggiTimA();
            }
            if (player.getTinggiTimA() < minTinggiTimA) {
                minTinggiTimA = player.getTinggiTimA();
            }
            if (player.getBeratTimA() > maxBeratTimA) {
                maxBeratTimA = player.getBeratTimA();
            }
            if (player.getBeratTimA() < minBeratTimA) {
                minBeratTimA = player.getBeratTimA();
            }
            if (player.getTinggiTimB() > maxTinggiTimB) {
                maxTinggiTimB = player.getTinggiTimB();
            }
            if (player.getTinggiTimB() < minTinggiTimB) {
                minTinggiTimB = player.getTinggiTimB();
            }
            if (player.getBeratTimB() > maxBeratTimB) {
                maxBeratTimB = player.getBeratTimB();
            }
            if (player.getBeratTimB() < minBeratTimB) {
                minBeratTimB = player.getBeratTimB();
            }
        }

        System.out.println("Maksimum tinggi badan Tim A: " + maxTinggiTimA);
        System.out.println("Minimum tinggi badan Tim A: " + minTinggiTimA);
        System.out.println("Maksimum berat badan Tim A: " + maxBeratTimA);
        System.out.println("Minimum berat badan Tim A: " + minBeratTimA);
        System.out.println("Maksimum tinggi badan Tim B: " + maxTinggiTimB);
        System.out.println("Minimum tinggi badan Tim B: " + minTinggiTimB);
        System.out.println("Maksimum berat badan Tim B: " + maxBeratTimB);
        System.out.println("Minimum berat badan Tim B: " + minBeratTimB);
    }

    private static PlayerData[] copyTeamB(PlayerData[] players) {
        PlayerData[] timC = new PlayerData[players.length];
        for (int i = 0; i < players.length; i++) {
            timC[i] = new PlayerData(0, 0, 0, players[i].getTinggiTimB(), players[i].getBeratTimB());
        }
        return timC;
    }

    private static int countPlayersWithHeight(PlayerData[] players, int height, boolean isTeamB) {
        int count = 0;
        for (PlayerData player : players) {
            if (isTeamB && player.getTinggiTimB() == height) {
                count++;
            } else if (!isTeamB && player.getTinggiTimA() == height) {
                count++;
            }
        }
        return count;
    }

    private static int countPlayersWithWeight(PlayerData[] players, int weight, boolean isTeamA) {
        int count = 0;
        for (PlayerData player : players) {
            if (isTeamA && player.getBeratTimA() == weight) {
                count++;
            } else if (!isTeamA && player.getBeratTimB() == weight) {
                count++;
            }
        }
        return count;
    }

    private static boolean checkSameHeight(PlayerData[] players) {
        for (PlayerData playerA : players) {
            for (PlayerData playerB : players) {
                if (playerA.getTinggiTimA() == playerB.getTinggiTimB()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkSameWeight(PlayerData[] players) {
        for (PlayerData playerA : players) {
            for (PlayerData playerB : players) {
                if (playerA.getBeratTimA() == playerB.getBeratTimB()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void printPlayers(PlayerData[] players) {
        System.out.println("No\tTim A\t\tTim B");
        System.out.println("\tTinggi\tBerat\tTinggi\tBerat");
        for (PlayerData player : players) {
            System.out.println(player.getNo() + "\t" + player.getTinggiTimA() + "\t" + player.getBeratTimA() + "\t"
                    + player.getTinggiTimB() + "\t" + player.getBeratTimB());
        }
        System.out.println();
    }
}