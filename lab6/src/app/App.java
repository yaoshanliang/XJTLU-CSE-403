package app;

public class App {
    private static App app = new App();
    private App() {
    }
    public static App createApp() {
        return app;
    }
    public static void main(String[] args) throws Exception {
        App a = createApp();
        App b = createApp();
        
        if (a == b) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }
}