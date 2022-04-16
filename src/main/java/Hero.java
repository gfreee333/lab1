public class Hero {

    private final int strength;
    private final int agility;
    private final int intelligence;

    public Hero() { // TODO генерация случайных чисел работает нормально.
        strength = (int) (Math.random()*10) + 1;
        agility = (int) (Math.random()*10) + 1;
        intelligence = (int) (Math.random()*10) + 1;
    }

    public Hero(int strength, int agility, int intelligence) {

        if(!characteristicIsOK(strength, agility, intelligence))
            System.out.println("ERROR");
           //TODO throw new OverloadedCharacteristicException();  добавь тоже исключение из своей лабы

        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    private boolean characteristicIsOK(int strength, int agility, int intelligence) {
        if (strength > 0 && strength <= 10 && agility > 0 && agility <= 10 && intelligence > 0 && intelligence <= 10)
            return true;
        else
            return false;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }
}

