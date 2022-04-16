public class Test {
    // todo тут тестировал класс hero get не вижу смысл тестировать, просто прогнал генератор все остальное работать должно

        public static int getRandomNumber()
        {
            return (int) (Math.random() * 10) + 1;
        }

    public static void main(String[] args) {
        for (int i = 0; i < 100 ; i++) {
            System.out.println(getRandomNumber());
        }
    }
}
