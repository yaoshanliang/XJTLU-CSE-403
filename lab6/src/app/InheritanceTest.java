package app;

class BaseClass {
    int x = 1;
    int y = 2;
    int z = 3;
}

class SubClass extends BaseClass {
    int sumOfXYZ = 5;

    public static SubClass convertToSub(BaseClass o) {

        SubClass temp = new SubClass();
        temp.x = o.x;
        temp.y = o.y;
        temp.z = o.z;
        
        return temp;
    }
}

public class InheritanceTest {
    public static void main(String[] args) throws Exception {

        BaseClass[] bcs = { new BaseClass(), new BaseClass(), new SubClass() };
        SubClass[] scs = new SubClass[3];
        for (int i = 0; i < 3; i++) {
            scs[i] = SubClass.convertToSub(bcs[i]);
            System.out.println(scs[i].sumOfXYZ);
        }
    }
}