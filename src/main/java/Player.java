public class Player {

    private Hero[] Team = new Hero[5];
    boolean[] HeroStatus = new boolean[5];

    public Player(int strength) {
        for(int i = 0; i < 5; i++) {
            HeroStatus[i] = true;
        }
    }

    public Hero getHero(int num) {
        return Team[num];
    }

    public boolean getStatus(int num) {
        return  HeroStatus[num];
    }

    public void setStatus(int num, boolean status) {
        HeroStatus[num] = status;
    }
}
