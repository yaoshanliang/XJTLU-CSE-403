public class Lab {

    public static void main(String[] args) {
        String name1 = "shanliang";
        String name2 = "yao";
        String name = makeName(name1, name2);
        System.out.println(name);
    }

    public static String makeName(String name1, String name2) {
        return name1 + ' ' + name2;
    }

}